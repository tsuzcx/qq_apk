package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class SDKEmotionSettingManager$4
  implements QQPermissionCallback
{
  SDKEmotionSettingManager$4(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    DialogUtil.a(SDKEmotionSettingManager.a(this.a), new SDKEmotionSettingManager.4.1(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    SDKEmotionSettingManager.a(this.a, SDKEmotionSettingManager.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.4
 * JD-Core Version:    0.7.0.1
 */