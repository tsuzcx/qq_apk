package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdPingUrlUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import nxw;
import nxy;
import oaz;
import omq;
import oqa;
import oqj;
import oqr;
import org.json.JSONException;
import org.json.JSONObject;
import ubb;

public final class NativeAdUtils$2
  implements Runnable
{
  public NativeAdUtils$2(JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt4, JSONObject paramJSONObject2, JSONObject paramJSONObject3, Bundle paramBundle, String paramString2, long paramLong, JSONObject paramJSONObject4, JSONObject paramJSONObject5, JSONObject paramJSONObject6, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    new JSONObject();
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    Object localObject3;
    for (;;)
    {
      try
      {
        localJSONObject.put("uin", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("type", this.jdField_a_of_type_Int);
        localJSONObject.put("ts", System.currentTimeMillis());
        localJSONObject.put("origin", this.jdField_b_of_type_Int);
        localJSONObject.put("sub_origin", this.jdField_c_of_type_Int);
        localJSONObject.put("oudid", "1");
        localJSONObject.put("device_info", nxw.a(this.jdField_a_of_type_AndroidContentContext));
        localJSONObject.put("ad_info", nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.jdField_d_of_type_Int));
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          localJSONObject.put("video_info", this.jdField_b_of_type_OrgJsonJSONObject);
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "video_info ad videoInfo = " + this.jdField_b_of_type_OrgJsonJSONObject.toString());
          }
        }
        if (this.jdField_c_of_type_OrgJsonJSONObject != null) {
          localJSONObject.put("device_report_info", this.jdField_c_of_type_OrgJsonJSONObject);
        }
        if (this.jdField_a_of_type_Int == nxw.jdField_c_of_type_Int)
        {
          localObject2 = new JSONObject();
          if (this.jdField_a_of_type_AndroidOsBundle != null)
          {
            ((JSONObject)localObject2).put("type_id", nxw.aE);
            ((JSONObject)localObject2).put("tel", this.jdField_a_of_type_AndroidOsBundle.getString(nxw.jdField_a_of_type_JavaLangString, ""));
            ((JSONObject)localObject2).put("txt", this.jdField_a_of_type_AndroidOsBundle.getString(nxw.jdField_b_of_type_JavaLangString, ""));
            localJSONObject.put("neg_info", localObject2);
          }
        }
        else
        {
          if (ubb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            new JSONObject();
            if (this.jdField_d_of_type_OrgJsonJSONObject != null) {
              break label700;
            }
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("type", oqa.a(this.jdField_b_of_type_Int));
            ((JSONObject)localObject2).put("interaction_report_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdInteractionReportUrl);
            ((JSONObject)localObject2).put("effect_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdEffectUrl);
            localJSONObject.put("ugc_card_info", localObject2);
          }
          localObject2 = new JSONObject();
          if ((oqj.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickType == 2) && (this.e != null))
          {
            ((JSONObject)localObject2).put("material_group", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.materialGroup));
            ((JSONObject)localObject2).put("slide_mode", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.k) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.l);
            ((JSONObject)localObject2).put("click_type", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickType));
            this.e.put("click_info_report", String.valueOf(localObject2));
            localObject3 = (JSONObject)localJSONObject.opt("ad_info");
            if (localObject3 != null)
            {
              ((JSONObject)localObject3).put("click_pos", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.m);
              localJSONObject.put("ad_info", localObject3);
            }
          }
          oqr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.e, (JSONObject)localObject2, this.jdField_a_of_type_Int);
          if (this.f != null) {
            localJSONObject.put("article_info", this.f);
          }
          if (this.e != null) {
            localJSONObject.put("func_ext_info", this.e);
          }
          localObject3 = localJSONObject.toString();
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "report json = " + (String)localObject3);
          }
          boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
          if (!bool) {
            break;
          }
          return;
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
          continue;
        }
        ((JSONObject)localObject2).put("type_id", nxw.aD);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          ((JSONObject)localObject2).put("neg_ids", String.valueOf(this.jdField_a_of_type_Long));
          continue;
        }
        ((JSONObject)localObject2).put("neg_ids", this.jdField_b_of_type_JavaLangString);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      continue;
      label700:
      localObject2 = this.jdField_d_of_type_OrgJsonJSONObject;
    }
    if (this.jdField_a_of_type_Int == nxw.B)
    {
      ReadInJoyAdPingUrlUtil.a(localJSONException);
      return;
    }
    Object localObject1 = new WebSsoBody.WebSsoRequestBody();
    ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject3);
    Object localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), oaz.class);
    ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report_new");
    ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new nxy(this));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject2);
    if ((this.jdField_d_of_type_Int != nxw.aB) && (!nxw.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!this.jdField_a_of_type_Boolean))
    {
      nxw.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      oqr.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Int);
    }
    localObject2 = "";
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
      }
    }
    nxw.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Int), (String)localObject1, (String)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.2
 * JD-Core Version:    0.7.0.1
 */