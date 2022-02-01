package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.ReadInJoyAdActionManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.AdParamsFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.BaseActivity;

public class FastWebRecommendAdHelper
{
  public static long a;
  public static GdtHandler.Params a;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt)
  {
    Object localObject = paramContext;
    if (!(paramContext instanceof Activity))
    {
      if (BaseActivity.sTopActivity != null) {
        localObject = BaseActivity.sTopActivity;
      }
    }
    else {
      a((Context)localObject, paramAdvertisementInfo, false, paramBoolean, paramInt);
    }
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
      if (((Integer)localObject).intValue() != -1) {
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, (Integer)localObject, paramAdvertisementInfo, 1, 1, 3);
      }
      label183:
      for (;;)
      {
        return;
        localObject = new ReadInJoyGdtAdParams();
        ((ReadInJoyGdtAdParams)localObject).d = paramBoolean1;
        ((ReadInJoyGdtAdParams)localObject).b = paramBoolean2;
        if (paramAdvertisementInfo.mChannelID != 3L) {
          ReadInJoyAdActionManager.a(paramAdvertisementInfo, (Activity)paramContext, 1, 1, 3, (ReadInJoyGdtAdParams)localObject);
        }
        for (;;)
        {
          if ((FastWeqAdUtils.a(paramAdvertisementInfo)) || ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0))) {
            break label183;
          }
          paramAdvertisementInfo.setClickPos(paramInt);
          paramContext = AdParamsFactory.a(paramAdvertisementInfo, (Activity)paramContext, (ReadInJoyGdtAdParams)localObject);
          if (paramContext == null) {
            break;
          }
          paramContext.f = ReadInJoyAdSwitchUtil.b(paramAdvertisementInfo);
          jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          return;
          ReadInJoyAdActionManager.a(paramAdvertisementInfo, (Activity)paramContext, 5, 1, 5, (ReadInJoyGdtAdParams)localObject);
        }
      }
    }
    ReadInJoyAdLog.a("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((!(paramContext instanceof Activity)) || (!(paramBaseData instanceof AdData))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo2 = ((AdData)paramBaseData).a;
    AdvertisementInfo localAdvertisementInfo1 = localAdvertisementInfo2;
    if (localAdvertisementInfo2 == null) {
      localAdvertisementInfo1 = ReadInJoyBottomAdVideoUtil.a((AdData)paramBaseData);
    }
    a(paramContext, localAdvertisementInfo1, false, paramBoolean, paramInt);
  }
  
  public void a()
  {
    ReadinJoyActionUtil.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper
 * JD-Core Version:    0.7.0.1
 */