package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DownloadingUrlEntry
  extends Entity
{
  public int bIsDownloadCompleted = 0;
  public int compressLevel = 0;
  public int fileType;
  @unique
  public String key;
  public long updatedMs;
  public String url;
  public String vid;
  
  public static String makeKey(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.DownloadingUrlEntry
 * JD-Core Version:    0.7.0.1
 */