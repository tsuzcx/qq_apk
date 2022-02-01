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
    return "jumpType = " + this.jdField_a_of_type_Int + "reportForClick = " + this.jdField_a_of_type_Boolean + "autoDownload = " + this.jdField_b_of_type_Boolean + "videoStartPositionMillis = " + this.jdField_a_of_type_Long + "isAutoPlaying = " + this.c + "filterVideoCeiling = " + this.d + "position = " + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams
 * JD-Core Version:    0.7.0.1
 */