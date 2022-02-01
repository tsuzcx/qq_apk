package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecRenderer
  extends BaseRenderer
{
  private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
  private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
  private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
  private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
  private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000L;
  private static final int RECONFIGURATION_STATE_NONE = 0;
  private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
  private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
  private static final int REINITIALIZATION_STATE_NONE = 0;
  private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
  private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
  private static final String TAG = "MediaCodecRenderer";
  private final DecoderInputBuffer buffer;
  private MediaCodec codec;
  private int codecAdaptationWorkaroundMode;
  private long codecHotswapDeadlineMs;
  private MediaCodecInfo codecInfo;
  private boolean codecNeedsAdaptationWorkaroundBuffer;
  private boolean codecNeedsDiscardToSpsWorkaround;
  private boolean codecNeedsEosFlushWorkaround;
  private boolean codecNeedsEosOutputExceptionWorkaround;
  private boolean codecNeedsEosPropagationWorkaround;
  private boolean codecNeedsFlushWorkaround;
  private boolean codecNeedsMonoChannelCountWorkaround;
  private boolean codecReceivedBuffers;
  private boolean codecReceivedEos;
  private int codecReconfigurationState;
  private boolean codecReconfigured;
  private int codecReinitializationState;
  private final List<Long> decodeOnlyPresentationTimestamps;
  protected DecoderCounters decoderCounters;
  private DrmSession<FrameworkMediaCrypto> drmSession;
  @Nullable
  private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
  private final DecoderInputBuffer flagsOnlyBuffer;
  private Format format;
  private final FormatHolder formatHolder;
  private ByteBuffer[] inputBuffers;
  private int inputIndex;
  private boolean inputStreamEnded;
  private final MediaCodecSelector mediaCodecSelector;
  private ByteBuffer outputBuffer;
  private final MediaCodec.BufferInfo outputBufferInfo;
  private ByteBuffer[] outputBuffers;
  private int outputIndex;
  private boolean outputStreamEnded;
  private DrmSession<FrameworkMediaCrypto> pendingDrmSession;
  private final boolean playClearSamplesWithoutKeys;
  private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
  private boolean shouldSkipOutputBuffer;
  private boolean waitingForFirstSyncFrame;
  private boolean waitingForKeys;
  
  public MediaCodecRenderer(int paramInt, MediaCodecSelector paramMediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, boolean paramBoolean)
  {
    super(paramInt);
    boolean bool;
    if (Util.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.mediaCodecSelector = ((MediaCodecSelector)Assertions.checkNotNull(paramMediaCodecSelector));
    this.drmSessionManager = paramDrmSessionManager;
    this.playClearSamplesWithoutKeys = paramBoolean;
    this.buffer = new DecoderInputBuffer(0);
    this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
    this.formatHolder = new FormatHolder();
    this.decodeOnlyPresentationTimestamps = new ArrayList();
    this.outputBufferInfo = new MediaCodec.BufferInfo();
    this.codecReconfigurationState = 0;
    this.codecReinitializationState = 0;
  }
  
  private int codecAdaptationWorkaroundMode(String paramString)
  {
    if ((Util.SDK_INT <= 25) && ("OMX.Exynos.avc.dec.secure".equals(paramString)) && ((Util.MODEL.startsWith("SM-T585")) || (Util.MODEL.startsWith("SM-A510")) || (Util.MODEL.startsWith("SM-A520")) || (Util.MODEL.startsWith("SM-J700")))) {
      return 2;
    }
    if ((Util.SDK_INT < 24) && (("OMX.Nvidia.h264.decode".equals(paramString)) || ("OMX.Nvidia.h264.decode.secure".equals(paramString))) && (("flounder".equals(Util.DEVICE)) || ("flounder_lte".equals(Util.DEVICE)) || ("grouper".equals(Util.DEVICE)) || ("tilapia".equals(Util.DEVICE)))) {
      return 1;
    }
    return 0;
  }
  
  private static boolean codecNeedsDiscardToSpsWorkaround(String paramString, Format paramFormat)
  {
    return (Util.SDK_INT < 21) && (paramFormat.initializationData.isEmpty()) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString));
  }
  
  private static boolean codecNeedsEosFlushWorkaround(String paramString)
  {
    return ((Util.SDK_INT <= 23) && ("OMX.google.vorbis.decoder".equals(paramString))) || ((Util.SDK_INT <= 19) && ("hb2000".equals(Util.DEVICE)) && (("OMX.amlogic.avc.decoder.awesome".equals(paramString)) || ("OMX.amlogic.avc.decoder.awesome.secure".equals(paramString))));
  }
  
  private static boolean codecNeedsEosOutputExceptionWorkaround(String paramString)
  {
    return (Util.SDK_INT == 21) && ("OMX.google.aac.decoder".equals(paramString));
  }
  
  private static boolean codecNeedsEosPropagationWorkaround(String paramString)
  {
    return (Util.SDK_INT <= 17) && (("OMX.rk.video_decoder.avc".equals(paramString)) || ("OMX.allwinner.video.decoder.avc".equals(paramString)));
  }
  
  private static boolean codecNeedsFlushWorkaround(String paramString)
  {
    return (Util.SDK_INT < 18) || ((Util.SDK_INT == 18) && (("OMX.SEC.avc.dec".equals(paramString)) || ("OMX.SEC.avc.dec.secure".equals(paramString)))) || ((Util.SDK_INT == 19) && (Util.MODEL.startsWith("SM-G800")) && (("OMX.Exynos.avc.dec".equals(paramString)) || ("OMX.Exynos.avc.dec.secure".equals(paramString))));
  }
  
  private static boolean codecNeedsMonoChannelCountWorkaround(String paramString, Format paramFormat)
  {
    return (Util.SDK_INT <= 18) && (paramFormat.channelCount == 1) && ("OMX.MTK.AUDIO.DECODER.MP3".equals(paramString));
  }
  
  @TargetApi(23)
  private static void configureMediaFormatForPlaybackV23(MediaFormat paramMediaFormat)
  {
    paramMediaFormat.setInteger("priority", 0);
  }
  
  private boolean drainOutputBuffer(long paramLong1, long paramLong2)
  {
    if ((hasOutputBuffer()) || ((this.codecNeedsEosOutputExceptionWorkaround) && (this.codecReceivedEos))) {}
    try
    {
      i = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      int i;
      label41:
      break label41;
    }
    processEndOfStream();
    if (this.outputStreamEnded) {}
    try
    {
      releaseCodec();
      return false;
    }
    catch (Exception localException1)
    {
      label257:
      return false;
    }
    try
    {
      i = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
      if (i >= 0)
      {
        if (this.shouldSkipAdaptationWorkaroundOutputBuffer)
        {
          this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
          this.codec.releaseOutputBuffer(i, false);
          return true;
        }
        if ((this.outputBufferInfo.flags & 0x4) != 0)
        {
          processEndOfStream();
          return false;
        }
        this.outputIndex = i;
        this.outputBuffer = getOutputBuffer(i);
        ByteBuffer localByteBuffer = this.outputBuffer;
        if (localByteBuffer != null)
        {
          localByteBuffer.position(this.outputBufferInfo.offset);
          this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
        }
        this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
      }
      else
      {
        if (i == -2)
        {
          processOutputFormat();
          return true;
        }
        if (i == -3)
        {
          processOutputBuffersChanged();
          return true;
        }
        if ((this.codecNeedsEosPropagationWorkaround) && ((this.inputStreamEnded) || (this.codecReinitializationState == 2))) {
          processEndOfStream();
        }
        return false;
      }
    }
    catch (Exception localException2)
    {
      break label257;
    }
    try
    {
      releaseCodec();
      return false;
    }
    catch (Exception localException3)
    {
      return false;
    }
    if ((this.codecNeedsEosOutputExceptionWorkaround) && (this.codecReceivedEos)) {}
    try
    {
      bool = processOutputBuffer(paramLong1, paramLong2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      boolean bool;
      label318:
      break label318;
    }
    processEndOfStream();
    if (this.outputStreamEnded) {
      releaseCodec();
    }
    return false;
    bool = processOutputBuffer(paramLong1, paramLong2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
    if (bool)
    {
      onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
      resetOutputBuffer();
      return true;
    }
    return false;
  }
  
  private boolean feedInputBuffer()
  {
    Object localObject1 = this.codec;
    if ((localObject1 != null) && (this.codecReinitializationState != 2))
    {
      if (this.inputStreamEnded) {
        return false;
      }
      int i;
      if (this.inputIndex < 0)
      {
        this.inputIndex = ((MediaCodec)localObject1).dequeueInputBuffer(0L);
        i = this.inputIndex;
        if (i < 0) {
          return false;
        }
        this.buffer.data = getInputBuffer(i);
        this.buffer.clear();
      }
      if (this.codecReinitializationState == 1)
      {
        if (!this.codecNeedsEosPropagationWorkaround)
        {
          this.codecReceivedEos = true;
          this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
          resetInputBuffer();
        }
        this.codecReinitializationState = 2;
        return false;
      }
      if (this.codecNeedsAdaptationWorkaroundBuffer)
      {
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
        this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0L, 0);
        resetInputBuffer();
        this.codecReceivedBuffers = true;
        return true;
      }
      int j;
      if (this.waitingForKeys)
      {
        j = -4;
        i = 0;
      }
      else
      {
        if (this.codecReconfigurationState == 1)
        {
          i = 0;
          while (i < this.format.initializationData.size())
          {
            localObject1 = (byte[])this.format.initializationData.get(i);
            this.buffer.data.put((byte[])localObject1);
            i += 1;
          }
          this.codecReconfigurationState = 2;
        }
        i = this.buffer.data.position();
        j = readSource(this.formatHolder, this.buffer, false);
      }
      if (j == -3) {
        return false;
      }
      if (j == -5)
      {
        if (this.codecReconfigurationState == 2)
        {
          this.buffer.clear();
          this.codecReconfigurationState = 1;
        }
        onInputFormatChanged(this.formatHolder.format);
        return true;
      }
      if (this.buffer.isEndOfStream())
      {
        if (this.codecReconfigurationState == 2)
        {
          this.buffer.clear();
          this.codecReconfigurationState = 1;
        }
        this.inputStreamEnded = true;
        if (!this.codecReceivedBuffers)
        {
          processEndOfStream();
          return false;
        }
        try
        {
          if (this.codecNeedsEosPropagationWorkaround) {
            return false;
          }
          this.codecReceivedEos = true;
          this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
          resetInputBuffer();
          return false;
        }
        catch (MediaCodec.CryptoException localCryptoException1)
        {
          throw ExoPlaybackException.createForRenderer(localCryptoException1, getIndex());
        }
      }
      if ((this.waitingForFirstSyncFrame) && (!this.buffer.isKeyFrame()))
      {
        this.buffer.clear();
        if (this.codecReconfigurationState == 2) {
          this.codecReconfigurationState = 1;
        }
        return true;
      }
      this.waitingForFirstSyncFrame = false;
      boolean bool = this.buffer.isEncrypted();
      this.waitingForKeys = shouldWaitForKeys(bool);
      if (this.waitingForKeys) {
        return false;
      }
      if ((this.codecNeedsDiscardToSpsWorkaround) && (!bool))
      {
        NalUnitUtil.discardToSps(this.buffer.data);
        if (this.buffer.data.position() == 0) {
          return true;
        }
        this.codecNeedsDiscardToSpsWorkaround = false;
      }
      try
      {
        long l = this.buffer.timeUs;
        if (this.buffer.isDecodeOnly()) {
          this.decodeOnlyPresentationTimestamps.add(Long.valueOf(l));
        }
        this.buffer.flip();
        onQueueInputBuffer(this.buffer);
        if (bool)
        {
          localObject2 = getFrameworkCryptoInfo(this.buffer, i);
          this.codec.queueSecureInputBuffer(this.inputIndex, 0, (MediaCodec.CryptoInfo)localObject2, l, 0);
        }
        else
        {
          this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), l, 0);
        }
        resetInputBuffer();
        this.codecReceivedBuffers = true;
        this.codecReconfigurationState = 0;
        Object localObject2 = this.decoderCounters;
        ((DecoderCounters)localObject2).inputBufferCount += 1;
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw ExoPlaybackException.createForRenderer(localRuntimeException, getIndex());
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw ExoPlaybackException.createForRenderer(localCryptoException2, getIndex());
      }
    }
    return false;
  }
  
  private void getCodecBuffers()
  {
    if (Util.SDK_INT < 21)
    {
      this.inputBuffers = this.codec.getInputBuffers();
      this.outputBuffers = this.codec.getOutputBuffers();
    }
  }
  
  private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
  {
    paramDecoderInputBuffer = paramDecoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
    if (paramInt == 0) {
      return paramDecoderInputBuffer;
    }
    if (paramDecoderInputBuffer.numBytesOfClearData == null) {
      paramDecoderInputBuffer.numBytesOfClearData = new int[1];
    }
    int[] arrayOfInt = paramDecoderInputBuffer.numBytesOfClearData;
    arrayOfInt[0] += paramInt;
    return paramDecoderInputBuffer;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    if (Util.SDK_INT >= 21) {
      return this.codec.getInputBuffer(paramInt);
    }
    return this.inputBuffers[paramInt];
  }
  
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    if (Util.SDK_INT >= 21) {
      return this.codec.getOutputBuffer(paramInt);
    }
    return this.outputBuffers[paramInt];
  }
  
  private boolean hasOutputBuffer()
  {
    return this.outputIndex >= 0;
  }
  
  private void initMediaCodecInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.codecInfo == null)
    {
      try
      {
        this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, paramBoolean1, paramBoolean2);
        if ((this.codecInfo == null) && (paramBoolean1))
        {
          this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, false, paramBoolean2);
          if (this.codecInfo != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Drm session requires secure decoder for ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(", but no secure decoder available. Trying to proceed with ");
            localStringBuilder.append(this.codecInfo.name);
            localStringBuilder.append(".");
            Log.w("MediaCodecRenderer", localStringBuilder.toString());
          }
        }
      }
      catch (MediaCodecUtil.DecoderQueryException paramString)
      {
        throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, paramString, paramBoolean1, -49998));
      }
      if (this.codecInfo == null) {
        throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, null, paramBoolean1, -49999));
      }
    }
  }
  
  private void processEndOfStream()
  {
    if (this.codecReinitializationState == 2)
    {
      releaseCodec();
      maybeInitCodec();
      return;
    }
    this.outputStreamEnded = true;
    renderToEndOfStream();
  }
  
  private void processOutputBuffersChanged()
  {
    if (Util.SDK_INT < 21) {
      this.outputBuffers = this.codec.getOutputBuffers();
    }
  }
  
  private void processOutputFormat()
  {
    MediaFormat localMediaFormat = this.codec.getOutputFormat();
    if ((this.codecAdaptationWorkaroundMode != 0) && (localMediaFormat.getInteger("width") == 32) && (localMediaFormat.getInteger("height") == 32))
    {
      this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
      return;
    }
    if (this.codecNeedsMonoChannelCountWorkaround) {
      localMediaFormat.setInteger("channel-count", 1);
    }
    onOutputFormatChanged(this.codec, localMediaFormat);
  }
  
  private void resetCodecBuffers()
  {
    if (Util.SDK_INT < 21)
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
    }
  }
  
  private void resetInputBuffer()
  {
    this.inputIndex = -1;
    this.buffer.data = null;
  }
  
  private void resetOutputBuffer()
  {
    this.outputIndex = -1;
    this.outputBuffer = null;
  }
  
  private boolean shouldSkipOutputBuffer(long paramLong)
  {
    int j = this.decodeOnlyPresentationTimestamps.size();
    int i = 0;
    while (i < j)
    {
      if (((Long)this.decodeOnlyPresentationTimestamps.get(i)).longValue() == paramLong)
      {
        this.decodeOnlyPresentationTimestamps.remove(i);
        return true;
      }
      i += 1;
    }
    return false;
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
  
  private void throwDecoderInitError(MediaCodecRenderer.DecoderInitializationException paramDecoderInitializationException)
  {
    throw ExoPlaybackException.createForRenderer(paramDecoderInitializationException, getIndex());
  }
  
  protected boolean canReconfigureCodec(MediaCodec paramMediaCodec, boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return false;
  }
  
  protected abstract void configureCodec(MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto);
  
  protected void flushCodec()
  {
    this.codecHotswapDeadlineMs = -9223372036854775807L;
    resetInputBuffer();
    resetOutputBuffer();
    this.waitingForFirstSyncFrame = true;
    this.waitingForKeys = false;
    this.shouldSkipOutputBuffer = false;
    this.decodeOnlyPresentationTimestamps.clear();
    this.codecNeedsAdaptationWorkaroundBuffer = false;
    this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
    if ((!this.codecNeedsFlushWorkaround) && ((!this.codecNeedsEosFlushWorkaround) || (!this.codecReceivedEos)))
    {
      if (this.codecReinitializationState != 0)
      {
        releaseCodec();
        maybeInitCodec();
      }
      else
      {
        this.codec.flush();
        this.codecReceivedBuffers = false;
      }
    }
    else
    {
      releaseCodec();
      maybeInitCodec();
    }
    if ((this.codecReconfigured) && (this.format != null)) {
      this.codecReconfigurationState = 1;
    }
  }
  
  protected final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  protected final MediaCodecInfo getCodecInfo()
  {
    return this.codecInfo;
  }
  
  protected MediaCodecInfo getDecoderInfo(MediaCodecSelector paramMediaCodecSelector, Format paramFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramMediaCodecSelector.getDecoderInfo(paramFormat.sampleMimeType, paramBoolean1, paramBoolean2);
  }
  
  protected long getDequeueOutputBufferTimeoutUs()
  {
    return 0L;
  }
  
  protected final MediaFormat getMediaFormatForPlayback(Format paramFormat)
  {
    paramFormat = paramFormat.getFrameworkMediaFormatV16();
    if (Util.SDK_INT >= 23) {
      configureMediaFormatForPlaybackV23(paramFormat);
    }
    return paramFormat;
  }
  
  public int getRenderIndex()
  {
    return getIndex();
  }
  
  public boolean isEnded()
  {
    return this.outputStreamEnded;
  }
  
  public boolean isReady()
  {
    return (this.format != null) && (!this.waitingForKeys) && ((isSourceReady()) || (hasOutputBuffer()) || ((this.codecHotswapDeadlineMs != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs)));
  }
  
  protected final void maybeInitCodec()
  {
    if (this.codec == null)
    {
      Object localObject1 = this.format;
      if (localObject1 == null) {
        return;
      }
      this.drmSession = this.pendingDrmSession;
      String str = ((Format)localObject1).sampleMimeType;
      localObject1 = this.drmSession;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (FrameworkMediaCrypto)((DrmSession)localObject1).getMediaCrypto();
        if (localObject2 == null)
        {
          if (this.drmSession.getError() != null) {}
        }
        else
        {
          localObject1 = ((FrameworkMediaCrypto)localObject2).getWrappedMediaCrypto();
          bool1 = ((FrameworkMediaCrypto)localObject2).requiresSecureDecoderComponent(str);
          break label101;
        }
      }
      localObject1 = null;
      boolean bool1 = false;
      label101:
      int i = 0;
      while (i < 2)
      {
        boolean bool2;
        if (i == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (i > 0) {
          this.codecInfo = null;
        }
        initMediaCodecInfo(str, bool1, bool2);
        if (!shouldInitCodec(this.codecInfo)) {
          return;
        }
        Object localObject3 = this.codecInfo.name;
        this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode((String)localObject3);
        this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround((String)localObject3, this.format);
        this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround((String)localObject3);
        this.codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround((String)localObject3);
        this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround((String)localObject3);
        this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround((String)localObject3);
        this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround((String)localObject3, this.format);
        long l1;
        try
        {
          l1 = SystemClock.elapsedRealtime();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createCodec:");
          ((StringBuilder)localObject2).append((String)localObject3);
          TraceUtil.beginSection(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createCodec: ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append((String)localObject3);
          Log.i("MediaCodecRenderer", ((StringBuilder)localObject2).toString());
          this.codec = MediaCodec.createByCodecName((String)localObject3);
          TraceUtil.endSection();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("configureCodec:");
          ((StringBuilder)localObject2).append((String)localObject3);
          TraceUtil.beginSection(((StringBuilder)localObject2).toString());
          configureCodec(this.codecInfo, this.codec, this.format, (MediaCrypto)localObject1);
          TraceUtil.endSection();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startCodec:");
          ((StringBuilder)localObject2).append((String)localObject3);
          TraceUtil.beginSection(((StringBuilder)localObject2).toString());
          this.codec.start();
          TraceUtil.endSection();
          long l2 = SystemClock.elapsedRealtime();
          try
          {
            onCodecInitialized((String)localObject3, l2, l2 - l1);
            getCodecBuffers();
            j = 0;
          }
          catch (Exception localException1) {}
          if (i < 1) {
            break label496;
          }
        }
        catch (Exception localException2) {}
        throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, localException2, bool1, (String)localObject3));
        label496:
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("decoder creation for ");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(" failed,");
        ((StringBuilder)localObject3).append(this.codecInfo.name);
        ((StringBuilder)localObject3).append(".");
        Log.w("MediaCodecRenderer", ((StringBuilder)localObject3).toString(), localException2);
        int j = 1;
        if (getState() == 2) {
          l1 = SystemClock.elapsedRealtime() + 1000L;
        } else {
          l1 = -9223372036854775807L;
        }
        this.codecHotswapDeadlineMs = l1;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForFirstSyncFrame = true;
        DecoderCounters localDecoderCounters = this.decoderCounters;
        localDecoderCounters.decoderInitCount += 1;
        if (j == 0) {
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void onCodecInitialized(String paramString, long paramLong1, long paramLong2) {}
  
  /* Error */
  protected void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 387	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:format	Lcom/google/android/exoplayer2/Format;
    //   5: aload_0
    //   6: invokevirtual 287	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:releaseCodec	()V
    //   9: aload_0
    //   10: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   20: aload_0
    //   21: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   24: invokeinterface 741 2 0
    //   29: aload_0
    //   30: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   33: ifnull +27 -> 60
    //   36: aload_0
    //   37: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   40: aload_0
    //   41: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   44: if_acmpeq +16 -> 60
    //   47: aload_0
    //   48: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   51: aload_0
    //   52: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   55: invokeinterface 741 2 0
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   89: ifnull +27 -> 116
    //   92: aload_0
    //   93: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   96: aload_0
    //   97: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   100: if_acmpeq +16 -> 116
    //   103: aload_0
    //   104: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   107: aload_0
    //   108: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   111: invokeinterface 741 2 0
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   146: ifnull +16 -> 162
    //   149: aload_0
    //   150: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   153: aload_0
    //   154: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   157: invokeinterface 741 2 0
    //   162: aload_0
    //   163: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   166: ifnull +27 -> 193
    //   169: aload_0
    //   170: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   173: aload_0
    //   174: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   177: if_acmpeq +16 -> 193
    //   180: aload_0
    //   181: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   184: aload_0
    //   185: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   188: invokeinterface 741 2 0
    //   193: aload_0
    //   194: aconst_null
    //   195: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: aload_0
    //   220: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   223: ifnull +27 -> 250
    //   226: aload_0
    //   227: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   230: aload_0
    //   231: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   234: if_acmpeq +16 -> 250
    //   237: aload_0
    //   238: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   241: aload_0
    //   242: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   245: invokeinterface 741 2 0
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   255: aload_0
    //   256: aconst_null
    //   257: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: aconst_null
    //   265: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	MediaCodecRenderer
    //   71	12	1	localObject1	Object
    //   84	43	1	localObject2	Object
    //   128	12	1	localObject3	Object
    //   141	63	1	localObject4	Object
    //   205	12	1	localObject5	Object
    //   218	43	1	localObject6	Object
    //   262	12	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	60	71	finally
    //   9	29	84	finally
    //   85	116	128	finally
    //   5	9	141	finally
    //   162	193	205	finally
    //   142	162	218	finally
    //   219	250	262	finally
  }
  
  protected void onEnabled(boolean paramBoolean)
  {
    this.decoderCounters = new DecoderCounters();
  }
  
  protected void onInputFormatChanged(Format paramFormat)
  {
    Format localFormat = this.format;
    this.format = paramFormat;
    DrmInitData localDrmInitData = this.format.drmInitData;
    if (localFormat == null) {
      paramFormat = null;
    } else {
      paramFormat = localFormat.drmInitData;
    }
    boolean bool1 = Util.areEqual(localDrmInitData, paramFormat);
    boolean bool2 = true;
    if ((bool1 ^ true)) {
      if (this.format.drmInitData != null)
      {
        paramFormat = this.drmSessionManager;
        if (paramFormat != null)
        {
          this.pendingDrmSession = paramFormat.acquireSession(Looper.myLooper(), this.format.drmInitData);
          paramFormat = this.pendingDrmSession;
          if (paramFormat == this.drmSession) {
            this.drmSessionManager.releaseSession(paramFormat);
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
    if (this.pendingDrmSession == this.drmSession)
    {
      paramFormat = this.codec;
      if ((paramFormat != null) && (canReconfigureCodec(paramFormat, this.codecInfo.adaptive, localFormat, this.format)))
      {
        this.codecReconfigured = true;
        this.codecReconfigurationState = 1;
        int i = this.codecAdaptationWorkaroundMode;
        bool1 = bool2;
        if (i != 2) {
          if ((i == 1) && (this.format.width == localFormat.width) && (this.format.height == localFormat.height)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        this.codecNeedsAdaptationWorkaroundBuffer = bool1;
        return;
      }
    }
    if (this.codecReceivedBuffers)
    {
      this.codecReinitializationState = 1;
      return;
    }
    releaseCodec();
    maybeInitCodec();
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  protected void onPositionReset(long paramLong, boolean paramBoolean)
  {
    this.inputStreamEnded = false;
    this.outputStreamEnded = false;
    if (this.codec != null) {
      flushCodec();
    }
  }
  
  protected void onProcessedOutputBuffer(long paramLong) {}
  
  protected void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer) {}
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  protected abstract boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean);
  
  /* Error */
  protected void releaseCodec()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 607
    //   4: putfield 610	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecHotswapDeadlineMs	J
    //   7: aload_0
    //   8: invokespecial 375	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetInputBuffer	()V
    //   11: aload_0
    //   12: invokespecial 348	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetOutputBuffer	()V
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 385	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForKeys	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 327	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:shouldSkipOutputBuffer	Z
    //   25: aload_0
    //   26: getfield 150	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:decodeOnlyPresentationTimestamps	Ljava/util/List;
    //   29: invokeinterface 611 1 0
    //   34: aload_0
    //   35: invokespecial 782	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetCodecBuffers	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 513	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecInfo	Lcom/google/android/exoplayer2/mediacodec/MediaCodecInfo;
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 620	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigured	Z
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 383	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedBuffers	Z
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 432	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsDiscardToSpsWorkaround	Z
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 613	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsFlushWorkaround	Z
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 568	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecAdaptationWorkaroundMode	I
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 335	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsEosPropagationWorkaround	Z
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 615	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsEosFlushWorkaround	Z
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 577	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsMonoChannelCountWorkaround	Z
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 377	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsAdaptationWorkaroundBuffer	Z
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 289	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:shouldSkipAdaptationWorkaroundOutputBuffer	Z
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 267	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedEos	Z
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 159	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReinitializationState	I
    //   108: aload_0
    //   109: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   112: ifnull +238 -> 350
    //   115: aload_0
    //   116: getfield 472	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   119: astore_1
    //   120: aload_1
    //   121: aload_1
    //   122: getfield 785	com/google/android/exoplayer2/decoder/DecoderCounters:decoderReleaseCount	I
    //   125: iconst_1
    //   126: iadd
    //   127: putfield 785	com/google/android/exoplayer2/decoder/DecoderCounters:decoderReleaseCount	I
    //   130: aload_0
    //   131: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   134: invokevirtual 788	android/media/MediaCodec:stop	()V
    //   137: aload_0
    //   138: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   141: invokevirtual 791	android/media/MediaCodec:release	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   149: aload_0
    //   150: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +195 -> 350
    //   158: aload_0
    //   159: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   162: aload_1
    //   163: if_acmpeq +187 -> 350
    //   166: aload_0
    //   167: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   170: aload_1
    //   171: invokeinterface 741 2 0
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   181: return
    //   182: astore_1
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   196: aload_0
    //   197: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   200: astore_2
    //   201: aload_2
    //   202: ifnull +37 -> 239
    //   205: aload_0
    //   206: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   209: aload_2
    //   210: if_acmpeq +29 -> 239
    //   213: aload_0
    //   214: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   217: aload_2
    //   218: invokeinterface 741 2 0
    //   223: aload_0
    //   224: aconst_null
    //   225: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   228: goto +11 -> 239
    //   231: astore_1
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   237: aload_1
    //   238: athrow
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: aload_0
    //   243: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   246: invokevirtual 791	android/media/MediaCodec:release	()V
    //   249: aload_0
    //   250: aconst_null
    //   251: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   254: aload_0
    //   255: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   258: astore_2
    //   259: aload_2
    //   260: ifnull +37 -> 297
    //   263: aload_0
    //   264: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   267: aload_2
    //   268: if_acmpeq +29 -> 297
    //   271: aload_0
    //   272: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   275: aload_2
    //   276: invokeinterface 741 2 0
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   286: goto +11 -> 297
    //   289: astore_1
    //   290: aload_0
    //   291: aconst_null
    //   292: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   295: aload_1
    //   296: athrow
    //   297: aload_1
    //   298: athrow
    //   299: astore_1
    //   300: aload_0
    //   301: aconst_null
    //   302: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   305: aload_0
    //   306: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   309: astore_2
    //   310: aload_2
    //   311: ifnull +37 -> 348
    //   314: aload_0
    //   315: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   318: aload_2
    //   319: if_acmpeq +29 -> 348
    //   322: aload_0
    //   323: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   326: aload_2
    //   327: invokeinterface 741 2 0
    //   332: aload_0
    //   333: aconst_null
    //   334: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   337: goto +11 -> 348
    //   340: astore_1
    //   341: aload_0
    //   342: aconst_null
    //   343: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   346: aload_1
    //   347: athrow
    //   348: aload_1
    //   349: athrow
    //   350: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	MediaCodecRenderer
    //   119	52	1	localObject1	Object
    //   182	7	1	localObject2	Object
    //   190	1	1	localObject3	Object
    //   231	9	1	localObject4	Object
    //   241	1	1	localObject5	Object
    //   289	9	1	localObject6	Object
    //   299	1	1	localObject7	Object
    //   340	9	1	localObject8	Object
    //   200	127	2	localDrmSession	DrmSession
    // Exception table:
    //   from	to	target	type
    //   166	176	182	finally
    //   137	144	190	finally
    //   213	223	231	finally
    //   130	137	241	finally
    //   271	281	289	finally
    //   242	249	299	finally
    //   322	332	340	finally
  }
  
  public void render(long paramLong1, long paramLong2)
  {
    if (this.outputStreamEnded)
    {
      renderToEndOfStream();
      return;
    }
    int i;
    if (this.format == null)
    {
      this.flagsOnlyBuffer.clear();
      i = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
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
    maybeInitCodec();
    if (this.codec != null)
    {
      TraceUtil.beginSection("drainAndFeed");
      while (drainOutputBuffer(paramLong1, paramLong2)) {}
      while (feedInputBuffer()) {}
      TraceUtil.endSection();
    }
    else
    {
      DecoderCounters localDecoderCounters = this.decoderCounters;
      localDecoderCounters.skippedInputBufferCount += skipSource(paramLong1);
      this.flagsOnlyBuffer.clear();
      i = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
      if (i == -5)
      {
        onInputFormatChanged(this.formatHolder.format);
      }
      else if (i == -4)
      {
        Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
        this.inputStreamEnded = true;
        processEndOfStream();
      }
    }
    this.decoderCounters.ensureUpdated();
  }
  
  protected void renderToEndOfStream() {}
  
  protected boolean shouldInitCodec(MediaCodecInfo paramMediaCodecInfo)
  {
    return true;
  }
  
  public final int supportsFormat(Format paramFormat)
  {
    try
    {
      int i = supportsFormat(this.mediaCodecSelector, this.drmSessionManager, paramFormat);
      return i;
    }
    catch (MediaCodecUtil.DecoderQueryException paramFormat)
    {
      throw ExoPlaybackException.createForRenderer(paramFormat, getIndex());
    }
  }
  
  protected abstract int supportsFormat(MediaCodecSelector paramMediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, Format paramFormat);
  
  public final int supportsMixedMimeTypeAdaptation()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
 * JD-Core Version:    0.7.0.1
 */