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
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
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
    }
    catch (NoSuchMethodException paramAudioCapabilities)
    {
      label52:
      break label52;
    }
    if (Util.SDK_INT >= 19) {
      this.audioTrackUtil = new DefaultAudioSink.AudioTrackUtilV19();
    } else {
      this.audioTrackUtil = new DefaultAudioSink.AudioTrackUtil(null);
    }
    this.channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
    this.trimmingAudioProcessor = new TrimmingAudioProcessor();
    this.sonicAudioProcessor = new SonicAudioProcessor();
    this.toIntPcmAvailableAudioProcessors = new AudioProcessor[paramArrayOfAudioProcessor.length + 4];
    this.toIntPcmAvailableAudioProcessors[0] = new ResamplingAudioProcessor();
    paramAudioCapabilities = this.toIntPcmAvailableAudioProcessors;
    paramAudioCapabilities[1] = this.channelMappingAudioProcessor;
    paramAudioCapabilities[2] = this.trimmingAudioProcessor;
    System.arraycopy(paramArrayOfAudioProcessor, 0, paramAudioCapabilities, 3, paramArrayOfAudioProcessor.length);
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
      return paramLong + this.playbackParametersOffsetUs - this.playbackParametersPositionUs;
    }
    long l2;
    long l1;
    if (this.playbackParametersCheckpoints.isEmpty())
    {
      l2 = this.playbackParametersOffsetUs;
      l1 = this.sonicAudioProcessor.scaleDurationForSpeedup(paramLong - this.playbackParametersPositionUs);
      paramLong = l2;
    }
    for (;;)
    {
      return paramLong + l1;
      l1 = this.playbackParametersOffsetUs;
      l2 = Util.getMediaDurationForPlayoutDuration(paramLong - this.playbackParametersPositionUs, this.playbackParameters.speed);
      paramLong = l1;
      l1 = l2;
    }
  }
  
  @TargetApi(21)
  private AudioTrack createAudioTrackV21()
  {
    android.media.AudioAttributes localAudioAttributes;
    if (this.tunneling) {
      localAudioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    } else {
      localAudioAttributes = this.audioAttributes.getAudioAttributesV21();
    }
    AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.outputEncoding).setSampleRate(this.sampleRate).build();
    int i = this.audioSessionId;
    if (i == 0) {
      i = 0;
    }
    return new ReportAudioTrack(localAudioAttributes, localAudioFormat, this.bufferSize, 1, i);
  }
  
  private boolean drainAudioProcessorsToEndOfStream()
  {
    int i;
    if (this.drainingAudioProcessorIndex == -1) {
      if (this.processingEnabled) {
        i = 0;
      } else {
        i = this.audioProcessors.length;
      }
    }
    for (this.drainingAudioProcessorIndex = i;; this.drainingAudioProcessorIndex += 1)
    {
      i = 1;
      break label38;
      i = 0;
      label38:
      int j = this.drainingAudioProcessorIndex;
      localObject = this.audioProcessors;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      if (i != 0) {
        ((AudioProcessor)localObject).queueEndOfStream();
      }
      processBuffers(-9223372036854775807L);
      if (!((AudioProcessor)localObject).isEnded()) {
        return false;
      }
    }
    Object localObject = this.outputBuffer;
    if (localObject != null)
    {
      writeBuffer((ByteBuffer)localObject, -9223372036854775807L);
      if (this.outputBuffer != null) {
        return false;
      }
    }
    this.drainingAudioProcessorIndex = -1;
    return true;
  }
  
  private long durationUsToFrames(long paramLong)
  {
    return paramLong * this.sampleRate / 1000000L;
  }
  
  private long framesToDurationUs(long paramLong)
  {
    return paramLong * 1000000L / this.sampleRate;
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
    if ((paramInt != 7) && (paramInt != 8))
    {
      if (paramInt == 5) {
        return Ac3Util.getAc3SyncframeAudioSampleCount();
      }
      if (paramInt == 6) {
        return Ac3Util.parseEAc3SyncframeAudioSampleCount(paramByteBuffer);
      }
      if (paramInt == 14) {
        return Ac3Util.parseTrueHdSyncframeAudioSampleCount(paramByteBuffer) * 8;
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Unexpected audio encoding: ");
      paramByteBuffer.append(paramInt);
      throw new IllegalStateException(paramByteBuffer.toString());
    }
    return DtsUtil.parseDtsAudioSampleCount(paramByteBuffer);
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
    Object localObject;
    if ((enablePreV21AudioSessionWorkaround) && (Util.SDK_INT < 21))
    {
      localObject = this.keepSessionIdAudioTrack;
      if ((localObject != null) && (i != ((AudioTrack)localObject).getAudioSessionId())) {
        releaseKeepSessionIdAudioTrack();
      }
      if (this.keepSessionIdAudioTrack == null) {
        this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(i);
      }
    }
    if (this.audioSessionId != i)
    {
      this.audioSessionId = i;
      localObject = this.listener;
      if (localObject != null) {
        ((AudioSink.Listener)localObject).onAudioSessionId(i);
      }
    }
    this.audioTrackUtil.reconfigure(this.audioTrack, needsPassthroughWorkarounds());
    setVolumeInternal();
    this.hasData = false;
  }
  
  private AudioTrack initializeAudioTrack()
  {
    Object localObject;
    if (Util.SDK_INT >= 21)
    {
      localObject = createAudioTrackV21();
    }
    else
    {
      i = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
      int j = this.audioSessionId;
      if (j == 0) {
        localObject = new ReportAudioTrack(i, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1);
      } else {
        localObject = new ReportAudioTrack(i, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1, j);
      }
    }
    int i = ((AudioTrack)localObject).getState();
    if (i == 1) {
      return localObject;
    }
    try
    {
      ((AudioTrack)localObject).release();
      label108:
      throw new AudioSink.InitializationException(i, this.sampleRate, this.channelConfig, this.bufferSize);
    }
    catch (Exception localException)
    {
      break label108;
    }
  }
  
  private AudioTrack initializeKeepSessionIdAudioTrack(int paramInt)
  {
    return new ReportAudioTrack(3, 4000, 4, 2, 2, 0, paramInt);
  }
  
  private long inputFramesToDurationUs(long paramLong)
  {
    return paramLong * 1000000L / this.inputSampleRate;
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
    if (l1 == 0L) {
      return;
    }
    long l2 = System.nanoTime() / 1000L;
    Object localObject;
    if (l2 - this.lastPlayheadSampleTimeUs >= 30000L)
    {
      localObject = this.playheadOffsets;
      int i = this.nextPlayheadOffsetIndex;
      localObject[i] = (l1 - l2);
      this.nextPlayheadOffsetIndex = ((i + 1) % 10);
      i = this.playheadOffsetCount;
      if (i < 10) {
        this.playheadOffsetCount = (i + 1);
      }
      this.lastPlayheadSampleTimeUs = l2;
      this.smoothedPlayheadOffsetUs = 0L;
      i = 0;
      for (;;)
      {
        int j = this.playheadOffsetCount;
        if (i >= j) {
          break;
        }
        this.smoothedPlayheadOffsetUs += this.playheadOffsets[i] / j;
        i += 1;
      }
    }
    if (needsPassthroughWorkarounds()) {
      return;
    }
    if (l2 - this.lastTimestampSampleTimeUs >= 500000L)
    {
      this.audioTimestampSet = this.audioTrackUtil.updateTimestamp();
      if (this.audioTimestampSet)
      {
        long l3 = this.audioTrackUtil.getTimestampNanoTime() / 1000L;
        long l4 = this.audioTrackUtil.getTimestampFramePosition();
        if (l3 < this.resumeSystemTimeUs)
        {
          this.audioTimestampSet = false;
        }
        else if (Math.abs(l3 - l2) > 5000000L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Spurious audio timestamp (system clock mismatch): ");
          ((StringBuilder)localObject).append(l4);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(getSubmittedFrames());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(getWrittenFrames());
          localObject = ((StringBuilder)localObject).toString();
          if (!failOnSpuriousAudioTimestamp)
          {
            Log.w("AudioTrack", (String)localObject);
            this.audioTimestampSet = false;
          }
          else
          {
            throw new DefaultAudioSink.InvalidAudioTrackTimestampException((String)localObject);
          }
        }
        else if (Math.abs(framesToDurationUs(l4) - l1) > 5000000L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Spurious audio timestamp (frame position mismatch): ");
          ((StringBuilder)localObject).append(l4);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(getSubmittedFrames());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(getWrittenFrames());
          localObject = ((StringBuilder)localObject).toString();
          if (!failOnSpuriousAudioTimestamp)
          {
            Log.w("AudioTrack", (String)localObject);
            this.audioTimestampSet = false;
          }
          else
          {
            throw new DefaultAudioSink.InvalidAudioTrackTimestampException((String)localObject);
          }
        }
      }
      localObject = this.getLatencyMethod;
      if ((localObject == null) || (!this.isInputPcm)) {}
    }
    try
    {
      this.latencyUs = (((Integer)((Method)localObject).invoke(this.audioTrack, (Object[])null)).intValue() * 1000L - this.bufferSizeUs);
      this.latencyUs = Math.max(this.latencyUs, 0L);
      if (this.latencyUs <= 5000000L) {
        break label678;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Ignoring impossibly large audio latency: ");
      ((StringBuilder)localObject).append(this.latencyUs);
      Log.w("AudioTrack", ((StringBuilder)localObject).toString());
      this.latencyUs = 0L;
    }
    catch (Exception localException)
    {
      label673:
      break label673;
    }
    this.getLatencyMethod = null;
    label678:
    this.lastTimestampSampleTimeUs = l2;
  }
  
  private boolean needsPassthroughWorkarounds()
  {
    if (Util.SDK_INT < 23)
    {
      int i = this.outputEncoding;
      if ((i == 5) || (i == 6)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean overrideHasPendingData()
  {
    return (needsPassthroughWorkarounds()) && (this.audioTrack.getPlayState() == 2) && (this.audioTrack.getPlaybackHeadPosition() == 0);
  }
  
  private void processBuffers(long paramLong)
  {
    int j = this.audioProcessors.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.outputBuffers[(i - 1)];
      }
      else
      {
        localByteBuffer = this.inputBuffer;
        if (localByteBuffer == null) {
          localByteBuffer = AudioProcessor.EMPTY_BUFFER;
        }
      }
      if (i == j)
      {
        writeBuffer(localByteBuffer, paramLong);
      }
      else
      {
        Object localObject = this.audioProcessors[i];
        ((AudioProcessor)localObject).queueInput(localByteBuffer);
        localObject = ((AudioProcessor)localObject).getOutput();
        this.outputBuffers[i] = localObject;
        if (((ByteBuffer)localObject).hasRemaining())
        {
          i += 1;
          continue;
        }
      }
      if (localByteBuffer.hasRemaining()) {
        return;
      }
      i -= 1;
    }
  }
  
  private void releaseKeepSessionIdAudioTrack()
  {
    AudioTrack localAudioTrack = this.keepSessionIdAudioTrack;
    if (localAudioTrack == null) {
      return;
    }
    this.keepSessionIdAudioTrack = null;
    new DefaultAudioSink.2(this, localAudioTrack).start();
  }
  
  private void resetAudioProcessors()
  {
    Object localObject = new ArrayList();
    AudioProcessor[] arrayOfAudioProcessor = getAvailableAudioProcessors();
    int k = arrayOfAudioProcessor.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      AudioProcessor localAudioProcessor = arrayOfAudioProcessor[i];
      if (localAudioProcessor.isActive()) {
        ((ArrayList)localObject).add(localAudioProcessor);
      } else {
        localAudioProcessor.flush();
      }
      i += 1;
    }
    k = ((ArrayList)localObject).size();
    this.audioProcessors = ((AudioProcessor[])((ArrayList)localObject).toArray(new AudioProcessor[k]));
    this.outputBuffers = new ByteBuffer[k];
    i = j;
    while (i < k)
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
    if (!paramByteBuffer.hasRemaining()) {
      return;
    }
    Object localObject = this.outputBuffer;
    boolean bool2 = true;
    boolean bool1;
    int i;
    int j;
    if (localObject != null)
    {
      if (localObject == paramByteBuffer) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Assertions.checkArgument(bool1);
    }
    else
    {
      this.outputBuffer = paramByteBuffer;
      if (Util.SDK_INT < 21)
      {
        i = paramByteBuffer.remaining();
        localObject = this.preV21OutputBuffer;
        if ((localObject == null) || (localObject.length < i)) {
          this.preV21OutputBuffer = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.preV21OutputBuffer, 0, i);
        paramByteBuffer.position(j);
        this.preV21OutputBufferOffset = 0;
      }
    }
    int k = paramByteBuffer.remaining();
    if (Util.SDK_INT < 21)
    {
      i = (int)(this.writtenPcmBytes - this.audioTrackUtil.getPlaybackHeadPosition() * this.outputPcmFrameSize);
      i = this.bufferSize - i;
      if (i > 0)
      {
        i = Math.min(k, i);
        j = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, i);
        localObject = this.listener;
        if ((localObject != null) && (((AudioSink.Listener)localObject).isNeedAudioData()) && (j > 0))
        {
          localObject = new byte[j];
          i = paramByteBuffer.position();
          paramByteBuffer.get((byte[])localObject, 0, j);
          paramByteBuffer.position(i);
          this.listener.onRenderAudioData((byte[])localObject);
        }
        i = j;
        if (j > 0)
        {
          this.preV21OutputBufferOffset += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
      else
      {
        i = 0;
      }
    }
    else if (this.tunneling)
    {
      if (paramLong != -9223372036854775807L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Assertions.checkState(bool1);
      i = writeNonBlockingWithAvSyncV21(this.audioTrack, paramByteBuffer, k, paramLong);
    }
    else
    {
      localObject = this.listener;
      if ((localObject != null) && (((AudioSink.Listener)localObject).isNeedAudioData()))
      {
        j = paramByteBuffer.position();
        i = writeNonBlockingV21(this.audioTrack, paramByteBuffer, k);
        if (i > 0)
        {
          int m = paramByteBuffer.position();
          paramByteBuffer.position(j);
          localObject = new byte[i];
          paramByteBuffer.get((byte[])localObject, 0, i);
          paramByteBuffer.position(m);
          this.listener.onRenderAudioData((byte[])localObject);
        }
      }
      else
      {
        i = writeNonBlockingV21(this.audioTrack, paramByteBuffer, k);
      }
    }
    this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
    if (i >= 0)
    {
      if (this.isInputPcm) {
        this.writtenPcmBytes += i;
      }
      if (i == k)
      {
        if (!this.isInputPcm) {
          this.writtenEncodedFrames += this.framesPerEncodedSample;
        }
        this.outputBuffer = null;
      }
      return;
    }
    throw new AudioSink.WriteException(i);
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
      this.avSyncHeader.putLong(8, paramLong * 1000L);
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
    boolean bool1 = this.enableConvertHighResIntPcmToFloat;
    boolean bool2 = true;
    if ((bool1) && (isEncodingSupported(1073741824)) && (Util.isEncodingHighResolutionIntegerPcm(paramInt1))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.shouldConvertHighResIntPcmToFloat = bool1;
    if (this.isInputPcm) {
      this.pcmFrameSize = Util.getPcmFrameSize(paramInt1, paramInt2);
    }
    bool1 = this.isInputPcm;
    int j = 4;
    if ((bool1) && (paramInt1 != 4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int m;
    if ((bool1) && (!this.shouldConvertHighResIntPcmToFloat)) {
      m = 1;
    } else {
      m = 0;
    }
    this.canApplyPlaybackParameters = m;
    int i;
    if (bool1)
    {
      this.trimmingAudioProcessor.setTrimSampleCount(paramInt5, paramInt6);
      this.channelMappingAudioProcessor.setChannelMap(paramArrayOfInt);
      paramArrayOfInt = getAvailableAudioProcessors();
      i = paramArrayOfInt.length;
      paramInt5 = paramInt1;
      paramInt1 = paramInt3;
      paramInt6 = 0;
      paramInt3 = 0;
      while (paramInt6 < i)
      {
        int n = paramArrayOfInt[paramInt6];
        try
        {
          m = n.configure(paramInt1, paramInt2, paramInt5);
          paramInt3 |= m;
          if (n.isActive())
          {
            paramInt2 = n.getOutputChannelCount();
            paramInt1 = n.getOutputSampleRateHz();
            paramInt5 = n.getOutputEncoding();
          }
          paramInt6 += 1;
        }
        catch (AudioProcessor.UnhandledFormatException paramArrayOfInt)
        {
          throw new AudioSink.ConfigurationException(paramArrayOfInt);
        }
      }
      paramInt6 = paramInt2;
      i = paramInt1;
    }
    else
    {
      paramInt5 = 0;
      i = paramInt3;
      paramInt3 = paramInt5;
      paramInt6 = paramInt2;
      paramInt5 = paramInt1;
    }
    int k = 252;
    paramInt1 = j;
    switch (paramInt6)
    {
    default: 
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("Unsupported channel count: ");
      paramArrayOfInt.append(paramInt6);
      throw new AudioSink.ConfigurationException(paramArrayOfInt.toString());
    case 8: 
      paramInt1 = C.CHANNEL_OUT_7POINT1_SURROUND;
      break;
    case 7: 
      paramInt1 = 1276;
      break;
    case 6: 
      paramInt1 = 252;
      break;
    case 5: 
      paramInt1 = 220;
      break;
    case 4: 
      paramInt1 = 204;
      break;
    case 3: 
      paramInt1 = 28;
      break;
    case 2: 
      paramInt1 = 12;
    }
    if ((Util.SDK_INT <= 23) && ("foster".equals(Util.DEVICE)) && ("NVIDIA".equals(Util.MANUFACTURER)))
    {
      paramInt2 = k;
      if (paramInt6 == 3) {
        break label496;
      }
      paramInt2 = k;
      if (paramInt6 == 5) {
        break label496;
      }
      if (paramInt6 == 7)
      {
        paramInt2 = C.CHANNEL_OUT_7POINT1_SURROUND;
        break label496;
      }
    }
    paramInt2 = paramInt1;
    label496:
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
          if (paramInt6 == 1) {
            paramInt1 = 12;
          }
        }
      }
    }
    if ((paramInt3 == 0) && (isInitialized()) && (this.outputEncoding == paramInt5) && (this.sampleRate == i) && (this.channelConfig == paramInt1)) {
      return;
    }
    reset();
    this.processingEnabled = bool1;
    this.sampleRate = i;
    this.channelConfig = paramInt1;
    this.outputEncoding = paramInt5;
    if (this.isInputPcm) {
      this.outputPcmFrameSize = Util.getPcmFrameSize(this.outputEncoding, paramInt6);
    }
    if (paramInt4 != 0)
    {
      this.bufferSize = paramInt4;
    }
    else if (this.isInputPcm)
    {
      paramInt1 = AudioTrack.getMinBufferSize(i, paramInt1, this.outputEncoding);
      if (paramInt1 != -2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Assertions.checkState(bool1);
      this.bufferSize = Util.constrainValue(paramInt1 * 4, (int)durationUsToFrames(250000L) * this.outputPcmFrameSize, (int)Math.max(paramInt1, durationUsToFrames(750000L) * this.outputPcmFrameSize));
    }
    else
    {
      paramInt1 = this.outputEncoding;
      if ((paramInt1 != 5) && (paramInt1 != 6))
      {
        if (paramInt1 == 7) {
          this.bufferSize = 49152;
        } else {
          this.bufferSize = 294912;
        }
      }
      else {
        this.bufferSize = 20480;
      }
    }
    long l;
    if (this.isInputPcm) {
      l = framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);
    } else {
      l = -9223372036854775807L;
    }
    this.bufferSizeUs = l;
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
    boolean bool;
    if (Util.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    if ((!this.tunneling) || (this.audioSessionId != paramInt))
    {
      this.tunneling = true;
      this.audioSessionId = paramInt;
      reset();
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
    long l2;
    if (this.audioTimestampSet)
    {
      l1 = durationUsToFrames(l1 - this.audioTrackUtil.getTimestampNanoTime() / 1000L);
      l2 = framesToDurationUs(this.audioTrackUtil.getTimestampFramePosition() + l1);
    }
    else
    {
      if (this.playheadOffsetCount == 0) {
        l1 = this.audioTrackUtil.getPositionUs();
      } else {
        l1 += this.smoothedPlayheadOffsetUs;
      }
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 - this.latencyUs;
      }
    }
    l1 = Math.min(l2, framesToDurationUs(getWrittenFrames()));
    return this.startMediaTimeUs + applySpeedup(l1);
  }
  
  public PlaybackParameters getPlaybackParameters()
  {
    return this.playbackParameters;
  }
  
  public boolean handleBuffer(ByteBuffer paramByteBuffer, long paramLong)
  {
    Object localObject = this.inputBuffer;
    if ((localObject != null) && (paramByteBuffer != localObject)) {
      bool = false;
    } else {
      bool = true;
    }
    Assertions.checkArgument(bool);
    if (!isInitialized())
    {
      initialize();
      if (this.playing) {
        play();
      }
    }
    if (needsPassthroughWorkarounds())
    {
      if (this.audioTrack.getPlayState() == 2)
      {
        this.hasData = false;
        return false;
      }
      if ((this.audioTrack.getPlayState() == 1) && (this.audioTrackUtil.getPlaybackHeadPosition() != 0L)) {
        return false;
      }
    }
    boolean bool = this.hasData;
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
      }
      else
      {
        l1 = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
        if ((this.startMediaTimeState == 1) && (Math.abs(l1 - paramLong) > 200000L))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Discontinuity detected [expected ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", got ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append("]");
          Log.e("AudioTrack", ((StringBuilder)localObject).toString());
          this.startMediaTimeState = 2;
        }
        if (this.startMediaTimeState == 2)
        {
          this.startMediaTimeUs += paramLong - l1;
          this.startMediaTimeState = 1;
          localObject = this.listener;
          if (localObject != null) {
            ((AudioSink.Listener)localObject).onPositionDiscontinuity();
          }
        }
      }
      localObject = "AudioTrack";
      if (this.isInputPcm) {
        this.submittedPcmBytes += paramByteBuffer.remaining();
      } else {
        this.submittedEncodedFrames += this.framesPerEncodedSample;
      }
      this.inputBuffer = paramByteBuffer;
      paramByteBuffer = (ByteBuffer)localObject;
    }
    else
    {
      paramByteBuffer = "AudioTrack";
    }
    if (this.processingEnabled) {
      processBuffers(paramLong);
    } else {
      writeBuffer(this.inputBuffer, paramLong);
    }
    if (!this.inputBuffer.hasRemaining())
    {
      this.inputBuffer = null;
      return true;
    }
    if (this.audioTrackUtil.needsReset(getWrittenFrames()))
    {
      Log.w(paramByteBuffer, "Resetting stalled audio track");
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
    boolean bool2 = isEncodingPcm(paramInt);
    boolean bool1 = true;
    if (bool2)
    {
      if (paramInt == 4)
      {
        if (Util.SDK_INT >= 21) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    AudioCapabilities localAudioCapabilities = this.audioCapabilities;
    return (localAudioCapabilities != null) && (localAudioCapabilities.supportsEncoding(paramInt));
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
    if (!this.handledEndOfStream)
    {
      if (!isInitialized()) {
        return;
      }
      if (drainAudioProcessorsToEndOfStream())
      {
        this.audioTrackUtil.handleEndOfStream(getWrittenFrames());
        this.bytesUntilNextAvSync = 0;
        this.handledEndOfStream = true;
      }
    }
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
      Object localObject = this.drainingPlaybackParameters;
      if (localObject != null)
      {
        this.playbackParameters = ((PlaybackParameters)localObject);
        this.drainingPlaybackParameters = null;
      }
      else if (!this.playbackParametersCheckpoints.isEmpty())
      {
        this.playbackParameters = DefaultAudioSink.PlaybackParametersCheckpoint.access$200((DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast());
      }
      this.playbackParametersCheckpoints.clear();
      this.playbackParametersOffsetUs = 0L;
      this.playbackParametersPositionUs = 0L;
      this.inputBuffer = null;
      this.outputBuffer = null;
      int i = 0;
      for (;;)
      {
        localObject = this.audioProcessors;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        ((AudioProcessor)localObject).flush();
        this.outputBuffers[i] = ((AudioProcessor)localObject).getOutput();
        i += 1;
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
      localObject = this.audioTrack;
      this.audioTrack = null;
      this.audioTrackUtil.reconfigure(null, false);
      this.releasingConditionVariable.close();
      new DefaultAudioSink.1(this, (AudioTrack)localObject).start();
    }
  }
  
  public void setAudioAttributes(AudioAttributes paramAudioAttributes)
  {
    if (this.audioAttributes.equals(paramAudioAttributes)) {
      return;
    }
    this.audioAttributes = paramAudioAttributes;
    if (this.tunneling) {
      return;
    }
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
    paramPlaybackParameters = this.drainingPlaybackParameters;
    if (paramPlaybackParameters == null) {
      if (!this.playbackParametersCheckpoints.isEmpty()) {
        paramPlaybackParameters = DefaultAudioSink.PlaybackParametersCheckpoint.access$200((DefaultAudioSink.PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast());
      } else {
        paramPlaybackParameters = this.playbackParameters;
      }
    }
    if (!localPlaybackParameters.equals(paramPlaybackParameters)) {
      if (isInitialized()) {
        this.drainingPlaybackParameters = localPlaybackParameters;
      } else {
        this.playbackParameters = localPlaybackParameters;
      }
    }
    return this.playbackParameters;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink
 * JD-Core Version:    0.7.0.1
 */