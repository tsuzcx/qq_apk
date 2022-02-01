package com.tencent.biz.richframework.animation.drawable;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;

public class AnimationDrawableCreateOption$Builder
{
  private String a;
  private boolean b;
  private long c;
  private int d;
  private int e;
  private boolean f;
  private RFWDownloadStrategy g;
  
  public AnimationDrawableCreateOption$Builder(String paramString)
  {
    this.a = paramString;
  }
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public AnimationDrawableCreateOption a()
  {
    return new AnimationDrawableCreateOption(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder
 * JD-Core Version:    0.7.0.1
 */