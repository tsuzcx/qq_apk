import android.webkit.WebView;
import android.webkit.WebViewClient;

class bexq
  extends WebViewClient
{
  bexq(bexp parambexp) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    bexp.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexq
 * JD-Core Version:    0.7.0.1
 */