package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReminderListFragment$2
  implements View.OnClickListener
{
  ReminderListFragment$2(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReminderListFragment.b(this.a) != null) {
      ReminderListFragment.b(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.2
 * JD-Core Version:    0.7.0.1
 */