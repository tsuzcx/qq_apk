package com.tencent.biz.qqstory.base.preload;

import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;

class AsyncFileDownloader$InnerBaseDownloader
  implements AsyncFileDownloader.InnerDownloader
{
  private AsyncFileDownloader$InnerBaseDownloader(AsyncFileDownloader paramAsyncFileDownloader) {}
  
  public void a(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.j = 0;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramDownloadTask.f;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramDownloadTask.g;
    localHttpNetReq.mTempPath = paramDownloadTask.h;
    localHttpNetReq.mPrioty = paramDownloadTask.s;
    localHttpNetReq.mContinuErrorLimit = 3;
    localHttpNetReq.setUserData(paramDownloadTask);
    localHttpNetReq.mSupportBreakResume = true;
    paramDownloadTask.u = localHttpNetReq;
    localHttpNetReq.mCallback = new AsyncFileDownloader.InnerBaseDownloader.1(this);
    IHttpEngineService localIHttpEngineService = b();
    if (localIHttpEngineService != null) {
      localIHttpEngineService.sendReq(localHttpNetReq);
    }
    SLog.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramDownloadTask);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected IHttpEngineService b()
  {
    AppInterface localAppInterface = ((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface();
    if (localAppInterface != null) {
      return (IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    }
    return null;
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    HttpNetReq localHttpNetReq = paramDownloadTask.u;
    if (localHttpNetReq != null)
    {
      IHttpEngineService localIHttpEngineService = b();
      if (localIHttpEngineService != null) {
        localIHttpEngineService.cancelReq(localHttpNetReq);
      }
      SLog.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramDownloadTask }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader
 * JD-Core Version:    0.7.0.1
 */