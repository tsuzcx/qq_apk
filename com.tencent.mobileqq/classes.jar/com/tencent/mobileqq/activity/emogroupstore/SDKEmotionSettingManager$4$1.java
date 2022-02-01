package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.startup.step.CheckPermission.SDCardPermissionCallback;
import com.tencent.qphone.base.util.QLog;

class SDKEmotionSettingManager$4$1
  implements CheckPermission.SDCardPermissionCallback
{
  SDKEmotionSettingManager$4$1(SDKEmotionSettingManager.4 param4) {}
  
  public void a()
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog grant");
  }
  
  public void b()
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog denied");
    SDKEmotionSettingManager.a(this.a.a, SDKEmotionSettingManager.b(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.4.1
 * JD-Core Version:    0.7.0.1
 */