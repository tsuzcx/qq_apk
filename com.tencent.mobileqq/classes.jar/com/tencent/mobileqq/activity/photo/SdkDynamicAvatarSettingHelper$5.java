package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class SdkDynamicAvatarSettingHelper$5
  implements DialogInterface.OnClickListener
{
  SdkDynamicAvatarSettingHelper$5(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ReportController.b(this.d, "dc00898", "", "", "0X8009DFD", "0X8009DFD", 0, 0, this.c, "", "", "");
      return;
    }
    SdkDynamicAvatarSettingHelper.a(this.a, true, this.b, this.c, false);
    this.a.finish();
    ReportController.b(this.d, "dc00898", "", "", "0X8009DFC", "0X8009DFC", 0, 0, this.c, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper.5
 * JD-Core Version:    0.7.0.1
 */