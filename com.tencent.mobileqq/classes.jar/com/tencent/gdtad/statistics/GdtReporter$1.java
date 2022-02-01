package com.tencent.gdtad.statistics;

import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;

final class GdtReporter$1
  implements GdtCgiReportRunnable.GdtCgiReportRunnableCallback
{
  public void a(int paramInt)
  {
    if ((paramInt != 200) && (paramInt != 204)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt != 0)
    {
      GdtADFlyingStreamingReportHelper.a().a(1020021L);
      return;
    }
    GdtADFlyingStreamingReportHelper.a().a(1020022L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter.1
 * JD-Core Version:    0.7.0.1
 */