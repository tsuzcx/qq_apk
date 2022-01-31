package com.tencent.mobileqq.app;

import alto;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class FrameHelperActivity$2
  implements Runnable
{
  FrameHelperActivity$2(FrameHelperActivity paramFrameHelperActivity) {}
  
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
          alto localalto = (alto)((QQAppInterface)localObject).getManager(51);
          if (localalto != null)
          {
            FrameHelperActivity.a(this.this$0, localalto.b(((QQAppInterface)localObject).getCurrentAccountUin()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.2
 * JD-Core Version:    0.7.0.1
 */