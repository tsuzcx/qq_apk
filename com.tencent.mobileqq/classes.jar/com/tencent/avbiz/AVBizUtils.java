package com.tencent.avbiz;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class AVBizUtils
{
  public static String a()
  {
    Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null) {
      return null;
    }
    int i = Process.myPid();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static List<Long> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    long l2 = 1L;
    long l1 = paramLong;
    for (paramLong = l2; l1 != 0L; paramLong <<= 1)
    {
      if ((l1 & 1L) != 0L) {
        localArrayList.add(Long.valueOf(paramLong));
      }
      l1 >>= 1;
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString)
  {
    return Constants.Business.a.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizUtils
 * JD-Core Version:    0.7.0.1
 */