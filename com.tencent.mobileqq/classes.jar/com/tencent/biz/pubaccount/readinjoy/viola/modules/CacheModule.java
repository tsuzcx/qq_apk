package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import bace;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CacheModule
  extends BaseModule
  implements Destroyable
{
  public static final String MODULE_NAME = "cache";
  public static final String TAG = "CacheModule";
  public static final String VIOLA_CACHE_FILE_NAME = "viola_cache_file_";
  
  private static void handleBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.get("children") != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("children");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if ("image".equals(localJSONObject.optString("type"))) {
            localJSONObject.optJSONObject("attr").put("src", "");
          }
          handleBody(localJSONObject);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  @JSMethod(uiThread=false)
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
      setItem(getViolaInstance().getUrl(), localJSONArray.toString());
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void getItem(@NonNull String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to getItem");
      if (!TextUtils.isEmpty(paramString2)) {
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString2, new JSONObject().toString(), true);
      }
      return;
    }
    paramString1 = bace.a("viola_cache_file_" + paramString1 + "_" + localAppRuntime.getAccount());
    if ((paramString1 instanceof String)) {}
    for (paramString1 = (String)paramString1;; paramString1 = null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = new JSONObject().toString();
      }
      while (!TextUtils.isEmpty(paramString2))
      {
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString2, paramString1, true);
        return;
      }
      break;
    }
  }
  
  @JSMethod(uiThread=false)
  public void remove(@NonNull String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to remove");
      return;
    }
    bace.d(BaseApplicationImpl.getContext().getFilesDir() + "/" + "viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
  }
  
  @JSMethod(uiThread=false)
  public void setItem(@NonNull String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to setItem");
      return;
    }
    bace.a("viola_cache_file_" + paramString1 + "_" + localAppRuntime.getAccount(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.CacheModule
 * JD-Core Version:    0.7.0.1
 */