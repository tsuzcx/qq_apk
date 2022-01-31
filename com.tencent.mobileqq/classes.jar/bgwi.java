import android.webkit.WebView;
import android.webkit.WebViewClient;

class bgwi
  extends WebViewClient
{
  bgwi(bgwh parambgwh) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    bgwh.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwi
 * JD-Core Version:    0.7.0.1
 */