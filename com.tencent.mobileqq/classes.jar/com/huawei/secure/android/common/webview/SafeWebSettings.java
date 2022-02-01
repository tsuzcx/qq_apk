package com.huawei.secure.android.common.webview;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SafeWebSettings
{
  public static void disableContentAccess(WebSettings paramWebSettings)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebSettings.setAllowContentAccess(false);
    }
  }
  
  public static void disableFileCrossAccess(WebSettings paramWebSettings)
  {
    paramWebSettings.setAllowFileAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramWebSettings.setAllowFileAccessFromFileURLs(false);
      paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
    }
  }
  
  public static void disableGeolocation(WebSettings paramWebSettings)
  {
    paramWebSettings.setGeolocationEnabled(false);
  }
  
  public static void disableMixedContentMode(WebSettings paramWebSettings)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramWebSettings.setMixedContentMode(1);
    }
  }
  
  public static void disablePasswordStorage(WebSettings paramWebSettings)
  {
    if (Build.VERSION.SDK_INT <= 18) {
      paramWebSettings.setSavePassword(false);
    }
  }
  
  public static void initWebviewAndSettings(WebView paramWebView)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    disableFileCrossAccess(localWebSettings);
    removeUnSafeJavascriptImpl(paramWebView);
    disablePasswordStorage(localWebSettings);
    disableGeolocation(localWebSettings);
    disableMixedContentMode(localWebSettings);
    disableContentAccess(localWebSettings);
  }
  
  public static void removeUnSafeJavascriptImpl(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      paramWebView.removeJavascriptInterface("accessibility");
      paramWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeWebSettings
 * JD-Core Version:    0.7.0.1
 */