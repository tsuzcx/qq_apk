package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GameLoadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJMiniGameService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class ReadInJoyAdUtils
{
  private static HashSet<Integer> a = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(56), Integer.valueOf(40531), Integer.valueOf(14), Integer.valueOf(40174), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(11), Integer.valueOf(40466), Integer.valueOf(41541), Integer.valueOf(40013), Integer.valueOf(58), Integer.valueOf(16), Integer.valueOf(53), Integer.valueOf(52), Integer.valueOf(41629), Integer.valueOf(55), Integer.valueOf(40007), Integer.valueOf(59), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(54), Integer.valueOf(41504) }));
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 10000;
    } else {
      i = 3000;
    }
    if (TextUtils.isEmpty(paramString)) {
      return i;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("cards_show_timming");
        if (TextUtils.isEmpty(paramString)) {
          return i;
        }
        paramString = new JSONObject(paramString);
        int j;
        if (paramBoolean)
        {
          j = paramString.optInt("show_cards");
          if (j < 0) {
            break label105;
          }
          i = j;
        }
        else
        {
          j = paramString.optInt("change_color");
          if (j >= 0) {
            i = j;
          } else {
            i = 3000;
          }
        }
        return i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return i;
      }
      label105:
      i = 10000;
    }
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = null;
    Object localObject = localMatrix;
    for (;;)
    {
      try
      {
        paramString = new URL(paramString).openConnection();
        localObject = localMatrix;
        int i = ((HttpURLConnection)paramString).getContentLength();
        localObject = localMatrix;
        paramString.connect();
        localObject = localMatrix;
        InputStream localInputStream = paramString.getInputStream();
        localObject = localMatrix;
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(localInputStream, i);
        localObject = localMatrix;
        paramString = BitmapFactory.decodeStream(localBufferedInputStream);
        localObject = paramString;
        i = paramString.getWidth();
        localObject = paramString;
        int j = paramString.getHeight();
        float f1 = 1.0F;
        if ((i > 0) && (j > 0))
        {
          localObject = paramString;
          f1 = paramInt1 / i;
          localObject = paramString;
          f2 = paramInt2 / j;
          localObject = paramString;
          localMatrix = new Matrix();
          localObject = paramString;
          localMatrix.postScale(f1, f2);
          localObject = paramString;
          paramString = Bitmap.createBitmap(paramString, 0, 0, i, j, localMatrix, true);
          localObject = paramString;
          localBufferedInputStream.close();
          localObject = paramString;
          localInputStream.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localObject;
      }
      float f2 = 1.0F;
    }
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    float f2 = AIOUtils.b(1.0F, paramContext.getResources());
    float f1 = 6;
    paramContext = new RectF(f2, f2, f2, f2);
    f2 = 5;
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, paramContext, new float[] { f2, f2, f2, f2, f2, f2, f2, f2 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramContext.getPaint().setShader(localLinearGradient);
    return paramContext;
  }
  
  public static String a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong != 0L)
    {
      if (paramLong > 99990000L)
      {
        localStringBuilder.append("9999万+");
      }
      else if (paramLong > 10000L)
      {
        double d = paramLong;
        Double.isNaN(d);
        d /= 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
      }
      else
      {
        localStringBuilder.append(paramLong);
      }
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  @NonNull
  public static String a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    String str1 = "下载";
    String str2 = "";
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdProductType == 12)) {}
    try
    {
      if (PackageUtil.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name")))
      {
        paramContext = "打开";
      }
      else
      {
        boolean bool = TextUtils.isEmpty("");
        paramContext = str2;
        if (bool) {
          paramContext = str1;
        }
      }
    }
    catch (JSONException paramContext)
    {
      label67:
      break label67;
    }
    paramContext = str2;
    if (TextUtils.isEmpty(""))
    {
      return str1;
      paramContext = str2;
      if (TextUtils.isEmpty("")) {
        paramContext = "查看";
      }
    }
    return paramContext;
    return paramContext;
  }
  
  @NonNull
  public static String a(Context paramContext, VideoInfo paramVideoInfo, int paramInt)
  {
    boolean bool = a(paramVideoInfo);
    String str1 = "查看详情";
    String str2 = "详情";
    Object localObject2 = str1;
    Object localObject3 = str2;
    if (bool)
    {
      i = paramVideoInfo.as.o;
      localObject1 = "立即下载";
      if (i != 12) {}
    }
    try
    {
      localObject2 = new JSONObject(paramVideoInfo.as.A);
      if (PackageUtil.a(paramContext, ((JSONObject)localObject2).optString("pkg_name")))
      {
        if (paramInt != 1) {
          break label248;
        }
        return "打开";
      }
      if (ADBaseAppDownloadManager.a(BaseApplicationImpl.getContext(), ((JSONObject)localObject2).optString("pkg_name")))
      {
        localObject2 = "安装";
        paramContext = HardCodeUtil.a(2131898189);
        localObject1 = localObject2;
      }
    }
    catch (JSONException paramContext)
    {
      label121:
      break label121;
    }
    localObject2 = "下载";
    paramContext = (Context)localObject1;
    Object localObject1 = localObject2;
    break label144;
    paramContext = "查看详情";
    localObject1 = "详情";
    label144:
    int i = paramVideoInfo.as.at;
    if (i != 1)
    {
      localObject2 = str1;
      localObject3 = str2;
      if (i != 28)
      {
        localObject2 = paramContext;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject3 = "购买";
      localObject2 = "立即购买";
    }
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramVideoInfo.as.au)) {
        return localObject3;
      }
      return paramVideoInfo.as.au;
    }
    if (TextUtils.isEmpty(paramVideoInfo.as.av)) {
      return localObject2;
    }
    return paramVideoInfo.as.av;
    label248:
    return "立即打开";
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    String str = paramAbsBaseArticleInfo.getSubscribeName();
    Object localObject = str;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo)) {}
    }
    try
    {
      localObject = new JSONObject(((AdvertisementInfo)localObject).mAdExt).getString("appname");
    }
    catch (JSONException localJSONException)
    {
      label77:
      int j;
      int i;
      break label77;
    }
    localObject = str;
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyAdUtils", 2, "cannot get name from app advertisement");
      localObject = str;
      break label107;
      localObject = ((AdvertisementInfo)localObject).mAdCorporateImageName;
    }
    label107:
    j = paramAbsBaseArticleInfo.mSubscribeName.length();
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
      i = 9;
    } else {
      i = 18;
    }
    if (j > i)
    {
      localObject = new StringBuilder();
      str = paramAbsBaseArticleInfo.mSubscribeName;
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
        i = 8;
      } else {
        i = 17;
      }
      ((StringBuilder)localObject).append(str.substring(0, i));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
    if ((paramAdvertisementInfo != null) && (paramJSONObject != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo))) {
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdExt)) {
        return paramJSONObject;
      }
    }
    for (;;)
    {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
        if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(paramContext, paramAdvertisementInfo)) {
          break label135;
        }
        i = 2;
        paramJSONObject.put("action_type", i);
        return paramJSONObject;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramAdvertisementInfo = new StringBuilder();
          paramAdvertisementInfo.append("doGdtWebClickReport fail message:");
          paramAdvertisementInfo.append(paramContext.getMessage());
          QLog.e("ReadInJoyAdUtils", 2, paramAdvertisementInfo.toString());
        }
      }
      return paramJSONObject;
      label135:
      int i = 1;
    }
  }
  
  public static void a()
  {
    Object localObject1 = ReadinjoyAdCache.b(2);
    if ((localObject1 instanceof GameLoadData)) {
      try
      {
        localObject1 = (GameLoadData)localObject1;
        if (((GameLoadData)localObject1).a())
        {
          int i = 3;
          if (((GameLoadData)localObject1).a.mOrigin > 0) {
            i = ((GameLoadData)localObject1).a.mOrigin;
          }
          localObject2 = new JSONObject();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("stat_type", 2);
          localJSONObject.put("webview_click", ((GameLoadData)localObject1).c);
          localJSONObject.put("webview_start", ((GameLoadData)localObject1).d);
          localJSONObject.put("webview_head", ((GameLoadData)localObject1).e);
          localJSONObject.put("webview_body", ((GameLoadData)localObject1).f);
          localJSONObject.put("webview_close", System.currentTimeMillis());
          boolean bool = ((GameLoadData)localObject1).g;
          if (bool) {
            localJSONObject.put("wvalive", 1);
          } else {
            localJSONObject.put("wvalive", 0);
          }
          ((JSONObject)localObject2).put("statistics_data_report", localJSONObject.toString());
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(25).b(i).a(((GameLoadData)localObject1).a).e((JSONObject)localObject2));
        }
        ReadinjoyAdCache.a(2);
        return;
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doGdtWebClickReport fail message:");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.e("ReadInJoyAdUtils", 2, ((StringBuilder)localObject2).toString());
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
  
  public static void a(View paramView, int paramInt)
  {
    try
    {
      localObject = paramView.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height == paramInt) {
        return;
      }
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Exception paramView)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("height error");
      ((StringBuilder)localObject).append(paramView.getMessage());
      ReadInJoyAdLog.a("ReadInJoyAdUtils", ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramIVideoFeedsPlayManager != null) {
      paramIVideoFeedsPlayManager = paramIVideoFeedsPlayManager.v();
    } else {
      paramIVideoFeedsPlayManager = null;
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
        a(paramIVideoFeedsPlayManager, true);
      }
    }
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).preLoadAdForMiniProgram(ReadInJoyVideoFeedsAdUtils.a(paramVideoAdInfo));
  }
  
  public static void a(AdData paramAdData)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).preLoadAdForMiniProgram(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData));
  }
  
  public static void a(VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.aq) && (paramADVideoItemHolder != null) && (paramVideoInfo.as != null))
    {
      if (TextUtils.isEmpty(paramVideoInfo.as.R)) {
        return;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.as.R);
        if (paramVideoInfo.has("AdsIconText"))
        {
          if (!TextUtils.isEmpty(paramVideoInfo.optString("AdsIconText")))
          {
            if (paramADVideoItemHolder.b() != null) {
              paramADVideoItemHolder.b().setText(paramVideoInfo.optString("AdsIconText"));
            }
          }
          else if (paramADVideoItemHolder.X == 4)
          {
            if (paramADVideoItemHolder.a() != null) {
              paramADVideoItemHolder.a().setVisibility(8);
            }
          }
          else if (paramADVideoItemHolder.b() != null) {
            paramADVideoItemHolder.b().setVisibility(8);
          }
          if (QLog.isColorLevel())
          {
            paramADVideoItemHolder = new StringBuilder();
            paramADVideoItemHolder.append("detail ad  video adInconText:");
            paramADVideoItemHolder.append(paramVideoInfo.optString("AdsIconText"));
            QLog.d("ReadInJoyAdUtils", 2, paramADVideoItemHolder.toString());
            return;
          }
        }
      }
      catch (Exception paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
    }
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.f != null)) {
      paramVideoPlayParam.f.l = paramBoolean;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl))) {}
    for (;;)
    {
      try
      {
        localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
        if (!((IMiniAppService)localObject).startMiniApp(paramContext, paramAbsBaseArticleInfo.mArticleContentUrl, 2103, null)) {
          ((IMiniAppService)localObject).startMiniApp(paramContext, paramAbsBaseArticleInfo.mSmallMiniGameInfo.n, 2103, null);
        }
        if (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) {
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromArticle(paramContext, paramAbsBaseArticleInfo, paramInt, 1);
        }
        if (!paramAbsBaseArticleInfo.hasChannelInfo()) {
          break label429;
        }
        paramInt = paramAbsBaseArticleInfo.mChannelInfoId;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText)) {
          break label434;
        }
        i = 0;
        localObject = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(paramAbsBaseArticleInfo);
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str1 = paramAbsBaseArticleInfo.mSubscribeID;
        String str2 = Long.toString(paramAbsBaseArticleInfo.mFeedId);
        String str3 = Long.toString(paramAbsBaseArticleInfo.mArticleID);
        String str4 = Integer.toString(paramAbsBaseArticleInfo.mStrategyId);
        IRIJTransMergeKanDianReport localIRIJTransMergeKanDianReport = (IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class);
        long l = paramAbsBaseArticleInfo.mAlgorithmID;
        int j = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo);
        boolean bool = NetworkUtil.isWifiConnected(paramContext);
        paramContext = paramAbsBaseArticleInfo.mStrCircleId;
        String str5 = paramAbsBaseArticleInfo.innerUniqueID;
        String str6 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo);
        try
        {
          localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, "0X8007625", "0X8007625", 0, 0, str2, str3, str4, localIRIJTransMergeKanDianReport.transMergeKandianReportR5WithTime(l, j, 0, paramInt, i, bool, (String)localObject, paramContext, str5, str6, paramAbsBaseArticleInfo), false);
          ((IRIJMiniGameService)QRoute.api(IRIJMiniGameService.class)).checkIsFollowed();
        }
        catch (Exception paramContext) {}
        if (!QLog.isColorLevel()) {
          break label379;
        }
      }
      catch (Exception paramContext) {}
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump to mini game error ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("ReadInJoyAdUtils", 2, ((StringBuilder)localObject).toString());
      label379:
      paramContext = new ReportInfo.VideoExtraRepoerData();
      paramContext.d = 0;
      paramContext.e = 0;
      paramContext.c = 1;
      ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoUserOperationByOidbOfFeed(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID, 25, -1L, paramContext);
      return;
      label429:
      paramInt = 0;
      continue;
      label434:
      int i = 1;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = a(paramAbsBaseArticleInfo.mSubscribeName);
    paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
    if (((String)localObject).length() > 13)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append(((String)localObject).substring(0, 12));
      paramAbsBaseArticleInfo.append("…");
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("info_source_text", paramAbsBaseArticleInfo);
    paramJSONObject.put("id_info_source", localObject);
  }
  
  public static void a(JSONObject paramJSONObject, AdvertisementExtInfo paramAdvertisementExtInfo)
  {
    if (paramAdvertisementExtInfo == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramAdvertisementExtInfo.n);
      Object localObject;
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("iconUrl", paramAdvertisementExtInfo.n);
        paramJSONObject.put("id_pk_icon", localObject);
      }
      if (paramAdvertisementExtInfo.m != null)
      {
        if (paramAdvertisementExtInfo.n.length() < 2) {
          return;
        }
        localObject = (AdPKImageData)paramAdvertisementExtInfo.m.get(0);
        JSONObject localJSONObject;
        if (!TextUtils.isEmpty(((AdPKImageData)localObject).d))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("iconUrl", ((AdPKImageData)localObject).d);
          paramJSONObject.put("id_pk_image_bg_left", localJSONObject);
        }
        bool = TextUtils.isEmpty(((AdPKImageData)localObject).c);
        if (!bool)
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", ((AdPKImageData)localObject).c);
          paramJSONObject.put("id_pk_label_left", localJSONObject);
        }
        paramAdvertisementExtInfo = (AdPKImageData)paramAdvertisementExtInfo.m.get(1);
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
        }
      }
      else {}
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        paramAdvertisementExtInfo = new StringBuilder();
        paramAdvertisementExtInfo.append("bindPkButton error message:");
        paramAdvertisementExtInfo.append(paramJSONObject.getMessage());
        QLog.d("ReadInJoyAdUtils", 2, paramAdvertisementExtInfo.toString());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (a.contains(Integer.valueOf(paramInt))) || (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDailyUnlimitChannel(paramInt));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      if (paramString == null) {
        return false;
      }
    }
    try
    {
      paramString.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    if ((HippyCommonUtils.getModuleOnlineConfig("TKDMiniGame") == 1) && (paramInt == 41708) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("h5GameSource")))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToMiniGameHippyTab scheme: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ReadInJoyAdUtils", 2, ((StringBuilder)localObject).toString());
      localObject = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, 0, paramInt);
      if (!(paramContext instanceof BaseActivity)) {
        ((Intent)localObject).setFlags(268435456);
      }
      ((Intent)localObject).putExtra("key_channel_jump_scheme", paramString);
      paramContext.startActivity((Intent)localObject);
      return true;
    }
    return false;
  }
  
  public static boolean a(Rect paramRect)
  {
    int i = paramRect.width();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      if (paramRect.height() <= 0) {
        return false;
      }
      bool1 = bool2;
      if (paramRect.left >= 0)
      {
        bool1 = bool2;
        if (paramRect.top >= 0)
        {
          bool1 = bool2;
          if (paramRect.right >= 0)
          {
            bool1 = bool2;
            if (paramRect.bottom >= 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) {}
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo);
      return bool;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static boolean a(VideoFeedsGameAdComBarConfigure paramVideoFeedsGameAdComBarConfigure)
  {
    String str = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_total_area");
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = true;
    if (!bool2)
    {
      if ("0".equals(str)) {
        return true;
      }
      int i = ParseUtil.a(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_ad_max"), 25);
      int j = paramVideoFeedsGameAdComBarConfigure.c();
      if (QLog.isColorLevel())
      {
        paramVideoFeedsGameAdComBarConfigure = new StringBuilder();
        paramVideoFeedsGameAdComBarConfigure.append("isOverAdFrequency: dayDisplayCount=");
        paramVideoFeedsGameAdComBarConfigure.append(j);
        paramVideoFeedsGameAdComBarConfigure.append(",adShowMaxCount=");
        paramVideoFeedsGameAdComBarConfigure.append(i);
        QLog.d("ReadInJoyAdUtils", 2, paramVideoFeedsGameAdComBarConfigure.toString());
      }
      if (j > i) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.as != null) && (!TextUtils.isEmpty(paramVideoInfo.as.ap));
  }
  
  public static boolean a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.f != null)) {
      return paramVideoPlayParam.f.l;
    }
    return false;
  }
  
  public static void b(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.f != null)) {
      paramVideoPlayParam.f.l = false;
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      JSONObject localJSONObject = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
      Object localObject = localJSONObject.optJSONArray("ad_bubble_texts");
      if ((localObject != null) && (((JSONArray)localObject).length() > 1))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", paramAbsBaseArticleInfo);
        paramJSONObject.put("id_article_bubble_view", localObject);
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("bindBubble ad_bubble_texts:");
          paramAbsBaseArticleInfo.append(localJSONObject.optString("ad_bubble_texts"));
          QLog.d("ReadInJoyAdUtils", 2, paramAbsBaseArticleInfo.toString());
        }
        return;
      }
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdUtils", "bindBubble JSONArray is empty");
    }
  }
  
  private static boolean b()
  {
    if (DeviceInfoUtil.d() >= 26) {
      return true;
    }
    String str = Aladdin.getConfig(461).getString("expand_card_switch", "1");
    return (str != null) && (str.equals("1"));
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mPopFormH5Url))
    {
      bool1 = bool2;
      if (ReadInJoyAdSwitchUtil.h(paramAdvertisementInfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(VideoAdInfo paramVideoAdInfo)
  {
    if (!TextUtils.isEmpty(paramVideoAdInfo.am)) {
      return true;
    }
    Object localObject = paramVideoAdInfo.R;
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("video_rowkey")) {
        paramVideoAdInfo.am = ((JSONObject)localObject).optString("video_rowkey", "");
      }
      boolean bool = TextUtils.isEmpty(paramVideoAdInfo.am);
      return bool ^ true;
    }
    catch (JSONException paramVideoAdInfo)
    {
      paramVideoAdInfo.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.as != null) && (!TextUtils.isEmpty(paramVideoInfo.as.ap)) && (!TextUtils.isEmpty(paramVideoInfo.as.ao));
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return false;
      }
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
      if (paramAbsBaseArticleInfo == null)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("isEducationLargeImgAd", "adExtInfo is empty");
        return false;
      }
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo);
      if (!paramAbsBaseArticleInfo.has("showAdType")) {
        return false;
      }
    }
    try
    {
      int i = paramAbsBaseArticleInfo.getInt("showAdType");
      if (i == 1019) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      label89:
      break label89;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("isEducationLargeImgAd", "showAdType格式错误");
    return false;
  }
  
  public static int c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return ParseUtil.a(paramAdvertisementInfo.gameAdComData.t, 0);
    }
    return ((Integer)ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo.mAdExtInfo, "game_button_type", Integer.valueOf(0))).intValue();
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      Object localObject = new JSONObject(localAdvertisementInfo.mAdExtInfo);
      if (e(paramAbsBaseArticleInfo))
      {
        localObject = ((JSONObject)localObject).optJSONArray("ad_bg_img");
        if ((localObject != null) && (((JSONArray)localObject).length() >= 1))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("atmosphere_image_url", (String)((JSONArray)localObject).get(0));
          paramJSONObject.put("id_atmosphere_image", localJSONObject);
        }
        if ((y(paramAbsBaseArticleInfo)) && (localAdvertisementInfo.mAdvertisementExtInfo != null))
        {
          paramAbsBaseArticleInfo = new JSONObject();
          paramAbsBaseArticleInfo.put("atmosphere_image_url", localAdvertisementInfo.mAdvertisementExtInfo.I);
          paramJSONObject.put("id_atmosphere_image", paramAbsBaseArticleInfo);
        }
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("ad_bg_img:");
          paramAbsBaseArticleInfo.append(localAdvertisementInfo.mAdExtInfo);
          QLog.d("ReadInJoyAdUtils", 2, paramAbsBaseArticleInfo.toString());
        }
      }
    }
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return false;
      }
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
      if (paramAbsBaseArticleInfo == null)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("isEducationLargeImgAd", "adExtInfo is empty");
        return false;
      }
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo);
      if (!paramAbsBaseArticleInfo.has("showAdType")) {
        return false;
      }
    }
    try
    {
      int i = paramAbsBaseArticleInfo.getInt("showAdType");
      if (i == 1020) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      label89:
      break label89;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("isEducationLargeImgAd", "showAdType格式错误");
    return false;
  }
  
  public static String d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return paramAdvertisementInfo.gameAdComData.e;
    }
    return (String)ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo.mAdExtInfo, "game_pkg_name", "");
  }
  
  public static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isEducationLargeImgAd(paramAbsBaseArticleInfo))
      {
        paramJSONObject.put("id_ad_education_main_body", new JSONObject());
        paramJSONObject.put("style_ID", "ReadInjoy_ad_education_large_cell");
        return;
      }
      if (e(paramAbsBaseArticleInfo))
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_large_atmosphere_cell");
        return;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_large_cell");
    }
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return false;
      }
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
      if (paramAbsBaseArticleInfo == null)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("bindAdColorIcon", "adExtInfo is empty");
        return false;
      }
      return new JSONObject(paramAbsBaseArticleInfo).has("ad_color_tags");
    }
    return false;
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isEducationLargeVideoAd(paramAbsBaseArticleInfo))
      {
        paramJSONObject.put("id_ad_education_main_body", new JSONObject());
        paramJSONObject.put("style_ID", "ReadInjoy_ad_education_video_cell");
        return;
      }
      if (e(paramAbsBaseArticleInfo))
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_video_atmopsphere_cell");
        return;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_video_cell");
    }
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(paramAdvertisementInfo.mInteractImageList));
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return false;
      }
      JSONObject localJSONObject = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
      if (y(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (localJSONObject.has("ad_bg_img")) {
        return true;
      }
    }
    return false;
  }
  
  public static void f(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      Object localObject = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo).getJSONObject("kol_info");
      paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo.mTitle);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("education_article_title_text", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_artilce_title", localJSONObject);
      paramAbsBaseArticleInfo = ((JSONObject)localObject).getString("kol_head");
      localJSONObject = new JSONObject();
      localJSONObject.put("education_advertisers_imge_url", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_ad_education_advertisers_img", localJSONObject);
      localObject = a(((JSONObject)localObject).getString("kol_name"));
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
      if (((String)localObject).length() > 16)
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(((String)localObject).substring(0, 15));
        paramAbsBaseArticleInfo.append("…");
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("education_teacher_text", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_education_teacher", localObject);
    }
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return paramAdvertisementInfo.downloadState != 3;
  }
  
  public static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 38) && (paramAbsBaseArticleInfo.smallGameData != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static String g(AdvertisementInfo paramAdvertisementInfo)
  {
    String str = HardCodeUtil.a(2131910342);
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      if (paramAdvertisementInfo.has("AdsIconText"))
      {
        paramAdvertisementInfo = paramAdvertisementInfo.optString("AdsIconText");
        return paramAdvertisementInfo;
      }
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return str;
  }
  
  public static void g(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      Object localObject = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
      paramJSONObject.put("id_info_operate_parent", new JSONObject());
      paramJSONObject.put("id_large_cell_container", new JSONObject());
      boolean bool = DiversionUtil.a();
      if ((((JSONObject)localObject).has("AdsIconText")) && (!bool))
      {
        paramAbsBaseArticleInfo = new JSONObject();
        if (!TextUtils.isEmpty(((JSONObject)localObject).optString("AdsIconText")))
        {
          paramAbsBaseArticleInfo.put("info_status_text", ((JSONObject)localObject).optString("AdsIconText"));
          paramJSONObject.put("id_info_status", paramAbsBaseArticleInfo);
        }
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("bindAdStatus AdsIconText:");
          paramAbsBaseArticleInfo.append(((JSONObject)localObject).optString("AdsIconText"));
          QLog.d("ReadInJoyAdUtils", 2, paramAbsBaseArticleInfo.toString());
        }
      }
      else if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText)) && (!bool))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("info_status_text", paramAbsBaseArticleInfo.mArticleSubscriptText);
        paramJSONObject.put("id_info_status", localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindAdStatus mArticleSubscriptText:");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleSubscriptText);
          QLog.d("ReadInJoyAdUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (bool)
      {
        paramAbsBaseArticleInfo = new JSONObject();
        paramAbsBaseArticleInfo.put("id_ad_diversion_txt", "去广告");
        paramJSONObject.put("id_ad_diversion", paramAbsBaseArticleInfo);
      }
    }
  }
  
  public static boolean g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 38) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (!paramAbsBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static void h(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    try
    {
      paramAdvertisementInfo = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      GdtPreLoader.a().a(paramAdvertisementInfo);
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyAdUtils", 2, "preLoadAdForMiniProgram fail");
      }
    }
  }
  
  public static void h(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
      if (paramAbsBaseArticleInfo == null)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("bindAdColorIcon", "adExtInfo is empty");
        return;
      }
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo).optJSONArray("ad_color_tags");
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.length() >= 1))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("color_label_path", (String)paramAbsBaseArticleInfo.get(0));
        paramJSONObject.put("id_ad_color_label_img", localJSONObject);
      }
    }
  }
  
  public static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.d.equals("1"));
  }
  
  public static void i(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    try
    {
      ReadInJoyAdGradeUtil.a(new JSONObject(paramAbsBaseArticleInfo.mAdExtInfo), paramJSONObject);
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.l);
  }
  
  public static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39);
  }
  
  public static void j(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    Object localObject1 = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
    if (localObject1 == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("bindAdSourceTag", "adExtInfo is empty");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new JSONObject((String)localObject1).optJSONArray("ad_tags");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
        {
          localObject1 = new ArrayList();
          i = 0;
          Object localObject3;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).get(i);
            if (((localObject3 instanceof String)) && (i < 3)) {
              ((ArrayList)localObject1).add(i, (String)localObject3);
            }
          }
          else
          {
            if ((((ArrayList)localObject1).size() > 0) && (((ArrayList)localObject1).get(0) != null))
            {
              paramJSONObject.put("ad_tag_text1", ((ArrayList)localObject1).get(0));
              localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("one: ");
              ((StringBuilder)localObject3).append((String)((ArrayList)localObject1).get(0));
              ((IRIJAdLogService)localObject2).d("bindAdSourceTag", ((StringBuilder)localObject3).toString());
            }
            if ((((ArrayList)localObject1).size() > 1) && (((ArrayList)localObject1).get(1) != null))
            {
              paramJSONObject.put("ad_tag_text2", ((ArrayList)localObject1).get(1));
              localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("two: ");
              ((StringBuilder)localObject3).append((String)((ArrayList)localObject1).get(1));
              ((IRIJAdLogService)localObject2).d("bindAdSourceTag", ((StringBuilder)localObject3).toString());
            }
            if ((((ArrayList)localObject1).size() > 2) && (((ArrayList)localObject1).get(2) != null))
            {
              paramJSONObject.put("ad_tag_text3", ((ArrayList)localObject1).get(2));
              localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("three: ");
              ((StringBuilder)localObject3).append((String)((ArrayList)localObject1).get(2));
              ((IRIJAdLogService)localObject2).d("bindAdSourceTag", ((StringBuilder)localObject3).toString());
            }
            localJSONObject.put("article_model", paramAbsBaseArticleInfo);
            paramJSONObject.put("id_blur_img", localJSONObject);
            paramJSONObject.remove("id_article_double_image");
            paramJSONObject.remove("id_article_large_imge");
          }
        }
        else
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("bindAdSourceTag", "JSONArray is empty");
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public static boolean j(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1003 == paramAdvertisementInfo.mAdvertisementExtInfo.l);
  }
  
  public static boolean j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.d.equals("5"));
  }
  
  public static void k(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null) {}
    for (;;)
    {
      int i;
      Object localObject3;
      Object localObject4;
      Object localObject6;
      try
      {
        if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
          return;
        }
        paramAbsBaseArticleInfo = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo).getString("floating_tip");
        boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo);
        if (bool)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdUtils", "floatingTipString is empty");
          return;
        }
        JSONArray localJSONArray = new JSONArray(paramAbsBaseArticleInfo);
        if (localJSONArray.length() < 1)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdUtils", "floatingTips JSONArray is empty");
          return;
        }
        i = 0;
        localObject5 = "";
        localObject3 = "";
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject3;
        localObject1 = paramAbsBaseArticleInfo;
        localObject2 = paramAbsBaseArticleInfo;
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject3;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str = localJSONObject.getString("type");
          bool = TextUtils.isEmpty(str);
          localObject4 = localObject5;
          localObject3 = localObject2;
          if (!bool)
          {
            localObject4 = localObject5;
            localObject3 = localObject2;
            if (str.equals("1"))
            {
              localObject4 = localJSONObject.getString("text");
              localObject3 = localJSONObject.getString("icon_url");
            }
          }
          localObject2 = paramAbsBaseArticleInfo;
          localObject6 = localObject1;
          if (!TextUtils.isEmpty(str))
          {
            localObject2 = paramAbsBaseArticleInfo;
            localObject6 = localObject1;
            if (str.equals("2"))
            {
              localObject2 = localJSONObject.getString("text");
              localObject6 = localJSONObject.getString("icon_url");
            }
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("ad_left_warning_txt", localObject5);
            paramJSONObject.put("id_text_left_warning", localObject3);
          }
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("ad_right_warning_txt", paramAbsBaseArticleInfo);
            paramJSONObject.put("id_txt_right_warning", localObject3);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramAbsBaseArticleInfo = new JSONObject();
            paramAbsBaseArticleInfo.put("img_left_warning_path", localObject2);
            paramJSONObject.put("id_img_left_warning", paramAbsBaseArticleInfo);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramAbsBaseArticleInfo = new JSONObject();
            paramAbsBaseArticleInfo.put("img_right_warning_path", localObject1);
            paramJSONObject.put("id_img_right_warning", paramAbsBaseArticleInfo);
          }
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        return;
      }
      i += 1;
      Object localObject5 = localObject4;
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject2;
      Object localObject2 = localObject3;
      Object localObject1 = localObject6;
    }
  }
  
  public static boolean k(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1022 == paramAdvertisementInfo.mAdvertisementExtInfo.l);
  }
  
  public static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.d.equals("2"));
  }
  
  public static boolean l(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.mAdvertisementExtInfo == null) {
        return false;
      }
      if ((1014 != paramAdvertisementInfo.mAdvertisementExtInfo.l) && (1015 != paramAdvertisementInfo.mAdvertisementExtInfo.l))
      {
        bool1 = bool2;
        if (1034 != paramAdvertisementInfo.mAdvertisementExtInfo.l) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null) {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle(paramAbsBaseArticleInfo))
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSubArticleList != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSubArticleList.size() > 0)
          {
            bool1 = bool2;
            if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0))) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean m(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = l(paramAdvertisementInfo);
    boolean bool1 = true;
    if ((!bool2) || (paramAdvertisementInfo.mAdvertisementExtInfo.A != 1))
    {
      if (n(paramAdvertisementInfo)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 39) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo.d.equals("4"));
  }
  
  public static boolean n(AdvertisementInfo paramAdvertisementInfo)
  {
    return (l(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo.B == 1);
  }
  
  public static boolean n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (k(paramAbsBaseArticleInfo)) || (h(paramAbsBaseArticleInfo)) || (i(paramAbsBaseArticleInfo)) || (j(paramAbsBaseArticleInfo)) || (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo));
  }
  
  public static int o(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null)) {
      return paramAdvertisementInfo.mAdvertisementExtInfo.C;
    }
    return 5;
  }
  
  public static int o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mFeedType == 38) {
      return 2051;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 39)
    {
      if (h(paramAbsBaseArticleInfo)) {
        return 2053;
      }
      if (j(paramAbsBaseArticleInfo)) {
        return 2054;
      }
      if (k(paramAbsBaseArticleInfo)) {
        return 2052;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo)) {
        return 2057;
      }
    }
    return 2050;
  }
  
  public static int p(AdvertisementInfo paramAdvertisementInfo)
  {
    if (i(paramAdvertisementInfo)) {
      return 116;
    }
    return 39;
  }
  
  public static boolean p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramAbsBaseArticleInfo == null) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.mVideoVid)))
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo != null)
      {
        bool1 = bool2;
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(paramAbsBaseArticleInfo)) {
          paramAbsBaseArticleInfo.mVideoVid = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdVideoUrl;
        }
      }
    }
    else
    {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
        return false;
      }
      if (!paramAbsBaseArticleInfo.mVideoVid.startsWith("http://"))
      {
        bool1 = bool2;
        if (!paramAbsBaseArticleInfo.mVideoVid.startsWith("https://")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void q(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    try
    {
      localObject = new GameLoadData();
      ((GameLoadData)localObject).a = paramAdvertisementInfo;
      ((GameLoadData)localObject).b = String.valueOf(paramAdvertisementInfo.mAdAid);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
      {
        paramAdvertisementInfo = Uri.parse(paramAdvertisementInfo.mAdLandingPage).getQueryParameter("adtag");
        if (!TextUtils.isEmpty(paramAdvertisementInfo))
        {
          int i = paramAdvertisementInfo.lastIndexOf(".");
          if ((i > 0) && (i < paramAdvertisementInfo.length() - 1)) {
            ((GameLoadData)localObject).b = paramAdvertisementInfo.substring(i + 1);
          }
        }
      }
      ((GameLoadData)localObject).c = System.currentTimeMillis();
      ReadinjoyAdCache.a(2, localObject);
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdUtils.1());
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addGdtWebClickReport fail message:");
        ((StringBuilder)localObject).append(paramAdvertisementInfo.getMessage());
        QLog.e("ReadInJoyAdUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = paramAbsBaseArticleInfo instanceof AdvertisementInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mChannelID == 0L)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mAdMaterialId == 185)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdExtParam(paramAbsBaseArticleInfo, "AdsIconText"))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean r(AdvertisementInfo paramAdvertisementInfo)
  {
    String str = paramAdvertisementInfo.mAdExtInfo;
    boolean bool = false;
    if (str != null) {
      try
      {
        int i = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optInt("AdSource", -1);
        if (i == 32) {
          bool = true;
        }
        return bool;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo instanceof AdvertisementInfo;
  }
  
  public static int s(AdvertisementInfo paramAdvertisementInfo)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) {
      return ReadInJoyAdSwitchUtil.c(paramAdvertisementInfo);
    }
    return 0;
  }
  
  public static boolean s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = r(paramAbsBaseArticleInfo);
    boolean bool1 = false;
    if (bool2)
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo.mAdvertisementSoftInfo != null) && (paramAbsBaseArticleInfo.mAdvertisementSoftInfo.q == 1)) {
        return true;
      }
      if (!RIJAdDownloadExKt.e(paramAbsBaseArticleInfo))
      {
        if (RIJAdDownloadExKt.g(paramAbsBaseArticleInfo)) {
          return true;
        }
        if (paramAbsBaseArticleInfo.mAdProductType == 12) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo.mAdvertisementExtInfo != null) && (1032 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l) && (b())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean u(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo.mAdvertisementExtInfo != null) && (1033 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l) && (b())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo.mAdvertisementExtInfo != null) && (1031 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramAbsBaseArticleInfo.mAdvertisementExtInfo == null) {
        return false;
      }
      bool1 = bool2;
      if (1025 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean x(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramAbsBaseArticleInfo.mAdvertisementExtInfo == null) {
        return false;
      }
      bool1 = bool2;
      if (1035 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && ((!((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) || (!b())))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramAbsBaseArticleInfo == null) {
        return false;
      }
      if ((1033 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l) || (1032 == paramAbsBaseArticleInfo.mAdvertisementExtInfo.l)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mAdMaterialId == 1122)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils
 * JD-Core Version:    0.7.0.1
 */