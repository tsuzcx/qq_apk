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
    return "UploadResult{errorMessage=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", fileKey='" + this.jdField_a_of_type_JavaLangString + '\'' + ", fileId='" + this.b + '\'' + ", uploadServerIp='" + this.d + '\'' + ", mLastUploadOffset='" + this.jdField_a_of_type_Int + '\'' + ", cdnUrl='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.UploadResult
 * JD-Core Version:    0.7.0.1
 */