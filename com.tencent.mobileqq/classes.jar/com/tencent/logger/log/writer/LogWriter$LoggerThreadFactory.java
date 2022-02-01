package com.tencent.logger.log.writer;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/writer/LogWriter$LoggerThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "mUncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class LogWriter$LoggerThreadFactory
  implements ThreadFactory
{
  public static final LogWriter.LoggerThreadFactory.Companion a = new LogWriter.LoggerThreadFactory.Companion(null);
  private final Thread.UncaughtExceptionHandler b = (Thread.UncaughtExceptionHandler)LogWriter.LoggerThreadFactory.mUncaughtExceptionHandler.1.a;
  
  @NotNull
  public Thread newThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    paramRunnable = new Thread(paramRunnable, "LogWriter");
    paramRunnable.setUncaughtExceptionHandler(this.b);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.writer.LogWriter.LoggerThreadFactory
 * JD-Core Version:    0.7.0.1
 */