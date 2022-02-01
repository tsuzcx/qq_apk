package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopDisbandActivity$4
  implements DialogInterface.OnClickListener
{
  TroopDisbandActivity$4(TroopDisbandActivity paramTroopDisbandActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.k(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131692170, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692165, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694510, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.4
 * JD-Core Version:    0.7.0.1
 */