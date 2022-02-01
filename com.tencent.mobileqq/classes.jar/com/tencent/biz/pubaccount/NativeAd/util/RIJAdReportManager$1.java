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
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localObject != null) && (((AdvertisementInfo)localObject).isMultiyVideo)) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e() == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e(new JSONObject());
        }
        boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().has("statistics_data_report");
        if (bool)
        {
          localObject = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().getString("statistics_data_report"));
          ((JSONObject)localObject).put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().put("statistics_data_report", ((JSONObject)localObject).toString());
          return;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().put("statistics_data_report", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newReport:action:");
    localStringBuilder.append(AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData));
    localStringBuilder.append(", exposeMode:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
    localStringBuilder.append(", json:");
    localStringBuilder.append(paramString);
    RIJAdReportManager.a("RIJAdReportManager", localStringBuilder.toString());
    AdReportManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    if ((AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData) == ReportAction.EXPOSE) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a().intValue() == 2) && (AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData) != ActionEntity.OutSuperMask) && (RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      a(paramString, true);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.b()) {
      return;
    }
    if (a())
    {
      c();
      RIJAdReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    }
    b(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str = RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    if ((RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!TextUtils.isEmpty(str)))
    {
      NativeAdUtils.b(str);
      if (!paramBoolean) {
        RIJAdReportManager.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData, this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = this.e;
      if (localJSONObject1 != null)
      {
        paramJSONObject = this.e.optString("exposure_info_report");
        if (TextUtils.isEmpty(paramJSONObject)) {
          paramJSONObject = new JSONObject();
        } else {
          paramJSONObject = new JSONObject(paramJSONObject);
        }
        paramJSONObject.put("stat_type", "2");
        this.e.put("exposure_info_report", paramJSONObject.toString());
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
    ((StringBuilder)localObject).append(AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData));
    ((StringBuilder)localObject).append(", exposeMode:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
    ((StringBuilder)localObject).append(", reportData:");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    ((StringBuilder)localObject).append(", json:");
    ((StringBuilder)localObject).append(paramString);
    RIJAdReportManager.a("NativeAdUtils", ((StringBuilder)localObject).toString());
    if (AdReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) {
      return;
    }
    localObject = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    ActionEntity localActionEntity = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    if ((localObject == ReportAction.EXPOSE) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a().intValue() == 2) && (localActionEntity != ActionEntity.OutSuperMask))
    {
      if (RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        a(paramString, false);
      }
      return;
    }
    if (this.jdField_a_of_type_Int == 25)
    {
      ReadInJoyAdReportUtil.a(paramJSONObject);
      return;
    }
    RIJAdReportManager.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData, this.jdField_b_of_type_Int);
    if (a()) {
      c();
    }
    b(paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_d_of_type_Int != 21) && (!RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) && (!this.jdField_b_of_type_Boolean);
  }
  
  private void b()
  {
    try
    {
      VideoReportObj localVideoReportObj = new VideoReportObj();
      localVideoReportObj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a();
      ((JSONObject)localObject).put("bt", localVideoReportObj.a());
      ((JSONObject)localObject).put("et", localVideoReportObj.b());
      ((JSONObject)localObject).put("bf", localVideoReportObj.c());
      ((JSONObject)localObject).put("ef", localVideoReportObj.d());
      ((JSONObject)localObject).put("pp", localVideoReportObj.e());
      ((JSONObject)localObject).put("pa", localVideoReportObj.b());
      ((JSONObject)localObject).put("hc", localVideoReportObj.f());
      ((JSONObject)localObject).put("ps", localVideoReportObj.a());
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
  
  private void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdViewId))) {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
    } else {
      localObject = "";
    }
    if (RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int))
    {
      SuperMaskReportMgr.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      return;
    }
    RIJAdReportManager.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Int), (String)localObject, paramString);
  }
  
  private void c()
  {
    RIJAdReportManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
  }
  
  public void run()
  {
    if (AdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("uin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject1).put("type", this.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("ts", System.currentTimeMillis());
      ((JSONObject)localObject1).put("origin", this.jdField_b_of_type_Int);
      ((JSONObject)localObject1).put("sub_origin", this.jdField_c_of_type_Int);
      ((JSONObject)localObject1).put("oudid", "1");
      ((JSONObject)localObject1).put("device_info", RIJAdReportManager.a(this.jdField_a_of_type_AndroidContentContext));
      ((JSONObject)localObject1).put("ad_info", RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo, this.jdField_d_of_type_Int));
      if (this.jdField_b_of_type_OrgJsonJSONObject != null)
      {
        b();
        ((JSONObject)localObject1).put("video_info", this.jdField_b_of_type_OrgJsonJSONObject);
        RIJAdReportManager.a("video_info ad videoInfo = ", this.jdField_b_of_type_OrgJsonJSONObject.toString());
      }
      if (this.jdField_c_of_type_OrgJsonJSONObject != null) {
        ((JSONObject)localObject1).put("device_report_info", this.jdField_c_of_type_OrgJsonJSONObject);
      }
      if (this.jdField_a_of_type_Int == 3) {
        ((JSONObject)localObject1).put("neg_info", RIJAdReportManager.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long));
      }
      if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        ((JSONObject)localObject1).put("ugc_card_info", RIJAdReportManager.a(this.jdField_d_of_type_OrgJsonJSONObject, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
      }
      localObject2 = new JSONObject();
      SuperMaskReportMgr.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.e, (JSONObject)localObject2, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
      a();
      if (this.f != null) {
        ((JSONObject)localObject1).put("article_info", this.f);
      }
      localObject2 = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
      ActionEntity localActionEntity = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
      if ((localObject2 == ReportAction.EXPOSE) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a().intValue() == 2) && (RIJAdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (localActionEntity != ActionEntity.OutSuperMask)) {
        a((JSONObject)localObject1);
      }
      if (this.e != null) {
        ((JSONObject)localObject1).put("func_ext_info", this.e);
      }
      ((JSONObject)localObject1).put("scene_trace_id", AdSessionManager.a().a());
      ((JSONObject)localObject1).put("scene_series_num", AdSessionManager.a().b());
      ((JSONObject)localObject1).put("refresh_series_num", AdSessionManager.a().a());
      localObject2 = ((JSONObject)localObject1).toString();
      RIJAdReportManager.a("report json = ", (String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (AdReportManager.a().b())
        {
          a((String)localObject2);
          return;
        }
        a((JSONObject)localObject1, (String)localObject2);
        return;
      }
      if (AdReportManager.a().a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager.1
 * JD-Core Version:    0.7.0.1
 */