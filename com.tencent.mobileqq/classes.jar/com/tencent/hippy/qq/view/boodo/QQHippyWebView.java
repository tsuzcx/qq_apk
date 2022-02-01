package com.tencent.hippy.qq.view.boodo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.WebSettings;

public class QQHippyWebView
  extends FrameLayout
  implements HippyViewBase
{
  private static final String TAG = "QQHippyWebView";
  private HippyViewEvent mEventOnMessage;
  private HippyMap mSourceMap;
  private HippyWebViewModule mWebViewModule;
  
  public QQHippyWebView(@NonNull Context paramContext)
  {
    super(paramContext);
    Intent localIntent = new Intent();
    localIntent.putExtra("web_view_module_from", 1);
    Context localContext = paramContext;
    if ((paramContext instanceof HippyInstanceContext)) {
      localContext = ((HippyInstanceContext)paramContext).getModuleParams().context;
    }
    TbsShareManager.isThirdPartyApp(localContext);
    initWebViewModuleSafety(localIntent, localContext);
  }
  
  private void checkInit(TouchWebView paramTouchWebView, HippyMap paramHippyMap)
  {
    String str1 = null;
    String str2;
    if ((paramTouchWebView != null) && (paramHippyMap != null))
    {
      str2 = paramHippyMap.getString("userAgent");
      if (!TextUtils.isEmpty(str2)) {
        paramTouchWebView.getSettings().setUserAgentString(str2);
      }
      str2 = paramHippyMap.getString("uri");
      if (TextUtils.isEmpty(str2)) {
        break label101;
      }
      if (!"POST".equalsIgnoreCase(paramHippyMap.getString("method"))) {
        break label94;
      }
      paramHippyMap = paramHippyMap.getString("body");
      if (paramHippyMap != null) {
        break label86;
      }
      paramHippyMap = str1;
      paramTouchWebView.postUrl(str2, paramHippyMap);
    }
    label86:
    label94:
    label101:
    do
    {
      return;
      paramHippyMap = paramHippyMap.getBytes();
      break;
      paramTouchWebView.loadUrl(str2);
      return;
      str1 = paramHippyMap.getString("html");
    } while (TextUtils.isEmpty(str1));
    paramHippyMap = paramHippyMap.getString("baseUrl");
    if (!TextUtils.isEmpty(paramHippyMap))
    {
      paramTouchWebView.loadDataWithBaseURL(paramHippyMap, str1, "text/html; charset=utf-8", "UTF-8", null);
      return;
    }
    paramTouchWebView.loadData(str1, "text/html; charset=utf-8", "UTF-8");
  }
  
  private void initWebViewModuleSafety(Intent paramIntent, Context paramContext)
  {
    try
    {
      this.mWebViewModule = new HippyWebViewModule(paramIntent, paramContext, this);
      this.mWebViewModule.onCreate();
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("QQHippyWebView", 1, paramIntent, new Object[0]);
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void initSource(HippyMap paramHippyMap)
  {
    this.mSourceMap = paramHippyMap;
    if (this.mWebViewModule != null) {
      checkInit(this.mWebViewModule.webView, this.mSourceMap);
    }
  }
  
  public void loadUrl(String paramString)
  {
    if ((this.mWebViewModule != null) && (this.mWebViewModule.webView != null))
    {
      this.mWebViewModule.webView.loadUrl(paramString);
      return;
    }
    QLog.e("QQHippyWebView", 1, "loadUrl webview is null");
  }
  
  public void onDestroy()
  {
    if (this.mWebViewModule != null)
    {
      this.mWebViewModule.onPause();
      this.mWebViewModule.onDestroy();
    }
  }
  
  public void onWebViewInited(TouchWebView paramTouchWebView)
  {
    new FrameLayout.LayoutParams(-1, -1);
    addView(paramTouchWebView);
    paramTouchWebView.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("QQHippyWebView", 2, "onWebViewInited webView");
    }
    checkInit(this.mWebViewModule.webView, this.mSourceMap);
  }
  
  public void postMessage(String paramString)
  {
    if (this.mEventOnMessage == null) {
      this.mEventOnMessage = new HippyViewEvent("onMessage");
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("data", paramString);
    this.mEventOnMessage.send(this, localHippyMap);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.boodo.QQHippyWebView
 * JD-Core Version:    0.7.0.1
 */