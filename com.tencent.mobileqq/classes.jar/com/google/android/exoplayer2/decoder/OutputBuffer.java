package com.google.android.exoplayer2.decoder;

public abstract class OutputBuffer
  extends Buffer
{
  public int skippedOutputBufferCount;
  public long timeUs;
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.OutputBuffer
 * JD-Core Version:    0.7.0.1
 */