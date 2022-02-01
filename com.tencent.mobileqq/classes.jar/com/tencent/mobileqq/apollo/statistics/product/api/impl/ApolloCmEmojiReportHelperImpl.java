package com.tencent.mobileqq.apollo.statistics.product.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloCmEmojiReportHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/api/impl/ApolloCmEmojiReportHelperImpl;", "Lcom/tencent/mobileqq/apollo/statistics/product/api/IApolloCmEmojiReportHelper;", "()V", "needReport", "", "report", "", "appRuntime", "Lmqq/app/AppRuntime;", "curSessionType", "", "curFriendUin", "", "setNeedReport", "need", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloCmEmojiReportHelperImpl
  implements IApolloCmEmojiReportHelper
{
  private boolean needReport;
  
  public boolean needReport()
  {
    return this.needReport;
  }
  
  public void report(@Nullable AppRuntime paramAppRuntime, int paramInt, @Nullable String paramString)
  {
    this.needReport = false;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      DtReportParamsBuilder localDtReportParamsBuilder = new DtReportParamsBuilder();
      paramAppRuntime = (AppInterface)paramAppRuntime;
      ApolloDtReportUtil.a("aio", "cm_emoji", "expose", (Map)localDtReportParamsBuilder.a(ApolloDtReportUtil.a(paramAppRuntime)).b(ApolloDtReportUtil.a(paramInt)).f(ApolloDtReportUtil.b(paramAppRuntime)).b(paramString).a());
    }
  }
  
  public void setNeedReport(boolean paramBoolean)
  {
    this.needReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.api.impl.ApolloCmEmojiReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */