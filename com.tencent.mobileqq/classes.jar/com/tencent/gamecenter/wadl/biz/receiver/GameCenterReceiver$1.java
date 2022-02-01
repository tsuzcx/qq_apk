package com.tencent.gamecenter.wadl.biz.receiver;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class GameCenterReceiver$1
  implements Runnable
{
  GameCenterReceiver$1(GameCenterReceiver paramGameCenterReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      boolean bool = TextUtils.equals(this.a, "android.intent.action.PACKAGE_REMOVED");
      IQQGameDownloadService localIQQGameDownloadService;
      if (bool)
      {
        if (MobileQQ.sProcessId == 1)
        {
          localIQQGameDownloadService = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
          if (localIQQGameDownloadService != null) {
            localIQQGameDownloadService.doAppSystemReceiver("doUninstallAppCompleted", this.b);
          }
        }
      }
      else if ((TextUtils.equals(this.a, "android.intent.action.PACKAGE_ADDED")) && (MobileQQ.sProcessId == 1))
      {
        localIQQGameDownloadService = (IQQGameDownloadService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDownloadService.class, "multi");
        if (localIQQGameDownloadService != null)
        {
          localIQQGameDownloadService.doAppSystemReceiver("doInstallAppCompleted", this.b);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveSystemInstallAction exception:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("Wadl_GameCenterReceiver", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.1
 * JD-Core Version:    0.7.0.1
 */