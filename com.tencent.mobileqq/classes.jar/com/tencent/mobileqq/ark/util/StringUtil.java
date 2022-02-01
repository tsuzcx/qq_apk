package com.tencent.mobileqq.ark.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class StringUtil
{
  public static List<Object> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray))
      {
        localObject1 = a((JSONArray)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get(str);
      Object localObject1;
      if ((localObject2 instanceof JSONArray))
      {
        localObject1 = a((JSONArray)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
      localHashMap.put(str, localObject1);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */