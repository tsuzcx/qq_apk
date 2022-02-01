package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class ResamplingAudioProcessor
  implements AudioProcessor
{
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private int encoding = 0;
  private boolean inputEnded;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private int sampleRateHz = -1;
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824)) {
      throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
    }
    if ((this.sampleRateHz == paramInt1) && (this.channelCount == paramInt2) && (this.encoding == paramInt3)) {
      return false;
    }
    this.sampleRateHz = paramInt1;
    this.channelCount = paramInt2;
    this.encoding = paramInt3;
    if (paramInt3 == 2) {
      this.buffer = EMPTY_BUFFER;
    }
    return true;
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
    return 2;
  }
  
  public int getOutputSampleRateHz()
  {
    return this.sampleRateHz;
  }
  
  public boolean isActive()
  {
    int i = this.encoding;
    return (i != 0) && (i != 2);
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
    int i = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int k = m - i;
    int n = this.encoding;
    if (n != -2147483648)
    {
      j = k;
      if (n != 3)
      {
        if (n == 1073741824)
        {
          j = k / 2;
          break label71;
        }
        throw new IllegalStateException();
      }
    }
    else
    {
      j = k / 3;
    }
    j *= 2;
    label71:
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    } else {
      this.buffer.clear();
    }
    k = this.encoding;
    int j = i;
    if (k != -2147483648)
    {
      j = i;
      if (k != 3)
      {
        if (k == 1073741824) {
          while (i < m)
          {
            this.buffer.put(paramByteBuffer.get(i + 2));
            this.buffer.put(paramByteBuffer.get(i + 3));
            i += 4;
          }
        }
        throw new IllegalStateException();
      }
      while (j < m)
      {
        this.buffer.put((byte)0);
        this.buffer.put((byte)((paramByteBuffer.get(j) & 0xFF) - 128));
        j += 1;
      }
    }
    while (j < m)
    {
      this.buffer.put(paramByteBuffer.get(j + 1));
      this.buffer.put(paramByteBuffer.get(j + 2));
      j += 3;
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
    this.encoding = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.ResamplingAudioProcessor
 * JD-Core Version:    0.7.0.1
 */