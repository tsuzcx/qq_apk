package com.tencent.gamecenter.wadl.biz.receiver;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
        if (MobileQQ.sProcessId == 1) {
          ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doAppSystemReceiver("doUninstallAppCompleted", this.b);
        }
      }
      else if ((TextUtils.equals(this.a, "android.intent.action.PACKAGE_ADDED")) && (MobileQQ.sProcessId == 1))
      {
        ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doAppSystemReceiver("doInstallAppCompleted", this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.1
 * JD-Core Version:    0.7.0.1
 */