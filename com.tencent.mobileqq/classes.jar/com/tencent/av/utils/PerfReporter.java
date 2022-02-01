package com.tencent.av.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.util.WeakReference;

public class PerfReporter
{
  private static boolean a = false;
  private static boolean b = false;
  private static String c;
  private static String d;
  private static WeakReference<Context> e;
  private static final PerfReporter.CalResult f = new PerfReporter.CalResult(null);
  private static final Vector<Integer> g = new Vector(10000);
  private static HandlerThread h;
  private static Handler i;
  private static final Runnable j = new PerfReporter.1();
  private static final Map<String, PerfReporter.DeltaTime> k = new PerfReporter.2();
  
  public static Map<String, String> a(SessionInfo paramSessionInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_subversion", d);
    localHashMap.put("user_uin", c);
    String str = "audio";
    if (paramSessionInfo == null)
    {
      QLog.w("PerfReporter", 2, "createParams with no sessionInfo found");
      str = "no_session";
    }
    else if (!paramSessionInfo.aK)
    {
      if (paramSessionInfo.H)
      {
        if (paramSessionInfo.I) {
          str = "video";
        } else {
          str = "local video only";
        }
      }
      else if (paramSessionInfo.I) {
        str = "remote video only";
      }
    }
    localHashMap.put("call_type", str);
    int m = 0;
    while (m < 20)
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("memory_node_");
      m += 1;
      paramSessionInfo.append(m);
      localHashMap.put(paramSessionInfo.toString(), "0");
    }
    paramSessionInfo = k.keySet().iterator();
    while (paramSessionInfo.hasNext())
    {
      str = (String)paramSessionInfo.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_max");
      localHashMap.put(localStringBuilder.toString(), "0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_min");
      localHashMap.put(localStringBuilder.toString(), "0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_avg");
      localHashMap.put(localStringBuilder.toString(), "0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_variance");
      localHashMap.put(localStringBuilder.toString(), "0");
    }
    return localHashMap;
  }
  
  public static void a()
  {
    QLog.d("PerfReporter", 2, "start");
    if ((a) && (!b))
    {
      b();
      i.post(j);
      b = true;
      return;
    }
    QLog.w("PerfReporter", 2, "start not init yet, or already start.");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    QLog.d("PerfReporter", 2, "init");
    if (!QAVPerfTestConfig.a(paramString1))
    {
      QLog.d("PerfReporter", 2, "init QAVPerfTestConfig isPerfTestOpen returns false.");
      a = false;
      b = false;
      return;
    }
    e = new WeakReference(paramContext);
    c = paramString1;
    d = paramString2;
    h = new HandlerThread("memory_report_handler_thread");
    h.start();
    i = new Handler(h.getLooper());
    QQBeaconReport.a();
    a = true;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (!b) {
      return;
    }
    long l = System.currentTimeMillis();
    paramString = (PerfReporter.DeltaTime)k.get(paramString);
    if (paramInt == 0)
    {
      paramString.a = l;
      return;
    }
    if ((paramInt == 1) && (paramString.a != 0L))
    {
      if (paramString.b.size() >= paramString.b.capacity())
      {
        PerfReporter.CalResult localCalResult = b(paramString.b);
        paramString.c.a(localCalResult);
        paramString.b.clear();
      }
      paramString.b.add(Integer.valueOf((int)(l - paramString.a)));
      paramString.a = 0L;
    }
  }
  
  private static PerfReporter.CalResult b(Vector<Integer> paramVector)
  {
    PerfReporter.CalResult localCalResult = new PerfReporter.CalResult(null);
    int i4 = paramVector.size();
    if (i4 > 0)
    {
      int i2 = 0;
      int m = 0;
      int n;
      int i3;
      for (int i1 = 0; m < i4; i1 = i3)
      {
        n = ((Integer)paramVector.get(m)).intValue();
        i3 = i1 + n;
        if (localCalResult.a < 0) {
          i1 = n;
        } else {
          i1 = Math.max(localCalResult.a, n);
        }
        localCalResult.a = i1;
        if (localCalResult.b >= 0) {
          n = Math.min(localCalResult.b, n);
        }
        localCalResult.b = n;
        m += 1;
      }
      localCalResult.c = (i1 / i4);
      double d1 = 0.0D;
      m = i2;
      while (m < i4)
      {
        n = ((Integer)paramVector.get(m)).intValue();
        d2 = (n - localCalResult.c) * (n - localCalResult.c);
        Double.isNaN(d2);
        d1 += d2;
        m += 1;
      }
      double d2 = i4;
      Double.isNaN(d2);
      localCalResult.d = Math.sqrt(d1 / d2);
    }
    localCalResult.e = i4;
    return localCalResult;
  }
  
  public static void b()
  {
    QLog.d("PerfReporter", 2, "stop");
    if (!b) {
      return;
    }
    i.removeCallbacks(j);
    g.clear();
    Iterator localIterator = k.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((PerfReporter.DeltaTime)((Map.Entry)localIterator.next()).getValue()).a();
    }
    b = false;
  }
  
  public static void b(SessionInfo paramSessionInfo)
  {
    if (!b)
    {
      QLog.w("PerfReporter", 2, "report not started yet:");
      return;
    }
    paramSessionInfo = a(paramSessionInfo);
    Object localObject1 = b(g);
    ((PerfReporter.CalResult)localObject1).a(f);
    paramSessionInfo.put("memory_max", String.valueOf(((PerfReporter.CalResult)localObject1).a));
    paramSessionInfo.put("memory_min", String.valueOf(((PerfReporter.CalResult)localObject1).b));
    paramSessionInfo.put("memory_avg", String.valueOf(((PerfReporter.CalResult)localObject1).c));
    paramSessionInfo.put("memory_variance", String.valueOf(((PerfReporter.CalResult)localObject1).d));
    int n;
    for (int m = 0; (m < g.size()) && (m < 20); m = n)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("memory_node_");
      n = m + 1;
      ((StringBuilder)localObject1).append(n);
      paramSessionInfo.put(((StringBuilder)localObject1).toString(), String.valueOf(g.get(m)));
    }
    localObject1 = k.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (PerfReporter.DeltaTime)k.get(str);
      PerfReporter.CalResult localCalResult = b(((PerfReporter.DeltaTime)localObject2).b);
      localCalResult.a(((PerfReporter.DeltaTime)localObject2).c);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_max");
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.a));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_min");
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.b));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_avg");
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.c));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_variance");
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.d));
    }
    QQBeaconReport.a("0AND0B5DQ74RHJ2R", c, "av_perf", true, paramSessionInfo, true);
  }
  
  public static int c()
  {
    long l = System.currentTimeMillis();
    Object localObject = new Debug.MemoryInfo();
    try
    {
      Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
      int m = ((Debug.MemoryInfo)localObject).getTotalPss() / 1024;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMemory: ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(", cost: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("PerfReporter", 2, ((StringBuilder)localObject).toString());
      return m;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMemory fail to getProcessMemoryInfo by exception:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.w("PerfReporter", 2, localStringBuilder.toString());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter
 * JD-Core Version:    0.7.0.1
 */