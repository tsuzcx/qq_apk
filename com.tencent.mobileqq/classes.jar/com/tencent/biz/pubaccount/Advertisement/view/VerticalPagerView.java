package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.util.DisplayUtil;

public class VerticalPagerView
  extends ViewGroup
{
  protected Scroller a = new Scroller(super.getContext());
  protected int b = 0;
  protected int c = 0;
  public int d = 0;
  protected VerticalPagerView.OnPagerChangedListener e;
  protected VerticalPagerView.OnInterceptTouchListener f;
  protected boolean g;
  protected float h = 0.0F;
  protected float i = 0.0F;
  protected float j = 0.0F;
  protected float k = 0.0F;
  protected float l = 0.0F;
  protected float m = 0.0F;
  protected boolean n = true;
  
  public VerticalPagerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerticalPagerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.e = null;
    this.f = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1 - this.a.getFinalX(), paramInt2 - this.a.getFinalY(), paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Scroller localScroller = this.a;
    localScroller.startScroll(localScroller.getFinalX(), this.a.getFinalY(), paramInt1, paramInt2, paramInt3);
    super.invalidate();
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      super.postInvalidate();
    }
    else if (!this.g)
    {
      int i1 = this.c;
      int i2 = this.d;
      if (i1 != i2)
      {
        a(i2);
        VerticalPagerView.OnPagerChangedListener localOnPagerChangedListener = this.e;
        if (localOnPagerChangedListener != null) {
          localOnPagerChangedListener.a(this, super.getChildAt(this.d), this.d);
        }
        this.c = this.d;
      }
    }
    super.computeScroll();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.getChildCount() >= 2)
    {
      if (!this.n) {
        return false;
      }
      int i1 = paramMotionEvent.getAction();
      this.j = paramMotionEvent.getX();
      this.k = paramMotionEvent.getY();
      float f1;
      if (i1 == 0)
      {
        this.b = ((int)paramMotionEvent.getY());
        this.h = this.j;
        f1 = this.k;
        this.i = f1;
        this.l = f1;
        return false;
      }
      if (i1 == 2)
      {
        f1 = Math.abs(this.j - this.h);
        float f2 = Math.abs(this.k - this.i);
        if ((f2 >= DisplayUtil.a(super.getContext(), 10.0F)) && (f2 >= f1))
        {
          i1 = (int)(paramMotionEvent.getY() - this.b);
          if (i1 > 0)
          {
            paramMotionEvent = this.f;
            if (paramMotionEvent != null) {
              return paramMotionEvent.b(this.d);
            }
            return c(this.d);
          }
          if (i1 < 0)
          {
            paramMotionEvent = this.f;
            if (paramMotionEvent != null) {
              return paramMotionEvent.a(this.d);
            }
            return b(this.d);
          }
        }
        else
        {
          this.b = ((int)paramMotionEvent.getY());
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i4 = super.getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      View localView = super.getChildAt(i1);
      i3 = paramInt4 - paramInt2 + i2;
      localView.layout(0, i2, paramInt3 - paramInt1, i3);
      i1 += 1;
    }
    setCurrentPage(this.d);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = super.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      super.measureChild(super.getChildAt(i1), paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    this.k = paramMotionEvent.getY();
    if (i1 == 0)
    {
      this.b = ((int)paramMotionEvent.getY());
      f1 = this.k;
      this.i = f1;
      this.g = true;
      this.l = f1;
      return true;
    }
    Object localObject;
    if (i1 == 2)
    {
      this.b = ((int)(paramMotionEvent.getY() - this.b));
      i1 = this.a.getCurrY();
      if (Math.abs(this.k - this.i) < DisplayUtil.a(super.getContext(), 10.0F))
      {
        this.b = ((int)paramMotionEvent.getY());
        f1 = this.k;
        this.m = (f1 - this.l);
        this.l = f1;
        return false;
      }
      if (i1 < 0)
      {
        this.b = ((int)paramMotionEvent.getY());
        paramMotionEvent = this.e;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false, this.d);
        }
        f1 = this.k;
        this.m = (f1 - this.l);
        this.l = f1;
        return false;
      }
      if (i1 > (super.getChildCount() - 1) * super.getHeight())
      {
        this.b = ((int)paramMotionEvent.getY());
        paramMotionEvent = this.e;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false, this.d);
        }
        f1 = this.k;
        this.m = (f1 - this.l);
        this.l = f1;
        return false;
      }
      localObject = this.a;
      ((Scroller)localObject).startScroll(0, ((Scroller)localObject).getFinalY(), 0, -this.b, 0);
      this.b = ((int)paramMotionEvent.getY());
      super.invalidate();
      localObject = this.e;
      if (localObject != null) {
        ((VerticalPagerView.OnPagerChangedListener)localObject).a(true, this.d);
      }
    }
    else if ((i1 == 1) || (i1 == 3))
    {
      f1 = Math.abs(this.m);
      this.l = this.k;
      i1 = this.a.getCurrY() - this.d * super.getHeight();
      if ((i1 <= super.getHeight() / 4) && ((i1 <= 0) || (f1 <= DisplayUtil.a(super.getContext(), 7.0F))))
      {
        if ((i1 < -super.getHeight() / 4) || ((i1 < 0) && (f1 > DisplayUtil.a(super.getContext(), 5.0F))))
        {
          this.d -= 1;
          if (this.d < 0) {
            this.d = 0;
          }
        }
      }
      else
      {
        this.d += 1;
        if (this.d >= super.getChildCount()) {
          this.d = (super.getChildCount() - 1);
        }
      }
      a(0, this.d * super.getHeight());
      this.b = ((int)paramMotionEvent.getY());
      this.g = false;
      localObject = this.e;
      if (localObject != null) {
        ((VerticalPagerView.OnPagerChangedListener)localObject).a(false, this.d);
      }
    }
    float f1 = this.k;
    this.m = (f1 - this.l);
    this.l = f1;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentPage(int paramInt)
  {
    this.d = paramInt;
    a(0, this.d * super.getHeight());
  }
  
  public void setCurrentPage(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    a(0, this.d * super.getHeight(), paramInt2);
  }
  
  public void setEnableChangePage(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOnInterceptTouchListener(VerticalPagerView.OnInterceptTouchListener paramOnInterceptTouchListener)
  {
    this.f = paramOnInterceptTouchListener;
  }
  
  public void setOnPagerChangedListener(VerticalPagerView.OnPagerChangedListener paramOnPagerChangedListener)
  {
    this.e = paramOnPagerChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView
 * JD-Core Version:    0.7.0.1
 */