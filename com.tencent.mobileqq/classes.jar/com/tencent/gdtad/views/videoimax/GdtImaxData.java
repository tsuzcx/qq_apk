package com.tencent.gdtad.views.videoimax;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.io.Serializable;

public class GdtImaxData
  implements Serializable
{
  private GdtAd ad;
  private GdtVideoData videoData;
  private int videoSplicePageStyle;
  private String webUrl;
  
  public GdtAd getAd()
  {
    return this.ad;
  }
  
  public GdtVideoData getVideoData()
  {
    return this.videoData;
  }
  
  public int getVideoSplicePageStyle()
  {
    return this.videoSplicePageStyle;
  }
  
  public String getWebUrl()
  {
    return this.webUrl;
  }
  
  public void setAd(GdtAd paramGdtAd)
  {
    this.ad = paramGdtAd;
  }
  
  public void setVideoData(GdtVideoData paramGdtVideoData)
  {
    this.videoData = paramGdtVideoData;
  }
  
  public void setVideoSplicePageStyle(int paramInt)
  {
    this.videoSplicePageStyle = paramInt;
  }
  
  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtImaxData
 * JD-Core Version:    0.7.0.1
 */