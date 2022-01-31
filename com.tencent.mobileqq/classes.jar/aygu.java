import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

class aygu
  extends nnn
{
  aygu(aygt paramaygt, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.onPageFinished(paramWebView, paramString);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.onPageStarted(paramWebView, paramString, paramBitmap);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Log.d("KDSearchResultBuilder", "shouldOverrideUrlLoading: setWebViewClient");
    if (this.a.shouldOverrideUrlLoading(paramWebView, paramString)) {
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygu
 * JD-Core Version:    0.7.0.1
 */