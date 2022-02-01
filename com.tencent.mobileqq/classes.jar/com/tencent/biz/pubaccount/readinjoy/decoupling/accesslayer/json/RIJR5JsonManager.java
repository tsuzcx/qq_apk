package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class RIJR5JsonManager
{
  public static String a(String paramString, Map<String, Object> paramMap)
  {
    JSONObject localJSONObject;
    if ((paramMap != null) && (paramMap.size() > 0)) {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return paramString;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("RIJR5JsonManager", 1, paramMap.getMessage());
      }
    }
    paramMap = localJSONObject.toString();
    return paramMap;
  }
  
  public static JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.optJSONArray(paramString2);
      if (paramString2 == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.length() > 0);
    return null;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json.RIJR5JsonManager
 * JD-Core Version:    0.7.0.1
 */