import android.view.View;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.comic.ui.QQComicTabBarView.ViewHolder;
import cooperation.comic.utils.SimpleBiMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class amki
  implements Runnable
{
  amki(amkh paramamkh, ArrayList paramArrayList, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start show red touch");
    }
    int i = this.jdField_a_of_type_Amkh.a.a();
    if ((i >= 0) && (i < QQComicTabBarView.a(this.jdField_a_of_type_Amkh.a)))
    {
      localObject = QQComicTabBarView.a(this.jdField_a_of_type_Amkh.a, i).getTag(-3);
      if (!(localObject instanceof QQComicTabBarView.ViewHolder)) {}
    }
    for (Object localObject = ((QQComicTabBarView.ViewHolder)localObject).a;; localObject = null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.jdField_a_of_type_Boolean) {}
        for (RedTouchUI localRedTouchUI = (RedTouchUI)this.jdField_a_of_type_Amkh.a.a.get(str);; localRedTouchUI = (RedTouchUI)this.jdField_a_of_type_Amkh.a.a.get(this.jdField_a_of_type_Amkh.a.b.a(str)))
        {
          if ((localRedTouchUI == null) || (localRedTouchUI.equals(localObject))) {
            break label208;
          }
          this.jdField_a_of_type_Amkh.a.a(localRedTouchUI, (RedAppInfo)this.jdField_a_of_type_JavaUtilMap.get(str), false);
          break;
        }
        label208:
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "cannot find red touch on path: " + str);
        }
      }
      this.jdField_a_of_type_Amkh.a.b();
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "end show red touch");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amki
 * JD-Core Version:    0.7.0.1
 */