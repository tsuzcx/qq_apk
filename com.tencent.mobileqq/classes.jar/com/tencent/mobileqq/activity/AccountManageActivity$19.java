package com.tencent.mobileqq.activity;

import amnu;
import atzw;
import bdgg;
import bfbj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class AccountManageActivity$19
  implements Runnable
{
  AccountManageActivity$19(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    bfbj.a().b(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.this$0.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.d();
        amnu.a(this.this$0.app, this.jdField_a_of_type_JavaLangString, true);
        new atzw().a(this.jdField_a_of_type_JavaLangString);
        bdgg.a().a(this.this$0.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.this$0.runOnUiThread(new AccountManageActivity.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19
 * JD-Core Version:    0.7.0.1
 */