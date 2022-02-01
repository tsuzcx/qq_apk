package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/RoundProgressStyle$DefaultRoundStyle;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/RoundProgressStyle;", "btnTextColor", "", "getBtnTextColor", "()Ljava/lang/String;", "setBtnTextColor", "(Ljava/lang/String;)V", "btnTextSize", "", "getBtnTextSize", "()F", "setBtnTextSize", "(F)V", "pauseRectColor", "getPauseRectColor", "setPauseRectColor", "pauseRectWidth", "getPauseRectWidth", "setPauseRectWidth", "progressColorHighLight", "getProgressColorHighLight", "setProgressColorHighLight", "progressColorNormal", "getProgressColorNormal", "setProgressColorNormal", "progressHighLightWidth", "getProgressHighLightWidth", "setProgressHighLightWidth", "progressWidthNormal", "getProgressWidthNormal", "setProgressWidthNormal", "roundSize", "getRoundSize", "setRoundSize", "startAngle", "", "getStartAngle", "()I", "setStartAngle", "(I)V", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class RoundProgressStyle$DefaultRoundStyle
  extends RoundProgressStyle
{
  @NotNull
  private String btnTextColor = "#FF12B7F5";
  private float btnTextSize = 12.0F;
  @NotNull
  private String pauseRectColor = "#FF00CAFC";
  private float pauseRectWidth = 5.0F;
  @NotNull
  private String progressColorHighLight = "#FF00CAFC";
  @NotNull
  private String progressColorNormal = "#CCE5E5E5";
  private float progressHighLightWidth = 1.5F;
  private float progressWidthNormal = 1.5F;
  private float roundSize = 18.0F;
  private int startAngle = 270;
  
  RoundProgressStyle$DefaultRoundStyle()
  {
    super(str, i, null);
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
  
  @NotNull
  public String getPauseRectColor()
  {
    return this.pauseRectColor;
  }
  
  public float getPauseRectWidth()
  {
    return this.pauseRectWidth;
  }
  
  @NotNull
  public String getProgressColorHighLight()
  {
    return this.progressColorHighLight;
  }
  
  @NotNull
  public String getProgressColorNormal()
  {
    return this.progressColorNormal;
  }
  
  public float getProgressHighLightWidth()
  {
    return this.progressHighLightWidth;
  }
  
  public float getProgressWidthNormal()
  {
    return this.progressWidthNormal;
  }
  
  public float getRoundSize()
  {
    return this.roundSize;
  }
  
  public int getStartAngle()
  {
    return this.startAngle;
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
  
  public void setPauseRectColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.pauseRectColor = paramString;
  }
  
  public void setPauseRectWidth(float paramFloat)
  {
    this.pauseRectWidth = paramFloat;
  }
  
  public void setProgressColorHighLight(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.progressColorHighLight = paramString;
  }
  
  public void setProgressColorNormal(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.progressColorNormal = paramString;
  }
  
  public void setProgressHighLightWidth(float paramFloat)
  {
    this.progressHighLightWidth = paramFloat;
  }
  
  public void setProgressWidthNormal(float paramFloat)
  {
    this.progressWidthNormal = paramFloat;
  }
  
  public void setRoundSize(float paramFloat)
  {
    this.roundSize = paramFloat;
  }
  
  public void setStartAngle(int paramInt)
  {
    this.startAngle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle.DefaultRoundStyle
 * JD-Core Version:    0.7.0.1
 */