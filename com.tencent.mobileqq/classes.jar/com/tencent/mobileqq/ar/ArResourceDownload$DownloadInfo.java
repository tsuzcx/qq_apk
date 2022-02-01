package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ArResourceDownload$DownloadInfo
{
  int a;
  String b;
  String c;
  String d;
  int e;
  long f;
  long g;
  boolean h = false;
  boolean i = false;
  HttpNetReq j;
  
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
    localStringBuffer.append(", fileSize=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", downloadSize=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", req=");
    localStringBuffer.append(this.h);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */