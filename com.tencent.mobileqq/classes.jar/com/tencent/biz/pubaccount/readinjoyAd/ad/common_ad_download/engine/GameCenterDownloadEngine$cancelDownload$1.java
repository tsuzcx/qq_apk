package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameCenterDownloadEngine$cancelDownload$1
  implements Runnable
{
  public final void run()
  {
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelDownload: pkg = ");
    Object localObject1 = this.a;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("  url = ");
    ADVideoAppDownloadData localADVideoAppDownloadData = this.a;
    localObject1 = localObject2;
    if (localADVideoAppDownloadData != null) {
      localObject1 = localADVideoAppDownloadData.c;
    }
    localStringBuilder.append((String)localObject1);
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    if (GameCenterDownloadEngine.b(GameCenterDownloadEngine.a, this.a)) {
      WadlProxyServiceUtil.a().c(this.a.m.h, this.a.m.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.cancelDownload.1
 * JD-Core Version:    0.7.0.1
 */