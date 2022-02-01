package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class ARPreSoResourceDownload$1
  implements HttpEngineTask.IHttpEngineTask
{
  ARPreSoResourceDownload$1(ARPreSoResourceDownload paramARPreSoResourceDownload, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int i = paramNetResp.mResult;
    boolean bool2 = true;
    if (i == 3)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Download init. url = ");
      ((StringBuilder)???).append(((HttpNetReq)paramNetResp.mReq).mReqUrl);
      QLog.i("AREngine_ARPreSoResourceDownload", 1, ((StringBuilder)???).toString());
      return;
    }
    label460:
    synchronized (ARPreSoResourceDownload.a(this.b))
    {
      if (ARPreSoResourceDownload.b(this.b) != null)
      {
        i = 0;
        if (i < ARPreSoResourceDownload.b(this.b).size())
        {
          if (!((ARPreSoResourceDownload.DownloadInfo)ARPreSoResourceDownload.b(this.b).get(i)).b.equals(this.a.b)) {
            break label460;
          }
          ARPreSoResourceDownload.b(this.b).remove(i);
        }
      }
      synchronized (ARPreSoResourceDownload.c(this.b))
      {
        ??? = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.c(this.b).get(this.a.c);
        boolean bool1;
        if (paramNetResp.mResult == 0)
        {
          if (ARPreSoResourceDownload.d(this.b) != null) {
            ARPreSoResourceDownload.d(this.b).preDownloadSuccess(this.a.b, this.a.h);
          }
          ??? = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
          String str = PortalUtils.a(((File)???).getAbsolutePath());
          if (!TextUtils.isEmpty(str))
          {
            bool1 = bool2;
            if (str.equalsIgnoreCase(this.a.c)) {}
          }
          else
          {
            bool1 = bool2;
            if (this.a.a != 1)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Download end. MD5 check error. url = ");
              localStringBuilder.append(((HttpNetReq)paramNetResp.mReq).mReqUrl);
              localStringBuilder.append(", fileName = ");
              localStringBuilder.append(((File)???).getAbsolutePath());
              localStringBuilder.append(", fileMD5 = ");
              localStringBuilder.append(str);
              QLog.i("AREngine_ARPreSoResourceDownload", 1, localStringBuilder.toString());
              if (??? != null) {
                ((ARPreSoResourceDownload.ARResourceDownloadCallback)???).a(false, this.a);
              }
            }
          }
        }
        else
        {
          if (ARPreSoResourceDownload.d(this.b) != null) {
            ARPreSoResourceDownload.d(this.b).preDownloadSuccess(this.a.b, -1L);
          }
          bool1 = false;
        }
        if (??? != null) {
          ((ARPreSoResourceDownload.ARResourceDownloadCallback)???).a(bool1, this.a);
        }
        return;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUpdateProgeress. url = ");
      ((StringBuilder)localObject1).append(((HttpNetReq)???).mReqUrl);
      ((StringBuilder)localObject1).append(", total size = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", cur downloaded size = ");
      ((StringBuilder)localObject1).append(paramLong1);
      QLog.d("AREngine_ARPreSoResourceDownload", 2, ((StringBuilder)localObject1).toString());
    }
    synchronized (ARPreSoResourceDownload.c(this.b))
    {
      localObject1 = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.c(this.b).get(this.a.c);
      if (localObject1 != null) {
        ((ARPreSoResourceDownload.ARResourceDownloadCallback)localObject1).a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.1
 * JD-Core Version:    0.7.0.1
 */