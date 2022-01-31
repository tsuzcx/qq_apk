package com.tencent.mobileqq.armap.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SystemUtil
{
  public static String a(Context paramContext, String paramString)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = "";
    Iterator localIterator = localActivityManager.getRunningAppProcesses().iterator();
    Object localObject;
    int i;
    int j;
    while (localIterator.hasNext())
    {
      localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      i = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
      j = ((ActivityManager.RunningAppProcessInfo)localObject).uid;
      localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
      if (((String)localObject).equals(paramString))
      {
        Debug.MemoryInfo[] arrayOfMemoryInfo = localActivityManager.getProcessMemoryInfo(new int[] { i });
        if (arrayOfMemoryInfo == null) {
          break label335;
        }
        arrayOfMemoryInfo[0].getTotalPss();
        int k = arrayOfMemoryInfo[0].otherPss;
        int m = arrayOfMemoryInfo[0].dalvikPss;
        int n = arrayOfMemoryInfo[0].nativePss;
        int i1 = arrayOfMemoryInfo[0].dalvikPrivateDirty;
        i1 = arrayOfMemoryInfo[0].dalvikSharedDirty;
        i1 = arrayOfMemoryInfo[0].nativePrivateDirty;
        i1 = arrayOfMemoryInfo[0].nativeSharedDirty;
        i1 = arrayOfMemoryInfo[0].otherPrivateDirty;
        i1 = arrayOfMemoryInfo[0].otherSharedDirty;
        i1 = arrayOfMemoryInfo[0].getTotalPss();
        arrayOfMemoryInfo[0].getTotalSharedDirty();
        arrayOfMemoryInfo[0].getTotalPrivateDirty();
        paramContext = " pss:" + i1 / 1024 + ",dalvikPss:" + m / 1024 + ",nativePss:" + n / 1024 + ",otherPss:" + k / 1024;
      }
    }
    label335:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemUtil", 2, "getRunningAppProcessInfo processName=" + (String)localObject + ",pid=" + i + ",uid=" + j + paramContext);
      }
      break;
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.SystemUtil
 * JD-Core Version:    0.7.0.1
 */