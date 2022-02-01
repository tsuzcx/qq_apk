package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.open.OpenProxy;

class AccountManageActivity$19
  implements Runnable
{
  AccountManageActivity$19(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    OpenProxy.a().b(this.a);
    if (this.b)
    {
      ProxyManager localProxyManager = this.this$0.app.getProxyManager();
      if (localProxyManager != null)
      {
        localProxyManager.transSaveToDatabase();
        ((IFTSDBRuntimeService)this.this$0.app.getRuntimeService(IFTSDBRuntimeService.class, "")).clearFTS(this.this$0.app, this.a, true);
        new MessageRecordManagerImpl().a(this.a);
        DBUtils.a().a(this.this$0.app.getApp(), this.a, false);
      }
    }
    this.this$0.runOnUiThread(new AccountManageActivity.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19
 * JD-Core Version:    0.7.0.1
 */