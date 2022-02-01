package com.tencent.mobileqq.apollo.statistics.trace.data;

public class AnnotationData
{
  public long a;
  public long b;
  public String c;
  
  public AnnotationData(String paramString, long paramLong1, long paramLong2)
  {
    this.c = paramString;
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.data.AnnotationData
 * JD-Core Version:    0.7.0.1
 */