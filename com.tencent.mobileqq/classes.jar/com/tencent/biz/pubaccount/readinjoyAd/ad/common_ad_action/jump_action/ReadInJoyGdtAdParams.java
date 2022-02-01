package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import org.jetbrains.annotations.NotNull;

public class ReadInJoyGdtAdParams
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c = true;
  public boolean d;
  
  public ReadInJoyGdtAdParams()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("reportForClick = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("autoDownload = ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("videoStartPositionMillis = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("isAutoPlaying = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("filterVideoCeiling = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("position = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams
 * JD-Core Version:    0.7.0.1
 */