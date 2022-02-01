package com.tencent.mobileqq.activity.activateFriend;

import afne;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;

public class ReminderListFragment$9$1
  implements Runnable
{
  public ReminderListFragment$9$1(afne paramafne) {}
  
  public void run()
  {
    PullToRefreshRecyclerView localPullToRefreshRecyclerView = ReminderListFragment.a(this.a.a);
    if (ReminderListFragment.a(this.a.a)) {}
    for (PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.BOTH;; localMode = PullToRefreshBase.Mode.PULL_FROM_START)
    {
      localPullToRefreshRecyclerView.setMode(localMode);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9.1
 * JD-Core Version:    0.7.0.1
 */