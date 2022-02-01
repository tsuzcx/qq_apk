package com.tencent.biz.pubaccount.readinjoy.video;

public class VideoUploadItemInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  public VideoUploadItemInfo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-").append("fileWidth:").append(this.e);
    localStringBuilder.append("\n |-").append("fileHeight:").append(this.f);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUploadItemInfo
 * JD-Core Version:    0.7.0.1
 */