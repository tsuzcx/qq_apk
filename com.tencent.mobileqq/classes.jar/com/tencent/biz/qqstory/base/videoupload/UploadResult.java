package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.ErrorMessage;

public class UploadResult
{
  public ErrorMessage a = new ErrorMessage();
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadResult{errorMessage=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", fileKey='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadServerIp='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLastUploadOffset='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cdnUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.UploadResult
 * JD-Core Version:    0.7.0.1
 */