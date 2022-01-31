package com.google.android.exoplayer2.ext.hevc;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher;

public final class LibHevcVideoRenderer
  extends BaseRenderer
{
  private static final int INITIAL_INPUT_BUFFER_SIZE = 786432;
  public static final int MSG_SET_OUTPUT_BUFFER_RENDERER = 10000;
  private static final int NUM_INPUT_BUFFERS = 8;
  private static final int NUM_OUTPUT_BUFFERS = 8;
  private static final int REINITIALIZATION_STATE_NONE = 0;
  private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
  private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
  public static final String TAG = "LibHevcVideoRenderer";
  private final long allowedJoiningTimeMs;
  private Bitmap bitmap;
  private int buffersInCodecCount;
  private int consecutiveDroppedFrameCount;
  private HevcDecoder decoder;
  protected DecoderCounters decoderCounters;
  private String decoderInfo;
  private boolean decoderReceivedBuffers;
  private int decoderReinitializationState;
  private DrmSession<ExoMediaCrypto> drmSession;
  private final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
  private long droppedFrameAccumulationStartTimeMs;
  private int droppedFrames;
  private final VideoRendererEventListener.EventDispatcher eventDispatcher;
  private final DecoderInputBuffer flagsOnlyBuffer;
  private Format format;
  private final FormatHolder formatHolder;
  private HevcInputBuffer inputBuffer;
  private boolean inputStreamEnded;
  private long joiningDeadlineMs;
  private long lastRenderTimeUs;
  private final int maxDroppedFramesToNotify;
  private HevcOutputBuffer outputBuffer;
  private HevcOutputBufferRenderer outputBufferRenderer;
  private int outputMode;
  private boolean outputStreamEnded;
  private DrmSession<ExoMediaCrypto> pendingDrmSession;
  private final boolean playClearSamplesWithoutKeys;
  private boolean renderedFirstFrame;
  private int reportedHeight;
  private int reportedWidth;
  private final boolean scaleToFit;
  private Surface surface;
  private boolean waitingForKeys;
  
  public LibHevcVideoRenderer(boolean paramBoolean, long paramLong)
  {
    this(paramBoolean, paramLong, null, null, 0);
  }
  
  public LibHevcVideoRenderer(boolean paramBoolean, long paramLong, Handler paramHandler, VideoRendererEventListener paramVideoRendererEventListener, int paramInt)
  {
    this(paramBoolean, paramLong, paramHandler, paramVideoRendererEventListener, paramInt, null, false);
  }
  
  public LibHevcVideoRenderer(boolean paramBoolean1, long paramLong, Handler paramHandler, VideoRendererEventListener paramVideoRendererEventListener, int paramInt, DrmSessionManager<ExoMediaCrypto> paramDrmSessionManager, boolean paramBoolean2)
  {
    super(2);
    this.scaleToFit = paramBoolean1;
    this.allowedJoiningTimeMs = paramLong;
    this.maxDroppedFramesToNotify = paramInt;
    this.drmSessionManager = paramDrmSessionManager;
    this.playClearSamplesWithoutKeys = paramBoolean2;
    this.joiningDeadlineMs = -9223372036854775807L;
    clearReportedVideoSize();
    this.formatHolder = new FormatHolder();
    this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
    this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(paramHandler, paramVideoRendererEventListener);
    this.outputMode = -1;
    this.decoderReinitializationState = 0;
  }
  
  private void checkSupportsFormat(Format paramFormat)
  {
    Log.d("LibHevcVideoRenderer", "supportsFormat " + paramFormat.sampleMimeType);
    if (!HevcLibrary.isAvailable()) {
      Log.w("LibHevcVideoRenderer", "HevcLibrary not available");
    }
    while (this.decoderInfo != null) {
      return;
    }
    this.decoderInfo = ("HevcLibrary Version:" + HevcLibrary.getVersion() + ", build params:" + HevcLibrary.getBuildConfig());
    Log.i("LibHevcVideoRenderer", this.decoderInfo);
  }
  
  private void clearRenderedFirstFrame()
  {
    this.renderedFirstFrame = false;
  }
  
  private void clearReportedVideoSize()
  {
    this.reportedWidth = -1;
    this.reportedHeight = -1;
  }
  
  private boolean drainOutputBuffer(long paramLong1, long paramLong2)
  {
    boolean bool1;
    if (this.outputBuffer == null)
    {
      this.outputBuffer = ((HevcOutputBuffer)this.decoder.dequeueOutputBuffer());
      if (this.outputBuffer == null) {
        bool1 = false;
      }
    }
    boolean bool2;
    do
    {
      return bool1;
      DecoderCounters localDecoderCounters = this.decoderCounters;
      localDecoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
      this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
      if (this.outputBuffer.isEndOfStream())
      {
        if (this.decoderReinitializationState == 2)
        {
          releaseDecoder();
          maybeInitDecoder();
        }
        for (;;)
        {
          return false;
          this.outputBuffer.release();
          this.outputBuffer = null;
          this.outputStreamEnded = true;
        }
      }
      bool2 = processOutputBuffer(paramLong1, paramLong2);
      bool1 = bool2;
    } while (!bool2);
    onProcessedOutputBuffer(this.outputBuffer.timeUs);
    this.outputBuffer = null;
    return bool2;
  }
  
  private boolean feedInputBuffer()
  {
    if ((this.decoder == null) || (this.decoderReinitializationState == 2) || (this.inputStreamEnded)) {
      return false;
    }
    if (this.inputBuffer == null)
    {
      this.inputBuffer = ((HevcInputBuffer)this.decoder.dequeueInputBuffer());
      if (this.inputBuffer == null) {
        return false;
      }
    }
    if (this.decoderReinitializationState == 1)
    {
      this.inputBuffer.setFlags(4);
      this.decoder.queueInputBuffer(this.inputBuffer);
      this.inputBuffer = null;
      this.decoderReinitializationState = 2;
      return false;
    }
    if (this.waitingForKeys) {}
    for (int i = -4; i == -3; i = readSource(this.formatHolder, this.inputBuffer, false)) {
      return false;
    }
    if (i == -5)
    {
      onInputFormatChanged(this.formatHolder.format);
      return true;
    }
    if (this.inputBuffer.isEndOfStream())
    {
      this.inputStreamEnded = true;
      this.decoder.queueInputBuffer(this.inputBuffer);
      this.inputBuffer = null;
      return false;
    }
    this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
    if (this.waitingForKeys) {
      return false;
    }
    this.inputBuffer.flip();
    this.inputBuffer.colorInfo = this.formatHolder.format.colorInfo;
    onQueueInputBuffer(this.inputBuffer);
    this.decoder.queueInputBuffer(this.inputBuffer);
    this.buffersInCodecCount += 1;
    this.decoderReceivedBuffers = true;
    DecoderCounters localDecoderCounters = this.decoderCounters;
    localDecoderCounters.inputBufferCount += 1;
    this.inputBuffer = null;
    return true;
  }
  
  private static boolean isBufferLate(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private static boolean isBufferVeryLate(long paramLong)
  {
    return paramLong < -500000L;
  }
  
  private void maybeInitDecoder()
  {
    if (this.decoder != null) {}
    ExoMediaCrypto localExoMediaCrypto;
    do
    {
      return;
      this.drmSession = this.pendingDrmSession;
      localObject = null;
      if (this.drmSession == null) {
        break;
      }
      localExoMediaCrypto = this.drmSession.getMediaCrypto();
      localObject = localExoMediaCrypto;
      if (localExoMediaCrypto != null) {
        break;
      }
    } while (this.drmSession.getError() == null);
    Object localObject = localExoMediaCrypto;
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      TraceUtil.beginSection("createVpxDecoder");
      this.decoder = new HevcDecoder(8, 8, 786432, (ExoMediaCrypto)localObject, this.format);
      this.decoder.setOutputMode(this.outputMode);
      TraceUtil.endSection();
      long l2 = SystemClock.elapsedRealtime();
      onDecoderInitialized(this.decoder.getName(), l2, l2 - l1);
      localObject = this.decoderCounters;
      ((DecoderCounters)localObject).decoderInitCount += 1;
      return;
    }
    catch (HevcDecoderException localHevcDecoderException)
    {
      throw ExoPlaybackException.createForRenderer(localHevcDecoderException, getIndex());
    }
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
  
  private void maybeNotifyRenderedFirstFrame()
  {
    if (!this.renderedFirstFrame)
    {
      this.renderedFirstFrame = true;
      this.eventDispatcher.renderedFirstFrame(this.surface);
    }
  }
  
  private void maybeNotifyVideoSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.reportedWidth != paramInt1) || (this.reportedHeight != paramInt2))
    {
      this.reportedWidth = paramInt1;
      this.reportedHeight = paramInt2;
      this.eventDispatcher.videoSizeChanged(paramInt1, paramInt2, 0, 1.0F);
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
      this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, 0, 1.0F);
    }
  }
  
  private boolean processOutputBuffer(long paramLong1, long paramLong2)
  {
    long l1 = this.outputBuffer.timeUs - paramLong1;
    if (this.outputMode == -1)
    {
      if (isBufferLate(l1))
      {
        skipOutputBuffer(this.outputBuffer);
        return true;
      }
      return false;
    }
    long l2 = SystemClock.elapsedRealtime();
    if (getState() == 2) {}
    for (int i = 1; (!this.renderedFirstFrame) || ((i != 0) && (shouldForceRenderOutputBuffer(l1, l2 * 1000L - this.lastRenderTimeUs))); i = 0)
    {
      renderOutputBuffer(this.outputBuffer);
      return true;
    }
    if (i == 0) {
      return false;
    }
    if ((shouldDropBuffersToKeyframe(l1, paramLong2)) && (maybeDropBuffersToKeyframe(paramLong1))) {
      return false;
    }
    if (shouldDropOutputBuffer(l1, paramLong2))
    {
      dropOutputBuffer(this.outputBuffer);
      return true;
    }
    if (l1 < 30000L)
    {
      renderOutputBuffer(this.outputBuffer);
      return true;
    }
    return false;
  }
  
  private void renderRgbFrame(HevcOutputBuffer paramHevcOutputBuffer, boolean paramBoolean)
  {
    if ((this.bitmap == null) || (this.bitmap.getWidth() != paramHevcOutputBuffer.width) || (this.bitmap.getHeight() != paramHevcOutputBuffer.height)) {
      if (1 != paramHevcOutputBuffer.pixfmt) {
        break label131;
      }
    }
    for (this.bitmap = Bitmap.createBitmap(paramHevcOutputBuffer.width, paramHevcOutputBuffer.height, Bitmap.Config.RGB_565);; this.bitmap = Bitmap.createBitmap(paramHevcOutputBuffer.width, paramHevcOutputBuffer.height, Bitmap.Config.ARGB_8888))
    {
      this.bitmap.copyPixelsFromBuffer(paramHevcOutputBuffer.data);
      Canvas localCanvas = this.surface.lockCanvas(null);
      if (paramBoolean) {
        localCanvas.scale(localCanvas.getWidth() / paramHevcOutputBuffer.width, localCanvas.getHeight() / paramHevcOutputBuffer.height);
      }
      localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      this.surface.unlockCanvasAndPost(localCanvas);
      return;
      label131:
      if (2 != paramHevcOutputBuffer.pixfmt) {
        break;
      }
    }
    throw new IllegalArgumentException("unrecognized output buffer pixfmt " + paramHevcOutputBuffer.pixfmt);
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
  
  private void setOutput(@Nullable Surface paramSurface, @Nullable HevcOutputBufferRenderer paramHevcOutputBufferRenderer)
  {
    int i = 0;
    boolean bool;
    if ((paramSurface == null) || (paramHevcOutputBufferRenderer == null))
    {
      bool = true;
      Assertions.checkState(bool);
      if ((this.surface == paramSurface) && (this.outputBufferRenderer == paramHevcOutputBufferRenderer)) {
        break label129;
      }
      this.surface = paramSurface;
      this.outputBufferRenderer = paramHevcOutputBufferRenderer;
      if (paramHevcOutputBufferRenderer == null) {
        break label106;
      }
      this.outputMode = i;
      if (this.outputMode == -1) {
        break label120;
      }
      if (this.decoder != null) {
        this.decoder.setOutputMode(this.outputMode);
      }
      maybeRenotifyVideoSizeChanged();
      clearRenderedFirstFrame();
      if (getState() == 2) {
        setJoiningDeadlineMs();
      }
    }
    label106:
    label120:
    while (this.outputMode == -1)
    {
      for (;;)
      {
        return;
        bool = false;
        break;
        if (paramSurface != null) {
          i = 1;
        } else {
          i = -1;
        }
      }
      clearReportedVideoSize();
      clearRenderedFirstFrame();
      return;
    }
    label129:
    maybeRenotifyVideoSizeChanged();
    maybeRenotifyRenderedFirstFrame();
  }
  
  private boolean shouldWaitForKeys(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.drmSession == null) || ((!paramBoolean) && (this.playClearSamplesWithoutKeys))) {
      paramBoolean = false;
    }
    int i;
    do
    {
      return paramBoolean;
      i = this.drmSession.getState();
      if (i == 1) {
        throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
      }
      paramBoolean = bool;
    } while (i != 4);
    return false;
  }
  
  protected void dropOutputBuffer(HevcOutputBuffer paramHevcOutputBuffer)
  {
    updateDroppedBufferCounters(1);
    paramHevcOutputBuffer.release();
  }
  
  @CallSuper
  protected void flushDecoder()
  {
    this.waitingForKeys = false;
    this.buffersInCodecCount = 0;
    if (this.decoderReinitializationState != 0)
    {
      releaseDecoder();
      maybeInitDecoder();
      return;
    }
    this.inputBuffer = null;
    if (this.outputBuffer != null)
    {
      this.outputBuffer.release();
      this.outputBuffer = null;
    }
    this.decoder.flush();
    this.decoderReceivedBuffers = false;
  }
  
  public void handleMessage(int paramInt, Object paramObject)
  {
    if (paramInt == 1)
    {
      setOutput((Surface)paramObject, null);
      return;
    }
    if (paramInt == 10000)
    {
      setOutput(null, (HevcOutputBufferRenderer)paramObject);
      return;
    }
    super.handleMessage(paramInt, paramObject);
  }
  
  public boolean isEnded()
  {
    return this.outputStreamEnded;
  }
  
  public boolean isReady()
  {
    if (this.waitingForKeys) {}
    do
    {
      return false;
      if ((this.format != null) && ((isSourceReady()) || (this.outputBuffer != null)) && ((this.renderedFirstFrame) || (this.outputMode == -1)))
      {
        this.joiningDeadlineMs = -9223372036854775807L;
        return true;
      }
    } while (this.joiningDeadlineMs == -9223372036854775807L);
    if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
      return true;
    }
    this.joiningDeadlineMs = -9223372036854775807L;
    return false;
  }
  
  protected boolean maybeDropBuffersToKeyframe(long paramLong)
  {
    int i = skipSource(paramLong);
    if (i == 0) {
      return false;
    }
    DecoderCounters localDecoderCounters = this.decoderCounters;
    localDecoderCounters.droppedToKeyframeCount += 1;
    updateDroppedBufferCounters(i + this.buffersInCodecCount);
    flushDecoder();
    return true;
  }
  
  @CallSuper
  protected void onDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.decoderInitialized(paramString, paramLong1, paramLong2);
  }
  
  /* Error */
  public void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 328	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:format	Lcom/google/android/exoplayer2/Format;
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 256	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:waitingForKeys	Z
    //   10: aload_0
    //   11: invokespecial 103	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:clearReportedVideoSize	()V
    //   14: aload_0
    //   15: invokespecial 501	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:clearRenderedFirstFrame	()V
    //   18: aload_0
    //   19: invokevirtual 219	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:releaseDecoder	()V
    //   22: aload_0
    //   23: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   26: ifnull +16 -> 42
    //   29: aload_0
    //   30: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   33: aload_0
    //   34: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   37: invokeinterface 548 2 0
    //   42: aload_0
    //   43: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   46: ifnull +27 -> 73
    //   49: aload_0
    //   50: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   53: aload_0
    //   54: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   57: if_acmpeq +16 -> 73
    //   60: aload_0
    //   61: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   64: aload_0
    //   65: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   68: invokeinterface 548 2 0
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   83: aload_0
    //   84: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   87: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   90: aload_0
    //   91: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   94: aload_0
    //   95: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   98: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   101: return
    //   102: astore_1
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   113: aload_0
    //   114: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   117: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   120: aload_0
    //   121: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   124: aload_0
    //   125: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   128: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload_0
    //   135: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   138: ifnull +27 -> 165
    //   141: aload_0
    //   142: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   145: aload_0
    //   146: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   149: if_acmpeq +16 -> 165
    //   152: aload_0
    //   153: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   156: aload_0
    //   157: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   160: invokeinterface 548 2 0
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   175: aload_0
    //   176: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   179: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   182: aload_0
    //   183: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   186: aload_0
    //   187: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   190: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   206: aload_0
    //   207: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   210: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   213: aload_0
    //   214: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   217: aload_0
    //   218: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   221: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   231: ifnull +16 -> 247
    //   234: aload_0
    //   235: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   238: aload_0
    //   239: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   242: invokeinterface 548 2 0
    //   247: aload_0
    //   248: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   251: ifnull +27 -> 278
    //   254: aload_0
    //   255: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   258: aload_0
    //   259: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   262: if_acmpeq +16 -> 278
    //   265: aload_0
    //   266: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   269: aload_0
    //   270: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   273: invokeinterface 548 2 0
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   288: aload_0
    //   289: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   292: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   295: aload_0
    //   296: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   299: aload_0
    //   300: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   303: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   306: aload_1
    //   307: athrow
    //   308: astore_1
    //   309: aload_0
    //   310: aconst_null
    //   311: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   314: aload_0
    //   315: aconst_null
    //   316: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   319: aload_0
    //   320: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   323: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   326: aload_0
    //   327: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   330: aload_0
    //   331: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   334: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: aload_0
    //   341: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   344: ifnull +27 -> 371
    //   347: aload_0
    //   348: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   351: aload_0
    //   352: getfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   355: if_acmpeq +16 -> 371
    //   358: aload_0
    //   359: getfield 93	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   362: aload_0
    //   363: getfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   366: invokeinterface 548 2 0
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   381: aload_0
    //   382: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   385: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   388: aload_0
    //   389: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   392: aload_0
    //   393: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   396: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   399: aload_1
    //   400: athrow
    //   401: astore_1
    //   402: aload_0
    //   403: aconst_null
    //   404: putfield 303	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   407: aload_0
    //   408: aconst_null
    //   409: putfield 301	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   412: aload_0
    //   413: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   416: invokevirtual 551	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   419: aload_0
    //   420: getfield 124	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:eventDispatcher	Lcom/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher;
    //   423: aload_0
    //   424: getfield 205	com/google/android/exoplayer2/ext/hevc/LibHevcVideoRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   427: invokevirtual 555	com/google/android/exoplayer2/video/VideoRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   430: aload_1
    //   431: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	LibHevcVideoRenderer
    //   102	30	1	localObject1	Object
    //   133	61	1	localObject2	Object
    //   195	30	1	localObject3	Object
    //   226	81	1	localObject4	Object
    //   308	30	1	localObject5	Object
    //   339	61	1	localObject6	Object
    //   401	30	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   42	73	102	finally
    //   22	42	133	finally
    //   134	165	195	finally
    //   18	22	226	finally
    //   247	278	308	finally
    //   227	247	339	finally
    //   340	371	401	finally
  }
  
  public void onEnabled(boolean paramBoolean)
  {
    this.decoderCounters = new DecoderCounters();
    this.eventDispatcher.enabled(this.decoderCounters);
  }
  
  @CallSuper
  protected void onInputFormatChanged(Format paramFormat)
  {
    Format localFormat = this.format;
    this.format = paramFormat;
    DrmInitData localDrmInitData = this.format.drmInitData;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (Util.areEqual(localDrmInitData, paramFormat)) {
        break label84;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.format.drmInitData == null) {
          break label171;
        }
        if (this.drmSessionManager == null)
        {
          throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
          paramFormat = localFormat.drmInitData;
          break;
          label84:
          i = 0;
          continue;
        }
        this.pendingDrmSession = this.drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
        if (this.pendingDrmSession == this.drmSession) {
          this.drmSessionManager.releaseSession(this.pendingDrmSession);
        }
      }
    }
    if (this.pendingDrmSession != this.drmSession)
    {
      if (!this.decoderReceivedBuffers) {
        break label179;
      }
      this.decoderReinitializationState = 1;
    }
    for (;;)
    {
      this.eventDispatcher.inputFormatChanged(this.format);
      return;
      label171:
      this.pendingDrmSession = null;
      break;
      label179:
      releaseDecoder();
      maybeInitDecoder();
    }
  }
  
  public void onPositionReset(long paramLong, boolean paramBoolean)
  {
    this.inputStreamEnded = false;
    this.outputStreamEnded = false;
    clearRenderedFirstFrame();
    this.consecutiveDroppedFrameCount = 0;
    if (this.decoder != null) {
      flushDecoder();
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
  
  protected void onQueueInputBuffer(HevcInputBuffer paramHevcInputBuffer) {}
  
  public void onStarted()
  {
    this.droppedFrames = 0;
    this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
  }
  
  public void onStopped()
  {
    this.joiningDeadlineMs = -9223372036854775807L;
    maybeNotifyDroppedFrames();
    if ((this.bitmap != null) && (!this.bitmap.isRecycled())) {
      this.bitmap.recycle();
    }
    this.bitmap = null;
  }
  
  @CallSuper
  protected void releaseDecoder()
  {
    if (this.decoder == null) {
      return;
    }
    this.inputBuffer = null;
    this.outputBuffer = null;
    this.decoder.release();
    this.decoder = null;
    DecoderCounters localDecoderCounters = this.decoderCounters;
    localDecoderCounters.decoderReleaseCount += 1;
    this.decoderReinitializationState = 0;
    this.decoderReceivedBuffers = false;
    this.buffersInCodecCount = 0;
  }
  
  public void render(long paramLong1, long paramLong2)
  {
    if (this.outputStreamEnded) {}
    do
    {
      int i;
      do
      {
        return;
        if (this.format == null)
        {
          this.flagsOnlyBuffer.clear();
          i = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
          if (i != -5) {
            break;
          }
          onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitDecoder();
      } while (this.decoder == null);
      try
      {
        TraceUtil.beginSection("drainAndFeed");
        while (drainOutputBuffer(paramLong1, paramLong2)) {}
        while (feedInputBuffer()) {}
        TraceUtil.endSection();
        this.decoderCounters.ensureUpdated();
        return;
      }
      catch (HevcDecoderException localHevcDecoderException)
      {
        throw ExoPlaybackException.createForRenderer(localHevcDecoderException, getIndex());
      }
    } while (i != -4);
    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
    this.inputStreamEnded = true;
    this.outputStreamEnded = true;
  }
  
  protected void renderOutputBuffer(HevcOutputBuffer paramHevcOutputBuffer)
  {
    int j = 1;
    int k = paramHevcOutputBuffer.mode;
    int i;
    if ((k == 1) && (this.surface != null))
    {
      i = 1;
      if ((k != 0) || (this.outputBufferRenderer == null)) {
        break label65;
      }
    }
    for (;;)
    {
      this.lastRenderTimeUs = (SystemClock.elapsedRealtime() * 1000L);
      if ((i != 0) || (j != 0)) {
        break label70;
      }
      dropOutputBuffer(paramHevcOutputBuffer);
      return;
      i = 0;
      break;
      label65:
      j = 0;
    }
    label70:
    maybeNotifyVideoSizeChanged(paramHevcOutputBuffer.width, paramHevcOutputBuffer.height);
    if (i != 0)
    {
      renderRgbFrame(paramHevcOutputBuffer, this.scaleToFit);
      paramHevcOutputBuffer.release();
    }
    for (;;)
    {
      this.consecutiveDroppedFrameCount = 0;
      paramHevcOutputBuffer = this.decoderCounters;
      paramHevcOutputBuffer.renderedOutputBufferCount += 1;
      maybeNotifyRenderedFirstFrame();
      return;
      this.outputBufferRenderer.setOutputBuffer(paramHevcOutputBuffer);
    }
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
  
  protected void skipOutputBuffer(HevcOutputBuffer paramHevcOutputBuffer)
  {
    DecoderCounters localDecoderCounters = this.decoderCounters;
    localDecoderCounters.skippedOutputBufferCount += 1;
    paramHevcOutputBuffer.release();
  }
  
  public int supportsFormat(Format paramFormat)
  {
    checkSupportsFormat(paramFormat);
    if ((!HevcLibrary.isAvailable()) || (!"video/hevc".equalsIgnoreCase(paramFormat.sampleMimeType))) {
      return 0;
    }
    if (!supportsFormatDrm(this.drmSessionManager, paramFormat.drmInitData)) {
      return 2;
    }
    return 20;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.LibHevcVideoRenderer
 * JD-Core Version:    0.7.0.1
 */