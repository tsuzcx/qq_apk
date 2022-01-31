package com.tencent.biz.pubaccount;

import ajlb;
import android.os.Handler;
import azqs;
import bdiu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import nrc;
import syb;

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
      int i = syb.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        nrc.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.d, this.this$0.b);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    ajlb.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.d, this.this$0.b);
    azqs.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.this$0.d, "0X8004E43", "0X8004E43", 0, 0, this.this$0.d, "", "", "");
    bdiu.a(" pubAcc_follow_cancel", null, this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */