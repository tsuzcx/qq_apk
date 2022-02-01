package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;
import udr;
import uds;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class AdAppDownloadUtil$getAppDownloadState$1
  implements Runnable
{
  public AdAppDownloadUtil$getAppDownloadState$1(ule paramule, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    uds localuds = new uds();
    if (this.jdField_a_of_type_Ule == null)
    {
      ukq.a("AdAppDownloadUtil", "downloadData == null");
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.1(this, localuds));
      return;
    }
    Object localObject = this.jdField_a_of_type_Ule.d;
    localuds.a((String)localObject);
    if (udr.a.a((String)localObject))
    {
      ukq.a("AdAppDownloadUtil", "downloadData isInstalled");
      localuds.a(1);
      localuds.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.2(this, localuds));
      return;
    }
    localObject = udr.a.a(this.jdField_a_of_type_Ule);
    if (localObject == null)
    {
      ukq.a("AdAppDownloadUtil", "downloadInfo == null");
      localuds.a(0);
      localuds.b(0);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.3(this, localuds));
      return;
    }
    if (udr.a.a((DownloadInfo)localObject))
    {
      ukq.a("AdAppDownloadUtil", "downloadData isPkgExist");
      localuds.a(5);
      localuds.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.4(this, localuds));
      return;
    }
    localuds.a(udr.a.a(((DownloadInfo)localObject).a()));
    localuds.b(((DownloadInfo)localObject).f);
    ukq.a("AdAppDownloadUtil", "downloadData state = " + localuds.a() + " progress = " + ((DownloadInfo)localObject).f);
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.5(this, localuds));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil.getAppDownloadState.1
 * JD-Core Version:    0.7.0.1
 */