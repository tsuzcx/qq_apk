package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import mqq.os.MqqHandler;

public class AutoFitScrollView
  extends FrameLayout
{
  public int a;
  private int b;
  private int c = 0;
  private float d;
  private float e;
  private int f;
  private AutoFitScroller g;
  private VelocityTracker h;
  private float i;
  private boolean j;
  private long k;
  private MqqHandler l;
  private boolean m = false;
  private int n;
  
  public AutoFitScrollView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = new AutoFitScroller(getContext());
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setFitWidth(paramContext.getResources().getDisplayMetrics().widthPixels, 10);
  }
  
  public void a()
  {
    this.m = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AutoFitScroller localAutoFitScroller;
    if (this.g.b() == 0)
    {
      localAutoFitScroller = this.g;
      localAutoFitScroller.a(localAutoFitScroller.b(), this.g.c(), paramInt1, paramInt2);
    }
    else
    {
      localAutoFitScroller = this.g;
      localAutoFitScroller.a(localAutoFitScroller.b(), this.g.c(), paramInt1 - this.g.b(), paramInt2);
    }
    scrollTo(this.g.b(), this.g.c());
    postInvalidate();
  }
  
  public void b()
  {
    this.m = false;
  }
  
  public void computeScroll()
  {
    if (this.g.d())
    {
      scrollTo(this.g.b(), this.g.c());
      postInvalidate();
      return;
    }
    if (this.j)
    {
      Object localObject = this.l;
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(65539);
        this.l.removeMessages(65540);
        this.l.removeMessages(65538);
        int i1 = this.a - getWidth();
        if (getScrollX() <= i1) {
          i1 = getScrollX();
        }
        if (i1 <= 0) {
          i1 = 0;
        }
        localObject = this.l.obtainMessage(65540, i1, getScrollX() - this.n, Integer.valueOf(this.a));
        this.l.sendMessage((Message)localObject);
        this.l.sendEmptyMessageDelayed(65538, 3000L);
      }
      this.j = false;
    }
  }
  
  public int getItemWidth()
  {
    return this.b;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 2) && (this.c != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label139;
          }
        }
        else
        {
          i1 = (int)(f1 - this.d);
          if ((Math.abs((int)(f2 - this.e)) >= Math.abs(i1)) || (Math.abs(i1) <= this.f)) {
            break label139;
          }
          this.c = 1;
          break label139;
        }
      }
      this.c = 0;
    }
    else
    {
      this.d = f1;
      this.e = f2;
      this.c = (this.g.a() ^ true);
    }
    label139:
    return this.c != 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, this.a, paramInt4 - paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.m) {
      return true;
    }
    if (this.h == null) {
      this.h = VelocityTracker.obtain();
    }
    this.h.addMovement(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
        }
        else
        {
          scrollBy((int)(this.i - f1), 0);
          this.i = f1;
          this.j = false;
          long l1 = System.currentTimeMillis();
          paramMotionEvent = this.l;
          if ((paramMotionEvent == null) || (l1 - this.k <= 50L)) {
            break label522;
          }
          this.k = l1;
          paramMotionEvent.removeMessages(65539);
          i1 = this.a - getWidth();
          if (getScrollX() <= i1) {
            i1 = getScrollX();
          }
          if (i1 <= 0) {
            i1 = 0;
          }
          paramMotionEvent = this.l.obtainMessage(65539, i1, this.b);
          this.l.sendMessage(paramMotionEvent);
          return true;
        }
      }
      paramMotionEvent = this.h;
      paramMotionEvent.computeCurrentVelocity(1000);
      int i3 = (int)paramMotionEvent.getXVelocity();
      if (getChildCount() > 0)
      {
        int i2;
        if (Math.abs(i3) > 1000)
        {
          i2 = this.g.a(i3);
          i1 = i2;
          if (i3 > 0) {
            i1 = -i2;
          }
          i1 = Math.round((i1 + getScrollX()) / this.b);
          i2 = this.b;
          paramMotionEvent = this.g;
          boolean bool;
          if (i3 < 0) {
            bool = true;
          } else {
            bool = false;
          }
          i1 = paramMotionEvent.a(bool, Math.abs(i1 * i2 - getScrollX()));
          if (i1 < 0) {
            this.g.a(getScrollX(), getScrollY(), -i1, 0, 0, this.a - getWidth(), 0, 0);
          } else {
            this.g.a(getScrollX(), getScrollY(), -i1, 0, 0, this.g.b(), 0, 0);
          }
          postInvalidate();
        }
        else
        {
          i1 = getScrollX();
          i2 = Math.max(Math.min(Math.round((i1 + 0.1F) / this.b) * this.b, this.a - getWidth()), 0);
          this.g.a(i1, getScrollY(), i2 - i1, 0);
          postInvalidate();
        }
      }
      paramMotionEvent = this.h;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.h = null;
      }
      this.c = 0;
      this.j = true;
      return true;
    }
    else
    {
      paramMotionEvent = this.g;
      if ((paramMotionEvent != null) && (!paramMotionEvent.a())) {
        this.g.e();
      }
      this.i = f1;
      this.j = false;
      this.n = getScrollX();
    }
    label522:
    return true;
  }
  
  public void setCallback(MqqHandler paramMqqHandler)
  {
    this.l = paramMqqHandler;
  }
  
  public void setFitWidth(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.a = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoFitScrollView
 * JD-Core Version:    0.7.0.1
 */