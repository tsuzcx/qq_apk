package com.tencent.hippy.qq.view.tkd.doublescrollview;

public class FixLengthQueue
{
  int length;
  long[] longs;
  int size;
  int start = 0;
  
  FixLengthQueue(int paramInt)
  {
    this.longs = new long[paramInt];
    this.length = paramInt;
  }
  
  public void add(long paramLong)
  {
    long[] arrayOfLong = this.longs;
    int i = this.start;
    arrayOfLong[i] = paramLong;
    this.start = (i + 1);
    if (this.start >= this.length) {
      this.start = 0;
    }
    i = this.size;
    if (i < this.length) {
      this.size = (i + 1);
    }
  }
  
  public long getEnd()
  {
    int j = this.size;
    if (j == 0) {
      return 0L;
    }
    int i = this.length;
    if (j == i)
    {
      j = this.start;
      if (j == 0) {
        return this.longs[(i - 1)];
      }
      return this.longs[(j - 1)];
    }
    return this.longs[(j - 1)];
  }
  
  public long getFirst()
  {
    int i = this.size;
    int j = this.length;
    if (i != j) {
      return this.longs[0];
    }
    if (i == 0) {
      return 0L;
    }
    if (i == j) {
      return this.longs[this.start];
    }
    return 0L;
  }
  
  public void refreash()
  {
    this.start = 0;
    this.size = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.FixLengthQueue
 * JD-Core Version:    0.7.0.1
 */