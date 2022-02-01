package com.tencent.comic.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

public class ComicHorizontalCenterScrollView
  extends HorizontalScrollView
{
  private int a;
  private int b;
  private int c;
  private int d;
  private boolean e = false;
  private int f = 0;
  private ComicHorizontalCenterScrollView.OnCustomScrollListener g = null;
  private float h = 0.0F;
  private float i = 0.0F;
  private boolean j = false;
  private VelocityTracker k;
  private int l;
  private int m;
  private int n;
  
  public ComicHorizontalCenterScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComicHorizontalCenterScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComicHorizontalCenterScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ViewConfiguration.get(getContext());
    this.l = paramContext.getScaledTouchSlop();
    this.m = paramContext.getScaledMinimumFlingVelocity();
    this.n = (this.m * 2);
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (Math.abs(paramFloat) >= this.n) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1;
    if (paramFloat <= 0.0F)
    {
      paramInt2 = paramInt3;
      if (i2 != 0) {
        paramInt2 = paramInt3 + this.f;
      }
      paramInt3 = this.c;
      i2 = paramInt2 / paramInt3;
      i1 = (i2 + 1) * paramInt3 + this.d;
      if (i1 > paramInt2)
      {
        paramInt3 = i1;
        if (i1 < paramInt2 + paramInt1) {}
      }
      else
      {
        return i2 * this.c + this.d;
      }
    }
    else
    {
      i1 = paramInt3;
      if (i2 != 0) {
        i1 = paramInt3 - this.f;
      }
      paramInt3 = this.c;
      int i3 = (paramInt2 - i1 - paramInt1) / paramInt3;
      i2 = paramInt2 - paramInt3 * (i3 + 1) - this.d;
      if (i2 > i1)
      {
        paramInt3 = i2;
        if (i2 < i1 + paramInt1) {}
      }
      else
      {
        paramInt3 = paramInt2 - this.c * i3 - this.d;
      }
    }
    return paramInt3;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Math.max(paramInt2, paramInt1);
    return Math.min(paramInt3, paramInt1);
  }
  
  private void a()
  {
    VelocityTracker localVelocityTracker = this.k;
    if (localVelocityTracker == null)
    {
      this.k = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void a(float paramFloat)
  {
    int i3 = getScrollX();
    float f1 = paramFloat;
    if (paramFloat == 0.0F) {
      if (this.i - i3 > 0.0F) {
        f1 = 1.0F;
      } else {
        f1 = -1.0F;
      }
    }
    Object localObject = getChildAt(0);
    if (localObject == null) {
      return;
    }
    int i1 = ((View)localObject).getMeasuredWidth();
    int i2 = getMeasuredWidth();
    if (i1 <= i2) {
      return;
    }
    if (i2 >= this.a * 2) {
      return;
    }
    i3 = a(f1, i2, i1, i3);
    smoothScrollTo(a(i3 - i2 / 2, 0, i1), 0);
    localObject = this.g;
    if (localObject != null) {
      ((ComicHorizontalCenterScrollView.OnCustomScrollListener)localObject).a(i3);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    b();
    this.k.addMovement(paramMotionEvent);
  }
  
  private void b()
  {
    if (this.k == null) {
      this.k = VelocityTracker.obtain();
    }
  }
  
  private void c()
  {
    VelocityTracker localVelocityTracker = this.k;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.k = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.i = getScrollX();
      this.j = false;
      a();
      this.h = paramMotionEvent.getX();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      if (!this.j)
      {
        if (Math.abs(paramMotionEvent.getX() - this.h) >= this.l)
        {
          this.j = true;
          a(paramMotionEvent);
          this.h = paramMotionEvent.getX();
        }
      }
      else {
        a(paramMotionEvent);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.e) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.j))
    {
      this.k.computeCurrentVelocity(1000);
      a(this.k.getXVelocity());
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBaseInfo(int paramInt1, int paramInt2, ComicHorizontalCenterScrollView.OnCustomScrollListener paramOnCustomScrollListener)
  {
    this.g = paramOnCustomScrollListener;
    this.a = paramInt1;
    this.b = paramInt2;
    paramInt1 = this.a;
    paramInt2 = this.b;
    this.c = (paramInt1 + paramInt2);
    this.f = (paramInt1 / 3);
    this.e = true;
    this.d = (paramInt1 / 2 + paramInt2);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.ComicHorizontalCenterScrollView
 * JD-Core Version:    0.7.0.1
 */