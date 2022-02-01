package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class VisitorsActivity$ListViewScrollListener
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = true;
  
  VisitorsActivity$ListViewScrollListener(VisitorsActivity paramVisitorsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLastTop=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",mHeaderVisible=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",firstVi=");
      localStringBuilder.append(paramInt1);
      QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
    }
    paramAbsListView = paramAbsListView.getChildAt(0);
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() == 0) {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getHeight() + 0;
      } else {
        paramInt1 = 0;
      }
      paramInt1 = (int)(paramInt1 + VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity) * 77.0F);
      paramInt2 = paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f;
      paramInt3 = Math.abs(paramAbsListView.getTop());
      if (QLog.isColorLevel())
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() == 8) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.d("VisitorsActivity", 2, String.format("sumH=%d top=%d offset=%d tabBarShow=%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
      }
      if ((paramInt3 > this.jdField_a_of_type_Int) && (paramInt3 >= paramInt1) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() == 8))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
      }
      else if ((paramInt3 < this.jdField_a_of_type_Int) && (paramInt3 <= paramInt1) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() == 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
      }
      localStringBuilder = null;
      CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getText();
      if ((paramInt3 > this.jdField_a_of_type_Int) && (paramInt3 >= paramInt2) && ("".equals(localCharSequence)))
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      }
      else
      {
        paramAbsListView = localStringBuilder;
        if (paramInt3 < this.jdField_a_of_type_Int)
        {
          paramAbsListView = localStringBuilder;
          if (paramInt3 <= paramInt2)
          {
            paramAbsListView = localStringBuilder;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaLangString.equals(localCharSequence)) {
              paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getAnimation()))
      {
        paramAbsListView.reset();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.d) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.startAnimation(paramAbsListView);
        }
      }
      this.jdField_a_of_type_Int = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VersionUtils.m())
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.ListViewScrollListener
 * JD-Core Version:    0.7.0.1
 */