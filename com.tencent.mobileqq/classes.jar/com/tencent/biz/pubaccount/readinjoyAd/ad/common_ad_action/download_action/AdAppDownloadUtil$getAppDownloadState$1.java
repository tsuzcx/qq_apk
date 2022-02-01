package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdAppDownloadUtil$getAppDownloadState$1
  implements Runnable
{
  public final void run()
  {
    AdAppDownloadUtil.DownloadStateInfo localDownloadStateInfo = new AdAppDownloadUtil.DownloadStateInfo();
    if (this.a == null)
    {
      ReadInJoyAdLog.a("AdAppDownloadUtil", "downloadData == null");
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.1(this, localDownloadStateInfo));
      return;
    }
    Object localObject = this.a.d;
    localDownloadStateInfo.a((String)localObject);
    if (AdAppDownloadUtil.a.a((String)localObject))
    {
      ReadInJoyAdLog.a("AdAppDownloadUtil", "downloadData isInstalled");
      localDownloadStateInfo.a(1);
      localDownloadStateInfo.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.2(this, localDownloadStateInfo));
      return;
    }
    localObject = AdAppDownloadUtil.a.a(this.a);
    if (localObject == null)
    {
      ReadInJoyAdLog.a("AdAppDownloadUtil", "downloadInfo == null");
      localDownloadStateInfo.a(0);
      localDownloadStateInfo.b(0);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.3(this, localDownloadStateInfo));
      return;
    }
    if (AdAppDownloadUtil.a.a((DownloadInfo)localObject))
    {
      ReadInJoyAdLog.a("AdAppDownloadUtil", "downloadData isPkgExist");
      localDownloadStateInfo.a(5);
      localDownloadStateInfo.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.4(this, localDownloadStateInfo));
      return;
    }
    localDownloadStateInfo.a(AdAppDownloadUtil.a.a(((DownloadInfo)localObject).a()));
    localDownloadStateInfo.b(((DownloadInfo)localObject).f);
    ReadInJoyAdLog.a("AdAppDownloadUtil", "downloadData state = " + localDownloadStateInfo.a() + " progress = " + ((DownloadInfo)localObject).f);
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.5(this, localDownloadStateInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil.getAppDownloadState.1
 * JD-Core Version:    0.7.0.1
 */