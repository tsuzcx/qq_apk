package com.tencent.comic.hippy.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.api.IQQComicHippyWebviewShareHelper;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.share.CommonShareHelper;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.WebSettings;

public class QQHippyWebView
  extends FrameLayout
  implements IQQComicHippyWebviewShareHelper, HippyViewBase
{
  private static final String TAG = "QQHippyWebView";
  private HippyViewEvent mEventOnMessage;
  private HippyMap mSourceMap;
  private HippyWebViewModule mWebViewModule;
  private CommonShareHelper shareHelper;
  
  public QQHippyWebView(@NonNull Context paramContext)
  {
    super(paramContext);
    Intent localIntent = new Intent();
    localIntent.putExtra("web_view_module_from", 2);
    Context localContext = paramContext;
    if ((paramContext instanceof HippyInstanceContext)) {
      localContext = ((HippyInstanceContext)paramContext).getModuleParams().context;
    }
    TbsShareManager.isThirdPartyApp(localContext);
    initWebViewModuleSafety(localIntent, localContext);
    this.shareHelper = new CommonShareHelper(localContext);
  }
  
  private void checkInit(TouchWebView paramTouchWebView, HippyMap paramHippyMap)
  {
    if ((paramTouchWebView != null) && (paramHippyMap != null))
    {
      String str = paramHippyMap.getString("userAgent");
      if (!TextUtils.isEmpty(str)) {
        paramTouchWebView.getSettings().setUserAgentString(str);
      }
      str = paramHippyMap.getString("uri");
      if (!TextUtils.isEmpty(str))
      {
        if ("POST".equalsIgnoreCase(paramHippyMap.getString("method")))
        {
          paramHippyMap = paramHippyMap.getString("body");
          if (paramHippyMap == null) {
            paramHippyMap = null;
          } else {
            paramHippyMap = paramHippyMap.getBytes();
          }
          paramTouchWebView.postUrl(str, paramHippyMap);
          return;
        }
        paramTouchWebView.loadUrl(str);
        return;
      }
      str = paramHippyMap.getString("html");
      if (!TextUtils.isEmpty(str))
      {
        paramHippyMap = paramHippyMap.getString("baseUrl");
        if (!TextUtils.isEmpty(paramHippyMap))
        {
          paramTouchWebView.loadDataWithBaseURL(paramHippyMap, str, "text/html; charset=utf-8", "UTF-8", null);
          return;
        }
        paramTouchWebView.loadData(str, "text/html; charset=utf-8", "UTF-8");
      }
    }
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
  
  private void reSizeWebView(TouchWebView paramTouchWebView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramTouchWebView.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    }
    else
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
    }
    paramTouchWebView.setLayoutParams(localLayoutParams);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public Object getShareHelper()
  {
    return this.shareHelper;
  }
  
  public void initSource(HippyMap paramHippyMap)
  {
    this.mSourceMap = paramHippyMap;
    paramHippyMap = this.mWebViewModule;
    if (paramHippyMap != null) {
      checkInit(paramHippyMap.webView, this.mSourceMap);
    }
  }
  
  public void loadUrl(String paramString)
  {
    HippyWebViewModule localHippyWebViewModule = this.mWebViewModule;
    if ((localHippyWebViewModule != null) && (localHippyWebViewModule.webView != null))
    {
      this.mWebViewModule.webView.loadUrl(paramString);
      return;
    }
    QLog.e("QQHippyWebView", 1, "loadUrl webview is null");
  }
  
  public void onDestroy()
  {
    HippyWebViewModule localHippyWebViewModule = this.mWebViewModule;
    if (localHippyWebViewModule != null)
    {
      localHippyWebViewModule.onPause();
      this.mWebViewModule.onDestroy();
    }
  }
  
  public void onWebViewInited(TouchWebView paramTouchWebView)
  {
    new FrameLayout.LayoutParams(-1, -1);
    addView(paramTouchWebView);
    reSizeWebView(paramTouchWebView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.view.QQHippyWebView
 * JD-Core Version:    0.7.0.1
 */