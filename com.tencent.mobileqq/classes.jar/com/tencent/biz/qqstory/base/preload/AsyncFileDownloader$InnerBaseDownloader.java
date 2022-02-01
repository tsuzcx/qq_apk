package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import dov.com.qq.im.capture.QIMManager;

class AsyncFileDownloader$InnerBaseDownloader
  implements AsyncFileDownloader.InnerDownloader
{
  private AsyncFileDownloader$InnerBaseDownloader(AsyncFileDownloader paramAsyncFileDownloader) {}
  
  protected IHttpEngineService a()
  {
    AppInterface localAppInterface = QIMManager.a();
    if (localAppInterface != null) {
      return (IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    }
    return null;
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.jdField_d_of_type_Int = 0;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramDownloadTask.jdField_d_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramDownloadTask.e;
    localHttpNetReq.mTempPath = paramDownloadTask.f;
    localHttpNetReq.mPrioty = paramDownloadTask.g;
    localHttpNetReq.mContinuErrorLimit = 3;
    localHttpNetReq.setUserData(paramDownloadTask);
    localHttpNetReq.mSupportBreakResume = true;
    paramDownloadTask.a = localHttpNetReq;
    localHttpNetReq.mCallback = new AsyncFileDownloader.InnerBaseDownloader.1(this);
    IHttpEngineService localIHttpEngineService = a();
    if (localIHttpEngineService != null) {
      localIHttpEngineService.sendReq(localHttpNetReq);
    }
    SLog.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramDownloadTask);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    HttpNetReq localHttpNetReq = paramDownloadTask.a;
    if (localHttpNetReq != null)
    {
      IHttpEngineService localIHttpEngineService = a();
      if (localIHttpEngineService != null) {
        localIHttpEngineService.cancelReq(localHttpNetReq);
      }
      SLog.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramDownloadTask }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader
 * JD-Core Version:    0.7.0.1
 */