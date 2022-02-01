package com.huawei.hms.stats;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class bp
{
  private static bp a = null;
  private Context b;
  private final Object c = new Object();
  
  public static bp a()
  {
    if (a == null) {
      b();
    }
    return a;
  }
  
  private JSONObject a(Map<String, String> paramMap)
  {
    localJSONObject = new JSONObject();
    if (paramMap != null) {
      try
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        return localJSONObject;
      }
      catch (JSONException paramMap)
      {
        af.d("HiAnalyticsEventManager", "Exception occured when transferring bundle to json");
      }
    }
  }
  
  private static void b()
  {
    try
    {
      if (a == null) {
        a = new bp();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    synchronized (this.c)
    {
      if (this.b != null) {
        return;
      }
      this.b = paramContext;
      aq.a().a(paramContext);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    aq.a().a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = a(paramLinkedHashMap);
    aq.a().a(paramString1, paramInt, paramString2, paramLinkedHashMap);
  }
  
  public void a(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("_constants", paramString3);
      aq.a().a(paramString1, 0, paramString2, paramContext);
      return;
    }
    catch (JSONException paramString1)
    {
      af.c("HiAnalyticsEventManager", "onEvent():JSON structure Exception!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bp
 * JD-Core Version:    0.7.0.1
 */