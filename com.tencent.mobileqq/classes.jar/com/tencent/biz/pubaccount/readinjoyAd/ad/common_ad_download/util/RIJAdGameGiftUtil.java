package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil;", "", "()V", "doGiftPackageDownload", "", "context", "Landroid/content/Context;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "view", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "showGiftDialog", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdGameGiftUtil
{
  public static final RIJAdGameGiftUtil a = new RIJAdGameGiftUtil();
  
  private final void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramAdvertisementInfo != null)
    {
      Object localObject1 = paramRIJDownloadView.getDownloadData();
      if (localObject1 != null) {
        ((ADVideoAppDownloadData)localObject1).r = true;
      }
      RIJAdDownloadUtil localRIJAdDownloadUtil = RIJAdDownloadUtil.a;
      Object localObject2 = null;
      if (paramADVideoAppDownloadData != null) {
        localObject1 = paramADVideoAppDownloadData.d;
      } else {
        localObject1 = null;
      }
      if (localRIJAdDownloadUtil.a((String)localObject1)) {
        if ((paramContext instanceof Activity))
        {
          if (RIJAdDownloadUtil.a.a((Activity)paramContext, paramAdvertisementInfo)) {
            RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.OPEN_APP, paramAdvertisementInfo, null, 8, null);
          }
        }
        else {
          return;
        }
      }
      if (paramADVideoAppDownloadData != null)
      {
        localObject1 = RIJAdDownloadExKt.a(paramADVideoAppDownloadData);
        if (localObject1 != null)
        {
          bool = ((IDownloadEngine)localObject1).a(paramADVideoAppDownloadData);
          break label126;
        }
      }
      boolean bool = false;
      label126:
      if (bool)
      {
        localObject1 = WadlProxyServiceUtil.a();
        paramRIJDownloadView = localObject2;
        if (paramADVideoAppDownloadData != null) {
          paramRIJDownloadView = paramADVideoAppDownloadData.m;
        }
        ((WadlProxyServiceWrap)localObject1).c(paramRIJDownloadView);
        RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.INSTALL_APP, paramAdvertisementInfo, null, 8, null);
        return;
      }
      if (RIJAdDownloadUtil.a.a(paramRIJDownloadView, paramAdvertisementInfo, paramADVideoAppDownloadData)) {
        RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.START_DOWNLOAD, paramAdvertisementInfo, null, 8, null);
      }
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable Context paramContext, @NotNull RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    ThreadManagerV2.executeOnSubThread((Runnable)new RIJAdGameGiftUtil.showGiftDialog.1(paramAdvertisementInfo, paramContext, paramRIJDownloadView, paramADVideoAppDownloadData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil
 * JD-Core Version:    0.7.0.1
 */