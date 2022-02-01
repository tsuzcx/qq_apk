package com.tencent.imsdk.base;

import androidx.annotation.UiThread;
import com.tencent.imsdk.base.annotations.CalledByNative;
import com.tencent.imsdk.base.annotations.JNINamespace;
import com.tencent.imsdk.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
public class JavaExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final boolean mCrashAfterReport;
  private boolean mHandlingException;
  private final Thread.UncaughtExceptionHandler mParent;
  
  private JavaExceptionReporter(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, boolean paramBoolean)
  {
    this.mParent = paramUncaughtExceptionHandler;
    this.mCrashAfterReport = paramBoolean;
  }
  
  @CalledByNative
  private static void installHandler(boolean paramBoolean)
  {
    Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), paramBoolean));
  }
  
  @UiThread
  public static void reportStackTrace(String paramString) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!this.mHandlingException) {
      this.mHandlingException = true;
    }
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.mParent;
    if (localUncaughtExceptionHandler != null) {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.base.JavaExceptionReporter
 * JD-Core Version:    0.7.0.1
 */