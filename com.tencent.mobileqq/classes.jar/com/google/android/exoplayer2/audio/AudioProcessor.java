package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface AudioProcessor
{
  public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract boolean configure(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void flush();
  
  public abstract ByteBuffer getOutput();
  
  public abstract int getOutputChannelCount();
  
  public abstract int getOutputEncoding();
  
  public abstract int getOutputSampleRateHz();
  
  public abstract boolean isActive();
  
  public abstract boolean isEnded();
  
  public abstract void queueEndOfStream();
  
  public abstract void queueInput(ByteBuffer paramByteBuffer);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioProcessor
 * JD-Core Version:    0.7.0.1
 */