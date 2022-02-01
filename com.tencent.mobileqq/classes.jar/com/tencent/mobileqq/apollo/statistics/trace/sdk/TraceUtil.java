package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class TraceUtil
{
  private static long jdField_a_of_type_Long = 0L;
  private static boolean jdField_a_of_type_Boolean = false;
  private static long b;
  
  public static int a()
  {
    if (jdField_a_of_type_Boolean) {
      return 0;
    }
    Object localObject5 = null;
    String str = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    try
    {
      try
      {
        localObject3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
        f1 = f2;
        String[] arrayOfString;
        long l1;
        long l2;
        float f3;
        label208:
        Object localObject2 = localObject3;
      }
      finally
      {
        try
        {
          try
          {
            str = ((BufferedReader)localObject3).readLine();
            if (str == null) {
              try
              {
                ((BufferedReader)localObject3).close();
                return 0;
              }
              catch (Exception localException1)
              {
                QLog.e("[cmshow][TraceReport]", 1, localException1, new Object[0]);
                return 0;
              }
            }
            f1 = f2;
            arrayOfString = localException1.split(" ");
            f1 = f2;
            l1 = Long.parseLong(arrayOfString[2]) + Long.parseLong(arrayOfString[3]) + Long.parseLong(arrayOfString[4]);
            f1 = f2;
            l2 = Long.parseLong(arrayOfString[5]);
            f1 = f2;
            f3 = (float)(l1 - jdField_a_of_type_Long);
            f1 = f2;
            f2 = (float)(l1 - jdField_a_of_type_Long + l2 - b);
            f1 = f2;
            f2 = f3 * 100.0F / f2;
            f1 = f2;
            jdField_a_of_type_Long = l1;
            f1 = f2;
            b = l2;
            try
            {
              ((BufferedReader)localObject3).close();
            }
            catch (Exception localException2)
            {
              QLog.e("[cmshow][TraceReport]", 1, localException2, new Object[0]);
            }
          }
          finally
          {
            break label270;
          }
        }
        catch (IOException localIOException2)
        {
          Object localObject3;
          Object localObject4;
          break label208;
        }
        localObject6 = finally;
        localObject3 = localObject1;
        localObject2 = localObject6;
        break label270;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        label270:
        localObject4 = localObject6;
      }
    }
    jdField_a_of_type_Boolean = true;
    f2 = f1;
    if (localObject3 != null) {
      try
      {
        ((BufferedReader)localObject3).close();
        f2 = f1;
      }
      catch (Exception localException3)
      {
        QLog.e("[cmshow][TraceReport]", 1, localException3, new Object[0]);
        f2 = f1;
      }
    }
    return Math.round(f2);
    if (localObject3 != null) {
      try
      {
        ((BufferedReader)localObject3).close();
      }
      catch (Exception localException4)
      {
        QLog.e("[cmshow][TraceReport]", 1, localException4, new Object[0]);
      }
    }
    throw localException3;
  }
  
  public static TraceConfig a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return new TraceConfig.Builder().a(1).a(((QQAppInterface)localAppRuntime).getCurrentAccountUin()).a();
    }
    throw new IllegalArgumentException("config should init in PROCESS_QQ");
  }
  
  private static Map<String, Integer> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap(9);
    if (paramContext != null) {
      try
      {
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        if (paramContext != null)
        {
          paramContext = paramContext.getProcessMemoryInfo(new int[] { Process.myPid() });
          if ((paramContext != null) && (paramContext.length > 0))
          {
            paramContext = paramContext[0];
            if (paramContext != null)
            {
              int i = Build.VERSION.SDK_INT;
              if (i >= 23)
              {
                localHashMap.put("summary.total-pss", Integer.valueOf(Integer.parseInt((String)paramContext.getMemoryStats().get("summary.total-pss"))));
                return localHashMap;
              }
              localHashMap.put("summary.total-pss", Integer.valueOf(paramContext.getTotalPss()));
              return localHashMap;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("[cmshow][TraceReport]", 1, paramContext, new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static int b()
  {
    int j = 0;
    try
    {
      Map localMap = a(BaseApplicationImpl.context);
      int i;
      if (localMap != null) {
        i = ((Integer)localMap.get("summary.total-pss")).intValue();
      } else {
        i = 0;
      }
      if (i > 0) {
        j = i;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow][TraceReport]", 1, localException, new Object[0]);
    }
    return j / 1024;
  }
  
  public static int c()
  {
    return (int)((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L);
  }
  
  public static int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceUtil
 * JD-Core Version:    0.7.0.1
 */