package com.tencent.mobileqq.activity;

import bdxs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AccountManageActivity$24
  implements Runnable
{
  AccountManageActivity$24(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    bdxs localbdxs = (bdxs)this.this$0.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    this.this$0.runOnUiThread(new AccountManageActivity.24.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.24
 * JD-Core Version:    0.7.0.1
 */