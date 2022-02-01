package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AssistantSettingActivity$1$1
  implements Runnable
{
  AssistantSettingActivity$1$1(AssistantSettingActivity.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$1.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$1.a.app.getApp();
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131700996;
    } else {
      i = 2131700992;
    }
    QQToast.a(localBaseApplication, HardCodeUtil.a(i), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.1.1
 * JD-Core Version:    0.7.0.1
 */