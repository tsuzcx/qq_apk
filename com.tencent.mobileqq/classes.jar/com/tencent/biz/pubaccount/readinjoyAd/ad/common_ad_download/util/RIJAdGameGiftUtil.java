package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil;", "", "()V", "doGiftPackageDownload", "", "context", "Landroid/content/Context;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "view", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "showGiftDialog", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAdGameGiftUtil
{
  public static final RIJAdGameGiftUtil a = new RIJAdGameGiftUtil();
  
  private final void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Object localObject;
    if (paramAdvertisementInfo != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ADVideoAppDownloadData)localObject).b = true;
      }
      RIJAdDownloadUtil localRIJAdDownloadUtil = RIJAdDownloadUtil.a;
      if (paramADVideoAppDownloadData == null) {
        break label85;
      }
      localObject = paramADVideoAppDownloadData.d;
      if (!localRIJAdDownloadUtil.a((String)localObject)) {
        break label91;
      }
      if ((paramContext instanceof Activity))
      {
        if (!RIJAdDownloadUtil.a.a((Activity)paramContext, paramAdvertisementInfo)) {
          break label91;
        }
        RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.OPEN_APP, paramAdvertisementInfo, null, 8, null);
      }
    }
    label85:
    label91:
    do
    {
      return;
      localObject = null;
      break;
      boolean bool;
      if (paramADVideoAppDownloadData != null)
      {
        localObject = RIJAdDownloadExKt.a(paramADVideoAppDownloadData);
        if (localObject != null)
        {
          bool = ((IDownloadEngine)localObject).a(paramADVideoAppDownloadData);
          if (!bool) {
            continue;
          }
          localObject = WadlProxyServiceUtil.a();
          if (paramADVideoAppDownloadData == null) {
            break label166;
          }
        }
      }
      for (paramRIJDownloadView = paramADVideoAppDownloadData.a;; paramRIJDownloadView = null)
      {
        ((WadlProxyServiceWrap)localObject).c(paramRIJDownloadView);
        RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.INSTALL_APP, paramAdvertisementInfo, null, 8, null);
        return;
        bool = false;
        break;
      }
    } while (!RIJAdDownloadUtil.a.a(paramRIJDownloadView, paramAdvertisementInfo, paramADVideoAppDownloadData));
    label166:
    RIJAdDownloadReport.a(RIJAdDownloadReport.a, paramContext, DownloadClickState.START_DOWNLOAD, paramAdvertisementInfo, null, 8, null);
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable Context paramContext, @NotNull RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    ThreadManagerV2.executeOnSubThread((Runnable)new RIJAdGameGiftUtil.showGiftDialog.1(paramAdvertisementInfo, paramContext, paramRIJDownloadView, paramADVideoAppDownloadData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil
 * JD-Core Version:    0.7.0.1
 */