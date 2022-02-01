package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"set", "", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "key", "", "value", "", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class ReportR5BuilderExtensionsKt
{
  public static final void a(@NotNull RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, @NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramReportR5Builder, "$this$set");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    paramReportR5Builder.addValueSafe(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReportR5BuilderExtensionsKt
 * JD-Core Version:    0.7.0.1
 */