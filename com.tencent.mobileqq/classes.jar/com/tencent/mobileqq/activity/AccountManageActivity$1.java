package com.tencent.mobileqq.activity;

import alto;
import com.tencent.mobileqq.app.QQAppInterface;
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
        alto localalto = (alto)this.this$0.app.getManager(51);
        if (localalto != null) {
          AccountManageActivity.a(this.this$0, localalto.b(this.this$0.app.getCurrentAccountUin()));
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