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
    }
    do
    {
      long l1;
      do
      {
        do
        {
          return;
          if (paramMessage.what != 2) {
            break;
          }
        } while (ThreadManagerV2.sThreadWrapContext == null);
        JobReporter.access$100();
        long l2 = System.currentTimeMillis();
        if (ThreadSetting.isPublicVersion) {}
        for (l1 = 86400000L; (l2 - JobReporter.access$200() > l1) && (JobReporter.access$300() > 0L) && (JobReporter.access$400()); l1 = 20000L)
        {
          if (JobReporter.access$300() < 500L)
          {
            paramMessage = (String)paramMessage.obj;
            ThreadManagerV2.sThreadWrapContext.reportDengTaException(paramMessage, "thread_monitor_peak_count", true, JobReporter.access$300(), 1L, null, "", false);
            ThreadLog.printQLog("JobReporter", "reportThreadPeakCount Yes " + JobReporter.access$300());
            JobReporter.access$202(l2);
            ThreadManagerV2.sThreadWrapContext.setMainProccessThreadMonitorTime(l2);
          }
          JobReporter.access$302(0L);
          ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.access$300());
          return;
        }
        l1 = JobReporter.access$500();
        ThreadLog.printQLog("JobReporter", "saveThreadPeakCount count" + l1 + " sThreadPeakCount " + JobReporter.access$300());
      } while (l1 <= JobReporter.access$300());
      JobReporter.access$302(l1);
      ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.access$300());
      return;
      if (paramMessage.what != 3) {
        break;
      }
    } while ((ThreadSetting.isPublicVersion) || (JobReporter.mThreadCheck == null) || (paramMessage.obj == null));
    paramMessage = (JobReporter.CheckParams)paramMessage.obj;
    JobReporter.mThreadCheck.isLegalName(paramMessage);
    return;
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.JobReporter.1
 * JD-Core Version:    0.7.0.1
 */