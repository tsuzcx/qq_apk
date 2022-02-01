package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.glue.pts.api.IViewBaseUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

public class InteraActionReportUtils
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 14: 
      return 4;
    case 13: 
      return 3;
    case 12: 
      return 2;
    }
    return 1;
  }
  
  public static void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(paramAbsBaseArticleInfo))
    {
      if (paramViewBase == null) {
        return;
      }
      if (((IViewBaseUtil)QRoute.api(IViewBaseUtil.class)).isReadInJoyLikeButton(paramViewBase))
      {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(11).b(3).a((AdvertisementInfo)paramAbsBaseArticleInfo));
        return;
      }
      if (((IViewBaseUtil)QRoute.api(IViewBaseUtil.class)).isReadInJoyBiuButton(paramViewBase))
      {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(13).b(3).a((AdvertisementInfo)paramAbsBaseArticleInfo));
        return;
      }
      if ((paramViewBase instanceof NativeButton))
      {
        if (paramBoolean)
        {
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(14).b(3).a((AdvertisementInfo)paramAbsBaseArticleInfo));
          return;
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(12).b(3).a((AdvertisementInfo)paramAbsBaseArticleInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils
 * JD-Core Version:    0.7.0.1
 */