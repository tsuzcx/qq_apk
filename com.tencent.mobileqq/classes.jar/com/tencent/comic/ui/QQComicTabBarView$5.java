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
    this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    QQComicTabBarView localQQComicTabBarView = this.this$0;
    localQQComicTabBarView.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService = ((IQQComicRedTouchService)localQQComicTabBarView.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQComicRedTouchService.class, "all"));
    if (this.this$0.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService != null) {
      this.this$0.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService.addObserver(this.this$0.jdField_a_of_type_ComTencentComicApiImplQQComicRedTouchServiceImpl$PluginRedTouchObserver);
    }
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.a(this.this$0.jdField_a_of_type_ComTencentComicJspQQComicDownloadCountObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.5
 * JD-Core Version:    0.7.0.1
 */