package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARResourceDownload
{
  public AppInterface a = null;
  private ArrayList<ARResourceDownload.DownloadInfo> b = null;
  private Object c = new Object();
  private IHttpEngineService d = null;
  
  public ARResourceDownload(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.d = ((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all"));
    this.b = new ArrayList();
  }
  
  public void a()
  {
    Object localObject1 = this.c;
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancelDownloadTask. url = ");
        localStringBuilder.append(((ARResourceDownload.DownloadInfo)this.b.get(i)).b);
        QLog.i("AREngine_ARResourceDownload", 1, localStringBuilder.toString());
        this.d.cancelReq(((ARResourceDownload.DownloadInfo)this.b.get(i)).f);
        i += 1;
      }
      this.b.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean a(ARResourceDownload.DownloadInfo paramDownloadInfo, ARResourceDownload.ARResourceDownloadCallback arg2)
  {
    if (paramDownloadInfo != null)
    {
      if (??? == null) {
        return false;
      }
      ??? = new ARResourceDownload.1(this, paramDownloadInfo, ???);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = ???;
      localHttpNetReq.mReqUrl = paramDownloadInfo.b;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = paramDownloadInfo.d;
      localHttpNetReq.mPrioty = 1;
      localHttpNetReq.mSupportBreakResume = true;
      this.d.sendReq(localHttpNetReq);
      paramDownloadInfo.f = localHttpNetReq;
      synchronized (this.c)
      {
        this.b.add(paramDownloadInfo);
        ??? = new StringBuilder();
        ???.append("submitDownloadTask. url = ");
        ???.append(paramDownloadInfo.b);
        QLog.i("AREngine_ARResourceDownload", 1, ???.toString());
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceDownload
 * JD-Core Version:    0.7.0.1
 */