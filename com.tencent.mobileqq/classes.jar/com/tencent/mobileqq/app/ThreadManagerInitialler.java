package com.tencent.mobileqq.app;

import bhhr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ThreadManagerInitialler
  implements ThreadWrapContext
{
  private static boolean sFlagInited;
  private static volatile boolean sShotChanceForPublicVersion;
  
  public static void initShotChanceForPublicVersion(long paramLong)
  {
    if ((!sFlagInited) && (BaseApplicationImpl.sProcessId == 1))
    {
      sFlagInited = true;
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|chance " + paramLong);
      }
      if (paramLong > 0L)
      {
        sShotChanceForPublicVersion = JobReporter.ramdomReport((int)paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|sShotChanceForPublicVersion " + sShotChanceForPublicVersion);
        }
      }
    }
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public long getMainProccessThreadMonitorTime()
  {
    return bhhr.d();
  }
  
  public long getMainProccessThreadPeakCounts()
  {
    return bhhr.c();
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isShotReportRejectedError()
  {
    return sShotChanceForPublicVersion;
  }
  
  public void reportDengTaException(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
  
  public void reportRDMException(Throwable paramThrowable, String paramString1, String paramString2) {}
  
  public void setMainProccessThreadMonitorTime(long paramLong)
  {
    bhhr.b(paramLong);
  }
  
  public void setMainProccessThreadPeakCounts(long paramLong)
  {
    bhhr.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerInitialler
 * JD-Core Version:    0.7.0.1
 */