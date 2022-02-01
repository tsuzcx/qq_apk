package com.tencent.biz.pubaccount.util;

public class FeedExposureHelper$Range
{
  public long a;
  public int b = -1;
  public int c = -1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" starPosition: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  endPostition: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FeedExposureHelper.Range
 * JD-Core Version:    0.7.0.1
 */