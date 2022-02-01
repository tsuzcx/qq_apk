package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.QQPermissionCallback;

class AssistantSettingActivity$6$1
  implements QQPermissionCallback
{
  AssistantSettingActivity$6$1(AssistantSettingActivity.6 param6) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord("Setting tips");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.6.1
 * JD-Core Version:    0.7.0.1
 */