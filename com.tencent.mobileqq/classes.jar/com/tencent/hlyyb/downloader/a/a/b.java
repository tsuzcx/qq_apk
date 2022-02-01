package com.tencent.hlyyb.downloader.a.a;

public final class b
{
  public long a = 0L;
  public long b = 0L;
  
  public b(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((this.a == paramObject.a) && (this.b == paramObject.b)) {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    return "[" + this.a + "," + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a.b
 * JD-Core Version:    0.7.0.1
 */