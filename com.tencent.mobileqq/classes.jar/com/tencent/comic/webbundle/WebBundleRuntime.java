package com.tencent.comic.webbundle;

import android.content.Context;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import org.jetbrains.annotations.NotNull;

public class WebBundleRuntime
  extends IWebBundleRuntime
{
  public WebBundleRuntime(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  @NotNull
  public IWebBundleWebView createWebView(@NotNull Context paramContext)
  {
    paramContext = new WebBundleWebView(paramContext);
    WebSettings localWebSettings = paramContext.getSettings();
    String str = localWebSettings.getUserAgentString();
    boolean bool;
    if (paramContext.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localWebSettings.setUserAgentString(SwiftWebViewUtils.a(str, "VipComic", bool));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleRuntime
 * JD-Core Version:    0.7.0.1
 */