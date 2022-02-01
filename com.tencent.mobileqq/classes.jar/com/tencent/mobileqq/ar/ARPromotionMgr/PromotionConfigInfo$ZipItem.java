package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class PromotionConfigInfo$ZipItem
{
  public final int a;
  String b;
  String c;
  String d = null;
  String e = null;
  final String f;
  int g = 1;
  boolean h = true;
  ResDownloadManager.IResDownloadListener i = null;
  Object j = new Object();
  int k = 0;
  long l = 0L;
  long m = 0L;
  long n = 0L;
  int o = -1;
  
  public PromotionConfigInfo$ZipItem(String paramString, int paramInt)
  {
    this.f = paramString;
    this.a = paramInt;
  }
  
  void a()
  {
    synchronized (this.j)
    {
      if (this.k == 1) {
        return;
      }
      if (this.k == -1)
      {
        String str = PromotionConfigInfo.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearDownladFlag, ZipItem[");
        localStringBuilder.append(this);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      a(0);
      this.l = 0L;
      this.m = 0L;
      this.n = 0L;
      return;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.j)
    {
      this.k = paramInt;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(", id[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], index[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], net_type[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], url[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], md5[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], zipFilePath[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], unzipDirPath[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], callByPreDownload[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], downloadType[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.ZipItem
 * JD-Core Version:    0.7.0.1
 */