package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReminderListFragment$1
  implements View.OnClickListener
{
  ReminderListFragment$1(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    ReminderListFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.1
 * JD-Core Version:    0.7.0.1
 */