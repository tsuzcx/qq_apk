package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "", "btnTextColor", "", "getBtnTextColor", "()Ljava/lang/String;", "setBtnTextColor", "(Ljava/lang/String;)V", "btnTextLength", "", "getBtnTextLength", "()I", "setBtnTextLength", "(I)V", "btnTextSize", "", "getBtnTextSize", "()F", "setBtnTextSize", "(F)V", "styleType", "getStyleType", "setStyleType", "Companion", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IDownloadStyle
{
  public static final IDownloadStyle.Companion a = IDownloadStyle.Companion.a;
  
  @NotNull
  public abstract String getBtnTextColor();
  
  public abstract int getBtnTextLength();
  
  public abstract float getBtnTextSize();
  
  public abstract int getStyleType();
  
  public abstract void setBtnTextColor(@NotNull String paramString);
  
  public abstract void setBtnTextSize(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle
 * JD-Core Version:    0.7.0.1
 */