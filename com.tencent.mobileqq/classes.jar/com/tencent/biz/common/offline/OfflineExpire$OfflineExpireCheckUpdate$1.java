package com.tencent.biz.common.offline;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import nce;
import zab;

public class OfflineExpire$OfflineExpireCheckUpdate$1
  implements Runnable
{
  public OfflineExpire$OfflineExpireCheckUpdate$1(nce paramnce) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      new zab((AppInterface)localAppRuntime).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate.1
 * JD-Core Version:    0.7.0.1
 */