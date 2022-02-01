package com.tencent.biz.richframework.animation.drawable;

import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;

public class AnimationDrawableCreateOption
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RFWDownloadStrategy jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private AnimationDrawableCreateOption(AnimationDrawableCreateOption.Builder paramBuilder)
  {
    if (!TextUtils.isEmpty(AnimationDrawableCreateOption.Builder.a(paramBuilder))) {
      this.jdField_a_of_type_JavaLangString = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    }
    this.jdField_a_of_type_Boolean = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    long l;
    if (AnimationDrawableCreateOption.Builder.a(paramBuilder) > 0L) {
      l = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    } else {
      l = 1000L;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Int = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    int i;
    if (AnimationDrawableCreateOption.Builder.b(paramBuilder) > 0) {
      i = AnimationDrawableCreateOption.Builder.b(paramBuilder);
    } else {
      i = 50;
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_b_of_type_Boolean = AnimationDrawableCreateOption.Builder.b(paramBuilder);
    if (AnimationDrawableCreateOption.Builder.a(paramBuilder) != null) {
      paramBuilder = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    } else {
      paramBuilder = QCircleDownloadConfig.a();
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy = paramBuilder;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public RFWDownloadStrategy a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWDownloadStrategy;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption
 * JD-Core Version:    0.7.0.1
 */