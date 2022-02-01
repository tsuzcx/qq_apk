package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import bmqk;
import bmql;
import cooperation.wadl.ipc.WadlParams;
import kotlin.Metadata;
import uew;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class GameCenterDownloadEngine$pauseDownload$1
  implements Runnable
{
  public GameCenterDownloadEngine$pauseDownload$1(ule paramule) {}
  
  public final void run()
  {
    Object localObject2 = null;
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("pauseDownload: pkg = ");
    Object localObject1 = this.a;
    if (localObject1 != null) {}
    for (localObject1 = ((ule)localObject1).d;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append("  url = ");
      ule localule = this.a;
      localObject1 = localObject2;
      if (localule != null) {
        localObject1 = localule.c;
      }
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject1);
      if (!uew.a(uew.a, this.a)) {
        break;
      }
      bmqk.a().a(this.a.a.d, this.a.a.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.pauseDownload.1
 * JD-Core Version:    0.7.0.1
 */