package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.StringUtils;

class HianalyticsHelper$1
  implements Runnable
{
  HianalyticsHelper$1(HianalyticsHelper paramHianalyticsHelper, String paramString1, Throwable paramThrowable, String paramString2) {}
  
  public void run()
  {
    CrashHianalyticsData localCrashHianalyticsData = new CrashHianalyticsData();
    localCrashHianalyticsData.put("thread_name", this.val$threadName);
    localCrashHianalyticsData.put("exception_name", this.val$e.getClass().getName());
    localCrashHianalyticsData.put("message", StringUtils.anonymizeMessage(this.val$e.getMessage()));
    localCrashHianalyticsData.put("stack_trace", StringUtils.getTraceInfo(this.val$e));
    HianalyticsHelper.getInstance().onEvent(localCrashHianalyticsData.get(), this.val$eventId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.1
 * JD-Core Version:    0.7.0.1
 */