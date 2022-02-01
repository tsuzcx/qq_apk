package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.report.bean.VideoReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

final class RIJAdReportManager$1
  implements Runnable
{
  RIJAdReportManager$1(AdReportData paramAdReportData, JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt4, JSONObject paramJSONObject2, JSONObject paramJSONObject3, Bundle paramBundle, String paramString2, long paramLong, JSONObject paramJSONObject4, JSONObject paramJSONObject5, JSONObject paramJSONObject6, boolean paramBoolean1, AppInterface paramAppInterface, boolean paramBoolean2) {}
  
  private void a()
  {
    try
    {
      Object localObject = AdReportUtil.a(this.a);
      if ((localObject != ReportAction.CLICK) && (localObject != ReportAction.CLOSE)) {
        return;
      }
      if (this.q.has("click_info_report")) {
        localObject = new JSONObject(this.q.optString("click_info_report"));
      } else {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("aindex", AdReportUtil.h(this.a));
      ((JSONObject)localObject).put("login_skey", AdReportUtil.a());
      this.q.put("click_info_report", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      ReadInJoyAdLog.b("RIJAdReportManager", localThrowable.getMessage());
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newReport:action:");
    localStringBuilder.append(AdReportUtil.a(this.a));
    localStringBuilder.append(", exposeMode:");
    localStringBuilder.append(this.a.t());
    localStringBuilder.append(", json:");
    localStringBuilder.append(paramString);
    RIJAdReportManager.a("RIJAdReportManager", localStringBuilder.toString());
    AdReportManager.a().a(this.a);
    if ((AdReportUtil.a(this.a) == ReportAction.EXPOSE) && (this.a.t().intValue() == 2) && (AdReportUtil.b(this.a) != ActionEntity.OutSuperMask) && (RIJAdReportManager.a(this.h))) {
      a(paramString, true);
    }
    if (this.a.u()) {
      return;
    }
    if (e())
    {
      d();
      RIJAdReportManager.b(this.a);
    }
    b(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str = RIJAdReportManager.d(this.a);
    if ((RIJAdReportManager.a(this.h)) && (!TextUtils.isEmpty(str)))
    {
      NativeAdUtils.c(str);
      if (!paramBoolean) {
        RIJAdReportManager.a(paramString, this.t, this.h, this.a, this.e);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = this.q;
      if (localJSONObject1 != null)
      {
        paramJSONObject = this.q.optString("exposure_info_report");
        if (TextUtils.isEmpty(paramJSONObject)) {
          paramJSONObject = new JSONObject();
        } else {
          paramJSONObject = new JSONObject(paramJSONObject);
        }
        paramJSONObject.put("stat_type", "2");
        this.q.put("exposure_info_report", paramJSONObject.toString());
        return;
      }
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("stat_type", "2");
      localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
      paramJSONObject.put("func_ext_info", localJSONObject1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      RIJAdReportManager.a("reportAmsLooseExpose fillAmsLooseReportData = ", paramJSONObject.getMessage());
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("oldReport:action:");
    ((StringBuilder)localObject).append(AdReportUtil.a(this.a));
    ((StringBuilder)localObject).append(", exposeMode:");
    ((StringBuilder)localObject).append(this.a.t());
    ((StringBuilder)localObject).append(", reportData:");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    ((StringBuilder)localObject).append(", json:");
    ((StringBuilder)localObject).append(paramString);
    RIJAdReportManager.a("NativeAdUtils", ((StringBuilder)localObject).toString());
    if (AdReportManager.c(this.a)) {
      return;
    }
    localObject = AdReportUtil.a(this.a);
    ActionEntity localActionEntity = AdReportUtil.b(this.a);
    if ((localObject == ReportAction.EXPOSE) && (this.a.t().intValue() == 2) && (localActionEntity != ActionEntity.OutSuperMask))
    {
      if (RIJAdReportManager.a(this.h)) {
        a(paramString, false);
      }
      return;
    }
    if (this.d == 25)
    {
      ReadInJoyAdReportUtil.a(paramJSONObject);
      return;
    }
    RIJAdReportManager.a(paramString, this.t, this.h, this.a, this.e);
    if (e()) {
      d();
    }
    b(paramString);
  }
  
  private void b()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((AdvertisementInfo)localObject).isMultiyVideo)) {
      try
      {
        if (this.a.r() == null) {
          this.a.e(new JSONObject());
        }
        boolean bool = this.a.r().has("statistics_data_report");
        if (bool)
        {
          localObject = new JSONObject(this.a.r().getString("statistics_data_report"));
          ((JSONObject)localObject).put("show_style", this.h.mRevisionVideoType);
          this.a.r().put("statistics_data_report", ((JSONObject)localObject).toString());
          return;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("show_style", this.h.mRevisionVideoType);
        this.a.r().put("statistics_data_report", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = this.h;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdViewId))) {
      localObject = this.h.mAdViewId;
    } else {
      localObject = "";
    }
    if (RIJAdReportManager.a(this.h, this.e))
    {
      SuperMaskReportMgr.a.a(this.h, this.e, this.d);
      return;
    }
    RIJAdReportManager.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.e), String.valueOf(this.d), (String)localObject, paramString);
  }
  
  private void c()
  {
    try
    {
      VideoReportObj localVideoReportObj = new VideoReportObj();
      localVideoReportObj.a(this.a);
      localObject = this.a.l();
      ((JSONObject)localObject).put("bt", localVideoReportObj.d());
      ((JSONObject)localObject).put("et", localVideoReportObj.e());
      ((JSONObject)localObject).put("bf", localVideoReportObj.f());
      ((JSONObject)localObject).put("ef", localVideoReportObj.g());
      ((JSONObject)localObject).put("pp", localVideoReportObj.h());
      ((JSONObject)localObject).put("pa", localVideoReportObj.k());
      ((JSONObject)localObject).put("hc", localVideoReportObj.i());
      ((JSONObject)localObject).put("ps", localVideoReportObj.j());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleOldVideoReport,error:");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      RIJAdReportManager.a("RIJAdReportManager", ((StringBuilder)localObject).toString());
    }
  }
  
  private void d()
  {
    RIJAdReportManager.a(this.d, this.h, this.i);
  }
  
  private boolean e()
  {
    return (this.j != 21) && (!RIJAdReportManager.c(this.a)) && (!this.u);
  }
  
  public void run()
  {
    if (AdReportManager.b(this.a)) {
      return;
    }
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("uin", this.c);
      ((JSONObject)localObject1).put("type", this.d);
      ((JSONObject)localObject1).put("ts", System.currentTimeMillis());
      ((JSONObject)localObject1).put("origin", this.e);
      ((JSONObject)localObject1).put("sub_origin", this.f);
      ((JSONObject)localObject1).put("oudid", "1");
      ((JSONObject)localObject1).put("device_info", RIJAdReportManager.a(this.g));
      ((JSONObject)localObject1).put("ad_info", RIJAdReportManager.a(this.h, this.i, this.j));
      if (this.k != null)
      {
        c();
        ((JSONObject)localObject1).put("video_info", this.k);
        RIJAdReportManager.a("video_info ad videoInfo = ", this.k.toString());
      }
      if (this.l != null) {
        ((JSONObject)localObject1).put("device_report_info", this.l);
      }
      if (this.d == 3) {
        ((JSONObject)localObject1).put("neg_info", RIJAdReportManager.a(this.m, this.n, this.o));
      }
      if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.h)) {
        ((JSONObject)localObject1).put("ugc_card_info", RIJAdReportManager.a(this.p, this.e, this.h));
      }
      localObject2 = new JSONObject();
      SuperMaskReportMgr.a.a(this.h, this.q, (JSONObject)localObject2, Integer.valueOf(this.d), Integer.valueOf(this.e), this.a.t());
      b();
      if (this.r != null) {
        ((JSONObject)localObject1).put("article_info", this.r);
      }
      localObject2 = AdReportUtil.a(this.a);
      ActionEntity localActionEntity = AdReportUtil.b(this.a);
      if ((localObject2 == ReportAction.EXPOSE) && (this.a.t().intValue() == 2) && (RIJAdReportManager.a(this.h)) && (localActionEntity != ActionEntity.OutSuperMask)) {
        a((JSONObject)localObject1);
      }
      a();
      ((JSONObject)localObject1).put("func_ext_info", this.q);
      ((JSONObject)localObject1).put("scene_trace_id", AdSessionManager.a().b());
      ((JSONObject)localObject1).put("scene_series_num", AdSessionManager.a().e());
      ((JSONObject)localObject1).put("refresh_series_num", AdSessionManager.a().c());
      localObject2 = ((JSONObject)localObject1).toString();
      RIJAdReportManager.a("report json = ", (String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      if (this.s)
      {
        if (AdReportManager.a().c())
        {
          a((String)localObject2);
          return;
        }
        a((JSONObject)localObject1, (String)localObject2);
        return;
      }
      if (AdReportManager.a().b())
      {
        a((String)localObject2);
        return;
      }
      a((JSONObject)localObject1, (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager.1
 * JD-Core Version:    0.7.0.1
 */