package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/GameCenterDownloadEngine;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "()V", "buildDownloadParams", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "installApp", "", "isAppPkgExist", "isGameDownloadData", "pauseDownload", "queryDownloadState", "startDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GameCenterDownloadEngine
  extends IDownloadEngine
{
  public static final GameCenterDownloadEngine a = new GameCenterDownloadEngine();
  
  private final WadlParams a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null) {
      paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = RIJAdDownloadExKt.a(paramADVideoAppDownloadData);
    }
    return paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams;
  }
  
  private final boolean c(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return (paramADVideoAppDownloadData.jdField_a_of_type_Boolean) && (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams != null);
  }
  
  public void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.queryDownloadState.1(paramRIJDownloadView, paramADVideoAppDownloadData));
  }
  
  public boolean a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {}
    for (String str = paramADVideoAppDownloadData.i; TextUtils.isEmpty((CharSequence)str); str = null) {
      return false;
    }
    if (paramADVideoAppDownloadData != null)
    {
      paramADVideoAppDownloadData = paramADVideoAppDownloadData.i;
      if (paramADVideoAppDownloadData == null) {}
    }
    for (;;)
    {
      return new File(paramADVideoAppDownloadData).exists();
      paramADVideoAppDownloadData = "";
    }
  }
  
  public void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.pauseDownload.1(paramADVideoAppDownloadData));
  }
  
  public boolean b(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      a.a(paramADVideoAppDownloadData);
    }
    WadlProxyServiceWrap localWadlProxyServiceWrap = WadlProxyServiceUtil.a();
    if (paramADVideoAppDownloadData != null) {}
    for (paramADVideoAppDownloadData = paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams;; paramADVideoAppDownloadData = null)
    {
      localWadlProxyServiceWrap.c(paramADVideoAppDownloadData);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine
 * JD-Core Version:    0.7.0.1
 */