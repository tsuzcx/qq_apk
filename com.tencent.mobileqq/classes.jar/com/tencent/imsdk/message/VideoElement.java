package com.tencent.imsdk.message;

public class VideoElement
  extends MessageBaseElement
{
  private int snapshotDownloadFlag;
  private String snapshotDownloadUrl;
  private String snapshotFilePath;
  private int snapshotFileSize;
  private int snapshotHeight;
  private String snapshotType;
  private String snapshotUUID;
  private int snapshotWidth;
  private int videoBusinessID;
  private int videoDownloadFlag;
  private String videoDownloadUrl;
  private int videoDuration;
  private String videoFilePath;
  private int videoFileSize;
  private String videoType;
  private String videoUUID;
  
  public VideoElement()
  {
    setElementType(5);
  }
  
  public int getSnapshotDownloadFlag()
  {
    return this.snapshotDownloadFlag;
  }
  
  public String getSnapshotDownloadUrl()
  {
    return this.snapshotDownloadUrl;
  }
  
  public String getSnapshotFilePath()
  {
    return this.snapshotFilePath;
  }
  
  public int getSnapshotFileSize()
  {
    return this.snapshotFileSize;
  }
  
  public int getSnapshotHeight()
  {
    return this.snapshotHeight;
  }
  
  public String getSnapshotType()
  {
    return this.snapshotType;
  }
  
  public String getSnapshotUUID()
  {
    return this.snapshotUUID;
  }
  
  public int getSnapshotWidth()
  {
    return this.snapshotWidth;
  }
  
  public int getVideoBusinessID()
  {
    return this.videoBusinessID;
  }
  
  public int getVideoDownloadFlag()
  {
    return this.videoDownloadFlag;
  }
  
  public String getVideoDownloadUrl()
  {
    return this.videoDownloadUrl;
  }
  
  public int getVideoDuration()
  {
    return this.videoDuration;
  }
  
  public String getVideoFilePath()
  {
    return this.videoFilePath;
  }
  
  public int getVideoFileSize()
  {
    return this.videoFileSize;
  }
  
  public String getVideoType()
  {
    return this.videoType;
  }
  
  public String getVideoUUID()
  {
    return this.videoUUID;
  }
  
  public void setSnapshotFilePath(String paramString)
  {
    this.snapshotFilePath = paramString;
  }
  
  public void setVideoDuration(int paramInt)
  {
    this.videoDuration = paramInt;
  }
  
  public void setVideoFilePath(String paramString)
  {
    this.videoFilePath = paramString;
  }
  
  public void setVideoType(String paramString)
  {
    this.videoType = paramString;
  }
  
  public boolean update(MessageBaseElement paramMessageBaseElement)
  {
    if (this.elementType == paramMessageBaseElement.elementType)
    {
      paramMessageBaseElement = (VideoElement)paramMessageBaseElement;
      if ((this.videoFilePath.equals(paramMessageBaseElement.videoFilePath)) && (this.snapshotFilePath.equals(paramMessageBaseElement.snapshotFilePath)))
      {
        this.videoUUID = paramMessageBaseElement.videoUUID;
        this.videoType = paramMessageBaseElement.videoType;
        this.videoFileSize = paramMessageBaseElement.videoFileSize;
        this.videoDuration = paramMessageBaseElement.videoDuration;
        this.videoDownloadUrl = paramMessageBaseElement.videoDownloadUrl;
        this.videoDownloadFlag = paramMessageBaseElement.videoDownloadFlag;
        this.videoBusinessID = paramMessageBaseElement.videoBusinessID;
        this.snapshotUUID = paramMessageBaseElement.snapshotUUID;
        this.snapshotType = paramMessageBaseElement.snapshotType;
        this.snapshotFileSize = paramMessageBaseElement.snapshotFileSize;
        this.snapshotWidth = paramMessageBaseElement.snapshotWidth;
        this.snapshotHeight = paramMessageBaseElement.snapshotHeight;
        this.snapshotDownloadUrl = paramMessageBaseElement.snapshotDownloadUrl;
        this.snapshotDownloadFlag = paramMessageBaseElement.snapshotDownloadFlag;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.VideoElement
 * JD-Core Version:    0.7.0.1
 */