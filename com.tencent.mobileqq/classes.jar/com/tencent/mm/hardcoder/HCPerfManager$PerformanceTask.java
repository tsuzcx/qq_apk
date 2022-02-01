package com.tencent.mm.hardcoder;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class HCPerfManager$PerformanceTask
  extends RecyclablePool.Recyclable
{
  public int a;
  public long a;
  public String a;
  public int[] a;
  public long[] a;
  public int b;
  public long b;
  public int[] b;
  public long[] b;
  public int c;
  public long c;
  public int[] c;
  public int d;
  public long d;
  public int e;
  long e;
  public int f;
  public long f;
  public int g;
  public long g;
  int h;
  public long h;
  int i;
  public long i;
  public int j = 0;
  
  public HCPerfManager$PerformanceTask()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfInt = new int[HCPerfManager.a().length];
    this.jdField_b_of_type_ArrayOfInt = new int[HCPerfManager.b().length];
    this.jdField_c_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_b_of_type_ArrayOfLong = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
  }
  
  public String a(long paramLong)
  {
    return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.jdField_c_of_type_Long - paramLong), Long.valueOf(this.jdField_b_of_type_Long - paramLong), Long.valueOf(this.jdField_d_of_type_Long - paramLong), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_f_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_g_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HCPerfManager.PerformanceTask
 * JD-Core Version:    0.7.0.1
 */