package com.tencent.mobileqq.apollo.statistics.trace.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/trace/api/ITraceReportHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addTraceData", "", "featureId", "", "tuid", "", "extra", "", "featureKey", "beginSpan", "spanId", "beginTrace", "endSpan", "errCode", "msg", "", "", "(III[Ljava/lang/Object;)V", "(ILjava/lang/String;II[Ljava/lang/Object;)V", "endTrace", "reportSpan", "timestamp", "", "(IIIJ[Ljava/lang/Object;)V", "extKey", "extValue", "(ILjava/lang/String;IIJIJ[Ljava/lang/Object;)V", "reportSpanMsg", "(II[Ljava/lang/Object;)V", "(ILjava/lang/String;I[Ljava/lang/Object;)V", "setEnableFeatureTrace", "enable", "", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITraceReportHelper
  extends QRouteApi
{
  public abstract void addTraceData(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @NotNull int... paramVarArgs);
  
  public abstract void addTraceData(int paramInt, @Nullable String paramString, @NotNull int... paramVarArgs);
  
  public abstract void beginSpan(int paramInt1, int paramInt2);
  
  public abstract void beginSpan(int paramInt1, @Nullable String paramString, int paramInt2);
  
  public abstract void beginTrace(int paramInt);
  
  public abstract void beginTrace(int paramInt, @Nullable String paramString);
  
  public abstract void beginTrace(int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void endSpan(int paramInt1, int paramInt2, int paramInt3, @NotNull Object... paramVarArgs);
  
  public abstract void endSpan(int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @NotNull Object... paramVarArgs);
  
  public abstract void endTrace(int paramInt);
  
  public abstract void endTrace(int paramInt, @Nullable String paramString);
  
  public abstract void reportSpan(int paramInt1, int paramInt2, int paramInt3, long paramLong, @NotNull Object... paramVarArgs);
  
  public abstract void reportSpan(int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, @NotNull Object... paramVarArgs);
  
  public abstract void reportSpanMsg(int paramInt1, int paramInt2, @NotNull Object... paramVarArgs);
  
  public abstract void reportSpanMsg(int paramInt1, @Nullable String paramString, int paramInt2, @NotNull Object... paramVarArgs);
  
  public abstract void setEnableFeatureTrace(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.api.ITraceReportHelper
 * JD-Core Version:    0.7.0.1
 */