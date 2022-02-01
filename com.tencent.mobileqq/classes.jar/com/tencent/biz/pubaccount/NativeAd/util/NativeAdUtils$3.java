package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdReportUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

final class NativeAdUtils$3
  implements Runnable
{
  NativeAdUtils$3(AdReportData paramAdReportData, JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt4, JSONObject paramJSONObject2, JSONObject paramJSONObject3, Bundle paramBundle, String paramString2, long paramLong, JSONObject paramJSONObject4, JSONObject paramJSONObject5, JSONObject paramJSONObject6, boolean paramBoolean1, AppInterface paramAppInterface, boolean paramBoolean2) {}
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e() == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e(new JSONObject());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().put("statistics_data_report", localJSONObject.toString());
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.e().put("statistics_data_report", localJSONObject.toString());
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
    NativeAdUtils.a("NativeAdUtils", "newReport:action:" + AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData) + ", exposeMode:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a() + ", json:" + paramString);
    AdReportManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.b()) {
      return;
    }
    if (a())
    {
      b();
      NativeAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    }
    b(paramString);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    NativeAdUtils.a("NativeAdUtils", "oldReport:action:" + AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData) + ", exposeMode:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a() + ", reportData:" + paramJSONObject.toString() + ", json:" + paramString);
    if (AdReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) {}
    ReportAction localReportAction;
    ActionEntity localActionEntity;
    do
    {
      return;
      localReportAction = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
      localActionEntity = AdReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData);
    } while ((localReportAction == ReportAction.EXPOSE) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a().intValue() == 2) && (localActionEntity != ActionEntity.OutSuperMask));
    if (this.jdField_a_of_type_Int == 25)
    {
      ReadInJoyAdReportUtil.a(paramJSONObject);
      return;
    }
    NativeAdUtils.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData, this.jdField_b_of_type_Int);
    if (a()) {
      b();
    }
    b(paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_d_of_type_Int != 21) && (!NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) && (!this.jdField_b_of_type_Boolean);
  }
  
  private void b()
  {
    NativeAdUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
  }
  
  private void b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
        str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
      }
    }
    if (NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int))
    {
      SuperMaskReportMgr.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      return;
    }
    NativeAdUtils.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Int), str1, paramString);
  }
  
  public void run()
  {
    if (AdReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData)) {
      return;
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    Object localObject;
    JSONObject localJSONObject2;
    for (JSONObject localJSONObject1 = new JSONObject();; localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONObject) {
      try
      {
        localJSONObject1.put("uin", this.jdField_a_of_type_JavaLangString);
        localJSONObject1.put("type", this.jdField_a_of_type_Int);
        localJSONObject1.put("ts", System.currentTimeMillis());
        localJSONObject1.put("origin", this.jdField_b_of_type_Int);
        localJSONObject1.put("sub_origin", this.jdField_c_of_type_Int);
        localJSONObject1.put("oudid", "1");
        localJSONObject1.put("device_info", NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext));
        localJSONObject1.put("ad_info", NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.jdField_d_of_type_Int));
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          localJSONObject1.put("video_info", this.jdField_b_of_type_OrgJsonJSONObject);
          NativeAdUtils.a("video_info ad videoInfo = ", this.jdField_b_of_type_OrgJsonJSONObject.toString());
        }
        if (this.jdField_c_of_type_OrgJsonJSONObject != null) {
          localJSONObject1.put("device_report_info", this.jdField_c_of_type_OrgJsonJSONObject);
        }
        if (this.jdField_a_of_type_Int == 3) {
          localJSONObject1.put("neg_info", NativeAdUtils.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long));
        }
        if (ReadinJoyActionUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          localJSONObject1.put("ugc_card_info", NativeAdUtils.a(this.jdField_d_of_type_OrgJsonJSONObject, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        }
        localObject = new JSONObject();
        SuperMaskReportMgr.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.e, (JSONObject)localObject, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
        a();
        if (this.f != null) {
          localJSONObject1.put("article_info", this.f);
        }
        if (this.e != null) {
          localJSONObject1.put("func_ext_info", this.e);
        }
        localJSONObject1.put("sceneTraceID", AdSessionManager.a().a());
        localJSONObject1.put("sceneSeriesNum", AdSessionManager.a().b());
        localJSONObject1.put("refreshSeriesNum", AdSessionManager.a().a());
        localObject = localJSONObject1.toString();
        NativeAdUtils.a("report json = ", (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label436;
        }
        if (!AdReportManager.a().b()) {
          break label429;
        }
        a((String)localObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
    label429:
    a(localJSONObject2, (String)localObject);
    return;
    label436:
    if (AdReportManager.a().a())
    {
      a((String)localObject);
      return;
    }
    a(localJSONObject2, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3
 * JD-Core Version:    0.7.0.1
 */