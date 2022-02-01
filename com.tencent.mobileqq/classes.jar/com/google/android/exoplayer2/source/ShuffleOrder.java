package com.google.android.exoplayer2.source;

public abstract interface ShuffleOrder
{
  public abstract ShuffleOrder cloneAndClear();
  
  public abstract ShuffleOrder cloneAndInsert(int paramInt1, int paramInt2);
  
  public abstract ShuffleOrder cloneAndRemove(int paramInt);
  
  public abstract int getFirstIndex();
  
  public abstract int getLastIndex();
  
  public abstract int getLength();
  
  public abstract int getNextIndex(int paramInt);
  
  public abstract int getPreviousIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ShuffleOrder
 * JD-Core Version:    0.7.0.1
 */