package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FastWeqAdUtils
{
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramProteusBannerVideoItemData)) {
      return 29;
    }
    return 15;
  }
  
  public static int a(ProteusInnerData paramProteusInnerData)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramProteusInnerData)) {
      return 24;
    }
    if (paramProteusInnerData.b()) {
      return 21;
    }
    if (paramProteusInnerData.c()) {
      return 20;
    }
    if (paramProteusInnerData.d()) {
      return 31;
    }
    if (paramProteusInnerData.e()) {
      return 31;
    }
    return 20;
  }
  
  public static Integer a(Context paramContext, AdData paramAdData)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData))
    {
      String str1 = paramAdData.as.n;
      if (!TextUtils.isEmpty(paramAdData.as.o)) {
        str1 = paramAdData.as.o;
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (!TextUtils.isEmpty(paramAdData.p)) {
          str2 = paramAdData.p;
        }
      }
      paramAdData = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).appendUrlParameter(str2);
      return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramAdData);
    }
    return Integer.valueOf(-1);
  }
  
  public static Integer a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramContext);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    } else if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3;
    }
    paramString1 = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).appendUrlParameter(paramString1);
    return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramString1);
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt)
  {
    try
    {
      View localView = ((ReadInjoyImageView)paramViewBase).getNativeView();
      a(paramContext, paramViewBase, paramString, paramInt, localView.getWidth(), localView.getHeight());
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramViewBase = new StringBuilder();
        paramViewBase.append("loadImage error ");
        paramViewBase.append(paramContext.getMessage());
        QLog.e("FastWeqAdUtils", 2, paramViewBase.toString());
      }
    }
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramViewBase = (ReadInjoyImageView)paramViewBase;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mRequestHeight = paramInt3;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(paramInt2, paramInt3, AIOUtils.b(paramInt1, paramContext.getResources())));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      paramViewBase.setImageDrawable(paramString, true);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramViewBase = new StringBuilder();
        paramViewBase.append("loadImage error ");
        paramViewBase.append(paramContext.getMessage());
        QLog.e("FastWeqAdUtils", 2, paramViewBase.toString());
      }
    }
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt)
  {
    if (paramAdData == null) {
      return;
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(paramContext, paramAdData.ac, paramAdData.p, paramAdData.D);
    paramContext = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(BaseApplication.getContext()).a(42).b(1).b(Integer.valueOf(21)).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData)).c(paramInt).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdData)));
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAdvertisementInfo.mSoftAdType == 1)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.gameAdComData != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.as != null) && (!TextUtils.isEmpty(paramAdData.as.c));
  }
  
  public static void b(Context paramContext, AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(paramContext, paramAdData.ac, paramAdData.p, paramAdData.D);
    paramContext = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(BaseApplication.getContext()).a(42).b(1).b(Integer.valueOf(21)).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData)).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdData)));
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return g(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(3));
  }
  
  public static boolean b(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.az != null) && (5001 == paramAdData.az.l);
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return g(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(1));
  }
  
  public static boolean c(AdData paramAdData)
  {
    return j(paramAdData).equalsIgnoreCase(String.valueOf(3));
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    return g(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(2));
  }
  
  public static boolean d(AdData paramAdData)
  {
    return j(paramAdData).equalsIgnoreCase(String.valueOf(1));
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    return g(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(6));
  }
  
  public static boolean e(AdData paramAdData)
  {
    return j(paramAdData).equalsIgnoreCase(String.valueOf(2));
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return g(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(4));
  }
  
  public static boolean f(AdData paramAdData)
  {
    return j(paramAdData).equalsIgnoreCase(String.valueOf(4));
  }
  
  private static String g(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null) && (paramAdvertisementInfo.gameAdComData.t != null)) {
      return paramAdvertisementInfo.gameAdComData.t;
    }
    return String.valueOf(0);
  }
  
  public static boolean g(AdData paramAdData)
  {
    return j(paramAdData).equalsIgnoreCase(String.valueOf(6));
  }
  
  public static boolean h(AdData paramAdData)
  {
    boolean bool2 = false;
    if (paramAdData == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramAdData.ac))
    {
      bool1 = bool2;
      if (paramAdData.ab)
      {
        bool1 = bool2;
        if (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isAmsSubcribeEnabled(paramAdData)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean i(AdData paramAdData)
  {
    if ((paramAdData instanceof ProteusInnerData)) {
      return ((ProteusInnerData)paramAdData).e();
    }
    return false;
  }
  
  private static String j(AdData paramAdData)
  {
    if ((paramAdData != null) && (paramAdData.as != null) && (paramAdData.as.y != null)) {
      return paramAdData.as.y;
    }
    return String.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils
 * JD-Core Version:    0.7.0.1
 */