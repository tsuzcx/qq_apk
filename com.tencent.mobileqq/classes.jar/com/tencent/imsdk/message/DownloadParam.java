package com.tencent.imsdk.message;

import java.io.Serializable;

public class DownloadParam
  implements Serializable
{
  public static int DOWNLOAD_FLAG_REQUEST_COS = 1;
  public static int DOWNLOAD_FLAG_REQUEST_DIRECT_DOWNLOAD = 2;
  public static int DOWNLOAD_FLAG_REQUEST_JIAPING = 0;
  public static int UUID_TYPE_VIDEO_AUDIO = 3;
  public static int UUID_TYPE_VIDEO_FILE = 1;
  public static int UUID_TYPE_VIDEO_THUMB = 0;
  public static int UUID_TYPE_VIDEO_VIDEO = 2;
  private int businessID;
  private int downloadFlag;
  private String downloadUrl;
  private String fileSavePath;
  private String uuid;
  private int uuidType;
  
  public void setBusinessID(int paramInt)
  {
    this.businessID = paramInt;
  }
  
  public void setDownloadFlag(int paramInt)
  {
    this.downloadFlag = paramInt;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public void setFileSavePath(String paramString)
  {
    this.fileSavePath = paramString;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setUuidType(int paramInt)
  {
    this.uuidType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.DownloadParam
 * JD-Core Version:    0.7.0.1
 */