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
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJNetworkUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo.SmallMiniGameData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAdUtils
{
  public static int a;
  private static volatile String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Int = 0;
  }
  
  public static double a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return 0.0D;
    }
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {}
    }
    for (;;)
    {
      return 0.0D;
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble(paramString1);
        double d2 = paramBaseArticleInfo.getDouble(paramString2);
        double d3 = localSosoLbsInfo.mLocation.mLat02;
        double d4 = localSosoLbsInfo.mLocation.mLon02;
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
        }
        if ((d3 <= 0.0D) || (d3 >= 90.0D) || (d4 <= 0.0D) || (d4 >= 180.0D) || (d1 <= 0.0D) || (d1 >= 90.0D) || (d2 <= 0.0D) || (d2 >= 180.0D)) {
          continue;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      }
      catch (Exception paramBaseArticleInfo) {}
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static double a(double[] paramArrayOfDouble, Context paramContext)
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
    double d1;
    double d2;
    double d3;
    double d4;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      d1 = paramArrayOfDouble[0];
      d2 = paramArrayOfDouble[1];
      d3 = localSosoLbsInfo.mLocation.mLat02;
      d4 = localSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D) && (d2 < 180.0D)) {}
    }
    for (;;)
    {
      return 0.0D;
      return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static int a(Context paramContext, BannerInfo paramBannerInfo)
  {
    if ((paramContext == null) || (paramBannerInfo == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramBannerInfo.jdField_f_of_type_JavaLangString;
          paramBannerInfo = paramBannerInfo.jdField_d_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramBannerInfo))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
        return -1;
        localDownloadInfo = DownloadManager.a().a(paramBannerInfo);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " true");
        }
        return localDownloadInfo.jdField_f_of_type_Int;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (FastWeqAdUtils.a(paramAdData)) {
      return 25;
    }
    if (paramAdData.a()) {
      return 35;
    }
    return 1;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559060);
    TextView localTextView = (TextView)paramContext.findViewById(2131365811);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131365807);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label148;
        }
        paramString1.setText(paramString4);
      }
      label68:
      paramString1 = (TextView)paramContext.findViewById(2131365796);
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          break label157;
        }
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
    }
    for (;;)
    {
      paramString1 = (TextView)paramContext.findViewById(2131365802);
      if (paramString1 != null)
      {
        if (paramString3 == null) {
          break label166;
        }
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null) {
          paramString1.setOnClickListener(paramOnClickListener2);
        }
      }
      return paramContext;
      localTextView.setVisibility(8);
      break;
      label148:
      paramString1.setVisibility(8);
      break label68;
      label157:
      paramString1.setVisibility(8);
    }
    label166:
    paramString1.setVisibility(8);
    return paramContext;
  }
  
  public static VideoAdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdInfo localVideoAdInfo = new VideoAdInfo();
    if (paramAdvertisementInfo != null)
    {
      localVideoAdInfo.jdField_a_of_type_Long = paramAdvertisementInfo.mAdFetchTime;
      localVideoAdInfo.jdField_a_of_type_Int = paramAdvertisementInfo.mAdPosLayout;
      localVideoAdInfo.jdField_b_of_type_Long = paramAdvertisementInfo.mAdPosID;
      localVideoAdInfo.jdField_c_of_type_Long = paramAdvertisementInfo.mChannelID;
      localVideoAdInfo.jdField_b_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localVideoAdInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mAdCl;
      localVideoAdInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
      localVideoAdInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mAdImgs;
      localVideoAdInfo.jdField_d_of_type_JavaLangString = paramAdvertisementInfo.mAdTxt;
      localVideoAdInfo.jdField_e_of_type_JavaLangString = paramAdvertisementInfo.mAdDesc;
      localVideoAdInfo.jdField_f_of_type_JavaLangString = paramAdvertisementInfo.mAdRl;
      localVideoAdInfo.jdField_g_of_type_JavaLangString = paramAdvertisementInfo.mAdApurl;
      localVideoAdInfo.jdField_h_of_type_JavaLangString = paramAdvertisementInfo.mAdTraceId;
      localVideoAdInfo.i = paramAdvertisementInfo.mAdProductId;
      localVideoAdInfo.jdField_c_of_type_Int = paramAdvertisementInfo.mAdProductType;
      localVideoAdInfo.jdField_d_of_type_Int = paramAdvertisementInfo.mAdType;
      localVideoAdInfo.jdField_j_of_type_JavaLangString = paramAdvertisementInfo.mAdLandingPage;
      localVideoAdInfo.k = paramAdvertisementInfo.mAdPrice;
      localVideoAdInfo.jdField_l_of_type_JavaLangString = paramAdvertisementInfo.mAdBtnTxt;
      localVideoAdInfo.jdField_m_of_type_JavaLangString = paramAdvertisementInfo.mAdViewId;
      localVideoAdInfo.jdField_n_of_type_JavaLangString = paramAdvertisementInfo.mAdCustomizedInvokeUrl;
      localVideoAdInfo.o = paramAdvertisementInfo.mAdCorporationName;
      localVideoAdInfo.jdField_p_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporateImageName;
      localVideoAdInfo.jdField_q_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporateLogo;
      localVideoAdInfo.jdField_d_of_type_Long = paramAdvertisementInfo.mAdUin;
      localVideoAdInfo.r = paramAdvertisementInfo.mAdExt;
      localVideoAdInfo.s = paramAdvertisementInfo.mAdVideoUrl;
      localVideoAdInfo.jdField_e_of_type_Int = paramAdvertisementInfo.mAdCostType;
      localVideoAdInfo.jdField_e_of_type_Long = paramAdvertisementInfo.mAdAid;
      localVideoAdInfo.jdField_f_of_type_Int = paramAdvertisementInfo.mAdLayout;
      localVideoAdInfo.jdField_g_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localVideoAdInfo.t = paramAdvertisementInfo.mAdVia;
      localVideoAdInfo.v = paramAdvertisementInfo.mAdExtInfo;
      localVideoAdInfo.jdField_l_of_type_Int = paramAdvertisementInfo.mAdJumpMode;
      localVideoAdInfo.w = paramAdvertisementInfo.mAdAppJson;
      localVideoAdInfo.x = paramAdvertisementInfo.mAdAppDownLoadSchema;
      localVideoAdInfo.y = paramAdvertisementInfo.mAdCanvasJson;
      localVideoAdInfo.z = paramAdvertisementInfo.mAdLandingPageReportUrl;
      localVideoAdInfo.jdField_g_of_type_Long = paramAdvertisementInfo.mAdAdvertiseId;
      localVideoAdInfo.jdField_n_of_type_Int = paramAdvertisementInfo.mAdDestType;
      localVideoAdInfo.A = paramAdvertisementInfo.mAdEffectUrl;
      localVideoAdInfo.jdField_h_of_type_Long = paramAdvertisementInfo.mAdNocoId;
      localVideoAdInfo.B = paramAdvertisementInfo.mAdDownloadApiUrl;
      localVideoAdInfo.jdField_p_of_type_Int = paramAdvertisementInfo.mC2SSwitch;
      localVideoAdInfo.jdField_f_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SClickUrl;
      localVideoAdInfo.jdField_g_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SExposureUrl;
      localVideoAdInfo.jdField_q_of_type_Int = paramAdvertisementInfo.replay;
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos;
      if ((paramAdvertisementInfo != null) && (!paramAdvertisementInfo.isEmpty()))
      {
        localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList = new ArrayList(paramAdvertisementInfo.size());
        int i = 0;
        while (i < paramAdvertisementInfo.size())
        {
          AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.get(i);
          VideoAdInfo.NegFeedback localNegFeedback = new VideoAdInfo.NegFeedback();
          localNegFeedback.jdField_a_of_type_JavaLangString = localAdDislikeInfo.jdField_a_of_type_JavaLangString;
          localNegFeedback.jdField_a_of_type_Long = localAdDislikeInfo.jdField_a_of_type_Long;
          localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList.add(localNegFeedback);
          i += 1;
        }
      }
      localVideoAdInfo.a(localVideoAdInfo.v);
      localVideoAdInfo.c(localVideoAdInfo.v);
      localVideoAdInfo.b(localVideoAdInfo.v);
    }
    return localVideoAdInfo;
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, null, null);
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo, Integer paramInteger1, Integer paramInteger2)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo == null) {
      return localAdvertisementInfo;
    }
    localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.jdField_g_of_type_Long;
    localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.s;
    localAdvertisementInfo.mAdAid = paramVideoAdInfo.jdField_e_of_type_Long;
    localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
    localAdvertisementInfo.mAdViewId = paramVideoAdInfo.jdField_m_of_type_JavaLangString;
    localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
    localAdvertisementInfo.mAdVia = paramVideoAdInfo.t;
    localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.jdField_h_of_type_Long;
    localAdvertisementInfo.mAdApurl = paramVideoAdInfo.jdField_g_of_type_JavaLangString;
    localAdvertisementInfo.mAdRl = paramVideoAdInfo.jdField_f_of_type_JavaLangString;
    localAdvertisementInfo.mAdDownloadApiUrl = paramVideoAdInfo.B;
    localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.A;
    localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.z;
    localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.jdField_j_of_type_JavaLangString;
    localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.y;
    localAdvertisementInfo.mAdDestType = paramVideoAdInfo.jdField_n_of_type_Int;
    localAdvertisementInfo.mAdExt = paramVideoAdInfo.r;
    localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.x;
    localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.jdField_n_of_type_JavaLangString;
    localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
    localAdvertisementInfo.mAdJumpMode = paramVideoAdInfo.jdField_l_of_type_Int;
    localAdvertisementInfo.mAdPosID = paramVideoAdInfo.jdField_b_of_type_Long;
    if (paramInteger1 != null) {
      localAdvertisementInfo.mOrigin = paramInteger1.intValue();
    }
    if (paramInteger2 != null) {
      localAdvertisementInfo.mChannelID = paramInteger2.intValue();
    }
    if (paramVideoAdInfo.v != null) {}
    try
    {
      paramInteger1 = new JSONObject(paramVideoAdInfo.v);
      if (paramInteger1.has("mini_program_type")) {
        localAdvertisementInfo.miniProgramType = paramInteger1.optInt("mini_program_type");
      }
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.v;
    }
    catch (Exception paramInteger1)
    {
      for (;;)
      {
        paramInteger1.printStackTrace();
      }
    }
    localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.C;
    localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.jdField_b_of_type_Boolean;
    localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.jdField_a_of_type_Long;
    localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.jdField_b_of_type_Int;
    localAdvertisementInfo.ecpm = paramVideoAdInfo.jdField_a_of_type_Double;
    localAdvertisementInfo.isContract = paramVideoAdInfo.jdField_u_of_type_Int;
    VideoAdInfo.a(paramVideoAdInfo);
    localAdvertisementInfo.mC2SSwitch = paramVideoAdInfo.jdField_p_of_type_Int;
    localAdvertisementInfo.mC2SClickUrl = paramVideoAdInfo.jdField_f_of_type_JavaUtilArrayList;
    localAdvertisementInfo.mC2SExposureUrl = paramVideoAdInfo.jdField_g_of_type_JavaUtilArrayList;
    localAdvertisementInfo.replay = paramVideoAdInfo.jdField_q_of_type_Int;
    localAdvertisementInfo.mRevisionVideoType = paramVideoAdInfo.jdField_m_of_type_Int;
    localAdvertisementInfo.isMultiyVideo = paramVideoAdInfo.jdField_a_of_type_Boolean;
    localAdvertisementInfo.processAdExt(paramVideoAdInfo.r);
    localAdvertisementInfo.mAdBtnTxt = paramVideoAdInfo.jdField_l_of_type_JavaLangString;
    localAdvertisementInfo.mAdvertisementExtInfo = new AdvertisementExtInfo(paramVideoAdInfo.v);
    return localAdvertisementInfo;
  }
  
  @Nullable
  private static AppInterface a(AdReportData paramAdReportData)
  {
    paramAdReportData = paramAdReportData.a();
    if ((paramAdReportData == null) && (BaseApplicationImpl.sProcessId == 1))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return paramAdReportData;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
          if (localObject1 == null) {
            jdField_a_of_type_JavaLangString = "";
          }
        }
        else
        {
          b("getAdCookie cookie=", jdField_a_of_type_JavaLangString);
          localObject1 = jdField_a_of_type_JavaLangString;
          return localObject1;
        }
        Object localObject1 = ReadInJoyHelper.a((AppRuntime)localObject1, true, false);
        if (localObject1 != null) {
          jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
        } else {
          jdField_a_of_type_JavaLangString = "";
        }
      }
      finally {}
    }
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return "";
    }
    paramDouble = Math.ceil(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDouble < 1000.0D) {
      localStringBuilder.append((int)paramDouble).append('m');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      long l = Math.round(paramDouble / 1000.0D);
      if (l < 1000L) {
        localStringBuilder.append(l).append("km");
      } else {
        localStringBuilder.append("999km");
      }
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    double d = a(paramBaseArticleInfo, paramContext, paramString1, paramString2);
    paramBaseArticleInfo = localObject;
    if (d > 0.0D) {
      paramBaseArticleInfo = a(d);
    }
    return paramBaseArticleInfo;
  }
  
  public static String a(String paramString)
  {
    return MD5.a(paramString);
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
    for (;;)
    {
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
        if (paramVideoEndType == null)
        {
          paramInt1 = ReportConstants.VideoEndType.NORMAL_COMPLETE.getValue();
          localJSONObject.put("videoEndType", paramInt1);
          localJSONObject.put("isVideoFeedsRecommend", paramBoolean2);
          localJSONObject.put("videoReplayCount", paramInt10);
          localJSONObject.put("isClickReplay", paramBoolean1);
          return localJSONObject;
        }
      }
      catch (JSONException paramVideoEndType)
      {
        paramVideoEndType.printStackTrace();
        return null;
      }
      paramInt1 = paramVideoEndType.getValue();
    }
  }
  
  /* Error */
  public static JSONObject a(Context paramContext)
  {
    // Byte code:
    //   0: new 53	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 660	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: invokestatic 708	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdDeviceInfoUtil:a	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 710	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdDeviceInfoUtil:c	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 5
    //   21: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +328 -> 352
    //   27: aload 5
    //   29: invokevirtual 715	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload 6
    //   35: ldc_w 717
    //   38: aload_3
    //   39: invokestatic 722	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 715	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 727
    //   54: iconst_1
    //   55: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload 4
    //   61: astore 5
    //   63: aload_3
    //   64: astore 4
    //   66: aload 5
    //   68: astore_3
    //   69: new 729	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params
    //   72: dup
    //   73: invokespecial 730	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc_w 732
    //   83: putfield 733	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokestatic 739	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: aload 5
    //   91: invokestatic 744	com/tencent/gdtad/util/GdtDeviceInfoHelper:a	(Landroid/content/Context;Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Params;)Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Result;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +51 -> 149
    //   101: aload 5
    //   103: getfield 749	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   106: ifnull +43 -> 149
    //   109: aload 6
    //   111: ldc_w 717
    //   114: aload 5
    //   116: getfield 749	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   119: getfield 754	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 758	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 727
    //   134: aload 5
    //   136: getfield 749	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   139: getfield 761	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 765	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 767
    //   154: invokestatic 770	com/tencent/biz/pubaccount/Advertisement/util/PublicAccountAdUtil:a	()I
    //   157: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 6
    //   163: ldc_w 772
    //   166: aload_0
    //   167: invokestatic 777	com/tencent/biz/qqstory/utils/NetworkUtils:c	(Landroid/content/Context;)Ljava/lang/String;
    //   170: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 781	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()I
    //   179: istore_2
    //   180: iload_2
    //   181: istore_1
    //   182: aload 6
    //   184: ldc_w 783
    //   187: iload_1
    //   188: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 6
    //   194: ldc_w 785
    //   197: invokestatic 787	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()Ljava/lang/String;
    //   200: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 789
    //   209: invokestatic 790	com/tencent/mobileqq/utils/DeviceInfoUtil:c	()Ljava/lang/String;
    //   212: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 6
    //   218: ldc_w 792
    //   221: invokestatic 795	com/tencent/common/config/AppSetting:a	()I
    //   224: invokestatic 799	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 801
    //   236: invokestatic 806	com/dataline/util/DatalineMathUtil:a	()J
    //   239: invokestatic 809	com/dataline/util/DatalineMathUtil:a	(J)Ljava/lang/String;
    //   242: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: ldc_w 811
    //   251: aload_0
    //   252: invokestatic 814	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJNetworkUtils:c	(Landroid/content/Context;)Ljava/lang/String;
    //   255: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 816
    //   264: aload_3
    //   265: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: ldc_w 818
    //   274: iconst_2
    //   275: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 6
    //   281: ldc_w 820
    //   284: invokestatic 822	com/tencent/mobileqq/utils/DeviceInfoUtil:k	()Ljava/lang/String;
    //   287: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 824
    //   296: invokestatic 826	com/tencent/mobileqq/utils/DeviceInfoUtil:i	()Ljava/lang/String;
    //   299: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 828
    //   308: invokestatic 830	com/tencent/mobileqq/utils/DeviceInfoUtil:h	()Ljava/lang/String;
    //   311: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 832
    //   320: aload 4
    //   322: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_0
    //   327: ifnull +22 -> 349
    //   330: aload 6
    //   332: ldc_w 834
    //   335: aload_0
    //   336: invokevirtual 840	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   339: ldc_w 842
    //   342: invokestatic 847	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 6
    //   351: areturn
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +97 -> 457
    //   363: aload 4
    //   365: ldc_w 849
    //   368: ldc_w 594
    //   371: invokevirtual 852	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 855	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   377: astore_3
    //   378: aload 6
    //   380: ldc_w 717
    //   383: aload_3
    //   384: invokestatic 722	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 715	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   390: invokevirtual 725	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 727
    //   399: iconst_3
    //   400: invokevirtual 666	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: goto +53 -> 457
    //   407: astore_0
    //   408: ldc 77
    //   410: iconst_1
    //   411: new 79	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 857
    //   421: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: invokevirtual 858	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 6
    //   439: areturn
    //   440: astore_0
    //   441: aload_0
    //   442: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   445: aconst_null
    //   446: areturn
    //   447: astore 5
    //   449: goto -267 -> 182
    //   452: astore 5
    //   454: goto -208 -> 246
    //   457: aload 5
    //   459: astore 4
    //   461: goto -392 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramContext	Context
    //   175	13	1	i	int
    //   179	2	2	j	int
    //   32	352	3	localObject1	Object
    //   17	443	4	localObject2	Object
    //   12	123	5	localObject3	Object
    //   447	1	5	localException1	Exception
    //   452	6	5	localException2	Exception
    //   7	431	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   330	349	407	java/lang/Exception
    //   9	59	440	java/lang/Exception
    //   69	96	440	java/lang/Exception
    //   101	149	440	java/lang/Exception
    //   149	174	440	java/lang/Exception
    //   182	231	440	java/lang/Exception
    //   246	326	440	java/lang/Exception
    //   355	404	440	java/lang/Exception
    //   408	437	440	java/lang/Exception
    //   176	180	447	java/lang/Exception
    //   231	246	452	java/lang/Exception
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      return paramAdvertisementInfo.mBusiJson;
    }
    return new JSONObject();
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
        localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
        localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
        localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
        localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
        localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
        localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
        localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
        localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
        localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
        localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
        localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
        localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
        localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
        localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
        localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
        localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
        localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
        localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
        localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
        localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
        localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
        localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
        localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
        localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
        localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
        localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
        localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
        localJSONObject.put("algo_id", "" + paramAdvertisementInfo.mAlgorithmID);
        localJSONObject.put("replay", paramAdvertisementInfo.replay);
        a(localJSONObject, paramAdvertisementInfo);
        if (paramAdvertisementInfo.downloadState == 0)
        {
          localJSONObject.put("download_state", "0");
          if (paramVideoAdInfo != null)
          {
            if (localJSONObject.isNull("apurl")) {
              localJSONObject.put("apurl", paramVideoAdInfo.jdField_g_of_type_JavaLangString);
            }
            localJSONObject.put("via", paramVideoAdInfo.t);
            localJSONObject.put("dis_channel", paramVideoAdInfo.jdField_j_of_type_Int);
            localJSONObject.put("button_url", paramVideoAdInfo.jdField_u_of_type_JavaLangString);
          }
          localJSONObject.put("cookie", a());
          if (paramInt <= 0) {
            break;
          }
          localJSONObject.put("click_pos", paramInt);
          return localJSONObject;
        }
        if (paramAdvertisementInfo.downloadState == 3)
        {
          localJSONObject.put("download_state", "1");
          continue;
        }
        if (paramAdvertisementInfo.downloadState != 4) {
          break label565;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("download_state", "2");
      continue;
      label565:
      if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.clickPos > 0)) {
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {
      localJSONObject = a(paramAdvertisementInfo);
    }
    return ReadInJoyJsonUtil.a(new JSONObject[] { localJSONObject, a(paramHashMap) });
  }
  
  public static JSONObject a(AdData paramAdData)
  {
    if (paramAdData == null) {
      return new JSONObject();
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return a(paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
    return a(ReadInJoyBottomAdVideoUtil.a(paramAdData));
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", b(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "8.5.5");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 != 1) {
          break label184;
        }
        paramQQAppInterface = paramAdData.jdField_e_of_type_JavaLangString;
        localJSONObject.put("ext", paramQQAppInterface);
        localJSONObject.put("oudid", paramAdData.k);
        if (!(paramAdData instanceof AttachedAdData)) {
          break label192;
        }
        localJSONObject.put("aname", paramAdData.jdField_b_of_type_JavaLangString);
        localJSONObject.put("posid", paramAdData.jdField_c_of_type_Int);
      }
      for (;;)
      {
        if (paramJSONObject == null) {
          break label226;
        }
        localJSONObject.put("exposureExtraInfo", paramJSONObject);
        return localJSONObject;
        label184:
        paramQQAppInterface = paramAdData.jdField_g_of_type_JavaLangString;
        break;
        label192:
        localJSONObject.put("aname", paramAdData.i);
        localJSONObject.put("posid", paramAdData.jdField_a_of_type_JavaLangString);
      }
      return localJSONObject;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
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
      return null;
    }
  }
  
  public static JSONObject a(HashMap<String, Object> paramHashMap)
  {
    localJSONObject = new JSONObject();
    if (paramHashMap != null) {
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
    }
  }
  
  public static void a(Activity paramActivity, BannerInfo paramBannerInfo, DownloadListener paramDownloadListener)
  {
    if ((paramActivity == null) || (paramBannerInfo == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramBannerInfo.jdField_f_of_type_JavaLangString;
      str2 = paramBannerInfo.jdField_d_of_type_JavaLangString;
      str3 = paramBannerInfo.jdField_j_of_type_JavaLangString;
      paramBannerInfo = paramBannerInfo.i;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramBannerInfo)));
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(DownloadConstants.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(DownloadConstants.jdField_l_of_type_JavaLangString, paramBannerInfo);
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putInt(DownloadConstants.F, 0);
    localBundle.putBoolean(DownloadConstants.x, false);
    localBundle.putInt(DownloadConstants.I, 0);
    localBundle.putBoolean(DownloadConstants.y, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramBannerInfo + ", url:" + str3);
    }
    if (paramDownloadListener != null) {
      DownloadManager.a().a(paramDownloadListener);
    }
    DownloadApi.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  private static void a(Context paramContext)
  {
    if (jdField_a_of_type_Int >= 3) {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
    }
    while ((paramContext == null) || (!NetworkUtil.g(paramContext))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
    }
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new NativeAdUtils.6("readinjoy_feed_ad_distance"));
    jdField_a_of_type_Int += 1;
  }
  
  public static void a(Context paramContext, AdReportExtData paramAdReportExtData)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page_id", paramAdReportExtData.jdField_a_of_type_Long);
      localJSONObject.put("oper_module", paramAdReportExtData.jdField_b_of_type_Long);
      localJSONObject.put("oper_id", paramAdReportExtData.jdField_c_of_type_Long);
      localJSONObject.put("oper_type", paramAdReportExtData.jdField_d_of_type_Long);
      localJSONObject.put("obj_id", paramAdReportExtData.jdField_a_of_type_JavaLangString);
      localJSONObject.put("obj_type", paramAdReportExtData.jdField_b_of_type_JavaLangString);
      localJSONObject.put("game_pkg", paramAdReportExtData.jdField_c_of_type_JavaLangString);
      localJSONObject.put("app_id", paramAdReportExtData.jdField_d_of_type_JavaLangString);
      localJSONObject.put("ex1", paramAdReportExtData.jdField_e_of_type_JavaLangString);
      localJSONObject.put("ex2", paramAdReportExtData.jdField_f_of_type_JavaLangString);
      localJSONObject.put("ex3", paramAdReportExtData.jdField_g_of_type_JavaLangString);
      localJSONObject.put("ex4", paramAdReportExtData.jdField_h_of_type_JavaLangString);
      localJSONObject.put("loc_id", paramAdReportExtData.i);
      paramAdReportExtData = new JSONObject();
      paramAdReportExtData.put("game_gift_report", String.valueOf(localJSONObject));
      a(new AdReportData().a(paramContext).a(119).b(39).b(Integer.valueOf(6)).e(paramAdReportExtData));
      return;
    }
    catch (Exception paramContext)
    {
      b("reportMiniGameAd error :", paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if ((paramContext != null) && (paramBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramBaseArticleInfo.mSmallMiniGameInfo == null) {
          break label322;
        }
        Object localObject = paramBaseArticleInfo.mSmallMiniGameInfo.jdField_j_of_type_JavaLangString;
        if (ReadInJoyAdUtils.i(paramBaseArticleInfo))
        {
          l2 = 50404L;
          if (paramInt2 != 1) {
            break label323;
          }
          l1 = 5040402L;
          localObject = new AdReportExtData.Builder().a(504L).b(l2).c(l1).d((String)localObject);
          if (paramInt2 != 1) {
            break label363;
          }
          l1 = 3L;
          AdReportExtData.Builder localBuilder = ((AdReportExtData.Builder)localObject).d(l1).a(paramBaseArticleInfo.innerUniqueID).b(paramBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
          if (ReadInJoyAdUtils.k(paramBaseArticleInfo))
          {
            localObject = paramBaseArticleInfo.mSmallMiniGameInfo.o;
            localObject = localBuilder.c((String)localObject);
            if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramBaseArticleInfo.mArticleContentUrl)) {
              continue;
            }
            paramBaseArticleInfo = paramBaseArticleInfo.mArticleContentUrl;
            a(paramContext, ((AdReportExtData.Builder)localObject).g(paramBaseArticleInfo).a());
          }
        }
        else
        {
          if (ReadInJoyAdUtils.g(paramBaseArticleInfo))
          {
            l2 = 50403L;
            if (paramInt2 != 1) {
              break label331;
            }
            l1 = 5040302L;
            continue;
          }
          if (ReadInJoyAdUtils.j(paramBaseArticleInfo))
          {
            l2 = 50402L;
            if (paramInt2 != 1) {
              break label339;
            }
            l1 = 5040202L;
            continue;
          }
          if (ReadInJoyAdUtils.k(paramBaseArticleInfo))
          {
            l2 = 50406L;
            if (paramInt2 != 1) {
              break label347;
            }
            l1 = 5040602L;
            continue;
          }
          if (!ReadInJoyAdUtils.h(paramBaseArticleInfo)) {
            break label316;
          }
          l2 = 50401L;
          if (paramInt2 != 1) {
            break label355;
          }
          l1 = 5040104L;
          continue;
        }
        localObject = paramBaseArticleInfo.mSubscribeName;
        continue;
        paramBaseArticleInfo = paramBaseArticleInfo.mSmallMiniGameInfo.k;
        continue;
        long l2 = 0L;
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
        return;
      }
      label316:
      continue;
      label322:
      return;
      label323:
      l1 = 5040401L;
      continue;
      label331:
      l1 = 5040301L;
      continue;
      label339:
      l1 = 5040201L;
      continue;
      label347:
      l1 = 5040601L;
      continue;
      label355:
      l1 = 5040103L;
      continue;
      label363:
      l1 = 6L;
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (paramBaseArticleInfo.mSmallMiniGameInfo.a == null)) {
          break label210;
        }
        if (paramInt3 != 2) {
          break label211;
        }
        l = 5010103L;
        String str;
        if (paramBaseArticleInfo.mSmallMiniGameInfo.a())
        {
          str = "3";
          paramBaseArticleInfo = (SmallMiniGameInfo.SmallMiniGameData)paramBaseArticleInfo.mSmallMiniGameInfo.a.get(paramInt2);
          if (paramBaseArticleInfo == null) {
            break label205;
          }
          AdReportExtData.Builder localBuilder = new AdReportExtData.Builder().a(501L).b(50101L).c(l);
          if (paramInt3 == 1)
          {
            l = 3L;
            paramBaseArticleInfo = localBuilder.d(l).d(paramBaseArticleInfo.jdField_a_of_type_JavaLangString).i(String.valueOf(paramInt1)).c(paramBaseArticleInfo.jdField_d_of_type_JavaLangString).e(paramBaseArticleInfo.jdField_c_of_type_JavaLangString).f(String.valueOf(paramInt2 + 1)).g(paramBaseArticleInfo.jdField_b_of_type_JavaLangString).h(str).a();
            if (paramBaseArticleInfo == null) {
              break label210;
            }
            a(paramContext, paramBaseArticleInfo);
          }
        }
        else
        {
          str = "2";
          continue;
        }
        l = 6L;
        continue;
        paramBaseArticleInfo = null;
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
        return;
      }
      label205:
      continue;
      label210:
      return;
      label211:
      long l = 5010104L;
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBaseArticleInfo.mSmallMiniGameInfo == null) {
      return;
    }
    Object localObject = paramBaseArticleInfo.mSmallMiniGameInfo.jdField_j_of_type_JavaLangString;
    localObject = new AdReportExtData.Builder().a(504L).b(50407L).c(paramInt2).d((String)localObject);
    long l;
    if (paramBoolean)
    {
      l = 9L;
      AdReportExtData.Builder localBuilder = ((AdReportExtData.Builder)localObject).d(l).a(paramBaseArticleInfo.innerUniqueID).b(paramBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
      if (!ReadInJoyAdUtils.k(paramBaseArticleInfo)) {
        break label161;
      }
      localObject = paramBaseArticleInfo.mSmallMiniGameInfo.o;
      label104:
      localObject = localBuilder.c((String)localObject);
      if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramBaseArticleInfo.mArticleContentUrl)) {
        break label170;
      }
    }
    label161:
    label170:
    for (paramBaseArticleInfo = paramBaseArticleInfo.mArticleContentUrl;; paramBaseArticleInfo = paramBaseArticleInfo.mSmallMiniGameInfo.k)
    {
      a(paramContext, ((AdReportExtData.Builder)localObject).g(paramBaseArticleInfo).a());
      return;
      l = 6L;
      break;
      localObject = paramBaseArticleInfo.mSubscribeName;
      break label104;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    boolean bool = ReadInJoyAdUtils.a(paramContext, paramString);
    ReadInJoyAdLog.a("NativeAdUtils", "launchResult = " + bool);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
      }
      GdtC2SReporter.a(0, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while (paramAdvertisementInfo == null);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
    }
    GdtC2SReporter.a(0, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
      }
      GdtC2SReporter.a(paramInt, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
    }
    GdtC2SReporter.a(paramInt, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
  }
  
  public static void a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = a(paramAdReportData);
    } while ((localAppInterface == null) || (AdReportManager.a(paramAdReportData)));
    Context localContext = paramAdReportData.a();
    int i = paramAdReportData.a();
    int j = paramAdReportData.b();
    AdvertisementInfo localAdvertisementInfo = paramAdReportData.a();
    VideoAdInfo localVideoAdInfo = paramAdReportData.a();
    long l = paramAdReportData.a();
    String str1 = paramAdReportData.a();
    JSONObject localJSONObject1 = paramAdReportData.a();
    int k = paramAdReportData.d();
    JSONObject localJSONObject2 = paramAdReportData.b();
    Bundle localBundle = paramAdReportData.a();
    JSONObject localJSONObject3 = paramAdReportData.c();
    JSONObject localJSONObject4 = paramAdReportData.d();
    JSONObject localJSONObject5 = paramAdReportData.f();
    JSONObject localJSONObject6 = paramAdReportData.e();
    int m = paramAdReportData.c();
    boolean bool2 = paramAdReportData.a();
    String str2 = localAppInterface.getAccount();
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mSoftAdType != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ThreadManager.post(new NativeAdUtils.3(paramAdReportData, localJSONObject3, str2, i, j, m, localContext, localAdvertisementInfo, localVideoAdInfo, k, localJSONObject1, localJSONObject2, localBundle, str1, l, localJSONObject4, localJSONObject6, localJSONObject5, bool1, localAppInterface, bool2), 5, null, true);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (ReadInJoyAdSwitchUtil.a(paramAdData))
    {
      a(new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(81).b(a(paramAdData)).a(ReadInJoyBottomAdVideoUtil.a(paramAdData)).d(a(paramAdData)));
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 81, 1, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    int i = 2;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
      if (ReadInJoyAdSwitchUtil.a(paramAdData))
      {
        paramQQAppInterface = new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(ReadInJoyBottomAdVideoUtil.a(paramAdData)).c(localJSONObject).d(a(paramAdData));
        if (paramBoolean)
        {
          a(paramQQAppInterface.a(Integer.valueOf(i)).b(paramBoolean));
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          i = 1;
        }
      } while (paramBoolean);
      a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, localJSONObject).toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt, Integer paramInteger)
  {
    if (ReadInJoyAdSwitchUtil.a(paramAdData, false))
    {
      a(new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(1).b(paramInteger).b(1).a(ReadInJoyBottomAdVideoUtil.a(paramAdData)).d(a(paramAdData)).c(paramInt));
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
    int i = 1;
    if ((paramQQAppInterface == null) || (paramAdData == null)) {
      return;
    }
    if (ReadInJoyAdSwitchUtil.a(paramAdData))
    {
      paramQQAppInterface = new AdReportData().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(ReadInJoyBottomAdVideoUtil.a(paramAdData)).d(a(paramAdData));
      if (paramBoolean) {
        i = 2;
      }
      a(paramQQAppInterface.a(Integer.valueOf(i)).b(paramBoolean));
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " reportNativeEngineAdExposure " + paramAdData.jdField_b_of_type_JavaLangString + "  : " + paramAdData.jdField_c_of_type_JavaLangString);
      return;
      if (paramBoolean) {
        break;
      }
      a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, null).toString());
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
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
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
      localJSONObject.put("version", "8.5.5");
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
      jdField_a_of_type_JavaLangString = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.5(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {}
    while ((paramJSONObject == null) || (paramAdvertisementInfo == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.jdField_d_of_type_JavaLangString);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.C).optString("ADTAG"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    try
    {
      paramJSONObject.put("extra_data", paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramJSONObject.put("game_adtag", paramAdvertisementInfo.optString("game_adtag"));
      paramJSONObject.put("pkg_name", paramAdvertisementInfo.optString("game_pkg_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static boolean a()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition activity null");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT < 23);
      bool1 = bool2;
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 4007) || (paramInt == 104) || (paramInt == 103) || (paramInt == 38) || (paramInt == 38) || (paramInt == 8) || (paramInt == 22) || (paramInt == 38) || (paramInt == 17);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = PackageUtil.a(paramContext, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " " + bool2);
    return bool2;
  }
  
  public static boolean a(BannerInfo paramBannerInfo)
  {
    String str1 = paramBannerInfo.jdField_f_of_type_JavaLangString;
    String str2 = paramBannerInfo.jdField_d_of_type_JavaLangString;
    String str3 = paramBannerInfo.jdField_j_of_type_JavaLangString;
    paramBannerInfo = paramBannerInfo.i;
    Bundle localBundle = new Bundle();
    localBundle.putInt(DownloadConstants.k, 5);
    localBundle.putString(DownloadConstants.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(DownloadConstants.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(DownloadConstants.jdField_l_of_type_JavaLangString, paramBannerInfo);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramBannerInfo + ", url:" + str3);
    }
    return DownloadApi.a(localBundle);
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str1 = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d = Double.parseDouble(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString);
          if ((Double.parseDouble(str1) != 0.0D) || (d != 0.0D))
          {
            str1 = paramBaseArticleInfo.mLocalInfo.jdField_c_of_type_JavaLangString;
            String str2 = paramBaseArticleInfo.mLocalInfo.jdField_f_of_type_JavaLangString;
            paramBaseArticleInfo = paramBaseArticleInfo.mLocalInfo.jdField_b_of_type_JavaLangString;
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              boolean bool = TextUtils.isEmpty(paramBaseArticleInfo);
              if (!bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NativeAdUtils", 2, "hasAddLocationInfo is -> true");
                }
                return true;
              }
            }
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return false;
  }
  
  public static double[] a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return null;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d1 = ParseUtil.a(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString, 0.0D);
          double d2 = ParseUtil.a(str, 0.0D);
          if ((d2 != 0.0D) || (d1 != 0.0D)) {
            return new double[] { d1, d2 };
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return null;
  }
  
  private static JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("dma", AdDeviceInfoUtil.c());
        localJSONObject.put("hwm", DeviceInfoUtil.i());
        localJSONObject.put("hwma", DeviceInfoUtil.h());
        localJSONObject.put("osver", DeviceInfoUtil.e());
        localJSONObject.put("imei", AdDeviceInfoUtil.a());
        localJSONObject.put("brd", DeviceInfoUtil.k());
        localJSONObject.put("ns", HttpUtil.getNetWorkTypeByStr());
        localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
        localJSONObject.put("mid", "mid");
        localJSONObject.put("pf", "android");
        localJSONObject.put("wn", NetworkUtils.c(paramContext));
        str = "";
        switch (ApolloGameBasicEventUtil.b())
        {
        case 1: 
          localJSONObject.put("mnc", str);
          localJSONObject.put("rma", RIJNetworkUtils.c(paramContext));
          return localJSONObject;
        }
      }
      catch (Exception paramContext)
      {
        String str;
        paramContext.printStackTrace();
        return localJSONObject;
      }
      str = HardCodeUtil.a(2131707082);
      continue;
      str = HardCodeUtil.a(2131707080);
      continue;
      str = HardCodeUtil.a(2131707078);
    }
  }
  
  @NotNull
  private static JSONObject b(Bundle paramBundle, String paramString, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle != null)
    {
      localJSONObject.put("type_id", 2);
      localJSONObject.put("tel", paramBundle.getString("ad_complain_tel", ""));
      localJSONObject.put("txt", paramBundle.getString("ad_complain_txt", ""));
      return localJSONObject;
    }
    localJSONObject.put("type_id", 1);
    if (TextUtils.isEmpty(paramString))
    {
      localJSONObject.put("neg_ids", String.valueOf(paramLong));
      return localJSONObject;
    }
    localJSONObject.put("neg_ids", paramString);
    return localJSONObject;
  }
  
  @NotNull
  private static JSONObject b(JSONObject paramJSONObject, int paramInt, AdvertisementInfo paramAdvertisementInfo)
  {
    new JSONObject();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("type", InteraActionReportUtils.a(paramInt));
    localJSONObject.put("interaction_report_url", paramAdvertisementInfo.mAdInteractionReportUrl);
    localJSONObject.put("effect_url", paramAdvertisementInfo.mAdEffectUrl);
    return localJSONObject;
  }
  
  private static void b(int paramInt, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (paramInt == 2) {
      a(paramAdvertisementInfo, paramVideoAdInfo);
    }
    if (paramInt == 1) {
      b(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mC2SClickUrl, " exposureUrl = ", paramAdvertisementInfo.mC2SExposureUrl, 1);
    }
    if (paramInt == 27) {
      a(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mC2SVideoPlayUrl, " videoClickUrl = ", paramAdvertisementInfo.mC2SVideoPlayUrl, 2);
    }
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
      }
      GdtC2SReporter.a(paramInt, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
    }
    GdtC2SReporter.a(paramInt, 1, ReadinJoyActionUtil.a(paramAdvertisementInfo));
  }
  
  public static void b(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {}
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      return;
      localAdvertisementInfo = paramAdReportData.a();
    } while ((localAdvertisementInfo == null) || (AdReportUtil.a(paramAdReportData) != ActionEntity.Default) || (AdReportUtil.a(paramAdReportData) != ReportAction.EXPOSE));
    if (ReadInJoyAdUtils.h(paramAdReportData.a()))
    {
      if (paramAdReportData.b() != 37)
      {
        QLog.e("reportAmsExpose", 1, "fail，超级蒙层计费曝光，不是外蒙层");
        return;
      }
      if (paramAdReportData.a().intValue() != 2) {
        QLog.e("reportAmsExpose", 1, "fail，超级蒙层计费曝光，不是宽口径");
      }
    }
    else if (paramAdReportData.a().intValue() == 2)
    {
      QLog.e("reportAmsExpose", 1, "fail，正常广告计费曝光是严口径");
      return;
    }
    if ((localAdvertisementInfo.mAdvertisementExtInfo == null) || (localAdvertisementInfo.mAdvertisementExtInfo.jdField_j_of_type_Int != 32))
    {
      QLog.e("reportAmsExpose", 1, "aPurl report fail, not ams ad");
      return;
    }
    if (TextUtils.isEmpty(localAdvertisementInfo.mAdApurl))
    {
      QLog.e("reportAmsExpose", 1, "aPurl report fail with empty url");
      return;
    }
    if (!localAdvertisementInfo.mAdApurl.startsWith("http"))
    {
      QLog.e("reportAmsExpose", 1, "aPurl report fail with error url:" + localAdvertisementInfo.mAdApurl);
      return;
    }
    ReadInJoyAdLog.a("reportAmsExpose", "apurl = " + localAdvertisementInfo.mAdApurl);
    paramAdReportData = new Bundle();
    HttpUtil.addCookie(paramAdReportData);
    for (;;)
    {
      try
      {
        paramAdReportData = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localAdvertisementInfo.mAdApurl, "GET", null, paramAdReportData);
        if (paramAdReportData == null)
        {
          paramAdReportData = "";
          ReadInJoyAdLog.a("reportAmsExpose, result:", paramAdReportData);
          return;
        }
      }
      catch (Throwable paramAdReportData)
      {
        ReadInJoyAdLog.a("reportAmsExpose, e:", paramAdReportData.getMessage());
        return;
      }
      paramAdReportData = new String(paramAdReportData);
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.excute(new NativeAdUtils.7(paramString), 128, null, false);
  }
  
  private static void b(String paramString, AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo, AdReportData paramAdReportData, int paramInt)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.data.set(paramString);
    paramString = new NewIntent(paramAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report_new");
    paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
    paramString.setObserver(new NativeAdUtils.4(paramAdvertisementInfo, paramAdReportData, paramInt));
    paramAppInterface.startServlet(paramString);
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, paramString1 + "，" + paramString2);
    }
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (ReadInJoyAdUtils.h(paramAdvertisementInfo)) {}
    while (paramInt == 37) {
      return true;
    }
    return false;
  }
  
  private static boolean b(AdReportData paramAdReportData)
  {
    int i = paramAdReportData.b();
    int j = paramAdReportData.a();
    AdvertisementInfo localAdvertisementInfo = paramAdReportData.a();
    if ((i == 27) || (j == 26)) {
      return true;
    }
    if ((ReadInJoyAdUtils.h(localAdvertisementInfo)) && (j == 2))
    {
      if (AdReportUtil.a(paramAdReportData) == ActionEntity.InnerSuperMask)
      {
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "inner mask, do not report c2s");
        return true;
      }
      if (paramAdReportData.a().intValue() == 1)
      {
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "strict mask expose, do not report c2s");
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils
 * JD-Core Version:    0.7.0.1
 */