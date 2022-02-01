package com.tencent.mobileqq.app.fms;

public class SearchCostStatistics
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public long e = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("M_size=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",C_size=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",R_size=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",K_len=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",time=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.SearchCostStatistics
 * JD-Core Version:    0.7.0.1
 */