package com.tencent.mobileqq.app.lifecycle;

import android.os.Message;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class BaseActivityInjectImpl$MyShakeListener
  extends ShakeListener
{
  public void a()
  {
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject == null) {
      ScreenShot.a("MyShakeListener - top activity is null");
    }
    do
    {
      return;
      if (!((QBaseActivity)localObject).mCurrentActivityShakeFlag)
      {
        ScreenShot.a("MyShakeListener - shake flag is false");
        return;
      }
    } while (ThreadManager.getSubThreadHandler().hasMessages(1001));
    localObject = ThreadManager.getSubThreadHandler().obtainMessage(1001, new BaseActivityInjectImpl.MyShakeListener.1(this, (QBaseActivity)localObject));
    ThreadManager.getSubThreadHandler().sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.MyShakeListener
 * JD-Core Version:    0.7.0.1
 */