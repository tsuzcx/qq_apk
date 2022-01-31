package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;

public class CustomViewPager
  extends ViewPager
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public float a;
  public GestureDetector.SimpleOnGestureListener a;
  public BetterGestureDetector a;
  public boolean a;
  public float b;
  public float c;
  public float d;
  
  public CustomViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector = new BetterGestureDetector(paramContext, this);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector.a(this);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onDoubleTap(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onDoubleTapEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onDown(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = SystemClock.uptimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    SLog.a("Q.qqstory.player.ViewPager", "onLayout, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onLongPress(paramMotionEvent);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onShowPress(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onSingleTapConfirmed(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener != null) {
      return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener.onSingleTapUp(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector.a(paramMotionEvent);
    if (!this.jdField_a_of_type_Boolean) {
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent) {}
      this.b = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.jdField_a_of_type_Float += Math.abs(f1 - this.c);
      this.b += Math.abs(f2 - this.d);
      this.c = f1;
      this.d = f2;
      if (this.jdField_a_of_type_Float <= this.b)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      }
    }
    return false;
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    long l = SystemClock.uptimeMillis();
    super.setAdapter(paramPagerAdapter);
    SLog.a("Q.qqstory.player.ViewPager", "setAdapter, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void setGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = paramSimpleOnGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */