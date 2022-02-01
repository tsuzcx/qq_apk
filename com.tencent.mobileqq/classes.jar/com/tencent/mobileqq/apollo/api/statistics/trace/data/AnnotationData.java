package com.tencent.mobileqq.apollo.api.statistics.trace.data;

public class AnnotationData
{
  public long a;
  public String a;
  public long b;
  
  public AnnotationData(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.statistics.trace.data.AnnotationData
 * JD-Core Version:    0.7.0.1
 */