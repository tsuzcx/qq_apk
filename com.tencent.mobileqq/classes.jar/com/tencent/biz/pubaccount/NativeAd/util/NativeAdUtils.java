package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AttachedAdData;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo.SmallMiniGameData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.base.MD5;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAdUtils
{
  public static int a;
  static volatile String b;
  
  public static double a(double[] paramArrayOfDouble, Context paramContext)
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      double d1 = paramArrayOfDouble[0];
      double d2 = paramArrayOfDouble[1];
      double d3 = localSosoLbsInfo.mLocation.mLat02;
      double d4 = localSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel())
      {
        paramArrayOfDouble = new StringBuilder();
        paramArrayOfDouble.append("getADPosition cached latitude =  ");
        paramArrayOfDouble.append(d3);
        paramArrayOfDouble.append(" longitude = ");
        paramArrayOfDouble.append(d4);
        paramArrayOfDouble.append(" adLatitude = ");
        paramArrayOfDouble.append(d1);
        paramArrayOfDouble.append(" adLongitude = ");
        paramArrayOfDouble.append(d2);
        QLog.d("NativeAdUtils", 2, paramArrayOfDouble.toString());
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D))
      {
        if (d2 >= 180.0D) {
          return 0.0D;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        b(paramContext);
        return 0.0D;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
    return 0.0D;
  }
  
  public static int a()
  {
    int i = HwNetworkUtil.getCarrierOperatorType(BaseApplicationImpl.getContext());
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }
  
  public static int a(Context paramContext, BannerInfo paramBannerInfo)
  {
    if (paramContext != null)
    {
      if (paramBannerInfo == null) {
        return -1;
      }
      paramContext = paramBannerInfo.h;
      paramBannerInfo = paramBannerInfo.f;
      Object localObject;
      if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramBannerInfo)))
      {
        localObject = DownloadManager.b().d(paramBannerInfo);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isPkgDownloading pkg:");
            ((StringBuilder)localObject).append(paramContext);
            ((StringBuilder)localObject).append(", appid:");
            ((StringBuilder)localObject).append(paramBannerInfo);
            ((StringBuilder)localObject).append(" false");
            QLog.d("NativeAdUtils", 2, ((StringBuilder)localObject).toString());
          }
          return -1;
        }
        if (((DownloadInfo)localObject).a() == 2)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isPkgDownloading pkg:");
            localStringBuilder.append(paramContext);
            localStringBuilder.append(", appid:");
            localStringBuilder.append(paramBannerInfo);
            localStringBuilder.append(" true");
            QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
          }
          return ((DownloadInfo)localObject).t;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isPkgDownloading pkg:");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(", appid:");
          ((StringBuilder)localObject).append(paramBannerInfo);
          ((StringBuilder)localObject).append(" false");
          QLog.d("NativeAdUtils", 2, ((StringBuilder)localObject).toString());
        }
        return -1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isPkgDownloading pkg:");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(", appid:");
        ((StringBuilder)localObject).append(paramBannerInfo);
        ((StringBuilder)localObject).append(" false");
        QLog.d("NativeAdUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData)) {
      return 25;
    }
    if (paramAdData.j()) {
      return 35;
    }
    return 1;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131953338);
    paramContext.setContentView(2131624587);
    TextView localTextView = (TextView)paramContext.findViewById(2131431880);
    if (localTextView != null) {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      } else {
        localTextView.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131431876);
    if (paramString1 != null) {
      if (paramString4 != null) {
        paramString1.setText(paramString4);
      } else {
        paramString1.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131431864);
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
      else
      {
        paramString1.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131431870);
    if (paramString1 != null) {
      if (paramString3 != null)
      {
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null)
        {
          paramString1.setOnClickListener(paramOnClickListener2);
          return paramContext;
        }
      }
      else
      {
        paramString1.setVisibility(8);
      }
    }
    return paramContext;
  }
  
  public static VideoAdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdInfo localVideoAdInfo = new VideoAdInfo();
    if (paramAdvertisementInfo != null)
    {
      localVideoAdInfo.a = paramAdvertisementInfo.mAdFetchTime;
      localVideoAdInfo.b = paramAdvertisementInfo.mAdPosLayout;
      localVideoAdInfo.c = paramAdvertisementInfo.mAdPosID;
      localVideoAdInfo.d = paramAdvertisementInfo.mChannelID;
      localVideoAdInfo.e = paramAdvertisementInfo.mAdKdPos;
      localVideoAdInfo.f = paramAdvertisementInfo.mAdCl;
      localVideoAdInfo.g = paramAdvertisementInfo.mAdImg;
      localVideoAdInfo.h = paramAdvertisementInfo.mAdImgs;
      localVideoAdInfo.i = paramAdvertisementInfo.mAdTxt;
      localVideoAdInfo.j = paramAdvertisementInfo.mAdDesc;
      localVideoAdInfo.k = paramAdvertisementInfo.mAdRl;
      localVideoAdInfo.l = paramAdvertisementInfo.mAdApurl;
      localVideoAdInfo.m = paramAdvertisementInfo.mAdTraceId;
      localVideoAdInfo.n = paramAdvertisementInfo.mAdProductId;
      localVideoAdInfo.o = paramAdvertisementInfo.mAdProductType;
      localVideoAdInfo.p = paramAdvertisementInfo.mAdType;
      localVideoAdInfo.r = paramAdvertisementInfo.mAdLandingPage;
      localVideoAdInfo.s = paramAdvertisementInfo.mAdPrice;
      localVideoAdInfo.t = paramAdvertisementInfo.mAdBtnTxt;
      localVideoAdInfo.u = paramAdvertisementInfo.mAdViewId;
      localVideoAdInfo.v = paramAdvertisementInfo.mAdCustomizedInvokeUrl;
      localVideoAdInfo.w = paramAdvertisementInfo.mAdCorporationName;
      localVideoAdInfo.x = paramAdvertisementInfo.mAdCorporateImageName;
      localVideoAdInfo.y = paramAdvertisementInfo.mAdCorporateLogo;
      localVideoAdInfo.z = paramAdvertisementInfo.mAdUin;
      localVideoAdInfo.A = paramAdvertisementInfo.mAdExt;
      localVideoAdInfo.B = paramAdvertisementInfo.mAdVideoUrl;
      localVideoAdInfo.C = paramAdvertisementInfo.mAdCostType;
      localVideoAdInfo.G = paramAdvertisementInfo.mAdAid;
      localVideoAdInfo.H = paramAdvertisementInfo.mAdLayout;
      localVideoAdInfo.I = paramAdvertisementInfo.mAdMaterialId;
      localVideoAdInfo.L = paramAdvertisementInfo.mAdVia;
      localVideoAdInfo.R = paramAdvertisementInfo.mAdExtInfo;
      localVideoAdInfo.S = paramAdvertisementInfo.mAdJumpMode;
      localVideoAdInfo.T = paramAdvertisementInfo.mAdAppJson;
      localVideoAdInfo.W = paramAdvertisementInfo.mAdAppDownLoadSchema;
      localVideoAdInfo.X = paramAdvertisementInfo.mAdCanvasJson;
      localVideoAdInfo.Y = paramAdvertisementInfo.mAdLandingPageReportUrl;
      localVideoAdInfo.Z = paramAdvertisementInfo.mAdAdvertiseId;
      localVideoAdInfo.aa = paramAdvertisementInfo.mAdDestType;
      localVideoAdInfo.ab = paramAdvertisementInfo.mAdEffectUrl;
      localVideoAdInfo.ac = paramAdvertisementInfo.mAdNocoId;
      localVideoAdInfo.ad = paramAdvertisementInfo.mAdDownloadApiUrl;
      localVideoAdInfo.af = paramAdvertisementInfo.mCToSSwitch;
      localVideoAdInfo.ag = paramAdvertisementInfo.mCToSClickUrl;
      localVideoAdInfo.ah = paramAdvertisementInfo.mCToSExposureUrl;
      localVideoAdInfo.ak = paramAdvertisementInfo.replay;
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos;
      if ((paramAdvertisementInfo != null) && (!paramAdvertisementInfo.isEmpty()))
      {
        localVideoAdInfo.P = new ArrayList(paramAdvertisementInfo.size());
        int i = 0;
        while (i < paramAdvertisementInfo.size())
        {
          AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.get(i);
          VideoAdInfo.NegFeedback localNegFeedback = new VideoAdInfo.NegFeedback();
          localNegFeedback.b = localAdDislikeInfo.c;
          localNegFeedback.a = localAdDislikeInfo.e;
          localVideoAdInfo.P.add(localNegFeedback);
          i += 1;
        }
      }
      localVideoAdInfo.a(localVideoAdInfo.R);
      localVideoAdInfo.c(localVideoAdInfo.R);
      localVideoAdInfo.b(localVideoAdInfo.R);
    }
    return localVideoAdInfo;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return "";
    }
    paramDouble = Math.ceil(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDouble < 1000.0D)
    {
      localStringBuilder.append((int)paramDouble);
      localStringBuilder.append('m');
    }
    else
    {
      long l = Math.round(paramDouble / 1000.0D);
      if (l < 1000L)
      {
        localStringBuilder.append(l);
        localStringBuilder.append("km");
      }
      else
      {
        localStringBuilder.append("999km");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    double d = b(paramAbsBaseArticleInfo, paramContext, paramString1, paramString2);
    if (d > 0.0D) {
      return a(d);
    }
    return null;
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, false);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, false, paramBoolean);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt2)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bt", paramInt1);
      localJSONObject.put("et", paramInt2);
      localJSONObject.put("bf", paramInt3);
      localJSONObject.put("ef", paramInt4);
      localJSONObject.put("pp", paramInt8);
      localJSONObject.put("pa", paramInt5);
      localJSONObject.put("pb", paramInt6);
      localJSONObject.put("duration", paramInt7);
      localJSONObject.put("ps", paramInt9);
      if (paramVideoEndType == null) {
        paramInt1 = ReportConstants.VideoEndType.NORMAL_COMPLETE.getValue();
      } else {
        paramInt1 = paramVideoEndType.getValue();
      }
      localJSONObject.put("videoEndType", paramInt1);
      localJSONObject.put("isVideoFeedsRecommend", paramBoolean2);
      localJSONObject.put("videoReplayCount", paramInt10);
      localJSONObject.put("isClickReplay", paramBoolean1);
      return localJSONObject;
    }
    catch (JSONException paramVideoEndType)
    {
      paramVideoEndType.printStackTrace();
    }
    return null;
  }
  
  private static JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dma", AdDeviceInfoUtil.d());
      localJSONObject.put("hwm", DeviceInfoUtil.u());
      localJSONObject.put("hwma", DeviceInfoUtil.t());
      localJSONObject.put("osver", DeviceInfoUtil.g());
      localJSONObject.put("imei", AdDeviceInfoUtil.a());
      localJSONObject.put("brd", DeviceInfoUtil.w());
      localJSONObject.put("ns", HttpUtil.getNetWorkTypeByStr());
      localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      localJSONObject.put("mid", "mid");
      localJSONObject.put("pf", "android");
      localJSONObject.put("wn", NetworkUtils.e(paramContext));
      String str = "";
      int i = a();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            str = HardCodeUtil.a(2131904938);
          }
        }
        else {
          str = HardCodeUtil.a(2131904940);
        }
      }
      else {
        str = HardCodeUtil.a(2131904942);
      }
      localJSONObject.put("mnc", str);
      localJSONObject.put("rma", ((IRIJNetworkUtils)QRoute.api(IRIJNetworkUtils.class)).getWifiMacAddress(paramContext));
      return localJSONObject;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {
      localJSONObject = b(paramAdvertisementInfo);
    }
    return ReadInJoyJsonUtil.a(new JSONObject[] { localJSONObject, a(paramHashMap) });
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", a(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "8.8.17");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 == 1) {
          paramQQAppInterface = paramAdData.p;
        } else {
          paramQQAppInterface = paramAdData.r;
        }
        localJSONObject.put("ext", paramQQAppInterface);
        localJSONObject.put("oudid", paramAdData.x);
        boolean bool = paramAdData instanceof AttachedAdData;
        if (bool)
        {
          localJSONObject.put("aname", paramAdData.l);
          localJSONObject.put("posid", paramAdData.y);
        }
        else
        {
          localJSONObject.put("aname", paramAdData.u);
          localJSONObject.put("posid", paramAdData.k);
        }
      }
      if (paramJSONObject != null)
      {
        localJSONObject.put("exposureExtraInfo", paramJSONObject);
        return localJSONObject;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdData paramAdData, HashMap<String, Object> paramHashMap)
  {
    return ReadInJoyJsonUtil.a(new JSONObject[] { b(paramAdData), a(paramHashMap) });
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("tags", paramString3);
      }
      if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        localJSONObject.put("game_component_type", paramString4);
        localJSONObject.put("game_pkg", paramString5);
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramString1 = paramHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramString3 = paramHashMap.get(paramString2);
          if (paramString3 != null) {
            localJSONObject.put(paramString2, paramString3);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramHashMap != null) {}
    try
    {
      if (paramHashMap.size() > 0)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = paramHashMap.get(str);
          if (localObject != null) {
            localJSONObject.put(str, localObject);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramHashMap) {}
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity, BannerInfo paramBannerInfo, DownloadListener paramDownloadListener)
  {
    if (paramActivity != null)
    {
      if (paramBannerInfo == null) {
        return;
      }
      String str1 = paramBannerInfo.h;
      String str2 = paramBannerInfo.f;
      String str3 = paramBannerInfo.l;
      paramBannerInfo = paramBannerInfo.k;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        if (TextUtils.isEmpty(paramBannerInfo)) {
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString(DownloadConstants.f, str1);
        localBundle.putString(DownloadConstants.b, str2);
        localBundle.putString(DownloadConstants.j, str3);
        localBundle.putString(DownloadConstants.l, paramBannerInfo);
        localBundle.putInt(DownloadConstants.k, 2);
        localBundle.putInt(DownloadConstants.G, 0);
        localBundle.putBoolean(DownloadConstants.y, false);
        localBundle.putInt(DownloadConstants.J, 0);
        localBundle.putBoolean(DownloadConstants.z, true);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadApk pkg:");
          localStringBuilder.append(str1);
          localStringBuilder.append(", appid:");
          localStringBuilder.append(str2);
          localStringBuilder.append(", name:");
          localStringBuilder.append(paramBannerInfo);
          localStringBuilder.append(", url:");
          localStringBuilder.append(str3);
          QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
        }
        if (paramDownloadListener != null) {
          DownloadManager.b().a(paramDownloadListener);
        }
        DownloadApi.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
      }
    }
  }
  
  public static void a(Context paramContext, AdReportExtData paramAdReportExtData)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page_id", paramAdReportExtData.a);
      localJSONObject.put("oper_module", paramAdReportExtData.b);
      localJSONObject.put("oper_id", paramAdReportExtData.c);
      localJSONObject.put("oper_type", paramAdReportExtData.d);
      localJSONObject.put("obj_id", paramAdReportExtData.e);
      localJSONObject.put("obj_type", paramAdReportExtData.f);
      localJSONObject.put("game_pkg", paramAdReportExtData.g);
      localJSONObject.put("app_id", paramAdReportExtData.h);
      localJSONObject.put("ex1", paramAdReportExtData.i);
      localJSONObject.put("ex2", paramAdReportExtData.j);
      localJSONObject.put("ex3", paramAdReportExtData.k);
      localJSONObject.put("ex4", paramAdReportExtData.l);
      localJSONObject.put("loc_id", paramAdReportExtData.m);
      paramAdReportExtData = new JSONObject();
      paramAdReportExtData.put("game_gift_report", String.valueOf(localJSONObject));
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(119).b(39).b(Integer.valueOf(6)).e(paramAdReportExtData));
      return;
    }
    catch (Exception paramContext)
    {
      b("reportMiniGameAd error :", paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null)
        {
          Object localObject = paramAbsBaseArticleInfo.mSmallMiniGameInfo.m;
          boolean bool = ReadInJoyAdUtils.j(paramAbsBaseArticleInfo);
          long l2 = 0L;
          if (bool)
          {
            l2 = 50404L;
            if (paramInt2 != 1) {
              break label346;
            }
            l1 = 5040402L;
          }
          else if (ReadInJoyAdUtils.h(paramAbsBaseArticleInfo))
          {
            l2 = 50403L;
            if (paramInt2 != 1) {
              break label354;
            }
            l1 = 5040302L;
          }
          else if (ReadInJoyAdUtils.k(paramAbsBaseArticleInfo))
          {
            l2 = 50402L;
            if (paramInt2 != 1) {
              break label362;
            }
            l1 = 5040202L;
          }
          else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo))
          {
            l2 = 50406L;
            if (paramInt2 != 1) {
              break label370;
            }
            l1 = 5040602L;
          }
          else
          {
            if (!ReadInJoyAdUtils.i(paramAbsBaseArticleInfo)) {
              break label386;
            }
            l2 = 50401L;
            if (paramInt2 != 1) {
              break label378;
            }
            l1 = 5040104L;
          }
          localObject = new AdReportExtData.Builder().a(504L).b(l2).c(l1).d((String)localObject);
          if (paramInt2 != 1) {
            break label392;
          }
          l1 = 3L;
          AdReportExtData.Builder localBuilder = ((AdReportExtData.Builder)localObject).d(l1).a(paramAbsBaseArticleInfo.innerUniqueID).b(paramAbsBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo)) {
            localObject = paramAbsBaseArticleInfo.mSmallMiniGameInfo.r;
          } else {
            localObject = paramAbsBaseArticleInfo.mSubscribeName;
          }
          localObject = localBuilder.c((String)localObject);
          if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramAbsBaseArticleInfo.mArticleContentUrl)) {
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mArticleContentUrl;
          } else {
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSmallMiniGameInfo.n;
          }
          a(paramContext, ((AdReportExtData.Builder)localObject).g(paramAbsBaseArticleInfo).a());
          return;
        }
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
      }
      return;
      label346:
      long l1 = 5040401L;
      continue;
      label354:
      l1 = 5040301L;
      continue;
      label362:
      l1 = 5040201L;
      continue;
      label370:
      l1 = 5040601L;
      continue;
      label378:
      l1 = 5040103L;
      continue;
      label386:
      l1 = 0L;
      continue;
      label392:
      l1 = 6L;
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if ((paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.y != null))
        {
          if (paramInt3 != 2) {
            break label208;
          }
          l = 5010103L;
          if (!paramAbsBaseArticleInfo.mSmallMiniGameInfo.a()) {
            break label216;
          }
          str = "3";
          Object localObject = null;
          SmallMiniGameInfo.SmallMiniGameData localSmallMiniGameData = (SmallMiniGameInfo.SmallMiniGameData)paramAbsBaseArticleInfo.mSmallMiniGameInfo.y.get(paramInt2);
          paramAbsBaseArticleInfo = localObject;
          if (localSmallMiniGameData != null)
          {
            paramAbsBaseArticleInfo = new AdReportExtData.Builder().a(501L).b(50101L).c(l);
            if (paramInt3 != 1) {
              break label224;
            }
            l = 3L;
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.d(l).d(localSmallMiniGameData.a).i(String.valueOf(paramInt1)).c(localSmallMiniGameData.d).e(localSmallMiniGameData.c).f(String.valueOf(paramInt2 + 1)).g(localSmallMiniGameData.b).h(str).a();
          }
          if (paramAbsBaseArticleInfo != null)
          {
            a(paramContext, paramAbsBaseArticleInfo);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
      }
      return;
      label208:
      long l = 5010104L;
      continue;
      label216:
      String str = "2";
      continue;
      label224:
      l = 6L;
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo.mSmallMiniGameInfo == null) {
      return;
    }
    Object localObject = paramAbsBaseArticleInfo.mSmallMiniGameInfo.m;
    localObject = new AdReportExtData.Builder().a(504L).b(50407L).c(paramInt2).d((String)localObject);
    long l;
    if (paramBoolean) {
      l = 9L;
    } else {
      l = 6L;
    }
    AdReportExtData.Builder localBuilder = ((AdReportExtData.Builder)localObject).d(l).a(paramAbsBaseArticleInfo.innerUniqueID).b(paramAbsBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo)) {
      localObject = paramAbsBaseArticleInfo.mSmallMiniGameInfo.r;
    } else {
      localObject = paramAbsBaseArticleInfo.mSubscribeName;
    }
    localObject = localBuilder.c((String)localObject);
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramAbsBaseArticleInfo.mArticleContentUrl)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mArticleContentUrl;
    } else {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSmallMiniGameInfo.n;
    }
    a(paramContext, ((AdReportExtData.Builder)localObject).g(paramAbsBaseArticleInfo).a());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, AdvertisementInfo paramAdvertisementInfo, float paramFloat, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("article_id", String.valueOf(paramAdvertisementInfo.mArticleID));
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mRowKey)) {
      localHashMap.put("rowkey", paramAdvertisementInfo.mRowKey);
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(paramInt).a(paramAdvertisementInfo).c(localJSONObject).d(a(localHashMap)));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (ReadInJoyAdSwitchUtil.a(paramAdData))
    {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(81).b(a(paramAdData)).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData)).d(b(paramAdData)));
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 81, 1, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    boolean bool = ReadInJoyAdSwitchUtil.a(paramAdData);
    int i = 1;
    if (bool)
    {
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
      if (localAdvertisementInfo == null) {
        return;
      }
      if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(localAdvertisementInfo))
      {
        GamesComponentAdDelegate.a(paramAdData);
        return;
      }
      IRIJAdService localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
      paramQQAppInterface = new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(localAdvertisementInfo).c(localJSONObject).d(b(paramAdData));
      if (paramBoolean) {
        i = 2;
      }
      localIRIJAdService.report(paramQQAppInterface.a(Integer.valueOf(i)).b(paramBoolean));
      return;
    }
    if (paramBoolean) {
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, localJSONObject).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt, Integer paramInteger)
  {
    if (ReadInJoyAdSwitchUtil.a(paramAdData, false))
    {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(1).b(paramInteger).b(1).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData)).d(b(paramAdData)).c(paramInt));
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 1, 3, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, Integer paramInteger)
  {
    a(paramQQAppInterface, paramAdData, 0, paramInteger);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramAdData == null) {
        return;
      }
      boolean bool = ReadInJoyAdSwitchUtil.a(paramAdData);
      int i = 1;
      if (bool)
      {
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
        if (localAdvertisementInfo == null) {
          return;
        }
        if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(localAdvertisementInfo))
        {
          GamesComponentAdDelegate.a(paramAdData);
        }
        else
        {
          IRIJAdService localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
          paramQQAppInterface = new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(localAdvertisementInfo).d(b(paramAdData));
          if (paramBoolean) {
            i = 2;
          }
          localIRIJAdService.report(paramQQAppInterface.a(Integer.valueOf(i)).b(paramBoolean));
        }
      }
      else
      {
        if (paramBoolean) {
          return;
        }
        a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, null).toString());
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" reportNativeEngineAdExposure ");
      paramQQAppInterface.append(paramAdData.l);
      paramQQAppInterface.append("  : ");
      paramQQAppInterface.append(paramAdData.m);
      QLog.d("Q.readinjoy.fast_web", 2, paramQQAppInterface.toString());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      b("nativeEngineAdReport json:", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.data.set(paramString);
        paramString = new NewIntent(paramQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report");
        paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
        paramString.setObserver(new NativeAdUtils.2());
        paramQQAppInterface.startServlet(paramString);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramQQAppInterface.getCurrentUin());
      localJSONObject.put("adId", paramString1);
      localJSONObject.put("channelId", paramString2);
      localJSONObject.put("info", paramString3);
      localJSONObject.put("version", "8.8.17");
      localJSONObject.put("actionCode", paramInt1);
      localJSONObject.put("subType", paramInt2);
      if (paramInt1 == 4) {
        localJSONObject.put("extValue", paramInt3);
      }
      paramString2 = localJSONObject.toString();
      b("doAdReport json:", paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        paramString2.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new NativeAdUtils.1());
        paramQQAppInterface.startServlet(paramString2);
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      b = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.3(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 4007) || (paramInt == 104) || (paramInt == 103) || (paramInt == 38) || (paramInt == 38) || (paramInt == 8) || (paramInt == 22) || (paramInt == 38) || (paramInt == 17);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool = PackageUtil.a(paramContext, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isAppInstall pkg:");
        paramContext.append(paramString);
        paramContext.append(" ");
        paramContext.append(bool);
        QLog.d("NativeAdUtils", 2, paramContext.toString());
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(BannerInfo paramBannerInfo)
  {
    String str1 = paramBannerInfo.h;
    String str2 = paramBannerInfo.f;
    String str3 = paramBannerInfo.l;
    paramBannerInfo = paramBannerInfo.k;
    Bundle localBundle = new Bundle();
    localBundle.putInt(DownloadConstants.k, 5);
    localBundle.putString(DownloadConstants.f, str1);
    localBundle.putString(DownloadConstants.b, str2);
    localBundle.putString(DownloadConstants.j, str3);
    localBundle.putString(DownloadConstants.l, paramBannerInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installApk pkg:");
      localStringBuilder.append(str1);
      localStringBuilder.append(", appid:");
      localStringBuilder.append(str2);
      localStringBuilder.append(", name:");
      localStringBuilder.append(paramBannerInfo);
      localStringBuilder.append(", url:");
      localStringBuilder.append(str3);
      QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
    }
    return DownloadApi.c(localBundle);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo.mLocalInfo == null) {
      return false;
    }
    try
    {
      String str1 = paramAbsBaseArticleInfo.mLocalInfo.d;
      double d = Double.parseDouble(paramAbsBaseArticleInfo.mLocalInfo.e);
      if ((Double.parseDouble(str1) == 0.0D) && (d == 0.0D)) {
        return false;
      }
      str1 = paramAbsBaseArticleInfo.mLocalInfo.c;
      String str2 = paramAbsBaseArticleInfo.mLocalInfo.f;
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mLocalInfo.b;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo);
        if (bool) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "hasAddLocationInfo is -> true");
        }
        return true;
      }
      return false;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
    return false;
  }
  
  public static double b(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    SosoLbsInfo localSosoLbsInfo;
    if (paramContext != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return 0.0D;
      }
      localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mAdExtInfo)) {
          return 0.0D;
        }
      }
    }
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.mAdExtInfo);
      double d1 = paramAbsBaseArticleInfo.getDouble(paramString1);
      double d2 = paramAbsBaseArticleInfo.getDouble(paramString2);
      double d3 = localSosoLbsInfo.mLocation.mLat02;
      double d4 = localSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel())
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("getADPosition cached latitude =  ");
        paramAbsBaseArticleInfo.append(d3);
        paramAbsBaseArticleInfo.append(" longitude = ");
        paramAbsBaseArticleInfo.append(d4);
        paramAbsBaseArticleInfo.append(" adLatitude = ");
        paramAbsBaseArticleInfo.append(d1);
        paramAbsBaseArticleInfo.append(" adLongitude = ");
        paramAbsBaseArticleInfo.append(d2);
        QLog.d("NativeAdUtils", 2, paramAbsBaseArticleInfo.toString());
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D))
      {
        if (d2 >= 180.0D) {
          return 0.0D;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
        }
        if (c())
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
          }
          b(paramContext);
          return 0.0D;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
        }
      }
      return 0.0D;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
    return 0.0D;
  }
  
  public static String b()
  {
    try
    {
      if (b == null) {
        if (BaseApplicationImpl.getApplication().peekAppRuntime() == null)
        {
          b = "";
        }
        else
        {
          localObject1 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySP(true, false);
          if (localObject1 != null) {
            b = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
          } else {
            b = "";
          }
        }
      }
      b("getAdCookie cookie=", b);
      Object localObject1 = b;
      return localObject1;
    }
    finally {}
  }
  
  public static String b(String paramString)
  {
    return MD5.b(paramString);
  }
  
  public static JSONObject b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      return paramAdvertisementInfo.mBusiJson;
    }
    return new JSONObject();
  }
  
  public static JSONObject b(AdData paramAdData)
  {
    if (paramAdData == null) {
      return new JSONObject();
    }
    if (paramAdData.j != null) {
      return b(paramAdData.j);
    }
    return b(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData));
  }
  
  private static void b(Context paramContext)
  {
    if (a >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
      return;
    }
    if ((paramContext != null) && (NetworkUtil.isNetworkAvailable(paramContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
      }
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new NativeAdUtils.4("readinjoy_feed_ad_distance"));
      a += 1;
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launch(paramContext, paramString);
    paramContext = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramString = new StringBuilder();
    paramString.append("launchResult = ");
    paramString.append(bool);
    paramContext.d("NativeAdUtils", paramString.toString());
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("，");
      localStringBuilder.append(paramString2);
      QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
    }
  }
  
  public static double[] b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return null;
    }
    paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo.mLocalInfo == null) {
      return null;
    }
    try
    {
      String str = paramAbsBaseArticleInfo.mLocalInfo.d;
      double d1 = ParseUtil.a(paramAbsBaseArticleInfo.mLocalInfo.e, 0.0D);
      double d2 = ParseUtil.a(str, 0.0D);
      if ((d2 == 0.0D) && (d1 == 0.0D)) {
        return null;
      }
      return new double[] { d1, d2 };
    }
    catch (Exception paramAbsBaseArticleInfo) {}
    return null;
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.excute(new NativeAdUtils.5(paramString), 128, null, false);
  }
  
  private static boolean c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool = false;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition activity null");
      }
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool = true;
      }
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils
 * JD-Core Version:    0.7.0.1
 */