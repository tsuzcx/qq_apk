package com.tencent.mobileqq.activity.contacts.view;

import afgz;
import afha;
import afhb;
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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private afgz jdField_a_of_type_Afgz;
  private afhb jdField_a_of_type_Afhb;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
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
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_Afgz = new afgz();
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_b_of_type_Int = paramContext.getScaledTouchSlop();
    this.jdField_c_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.e = Build.VERSION.SDK_INT;
  }
  
  @SuppressLint({"NewApi"})
  private int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      return 0;
    }
    if (this.e >= 14) {
      return (int)this.jdField_a_of_type_AndroidWidgetScroller.getCurrVelocity();
    }
    return paramInt1 / paramInt2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public boolean a()
  {
    return this.i == this.g;
  }
  
  public boolean b()
  {
    return (this.i == this.h) && (this.jdField_a_of_type_Afgz.a());
  }
  
  public void computeScroll()
  {
    int m;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      m = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (this.j != 1) {
        break label101;
      }
      if (a())
      {
        m = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY() - m;
        int n = b(this.jdField_a_of_type_AndroidWidgetScroller.getDuration(), this.jdField_a_of_type_AndroidWidgetScroller.timePassed());
        this.jdField_a_of_type_Afgz.a(a(m, n), m, n);
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
    }
    else
    {
      return;
    }
    scrollTo(0, m);
    invalidate();
    for (;;)
    {
      this.k = m;
      return;
      label101:
      if ((this.jdField_a_of_type_Afgz.a()) || (this.jdField_c_of_type_Boolean))
      {
        scrollTo(0, m - this.k + getScrollY());
        if (this.i <= this.h)
        {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          return;
        }
      }
      invalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.jdField_a_of_type_Float);
    float f2 = Math.abs(f4 - this.jdField_b_of_type_Float);
    a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      this.jdField_a_of_type_Afgz.a(true);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f4;
      this.jdField_c_of_type_Float = f4;
      this.jdField_d_of_type_Float = 0.0F;
      a((int)f4, this.f, getScrollY());
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      continue;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float - f4);
        this.jdField_c_of_type_Float = f4;
        if ((f1 > this.jdField_b_of_type_Int) && (f1 > 2.0F * f2)) {}
        boolean bool;
        for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true) {
          do
          {
            bool = a();
            if ((!this.jdField_a_of_type_Boolean) || (((this.jdField_d_of_type_Float <= 0.0F) || (bool)) && (!this.jdField_a_of_type_Afgz.a()) && (!this.jdField_c_of_type_Boolean))) {
              break;
            }
            if (!this.jdField_d_of_type_Boolean)
            {
              this.jdField_d_of_type_Boolean = true;
              this.jdField_a_of_type_Afgz.a(false);
            }
            scrollBy(0, (int)(this.jdField_d_of_type_Float + 0.5D));
            invalidate();
            break;
          } while ((f2 <= this.jdField_b_of_type_Int) || (f2 <= f1));
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if ((this.jdField_d_of_type_Float < 0.0F) || (!a()))
          {
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
            f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
            if (f3 <= 0.0F) {
              break label467;
            }
          }
          label467:
          for (int m = 2;; m = 1)
          {
            this.j = m;
            this.jdField_a_of_type_AndroidWidgetScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.k = getScrollY();
            invalidate();
            if (((f1 <= this.jdField_b_of_type_Int) && (f2 <= this.jdField_b_of_type_Int)) || ((!this.jdField_c_of_type_Boolean) && (a()))) {
              break;
            }
            m = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(m);
            return bool;
          }
        }
        FrameHelperActivity.c(true);
        a();
        continue;
        FrameHelperActivity.c(true);
        a();
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_AndroidViewView.isClickable())) {
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    measureChildWithMargins(this.jdField_a_of_type_AndroidViewView, paramInt1, 0, 0, 0);
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {}
    for (this.f = 0;; this.f = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
    {
      this.g = (this.f - this.jdField_a_of_type_Int);
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.g, 1073741824));
      return;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int n = getScrollY();
    int m = n + paramInt2;
    if (m >= this.g) {
      paramInt2 = this.g;
    }
    for (;;)
    {
      super.scrollBy(paramInt1, paramInt2 - n);
      return;
      paramInt2 = m;
      if (m <= this.h) {
        paramInt2 = this.h;
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int m;
    if (paramInt2 >= this.g) {
      m = this.g;
    }
    for (;;)
    {
      this.i = m;
      if (this.jdField_a_of_type_Afhb != null) {
        this.jdField_a_of_type_Afhb.a(m, this.g);
      }
      super.scrollTo(paramInt1, m);
      return;
      m = paramInt2;
      if (paramInt2 <= this.h) {
        m = this.h;
      }
    }
  }
  
  public void setCurrentScrollableContainer(afha paramafha)
  {
    this.jdField_a_of_type_Afgz.a(paramafha);
  }
  
  public void setOnScrollListener(afhb paramafhb)
  {
    this.jdField_a_of_type_Afhb = paramafhb;
  }
  
  public void setTopOffset(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.HeaderScrollView
 * JD-Core Version:    0.7.0.1
 */