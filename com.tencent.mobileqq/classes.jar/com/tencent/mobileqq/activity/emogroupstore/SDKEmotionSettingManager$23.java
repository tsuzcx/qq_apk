package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SDKEmotionSettingManager$23
  implements DialogInterface.OnClickListener
{
  SDKEmotionSettingManager$23(SDKEmotionSettingManager paramSDKEmotionSettingManager, boolean paramBoolean, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X8009DCA", "0X8009DCA", 0, 0, SDKEmotionSettingManager.b(this.c), "", "", "");
    if (this.a)
    {
      paramDialogInterface = this.c;
      SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.b(this.c)).longValue(), false);
      return;
    }
    paramDialogInterface = this.c;
    SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.b(this.c)).longValue(), false, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.23
 * JD-Core Version:    0.7.0.1
 */