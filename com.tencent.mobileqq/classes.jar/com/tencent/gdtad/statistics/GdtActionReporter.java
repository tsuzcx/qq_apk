package com.tencent.gdtad.statistics;

import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtActionReporter
{
  public static void a(GdtActionReporter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.a()))
    {
      Object localObject1 = paramParams.jdField_a_of_type_ComTencentAdTangramAd.getUrlForAction();
      try
      {
        Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramParams.jdField_a_of_type_ComTencentAdTangramAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
        localObject1 = localObject2;
        if (paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
          localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
        }
        localObject2 = localObject1;
        if (paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
          localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
        }
        paramParams = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(GdtVersionUtil.a(), "utf-8"));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GdtActionReporter report url = ");
        ((StringBuilder)localObject1).append(paramParams);
        GdtLog.b("GdtActionReporter", ((StringBuilder)localObject1).toString());
        GdtReporter.doCgiReport(paramParams);
        return;
      }
      catch (UnsupportedEncodingException paramParams)
      {
        GdtLog.d("GdtActionReporter", "report error", paramParams);
        return;
      }
    }
    GdtLog.d("GdtActionReporter", "report error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter
 * JD-Core Version:    0.7.0.1
 */