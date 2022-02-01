package com.tencent.biz.pubaccount.AccountDetail.view;

import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$14$1$1
  implements Runnable
{
  AccountDetailGroupListContainer$14$1$1(AccountDetailGroupListContainer.14.1 param1, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "saveAccountDetailInSubThread");
    }
    AccountDetailBaseInfoModel.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14$1.a.a.a, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.14.1.1
 * JD-Core Version:    0.7.0.1
 */