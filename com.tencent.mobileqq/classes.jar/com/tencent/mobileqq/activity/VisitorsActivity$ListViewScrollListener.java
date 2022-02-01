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
  int a = 0;
  boolean b = true;
  
  VisitorsActivity$ListViewScrollListener(VisitorsActivity paramVisitorsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLastTop=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",mHeaderVisible=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",firstVi=");
      localStringBuilder.append(paramInt1);
      QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
    }
    paramAbsListView = paramAbsListView.getChildAt(0);
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      if (this.c.x.getVisibility() == 0) {
        paramInt1 = this.c.x.getHeight() + 0;
      } else {
        paramInt1 = 0;
      }
      paramInt1 = (int)(paramInt1 + VisitorsActivity.d(this.c) * 77.0F);
      paramInt2 = paramInt1 - this.c.R;
      paramInt3 = Math.abs(paramAbsListView.getTop());
      if (QLog.isColorLevel())
      {
        boolean bool;
        if (this.c.b.getVisibility() == 8) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.d("VisitorsActivity", 2, String.format("sumH=%d top=%d offset=%d tabBarShow=%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
      }
      if ((paramInt3 > this.a) && (paramInt3 >= paramInt1) && (this.c.b.getVisibility() == 8))
      {
        this.b = false;
        this.c.b.setVisibility(0);
      }
      else if ((paramInt3 < this.a) && (paramInt3 <= paramInt1) && (this.c.b.getVisibility() == 0))
      {
        this.b = true;
        this.c.b.setVisibility(8);
      }
      localStringBuilder = null;
      CharSequence localCharSequence = this.c.centerView.getText();
      if ((paramInt3 > this.a) && (paramInt3 >= paramInt2) && ("".equals(localCharSequence)))
      {
        paramAbsListView = this.c.V;
      }
      else
      {
        paramAbsListView = localStringBuilder;
        if (paramInt3 < this.a)
        {
          paramAbsListView = localStringBuilder;
          if (paramInt3 <= paramInt2)
          {
            paramAbsListView = localStringBuilder;
            if (this.c.S.equals(localCharSequence)) {
              paramAbsListView = this.c.W;
            }
          }
        }
      }
      if ((paramAbsListView != null) && (paramAbsListView != this.c.centerView.getAnimation()))
      {
        paramAbsListView.reset();
        if (this.c.t) {
          this.c.centerView.startAnimation(paramAbsListView);
        }
      }
      this.a = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VersionUtils.m())
    {
      paramAbsListView = this.c.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.ListViewScrollListener
 * JD-Core Version:    0.7.0.1
 */