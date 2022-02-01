package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/IApolloConfigDataReportHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "interceptReport", "", "app", "Lmqq/app/AppRuntime;", "businessFlag", "", "sop_type", "sop_name", "toUin", "dwop_via", "", "dwop_result", "dwflag2", "dwflag3", "dwflag4", "dwflag5", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloConfigDataReportHelper
  extends QRouteApi
{
  public abstract void interceptReport(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt1, int paramInt2, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloConfigDataReportHelper
 * JD-Core Version:    0.7.0.1
 */