package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.hippy.HippyCallBackListenerWebViewPlugin;
import com.tencent.mobileqq.vas.hippy.HippyCallBackWebView;
import com.tencent.mobileqq.vas.hippy.HippyJsBridgeListener;
import com.tencent.mobileqq.vas.hippyhelper.IHippyJsbInvokeAdapter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

class QQJsbModule$QQJsbModuleAdapter
  implements IHippyJsbInvokeAdapter
{
  private final Activity activity;
  private final AppInterface appInterface;
  private final HippyEngineContext context;
  private final HippyMap params;
  private final Promise promise;
  
  public QQJsbModule$QQJsbModuleAdapter(Promise paramPromise, Activity paramActivity, AppInterface paramAppInterface, HippyMap paramHippyMap, HippyEngineContext paramHippyEngineContext)
  {
    this.promise = paramPromise;
    this.activity = paramActivity;
    this.appInterface = paramAppInterface;
    this.params = paramHippyMap;
    this.context = paramHippyEngineContext;
  }
  
  @Nullable
  private Object handleListenerArg(Class<?> paramClass, @NotNull Object paramObject)
  {
    if ((JsBridgeListener.class.isAssignableFrom(paramClass)) && ((paramObject instanceof WebViewPlugin)))
    {
      paramClass = (WebViewPlugin)paramObject;
      if ((paramClass.mRuntime != null) && ((paramClass.mRuntime.a() instanceof HippyCallBackWebView))) {
        return new HippyJsBridgeListener((HippyCallBackWebView)paramClass.mRuntime.a(), -1L, true);
      }
      QLog.e("QQJsbModule", 1, new Object[] { "handleListenerArg error", paramClass.mRuntime });
      onCallError("handleListenerArg error");
    }
    else if (WebViewPlugin.class.isAssignableFrom(paramClass))
    {
      return new HippyCallBackListenerWebViewPlugin();
    }
    return null;
  }
  
  public Object createFakeWebView(Object paramObject)
  {
    return new HippyCallBackWebView(ContextHolder.getAppContext());
  }
  
  public Object createWebViewPlugin(String paramString)
  {
    paramString = WebViewPluginFactory.a(paramString);
    if (paramString == null)
    {
      onCallError("createWebViewPlugin failed");
      QLog.e("QQJsbModule", 1, "createWebViewPlugin error, webViewPluginOrigin is null");
      return null;
    }
    paramString.mRuntime = new WebViewPlugin.PluginRuntime(this.activity, this.appInterface);
    return paramString;
  }
  
  public String[] getDispatchArgsNameList(String paramString)
  {
    return new String[] { "listener", "url", "pkgName", "method", "args" };
  }
  
  public String getDispatchMethodName(String paramString)
  {
    return "handleJsRequest";
  }
  
  public Object getInvokeArgs(int paramInt, Class<?> paramClass, @NotNull Object paramObject, String paramString)
  {
    if (paramInt == 0)
    {
      paramClass = handleListenerArg(paramClass, paramObject);
      if (paramClass != null) {
        return paramClass;
      }
    }
    if ("args".equals(getDispatchArgsNameList(paramString)[paramInt]))
    {
      paramClass = this.params.getMap("args");
      if (paramClass != null) {
        try
        {
          paramClass = paramClass.toJSONObject().toString();
          return new String[] { paramClass };
        }
        catch (Exception paramClass)
        {
          QLog.e("QQJsbModule", 1, "getInvokeArgs error", paramClass);
        }
      }
    }
    return null;
  }
  
  public String getJsbMethod(HippyMap paramHippyMap)
  {
    return paramHippyMap.getString("method");
  }
  
  public String getJsbNameSpace(HippyMap paramHippyMap)
  {
    return paramHippyMap.getString("pkgName");
  }
  
  public boolean isNeedIntercept(HippyMap paramHippyMap)
  {
    String str = paramHippyMap.getString("pkgName");
    paramHippyMap = paramHippyMap.getString("method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(".");
    localStringBuilder.append(paramHippyMap);
    paramHippyMap = localStringBuilder.toString();
    return QQJsbModule.access$000(this.context, paramHippyMap) ^ true;
  }
  
  public void onCallError(String paramString)
  {
    this.promise.reject(paramString);
  }
  
  public void onCallJs(Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      HippyArray localHippyArray = new HippyArray();
      paramObject = (Object[])paramObject;
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        localHippyArray.pushObject(paramObject[i]);
        i += 1;
      }
      this.promise.resolve(localHippyArray);
      return;
    }
    this.promise.resolve(paramObject);
  }
  
  public void onUpdateActivity(Object paramObject)
  {
    if (!(paramObject instanceof WebViewPlugin)) {
      return;
    }
    Object localObject = (WebViewPlugin)paramObject;
    if (((WebViewPlugin)localObject).mRuntime == null)
    {
      ((WebViewPlugin)localObject).mRuntime = new WebViewPlugin.PluginRuntime(this.activity, this.appInterface);
      return;
    }
    try
    {
      localObject = WebViewPlugin.PluginRuntime.class.getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(((WebViewPlugin)paramObject).mRuntime, new WeakReference(this.activity));
      return;
    }
    catch (IllegalAccessException paramObject) {}catch (NoSuchFieldException paramObject) {}
    QLog.e("QQJsbModule", 1, "onUpdateActivity error", paramObject);
  }
  
  public void setWebViewInternal(Object paramObject1, Object paramObject2)
  {
    try
    {
      Field localField = WebViewPlugin.PluginRuntime.class.getDeclaredField("a");
      localField.setAccessible(true);
      localField.set(((WebViewPlugin)paramObject1).mRuntime, new WeakReference(paramObject2));
      return;
    }
    catch (IllegalAccessException paramObject1) {}catch (NoSuchFieldException paramObject1) {}
    QLog.e("QQJsbModule", 1, "setWebViewInternal error", paramObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQJsbModule.QQJsbModuleAdapter
 * JD-Core Version:    0.7.0.1
 */