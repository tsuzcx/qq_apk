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

public abstract interface bazp
{
  public abstract Object a(String paramString, Bundle paramBundle);
  
  public abstract String a();
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2);
  
  public abstract void a(WebView paramWebView, int paramInt);
  
  public abstract void a(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(WebView paramWebView, SslError paramSslError);
  
  public abstract void a(WebView paramWebView, String paramString);
  
  public abstract void a(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback);
  
  public abstract boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams);
  
  public abstract boolean a(WebView paramWebView, String paramString);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract View b();
  
  public abstract void b(WebView paramWebView, String paramString);
  
  public abstract void b(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract boolean b(WebView paramWebView, String paramString);
  
  public abstract boolean c(WebView paramWebView, String paramString);
  
  public abstract void v();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bazp
 * JD-Core Version:    0.7.0.1
 */