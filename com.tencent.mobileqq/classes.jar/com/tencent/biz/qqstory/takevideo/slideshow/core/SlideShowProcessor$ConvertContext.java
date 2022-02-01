package com.tencent.biz.qqstory.takevideo.slideshow.core;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;

public class SlideShowProcessor$ConvertContext
  extends SlideShowProcessor.TaskContext
{
  public String a;
  public int b;
  public int c;
  public long d;
  public SlideItemInfo e;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  private boolean m;
  
  public SlideShowProcessor$ConvertContext() {}
  
  public SlideShowProcessor$ConvertContext(long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, SlideShowProcessor.SlideShowProcessListener paramSlideShowProcessListener, boolean paramBoolean)
  {
    this.k = paramLong1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong2;
    this.e = paramSlideItemInfo;
    this.a = paramSlideItemInfo.f;
    this.l = paramSlideShowProcessListener;
    this.m = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.ConvertContext
 * JD-Core Version:    0.7.0.1
 */