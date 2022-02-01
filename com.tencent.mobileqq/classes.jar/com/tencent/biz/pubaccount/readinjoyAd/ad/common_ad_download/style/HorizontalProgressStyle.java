package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/HorizontalProgressStyle;", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "(Ljava/lang/String;I)V", "btnDrawableActiveColor", "", "getBtnDrawableActiveColor", "()Ljava/lang/String;", "setBtnDrawableActiveColor", "(Ljava/lang/String;)V", "btnDrawableActiveRadius", "", "getBtnDrawableActiveRadius", "()F", "setBtnDrawableActiveRadius", "(F)V", "btnDrawableNormalColor", "getBtnDrawableNormalColor", "setBtnDrawableNormalColor", "btnDrawableNormalRadius", "getBtnDrawableNormalRadius", "setBtnDrawableNormalRadius", "btnTextLength", "", "getBtnTextLength", "()I", "setBtnTextLength", "(I)V", "progressDrawable", "getProgressDrawable", "setProgressDrawable", "progressTextColor", "getProgressTextColor", "setProgressTextColor", "progressTextSize", "getProgressTextSize", "setProgressTextSize", "styleType", "getStyleType", "setStyleType", "VideoStyleNormal", "VideoStyleTikTok", "VideoCardStyleNormal", "VideoCardStyleTikTok", "FastWebGameStyle", "FastWebAppStyle", "DefaultHorizontalStyle", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum HorizontalProgressStyle
  implements IDownloadStyle
{
  @NotNull
  private String btnDrawableActiveColor = "#FF12B7F6";
  private float btnDrawableActiveRadius;
  @NotNull
  private String btnDrawableNormalColor = "#1AFFFFFF";
  private float btnDrawableNormalRadius;
  private int btnTextLength = 4;
  private int progressDrawable = 2130842913;
  @NotNull
  private String progressTextColor = "#FFFFFF";
  private float progressTextSize = 14.0F;
  private int styleType = 1;
  
  static
  {
    HorizontalProgressStyle.VideoStyleNormal localVideoStyleNormal = new HorizontalProgressStyle.VideoStyleNormal("VideoStyleNormal", 0);
    VideoStyleNormal = localVideoStyleNormal;
    HorizontalProgressStyle.VideoStyleTikTok localVideoStyleTikTok = new HorizontalProgressStyle.VideoStyleTikTok("VideoStyleTikTok", 1);
    VideoStyleTikTok = localVideoStyleTikTok;
    HorizontalProgressStyle.VideoCardStyleNormal localVideoCardStyleNormal = new HorizontalProgressStyle.VideoCardStyleNormal("VideoCardStyleNormal", 2);
    VideoCardStyleNormal = localVideoCardStyleNormal;
    HorizontalProgressStyle.VideoCardStyleTikTok localVideoCardStyleTikTok = new HorizontalProgressStyle.VideoCardStyleTikTok("VideoCardStyleTikTok", 3);
    VideoCardStyleTikTok = localVideoCardStyleTikTok;
    HorizontalProgressStyle.FastWebGameStyle localFastWebGameStyle = new HorizontalProgressStyle.FastWebGameStyle("FastWebGameStyle", 4);
    FastWebGameStyle = localFastWebGameStyle;
    HorizontalProgressStyle.FastWebAppStyle localFastWebAppStyle = new HorizontalProgressStyle.FastWebAppStyle("FastWebAppStyle", 5);
    FastWebAppStyle = localFastWebAppStyle;
    HorizontalProgressStyle.DefaultHorizontalStyle localDefaultHorizontalStyle = new HorizontalProgressStyle.DefaultHorizontalStyle("DefaultHorizontalStyle", 6);
    DefaultHorizontalStyle = localDefaultHorizontalStyle;
    $VALUES = new HorizontalProgressStyle[] { localVideoStyleNormal, localVideoStyleTikTok, localVideoCardStyleNormal, localVideoCardStyleTikTok, localFastWebGameStyle, localFastWebAppStyle, localDefaultHorizontalStyle };
  }
  
  private HorizontalProgressStyle() {}
  
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
  
  public int getBtnTextLength()
  {
    return this.btnTextLength;
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
  
  public int getStyleType()
  {
    return this.styleType;
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
  
  public void setBtnTextLength(int paramInt)
  {
    this.btnTextLength = paramInt;
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
  
  public void setStyleType(int paramInt)
  {
    this.styleType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle
 * JD-Core Version:    0.7.0.1
 */