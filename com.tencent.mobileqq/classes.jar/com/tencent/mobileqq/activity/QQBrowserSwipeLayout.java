package com.tencent.mobileqq.activity;

import abug;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.qphone.base.util.QLog;
import shv;

public class QQBrowserSwipeLayout
  extends SwipeBackLayout
{
  private GestureDetector a;
  
  public QQBrowserSwipeLayout(Context paramContext)
  {
    this(paramContext, true);
    setBackgroundColor(0);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new abug(this, paramContext));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.jdField_a_of_type_JavaUtilList, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        this.jdField_d_of_type_Boolean = false;
        int i = (int)paramMotionEvent.getRawX();
        this.jdField_d_of_type_Int = i;
        this.jdField_b_of_type_Int = i;
        this.jdField_c_of_type_Int = ((int)paramMotionEvent.getRawY());
        if ((this.jdField_b_of_type_Int < this.jdField_e_of_type_Int / 3) && ((this.jdField_a_of_type_Shv.a()) || (!a(paramMotionEvent))) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
    } while ((!this.jdField_d_of_type_Boolean) || ((int)paramMotionEvent.getRawX() - this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) || (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) >= this.jdField_a_of_type_Int));
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if (this.jdField_d_of_type_Boolean)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = this.jdField_d_of_type_Int - i;
        this.jdField_d_of_type_Int = i;
        if ((i - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) < this.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((i - this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQBrowserSwipeLayout", 2, "moveX:" + i + "downX:" + this.jdField_b_of_type_Int + "deltaX:" + j);
          }
          this.jdField_a_of_type_AndroidViewView.scrollBy(j, 0);
          continue;
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.i("QQBrowserSwipeLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.f + "viewWidth:" + this.jdField_e_of_type_Int);
            }
            if (paramMotionEvent.getRawX() - this.jdField_b_of_type_Int >= this.f / 2)
            {
              this.jdField_b_of_type_Boolean = true;
              a();
            }
            else
            {
              postDelayed(new QQBrowserSwipeLayout.1(this), 100L);
              this.jdField_b_of_type_Boolean = false;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout
 * JD-Core Version:    0.7.0.1
 */