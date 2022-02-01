package com.huawei.hms.framework.common.hianalytics;

import android.os.Process;

public class CrashHianalyticsData
  extends HianalyticsBaseData
{
  public static final String EXCEPTION_NAME = "exception_name";
  public static final String MESSAGE = "message";
  public static final String PROCESS_ID = "process_id";
  public static final String STACK_TRACE = "stack_trace";
  public static final String THREAD_ID = "thread_id";
  public static final String THREAD_NAME = "thread_name";
  public static final String TIME = "time";
  
  public CrashHianalyticsData()
  {
    put("sdk_name", "Restclient_Crash");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(System.currentTimeMillis());
    put("time", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Process.myPid());
    put("process_id", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Process.myTid());
    put("thread_id", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData
 * JD-Core Version:    0.7.0.1
 */