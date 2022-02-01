package com.tencent.biz.richframework.download;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import mqq.app.AppRuntime;

class RFWDownloader$2
  implements Runnable
{
  RFWDownloader$2(RFWDownloader paramRFWDownloader, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new RFWDownloader.2.1(this);
    localHttpNetReq.mReqUrl = this.val$downloadUrl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.val$downloadSavePath;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      QLog.i("DownLoadZipFile", 1, "startDownloadZipFile, url: " + this.val$downloadUrl);
      if (!RFWDownloader.access$100(this.this$0).contains(this.val$downloadUrl))
      {
        RFWDownloader.access$100(this.this$0).add(this.val$downloadUrl);
        ((QQAppInterface)localAppRuntime).getNetEngine(0).sendReq(localHttpNetReq);
      }
      return;
    }
    QLog.e("RFWDownloader", 1, "error Runtime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.2
 * JD-Core Version:    0.7.0.1
 */