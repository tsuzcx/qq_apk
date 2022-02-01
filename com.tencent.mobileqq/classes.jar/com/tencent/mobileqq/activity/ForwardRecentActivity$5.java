package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$5
  implements View.OnClickListener
{
  ForwardRecentActivity$5(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.b))
    {
      if (ForwardRecentActivity.access$700(this.b, AppConstants.DATALINE_PC_UIN, 6000))
      {
        ForwardRecentActivity.access$300(this.b).a(false);
        ForwardRecentActivity.access$800(this.b, AppConstants.DATALINE_PC_UIN, 6000);
      }
      else if (ForwardRecentActivity.access$900(this.b, this.a))
      {
        ForwardRecentActivity.access$300(this.b).a(true);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(AppConstants.DATALINE_PC_UIN));
      localBundle.putInt("uintype", -1);
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "0");
      localBundle.putString("caller_name", this.b.mCallActivity);
      this.b.mForwardOption.a(ForwardAbility.ForwardAbilityType.g.intValue(), localBundle);
      this.b.mForwardOption.ao();
      ReportController.b(this.b.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.access$1000(this.b), 0, "", "", "", "");
      if (this.b.isSdkShare) {
        ReportCenter.a().a(this.b.app.getAccount(), "", this.b.appid, "1000", "34", "0", false, this.b.isSdkShare);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.5
 * JD-Core Version:    0.7.0.1
 */