package com.tencent.biz.subscribe.widget.comment.component;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class WorkSpaceView
  extends FrameLayout
{
  private static final double k = Math.tan(Math.toRadians(30.0D));
  private int a = 0;
  private int b = -1;
  private float c;
  private float d;
  private Scroller e = new Scroller(getContext());
  private int f = 0;
  private VelocityTracker g;
  private WorkSpaceView.OnScreenChangeListener h;
  private int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean j;
  private Handler l;
  
  public WorkSpaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int m = getWidth();
    a((getScrollX() + m / 2) / m);
  }
  
  public void a(int paramInt)
  {
    if (!this.e.isFinished()) {
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt)
  {
    int m = Math.min(paramInt, getChildCount() - 1);
    paramInt = 0;
    m = Math.max(0, m);
    if (m != this.a) {
      paramInt = 1;
    }
    this.b = m;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.a))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth() * m - getScrollX();
    this.e.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
    localObject = this.h;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(m);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.e.computeScrollOffset())
    {
      scrollTo(this.e.getCurrX(), this.e.getCurrY());
      postInvalidate();
      return;
    }
    int m = this.b;
    if (m != -1)
    {
      this.a = Math.max(0, Math.min(m, getChildCount() - 1));
      this.b = -1;
    }
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (getCurrentScreen() > 0)
      {
        a(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      a(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool = false;
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            break label233;
          }
        }
        else
        {
          int i1 = (int)Math.abs(f1 - this.c);
          int i2 = (int)Math.abs(f2 - this.d);
          int n = this.i;
          if (i1 > n) {
            m = 1;
          } else {
            m = 0;
          }
          if (i2 > n) {
            n = 1;
          } else {
            n = 0;
          }
          double d1 = i2;
          double d2 = i1;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if (((m == 0) && (n == 0)) || (d1 >= k)) {
            break label233;
          }
          if (m != 0) {
            this.f = 1;
          }
          if (!this.j) {
            break label233;
          }
          this.j = false;
          getChildAt(this.a).cancelLongPress();
          break label233;
        }
      }
      this.f = 0;
      this.j = false;
    }
    else
    {
      this.c = f1;
      this.d = f2;
      this.j = true;
      this.f = (this.e.isFinished() ^ true);
    }
    label233:
    if (this.f != 0) {
      bool = true;
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getMeasuredWidth() + paramInt2;
        localView.layout(paramInt2, 0, paramInt3, getMeasuredHeight());
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      getChildAt(m).measure(paramInt1, paramInt2);
      m += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
    this.g.addMovement(paramMotionEvent);
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    if (m != 0)
    {
      int n;
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            return true;
          }
        }
        else
        {
          if (this.f != 1) {
            break label310;
          }
          m = (int)(this.c - f1);
          this.c = f1;
          n = getScrollX();
          if (m < 0)
          {
            if (n <= 0) {
              break label310;
            }
            scrollBy(Math.max(-n, m), 0);
            return true;
          }
          if (m <= 0) {
            break label310;
          }
          n = getChildAt(getChildCount() - 1).getRight() - n - getWidth();
          if (n > 0) {
            scrollBy(Math.min(n, m), 0);
          }
          paramMotionEvent = Message.obtain();
          paramMotionEvent.what = 0;
          this.l.sendMessage(paramMotionEvent);
          return true;
        }
      }
      if (this.f == 1)
      {
        paramMotionEvent = this.g;
        paramMotionEvent.computeCurrentVelocity(1000);
        m = (int)paramMotionEvent.getXVelocity();
        if (m > 500)
        {
          n = this.a;
          if (n > 0)
          {
            a(n - 1);
            break label258;
          }
        }
        if ((m < -500) && (this.a < getChildCount() - 1)) {
          a(this.a + 1);
        } else {
          a();
        }
        label258:
        paramMotionEvent = this.g;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.g = null;
        }
      }
      this.f = 0;
      return true;
    }
    else
    {
      if (!this.e.isFinished()) {
        this.e.abortAnimation();
      }
      this.c = f1;
      this.f = 1;
    }
    label310:
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return (indexOfChild(paramView) != this.a) || (!this.e.isFinished());
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.l = paramHandler;
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.h = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */