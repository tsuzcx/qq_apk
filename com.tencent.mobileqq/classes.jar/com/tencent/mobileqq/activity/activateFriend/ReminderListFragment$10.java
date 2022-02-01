package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.widget.QQToast;

class ReminderListFragment$10
  implements Runnable
{
  ReminderListFragment$10(ReminderListFragment paramReminderListFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getBaseActivity() != null) {
      QQToast.makeText(this.this$0.getBaseActivity(), this.a, 0).show();
    }
    ReminderListFragment.e(this.this$0).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.10
 * JD-Core Version:    0.7.0.1
 */