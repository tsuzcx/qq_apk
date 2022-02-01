package com.tencent.biz.pubaccount;

import android.os.Handler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$21
  implements Runnable
{
  AccountDetailActivity$21(AccountDetailActivity paramAccountDetailActivity, AccountDetail paramAccountDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    if (this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    AccountDetailActivity.d(this.this$0, new AccountDetailActivity.21.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.21
 * JD-Core Version:    0.7.0.1
 */