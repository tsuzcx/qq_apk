package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaFormat;

public class ResultInfo
{
  public int a;
  public long a;
  public MediaFormat a;
  public String a;
  public boolean a;
  public int b;
  long b;
  public String b;
  long c;
  public String c;
  
  public ResultInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    if (paramResultInfo == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramResultInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramResultInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramResultInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramResultInfo.jdField_a_of_type_AndroidMediaMediaFormat;
    this.jdField_a_of_type_JavaLangString = paramResultInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramResultInfo.jdField_b_of_type_Long;
    this.c = paramResultInfo.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Image2result.result ").append("src: ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("result ").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo
 * JD-Core Version:    0.7.0.1
 */