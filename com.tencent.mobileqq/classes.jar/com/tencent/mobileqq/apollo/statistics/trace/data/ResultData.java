package com.tencent.mobileqq.apollo.statistics.trace.data;

public class ResultData
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("errCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(this.b);
    if (this.c > 0)
    {
      localStringBuilder.append(",mem:");
      localStringBuilder.append(this.c);
    }
    if (this.d > 0)
    {
      localStringBuilder.append(",cpu:");
      localStringBuilder.append(this.d);
    }
    if (this.f != 0)
    {
      localStringBuilder.append(",javaHeap:");
      localStringBuilder.append(this.f);
    }
    if (this.g != 0)
    {
      localStringBuilder.append(",nativeHeap:");
      localStringBuilder.append(this.g);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.data.ResultData
 * JD-Core Version:    0.7.0.1
 */