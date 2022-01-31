package com.tencent.mobileqq.activity.contacts.view.pullrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;
import wll;
import wlm;
import wln;
import wlo;

public class CommonRefreshLayout
  extends ViewGroup
  implements AutoScroller.ScrollerCallback
{
  private float jdField_a_of_type_Float = 0.5F;
  private int jdField_a_of_type_Int = 200;
  private View jdField_a_of_type_AndroidViewView;
  private AutoScroller jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller;
  private OnRefreshListener jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshOnRefreshListener;
  wln jdField_a_of_type_Wln = new wlm(this);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 200;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 300;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 500;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 500;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private int h;
  private int i;
  private int j;
  private int k = 0;
  
  public CommonRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RefreshLayout, paramInt, 0);
    for (;;)
    {
      try
      {
        int n = paramAttributeSet.getIndexCount();
        paramInt = m;
        if (paramInt >= n) {
          break label310;
        }
        m = paramAttributeSet.getIndex(paramInt);
        if (m == 0) {
          setRefreshEnabled(paramAttributeSet.getBoolean(m, true));
        } else if (m == 2) {
          this.jdField_a_of_type_Float = paramAttributeSet.getFloat(m, 0.5F);
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (m == 5)
      {
        this.jdField_c_of_type_Float = paramAttributeSet.getDimensionPixelOffset(m, 0);
      }
      else if (m == 3)
      {
        this.jdField_b_of_type_Float = paramAttributeSet.getDimensionPixelOffset(m, 0);
      }
      else if (m == 7)
      {
        this.jdField_a_of_type_Int = paramAttributeSet.getInt(m, 200);
      }
      else if (m == 8)
      {
        this.jdField_b_of_type_Int = paramAttributeSet.getInt(m, 200);
      }
      else if (m == 9)
      {
        setRefreshCompleteDelayDuration(paramAttributeSet.getInt(m, 300));
      }
      else if (m == 10)
      {
        this.jdField_d_of_type_Int = paramAttributeSet.getInt(m, 500);
      }
      else if (m == 11)
      {
        this.jdField_e_of_type_Int = paramAttributeSet.getInt(m, 500);
        break label346;
        label310:
        paramAttributeSet.recycle();
        this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller = new AutoScroller(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a(this);
        return;
      }
      label346:
      paramInt += 1;
    }
  }
  
  private float a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int m = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, m) == this.jdField_f_of_type_Int) {
      if (m != 0) {
        break label33;
      }
    }
    label33:
    for (m = 1;; m = 0)
    {
      this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, m);
      return;
    }
  }
  
  private float b(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getX(paramMotionEvent, paramInt);
  }
  
  private void b(float paramFloat)
  {
    float f1 = this.jdField_a_of_type_Float * paramFloat;
    float f2 = this.i + f1;
    if ((this.i <= 0) || (f2 >= 0.0F))
    {
      paramFloat = f1;
      if (this.i < 0)
      {
        paramFloat = f1;
        if (f2 <= 0.0F) {}
      }
    }
    else
    {
      paramFloat = -this.i;
    }
    f1 = paramFloat;
    if (this.jdField_c_of_type_Float > this.jdField_b_of_type_Float)
    {
      f1 = paramFloat;
      if (f2 > this.jdField_c_of_type_Float) {
        f1 = this.jdField_c_of_type_Float - this.i;
      }
    }
    if (wlo.c(this.k)) {
      this.jdField_a_of_type_Wln.a(this.i, false, false);
    }
    c(f1);
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Boolean) && (!ViewUtils.a(this.jdField_b_of_type_AndroidViewView)) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Float > 0.0F);
  }
  
  private void c()
  {
    int n = getPaddingLeft();
    int m = getPaddingTop();
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localView = this.jdField_a_of_type_AndroidViewView;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        i1 = localMarginLayoutParams.leftMargin + n;
        int i2 = localMarginLayoutParams.topMargin + m - this.jdField_g_of_type_Int + this.h;
        localView.layout(i1, i2, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + i2);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    View localView = this.jdField_b_of_type_AndroidViewView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
    int i1 = n + localMarginLayoutParams.leftMargin;
    n = localMarginLayoutParams.topMargin + m + this.i;
    m = n;
    if (n < 0) {
      m = 0;
    }
    localView.layout(i1, m, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + m);
  }
  
  private void c(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.i = ((int)(this.i + paramFloat));
    if (wlo.c(this.k)) {
      this.h = this.i;
    }
    d();
    requestLayout();
    invalidate();
  }
  
  private void d()
  {
    int m = getPaddingTop();
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localView = this.jdField_a_of_type_AndroidViewView;
        localView.setTop(((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).topMargin + m - this.jdField_g_of_type_Int + this.h);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    View localView = this.jdField_b_of_type_AndroidViewView;
    int n = ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).topMargin + m + this.i;
    m = n;
    if (n < 0) {
      m = 0;
    }
    localView.setTop(m);
  }
  
  private void e()
  {
    if (wlo.b(this.k))
    {
      this.i = ((int)(this.jdField_b_of_type_Float + 0.5F));
      this.h = this.i;
      d();
      requestLayout();
      invalidate();
    }
    while (!wlo.a(this.k)) {
      return;
    }
    this.i = 0;
    this.h = 0;
    d();
    requestLayout();
    invalidate();
  }
  
  private void f()
  {
    if (wlo.d(this.k)) {
      h();
    }
    do
    {
      return;
      if (wlo.e(this.k))
      {
        this.jdField_a_of_type_Wln.b();
        i();
        return;
      }
    } while (!wlo.b(this.k));
    b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a((int)(this.jdField_b_of_type_Float + 0.5F), this.jdField_e_of_type_Int);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a(-this.h, this.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a(this.jdField_g_of_type_Int - this.h, this.jdField_b_of_type_Int);
    }
  }
  
  public void a()
  {
    if (wlo.e(this.k))
    {
      a(-3);
      e();
      this.jdField_a_of_type_Wln.c();
    }
    do
    {
      return;
      if (wlo.b(this.k))
      {
        a(0);
        e();
        this.jdField_a_of_type_Wln.d();
        return;
      }
      if (wlo.d(this.k))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          a(-3);
          e();
          this.jdField_a_of_type_Wln.c();
          return;
        }
        a(0);
        e();
        this.jdField_a_of_type_Wln.d();
        return;
      }
    } while (!wlo.a(this.k));
  }
  
  public void a(float paramFloat)
  {
    if (wlo.d(this.k)) {
      this.jdField_a_of_type_Wln.a(this.i, false, true);
    }
    for (;;)
    {
      c(paramFloat);
      return;
      if (wlo.e(this.k)) {
        this.jdField_a_of_type_Wln.a(this.i, false, true);
      } else if (wlo.b(this.k)) {
        this.jdField_a_of_type_Wln.a(this.i, true, true);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a(-this.h, this.jdField_d_of_type_Int);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      f();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new CommonRefreshLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CommonRefreshLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new CommonRefreshLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = getChildCount();
    if (m == 0) {}
    do
    {
      return;
      if ((m <= 0) || (m >= 4)) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131362382);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131362381);
    } while ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView == null) || (!(this.jdField_a_of_type_AndroidViewView instanceof SwipeTrigger)));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return;
    throw new IllegalStateException("Children num must equal or less than 3");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i1 = 0;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      label47:
      float f1;
      do
      {
        return bool;
        this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
        this.jdField_d_of_type_Float = f1;
        this.jdField_f_of_type_Float = f1;
        f1 = a(paramMotionEvent, this.jdField_f_of_type_Int);
        this.jdField_e_of_type_Float = f1;
        this.jdField_g_of_type_Float = f1;
        if ((wlo.d(this.k)) || (wlo.e(this.k))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshAutoScroller.a();
        }
      } while (wlo.d(this.k));
      if (wlo.e(this.k))
      {
        return true;
        if (this.jdField_f_of_type_Int == -1) {
          return false;
        }
        f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
        float f2 = a(paramMotionEvent, this.jdField_f_of_type_Int);
        float f3 = this.jdField_d_of_type_Float;
        float f4 = f2 - this.jdField_e_of_type_Float;
        this.jdField_f_of_type_Float = f1;
        this.jdField_g_of_type_Float = f2;
        if ((Math.abs(f1 - f3) < Math.abs(f4)) && (Math.abs(f4) > this.j)) {}
        for (int m = 1;; m = 0)
        {
          int n = i1;
          if (f4 > 0.0F)
          {
            n = i1;
            if (b()) {
              n = 1;
            }
          }
          if (m == 0) {
            break;
          }
          if (n != 0) {
            break label47;
          }
          if (!wlo.b(this.k)) {
            break;
          }
          return true;
        }
        this.jdField_f_of_type_Int = -1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int m = localView.getMeasuredHeight();
      int n = localMarginLayoutParams.topMargin;
      this.jdField_g_of_type_Int = (localMarginLayoutParams.bottomMargin + (m + n));
      if (this.jdField_b_of_type_Float < this.jdField_g_of_type_Int) {
        this.jdField_b_of_type_Float = this.jdField_g_of_type_Int;
      }
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      measureChildWithMargins(this.jdField_b_of_type_AndroidViewView, paramInt1, 0, paramInt2, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      float f4;
      do
      {
        return bool;
        this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        return true;
        float f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
        float f2 = a(paramMotionEvent, this.jdField_f_of_type_Int);
        float f3 = f1 - this.jdField_f_of_type_Float;
        f4 = f2 - this.jdField_g_of_type_Float;
        this.jdField_f_of_type_Float = f1;
        this.jdField_g_of_type_Float = f2;
        if ((Math.abs(f3) >= Math.abs(f4)) && (Math.abs(f3) > this.j)) {
          return false;
        }
        if ((wlo.a(this.k)) && (f4 > 0.0F) && (b()))
        {
          this.jdField_a_of_type_Wln.a();
          a(-1);
        }
      } while (!wlo.c(this.k));
      if ((wlo.d(this.k)) || (wlo.e(this.k)))
      {
        if (this.i < this.jdField_b_of_type_Float) {
          break label238;
        }
        a(-2);
      }
      for (;;)
      {
        b(f4);
        return true;
        label238:
        a(-1);
      }
      int m = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
      if (m != -1) {
        this.jdField_f_of_type_Int = m;
      }
      this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
      continue;
      a(paramMotionEvent);
      this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
      continue;
      if (this.jdField_f_of_type_Int == -1) {
        return false;
      }
      this.jdField_f_of_type_Int = -1;
    }
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshOnRefreshListener = paramOnRefreshListener;
  }
  
  public void setRefreshCompleteDelayDuration(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((!a()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (!wlo.a(this.k));
      a(-1);
      g();
      return;
    } while (!wlo.b(this.k));
    this.jdField_a_of_type_Wln.d();
    postDelayed(new wll(this), this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout
 * JD-Core Version:    0.7.0.1
 */