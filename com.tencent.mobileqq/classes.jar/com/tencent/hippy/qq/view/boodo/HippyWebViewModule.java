package com.tencent.hippy.qq.view.boodo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import org.jetbrains.annotations.NotNull;

public class HippyWebViewModule
  extends WebViewModule
{
  private static final String TAG = "HippyWebViewModule";
  private Context mContext;
  private HippyViewEvent mEventOnError = new HippyViewEvent("onError");
  private HippyViewEvent mEventonLoad = new HippyViewEvent("onLoad");
  private HippyViewEvent mEventonLoadEnd = new HippyViewEvent("onLoadEnd");
  private HippyViewEvent mEventonLoadStart = new HippyViewEvent("onLoadStart");
  private String mMessageUrlPre = "hippy://postMessage?data=";
  private QQHippyWebView mQQHippyWebView;
  
  public HippyWebViewModule(@NotNull Intent paramIntent, Context paramContext, QQHippyWebView paramQQHippyWebView)
  {
    super(paramIntent, paramContext);
    this.mContext = paramContext;
    this.mQQHippyWebView = paramQQHippyWebView;
  }
  
  public Activity getActivity()
  {
    if ((this.mContext instanceof Activity)) {
      return (Activity)this.mContext;
    }
    return super.getActivity();
  }
  
  public void initWebView()
  {
    super.initWebView();
    if (this.webView != null)
    {
      if (Build.VERSION.SDK_INT >= 17) {
        this.webView.addJavascriptInterface(new HippyWebViewModule.QQHippyWebViewBridge(this.mQQHippyWebView), "hippy");
      }
      if (Build.VERSION.SDK_INT < 19)
      {
        this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.webView.removeJavascriptInterface("accessibility");
        this.webView.removeJavascriptInterface("accessibilityTraversal");
      }
      this.mQQHippyWebView.onWebViewInited(this.webView);
      return;
    }
    QLog.e("HippyWebViewModule", 1, "initWebView webview is null");
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 17) {
      paramWebView.loadUrl("javascript:hippy={};hippy.onMessage=function(data){location.href='hippy://postMessage?data='+encodeURIComponent(data)}");
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    this.mEventonLoad.send(this.mQQHippyWebView, localHippyMap);
    this.mEventonLoadEnd.send(this.mQQHippyWebView, localHippyMap);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    this.mEventonLoadStart.send(this.mQQHippyWebView, localHippyMap);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    HippyMap localHippyMap;
    if (this.mQQHippyWebView != null)
    {
      localHippyMap = new HippyMap();
      if (Build.VERSION.SDK_INT < 23) {
        break label63;
      }
      localHippyMap.pushString("error", paramString1);
      localHippyMap.pushInt("errorCode", paramInt);
    }
    for (;;)
    {
      this.mEventOnError.send(this.mQQHippyWebView, localHippyMap);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
      label63:
      localHippyMap.pushString("error", "unknown error");
      localHippyMap.pushInt("errorCode", 2147483647);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.mQQHippyWebView != null) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith(this.mMessageUrlPre)))
    {
      this.mQQHippyWebView.postMessage(URLDecoder.decode(paramString.substring(this.mMessageUrlPre.length())));
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.boodo.HippyWebViewModule
 * JD-Core Version:    0.7.0.1
 */