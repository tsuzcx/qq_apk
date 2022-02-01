package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopDisbandActivity$4
  implements DialogInterface.OnClickListener
{
  TroopDisbandActivity$4(TroopDisbandActivity paramTroopDisbandActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
      paramDialogInterface.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(paramDialogInterface);
    }
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131692090, 1000);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694475, 1500);
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.4
 * JD-Core Version:    0.7.0.1
 */