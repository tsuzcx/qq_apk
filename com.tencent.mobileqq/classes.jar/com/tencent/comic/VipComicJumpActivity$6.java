package com.tencent.comic;

import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

final class VipComicJumpActivity$6
  extends VipComicJumpActivity.PluginCheckJob
{
  VipComicJumpActivity$6(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void run()
  {
    AppRuntime localAppRuntime = (AppRuntime)this.b.get();
    if (localAppRuntime == null) {
      return;
    }
    if (QQComicPluginBridge.a(localAppRuntime))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is installed.");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "wait for plugin installation...");
      }
      VipComicHelper.a(2, localAppRuntime);
      if (!QQComicPluginBridge.a(localAppRuntime, true, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "plugin install failed.");
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is installed now.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.6
 * JD-Core Version:    0.7.0.1
 */