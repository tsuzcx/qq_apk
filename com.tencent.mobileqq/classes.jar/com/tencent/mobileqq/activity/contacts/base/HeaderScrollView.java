package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class HeaderScrollView
  extends LinearLayout
{
  public boolean a = false;
  private int b = 0;
  private Scroller c;
  private int d;
  private int e;
  private int f;
  private int g;
  private View h;
  private int i;
  private int j = 0;
  private int k = 0;
  private int l;
  private VelocityTracker m;
  private int n;
  private int o;
  private boolean p;
  private boolean q;
  private HeaderScrollView.OnScrollListener r;
  private HeaderScrollHelper s;
  private float t;
  private float u;
  private float v;
  private boolean w = false;
  private float x = 0.0F;
  
  public HeaderScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HeaderScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeaderScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = new Scroller(paramContext);
    this.s = new HeaderScrollHelper();
    paramContext = ViewConfiguration.get(paramContext);
    this.d = paramContext.getScaledTouchSlop();
    this.e = paramContext.getScaledMinimumFlingVelocity();
    this.f = paramContext.getScaledMaximumFlingVelocity();
    this.g = Build.VERSION.SDK_INT;
  }
  
  @SuppressLint({"NewApi"})
  private int a(int paramInt1, int paramInt2)
  {
    Scroller localScroller = this.c;
    if (localScroller == null) {
      return 0;
    }
    if (this.g >= 14) {
      return (int)localScroller.getCurrVelocity();
    }
    return paramInt1 / paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 + paramInt3 <= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    this.q = bool;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.m == null) {
      this.m = VelocityTracker.obtain();
    }
    this.m.addMovement(paramMotionEvent);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private void c()
  {
    VelocityTracker localVelocityTracker = this.m;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.m = null;
    }
  }
  
  public boolean a()
  {
    return this.l == this.j;
  }
  
  public boolean b()
  {
    return (this.l == this.k) && (this.s.a());
  }
  
  public void computeScroll()
  {
    if (this.c.computeScrollOffset())
    {
      int i1 = this.c.getCurrY();
      int i2;
      if (this.n == 1)
      {
        if (a())
        {
          i1 = this.c.getFinalY() - i1;
          i2 = b(this.c.getDuration(), this.c.timePassed());
          this.s.a(a(i1, i2), i1, i2);
          this.c.abortAnimation();
          return;
        }
        scrollTo(0, i1);
        invalidate();
      }
      else
      {
        if ((this.s.a()) || (this.q))
        {
          i2 = this.o;
          scrollTo(0, getScrollY() + (i1 - i2));
          if (this.l <= this.k)
          {
            this.c.abortAnimation();
            return;
          }
        }
        invalidate();
      }
      this.o = i1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.t);
    float f2 = Math.abs(f4 - this.u);
    a(paramMotionEvent);
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      int i1 = 2;
      boolean bool;
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 3)
          {
            FrameHelperActivity.c(true);
            c();
          }
        }
        else if (!this.p)
        {
          this.x = (this.v - f4);
          this.v = f4;
          if ((f1 > this.d) && (f1 > 2.0F * f2)) {
            this.a = false;
          } else if ((f2 > this.d) && (f2 > f1)) {
            this.a = true;
          }
          bool = a();
          if ((this.a) && (((this.x > 0.0F) && (!bool)) || (this.s.a()) || (this.q)))
          {
            if (!this.w)
            {
              this.w = true;
              this.s.a(false);
            }
            double d1 = this.x;
            Double.isNaN(d1);
            scrollBy(0, (int)(d1 + 0.5D));
            invalidate();
          }
        }
      }
      else
      {
        if (this.a)
        {
          if ((this.x < 0.0F) || (!a()))
          {
            this.m.computeCurrentVelocity(1000, this.f);
            f3 = this.m.getYVelocity();
            if (f3 <= 0.0F) {
              i1 = 1;
            }
            this.n = i1;
            this.c.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.o = getScrollY();
            invalidate();
          }
          i1 = this.d;
          if (((f1 > i1) || (f2 > i1)) && ((this.q) || ((this.l > 0) && (!a()))))
          {
            i1 = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(i1);
            return bool;
          }
        }
        FrameHelperActivity.c(true);
        c();
      }
    }
    else
    {
      this.s.a(true);
      this.w = false;
      this.p = false;
      this.a = false;
      this.t = f3;
      this.u = f4;
      this.v = f4;
      this.x = 0.0F;
      a((int)f4, this.i, getScrollY());
      this.c.abortAnimation();
    }
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public int getMaxY()
  {
    return this.j;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = this.h;
    if ((localView != null) && (!localView.isClickable())) {
      this.h.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.h = getChildAt(0);
    measureChildWithMargins(this.h, paramInt1, 0, 0, 0);
    if (this.h.getVisibility() == 8) {
      this.i = 0;
    } else {
      this.i = this.h.getMeasuredHeight();
    }
    this.j = (this.i - this.b);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.j, 1073741824));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int i2 = getScrollY();
    paramInt2 += i2;
    int i1 = this.j;
    if (paramInt2 >= i1)
    {
      paramInt2 = i1;
    }
    else
    {
      i1 = this.k;
      if (paramInt2 <= i1) {
        paramInt2 = i1;
      }
    }
    super.scrollBy(paramInt1, paramInt2 - i2);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i1 = this.j;
    if (paramInt2 >= i1)
    {
      paramInt2 = i1;
    }
    else
    {
      i1 = this.k;
      if (paramInt2 <= i1) {
        paramInt2 = i1;
      }
    }
    this.l = paramInt2;
    HeaderScrollView.OnScrollListener localOnScrollListener = this.r;
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramInt2, this.j);
    }
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setCurrentScrollableContainer(HeaderScrollHelper.ScrollableContainer paramScrollableContainer)
  {
    this.s.a(paramScrollableContainer);
  }
  
  public void setOnScrollListener(HeaderScrollView.OnScrollListener paramOnScrollListener)
  {
    this.r = paramOnScrollListener;
  }
  
  public void setTopOffset(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.HeaderScrollView
 * JD-Core Version:    0.7.0.1
 */