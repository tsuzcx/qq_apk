package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.open.OpenProxy;

class AccountManageActivity$22
  implements Runnable
{
  AccountManageActivity$22(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    OpenProxy.a().b(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.this$0.app.getProxyManager();
      if (localProxyManager != null)
      {
        localProxyManager.transSaveToDatabase();
        ((IFTSDBRuntimeService)this.this$0.app.getRuntimeService(IFTSDBRuntimeService.class, "")).clearFTS(this.this$0.app, this.jdField_a_of_type_JavaLangString, true);
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
        DBUtils.a().a(this.this$0.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.this$0.runOnUiThread(new AccountManageActivity.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.22
 * JD-Core Version:    0.7.0.1
 */