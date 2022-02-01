package com.tencent.hippy.qq.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.CacheModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQCacheModule
  extends CacheModule
{
  public void cacheBody(@NonNull String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("module", "dom");
      localJSONObject.put("method", "createBody");
      paramString = new JSONObject(paramString);
      handleBody(paramString);
      localJSONObject.put("args", paramString);
      localJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void destroy() {}
  
  public void getItem(@NonNull String paramString, Promise paramPromise)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      QLog.e("CacheModule", 1, "failed to getItem");
      if ((paramPromise != null) && (paramPromise.isCallback()))
      {
        paramString = new HippyMap();
        paramString.pushString("retmsg", "failed to getItem");
        paramPromise.resolve(paramString);
      }
      return;
    }
    paramString = FileUtils.a("viola_cache_file_" + paramString + "_" + ((AppRuntime)localObject).getAccount());
    if ((paramString instanceof String)) {}
    for (paramString = (String)paramString;; paramString = null)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = new JSONObject().toString();
      }
      if ((paramPromise == null) || (!paramPromise.isCallback())) {
        break;
      }
      paramPromise.resolve(localObject);
      return;
    }
  }
  
  public void multiGet(@NonNull JSONObject paramJSONObject, Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to getItem");
      if ((paramPromise != null) && (paramPromise.isCallback()))
      {
        localHippyMap.pushString("retmsg", "failed to getItem");
        paramPromise.resolve(localHippyMap);
      }
    }
    JSONObject localJSONObject1;
    do
    {
      return;
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      for (;;)
      {
        try
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("keys");
          i = 0;
          if (i >= localJSONArray.length()) {
            continue;
          }
          str = localJSONArray.getString(i);
          paramJSONObject = FileUtils.a("viola_cache_file_" + str + "_" + localAppRuntime.getAccount());
          if (!(paramJSONObject instanceof String)) {
            continue;
          }
          paramJSONObject = (String)paramJSONObject;
        }
        catch (JSONException paramJSONObject)
        {
          int i;
          String str;
          Object localObject;
          QLog.e("CacheModule", 1, "CacheModule multiGet:", paramJSONObject);
          continue;
          paramJSONObject = null;
          continue;
        }
        localObject = paramJSONObject;
        if (TextUtils.isEmpty(paramJSONObject)) {
          localObject = "";
        }
        localJSONObject2.put(str, localObject);
        i += 1;
      }
      localJSONObject1.put("data", localJSONObject2);
    } while ((paramPromise == null) || (!paramPromise.isCallback()));
    localHippyMap.pushJSONObject(localJSONObject1);
    paramPromise.resolve(localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQCacheModule
 * JD-Core Version:    0.7.0.1
 */