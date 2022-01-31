package com.tencent.mobileqq.activity;

import aktb;
import asel;
import bbcp;
import bcxj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class AccountManageActivity$18
  implements Runnable
{
  AccountManageActivity$18(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    bcxj.a().b(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.this$0.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.d();
        aktb.a(this.this$0.app, this.jdField_a_of_type_JavaLangString, true);
        new asel().a(this.jdField_a_of_type_JavaLangString);
        bbcp.a().a(this.this$0.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.this$0.runOnUiThread(new AccountManageActivity.18.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.18
 * JD-Core Version:    0.7.0.1
 */