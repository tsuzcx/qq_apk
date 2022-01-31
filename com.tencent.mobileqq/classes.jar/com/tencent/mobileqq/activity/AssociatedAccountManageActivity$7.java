package com.tencent.mobileqq.activity;

import amjf;
import atvn;
import bdbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class AssociatedAccountManageActivity$7
  implements Runnable
{
  AssociatedAccountManageActivity$7(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.this$0.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.d();
        amjf.a(this.this$0.app, this.jdField_a_of_type_JavaLangString, true);
        new atvn().a(this.jdField_a_of_type_JavaLangString);
        bdbx.a().a(this.this$0.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.this$0.runOnUiThread(new AssociatedAccountManageActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7
 * JD-Core Version:    0.7.0.1
 */