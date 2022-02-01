package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import nqo;
import nqp;

public class AccountDetailBaseInfoModel$1$1
  implements Runnable
{
  public AccountDetailBaseInfoModel$1$1(nqp paramnqp, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
    }
    nqo.a(this.this$0.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1
 * JD-Core Version:    0.7.0.1
 */