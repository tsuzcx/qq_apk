package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public class MediaCodecVideoRenderer
  extends MediaCodecRenderer
{
  private static final String KEY_CROP_BOTTOM = "crop-bottom";
  private static final String KEY_CROP_LEFT = "crop-left";
  private static final String KEY_CROP_RIGHT = "crop-right";
  private static final String KEY_CROP_TOP = "crop-top";
  private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
  private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private static final String TAG = "MediaCodecVideoRenderer";
  private final long allowedJoiningTimeMs;
  private int buffersInCodecCount;
  private MediaCodecVideoRenderer.CodecMaxValues codecMaxValues;
  private boolean codecNeedsSetOutputSurfaceWorkaround;
  private int consecutiveDroppedFrameCount;
  private final Context context;
  private int currentHeight;
  private float currentPixelWidthHeightRatio;
  private int currentUnappliedRotationDegrees;
  private int currentWidth;
  private final boolean deviceNeedsAutoFrcWorkaround;
  private long droppedFrameAccumulationStartTimeMs;
  private int droppedFrames;
  private Surface dummySurface;
  private final VideoRendererEventListener.EventDispatcher eventDispatcher;
  private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
  private long joiningDeadlineMs;
  private long lastRenderTimeUs;
  private final int maxDroppedFramesToNotify;
  private long outputStreamOffsetUs;
  private int pendingOutputStreamOffsetCount;
  private final long[] pendingOutputStreamOffsetsUs;
  private float pendingPixelWidthHeightRatio;
  private int pendingRotationDegrees;
  private boolean renderedFirstFrame;
  private int reportedHeight;
  private float reportedPixelWidthHeightRatio;
  private int reportedUnappliedRotationDegrees;
  private int reportedWidth;
  private int scalingMode;
  private Format[] streamFormats;
  private Surface surface;
  private boolean tunneling;
  private int tunnelingAudioSessionId;
  MediaCodecVideoRenderer.OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
  
  public MediaCodecVideoRenderer(Context paramContext, MediaCodecSelector paramMediaCodecSelector)
  {
    this(paramContext, paramMediaCodecSelector, 0L);
  }
  
  public MediaCodecVideoRenderer(Context paramContext, MediaCodecSelector paramMediaCodecSelector, long paramLong)
  {
    this(paramContext, paramMediaCodecSelector, paramLong, null, null, -1);
  }
  
  public MediaCodecVideoRenderer(Context paramContext, MediaCodecSelector paramMediaCodecSelector, long paramLong, @Nullable Handler paramHandler, @Nullable VideoRendererEventListener paramVideoRendererEventListener, int paramInt)
  {
    this(paramContext, paramMediaCodecSelector, paramLong, null, false, paramHandler, paramVideoRendererEventListener, paramInt);
  }
  
  public MediaCodecVideoRenderer(Context paramContext, MediaCodecSelector paramMediaCodecSelector, long paramLong, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable VideoRendererEventListener paramVideoRendererEventListener, int paramInt)
  {
    super(2, paramMediaCodecSelector, paramDrmSessionManager, paramBoolean);
    this.allowedJoiningTimeMs = paramLong;
    this.maxDroppedFramesToNotify = paramInt;
    this.context = paramContext.getApplicationContext();
    this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(paramContext);
    this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(paramHandler, paramVideoRendererEventListener);
    this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
    this.pendingOutputStreamOffsetsUs = new long[10];
    this.outputStreamOffsetUs = -9223372036854775807L;
    this.joiningDeadlineMs = -9223372036854775807L;
    this.currentWidth = -1;
    this.currentHeight = -1;
    this.currentPixelWidthHeightRatio = -1.0F;
    this.pendingPixelWidthHeightRatio = -1.0F;
    this.scalingMode = 1;
    clearReportedVideoSize();
  }
  
  private static boolean areAdaptationCompatible(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return (paramFormat1.sampleMimeType.equals(paramFormat2.sampleMimeType)) && (getRotationDegrees(paramFormat1) == getRotationDegrees(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height)));
  }
  
  private void clearRenderedFirstFrame()
  {
    this.renderedFirstFrame = false;
    if ((Util.SDK_INT >= 23) && (this.tunneling))
    {
      MediaCodec localMediaCodec = getCodec();
      if (localMediaCodec != null) {
        this.tunnelingOnFrameRenderedListener = new MediaCodecVideoRenderer.OnFrameRenderedListenerV23(this, localMediaCodec, null);
      }
    }
  }
  
  private void clearReportedVideoSize()
  {
    this.reportedWidth = -1;
    this.reportedHeight = -1;
    this.reportedPixelWidthHeightRatio = -1.0F;
    this.reportedUnappliedRotationDegrees = -1;
  }
  
  private static boolean codecNeedsSetOutputSurfaceWorkaround(String paramString)
  {
    return (("deb".equals(Util.DEVICE)) || ("flo".equals(Util.DEVICE))) && (("OMX.qcom.video.decoder.avc".equals(paramString)) || ((("tcl_eu".equals(Util.DEVICE)) || ("SVP-DTV15".equals(Util.DEVICE)) || ("BRAVIA_ATV2".equals(Util.DEVICE)) || (Util.DEVICE.startsWith("panell_")) || ("F3311".equals(Util.DEVICE)) || ("M5c".equals(Util.DEVICE)) || ("A7010a48".equals(Util.DEVICE))) && (("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString)) || ((("ALE-L21".equals(Util.MODEL)) || ("CAM-L21".equals(Util.MODEL))) && ("OMX.k3.video.decoder.avc".equals(paramString))))));
  }
  
  @TargetApi(21)
  private static void configureTunnelingV21(MediaFormat paramMediaFormat, int paramInt)
  {
    paramMediaFormat.setFeatureEnabled("tunneled-playback", true);
    paramMediaFormat.setInteger("audio-session-id", paramInt);
  }
  
  private static boolean deviceNeedsAutoFrcWorkaround()
  {
    return (Util.SDK_INT <= 22) && ("foster".equals(Util.DEVICE)) && ("NVIDIA".equals(Util.MANUFACTURER));
  }
  
  private static Point getCodecMaxSize(MediaCodecInfo paramMediaCodecInfo, Format paramFormat)
  {
    int i = paramFormat.height;
    int j = paramFormat.width;
    int m = 0;
    if (i > j) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      j = paramFormat.height;
    } else {
      j = paramFormat.width;
    }
    int k;
    if (i != 0) {
      k = paramFormat.width;
    } else {
      k = paramFormat.height;
    }
    float f1 = k / j;
    int[] arrayOfInt = STANDARD_LONG_EDGE_VIDEO_PX;
    int i3 = arrayOfInt.length;
    while (m < i3)
    {
      int n = arrayOfInt[m];
      int i1 = (int)(n * f1);
      if (n <= j) {
        break;
      }
      if (i1 <= k) {
        return null;
      }
      if (Util.SDK_INT >= 21)
      {
        int i2;
        if (i != 0) {
          i2 = i1;
        } else {
          i2 = n;
        }
        if (i == 0) {
          n = i1;
        }
        Point localPoint = paramMediaCodecInfo.alignVideoSizeV21(i2, n);
        float f2 = paramFormat.frameRate;
        if (paramMediaCodecInfo.isVideoSizeAndRateSupportedV21(localPoint.x, localPoint.y, f2)) {
          return localPoint;
        }
      }
      else
      {
        n = Util.ceilDivide(n, 16) * 16;
        i1 = Util.ceilDivide(i1, 16) * 16;
        if (n * i1 <= MediaCodecUtil.maxH264DecodableFrameSize())
        {
          if (i != 0) {
            j = i1;
          } else {
            j = n;
          }
          if (i != 0) {
            i1 = n;
          }
          return new Point(j, i1);
        }
      }
      m += 1;
    }
    return null;
  }
  
  private static int getMaxInputSize(Format paramFormat)
  {
    if (paramFormat.maxInputSize != -1)
    {
      int k = paramFormat.initializationData.size();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((byte[])paramFormat.initializationData.get(i)).length;
        i += 1;
      }
      return paramFormat.maxInputSize + j;
    }
    return getMaxInputSize(paramFormat.sampleMimeType, paramFormat.width, paramFormat.height);
  }
  
  private static int getMaxInputSize(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1)
    {
      if (paramInt2 == -1) {
        return -1;
      }
      int i = paramString.hashCode();
      int j = 4;
      switch (i)
      {
      default: 
        break;
      case 1599127257: 
        if (paramString.equals("video/x-vnd.on2.vp9")) {
          i = 5;
        }
        break;
      case 1599127256: 
        if (paramString.equals("video/x-vnd.on2.vp8")) {
          i = 3;
        }
        break;
      case 1331836730: 
        if (paramString.equals("video/avc")) {
          i = 2;
        }
        break;
      case 1187890754: 
        if (paramString.equals("video/mp4v-es")) {
          i = 1;
        }
        break;
      case -1662541442: 
        if (paramString.equals("video/hevc")) {
          i = 4;
        }
        break;
      case -1664118616: 
        if (paramString.equals("video/3gpp")) {
          i = 0;
        }
        break;
      }
      i = -1;
      if ((i != 0) && (i != 1)) {
        if (i != 2)
        {
          if (i != 3)
          {
            if ((i != 4) && (i != 5)) {
              return -1;
            }
            paramInt2 = paramInt1 * paramInt2;
            paramInt1 = j;
            break label263;
          }
        }
        else
        {
          if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
            return -1;
          }
          paramInt1 = Util.ceilDivide(paramInt1, 16) * Util.ceilDivide(paramInt2, 16) * 16 * 16;
          break label257;
        }
      }
      paramInt1 *= paramInt2;
      label257:
      i = 2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      label263:
      return paramInt2 * 3 / (paramInt1 * 2);
    }
    return -1;
  }
  
  private static float getPixelWidthHeightRatio(Format paramFormat)
  {
    if (paramFormat.pixelWidthHeightRatio == -1.0F) {
      return 1.0F;
    }
    return paramFormat.pixelWidthHeightRatio;
  }
  
  private static int getRotationDegrees(Format paramFormat)
  {
    if (paramFormat.rotationDegrees == -1) {
      return 0;
    }
    return paramFormat.rotationDegrees;
  }
  
  private static boolean isBufferLate(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private static boolean isBufferVeryLate(long paramLong)
  {
    return paramLong < -500000L;
  }
  
  private void maybeNotifyDroppedFrames()
  {
    if (this.droppedFrames > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.droppedFrameAccumulationStartTimeMs;
      this.eventDispatcher.droppedFrames(this.droppedFrames, l1 - l2);
      this.droppedFrames = 0;
      this.droppedFrameAccumulationStartTimeMs = l1;
    }
  }
  
  private void maybeNotifyVideoSizeChanged()
  {
    if (((this.currentWidth != -1) || (this.currentHeight != -1)) && ((this.reportedWidth != this.currentWidth) || (this.reportedHeight != this.currentHeight) || (this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees) || (this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio)))
    {
      this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
      this.reportedWidth = this.currentWidth;
      this.reportedHeight = this.currentHeight;
      this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
      this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }
  }
  
  private void maybeRenotifyRenderedFirstFrame()
  {
    if (this.renderedFirstFrame) {
      this.eventDispatcher.renderedFirstFrame(this.surface);
    }
  }
  
  private void maybeRenotifyVideoSizeChanged()
  {
    if ((this.reportedWidth != -1) || (this.reportedHeight != -1)) {
      this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }
  }
  
  private void setJoiningDeadlineMs()
  {
    long l;
    if (this.allowedJoiningTimeMs > 0L) {
      l = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
    } else {
      l = -9223372036854775807L;
    }
    this.joiningDeadlineMs = l;
  }
  
  @TargetApi(23)
  private static void setOutputSurfaceV23(MediaCodec paramMediaCodec, Surface paramSurface)
  {
    paramMediaCodec.setOutputSurface(paramSurface);
  }
  
  private void setSurface(Surface paramSurface)
  {
    Surface localSurface = paramSurface;
    if (paramSurface == null)
    {
      localSurface = this.dummySurface;
      if (localSurface == null)
      {
        MediaCodecInfo localMediaCodecInfo = getCodecInfo();
        localSurface = paramSurface;
        if (localMediaCodecInfo != null)
        {
          localSurface = paramSurface;
          if (shouldUseDummySurface(localMediaCodecInfo))
          {
            this.dummySurface = DummySurface.newInstanceV17(this.context, localMediaCodecInfo.secure);
            localSurface = this.dummySurface;
          }
        }
      }
    }
    if (this.surface != localSurface)
    {
      this.surface = localSurface;
      int i = getState();
      if ((i == 1) || (i == 2))
      {
        paramSurface = getCodec();
        if ((Util.SDK_INT >= 23) && (paramSurface != null) && (localSurface != null) && (!this.codecNeedsSetOutputSurfaceWorkaround))
        {
          setOutputSurfaceV23(paramSurface, localSurface);
        }
        else
        {
          releaseCodec();
          maybeInitCodec();
        }
      }
      if ((localSurface != null) && (localSurface != this.dummySurface))
      {
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (i == 2) {
          setJoiningDeadlineMs();
        }
      }
      else
      {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
      }
    }
    else if ((localSurface != null) && (localSurface != this.dummySurface))
    {
      maybeRenotifyVideoSizeChanged();
      maybeRenotifyRenderedFirstFrame();
    }
  }
  
  private static void setVideoScalingMode(MediaCodec paramMediaCodec, int paramInt)
  {
    paramMediaCodec.setVideoScalingMode(paramInt);
  }
  
  private boolean shouldUseDummySurface(MediaCodecInfo paramMediaCodecInfo)
  {
    return (Util.SDK_INT >= 23) && (!this.tunneling) && (!codecNeedsSetOutputSurfaceWorkaround(paramMediaCodecInfo.name)) && ((!paramMediaCodecInfo.secure) || (DummySurface.isSecureSupported(this.context)));
  }
  
  protected boolean canReconfigureCodec(MediaCodec paramMediaCodec, boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return (areAdaptationCompatible(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.codecMaxValues.width) && (paramFormat2.height <= this.codecMaxValues.height) && (getMaxInputSize(paramFormat2) <= this.codecMaxValues.inputSize);
  }
  
  protected void configureCodec(MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    this.codecMaxValues = getCodecMaxValues(paramMediaCodecInfo, paramFormat, this.streamFormats);
    paramFormat = getMediaFormat(paramFormat, this.codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
    if (this.surface == null)
    {
      Assertions.checkState(shouldUseDummySurface(paramMediaCodecInfo));
      if (this.dummySurface == null) {
        this.dummySurface = DummySurface.newInstanceV17(this.context, paramMediaCodecInfo.secure);
      }
      this.surface = this.dummySurface;
    }
    paramMediaCodec.configure(paramFormat, this.surface, paramMediaCrypto, 0);
    if ((Util.SDK_INT >= 23) && (this.tunneling)) {
      this.tunnelingOnFrameRenderedListener = new MediaCodecVideoRenderer.OnFrameRenderedListenerV23(this, paramMediaCodec, null);
    }
  }
  
  protected void dropOutputBuffer(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    TraceUtil.beginSection("dropVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    TraceUtil.endSection();
    updateDroppedBufferCounters(1);
  }
  
  @CallSuper
  protected void flushCodec()
  {
    super.flushCodec();
    this.buffersInCodecCount = 0;
  }
  
  protected MediaCodecVideoRenderer.CodecMaxValues getCodecMaxValues(MediaCodecInfo paramMediaCodecInfo, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = getMaxInputSize(paramFormat);
    if (paramArrayOfFormat.length == 1) {
      return new MediaCodecVideoRenderer.CodecMaxValues(k, j, i);
    }
    int i5 = paramArrayOfFormat.length;
    int n = 0;
    int m = 0;
    while (m < i5)
    {
      Format localFormat = paramArrayOfFormat[m];
      int i4 = n;
      int i3 = k;
      i2 = j;
      i1 = i;
      if (areAdaptationCompatible(paramMediaCodecInfo.adaptive, paramFormat, localFormat))
      {
        if ((localFormat.width != -1) && (localFormat.height != -1)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        i4 = n | i1;
        i3 = Math.max(k, localFormat.width);
        i2 = Math.max(j, localFormat.height);
        i1 = Math.max(i, getMaxInputSize(localFormat));
      }
      m += 1;
      n = i4;
      k = i3;
      j = i2;
      i = i1;
    }
    int i2 = k;
    int i1 = j;
    m = i;
    if (n != 0)
    {
      paramArrayOfFormat = new StringBuilder();
      paramArrayOfFormat.append("Resolutions unknown. Codec max resolution: ");
      paramArrayOfFormat.append(k);
      paramArrayOfFormat.append("x");
      paramArrayOfFormat.append(j);
      Log.w("MediaCodecVideoRenderer", paramArrayOfFormat.toString());
      paramMediaCodecInfo = getCodecMaxSize(paramMediaCodecInfo, paramFormat);
      i2 = k;
      i1 = j;
      m = i;
      if (paramMediaCodecInfo != null)
      {
        i2 = Math.max(k, paramMediaCodecInfo.x);
        i1 = Math.max(j, paramMediaCodecInfo.y);
        m = Math.max(i, getMaxInputSize(paramFormat.sampleMimeType, i2, i1));
        paramMediaCodecInfo = new StringBuilder();
        paramMediaCodecInfo.append("Codec max resolution adjusted to: ");
        paramMediaCodecInfo.append(i2);
        paramMediaCodecInfo.append("x");
        paramMediaCodecInfo.append(i1);
        Log.w("MediaCodecVideoRenderer", paramMediaCodecInfo.toString());
      }
    }
    return new MediaCodecVideoRenderer.CodecMaxValues(i2, i1, m);
  }
  
  @SuppressLint({"InlinedApi"})
  protected MediaFormat getMediaFormat(Format paramFormat, MediaCodecVideoRenderer.CodecMaxValues paramCodecMaxValues, boolean paramBoolean, int paramInt)
  {
    paramFormat = getMediaFormatForPlayback(paramFormat);
    paramFormat.setInteger("max-width", paramCodecMaxValues.width);
    paramFormat.setInteger("max-height", paramCodecMaxValues.height);
    if (paramCodecMaxValues.inputSize != -1) {
      paramFormat.setInteger("max-input-size", paramCodecMaxValues.inputSize);
    }
    if (paramBoolean) {
      paramFormat.setInteger("auto-frc", 0);
    }
    if (paramInt != 0) {
      configureTunnelingV21(paramFormat, paramInt);
    }
    return paramFormat;
  }
  
  public void handleMessage(int paramInt, Object paramObject)
  {
    if (paramInt == 1)
    {
      setSurface((Surface)paramObject);
      return;
    }
    if (paramInt == 4)
    {
      this.scalingMode = ((Integer)paramObject).intValue();
      paramObject = getCodec();
      if (paramObject != null) {
        setVideoScalingMode(paramObject, this.scalingMode);
      }
    }
    else
    {
      super.handleMessage(paramInt, paramObject);
    }
  }
  
  public boolean isReady()
  {
    if (super.isReady()) {
      if (!this.renderedFirstFrame)
      {
        Surface localSurface = this.dummySurface;
        if (((localSurface == null) || (this.surface != localSurface)) && (getCodec() != null) && (!this.tunneling)) {}
      }
      else
      {
        this.joiningDeadlineMs = -9223372036854775807L;
        return true;
      }
    }
    if (this.joiningDeadlineMs == -9223372036854775807L) {
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
      return true;
    }
    this.joiningDeadlineMs = -9223372036854775807L;
    return false;
  }
  
  protected boolean maybeDropBuffersToKeyframe(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = skipSource(paramLong2);
    if (paramInt == 0) {
      return false;
    }
    paramMediaCodec = this.decoderCounters;
    paramMediaCodec.droppedToKeyframeCount += 1;
    updateDroppedBufferCounters(this.buffersInCodecCount + paramInt);
    flushCodec();
    return true;
  }
  
  void maybeNotifyRenderedFirstFrame()
  {
    if (!this.renderedFirstFrame)
    {
      TraceUtil.beginSection("RenderedFirstFrame");
      this.renderedFirstFrame = true;
      this.eventDispatcher.renderedFirstFrame(this.surface);
      TraceUtil.endSection();
    }
  }
  
  protected void onCodecInitialized(String paramString, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.decoderInitialized(paramString, paramLong1, paramLong2);
    this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(paramString);
  }
  
  protected void onDisabled()
  {
    this.currentWidth = -1;
    this.currentHeight = -1;
    this.currentPixelWidthHeightRatio = -1.0F;
    this.pendingPixelWidthHeightRatio = -1.0F;
    this.outputStreamOffsetUs = -9223372036854775807L;
    this.pendingOutputStreamOffsetCount = 0;
    clearReportedVideoSize();
    clearRenderedFirstFrame();
    this.frameReleaseTimeHelper.disable();
    this.tunnelingOnFrameRenderedListener = null;
    this.tunneling = false;
    try
    {
      super.onDisabled();
      return;
    }
    finally
    {
      this.decoderCounters.ensureUpdated();
      this.eventDispatcher.disabled(this.decoderCounters);
    }
  }
  
  protected void onEnabled(boolean paramBoolean)
  {
    super.onEnabled(paramBoolean);
    this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
    if (this.tunnelingAudioSessionId != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.tunneling = paramBoolean;
    this.eventDispatcher.enabled(this.decoderCounters);
    this.frameReleaseTimeHelper.enable();
  }
  
  protected void onInputFormatChanged(Format paramFormat)
  {
    super.onInputFormatChanged(paramFormat);
    this.eventDispatcher.inputFormatChanged(paramFormat);
    this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(paramFormat);
    this.pendingRotationDegrees = getRotationDegrees(paramFormat);
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
    } else {
      j = paramMediaFormat.getInteger("width");
    }
    this.currentWidth = j;
    if (i != 0) {
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
    } else {
      i = paramMediaFormat.getInteger("height");
    }
    this.currentHeight = i;
    this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
    if (Util.SDK_INT >= 21)
    {
      i = this.pendingRotationDegrees;
      if ((i == 90) || (i == 270))
      {
        i = this.currentWidth;
        this.currentWidth = this.currentHeight;
        this.currentHeight = i;
        this.currentPixelWidthHeightRatio = (1.0F / this.currentPixelWidthHeightRatio);
      }
    }
    else
    {
      this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
    }
    setVideoScalingMode(paramMediaCodec, this.scalingMode);
  }
  
  protected void onPositionReset(long paramLong, boolean paramBoolean)
  {
    super.onPositionReset(paramLong, paramBoolean);
    clearRenderedFirstFrame();
    this.consecutiveDroppedFrameCount = 0;
    int i = this.pendingOutputStreamOffsetCount;
    if (i != 0)
    {
      this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[(i - 1)];
      this.pendingOutputStreamOffsetCount = 0;
    }
    if (paramBoolean)
    {
      setJoiningDeadlineMs();
      return;
    }
    this.joiningDeadlineMs = -9223372036854775807L;
  }
  
  @CallSuper
  protected void onProcessedOutputBuffer(long paramLong)
  {
    this.buffersInCodecCount -= 1;
  }
  
  @CallSuper
  protected void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer)
  {
    this.buffersInCodecCount += 1;
    if ((Util.SDK_INT < 23) && (this.tunneling)) {
      maybeNotifyRenderedFirstFrame();
    }
  }
  
  protected void onStarted()
  {
    super.onStarted();
    this.droppedFrames = 0;
    this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
  }
  
  protected void onStopped()
  {
    this.joiningDeadlineMs = -9223372036854775807L;
    maybeNotifyDroppedFrames();
    super.onStopped();
  }
  
  protected void onStreamChanged(Format[] paramArrayOfFormat, long paramLong)
  {
    this.streamFormats = paramArrayOfFormat;
    if (this.outputStreamOffsetUs == -9223372036854775807L)
    {
      this.outputStreamOffsetUs = paramLong;
    }
    else
    {
      int i = this.pendingOutputStreamOffsetCount;
      if (i == this.pendingOutputStreamOffsetsUs.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Too many stream changes, so dropping offset: ");
        localStringBuilder.append(this.pendingOutputStreamOffsetsUs[(this.pendingOutputStreamOffsetCount - 1)]);
        Log.w("MediaCodecVideoRenderer", localStringBuilder.toString());
      }
      else
      {
        this.pendingOutputStreamOffsetCount = (i + 1);
      }
      this.pendingOutputStreamOffsetsUs[(this.pendingOutputStreamOffsetCount - 1)] = paramLong;
    }
    super.onStreamChanged(paramArrayOfFormat, paramLong);
  }
  
  protected boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    for (;;)
    {
      paramInt2 = this.pendingOutputStreamOffsetCount;
      if (paramInt2 == 0) {
        break;
      }
      paramByteBuffer = this.pendingOutputStreamOffsetsUs;
      if (paramLong3 < paramByteBuffer[0]) {
        break;
      }
      this.outputStreamOffsetUs = paramByteBuffer[0];
      this.pendingOutputStreamOffsetCount = (paramInt2 - 1);
      System.arraycopy(paramByteBuffer, 1, paramByteBuffer, 0, this.pendingOutputStreamOffsetCount);
    }
    long l1 = paramLong3 - this.outputStreamOffsetUs;
    if (paramBoolean)
    {
      skipOutputBuffer(paramMediaCodec, paramInt1, l1);
      return true;
    }
    long l2 = paramLong3 - paramLong1;
    if (this.surface == this.dummySurface)
    {
      if (isBufferLate(l2))
      {
        skipOutputBuffer(paramMediaCodec, paramInt1, l1);
        return true;
      }
      return false;
    }
    long l3 = SystemClock.elapsedRealtime() * 1000L;
    if (getState() == 2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((this.renderedFirstFrame) && ((paramInt2 == 0) || (!shouldForceRenderOutputBuffer(l2, l3 - this.lastRenderTimeUs))))
    {
      if (paramInt2 == 0) {
        return false;
      }
      long l4 = System.nanoTime();
      paramLong3 = this.frameReleaseTimeHelper.adjustReleaseTime(paramLong3, (l2 - (l3 - paramLong2)) * 1000L + l4);
      l2 = (paramLong3 - l4) / 1000L;
      if ((shouldDropBuffersToKeyframe(l2, paramLong2)) && (maybeDropBuffersToKeyframe(paramMediaCodec, paramInt1, l1, paramLong1))) {
        return false;
      }
      if (shouldDropOutputBuffer(l2, paramLong2))
      {
        dropOutputBuffer(paramMediaCodec, paramInt1, l1);
        return true;
      }
      if (Util.SDK_INT >= 21)
      {
        if (l2 < 50000L)
        {
          renderOutputBufferV21(paramMediaCodec, paramInt1, l1, paramLong3);
          return true;
        }
      }
      else if ((l2 < 30000L) && (l2 <= 11000L)) {}
    }
    try
    {
      Thread.sleep((l2 - 10000L) / 1000L);
    }
    catch (InterruptedException paramMediaCodec)
    {
      label342:
      break label342;
    }
    Thread.currentThread().interrupt();
    return false;
    renderOutputBuffer(paramMediaCodec, paramInt1, l1);
    return true;
    return false;
    if (Util.SDK_INT >= 21) {
      renderOutputBufferV21(paramMediaCodec, paramInt1, l1, System.nanoTime());
    } else {
      renderOutputBuffer(paramMediaCodec, paramInt1, l1);
    }
    return true;
  }
  
  @CallSuper
  protected void releaseCodec()
  {
    try
    {
      super.releaseCodec();
      Surface localSurface1;
      return;
    }
    finally
    {
      this.buffersInCodecCount = 0;
      Surface localSurface2 = this.dummySurface;
      if (localSurface2 != null)
      {
        if (this.surface == localSurface2) {
          this.surface = null;
        }
        this.dummySurface.release();
        this.dummySurface = null;
      }
    }
  }
  
  protected void renderOutputBuffer(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    maybeNotifyVideoSizeChanged();
    TraceUtil.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    TraceUtil.endSection();
    this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
    paramMediaCodec = this.decoderCounters;
    paramMediaCodec.renderedOutputBufferCount += 1;
    this.consecutiveDroppedFrameCount = 0;
    maybeNotifyRenderedFirstFrame();
  }
  
  @TargetApi(21)
  protected void renderOutputBufferV21(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
  {
    maybeNotifyVideoSizeChanged();
    TraceUtil.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong2);
    TraceUtil.endSection();
    this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
    paramMediaCodec = this.decoderCounters;
    paramMediaCodec.renderedOutputBufferCount += 1;
    this.consecutiveDroppedFrameCount = 0;
    maybeNotifyRenderedFirstFrame();
  }
  
  protected boolean shouldDropBuffersToKeyframe(long paramLong1, long paramLong2)
  {
    return isBufferVeryLate(paramLong1);
  }
  
  protected boolean shouldDropOutputBuffer(long paramLong1, long paramLong2)
  {
    return isBufferLate(paramLong1);
  }
  
  protected boolean shouldForceRenderOutputBuffer(long paramLong1, long paramLong2)
  {
    return (isBufferLate(paramLong1)) && (paramLong2 > 100000L);
  }
  
  protected boolean shouldInitCodec(MediaCodecInfo paramMediaCodecInfo)
  {
    return (this.surface != null) || (shouldUseDummySurface(paramMediaCodecInfo));
  }
  
  protected void skipOutputBuffer(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    TraceUtil.beginSection("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    TraceUtil.endSection();
    paramMediaCodec = this.decoderCounters;
    paramMediaCodec.skippedOutputBufferCount += 1;
  }
  
  protected int supportsFormat(MediaCodecSelector paramMediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, Format paramFormat)
  {
    String str = paramFormat.sampleMimeType;
    boolean bool1 = MimeTypes.isVideo(str);
    int j = 0;
    if (!bool1) {
      return 0;
    }
    DrmInitData localDrmInitData = paramFormat.drmInitData;
    int i;
    if (localDrmInitData != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= localDrmInitData.schemeDataCount) {
          break;
        }
        bool1 |= localDrmInitData.get(i).requiresSecureDecryption;
        i += 1;
      }
    }
    boolean bool2 = false;
    MediaCodecInfo localMediaCodecInfo = paramMediaCodecSelector.getDecoderInfo(str, bool2, false);
    if (localMediaCodecInfo == null)
    {
      if ((bool2) && (paramMediaCodecSelector.getDecoderInfo(str, false, false) != null)) {
        return 2;
      }
      return 1;
    }
    if (!supportsFormatDrm(paramDrmSessionManager, localDrmInitData)) {
      return 2;
    }
    bool2 = localMediaCodecInfo.isCodecSupported(paramFormat.codecs);
    bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramFormat.width > 0)
      {
        bool1 = bool2;
        if (paramFormat.height > 0) {
          if (Util.SDK_INT >= 21)
          {
            bool1 = localMediaCodecInfo.isVideoSizeAndRateSupportedV21(paramFormat.width, paramFormat.height, paramFormat.frameRate);
          }
          else
          {
            if (paramFormat.width * paramFormat.height <= MediaCodecUtil.maxH264DecodableFrameSize()) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            bool1 = bool2;
            if (!bool2)
            {
              paramMediaCodecSelector = new StringBuilder();
              paramMediaCodecSelector.append("FalseCheck [legacyFrameSize, ");
              paramMediaCodecSelector.append(paramFormat.width);
              paramMediaCodecSelector.append("x");
              paramMediaCodecSelector.append(paramFormat.height);
              paramMediaCodecSelector.append("] [");
              paramMediaCodecSelector.append(Util.DEVICE_DEBUG_INFO);
              paramMediaCodecSelector.append("]");
              Log.d("MediaCodecVideoRenderer", paramMediaCodecSelector.toString());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (localMediaCodecInfo.adaptive) {
      i = 16;
    } else {
      i = 8;
    }
    if (localMediaCodecInfo.tunneling) {
      j = 32;
    }
    int k;
    if (bool1) {
      k = 4;
    } else {
      k = 3;
    }
    return k | i | j;
  }
  
  protected void updateDroppedBufferCounters(int paramInt)
  {
    DecoderCounters localDecoderCounters = this.decoderCounters;
    localDecoderCounters.droppedBufferCount += paramInt;
    this.droppedFrames += paramInt;
    this.consecutiveDroppedFrameCount += paramInt;
    this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
    if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
      maybeNotifyDroppedFrames();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.MediaCodecVideoRenderer
 * JD-Core Version:    0.7.0.1
 */