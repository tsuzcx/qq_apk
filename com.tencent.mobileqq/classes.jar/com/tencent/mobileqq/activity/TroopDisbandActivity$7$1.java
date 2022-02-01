package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopDisbandActivity$7$1
  implements DialogInterface.OnClickListener
{
  TroopDisbandActivity$7$1(TroopDisbandActivity.7 param7, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.b.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_more", 0, 0, this.b.a.k, "", "", "");
    paramDialogInterface = new Intent(this.b.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.b.a.startActivity(paramDialogInterface);
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.7.1
 * JD-Core Version:    0.7.0.1
 */