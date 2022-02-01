package com.tencent.biz.richframework.animation.drawable;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;

public class AnimationDrawableCreateOption$Builder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RFWDownloadStrategy jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public AnimationDrawableCreateOption$Builder(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public AnimationDrawableCreateOption a()
  {
    return new AnimationDrawableCreateOption(this, null);
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder
 * JD-Core Version:    0.7.0.1
 */