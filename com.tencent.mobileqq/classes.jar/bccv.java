import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class bccv
  implements View.OnLongClickListener
{
  public bccv(UnVisibleWebViewFragment paramUnVisibleWebViewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Bcfg.a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!this.a.jdField_a_of_type_Bcfg.a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    bcer localbcer = (bcer)this.a.jdField_a_of_type_Bcee.a(8);
    if ((localbcer != null) && (localbcer.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bccv
 * JD-Core Version:    0.7.0.1
 */