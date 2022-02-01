package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQEventModule")
public class QQEventModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQEventModule";
  private static final String TAG = "QQEventModule";
  private static volatile BroadcastReceiver sDispatchEventReceiver;
  public static AtomicInteger sPageCount = new AtomicInteger(0);
  
  public QQEventModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    init();
  }
  
  private void broadcast2WebView(HippyMap paramHippyMap)
  {
    for (;;)
    {
      int i;
      try
      {
        String str1 = paramHippyMap.getString("event");
        if (TextUtils.isEmpty(str1))
        {
          QLog.w("QQEventModule", 2, "param event is requested");
          return;
        }
        String str2 = paramHippyMap.getString("data");
        if (str2 == null) {
          break label380;
        }
        localObject1 = str2.toString();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() >= 460800L))
        {
          paramHippyMap = new StringBuilder();
          paramHippyMap.append("param data is over size! ");
          paramHippyMap.append(((String)localObject1).length());
          QLog.e("QQEventModule", 1, paramHippyMap.toString());
          return;
        }
        Object localObject2 = paramHippyMap.getString("options");
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = new JSONObject((String)localObject2);
        }
        localObject2 = new ArrayList();
        if (localObject1 == null) {
          break label394;
        }
        boolean bool2 = ((JSONObject)localObject1).optBoolean("broadcast", true);
        localObject1 = ((JSONObject)localObject1).optJSONArray("domains");
        bool1 = bool2;
        if (localObject1 != null)
        {
          int j = ((JSONArray)localObject1).length();
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label387;
            }
            ((ArrayList)localObject2).add(localObject3);
            break label387;
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("url", "");
        Object localObject3 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject3).putExtra("broadcast", bool1);
        ((Intent)localObject3).putExtra("event", str1);
        if (str2 != null) {
          ((Intent)localObject3).putExtra("data", str2);
        }
        ((Intent)localObject3).putStringArrayListExtra("domains", (ArrayList)localObject2);
        ((Intent)localObject3).putExtra("source", ((JSONObject)localObject1).toString());
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject3, "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("dispatchEvent:");
          ((StringBuilder)localObject1).append(paramHippyMap.toJSONObject().toString());
          QLog.d("QQEventModule", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception paramHippyMap)
      {
        QLog.e("QQEventModule", 1, paramHippyMap, new Object[0]);
      }
      return;
      label380:
      Object localObject1 = "";
      continue;
      label387:
      i += 1;
      continue;
      label394:
      boolean bool1 = true;
    }
  }
  
  private void checkDispatchEvent(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("broadcast", true)) {
      return;
    }
    paramContext = paramIntent.getStringExtra("event");
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("data");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkDispatchEvent event:");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(" dataStr:");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("QQEventModule", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent != null) {
      try
      {
        paramIntent = new JSONObject(paramIntent);
        localObject = new HippyMap();
        ((HippyMap)localObject).pushJSONObject(paramIntent);
        HippyQQEngine.dispatchEvent(paramContext, null, (HippyMap)localObject);
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QQEventModule", 1, paramContext, new Object[0]);
      }
    }
  }
  
  private void init()
  {
    if ((sPageCount.getAndIncrement() == 0) && (sDispatchEventReceiver == null))
    {
      sDispatchEventReceiver = new QQEventModule.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      BaseApplicationImpl.getApplication().registerReceiver(sDispatchEventReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      QLog.i("QQEventModule", 1, "init registerReceiver sDispatchEventReceiver");
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if ((sPageCount.decrementAndGet() == 0) && (sDispatchEventReceiver != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(sDispatchEventReceiver);
      sDispatchEventReceiver = null;
      QLog.i("QQEventModule", 1, "destroy unregisterReceiver sDispatchEventReceiver");
    }
  }
  
  @HippyMethod(name="dispatchEvent")
  public void dispatchEvent(String paramString1, String paramString2, HippyMap paramHippyMap)
  {
    HippyQQEngine.dispatchEvent(paramString1, paramString2, paramHippyMap);
    if ((paramHippyMap != null) && (paramHippyMap.getBoolean("toWebView"))) {
      broadcast2WebView(paramHippyMap);
    }
  }
  
  @HippyMethod(name="dispatchEventToHippy")
  public void dispatchEventToHippy(String paramString1, String paramString2, HippyMap paramHippyMap)
  {
    HippyQQEngine.dispatchEvent(paramString1, paramString2, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQEventModule
 * JD-Core Version:    0.7.0.1
 */