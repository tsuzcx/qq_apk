package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class ChannelMappingAudioProcessor
  implements AudioProcessor
{
  private boolean active;
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private boolean inputEnded;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private int[] outputChannels;
  private int[] pendingOutputChannels;
  private int sampleRateHz = -1;
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = Arrays.equals(this.pendingOutputChannels, this.outputChannels) ^ true;
    this.outputChannels = this.pendingOutputChannels;
    if (this.outputChannels == null)
    {
      this.active = false;
      return k;
    }
    if (paramInt3 == 2)
    {
      if ((k == 0) && (this.sampleRateHz == paramInt1) && (this.channelCount == paramInt2)) {
        return false;
      }
      this.sampleRateHz = paramInt1;
      this.channelCount = paramInt2;
      if (paramInt2 != this.outputChannels.length) {
        k = 1;
      } else {
        k = 0;
      }
      this.active = k;
      int i = 0;
      for (;;)
      {
        localObject = this.outputChannels;
        if (i >= localObject.length) {
          break label181;
        }
        int j = localObject[i];
        if (j >= paramInt2) {
          break;
        }
        k = this.active;
        if (j != i) {
          j = 1;
        } else {
          j = 0;
        }
        this.active = (j | k);
        i += 1;
      }
      throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
      label181:
      return true;
    }
    Object localObject = new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
    for (;;)
    {
      throw ((Throwable)localObject);
    }
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
    int[] arrayOfInt = this.outputChannels;
    if (arrayOfInt == null) {
      return this.channelCount;
    }
    return arrayOfInt.length;
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
    return this.active;
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
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.channelCount * 2) * this.outputChannels.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    } else {
      this.buffer.clear();
    }
    while (i < k)
    {
      int[] arrayOfInt = this.outputChannels;
      int m = arrayOfInt.length;
      j = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        this.buffer.putShort(paramByteBuffer.getShort(n * 2 + i));
        j += 1;
      }
      i += this.channelCount * 2;
    }
    paramByteBuffer.position(k);
    this.buffer.flip();
    this.outputBuffer = this.buffer;
  }
  
  public void reset()
  {
    flush();
    this.buffer = EMPTY_BUFFER;
    this.channelCount = -1;
    this.sampleRateHz = -1;
    this.outputChannels = null;
    this.active = false;
  }
  
  public void setChannelMap(int[] paramArrayOfInt)
  {
    this.pendingOutputChannels = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor
 * JD-Core Version:    0.7.0.1
 */