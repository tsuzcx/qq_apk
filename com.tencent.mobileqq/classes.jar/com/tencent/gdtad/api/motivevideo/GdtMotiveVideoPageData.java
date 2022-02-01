package com.tencent.gdtad.api.motivevideo;

import java.io.Serializable;

public class GdtMotiveVideoPageData
  implements Serializable
{
  public static final int CONTAINER_ACTIVITY = 0;
  public static final int CONTAINER_WINDOW = 1;
  public static final int DEFAULT_BOTTOM_CARD_LOAD_SEC = 2;
  public static final int DEFAULT_ENDCARD_LOADTIME = 5;
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
  
  public String getRewardText()
  {
    return this.rewardText;
  }
  
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
  
  public void setRewardText(String paramString)
  {
    this.rewardText = paramString;
  }
  
  public void setVideoCountDown(int paramInt)
  {
    this.videoCountDown = paramInt;
  }
  
  public String toString()
  {
    return "GdtMotiveVideoPageData{vid='" + this.vid + '\'' + ", vSize=" + this.vSize + ", exposureUrl='" + this.exposureUrl + '\'' + ", bannerImgName='" + this.bannerImgName + '\'' + ", bannerBaseInfoText='" + this.bannerBaseInfoText + '\'' + ", bannerLogo='" + this.bannerLogo + '\'' + ", productType=" + this.productType + ", previewImgUrl='" + this.previewImgUrl + '\'' + ", adId=" + this.adId + ", downloadNum=" + this.downloadNum + ", appScore=" + this.appScore + ", jsState=" + this.jsState + ", url='" + this.url + '\'' + ", screenOrientation=" + this.screenOrientation + ", adsContent='" + this.adsContent + '\'' + ", processId=" + this.processId + ", style=" + this.style + ", refId='" + this.refId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData
 * JD-Core Version:    0.7.0.1
 */