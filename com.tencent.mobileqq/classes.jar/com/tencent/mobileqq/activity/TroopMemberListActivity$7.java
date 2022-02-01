package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$7
  implements View.OnClickListener
{
  TroopMemberListActivity$7(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    localTroopMemberListActivity.setResult(0, localTroopMemberListActivity.getIntent());
    this.a.finish();
    if (this.a.mFrom == 11) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.7
 * JD-Core Version:    0.7.0.1
 */