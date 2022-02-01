package com.tencent.beacon.qimei;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.b.a.b;
import com.tencent.beacon.base.util.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static com.tencent.beacon.a.d.g a;
  
  static String a(Context paramContext)
  {
    paramContext = b(paramContext);
    if (paramContext != null)
    {
      paramContext = (String)paramContext.a("Q_V3", "");
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
    }
    b localb = b.a();
    if (com.tencent.beacon.a.c.g.a() != 1) {
      paramContext = localb.a("BEACON_QIMEI_1", "");
    } else {
      paramContext = localb.a("QIMEI_DENGTA", "qimei_v2", "");
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      localObject = localb.a("QIMEI_DENGTA", "");
    }
    return localObject;
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap(3);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject = localJSONObject.keys();
      if (localObject != null)
      {
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localHashMap.put(str, localJSONObject.getString(str));
        }
        return localHashMap;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[qimei] jsonToMap error: ");
      ((StringBuilder)localObject).append(localJSONException.getMessage());
      c.a(((StringBuilder)localObject).toString(), new Object[0]);
      localHashMap.put("A3", paramString);
    }
    return localHashMap;
  }
  
  public static void a(long paramLong)
  {
    a.a().edit().putLong("q_i_t", paramLong);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramContext).b("Q_V3", paramString);
  }
  
  public static boolean a()
  {
    return "n".equalsIgnoreCase(com.tencent.beacon.e.g.b().a("enableQimei"));
  }
  
  private static com.tencent.beacon.a.d.g b(Context paramContext)
  {
    try
    {
      if (a == null) {
        try
        {
          a = com.tencent.beacon.a.d.g.a(paramContext, "Q_V3");
        }
        catch (Exception paramContext)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[qimei] qimeiFile create error: ");
          localStringBuilder.append(paramContext.getMessage());
          c.a(localStringBuilder.toString(), new Object[0]);
          d.b().a("511", "getQimeiStoreFile error", paramContext);
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean b()
  {
    long l = a.a().getLong("q_i_t", 0L);
    boolean bool;
    if ((l != 0L) && (System.currentTimeMillis() - l < 86400000L)) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[qimei] lastUpdateQimei time: ");
    localStringBuilder.append(l);
    localStringBuilder.append(", isOver24h: ");
    localStringBuilder.append(bool);
    c.a(localStringBuilder.toString(), new Object[0]);
    return bool;
  }
  
  public static boolean c()
  {
    String str = com.tencent.beacon.e.g.b().a("qimeiZeroPeak");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if ("y".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (Calendar.getInstance().get(11) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void d()
  {
    com.tencent.beacon.a.d.g localg = a;
    if (localg != null) {
      localg.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.e
 * JD-Core Version:    0.7.0.1
 */