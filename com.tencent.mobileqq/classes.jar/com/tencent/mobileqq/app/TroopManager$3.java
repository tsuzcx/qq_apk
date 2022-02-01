package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopManager$3
  implements DialogInterface.OnClickListener
{
  TroopManager$3(TroopManager paramTroopManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(this.b, Boolean.valueOf(false));
    ReportController.b(this.c, "dc00898", "", "", "qq_vip", "0X800A57E", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.3
 * JD-Core Version:    0.7.0.1
 */