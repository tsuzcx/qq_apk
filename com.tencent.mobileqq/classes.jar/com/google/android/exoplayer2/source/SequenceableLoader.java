package com.google.android.exoplayer2.source;

public abstract interface SequenceableLoader
{
  public abstract boolean continueLoading(long paramLong);
  
  public abstract long getBufferedPositionUs();
  
  public abstract long getNextLoadPositionUs();
  
  public abstract void reevaluateBuffer(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SequenceableLoader
 * JD-Core Version:    0.7.0.1
 */