package com.tencent.mobileqq.ark.module;

class TokenBucket
{
  private long a;
  private long b;
  private double c;
  private long d;
  
  public TokenBucket(long paramLong1, long paramLong2)
  {
    this.b = paramLong2;
    this.a = paramLong1;
    this.c = paramLong1;
    this.d = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    if (this.a == -1L) {
      return true;
    }
    if (this.b > 0L)
    {
      long l1 = System.currentTimeMillis();
      double d1 = this.c;
      double d2 = l1 - this.d;
      long l2 = this.a;
      double d3 = l2;
      Double.isNaN(d2);
      Double.isNaN(d3);
      double d4 = this.b;
      Double.isNaN(d4);
      this.c = Math.min(d1 + d2 * d3 / d4, l2);
      this.d = l1;
      d1 = this.c;
      if (d1 >= 1.0D)
      {
        this.c = (d1 - 1.0D);
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TokenBucket)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return String.format("TokenBucket:mTimes:%d,mPeriod:%d,mTokenCount:%f,mLastTimestamp:%d", new Object[] { Long.valueOf(this.a), Long.valueOf(this.b), Double.valueOf(this.c), Long.valueOf(this.d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.TokenBucket
 * JD-Core Version:    0.7.0.1
 */