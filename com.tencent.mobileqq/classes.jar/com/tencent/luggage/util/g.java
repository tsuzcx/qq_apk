package com.tencent.luggage.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
{
  public static Boolean a(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(true);
      }
      if ("false".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(false);
      }
    }
    return null;
  }
  
  public static JSONArray a(List<?> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localJSONArray;
      }
      int i = 0;
      while (i < paramList.size())
      {
        localJSONArray.put(paramList.get(i));
        i += 1;
      }
    }
    return localJSONArray;
  }
  
  public static void a(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        localObject2 = (Map)localObject2;
        a((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.g
 * JD-Core Version:    0.7.0.1
 */