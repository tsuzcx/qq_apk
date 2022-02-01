package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameCenterDownloadEngine$pauseDownload$1
  implements Runnable
{
  GameCenterDownloadEngine$pauseDownload$1(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public final void run()
  {
    Object localObject2 = null;
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("pauseDownload: pkg = ");
    Object localObject1 = this.a;
    if (localObject1 != null) {}
    for (localObject1 = ((ADVideoAppDownloadData)localObject1).d;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append("  url = ");
      ADVideoAppDownloadData localADVideoAppDownloadData = this.a;
      localObject1 = localObject2;
      if (localADVideoAppDownloadData != null) {
        localObject1 = localADVideoAppDownloadData.c;
      }
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject1);
      if (!GameCenterDownloadEngine.a(GameCenterDownloadEngine.a, this.a)) {
        break;
      }
      WadlProxyServiceUtil.a().a(this.a.a.d, this.a.a.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.pauseDownload.1
 * JD-Core Version:    0.7.0.1
 */