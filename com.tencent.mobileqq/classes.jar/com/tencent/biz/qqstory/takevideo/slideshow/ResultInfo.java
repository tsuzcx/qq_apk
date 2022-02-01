package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaFormat;

public class ResultInfo
{
  public long a = -1L;
  public int b = -1;
  public String c;
  public String d;
  public MediaFormat e;
  public String f;
  long g;
  long h;
  public boolean i = false;
  public int j = 1;
  
  public void a(ResultInfo paramResultInfo)
  {
    if (paramResultInfo == null) {
      return;
    }
    this.a = paramResultInfo.a;
    this.b = paramResultInfo.b;
    this.d = paramResultInfo.d;
    this.e = paramResultInfo.e;
    this.c = paramResultInfo.c;
    this.g = paramResultInfo.g;
    this.h = paramResultInfo.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Image2result.result ");
    localStringBuilder.append("src: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("result ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo
 * JD-Core Version:    0.7.0.1
 */