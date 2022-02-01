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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopTransferActivity$13
  implements DialogInterface.OnClickListener
{
  TroopTransferActivity$13(TroopTransferActivity paramTroopTransferActivity, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity;
        paramDialogInterface.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(paramDialogInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692183, 1000);
      return;
    }
    paramDialogInterface = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if (paramDialogInterface != null) {
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getCurrentAccountUin());
        long l3 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Boolean = true;
        paramDialogInterface.a(l1, l2, l3);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131719753, 1000);
      }
      catch (Exception paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, paramDialogInterface.toString());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.13
 * JD-Core Version:    0.7.0.1
 */