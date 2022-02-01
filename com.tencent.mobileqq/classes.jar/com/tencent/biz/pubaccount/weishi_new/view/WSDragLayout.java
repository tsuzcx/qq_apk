package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class WSDragLayout
  extends LinearLayout
{
  boolean a = false;
  boolean b;
  float c = 0.0F;
  float d = 0.0F;
  float e = 0.0F;
  private float f = 0.0F;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  private int j = 1;
  private Scroller k;
  private WSDragLayout.TouchListener l;
  private int m = 0;
  private int n = 0;
  private boolean o = false;
  private boolean p = false;
  private ViewGroup q;
  private boolean r;
  private boolean s;
  
  public WSDragLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public WSDragLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public WSDragLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    this.g = false;
    this.b = false;
    if (!this.i) {
      return true;
    }
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    getMaxScrollDistance();
    this.d = 0.0F;
    this.c = 0.0F;
    if (this.s)
    {
      this.p = true;
      a(0);
      return false;
    }
    if (this.l != null)
    {
      this.o = true;
      int i1 = this.n;
      if (i1 > 0) {
        i1 = this.m - i1;
      } else {
        i1 = this.m;
      }
      a(-i1);
    }
    return false;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int i1 = (int)paramMotionEvent.getRawY();
    int i2 = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int i3 = paramMotionEvent[0];
    int i4 = paramMotionEvent[1];
    int i5 = paramView.getMeasuredWidth();
    int i6 = paramView.getMeasuredHeight();
    return (i1 >= i4) && (i1 <= i6 + i4) && (i2 >= i3) && (i2 <= i5 + i3);
  }
  
  private void b()
  {
    this.k = new Scroller(getContext());
    getMaxScrollDistance();
  }
  
  private void b(float paramFloat)
  {
    float f1 = -(paramFloat - this.f);
    float f2 = a(f1);
    WSDragLayout.TouchListener localTouchListener = this.l;
    if ((localTouchListener != null) && (this.m > 0)) {
      localTouchListener.a(Math.abs(getScrollY() + f2) / this.m);
    }
    boolean bool1 = this.g;
    boolean bool2 = false;
    if ((bool1) && (f2 != 0.0F)) {
      scrollBy(0, (int)f2);
    } else if (f2 > 0.0F) {
      scrollBy(0, (int)f2);
    }
    if (Math.abs(f1) > 5.0F)
    {
      this.i = true;
      if (f2 >= 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.s = bool1;
    }
    localTouchListener = this.l;
    if (localTouchListener != null)
    {
      bool1 = bool2;
      if (getScrollY() > 0) {
        bool1 = true;
      }
      localTouchListener.a(bool1);
    }
    this.f = paramFloat;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if ((getChildAt(0).isShown()) && (b(getChildAt(0), paramMotionEvent))) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      this.e = 0.0F;
      this.b = false;
    }
    WSDragLayout.TouchListener localTouchListener = this.l;
    int i1;
    if ((localTouchListener != null) && (localTouchListener.b())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!this.q.canScrollVertically(-1)) && (i1 == 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 != 0) || (paramMotionEvent.getRawY() < this.e))
    {
      this.e = paramMotionEvent.getRawY();
      this.c = paramMotionEvent.getRawX();
      this.d = paramMotionEvent.getRawY();
      if (getScrollY() == 0)
      {
        this.b = true;
        return true;
      }
    }
    if (this.b) {
      return true;
    }
    this.e = paramMotionEvent.getRawY();
    return false;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.g) {
      return true;
    }
    if ((this.h) && (!a(paramView, paramMotionEvent))) {
      return false;
    }
    this.g = true;
    return true;
  }
  
  private int getMaxScrollDistance()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        int i3 = i2 + localView.getHeight();
        i2 = i3;
        if (i1 == 0)
        {
          this.n = localView.getHeight();
          i2 = i3;
        }
      }
      i1 += 1;
    }
    this.m = i2;
    return i2 / 4;
  }
  
  public float a(float paramFloat)
  {
    float f1;
    if (this.a) {
      f1 = 0.0F;
    } else {
      f1 = 20.0F;
    }
    int i1 = AIOUtils.b(f1, getContext().getResources());
    if ((int)(getScrollY() + paramFloat) < i1) {
      return paramFloat;
    }
    return i1 - getScrollY();
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.k;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Scroller localScroller = this.k;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt1 - getScrollY(), paramInt2);
      invalidate();
      return;
    }
    scrollTo(0, paramInt1);
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public void b(int paramInt)
  {
    this.r = true;
    this.o = true;
    if (this.n > 0)
    {
      a(-(getHeight() - this.n), paramInt);
      return;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new WSDragLayout.1(this, paramInt));
  }
  
  public void c(int paramInt)
  {
    this.r = false;
    this.p = true;
    if (this.n > 0)
    {
      a(0, paramInt);
      return;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new WSDragLayout.2(this, paramInt));
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.k;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.k.getCurrX(), this.k.getCurrY());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollY = ");
      ((StringBuilder)localObject).append(this.k.getCurrY());
      ((StringBuilder)localObject).append("; dis = ");
      ((StringBuilder)localObject).append(this.m);
      WSLog.a("WSDragLayout", ((StringBuilder)localObject).toString());
      localObject = this.l;
      if ((localObject != null) && (this.m > 0)) {
        ((WSDragLayout.TouchListener)localObject).a(Math.abs(this.k.getCurrY()) / this.m);
      }
      invalidate();
      return;
    }
    if (this.o)
    {
      this.o = false;
      this.r = true;
      localObject = this.l;
      if (localObject != null)
      {
        ((WSDragLayout.TouchListener)localObject).a(1.0F);
        this.l.a(this.j);
      }
    }
    else if (this.p)
    {
      this.p = false;
      this.r = false;
      localObject = this.l;
      if (localObject != null)
      {
        ((WSDragLayout.TouchListener)localObject).a(0.0F);
        this.l.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b(getChildAt(0), paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (b(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
        }
        else
        {
          b(f1);
          return true;
        }
      }
      if (a(paramMotionEvent)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.b = false;
    this.i = false;
    this.f = paramMotionEvent.getY();
    this.c = paramMotionEvent.getRawX();
    this.d = paramMotionEvent.getRawY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getMaxScrollDistance();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(ViewGroup paramViewGroup)
  {
    this.q = paramViewGroup;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setTouchListener(WSDragLayout.TouchListener paramTouchListener)
  {
    this.l = paramTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout
 * JD-Core Version:    0.7.0.1
 */