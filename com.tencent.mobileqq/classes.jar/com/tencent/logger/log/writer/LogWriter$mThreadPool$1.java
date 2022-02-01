package com.tencent.logger.log.writer;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Ljava/util/concurrent/ThreadPoolExecutor;", "rejectedExecution"}, k=3, mv={1, 1, 16})
final class LogWriter$mThreadPool$1
  implements RejectedExecutionHandler
{
  LogWriter$mThreadPool$1(LogWriter paramLogWriter) {}
  
  public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramThreadPoolExecutor = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramRunnable, "r");
    LogWriter.a(paramThreadPoolExecutor, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.writer.LogWriter.mThreadPool.1
 * JD-Core Version:    0.7.0.1
 */