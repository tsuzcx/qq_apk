package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class FloatResamplingAudioProcessor
  implements AudioProcessor
{
  private static final int FLOAT_NAN_AS_INT = Float.floatToIntBits((0.0F / 0.0F));
  private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-010D;
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private boolean inputEnded;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private int sampleRateHz = -1;
  private int sourceEncoding = 0;
  
  private static void writePcm32BitFloat(int paramInt, ByteBuffer paramByteBuffer)
  {
    double d = paramInt;
    Double.isNaN(d);
    int i = Float.floatToIntBits((float)(d * 4.656612875245797E-010D));
    paramInt = i;
    if (i == FLOAT_NAN_AS_INT) {
      paramInt = Float.floatToIntBits(0.0F);
    }
    paramByteBuffer.putInt(paramInt);
  }
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
  {
    if (Util.isEncodingHighResolutionIntegerPcm(paramInt3))
    {
      if ((this.sampleRateHz == paramInt1) && (this.channelCount == paramInt2) && (this.sourceEncoding == paramInt3)) {
        return false;
      }
      this.sampleRateHz = paramInt1;
      this.channelCount = paramInt2;
      this.sourceEncoding = paramInt3;
      return true;
    }
    throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
  }
  
  public void flush()
  {
    this.outputBuffer = EMPTY_BUFFER;
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
    return 4;
  }
  
  public int getOutputSampleRateHz()
  {
    return this.sampleRateHz;
  }
  
  public boolean isActive()
  {
    return Util.isEncodingHighResolutionIntegerPcm(this.sourceEncoding);
  }
  
  public boolean isEnded()
  {
    return (this.inputEnded) && (this.outputBuffer == EMPTY_BUFFER);
  }
  
  public void queueEndOfStream()
  {
    this.inputEnded = true;
  }
  
  public void queueInput(ByteBuffer paramByteBuffer)
  {
    Assertions.checkState(isActive());
    int i;
    if (this.sourceEncoding == 1073741824) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int k = m - j;
    if (i == 0) {
      k = k / 3 * 4;
    }
    if (this.buffer.capacity() < k) {
      this.buffer = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
    } else {
      this.buffer.clear();
    }
    k = j;
    if (i != 0) {
      while (j < m)
      {
        writePcm32BitFloat(paramByteBuffer.get(j) & 0xFF | (paramByteBuffer.get(j + 1) & 0xFF) << 8 | (paramByteBuffer.get(j + 2) & 0xFF) << 16 | (paramByteBuffer.get(j + 3) & 0xFF) << 24, this.buffer);
        j += 4;
      }
    }
    while (k < m)
    {
      writePcm32BitFloat((paramByteBuffer.get(k) & 0xFF) << 8 | (paramByteBuffer.get(k + 1) & 0xFF) << 16 | (paramByteBuffer.get(k + 2) & 0xFF) << 24, this.buffer);
      k += 3;
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    this.buffer.flip();
    this.outputBuffer = this.buffer;
  }
  
  public void reset()
  {
    flush();
    this.buffer = EMPTY_BUFFER;
    this.sampleRateHz = -1;
    this.channelCount = -1;
    this.sourceEncoding = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.FloatResamplingAudioProcessor
 * JD-Core Version:    0.7.0.1
 */