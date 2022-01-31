import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class beci
  implements View.OnLongClickListener
{
  public beci(WebViewFragment paramWebViewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Beeh.a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!this.a.jdField_a_of_type_Beeh.a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    beds localbeds = (beds)this.a.jdField_a_of_type_Bedf.a(8);
    if ((localbeds != null) && (localbeds.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beci
 * JD-Core Version:    0.7.0.1
 */