package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.AutoFitScroller;
import com.tencent.qphone.base.util.QLog;

public class MultilScreenlLayout
  extends FrameLayout
{
  protected MultilScreenlLayout.OnClickScrollLayoutListener a;
  private AutoFitScroller b;
  private VelocityTracker c;
  private int d;
  private int e = 0;
  private int f = 600;
  private int g = 0;
  private int h;
  private float i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o = 1;
  private int p;
  private int q;
  private float r;
  private float s;
  private boolean t;
  
  public MultilScreenlLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MultilScreenlLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.c;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    int i1 = (int)((VelocityTracker)localObject).getXVelocity();
    if ((i1 > this.f) && (this.d > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent velocityX > mMinVelocity mCurScreen:");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" velocityX:");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MutilScreenlLayout", 2, ((StringBuilder)localObject).toString());
      }
      a(this.d - 1);
    }
    else if ((i1 < -this.f) && (this.d < super.getChildCount() - 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent velocityX < -mMinVelocity mCurScreen:");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" velocityX:");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MutilScreenlLayout", 2, ((StringBuilder)localObject).toString());
      }
      a(this.d + 1);
    }
    else
    {
      a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent velocityX:");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MutilScreenlLayout", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.c = null;
    }
    this.g = 0;
    b(paramMotionEvent);
  }
  
  private void b()
  {
    this.b = new AutoFitScroller(getContext());
    this.d = this.e;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.h = localViewConfiguration.getScaledTouchSlop();
    this.f = (localViewConfiguration.getScaledMinimumFlingVelocity() * 2);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (Math.hypot(Math.abs(this.s - f1), Math.abs(this.r - f2)) > this.h) {
      this.t = true;
    }
    if ((!this.t) && (this.a != null))
    {
      int i4 = super.getChildCount();
      int i3 = 0;
      int i2 = 0;
      int i5 = this.d;
      int i1 = i3;
      if (i5 >= 0)
      {
        i1 = i3;
        if (i5 < i4)
        {
          paramMotionEvent = super.getChildAt(i5);
          i3 = paramMotionEvent.getLeft() - super.getScrollX();
          i1 = i2;
          if (f1 < i3)
          {
            i1 = i2;
            if (f1 > i3 - this.k) {
              i1 = 1;
            }
          }
          i3 = paramMotionEvent.getRight() - super.getScrollX();
          i2 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            if (f1 > i3)
            {
              i2 = i1;
              if (f1 < i3 + this.k) {
                i2 = 1;
              }
            }
          }
          i3 = i2;
          if (i2 == 0)
          {
            i3 = i2;
            if (f1 < this.l - super.getScrollX()) {
              i3 = 1;
            }
          }
          i1 = i3;
          if (i3 == 0)
          {
            i1 = i3;
            if (f1 > this.n + super.getWidth() - super.getScrollX() - this.l) {
              i1 = 1;
            }
          }
        }
      }
      if (i1 != 0) {
        this.a.a(f1, f2);
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (!this.b.a()) {
      this.b.e();
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.i = f1;
    this.s = f1;
    this.r = f2;
    this.t = false;
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i2 = (int)(this.i - f1);
    this.i = f1;
    int i3 = super.getScrollX();
    int i1 = i2;
    if (i3 + i2 <= 0) {
      i1 = -i3;
    }
    int i4 = this.n;
    i2 = i1;
    if (i3 + i1 >= i4) {
      i2 = i4 - i3;
    }
    if (i2 != 0) {
      scrollBy(i2, 0);
    }
    if (Math.hypot(Math.abs(this.s - f1), Math.abs(this.r - f2)) > this.h) {
      this.t = true;
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    this.g = 0;
  }
  
  private int getFrameWith()
  {
    int i1 = this.j;
    if (i1 == 0) {
      return getWidth();
    }
    return i1 + this.k;
  }
  
  public void a()
  {
    a((getScrollX() + getFrameWith() / 2) / getFrameWith());
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapToScreen before change whichScreen:");
      localStringBuilder.append(paramInt);
      QLog.d("MutilScreenlLayout", 2, localStringBuilder.toString());
    }
    int i1 = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    paramInt = getFrameWith() * i1;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapToScreen dest:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" getScrollX():");
      localStringBuilder.append(getScrollX());
      localStringBuilder.append(" afterchange whichScreen:");
      localStringBuilder.append(i1);
      QLog.d("MutilScreenlLayout", 2, localStringBuilder.toString());
    }
    if (getScrollX() != paramInt)
    {
      int i2 = paramInt - getScrollX();
      paramInt = Math.abs(i2) / 2;
      if (paramInt < 300) {
        paramInt = 300;
      }
      this.b.a(getScrollX(), 0, i2, 0, paramInt);
      this.d = i1;
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    if (this.b.d())
    {
      super.scrollTo(this.b.b(), this.b.c());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.g != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    paramMotionEvent.getY();
    boolean bool2 = false;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label105;
          }
        }
        else
        {
          if ((int)Math.abs(this.i - f1) <= this.h) {
            break label105;
          }
          this.g = 1;
          break label105;
        }
      }
      this.g = 0;
    }
    else
    {
      this.i = f1;
      this.g = (this.b.a() ^ true);
    }
    label105:
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("onInterceptTouchEvent mTouchState != TOUCH_STATE_REST ");
      if (this.g != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramMotionEvent.append(bool1);
      QLog.d("MutilScreenlLayout", 2, paramMotionEvent.toString());
    }
    boolean bool1 = bool2;
    if (this.g != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.o == 1)
    {
      paramInt2 = this.l + this.k;
      paramInt4 = super.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        View localView = super.getChildAt(paramInt1);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = getFrameWith();
          int i1 = this.q;
          localView.layout(paramInt2, i1, this.j + paramInt2, this.p + i1);
          paramInt3 = paramInt2 + paramInt3;
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
      this.n = (paramInt2 + this.m - super.getWidth());
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.o == 0) {
      return true;
    }
    if (this.c == null) {
      this.c = VelocityTracker.obtain();
    }
    this.c.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            e(paramMotionEvent);
          }
        }
        else {
          d(paramMotionEvent);
        }
      }
      else {
        a(paramMotionEvent);
      }
    }
    else {
      c(paramMotionEvent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "onTouchEvent ");
    }
    return true;
  }
  
  public void setClickLayoutListener(MultilScreenlLayout.OnClickScrollLayoutListener paramOnClickScrollLayoutListener)
  {
    this.a = paramOnClickScrollLayoutListener;
  }
  
  public void setCurrentFrame(int paramInt)
  {
    this.d = paramInt;
    super.scrollTo(paramInt * getFrameWith(), 0);
  }
  
  public void setFrameWidth(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.j = paramInt1;
    this.k = paramInt4;
    this.l = paramInt5;
    this.m = paramInt6;
    this.p = paramInt2;
    this.q = paramInt3;
  }
  
  public void setLayoutStyle(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultilScreenlLayout
 * JD-Core Version:    0.7.0.1
 */