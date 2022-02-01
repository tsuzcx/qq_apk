package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.webkit.ValueCallback;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
final class AdDownloadCallbackImpl$callback$1<T>
  implements ValueCallback<Integer>
{
  public final void a(Integer paramInteger)
  {
    this.b.onReceiveValue(paramInteger);
    WadlProxyServiceUtil.a().b((WadlProxyServiceCallBackInterface)this.a);
    DownloadManagerV2.a().b((DownloadListener)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallbackImpl.callback.1
 * JD-Core Version:    0.7.0.1
 */