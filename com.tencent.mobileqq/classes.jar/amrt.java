import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.comic.utils.QQComicRedTouchManager;
import cooperation.comic.utils.SimpleBiMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class amrt
  implements Runnable
{
  public amrt(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start getRedAppInfo");
    }
    Object localObject = (QQComicRedTouchManager)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getManager(212);
    ArrayList localArrayList = new ArrayList();
    if (((QQComicRedTouchManager)localObject).a(1113)) {
      localArrayList.addAll(this.a.a.keySet());
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "isLebaItemOpen=" + bool + ", resId=" + 1113);
      }
      localObject = ((QQComicRedTouchManager)localObject).a(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "end getRedAppInfo map is " + localObject);
      }
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new amru(this, localArrayList, bool, (Map)localObject));
      }
      return;
      Iterator localIterator = this.a.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(this.a.b.get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrt
 * JD-Core Version:    0.7.0.1
 */