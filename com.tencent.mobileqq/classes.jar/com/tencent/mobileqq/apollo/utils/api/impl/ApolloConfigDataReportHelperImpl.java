package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.utils.api.IApolloConfigDataReportHelper;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/impl/ApolloConfigDataReportHelperImpl;", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloConfigDataReportHelper;", "()V", "interceptReport", "", "app", "Lmqq/app/AppRuntime;", "businessFlag", "", "sop_type", "sop_name", "toUin", "dwop_via", "", "dwop_result", "dwflag2", "dwflag3", "dwflag4", "dwflag5", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloConfigDataReportHelperImpl
  implements IApolloConfigDataReportHelper
{
  public void interceptReport(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt1, int paramInt2, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8)
  {
    ApolloConfigDataReport.a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloConfigDataReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */