package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
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
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecAudioRenderer
  extends MediaCodecRenderer
  implements MediaClock
{
  private boolean allowFirstBufferPositionDiscontinuity;
  private boolean allowPositionDiscontinuity;
  private final AudioSink audioSink;
  private int channelCount;
  private boolean codecNeedsDiscardChannelsWorkaround;
  private long currentPositionUs;
  private int encoderDelay;
  private int encoderPadding;
  private final AudioRendererEventListener.EventDispatcher eventDispatcher;
  private boolean passthroughEnabled;
  private MediaFormat passthroughMediaFormat;
  private int pcmEncoding;
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector)
  {
    this(paramMediaCodecSelector, null, true);
  }
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector, @Nullable Handler paramHandler, @Nullable AudioRendererEventListener paramAudioRendererEventListener)
  {
    this(paramMediaCodecSelector, null, true, paramHandler, paramAudioRendererEventListener);
  }
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean)
  {
    this(paramMediaCodecSelector, paramDrmSessionManager, paramBoolean, null, null);
  }
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable AudioRendererEventListener paramAudioRendererEventListener)
  {
    this(paramMediaCodecSelector, paramDrmSessionManager, paramBoolean, paramHandler, paramAudioRendererEventListener, (AudioCapabilities)null, new AudioProcessor[0]);
  }
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable AudioRendererEventListener paramAudioRendererEventListener, @Nullable AudioCapabilities paramAudioCapabilities, AudioProcessor... paramVarArgs)
  {
    this(paramMediaCodecSelector, paramDrmSessionManager, paramBoolean, paramHandler, paramAudioRendererEventListener, new DefaultAudioSink(paramAudioCapabilities, paramVarArgs));
  }
  
  public MediaCodecAudioRenderer(MediaCodecSelector paramMediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable AudioRendererEventListener paramAudioRendererEventListener, AudioSink paramAudioSink)
  {
    super(1, paramMediaCodecSelector, paramDrmSessionManager, paramBoolean);
    this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(paramHandler, paramAudioRendererEventListener);
    this.audioSink = paramAudioSink;
    paramAudioSink.setListener(new MediaCodecAudioRenderer.AudioSinkListener(this, null));
  }
  
  private static boolean codecNeedsDiscardChannelsWorkaround(String paramString)
  {
    return (Util.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(paramString)) && ("samsung".equals(Util.MANUFACTURER)) && ((Util.DEVICE.startsWith("zeroflte")) || (Util.DEVICE.startsWith("herolte")) || (Util.DEVICE.startsWith("heroqlte")));
  }
  
  private void updateCurrentPosition()
  {
    long l = this.audioSink.getCurrentPositionUs(isEnded());
    if (l != -9223372036854775808L) {
      if (!this.allowPositionDiscontinuity) {
        break label40;
      }
    }
    for (;;)
    {
      this.currentPositionUs = l;
      this.allowPositionDiscontinuity = false;
      return;
      label40:
      l = Math.max(this.currentPositionUs, l);
    }
  }
  
  protected boolean allowPassthrough(String paramString)
  {
    int i = MimeTypes.getEncoding(paramString);
    return (i != 0) && (this.audioSink.isEncodingSupported(i));
  }
  
  public void configureCodec(MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(paramMediaCodecInfo.name);
    paramMediaCodecInfo = getMediaFormatForPlayback(paramFormat);
    if (this.passthroughEnabled)
    {
      this.passthroughMediaFormat = paramMediaCodecInfo;
      this.passthroughMediaFormat.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.passthroughMediaFormat, null, paramMediaCrypto, 0);
      this.passthroughMediaFormat.setString("mime", paramFormat.sampleMimeType);
      return;
    }
    paramMediaCodec.configure(paramMediaCodecInfo, null, paramMediaCrypto, 0);
    this.passthroughMediaFormat = null;
  }
  
  public MediaCodecInfo getDecoderInfo(MediaCodecSelector paramMediaCodecSelector, Format paramFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (allowPassthrough(paramFormat.sampleMimeType))
    {
      MediaCodecInfo localMediaCodecInfo = paramMediaCodecSelector.getPassthroughDecoderInfo();
      if (localMediaCodecInfo != null)
      {
        this.passthroughEnabled = true;
        return localMediaCodecInfo;
      }
    }
    this.passthroughEnabled = false;
    return super.getDecoderInfo(paramMediaCodecSelector, paramFormat, paramBoolean1, paramBoolean2);
  }
  
  public MediaClock getMediaClock()
  {
    return this;
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
    switch (paramInt)
    {
    default: 
      super.handleMessage(paramInt, paramObject);
      return;
    case 2: 
      this.audioSink.setVolume(((Float)paramObject).floatValue());
      return;
    }
    paramObject = (AudioAttributes)paramObject;
    this.audioSink.setAudioAttributes(paramObject);
  }
  
  public boolean isEnded()
  {
    return (super.isEnded()) && (this.audioSink.isEnded());
  }
  
  public boolean isReady()
  {
    return (this.audioSink.hasPendingData()) || (super.isReady());
  }
  
  protected void onAudioSessionId(int paramInt) {}
  
  protected void onAudioTrackPositionDiscontinuity() {}
  
  protected void onAudioTrackUnderrun(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onCodecInitialized(String paramString, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.decoderInitialized(paramString, paramLong1, paramLong2);
  }
  
  /* Error */
  public void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:audioSink	Lcom/google/android/exoplayer2/audio/AudioSink;
    //   4: invokeinterface 259 1 0
    //   9: aload_0
    //   10: invokespecial 261	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:onDisabled	()V
    //   13: aload_0
    //   14: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   17: invokevirtual 270	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   20: aload_0
    //   21: getfield 68	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   24: aload_0
    //   25: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   28: invokevirtual 274	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   37: invokevirtual 270	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   40: aload_0
    //   41: getfield 68	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   44: aload_0
    //   45: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   48: invokevirtual 274	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: invokespecial 261	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:onDisabled	()V
    //   58: aload_0
    //   59: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   62: invokevirtual 270	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   65: aload_0
    //   66: getfield 68	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   69: aload_0
    //   70: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   73: invokevirtual 274	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   83: invokevirtual 270	com/google/android/exoplayer2/decoder/DecoderCounters:ensureUpdated	()V
    //   86: aload_0
    //   87: getfield 68	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:eventDispatcher	Lcom/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher;
    //   90: aload_0
    //   91: getfield 265	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   94: invokevirtual 274	com/google/android/exoplayer2/audio/AudioRendererEventListener$EventDispatcher:disabled	(Lcom/google/android/exoplayer2/decoder/DecoderCounters;)V
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	MediaCodecAudioRenderer
    //   32	20	1	localObject1	Object
    //   53	24	1	localObject2	Object
    //   78	20	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	13	32	finally
    //   0	9	53	finally
    //   54	58	78	finally
  }
  
  public void onEnabled(boolean paramBoolean)
  {
    super.onEnabled(paramBoolean);
    this.eventDispatcher.enabled(this.decoderCounters);
    int i = getConfiguration().tunnelingAudioSessionId;
    if (i != 0)
    {
      this.audioSink.enableTunnelingV21(i);
      return;
    }
    this.audioSink.disableTunneling();
  }
  
  public void onInputFormatChanged(Format paramFormat)
  {
    int j = 0;
    super.onInputFormatChanged(paramFormat);
    this.eventDispatcher.inputFormatChanged(paramFormat);
    if ("audio/raw".equals(paramFormat.sampleMimeType))
    {
      i = paramFormat.pcmEncoding;
      this.pcmEncoding = i;
      this.channelCount = paramFormat.channelCount;
      if (paramFormat.encoderDelay == -1) {
        break label89;
      }
    }
    label89:
    for (int i = paramFormat.encoderDelay;; i = 0)
    {
      this.encoderDelay = i;
      i = j;
      if (paramFormat.encoderPadding != -1) {
        i = paramFormat.encoderPadding;
      }
      this.encoderPadding = i;
      return;
      i = 2;
      break;
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int j = 0;
    int i;
    if (this.passthroughMediaFormat != null)
    {
      i = MimeTypes.getEncoding(this.passthroughMediaFormat.getString("mime"));
      paramMediaFormat = this.passthroughMediaFormat;
    }
    int k;
    int m;
    for (;;)
    {
      k = paramMediaFormat.getInteger("channel-count");
      m = paramMediaFormat.getInteger("sample-rate");
      if ((!this.codecNeedsDiscardChannelsWorkaround) || (k != 6) || (this.channelCount >= 6)) {
        break;
      }
      paramMediaFormat = new int[this.channelCount];
      for (;;)
      {
        paramMediaCodec = paramMediaFormat;
        if (j >= this.channelCount) {
          break;
        }
        paramMediaFormat[j] = j;
        j += 1;
      }
      i = this.pcmEncoding;
    }
    paramMediaCodec = null;
    try
    {
      this.audioSink.configure(i, k, m, 0, paramMediaCodec, this.encoderDelay, this.encoderPadding);
      return;
    }
    catch (AudioSink.ConfigurationException paramMediaCodec)
    {
      throw ExoPlaybackException.createForRenderer(paramMediaCodec, getIndex());
    }
  }
  
  public void onPositionReset(long paramLong, boolean paramBoolean)
  {
    super.onPositionReset(paramLong, paramBoolean);
    this.audioSink.reset();
    this.currentPositionUs = paramLong;
    this.allowFirstBufferPositionDiscontinuity = true;
    this.allowPositionDiscontinuity = true;
  }
  
  public void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer)
  {
    if ((this.allowFirstBufferPositionDiscontinuity) && (!paramDecoderInputBuffer.isDecodeOnly()))
    {
      if (Math.abs(paramDecoderInputBuffer.timeUs - this.currentPositionUs) > 500000L) {
        this.currentPositionUs = paramDecoderInputBuffer.timeUs;
      }
      this.allowFirstBufferPositionDiscontinuity = false;
    }
  }
  
  public void onStarted()
  {
    super.onStarted();
    this.audioSink.play();
  }
  
  public void onStopped()
  {
    this.audioSink.pause();
    updateCurrentPosition();
    super.onStopped();
  }
  
  public boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    if ((this.passthroughEnabled) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.decoderCounters;
      paramMediaCodec.skippedOutputBufferCount += 1;
      this.audioSink.handleDiscontinuity();
      return true;
    }
    try
    {
      if (this.audioSink.handleBuffer(paramByteBuffer, paramLong3))
      {
        paramMediaCodec.releaseOutputBuffer(paramInt1, false);
        paramMediaCodec = this.decoderCounters;
        paramMediaCodec.renderedOutputBufferCount += 1;
        return true;
      }
    }
    catch (AudioSink.InitializationException paramMediaCodec)
    {
      throw ExoPlaybackException.createForRenderer(paramMediaCodec, getIndex());
      return false;
    }
    catch (AudioSink.WriteException paramMediaCodec)
    {
      label112:
      break label112;
    }
  }
  
  public void renderToEndOfStream()
  {
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
  
  public PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters)
  {
    return this.audioSink.setPlaybackParameters(paramPlaybackParameters);
  }
  
  public int supportsFormat(MediaCodecSelector paramMediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, Format paramFormat)
  {
    int k = 0;
    String str = paramFormat.sampleMimeType;
    if (!MimeTypes.isAudio(str)) {
      return 0;
    }
    if (Util.SDK_INT >= 21) {}
    boolean bool3;
    for (int i = 32;; i = 0)
    {
      bool3 = supportsFormatDrm(paramDrmSessionManager, paramFormat.drmInitData);
      if ((!bool3) || (!allowPassthrough(str)) || (paramMediaCodecSelector.getPassthroughDecoderInfo() == null)) {
        break;
      }
      return i | 0x8 | 0x4;
    }
    if ((("audio/raw".equals(str)) && (!this.audioSink.isEncodingSupported(paramFormat.pcmEncoding))) || (!this.audioSink.isEncodingSupported(2))) {
      return 1;
    }
    paramDrmSessionManager = paramFormat.drmInitData;
    if (paramDrmSessionManager != null)
    {
      j = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (j >= paramDrmSessionManager.schemeDataCount) {
          break;
        }
        bool1 |= paramDrmSessionManager.get(j).requiresSecureDecryption;
        j += 1;
      }
    }
    boolean bool2 = false;
    paramDrmSessionManager = paramMediaCodecSelector.getDecoderInfo(str, bool2, false);
    if (paramDrmSessionManager == null)
    {
      if ((bool2) && (paramMediaCodecSelector.getDecoderInfo(str, false, false) != null)) {}
      for (i = 2;; i = 1) {
        return i;
      }
    }
    if (!bool3) {
      return 2;
    }
    if (Util.SDK_INT >= 21)
    {
      if (paramFormat.sampleRate != -1)
      {
        j = k;
        if (!paramDrmSessionManager.isAudioSampleRateSupportedV21(paramFormat.sampleRate)) {
          break label283;
        }
      }
      if (paramFormat.channelCount != -1)
      {
        j = k;
        if (!paramDrmSessionManager.isAudioChannelCountSupportedV21(paramFormat.channelCount)) {
          break label283;
        }
      }
    }
    int j = 1;
    label283:
    if (j != 0) {}
    for (j = 4;; j = 3) {
      return j | i | 0x8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
 * JD-Core Version:    0.7.0.1
 */