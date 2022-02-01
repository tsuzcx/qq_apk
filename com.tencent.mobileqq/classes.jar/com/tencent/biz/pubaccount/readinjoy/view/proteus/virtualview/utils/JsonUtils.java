package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils
{
  public static Map<String, Object> covertJsonObjectToMap(Object paramObject)
  {
    if (!(paramObject instanceof JSONObject)) {
      return null;
    }
    paramObject = (JSONObject)paramObject;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramObject.opt(str);
      if (localObject != null) {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  public static int getDynamicRateSize(double[] paramArrayOfDouble, Object paramObject)
  {
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() < 2) {}
    }
    try
    {
      double d = Double.parseDouble(paramObject.get(0).toString());
      paramObject = paramObject.get(1).toString();
      if (!TextUtils.isEmpty(paramObject))
      {
        if (d <= 0.0D) {
          return 0;
        }
        if ("YES".equalsIgnoreCase(paramObject))
        {
          paramArrayOfDouble[0] = d;
          return 1;
        }
        if ("NO".equalsIgnoreCase(paramObject))
        {
          paramArrayOfDouble[0] = d;
          return 2;
        }
      }
      return 0;
    }
    catch (Exception paramArrayOfDouble) {}
    return 0;
  }
  
  public static Object getObjectFromJsonArray(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof JSONArray)) {
      return null;
    }
    paramObject = (JSONArray)paramObject;
    if (paramObject.length() > paramInt) {
      try
      {
        paramObject = paramObject.get(paramInt);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        LogUtil.QLog.i("JsonUtils", 2, "parse json error", paramObject);
      }
    }
    return null;
  }
  
  public static String getStringValue(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() <= paramInt) {
        return null;
      }
      try
      {
        paramObject = paramObject.get(paramInt);
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        paramObject = null;
      }
      if ((paramObject instanceof String)) {
        return (String)paramObject;
      }
      return null;
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */