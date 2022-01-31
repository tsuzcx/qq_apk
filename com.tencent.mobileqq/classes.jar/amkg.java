import com.tencent.qphone.base.util.QLog;
import cooperation.comic.jsp.QQComicDownloadObserverProxy;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;

public class amkg
  implements Runnable
{
  public amkg(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager != null) {
      this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager.deleteObserver(this.a.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager$PluginRedTouchObserver);
    }
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.b(this.a.jdField_a_of_type_CooperationComicJspQQComicDownloadCountObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */