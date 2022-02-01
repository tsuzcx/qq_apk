package com.tencent.luggage.wxa.do;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.a;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.jj.t;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.e.a;
import com.tencent.luggage.wxa.rb.g;
import java.util.Map;

public class b
  implements e.a
{
  protected static b a;
  private static String[] d = t.b;
  private final Map<String, c> b = new ArrayMap();
  private final Map<String, String> c = new ArrayMap();
  
  public static void a()
  {
    try
    {
      a = new b();
      return;
    }
    finally {}
  }
  
  public static b b()
  {
    try
    {
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private c b(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    synchronized (this.c)
    {
      Object localObject2 = (String)this.c.get(paramString);
      if (af.c((String)localObject2))
      {
        localObject2 = a(u.a().a(paramString, d));
        ??? = localObject2;
        if (localObject2 != null) {
          synchronized (this.c)
          {
            this.c.put(paramString, ((c)localObject2).D);
            return localObject2;
          }
        }
      }
      else
      {
        ??? = a((String)localObject2);
      }
      return ???;
    }
  }
  
  @Nullable
  public c a(s params)
  {
    if (params != null)
    {
      c localc = new c();
      localc.b = params.c;
      localc.D = params.d;
      localc.E = params.e;
      localc.F = params.g;
      if (params.c() != null)
      {
        localc.c = params.c().d;
        localc.J = params.c().k;
        localc.K = params.c().l;
      }
      else
      {
        o.b("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { params.c, params.d });
      }
      if (params.e() != null)
      {
        localc.o = params.e().b;
        localc.n = params.e().a;
        localc.p = params.e();
      }
      else
      {
        o.b("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { params.c, params.d });
      }
      localc.q = params.p;
      return localc;
    }
    return null;
  }
  
  public c a(String paramString)
  {
    if (af.c(paramString))
    {
      o.c("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
      return null;
    }
    synchronized (this.b)
    {
      c localc = (c)this.b.remove(paramString);
      if (localc == null)
      {
        ??? = a(u.a().b(paramString, d));
        int i;
        if (??? == null) {
          i = -1;
        } else {
          i = ((c)???).n;
        }
        o.d("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
        return ???;
      }
      o.d("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localc.n) });
      return localc;
    }
  }
  
  public void a(String arg1, g paramg)
  {
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramg.d))
      {
        paramg = String.valueOf(paramg.d);
        if (!af.c(paramg)) {
          try
          {
            b(paramg);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            o.a("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramg });
            synchronized (this.c)
            {
              paramg = (String)this.c.remove(paramg);
              if (TextUtils.isEmpty(paramg)) {
                return;
              }
              synchronized (this.b)
              {
                this.b.remove(paramg);
                return;
              }
            }
          }
        }
      }
    }
    else if ("batch".equals(???)) {
      synchronized (this.b)
      {
        this.b.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.do.b
 * JD-Core Version:    0.7.0.1
 */