package com.tencent.biz.subscribe;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class SubscribeUtils$1
  implements Runnable
{
  SubscribeUtils$1(String paramString1, File paramFile, String paramString2) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new SubscribeUtils.1.1(this);
    localHttpNetReq.mReqUrl = this.b;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.jdField_a_of_type_JavaIoFile.getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    QLog.i("DownLoadZipFile", 1, "startDownloadZipFile, url: " + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.1
 * JD-Core Version:    0.7.0.1
 */