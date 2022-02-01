package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.URL;
import java.util.Map;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class GdtWebReportQQ
  implements GdtWebReportInterface
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -2147483648L;
  private GdtWebReportPlugin jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -2147483648L;
  
  public GdtWebReportQQ(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin = paramGdtWebReportPlugin;
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_Long == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
  }
  
  private String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin;
    if (localObject != null) {
      localObject = ((GdtWebReportPlugin)localObject).a();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      localObject = ((Activity)localObject).getIntent().getStringExtra(paramString);
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", s = ");
    localStringBuilder.append((String)localObject);
    Log.i("GdtWebReportQQ", localStringBuilder.toString());
    return localObject;
  }
  
  private void a(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_REDIRECT_FAIL -- 2 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(2);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  private void a(GdtAd paramGdtAd, int paramInt, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_LOAD_FAILED -- 4 -- ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\t");
    localStringBuilder.append(a());
    Log.i("GdtWebReportQQ", localStringBuilder.toString());
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {
      paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());
    } else {
      paramInt = 0;
    }
    paramMap = new GdtActionReporter.Params();
    paramMap.jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(4);
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(paramInt);
    a(paramMap);
  }
  
  public static void a(GdtActionReporter.Params paramParams)
  {
    if (paramParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
      GdtActionReporter.a(paramParams);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      String[] arrayOfString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.equals(arrayOfString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private long b()
  {
    if (this.jdField_b_of_type_Long == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
  }
  
  private void b(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_REDIRECT_SUCESS -- 1 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(1);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  private void c(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_BACK -- 5 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(5);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  private void d(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_PAUSE -- 6 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(6);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  private void e(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_EXIT -- 7 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(7);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  private void f(GdtAd paramGdtAd)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_LOAD_SUCCESS -- 3 -- \t");
    ((StringBuilder)localObject).append(a());
    Log.i("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = paramGdtAd;
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(3);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a((GdtActionReporter.Params)localObject);
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject1 = a("GdtWebReportQQ_ACTION_URL");
    Object localObject2 = a("GdtWebReportQQ_TRACE_ID");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo localTraceInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
      localTraceInfo.traceid.set((String)localObject2);
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).landing_page_report_url.set((String)localObject1);
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).trace_info.set(localTraceInfo);
      localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.set((MessageMicro)localObject2);
      localObject1 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
      int i = this.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              if (paramLong == 8589934593L)
              {
                this.jdField_a_of_type_Int = 4;
                c((GdtAd)localObject1);
                this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
              }
              else if (paramLong == 8589934597L)
              {
                this.jdField_a_of_type_Int = 4;
                d((GdtAd)localObject1);
              }
            }
          }
          else if ((paramLong == 8589934601L) || (paramLong == 8589934597L))
          {
            e((GdtAd)localObject1);
            this.jdField_a_of_type_Int = 4;
          }
        }
        else if (paramLong == 8589934594L)
        {
          this.jdField_a_of_type_Int = 2;
          f((GdtAd)localObject1);
        }
        else if (paramLong == 8589934595L)
        {
          this.jdField_a_of_type_Int = 3;
          a((GdtAd)localObject1, 1, paramMap);
        }
        else if (paramLong == 8589934601L)
        {
          this.jdField_a_of_type_Int = 4;
          a((GdtAd)localObject1, 94, paramMap);
          c((GdtAd)localObject1);
        }
        else if (paramLong == 8589934597L)
        {
          this.jdField_a_of_type_Int = 4;
          a((GdtAd)localObject1, 95, paramMap);
          d((GdtAd)localObject1);
        }
      }
      else if (paramLong == 8589934593L)
      {
        if ((a(paramString)) && (this.jdField_b_of_type_Int == 0)) {
          this.jdField_b_of_type_Int = 1;
        }
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_Int = 1;
      }
      if (this.jdField_b_of_type_Int == 1) {
        if ((paramLong == 8589934593L) && (this.jdField_a_of_type_Int == 1) && (!a(paramString)))
        {
          b((GdtAd)localObject1);
          this.jdField_b_of_type_Int = 2;
        }
        else if ((a(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
        {
          this.jdField_b_of_type_Int = 2;
          a((GdtAd)localObject1);
        }
      }
      return false;
    }
    Log.i("GdtWebReportQQ", "ljh, empty traceURL or traceID");
    return false;
  }
  
  public void b() {}
  
  public void b(CustomWebView paramCustomWebView) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportQQ
 * JD-Core Version:    0.7.0.1
 */