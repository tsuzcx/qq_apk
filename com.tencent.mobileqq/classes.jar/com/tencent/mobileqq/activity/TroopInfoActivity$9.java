package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class TroopInfoActivity$9
  implements DialogInterface.OnClickListener
{
  TroopInfoActivity$9(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    String str2 = this.a.a.troopUin;
    if (this.a.a.bOwner) {}
    for (String str1 = "0";; str1 = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_clk", 0, 0, str2, str1, "1", "");
      paramDialogInterface.dismiss();
      this.a.k();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */