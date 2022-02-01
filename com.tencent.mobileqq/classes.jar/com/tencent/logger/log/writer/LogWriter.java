package com.tencent.logger.log.writer;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/writer/LogWriter;", "", "queueCapacity", "", "(I)V", "mQueueCapacity", "mThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "execute", "", "task", "Lcom/tencent/logger/log/writer/WriteTask;", "onRunnableRejected", "runnable", "Ljava/lang/Runnable;", "Companion", "LoggerThreadFactory", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LogWriter
{
  public static final LogWriter.Companion a = new LogWriter.Companion(null);
  private final int b;
  private final ThreadPoolExecutor c;
  
  public LogWriter()
  {
    this(0, 1, null);
  }
  
  public LogWriter(int paramInt)
  {
    if ((100 > paramInt) || (10000 < paramInt)) {
      paramInt = 1000;
    }
    this.b = paramInt;
    this.c = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(this.b), (ThreadFactory)new LogWriter.LoggerThreadFactory(), (RejectedExecutionHandler)new LogWriter.mThreadPool.1(this));
  }
  
  private final void a(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof WriteTask))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onRunnableReject] threadInfo:");
      paramRunnable = (WriteTask)paramRunnable;
      localStringBuilder.append(paramRunnable.c());
      localStringBuilder.append(", ");
      localStringBuilder.append("logNumInQueue:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(paramRunnable.a());
      localStringBuilder.append(", msg:");
      localStringBuilder.append(paramRunnable.b());
      Log.w("LogWriter", localStringBuilder.toString());
    }
  }
  
  public final void a(@NotNull WriteTask paramWriteTask)
  {
    Intrinsics.checkParameterIsNotNull(paramWriteTask, "task");
    this.c.execute((Runnable)paramWriteTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.writer.LogWriter
 * JD-Core Version:    0.7.0.1
 */