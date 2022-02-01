package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/HorizontalProgressStyle$DefaultHorizontalStyle;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/HorizontalProgressStyle;", "btnDrawableActiveColor", "", "getBtnDrawableActiveColor", "()Ljava/lang/String;", "setBtnDrawableActiveColor", "(Ljava/lang/String;)V", "btnDrawableActiveRadius", "", "getBtnDrawableActiveRadius", "()F", "setBtnDrawableActiveRadius", "(F)V", "btnDrawableNormalColor", "getBtnDrawableNormalColor", "setBtnDrawableNormalColor", "btnDrawableNormalRadius", "getBtnDrawableNormalRadius", "setBtnDrawableNormalRadius", "btnTextColor", "getBtnTextColor", "setBtnTextColor", "btnTextSize", "getBtnTextSize", "setBtnTextSize", "progressDrawable", "", "getProgressDrawable", "()I", "setProgressDrawable", "(I)V", "progressTextColor", "getProgressTextColor", "setProgressTextColor", "progressTextSize", "getProgressTextSize", "setProgressTextSize", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class HorizontalProgressStyle$DefaultHorizontalStyle
  extends HorizontalProgressStyle
{
  @NotNull
  private String btnDrawableActiveColor = "#FF12B7F5";
  private float btnDrawableActiveRadius = 2.0F;
  @NotNull
  private String btnDrawableNormalColor = "#00000000";
  private float btnDrawableNormalRadius = 2.0F;
  @NotNull
  private String btnTextColor = "#FF12B7F5";
  private float btnTextSize = 12.0F;
  private int progressDrawable = 2130843754;
  @NotNull
  private String progressTextColor = "#FFFFFF";
  private float progressTextSize = 12.0F;
  
  HorizontalProgressStyle$DefaultHorizontalStyle()
  {
    super(str, i, null);
  }
  
  @NotNull
  public String getBtnDrawableActiveColor()
  {
    return this.btnDrawableActiveColor;
  }
  
  public float getBtnDrawableActiveRadius()
  {
    return this.btnDrawableActiveRadius;
  }
  
  @NotNull
  public String getBtnDrawableNormalColor()
  {
    return this.btnDrawableNormalColor;
  }
  
  public float getBtnDrawableNormalRadius()
  {
    return this.btnDrawableNormalRadius;
  }
  
  @NotNull
  public String getBtnTextColor()
  {
    return this.btnTextColor;
  }
  
  public float getBtnTextSize()
  {
    return this.btnTextSize;
  }
  
  public int getProgressDrawable()
  {
    return this.progressDrawable;
  }
  
  @NotNull
  public String getProgressTextColor()
  {
    return this.progressTextColor;
  }
  
  public float getProgressTextSize()
  {
    return this.progressTextSize;
  }
  
  public void setBtnDrawableActiveColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.btnDrawableActiveColor = paramString;
  }
  
  public void setBtnDrawableActiveRadius(float paramFloat)
  {
    this.btnDrawableActiveRadius = paramFloat;
  }
  
  public void setBtnDrawableNormalColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.btnDrawableNormalColor = paramString;
  }
  
  public void setBtnDrawableNormalRadius(float paramFloat)
  {
    this.btnDrawableNormalRadius = paramFloat;
  }
  
  public void setBtnTextColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.btnTextColor = paramString;
  }
  
  public void setBtnTextSize(float paramFloat)
  {
    this.btnTextSize = paramFloat;
  }
  
  public void setProgressDrawable(int paramInt)
  {
    this.progressDrawable = paramInt;
  }
  
  public void setProgressTextColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.progressTextColor = paramString;
  }
  
  public void setProgressTextSize(float paramFloat)
  {
    this.progressTextSize = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle.DefaultHorizontalStyle
 * JD-Core Version:    0.7.0.1
 */