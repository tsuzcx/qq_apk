package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SDKEmotionSettingManager$22
  implements DialogInterface.OnClickListener
{
  SDKEmotionSettingManager$22(SDKEmotionSettingManager paramSDKEmotionSettingManager, boolean paramBoolean, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X8009DCB", "0X8009DCB", 0, 0, SDKEmotionSettingManager.b(this.c), "", "", "");
    if (this.a)
    {
      paramDialogInterface = this.c;
      SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.b(this.c)).longValue(), false);
    }
    else
    {
      paramDialogInterface = this.c;
      SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.b(this.c)).longValue(), false, this.b);
    }
    this.c.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.22
 * JD-Core Version:    0.7.0.1
 */