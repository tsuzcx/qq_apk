package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor
  implements AudioProcessor
{
  private static final float CLOSE_THRESHOLD = 0.01F;
  public static final float MAXIMUM_PITCH = 8.0F;
  public static final float MAXIMUM_SPEED = 8.0F;
  public static final float MINIMUM_PITCH = 0.1F;
  public static final float MINIMUM_SPEED = 0.1F;
  private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
  public static final int SAMPLE_RATE_NO_CHANGE = -1;
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private long inputBytes;
  private boolean inputEnded;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private long outputBytes;
  private int outputSampleRateHz = -1;
  private int pendingOutputSampleRateHz = -1;
  private float pitch = 1.0F;
  private int sampleRateHz = -1;
  private ShortBuffer shortBuffer = this.buffer.asShortBuffer();
  private Sonic sonic;
  private float speed = 1.0F;
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      int i = this.pendingOutputSampleRateHz;
      paramInt3 = i;
      if (i == -1) {
        paramInt3 = paramInt1;
      }
      if ((this.sampleRateHz == paramInt1) && (this.channelCount == paramInt2) && (this.outputSampleRateHz == paramInt3)) {
        return false;
      }
      this.sampleRateHz = paramInt1;
      this.channelCount = paramInt2;
      this.outputSampleRateHz = paramInt3;
      return true;
    }
    throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
  }
  
  public void flush()
  {
    this.sonic = new Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
    this.outputBuffer = EMPTY_BUFFER;
    this.inputBytes = 0L;
    this.outputBytes = 0L;
    this.inputEnded = false;
  }
  
  public ByteBuffer getOutput()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = EMPTY_BUFFER;
    return localByteBuffer;
  }
  
  public int getOutputChannelCount()
  {
    return this.channelCount;
  }
  
  public int getOutputEncoding()
  {
    return 2;
  }
  
  public int getOutputSampleRateHz()
  {
    return this.outputSampleRateHz;
  }
  
  public boolean isActive()
  {
    return (Math.abs(this.speed - 1.0F) >= 0.01F) || (Math.abs(this.pitch - 1.0F) >= 0.01F) || (this.outputSampleRateHz != this.sampleRateHz);
  }
  
  public boolean isEnded()
  {
    if (this.inputEnded)
    {
      Sonic localSonic = this.sonic;
      if ((localSonic == null) || (localSonic.getSamplesAvailable() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void queueEndOfStream()
  {
    this.sonic.queueEndOfStream();
    this.inputEnded = true;
  }
  
  public void queueInput(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      ShortBuffer localShortBuffer = paramByteBuffer.asShortBuffer();
      i = paramByteBuffer.remaining();
      this.inputBytes += i;
      this.sonic.queueInput(localShortBuffer);
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    int i = this.sonic.getSamplesAvailable() * this.channelCount * 2;
    if (i > 0)
    {
      if (this.buffer.capacity() < i)
      {
        this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        this.shortBuffer = this.buffer.asShortBuffer();
      }
      else
      {
        this.buffer.clear();
        this.shortBuffer.clear();
      }
      this.sonic.getOutput(this.shortBuffer);
      this.outputBytes += i;
      this.buffer.limit(i);
      this.outputBuffer = this.buffer;
    }
  }
  
  public void reset()
  {
    this.sonic = null;
    this.buffer = EMPTY_BUFFER;
    this.shortBuffer = this.buffer.asShortBuffer();
    this.outputBuffer = EMPTY_BUFFER;
    this.channelCount = -1;
    this.sampleRateHz = -1;
    this.outputSampleRateHz = -1;
    this.inputBytes = 0L;
    this.outputBytes = 0L;
    this.inputEnded = false;
    this.pendingOutputSampleRateHz = -1;
  }
  
  public long scaleDurationForSpeedup(long paramLong)
  {
    long l = this.outputBytes;
    if (l >= 1024L)
    {
      int i = this.outputSampleRateHz;
      int j = this.sampleRateHz;
      if (i == j) {
        return Util.scaleLargeTimestamp(paramLong, this.inputBytes, l);
      }
      return Util.scaleLargeTimestamp(paramLong, this.inputBytes * i, l * j);
    }
    double d1 = this.speed;
    double d2 = paramLong;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 * d2);
  }
  
  public void setOutputSampleRateHz(int paramInt)
  {
    this.pendingOutputSampleRateHz = paramInt;
  }
  
  public float setPitch(float paramFloat)
  {
    this.pitch = Util.constrainValue(paramFloat, 0.1F, 8.0F);
    return paramFloat;
  }
  
  public float setSpeed(float paramFloat)
  {
    this.speed = Util.constrainValue(paramFloat, 0.1F, 8.0F);
    return this.speed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.SonicAudioProcessor
 * JD-Core Version:    0.7.0.1
 */