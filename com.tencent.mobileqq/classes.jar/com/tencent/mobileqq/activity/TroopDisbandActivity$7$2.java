package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopDisbandActivity$7$2
  implements DialogInterface.OnClickListener
{
  TroopDisbandActivity$7$2(TroopDisbandActivity.7 param7, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.b.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_know", 0, 0, this.b.a.k, "", "", "");
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.7.2
 * JD-Core Version:    0.7.0.1
 */