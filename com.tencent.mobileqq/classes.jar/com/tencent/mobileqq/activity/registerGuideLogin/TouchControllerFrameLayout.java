package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class TouchControllerFrameLayout
  extends FrameLayout
{
  private float a = 1.4E-45F;
  private float b = 1.4E-45F;
  private boolean c;
  private boolean d = true;
  private boolean e;
  private boolean f;
  private boolean g;
  private Scroller h = new Scroller(getContext());
  private TouchControllerFrameLayout.CustomTouchListener i;
  private int j;
  private View k;
  
  public TouchControllerFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    this.h.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
    invalidate();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.c) {
      return true;
    }
    View localView2 = this.k;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = getChildAt(0);
    }
    if (a(localView1, paramMotionEvent))
    {
      this.c = true;
      return true;
    }
    return false;
  }
  
  public float a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchControllerFrameLayout", 2, new Object[] { "canScrollDistance getScrollY()=", Integer.valueOf(getScrollY()), ", dist=", Float.valueOf(paramFloat) });
    }
    if ((int)(getScrollY() + paramFloat) < 0) {
      return paramFloat;
    }
    return -getScrollY();
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    if (paramView == null) {
      return false;
    }
    int n = (int)paramMotionEvent.getRawY();
    int m = (int)paramMotionEvent.getRawX();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i2 = arrayOfInt[0];
    boolean bool2 = true;
    int i1 = arrayOfInt[1];
    int i3 = paramView.getMeasuredWidth();
    if ((n <= paramView.getMeasuredHeight() + i1) && (m >= i2) && (m <= i3 + i2)) {
      m = 1;
    } else {
      m = 0;
    }
    boolean bool1;
    if ((n >= i1) && (m != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.d) {
      return bool1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (bool1) {
        return true;
      }
      if ((n >= 0) && (m != 0)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.e = bool1;
      return false;
    }
    bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if (this.e) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.h.computeScrollOffset())
    {
      scrollTo(this.h.getCurrX(), this.h.getCurrY());
      invalidate();
      return;
    }
    if (this.f)
    {
      this.f = false;
      TouchControllerFrameLayout.CustomTouchListener localCustomTouchListener = this.i;
      if (localCustomTouchListener != null) {
        localCustomTouchListener.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            return false;
          }
        }
        else
        {
          if (this.a == 1.4E-45F)
          {
            this.a = f1;
            this.b = f1;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if ((!this.g) && (Math.abs(f1 - this.b) < 5.0F))
          {
            this.a = f1;
            return true;
          }
          this.g = true;
          float f2 = a(-(f1 - this.a));
          if (f2 != 0.0F) {
            scrollBy(0, (int)f2);
          }
          this.a = f1;
          return true;
        }
      }
      this.c = false;
      this.a = 1.4E-45F;
      this.b = 1.4E-45F;
      m = -getScrollY();
      boolean bool;
      if (-getScrollY() < this.j) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("TouchControllerFrameLayout", 1, new Object[] { "dispatchTouchEvent ACTION_UP -getScrollY()=", Integer.valueOf(m), ", toUp=", Boolean.valueOf(bool) });
      if (this.g)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        if (-getScrollY() < this.j)
        {
          a(0);
          return false;
        }
        if (this.i != null)
        {
          this.f = true;
          a(-getHeight());
        }
        return false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.g = false;
    this.a = f1;
    this.b = f1;
    QLog.d("TouchControllerFrameLayout", 1, new Object[] { "dispatchTouchEvent ACTION_DOWN mPreY=", Float.valueOf(this.a) });
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setCustomTouchListener(TouchControllerFrameLayout.CustomTouchListener paramCustomTouchListener)
  {
    this.i = paramCustomTouchListener;
  }
  
  public void setHeadView(View paramView)
  {
    this.k = paramView;
  }
  
  public void setIsInterceptContentEvent(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setMaxScrollHeight(int paramInt)
  {
    QLog.d("TouchControllerFrameLayout", 1, new Object[] { "maxScrollHeight=", Integer.valueOf(paramInt) });
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout
 * JD-Core Version:    0.7.0.1
 */