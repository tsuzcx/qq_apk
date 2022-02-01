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
    this.longs[this.start] = paramLong;
    this.start += 1;
    if (this.start >= this.length) {
      this.start = 0;
    }
    if (this.size < this.length) {
      this.size += 1;
    }
  }
  
  public long getEnd()
  {
    if (this.size == 0) {
      return 0L;
    }
    if (this.size == this.length)
    {
      if (this.start == 0) {
        return this.longs[(this.length - 1)];
      }
      return this.longs[(this.start - 1)];
    }
    return this.longs[(this.size - 1)];
  }
  
  public long getFirst()
  {
    long l2 = 0L;
    long l1;
    if (this.size != this.length) {
      l1 = this.longs[0];
    }
    do
    {
      do
      {
        return l1;
        l1 = l2;
      } while (this.size == 0);
      l1 = l2;
    } while (this.size != this.length);
    return this.longs[this.start];
  }
  
  public void refreash()
  {
    this.start = 0;
    this.size = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.FixLengthQueue
 * JD-Core Version:    0.7.0.1
 */