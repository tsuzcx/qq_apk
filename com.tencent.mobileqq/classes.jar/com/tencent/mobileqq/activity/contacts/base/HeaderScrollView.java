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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private HeaderScrollHelper jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper;
  private HeaderScrollView.OnScrollListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$OnScrollListener;
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f;
  private int g = 0;
  private int h = 0;
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper = new HeaderScrollHelper();
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_b_of_type_Int = paramContext.getScaledTouchSlop();
    this.jdField_c_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.e = Build.VERSION.SDK_INT;
  }
  
  @SuppressLint({"NewApi"})
  private int a(int paramInt1, int paramInt2)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller == null) {
      return 0;
    }
    if (this.e >= 14) {
      return (int)localScroller.getCurrVelocity();
    }
    return paramInt1 / paramInt2;
  }
  
  private void a()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 + paramInt3 <= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
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
    return (this.i == this.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a());
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      int m = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      int n;
      if (this.j == 1)
      {
        if (a())
        {
          m = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY() - m;
          n = b(this.jdField_a_of_type_AndroidWidgetScroller.getDuration(), this.jdField_a_of_type_AndroidWidgetScroller.timePassed());
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a(a(m, n), m, n);
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          return;
        }
        scrollTo(0, m);
        invalidate();
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a()) || (this.jdField_c_of_type_Boolean))
        {
          n = this.k;
          scrollTo(0, getScrollY() + (m - n));
          if (this.i <= this.h)
          {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            return;
          }
        }
        invalidate();
      }
      this.k = m;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.jdField_a_of_type_Float);
    float f2 = Math.abs(f4 - this.jdField_b_of_type_Float);
    a(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      int m = 2;
      boolean bool;
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3)
          {
            FrameHelperActivity.b(true);
            a();
          }
        }
        else if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float - f4);
          this.jdField_c_of_type_Float = f4;
          if ((f1 > this.jdField_b_of_type_Int) && (f1 > 2.0F * f2)) {
            this.jdField_a_of_type_Boolean = false;
          } else if ((f2 > this.jdField_b_of_type_Int) && (f2 > f1)) {
            this.jdField_a_of_type_Boolean = true;
          }
          bool = a();
          if ((this.jdField_a_of_type_Boolean) && (((this.jdField_d_of_type_Float > 0.0F) && (!bool)) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a()) || (this.jdField_c_of_type_Boolean)))
          {
            if (!this.jdField_d_of_type_Boolean)
            {
              this.jdField_d_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a(false);
            }
            double d1 = this.jdField_d_of_type_Float;
            Double.isNaN(d1);
            scrollBy(0, (int)(d1 + 0.5D));
            invalidate();
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if ((this.jdField_d_of_type_Float < 0.0F) || (!a()))
          {
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
            f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
            if (f3 <= 0.0F) {
              m = 1;
            }
            this.j = m;
            this.jdField_a_of_type_AndroidWidgetScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.k = getScrollY();
            invalidate();
          }
          m = this.jdField_b_of_type_Int;
          if (((f1 > m) || (f2 > m)) && ((this.jdField_c_of_type_Boolean) || ((this.i > 0) && (!a()))))
          {
            m = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(m);
            return bool;
          }
        }
        FrameHelperActivity.b(true);
        a();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a(true);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f4;
      this.jdField_c_of_type_Float = f4;
      this.jdField_d_of_type_Float = 0.0F;
      a((int)f4, this.f, getScrollY());
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    }
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (!localView.isClickable())) {
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    measureChildWithMargins(this.jdField_a_of_type_AndroidViewView, paramInt1, 0, 0, 0);
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
      this.f = 0;
    } else {
      this.f = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    }
    this.g = (this.f - this.jdField_a_of_type_Int);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.g, 1073741824));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int n = getScrollY();
    paramInt2 += n;
    int m = this.g;
    if (paramInt2 >= m)
    {
      paramInt2 = m;
    }
    else
    {
      m = this.h;
      if (paramInt2 <= m) {
        paramInt2 = m;
      }
    }
    super.scrollBy(paramInt1, paramInt2 - n);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int m = this.g;
    if (paramInt2 >= m)
    {
      paramInt2 = m;
    }
    else
    {
      m = this.h;
      if (paramInt2 <= m) {
        paramInt2 = m;
      }
    }
    this.i = paramInt2;
    HeaderScrollView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramInt2, this.g);
    }
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setCurrentScrollableContainer(HeaderScrollHelper.ScrollableContainer paramScrollableContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper.a(paramScrollableContainer);
  }
  
  public void setOnScrollListener(HeaderScrollView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setTopOffset(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.HeaderScrollView
 * JD-Core Version:    0.7.0.1
 */