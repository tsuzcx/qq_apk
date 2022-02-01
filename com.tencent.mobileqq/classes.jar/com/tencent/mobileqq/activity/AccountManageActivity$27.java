package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

class AccountManageActivity$27
  implements Runnable
{
  AccountManageActivity$27(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.this$0.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    this.this$0.runOnUiThread(new AccountManageActivity.27.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.27
 * JD-Core Version:    0.7.0.1
 */