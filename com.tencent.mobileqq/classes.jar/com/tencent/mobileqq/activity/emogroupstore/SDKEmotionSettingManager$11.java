package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class SDKEmotionSettingManager$11
  implements DialogInterface.OnClickListener
{
  SDKEmotionSettingManager$11(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKEmotionSettingManager.j(this.a);
      return;
    }
    if (paramInt == 0) {
      SDKEmotionSettingManager.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.11
 * JD-Core Version:    0.7.0.1
 */