package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class YYBDownloadEngine$pauseDownload$1
  implements Runnable
{
  YYBDownloadEngine$pauseDownload$1(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public final void run()
  {
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("pauseDownload: pkg = ");
    Object localObject1 = this.a;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("  url = ");
    localObject1 = this.a;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).c;
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject3).toString());
    localObject3 = DownloadManagerV2.a();
    ADVideoAppDownloadData localADVideoAppDownloadData = this.a;
    localObject1 = localObject2;
    if (localADVideoAppDownloadData != null) {
      localObject1 = localADVideoAppDownloadData.c;
    }
    ((DownloadManagerV2)localObject3).e((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.pauseDownload.1
 * JD-Core Version:    0.7.0.1
 */