package com.tencent.mobileqq.ar;

public class GapDataCollector$RefreshData
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long[] g;
  public int h;
  
  public GapDataCollector$RefreshData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, double paramDouble, long[] paramArrayOfLong, int paramInt)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = ((paramDouble + 0.9D));
    this.h = paramInt;
    this.g = paramArrayOfLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("70% :  ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" --------- 80% : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" --------- 90% : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" --------- min : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" --------- max : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" --------- num : ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("--------arr");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.GapDataCollector.RefreshData
 * JD-Core Version:    0.7.0.1
 */