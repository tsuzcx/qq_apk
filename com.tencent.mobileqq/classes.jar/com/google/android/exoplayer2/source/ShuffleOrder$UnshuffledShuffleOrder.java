package com.google.android.exoplayer2.source;

public final class ShuffleOrder$UnshuffledShuffleOrder
  implements ShuffleOrder
{
  private final int length;
  
  public ShuffleOrder$UnshuffledShuffleOrder(int paramInt)
  {
    this.length = paramInt;
  }
  
  public ShuffleOrder cloneAndClear()
  {
    return new UnshuffledShuffleOrder(0);
  }
  
  public ShuffleOrder cloneAndInsert(int paramInt1, int paramInt2)
  {
    return new UnshuffledShuffleOrder(this.length + paramInt2);
  }
  
  public ShuffleOrder cloneAndRemove(int paramInt)
  {
    return new UnshuffledShuffleOrder(this.length - 1);
  }
  
  public int getFirstIndex()
  {
    if (this.length > 0) {
      return 0;
    }
    return -1;
  }
  
  public int getLastIndex()
  {
    if (this.length > 0) {
      return this.length - 1;
    }
    return -1;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public int getNextIndex(int paramInt)
  {
    paramInt += 1;
    if (paramInt < this.length) {
      return paramInt;
    }
    return -1;
  }
  
  public int getPreviousIndex(int paramInt)
  {
    paramInt -= 1;
    if (paramInt >= 0) {
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder
 * JD-Core Version:    0.7.0.1
 */