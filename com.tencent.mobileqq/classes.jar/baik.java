import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class baik
  extends WebChromeClient
{
  baik(baij parambaij) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    QLog.i("TenDocWebViewPool", 1, "tendocpreload onProgressChanged = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baik
 * JD-Core Version:    0.7.0.1
 */