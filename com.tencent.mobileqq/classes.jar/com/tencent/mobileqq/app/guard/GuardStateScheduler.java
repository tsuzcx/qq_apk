package com.tencent.mobileqq.app.guard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class GuardStateScheduler
{
  private final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private int a(int paramInt)
  {
    int i = GuardManager.a.b();
    if (paramInt == i) {
      return paramInt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "GuardState have change: prv state: ", Integer.valueOf(paramInt), " curState: ", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static GuardStateScheduler a()
  {
    return GuardStateScheduler.GuardStateSchedulerHolder.a;
  }
  
  private String a()
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilHashMap).entrySet().iterator();
    long l = 0L;
    String str = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (Long.parseLong((String)localEntry.getValue()) > l)
      {
        l = Long.parseLong((String)localEntry.getValue());
        str = (String)localEntry.getKey();
      }
    }
    return str;
  }
  
  private static Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject1 = BaseApplication.context;
    HashMap localHashMap = new HashMap();
    localObject1 = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningAppProcesses();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        localObject3 = paramMap.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Map.Entry)((Iterator)localObject3).next()).getKey();
          if ((str != null) && (str.equals(((ActivityManager.RunningAppProcessInfo)localObject2).processName)) && (((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100)) {
            localHashMap.put(str, paramMap.get(str));
          }
        }
      }
      localObject1 = new ArrayList();
      Object localObject2 = paramMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!localHashMap.containsKey(((Map.Entry)localObject3).getKey())) {
          ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramMap.remove((String)((Iterator)localObject1).next());
      }
    }
    QLog.d("GuardManager.GuardStateScheduler", 1, new Object[] { "[process] filterRealForegroundProcMap: invoked. ", " realProcMap: ", localHashMap });
    return localHashMap;
  }
  
  private void b(int paramInt, String paramString)
  {
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "nextState: ", GuardState.a[paramInt], " process: ", paramString });
      }
      localGuardManager.a(paramInt, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "GuardManager is Null !! nextState: ", GuardState.a[paramInt], " process: ", paramString });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramInt = a(paramInt);
    if (paramInt != 5)
    {
      if (paramInt != 7)
      {
        QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "onMessageRec unknown state type: ", Integer.valueOf(paramInt) });
        return;
      }
      b(6, paramString);
      return;
    }
    b(4, paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = a(paramInt1);
    if (paramInt1 != 2)
    {
      if (paramInt1 != 4)
      {
        if (paramInt1 != 6)
        {
          QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "onTickEvent unSupport state type: ", Integer.valueOf(paramInt1) });
          return;
        }
        b(7, paramString);
        return;
      }
      b(5, paramString);
      return;
    }
    if (a(this.jdField_a_of_type_JavaUtilHashMap).size() <= 0) {
      b(4, null);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "onProcessFGEvent: process: ", paramString1, " isReady: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    paramString1 = a();
    if ("com.tencent.mobileqq".equals(paramString1))
    {
      b(2, paramString1);
      return;
    }
    b(3, paramString1);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardStateScheduler", 2, new Object[] { "onProcessBGEvent: process: ", paramString1, " isReady: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("GuardManager.GuardStateScheduler", 1, "GuardStateScheduler setReady");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    paramString1 = a();
    if (paramString1 != null)
    {
      if ("com.tencent.mobileqq".equals(paramString1))
      {
        b(2, paramString1);
        return;
      }
      b(3, paramString1);
      return;
    }
    b(4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardStateScheduler
 * JD-Core Version:    0.7.0.1
 */