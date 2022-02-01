package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.AutoFitScroller;
import com.tencent.qphone.base.util.QLog;

public class MultilScreenlLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private AutoFitScroller jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
  protected MultilScreenlLayout.OnClickScrollLayoutListener a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 600;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 1;
  private int l;
  private int m;
  
  public MultilScreenlLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MultilScreenlLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private int a()
  {
    int n = this.f;
    if (n == 0) {
      return getWidth();
    }
    return n + this.g;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller = new AutoFitScroller(getContext());
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.e = localViewConfiguration.getScaledTouchSlop();
    this.jdField_c_of_type_Int = (localViewConfiguration.getScaledMinimumFlingVelocity() * 2);
  }
  
  public void a()
  {
    a((getScrollX() + a() / 2) / a());
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapToScreen before change whichScreen:");
      localStringBuilder.append(paramInt);
      QLog.d("MutilScreenlLayout", 2, localStringBuilder.toString());
    }
    int n = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    paramInt = a() * n;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapToScreen dest:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" getScrollX():");
      localStringBuilder.append(getScrollX());
      localStringBuilder.append(" afterchange whichScreen:");
      localStringBuilder.append(n);
      QLog.d("MutilScreenlLayout", 2, localStringBuilder.toString());
    }
    if (getScrollX() != paramInt)
    {
      int i1 = paramInt - getScrollX();
      paramInt = Math.abs(i1) / 2;
      if (paramInt < 300) {
        paramInt = 300;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(getScrollX(), 0, i1, 0, paramInt);
      this.jdField_a_of_type_Int = n;
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b())
    {
      super.scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.d != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    paramMotionEvent.getY();
    boolean bool2 = false;
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3) {
            break label105;
          }
        }
        else
        {
          if ((int)Math.abs(this.jdField_a_of_type_Float - f1) <= this.e) {
            break label105;
          }
          this.d = 1;
          break label105;
        }
      }
      this.d = 0;
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.d = (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a() ^ true);
    }
    label105:
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("onInterceptTouchEvent mTouchState != TOUCH_STATE_REST ");
      if (this.d != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramMotionEvent.append(bool1);
      QLog.d("MutilScreenlLayout", 2, paramMotionEvent.toString());
    }
    boolean bool1 = bool2;
    if (this.d != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.k == 1)
    {
      paramInt2 = this.h + this.g;
      paramInt4 = super.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        View localView = super.getChildAt(paramInt1);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = a();
          int n = this.m;
          localView.layout(paramInt2, n, this.f + paramInt2, this.l + n);
          paramInt3 = paramInt2 + paramInt3;
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
      this.j = (paramInt2 + this.i - super.getWidth());
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.k == 0) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i2 = 0;
    int i1 = 0;
    if (n != 0)
    {
      int i3;
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            this.d = 0;
          }
        }
        else
        {
          i1 = (int)(this.jdField_a_of_type_Float - f1);
          this.jdField_a_of_type_Float = f1;
          i2 = super.getScrollX();
          n = i1;
          if (i2 + i1 <= 0) {
            n = -i2;
          }
          i3 = this.j;
          i1 = n;
          if (i2 + n >= i3) {
            i1 = i3 - i2;
          }
          if (i1 != 0) {
            scrollBy(i1, 0);
          }
          if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_b_of_type_Float - f2)) > this.e) {
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        n = (int)paramMotionEvent.getXVelocity();
        if ((n > this.jdField_c_of_type_Int) && (this.jdField_a_of_type_Int > 0))
        {
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("onTouchEvent velocityX > mMinVelocity mCurScreen:");
            paramMotionEvent.append(this.jdField_a_of_type_Int);
            paramMotionEvent.append(" velocityX:");
            paramMotionEvent.append(n);
            QLog.d("MutilScreenlLayout", 2, paramMotionEvent.toString());
          }
          a(this.jdField_a_of_type_Int - 1);
        }
        else if ((n < -this.jdField_c_of_type_Int) && (this.jdField_a_of_type_Int < super.getChildCount() - 1))
        {
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("onTouchEvent velocityX < -mMinVelocity mCurScreen:");
            paramMotionEvent.append(this.jdField_a_of_type_Int);
            paramMotionEvent.append(" velocityX:");
            paramMotionEvent.append(n);
            QLog.d("MutilScreenlLayout", 2, paramMotionEvent.toString());
          }
          a(this.jdField_a_of_type_Int + 1);
        }
        else
        {
          a();
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("onTouchEvent velocityX:");
            paramMotionEvent.append(n);
            QLog.d("MutilScreenlLayout", 2, paramMotionEvent.toString());
          }
        }
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.d = 0;
        if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_b_of_type_Float - f2)) > this.e) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$OnClickScrollLayoutListener != null))
        {
          i3 = super.getChildCount();
          int i4 = this.jdField_a_of_type_Int;
          n = i2;
          if (i4 >= 0)
          {
            n = i2;
            if (i4 < i3)
            {
              paramMotionEvent = super.getChildAt(i4);
              i2 = paramMotionEvent.getLeft() - super.getScrollX();
              n = i1;
              if (f1 < i2)
              {
                n = i1;
                if (f1 > i2 - this.g) {
                  n = 1;
                }
              }
              i2 = paramMotionEvent.getRight() - super.getScrollX();
              i1 = n;
              if (n == 0)
              {
                i1 = n;
                if (f1 > i2)
                {
                  i1 = n;
                  if (f1 < i2 + this.g) {
                    i1 = 1;
                  }
                }
              }
              i2 = i1;
              if (i1 == 0)
              {
                i2 = i1;
                if (f1 < this.h - super.getScrollX()) {
                  i2 = 1;
                }
              }
              n = i2;
              if (i2 == 0)
              {
                n = i2;
                if (f1 > this.j + super.getWidth() - super.getScrollX() - this.h) {
                  n = 1;
                }
              }
            }
          }
          if (n != 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$OnClickScrollLayoutListener.a(f1, f2);
          }
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a();
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_c_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "onTouchEvent ");
    }
    return true;
  }
  
  public void setClickLayoutListener(MultilScreenlLayout.OnClickScrollLayoutListener paramOnClickScrollLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$OnClickScrollLayoutListener = paramOnClickScrollLayoutListener;
  }
  
  public void setCurrentFrame(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.scrollTo(paramInt * a(), 0);
  }
  
  public void setFrameWidth(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.f = paramInt1;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
    this.l = paramInt2;
    this.m = paramInt3;
  }
  
  public void setLayoutStyle(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultilScreenlLayout
 * JD-Core Version:    0.7.0.1
 */