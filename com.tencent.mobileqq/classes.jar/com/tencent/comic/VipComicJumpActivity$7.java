package com.tencent.comic;

import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.QQComicPluginBridge.PluginInstallObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class VipComicJumpActivity$7
  extends VipComicJumpActivity.PluginCheckJob
{
  VipComicJumpActivity$7(VipComicJumpActivity paramVipComicJumpActivity, AppRuntime paramAppRuntime, VipComicJumpActivity.ComicParam paramComicParam)
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
      this.this$0.openComicPlugin(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "wait for plugin installation...");
    }
    QQComicPluginBridge.PluginInstallObserver localPluginInstallObserver = new QQComicPluginBridge.PluginInstallObserver();
    localPluginInstallObserver.d = new VipComicJumpActivity.ComicPluginInstallCallback(this.this$0.mHandler);
    VipComicHelper.a(2, localAppRuntime);
    boolean bool = QQComicPluginBridge.a(localAppRuntime, true, localPluginInstallObserver);
    this.this$0.downloadTime = localPluginInstallObserver.a;
    this.this$0.installTime = localPluginInstallObserver.b;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin install failed.");
      }
      this.this$0.enterComicReport644(this.a, localPluginInstallObserver.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "plugin is installed now.");
    }
    this.this$0.openComicPlugin(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.7
 * JD-Core Version:    0.7.0.1
 */