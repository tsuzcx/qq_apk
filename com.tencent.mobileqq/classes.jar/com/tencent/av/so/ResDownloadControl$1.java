package com.tencent.av.so;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class ResDownloadControl$1
  implements INetEngineListener
{
  ResDownloadControl$1(ResDownloadControl paramResDownloadControl, ResDownloadControl.DownloadInfo paramDownloadInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          if (ResMgr.a(localHttpNetReq.mOutPath, this.a.a.resZipMd5))
          {
            String str = paramNetResp.getParent();
            FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(this.a.a.resFileName);
            boolean bool = ResMgr.a(localStringBuilder.toString(), this.a.a.resMd5);
            if (bool) {
              i = 1;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = 0;
        }
        paramNetResp.delete();
        break label163;
      }
    }
    int i = 0;
    label163:
    if (i != 0)
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("download successfully. ");
      paramNetResp.append(this.a.a);
      QLog.i("AVResMgr", 1, paramNetResp.toString());
      if (this.a.a.resId.equalsIgnoreCase("AVTraeSo")) {
        ResMgr.f();
      } else if (this.a.a.resId.equalsIgnoreCase("AVAINSMediaLabGruModel")) {
        ResMgr.d();
      } else if (this.a.a.resId.equalsIgnoreCase("AVSDKSo")) {
        ResMgr.h();
      }
      ResDownloadControl.a(1, 100, this.a.a);
    }
    else
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("download end but failed. uncompressZip failed or md5 not match. ");
      paramNetResp.append(this.a.a);
      QLog.e("AVResMgr", 1, paramNetResp.toString());
      ResDownloadControl.a(-1, this.a.c, this.a.a);
    }
    if (this.a.d == localHttpNetReq)
    {
      paramNetResp = this.a;
      paramNetResp.d = null;
      paramNetResp.b = 0;
      ResDownloadControl.a(this.b).remove(this.a);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    } else if (paramLong1 >= paramLong2) {
      i = 99;
    } else {
      i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    this.a.c = i;
    if (QLog.isColorLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("download... progress = ");
      paramNetReq.append(i);
      paramNetReq.append(", ");
      paramNetReq.append(this.a.a);
      QLog.d("AVResMgr", 2, paramNetReq.toString());
    }
    ResDownloadControl.a(2, i, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResDownloadControl.1
 * JD-Core Version:    0.7.0.1
 */