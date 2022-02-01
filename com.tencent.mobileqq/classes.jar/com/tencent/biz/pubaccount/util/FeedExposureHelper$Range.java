package com.tencent.biz.pubaccount.util;

public class FeedExposureHelper$Range
{
  public int a;
  public long a;
  public int b = -1;
  
  public FeedExposureHelper$Range()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" starPosition: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("  endPostition: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FeedExposureHelper.Range
 * JD-Core Version:    0.7.0.1
 */