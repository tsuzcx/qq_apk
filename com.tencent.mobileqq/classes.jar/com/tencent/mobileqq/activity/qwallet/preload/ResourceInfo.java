package com.tencent.mobileqq.activity.qwallet.preload;

import java.io.Serializable;

public class ResourceInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long doneTime;
  public String fileMd5;
  public String filePath;
  public String folderPath;
  public String resId;
  public int type;
  public String url;
  
  public String toString()
  {
    return "ResourceInfo{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", fileMd5='" + this.fileMd5 + '\'' + ", doneTime=" + this.doneTime + ", type=" + this.type + ", folderPath='" + this.folderPath + '\'' + ", resId='" + this.resId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo
 * JD-Core Version:    0.7.0.1
 */