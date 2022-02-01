package com.tencent.mobileqq.ark.module;

class TokenBucket
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private long b;
  private long c;
  
  public TokenBucket(long paramLong1, long paramLong2)
  {
    this.b = paramLong2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Double = paramLong1;
    this.c = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return true;
    }
    if (this.b > 0L)
    {
      long l1 = System.currentTimeMillis();
      double d1 = this.jdField_a_of_type_Double;
      double d2 = l1 - this.c;
      long l2 = this.jdField_a_of_type_Long;
      double d3 = l2;
      Double.isNaN(d2);
      Double.isNaN(d3);
      double d4 = this.b;
      Double.isNaN(d4);
      this.jdField_a_of_type_Double = Math.min(d1 + d2 * d3 / d4, l2);
      this.c = l1;
      d1 = this.jdField_a_of_type_Double;
      if (d1 >= 1.0D)
      {
        this.jdField_a_of_type_Double = (d1 - 1.0D);
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
      if (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) {
        return false;
      }
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.jdField_a_of_type_Long;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return String.format("TokenBucket:mTimes:%d,mPeriod:%d,mTokenCount:%f,mLastTimestamp:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), Double.valueOf(this.jdField_a_of_type_Double), Long.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.TokenBucket
 * JD-Core Version:    0.7.0.1
 */