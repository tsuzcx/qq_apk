package com.tencent.biz.pubaccount;

import alik;
import android.os.Handler;
import bdla;
import bhfm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import okn;
import uuc;

class AccountDetailActivity$3
  implements Runnable
{
  AccountDetailActivity$3(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateUnfollowInfo");
    }
    if (this.this$0.k)
    {
      int i = uuc.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        okn.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.this$0.e, 1008);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    alik.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.e, 1008);
    bdla.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.this$0.e, "0X8004E43", "0X8004E43", 0, 0, this.this$0.e, "", "", "");
    bhfm.a(" pubAcc_follow_cancel", null, this.this$0.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */