package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private static ConcurrentHashMap A = new ConcurrentHashMap(16);
  private static final long a = 180000L;
  private static final int b = 20;
  private static final int c = 30000;
  private static String d = "";
  private static int e = 0;
  private static int f = 0;
  private static long g = 0L;
  private static long h = 0L;
  private static long i = 0L;
  private static boolean j = false;
  private static ConcurrentHashMap k = new ConcurrentHashMap(16);
  private static double l = 0.0D;
  private static long m = 0L;
  private static long n = 0L;
  private static long o = 0L;
  private static long p = 0L;
  private static long q = 0L;
  private static double r = 0.0D;
  private static String s = "";
  private static long t = 0L;
  private static int u = 0;
  private static String v = "";
  private static long w = 0L;
  private static int x = 0;
  private static boolean y = false;
  private static double z = 0.0D;
  
  public static void a()
  {
    try
    {
      c();
      b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    b();
    d = paramString;
    e = paramInt1;
    f = paramInt2;
    g = SystemClock.elapsedRealtime();
    y = a.b;
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    try
    {
      double d1 = l;
      long l1 = m;
      double d2 = l1 + 1L;
      Double.isNaN(d2);
      d1 /= d2;
      l1 = m;
      d2 = l1;
      Double.isNaN(d2);
      l1 = paramLong / (m + 1L);
      double d3 = l1;
      Double.isNaN(d3);
      l = d1 * d2 + d3;
      m += 1L;
      if (!"SSO.LoginMerge".equals(paramString)) {
        n += 1L;
      } else if (paramInt2 > 0) {
        n += paramInt2;
      }
      if (paramInt3 > 0) {
        o += paramInt3;
      }
      if ((TextUtils.isEmpty(s)) || (t < paramLong))
      {
        s = paramString;
        t = paramLong;
        u = paramInt1;
      }
      if ((g > 0L) && (i - g > 180000L))
      {
        if (!j)
        {
          j = true;
          paramString = new ConcurrentHashMap(32);
          Object localObject1 = k.entrySet().iterator();
          for (;;)
          {
            boolean bool = ((Iterator)localObject1).hasNext();
            if (!bool) {
              break;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
            if (((Integer)localEntry.getValue()).intValue() > 20)
            {
              Object localObject2 = localEntry.getKey();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(localEntry.getValue());
              paramString.put(localObject2, localStringBuilder.toString());
            }
          }
          if (paramString.size() > 0)
          {
            paramString.put("account", MsfService.getCore().getAccountCenter().i());
            paramString.put("ip", d);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(e);
            paramString.put("port", ((StringBuilder)localObject1).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(f);
            paramString.put("nettype", ((StringBuilder)localObject1).toString());
            if (MsfService.getCore().getStatReporter() != null) {
              MsfService.getCore().getStatReporter().a("ReqQualityStatExceptTemp", true, 0L, 0L, paramString, false, false);
            }
          }
        }
      }
      else
      {
        i = SystemClock.elapsedRealtime();
        if (k.containsKey(paramString))
        {
          k.put(paramString, Integer.valueOf(((Integer)k.get(paramString)).intValue() + 1));
          return;
        }
        k.put(paramString, Integer.valueOf(1));
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      h = SystemClock.elapsedRealtime();
      double d1 = r;
      long l1 = q;
      double d2 = l1 + 1L;
      Double.isNaN(d2);
      d1 /= d2;
      l1 = q;
      d2 = l1;
      Double.isNaN(d2);
      l1 = paramLong1 / (q + 1L);
      double d3 = l1;
      Double.isNaN(d3);
      r = d1 * d2 + d3;
      q += 1L;
      if ((TextUtils.isEmpty(v)) || (w < paramLong1))
      {
        v = paramString;
        w = paramLong1;
        x = paramInt;
      }
      if (!paramBoolean)
      {
        d1 = z;
        l1 = p;
        d2 = l1 + 1L;
        Double.isNaN(d2);
        d1 /= d2;
        l1 = p;
        d2 = l1;
        Double.isNaN(d2);
        l1 = paramLong2 / (p + 1L);
        d3 = l1;
        Double.isNaN(d3);
        z = d1 * d2 + d3;
        p += 1L;
        if ((!TextUtils.isEmpty(v)) && (w < paramLong1))
        {
          v = paramString;
          w = paramLong1;
          x = paramInt;
        }
        if (paramLong2 <= 30000L)
        {
          paramInt = (int)(paramLong2 / 1000L);
          if (A.containsKey(Integer.valueOf(paramInt)))
          {
            A.put(Integer.valueOf(paramInt), Integer.valueOf(((Integer)A.get(Integer.valueOf(paramInt))).intValue() + 1));
            return;
          }
          A.put(Integer.valueOf(paramInt), Integer.valueOf(1));
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static void b()
  {
    d = "";
    e = 0;
    f = 0;
    g = 0L;
    i = 0L;
    j = false;
    h = 0L;
    l = 0.0D;
    r = 0.0D;
    n = 0L;
    o = 0L;
    m = 0L;
    p = 0L;
    q = 0L;
    s = "";
    t = 0L;
    u = 0;
    v = "";
    w = 0L;
    x = 0;
    k.clear();
    y = false;
    z = 0.0D;
    A.clear();
  }
  
  private static void c()
  {
    if (TextUtils.isEmpty(d)) {
      return;
    }
    if (m == 0L) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(32);
    localConcurrentHashMap.put("account", MsfService.getCore().getAccountCenter().i());
    localConcurrentHashMap.put("ip", d);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(e);
    localConcurrentHashMap.put("port", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(f);
    localConcurrentHashMap.put("nettype", ((StringBuilder)localObject1).toString());
    localConcurrentHashMap.put("imsi", o.e());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(n);
    localConcurrentHashMap.put("reqtotalcount", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(o);
    localConcurrentHashMap.put("reqnoresp", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(m);
    localConcurrentHashMap.put("reqcount", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l);
    localConcurrentHashMap.put("avareqsize", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(p);
    localConcurrentHashMap.put("respcount", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(q);
    localConcurrentHashMap.put("resptotalcount", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(r);
    localConcurrentHashMap.put("avarespsize", ((StringBuilder)localObject1).toString());
    localConcurrentHashMap.put("maxreqcmd", s);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(t);
    localConcurrentHashMap.put("maxreqsize", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(u);
    localConcurrentHashMap.put("maxreqseq", ((StringBuilder)localObject1).toString());
    localConcurrentHashMap.put("maxrespcmd", v);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(w);
    localConcurrentHashMap.put("maxrespsize", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(x);
    localConcurrentHashMap.put("maxrespseq", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(z);
    localConcurrentHashMap.put("avacost", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(g);
    localConcurrentHashMap.put("conntime", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l1);
    localConcurrentHashMap.put("disconntime", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(h);
    localConcurrentHashMap.put("lastresptime", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(i);
    localConcurrentHashMap.put("lastreqtime", ((StringBuilder)localObject1).toString());
    boolean bool = y;
    Object localObject2 = "1";
    if (bool) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localConcurrentHashMap.put("crossOper", localObject1);
    localConcurrentHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    if (y) {
      localObject1 = localObject2;
    } else {
      localObject1 = "0";
    }
    localConcurrentHashMap.put("param_FailCode", localObject1);
    if (A.size() > 0)
    {
      localObject1 = new StringBuilder();
      localObject2 = A.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localEntry.getKey());
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(localEntry.getValue());
        ((StringBuilder)localObject1).append("|");
      }
      localConcurrentHashMap.put("costmap", ((StringBuilder)localObject1).toString());
    }
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("ReqQualityStatTemp", true, z, (int)l, localConcurrentHashMap, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.f
 * JD-Core Version:    0.7.0.1
 */