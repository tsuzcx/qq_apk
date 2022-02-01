package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  public static Map<String, String> a(String paramString)
  {
    if (j.b(paramString)) {
      return null;
    }
    localHashMap = new HashMap(10);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, localJSONObject.getString(str));
      }
      return localHashMap;
    }
    catch (JSONException localJSONException)
    {
      d.a("[qimei] jsonToMap error: " + localJSONException.getMessage(), new Object[0]);
      localHashMap.put("A3", paramString);
      return localHashMap;
    }
  }
  
  public static void a(Context paramContext)
  {
    int i = e(paramContext);
    if (!b.a().equals(d(paramContext)))
    {
      f(paramContext);
      i = 0;
    }
    com.tencent.beacon.core.a.f.a(paramContext).b().a("GEN_QIMEI_TIMES", Integer.valueOf(i + 1)).a();
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    com.tencent.beacon.core.a.f.a(paramContext).b().a("QIMEI_TINE", Long.valueOf(paramLong)).a();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (j.b(paramString)) {
      return;
    }
    if (com.tencent.beacon.core.info.f.a() != 1) {
      com.tencent.beacon.core.a.f.a(paramContext).b().a("BEACON_QIMEI_1", paramString).a();
    }
    for (;;)
    {
      d.a("[qimei] update QIMEI:%s, and save to sp.", new Object[] { paramString });
      return;
      com.tencent.beacon.core.a.f.a(paramContext).b().b("qimei_v2", paramString).a();
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (d.b()) {
      new Handler(Looper.getMainLooper()).post(new h(paramContext, paramString));
    }
  }
  
  public static boolean b(Context paramContext)
  {
    long l = com.tencent.beacon.core.a.f.a(paramContext).a("QIMEI_TINE", 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l >= 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      d.a("[qimei] lastUpdateQimei time: " + l + ", isOver24h: " + bool, new Object[0]);
      return bool;
    }
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    com.tencent.beacon.core.a.f localf = com.tencent.beacon.core.a.f.a(paramContext);
    if (com.tencent.beacon.core.info.f.a() != 1)
    {
      paramContext = localf.a("BEACON_QIMEI_1", "");
      if (TextUtils.isEmpty(paramContext)) {}
    }
    for (;;)
    {
      d.a("[qimei] loadQIMEIJson: %s.", new Object[] { paramContext });
      return paramContext;
      paramContext = localf.a("QIMEI_DENGTA", "");
      continue;
      paramContext = localf.a("QIMEI_DENGTA", "qimei_v2", "");
    }
  }
  
  private static String d(Context paramContext)
  {
    return com.tencent.beacon.core.a.f.a(paramContext).a("GEN_QIMEI", "");
  }
  
  private static int e(Context paramContext)
  {
    return com.tencent.beacon.core.a.f.a(paramContext).a("GEN_QIMEI_TIMES", 0);
  }
  
  private static void f(Context paramContext)
  {
    com.tencent.beacon.core.a.f.a(paramContext).b().a("GEN_QIMEI", b.a()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.i
 * JD-Core Version:    0.7.0.1
 */