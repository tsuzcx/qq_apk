package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkAppSchemeCenter
{
  private static HashMap a = new HashMap();
  
  static
  {
    a.put("qq", new ArkAppSchemeCenter.QQSchemeHandler());
    a.put("tel", new ArkAppSchemeCenter.TelSchemeHandler());
    a.put("app", new ArkAppSchemeCenter.AppSchemeHandler());
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public static Map a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get(str);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localHashMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localHashMap;
  }
  
  public static boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    ArkAppSchemeCenter.IRegScheme localIRegScheme;
    do
    {
      do
      {
        return false;
        localObject = paramString1.split(":");
      } while (localObject.length <= 1);
      localObject = localObject[0];
      localIRegScheme = (ArkAppSchemeCenter.IRegScheme)a.get(localObject);
    } while (localIRegScheme == null);
    Object localObject = paramString1.substring(((String)localObject).length() + 1);
    paramString1 = (String)localObject;
    if (((String)localObject).startsWith("//")) {
      paramString1 = ((String)localObject).substring(2);
    }
    localIRegScheme.a(paramString1, paramString2, paramLong, paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter
 * JD-Core Version:    0.7.0.1
 */