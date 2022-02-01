package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ArDownloadInfo
  extends Entity
{
  public int dailyRetryCount;
  public long dailyStartTime;
  @unique
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArDownloadInfo
 * JD-Core Version:    0.7.0.1
 */