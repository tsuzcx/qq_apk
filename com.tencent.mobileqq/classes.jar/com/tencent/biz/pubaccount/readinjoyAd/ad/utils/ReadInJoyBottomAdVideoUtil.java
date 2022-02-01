package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyBottomAdVideoUtil
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdData.jdField_u_of_type_Int != 10) {
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.l)) {
      paramAdvertisementInfo.mSinglePicture = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.l, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    Object localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start : ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((IRIJAdLogService)localObject1).d("ReadInJoyBottomAdVideoUtil", ((StringBuilder)localObject2).toString());
    if (paramAdData == null) {
      return null;
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    localObject1 = new AdvertisementInfo();
    b(paramAdData, (AdvertisementInfo)localObject1);
    b((AdvertisementInfo)localObject1, paramAdData);
    c((AdvertisementInfo)localObject1, paramAdData);
    d((AdvertisementInfo)localObject1, paramAdData);
    e((AdvertisementInfo)localObject1, paramAdData);
    ((AdvertisementInfo)localObject1).mAdvertisementExtInfo = new AdvertisementExtInfo(((AdvertisementInfo)localObject1).mAdExtInfo);
    if (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      a(paramAdData, (AdvertisementInfo)localObject1);
      a((AdvertisementInfo)localObject1, paramAdData);
    }
    ((AdvertisementInfo)localObject1).liujinReportUrl = paramAdData.W;
    ((AdvertisementInfo)localObject1).ticket = paramAdData.X;
    ((AdvertisementInfo)localObject1).amsNfbUrl = paramAdData.Y;
    ((AdvertisementInfo)localObject1).packageName = paramAdData.a();
    ((AdvertisementInfo)localObject1).mAdMaterialId = paramAdData.a();
    ((AdvertisementInfo)localObject1).originalExposureUrl = paramAdData.ac;
    localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("end : ");
    localStringBuilder.append(System.currentTimeMillis());
    ((IRIJAdLogService)localObject2).d("ReadInJoyBottomAdVideoUtil", localStringBuilder.toString());
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isBottomAd(paramAdData)) {
      ((AdvertisementInfo)localObject1).isBottomAd = true;
    }
    paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)localObject1);
    return localObject1;
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if ((paramAdvertisementInfo != null) && (paramAdData != null) && (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramAdData.jdField_b_of_type_OrgJsonJSONObject;
        boolean bool = false;
        if (((JSONObject)localObject).optInt("sourceId", 0) == 8) {
          bool = true;
        }
        paramAdvertisementInfo.isKolGame = bool;
        JSONObject localJSONObject = paramAdData.jdField_a_of_type_OrgJsonJSONObject;
        if (!paramAdvertisementInfo.isKolGame) {
          break label123;
        }
        localObject = "2";
        localJSONObject.put("obj_type", localObject);
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("fillKolGameInfo", paramAdvertisementInfo.getMessage());
      }
      return;
      label123:
      Object localObject = "1";
    }
  }
  
  private static void a(GameAdComData paramGameAdComData, AdGameComponentInfo paramAdGameComponentInfo)
  {
    if ((paramAdGameComponentInfo != null) && (paramGameAdComData != null))
    {
      paramGameAdComData.b = String.valueOf(paramAdGameComponentInfo.jdField_a_of_type_Int);
      paramGameAdComData.s = paramAdGameComponentInfo.x;
      paramGameAdComData.d = paramAdGameComponentInfo.b;
      paramGameAdComData.c = paramAdGameComponentInfo.jdField_a_of_type_JavaLangString;
      paramGameAdComData.e = paramAdGameComponentInfo.c;
      paramGameAdComData.f = paramAdGameComponentInfo.d;
      paramGameAdComData.g = paramAdGameComponentInfo.e;
      paramGameAdComData.j = paramAdGameComponentInfo.k;
      paramGameAdComData.k = paramAdGameComponentInfo.f;
      paramGameAdComData.l = paramAdGameComponentInfo.r;
      paramGameAdComData.jdField_m_of_type_JavaLangString = paramAdGameComponentInfo.jdField_q_of_type_JavaLangString;
      paramGameAdComData.n = paramAdGameComponentInfo.h;
      paramGameAdComData.o = paramAdGameComponentInfo.jdField_i_of_type_JavaLangString;
      paramGameAdComData.p = paramAdGameComponentInfo.jdField_m_of_type_JavaLangString;
      paramGameAdComData.jdField_q_of_type_JavaLangString = paramAdGameComponentInfo.n;
      paramGameAdComData.r = paramAdGameComponentInfo.g;
      paramGameAdComData.jdField_v_of_type_JavaLangString = paramAdGameComponentInfo.l;
      paramGameAdComData.y = paramAdGameComponentInfo.s;
      paramGameAdComData.x = paramAdGameComponentInfo.t;
      paramGameAdComData.z = paramAdGameComponentInfo.jdField_u_of_type_JavaLangString;
      paramGameAdComData.A = paramAdGameComponentInfo.jdField_v_of_type_JavaLangString;
      paramGameAdComData.w = paramAdGameComponentInfo.w;
      paramGameAdComData.B = paramAdGameComponentInfo.y;
      String str;
      if (paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo != null)
      {
        str = paramGameAdComData.jdField_u_of_type_JavaLangString;
        Object localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          ((JSONObject)localObject1).put("sActivityId", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.b);
          ((JSONObject)localObject1).put("sGiftName", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("sNeedRole", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.h);
          ((JSONObject)localObject1).put("iGiftId", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("gift_icon", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.c);
          ((JSONObject)localObject1).put("gift_desc", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g);
          ((JSONObject)localObject1).put("bag_item_icon_1", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.d);
          ((JSONObject)localObject1).put("bag_item_icon_2", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.e);
          ((JSONObject)localObject1).put("bag_item_icon_3", paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.f);
          paramGameAdComData.jdField_u_of_type_JavaLangString = ((JSONObject)localObject1).toString();
        }
        catch (Exception localException)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("parse gift info", localException.getMessage());
        }
      }
      try
      {
        str = paramGameAdComData.t;
        Object localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localObject2 = new JSONObject((String)localObject2);
        ((JSONObject)localObject2).put("sGameDownloadUrl", paramAdGameComponentInfo.p);
        ((JSONObject)localObject2).put("lGameSize", paramAdGameComponentInfo.jdField_q_of_type_JavaLangString);
        paramGameAdComData.t = ((JSONObject)localObject2).toString();
        return;
      }
      catch (Exception paramGameAdComData)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("parse download info", paramGameAdComData.getMessage());
      }
    }
  }
  
  private static void a(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
    if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString)))
    {
      paramAdvertisementInfo.mSoftAdType = 2;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.M)) {
        paramAdvertisementInfo.mAdBtnTxt = paramAdvertisementInfo.mAdvertisementSoftInfo.M;
      }
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
    }
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    int i = paramView.getHeight();
    paramView.getLocalVisibleRect(localRect);
    double d = localRect.height() * 1.0F / i;
    if (localRect.top < 0) {
      return false;
    }
    if (d < 0.5D) {
      return false;
    }
    if (d > 0.800000011920929D)
    {
      paramView = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramRect = new StringBuilder();
      paramRect.append("showpercentage = ");
      paramRect.append(d);
      paramView.d("VideoPlayerWrapper_AD", paramRect.toString());
      paramView = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramRect = new StringBuilder();
      paramRect.append(" top = ");
      paramRect.append(localRect.top);
      paramRect.append(" bottom = ");
      paramRect.append(localRect.bottom);
      paramView.d("VideoPlayerWrapper_AD", paramRect.toString());
      return true;
    }
    return false;
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    try
    {
      localObject2 = paramAdData.T;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = new JSONObject((String)localObject1);
      if (!TextUtils.isEmpty(paramAdData.E)) {
        ((JSONObject)localObject1).put("pkgurl", paramAdData.E);
      }
      if (!TextUtils.isEmpty(paramAdData.jdField_q_of_type_JavaLangString)) {
        ((JSONObject)localObject1).put("appname", paramAdData.jdField_q_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramAdData.D)) {
        ((JSONObject)localObject1).put("pkg_name", paramAdData.D);
      }
      if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo != null) {
        ((JSONObject)localObject1).put("appid", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.c);
      }
      paramAdvertisementInfo.mAdExt = ((JSONObject)localObject1).toString();
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("adData.mAdExt error:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("ReadInJoyBottomAdVideoUtil", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if ((paramAdData != null) && (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo != null)) {
      paramAdvertisementInfo.mAdDownloadApiUrl = paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  private static void b(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_e_of_type_Int;
    paramAdvertisementInfo.ecpm = paramAdData.jdField_a_of_type_Double;
    paramAdvertisementInfo.isContract = paramAdData.jdField_f_of_type_Int;
    paramAdvertisementInfo.mAdVideoUrl = paramAdData.w;
    paramAdvertisementInfo.adPosType = paramAdData.jdField_v_of_type_Int;
    paramAdvertisementInfo.mAdAid = paramAdData.jdField_b_of_type_Long;
    paramAdvertisementInfo.mAdTraceId = paramAdData.jdField_u_of_type_JavaLangString;
    paramAdvertisementInfo.mAdViewId = paramAdData.t;
    paramAdvertisementInfo.mAdProductId = paramAdData.z;
    paramAdvertisementInfo.mAdVia = paramAdData.A;
    paramAdvertisementInfo.mAdNocoId = paramAdData.jdField_d_of_type_Long;
    paramAdvertisementInfo.mAdApurl = paramAdData.o;
    paramAdvertisementInfo.mAdRl = paramAdData.jdField_m_of_type_JavaLangString;
    paramAdvertisementInfo.mAdEffectUrl = paramAdData.x;
    paramAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.y;
    paramAdvertisementInfo.mAdLandingPage = paramAdData.B;
    paramAdvertisementInfo.mAdCanvasJson = paramAdData.C;
    paramAdvertisementInfo.mAdDestType = paramAdData.g;
    paramAdvertisementInfo.mOrigin = 1;
    paramAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.F;
    paramAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.G;
    paramAdvertisementInfo.mChannelID = 2L;
    paramAdvertisementInfo.mAdProductType = paramAdData.jdField_d_of_type_Int;
    paramAdvertisementInfo.mADVideoAutoPlay = paramAdData.h;
    paramAdvertisementInfo.mAlgorithmID = paramAdData.jdField_e_of_type_Long;
    paramAdvertisementInfo.mAlgorithmGroup = paramAdData.jdField_f_of_type_Long;
    paramAdvertisementInfo.mC2SSwitch = paramAdData.jdField_i_of_type_Int;
    paramAdvertisementInfo.mC2SClickUrl = paramAdData.c;
    paramAdvertisementInfo.mC2SExposureUrl = paramAdData.jdField_d_of_type_JavaUtilArrayList;
    paramAdvertisementInfo.miniProgramType = paramAdData.jdField_m_of_type_Int;
    paramAdvertisementInfo.mPhoneComponetId = paramAdData.n;
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo != null) {
      paramAdvertisementInfo.mAdBtnTxt = paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.l;
    }
    try
    {
      paramAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.M);
    }
    catch (Exception localException)
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse article_id error :");
      localStringBuilder.append(localException.getMessage());
      localIRIJAdLogService.d("ReadInJoyBottomAdVideoUtil", localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramAdData.j)) {
      paramAdvertisementInfo.mTitle = paramAdData.j;
    }
    paramAdvertisementInfo.mAdLocalSource = a(paramAdData, paramAdvertisementInfo);
    if (!TextUtils.isEmpty(paramAdData.I)) {
      paramAdvertisementInfo.mAdCorporateImageName = paramAdData.I;
    } else {
      paramAdvertisementInfo.mAdCorporateImageName = paramAdData.jdField_q_of_type_JavaLangString;
    }
    paramAdvertisementInfo.mAdCorporateLogo = paramAdData.J;
    paramAdvertisementInfo.mSubordinateProductId = paramAdData.H;
    paramAdvertisementInfo.mPopFormH5Url = paramAdData.K;
    paramAdvertisementInfo.mShowAdButton = paramAdData.jdField_e_of_type_Boolean;
    paramAdvertisementInfo.mAdJumpMode = paramAdData.p;
    try
    {
      if (!TextUtils.isEmpty(paramAdData.jdField_i_of_type_JavaLangString)) {
        paramAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.jdField_i_of_type_JavaLangString).longValue();
      }
      return;
    }
    catch (Exception paramAdData) {}
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if (!TextUtils.isEmpty(paramAdData.U))
    {
      paramAdvertisementInfo.mAdExtInfo = paramAdData.U;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAdData.U);
        localJSONObject.put("AdSource", paramAdData.jdField_q_of_type_Int);
        localJSONObject.put("ad_switchs", paramAdData.jdField_v_of_type_JavaLangString);
        localJSONObject.put("jump_type", paramAdData.Z);
        boolean bool = FastWeqAdUtils.e(paramAdData);
        if (bool) {
          localJSONObject.put("game_button_type", 2);
        } else if (FastWeqAdUtils.c(paramAdData)) {
          localJSONObject.put("game_button_type", 3);
        } else if (FastWeqAdUtils.d(paramAdData)) {
          localJSONObject.put("game_button_type", 1);
        } else if (FastWeqAdUtils.f(paramAdData)) {
          localJSONObject.put("game_button_type", 4);
        } else if (FastWeqAdUtils.g(paramAdData)) {
          localJSONObject.put("game_button_type", 6);
        }
        if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo != null)
        {
          localJSONObject.put("game_pkg_name", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.b);
          localJSONObject.put("game_adtag", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.o);
          localJSONObject.put("game_app_id", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.e);
          localJSONObject.put("game_app_name", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("game_apk_url", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.p);
        }
        paramAdvertisementInfo.mAdExtInfo = localJSONObject.toString();
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        if (QLog.isColorLevel())
        {
          paramAdData = new StringBuilder();
          paramAdData.append("adData.mAdExtInfo error:");
          paramAdData.append(paramAdvertisementInfo.getMessage());
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, paramAdData.toString());
        }
      }
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    Object localObject;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData))
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
      localObject = new GameAdComData(paramAdData.N, (JSONObject)localObject);
      a((GameAdComData)localObject, paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo);
      paramAdvertisementInfo.gameAdComData = ((GameAdComData)localObject);
      paramAdvertisementInfo.mSoftAdType = 1;
      if (paramAdvertisementInfo.gameAdComData.s.equals("2")) {
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
      paramAdvertisementInfo.mBusiJson.put("article_id", paramAdData.M);
      paramAdvertisementInfo.mBusiJson.put("rowkey", paramAdData.N);
      if ((!TextUtils.isEmpty(paramAdData.O)) && (!paramAdData.O.contains("%"))) {
        paramAdvertisementInfo.mBusiJson.put("tags", paramAdData.O);
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.x);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.b);
      }
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
        return;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil
 * JD-Core Version:    0.7.0.1
 */