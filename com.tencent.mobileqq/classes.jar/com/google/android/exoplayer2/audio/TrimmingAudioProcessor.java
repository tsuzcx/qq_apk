package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class TrimmingAudioProcessor
  implements AudioProcessor
{
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private byte[] endBuffer;
  private int endBufferSize;
  private boolean inputEnded;
  private boolean isActive;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private int pendingTrimStartBytes;
  private int sampleRateHz;
  private int trimEndSamples;
  private int trimStartSamples;
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.channelCount = paramInt2;
      this.sampleRateHz = paramInt1;
      paramInt1 = this.trimEndSamples;
      this.endBuffer = new byte[paramInt1 * paramInt2 * 2];
      boolean bool2 = false;
      this.endBufferSize = 0;
      paramInt3 = this.trimStartSamples;
      this.pendingTrimStartBytes = (paramInt2 * paramInt3 * 2);
      boolean bool3 = this.isActive;
      if ((paramInt3 == 0) && (paramInt1 == 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      this.isActive = bool1;
      boolean bool1 = bool2;
      if (bool3 != this.isActive) {
        bool1 = true;
      }
      return bool1;
    }
    throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
  }
  
  public void flush()
  {
    this.outputBuffer = EMPTY_BUFFER;
    this.inputEnded = false;
    this.pendingTrimStartBytes = 0;
    this.endBufferSize = 0;
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
    return this.isActive;
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
    int j = paramByteBuffer.position();
    int i = paramByteBuffer.limit();
    int k = i - j;
    int m = Math.min(k, this.pendingTrimStartBytes);
    this.pendingTrimStartBytes -= m;
    paramByteBuffer.position(j + m);
    if (this.pendingTrimStartBytes > 0) {
      return;
    }
    k -= m;
    m = this.endBufferSize + k - this.endBuffer.length;
    if (this.buffer.capacity() < m) {
      this.buffer = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
    } else {
      this.buffer.clear();
    }
    j = Util.constrainValue(m, 0, this.endBufferSize);
    this.buffer.put(this.endBuffer, 0, j);
    m = Util.constrainValue(m - j, 0, k);
    paramByteBuffer.limit(paramByteBuffer.position() + m);
    this.buffer.put(paramByteBuffer);
    paramByteBuffer.limit(i);
    i = k - m;
    this.endBufferSize -= j;
    byte[] arrayOfByte = this.endBuffer;
    System.arraycopy(arrayOfByte, j, arrayOfByte, 0, this.endBufferSize);
    paramByteBuffer.get(this.endBuffer, this.endBufferSize, i);
    this.endBufferSize += i;
    this.buffer.flip();
    this.outputBuffer = this.buffer;
  }
  
  public void reset()
  {
    flush();
    this.buffer = EMPTY_BUFFER;
    this.channelCount = -1;
    this.sampleRateHz = -1;
    this.endBuffer = null;
  }
  
  public void setTrimSampleCount(int paramInt1, int paramInt2)
  {
    this.trimStartSamples = paramInt1;
    this.trimEndSamples = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.TrimmingAudioProcessor
 * JD-Core Version:    0.7.0.1
 */