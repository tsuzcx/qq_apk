package com.tencent.mobileqq.app;

import java.util.HashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadSmartPool$SmartRejectedExecutionHandler
  implements RejectedExecutionHandler
{
  private int rejectReportCount = 0;
  
  public ThreadSmartPool$SmartRejectedExecutionHandler(ThreadSmartPool paramThreadSmartPool) {}
  
  private boolean needReportRejectedError()
  {
    return (this.rejectReportCount < 1) && (ThreadLog.needRecordJob());
  }
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    ThreadSmartPool.access$002(this.this$0, true);
    if ((needReportRejectedError()) && ((paramThreadPoolExecutor instanceof ThreadSmartPool)))
    {
      String str1 = ((ThreadSmartPool)paramThreadPoolExecutor).getName();
      String str2 = str1 + "_RejectedExecution";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n revision:" + ThreadSetting.revision);
      ThreadSmartPool.access$100(this.this$0, str2, localStringBuilder);
      localStringBuilder.append("\n" + str2 + paramThreadPoolExecutor.toString());
      ThreadLog.printQLog("ThreadManager", str2 + localStringBuilder.toString());
      if (ThreadManagerV2.sThreadWrapContext != null)
      {
        ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRejectedCatchedException(str2), str2, localStringBuilder.toString());
        this.rejectReportCount += 1;
        paramThreadPoolExecutor = new HashMap();
        paramThreadPoolExecutor.put("executor", str1);
        paramThreadPoolExecutor.put("process", String.valueOf(ThreadSetting.sProcessId));
        ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "sp_reject_exception_report", true, 0L, 0L, paramThreadPoolExecutor, "", false);
      }
    }
    ThreadSmartPool.access$200(this.this$0, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadSmartPool.SmartRejectedExecutionHandler
 * JD-Core Version:    0.7.0.1
 */