package com.tencent.hippy.qq.module;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

@HippyNativeModule(name="QQOfflineModule")
public class QQOfflineModule
  extends QQBaseModule
{
  public static final String TAG = "QQOfflineModule";
  
  public QQOfflineModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  @HippyMethod(name="batchCheckUpdate")
  public void batchCheckUpdate(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQOfflineModule", 2, "batchCheckUpdate:" + paramHippyMap + ",promise:" + paramPromise);
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramHippyMap != null) {}
    try
    {
      ArrayList localArrayList;
      for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
      {
        paramHippyMap = paramHippyMap.optJSONArray("bids");
        int j = paramHippyMap.length();
        localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(paramHippyMap.optString(i));
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramHippyMap)
    {
      QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramHippyMap);
      try
      {
        localJSONObject.put("retcode", -1);
        localJSONObject.put("msg", "error");
        doPromiseCallback(paramPromise, localJSONObject);
        return;
      }
      catch (Throwable paramHippyMap)
      {
        QLog.d("QQOfflineModule", 1, paramHippyMap, new Object[0]);
      }
      HtmlOffline.a(localArrayList, MobileQQ.sMobileQQ.waitAppRuntime(null), new QQOfflineModule.1(this, localJSONObject, paramPromise), true, true);
      return;
    }
  }
  
  @HippyMethod(name="clearCache")
  public void clearCache(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQOfflineModule", 2, "clearCache:" + paramHippyMap + ",promise:" + paramPromise);
    }
    localJSONObject = new JSONObject();
    if (paramHippyMap != null) {}
    for (;;)
    {
      try
      {
        paramHippyMap = paramHippyMap.toJSONObject();
        paramHippyMap = paramHippyMap.optString("bid");
        HtmlOffline.a(MobileQQ.sMobileQQ, paramHippyMap, 1);
        localJSONObject.put("retcode", 0);
        localJSONObject.put("msg", "ok");
        return;
      }
      catch (Throwable paramHippyMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQOfflineModule", 2, "OfflinePlugin, clearCache, JSONException :" + paramHippyMap);
        try
        {
          localJSONObject.put("retcode", -1);
          localJSONObject.put("msg", "error");
          return;
        }
        catch (Throwable paramHippyMap)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQOfflineModule", 2, "OfflinePlugin, clearCache, JSONException :" + paramHippyMap);
          continue;
        }
      }
      finally
      {
        doPromiseCallback(paramPromise, localJSONObject);
      }
      paramHippyMap = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQOfflineModule
 * JD-Core Version:    0.7.0.1
 */