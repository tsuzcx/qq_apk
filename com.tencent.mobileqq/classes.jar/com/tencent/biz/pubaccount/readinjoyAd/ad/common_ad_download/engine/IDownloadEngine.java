package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "", "()V", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "installApp", "", "isAppPkgExist", "pauseDownload", "queryDownloadState", "startDownload", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public abstract class IDownloadEngine
{
  public abstract void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract boolean a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract boolean b(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine
 * JD-Core Version:    0.7.0.1
 */