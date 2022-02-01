import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.comic.ui.QQComicFragment;
import java.util.Observable;
import java.util.Observer;

public class bmck
  implements Observer
{
  public bmck(QQComicFragment paramQQComicFragment, WebView paramWebView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (bmcx.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "RuntimeCreateObserver update ");
      bmcx.a.a(this.jdField_a_of_type_ComTencentSmttSdkWebView.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmck
 * JD-Core Version:    0.7.0.1
 */