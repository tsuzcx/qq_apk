package com.tencent.gdtad.statistics;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GdtActionReporter
{
  public static GdtActionReporter.Params a(GdtAd paramGdtAd, int paramInt, long paramLong)
  {
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localParams.jdField_a_of_type_Int = paramInt;
    localParams.jdField_a_of_type_Long = paramLong;
    if (localParams.a()) {
      return localParams;
    }
    return null;
  }
  
  public static void a(GdtActionReporter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.a()))
    {
      GdtLog.d("GdtActionReporter", "report error");
      return;
    }
    String str = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction();
    try
    {
      paramParams = str.replace("__TRACE_ID__", URLEncoder.encode(paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramParams.jdField_a_of_type_Int)).replace("__PAGE_TIME__", String.valueOf(paramParams.jdField_a_of_type_Long)).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(GdtVersionUtil.a(), "utf-8"));
      GdtLog.b("GdtActionReporter", "report " + paramParams);
      GdtReporter.a().a(paramParams);
      return;
    }
    catch (UnsupportedEncodingException paramParams)
    {
      GdtLog.d("GdtActionReporter", "report error", paramParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter
 * JD-Core Version:    0.7.0.1
 */