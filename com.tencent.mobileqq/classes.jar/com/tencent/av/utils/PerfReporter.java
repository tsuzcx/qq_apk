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
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static final PerfReporter.CalResult jdField_a_of_type_ComTencentAvUtilsPerfReporter$CalResult = new PerfReporter.CalResult(null);
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new PerfReporter.1();
  private static String jdField_a_of_type_JavaLangString;
  private static final Map<String, PerfReporter.DeltaTime> jdField_a_of_type_JavaUtilMap = new PerfReporter.2();
  private static final Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector(10000);
  private static WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  private static boolean jdField_a_of_type_Boolean = false;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  
  public static int a()
  {
    long l = System.currentTimeMillis();
    Object localObject = new Debug.MemoryInfo();
    try
    {
      Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
      int i = ((Debug.MemoryInfo)localObject).getTotalPss() / 1024;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMemory: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", cost: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("PerfReporter", 2, ((StringBuilder)localObject).toString());
      return i;
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
  
  public static Map<String, String> a(SessionInfo paramSessionInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_subversion", jdField_b_of_type_JavaLangString);
    localHashMap.put("user_uin", jdField_a_of_type_JavaLangString);
    String str = "audio";
    if (paramSessionInfo == null)
    {
      QLog.w("PerfReporter", 2, "createParams with no sessionInfo found");
      str = "no_session";
    }
    else if (!paramSessionInfo.H)
    {
      if (paramSessionInfo.j)
      {
        if (paramSessionInfo.k) {
          str = "video";
        } else {
          str = "local video only";
        }
      }
      else if (paramSessionInfo.k) {
        str = "remote video only";
      }
    }
    localHashMap.put("call_type", str);
    int i = 0;
    while (i < 20)
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("memory_node_");
      i += 1;
      paramSessionInfo.append(i);
      localHashMap.put(paramSessionInfo.toString(), "0");
    }
    paramSessionInfo = jdField_a_of_type_JavaUtilMap.keySet().iterator();
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
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean))
    {
      b();
      jdField_a_of_type_AndroidOsHandler.post(jdField_a_of_type_JavaLangRunnable);
      jdField_b_of_type_Boolean = true;
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
      jdField_a_of_type_Boolean = false;
      jdField_b_of_type_Boolean = false;
      return;
    }
    jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    jdField_a_of_type_JavaLangString = paramString1;
    jdField_b_of_type_JavaLangString = paramString2;
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("memory_report_handler_thread");
    jdField_a_of_type_AndroidOsHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    QQBeaconReport.a();
    jdField_a_of_type_Boolean = true;
  }
  
  public static void a(SessionInfo paramSessionInfo)
  {
    if (!jdField_b_of_type_Boolean)
    {
      QLog.w("PerfReporter", 2, "report not started yet:");
      return;
    }
    paramSessionInfo = a(paramSessionInfo);
    Object localObject1 = b(jdField_a_of_type_JavaUtilVector);
    ((PerfReporter.CalResult)localObject1).a(jdField_a_of_type_ComTencentAvUtilsPerfReporter$CalResult);
    paramSessionInfo.put("memory_max", String.valueOf(((PerfReporter.CalResult)localObject1).jdField_a_of_type_Int));
    paramSessionInfo.put("memory_min", String.valueOf(((PerfReporter.CalResult)localObject1).b));
    paramSessionInfo.put("memory_avg", String.valueOf(((PerfReporter.CalResult)localObject1).c));
    paramSessionInfo.put("memory_variance", String.valueOf(((PerfReporter.CalResult)localObject1).jdField_a_of_type_Double));
    int j;
    for (int i = 0; (i < jdField_a_of_type_JavaUtilVector.size()) && (i < 20); i = j)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("memory_node_");
      j = i + 1;
      ((StringBuilder)localObject1).append(j);
      paramSessionInfo.put(((StringBuilder)localObject1).toString(), String.valueOf(jdField_a_of_type_JavaUtilVector.get(i)));
    }
    localObject1 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (PerfReporter.DeltaTime)jdField_a_of_type_JavaUtilMap.get(str);
      PerfReporter.CalResult localCalResult = b(((PerfReporter.DeltaTime)localObject2).jdField_a_of_type_JavaUtilVector);
      localCalResult.a(((PerfReporter.DeltaTime)localObject2).jdField_a_of_type_ComTencentAvUtilsPerfReporter$CalResult);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_max");
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.jdField_a_of_type_Int));
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
      paramSessionInfo.put(((StringBuilder)localObject2).toString(), String.valueOf(localCalResult.jdField_a_of_type_Double));
    }
    QQBeaconReport.a("0AND0B5DQ74RHJ2R", jdField_a_of_type_JavaLangString, "av_perf", true, paramSessionInfo, true);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    long l = System.currentTimeMillis();
    paramString = (PerfReporter.DeltaTime)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramInt == 0)
    {
      paramString.jdField_a_of_type_Long = l;
      return;
    }
    if ((paramInt == 1) && (paramString.jdField_a_of_type_Long != 0L))
    {
      if (paramString.jdField_a_of_type_JavaUtilVector.size() >= paramString.jdField_a_of_type_JavaUtilVector.capacity())
      {
        PerfReporter.CalResult localCalResult = b(paramString.jdField_a_of_type_JavaUtilVector);
        paramString.jdField_a_of_type_ComTencentAvUtilsPerfReporter$CalResult.a(localCalResult);
        paramString.jdField_a_of_type_JavaUtilVector.clear();
      }
      paramString.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf((int)(l - paramString.jdField_a_of_type_Long)));
      paramString.jdField_a_of_type_Long = 0L;
    }
  }
  
  private static PerfReporter.CalResult b(Vector<Integer> paramVector)
  {
    PerfReporter.CalResult localCalResult = new PerfReporter.CalResult(null);
    int i1 = paramVector.size();
    if (i1 > 0)
    {
      int m = 0;
      int i = 0;
      int j;
      int n;
      for (int k = 0; i < i1; k = n)
      {
        j = ((Integer)paramVector.get(i)).intValue();
        n = k + j;
        if (localCalResult.jdField_a_of_type_Int < 0) {
          k = j;
        } else {
          k = Math.max(localCalResult.jdField_a_of_type_Int, j);
        }
        localCalResult.jdField_a_of_type_Int = k;
        if (localCalResult.b >= 0) {
          j = Math.min(localCalResult.b, j);
        }
        localCalResult.b = j;
        i += 1;
      }
      localCalResult.c = (k / i1);
      double d1 = 0.0D;
      i = m;
      while (i < i1)
      {
        j = ((Integer)paramVector.get(i)).intValue();
        d2 = (j - localCalResult.c) * (j - localCalResult.c);
        Double.isNaN(d2);
        d1 += d2;
        i += 1;
      }
      double d2 = i1;
      Double.isNaN(d2);
      localCalResult.jdField_a_of_type_Double = Math.sqrt(d1 / d2);
    }
    localCalResult.d = i1;
    return localCalResult;
  }
  
  public static void b()
  {
    QLog.d("PerfReporter", 2, "stop");
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    jdField_a_of_type_JavaUtilVector.clear();
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((PerfReporter.DeltaTime)((Map.Entry)localIterator.next()).getValue()).a();
    }
    jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter
 * JD-Core Version:    0.7.0.1
 */