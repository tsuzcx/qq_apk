package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.ReadInJoyAdActionManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;

public class FastWebRecommendAdHelper
{
  public static long a = -2147483648L;
  public static GdtHandler.Params a;
  
  public static void a()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt)
  {
    Object localObject = paramContext;
    if (!(paramContext instanceof Activity)) {
      if (BaseActivity.sTopActivity != null) {
        localObject = BaseActivity.sTopActivity;
      } else {
        return;
      }
    }
    a((Context)localObject, paramAdvertisementInfo, false, paramBoolean, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (paramAdvertisementInfo != null))
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      Object localObject = Integer.valueOf(-1);
      if (LiujinAdJump.isFromLiuJin(paramAdvertisementInfo)) {
        localObject = LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext, paramBoolean2);
      }
      if (((Integer)localObject).intValue() != -1)
      {
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, (Integer)localObject, paramAdvertisementInfo, 1, 1, 3);
        return;
      }
      localObject = new ReadInJoyGdtAdParams();
      ((ReadInJoyGdtAdParams)localObject).d = paramBoolean1;
      ((ReadInJoyGdtAdParams)localObject).b = paramBoolean2;
      if (paramAdvertisementInfo.mChannelID != 3L) {
        ReadInJoyAdActionManager.a(paramAdvertisementInfo, (Activity)paramContext, 1, 1, 3, (ReadInJoyGdtAdParams)localObject);
      } else {
        ReadInJoyAdActionManager.a(paramAdvertisementInfo, (Activity)paramContext, 5, 1, 5, (ReadInJoyGdtAdParams)localObject);
      }
      if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(paramAdvertisementInfo)) {
        return;
      }
      if ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0)) {
        return;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
      paramContext = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).obtainGdtParams(paramAdvertisementInfo, (Activity)paramContext, localObject);
      if (paramContext == null) {
        return;
      }
      paramContext.f = ReadInJoyAdSwitchUtil.b(paramAdvertisementInfo);
      jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((paramContext instanceof Activity))
    {
      if (!(paramBaseData instanceof AdData)) {
        return;
      }
      AdData localAdData = (AdData)paramBaseData;
      AdvertisementInfo localAdvertisementInfo = localAdData.a;
      paramBaseData = localAdvertisementInfo;
      if (localAdvertisementInfo == null) {
        paramBaseData = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(localAdData);
      }
      a(paramContext, paramBaseData, false, paramBoolean, paramInt);
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper
 * JD-Core Version:    0.7.0.1
 */