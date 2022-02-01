package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyAdActionManager
{
  public static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    int i = paramAdvertisementInfo.clickPos;
    paramActivity = ReadInJoyAdJumpUtils.a(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams);
    if (paramActivity.intValue() == 10)
    {
      paramAdvertisementInfo.clickPos = i;
      paramInt1 = 8;
    }
    ReadInJoyAdReportUtils.a(ReportAction.CLICK, paramActivity, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.ReadInJoyAdActionManager
 * JD-Core Version:    0.7.0.1
 */