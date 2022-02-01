package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.QQPermissionCallback;

class AssistantSettingActivity$4$2
  implements QQPermissionCallback
{
  AssistantSettingActivity$4$2(AssistantSettingActivity.4 param4, WakeServiceCallBack paramWakeServiceCallBack) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$4.a, 2131695323, 1).a();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$4.a, "AssistantSettingActivity", this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeServiceCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.4.2
 * JD-Core Version:    0.7.0.1
 */