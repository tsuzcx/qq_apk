package com.tencent.mobileqq.activity.contacts.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BuddyListAdapter$3
  implements View.OnClickListener
{
  BuddyListAdapter$3(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a(this.a.a);
    ReportController.b(BuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.3
 * JD-Core Version:    0.7.0.1
 */