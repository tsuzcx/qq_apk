package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyBottomAdVideoUtil
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.jdField_s_of_type_Int)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_d_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.jdField_d_of_type_JavaLangString, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    ReadInJoyAdLog.a("ReadInJoyBottomAdVideoUtil", "start : " + System.currentTimeMillis());
    if (paramAdData == null) {
      return null;
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    b(paramAdData, localAdvertisementInfo);
    b(localAdvertisementInfo, paramAdData);
    c(localAdvertisementInfo, paramAdData);
    d(localAdvertisementInfo, paramAdData);
    e(localAdvertisementInfo, paramAdData);
    localAdvertisementInfo.mAdvertisementExtInfo = new AdvertisementExtInfo(localAdvertisementInfo.mAdExtInfo);
    if (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      a(paramAdData, localAdvertisementInfo);
      a(localAdvertisementInfo, paramAdData);
    }
    localAdvertisementInfo.liujinReportUrl = paramAdData.O;
    localAdvertisementInfo.ticket = paramAdData.P;
    localAdvertisementInfo.amsNfbUrl = paramAdData.Q;
    localAdvertisementInfo.packageName = paramAdData.a();
    localAdvertisementInfo.mAdMaterialId = paramAdData.a();
    ReadInJoyAdLog.a("ReadInJoyBottomAdVideoUtil", "end : " + System.currentTimeMillis());
    if (RIJAdDownloadExKt.a(paramAdData)) {
      localAdvertisementInfo.isBottomAd = true;
    }
    paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
    return localAdvertisementInfo;
  }
  
  private static void a(VideoInfo.GameAdComData paramGameAdComData, AdGameComponentInfo paramAdGameComponentInfo)
  {
    String str;
    Object localObject;
    if ((paramAdGameComponentInfo != null) && (paramGameAdComData != null))
    {
      paramGameAdComData.jdField_b_of_type_JavaLangString = String.valueOf(paramAdGameComponentInfo.jdField_a_of_type_Int);
      paramGameAdComData.jdField_s_of_type_JavaLangString = paramAdGameComponentInfo.x;
      paramGameAdComData.jdField_d_of_type_JavaLangString = paramAdGameComponentInfo.jdField_b_of_type_JavaLangString;
      paramGameAdComData.c = paramAdGameComponentInfo.jdField_a_of_type_JavaLangString;
      paramGameAdComData.jdField_e_of_type_JavaLangString = paramAdGameComponentInfo.c;
      paramGameAdComData.f = paramAdGameComponentInfo.jdField_d_of_type_JavaLangString;
      paramGameAdComData.jdField_g_of_type_JavaLangString = paramAdGameComponentInfo.jdField_e_of_type_JavaLangString;
      paramGameAdComData.j = paramAdGameComponentInfo.k;
      paramGameAdComData.k = paramAdGameComponentInfo.f;
      paramGameAdComData.jdField_l_of_type_JavaLangString = paramAdGameComponentInfo.r;
      paramGameAdComData.m = paramAdGameComponentInfo.q;
      paramGameAdComData.jdField_n_of_type_JavaLangString = paramAdGameComponentInfo.h;
      paramGameAdComData.jdField_o_of_type_JavaLangString = paramAdGameComponentInfo.i;
      paramGameAdComData.p = paramAdGameComponentInfo.m;
      paramGameAdComData.q = paramAdGameComponentInfo.jdField_n_of_type_JavaLangString;
      paramGameAdComData.r = paramAdGameComponentInfo.jdField_g_of_type_JavaLangString;
      paramGameAdComData.v = paramAdGameComponentInfo.jdField_l_of_type_JavaLangString;
      paramGameAdComData.y = paramAdGameComponentInfo.jdField_s_of_type_JavaLangString;
      paramGameAdComData.x = paramAdGameComponentInfo.jdField_t_of_type_JavaLangString;
      paramGameAdComData.z = paramAdGameComponentInfo.u;
      paramGameAdComData.A = paramAdGameComponentInfo.v;
      paramGameAdComData.w = paramAdGameComponentInfo.w;
      paramGameAdComData.B = paramAdGameComponentInfo.y;
      if (paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo != null)
      {
        str = paramGameAdComData.u;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("sActivityId", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("sGiftName", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("sNeedRole", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.h);
      ((JSONObject)localObject).put("iGiftId", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("gift_icon", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.c);
      ((JSONObject)localObject).put("gift_desc", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_g_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_1", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_2", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_3", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.f);
      paramGameAdComData.u = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          str = paramGameAdComData.jdField_t_of_type_JavaLangString;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new JSONObject((String)localObject);
          ((JSONObject)localObject).put("sGameDownloadUrl", paramAdGameComponentInfo.p);
          ((JSONObject)localObject).put("lGameSize", paramAdGameComponentInfo.q);
          paramGameAdComData.jdField_t_of_type_JavaLangString = ((JSONObject)localObject).toString();
          return;
        }
        catch (Exception paramGameAdComData)
        {
          ReadInJoyAdLog.a("parse download info", paramGameAdComData.getMessage());
        }
        localException = localException;
        ReadInJoyAdLog.a("parse gift info", localException.getMessage());
      }
    }
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    boolean bool = false;
    if ((paramAdvertisementInfo == null) || (paramAdData == null) || (paramAdData.jdField_b_of_type_OrgJsonJSONObject == null) || (paramAdvertisementInfo.mBusiJson == null) || (paramAdData.jdField_a_of_type_OrgJsonJSONObject == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramAdData.jdField_b_of_type_OrgJsonJSONObject.optInt("sourceId", 0) == 8) {
          bool = true;
        }
        paramAdvertisementInfo.isKolGame = bool;
        JSONObject localJSONObject = paramAdData.jdField_a_of_type_OrgJsonJSONObject;
        if (paramAdvertisementInfo.isKolGame)
        {
          str = "2";
          localJSONObject.put("obj_type", str);
          paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
          return;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        ReadInJoyAdLog.a("fillKolGameInfo", paramAdvertisementInfo.getMessage());
        return;
      }
      String str = "1";
    }
  }
  
  private static void a(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
    if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString)))
    {
      paramAdvertisementInfo.mSoftAdType = 2;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.L)) {
        paramAdvertisementInfo.mAdBtnTxt = paramAdvertisementInfo.mAdvertisementSoftInfo.L;
      }
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
    }
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {}
    Rect localRect;
    double d;
    do
    {
      return false;
      localRect = paramRect;
      if (paramRect == null) {
        localRect = new Rect();
      }
      int i = paramView.getHeight();
      paramView.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((localRect.top < 0) || (d < 0.5D) || (d <= 0.800000011920929D));
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "showpercentage = " + d);
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", " top = " + localRect.top + " bottom = " + localRect.bottom);
    return true;
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    try
    {
      String str = paramAdData.L;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = new JSONObject((String)localObject);
      if (!TextUtils.isEmpty(paramAdData.w)) {
        ((JSONObject)localObject).put("pkgurl", paramAdData.w);
      }
      if (!TextUtils.isEmpty(paramAdData.i)) {
        ((JSONObject)localObject).put("appname", paramAdData.i);
      }
      if (!TextUtils.isEmpty(paramAdData.v)) {
        ((JSONObject)localObject).put("pkg_name", paramAdData.v);
      }
      if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo != null) {
        ((JSONObject)localObject).put("appid", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.c);
      }
      paramAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExt error:" + localException.getMessage());
        }
      }
    }
    if ((paramAdData != null) && (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo != null)) {
      paramAdvertisementInfo.mAdDownloadApiUrl = paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  private static void b(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_c_of_type_Int;
    paramAdvertisementInfo.ecpm = paramAdData.jdField_a_of_type_Double;
    paramAdvertisementInfo.isContract = paramAdData.jdField_d_of_type_Int;
    paramAdvertisementInfo.mAdVideoUrl = paramAdData.jdField_o_of_type_JavaLangString;
    paramAdvertisementInfo.adPosType = paramAdData.jdField_t_of_type_Int;
    paramAdvertisementInfo.mAdAid = paramAdData.jdField_a_of_type_Long;
    paramAdvertisementInfo.mAdTraceId = paramAdData.m;
    paramAdvertisementInfo.mAdViewId = paramAdData.jdField_l_of_type_JavaLangString;
    paramAdvertisementInfo.mAdProductId = paramAdData.r;
    paramAdvertisementInfo.mAdVia = paramAdData.jdField_s_of_type_JavaLangString;
    paramAdvertisementInfo.mAdNocoId = paramAdData.jdField_c_of_type_Long;
    paramAdvertisementInfo.mAdApurl = paramAdData.jdField_g_of_type_JavaLangString;
    paramAdvertisementInfo.mAdRl = paramAdData.jdField_e_of_type_JavaLangString;
    paramAdvertisementInfo.mAdEffectUrl = paramAdData.p;
    paramAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.q;
    paramAdvertisementInfo.mAdLandingPage = paramAdData.jdField_t_of_type_JavaLangString;
    paramAdvertisementInfo.mAdCanvasJson = paramAdData.u;
    paramAdvertisementInfo.mAdDestType = paramAdData.jdField_e_of_type_Int;
    paramAdvertisementInfo.mOrigin = 1;
    paramAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.x;
    paramAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.y;
    paramAdvertisementInfo.mChannelID = 2L;
    paramAdvertisementInfo.mAdProductType = paramAdData.jdField_b_of_type_Int;
    paramAdvertisementInfo.mADVideoAutoPlay = paramAdData.f;
    paramAdvertisementInfo.mAlgorithmID = paramAdData.jdField_d_of_type_Long;
    paramAdvertisementInfo.mAlgorithmGroup = paramAdData.jdField_e_of_type_Long;
    paramAdvertisementInfo.mC2SSwitch = paramAdData.jdField_g_of_type_Int;
    paramAdvertisementInfo.mC2SClickUrl = paramAdData.jdField_c_of_type_JavaUtilArrayList;
    paramAdvertisementInfo.mC2SExposureUrl = paramAdData.jdField_d_of_type_JavaUtilArrayList;
    paramAdvertisementInfo.miniProgramType = paramAdData.k;
    paramAdvertisementInfo.mPhoneComponetId = paramAdData.jdField_l_of_type_Int;
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo != null) {
      paramAdvertisementInfo.mAdBtnTxt = paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_l_of_type_JavaLangString;
    }
    try
    {
      paramAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.E);
      if (!TextUtils.isEmpty(paramAdData.jdField_b_of_type_JavaLangString)) {
        paramAdvertisementInfo.mTitle = paramAdData.jdField_b_of_type_JavaLangString;
      }
      paramAdvertisementInfo.mAdLocalSource = a(paramAdData, paramAdvertisementInfo);
      if (!TextUtils.isEmpty(paramAdData.A))
      {
        paramAdvertisementInfo.mAdCorporateImageName = paramAdData.A;
        paramAdvertisementInfo.mAdCorporateLogo = paramAdData.B;
        paramAdvertisementInfo.mSubordinateProductId = paramAdData.z;
        paramAdvertisementInfo.mPopFormH5Url = paramAdData.C;
        paramAdvertisementInfo.mShowAdButton = paramAdData.jdField_c_of_type_Boolean;
        paramAdvertisementInfo.mAdJumpMode = paramAdData.jdField_n_of_type_Int;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_JavaLangString)) {
            paramAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.jdField_a_of_type_JavaLangString).longValue();
          }
          return;
        }
        catch (Exception paramAdData) {}
        localException = localException;
        ReadInJoyAdLog.a("ReadInJoyBottomAdVideoUtil", "parse article_id error :" + localException.getMessage());
        continue;
        paramAdvertisementInfo.mAdCorporateImageName = paramAdData.i;
      }
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if (!TextUtils.isEmpty(paramAdData.M))
    {
      paramAdvertisementInfo.mAdExtInfo = paramAdData.M;
      try
      {
        localJSONObject = new JSONObject(paramAdData.M);
        localJSONObject.put("AdSource", paramAdData.jdField_o_of_type_Int);
        localJSONObject.put("ad_switchs", paramAdData.jdField_n_of_type_JavaLangString);
        localJSONObject.put("jump_type", paramAdData.R);
        if (FastWeqAdUtils.e(paramAdData)) {
          localJSONObject.put("game_button_type", 2);
        }
        for (;;)
        {
          if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo != null)
          {
            localJSONObject.put("game_pkg_name", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_b_of_type_JavaLangString);
            localJSONObject.put("game_adtag", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_o_of_type_JavaLangString);
            localJSONObject.put("game_app_id", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_e_of_type_JavaLangString);
            localJSONObject.put("game_app_name", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_a_of_type_JavaLangString);
            localJSONObject.put("game_apk_url", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.p);
          }
          paramAdvertisementInfo.mAdExtInfo = localJSONObject.toString();
          return;
          if (!FastWeqAdUtils.c(paramAdData)) {
            break;
          }
          localJSONObject.put("game_button_type", 3);
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        JSONObject localJSONObject;
        while (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExtInfo error:" + paramAdvertisementInfo.getMessage());
          return;
          if (FastWeqAdUtils.d(paramAdData)) {
            localJSONObject.put("game_button_type", 1);
          } else if (FastWeqAdUtils.f(paramAdData)) {
            localJSONObject.put("game_button_type", 4);
          }
        }
      }
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    Object localObject;
    if (FastWeqAdUtils.a(paramAdData))
    {
      String str = paramAdvertisementInfo.mAdExt;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = new VideoInfo.GameAdComData(paramAdData.F, (JSONObject)localObject);
      a((VideoInfo.GameAdComData)localObject, paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo);
      paramAdvertisementInfo.gameAdComData = ((VideoInfo.GameAdComData)localObject);
      paramAdvertisementInfo.mSoftAdType = 1;
      if (paramAdvertisementInfo.gameAdComData.jdField_s_of_type_JavaLangString.equals("2")) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
      return;
    }
    catch (Exception paramAdvertisementInfo) {}
  }
  
  private static void e(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    paramAdvertisementInfo.mBusiJson = new JSONObject();
    try
    {
      paramAdvertisementInfo.mBusiJson.put("article_id", paramAdData.E);
      paramAdvertisementInfo.mBusiJson.put("rowkey", paramAdData.F);
      if ((!TextUtils.isEmpty(paramAdData.G)) && (!paramAdData.G.contains("%"))) {
        paramAdvertisementInfo.mBusiJson.put("tags", paramAdData.G);
      }
      if (FastWeqAdUtils.a(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.x);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_b_of_type_JavaLangString);
      }
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null) {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
      }
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      ReadInJoyAdLog.a("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil
 * JD-Core Version:    0.7.0.1
 */