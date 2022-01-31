package com.tencent.gdtad.api.motivevideo;

import android.os.ResultReceiver;
import java.io.Serializable;

public class GdtMotiveVideoPageData
  implements Serializable
{
  public static final int CONTAINER_ACTIVITY = 0;
  public static final int CONTAINER_WINDOW = 1;
  public static String TAG = "GdtMotiveVideoAd";
  public long adId;
  public String adsContent;
  public double appScore = 0.0D;
  public String bannerBaseInfoText;
  public String bannerImgName;
  public String bannerLogo;
  public int containerType = 0;
  public long downloadNum;
  public String exposureUrl;
  public long jsState;
  public String previewImgUrl;
  public int processId;
  public int productType;
  public String refId;
  public ResultReceiver resultReceiver;
  public int screenOrientation = 0;
  public int style;
  public String url;
  public int vSize;
  public String vid;
  private int videoCountDown = 15;
  
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
  
  public void setVideoCountDown(int paramInt)
  {
    this.videoCountDown = paramInt;
  }
  
  public String toString()
  {
    return "GdtMotiveVideoPageData{vid='" + this.vid + '\'' + ", vSize=" + this.vSize + ", exposureUrl='" + this.exposureUrl + '\'' + ", bannerImgName='" + this.bannerImgName + '\'' + ", bannerBaseInfoText='" + this.bannerBaseInfoText + '\'' + ", bannerLogo='" + this.bannerLogo + '\'' + ", productType=" + this.productType + ", previewImgUrl='" + this.previewImgUrl + '\'' + ", adId=" + this.adId + ", downloadNum=" + this.downloadNum + ", appScore=" + this.appScore + ", jsState=" + this.jsState + ", url='" + this.url + '\'' + ", screenOrientation=" + this.screenOrientation + ", adsContent='" + this.adsContent + '\'' + ", processId=" + this.processId + ", style=" + this.style + ", refId='" + this.refId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData
 * JD-Core Version:    0.7.0.1
 */