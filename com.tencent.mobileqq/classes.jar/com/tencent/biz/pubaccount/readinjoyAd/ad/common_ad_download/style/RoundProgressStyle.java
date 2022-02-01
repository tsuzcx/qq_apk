package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/RoundProgressStyle;", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "(Ljava/lang/String;I)V", "btnDrawableNormalColor", "", "getBtnDrawableNormalColor", "()Ljava/lang/String;", "setBtnDrawableNormalColor", "(Ljava/lang/String;)V", "btnDrawableNormalRadius", "", "getBtnDrawableNormalRadius", "()F", "setBtnDrawableNormalRadius", "(F)V", "btnResource", "", "getBtnResource", "()I", "setBtnResource", "(I)V", "btnTextLength", "getBtnTextLength", "setBtnTextLength", "imageIconHeight", "getImageIconHeight", "setImageIconHeight", "imageIconWidth", "getImageIconWidth", "setImageIconWidth", "pauseRectColor", "getPauseRectColor", "setPauseRectColor", "pauseRectWidth", "getPauseRectWidth", "setPauseRectWidth", "progressColorHighLight", "getProgressColorHighLight", "setProgressColorHighLight", "progressColorNormal", "getProgressColorNormal", "setProgressColorNormal", "progressHighLightWidth", "getProgressHighLightWidth", "setProgressHighLightWidth", "progressWidthNormal", "getProgressWidthNormal", "setProgressWidthNormal", "roundSize", "getRoundSize", "setRoundSize", "startAngle", "getStartAngle", "setStartAngle", "styleType", "getStyleType", "setStyleType", "VideoSoftAd", "FastWebSoftAd", "DefaultRoundStyle", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public enum RoundProgressStyle
  implements IDownloadStyle
{
  @NotNull
  private String btnDrawableNormalColor = "#00000000";
  private float btnDrawableNormalRadius = 2.0F;
  private int btnResource = -1;
  private int btnTextLength = 4;
  private float imageIconHeight = -1.0F;
  private float imageIconWidth = -1.0F;
  @NotNull
  private String pauseRectColor = "#FF00CAFC";
  private float pauseRectWidth = 5.0F;
  @NotNull
  private String progressColorHighLight = "#FF00CAFC";
  @NotNull
  private String progressColorNormal = "#CCE5E5E5";
  private float progressHighLightWidth = 1.5F;
  private float progressWidthNormal = 1.5F;
  private float roundSize = 20.0F;
  private int startAngle = 270;
  private int styleType = 2;
  
  static
  {
    RoundProgressStyle.VideoSoftAd localVideoSoftAd = new RoundProgressStyle.VideoSoftAd("VideoSoftAd", 0);
    VideoSoftAd = localVideoSoftAd;
    RoundProgressStyle.FastWebSoftAd localFastWebSoftAd = new RoundProgressStyle.FastWebSoftAd("FastWebSoftAd", 1);
    FastWebSoftAd = localFastWebSoftAd;
    RoundProgressStyle.DefaultRoundStyle localDefaultRoundStyle = new RoundProgressStyle.DefaultRoundStyle("DefaultRoundStyle", 2);
    DefaultRoundStyle = localDefaultRoundStyle;
    $VALUES = new RoundProgressStyle[] { localVideoSoftAd, localFastWebSoftAd, localDefaultRoundStyle };
  }
  
  private RoundProgressStyle() {}
  
  @NotNull
  public String getBtnDrawableNormalColor()
  {
    return this.btnDrawableNormalColor;
  }
  
  public float getBtnDrawableNormalRadius()
  {
    return this.btnDrawableNormalRadius;
  }
  
  public int getBtnResource()
  {
    return this.btnResource;
  }
  
  public int getBtnTextLength()
  {
    return this.btnTextLength;
  }
  
  public float getImageIconHeight()
  {
    return this.imageIconHeight;
  }
  
  public float getImageIconWidth()
  {
    return this.imageIconWidth;
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
  
  public int getStyleType()
  {
    return this.styleType;
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
  
  public void setBtnResource(int paramInt)
  {
    this.btnResource = paramInt;
  }
  
  public void setBtnTextLength(int paramInt)
  {
    this.btnTextLength = paramInt;
  }
  
  public void setImageIconHeight(float paramFloat)
  {
    this.imageIconHeight = paramFloat;
  }
  
  public void setImageIconWidth(float paramFloat)
  {
    this.imageIconWidth = paramFloat;
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
  
  public void setStyleType(int paramInt)
  {
    this.styleType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle
 * JD-Core Version:    0.7.0.1
 */