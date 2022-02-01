package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qassistant.wake.WakeManager;
import mqq.app.QQPermissionCallback;

class AssistantSettingActivity$6$1
  implements QQPermissionCallback
{
  AssistantSettingActivity$6$1(AssistantSettingActivity.6 param6) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    WakeManager.a().a("Setting tips");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.6.1
 * JD-Core Version:    0.7.0.1
 */