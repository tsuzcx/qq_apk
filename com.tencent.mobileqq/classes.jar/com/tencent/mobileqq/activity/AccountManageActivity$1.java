package com.tencent.mobileqq.activity;

import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class AccountManageActivity$1
  implements Runnable
{
  AccountManageActivity$1(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.app != null)
      {
        anvk localanvk = (anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localanvk != null) {
          AccountManageActivity.a(this.this$0, localanvk.b(this.this$0.app.getCurrentAccountUin()));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.1
 * JD-Core Version:    0.7.0.1
 */