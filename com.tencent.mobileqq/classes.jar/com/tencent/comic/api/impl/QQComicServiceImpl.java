package com.tencent.comic.api.impl;

import android.app.Application;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.VipComicRemoteCommand;
import com.tencent.comic.api.IQQComicService;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQComicServiceImpl
  implements IQQComicService
{
  public static final String TAG = "QQComicServiceImpl";
  private AppRuntime appRuntime;
  
  public void beforeLaunchPlugin()
  {
    VipComicRemoteCommand.a(null);
  }
  
  public AppRuntime createComicRuntime(Application paramApplication, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createComicRuntime: processName=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQComicServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if ((paramApplication instanceof MobileQQ)) {
      localObject = (MobileQQ)paramApplication;
    }
    return VipComicHelper.a((MobileQQ)localObject, paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void startUp()
  {
    AppRuntime localAppRuntime = this.appRuntime;
    if (localAppRuntime == null)
    {
      QLog.i("QQComicServiceImpl", 1, "app runtime is null");
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new QQComicServiceImpl.1(this, localAppRuntime), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicServiceImpl
 * JD-Core Version:    0.7.0.1
 */