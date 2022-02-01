package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.FixedSpeedScroller;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;

public class QFSViewPager
  extends ViewPagerCompat
{
  float a;
  float b;
  float c;
  float d;
  private QFSViewPager.OnSlideListener e;
  private boolean f = true;
  private boolean g = true;
  private int h;
  private int i;
  
  public QFSViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public QFSViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    FixedSpeedScroller localFixedSpeedScroller = new FixedSpeedScroller(getContext());
    localFixedSpeedScroller.a(400);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(this, localFixedSpeedScroller);
    }
    catch (Exception localException)
    {
      QLog.e("QFSViewPager", 1, "initViewPager error:", localException);
    }
    this.h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.i = ImmersiveUtils.getScreenWidth();
  }
  
  void a()
  {
    if (getCurrentItem() == 0)
    {
      float f1 = this.a;
      if (f1 < 100.0F)
      {
        float f2 = this.c;
        if ((f2 - f1 > 0.0F) && (f2 - f1 >= this.i / 10.0F)) {
          this.e.c();
        }
      }
    }
  }
  
  public void a(QFSViewPager.OnSlideListener paramOnSlideListener)
  {
    this.e = paramOnSlideListener;
  }
  
  void b()
  {
    if (this.e.a())
    {
      float f1 = this.a;
      float f2 = this.c;
      if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.i / 4.0F) && (this.f)) {
        this.e.b();
      }
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView != this) && ((paramView instanceof QFSViewPager)))
    {
      QFSViewPager localQFSViewPager = (QFSViewPager)paramView;
      if (!localQFSViewPager.getScrollable()) {
        return localQFSViewPager.canScroll(paramView, false, paramInt1, paramInt2, paramInt3);
      }
    }
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        float f2 = Math.abs(this.a - f1);
        f3 = Math.abs(this.b - f3);
        if ((this.e.a()) && (this.a - f1 > this.h))
        {
          double d1 = f2;
          double d2 = Math.tan(0.5235987755982988D);
          Double.isNaN(d1);
          if (d1 * d2 > f3) {
            return this.f;
          }
        }
      }
    }
    else
    {
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      b();
      a();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt, this.g);
  }
  
  public void setEnableSlideRightAction(boolean paramBoolean)
  {
    QFSViewPager.OnSlideListener localOnSlideListener = this.e;
    if (localOnSlideListener != null)
    {
      if (!localOnSlideListener.a()) {
        return;
      }
      this.f = paramBoolean;
    }
  }
  
  public void setScrollWithAnim(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSViewPager
 * JD-Core Version:    0.7.0.1
 */