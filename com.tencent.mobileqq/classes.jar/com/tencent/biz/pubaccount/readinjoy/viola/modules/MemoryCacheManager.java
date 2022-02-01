package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class MemoryCacheManager
{
  private static final Map<String, JSONObject> a = new ConcurrentHashMap();
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = new JSONObject();
    }
    JSONObject localJSONObject;
    do
    {
      return paramString;
      localJSONObject = (JSONObject)a.get(paramString);
      paramString = localJSONObject;
    } while (localJSONObject != null);
    return new JSONObject();
  }
  
  public static boolean a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    a.put(paramString, localJSONObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.MemoryCacheManager
 * JD-Core Version:    0.7.0.1
 */