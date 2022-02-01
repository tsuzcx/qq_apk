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
      if (this.c.x == null)
      {
        paramDialogInterface = this.c;
        paramDialogInterface.x = new QQProgressNotifier(paramDialogInterface);
      }
      this.c.x.b(2, 2131889169, 1000);
      return;
    }
    paramDialogInterface = (ITroopMngHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if (paramDialogInterface != null) {
      try
      {
        long l1 = Long.parseLong(this.c.r);
        long l2 = Long.parseLong(this.c.app.getCurrentAccountUin());
        long l3 = Long.parseLong(this.a);
        this.c.w = true;
        paramDialogInterface.a(l1, l2, l3);
        if (this.c.x == null) {
          this.c.x = new QQProgressNotifier(this.c);
        }
        this.c.x.b(0, 2131917356, 1000);
      }
      catch (Exception paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, paramDialogInterface.toString());
        }
      }
    }
    this.b.cancel();
    ReportController.b(this.c.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.13
 * JD-Core Version:    0.7.0.1
 */