package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "", "pause", "", "setProgress", "progress", "", "setProgressStyle", "style", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setProgressText", "text", "", "start", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IProgressView
{
  public abstract void a();
  
  public abstract void b();
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setProgressText(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.IProgressView
 * JD-Core Version:    0.7.0.1
 */