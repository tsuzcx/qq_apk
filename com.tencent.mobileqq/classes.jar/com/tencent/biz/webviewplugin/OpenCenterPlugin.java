package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.appcommon.now.download.js.DownloadWebInterface;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.open.appstore.js.YybTreasureCardJsPlugin;
import com.tencent.open.export.js.VipDownloadInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class OpenCenterPlugin
  extends JsWebViewPlugin
  implements MultiNameSpacePluginCompact
{
  private Map<String, BaseInterface> a = null;
  
  private void a()
  {
    this.a = new HashMap();
    Object localObject = this.mRuntime.d();
    BaseJsCallBack localBaseJsCallBack = new BaseJsCallBack((Activity)localObject);
    VipDownloadInterface localVipDownloadInterface = new VipDownloadInterface((Activity)localObject, this.mRuntime.a());
    HttpInterface localHttpInterface = new HttpInterface((Activity)localObject, this.mRuntime.a());
    AppInterface localAppInterface = new AppInterface((Activity)localObject, this.mRuntime.a());
    DownloadInterface localDownloadInterface = new DownloadInterface((Activity)localObject, this.mRuntime.a());
    DINewForCommonWebView localDINewForCommonWebView = new DINewForCommonWebView((Activity)localObject, this.mRuntime.a());
    YybTreasureCardJsPlugin localYybTreasureCardJsPlugin = new YybTreasureCardJsPlugin((Activity)localObject, this.mRuntime.a());
    localObject = new DownloadWebInterface((Activity)localObject, this.mRuntime.a());
    this.a.put(localBaseJsCallBack.getInterfaceName(), localBaseJsCallBack);
    this.a.put(localVipDownloadInterface.getInterfaceName(), localVipDownloadInterface);
    this.a.put(localHttpInterface.getInterfaceName(), localHttpInterface);
    this.a.put(localAppInterface.getInterfaceName(), localAppInterface);
    this.a.put(localDownloadInterface.getInterfaceName(), localDownloadInterface);
    this.a.put(localDINewForCommonWebView.getInterfaceName(), localDINewForCommonWebView);
    this.a.put(localYybTreasureCardJsPlugin.getInterfaceName(), localYybTreasureCardJsPlugin);
    this.a.put(((BaseInterface)localObject).getInterfaceName(), localObject);
  }
  
  protected Method getJsMethod(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (BaseInterface)this.a.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getClass().getDeclaredMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramString1[i];
        if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
          return localMethod;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "opencenter", "qqZoneAppList", "q_download_vip", "qzone_http", "qzone_app", "q_download", "q_download_now", "q_download_v2", "yyb_treasureCard" };
  }
  
  protected String getNameSpace()
  {
    return "opencenter";
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {
      OpenAppClient.a(this.mRuntime.b());
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (this.a == null) {
      a();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.a.get(paramString2);
    if (localBaseInterface != null)
    {
      Method[] arrayOfMethod = localBaseInterface.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      paramString1 = null;
      int i = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (i >= j) {
          break;
        }
        Method localMethod = arrayOfMethod[i];
        paramString2 = paramString1;
        if (localMethod.getName().equals(paramString3))
        {
          paramString2 = paramString1;
          if (localMethod.getParameterTypes().length == paramVarArgs.length) {
            paramString2 = localMethod;
          }
        }
        i += 1;
        paramString1 = paramString2;
      }
    }
    paramString2 = null;
    if (paramString2 != null) {}
    try
    {
      if (paramVarArgs.length == 0) {
        paramString1 = paramString2.invoke(localBaseInterface, new Object[0]);
      } else {
        paramString1 = paramString2.invoke(localBaseInterface, paramVarArgs);
      }
      paramString2 = paramString2.getReturnType();
      if ((paramString2 != Void.TYPE) && (paramString2 != Void.class))
      {
        if (paramJsBridgeListener != null) {
          paramJsBridgeListener.a(paramString1);
        }
      }
      else if (paramJsBridgeListener != null) {
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    catch (Exception paramJsBridgeListener) {}
    return false;
    return false;
  }
  
  public void onAppRuntimeReady(AppRuntime paramAppRuntime) {}
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      try
      {
        ((BaseInterface)((Map.Entry)((Iterator)localObject).next()).getValue()).destroy();
      }
      catch (Exception localException)
      {
        label54:
        break label54;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OpenCenterPlugin
 * JD-Core Version:    0.7.0.1
 */