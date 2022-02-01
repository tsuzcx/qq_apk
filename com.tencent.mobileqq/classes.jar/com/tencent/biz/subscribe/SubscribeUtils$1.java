package com.tencent.biz.subscribe;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
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
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new SubscribeUtils.1.1(this);
    ((HttpNetReq)localObject).mReqUrl = this.b;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = this.jdField_a_of_type_JavaIoFile.getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadZipFile, url: ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("DownLoadZipFile", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.1
 * JD-Core Version:    0.7.0.1
 */