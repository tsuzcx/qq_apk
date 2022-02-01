package com.tencent.av.ui;

import com.tencent.av.gaudio.AVPhoneUserInfo;

public class VideoMemberInfo
{
  public int a;
  public long a;
  public AVPhoneUserInfo a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  
  public VideoMemberInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = null;
    this.jdField_b_of_type_Long = 4L;
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
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
    return this.jdField_b_of_type_Int == 2;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Boolean) && (!this.d);
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(',');
    localStringBuilder.append("videoSrc:=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(',');
    localStringBuilder.append("isVideoIn:=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(',');
    localStringBuilder.append("isAttened:=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(',');
    localStringBuilder.append("isSpeaking:=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(',');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoMemberInfo
 * JD-Core Version:    0.7.0.1
 */