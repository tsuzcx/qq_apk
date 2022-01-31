package com.tencent.biz.qqstory.utils;

import android.media.MediaFormat;

public class Image2Video$ResultInfo
{
  public int a;
  public long a;
  public MediaFormat a;
  public String a;
  public String b;
  
  public Image2Video$ResultInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    if (paramResultInfo == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramResultInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramResultInfo.jdField_a_of_type_Int;
    this.b = paramResultInfo.b;
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramResultInfo.jdField_a_of_type_AndroidMediaMediaFormat;
    this.jdField_a_of_type_JavaLangString = paramResultInfo.jdField_a_of_type_JavaLangString;
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
 * Qualified Name:     com.tencent.biz.qqstory.utils.Image2Video.ResultInfo
 * JD-Core Version:    0.7.0.1
 */