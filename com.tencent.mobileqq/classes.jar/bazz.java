import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class bazz
  implements View.OnLongClickListener
{
  public bazz(WebViewFragment paramWebViewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Bbbs.a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!this.a.jdField_a_of_type_Bbbs.a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    bbbd localbbbd = (bbbd)this.a.jdField_a_of_type_Bbaq.a(8);
    if ((localbbbd != null) && (localbbbd.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bazz
 * JD-Core Version:    0.7.0.1
 */