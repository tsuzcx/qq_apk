package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.log.GdtLog;

public class GdtTraceReporter
{
  public static void a(Ad paramAd, int paramInt)
  {
    if (TextUtils.isEmpty(paramAd.getUrlForEffect()))
    {
      GdtLog.d("GdtTraceReporter", String.format("report %d error", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    GdtLog.b("GdtTraceReporter", String.format("report %d", new Object[] { Integer.valueOf(paramInt) }));
    GdtReporter.doCgiReport(paramAd.getUrlForEffect().replaceAll("__CLICK_ID__", paramAd.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtTraceReporter
 * JD-Core Version:    0.7.0.1
 */