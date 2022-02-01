package com.tencent.hippy.qq.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.viola.module.CacheModule;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viola_cache_file_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(((AppRuntime)localObject).getAccount());
    localObject = FileUtils.readObject(localStringBuilder.toString());
    paramString = null;
    if ((localObject instanceof String)) {
      paramString = (String)localObject;
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = new JSONObject().toString();
    }
    if ((paramPromise != null) && (paramPromise.isCallback())) {
      paramPromise.resolve(localObject);
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
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("keys");
      int i = 0;
      while (i < localJSONArray.length())
      {
        String str = localJSONArray.getString(i);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("viola_cache_file_");
        paramJSONObject.append(str);
        paramJSONObject.append("_");
        paramJSONObject.append(localAppRuntime.getAccount());
        Object localObject = FileUtils.readObject(paramJSONObject.toString());
        paramJSONObject = null;
        if ((localObject instanceof String)) {
          paramJSONObject = (String)localObject;
        }
        localObject = paramJSONObject;
        if (TextUtils.isEmpty(paramJSONObject)) {
          localObject = "";
        }
        localJSONObject2.put(str, localObject);
        i += 1;
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CacheModule", 1, "CacheModule multiGet:", paramJSONObject);
    }
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      localHippyMap.pushJSONObject(localJSONObject1);
      paramPromise.resolve(localHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQCacheModule
 * JD-Core Version:    0.7.0.1
 */