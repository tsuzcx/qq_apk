package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class SpecailCareListActivity$2
  implements OverScrollViewListener
{
  SpecailCareListActivity$2(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.a.j.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.a.j.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.j.a(0L);
    if (NetworkUtil.isNetSupport(this.a))
    {
      this.a.v.getFriendGroupList(true);
      paramView = this.a;
      paramView.r = true;
      ((QzoneContactsFeedManager)paramView.app.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
      return true;
    }
    paramView = this.a.A.obtainMessage(2000, 0, 0);
    this.a.A.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.2
 * JD-Core Version:    0.7.0.1
 */