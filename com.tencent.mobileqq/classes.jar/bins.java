import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.comic.ui.QQComicFragment;
import java.util.Observable;
import java.util.Observer;

public class bins
  implements Observer
{
  public bins(QQComicFragment paramQQComicFragment, WebView paramWebView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (biof.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "RuntimeCreateObserver update ");
      biof.a.a(this.jdField_a_of_type_ComTencentSmttSdkWebView.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bins
 * JD-Core Version:    0.7.0.1
 */