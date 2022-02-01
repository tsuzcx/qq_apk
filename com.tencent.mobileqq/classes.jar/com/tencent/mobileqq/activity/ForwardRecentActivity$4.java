package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$4
  implements View.OnClickListener
{
  ForwardRecentActivity$4(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity)) {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_PC_UIN, 6000))
      {
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_PC_UIN, 6000);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord))
      {
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
        continue;
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", String.valueOf(AppConstants.DATALINE_PC_UIN));
        localBundle.putInt("uintype", -1);
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
        localBundle.putString("forward_report_confirm_reverse2", "0");
        localBundle.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.c);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), localBundle);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.D();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Boolean) {
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app.getAccount(), "", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.b, "1000", "34", "0", false, this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Boolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.4
 * JD-Core Version:    0.7.0.1
 */