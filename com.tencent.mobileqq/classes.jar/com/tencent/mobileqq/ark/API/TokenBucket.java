package com.tencent.mobileqq.ark.API;

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
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Double = Math.min(this.jdField_a_of_type_Double + (l - this.c) * this.jdField_a_of_type_Long / this.b, this.jdField_a_of_type_Long);
      this.c = l;
      if (this.jdField_a_of_type_Double >= 1.0D)
      {
        this.jdField_a_of_type_Double -= 1.0D;
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TokenBucket)paramObject;
      if (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) {
        return false;
      }
    } while (this.b == paramObject.b);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.jdField_a_of_type_Long ^ this.jdField_a_of_type_Long >>> 32) * 31 + (int)(this.b ^ this.b >>> 32);
  }
  
  public String toString()
  {
    return String.format("TokenBucket:mTimes:%d,mPeriod:%d,mTokenCount:%f,mLastTimestamp:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), Double.valueOf(this.jdField_a_of_type_Double), Long.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.TokenBucket
 * JD-Core Version:    0.7.0.1
 */