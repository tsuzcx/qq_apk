package com.tencent.mobileqq.ar.arengine;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ARResourceManagerTools
{
  long a;
  long b;
  int c;
  Object d = new Object();
  AppInterface e;
  private ARResourceDownload f;
  
  public ARResourceManagerTools(AppInterface paramAppInterface)
  {
    this.e = paramAppInterface;
    this.f = new ARResourceDownload(paramAppInterface);
  }
  
  private int a(long paramLong, int paramInt)
  {
    this.a = Math.max(paramLong, this.a);
    this.c = Math.max(paramInt, this.c);
    long l = this.b;
    if (l == 0L) {
      return this.c;
    }
    return Math.max((int)(paramLong * 100L / l), this.c);
  }
  
  public void a()
  {
    ARResourceDownload localARResourceDownload = this.f;
    if (localARResourceDownload != null) {
      localARResourceDownload.a();
    }
  }
  
  public void a(ArrayList<ARResourceDownload.DownloadInfo> paramArrayList, ARResourceManagerTools.ARResourceCallback paramARResourceCallback)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.a = 0L;
    int i = 0;
    this.c = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ARResourceDownload.DownloadInfo)((Iterator)localObject1).next();
      this.b = Math.max(this.b, ((ARResourceDownload.DownloadInfo)localObject2).g);
    }
    if (paramARResourceCallback != null) {
      paramARResourceCallback.a();
    }
    localObject1 = (ArrayList)paramArrayList.clone();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startDowdLoad size is ");
    ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
    QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject2).toString());
    while (i < paramArrayList.size())
    {
      if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).a != 4)
      {
        this.f.a((ARResourceDownload.DownloadInfo)paramArrayList.get(i), new ARResourceManagerTools.1(this, paramARResourceCallback, paramArrayList, (ArrayList)localObject1));
      }
      else if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).a == 4)
      {
        HtmlOffline.b();
        localObject2 = (ARResourceDownload.DownloadInfo)paramArrayList.get(i);
        HtmlOffline.a(((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).b, this.e, new ARResourceManagerTools.2(this, paramARResourceCallback, (ArrayList)localObject1, (ARResourceDownload.DownloadInfo)localObject2), true, 0, true);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    synchronized (this.d)
    {
      a();
      return;
    }
  }
  
  public void c()
  {
    ARResourceDownload localARResourceDownload = this.f;
    if (localARResourceDownload != null) {
      localARResourceDownload.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools
 * JD-Core Version:    0.7.0.1
 */