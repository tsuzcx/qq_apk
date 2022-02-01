package com.tencent.aelight.camera.ae.util;

import android.support.annotation.WorkerThread;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEDownloader
{
  public static AEDownloader a()
  {
    return AEDownloader.InstanceHolder.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realDownload---url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", saveName=");
    ((StringBuilder)localObject).append(paramString2);
    AEQLog.b("AEDownloader", ((StringBuilder)localObject).toString());
    localObject = AECaptureContext.a();
    if (localObject == null)
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
      AEQLog.d("AEDownloader", "realDownload---FAIL appInterface is null");
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEDownloader.InnerDownloadListener(paramString1, paramString2, paramDownloadListener);
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(paramString2).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    try
    {
      ((IHttpEngineService)((AppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        paramString1.printStackTrace();
      }
      AEQLog.a("AEDownloader", "realDownload---exception: ", paramString1);
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    b(paramString1, paramString2, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AEDownloader
 * JD-Core Version:    0.7.0.1
 */