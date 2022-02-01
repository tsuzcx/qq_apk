package com.tencent.gdtad.statistics;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class GdtC2SReporter
{
  private static GdtC2SReporter.IGdtC2SReportInterface a(int paramInt)
  {
    GdtC2SReportInterface localGdtC2SReportInterface = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localGdtC2SReportInterface = new GdtC2SReportInterface();
    }
    return localGdtC2SReportInterface;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    GdtC2SReporter.IGdtC2SReportInterface localIGdtC2SReportInterface;
    do
    {
      do
      {
        GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      localIGdtC2SReportInterface = a(paramInt2);
    } while (localIGdtC2SReportInterface == null);
    localIGdtC2SReportInterface.a(paramInt1, paramInt2, paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtC2SReporter
 * JD-Core Version:    0.7.0.1
 */