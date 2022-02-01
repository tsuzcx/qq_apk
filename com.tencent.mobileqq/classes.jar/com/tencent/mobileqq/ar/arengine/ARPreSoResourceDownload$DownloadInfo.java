package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ARPreSoResourceDownload$DownloadInfo
{
  public int a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e;
  public boolean f = false;
  public HttpNetReq g = null;
  public long h;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append("type=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", url='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", md5='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", fileName='");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */