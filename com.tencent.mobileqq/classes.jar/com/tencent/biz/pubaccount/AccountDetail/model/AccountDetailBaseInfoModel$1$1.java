package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class AccountDetailBaseInfoModel$1$1
  implements Runnable
{
  AccountDetailBaseInfoModel$1$1(AccountDetailBaseInfoModel.1 param1, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
    }
    AccountDetailBaseInfoModel.a(this.this$0.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1
 * JD-Core Version:    0.7.0.1
 */