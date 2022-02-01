package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$12
  implements Runnable
{
  AccountDetailActivity$12(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData loadDatabase");
    }
    AccountDetailActivity localAccountDetailActivity = this.this$0;
    if (!this.this$0.e()) {}
    for (boolean bool = true;; bool = false)
    {
      localAccountDetailActivity.c = bool;
      AccountDetailActivity.b(this.this$0, new AccountDetailActivity.12.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.12
 * JD-Core Version:    0.7.0.1
 */