package com.tencent.mfsdk.collector;

public final class DropResultObject
{
  public int a;
  public long a;
  public long[] a;
  public long b;
  
  public DropResultObject()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L, 0L };
  }
  
  public DropResultObject(long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L, 0L };
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = 0L;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.mfsdk.collector.DropResultObject
 * JD-Core Version:    0.7.0.1
 */