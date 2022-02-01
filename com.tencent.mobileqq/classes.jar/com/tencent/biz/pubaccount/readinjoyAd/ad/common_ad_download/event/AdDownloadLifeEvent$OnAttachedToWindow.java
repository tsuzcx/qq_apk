package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import bjjq;
import bmqi;
import bmqk;
import bmql;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.open.downloadnew.DownloadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uet;
import ukq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent$OnAttachedToWindow;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent;", "onEvent", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadLifeEvent$OnAttachedToWindow
  extends AdDownloadLifeEvent
{
  AdDownloadLifeEvent$OnAttachedToWindow()
  {
    super(str, i, null);
  }
  
  public void onEvent(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView == null) {}
    do
    {
      return;
      ukq.a("AD_DOWNLOAD_TAG", "OnAttachedToWindow " + paramRIJDownloadView.hashCode());
    } while (!AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramRIJDownloadView.a()));
    ukq.a("AD_DOWNLOAD_TAG", "registerListener " + paramRIJDownloadView.hashCode());
    bmqk.a().a((bmqi)paramRIJDownloadView);
    bjjq.a().a((DownloadListener)paramRIJDownloadView);
    uet.a.a(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent.OnAttachedToWindow
 * JD-Core Version:    0.7.0.1
 */