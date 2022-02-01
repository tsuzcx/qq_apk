package com.tencent.android.gldrawable.api.base;

import android.util.Log;
import com.tencent.android.gldrawable.api.IReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/android/gldrawable/api/base/EmptyLoadUtils$getReport$1", "Lcom/tencent/android/gldrawable/api/IReporter;", "logE", "", "s", "", "e", "", "logI", "report", "event", "statusCode", "statusMsg", "elapse", "", "api_release"}, k=1, mv={1, 1, 16})
public final class EmptyLoadUtils$getReport$1
  implements IReporter
{
  EmptyLoadUtils$getReport$1(String paramString) {}
  
  public void logE(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    Log.e(this.$tag, paramString);
  }
  
  public void logE(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "e");
    Log.e(this.$tag, paramString, paramThrowable);
  }
  
  public void logI(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    Log.i(this.$tag, paramString);
  }
  
  public void report(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "event");
    Intrinsics.checkParameterIsNotNull(paramString2, "statusCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "statusMsg");
    String str = this.$tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>report>> ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString2);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString3);
    Log.i(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.EmptyLoadUtils.getReport.1
 * JD-Core Version:    0.7.0.1
 */