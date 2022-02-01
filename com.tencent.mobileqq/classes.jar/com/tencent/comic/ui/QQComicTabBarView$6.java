package com.tencent.comic.ui;

import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService != null) {
      this.this$0.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService.deleteObserver(this.this$0.jdField_a_of_type_ComTencentComicApiImplQQComicRedTouchServiceImpl$PluginRedTouchObserver);
    }
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.b(this.this$0.jdField_a_of_type_ComTencentComicJspQQComicDownloadCountObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */