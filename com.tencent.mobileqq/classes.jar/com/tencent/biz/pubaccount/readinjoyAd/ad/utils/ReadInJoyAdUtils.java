package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GameLoadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyAdUtils
{
  private static HashSet<Integer> a = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(56), Integer.valueOf(40531), Integer.valueOf(14), Integer.valueOf(40174), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(11), Integer.valueOf(40466), Integer.valueOf(41541), Integer.valueOf(40013), Integer.valueOf(58), Integer.valueOf(16), Integer.valueOf(53), Integer.valueOf(52), Integer.valueOf(41629), Integer.valueOf(55), Integer.valueOf(40007), Integer.valueOf(59), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(54), Integer.valueOf(41504) }));
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return ParseUtil.a(paramAdvertisementInfo.gameAdComData.s, 0);
    }
    return ((Integer)ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo.mAdExtInfo, "game_button_type", Integer.valueOf(0))).intValue();
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    int j = 2050;
    int i;
    if (paramArticleInfo.mFeedType == 38) {
      i = 2051;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramArticleInfo.mFeedType != 39);
      if (g(paramArticleInfo)) {
        return 2053;
      }
      if (i(paramArticleInfo)) {
        return 2054;
      }
      if (j(paramArticleInfo)) {
        return 2052;
      }
      i = j;
    } while (!k(paramArticleInfo));
    return 2057;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int j = 10000;
    int k = 3000;
    int i;
    if (paramBoolean)
    {
      i = 10000;
      if (!TextUtils.isEmpty(paramString)) {
        break label33;
      }
    }
    for (;;)
    {
      return i;
      i = 3000;
      break;
      try
      {
        label33:
        paramString = new JSONObject(paramString).optString("cards_show_timming");
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          if (paramBoolean)
          {
            k = paramString.optInt("show_cards");
            i = j;
            if (k >= 0) {
              i = k;
            }
          }
          else
          {
            j = paramString.optInt("change_color");
            i = k;
            if (j >= 0) {
              i = j;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return i;
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    float f9 = AIOUtils.a(1.0F, paramContext.getResources());
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    paramContext = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, paramContext, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramContext.getPaint().setShader(localLinearGradient);
    return paramContext;
  }
  
  public static String a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong != 0L)
    {
      if (paramLong <= 99990000L) {
        break label44;
      }
      localStringBuilder.append("9999万+");
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      label44:
      if (paramLong > 10000L)
      {
        double d = paramLong / 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
      }
      else
      {
        localStringBuilder.append(paramLong);
      }
    }
  }
  
  @NonNull
  public static String a(Context paramContext, VideoInfo paramVideoInfo, int paramInt)
  {
    String str2 = "详情";
    String str3 = "查看详情";
    Object localObject = str3;
    String str1 = str2;
    if (a(paramVideoInfo))
    {
      localObject = str3;
      str1 = str2;
      if (paramVideoInfo.a.c != 12) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramVideoInfo.a.jdField_r_of_type_JavaLangString);
        if (PackageUtil.a(paramContext, ((JSONObject)localObject).optString("pkg_name")))
        {
          if (paramInt != 1) {
            break;
          }
          return "打开";
        }
        if (ADBaseAppDownloadManager.a(BaseApplicationImpl.getContext(), ((JSONObject)localObject).optString("pkg_name")))
        {
          str1 = "安装";
          localObject = HardCodeUtil.a(2131700003);
        }
      }
      catch (JSONException paramContext)
      {
        str1 = "下载";
        localObject = "立即下载";
        continue;
        paramContext = "购买";
        localObject = "立即购买";
        continue;
        paramContext = "详情";
        localObject = "查看详情";
        continue;
        if (TextUtils.isEmpty(paramVideoInfo.a.J)) {
          return localObject;
        }
        paramContext = paramVideoInfo.a.J;
      }
      switch (paramVideoInfo.a.jdField_r_of_type_Int)
      {
      default: 
        paramContext = str1;
        if (paramInt == 1)
        {
          if (TextUtils.isEmpty(paramVideoInfo.a.I)) {
            break label233;
          }
          return paramVideoInfo.a.I;
          str1 = "下载";
          localObject = "立即下载";
        }
        break;
      case 1: 
      case 28: 
        label233:
        return paramContext;
      }
    }
    return "立即打开";
  }
  
  @NonNull
  public static String a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    String str = "";
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdProductType == 12))
    {
      try
      {
        if (PackageUtil.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          return "打开";
        }
        paramContext = str;
        if (!TextUtils.isEmpty("")) {
          return paramContext;
        }
        return "下载";
      }
      catch (JSONException paramContext)
      {
        paramContext = str;
        if (!TextUtils.isEmpty("")) {
          return paramContext;
        }
      }
      return "下载";
    }
    else
    {
      paramContext = str;
      if (TextUtils.isEmpty("")) {
        paramContext = "查看";
      }
    }
    return paramContext;
  }
  
  public static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return paramAdvertisementInfo.gameAdComData.d;
    }
    return (String)ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo.mAdExtInfo, "game_pkg_name", "");
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = paramBaseArticleInfo.getSubscribeName();
    Object localObject2;
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      localObject2 = (AdvertisementInfo)paramBaseArticleInfo;
      if (!AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject2).mAdExt).getString("appname");
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyAdUtils", 2, "cannot get name from app advertisement");
        continue;
      }
      j = paramBaseArticleInfo.mSubscribeName.length();
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        i = 9;
        if (j > i)
        {
          localObject1 = new StringBuilder();
          localObject2 = paramBaseArticleInfo.mSubscribeName;
          if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
            break label160;
          }
          i = 8;
          return ((String)localObject2).substring(0, i) + "…";
          localObject1 = localJSONException.mAdCorporateImageName;
        }
      }
      else
      {
        i = 18;
        continue;
      }
      break;
      label160:
      int i = 17;
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject == null) || (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExt))) {
      return paramJSONObject;
    }
    for (;;)
    {
      try
      {
        if (!NativeAdUtils.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          break label102;
        }
        i = 2;
        paramJSONObject.put("action_type", i);
        return paramJSONObject;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + paramContext.getMessage());
      return paramJSONObject;
      label102:
      int i = 1;
    }
  }
  
  public static void a()
  {
    Object localObject = ReadinjoyAdCache.a(2);
    if ((localObject instanceof GameLoadData)) {
      try
      {
        localObject = (GameLoadData)localObject;
        int i;
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        if (((GameLoadData)localObject).a())
        {
          i = 3;
          if (((GameLoadData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin > 0) {
            i = ((GameLoadData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("stat_type", 2);
          localJSONObject2.put("webview_click", ((GameLoadData)localObject).jdField_a_of_type_Long);
          localJSONObject2.put("webview_start", ((GameLoadData)localObject).b);
          localJSONObject2.put("webview_head", ((GameLoadData)localObject).c);
          localJSONObject2.put("webview_body", ((GameLoadData)localObject).d);
          localJSONObject2.put("webview_close", System.currentTimeMillis());
          if (!((GameLoadData)localObject).jdField_a_of_type_Boolean) {
            break label191;
          }
          localJSONObject2.put("wvalive", 1);
        }
        for (;;)
        {
          localJSONObject1.put("statistics_data_report", localJSONObject2.toString());
          NativeAdUtils.a(new AdReportData().a(25).b(i).a(((GameLoadData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1));
          ReadinjoyAdCache.a(2);
          return;
          label191:
          localJSONObject2.put("wvalive", 0);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + localException.getMessage());
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getDrawingCache());
    paramActivity.setDrawingCacheEnabled(false);
    if (localBitmap == null) {
      return;
    }
    ReadinjoyAdCache.a(paramInt, localBitmap);
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    a(ReadInJoyVideoFeedsAdUtils.a(paramVideoAdInfo));
  }
  
  public static void a(VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramVideoInfo == null) || (!paramVideoInfo.c) || (paramADVideoItemHolder == null) || (paramVideoInfo.a == null) || (TextUtils.isEmpty(paramVideoInfo.a.v))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.v);
        if (!paramVideoInfo.has("AdsIconText")) {
          break;
        }
        if (!TextUtils.isEmpty(paramVideoInfo.optString("AdsIconText")))
        {
          if (paramADVideoItemHolder.a() != null) {
            paramADVideoItemHolder.a().setText(paramVideoInfo.optString("AdsIconText"));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyAdUtils", 2, "detail ad  video adInconText:" + paramVideoInfo.optString("AdsIconText"));
          return;
        }
      }
      catch (Exception paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return;
      }
      if (paramADVideoItemHolder.a == 4)
      {
        if (paramADVideoItemHolder.a() != null) {
          paramADVideoItemHolder.a().setVisibility(8);
        }
      }
      else if (paramADVideoItemHolder.a() != null) {
        paramADVideoItemHolder.a().setVisibility(8);
      }
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        paramAdvertisementInfo = new GdtAd(ReadinJoyActionUtil.a(paramAdvertisementInfo));
        GdtPreLoader.a().a(paramAdvertisementInfo);
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "preLoadAdForMiniProgram fail");
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = null;
    if (paramVideoFeedsPlayManager != null) {
      localVideoPlayParam = paramVideoFeedsPlayManager.a();
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
        a(localVideoPlayParam, true);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 39) && (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl))) {}
    for (;;)
    {
      try
      {
        Object localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
        if (!((IMiniAppService)localObject).startMiniApp(paramContext, paramArticleInfo.mArticleContentUrl, 2103, null)) {
          ((IMiniAppService)localObject).startMiniApp(paramContext, paramArticleInfo.mSmallMiniGameInfo.k, 2103, null);
        }
        if (paramArticleInfo.mSmallMiniGameInfo != null) {
          NativeAdUtils.a(paramContext, paramArticleInfo, paramInt, 1);
        }
        if (!paramArticleInfo.hasChannelInfo()) {
          continue;
        }
        paramInt = paramArticleInfo.mChannelInfoId;
        if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
          continue;
        }
        i = 0;
        localObject = RIJFeedsType.b(paramArticleInfo);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), 0, paramInt, i, NetworkUtil.h(paramContext), (String)localObject, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo), false);
        AdMiniGameGuideManager.a.a();
      }
      catch (Exception paramContext)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyAdUtils", 2, "jump to mini game error " + paramContext.getMessage());
        continue;
      }
      paramContext = new ReportInfo.VideoExtraRepoerData();
      paramContext.d = 0;
      paramContext.e = 0;
      paramContext.c = 1;
      VideoReporter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID, 25, -1L, paramContext);
      return;
      paramInt = 0;
      continue;
      i = 1;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = a(paramBaseArticleInfo.mSubscribeName);
    paramBaseArticleInfo = (BaseArticleInfo)localObject;
    if (((String)localObject).length() > 13) {
      paramBaseArticleInfo = ((String)localObject).substring(0, 12) + "…";
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("info_source_text", paramBaseArticleInfo);
    paramJSONObject.put("id_info_source", localObject);
  }
  
  public static void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null)) {
      paramVideoPlayParam.a.e = false;
    }
  }
  
  public static void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null)) {
      paramVideoPlayParam.a.e = paramBoolean;
    }
  }
  
  public static void a(AdData paramAdData)
  {
    a(ReadInJoyBottomAdVideoUtil.a(paramAdData));
  }
  
  public static void a(JSONObject paramJSONObject, AdvertisementExtInfo paramAdvertisementExtInfo)
  {
    if (paramAdvertisementExtInfo == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject;
          if (!TextUtils.isEmpty(paramAdvertisementExtInfo.c))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("iconUrl", paramAdvertisementExtInfo.c);
            paramJSONObject.put("id_pk_icon", localObject);
          }
          if ((paramAdvertisementExtInfo.a != null) && (paramAdvertisementExtInfo.c.length() >= 2))
          {
            localObject = (AdPKImageData)paramAdvertisementExtInfo.a.get(0);
            JSONObject localJSONObject;
            if (!TextUtils.isEmpty(((AdPKImageData)localObject).d))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("iconUrl", ((AdPKImageData)localObject).d);
              paramJSONObject.put("id_pk_image_bg_left", localJSONObject);
            }
            if (!TextUtils.isEmpty(((AdPKImageData)localObject).c))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("text", ((AdPKImageData)localObject).c);
              paramJSONObject.put("id_pk_label_left", localJSONObject);
            }
            paramAdvertisementExtInfo = (AdPKImageData)paramAdvertisementExtInfo.a.get(1);
            if (!TextUtils.isEmpty(paramAdvertisementExtInfo.d))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("iconUrl", paramAdvertisementExtInfo.d);
              paramJSONObject.put("id_pk_image_bg_right", localObject);
            }
            if (!TextUtils.isEmpty(paramAdvertisementExtInfo.c))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("text", paramAdvertisementExtInfo.c);
              paramJSONObject.put("id_pk_label_right", localObject);
              return;
            }
          }
        }
        catch (Exception paramJSONObject) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindPkButton error message:" + paramJSONObject.getMessage());
  }
  
  public static boolean a(int paramInt)
  {
    return (a.contains(Integer.valueOf(paramInt))) || (DailyModeConfigHandler.b(paramInt));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    try
    {
      paramString.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    if ((HippyQQEngine.getModuleOnlineConfig("TKDMiniGame") == 1) && (paramInt == 41708) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("h5GameSource")))
    {
      QLog.d("ReadInJoyAdUtils", 2, "jumpToMiniGameHippyTab scheme: " + paramString);
      Intent localIntent = ReadInJoyActivityHelper.b(paramContext, 0, paramInt);
      if (!(paramContext instanceof BaseActivity)) {
        localIntent.setFlags(268435456);
      }
      localIntent.putExtra("key_channel_jump_scheme", paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static boolean a(Rect paramRect)
  {
    if ((paramRect.width() <= 0) || (paramRect.height() <= 0)) {}
    while ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right < 0) || (paramRect.bottom < 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    if (!TextUtils.isEmpty(paramVideoAdInfo.D)) {}
    for (;;)
    {
      return true;
      Object localObject = paramVideoAdInfo.v;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("video_rowkey")) {
          paramVideoAdInfo.D = ((JSONObject)localObject).optString("video_rowkey", "");
        }
        boolean bool = TextUtils.isEmpty(paramVideoAdInfo.D);
        if (bool) {
          return false;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.F));
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) {}
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      boolean bool3 = PackageUtil.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      paramArticleInfo = (AdvertisementInfo)paramArticleInfo;
      bool1 = bool2;
      if (paramArticleInfo.mChannelID == 0L)
      {
        bool1 = bool2;
        if (paramArticleInfo.mAdMaterialId == 185)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(ReadinJoyActionUtil.a(paramArticleInfo, "AdsIconText"))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
      if (paramBaseArticleInfo == null)
      {
        ReadInJoyAdLog.a("isEducationLargeImgAd", "adExtInfo is empty");
        return false;
      }
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo);
      if (paramBaseArticleInfo.has("showAdType")) {
        try
        {
          int i = paramBaseArticleInfo.getInt("showAdType");
          if (i == 1019) {
            return true;
          }
        }
        catch (Exception paramBaseArticleInfo)
        {
          ReadInJoyAdLog.a("isEducationLargeImgAd", "showAdType格式错误");
        }
      }
    }
    return false;
  }
  
  public static boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null)) {
      return paramVideoPlayParam.a.e;
    }
    return false;
  }
  
  public static boolean a(VideoFeedsGameAdComBarConfigure paramVideoFeedsGameAdComBarConfigure)
  {
    String str = ReadInJoyHelper.a("sp_key_ad_soft_total_area");
    if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {}
    int i;
    int j;
    do
    {
      return true;
      i = ParseUtil.a(ReadInJoyHelper.a("sp_key_ad_soft_ad_max"), 25);
      j = paramVideoFeedsGameAdComBarConfigure.b();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdUtils", 2, "isOverAdFrequency: dayDisplayCount=" + j + ",adShowMaxCount=" + i);
      }
    } while (j > i);
    return false;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (e(paramAdvertisementInfo)) {
      return 116;
    }
    return 39;
  }
  
  public static String b(AdvertisementInfo paramAdvertisementInfo)
  {
    String str = HardCodeUtil.a(2131712793);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = str;
      if (localJSONObject.has("AdsIconText")) {
        paramAdvertisementInfo = localJSONObject.optString("AdsIconText");
      }
      return paramAdvertisementInfo;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return str;
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        GameLoadData localGameLoadData = new GameLoadData();
        localGameLoadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        localGameLoadData.jdField_a_of_type_JavaLangString = String.valueOf(paramAdvertisementInfo.mAdAid);
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
        {
          paramAdvertisementInfo = Uri.parse(paramAdvertisementInfo.mAdLandingPage).getQueryParameter("adtag");
          if (!TextUtils.isEmpty(paramAdvertisementInfo))
          {
            int i = paramAdvertisementInfo.lastIndexOf(".");
            if ((i > 0) && (i < paramAdvertisementInfo.length() - 1)) {
              localGameLoadData.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.substring(i + 1);
            }
          }
        }
        localGameLoadData.jdField_a_of_type_Long = System.currentTimeMillis();
        ReadinjoyAdCache.a(2, localGameLoadData);
        ThreadManager.getSubThreadHandler().post(new ReadInJoyAdUtils.1());
        return;
      }
      catch (Exception paramAdvertisementInfo) {}
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "addGdtWebClickReport fail message:" + paramAdvertisementInfo.getMessage());
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      if (localJSONObject == null)
      {
        ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
        return;
      }
      Object localObject = localJSONObject.optJSONArray("ad_bubble_texts");
      if ((localObject == null) || (((JSONArray)localObject).length() <= 1))
      {
        ReadInJoyAdLog.a("ReadInJoyAdUtils", "bindBubble JSONArray is empty");
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
      paramJSONObject.put("id_article_bubble_view", localObject);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindBubble ad_bubble_texts:" + localJSONObject.optString("ad_bubble_texts"));
  }
  
  public static boolean b(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.F)) && (!TextUtils.isEmpty(paramVideoInfo.a.E));
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mPopFormH5Url)) || (!ReadInJoyAdSwitchUtil.d(paramAdvertisementInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
      if (paramBaseArticleInfo == null)
      {
        ReadInJoyAdLog.a("isEducationLargeImgAd", "adExtInfo is empty");
        return false;
      }
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo);
      if (paramBaseArticleInfo.has("showAdType")) {
        try
        {
          int i = paramBaseArticleInfo.getInt("showAdType");
          if (i == 1020) {
            return true;
          }
        }
        catch (Exception paramBaseArticleInfo)
        {
          ReadInJoyAdLog.a("isEducationLargeImgAd", "showAdType格式错误");
        }
      }
    }
    return false;
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      JSONObject localJSONObject;
      do
      {
        return;
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        localJSONObject = new JSONObject(localAdvertisementInfo.mAdExtInfo);
        if (localJSONObject == null)
        {
          ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
          return;
        }
      } while (!d(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.optJSONArray("ad_bg_img");
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.length() >= 1))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("atmosphere_image_url", (String)paramBaseArticleInfo.get(0));
        paramJSONObject.put("id_atmosphere_image", localJSONObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "ad_bg_img:" + localAdvertisementInfo.mAdExtInfo);
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(paramAdvertisementInfo.mInteractImageList));
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return false;
    }
    paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
    if (paramBaseArticleInfo == null)
    {
      ReadInJoyAdLog.a("bindAdColorIcon", "adExtInfo is empty");
      return false;
    }
    return new JSONObject(paramBaseArticleInfo).has("ad_color_tags");
  }
  
  public static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo) == null)
    {
      ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
      return;
    }
    if (a(paramBaseArticleInfo))
    {
      paramJSONObject.put("id_ad_education_main_body", new JSONObject());
      paramJSONObject.put("style_ID", "ReadInjoy_ad_education_large_cell");
      return;
    }
    if (d(paramBaseArticleInfo))
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_large_atmosphere_cell");
      return;
    }
    paramJSONObject.put("style_ID", "ReadInjoy_ad_large_cell");
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    return paramAdvertisementInfo.downloadState != 3;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return false;
      paramBaseArticleInfo = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      if (paramBaseArticleInfo == null)
      {
        ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
        return false;
      }
    } while (!paramBaseArticleInfo.has("ad_bg_img"));
    return true;
  }
  
  public static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo) == null)
    {
      ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
      return;
    }
    if (b(paramBaseArticleInfo))
    {
      paramJSONObject.put("id_ad_education_main_body", new JSONObject());
      paramJSONObject.put("style_ID", "ReadInjoy_ad_education_video_cell");
      return;
    }
    if (d(paramBaseArticleInfo))
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_video_atmopsphere_cell");
      return;
    }
    paramJSONObject.put("style_ID", "ReadInjoy_ad_video_cell");
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 38) && (paramBaseArticleInfo.smallGameData != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    Object localObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
    if (localObject == null)
    {
      ReadInJoyAdLog.a("ReadInJoyAdUtils", "adExtInfo is empty");
      return;
    }
    localObject = ((JSONObject)localObject).getJSONObject("kol_info");
    paramBaseArticleInfo = a(paramBaseArticleInfo.mTitle);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("education_article_title_text", paramBaseArticleInfo);
    paramJSONObject.put("id_artilce_title", localJSONObject);
    paramBaseArticleInfo = ((JSONObject)localObject).getString("kol_head");
    localJSONObject = new JSONObject();
    localJSONObject.put("education_advertisers_imge_url", paramBaseArticleInfo);
    paramJSONObject.put("id_ad_education_advertisers_img", localJSONObject);
    localObject = a(((JSONObject)localObject).getString("kol_name"));
    paramBaseArticleInfo = (BaseArticleInfo)localObject;
    if (((String)localObject).length() > 16) {
      paramBaseArticleInfo = ((String)localObject).substring(0, 15) + "…";
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("education_teacher_text", paramBaseArticleInfo);
    paramJSONObject.put("id_education_teacher", localObject);
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1003 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 38) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!paramBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      do
      {
        do
        {
          return;
          localJSONObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
          paramJSONObject.put("id_info_operate_parent", new JSONObject());
          paramJSONObject.put("id_large_cell_container", new JSONObject());
          if (!localJSONObject.has("AdsIconText")) {
            break;
          }
          paramBaseArticleInfo = new JSONObject();
          if (!TextUtils.isEmpty(localJSONObject.optString("AdsIconText")))
          {
            paramBaseArticleInfo.put("info_status_text", localJSONObject.optString("AdsIconText"));
            paramJSONObject.put("id_info_status", paramBaseArticleInfo);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus AdsIconText:" + localJSONObject.optString("AdsIconText"));
        return;
      } while (TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("info_status_text", paramBaseArticleInfo.mArticleSubscriptText);
      paramJSONObject.put("id_info_status", localJSONObject);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus mArticleSubscriptText:" + paramBaseArticleInfo.mArticleSubscriptText);
  }
  
  public static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1022 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("1"));
  }
  
  public static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return;
      paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
      if (paramBaseArticleInfo == null)
      {
        ReadInJoyAdLog.a("bindAdColorIcon", "adExtInfo is empty");
        return;
      }
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo).optJSONArray("ad_color_tags");
    } while ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.length() < 1));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("color_label_path", (String)paramBaseArticleInfo.get(0));
    paramJSONObject.put("id_ad_color_label_img", localJSONObject);
  }
  
  public static boolean h(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo == null)) {}
    while ((1014 != paramAdvertisementInfo.mAdvertisementExtInfo.i) && (1015 != paramAdvertisementInfo.mAdvertisementExtInfo.i)) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39);
  }
  
  public static void i(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
    try
    {
      ReadInJoyAdGradeUtil.a(new JSONObject(paramBaseArticleInfo.mAdExtInfo), paramJSONObject);
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    return (h(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo.jdField_r_of_type_Int == 1);
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("5"));
  }
  
  public static void j(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = 0;
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    Object localObject1 = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
    if (localObject1 == null)
    {
      ReadInJoyAdLog.a("bindAdSourceTag", "adExtInfo is empty");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("ad_tags");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
      {
        ReadInJoyAdLog.a("bindAdSourceTag", "JSONArray is empty");
        return;
      }
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).get(i);
        if (((localObject2 instanceof String)) && (i < 3)) {
          localArrayList.add(i, (String)localObject2);
        }
      }
      else
      {
        if ((localArrayList.size() > 0) && (localArrayList.get(0) != null))
        {
          paramJSONObject.put("ad_tag_text1", localArrayList.get(0));
          ReadInJoyAdLog.a("bindAdSourceTag", "one: " + (String)localArrayList.get(0));
        }
        if ((localArrayList.size() > 1) && (localArrayList.get(1) != null))
        {
          paramJSONObject.put("ad_tag_text2", localArrayList.get(1));
          ReadInJoyAdLog.a("bindAdSourceTag", "two: " + (String)localArrayList.get(1));
        }
        if ((localArrayList.size() > 2) && (localArrayList.get(2) != null))
        {
          paramJSONObject.put("ad_tag_text3", localArrayList.get(2));
          ReadInJoyAdLog.a("bindAdSourceTag", "three: " + (String)localArrayList.get(2));
        }
        localJSONObject.put("article_model", paramBaseArticleInfo);
        paramJSONObject.put("id_blur_img", localJSONObject);
        paramJSONObject.remove("id_article_double_image");
        paramJSONObject.remove("id_article_large_imge");
        return;
      }
      i += 1;
    }
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("2"));
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((l(paramBaseArticleInfo)) || ((paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (l((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)))));
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("4"));
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    return (j(paramBaseArticleInfo)) || (g(paramBaseArticleInfo)) || (h(paramBaseArticleInfo)) || (i(paramBaseArticleInfo)) || (k(paramBaseArticleInfo));
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {}
    while ((!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) || ((!paramBaseArticleInfo.mVideoVid.startsWith("http://")) && (!paramBaseArticleInfo.mVideoVid.startsWith("https://")))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils
 * JD-Core Version:    0.7.0.1
 */