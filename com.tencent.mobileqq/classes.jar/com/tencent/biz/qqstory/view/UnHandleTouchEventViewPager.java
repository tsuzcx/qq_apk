package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class UnHandleTouchEventViewPager
  extends ViewPager
{
  protected boolean h;
  
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
    catch (IllegalArgumentException paramMotionEvent)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.h) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.h) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager
 * JD-Core Version:    0.7.0.1
 */