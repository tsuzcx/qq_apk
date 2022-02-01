package com.tencent.biz.richframework.animation.drawable;

import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;

public class AnimationDrawableCreateOption
{
  private String a;
  private boolean b;
  private long c;
  private int d;
  private int e;
  private RFWDownloadStrategy f;
  private boolean g;
  
  private AnimationDrawableCreateOption(AnimationDrawableCreateOption.Builder paramBuilder)
  {
    if (!TextUtils.isEmpty(AnimationDrawableCreateOption.Builder.a(paramBuilder))) {
      this.a = AnimationDrawableCreateOption.Builder.a(paramBuilder);
    }
    this.b = AnimationDrawableCreateOption.Builder.b(paramBuilder);
    long l;
    if (AnimationDrawableCreateOption.Builder.c(paramBuilder) > 0L) {
      l = AnimationDrawableCreateOption.Builder.c(paramBuilder);
    } else {
      l = 1000L;
    }
    this.c = l;
    this.d = AnimationDrawableCreateOption.Builder.d(paramBuilder);
    int i;
    if (AnimationDrawableCreateOption.Builder.e(paramBuilder) > 0) {
      i = AnimationDrawableCreateOption.Builder.e(paramBuilder);
    } else {
      i = 50;
    }
    this.e = i;
    this.g = AnimationDrawableCreateOption.Builder.f(paramBuilder);
    if (AnimationDrawableCreateOption.Builder.g(paramBuilder) != null) {
      paramBuilder = AnimationDrawableCreateOption.Builder.g(paramBuilder);
    } else {
      paramBuilder = QCircleDownloadConfig.a();
    }
    this.f = paramBuilder;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public RFWDownloadStrategy g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption
 * JD-Core Version:    0.7.0.1
 */