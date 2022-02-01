package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Map;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

final class GdtWebReportAction
  implements GdtWebReportInterface
{
  private GdtWebReportPlugin a;
  
  public GdtWebReportAction(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    this.a = paramGdtWebReportPlugin;
  }
  
  private void a()
  {
    a(102);
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((GdtWebReportPlugin)localObject1).b() != null) && (this.a.b().getIntent() != null))
    {
      Object localObject3 = this.a.b().getIntent().getStringExtra("GdtWebReportQQ_TRACE_ID");
      localObject1 = this.a.b().getIntent().getStringExtra("GdtWebReportQQ_ACTION_URL");
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set((String)localObject3);
        localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).landing_page_report_url.set((String)localObject1);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).trace_info.set((MessageMicro)localObject2);
        localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.set((MessageMicro)localObject3);
        localObject1 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        localObject2 = new GdtActionReporter.Params();
        ((GdtActionReporter.Params)localObject2).a = ((Ad)localObject1);
        ((GdtActionReporter.Params)localObject2).b.landing_page_action_type.set(paramInt);
        GdtActionReporter.a((GdtActionReporter.Params)localObject2);
        return;
      }
    }
    GdtLog.d("GdtWebReportAction", String.format("reportForAction:%d error", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  private void d()
  {
    a(103);
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public void b()
  {
    GdtLog.b("GdtWebReportAction", "onActivityReady");
    a();
  }
  
  public void b(CustomWebView paramCustomWebView) {}
  
  public void c()
  {
    GdtLog.b("GdtWebReportAction", "onDestroy");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportAction
 * JD-Core Version:    0.7.0.1
 */