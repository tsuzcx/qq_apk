package com.tencent.gdtad.statistics;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GdtActionReporter
{
  public static void a(GdtActionReporter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.a()))
    {
      GdtLog.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction();
    try
    {
      String str = ((String)localObject).replace("__TRACE_ID__", URLEncoder.encode(paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramParams.jdField_a_of_type_Int));
      localObject = str;
      if (paramParams.jdField_a_of_type_Long != -2147483648L) {
        localObject = str.replace("__PAGE_TIME__", String.valueOf(paramParams.jdField_a_of_type_Long));
      }
      paramParams = ((String)localObject).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(GdtVersionUtil.a(), "utf-8"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter
 * JD-Core Version:    0.7.0.1
 */