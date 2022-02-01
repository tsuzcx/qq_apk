package com.tencent.android.gldrawable.api.impl;

import com.tencent.android.gldrawable.api.IReporter;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/android/gldrawable/api/impl/LoaderUtilsImpl$getReport$1", "Lcom/tencent/android/gldrawable/api/IReporter;", "logE", "", "s", "", "e", "", "logI", "report", "event", "statusCode", "statusMsg", "elapse", "", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class LoaderUtilsImpl$getReport$1
  implements IReporter
{
  LoaderUtilsImpl$getReport$1(String paramString) {}
  
  public void logE(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    QLog.e(this.$tag, 1, paramString);
  }
  
  public void logE(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "e");
    QLog.e(this.$tag, 1, paramString, paramThrowable);
  }
  
  public void logI(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    QLog.i(this.$tag, 1, paramString);
  }
  
  public void report(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "event");
    Intrinsics.checkParameterIsNotNull(paramString2, "statusCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "statusMsg");
    Map localMap = (Map)new HashMap();
    localMap.put("status_code", paramString2);
    localMap.put("status_msg", paramString3);
    localMap.put("scid", "GLDrawableV860");
    VasStatisticCollector.a(paramString1, paramLong, localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.impl.LoaderUtilsImpl.getReport.1
 * JD-Core Version:    0.7.0.1
 */