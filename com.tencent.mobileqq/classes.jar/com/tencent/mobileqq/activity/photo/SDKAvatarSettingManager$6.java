package com.tencent.mobileqq.activity.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SDKAvatarSettingManager$6
  implements DialogInterface.OnClickListener
{
  SDKAvatarSettingManager$6(SDKAvatarSettingManager paramSDKAvatarSettingManager, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReportController.b(this.a, "dc00898", "", "", "0X8009B6D", "0X8009B6D", 0, 0, "", "", "", "");
        paramDialogInterface = this.b;
        SDKAvatarSettingManager.a(paramDialogInterface, SDKAvatarSettingManager.a(paramDialogInterface), true, Long.valueOf(SDKAvatarSettingManager.g(this.b)).longValue(), true);
      }
    }
    else
    {
      ReportController.b(this.a, "dc00898", "", "", "0X8009B6C", "0X8009B6C", 0, 0, "", "", "", "");
      this.b.b();
      paramDialogInterface = this.b;
      SDKAvatarSettingManager.a(paramDialogInterface, SDKAvatarSettingManager.a(paramDialogInterface), true, Long.valueOf(SDKAvatarSettingManager.g(this.b)).longValue(), false);
    }
    this.b.d.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.6
 * JD-Core Version:    0.7.0.1
 */