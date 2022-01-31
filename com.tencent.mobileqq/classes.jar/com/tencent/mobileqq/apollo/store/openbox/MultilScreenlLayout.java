package com.tencent.mobileqq.apollo.store.openbox;

import accl;
import alam;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

public class MultilScreenlLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private accl jdField_a_of_type_Accl;
  protected alam a;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
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
    if (this.f == 0) {
      return getWidth();
    }
    return this.f + this.g;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Accl = new accl(getContext());
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
    int n = 300;
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "snapToScreen before change whichScreen:" + paramInt);
    }
    int i1 = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    paramInt = a() * i1;
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "snapToScreen dest:" + paramInt + " getScrollX():" + getScrollX() + " afterchange whichScreen:" + i1);
    }
    int i2;
    if (getScrollX() != paramInt)
    {
      i2 = paramInt - getScrollX();
      paramInt = Math.abs(i2) / 2;
      if (paramInt >= 300) {
        break label168;
      }
      paramInt = n;
    }
    label168:
    for (;;)
    {
      this.jdField_a_of_type_Accl.a(getScrollX(), 0, i2, 0, paramInt);
      this.jdField_a_of_type_Int = i1;
      invalidate();
      return;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_Accl.b())
    {
      super.scrollTo(this.jdField_a_of_type_Accl.a(), this.jdField_a_of_type_Accl.b());
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
    switch (n)
    {
    default: 
      label60:
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder().append("onInterceptTouchEvent mTouchState != TOUCH_STATE_REST ");
        if (this.d == 0) {
          break label176;
        }
      }
      break;
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MutilScreenlLayout", 2, bool);
      if (this.d != 0) {
        break;
      }
      return false;
      if ((int)Math.abs(this.jdField_a_of_type_Float - f1) <= this.e) {
        break label60;
      }
      this.d = 1;
      break label60;
      this.jdField_a_of_type_Float = f1;
      if (this.jdField_a_of_type_Accl.a()) {}
      for (n = 0;; n = 1)
      {
        this.d = n;
        break;
      }
      this.d = 0;
      break label60;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.k == 1)
    {
      paramInt1 = this.h;
      paramInt2 = this.g;
      paramInt4 = super.getChildCount();
      paramInt2 += paramInt1;
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        View localView = super.getChildAt(paramInt1);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = a();
          localView.layout(paramInt2, this.m, this.f + paramInt2, this.m + this.l);
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
    int i1 = 0;
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
    switch (n)
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      for (;;)
      {
        label84:
        if (QLog.isColorLevel())
        {
          QLog.d("MutilScreenlLayout", 2, "onTouchEvent ");
          return true;
          if (!this.jdField_a_of_type_Accl.a()) {
            this.jdField_a_of_type_Accl.a();
          }
          this.jdField_a_of_type_Float = f1;
          this.jdField_c_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          this.jdField_a_of_type_Boolean = false;
          continue;
          i1 = (int)(this.jdField_a_of_type_Float - f1);
          this.jdField_a_of_type_Float = f1;
          int i2 = super.getScrollX();
          n = i1;
          if (i2 + i1 <= 0) {
            n = -i2;
          }
          i1 = n;
          if (i2 + n >= this.j) {
            i1 = this.j - i2;
          }
          if (i1 != 0) {
            scrollBy(i1, 0);
          }
          if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_b_of_type_Float - f2)) > this.e)
          {
            this.jdField_a_of_type_Boolean = true;
            continue;
            paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
            paramMotionEvent.computeCurrentVelocity(1000);
            n = (int)paramMotionEvent.getXVelocity();
            if ((n > this.jdField_c_of_type_Int) && (this.jdField_a_of_type_Int > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX > mMinVelocity mCurScreen:" + this.jdField_a_of_type_Int + " velocityX:" + n);
              }
              a(this.jdField_a_of_type_Int - 1);
              label343:
              if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
              {
                this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
                this.jdField_a_of_type_AndroidViewVelocityTracker = null;
              }
              this.d = 0;
              if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_b_of_type_Float - f2)) > this.e) {
                this.jdField_a_of_type_Boolean = true;
              }
              if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Alam == null)) {
                continue;
              }
              i2 = super.getChildCount();
              n = i1;
              if (this.jdField_a_of_type_Int >= 0)
              {
                n = i1;
                if (this.jdField_a_of_type_Int < i2)
                {
                  paramMotionEvent = super.getChildAt(this.jdField_a_of_type_Int);
                  n = paramMotionEvent.getLeft() - super.getScrollX();
                  if ((f1 >= n) || (f1 <= n - this.g)) {
                    break label755;
                  }
                }
              }
            }
          }
        }
      }
    }
    label755:
    for (n = 1;; n = 0)
    {
      i1 = paramMotionEvent.getRight() - super.getScrollX();
      if ((n == 0) && (f1 > i1) && (f1 < i1 + this.g)) {
        n = 1;
      }
      for (;;)
      {
        i1 = n;
        if (n == 0)
        {
          i1 = n;
          if (f1 < this.h - super.getScrollX()) {
            i1 = 1;
          }
        }
        n = i1;
        if (i1 == 0)
        {
          n = i1;
          if (f1 > this.j + super.getWidth() - super.getScrollX() - this.h) {
            n = 1;
          }
        }
        if (n == 0) {
          break label84;
        }
        this.jdField_a_of_type_Alam.a(f1, f2);
        break label84;
        if ((n < -this.jdField_c_of_type_Int) && (this.jdField_a_of_type_Int < super.getChildCount() - 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX < -mMinVelocity mCurScreen:" + this.jdField_a_of_type_Int + " velocityX:" + n);
          }
          a(this.jdField_a_of_type_Int + 1);
          break label343;
        }
        a();
        if (!QLog.isColorLevel()) {
          break label343;
        }
        QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX:" + n);
        break label343;
        this.d = 0;
        break label84;
        break;
      }
    }
  }
  
  public void setClickLayoutListener(alam paramalam)
  {
    this.jdField_a_of_type_Alam = paramalam;
  }
  
  public void setCurrentFrame(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.scrollTo(a() * paramInt, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultilScreenlLayout
 * JD-Core Version:    0.7.0.1
 */