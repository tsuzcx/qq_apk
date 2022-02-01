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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$7.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_more", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$7.a.a, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$7.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$7.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.7.1
 * JD-Core Version:    0.7.0.1
 */