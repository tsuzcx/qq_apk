package com.qflutter.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArgumentUtil
{
  private static List<Object> jsonArrayToList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(processJsonValue(paramJSONArray.opt(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static Map<String, Object> jsonObjectToMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, processJsonValue(paramJSONObject.opt(str)));
    }
    return localHashMap;
  }
  
  private static Object processJsonValue(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = jsonObjectToMap((JSONObject)paramObject);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof JSONArray));
    return jsonArrayToList((JSONArray)paramObject);
  }
  
  public static Map<String, Object> transFlutterArguments(Object paramObject)
  {
    if (paramObject == null) {
      return new HashMap();
    }
    if ((paramObject instanceof Map)) {
      return (Map)paramObject;
    }
    if ((paramObject instanceof JSONObject)) {
      return jsonObjectToMap((JSONObject)paramObject);
    }
    throw new ClassCastException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.video.ArgumentUtil
 * JD-Core Version:    0.7.0.1
 */