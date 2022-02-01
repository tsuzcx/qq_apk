package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class SDKEmotionSettingManager$12
  implements DialogInterface.OnClickListener
{
  SDKEmotionSettingManager$12(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      SDKEmotionSettingManager.a(this.a, SDKEmotionSettingManager.a(this.a), Long.valueOf(SDKEmotionSettingManager.b(this.a)).longValue());
      SDKEmotionSettingManager.c(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      label41:
      break label41;
    }
    QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.12
 * JD-Core Version:    0.7.0.1
 */