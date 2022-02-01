import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

public abstract interface bioe
{
  public abstract boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString);
  
  public abstract boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString);
  
  public abstract String getUAMark();
  
  public abstract View getVideoLoadingProgressView();
  
  public abstract void handlePreloadCallback(int paramInt, String paramString);
  
  public abstract Object handlerMiscCallback(String paramString, Bundle paramBundle);
  
  public abstract void onDetectedBlankScreen(String paramString, int paramInt);
  
  public abstract void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback);
  
  public abstract void onHideCustomView();
  
  public abstract boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract void onPageFinished(WebView paramWebView, String paramString);
  
  public abstract void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void onProgressChanged(WebView paramWebView, int paramInt);
  
  public abstract void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void onReceivedSslError(WebView paramWebView, SslError paramSslError);
  
  public abstract void onReceivedTitle(WebView paramWebView, String paramString);
  
  public abstract boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams);
  
  public abstract void onUrlChange(String paramString1, String paramString2);
  
  public abstract void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2);
  
  public abstract boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
  
  public abstract void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bioe
 * JD-Core Version:    0.7.0.1
 */