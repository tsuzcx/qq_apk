package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

public class c
{
  public static final Object a = new Object();
  public static boolean b = false;
  public static boolean c = false;
  
  public static boolean a()
  {
    synchronized (a)
    {
      boolean bool = b;
      int j;
      if (!bool) {
        j = 0;
      }
      try
      {
        Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
        i = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        int i;
        label27:
        label47:
        break label27;
      }
      HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
      i = 0;
      try
      {
        Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
        j = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        StringBuilder localStringBuilder;
        break label47;
      }
      HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
      if ((i != 0) && (j == 0)) {
        c = true;
      }
      b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hianalytics exist: ");
      localStringBuilder.append(c);
      HMSLog.i("HianalyticsExist", localStringBuilder.toString());
      return c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.c
 * JD-Core Version:    0.7.0.1
 */