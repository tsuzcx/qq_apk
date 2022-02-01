package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ARPreSoResourceDownload
{
  public QQAppInterface a = null;
  private ArrayList<ARPreSoResourceDownload.DownloadInfo> b = null;
  private Object c = new Object();
  private IHttpEngineService d = null;
  private IPreDownloadController e;
  private HashMap<String, ARPreSoResourceDownload.ARResourceDownloadCallback> f;
  
  public ARPreSoResourceDownload(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.d = ((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all"));
    this.b = new ArrayList();
    this.f = new HashMap();
    this.e = ((IPreDownloadController)this.a.getRuntimeService(IPreDownloadController.class));
  }
  
  public boolean a(ARPreSoResourceDownload.DownloadInfo paramDownloadInfo, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    if (paramDownloadInfo != null)
    {
      if (paramARResourceDownloadCallback == null) {
        return false;
      }
      Object localObject1 = new ARPreSoResourceDownload.1(this, paramDownloadInfo);
      ??? = new ARPreSoResourceDownload.2(this);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = ((INetEngineListener)???);
      localHttpNetReq.mReqUrl = paramDownloadInfo.b;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = paramDownloadInfo.d;
      localHttpNetReq.mPrioty = 1;
      localHttpNetReq.mSupportBreakResume = true;
      paramDownloadInfo.g = localHttpNetReq;
      synchronized (this.c)
      {
        this.b.add(paramDownloadInfo);
        int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (i != 1)
        {
          if (i == 2) {
            break label152;
          }
          if (i == 3) {
            break label147;
          }
          if (i == 4) {}
        }
        else
        {
          i = 1;
          break label154;
        }
        i = 4;
        break label154;
        label147:
        i = 3;
        break label154;
        label152:
        i = 2;
        label154:
        localObject1 = new ARPreSoResourceDownload.3(this, this.a, paramDownloadInfo.c, (HttpEngineTask.IHttpEngineTask)localObject1, localHttpNetReq, paramDownloadInfo, paramARResourceDownloadCallback);
        this.e.requestPreDownload(10065, "prd", paramDownloadInfo.c, 0, paramDownloadInfo.b, localHttpNetReq.mOutPath, i, 0, false, (AbsPreDownloadTask)localObject1);
        this.f.put(paramDownloadInfo.c, paramARResourceDownloadCallback);
        paramARResourceDownloadCallback = new StringBuilder();
        paramARResourceDownloadCallback.append("submitDownloadTask. url = ");
        paramARResourceDownloadCallback.append(paramDownloadInfo.b);
        QLog.i("AREngine_ARPreSoResourceDownload", 1, paramARResourceDownloadCallback.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload
 * JD-Core Version:    0.7.0.1
 */