package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class w
{
  public static Map<String, List<q>> a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = g0.a(paramContext, paramString);
    b(paramContext);
    return a(paramContext);
  }
  
  public static Map<String, List<q>> a(Context paramContext, String paramString1, String paramString2)
  {
    if ((!"alltype".equals(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = s0.a(paramString1, paramString2);
      paramString1 = b(paramContext, "stat_v2_1", paramString2);
      paramContext = b(paramContext, "cached_v2_1", paramString2);
    }
    else
    {
      y.c("hmsSdk", "read all event records");
      paramString1 = a(paramContext, "stat_v2_1");
      paramContext = a(paramContext, "cached_v2_1");
    }
    return a(paramString1, paramContext);
  }
  
  public static Map<String, List<q>> a(Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((localEntry.getValue() instanceof String)) {
        a(str, (String)localEntry.getValue(), localHashMap);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, List<q>> a(Map<String, List<q>> paramMap1, Map<String, List<q>> paramMap2)
  {
    if ((paramMap1.size() == 0) && (paramMap2.size() == 0)) {
      return new HashMap();
    }
    if (paramMap1.size() == 0) {
      return paramMap2;
    }
    if (paramMap2.size() == 0) {
      return paramMap1;
    }
    HashMap localHashMap = new HashMap();
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Object localObject = (Map.Entry)paramMap1.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      List localList = (List)paramMap2.get(str);
      if ((localList != null) && (localList.size() > 0)) {
        ((List)localObject).addAll(localList);
      }
      localHashMap.put(str, localObject);
    }
    return localHashMap;
  }
  
  public static void a(String paramString1, String paramString2, Map<String, List<q>> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = new JSONArray(paramString2);
        if (paramString2.length() == 0) {
          return;
        }
        i = 0;
        if (i < paramString2.length()) {
          localq = new q();
        }
      }
      catch (JSONException paramString1)
      {
        int i;
        q localq;
        continue;
      }
      try
      {
        localq.a(paramString2.getJSONObject(i));
        localArrayList.add(localq);
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      y.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
      i += 1;
    }
    paramMap.put(paramString1, localArrayList);
    return;
    y.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
  }
  
  public static Map<String, List<q>> b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = g0.a(paramContext, paramString1, paramString2, "");
    paramString1 = new HashMap();
    a(paramString2, paramContext, paramString1);
    return paramString1;
  }
  
  public static void b(Map<String, ?> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Set localSet = s0.a(b.a());
    while (paramMap.hasNext()) {
      if (!localSet.contains(((Map.Entry)paramMap.next()).getKey())) {
        paramMap.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.w
 * JD-Core Version:    0.7.0.1
 */