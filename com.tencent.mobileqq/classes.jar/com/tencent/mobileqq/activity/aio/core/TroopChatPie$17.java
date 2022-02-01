package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class TroopChatPie$17
  implements DialogInterface.OnClickListener
{
  TroopChatPie$17(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.d(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null)) {
      if (((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).isTroopOwner(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        paramDialogInterface.k(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    for (;;)
    {
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_quitgrp").a(new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }).a();
      return;
      paramDialogInterface.j(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      continue;
      if (paramDialogInterface != null) {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131694510, 0).a();
      } else {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131692165, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.17
 * JD-Core Version:    0.7.0.1
 */