package com.tencent.biz.common.offline;

import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class OfflineExpire$OfflineExpireCheckUpdate$1
  implements Runnable
{
  OfflineExpire$OfflineExpireCheckUpdate$1(OfflineExpire.OfflineExpireCheckUpdate paramOfflineExpireCheckUpdate) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      new OfflineWebResManager((AppInterface)localAppRuntime).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate.1
 * JD-Core Version:    0.7.0.1
 */