package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import veg;
import vxu;

public class CustomViewPager
  extends ViewPager
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public float a;
  public GestureDetector.SimpleOnGestureListener a;
  public vxu a;
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
    this.jdField_a_of_type_Vxu = new vxu(paramContext, this);
    this.jdField_a_of_type_Vxu.a(this);
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Object localObject = ViewPager.class.getDeclaredField("mDrawingOrderedChildren");
      ((Field)localObject).setAccessible(true);
      localObject = (ArrayList)((Field)localObject).get(this);
      if ((localObject == null) || (((ArrayList)localObject).size() != getChildCount()))
      {
        veg.d("Q.qqstory.player.ViewPager", "getChildDrawingOrder invoke sortChildDrawingOrder() by ourselves !");
        localObject = ViewPager.class.getDeclaredMethod("sortChildDrawingOrder", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(this, new Object[0]);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchMethodException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localInvocationTargetException);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchFieldException);
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = SystemClock.uptimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    veg.a("Q.qqstory.player.ViewPager", "onLayout, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
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
    boolean bool = this.jdField_a_of_type_Vxu.a(paramMotionEvent);
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
    veg.a("Q.qqstory.player.ViewPager", "setAdapter, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void setGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = paramSimpleOnGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */