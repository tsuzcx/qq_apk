package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import ohu;
import oik;
import ois;
import org.json.JSONException;
import org.json.JSONObject;
import ufw;
import ujg;
import ukq;
import uvp;

public final class NativeAdUtils$3
  implements Runnable
{
  public NativeAdUtils$3(JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt4, JSONObject paramJSONObject2, JSONObject paramJSONObject3, Bundle paramBundle, String paramString2, long paramLong, JSONObject paramJSONObject4, JSONObject paramJSONObject5, ufw paramufw, JSONObject paramJSONObject6, boolean paramBoolean1, AppInterface paramAppInterface, boolean paramBoolean2) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    while ((oik.a(this.jdField_a_of_type_Ufw) != ReportAction.EXPOSE) || (this.jdField_a_of_type_Ufw.a() == ExposeMode.LOOSE) || (oik.a(this.jdField_a_of_type_Ufw) != ActionEntity.Default)) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdApurl))
    {
      QLog.e("reportAmsExpose", 1, "aPurl report fail with empty url");
      return;
    }
    ukq.a("reportAmsExpose", "apurl = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdApurl);
    Bundle localBundle = new Bundle();
    HttpUtil.addCookie(localBundle);
    try
    {
      ukq.a("reportAmsExpose, result:", new String(HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdApurl, "GET", null, localBundle)));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      ukq.a("reportAmsExpose, e:", localThrowable.getMessage());
    }
  }
  
  private void a(String paramString)
  {
    ohu.a().a(this.jdField_a_of_type_Ufw);
    if (this.jdField_a_of_type_Ufw.b()) {
      return;
    }
    a();
    if (a()) {
      b();
    }
    b(paramString);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    if (this.jdField_a_of_type_Int == 25)
    {
      ReadInJoyAdReportUtil.a(paramJSONObject);
      return;
    }
    ois.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Ufw, this.jdField_b_of_type_Int);
    if (a()) {
      b();
    }
    b(paramString);
  }
  
  private boolean a()
  {
    return (this.jdField_d_of_type_Int != 21) && (!ois.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!this.jdField_b_of_type_Boolean);
  }
  
  private void b()
  {
    ois.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
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
    if (ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int))
    {
      ujg.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      return;
    }
    ois.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Int), str1, paramString);
  }
  
  public void run()
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    Object localObject;
    label401:
    do
    {
      try
      {
        localJSONObject.put("uin", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("type", this.jdField_a_of_type_Int);
        localJSONObject.put("ts", System.currentTimeMillis());
        localJSONObject.put("origin", this.jdField_b_of_type_Int);
        localJSONObject.put("sub_origin", this.jdField_c_of_type_Int);
        localJSONObject.put("oudid", "1");
        localJSONObject.put("device_info", ois.a(this.jdField_a_of_type_AndroidContentContext));
        localJSONObject.put("ad_info", ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.jdField_d_of_type_Int));
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          localJSONObject.put("video_info", this.jdField_b_of_type_OrgJsonJSONObject);
          ois.a("video_info ad videoInfo = ", this.jdField_b_of_type_OrgJsonJSONObject.toString());
        }
        if (this.jdField_c_of_type_OrgJsonJSONObject != null) {
          localJSONObject.put("device_report_info", this.jdField_c_of_type_OrgJsonJSONObject);
        }
        if (this.jdField_a_of_type_Int == 3) {
          localJSONObject.put("neg_info", ois.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long));
        }
        if (uvp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          localJSONObject.put("ugc_card_info", ois.a(this.jdField_d_of_type_OrgJsonJSONObject, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        }
        localObject = new JSONObject();
        ujg.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.e, (JSONObject)localObject, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_Ufw.a());
        if (this.f != null) {
          localJSONObject.put("article_info", this.f);
        }
        if (this.e != null) {
          localJSONObject.put("func_ext_info", this.e);
        }
        localObject = localJSONObject.toString();
        ois.a("report json = ", (String)localObject);
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {}
        do
        {
          return;
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
          break;
          if (!this.jdField_a_of_type_Boolean) {
            break label401;
          }
          if (ohu.a().c()) {
            a((String)localObject);
          }
        } while ((this.jdField_a_of_type_Ufw.b()) || (!ohu.a().d()));
        a(localJSONObject, (String)localObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if (ohu.a().a())
      {
        a((String)localObject);
        return;
      }
    } while ((this.jdField_a_of_type_Ufw.b()) || (!ohu.a().b()));
    a(localJSONException, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3
 * JD-Core Version:    0.7.0.1
 */