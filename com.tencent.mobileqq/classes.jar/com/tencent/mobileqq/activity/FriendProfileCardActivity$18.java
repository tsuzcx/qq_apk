package com.tencent.mobileqq.activity;

import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Iterator;
import java.util.List;

class FriendProfileCardActivity$18
  implements AbsListView.OnScrollListener
{
  FriendProfileCardActivity$18(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FriendProfileCardActivity.a(this.a) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.a().a("vas_profilecard_list", false);
    }
    while (FriendProfileCardActivity.a(this.a) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
      }
      DropFrameMonitor.a().a("vas_profilecard_list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.18
 * JD-Core Version:    0.7.0.1
 */