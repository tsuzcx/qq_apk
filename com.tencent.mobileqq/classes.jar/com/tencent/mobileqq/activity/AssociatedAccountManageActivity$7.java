package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;

class AssociatedAccountManageActivity$7
  implements Runnable
{
  AssociatedAccountManageActivity$7(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.this$0.app.getProxyManager();
      if (localProxyManager != null)
      {
        localProxyManager.transSaveToDatabase();
        FTSDBManager.a(this.this$0.app, this.jdField_a_of_type_JavaLangString, true);
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
        DBUtils.a().a(this.this$0.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.this$0.runOnUiThread(new AssociatedAccountManageActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7
 * JD-Core Version:    0.7.0.1
 */