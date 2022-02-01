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
  private static volatile BroadcastReceiver sDispatchEventReceiver = null;
  public static AtomicInteger sPageCount = new AtomicInteger(0);
  
  public QQEventModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    init();
  }
  
  private void broadcast2WebView(HippyMap paramHippyMap)
  {
    String str1;
    String str2;
    for (;;)
    {
      try
      {
        str1 = paramHippyMap.getString("event");
        if (TextUtils.isEmpty(str1))
        {
          QLog.w("QQEventModule", 2, "param event is requested");
          return;
        }
        str2 = paramHippyMap.getString("data");
        if (str2 != null)
        {
          localObject1 = str2.toString();
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).length() < 460800L)) {
            break;
          }
          QLog.e("QQEventModule", 1, "param data is over size! " + ((String)localObject1).length());
          return;
        }
      }
      catch (Exception paramHippyMap)
      {
        QLog.e("QQEventModule", 1, paramHippyMap, new Object[0]);
        return;
      }
      localObject1 = "";
    }
    Object localObject1 = paramHippyMap.getString("options");
    ArrayList localArrayList;
    boolean bool1;
    int i;
    label193:
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new JSONObject((String)localObject1);
      localArrayList = new ArrayList();
      if (localObject1 == null) {
        break label379;
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
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label372;
          }
          localArrayList.add(localObject2);
          break label372;
        }
      }
    }
    for (;;)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("url", "");
      localObject2 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      ((Intent)localObject2).putExtra("broadcast", bool1);
      ((Intent)localObject2).putExtra("event", str1);
      if (str2 != null) {
        ((Intent)localObject2).putExtra("data", str2);
      }
      ((Intent)localObject2).putStringArrayListExtra("domains", localArrayList);
      ((Intent)localObject2).putExtra("source", ((JSONObject)localObject1).toString());
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel())
      {
        QLog.d("QQEventModule", 2, "dispatchEvent:" + paramHippyMap.toJSONObject().toString());
        return;
        localObject1 = null;
        break;
      }
      return;
      label372:
      i += 1;
      break label193;
      label379:
      bool1 = true;
    }
  }
  
  private void checkDispatchEvent(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("broadcast", true)) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getStringExtra("event");
      } while (TextUtils.isEmpty(paramContext));
      paramIntent = paramIntent.getStringExtra("data");
      if (QLog.isColorLevel()) {
        QLog.d("QQEventModule", 2, "checkDispatchEvent event:" + paramContext + " dataStr:" + paramIntent);
      }
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramIntent);
      HippyQQEngine.dispatchEvent(paramContext, null, localHippyMap);
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("QQEventModule", 1, paramContext, new Object[0]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQEventModule
 * JD-Core Version:    0.7.0.1
 */