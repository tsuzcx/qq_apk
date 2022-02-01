package com.tencent.mobileqq.apollo.statistics;

import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloQualityReportUtil$report$1
  implements Runnable
{
  ApolloQualityReportUtil$report$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report subActionType : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("; reserves : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("; reserves2 : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("; reserves3 : ");
    localStringBuilder.append(this.d);
    QLog.d("ApolloQualityReportUtil", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil.report.1
 * JD-Core Version:    0.7.0.1
 */