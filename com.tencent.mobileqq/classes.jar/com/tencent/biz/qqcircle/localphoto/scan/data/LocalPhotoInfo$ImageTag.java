package com.tencent.biz.qqcircle.localphoto.scan.data;

public class LocalPhotoInfo$ImageTag
{
  public String a;
  public String b;
  public float c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageTag{classifyType='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", classifyName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", classifyConfidence=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo.ImageTag
 * JD-Core Version:    0.7.0.1
 */