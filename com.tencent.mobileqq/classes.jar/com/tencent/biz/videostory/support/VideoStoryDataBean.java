package com.tencent.biz.videostory.support;

import java.io.Serializable;

public class VideoStoryDataBean
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private String filterId;
  private int filterType;
  private boolean isLandTakePicToVideo;
  private boolean isTakePicToVideo;
  private String lensId;
  private String lensTabId;
  private long musciPlayTime;
  private int musicType;
  private String songMid = "";
  private String stickerId;
  private long videoDuration;
  private String watermarkId = "";
  private String wordId;
  
  public String getFilterId()
  {
    return this.filterId;
  }
  
  public int getFilterType()
  {
    return this.filterType;
  }
  
  public String getLensId()
  {
    return this.lensId;
  }
  
  public String getLensTabId()
  {
    return this.lensTabId;
  }
  
  public long getMusciPlayTime()
  {
    return this.musciPlayTime;
  }
  
  public int getMusicType()
  {
    return this.musicType;
  }
  
  public String getSongMid()
  {
    return this.songMid;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public boolean getTakePicToVideo()
  {
    return this.isTakePicToVideo;
  }
  
  public long getVideoDuration()
  {
    return this.videoDuration;
  }
  
  public String getWatermarkId()
  {
    return this.watermarkId;
  }
  
  public String getWordId()
  {
    return this.wordId;
  }
  
  public boolean isLandTakePicToVideo()
  {
    return this.isLandTakePicToVideo;
  }
  
  public void setFilterId(String paramString)
  {
    this.filterId = paramString;
  }
  
  public void setFilterType(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setLandTakePicToVideo(boolean paramBoolean)
  {
    this.isLandTakePicToVideo = paramBoolean;
  }
  
  public void setLensId(String paramString)
  {
    this.lensId = paramString;
  }
  
  public void setLensTabId(String paramString)
  {
    this.lensTabId = paramString;
  }
  
  public void setMusciPlayTime(long paramLong)
  {
    this.musciPlayTime = paramLong;
  }
  
  public void setMusicType(int paramInt)
  {
    this.musicType = paramInt;
  }
  
  public void setSongMid(String paramString)
  {
    this.songMid = paramString;
  }
  
  public void setStickerId(String paramString)
  {
    this.stickerId = paramString;
  }
  
  public void setTakePicToVideo(boolean paramBoolean)
  {
    this.isTakePicToVideo = paramBoolean;
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.videoDuration = paramLong;
  }
  
  public void setWatermarkId(String paramString)
  {
    this.watermarkId = paramString;
  }
  
  public void setWordId(String paramString)
  {
    this.wordId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.support.VideoStoryDataBean
 * JD-Core Version:    0.7.0.1
 */