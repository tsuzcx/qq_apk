package com.tencent.biz.qqcircle.download;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QCircleRichMediaDownLoadManager
{
  private static final String a;
  private static volatile QCircleRichMediaDownLoadManager b;
  private HandlerThread c = new HandlerThread("QCircleRichMediaDownLoadManager");
  private Handler d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleConstants.i);
    localStringBuilder.append("feedRichMedia/");
    a = localStringBuilder.toString();
  }
  
  private QCircleRichMediaDownLoadManager()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(".nomedia");
    HostFileUtils.createFileIfNotExits(localStringBuilder.toString());
    HostStaticInvokeHelper.registerNetworkMonitorReceiver();
  }
  
  public static QCircleRichMediaDownLoadManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QCircleRichMediaDownLoadManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private boolean b(QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    if (HostFileUtils.moveFile(paramDownLoadParams.c(), QCircleRichMediaDownLoadManager.DownLoadParams.b(paramDownLoadParams)))
    {
      Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject).setData(Uri.fromFile(new File(QCircleRichMediaDownLoadManager.DownLoadParams.b(paramDownLoadParams))));
      QCircleApplication.APP.sendBroadcast((Intent)localObject);
      if (QCircleRichMediaDownLoadManager.DownLoadParams.a(paramDownLoadParams) != null) {
        QCircleRichMediaDownLoadManager.DownLoadParams.a(paramDownLoadParams).a(true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDownLoadParams.a());
      ((StringBuilder)localObject).append(" ,move file to local album ");
      QLog.d("QCircleRichMediaDownLoadManager", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    HostFileUtils.delete(paramDownLoadParams.c(), true);
    return false;
  }
  
  private void c(QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    this.d.post(new QCircleRichMediaDownLoadManager.2(this, paramDownLoadParams));
  }
  
  private void d(QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramDownLoadParams.a());
    ((StringBuilder)localObject).append(",download start ");
    QLog.d("QCircleRichMediaDownLoadManager", 1, ((StringBuilder)localObject).toString());
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new QCircleRichMediaDownLoadManager.3(this, paramDownLoadParams);
    ((HttpNetReq)localObject).mReqUrl = paramDownLoadParams.a();
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = paramDownLoadParams.c();
    ((HttpNetReq)localObject).mContinuErrorLimit = HostNetworkUtils.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    HostHttpUtils.httpEngineServiceSendRequest((HttpNetReq)localObject);
    HostStaticInvokeHelper.addNetwortChangedObserver(new QCircleRichMediaDownLoadManager.DownLoadChangObserver(paramDownLoadParams, (HttpNetReq)localObject));
  }
  
  public void a(QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    if (paramDownLoadParams != null) {
      this.d.post(new QCircleRichMediaDownLoadManager.1(this, paramDownLoadParams));
    }
  }
  
  public void b()
  {
    this.d.removeCallbacks(null);
    HostFileUtils.deleteDirectory(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager
 * JD-Core Version:    0.7.0.1
 */