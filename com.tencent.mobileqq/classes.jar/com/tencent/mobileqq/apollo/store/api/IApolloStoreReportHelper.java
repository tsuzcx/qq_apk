package com.tencent.mobileqq.apollo.store.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/store/api/IApolloStoreReportHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportSSORetCodeNonZero", "", "cmd", "", "ssoErrorCode", "", "ssoCost", "", "reportSSOSuccessCost", "reportSSOTimeout", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloStoreReportHelper
  extends QRouteApi
{
  public abstract void reportSSORetCodeNonZero(@NotNull String paramString, long paramLong, int paramInt);
  
  public abstract void reportSSOSuccessCost(@Nullable String paramString, int paramInt);
  
  public abstract void reportSSOTimeout(@NotNull String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.api.IApolloStoreReportHelper
 * JD-Core Version:    0.7.0.1
 */