package com.tencent.mobileqq.ar.model;

import awbv;
import awdj;

public class ArDownloadInfo
  extends awbv
{
  public int dailyRetryCount;
  public long dailyStartTime;
  @awdj
  public String md5;
  public int totalRetryCount;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ArDownloadInfo{");
    localStringBuilder.append("md5='").append(this.md5).append('\'');
    localStringBuilder.append(", dailyRetryCount=").append(this.dailyRetryCount);
    localStringBuilder.append(", dailyStartTime=").append(this.dailyStartTime);
    localStringBuilder.append(", totalRetryCount=").append(this.totalRetryCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArDownloadInfo
 * JD-Core Version:    0.7.0.1
 */