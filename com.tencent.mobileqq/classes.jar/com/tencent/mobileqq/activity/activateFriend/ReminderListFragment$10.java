package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.widget.QQToast;

class ReminderListFragment$10
  implements Runnable
{
  ReminderListFragment$10(ReminderListFragment paramReminderListFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getActivity() != null) {
      QQToast.a(this.this$0.getActivity(), this.a, 0).a();
    }
    ReminderListFragment.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.10
 * JD-Core Version:    0.7.0.1
 */