package com.tencent.biz.qqcircle.localphoto.scan.data;

class ExpandExifInterface$Rational
{
  public final long a;
  public final long b;
  
  private ExpandExifInterface$Rational(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L)
    {
      this.a = 0L;
      this.b = 1L;
      return;
    }
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public double a()
  {
    double d1 = this.a;
    double d2 = this.b;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("/");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.ExpandExifInterface.Rational
 * JD-Core Version:    0.7.0.1
 */