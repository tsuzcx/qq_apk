import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebView;

public abstract interface bigq
{
  public abstract Activity getHostActivity();
  
  public abstract WebViewFragment getHostFragment();
  
  public abstract WebView getHostWebView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigq
 * JD-Core Version:    0.7.0.1
 */