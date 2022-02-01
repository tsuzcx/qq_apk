package com.tencent.comic.ui;

import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQComicTabBarView$5
  implements Runnable
{
  QQComicTabBarView$5(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    this.this$0.h = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    QQComicTabBarView localQQComicTabBarView = this.this$0;
    localQQComicTabBarView.G = ((IQQComicRedTouchService)localQQComicTabBarView.h.getRuntimeService(IQQComicRedTouchService.class, "all"));
    if (this.this$0.G != null) {
      this.this$0.G.addObserver(this.this$0.H);
    }
    if (QQComicPluginBridge.c != null) {
      QQComicPluginBridge.c.a(this.this$0.I);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.5
 * JD-Core Version:    0.7.0.1
 */