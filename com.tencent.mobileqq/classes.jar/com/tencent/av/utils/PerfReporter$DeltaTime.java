package com.tencent.av.utils;

import java.util.Vector;

class PerfReporter$DeltaTime
{
  public long a;
  public PerfReporter.CalResult a;
  public Vector<Integer> a;
  
  private PerfReporter$DeltaTime()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilVector = new Vector(10000);
    this.jdField_a_of_type_ComTencentAvUtilsPerfReporter$CalResult = new PerfReporter.CalResult(null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeltaTime{start=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", deltas=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilVector);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.DeltaTime
 * JD-Core Version:    0.7.0.1
 */