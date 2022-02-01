package com.huawei.hms.hatool;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class g1
{
  public static g1 c;
  public Context a;
  public final Object b = new Object();
  
  public static g1 a()
  {
    if (c == null) {
      b();
    }
    return c;
  }
  
  public static void b()
  {
    try
    {
      if (c == null) {
        c = new g1();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final JSONObject a(Map<String, String> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null) {}
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    catch (JSONException paramMap)
    {
      label66:
      break label66;
    }
    y.b("hmsSdk", "Exception occured when transferring bundle to json");
    return localJSONObject;
  }
  
  public void a(Context paramContext)
  {
    synchronized (this.b)
    {
      if (this.a != null) {
        return;
      }
      this.a = paramContext;
      h0.a().a(paramContext);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    h0.a().a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = a(paramLinkedHashMap);
    h0.a().a(paramString1, paramInt, paramString2, paramLinkedHashMap);
  }
  
  public void a(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("_constants", paramString3);
      h0.a().a(paramString1, 0, paramString2, paramContext);
      return;
    }
    catch (JSONException paramString1)
    {
      label28:
      break label28;
    }
    y.f("hmsSdk", "onEvent():JSON structure Exception!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.g1
 * JD-Core Version:    0.7.0.1
 */