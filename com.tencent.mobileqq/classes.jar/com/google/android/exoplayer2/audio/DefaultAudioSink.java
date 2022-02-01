package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class DefaultAudioSink
  implements AudioSink
{
  private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
  private static final int ERROR_BAD_VALUE = -2;
  private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000L;
  private static final long MAX_BUFFER_DURATION_US = 750000L;
  private static final long MAX_LATENCY_US = 5000000L;
  private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
  private static final long MIN_BUFFER_DURATION_US = 250000L;
  private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
  private static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 500000;
  private static final int MODE_STATIC = 0;
  private static final int MODE_STREAM = 1;
  private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000L;
  private static final int PLAYSTATE_PAUSED = 2;
  private static final int PLAYSTATE_PLAYING = 3;
  private static final int PLAYSTATE_STOPPED = 1;
  private static final int START_IN_SYNC = 1;
  private static final int START_NEED_SYNC = 2;
  private static final int START_NOT_SET = 0;
  private static final int STATE_INITIALIZED = 1;
  private static final String TAG = "AudioTrack";
  @SuppressLint({"InlinedApi"})
  private static final int WRITE_NON_BLOCKING = 1;
  public static boolean enablePreV21AudioSessionWorkaround = false;
  public static boolean failOnSpuriousAudioTimestamp = false;
  private AudioAttributes audioAttributes;
  @Nullable
  private final AudioCapabilities audioCapabilities;
  private AudioProcessor[] audioProcessors;
  private int audioSessionId;
  private boolean audioTimestampSet;
  private AudioTrack audioTrack;
  private final DefaultAudioSink.AudioTrackUtil audioTrackUtil;
  private ByteBuffer avSyncHeader;
  private int bufferSize;
  private long bufferSizeUs;
  private int bytesUntilNextAvSync;
  private boolean canApplyPlaybackParameters;
  private int channelConfig;
  private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
  private int drainingAudioProcessorIndex;
  private PlaybackParameters drainingPlaybackParameters;
  private final boolean enableConvertHighResIntPcmToFloat;
  private int framesPerEncodedSample;
  private Method getLatencyMethod;
  private boolean handledEndOfStream;
  private boolean hasData;
  private ByteBuffer inputBuffer;
  private int inputSampleRate;
  private boolean isInputPcm;
  private AudioTrack keepSessionIdAudioTrack;
  private long lastFeedElapsedRealtimeMs;
  private long lastPlayheadSampleTimeUs;
  private long lastTimestampSampleTimeUs;
  private long latencyUs;
  @Nullable
  private AudioSink.Listener listener;
  private int nextPlayheadOffsetIndex;
  private ByteBuffer outputBuffer;
  private ByteBuffer[] outputBuffers;
  private int outputEncoding;
  private int outputPcmFrameSize;
  private int pcmFrameSize;
  private PlaybackParameters playbackParameters;
  private final ArrayDeque<DefaultAudioSink.PlaybackParametersCheckpoint> playbackParametersCheckpoints;
  private long playbackParametersOffsetUs;
  private long playbackParametersPositionUs;
  private int playheadOffsetCount;
  private final long[] playheadOffsets;
  private boolean playing;
  private byte[] preV21OutputBuffer;
  private int preV21OutputBufferOffset;
  private boolean processingEnabled;
  private final ConditionVariable releasingConditionVariable;
  private long resumeSystemTimeUs;
  private int sampleRate;
  private boolean shouldConvertHighResIntPcmToFloat;
  private long smoothedPlayheadOffsetUs;
  private final SonicAudioProcessor sonicAudioProcessor;
  private int startMediaTimeState;
  private long startMediaTimeUs;
  private long submittedEncodedFrames;
  private long submittedPcmBytes;
  private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
  private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
  private final TrimmingAudioProcessor trimmingAudioProcessor;
  private boolean tunneling;
  private float volume;
  private long writtenEncodedFrames;
  private long writtenPcmBytes;
  
  public DefaultAudioSink(@Nullable AudioCapabilities paramAudioCapabilities, AudioProcessor[] paramArrayOfAudioProcessor)
  {
    this(paramAudioCapabilities, paramArrayOfAudioProcessor, false);
  }
  
  public DefaultAudioSink(@Nullable AudioCapabilities paramAudioCapabilities, AudioProcessor[] paramArrayOfAudioProcessor, boolean paramBoolean)
  {
    this.audioCapabilities = paramAudioCapabilities;
    this.enableConvertHighResIntPcmToFloat = paramBoolean;
    this.releasingConditionVariable = new ConditionVariable(true);
    if (Util.SDK_INT >= 18) {}
    try
    {
      this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", (Class[])null);
      label49:
      if (Util.SDK_INT >= 19) {}
      for (this.audioTrackUtil = new DefaultAudioSink.AudioTrackUtilV19();; this.audioTrackUtil = new DefaultAudioSink.AudioTrackUtil(null))
      {
        this.channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.sonicAudioProcessor = new SonicAudioProcessor();
        this.toIntPcmAvailableAudioProcessors = new AudioProcessor[paramArrayOfAudioProcessor.length + 4];
        this.toIntPcmAvailableAudioProcessors[0] = new ResamplingAudioProcessor();
        this.toIntPcmAvailableAudioProcessors[1] = this.channelMappingAudioProcessor;
        this.toIntPcmAvailableAudioProcessors[2] = this.trimmingAudioProcessor;
        System.arraycopy(paramArrayOfAudioProcessor, 0, this.toIntPcmAvailableAudioProcessors, 3, paramArrayOfAudioProcessor.length);
        this.toIntPcmAvailableAudioProcessors[(paramArrayOfAudioProcessor.length + 3)] = this.sonicAudioProcessor;
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[] { new FloatResamplingAudioProcessor() };
        this.playheadOffsets = new long[10];
        this.volume = 1.0F;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.audioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new ArrayDeque();
        return;
      }
    }
    catch (NoSuchMethodException paramAudioCapabilities)
    {
      break label49;
    }
  }
  
  private long applySpeedup(long paramLong)
  {
    while ((!this.playbackParametersCheckpoints.isEmpty()) && (paramLong >= DefaultAudioSink.PlaybackParametersCheckpoint.access$400((DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getFirst())))
    {
      DefaultAudioSink.PlaybackParametersCheckpoint localPlaybackParametersCheckpoint = (DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.remove();
      this.playbackParameters = DefaultAudioSink.PlaybackParametersCheckpoint.access$200(localPlaybackParametersCheckpoint);
      this.playbackParametersPositionUs = DefaultAudioSink.PlaybackParametersCheckpoint.access$400(localPlaybackParametersCheckpoint);
      this.playbackParametersOffsetUs = (DefaultAudioSink.PlaybackParametersCheckpoint.access$500(localPlaybackParametersCheckpoint) - this.startMediaTimeUs);
    }
    if (this.playbackParameters.speed == 1.0F) {
      return this.playbackParametersOffsetUs + paramLong - this.playbackParametersPositionUs;
    }
    if (this.playbackParametersCheckpoints.isEmpty()) {
      return this.playbackParametersOffsetUs + this.sonicAudioProcessor.scaleDurationForSpeedup(paramLong - this.playbackParametersPositionUs);
    }
    return this.playbackParametersOffsetUs + Util.getMediaDurationForPlayoutDuration(paramLong - this.playbackParametersPositionUs, this.playbackParameters.speed);
  }
  
  @TargetApi(21)
  private AudioTrack createAudioTrackV21()
  {
    android.media.AudioAttributes localAudioAttributes;
    AudioFormat localAudioFormat;
    if (this.tunneling)
    {
      localAudioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.outputEncoding).setSampleRate(this.sampleRate).build();
      if (this.audioSessionId == 0) {
        break label102;
      }
    }
    label102:
    for (int i = this.audioSessionId;; i = 0)
    {
      return new AudioTrack(localAudioAttributes, localAudioFormat, this.bufferSize, 1, i);
      localAudioAttributes = this.audioAttributes.getAudioAttributesV21();
      break;
    }
  }
  
  private boolean drainAudioProcessorsToEndOfStream()
  {
    int i;
    if (this.drainingAudioProcessorIndex == -1) {
      if (this.processingEnabled)
      {
        i = 0;
        this.drainingAudioProcessorIndex = i;
        i = 1;
      }
    }
    for (;;)
    {
      label24:
      if (this.drainingAudioProcessorIndex < this.audioProcessors.length)
      {
        AudioProcessor localAudioProcessor = this.audioProcessors[this.drainingAudioProcessorIndex];
        if (i != 0) {
          localAudioProcessor.queueEndOfStream();
        }
        processBuffers(-9223372036854775807L);
        if (localAudioProcessor.isEnded()) {}
      }
      do
      {
        return false;
        i = this.audioProcessors.length;
        break;
        this.drainingAudioProcessorIndex += 1;
        i = 1;
        break label24;
        if (this.outputBuffer == null) {
          break label123;
        }
        writeBuffer(this.outputBuffer, -9223372036854775807L);
      } while (this.outputBuffer != null);
      label123:
      this.drainingAudioProcessorIndex = -1;
      return true;
      i = 0;
    }
  }
  
  private long durationUsToFrames(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  private long framesToDurationUs(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  private AudioProcessor[] getAvailableAudioProcessors()
  {
    if (this.shouldConvertHighResIntPcmToFloat) {
      return this.toFloatPcmAvailableAudioProcessors;
    }
    return this.toIntPcmAvailableAudioProcessors;
  }
  
  private static int getFramesPerEncodedSample(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt == 7) || (paramInt == 8)) {
      return DtsUtil.parseDtsAudioSampleCount(paramByteBuffer);
    }
    if (paramInt == 5) {
      return Ac3Util.getAc3SyncframeAudioSampleCount();
    }
    if (paramInt == 6) {
      return Ac3Util.parseEAc3SyncframeAudioSampleCount(paramByteBuffer);
    }
    if (paramInt == 14) {
      return Ac3Util.parseTrueHdSyncframeAudioSampleCount(paramByteBuffer) * 8;
    }
    throw new IllegalStateException("Unexpected audio encoding: " + paramInt);
  }
  
  private long getSubmittedFrames()
  {
    if (this.isInputPcm) {
      return this.submittedPcmBytes / this.pcmFrameSize;
    }
    return this.submittedEncodedFrames;
  }
  
  private long getWrittenFrames()
  {
    if (this.isInputPcm) {
      return this.writtenPcmBytes / this.outputPcmFrameSize;
    }
    return this.writtenEncodedFrames;
  }
  
  private boolean hasCurrentPositionUs()
  {
    return (isInitialized()) && (this.startMediaTimeState != 0);
  }
  
  private void initialize()
  {
    this.releasingConditionVariable.block();
    this.audioTrack = initializeAudioTrack();
    setPlaybackParameters(this.playbackParameters);
    resetAudioProcessors();
    int i = this.audioTrack.getAudioSessionId();
    if ((enablePreV21AudioSessionWorkaround) && (Util.SDK_INT < 21))
    {
      if ((this.keepSessionIdAudioTrack != null) && (i != this.keepSessionIdAudioTrack.getAudioSessionId())) {
        releaseKeepSessionIdAudioTrack();
      }
      if (this.keepSessionIdAudioTrack == null) {
        this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(i);
      }
    }
    if (this.audioSessionId != i)
    {
      this.audioSessionId = i;
      if (this.listener != null) {
        this.listener.onAudioSessionId(i);
      }
    }
    this.audioTrackUtil.reconfigure(this.audioTrack, needsPassthroughWorkarounds());
    setVolumeInternal();
    this.hasData = false;
  }
  
  private AudioTrack initializeAudioTrack()
  {
    AudioTrack localAudioTrack;
    if (Util.SDK_INT >= 21) {
      localAudioTrack = createAudioTrackV21();
    }
    for (;;)
    {
      int i = localAudioTrack.getState();
      if (i != 1) {
        try
        {
          localAudioTrack.release();
          label27:
          throw new AudioSink.InitializationException(i, this.sampleRate, this.channelConfig, this.bufferSize);
          i = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
          if (this.audioSessionId == 0) {
            localAudioTrack = new AudioTrack(i, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1);
          } else {
            localAudioTrack = new AudioTrack(i, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1, this.audioSessionId);
          }
        }
        catch (Exception localException)
        {
          break label27;
        }
      }
    }
    return localException;
  }
  
  private AudioTrack initializeKeepSessionIdAudioTrack(int paramInt)
  {
    return new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt);
  }
  
  private long inputFramesToDurationUs(long paramLong)
  {
    return 1000000L * paramLong / this.inputSampleRate;
  }
  
  private static boolean isEncodingPcm(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 2) || (paramInt == -2147483648) || (paramInt == 1073741824) || (paramInt == 4);
  }
  
  private boolean isInitialized()
  {
    return this.audioTrack != null;
  }
  
  private void maybeSampleSyncParams()
  {
    long l1 = this.audioTrackUtil.getPositionUs();
    if (l1 == 0L) {}
    long l2;
    do
    {
      return;
      l2 = System.nanoTime() / 1000L;
      if (l2 - this.lastPlayheadSampleTimeUs >= 30000L)
      {
        this.playheadOffsets[this.nextPlayheadOffsetIndex] = (l1 - l2);
        this.nextPlayheadOffsetIndex = ((this.nextPlayheadOffsetIndex + 1) % 10);
        if (this.playheadOffsetCount < 10) {
          this.playheadOffsetCount += 1;
        }
        this.lastPlayheadSampleTimeUs = l2;
        this.smoothedPlayheadOffsetUs = 0L;
        int i = 0;
        while (i < this.playheadOffsetCount)
        {
          this.smoothedPlayheadOffsetUs += this.playheadOffsets[i] / this.playheadOffsetCount;
          i += 1;
        }
      }
    } while ((needsPassthroughWorkarounds()) || (l2 - this.lastTimestampSampleTimeUs < 500000L));
    this.audioTimestampSet = this.audioTrackUtil.updateTimestamp();
    long l3;
    long l4;
    if (this.audioTimestampSet)
    {
      l3 = this.audioTrackUtil.getTimestampNanoTime() / 1000L;
      l4 = this.audioTrackUtil.getTimestampFramePosition();
      if (l3 >= this.resumeSystemTimeUs) {
        break label321;
      }
      this.audioTimestampSet = false;
    }
    for (;;)
    {
      if ((this.getLatencyMethod != null) && (this.isInputPcm)) {}
      try
      {
        this.latencyUs = (((Integer)this.getLatencyMethod.invoke(this.audioTrack, (Object[])null)).intValue() * 1000L - this.bufferSizeUs);
        this.latencyUs = Math.max(this.latencyUs, 0L);
        if (this.latencyUs > 5000000L)
        {
          Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.latencyUs);
          this.latencyUs = 0L;
        }
        this.lastTimestampSampleTimeUs = l2;
        return;
        label321:
        if (Math.abs(l3 - l2) > 5000000L)
        {
          str = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + getSubmittedFrames() + ", " + getWrittenFrames();
          if (failOnSpuriousAudioTimestamp) {
            throw new DefaultAudioSink.InvalidAudioTrackTimestampException(str);
          }
          Log.w("AudioTrack", str);
          this.audioTimestampSet = false;
          continue;
        }
        if (Math.abs(framesToDurationUs(l4) - l1) <= 5000000L) {
          continue;
        }
        String str = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + getSubmittedFrames() + ", " + getWrittenFrames();
        if (failOnSpuriousAudioTimestamp) {
          throw new DefaultAudioSink.InvalidAudioTrackTimestampException(str);
        }
        Log.w("AudioTrack", str);
        this.audioTimestampSet = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.getLatencyMethod = null;
        }
      }
    }
  }
  
  private boolean needsPassthroughWorkarounds()
  {
    return (Util.SDK_INT < 23) && ((this.outputEncoding == 5) || (this.outputEncoding == 6));
  }
  
  private boolean overrideHasPendingData()
  {
    return (needsPassthroughWorkarounds()) && (this.audioTrack.getPlayState() == 2) && (this.audioTrack.getPlaybackHeadPosition() == 0);
  }
  
  private void processBuffers(long paramLong)
  {
    int j = this.audioProcessors.length;
    int i = j;
    for (;;)
    {
      ByteBuffer localByteBuffer;
      if (i >= 0)
      {
        if (i <= 0) {
          break label50;
        }
        localByteBuffer = this.outputBuffers[(i - 1)];
        label28:
        if (i != j) {
          break label74;
        }
        writeBuffer(localByteBuffer, paramLong);
      }
      for (;;)
      {
        if (localByteBuffer.hasRemaining())
        {
          return;
          label50:
          if (this.inputBuffer != null)
          {
            localByteBuffer = this.inputBuffer;
            break label28;
          }
          localByteBuffer = AudioProcessor.EMPTY_BUFFER;
          break label28;
          label74:
          Object localObject = this.audioProcessors[i];
          ((AudioProcessor)localObject).queueInput(localByteBuffer);
          localObject = ((AudioProcessor)localObject).getOutput();
          this.outputBuffers[i] = localObject;
          if (((ByteBuffer)localObject).hasRemaining())
          {
            i += 1;
            break;
          }
        }
      }
      i -= 1;
    }
  }
  
  private void releaseKeepSessionIdAudioTrack()
  {
    if (this.keepSessionIdAudioTrack == null) {
      return;
    }
    AudioTrack localAudioTrack = this.keepSessionIdAudioTrack;
    this.keepSessionIdAudioTrack = null;
    new DefaultAudioSink.2(this, localAudioTrack).start();
  }
  
  private void resetAudioProcessors()
  {
    Object localObject = new ArrayList();
    AudioProcessor[] arrayOfAudioProcessor = getAvailableAudioProcessors();
    int j = arrayOfAudioProcessor.length;
    int i = 0;
    if (i < j)
    {
      AudioProcessor localAudioProcessor = arrayOfAudioProcessor[i];
      if (localAudioProcessor.isActive()) {
        ((ArrayList)localObject).add(localAudioProcessor);
      }
      for (;;)
      {
        i += 1;
        break;
        localAudioProcessor.flush();
      }
    }
    j = ((ArrayList)localObject).size();
    this.audioProcessors = ((AudioProcessor[])((ArrayList)localObject).toArray(new AudioProcessor[j]));
    this.outputBuffers = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.audioProcessors[i];
      ((AudioProcessor)localObject).flush();
      this.outputBuffers[i] = ((AudioProcessor)localObject).getOutput();
      i += 1;
    }
  }
  
  private void resetSyncParams()
  {
    this.smoothedPlayheadOffsetUs = 0L;
    this.playheadOffsetCount = 0;
    this.nextPlayheadOffsetIndex = 0;
    this.lastPlayheadSampleTimeUs = 0L;
    this.audioTimestampSet = false;
    this.lastTimestampSampleTimeUs = 0L;
  }
  
  private void setVolumeInternal()
  {
    if (!isInitialized()) {
      return;
    }
    if (Util.SDK_INT >= 21)
    {
      setVolumeInternalV21(this.audioTrack, this.volume);
      return;
    }
    setVolumeInternalV3(this.audioTrack, this.volume);
  }
  
  @TargetApi(21)
  private static void setVolumeInternalV21(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setVolume(paramFloat);
  }
  
  private static void setVolumeInternalV3(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  private void writeBuffer(ByteBuffer paramByteBuffer, long paramLong)
  {
    boolean bool2 = true;
    int i = 0;
    if (!paramByteBuffer.hasRemaining()) {}
    label37:
    int j;
    label311:
    label465:
    do
    {
      return;
      boolean bool1;
      int k;
      byte[] arrayOfByte;
      if (this.outputBuffer != null) {
        if (this.outputBuffer == paramByteBuffer)
        {
          bool1 = true;
          Assertions.checkArgument(bool1);
          j = paramByteBuffer.remaining();
          if (Util.SDK_INT >= 21) {
            break label311;
          }
          k = (int)(this.writtenPcmBytes - this.audioTrackUtil.getPlaybackHeadPosition() * this.outputPcmFrameSize);
          k = this.bufferSize - k;
          if (k > 0)
          {
            i = Math.min(j, k);
            i = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, i);
            if ((this.listener != null) && (this.listener.isNeedAudioData()) && (i > 0))
            {
              arrayOfByte = new byte[i];
              k = paramByteBuffer.position();
              paramByteBuffer.get(arrayOfByte, 0, i);
              paramByteBuffer.position(k);
              this.listener.onRenderAudioData(arrayOfByte);
            }
            if (i > 0)
            {
              this.preV21OutputBufferOffset += i;
              paramByteBuffer.position(paramByteBuffer.position() + i);
            }
          }
        }
      }
      for (;;)
      {
        this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (i >= 0) {
          break label465;
        }
        throw new AudioSink.WriteException(i);
        bool1 = false;
        break;
        this.outputBuffer = paramByteBuffer;
        if (Util.SDK_INT >= 21) {
          break label37;
        }
        j = paramByteBuffer.remaining();
        if ((this.preV21OutputBuffer == null) || (this.preV21OutputBuffer.length < j)) {
          this.preV21OutputBuffer = new byte[j];
        }
        k = paramByteBuffer.position();
        paramByteBuffer.get(this.preV21OutputBuffer, 0, j);
        paramByteBuffer.position(k);
        this.preV21OutputBufferOffset = 0;
        break label37;
        if (this.tunneling)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool1 = bool2;; bool1 = false)
          {
            Assertions.checkState(bool1);
            i = writeNonBlockingWithAvSyncV21(this.audioTrack, paramByteBuffer, j, paramLong);
            break;
          }
        }
        if ((this.listener != null) && (this.listener.isNeedAudioData()))
        {
          k = paramByteBuffer.position();
          i = writeNonBlockingV21(this.audioTrack, paramByteBuffer, j);
          if (i > 0)
          {
            int m = paramByteBuffer.position();
            paramByteBuffer.position(k);
            arrayOfByte = new byte[i];
            paramByteBuffer.get(arrayOfByte, 0, i);
            paramByteBuffer.position(m);
            this.listener.onRenderAudioData(arrayOfByte);
          }
        }
        else
        {
          i = writeNonBlockingV21(this.audioTrack, paramByteBuffer, j);
        }
      }
      if (this.isInputPcm) {
        this.writtenPcmBytes += i;
      }
    } while (i != j);
    if (!this.isInputPcm) {
      this.writtenEncodedFrames += this.framesPerEncodedSample;
    }
    this.outputBuffer = null;
  }
  
  @TargetApi(21)
  private static int writeNonBlockingV21(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramAudioTrack.write(paramByteBuffer, paramInt, 1);
  }
  
  @TargetApi(21)
  private int writeNonBlockingWithAvSyncV21(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (this.avSyncHeader == null)
    {
      this.avSyncHeader = ByteBuffer.allocate(16);
      this.avSyncHeader.order(ByteOrder.BIG_ENDIAN);
      this.avSyncHeader.putInt(1431633921);
    }
    if (this.bytesUntilNextAvSync == 0)
    {
      this.avSyncHeader.putInt(4, paramInt);
      this.avSyncHeader.putLong(8, 1000L * paramLong);
      this.avSyncHeader.position(0);
      this.bytesUntilNextAvSync = paramInt;
    }
    int i = this.avSyncHeader.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.avSyncHeader, i, 1);
      if (j < 0)
      {
        this.bytesUntilNextAvSync = 0;
        return j;
      }
      if (j < i) {
        return 0;
      }
    }
    paramInt = writeNonBlockingV21(paramAudioTrack, paramByteBuffer, paramInt);
    if (paramInt < 0)
    {
      this.bytesUntilNextAvSync = 0;
      return paramInt;
    }
    this.bytesUntilNextAvSync -= paramInt;
    return paramInt;
  }
  
  public void configure(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5, int paramInt6)
  {
    this.inputSampleRate = paramInt3;
    this.isInputPcm = isEncodingPcm(paramInt1);
    boolean bool;
    if ((this.enableConvertHighResIntPcmToFloat) && (isEncodingSupported(1073741824)) && (Util.isEncodingHighResolutionIntegerPcm(paramInt1)))
    {
      bool = true;
      this.shouldConvertHighResIntPcmToFloat = bool;
      if (this.isInputPcm) {
        this.pcmFrameSize = Util.getPcmFrameSize(paramInt1, paramInt2);
      }
      if ((!this.isInputPcm) || (paramInt1 == 4)) {
        break label236;
      }
      bool = true;
      label77:
      if ((!bool) || (this.shouldConvertHighResIntPcmToFloat)) {
        break label242;
      }
    }
    label236:
    label242:
    for (int m = 1;; m = 0)
    {
      this.canApplyPlaybackParameters = m;
      if (!bool) {
        break label806;
      }
      this.trimmingAudioProcessor.setTrimSampleCount(paramInt5, paramInt6);
      this.channelMappingAudioProcessor.setChannelMap(paramArrayOfInt);
      paramArrayOfInt = getAvailableAudioProcessors();
      int k = paramArrayOfInt.length;
      paramInt6 = 0;
      int j = 0;
      paramInt5 = paramInt1;
      i = paramInt3;
      paramInt1 = j;
      paramInt3 = paramInt2;
      paramInt2 = i;
      while (paramInt6 < k)
      {
        int n = paramArrayOfInt[paramInt6];
        try
        {
          m = n.configure(paramInt2, paramInt3, paramInt5);
          if (n.isActive())
          {
            paramInt3 = n.getOutputChannelCount();
            paramInt2 = n.getOutputSampleRateHz();
            paramInt5 = n.getOutputEncoding();
          }
          paramInt6 += 1;
          paramInt1 = m | paramInt1;
        }
        catch (AudioProcessor.UnhandledFormatException paramArrayOfInt)
        {
          throw new AudioSink.ConfigurationException(paramArrayOfInt);
        }
      }
      bool = false;
      break;
      bool = false;
      break label77;
    }
    int i = paramInt5;
    paramInt6 = paramInt1;
    paramInt5 = paramInt3;
    paramInt3 = paramInt2;
    for (;;)
    {
      switch (paramInt5)
      {
      default: 
        throw new AudioSink.ConfigurationException("Unsupported channel count: " + paramInt5);
      case 1: 
        paramInt1 = 4;
        paramInt2 = paramInt1;
        if (Util.SDK_INT <= 23)
        {
          paramInt2 = paramInt1;
          if ("foster".equals(Util.DEVICE))
          {
            paramInt2 = paramInt1;
            if ("NVIDIA".equals(Util.MANUFACTURER))
            {
              paramInt2 = paramInt1;
              switch (paramInt5)
              {
              default: 
                paramInt2 = paramInt1;
              }
            }
          }
        }
        break;
      }
      for (;;)
      {
        paramInt1 = paramInt2;
        if (Util.SDK_INT <= 25)
        {
          paramInt1 = paramInt2;
          if ("fugu".equals(Util.DEVICE))
          {
            paramInt1 = paramInt2;
            if (!this.isInputPcm)
            {
              paramInt1 = paramInt2;
              if (paramInt5 == 1) {
                paramInt1 = 12;
              }
            }
          }
        }
        if ((paramInt6 != 0) || (!isInitialized()) || (this.outputEncoding != i) || (this.sampleRate != paramInt3) || (this.channelConfig != paramInt1)) {
          break label573;
        }
        return;
        paramInt1 = 12;
        break;
        paramInt1 = 28;
        break;
        paramInt1 = 204;
        break;
        paramInt1 = 220;
        break;
        paramInt1 = 252;
        break;
        paramInt1 = 1276;
        break;
        paramInt1 = C.CHANNEL_OUT_7POINT1_SURROUND;
        break;
        paramInt2 = C.CHANNEL_OUT_7POINT1_SURROUND;
        continue;
        paramInt2 = 252;
      }
      label573:
      reset();
      this.processingEnabled = bool;
      this.sampleRate = paramInt3;
      this.channelConfig = paramInt1;
      this.outputEncoding = i;
      if (this.isInputPcm) {
        this.outputPcmFrameSize = Util.getPcmFrameSize(this.outputEncoding, paramInt5);
      }
      if (paramInt4 != 0)
      {
        this.bufferSize = paramInt4;
        if (!this.isInputPcm) {
          break label798;
        }
      }
      label798:
      for (long l = framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);; l = -9223372036854775807L)
      {
        this.bufferSizeUs = l;
        return;
        if (this.isInputPcm)
        {
          paramInt1 = AudioTrack.getMinBufferSize(paramInt3, paramInt1, this.outputEncoding);
          if (paramInt1 != -2) {}
          for (bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            this.bufferSize = Util.constrainValue(paramInt1 * 4, (int)durationUsToFrames(250000L) * this.outputPcmFrameSize, (int)Math.max(paramInt1, durationUsToFrames(750000L) * this.outputPcmFrameSize));
            break;
          }
        }
        if ((this.outputEncoding == 5) || (this.outputEncoding == 6))
        {
          this.bufferSize = 20480;
          break;
        }
        if (this.outputEncoding == 7)
        {
          this.bufferSize = 49152;
          break;
        }
        this.bufferSize = 294912;
        break;
      }
      label806:
      paramInt6 = 0;
      paramInt5 = paramInt2;
      i = paramInt1;
    }
  }
  
  public void disableTunneling()
  {
    if (this.tunneling)
    {
      this.tunneling = false;
      this.audioSessionId = 0;
      reset();
    }
  }
  
  public void enableTunnelingV21(int paramInt)
  {
    if (Util.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if ((!this.tunneling) || (this.audioSessionId != paramInt))
      {
        this.tunneling = true;
        this.audioSessionId = paramInt;
        reset();
      }
      return;
    }
  }
  
  public long getCurrentPositionUs(boolean paramBoolean)
  {
    if (!hasCurrentPositionUs()) {
      return -9223372036854775808L;
    }
    if (this.audioTrack.getPlayState() == 3) {
      maybeSampleSyncParams();
    }
    long l1 = System.nanoTime() / 1000L;
    if (this.audioTimestampSet)
    {
      l1 = framesToDurationUs(durationUsToFrames(l1 - this.audioTrackUtil.getTimestampNanoTime() / 1000L) + this.audioTrackUtil.getTimestampFramePosition());
      l1 = Math.min(l1, framesToDurationUs(getWrittenFrames()));
      l2 = this.startMediaTimeUs;
      return applySpeedup(l1) + l2;
    }
    if (this.playheadOffsetCount == 0) {}
    for (long l2 = this.audioTrackUtil.getPositionUs();; l2 = l1 + this.smoothedPlayheadOffsetUs)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.latencyUs;
      break;
    }
  }
  
  public PlaybackParameters getPlaybackParameters()
  {
    return this.playbackParameters;
  }
  
  public boolean handleBuffer(ByteBuffer paramByteBuffer, long paramLong)
  {
    if ((this.inputBuffer == null) || (paramByteBuffer == this.inputBuffer)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      if (!isInitialized())
      {
        initialize();
        if (this.playing) {
          play();
        }
      }
      if (!needsPassthroughWorkarounds()) {
        break label101;
      }
      if (this.audioTrack.getPlayState() != 2) {
        break;
      }
      this.hasData = false;
      return false;
    }
    if ((this.audioTrack.getPlayState() == 1) && (this.audioTrackUtil.getPlaybackHeadPosition() != 0L)) {
      return false;
    }
    label101:
    bool = this.hasData;
    this.hasData = hasPendingData();
    long l1;
    if ((bool) && (!this.hasData) && (this.audioTrack.getPlayState() != 1) && (this.listener != null))
    {
      l1 = SystemClock.elapsedRealtime();
      long l2 = this.lastFeedElapsedRealtimeMs;
      this.listener.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs), l1 - l2);
    }
    if (this.inputBuffer == null)
    {
      if (!paramByteBuffer.hasRemaining()) {
        return true;
      }
      if ((!this.isInputPcm) && (this.framesPerEncodedSample == 0))
      {
        this.framesPerEncodedSample = getFramesPerEncodedSample(this.outputEncoding, paramByteBuffer);
        if (this.framesPerEncodedSample == 0) {
          return true;
        }
      }
      if (this.drainingPlaybackParameters != null)
      {
        if (!drainAudioProcessorsToEndOfStream()) {
          return false;
        }
        this.playbackParametersCheckpoints.add(new DefaultAudioSink.PlaybackParametersCheckpoint(this.drainingPlaybackParameters, Math.max(0L, paramLong), framesToDurationUs(getWrittenFrames()), null));
        this.drainingPlaybackParameters = null;
        resetAudioProcessors();
      }
      if (this.startMediaTimeState == 0)
      {
        this.startMediaTimeUs = Math.max(0L, paramLong);
        this.startMediaTimeState = 1;
        if (!this.isInputPcm) {
          break label496;
        }
        this.submittedPcmBytes += paramByteBuffer.remaining();
        label332:
        this.inputBuffer = paramByteBuffer;
      }
    }
    else
    {
      if (!this.processingEnabled) {
        break label513;
      }
      processBuffers(paramLong);
    }
    for (;;)
    {
      if (this.inputBuffer.hasRemaining()) {
        break label525;
      }
      this.inputBuffer = null;
      return true;
      l1 = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
      if ((this.startMediaTimeState == 1) && (Math.abs(l1 - paramLong) > 200000L))
      {
        Log.e("AudioTrack", "Discontinuity detected [expected " + l1 + ", got " + paramLong + "]");
        this.startMediaTimeState = 2;
      }
      if (this.startMediaTimeState != 2) {
        break;
      }
      this.startMediaTimeUs = (paramLong - l1 + this.startMediaTimeUs);
      this.startMediaTimeState = 1;
      if (this.listener == null) {
        break;
      }
      this.listener.onPositionDiscontinuity();
      break;
      label496:
      this.submittedEncodedFrames += this.framesPerEncodedSample;
      break label332;
      label513:
      writeBuffer(this.inputBuffer, paramLong);
    }
    label525:
    if (this.audioTrackUtil.needsReset(getWrittenFrames()))
    {
      Log.w("AudioTrack", "Resetting stalled audio track");
      reset();
      return true;
    }
    return false;
  }
  
  public void handleDiscontinuity()
  {
    if (this.startMediaTimeState == 1) {
      this.startMediaTimeState = 2;
    }
  }
  
  public boolean hasPendingData()
  {
    return (isInitialized()) && ((getWrittenFrames() > this.audioTrackUtil.getPlaybackHeadPosition()) || (overrideHasPendingData()));
  }
  
  public boolean isEncodingSupported(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (isEncodingPcm(paramInt))
    {
      if (paramInt == 4)
      {
        bool1 = bool2;
        if (Util.SDK_INT < 21) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if ((this.audioCapabilities != null) && (this.audioCapabilities.supportsEncoding(paramInt))) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public boolean isEnded()
  {
    return (!isInitialized()) || ((this.handledEndOfStream) && (!hasPendingData()));
  }
  
  public void pause()
  {
    this.playing = false;
    if (isInitialized())
    {
      resetSyncParams();
      this.audioTrackUtil.pause();
    }
  }
  
  public void play()
  {
    this.playing = true;
    if (isInitialized())
    {
      this.resumeSystemTimeUs = (System.nanoTime() / 1000L);
      this.audioTrack.play();
    }
  }
  
  public void playToEndOfStream()
  {
    if ((this.handledEndOfStream) || (!isInitialized())) {}
    while (!drainAudioProcessorsToEndOfStream()) {
      return;
    }
    this.audioTrackUtil.handleEndOfStream(getWrittenFrames());
    this.bytesUntilNextAvSync = 0;
    this.handledEndOfStream = true;
  }
  
  public void release()
  {
    reset();
    releaseKeepSessionIdAudioTrack();
    AudioProcessor[] arrayOfAudioProcessor = this.toIntPcmAvailableAudioProcessors;
    int j = arrayOfAudioProcessor.length;
    int i = 0;
    while (i < j)
    {
      arrayOfAudioProcessor[i].reset();
      i += 1;
    }
    arrayOfAudioProcessor = this.toFloatPcmAvailableAudioProcessors;
    j = arrayOfAudioProcessor.length;
    i = 0;
    while (i < j)
    {
      arrayOfAudioProcessor[i].reset();
      i += 1;
    }
    this.audioSessionId = 0;
    this.playing = false;
  }
  
  public void reset()
  {
    if (isInitialized())
    {
      this.submittedPcmBytes = 0L;
      this.submittedEncodedFrames = 0L;
      this.writtenPcmBytes = 0L;
      this.writtenEncodedFrames = 0L;
      this.framesPerEncodedSample = 0;
      if (this.drainingPlaybackParameters != null)
      {
        this.playbackParameters = this.drainingPlaybackParameters;
        this.drainingPlaybackParameters = null;
      }
      for (;;)
      {
        this.playbackParametersCheckpoints.clear();
        this.playbackParametersOffsetUs = 0L;
        this.playbackParametersPositionUs = 0L;
        this.inputBuffer = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.audioProcessors.length)
        {
          localObject = this.audioProcessors[i];
          ((AudioProcessor)localObject).flush();
          this.outputBuffers[i] = ((AudioProcessor)localObject).getOutput();
          i += 1;
        }
        if (!this.playbackParametersCheckpoints.isEmpty()) {
          this.playbackParameters = DefaultAudioSink.PlaybackParametersCheckpoint.access$200((DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast());
        }
      }
      this.handledEndOfStream = false;
      this.drainingAudioProcessorIndex = -1;
      this.avSyncHeader = null;
      this.bytesUntilNextAvSync = 0;
      this.startMediaTimeState = 0;
      this.latencyUs = 0L;
      resetSyncParams();
      if (this.audioTrack.getPlayState() == 3) {
        this.audioTrack.pause();
      }
      Object localObject = this.audioTrack;
      this.audioTrack = null;
      this.audioTrackUtil.reconfigure(null, false);
      this.releasingConditionVariable.close();
      new DefaultAudioSink.1(this, (AudioTrack)localObject).start();
    }
  }
  
  public void setAudioAttributes(AudioAttributes paramAudioAttributes)
  {
    if (this.audioAttributes.equals(paramAudioAttributes)) {}
    do
    {
      return;
      this.audioAttributes = paramAudioAttributes;
    } while (this.tunneling);
    reset();
    this.audioSessionId = 0;
  }
  
  public void setAudioSessionId(int paramInt)
  {
    if (this.audioSessionId != paramInt)
    {
      this.audioSessionId = paramInt;
      reset();
    }
  }
  
  public void setListener(AudioSink.Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  public PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters)
  {
    if ((isInitialized()) && (!this.canApplyPlaybackParameters))
    {
      this.playbackParameters = PlaybackParameters.DEFAULT;
      return this.playbackParameters;
    }
    PlaybackParameters localPlaybackParameters = new PlaybackParameters(this.sonicAudioProcessor.setSpeed(paramPlaybackParameters.speed), this.sonicAudioProcessor.setPitch(paramPlaybackParameters.pitch));
    if (this.drainingPlaybackParameters != null)
    {
      paramPlaybackParameters = this.drainingPlaybackParameters;
      if (!localPlaybackParameters.equals(paramPlaybackParameters))
      {
        if (!isInitialized()) {
          break label128;
        }
        this.drainingPlaybackParameters = localPlaybackParameters;
      }
    }
    for (;;)
    {
      return this.playbackParameters;
      if (!this.playbackParametersCheckpoints.isEmpty())
      {
        paramPlaybackParameters = DefaultAudioSink.PlaybackParametersCheckpoint.access$200((DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast());
        break;
      }
      paramPlaybackParameters = this.playbackParameters;
      break;
      label128:
      this.playbackParameters = localPlaybackParameters;
    }
  }
  
  public void setVolume(float paramFloat)
  {
    if (this.volume != paramFloat)
    {
      this.volume = paramFloat;
      setVolumeInternal();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink
 * JD-Core Version:    0.7.0.1
 */