package com.tencent.logger.log.writer;

import android.util.Log;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "throwable", "", "uncaughtException"}, k=3, mv={1, 1, 16})
final class LogWriter$LoggerThreadFactory$mUncaughtExceptionHandler$1
  implements Thread.UncaughtExceptionHandler
{
  public static final 1 a = new 1();
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.e("LoggerThreadFactory", paramThrowable.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.writer.LogWriter.LoggerThreadFactory.mUncaughtExceptionHandler.1
 * JD-Core Version:    0.7.0.1
 */