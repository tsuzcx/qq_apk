package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;

class ReminderListFragment$9$1
  implements Runnable
{
  ReminderListFragment$9$1(ReminderListFragment.9 param9) {}
  
  public void run()
  {
    PullToRefreshRecyclerView localPullToRefreshRecyclerView = ReminderListFragment.a(this.a.a);
    PullToRefreshBase.Mode localMode;
    if (ReminderListFragment.a(this.a.a)) {
      localMode = PullToRefreshBase.Mode.BOTH;
    } else {
      localMode = PullToRefreshBase.Mode.PULL_FROM_START;
    }
    localPullToRefreshRecyclerView.setMode(localMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9.1
 * JD-Core Version:    0.7.0.1
 */