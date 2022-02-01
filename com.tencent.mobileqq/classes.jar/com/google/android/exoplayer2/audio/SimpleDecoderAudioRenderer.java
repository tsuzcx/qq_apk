package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;

public abstract class SimpleDecoderAudioRenderer
  extends BaseRenderer
  implements MediaClock
{
  private static final int REINITIALIZATION_STATE_NONE = 0;
  private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
  private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
  private boolean allowFirstBufferPositionDiscontinuity;
  private boolean allowPositionDiscontinuity;
  private final AudioSink audioSink;
  private boolean audioTrackNeedsConfigure;
  private long currentPositionUs;
  private SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> decoder;
  private DecoderCounters decoderCounters;
  private boolean decoderReceivedBuffers;
  private int decoderReinitializationState;
  private DrmSession<ExoMediaCrypto> drmSession;
  private final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
  private int encoderDelay;
  private int encoderPadding;
  private final AudioRendererEventListener.EventDispatcher eventDispatcher;
  private final DecoderInputBuffer flagsOnlyBuffer;
  private final FormatHolder formatHolder;
  private DecoderInputBuffer inputBuffer;
  private Format inputFormat;
  private boolean inputStreamEnded;
  private SimpleOutputBuffer outputBuffer;
  private boolean outputStreamEnded;
  private DrmSession<ExoMediaCrypto> pendingDrmSession;
  private final boolean playClearSamplesWithoutKeys;
  private boolean waitingForKeys;
  
  public SimpleDecoderAudioRenderer()
  {
    this(null, null, new AudioProcessor[0]);
  }
  
  public SimpleDecoderAudioRenderer(Handler paramHandler, AudioRendererEventListener paramAudioRendererEventListener, AudioCapabilities paramAudioCapabilities)
  {
    this(paramHandler, paramAudioRendererEventListener, paramAudioCapabilities, null, false, new AudioProcessor[0]);
  }
  
  public SimpleDecoderAudioRenderer(Handler paramHandler, AudioRendererEventListener paramAudioRendererEventListener, AudioCapabilities paramAudioCapabilities, DrmSessionManager<ExoMediaCrypto> paramDrmSessionManager, boolean paramBoolean, AudioProcessor... paramVarArgs)
  {
    this(paramHandler, paramAudioRendererEventListener, paramDrmSessionManager, paramBoolean, new DefaultAudioSink(paramAudioCapabilities, paramVarArgs));
  }
  
  public SimpleDecoderAudioRenderer(Handler paramHandler, AudioRendererEventListener paramAudioRendererEventListener, DrmSessionManager<ExoMediaCrypto> paramDrmSessionManager, boolean paramBoolean, AudioSink paramAudioSink)
  {
    super(1);
    this.drmSessionManager = paramDrmSessionManager;
    this.playClearSamplesWithoutKeys = paramBoolean;
    this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(paramHandler, paramAudioRendererEventListener);
    this.audioSink = paramAudioSink;
    paramAudioSink.setListener(new SimpleDecoderAudioRenderer.AudioSinkListener(this, null));
    this.formatHolder = new FormatHolder();
    this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
    this.decoderReinitializationState = 0;
    this.audioTrackNeedsConfigure = true;
  }
  
  public SimpleDecoderAudioRenderer(Handler paramHandler, AudioRendererEventListener paramAudioRendererEventListener, AudioProcessor... paramVarArgs)
  {
    this(paramHandler, paramAudioRendererEventListener, null, null, false, paramVarArgs);
  }
  
  private boolean drainOutputBuffer()
  {
    Object localObject;
    if (this.outputBuffer == null)
    {
      this.outputBuffer = ((SimpleOutputBuffer)this.decoder.dequeueOutputBuffer());
      if (this.outputBuffer == null) {
        return false;
      }
      localObject = this.decoderCounters;
      ((DecoderCounters)localObject).skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
    }
    if (this.outputBuffer.isEndOfStream())
    {
      if (this.decoderReinitializationState == 2)
      {
        releaseDecoder();
        maybeInitDecoder();
        this.audioTrackNeedsConfigure = true;
        return false;
      }
      this.outputBuffer.release();
      this.outputBuffer = null;
      processEndOfStream();
      return false;
    }
    if (this.audioTrackNeedsConfigure)
    {
      localObject = getOutputFormat();
      this.audioSink.configure(((Format)localObject).pcmEncoding, ((Format)localObject).channelCount, ((Format)localObject).sampleRate, 0, null, this.encoderDelay, this.encoderPadding);
      this.audioTrackNeedsConfigure = false;
    }
    if (this.audioSink.handleBuffer(this.outputBuffer.data, this.outputBuffer.timeUs))
    {
      localObject = this.decoderCounters;
      ((DecoderCounters)localObject).renderedOutputBufferCount += 1;
      this.outputBuffer.release();
      this.outputBuffer = null;
      return true;
    }
    return false;
  }
  
  private boolean feedInputBuffer()
  {
    Object localObject = this.decoder;
    if ((localObject != null) && (this.decoderReinitializationState != 2))
    {
      if (this.inputStreamEnded) {
        return false;
      }
      if (this.inputBuffer == null)
      {
        this.inputBuffer = ((SimpleDecoder)localObject).dequeueInputBuffer();
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
      int i;
      if (this.waitingForKeys) {
        i = -4;
      } else {
        i = readSource(this.formatHolder, this.inputBuffer, false);
      }
      if (i == -3) {
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
      onQueueInputBuffer(this.inputBuffer);
      this.decoder.queueInputBuffer(this.inputBuffer);
      this.decoderReceivedBuffers = true;
      localObject = this.decoderCounters;
      ((DecoderCounters)localObject).inputBufferCount += 1;
      this.inputBuffer = null;
      return true;
    }
    return false;
  }
  
  private void flushDecoder()
  {
    this.waitingForKeys = false;
    if (this.decoderReinitializationState != 0)
    {
      releaseDecoder();
      maybeInitDecoder();
      return;
    }
    this.inputBuffer = null;
    SimpleOutputBuffer localSimpleOutputBuffer = this.outputBuffer;
    if (localSimpleOutputBuffer != null)
    {
      localSimpleOutputBuffer.release();
      this.outputBuffer = null;
    }
    this.decoder.flush();
    this.decoderReceivedBuffers = false;
  }
  
  private void maybeInitDecoder()
  {
    if (this.decoder != null) {
      return;
    }
    this.drmSession = this.pendingDrmSession;
    Object localObject1 = null;
    Object localObject2 = this.drmSession;
    if (localObject2 != null)
    {
      localObject2 = ((DrmSession)localObject2).getMediaCrypto();
      localObject1 = localObject2;
      if (localObject2 == null) {
        if (this.drmSession.getError() != null) {
          localObject1 = localObject2;
        } else {
          return;
        }
      }
    }
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      TraceUtil.beginSection("createAudioDecoder");
      this.decoder = createDecoder(this.inputFormat, (ExoMediaCrypto)localObject1);
      TraceUtil.endSection();
      long l2 = SystemClock.elapsedRealtime();
      this.eventDispatcher.decoderInitialized(this.decoder.getName(), l2, l2 - l1);
      localObject1 = this.decoderCounters;
      ((DecoderCounters)localObject1).decoderInitCount += 1;
      return;
    }
    catch (AudioDecoderException localAudioDecoderException)
    {
      throw ExoPlaybackException.createForRenderer(localAudioDecoderException, getIndex());
    }
  }
  
  private void onInputFormatChanged(Format paramFormat)
  {
    Object localObject = this.inputFormat;
    this.inputFormat = paramFormat;
    DrmInitData localDrmInitData = this.inputFormat.drmInitData;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Format)localObject).drmInitData;
    }
    if ((Util.areEqual(localDrmInitData, localObject) ^ true)) {
      if (this.inputFormat.drmInitData != null)
      {
        localObject = this.drmSessionManager;
        if (localObject != null)
        {
          this.pendingDrmSession = ((DrmSessionManager)localObject).acquireSession(Looper.myLooper(), this.inputFormat.drmInitData);
          localObject = this.pendingDrmSession;
          if (localObject == this.drmSession) {
            this.drmSessionManager.releaseSession((DrmSession)localObject);
          }
        }
        else
        {
          throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
        }
      }
      else
      {
        this.pendingDrmSession = null;
      }
    }
    if (this.decoderReceivedBuffers)
    {
      this.decoderReinitializationState = 1;
    }
    else
    {
      releaseDecoder();
      maybeInitDecoder();
      this.audioTrackNeedsConfigure = true;
    }
    int i = paramFormat.encoderDelay;
    int j = 0;
    if (i == -1) {
      i = 0;
    } else {
      i = paramFormat.encoderDelay;
    }
    this.encoderDelay = i;
    if (paramFormat.encoderPadding == -1) {
      i = j;
    } else {
      i = paramFormat.encoderPadding;
    }
    this.encoderPadding = i;
    this.eventDispatcher.inputFormatChanged(paramFormat);
  }
  
  private void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer)
  {
    if ((this.allowFirstBufferPositionDiscontinuity) && (!paramDecoderInputBuffer.isDecodeOnly()))
    {
      if (Math.abs(paramDecoderInputBuffer.timeUs - this.currentPositionUs) > 500000L) {
        this.currentPositionUs = paramDecoderInputBuffer.timeUs;
      }
      this.allowFirstBufferPositionDiscontinuity = false;
    }
  }
  
  private void processEndOfStream()
  {
    this.outputStreamEnded = true;
    try
    {
      this.audioSink.playToEndOfStream();
      return;
    }
    catch (AudioSink.WriteException localWriteException)
    {
      throw ExoPlaybackException.createForRenderer(localWriteException, getIndex());
    }
  }
  
  private void releaseDecoder()
  {
    Object localObject = this.decoder;
    if (localObject == null) {
      return;
    }
    this.inputBuffer = null;
    this.outputBuffer = null;
    ((SimpleDecoder)localObject).release();
    this.decoder = null;
    localObject = this.decoderCounters;
    ((DecoderCounters)localObject).decoderReleaseCount += 1;
    this.decoderReinitializationState = 0;
    this.decoderReceivedBuffers = false;
  }
  
  private boolean shouldWaitForKeys(boolean paramBoolean)
  {
    if (this.drmSession != null)
    {
      if ((!paramBoolean) && (this.playClearSamplesWithoutKeys)) {
        return false;
      }
      int i = this.drmSession.getState();
      if (i != 1) {
        return i != 4;
      }
      throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
    }
    return false;
  }
  
  private void updateCurrentPosition()
  {
    long l = this.audioSink.getCurrentPositionUs(isEnded());
    if (l != -9223372036854775808L)
    {
      if (!this.allowPositionDiscontinuity) {
        l = Math.max(this.currentPositionUs, l);
      }
      this.currentPositionUs = l;
      this.allowPositionDiscontinuity = false;
    }
  }
  
  protected abstract SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> createDecoder(Format paramFormat, ExoMediaCrypto paramExoMediaCrypto);
  
  public MediaClock getMediaClock()
  {
    return this;
  }
  
  protected Format getOutputFormat()
  {
    return Format.createAudioSampleFormat(null, "audio/raw", null, -1, -1, this.inputFormat.channelCount, this.inputFormat.sampleRate, 2, null, null, 0, null);
  }
  
  public PlaybackParameters getPlaybackParameters()
  {
    return this.audioSink.getPlaybackParameters();
  }
  
  public long getPositionUs()
  {
    if (getState() == 2) {
      updateCurrentPosition();
    }
    return this.currentPositionUs;
  }
  
  public void handleMessage(int paramInt, Object paramObject)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        super.handleMessage(paramInt, paramObject);
        return;
      }
      paramObject = (AudioAttributes)paramObject;
      this.audioSink.setAudioAttributes(paramObject);
      return;
    }
    this.audioSink.setVolume(((Float)paramObject).floatValue());
  }
  
  public boolean isEnded()
  {
    return (this.outputStreamEnded) && (this.audioSink.isEnded());
  }
  
  public boolean isReady()
  {
    return (this.audioSink.hasPendingData()) || ((this.inputFormat != null) && (!this.waitingForKeys) && ((isSourceReady()) || (this.outputBuffer != null)));
  }
  
  protected void onAudioSessionId(int paramInt) {}
  
  protected void onAudioTrackPositionDiscontinuity() {}
  
  protected void onAudioTrackUnderrun(int paramInt, long paramLong1, long paramLong2) {}
  
  /* Error */
  protected void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 283	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:inputFormat	Lcom/google/android/exoplayer2/Format;
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 119	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:audioTrackNeedsConfigure	Z
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 217	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:waitingForKeys	Z
    //   15: aload_0
    //   16: invokespecial 154	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:releaseDecoder	()V
    //   19: aload_0
    //   20: getfield 90	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:audioSink	Lcom/google/android/exoplayer2/audio/AudioSink;
    //   23: invokeinterface 442 1 0
    //   28: aload_0
    //   29: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   32: ifnull +16 -> 48
    //   35: aload_0
    //   36: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   39: aload_0
    //   40: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   43: invokeinterface 337 2 0
    //   48: aload_0
    //   49: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   52: ifnull +27 -> 79
    //   55: aload_0
    //   56: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   59: aload_0
    //   60: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   63: if_acmpeq +16 -> 79
    //   66: aload_0
    //   67: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   70: aload_0
    //   71: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   74: invokeinterface 337 2 0
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   89: aload_0
    //   90: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   93: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   96: aload_0
    //   97: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   100: aload_0
    //   101: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   104: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   119: aload_0
    //   120: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   123: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   126: aload_0
    //   127: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   130: aload_0
    //   131: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   134: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   144: ifnull +27 -> 171
    //   147: aload_0
    //   148: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   151: aload_0
    //   152: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   155: if_acmpeq +16 -> 171
    //   158: aload_0
    //   159: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   162: aload_0
    //   163: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   166: invokeinterface 337 2 0
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   181: aload_0
    //   182: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   185: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   188: aload_0
    //   189: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   192: aload_0
    //   193: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   196: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   212: aload_0
    //   213: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   216: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   219: aload_0
    //   220: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   223: aload_0
    //   224: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   227: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload_0
    //   234: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   237: ifnull +16 -> 253
    //   240: aload_0
    //   241: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   244: aload_0
    //   245: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   248: invokeinterface 337 2 0
    //   253: aload_0
    //   254: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   257: ifnull +27 -> 284
    //   260: aload_0
    //   261: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   264: aload_0
    //   265: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   268: if_acmpeq +16 -> 284
    //   271: aload_0
    //   272: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   275: aload_0
    //   276: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   279: invokeinterface 337 2 0
    //   284: aload_0
    //   285: aconst_null
    //   286: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   289: aload_0
    //   290: aconst_null
    //   291: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   294: aload_0
    //   295: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   298: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   301: aload_0
    //   302: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   305: aload_0
    //   306: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   309: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   312: aload_1
    //   313: athrow
    //   314: astore_1
    //   315: aload_0
    //   316: aconst_null
    //   317: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   320: aload_0
    //   321: aconst_null
    //   322: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   325: aload_0
    //   326: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   329: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   332: aload_0
    //   333: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   336: aload_0
    //   337: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   340: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: aload_0
    //   347: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   350: ifnull +27 -> 377
    //   353: aload_0
    //   354: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   357: aload_0
    //   358: getfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   361: if_acmpeq +16 -> 377
    //   364: aload_0
    //   365: getfield 79	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   368: aload_0
    //   369: getfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   372: invokeinterface 337 2 0
    //   377: aload_0
    //   378: aconst_null
    //   379: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   382: aload_0
    //   383: aconst_null
    //   384: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   387: aload_0
    //   388: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   391: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   394: aload_0
    //   395: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   398: aload_0
    //   399: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   402: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   405: aload_1
    //   406: athrow
    //   407: astore_1
    //   408: aload_0
    //   409: aconst_null
    //   410: putfield 257	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   413: aload_0
    //   414: aconst_null
    //   415: putfield 255	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   418: aload_0
    //   419: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   422: invokevirtual 445	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   425: aload_0
    //   426: getfield 88	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   429: aload_0
    //   430: getfield 142	com/google/android/exoplayer2/audio/SimpleDecoderAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   433: invokevirtual 449	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   436: aload_1
    //   437: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	SimpleDecoderAudioRenderer
    //   108	30	1	localObject1	Object
    //   139	61	1	localObject2	Object
    //   201	30	1	localObject3	Object
    //   232	81	1	localObject4	Object
    //   314	30	1	localObject5	Object
    //   345	61	1	localObject6	Object
    //   407	30	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   48	79	108	finally
    //   28	48	139	finally
    //   140	171	201	finally
    //   15	28	232	finally
    //   253	284	314	finally
    //   233	253	345	finally
    //   346	377	407	finally
  }
  
  protected void onEnabled(boolean paramBoolean)
  {
    this.decoderCounters = new DecoderCounters();
    this.eventDispatcher.enabled(this.decoderCounters);
    int i = getConfiguration().tunnelingAudioSessionId;
    if (i != 0)
    {
      this.audioSink.enableTunnelingV21(i);
      return;
    }
    this.audioSink.disableTunneling();
  }
  
  protected void onPositionReset(long paramLong, boolean paramBoolean)
  {
    this.audioSink.reset();
    this.currentPositionUs = paramLong;
    this.allowFirstBufferPositionDiscontinuity = true;
    this.allowPositionDiscontinuity = true;
    this.inputStreamEnded = false;
    this.outputStreamEnded = false;
    if (this.decoder != null) {
      flushDecoder();
    }
  }
  
  protected void onStarted()
  {
    this.audioSink.play();
  }
  
  protected void onStopped()
  {
    this.audioSink.pause();
    updateCurrentPosition();
  }
  
  public void render(long paramLong1, long paramLong2)
  {
    if (this.outputStreamEnded) {
      try
      {
        this.audioSink.playToEndOfStream();
        return;
      }
      catch (AudioSink.WriteException localWriteException1)
      {
        throw ExoPlaybackException.createForRenderer(localWriteException1, getIndex());
      }
    }
    if (this.inputFormat == null)
    {
      this.flagsOnlyBuffer.clear();
      int i = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
      if (i == -5)
      {
        onInputFormatChanged(this.formatHolder.format);
      }
      else
      {
        if (i == -4)
        {
          Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
          this.inputStreamEnded = true;
          processEndOfStream();
        }
        return;
      }
    }
    maybeInitDecoder();
    if (this.decoder != null)
    {
      try
      {
        TraceUtil.beginSection("drainAndFeed");
        while (drainOutputBuffer()) {}
        while (feedInputBuffer()) {}
        TraceUtil.endSection();
        this.decoderCounters.ensureUpdated();
        return;
      }
      catch (AudioSink.WriteException localWriteException2) {}catch (AudioSink.InitializationException localInitializationException) {}catch (AudioSink.ConfigurationException localConfigurationException) {}catch (AudioDecoderException localAudioDecoderException) {}
      throw ExoPlaybackException.createForRenderer(localAudioDecoderException, getIndex());
    }
  }
  
  public PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters)
  {
    return this.audioSink.setPlaybackParameters(paramPlaybackParameters);
  }
  
  public final int supportsFormat(Format paramFormat)
  {
    int j = supportsFormatInternal(this.drmSessionManager, paramFormat);
    if (j <= 2) {
      return j;
    }
    int i;
    if (Util.SDK_INT >= 21) {
      i = 32;
    } else {
      i = 0;
    }
    return j | i | 0x8;
  }
  
  protected abstract int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> paramDrmSessionManager, Format paramFormat);
  
  protected final boolean supportsOutputEncoding(int paramInt)
  {
    return this.audioSink.isEncodingSupported(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
 * JD-Core Version:    0.7.0.1
 */