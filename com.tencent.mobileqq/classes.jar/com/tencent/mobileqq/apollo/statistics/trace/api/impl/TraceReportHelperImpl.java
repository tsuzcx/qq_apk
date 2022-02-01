package com.tencent.mobileqq.apollo.statistics.trace.api.impl;

import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.api.ITraceReportHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/trace/api/impl/TraceReportHelperImpl;", "Lcom/tencent/mobileqq/apollo/statistics/trace/api/ITraceReportHelper;", "()V", "addTraceData", "", "featureId", "", "tuid", "", "extra", "", "featureKey", "beginSpan", "spanId", "beginTrace", "endSpan", "errCode", "msg", "", "", "(III[Ljava/lang/Object;)V", "(ILjava/lang/String;II[Ljava/lang/Object;)V", "endTrace", "reportSpan", "timestamp", "", "(IIIJ[Ljava/lang/Object;)V", "extKey", "extValue", "(ILjava/lang/String;IIJIJ[Ljava/lang/Object;)V", "reportSpanMsg", "(II[Ljava/lang/Object;)V", "(ILjava/lang/String;I[Ljava/lang/Object;)V", "setEnableFeatureTrace", "enable", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TraceReportHelperImpl
  implements ITraceReportHelper
{
  public void addTraceData(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @NotNull int... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "extra");
    TraceReportUtil.a(paramInt, paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void addTraceData(int paramInt, @Nullable String paramString, @NotNull int... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "extra");
    TraceReportUtil.a(paramInt, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void beginSpan(int paramInt1, int paramInt2)
  {
    TraceReportUtil.a(paramInt1, paramInt2);
  }
  
  public void beginSpan(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    TraceReportUtil.a(paramInt1, paramString, paramInt2);
  }
  
  public void beginTrace(int paramInt)
  {
    TraceReportUtil.a(paramInt);
  }
  
  public void beginTrace(int paramInt, @Nullable String paramString)
  {
    TraceReportUtil.a(paramInt, paramString);
  }
  
  public void beginTrace(int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    TraceReportUtil.a(paramInt, paramString1, paramString2);
  }
  
  public void endSpan(int paramInt1, int paramInt2, int paramInt3, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramInt2, paramInt3, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void endSpan(int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramString, paramInt2, paramInt3, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void endTrace(int paramInt)
  {
    TraceReportUtil.b(paramInt);
  }
  
  public void endTrace(int paramInt, @Nullable String paramString)
  {
    TraceReportUtil.b(paramInt, paramString);
  }
  
  public void reportSpan(int paramInt1, int paramInt2, int paramInt3, long paramLong, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramInt2, paramInt3, paramLong, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void reportSpan(int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramString, paramInt2, paramInt3, paramLong1, paramInt4, paramLong2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void reportSpanMsg(int paramInt1, int paramInt2, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramInt2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void reportSpanMsg(int paramInt1, @Nullable String paramString, int paramInt2, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    TraceReportUtil.a(paramInt1, paramString, paramInt2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public void setEnableFeatureTrace(int paramInt, boolean paramBoolean)
  {
    TraceReportUtil.a(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.api.impl.TraceReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */