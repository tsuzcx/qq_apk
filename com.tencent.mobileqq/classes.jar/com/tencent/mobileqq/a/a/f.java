package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.t;
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
      l = l / (m + 1L) * m + paramLong / (m + 1L);
      m += 1L;
      if (!"SSO.LoginMerge".equals(paramString))
      {
        n += 1L;
        if (paramInt3 > 0) {
          o += paramInt3;
        }
        if ((TextUtils.isEmpty(s)) || (t < paramLong))
        {
          s = paramString;
          t = paramLong;
          u = paramInt1;
        }
        if ((g <= 0L) || (i - g <= 180000L)) {
          break label371;
        }
        if (!j)
        {
          j = true;
          paramString = new ConcurrentHashMap(32);
          Iterator localIterator = k.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((Integer)localEntry.getValue()).intValue() > 20) {
              paramString.put(localEntry.getKey(), "" + localEntry.getValue());
            }
          }
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    do
    {
      do
      {
        if (paramInt2 <= 0) {
          break;
        }
        n += paramInt2;
        break;
      } while (paramString.size() <= 0);
      paramString.put("account", MsfService.getCore().getAccountCenter().i());
      paramString.put("ip", d);
      paramString.put("port", "" + e);
      paramString.put("nettype", "" + f);
    } while (MsfService.getCore().getStatReporter() == null);
    MsfService.getCore().getStatReporter().a("ReqQualityStatExceptTemp", true, 0L, 0L, paramString, false, false);
    return;
    label371:
    i = SystemClock.elapsedRealtime();
    if (k.containsKey(paramString))
    {
      k.put(paramString, Integer.valueOf(((Integer)k.get(paramString)).intValue() + 1));
      return;
    }
    k.put(paramString, Integer.valueOf(1));
  }
  
  public static void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      h = SystemClock.elapsedRealtime();
      r = r / (q + 1L) * q + paramLong1 / (q + 1L);
      q += 1L;
      if ((TextUtils.isEmpty(v)) || (w < paramLong1))
      {
        v = paramString;
        w = paramLong1;
        x = paramInt;
      }
      if (!paramBoolean)
      {
        z = z / (p + 1L) * p + paramLong2 / (p + 1L);
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
    if (TextUtils.isEmpty(d)) {}
    ConcurrentHashMap localConcurrentHashMap;
    label752:
    do
    {
      do
      {
        return;
      } while (m == 0L);
      long l1 = SystemClock.elapsedRealtime();
      localConcurrentHashMap = new ConcurrentHashMap(32);
      localConcurrentHashMap.put("account", MsfService.getCore().getAccountCenter().i());
      localConcurrentHashMap.put("ip", d);
      localConcurrentHashMap.put("port", "" + e);
      localConcurrentHashMap.put("nettype", "" + f);
      localConcurrentHashMap.put("imsi", t.e());
      localConcurrentHashMap.put("reqtotalcount", "" + n);
      localConcurrentHashMap.put("reqnoresp", "" + o);
      localConcurrentHashMap.put("reqcount", "" + m);
      localConcurrentHashMap.put("avareqsize", "" + l);
      localConcurrentHashMap.put("respcount", "" + p);
      localConcurrentHashMap.put("resptotalcount", "" + q);
      localConcurrentHashMap.put("avarespsize", "" + r);
      localConcurrentHashMap.put("maxreqcmd", s);
      localConcurrentHashMap.put("maxreqsize", "" + t);
      localConcurrentHashMap.put("maxreqseq", "" + u);
      localConcurrentHashMap.put("maxrespcmd", v);
      localConcurrentHashMap.put("maxrespsize", "" + w);
      localConcurrentHashMap.put("maxrespseq", "" + x);
      localConcurrentHashMap.put("avacost", "" + z);
      localConcurrentHashMap.put("conntime", "" + g);
      localConcurrentHashMap.put("disconntime", "" + l1);
      localConcurrentHashMap.put("lastresptime", "" + h);
      localConcurrentHashMap.put("lastreqtime", "" + i);
      if (y)
      {
        localObject = "1";
        localConcurrentHashMap.put("crossOper", localObject);
        localConcurrentHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (!y) {
          break label752;
        }
      }
      for (Object localObject = "1";; localObject = "0")
      {
        localConcurrentHashMap.put("param_FailCode", localObject);
        if (A.size() <= 0) {
          break label771;
        }
        localObject = new StringBuilder();
        Iterator localIterator = A.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((StringBuilder)localObject).append(localEntry.getKey()).append(":").append(localEntry.getValue()).append("|");
        }
        localObject = "0";
        break;
      }
      localConcurrentHashMap.put("costmap", ((StringBuilder)localObject).toString());
    } while (MsfService.getCore().getStatReporter() == null);
    label771:
    MsfService.getCore().getStatReporter().a("ReqQualityStatTemp", true, z, (int)l, localConcurrentHashMap, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.f
 * JD-Core Version:    0.7.0.1
 */