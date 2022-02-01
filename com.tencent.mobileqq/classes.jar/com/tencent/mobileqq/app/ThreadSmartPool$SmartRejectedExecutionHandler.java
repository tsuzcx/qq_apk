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
      String str = ((ThreadSmartPool)paramThreadPoolExecutor).getName();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_RejectedExecution");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n revision:");
      localStringBuilder2.append(ThreadSetting.revision);
      localStringBuilder1.append(localStringBuilder2.toString());
      ThreadSmartPool.access$100(this.this$0, (String)localObject, localStringBuilder1);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n");
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append(paramThreadPoolExecutor.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
      paramThreadPoolExecutor = new StringBuilder();
      paramThreadPoolExecutor.append((String)localObject);
      paramThreadPoolExecutor.append(localStringBuilder1.toString());
      ThreadLog.printQLog("ThreadManager", paramThreadPoolExecutor.toString());
      if (ThreadManagerV2.sThreadWrapContext != null)
      {
        ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRejectedCatchedException((String)localObject), (String)localObject, localStringBuilder1.toString());
        this.rejectReportCount += 1;
        paramThreadPoolExecutor = new HashMap();
        paramThreadPoolExecutor.put("executor", str);
        paramThreadPoolExecutor.put("process", String.valueOf(ThreadSetting.sProcessId));
        ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "sp_reject_exception_report", true, 0L, 0L, paramThreadPoolExecutor, "", false);
      }
    }
    ThreadSmartPool.access$200(this.this$0, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadSmartPool.SmartRejectedExecutionHandler
 * JD-Core Version:    0.7.0.1
 */