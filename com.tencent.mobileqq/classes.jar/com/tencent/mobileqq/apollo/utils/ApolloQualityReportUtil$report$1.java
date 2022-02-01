package com.tencent.mobileqq.apollo.utils;

import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ApolloQualityReportUtil$report$1
  implements Runnable
{
  public ApolloQualityReportUtil$report$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    QLog.d("ApolloQualityReportUtil", 1, "report subActionType : " + this.a + "; reserves : " + this.b + "; reserves2 : " + this.c + "; reserves3 : " + this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloQualityReportUtil.report.1
 * JD-Core Version:    0.7.0.1
 */