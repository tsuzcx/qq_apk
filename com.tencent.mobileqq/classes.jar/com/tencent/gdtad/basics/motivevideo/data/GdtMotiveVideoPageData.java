package com.tencent.gdtad.basics.motivevideo.data;

import java.io.Serializable;

public class GdtMotiveVideoPageData
  implements Serializable
{
  public static final int CONTAINER_ACTIVITY = 0;
  public static final int CONTAINER_WINDOW = 1;
  public static final int DEFAULT_BOTTOM_CARD_LOAD_SEC = 2;
  public static final int DEFAULT_ENDCARD_LOADTIME = 5;
  public static final int DEFAULT_SHOT_SECONDS = 15;
  public static String TAG = "GdtMotiveVideoAd";
  public long adId;
  public String adsContent;
  public String antiSpamParams;
  public double appScore = 0.0D;
  public String bannerBaseInfoText;
  public String bannerImgName;
  public String bannerLogo;
  public int bottomCardLoadTime = 2;
  public String bottomCardUrl;
  public int containerType = 0;
  public long downloadNum = 0L;
  public int endcardLoadTime = 5;
  public String endcardUrl;
  public String exposureUrl;
  private String hippyAsyncCallbackId;
  public long jsState;
  public String motiveBrowsingKey;
  public String previewImgUrl;
  public int processId;
  public int productType;
  public String refId;
  private String rewardText;
  public int screenOrientation = 0;
  public int style = 0;
  public String traceId;
  public String url;
  public int vSize;
  public String vid;
  private int videoCountDown = 15;
  
  public String getHippyAsyncCallbackId()
  {
    return this.hippyAsyncCallbackId;
  }
  
  public String getRewardText()
  {
    return this.rewardText;
  }
  
  @Deprecated
  public int getVideoCountDown()
  {
    return this.videoCountDown;
  }
  
  public boolean isStyleA()
  {
    return this.style == 0;
  }
  
  public boolean isStyleB()
  {
    return this.style == 1;
  }
  
  public boolean isStyleC()
  {
    return this.style == 2;
  }
  
  public void setHippyAsyncCallbackId(String paramString)
  {
    this.hippyAsyncCallbackId = paramString;
  }
  
  public void setRewardText(String paramString)
  {
    this.rewardText = paramString;
  }
  
  @Deprecated
  public void setVideoCountDown(int paramInt)
  {
    this.videoCountDown = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GdtMotiveVideoPageData{vid='");
    localStringBuilder.append(this.vid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vSize=");
    localStringBuilder.append(this.vSize);
    localStringBuilder.append(", exposureUrl='");
    localStringBuilder.append(this.exposureUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerImgName='");
    localStringBuilder.append(this.bannerImgName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerBaseInfoText='");
    localStringBuilder.append(this.bannerBaseInfoText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerLogo='");
    localStringBuilder.append(this.bannerLogo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", productType=");
    localStringBuilder.append(this.productType);
    localStringBuilder.append(", previewImgUrl='");
    localStringBuilder.append(this.previewImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adId=");
    localStringBuilder.append(this.adId);
    localStringBuilder.append(", downloadNum=");
    localStringBuilder.append(this.downloadNum);
    localStringBuilder.append(", appScore=");
    localStringBuilder.append(this.appScore);
    localStringBuilder.append(", jsState=");
    localStringBuilder.append(this.jsState);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", screenOrientation=");
    localStringBuilder.append(this.screenOrientation);
    localStringBuilder.append(", adsContent='");
    localStringBuilder.append(this.adsContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", processId=");
    localStringBuilder.append(this.processId);
    localStringBuilder.append(", style=");
    localStringBuilder.append(this.style);
    localStringBuilder.append(", refId='");
    localStringBuilder.append(this.refId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData
 * JD-Core Version:    0.7.0.1
 */