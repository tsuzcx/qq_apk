package com.tencent.mobileqq.activity.home.impl;

import android.content.SharedPreferences;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class TabFrameControllerImpl$3
  implements Runnable
{
  TabFrameControllerImpl$3(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt) {}
  
  public void run()
  {
    String str2 = this.this$0.getCurrentTabTag(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost);
    if ((FrameControllerUtil.a.equals(str2)) || (FrameControllerUtil.b.equals(str2))) {
      if (!FrameControllerUtil.a.equals(str2)) {
        break label169;
      }
    }
    label169:
    for (String str1 = "Msg_tab";; str1 = "Contacts_tab")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_AndroidContentSharedPreferences != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), true))) {
        TabFrameControllerImpl.sFrameControllerInjectInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment, this.jdField_a_of_type_Int);
      }
      if ((str2 != null) && (AppSetting.d)) {
        this.this$0.dispatchTabContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment, str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */