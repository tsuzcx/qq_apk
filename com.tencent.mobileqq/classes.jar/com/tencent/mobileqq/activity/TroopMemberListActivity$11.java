package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$11
  implements View.OnClickListener
{
  TroopMemberListActivity$11(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.showActionSheet();
    new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.a.mTroopUin }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.11
 * JD-Core Version:    0.7.0.1
 */