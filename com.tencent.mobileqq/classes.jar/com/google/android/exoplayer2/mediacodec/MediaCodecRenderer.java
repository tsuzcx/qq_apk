package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
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
    if (Util.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
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
      return;
    }
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
    int i;
    if (!hasOutputBuffer())
    {
      if ((this.codecNeedsEosOutputExceptionWorkaround) && (this.codecReceivedEos)) {}
      for (;;)
      {
        try
        {
          i = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
          if (i < 0) {
            break label290;
          }
          if (!this.shouldSkipAdaptationWorkaroundOutputBuffer) {
            break;
          }
          this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
          this.codec.releaseOutputBuffer(i, false);
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          processEndOfStream();
          if (this.outputStreamEnded) {}
          try
          {
            releaseCodec();
            return false;
          }
          catch (Exception localException1)
          {
            return false;
          }
        }
        try
        {
          i = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
        }
        catch (Exception localException2)
        {
          try
          {
            releaseCodec();
            return false;
          }
          catch (Exception localException3)
          {
            return false;
          }
        }
      }
      if ((this.outputBufferInfo.flags & 0x4) != 0)
      {
        processEndOfStream();
        return false;
      }
      this.outputIndex = i;
      this.outputBuffer = getOutputBuffer(i);
      if (this.outputBuffer != null)
      {
        this.outputBuffer.position(this.outputBufferInfo.offset);
        this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
      }
      this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
    }
    if ((this.codecNeedsEosOutputExceptionWorkaround) && (this.codecReceivedEos)) {}
    for (;;)
    {
      try
      {
        bool = processOutputBuffer(paramLong1, paramLong2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
        if (!bool) {
          break;
        }
        onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
        resetOutputBuffer();
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label290:
        processEndOfStream();
        if (!this.outputStreamEnded) {
          continue;
        }
        releaseCodec();
        return false;
      }
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
      boolean bool = processOutputBuffer(paramLong1, paramLong2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
    }
    return false;
  }
  
  /* Error */
  private boolean feedInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   4: ifnull +18 -> 22
    //   7: aload_0
    //   8: getfield 159	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReinitializationState	I
    //   11: iconst_2
    //   12: if_icmpeq +10 -> 22
    //   15: aload_0
    //   16: getfield 348	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputStreamEnded	Z
    //   19: ifeq +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   28: ifge +44 -> 72
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   36: lconst_0
    //   37: invokevirtual 359	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   40: putfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   43: aload_0
    //   44: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   47: iflt -25 -> 22
    //   50: aload_0
    //   51: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   59: invokespecial 362	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   62: putfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   65: aload_0
    //   66: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   69: invokevirtual 368	com/google/android/exoplayer2/decoder/DecoderInputBuffer:clear	()V
    //   72: aload_0
    //   73: getfield 159	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReinitializationState	I
    //   76: iconst_1
    //   77: if_icmpne +44 -> 121
    //   80: aload_0
    //   81: getfield 346	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsEosPropagationWorkaround	Z
    //   84: ifeq +10 -> 94
    //   87: aload_0
    //   88: iconst_2
    //   89: putfield 159	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReinitializationState	I
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 267	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedEos	Z
    //   99: aload_0
    //   100: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   103: aload_0
    //   104: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   107: iconst_0
    //   108: iconst_0
    //   109: lconst_0
    //   110: iconst_4
    //   111: invokevirtual 372	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   114: aload_0
    //   115: invokespecial 375	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetInputBuffer	()V
    //   118: goto -31 -> 87
    //   121: aload_0
    //   122: getfield 377	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsAdaptationWorkaroundBuffer	Z
    //   125: ifeq +51 -> 176
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 377	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsAdaptationWorkaroundBuffer	Z
    //   133: aload_0
    //   134: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   137: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   140: getstatic 101	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:ADAPTATION_WORKAROUND_BUFFER	[B
    //   143: invokevirtual 381	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   146: pop
    //   147: aload_0
    //   148: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   151: aload_0
    //   152: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   155: iconst_0
    //   156: getstatic 101	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:ADAPTATION_WORKAROUND_BUFFER	[B
    //   159: arraylength
    //   160: lconst_0
    //   161: iconst_0
    //   162: invokevirtual 372	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   165: aload_0
    //   166: invokespecial 375	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetInputBuffer	()V
    //   169: aload_0
    //   170: iconst_1
    //   171: putfield 383	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedBuffers	Z
    //   174: iconst_1
    //   175: ireturn
    //   176: aload_0
    //   177: getfield 385	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForKeys	Z
    //   180: ifeq +53 -> 233
    //   183: bipush 252
    //   185: istore_2
    //   186: iconst_0
    //   187: istore_1
    //   188: iload_2
    //   189: bipush 253
    //   191: if_icmpeq -169 -> 22
    //   194: iload_2
    //   195: bipush 251
    //   197: if_icmpne +133 -> 330
    //   200: aload_0
    //   201: getfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   204: iconst_2
    //   205: if_icmpne +15 -> 220
    //   208: aload_0
    //   209: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   212: invokevirtual 368	com/google/android/exoplayer2/decoder/DecoderInputBuffer:clear	()V
    //   215: aload_0
    //   216: iconst_1
    //   217: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 145	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:formatHolder	Lcom/google/android/exoplayer2/FormatHolder;
    //   225: getfield 387	com/google/android/exoplayer2/FormatHolder:format	Lcom/google/android/exoplayer2/Format;
    //   228: invokevirtual 391	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:onInputFormatChanged	(Lcom/google/android/exoplayer2/Format;)V
    //   231: iconst_1
    //   232: ireturn
    //   233: aload_0
    //   234: getfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   237: iconst_1
    //   238: if_icmpne +64 -> 302
    //   241: iconst_0
    //   242: istore_1
    //   243: iload_1
    //   244: aload_0
    //   245: getfield 392	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:format	Lcom/google/android/exoplayer2/Format;
    //   248: getfield 207	com/google/android/exoplayer2/Format:initializationData	Ljava/util/List;
    //   251: invokeinterface 395 1 0
    //   256: if_icmpge +41 -> 297
    //   259: aload_0
    //   260: getfield 392	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:format	Lcom/google/android/exoplayer2/Format;
    //   263: getfield 207	com/google/android/exoplayer2/Format:initializationData	Ljava/util/List;
    //   266: iload_1
    //   267: invokeinterface 399 2 0
    //   272: checkcast 400	[B
    //   275: astore 6
    //   277: aload_0
    //   278: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   281: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   284: aload 6
    //   286: invokevirtual 381	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   289: pop
    //   290: iload_1
    //   291: iconst_1
    //   292: iadd
    //   293: istore_1
    //   294: goto -51 -> 243
    //   297: aload_0
    //   298: iconst_2
    //   299: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   302: aload_0
    //   303: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   306: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   309: invokevirtual 402	java/nio/ByteBuffer:position	()I
    //   312: istore_1
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 145	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:formatHolder	Lcom/google/android/exoplayer2/FormatHolder;
    //   318: aload_0
    //   319: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   322: iconst_0
    //   323: invokevirtual 406	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:readSource	(Lcom/google/android/exoplayer2/FormatHolder;Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;Z)I
    //   326: istore_2
    //   327: goto -139 -> 188
    //   330: aload_0
    //   331: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   334: invokevirtual 409	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isEndOfStream	()Z
    //   337: ifeq +86 -> 423
    //   340: aload_0
    //   341: getfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   344: iconst_2
    //   345: if_icmpne +15 -> 360
    //   348: aload_0
    //   349: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   352: invokevirtual 368	com/google/android/exoplayer2/decoder/DecoderInputBuffer:clear	()V
    //   355: aload_0
    //   356: iconst_1
    //   357: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   360: aload_0
    //   361: iconst_1
    //   362: putfield 348	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputStreamEnded	Z
    //   365: aload_0
    //   366: getfield 383	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedBuffers	Z
    //   369: ifne +9 -> 378
    //   372: aload_0
    //   373: invokespecial 288	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:processEndOfStream	()V
    //   376: iconst_0
    //   377: ireturn
    //   378: aload_0
    //   379: getfield 346	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsEosPropagationWorkaround	Z
    //   382: ifne -360 -> 22
    //   385: aload_0
    //   386: iconst_1
    //   387: putfield 267	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedEos	Z
    //   390: aload_0
    //   391: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   394: aload_0
    //   395: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   398: iconst_0
    //   399: iconst_0
    //   400: lconst_0
    //   401: iconst_4
    //   402: invokevirtual 372	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   405: aload_0
    //   406: invokespecial 375	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetInputBuffer	()V
    //   409: iconst_0
    //   410: ireturn
    //   411: astore 6
    //   413: aload 6
    //   415: aload_0
    //   416: invokevirtual 412	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getIndex	()I
    //   419: invokestatic 418	com/google/android/exoplayer2/ExoPlaybackException:createForRenderer	(Ljava/lang/Exception;I)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   422: athrow
    //   423: aload_0
    //   424: getfield 420	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForFirstSyncFrame	Z
    //   427: ifeq +35 -> 462
    //   430: aload_0
    //   431: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   434: invokevirtual 423	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isKeyFrame	()Z
    //   437: ifne +25 -> 462
    //   440: aload_0
    //   441: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   444: invokevirtual 368	com/google/android/exoplayer2/decoder/DecoderInputBuffer:clear	()V
    //   447: aload_0
    //   448: getfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   451: iconst_2
    //   452: if_icmpne +8 -> 460
    //   455: aload_0
    //   456: iconst_1
    //   457: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   460: iconst_1
    //   461: ireturn
    //   462: aload_0
    //   463: iconst_0
    //   464: putfield 420	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForFirstSyncFrame	Z
    //   467: aload_0
    //   468: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   471: invokevirtual 426	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isEncrypted	()Z
    //   474: istore_3
    //   475: aload_0
    //   476: aload_0
    //   477: iload_3
    //   478: invokespecial 430	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:shouldWaitForKeys	(Z)Z
    //   481: putfield 385	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForKeys	Z
    //   484: aload_0
    //   485: getfield 385	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:waitingForKeys	Z
    //   488: ifne -466 -> 22
    //   491: aload_0
    //   492: getfield 432	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsDiscardToSpsWorkaround	Z
    //   495: ifeq +37 -> 532
    //   498: iload_3
    //   499: ifne +33 -> 532
    //   502: aload_0
    //   503: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   506: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   509: invokestatic 438	com/google/android/exoplayer2/util/NalUnitUtil:discardToSps	(Ljava/nio/ByteBuffer;)V
    //   512: aload_0
    //   513: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   516: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   519: invokevirtual 402	java/nio/ByteBuffer:position	()I
    //   522: ifne +5 -> 527
    //   525: iconst_1
    //   526: ireturn
    //   527: aload_0
    //   528: iconst_0
    //   529: putfield 432	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsDiscardToSpsWorkaround	Z
    //   532: aload_0
    //   533: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   536: getfield 441	com/google/android/exoplayer2/decoder/DecoderInputBuffer:timeUs	J
    //   539: lstore 4
    //   541: aload_0
    //   542: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   545: invokevirtual 444	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isDecodeOnly	()Z
    //   548: ifeq +18 -> 566
    //   551: aload_0
    //   552: getfield 150	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:decodeOnlyPresentationTimestamps	Ljava/util/List;
    //   555: lload 4
    //   557: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   560: invokeinterface 453 2 0
    //   565: pop
    //   566: aload_0
    //   567: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   570: invokevirtual 456	com/google/android/exoplayer2/decoder/DecoderInputBuffer:flip	()V
    //   573: aload_0
    //   574: aload_0
    //   575: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   578: invokevirtual 460	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:onQueueInputBuffer	(Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;)V
    //   581: iload_3
    //   582: ifeq +64 -> 646
    //   585: aload_0
    //   586: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   589: iload_1
    //   590: invokestatic 464	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getFrameworkCryptoInfo	(Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;I)Landroid/media/MediaCodec$CryptoInfo;
    //   593: astore 6
    //   595: aload_0
    //   596: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   599: aload_0
    //   600: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   603: iconst_0
    //   604: aload 6
    //   606: lload 4
    //   608: iconst_0
    //   609: invokevirtual 468	android/media/MediaCodec:queueSecureInputBuffer	(IILandroid/media/MediaCodec$CryptoInfo;JI)V
    //   612: aload_0
    //   613: invokespecial 375	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetInputBuffer	()V
    //   616: aload_0
    //   617: iconst_1
    //   618: putfield 383	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReceivedBuffers	Z
    //   621: aload_0
    //   622: iconst_0
    //   623: putfield 157	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigurationState	I
    //   626: aload_0
    //   627: getfield 470	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
    //   630: astore 6
    //   632: aload 6
    //   634: aload 6
    //   636: getfield 475	com/google/android/exoplayer2/decoder/DecoderCounters:inputBufferCount	I
    //   639: iconst_1
    //   640: iadd
    //   641: putfield 475	com/google/android/exoplayer2/decoder/DecoderCounters:inputBufferCount	I
    //   644: iconst_1
    //   645: ireturn
    //   646: aload_0
    //   647: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   650: aload_0
    //   651: getfield 355	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:inputIndex	I
    //   654: iconst_0
    //   655: aload_0
    //   656: getfield 133	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:buffer	Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;
    //   659: getfield 365	com/google/android/exoplayer2/decoder/DecoderInputBuffer:data	Ljava/nio/ByteBuffer;
    //   662: invokevirtual 477	java/nio/ByteBuffer:limit	()I
    //   665: lload 4
    //   667: iconst_0
    //   668: invokevirtual 372	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   671: goto -59 -> 612
    //   674: astore 6
    //   676: aload 6
    //   678: aload_0
    //   679: invokevirtual 412	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getIndex	()I
    //   682: invokestatic 418	com/google/android/exoplayer2/ExoPlaybackException:createForRenderer	(Ljava/lang/Exception;I)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   685: athrow
    //   686: astore 6
    //   688: aload 6
    //   690: aload_0
    //   691: invokevirtual 412	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getIndex	()I
    //   694: invokestatic 418	com/google/android/exoplayer2/ExoPlaybackException:createForRenderer	(Ljava/lang/Exception;I)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   697: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	MediaCodecRenderer
    //   187	403	1	i	int
    //   185	142	2	j	int
    //   474	108	3	bool	boolean
    //   539	127	4	l	long
    //   275	10	6	arrayOfByte	byte[]
    //   411	3	6	localCryptoException1	android.media.MediaCodec.CryptoException
    //   593	42	6	localObject	Object
    //   674	3	6	localCryptoException2	android.media.MediaCodec.CryptoException
    //   686	3	6	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   378	409	411	android/media/MediaCodec$CryptoException
    //   532	566	674	android/media/MediaCodec$CryptoException
    //   566	581	674	android/media/MediaCodec$CryptoException
    //   585	612	674	android/media/MediaCodec$CryptoException
    //   612	644	674	android/media/MediaCodec$CryptoException
    //   646	671	674	android/media/MediaCodec$CryptoException
    //   532	566	686	java/lang/RuntimeException
    //   566	581	686	java/lang/RuntimeException
    //   585	612	686	java/lang/RuntimeException
    //   612	644	686	java/lang/RuntimeException
    //   646	671	686	java/lang/RuntimeException
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
    if (this.codecInfo == null) {}
    try
    {
      this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, paramBoolean1, paramBoolean2);
      if ((this.codecInfo == null) && (paramBoolean1))
      {
        this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, false, paramBoolean2);
        if (this.codecInfo != null) {
          Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + paramString + ", but no secure decoder available. Trying to proceed with " + this.codecInfo.name + ".");
        }
      }
    }
    catch (MediaCodecUtil.DecoderQueryException paramString)
    {
      for (;;)
      {
        throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, paramString, paramBoolean1, -49998));
      }
    }
    if (this.codecInfo == null) {
      throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, null, paramBoolean1, -49999));
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
    if ((this.codecNeedsFlushWorkaround) || ((this.codecNeedsEosFlushWorkaround) && (this.codecReceivedEos)))
    {
      releaseCodec();
      maybeInitCodec();
    }
    for (;;)
    {
      if ((this.codecReconfigured) && (this.format != null)) {
        this.codecReconfigurationState = 1;
      }
      return;
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
    if ((this.codec != null) || (this.format == null)) {}
    String str;
    Object localObject;
    do
    {
      return;
      this.drmSession = this.pendingDrmSession;
      str = this.format.sampleMimeType;
      if (this.drmSession == null) {
        break label562;
      }
      localObject = (FrameworkMediaCrypto)this.drmSession.getMediaCrypto();
      if (localObject != null) {
        break;
      }
    } while (this.drmSession.getError() == null);
    boolean bool1 = false;
    MediaCrypto localMediaCrypto = null;
    for (;;)
    {
      label75:
      int i = 0;
      label77:
      if (i < 2) {
        if (i != 1) {
          break label465;
        }
      }
      label465:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (i > 0) {
          this.codecInfo = null;
        }
        initMediaCodecInfo(str, bool1, bool2);
        if (!shouldInitCodec(this.codecInfo)) {
          break;
        }
        localObject = this.codecInfo.name;
        this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode((String)localObject);
        this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround((String)localObject, this.format);
        this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround((String)localObject);
        this.codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround((String)localObject);
        this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround((String)localObject);
        this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround((String)localObject);
        this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround((String)localObject, this.format);
        try
        {
          l1 = SystemClock.elapsedRealtime();
          TraceUtil.beginSection("createCodec:" + (String)localObject);
          Log.i("MediaCodecRenderer", "createCodec: " + str + ", " + (String)localObject);
          this.codec = MediaCodec.createByCodecName((String)localObject);
          TraceUtil.endSection();
          TraceUtil.beginSection("configureCodec:" + (String)localObject);
          configureCodec(this.codecInfo, this.codec, this.format, localMediaCrypto);
          TraceUtil.endSection();
          TraceUtil.beginSection("startCodec:" + (String)localObject);
          this.codec.start();
          TraceUtil.endSection();
          long l2 = SystemClock.elapsedRealtime();
          onCodecInitialized((String)localObject, l2, l2 - l1);
          getCodecBuffers();
          j = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (i >= 1) {
              throwDecoderInitError(new MediaCodecRenderer.DecoderInitializationException(this.format, localException, bool1, (String)localObject));
            }
            Log.w("MediaCodecRenderer", "decoder creation for " + str + " failed," + this.codecInfo.name + ".", localException);
            int j = 1;
            continue;
            long l1 = -9223372036854775807L;
          }
        }
        if (getState() != 2) {
          break label554;
        }
        l1 = SystemClock.elapsedRealtime() + 1000L;
        this.codecHotswapDeadlineMs = l1;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForFirstSyncFrame = true;
        localObject = this.decoderCounters;
        ((DecoderCounters)localObject).decoderInitCount += 1;
        if (j == 0) {
          break;
        }
        i += 1;
        break label77;
        break;
        localMediaCrypto = ((FrameworkMediaCrypto)localObject).getWrappedMediaCrypto();
        bool1 = ((FrameworkMediaCrypto)localObject).requiresSecureDecoderComponent(str);
        break label75;
      }
      label554:
      label562:
      bool1 = false;
      localMediaCrypto = null;
    }
  }
  
  protected void onCodecInitialized(String paramString, long paramLong1, long paramLong2) {}
  
  /* Error */
  public void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 392	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:format	Lcom/google/android/exoplayer2/Format;
    //   5: aload_0
    //   6: invokevirtual 293	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:releaseCodec	()V
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
  
  public void onEnabled(boolean paramBoolean)
  {
    this.decoderCounters = new DecoderCounters();
  }
  
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
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.format.drmInitData == null) {
          break label244;
        }
        if (this.drmSessionManager == null)
        {
          throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
          paramFormat = localFormat.drmInitData;
          break;
          label86:
          i = 0;
          continue;
        }
        this.pendingDrmSession = this.drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
        if (this.pendingDrmSession == this.drmSession) {
          this.drmSessionManager.releaseSession(this.pendingDrmSession);
        }
      }
    }
    if ((this.pendingDrmSession == this.drmSession) && (this.codec != null) && (canReconfigureCodec(this.codec, this.codecInfo.adaptive, localFormat, this.format)))
    {
      this.codecReconfigured = true;
      this.codecReconfigurationState = 1;
      if ((this.codecAdaptationWorkaroundMode == 2) || ((this.codecAdaptationWorkaroundMode == 1) && (this.format.width == localFormat.width) && (this.format.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.codecNeedsAdaptationWorkaroundBuffer = bool;
        return;
        label244:
        this.pendingDrmSession = null;
        break;
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
  
  public void onPositionReset(long paramLong, boolean paramBoolean)
  {
    this.inputStreamEnded = false;
    this.outputStreamEnded = false;
    if (this.codec != null) {
      flushCodec();
    }
  }
  
  protected void onProcessedOutputBuffer(long paramLong) {}
  
  protected void onQueueInputBuffer(DecoderInputBuffer paramDecoderInputBuffer) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
  
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
    //   12: invokespecial 338	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:resetOutputBuffer	()V
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
    //   45: putfield 617	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecReconfigured	Z
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
    //   70: putfield 346	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codecNeedsEosPropagationWorkaround	Z
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
    //   90: putfield 281	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:shouldSkipAdaptationWorkaroundOutputBuffer	Z
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
    //   112: ifnull +73 -> 185
    //   115: aload_0
    //   116: getfield 470	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:decoderCounters	Lcom/google/android/exoplayer2/decoder/DecoderCounters;
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
    //   153: ifnull +32 -> 185
    //   156: aload_0
    //   157: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   160: aload_0
    //   161: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   164: if_acmpeq +21 -> 185
    //   167: aload_0
    //   168: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   171: aload_0
    //   172: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   175: invokeinterface 741 2 0
    //   180: aload_0
    //   181: aconst_null
    //   182: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: aconst_null
    //   197: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   200: aload_0
    //   201: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   204: ifnull +32 -> 236
    //   207: aload_0
    //   208: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   211: aload_0
    //   212: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   215: if_acmpeq +21 -> 236
    //   218: aload_0
    //   219: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   222: aload_0
    //   223: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   226: invokeinterface 741 2 0
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   244: aload_1
    //   245: athrow
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   251: invokevirtual 791	android/media/MediaCodec:release	()V
    //   254: aload_0
    //   255: aconst_null
    //   256: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   259: aload_0
    //   260: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   263: ifnull +32 -> 295
    //   266: aload_0
    //   267: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   270: aload_0
    //   271: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   274: if_acmpeq +21 -> 295
    //   277: aload_0
    //   278: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   281: aload_0
    //   282: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   285: invokeinterface 741 2 0
    //   290: aload_0
    //   291: aconst_null
    //   292: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   295: aload_1
    //   296: athrow
    //   297: astore_1
    //   298: aload_0
    //   299: aconst_null
    //   300: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: aload_0
    //   307: aconst_null
    //   308: putfield 269	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:codec	Landroid/media/MediaCodec;
    //   311: aload_0
    //   312: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   315: ifnull +32 -> 347
    //   318: aload_0
    //   319: getfield 650	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:pendingDrmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   322: aload_0
    //   323: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   326: if_acmpeq +21 -> 347
    //   329: aload_0
    //   330: getfield 126	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSessionManager	Lcom/google/android/exoplayer2/drm/DrmSessionManager;
    //   333: aload_0
    //   334: getfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   337: invokeinterface 741 2 0
    //   342: aload_0
    //   343: aconst_null
    //   344: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   347: aload_1
    //   348: athrow
    //   349: astore_1
    //   350: aload_0
    //   351: aconst_null
    //   352: putfield 592	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:drmSession	Lcom/google/android/exoplayer2/drm/DrmSession;
    //   355: aload_1
    //   356: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	MediaCodecRenderer
    //   119	3	1	localDecoderCounters	DecoderCounters
    //   186	7	1	localObject1	Object
    //   194	43	1	localObject2	Object
    //   238	7	1	localObject3	Object
    //   246	50	1	localObject4	Object
    //   297	7	1	localObject5	Object
    //   305	43	1	localObject6	Object
    //   349	7	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   167	180	186	finally
    //   137	144	194	finally
    //   218	231	238	finally
    //   130	137	246	finally
    //   277	290	297	finally
    //   247	254	305	finally
    //   329	342	349	finally
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
      if (i == -5) {
        onInputFormatChanged(this.formatHolder.format);
      }
    }
    else
    {
      maybeInitCodec();
      if (this.codec == null) {
        break label130;
      }
      TraceUtil.beginSection("drainAndFeed");
      while (drainOutputBuffer(paramLong1, paramLong2)) {}
      while (feedInputBuffer()) {}
      TraceUtil.endSection();
    }
    for (;;)
    {
      this.decoderCounters.ensureUpdated();
      return;
      if (i != -4) {
        break;
      }
      Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
      this.inputStreamEnded = true;
      processEndOfStream();
      return;
      label130:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
 * JD-Core Version:    0.7.0.1
 */