package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectMemberBuddyListAdapter$3
  implements View.OnClickListener
{
  SelectMemberBuddyListAdapter$3(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)SelectMemberBuddyListAdapter.a(this.a));
    ReportController.b(SelectMemberBuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter.3
 * JD-Core Version:    0.7.0.1
 */