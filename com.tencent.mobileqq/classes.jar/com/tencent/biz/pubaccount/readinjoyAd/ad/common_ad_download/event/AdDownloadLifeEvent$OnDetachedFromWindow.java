package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadListener;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent$OnDetachedFromWindow;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent;", "onEvent", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadLifeEvent$OnDetachedFromWindow
  extends AdDownloadLifeEvent
{
  AdDownloadLifeEvent$OnDetachedFromWindow()
  {
    super(str, i, null);
  }
  
  public void onEvent(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView == null) {}
    do
    {
      return;
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "OnDetachedFromWindow " + paramRIJDownloadView.hashCode());
    } while (!AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramRIJDownloadView.a()));
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "unRegisterListener " + paramRIJDownloadView.hashCode());
    WadlProxyServiceUtil.a().b((WadlProxyServiceCallBackInterface)DownloadCallbackHandler.a((DownloadListener)paramRIJDownloadView));
    DownloadManagerV2.a().b(DownloadCallbackHandler.a((DownloadListener)paramRIJDownloadView));
    RIJAdDownloadCache.a.b(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent.OnDetachedFromWindow
 * JD-Core Version:    0.7.0.1
 */