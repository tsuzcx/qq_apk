package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/GameCenterDownloadEngine;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "()V", "buildDownloadParams", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "installApp", "", "isAppPkgExist", "isGameDownloadData", "pauseDownload", "queryDownloadState", "startDownload", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class GameCenterDownloadEngine
  extends IDownloadEngine
{
  public static final GameCenterDownloadEngine a = new GameCenterDownloadEngine();
  
  private final WadlParams c(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.m == null) {
      paramADVideoAppDownloadData.m = RIJAdDownloadExKt.b(paramADVideoAppDownloadData);
    }
    return paramADVideoAppDownloadData.m;
  }
  
  private final boolean d(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return (paramADVideoAppDownloadData.l) && (paramADVideoAppDownloadData.m != null);
  }
  
  public void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.queryDownloadState.1(paramRIJDownloadView, paramADVideoAppDownloadData));
  }
  
  public boolean a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    String str;
    if (paramADVideoAppDownloadData != null) {
      str = paramADVideoAppDownloadData.n;
    } else {
      str = null;
    }
    if (TextUtils.isEmpty((CharSequence)str)) {
      return false;
    }
    if (paramADVideoAppDownloadData != null)
    {
      paramADVideoAppDownloadData = paramADVideoAppDownloadData.n;
      if (paramADVideoAppDownloadData != null) {}
    }
    else
    {
      paramADVideoAppDownloadData = "";
    }
    return new File(paramADVideoAppDownloadData).exists();
  }
  
  public void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.pauseDownload.1(paramADVideoAppDownloadData));
  }
  
  public boolean b(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      a.c(paramADVideoAppDownloadData);
    }
    WadlProxyServiceWrap localWadlProxyServiceWrap = WadlProxyServiceUtil.a();
    if (paramADVideoAppDownloadData != null) {
      paramADVideoAppDownloadData = paramADVideoAppDownloadData.m;
    } else {
      paramADVideoAppDownloadData = null;
    }
    localWadlProxyServiceWrap.c(paramADVideoAppDownloadData);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine
 * JD-Core Version:    0.7.0.1
 */