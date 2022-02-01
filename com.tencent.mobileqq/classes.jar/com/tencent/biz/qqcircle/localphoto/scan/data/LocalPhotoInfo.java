package com.tencent.biz.qqcircle.localphoto.scan.data;

import java.util.List;

public class LocalPhotoInfo
{
  public int a;
  public String b;
  public String c;
  public long d;
  public long e;
  public int f;
  public int g;
  public int h;
  public float i;
  public float j;
  public List<LocalPhotoInfo.ImageTag> k;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalPhotoInfo{photoId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mineType='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", modifyTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", imageTags=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo
 * JD-Core Version:    0.7.0.1
 */