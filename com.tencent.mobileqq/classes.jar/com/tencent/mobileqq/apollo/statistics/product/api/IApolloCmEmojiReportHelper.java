package com.tencent.mobileqq.apollo.statistics.product.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/api/IApolloCmEmojiReportHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needReport", "", "report", "", "appRuntime", "Lmqq/app/AppRuntime;", "curSessionType", "", "curFriendUin", "", "setNeedReport", "need", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloCmEmojiReportHelper
  extends QRouteApi
{
  public abstract boolean needReport();
  
  public abstract void report(@Nullable AppRuntime paramAppRuntime, int paramInt, @Nullable String paramString);
  
  public abstract void setNeedReport(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.api.IApolloCmEmojiReportHelper
 * JD-Core Version:    0.7.0.1
 */