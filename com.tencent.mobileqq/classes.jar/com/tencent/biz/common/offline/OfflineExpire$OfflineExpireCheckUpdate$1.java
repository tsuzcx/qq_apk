package com.tencent.biz.common.offline;

import abfm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import nms;

public class OfflineExpire$OfflineExpireCheckUpdate$1
  implements Runnable
{
  public OfflineExpire$OfflineExpireCheckUpdate$1(nms paramnms) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      new abfm((AppInterface)localAppRuntime).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate.1
 * JD-Core Version:    0.7.0.1
 */