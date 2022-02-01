package com.tencent.mobileqq.ar;

public class GapDataCollector$RefreshData
{
  public int a;
  public long a;
  public long[] a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public GapDataCollector$RefreshData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, double paramDouble, long[] paramArrayOfLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = ((paramDouble + 0.9D));
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("70% :  ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" --------- 80% : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" --------- 90% : ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" --------- min : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" --------- max : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" --------- num : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("--------arr");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfLong);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.GapDataCollector.RefreshData
 * JD-Core Version:    0.7.0.1
 */