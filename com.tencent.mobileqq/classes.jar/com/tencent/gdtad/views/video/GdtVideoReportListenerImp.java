package com.tencent.gdtad.views.video;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;

public class GdtVideoReportListenerImp
  implements GdtVideoReportListener
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public GdtVideoReportListenerImp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    GdtAd localGdtAd;
    long l;
    if (!paramGdtVideoReportInfo.a())
    {
      if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
      {
        GdtLog.d("GdtVideoStatistics", "return startPositionMillis =-1");
        return;
      }
      if (this.jdField_a_of_type_Long > paramLong)
      {
        GdtLog.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
        this.jdField_a_of_type_Long = 0L;
      }
      GdtLog.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      localGdtAd = (GdtAd)paramGdtVideoData.getAd();
      l = this.jdField_a_of_type_Long;
      if (paramLong != paramGdtVideoData.getDurationMillis()) {
        break label182;
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      GdtImpressionReporter.a(localGdtAd, l, paramLong, bool, this.jdField_a_of_type_Int, paramGdtVideoReportInfo);
      paramGdtVideoReportInfo.b();
      paramGdtVideoReportInfo.d();
      this.jdField_a_of_type_Long = -1L;
      return;
      if (this.jdField_a_of_type_Long != -1L) {
        break;
      }
      this.jdField_a_of_type_Long = 0L;
      break;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    GdtLog.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    GdtLog.b("GdtVideoStatistics", "onError");
    d(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
  }
  
  public void a(GdtVideoData paramGdtVideoData, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    GdtLog.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis(), paramGdtVideoReportInfo);
      paramGdtVideoReportInfo.a(13);
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    GdtLog.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong, paramGdtVideoReportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoReportListenerImp
 * JD-Core Version:    0.7.0.1
 */