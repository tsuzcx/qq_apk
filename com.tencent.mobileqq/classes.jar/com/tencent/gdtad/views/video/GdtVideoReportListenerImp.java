package com.tencent.gdtad.views.video;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;

public class GdtVideoReportListenerImp
  implements GdtVideoReportListener
{
  private long a = -1L;
  private int b = -1;
  
  public GdtVideoReportListenerImp(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    paramGdtVideoReportInfo.d();
    e(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
  }
  
  private void d(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    e(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
  }
  
  private void e(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    if (paramGdtVideoData == null)
    {
      GdtLog.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    if (!paramGdtVideoReportInfo.e())
    {
      l = this.a;
      if ((l != -1L) && (paramLong != 0L))
      {
        if (l > paramLong)
        {
          GdtLog.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
          this.a = 0L;
        }
      }
      else {
        GdtLog.d("GdtVideoStatistics", "return startPositionMillis =-1");
      }
    }
    else if (this.a == -1L)
    {
      this.a = 0L;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report start:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" end:");
    ((StringBuilder)localObject).append(paramLong);
    GdtLog.b("GdtVideoStatistics", ((StringBuilder)localObject).toString());
    localObject = (GdtAd)paramGdtVideoData.getAd();
    long l = this.a;
    boolean bool;
    if (paramLong == paramGdtVideoData.getDurationMillis()) {
      bool = true;
    } else {
      bool = false;
    }
    GdtImpressionReporter.a((GdtAd)localObject, l, paramLong, bool, this.b, paramGdtVideoReportInfo);
    paramGdtVideoReportInfo.b();
    paramGdtVideoReportInfo.d();
    this.a = -1L;
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    if (this.a <= 0L) {
      this.a = paramLong;
    }
    paramGdtVideoData = new StringBuilder();
    paramGdtVideoData.append("onStarted start:");
    paramGdtVideoData.append(this.a);
    GdtLog.b("GdtVideoStatistics", paramGdtVideoData.toString());
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    GdtLog.b("GdtVideoStatistics", "onError");
    d(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
  }
  
  public void a(GdtVideoData paramGdtVideoData, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompleted start:");
    localStringBuilder.append(this.a);
    GdtLog.b("GdtVideoStatistics", localStringBuilder.toString());
    if (paramGdtVideoData == null) {
      return;
    }
    c(paramGdtVideoData, paramGdtVideoData.getDurationMillis(), paramGdtVideoReportInfo);
    paramGdtVideoReportInfo.a(13);
    if (paramGdtVideoData.isLoop()) {
      this.a = 0L;
    }
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStopped start:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" end:");
    localStringBuilder.append(paramLong);
    GdtLog.b("GdtVideoStatistics", localStringBuilder.toString());
    c(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
    this.a = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoReportListenerImp
 * JD-Core Version:    0.7.0.1
 */