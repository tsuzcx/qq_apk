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

class ForwardRecentActivity$5
  implements View.OnClickListener
{
  ForwardRecentActivity$5(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      if (ForwardRecentActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_IPAD_UIN, 6003))
      {
        ForwardRecentActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_IPAD_UIN, 6003);
      }
      else if (ForwardRecentActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord))
      {
        ForwardRecentActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", AppConstants.DATALINE_IPAD_UIN);
      localBundle.putInt("uintype", -1);
      localBundle.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.mCallActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.mForwardOption.a(ForwardAbility.ForwardAbilityType.k.intValue(), localBundle);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.access$800(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.5
 * JD-Core Version:    0.7.0.1
 */