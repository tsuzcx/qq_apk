package com.tencent.av.utils;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ScoreManager$DownloadInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  public HttpNetReq d = null;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append(", url='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", md5='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", fileName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */