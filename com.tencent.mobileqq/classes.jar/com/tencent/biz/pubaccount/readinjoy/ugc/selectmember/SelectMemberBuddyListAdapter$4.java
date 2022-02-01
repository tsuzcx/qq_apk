package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectMemberBuddyListAdapter$4
  implements View.OnClickListener
{
  SelectMemberBuddyListAdapter$4(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)this.a.a);
    ReportController.b(SelectMemberBuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.4
 * JD-Core Version:    0.7.0.1
 */