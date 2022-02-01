package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.ErrorMessage;

public class UploadResult
{
  public int a;
  public ErrorMessage a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public UploadResult()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadResult{errorMessage=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuilder.append(", fileKey='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadServerIp='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLastUploadOffset='");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cdnUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.UploadResult
 * JD-Core Version:    0.7.0.1
 */