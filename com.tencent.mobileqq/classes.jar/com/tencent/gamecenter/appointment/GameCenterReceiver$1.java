package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import bnyp;
import bnyq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class GameCenterReceiver$1
  implements Runnable
{
  GameCenterReceiver$1(GameCenterReceiver paramGameCenterReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.equals(this.a, "android.intent.action.PACKAGE_REMOVED"))
      {
        if (BaseApplicationImpl.sProcessId == 1) {
          bnyp.a().a("doUninstallAppCompleted", this.b);
        }
      }
      else if ((TextUtils.equals(this.a, "android.intent.action.PACKAGE_ADDED")) && (BaseApplicationImpl.sProcessId == 1))
      {
        bnyp.a().a("doInstallAppCompleted", this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GameCenterReceiver", 2, "receiveSystemInstallAction exception:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.1
 * JD-Core Version:    0.7.0.1
 */