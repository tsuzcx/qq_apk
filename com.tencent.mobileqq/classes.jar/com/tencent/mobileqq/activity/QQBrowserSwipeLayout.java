package com.tencent.mobileqq.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager;
import com.tencent.qphone.base.util.QLog;

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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new QQBrowserSwipeLayout.QQBrowserGestureDetector(this, paramContext));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.jdField_a_of_type_JavaUtilList, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 2) && (this.jdField_d_of_type_Boolean) && ((int)paramMotionEvent.getRawX() - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) < this.jdField_a_of_type_Int)) {
        return true;
      }
    }
    else
    {
      this.jdField_d_of_type_Boolean = false;
      i = (int)paramMotionEvent.getRawX();
      this.jdField_d_of_type_Int = i;
      this.jdField_b_of_type_Int = i;
      this.jdField_c_of_type_Int = ((int)paramMotionEvent.getRawY());
      if ((this.jdField_b_of_type_Int < this.jdField_e_of_type_Int / 3) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebReadinjoyH5ElementManager.a()) || (!a(paramMotionEvent))) && (this.jdField_e_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    StringBuilder localStringBuilder;
    if (i != 1)
    {
      if ((i == 2) && (this.jdField_d_of_type_Boolean))
      {
        i = (int)paramMotionEvent.getRawX();
        int j = this.jdField_d_of_type_Int - i;
        this.jdField_d_of_type_Int = i;
        if ((i - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) < this.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((i - this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("moveX:");
            localStringBuilder.append(i);
            localStringBuilder.append("downX:");
            localStringBuilder.append(this.jdField_b_of_type_Int);
            localStringBuilder.append("deltaX:");
            localStringBuilder.append(j);
            QLog.i("QQBrowserSwipeLayout", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_AndroidViewView.scrollBy(j, 0);
        }
      }
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("event.getRawX():");
        localStringBuilder.append(paramMotionEvent.getRawX());
        localStringBuilder.append("screenWidth:");
        localStringBuilder.append(this.f);
        localStringBuilder.append("viewWidth:");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        QLog.i("QQBrowserSwipeLayout", 2, localStringBuilder.toString());
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
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout
 * JD-Core Version:    0.7.0.1
 */