package com.tencent.mobileqq.app;

import java.util.HashMap;

public abstract interface ThreadWrapContext
{
  public abstract void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
  
  public abstract long getMainProccessThreadMonitorTime();
  
  public abstract long getMainProccessThreadPeakCounts();
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isShotReportRejectedError();
  
  public abstract void reportDengTaException(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2);
  
  public abstract void reportRDMException(Throwable paramThrowable, String paramString1, String paramString2);
  
  public abstract void setMainProccessThreadMonitorTime(long paramLong);
  
  public abstract void setMainProccessThreadPeakCounts(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadWrapContext
 * JD-Core Version:    0.7.0.1
 */