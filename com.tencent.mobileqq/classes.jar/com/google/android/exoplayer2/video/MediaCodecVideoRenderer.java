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
    return ((!"deb".equals(Util.DEVICE)) && (!"flo".equals(Util.DEVICE))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (((!"tcl_eu".equals(Util.DEVICE)) && (!"SVP-DTV15".equals(Util.DEVICE)) && (!"BRAVIA_ATV2".equals(Util.DEVICE)) && (!Util.DEVICE.startsWith("panell_")) && (!"F3311".equals(Util.DEVICE)) && (!"M5c".equals(Util.DEVICE)) && (!"A7010a48".equals(Util.DEVICE))) || (("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString)) || ((("ALE-L21".equals(Util.MODEL)) || ("CAM-L21".equals(Util.MODEL))) && ("OMX.k3.video.decoder.avc".equals(paramString))))));
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
    int i;
    int j;
    label25:
    int k;
    label36:
    float f1;
    int[] arrayOfInt;
    int i3;
    int m;
    if (paramFormat.height > paramFormat.width)
    {
      i = 1;
      if (i == 0) {
        break label101;
      }
      j = paramFormat.height;
      if (i == 0) {
        break label110;
      }
      k = paramFormat.width;
      f1 = k / j;
      arrayOfInt = STANDARD_LONG_EDGE_VIDEO_PX;
      i3 = arrayOfInt.length;
      m = 0;
    }
    for (;;)
    {
      if (m >= i3) {
        break label276;
      }
      int i1 = arrayOfInt[m];
      int n = (int)(i1 * f1);
      if ((i1 <= j) || (n <= k))
      {
        return null;
        i = 0;
        break;
        label101:
        j = paramFormat.width;
        break label25;
        label110:
        k = paramFormat.height;
        break label36;
      }
      if (Util.SDK_INT >= 21)
      {
        int i2;
        if (i != 0)
        {
          i2 = n;
          if (i == 0) {
            break label185;
          }
        }
        for (;;)
        {
          Point localPoint = paramMediaCodecInfo.alignVideoSizeV21(i2, i1);
          float f2 = paramFormat.frameRate;
          if (!paramMediaCodecInfo.isVideoSizeAndRateSupportedV21(localPoint.x, localPoint.y, f2)) {
            break label267;
          }
          return localPoint;
          i2 = i1;
          break;
          label185:
          i1 = n;
        }
      }
      i1 = Util.ceilDivide(i1, 16) * 16;
      n = Util.ceilDivide(n, 16) * 16;
      if (i1 * n <= MediaCodecUtil.maxH264DecodableFrameSize())
      {
        if (i != 0)
        {
          j = n;
          if (i == 0) {
            break label260;
          }
        }
        for (;;)
        {
          return new Point(j, i1);
          j = i1;
          break;
          label260:
          i1 = n;
        }
      }
      label267:
      m += 1;
    }
    label276:
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
    int j = 2;
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      return -1;
    }
    label76:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return -1;
        if (!paramString.equals("video/3gpp")) {
          break label76;
        }
        i = 0;
        continue;
        if (!paramString.equals("video/mp4v-es")) {
          break label76;
        }
        i = 1;
        continue;
        if (!paramString.equals("video/avc")) {
          break label76;
        }
        i = 2;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break label76;
        }
        i = 3;
        continue;
        if (!paramString.equals("video/hevc")) {
          break label76;
        }
        i = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9")) {
          break label76;
        }
        i = 5;
      }
    }
    paramInt1 *= paramInt2;
    paramInt2 = j;
    for (;;)
    {
      return paramInt1 * 3 / (paramInt2 * 2);
      if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
        return -1;
      }
      paramInt1 = Util.ceilDivide(paramInt1, 16) * Util.ceilDivide(paramInt2, 16) * 16 * 16;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = 4;
    }
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
    if (this.allowedJoiningTimeMs > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;; l = -9223372036854775807L)
    {
      this.joiningDeadlineMs = l;
      return;
    }
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
      if (this.dummySurface != null) {
        localSurface = this.dummySurface;
      }
    }
    else
    {
      if (this.surface == localSurface) {
        break label177;
      }
      this.surface = localSurface;
      i = getState();
      if ((i == 1) || (i == 2))
      {
        paramSurface = getCodec();
        if ((Util.SDK_INT < 23) || (paramSurface == null) || (localSurface == null) || (this.codecNeedsSetOutputSurfaceWorkaround)) {
          break label157;
        }
        setOutputSurfaceV23(paramSurface, localSurface);
      }
      if ((localSurface == null) || (localSurface == this.dummySurface)) {
        break label168;
      }
      maybeRenotifyVideoSizeChanged();
      clearRenderedFirstFrame();
      if (i == 2) {
        setJoiningDeadlineMs();
      }
    }
    label157:
    label168:
    label177:
    while ((localSurface == null) || (localSurface == this.dummySurface))
    {
      for (;;)
      {
        int i;
        return;
        MediaCodecInfo localMediaCodecInfo = getCodecInfo();
        localSurface = paramSurface;
        if (localMediaCodecInfo == null) {
          break;
        }
        localSurface = paramSurface;
        if (!shouldUseDummySurface(localMediaCodecInfo)) {
          break;
        }
        this.dummySurface = DummySurface.newInstanceV17(this.context, localMediaCodecInfo.secure);
        localSurface = this.dummySurface;
        break;
        releaseCodec();
        maybeInitCodec();
      }
      clearReportedVideoSize();
      clearRenderedFirstFrame();
      return;
    }
    maybeRenotifyVideoSizeChanged();
    maybeRenotifyRenderedFirstFrame();
  }
  
  private static void setVideoScalingMode(MediaCodec paramMediaCodec, int paramInt)
  {
    paramMediaCodec.setVideoScalingMode(paramInt);
  }
  
  private boolean shouldUseDummySurface(MediaCodecInfo paramMediaCodecInfo)
  {
    return (Util.SDK_INT >= 23) && (!this.tunneling) && (!codecNeedsSetOutputSurfaceWorkaround(paramMediaCodecInfo.name)) && ((!paramMediaCodecInfo.secure) || (DummySurface.isSecureSupported(this.context)));
  }
  
  public boolean canReconfigureCodec(MediaCodec paramMediaCodec, boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return (areAdaptationCompatible(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.codecMaxValues.width) && (paramFormat2.height <= this.codecMaxValues.height) && (getMaxInputSize(paramFormat2) <= this.codecMaxValues.inputSize);
  }
  
  public void configureCodec(MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
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
  public void flushCodec()
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
    int i4 = paramArrayOfFormat.length;
    int n = 0;
    int m = 0;
    int i1;
    if (n < i4)
    {
      Format localFormat = paramArrayOfFormat[n];
      if (!areAdaptationCompatible(paramMediaCodecInfo.adaptive, paramFormat, localFormat)) {
        break label350;
      }
      if ((localFormat.width == -1) || (localFormat.height == -1))
      {
        i1 = 1;
        label95:
        i1 |= m;
        m = Math.max(k, localFormat.width);
        k = Math.max(j, localFormat.height);
        j = Math.max(i, getMaxInputSize(localFormat));
        i = i1;
      }
    }
    for (;;)
    {
      i1 = n + 1;
      n = m;
      m = i;
      i = j;
      j = k;
      k = n;
      n = i1;
      break;
      i1 = 0;
      break label95;
      int i2 = i;
      i1 = j;
      n = k;
      if (m != 0)
      {
        Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + k + "x" + j);
        paramMediaCodecInfo = getCodecMaxSize(paramMediaCodecInfo, paramFormat);
        i2 = i;
        i1 = j;
        n = k;
        if (paramMediaCodecInfo != null)
        {
          n = Math.max(k, paramMediaCodecInfo.x);
          i1 = Math.max(j, paramMediaCodecInfo.y);
          i2 = Math.max(i, getMaxInputSize(paramFormat.sampleMimeType, n, i1));
          Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + n + "x" + i1);
        }
      }
      return new MediaCodecVideoRenderer.CodecMaxValues(n, i1, i2);
      label350:
      i1 = i;
      i2 = j;
      int i3 = k;
      i = m;
      j = i1;
      k = i2;
      m = i3;
    }
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
    if (paramInt == 1) {
      setSurface((Surface)paramObject);
    }
    do
    {
      return;
      if (paramInt != 4) {
        break;
      }
      this.scalingMode = ((Integer)paramObject).intValue();
      paramObject = getCodec();
    } while (paramObject == null);
    setVideoScalingMode(paramObject, this.scalingMode);
    return;
    super.handleMessage(paramInt, paramObject);
  }
  
  public boolean isReady()
  {
    if ((super.isReady()) && ((this.renderedFirstFrame) || ((this.dummySurface != null) && (this.surface == this.dummySurface)) || (getCodec() == null) || (this.tunneling))) {
      this.joiningDeadlineMs = -9223372036854775807L;
    }
    do
    {
      return true;
      if (this.joiningDeadlineMs == -9223372036854775807L) {
        return false;
      }
    } while (SystemClock.elapsedRealtime() < this.joiningDeadlineMs);
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
    updateDroppedBufferCounters(paramInt + this.buffersInCodecCount);
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
  
  public void onCodecInitialized(String paramString, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.decoderInitialized(paramString, paramLong1, paramLong2);
    this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(paramString);
  }
  
  public void onDisabled()
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
  
  public void onEnabled(boolean paramBoolean)
  {
    super.onEnabled(paramBoolean);
    this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
    if (this.tunnelingAudioSessionId != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.tunneling = paramBoolean;
      this.eventDispatcher.enabled(this.decoderCounters);
      this.frameReleaseTimeHelper.enable();
      return;
    }
  }
  
  public void onInputFormatChanged(Format paramFormat)
  {
    super.onInputFormatChanged(paramFormat);
    this.eventDispatcher.inputFormatChanged(paramFormat);
    this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(paramFormat);
    this.pendingRotationDegrees = getRotationDegrees(paramFormat);
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0) {
        break label167;
      }
      j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
      label59:
      this.currentWidth = j;
      if (i == 0) {
        break label179;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label85:
      this.currentHeight = i;
      this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
      if (Util.SDK_INT < 21) {
        break label190;
      }
      if ((this.pendingRotationDegrees == 90) || (this.pendingRotationDegrees == 270))
      {
        i = this.currentWidth;
        this.currentWidth = this.currentHeight;
        this.currentHeight = i;
        this.currentPixelWidthHeightRatio = (1.0F / this.currentPixelWidthHeightRatio);
      }
    }
    for (;;)
    {
      setVideoScalingMode(paramMediaCodec, this.scalingMode);
      return;
      i = 0;
      break;
      label167:
      j = paramMediaFormat.getInteger("width");
      break label59;
      label179:
      i = paramMediaFormat.getInteger("height");
      break label85;
      label190:
      this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
    }
  }
  
  public void onPositionReset(long paramLong, boolean paramBoolean)
  {
    super.onPositionReset(paramLong, paramBoolean);
    clearRenderedFirstFrame();
    this.consecutiveDroppedFrameCount = 0;
    if (this.pendingOutputStreamOffsetCount != 0)
    {
      this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[(this.pendingOutputStreamOffsetCount - 1)];
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
  public void onProcessedOutputBuffer(long paramLong)
  {
    this.buffersInCodecCount -= 1;
  }
  
  @CallSuper
  public void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer)
  {
    this.buffersInCodecCount += 1;
    if ((Util.SDK_INT < 23) && (this.tunneling)) {
      maybeNotifyRenderedFirstFrame();
    }
  }
  
  public void onStarted()
  {
    super.onStarted();
    this.droppedFrames = 0;
    this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
  }
  
  public void onStopped()
  {
    this.joiningDeadlineMs = -9223372036854775807L;
    maybeNotifyDroppedFrames();
    super.onStopped();
  }
  
  public void onStreamChanged(Format[] paramArrayOfFormat, long paramLong)
  {
    this.streamFormats = paramArrayOfFormat;
    if (this.outputStreamOffsetUs == -9223372036854775807L)
    {
      this.outputStreamOffsetUs = paramLong;
      super.onStreamChanged(paramArrayOfFormat, paramLong);
      return;
    }
    if (this.pendingOutputStreamOffsetCount == this.pendingOutputStreamOffsetsUs.length) {
      Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[(this.pendingOutputStreamOffsetCount - 1)]);
    }
    for (;;)
    {
      this.pendingOutputStreamOffsetsUs[(this.pendingOutputStreamOffsetCount - 1)] = paramLong;
      break;
      this.pendingOutputStreamOffsetCount += 1;
    }
  }
  
  public boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    while ((this.pendingOutputStreamOffsetCount != 0) && (paramLong3 >= this.pendingOutputStreamOffsetsUs[0]))
    {
      this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[0];
      this.pendingOutputStreamOffsetCount -= 1;
      System.arraycopy(this.pendingOutputStreamOffsetsUs, 1, this.pendingOutputStreamOffsetsUs, 0, this.pendingOutputStreamOffsetCount);
    }
    long l1 = paramLong3 - this.outputStreamOffsetUs;
    if (paramBoolean)
    {
      skipOutputBuffer(paramMediaCodec, paramInt1, l1);
      return true;
    }
    long l3 = paramLong3 - paramLong1;
    if (this.surface == this.dummySurface)
    {
      if (isBufferLate(l3))
      {
        skipOutputBuffer(paramMediaCodec, paramInt1, l1);
        return true;
      }
      return false;
    }
    long l4 = 1000L * SystemClock.elapsedRealtime();
    if (getState() == 2)
    {
      paramInt2 = 1;
      if ((this.renderedFirstFrame) && ((paramInt2 == 0) || (!shouldForceRenderOutputBuffer(l3, l4 - this.lastRenderTimeUs)))) {
        break label214;
      }
      if (Util.SDK_INT < 21) {
        break label201;
      }
      renderOutputBufferV21(paramMediaCodec, paramInt1, l1, System.nanoTime());
    }
    for (;;)
    {
      return true;
      paramInt2 = 0;
      break;
      label201:
      renderOutputBuffer(paramMediaCodec, paramInt1, l1);
    }
    label214:
    if (paramInt2 == 0) {
      return false;
    }
    long l2 = System.nanoTime();
    paramLong3 = this.frameReleaseTimeHelper.adjustReleaseTime(paramLong3, (l3 - (l4 - paramLong2)) * 1000L + l2);
    l2 = (paramLong3 - l2) / 1000L;
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
    else if (l2 < 30000L)
    {
      if (l2 > 11000L) {}
      try
      {
        Thread.sleep((l2 - 10000L) / 1000L);
        renderOutputBuffer(paramMediaCodec, paramInt1, l1);
        return true;
      }
      catch (InterruptedException paramMediaCodec)
      {
        Thread.currentThread().interrupt();
        return false;
      }
    }
    return false;
  }
  
  @CallSuper
  public void releaseCodec()
  {
    try
    {
      super.releaseCodec();
      return;
    }
    finally
    {
      this.buffersInCodecCount = 0;
      if (this.dummySurface != null)
      {
        if (this.surface == this.dummySurface) {
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
  
  public boolean shouldInitCodec(MediaCodecInfo paramMediaCodecInfo)
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
  
  public int supportsFormat(MediaCodecSelector paramMediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, Format paramFormat)
  {
    int j = 0;
    String str = paramFormat.sampleMimeType;
    if (!MimeTypes.isVideo(str)) {
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
      if ((bool2) && (paramMediaCodecSelector.getDecoderInfo(str, false, false) != null)) {}
      for (i = 2;; i = 1) {
        return i;
      }
    }
    if (!supportsFormatDrm(paramDrmSessionManager, localDrmInitData)) {
      return 2;
    }
    bool2 = localMediaCodecInfo.isCodecSupported(paramFormat.codecs);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramFormat.width > 0)
      {
        bool1 = bool2;
        if (paramFormat.height > 0)
        {
          if (Util.SDK_INT < 21) {
            break label247;
          }
          bool1 = localMediaCodecInfo.isVideoSizeAndRateSupportedV21(paramFormat.width, paramFormat.height, paramFormat.frameRate);
        }
      }
    }
    if (localMediaCodecInfo.adaptive)
    {
      i = 16;
      label218:
      if (localMediaCodecInfo.tunneling) {
        j = 32;
      }
      if (!bool1) {
        break label354;
      }
    }
    label354:
    for (int k = 4;; k = 3)
    {
      return j | i | k;
      label247:
      if (paramFormat.width * paramFormat.height <= MediaCodecUtil.maxH264DecodableFrameSize()) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (bool2) {
          break;
        }
        Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + paramFormat.width + "x" + paramFormat.height + "] [" + Util.DEVICE_DEBUG_INFO + "]");
        bool1 = bool2;
        break;
      }
      i = 8;
      break label218;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.MediaCodecVideoRenderer
 * JD-Core Version:    0.7.0.1
 */