import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class baxu
  extends baxx
{
  baxu(baxr parambaxr)
  {
    super(parambaxr, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "old shouldInterceptRequest");
    }
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     baxu
 * JD-Core Version:    0.7.0.1
 */