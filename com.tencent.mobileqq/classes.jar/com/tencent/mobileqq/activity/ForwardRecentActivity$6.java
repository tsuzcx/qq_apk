package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$6
  implements View.OnClickListener
{
  ForwardRecentActivity$6(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.b))
    {
      if (ForwardRecentActivity.access$700(this.b, AppConstants.DATALINE_IPAD_UIN, 6003))
      {
        ForwardRecentActivity.access$1100(this.b).a(false);
        ForwardRecentActivity.access$800(this.b, AppConstants.DATALINE_IPAD_UIN, 6003);
      }
      else if (ForwardRecentActivity.access$900(this.b, this.a))
      {
        ForwardRecentActivity.access$1100(this.b).a(true);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", AppConstants.DATALINE_IPAD_UIN);
      localBundle.putInt("uintype", -1);
      localBundle.putString("caller_name", this.b.mCallActivity);
      this.b.mForwardOption.a(ForwardAbility.ForwardAbilityType.l.intValue(), localBundle);
      ReportController.b(this.b.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.access$1000(this.b), 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.6
 * JD-Core Version:    0.7.0.1
 */