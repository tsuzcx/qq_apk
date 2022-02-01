package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$20
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$20(AssistantSettingActivity paramAssistantSettingActivity, IDoutuService paramIDoutuService) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoutuApiIDoutuService.updateDoutuSetting(paramBoolean);
    if (!paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081DD", "0X80081DD", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081F1", "0X80081F1", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.20
 * JD-Core Version:    0.7.0.1
 */