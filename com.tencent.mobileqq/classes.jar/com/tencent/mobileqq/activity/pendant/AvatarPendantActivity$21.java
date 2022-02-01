package com.tencent.mobileqq.activity.pendant;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class AvatarPendantActivity$21
  implements DialogInterface.OnClickListener
{
  AvatarPendantActivity$21(AvatarPendantActivity paramAvatarPendantActivity, PendantTipsInfo paramPendantTipsInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.c.a(this.a, false, this.b);
    ReportController.b(this.c.app, "CliOper", "", "", "0X8005FD9", "0X8005FD9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.21
 * JD-Core Version:    0.7.0.1
 */