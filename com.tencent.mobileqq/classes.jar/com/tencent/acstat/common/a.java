package com.tencent.acstat.common;

import android.content.Context;
import com.tencent.acstat.NetworkManager;
import com.tencent.acstat.StatSpecifyReportedInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a
{
  static c a;
  private static StatLogger d = ;
  private static JSONObject e = new JSONObject();
  Integer b = null;
  String c = null;
  
  public a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      a(paramContext, paramStatSpecifyReportedInfo);
      this.b = StatCommonHelper.getTelephonyNetworkType(paramContext.getApplicationContext());
      this.c = NetworkManager.getInstance(paramContext).getCurNetwrokName();
      return;
    }
    catch (Throwable paramContext)
    {
      d.e(paramContext);
    }
  }
  
  static c a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext.getApplicationContext(), paramStatSpecifyReportedInfo, null);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramContext = new HashMap(paramMap).entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramMap = (Map.Entry)paramContext.next();
      e.put((String)paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public void a(JSONObject paramJSONObject, Thread paramThread)
  {
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (a != null) {
          a.a((JSONObject)localObject, paramThread);
        }
        Util.jsonPut((JSONObject)localObject, "cn", this.c);
        if (this.b == null) {
          break label113;
        }
        ((JSONObject)localObject).put("tn", this.b);
      }
      catch (Throwable paramJSONObject)
      {
        d.e(paramJSONObject);
        return;
      }
      paramJSONObject.put((String)localObject, paramThread);
      continue;
      String str = "errkv";
      paramThread = ((JSONObject)localObject).toString();
      localObject = str;
      continue;
      if ((e != null) && (e.length() > 0)) {
        paramJSONObject.put("eva", e);
      }
      return;
      label113:
      if (paramThread == null)
      {
        str = "ev";
        paramThread = (Thread)localObject;
        localObject = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.a
 * JD-Core Version:    0.7.0.1
 */