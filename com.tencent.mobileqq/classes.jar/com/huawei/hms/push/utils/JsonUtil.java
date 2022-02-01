package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil
{
  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject, Bundle paramBundle)
  {
    if (paramObject == null)
    {
      HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
      return;
    }
    Object localObject;
    if ((paramObject instanceof String))
    {
      localObject = (String)paramObject;
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramObject = null;
      }
      paramBundle.putString(paramString, getString(paramJSONObject, paramString, paramObject));
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, getInt(paramJSONObject, paramString, ((Integer)paramObject).intValue()));
      return;
    }
    if ((paramObject instanceof int[]))
    {
      localObject = (int[])paramObject;
      paramObject = localObject;
      if (localObject.length == 0) {
        paramObject = null;
      }
      paramBundle.putIntArray(paramString, getIntArray(paramJSONObject, paramString, paramObject));
      return;
    }
    if ((paramObject instanceof long[]))
    {
      localObject = (long[])paramObject;
      paramObject = localObject;
      if (localObject.length == 0) {
        paramObject = null;
      }
      paramBundle.putLongArray(paramString, getLongArray(paramJSONObject, paramString, paramObject));
      return;
    }
    if ((paramObject instanceof String[]))
    {
      localObject = (String[])paramObject;
      paramObject = localObject;
      if (localObject.length == 0) {
        paramObject = null;
      }
      paramBundle.putStringArray(paramString, getStringArray(paramJSONObject, paramString, paramObject));
      return;
    }
    HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
  }
  
  public static int getInt(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject != null) {}
    try
    {
      if (!paramJSONObject.has(paramString)) {
        break label57;
      }
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException paramJSONObject)
    {
      label20:
      break label20;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("JSONException: get ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" error.");
    HMSLog.w("JsonUtil", paramJSONObject.toString());
    label57:
    return paramInt;
  }
  
  public static int[] getIntArray(JSONObject paramJSONObject, String paramString, int[] paramArrayOfInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramJSONObject != null)
    {
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    try
    {
      if (!paramJSONObject.has(paramString)) {
        break label136;
      }
      localObject1 = localObject3;
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      localObject1 = localObject3;
      paramJSONObject = new int[localJSONArray.length()];
      int i = 0;
      for (;;)
      {
        localObject2 = paramJSONObject;
        localObject1 = paramJSONObject;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramJSONObject;
        paramJSONObject[i] = ((Integer)localJSONArray.get(i)).intValue();
        i += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label95:
      break label95;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("JSONException: get ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" error.");
    HMSLog.w("JsonUtil", paramJSONObject.toString());
    localObject2 = localObject1;
    label136:
    if (localObject2 == null) {
      return paramArrayOfInt;
    }
    return localObject2;
  }
  
  public static JSONArray getIntJsonArray(int[] paramArrayOfInt)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return localJSONArray;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
    }
    return localJSONArray;
  }
  
  public static long[] getLongArray(JSONObject paramJSONObject, String paramString, long[] paramArrayOfLong)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramJSONObject != null)
    {
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    try
    {
      if (!paramJSONObject.has(paramString)) {
        break label130;
      }
      localObject1 = localObject3;
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      localObject1 = localObject3;
      paramJSONObject = new long[localJSONArray.length()];
      int i = 0;
      for (;;)
      {
        localObject2 = paramJSONObject;
        localObject1 = paramJSONObject;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramJSONObject;
        paramJSONObject[i] = localJSONArray.getLong(i);
        i += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label89:
      break label89;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("JSONException: get ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" error.");
    HMSLog.w("JsonUtil", paramJSONObject.toString());
    localObject2 = localObject1;
    label130:
    if (localObject2 == null) {
      return paramArrayOfLong;
    }
    return localObject2;
  }
  
  public static JSONArray getLongJsonArray(long[] paramArrayOfLong)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length == 0) {
        return localJSONArray;
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfLong[i]);
        i += 1;
      }
    }
    return localJSONArray;
  }
  
  public static String getString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject != null) {}
    try
    {
      if ((!paramJSONObject.has(paramString1)) || (paramJSONObject.get(paramString1) == null)) {
        break label68;
      }
      paramJSONObject = String.valueOf(paramJSONObject.get(paramString1));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      label31:
      break label31;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("JSONException: get ");
    paramJSONObject.append(paramString1);
    paramJSONObject.append(" error.");
    HMSLog.w("JsonUtil", paramJSONObject.toString());
    label68:
    return paramString2;
  }
  
  public static String[] getStringArray(JSONObject paramJSONObject, String paramString, String[] paramArrayOfString)
  {
    Object localObject2 = null;
    paramArrayOfString = null;
    Object localObject1 = paramArrayOfString;
    if (paramJSONObject != null)
    {
      localObject1 = paramArrayOfString;
      paramArrayOfString = localObject2;
    }
    try
    {
      if (!paramJSONObject.has(paramString)) {
        break label125;
      }
      paramArrayOfString = localObject2;
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      paramArrayOfString = localObject2;
      paramJSONObject = new String[localJSONArray.length()];
      int i = 0;
      for (;;)
      {
        localObject1 = paramJSONObject;
        paramArrayOfString = paramJSONObject;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramArrayOfString = paramJSONObject;
        paramJSONObject[i] = ((String)localJSONArray.get(i));
        i += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label85:
      break label85;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("JSONException: get ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" error.");
    HMSLog.w("JsonUtil", paramJSONObject.toString());
    localObject1 = paramArrayOfString;
    label125:
    return localObject1;
  }
  
  public static JSONArray getStringJsonArray(String[] paramArrayOfString)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return localJSONArray;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localJSONArray;
  }
  
  public static void transferJsonObjectToBundle(JSONObject paramJSONObject, Bundle paramBundle, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      a(paramJSONObject, (String)localEntry.getKey(), localEntry.getValue(), paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.utils.JsonUtil
 * JD-Core Version:    0.7.0.1
 */