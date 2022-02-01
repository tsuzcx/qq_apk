package com.tencent.mobileqq.app;

import android.support.v4.app.FragmentActivity;
import anvk;
import com.tencent.qphone.base.util.QLog;

class FrameHelperActivity$3
  implements Runnable
{
  FrameHelperActivity$3(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.getActivity();
      if (localObject != null)
      {
        if (((FragmentActivity)localObject).getAppInterface() == null) {
          return;
        }
        localObject = ((FragmentActivity)localObject).app;
        if (localObject != null)
        {
          anvk localanvk = (anvk)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localanvk != null)
          {
            FrameHelperActivity.a(this.this$0, localanvk.b(((QQAppInterface)localObject).getCurrentAccountUin()));
            return;
          }
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.3
 * JD-Core Version:    0.7.0.1
 */