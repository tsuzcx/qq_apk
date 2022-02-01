package com.tencent.av.ui;

import com.tencent.av.gaudio.AVPhoneUserInfo;

public class VideoMemberInfo
{
  public int a = 0;
  public long b = 0L;
  public String c = null;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public AVPhoneUserInfo g = null;
  public boolean h = false;
  public boolean i = false;
  public long j = 4L;
  public boolean k = false;
  public boolean l = false;
  public int m = 0;
  public boolean n = false;
  
  public int a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.m;
  }
  
  public boolean d()
  {
    return this.m == 2;
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    return (this.e) && (!this.h);
  }
  
  public long g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(',');
    localStringBuilder.append("videoSrc:=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(',');
    localStringBuilder.append("isVideoIn:=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(',');
    localStringBuilder.append("isAttened:=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(',');
    localStringBuilder.append("isSpeaking:=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(',');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoMemberInfo
 * JD-Core Version:    0.7.0.1
 */