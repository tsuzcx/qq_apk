package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ThreadManagerInitialler
  implements ThreadWrapContext
{
  private static boolean a;
  private static volatile boolean b;
  
  public static void a(long paramLong)
  {
    if ((!a) && (BaseApplicationImpl.sProcessId == 1))
    {
      a = true;
      QLog.d("ThreadManager.config", 1, "initShotChanceForPublicVersion|chance " + paramLong);
      if (paramLong > 0L)
      {
        b = JobReporter.ramdomReport((int)paramLong);
        QLog.d("ThreadManager.config", 1, "initShotChanceForPublicVersion| " + b);
      }
    }
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public long getMainProccessThreadMonitorTime()
  {
    return SharedPreUtils.d();
  }
  
  public long getMainProccessThreadPeakCounts()
  {
    return SharedPreUtils.c();
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isShotReportRejectedError()
  {
    return b;
  }
  
  public void reportDengTaException(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
  
  public void reportRDMException(Throwable paramThrowable, String paramString1, String paramString2)
  {
    QQCatchedExceptionReporter.reportQQCatchedException(paramThrowable, paramString1, paramString2);
  }
  
  public void setMainProccessThreadMonitorTime(long paramLong)
  {
    SharedPreUtils.b(paramLong);
  }
  
  public void setMainProccessThreadPeakCounts(long paramLong)
  {
    SharedPreUtils.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerInitialler
 * JD-Core Version:    0.7.0.1
 */