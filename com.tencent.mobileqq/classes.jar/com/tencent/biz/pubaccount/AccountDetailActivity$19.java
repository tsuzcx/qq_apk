package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$19
  implements Runnable
{
  AccountDetailActivity$19(AccountDetailActivity paramAccountDetailActivity) {}
  
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
      AccountDetailActivity.b(this.this$0, new AccountDetailActivity.19.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.19
 * JD-Core Version:    0.7.0.1
 */