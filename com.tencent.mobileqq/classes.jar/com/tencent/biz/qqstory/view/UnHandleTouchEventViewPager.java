package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UnHandleTouchEventViewPager
  extends ViewPager
{
  protected boolean a;
  
  public UnHandleTouchEventViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public UnHandleTouchEventViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.a) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.a) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager
 * JD-Core Version:    0.7.0.1
 */