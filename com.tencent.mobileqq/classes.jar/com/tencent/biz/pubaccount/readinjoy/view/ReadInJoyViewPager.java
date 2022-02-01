package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class ReadInJoyViewPager
  extends ViewPager
{
  public ReadInJoyViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getX() <= getWidth() / 8) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyViewPager
 * JD-Core Version:    0.7.0.1
 */