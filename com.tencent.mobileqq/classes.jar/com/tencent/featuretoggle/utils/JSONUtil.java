package com.tencent.featuretoggle.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JSONUtil
{
  public static Map<String, String> a(String paramString)
  {
    localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = String.valueOf(localIterator.next());
        localHashMap.put(str, String.valueOf(paramString.get(str)));
      }
      return localHashMap;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.JSONUtil
 * JD-Core Version:    0.7.0.1
 */