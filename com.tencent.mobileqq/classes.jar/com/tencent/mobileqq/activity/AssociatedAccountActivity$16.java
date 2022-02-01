package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import mqq.os.MqqHandler;

class AssociatedAccountActivity$16
  implements OverScrollViewListener
{
  AssociatedAccountActivity$16(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.mIsStartRefreshList)
    {
      this.a.mTopRefreshTop.f();
      return;
    }
    this.a.mTopRefreshTop.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.mIsStartRefreshList) {
      return;
    }
    this.a.mTopRefreshTop.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.mIsStartRefreshList) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onViewCompleteVisableAndReleased begin refresh");
    }
    if (this.a.isNetConnToast())
    {
      this.a.mTopRefreshTop.a(0L);
      paramView = this.a;
      paramView.mIsFromPull = true;
      AssociatedAccountActivity.access$2300(paramView, false, true);
      return true;
    }
    this.a.mTopRefreshTop.a(1);
    this.a.mHandler.postDelayed(new AssociatedAccountActivity.16.1(this), 800L);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.16
 * JD-Core Version:    0.7.0.1
 */