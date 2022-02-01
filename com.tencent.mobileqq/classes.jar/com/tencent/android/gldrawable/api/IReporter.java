package com.tencent.android.gldrawable.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/IReporter;", "", "logE", "", "s", "", "e", "", "logI", "report", "event", "statusCode", "statusMsg", "elapse", "", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReporter
{
  public abstract void logE(@NotNull String paramString);
  
  public abstract void logE(@NotNull String paramString, @NotNull Throwable paramThrowable);
  
  public abstract void logI(@NotNull String paramString);
  
  public abstract void report(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.IReporter
 * JD-Core Version:    0.7.0.1
 */