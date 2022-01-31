package com.tencent.biz.qqstory.database;

import awbv;
import awdj;

public class DownloadingUrlEntry
  extends awbv
{
  public int bIsDownloadCompleted = 0;
  public int compressLevel;
  public int fileType;
  @awdj
  public String key;
  public long updatedMs;
  public String url;
  public String vid;
  
  public static String makeKey(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.DownloadingUrlEntry
 * JD-Core Version:    0.7.0.1
 */