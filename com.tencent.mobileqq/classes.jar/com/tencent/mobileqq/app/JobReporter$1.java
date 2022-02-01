package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;

final class JobReporter$1
  extends Handler
{
  JobReporter$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (paramMessage.obj != null))
    {
      paramMessage = new WeakReference((Thread)paramMessage.obj);
      JobReporter.access$000().add(paramMessage);
      return;
    }
    if (paramMessage.what == 2)
    {
      if (ThreadManagerV2.sThreadWrapContext != null)
      {
        JobReporter.access$100();
        long l2 = System.currentTimeMillis();
        if (ThreadSetting.isPublicVersion) {
          l1 = 86400000L;
        } else {
          l1 = 20000L;
        }
        if ((l2 - JobReporter.access$200() > l1) && (JobReporter.access$300() > 0L) && (JobReporter.access$400()))
        {
          if (JobReporter.access$300() < 500L)
          {
            paramMessage = (String)paramMessage.obj;
            ThreadManagerV2.sThreadWrapContext.reportDengTaException(paramMessage, "thread_monitor_peak_count", true, JobReporter.access$300(), 1L, null, "", false);
            paramMessage = new StringBuilder();
            paramMessage.append("reportThreadPeakCount Yes ");
            paramMessage.append(JobReporter.access$300());
            ThreadLog.printQLog("JobReporter", paramMessage.toString());
            JobReporter.access$202(l2);
            ThreadManagerV2.sThreadWrapContext.setMainProccessThreadMonitorTime(l2);
          }
          JobReporter.access$302(0L);
          ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.access$300());
          return;
        }
        long l1 = JobReporter.access$500();
        paramMessage = new StringBuilder();
        paramMessage.append("saveThreadPeakCount count");
        paramMessage.append(l1);
        paramMessage.append(" sThreadPeakCount ");
        paramMessage.append(JobReporter.access$300());
        ThreadLog.printQLog("JobReporter", paramMessage.toString());
        if (l1 > JobReporter.access$300())
        {
          JobReporter.access$302(l1);
          ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.access$300());
        }
      }
    }
    else if (paramMessage.what == 3)
    {
      if ((!ThreadSetting.isPublicVersion) && (JobReporter.mThreadCheck != null) && (paramMessage.obj != null))
      {
        paramMessage = (JobReporter.CheckParams)paramMessage.obj;
        JobReporter.mThreadCheck.isLegalName(paramMessage);
      }
    }
    else {
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.JobReporter.1
 * JD-Core Version:    0.7.0.1
 */