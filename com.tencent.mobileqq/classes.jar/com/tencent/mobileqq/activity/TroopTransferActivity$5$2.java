package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopTransferActivity$5$2
  implements DialogInterface.OnClickListener
{
  TroopTransferActivity$5$2(TroopTransferActivity.5 param5, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$5.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$5.a.a, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.5.2
 * JD-Core Version:    0.7.0.1
 */