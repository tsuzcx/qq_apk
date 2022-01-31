package com.tencent.gdtad.views.videoceiling;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.io.Serializable;

public class GdtVideoCeilingData
  implements Serializable
{
  private GdtAd ad;
  private GdtVideoData videoData;
  private String webUrl;
  
  public GdtAd getAd()
  {
    return this.ad;
  }
  
  public GdtVideoData getVideoData()
  {
    return this.videoData;
  }
  
  public String getWebUrl()
  {
    return this.webUrl;
  }
  
  public boolean isValid()
  {
    return (this.videoData != null) && (this.videoData.isValid()) && (!TextUtils.isEmpty(this.webUrl));
  }
  
  public void setAd(GdtAd paramGdtAd)
  {
    if (paramGdtAd == null) {}
    do
    {
      return;
      this.ad = paramGdtAd;
    } while (this.videoData == null);
    this.videoData.setAd(paramGdtAd);
  }
  
  public void setVideoData(GdtVideoData paramGdtVideoData)
  {
    this.videoData = paramGdtVideoData;
    this.videoData.setAd(this.ad);
    this.videoData.setLoop(true);
    this.videoData.setPlayScene(7);
  }
  
  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData
 * JD-Core Version:    0.7.0.1
 */