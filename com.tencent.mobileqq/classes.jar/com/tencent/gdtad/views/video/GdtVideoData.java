package com.tencent.gdtad.views.video;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.io.Serializable;

public class GdtVideoData
  implements Serializable
{
  private Ad ad;
  private String coverURL;
  private boolean directPlay = false;
  private long durationMillis = 0L;
  private boolean forceNotShowControllerView;
  private boolean isVolumOpen = true;
  private boolean loop = true;
  private boolean needReport = true;
  private int playScene = -1;
  private long startPositionMillis = 0L;
  private String url;
  private int videoDefaultBackgroundColor = -16777216;
  
  public Ad getAd()
  {
    return this.ad;
  }
  
  public String getCoverUrl()
  {
    return this.coverURL;
  }
  
  public long getDurationMillis()
  {
    return this.durationMillis;
  }
  
  public int getPlayScene()
  {
    return this.playScene;
  }
  
  public long getStartPositionMillis()
  {
    return this.startPositionMillis;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getVideoDefaultBackgroundColor()
  {
    return this.videoDefaultBackgroundColor;
  }
  
  public boolean isDirectPlay()
  {
    return this.directPlay;
  }
  
  public boolean isForceNotShowControllerView()
  {
    return this.forceNotShowControllerView;
  }
  
  public boolean isLoop()
  {
    return this.loop;
  }
  
  public boolean isValid()
  {
    return TextUtils.isEmpty(getUrl()) ^ true;
  }
  
  public boolean isVolumOpen()
  {
    return this.isVolumOpen;
  }
  
  public boolean needReport()
  {
    return this.needReport;
  }
  
  public void setAd(Ad paramAd)
  {
    if (paramAd != null) {
      this.ad = paramAd;
    }
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverURL = paramString;
  }
  
  public void setDirectPlay(boolean paramBoolean)
  {
    this.directPlay = paramBoolean;
  }
  
  public void setDurationMillis(long paramLong)
  {
    this.durationMillis = paramLong;
  }
  
  public void setForceNotShowControllerView(boolean paramBoolean)
  {
    this.forceNotShowControllerView = paramBoolean;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public void setNeedReport(boolean paramBoolean)
  {
    this.needReport = paramBoolean;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.playScene = paramInt;
  }
  
  public void setStartPositionMillis(long paramLong)
  {
    this.startPositionMillis = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("https"))
      {
        this.url = paramString.replaceFirst("https", "http");
        return;
      }
      if (paramString.startsWith("HTTPS"))
      {
        this.url = paramString.replaceFirst("HTTPS", "http");
        return;
      }
      this.url = paramString;
    }
  }
  
  public void setVideoDefaultBackgroundColor(int paramInt)
  {
    this.videoDefaultBackgroundColor = paramInt;
  }
  
  public void setVolumOpen(boolean paramBoolean)
  {
    this.isVolumOpen = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoData
 * JD-Core Version:    0.7.0.1
 */