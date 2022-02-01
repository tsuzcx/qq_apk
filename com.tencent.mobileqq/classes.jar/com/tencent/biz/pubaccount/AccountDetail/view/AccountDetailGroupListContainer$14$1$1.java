package com.tencent.biz.pubaccount.accountdetail.view;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$14$1$1
  implements Runnable
{
  AccountDetailGroupListContainer$14$1$1(AccountDetailGroupListContainer.14.1 param1, PublicAccountDetailImpl paramPublicAccountDetailImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "saveAccountDetailInSubThread");
    }
    AccountDetailBaseInfoModel.a(this.b.b.c.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14.1.1
 * JD-Core Version:    0.7.0.1
 */