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
    String str = this.this$0.getCurrentTabTag(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost);
    Object localObject;
    if ((FrameControllerUtil.a.equals(str)) || (FrameControllerUtil.b.equals(str)))
    {
      if (FrameControllerUtil.a.equals(str)) {
        localObject = "Msg_tab";
      } else {
        localObject = "Contacts_tab";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("theme_voice_setting_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true)) {
        TabFrameControllerImpl.sFrameControllerInjectInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment, this.jdField_a_of_type_Int);
      }
    }
    if ((str != null) && (AppSetting.d)) {
      this.this$0.dispatchTabContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */