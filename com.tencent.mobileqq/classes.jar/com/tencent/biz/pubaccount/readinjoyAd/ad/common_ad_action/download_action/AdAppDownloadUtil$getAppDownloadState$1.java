package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;
import tpy;
import tpz;
import twp;
import txh;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class AdAppDownloadUtil$getAppDownloadState$1
  implements Runnable
{
  public AdAppDownloadUtil$getAppDownloadState$1(txh paramtxh, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    tpz localtpz = new tpz();
    if (this.jdField_a_of_type_Txh == null)
    {
      twp.a("AdAppDownloadUtil", "downloadData == null");
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.1(this, localtpz));
      return;
    }
    Object localObject = this.jdField_a_of_type_Txh.d;
    localtpz.a((String)localObject);
    if (tpy.a.a((String)localObject))
    {
      twp.a("AdAppDownloadUtil", "downloadData isInstalled");
      localtpz.a(1);
      localtpz.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.2(this, localtpz));
      return;
    }
    localObject = tpy.a.a(this.jdField_a_of_type_Txh);
    if (localObject == null)
    {
      twp.a("AdAppDownloadUtil", "downloadInfo == null");
      localtpz.a(0);
      localtpz.b(0);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.3(this, localtpz));
      return;
    }
    if (tpy.a.a((DownloadInfo)localObject))
    {
      twp.a("AdAppDownloadUtil", "downloadData isPkgExist");
      localtpz.a(5);
      localtpz.b(100);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.4(this, localtpz));
      return;
    }
    localtpz.a(tpy.a.a(((DownloadInfo)localObject).a()));
    localtpz.b(((DownloadInfo)localObject).f);
    twp.a("AdAppDownloadUtil", "downloadData state = " + localtpz.a() + " progress = " + ((DownloadInfo)localObject).f);
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdAppDownloadUtil.getAppDownloadState.1.5(this, localtpz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil.getAppDownloadState.1
 * JD-Core Version:    0.7.0.1
 */