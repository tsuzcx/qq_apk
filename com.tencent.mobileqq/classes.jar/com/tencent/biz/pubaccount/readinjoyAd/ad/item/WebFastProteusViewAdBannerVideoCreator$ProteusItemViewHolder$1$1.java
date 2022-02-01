package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.c.b != null)
    {
      int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (i != 1071)
      {
        boolean bool3 = false;
        if (i != 1127) {
          if (i != 1128) {
            switch (i)
            {
            default: 
              i = -1;
            }
          }
        }
        boolean bool1;
        for (;;)
        {
          bool1 = false;
          break;
          i = 8;
          bool1 = true;
          break;
          i = 5;
          continue;
          i = 3;
          continue;
          i = 4;
          continue;
          i = 2;
          continue;
          i = 1000;
        }
        if (FastWeqAdUtils.h((AdData)this.a.a))
        {
          FastWeqAdUtils.b(this.a.b, (AdData)this.a.a);
          return;
        }
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo((ProteusBannerVideoItemData)this.a.a);
        if (localAdvertisementInfo == null) {
          return;
        }
        paramViewBase = ReadinJoyActionUtil.a((Activity)this.a.b, (AdData)this.a.a, localAdvertisementInfo);
        if (paramViewBase.intValue() != -1)
        {
          if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c) != null) {
            WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c).a(true);
          }
          return;
        }
        boolean bool2;
        if (LiujinAdJump.isFromLiuJin(localAdvertisementInfo))
        {
          paramViewBase = (Context)this.a.c.c.get();
          if (i == 8) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramViewBase = LiujinAdJump.doJumpAction(localAdvertisementInfo, paramViewBase, bool2);
        }
        localAdvertisementInfo.setClickPos(i);
        if (paramViewBase.intValue() == -1)
        {
          bool2 = bool3;
          if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c) != null) {
            bool2 = WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c).d();
          }
          paramViewBase = new AdJumpParams(bool2);
          if (i == 8) {
            paramViewBase.c = true;
          }
          GdtHandler.Params localParams = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams((Activity)this.a.b, localAdvertisementInfo, null, 2, bool1, paramViewBase);
          if (localParams == null) {
            return;
          }
          localParams.l = ReadInJoyAdSwitchUtil.b((AdData)this.a.a);
          paramViewBase = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localParams, this.a.b, localAdvertisementInfo);
          WebFastProteusViewAdBannerVideoCreator.f = localParams;
          WebFastProteusViewAdBannerVideoCreator.g = SystemClock.elapsedRealtime();
          localAdvertisementInfo.setClickPos(i);
        }
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, paramViewBase, localAdvertisementInfo, 2, 1, 3);
        if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c) != null) {
          WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c).a(true);
        }
      }
      else
      {
        JumpAdUtils.a(this.a.a, paramViewBase.getNativeView(), this.a.b);
        if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c) != null) {
          WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.c).a(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */