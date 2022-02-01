package com.tencent.mobileqq.banner;

import android.view.MotionEvent;
import android.widget.FrameLayout;

public class BannerFrameLayout
  extends FrameLayout
{
  private boolean a;
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAnimEnd(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerFrameLayout
 * JD-Core Version:    0.7.0.1
 */