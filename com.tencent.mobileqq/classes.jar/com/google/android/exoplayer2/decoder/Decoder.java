package com.google.android.exoplayer2.decoder;

public abstract interface Decoder<I, O, E extends Exception>
{
  public abstract I dequeueInputBuffer();
  
  public abstract O dequeueOutputBuffer();
  
  public abstract void flush();
  
  public abstract String getName();
  
  public abstract void queueInputBuffer(I paramI);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.Decoder
 * JD-Core Version:    0.7.0.1
 */