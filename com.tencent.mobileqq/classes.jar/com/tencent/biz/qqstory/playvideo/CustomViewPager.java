package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CustomViewPager
  extends ViewPager
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public GestureDetector.SimpleOnGestureListener a;
  public BetterGestureDetector b = new BetterGestureDetector(paramContext, this);
  public float c;
  public float d;
  public float e;
  public float f;
  public boolean g = true;
  
  public CustomViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.a(this);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      try
      {
        Object localObject = ViewPager.class.getDeclaredField("mDrawingOrderedChildren");
        ((Field)localObject).setAccessible(true);
        localObject = (ArrayList)((Field)localObject).get(this);
        if ((localObject == null) || (((ArrayList)localObject).size() != getChildCount()))
        {
          SLog.d("Q.qqstory.player.ViewPager", "getChildDrawingOrder invoke sortChildDrawingOrder() by ourselves !");
          localObject = ViewPager.class.getDeclaredMethod("sortChildDrawingOrder", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(this, new Object[0]);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        SLog.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchFieldException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        SLog.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        SLog.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        SLog.c("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchMethodException);
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onDoubleTap(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onDoubleTapEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onDown(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.g) {
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
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      localSimpleOnGestureListener.onLongPress(paramMotionEvent);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      localSimpleOnGestureListener.onShowPress(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onSingleTapConfirmed(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.a;
    if (localSimpleOnGestureListener != null) {
      return localSimpleOnGestureListener.onSingleTapUp(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.b.a(paramMotionEvent);
    if (!this.g) {
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.c += Math.abs(f1 - this.e);
        this.d += Math.abs(f2 - this.f);
        this.e = f1;
        this.f = f2;
        if (this.c <= this.d)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
    }
    else
    {
      this.d = 0.0F;
      this.c = 0.0F;
      this.e = paramMotionEvent.getX();
      this.f = paramMotionEvent.getY();
    }
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
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
    this.a = paramSimpleOnGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */