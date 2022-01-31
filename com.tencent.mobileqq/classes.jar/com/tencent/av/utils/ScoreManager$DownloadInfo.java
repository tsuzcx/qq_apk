package com.tencent.av.utils;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ScoreManager$DownloadInfo
{
  public HttpNetReq a;
  public String a = "";
  public String b = "";
  public String c = "";
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append(", url='").append(this.a).append('\'');
    localStringBuffer.append(", md5='").append(this.b).append('\'');
    localStringBuffer.append(", fileName='").append(this.c).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */