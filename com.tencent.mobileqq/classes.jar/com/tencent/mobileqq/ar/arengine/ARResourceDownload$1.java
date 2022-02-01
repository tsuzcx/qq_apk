package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class ARResourceDownload$1
  implements INetEngineListener
{
  ARResourceDownload$1(ARResourceDownload paramARResourceDownload, ARResourceDownload.DownloadInfo paramDownloadInfo, ARResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = paramNetResp.mResult;
    boolean bool2 = true;
    if (i == 3)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Download init. url = ");
      ((StringBuilder)???).append(((HttpNetReq)paramNetResp.mReq).mReqUrl);
      QLog.i("AREngine_ARResourceDownload", 1, ((StringBuilder)???).toString());
      return;
    }
    label343:
    synchronized (ARResourceDownload.a(this.c))
    {
      if (ARResourceDownload.b(this.c) != null)
      {
        i = 0;
        if (i < ARResourceDownload.b(this.c).size())
        {
          if (!((ARResourceDownload.DownloadInfo)ARResourceDownload.b(this.c).get(i)).b.equals(this.a.b)) {
            break label343;
          }
          ARResourceDownload.b(this.c).remove(i);
        }
      }
      boolean bool1;
      if (paramNetResp.mResult == 0)
      {
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
            QLog.i("AREngine_ARResourceDownload", 1, localStringBuilder.toString());
            this.b.a(false, this.a);
          }
        }
      }
      else
      {
        bool1 = false;
      }
      this.b.a(bool1, this.a);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateProgeress. url = ");
      localStringBuilder.append(((HttpNetReq)paramNetReq).mReqUrl);
      localStringBuilder.append(", total size = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", cur downloaded size = ");
      localStringBuilder.append(paramLong1);
      QLog.d("AREngine_ARResourceDownload", 2, localStringBuilder.toString());
    }
    this.b.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceDownload.1
 * JD-Core Version:    0.7.0.1
 */