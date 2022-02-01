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
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyBottomAdVideoUtil
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdData.aP != 10) {
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.n)) {
      paramAdvertisementInfo.mSinglePicture = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAdData.n, 4);
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
    if (paramAdData.j != null) {
      return paramAdData.j;
    }
    localObject1 = new AdvertisementInfo();
    c(paramAdData, (AdvertisementInfo)localObject1);
    b((AdvertisementInfo)localObject1, paramAdData);
    c((AdvertisementInfo)localObject1, paramAdData);
    d((AdvertisementInfo)localObject1, paramAdData);
    e((AdvertisementInfo)localObject1, paramAdData);
    ((AdvertisementInfo)localObject1).mAdvertisementExtInfo = new AdvertisementExtInfo(((AdvertisementInfo)localObject1).mAdExtInfo);
    if (paramAdData.aE != null)
    {
      b(paramAdData, (AdvertisementInfo)localObject1);
      a((AdvertisementInfo)localObject1, paramAdData);
    }
    ((AdvertisementInfo)localObject1).liujinReportUrl = paramAdData.aI;
    ((AdvertisementInfo)localObject1).ticket = paramAdData.aJ;
    ((AdvertisementInfo)localObject1).amsNfbUrl = paramAdData.aK;
    ((AdvertisementInfo)localObject1).packageName = paramAdData.k();
    ((AdvertisementInfo)localObject1).mAdMaterialId = paramAdData.l();
    ((AdvertisementInfo)localObject1).originalExposureUrl = paramAdData.aO;
    localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("end : ");
    localStringBuilder.append(System.currentTimeMillis());
    ((IRIJAdLogService)localObject2).d("ReadInJoyBottomAdVideoUtil", localStringBuilder.toString());
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isBottomAd(paramAdData)) {
      ((AdvertisementInfo)localObject1).isBottomAd = true;
    }
    paramAdData.j = ((AdvertisementInfo)localObject1);
    return localObject1;
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if ((paramAdvertisementInfo != null) && (paramAdData != null) && (paramAdData.aE != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      if (paramAdData.aC == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramAdData.aE;
        boolean bool = false;
        if (((JSONObject)localObject).optInt("sourceId", 0) == 8) {
          bool = true;
        }
        paramAdvertisementInfo.isKolGame = bool;
        JSONObject localJSONObject = paramAdData.aC;
        if (!paramAdvertisementInfo.isKolGame) {
          break label123;
        }
        localObject = "2";
        localJSONObject.put("obj_type", localObject);
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.aC.toString());
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
      paramGameAdComData.b = String.valueOf(paramAdGameComponentInfo.a);
      paramGameAdComData.t = paramAdGameComponentInfo.y;
      paramGameAdComData.e = paramAdGameComponentInfo.c;
      paramGameAdComData.d = paramAdGameComponentInfo.b;
      paramGameAdComData.f = paramAdGameComponentInfo.d;
      paramGameAdComData.g = paramAdGameComponentInfo.e;
      paramGameAdComData.h = paramAdGameComponentInfo.f;
      paramGameAdComData.k = paramAdGameComponentInfo.l;
      paramGameAdComData.l = paramAdGameComponentInfo.g;
      paramGameAdComData.m = paramAdGameComponentInfo.s;
      paramGameAdComData.n = paramAdGameComponentInfo.r;
      paramGameAdComData.o = paramAdGameComponentInfo.i;
      paramGameAdComData.p = paramAdGameComponentInfo.j;
      paramGameAdComData.q = paramAdGameComponentInfo.n;
      paramGameAdComData.r = paramAdGameComponentInfo.o;
      paramGameAdComData.s = paramAdGameComponentInfo.h;
      paramGameAdComData.w = paramAdGameComponentInfo.m;
      paramGameAdComData.z = paramAdGameComponentInfo.t;
      paramGameAdComData.y = paramAdGameComponentInfo.u;
      paramGameAdComData.A = paramAdGameComponentInfo.v;
      paramGameAdComData.B = paramAdGameComponentInfo.w;
      paramGameAdComData.x = paramAdGameComponentInfo.x;
      paramGameAdComData.C = paramAdGameComponentInfo.z;
      String str;
      if (paramAdGameComponentInfo.B != null)
      {
        str = paramGameAdComData.v;
        Object localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          ((JSONObject)localObject1).put("sActivityId", paramAdGameComponentInfo.B.c);
          ((JSONObject)localObject1).put("sGiftName", paramAdGameComponentInfo.B.b);
          ((JSONObject)localObject1).put("sNeedRole", paramAdGameComponentInfo.B.i);
          ((JSONObject)localObject1).put("iGiftId", paramAdGameComponentInfo.B.a);
          ((JSONObject)localObject1).put("gift_icon", paramAdGameComponentInfo.B.d);
          ((JSONObject)localObject1).put("gift_desc", paramAdGameComponentInfo.B.h);
          ((JSONObject)localObject1).put("bag_item_icon_1", paramAdGameComponentInfo.B.e);
          ((JSONObject)localObject1).put("bag_item_icon_2", paramAdGameComponentInfo.B.f);
          ((JSONObject)localObject1).put("bag_item_icon_3", paramAdGameComponentInfo.B.g);
          paramGameAdComData.v = ((JSONObject)localObject1).toString();
        }
        catch (Exception localException)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("parse gift info", localException.getMessage());
        }
      }
      try
      {
        str = paramGameAdComData.u;
        Object localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localObject2 = new JSONObject((String)localObject2);
        ((JSONObject)localObject2).put("sGameDownloadUrl", paramAdGameComponentInfo.q);
        ((JSONObject)localObject2).put("lGameSize", paramAdGameComponentInfo.r);
        paramGameAdComData.u = ((JSONObject)localObject2).toString();
        return;
      }
      catch (Exception paramGameAdComData)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("parse download info", paramGameAdComData.getMessage());
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
      localObject2 = paramAdData.aw;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = new JSONObject((String)localObject1);
      if (!TextUtils.isEmpty(paramAdData.Q)) {
        ((JSONObject)localObject1).put("pkgurl", paramAdData.Q);
      }
      if (!TextUtils.isEmpty(paramAdData.u)) {
        ((JSONObject)localObject1).put("appname", paramAdData.u);
      }
      if (!TextUtils.isEmpty(paramAdData.P)) {
        ((JSONObject)localObject1).put("pkg_name", paramAdData.P);
      }
      if (paramAdData.an != null) {
        ((JSONObject)localObject1).put("appid", paramAdData.an.c);
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
    if ((paramAdData != null) && (paramAdData.an != null)) {
      paramAdvertisementInfo.mAdDownloadApiUrl = paramAdData.an.a;
    }
  }
  
  private static void b(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.processSoftDataInfo(paramAdData.aE);
    if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.e)))
    {
      paramAdvertisementInfo.mSoftAdType = 2;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.W)) {
        paramAdvertisementInfo.mAdBtnTxt = paramAdvertisementInfo.mAdvertisementSoftInfo.W;
      }
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.q == 1) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if (!TextUtils.isEmpty(paramAdData.ay))
    {
      paramAdvertisementInfo.mAdExtInfo = paramAdData.ay;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAdData.ay);
        localJSONObject.put("AdSource", paramAdData.aB);
        localJSONObject.put("ad_switchs", paramAdData.F);
        localJSONObject.put("jump_type", paramAdData.aL);
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
        if (paramAdData.as != null)
        {
          localJSONObject.put("game_pkg_name", paramAdData.as.c);
          localJSONObject.put("game_adtag", paramAdData.as.p);
          localJSONObject.put("game_app_id", paramAdData.as.f);
          localJSONObject.put("game_app_name", paramAdData.as.b);
          localJSONObject.put("game_apk_url", paramAdData.as.q);
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
  
  private static void c(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.mAdAdvertiseId = paramAdData.y;
    paramAdvertisementInfo.ecpm = paramAdData.z;
    paramAdvertisementInfo.isContract = paramAdData.A;
    paramAdvertisementInfo.mAdVideoUrl = paramAdData.G;
    paramAdvertisementInfo.adPosType = paramAdData.aT;
    paramAdvertisementInfo.mAdAid = paramAdData.J;
    paramAdvertisementInfo.mAdTraceId = paramAdData.D;
    paramAdvertisementInfo.mAdViewId = paramAdData.C;
    paramAdvertisementInfo.mAdProductId = paramAdData.K;
    paramAdvertisementInfo.mAdVia = paramAdData.L;
    paramAdvertisementInfo.mAdNocoId = paramAdData.V;
    paramAdvertisementInfo.mAdApurl = paramAdData.r;
    paramAdvertisementInfo.mAdRl = paramAdData.p;
    paramAdvertisementInfo.mAdEffectUrl = paramAdData.H;
    paramAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.I;
    paramAdvertisementInfo.mAdLandingPage = paramAdData.M;
    paramAdvertisementInfo.mAdCanvasJson = paramAdData.N;
    paramAdvertisementInfo.mAdDestType = paramAdData.O;
    paramAdvertisementInfo.mOrigin = 1;
    paramAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.S;
    paramAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.T;
    paramAdvertisementInfo.mChannelID = 2L;
    paramAdvertisementInfo.mAdProductType = paramAdData.s;
    paramAdvertisementInfo.mADVideoAutoPlay = paramAdData.W;
    paramAdvertisementInfo.mAlgorithmID = paramAdData.Y;
    paramAdvertisementInfo.mAlgorithmGroup = paramAdData.Z;
    paramAdvertisementInfo.mCToSSwitch = paramAdData.ae;
    paramAdvertisementInfo.mCToSClickUrl = paramAdData.af;
    paramAdvertisementInfo.mCToSExposureUrl = paramAdData.ag;
    paramAdvertisementInfo.miniProgramType = paramAdData.ar;
    paramAdvertisementInfo.mPhoneComponetId = paramAdData.av;
    if (paramAdData.as != null) {
      paramAdvertisementInfo.mAdBtnTxt = paramAdData.as.m;
    }
    try
    {
      paramAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.ai);
    }
    catch (Exception localException)
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse article_id error :");
      localStringBuilder.append(localException.getMessage());
      localIRIJAdLogService.d("ReadInJoyBottomAdVideoUtil", localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramAdData.l)) {
      paramAdvertisementInfo.mTitle = paramAdData.l;
    }
    paramAdvertisementInfo.mAdLocalSource = a(paramAdData, paramAdvertisementInfo);
    if (!TextUtils.isEmpty(paramAdData.X)) {
      paramAdvertisementInfo.mAdCorporateImageName = paramAdData.X;
    } else {
      paramAdvertisementInfo.mAdCorporateImageName = paramAdData.u;
    }
    paramAdvertisementInfo.mAdCorporateLogo = paramAdData.aa;
    paramAdvertisementInfo.mSubordinateProductId = paramAdData.U;
    paramAdvertisementInfo.mPopFormH5Url = paramAdData.ac;
    paramAdvertisementInfo.mShowAdButton = paramAdData.ad;
    paramAdvertisementInfo.mAdJumpMode = paramAdData.aA;
    try
    {
      if (!TextUtils.isEmpty(paramAdData.k)) {
        paramAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.k).longValue();
      }
      return;
    }
    catch (Exception paramAdData) {}
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
      localObject = new GameAdComData(paramAdData.aj, (JSONObject)localObject);
      a((GameAdComData)localObject, paramAdData.as);
      paramAdvertisementInfo.gameAdComData = ((GameAdComData)localObject);
      paramAdvertisementInfo.mSoftAdType = 1;
      if (paramAdvertisementInfo.gameAdComData.t.equals("2")) {
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
      paramAdvertisementInfo.mBusiJson.put("article_id", paramAdData.ai);
      paramAdvertisementInfo.mBusiJson.put("rowkey", paramAdData.aj);
      if ((!TextUtils.isEmpty(paramAdData.ak)) && (!paramAdData.ak.contains("%"))) {
        paramAdvertisementInfo.mBusiJson.put("tags", paramAdData.ak);
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.as.y);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.as.c);
      }
      if (paramAdData.aC != null)
      {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.aC.toString());
        return;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil
 * JD-Core Version:    0.7.0.1
 */