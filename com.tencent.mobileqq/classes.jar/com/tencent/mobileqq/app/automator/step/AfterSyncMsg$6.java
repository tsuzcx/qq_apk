package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AfterSyncMsg$6
  implements Runnable
{
  AfterSyncMsg$6(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    QLog.e("QQInitHandler", 1, "VipInfoHandler PreloadWebService AfterSyncMsg");
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Intent localIntent = new Intent(localBaseApplication, PreloadWebService.class);
    try
    {
      localBaseApplication.startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQInitHandler", 2, "PreloadWebService", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.6
 * JD-Core Version:    0.7.0.1
 */