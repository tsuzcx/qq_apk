package com.tencent.mobileqq.activity;

import aoxz;
import bdxj;
import bhdf;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

class AccountManageActivity$9
  implements Runnable
{
  AccountManageActivity$9(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    int i;
    if ((RecentUser)this.this$0.app.getProxyManager().a().findRecentUser(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) != null)
    {
      i = bhdf.a().a(this.this$0.app.getCurrentAccountUin());
      if (i >= 3) {
        if (QLog.isColorLevel()) {
          QLog.d("AccountManageActivity", 2, "refreshSubAccount() set stick2top fail." + this.this$0.app.getCurrentAccountUin() + " count=" + i + " >=max_stick2top_count , return.");
        }
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "refreshSubAccount() RecentList has default subAccount RU. go 2 stick2Top, current count=" + i);
      }
      bdxj.a(this.this$0.app, AppConstants.SUBACCOUNT_ASSISTANT_UIN, true);
      bhdf.a().a(this.this$0.app.getCurrentAccountUin(), i);
      return;
      bhdf.a().a(this.this$0.app.getCurrentAccountUin(), 3);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "recent list does not exist ruDefault.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.9
 * JD-Core Version:    0.7.0.1
 */