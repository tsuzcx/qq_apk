package com.tencent.gdtad.views.video;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.Serializable;

public class GdtVideoData
  implements Serializable
{
  private GdtAd ad;
  private String coverURL;
  private long durationMillis;
  private boolean loop;
  private int playScene = -1;
  private long startPositionMillis;
  private String url;
  
  public GdtAd getAd()
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
  
  public boolean isLoop()
  {
    return this.loop;
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(getUrl());
  }
  
  public void setAd(GdtAd paramGdtAd)
  {
    if (paramGdtAd != null) {
      this.ad = paramGdtAd;
    }
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverURL = paramString;
  }
  
  public void setDurationMillis(long paramLong)
  {
    this.durationMillis = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.loop = paramBoolean;
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
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoData
 * JD-Core Version:    0.7.0.1
 */