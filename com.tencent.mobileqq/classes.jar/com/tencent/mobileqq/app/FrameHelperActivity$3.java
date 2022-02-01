package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class FrameHelperActivity$3
  implements Runnable
{
  FrameHelperActivity$3(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.C();
      if (localObject != null)
      {
        if (((QBaseActivity)localObject).getAppRuntime() == null) {
          return;
        }
        localObject = (QQAppInterface)((QBaseActivity)localObject).getAppRuntime();
        if (localObject != null)
        {
          FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localFriendsManager != null) {
            FrameHelperActivity.a(this.this$0, localFriendsManager.f(((QQAppInterface)localObject).getCurrentAccountUin()));
          }
        }
      }
      else {}
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.3
 * JD-Core Version:    0.7.0.1
 */