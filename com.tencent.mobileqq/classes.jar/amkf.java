import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.jsp.QQComicDownloadObserverProxy;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class amkf
  implements Runnable
{
  public amkf(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager = ((QQComicRedTouchManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(212));
    if (this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager != null) {
      this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager.addObserver(this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager$PluginRedTouchObserver);
    }
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.a(this.a.jdField_a_of_type_CooperationComicJspQQComicDownloadCountObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkf
 * JD-Core Version:    0.7.0.1
 */