import android.webkit.WebView;
import android.webkit.WebViewClient;

class bhap
  extends WebViewClient
{
  bhap(bhao parambhao) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    bhao.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhap
 * JD-Core Version:    0.7.0.1
 */