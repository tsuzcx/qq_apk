package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent$OnDetachedFromWindow;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent;", "onEvent", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
final class AdDownloadLifeEvent$OnDetachedFromWindow
  extends AdDownloadLifeEvent
{
  AdDownloadLifeEvent$OnDetachedFromWindow()
  {
    super(str, i, null);
  }
  
  public void onEvent(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnDetachedFromWindow ");
    ((StringBuilder)localObject).append(paramRIJDownloadView.hashCode());
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject).toString());
    if (!ReadInJoyAdUtils.s((AbsBaseArticleInfo)paramRIJDownloadView.getAdInfo())) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unRegisterListener ");
    ((StringBuilder)localObject).append(paramRIJDownloadView.hashCode());
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject).toString());
    localObject = WadlProxyServiceUtil.a();
    DownloadListener localDownloadListener = (DownloadListener)paramRIJDownloadView;
    ((WadlProxyServiceWrap)localObject).b((WadlProxyServiceCallBackInterface)DownloadCallbackHandler.a(localDownloadListener));
    DownloadManagerV2.a().b(DownloadCallbackHandler.a(localDownloadListener));
    RIJAdDownloadCache.a.b(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent.OnDetachedFromWindow
 * JD-Core Version:    0.7.0.1
 */