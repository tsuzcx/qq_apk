package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;

public class UIDelegateFactory
{
  public static IUIDelegate a(Context paramContext, AdData paramAdData)
  {
    if (paramContext != null)
    {
      if (paramAdData == null) {
        return null;
      }
      boolean bool = paramAdData instanceof ProteusInnerData;
      if ((bool) && (((ProteusInnerData)paramAdData).f())) {
        return ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).createGamesComponentAdDelegate(paramContext, 2);
      }
      if ((bool) && (((ProteusInnerData)paramAdData).e())) {
        return ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).createGoodsSoftAdAppDelegate(paramContext, 1);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.UIDelegateFactory
 * JD-Core Version:    0.7.0.1
 */