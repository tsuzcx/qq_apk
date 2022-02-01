package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import java.lang.ref.WeakReference;

class ReadInJoyArticleBottomVideoView$2
  implements ReadInJoyAdVideoGuide.AdGuideClickListener
{
  ReadInJoyArticleBottomVideoView$2(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 17) && (FastWeqAdUtils.g(ReadInJoyArticleBottomVideoView.a(this.a)))) {
      FastWeqAdUtils.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
    }
    long l;
    do
    {
      return;
      if (paramInt != 21) {
        break;
      }
      NativeAdUtils.a(new AdReportData().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(1).b(ReadInJoyArticleBottomVideoView.a(this.a)).b(Integer.valueOf(0)).a(ReadInJoyArticleBottomVideoView.a(this.a)).c(paramInt));
      l = System.currentTimeMillis();
    } while (l - ReadInJoyArticleBottomVideoView.a(this.a) <= 500L);
    ReadInJoyArticleBottomVideoView.a(this.a, l);
    ReadInJoyArticleBottomVideoView.e(this.a);
    return;
    Object localObject;
    boolean bool1;
    boolean bool2;
    if (ReadInJoyArticleBottomVideoView.a(this.a) != null) {
      if (ReadInJoyArticleBottomVideoView.a(this.a).v != null)
      {
        localObject = ReadInJoyArticleBottomVideoView.a(this.a).v;
        bool1 = PackageUtil.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = ADBaseAppDownloadManager.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label336;
        }
      }
      label336:
      for (localObject = new AdJumpParams(false);; localObject = null)
      {
        AdvertisementInfo localAdvertisementInfo = ReadInJoyBottomAdVideoUtil.a(ReadInJoyArticleBottomVideoView.a(this.a));
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        paramView = ReadinJoyActionUtil.d(paramView.getContext(), localAdvertisementInfo, null, 2, NativeAdUtils.a(paramInt), (AdJumpParams)localObject);
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, paramView, localAdvertisementInfo, 2, 1, 3);
        return;
        ReadInJoyArticleBottomVideoView.a(this.a, paramView, true, paramInt);
        return;
      }
      bool2 = false;
      continue;
      bool1 = false;
      localObject = "";
      break;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.2
 * JD-Core Version:    0.7.0.1
 */