package com.tencent.biz.pubaccount;

import bhfm;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$6
  implements Runnable
{
  AccountDetailActivity$6(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateFollowInfo");
    }
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.d();
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null) {}
    for (boolean bool = true;; bool = false)
    {
      bhfm.a("pubAcc_follow_confirm", null, this.this$0.e);
      if (!this.this$0.c(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        break;
      }
      return;
    }
    AccountDetailActivity.a(this.this$0, new AccountDetailActivity.6.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */