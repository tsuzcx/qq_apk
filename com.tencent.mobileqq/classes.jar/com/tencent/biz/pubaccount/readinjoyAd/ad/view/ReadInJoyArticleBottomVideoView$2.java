package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import java.lang.ref.WeakReference;

class ReadInJoyArticleBottomVideoView$2
  implements ReadInJoyAdVideoGuide.AdGuideClickListener
{
  ReadInJoyArticleBottomVideoView$2(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 17) && (FastWeqAdUtils.h(ReadInJoyArticleBottomVideoView.a(this.a))))
    {
      FastWeqAdUtils.a((Context)ReadInJoyArticleBottomVideoView.f(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
      return;
    }
    if (paramInt == 21)
    {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(ReadInJoyArticleBottomVideoView.j(this.a)).a(ReadInJoyArticleBottomVideoView.i(this.a)).a(1).b(ReadInJoyArticleBottomVideoView.h(this.a)).b(Integer.valueOf(0)).a(ReadInJoyArticleBottomVideoView.g(this.a)).c(paramInt));
      long l = System.currentTimeMillis();
      if (l - ReadInJoyArticleBottomVideoView.k(this.a) > 500L)
      {
        ReadInJoyArticleBottomVideoView.a(this.a, l);
        ReadInJoyArticleBottomVideoView.l(this.a);
      }
    }
    else
    {
      boolean bool1;
      boolean bool2;
      if (ReadInJoyArticleBottomVideoView.a(this.a) != null)
      {
        if (ReadInJoyArticleBottomVideoView.a(this.a).P != null)
        {
          localObject = ReadInJoyArticleBottomVideoView.a(this.a).P;
          bool1 = PackageUtil.a((Context)ReadInJoyArticleBottomVideoView.f(this.a).get(), (String)localObject);
        }
        else
        {
          localObject = "";
          bool1 = false;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = ADBaseAppDownloadManager.a((Context)ReadInJoyArticleBottomVideoView.f(this.a).get(), (String)localObject);
        } else {
          bool2 = false;
        }
      }
      else
      {
        bool2 = false;
        bool1 = false;
      }
      if ((!bool1) && (!bool2))
      {
        ReadInJoyArticleBottomVideoView.a(this.a, paramView, true, paramInt);
        return;
      }
      Object localObject = null;
      if (!bool1) {
        localObject = new AdJumpParams(false);
      }
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(ReadInJoyArticleBottomVideoView.a(this.a));
      if (localAdvertisementInfo != null) {
        localAdvertisementInfo.setClickPos(paramInt);
      }
      paramView = ReadinJoyActionUtil.e(paramView.getContext(), localAdvertisementInfo, null, 2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt), (AdJumpParams)localObject);
      if (localAdvertisementInfo != null) {
        localAdvertisementInfo.setClickPos(paramInt);
      }
      ReadInJoyAdReportUtils.a(ReportAction.CLICK, paramView, localAdvertisementInfo, 2, 1, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.2
 * JD-Core Version:    0.7.0.1
 */