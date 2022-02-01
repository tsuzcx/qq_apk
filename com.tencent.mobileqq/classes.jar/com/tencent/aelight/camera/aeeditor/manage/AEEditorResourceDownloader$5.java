package com.tencent.aelight.camera.aeeditor.manage;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.AEDownloader.DownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;

class AEEditorResourceDownloader$5
  implements AEDownloader.DownloadListener
{
  AEEditorResourceDownloader$5(AEEditorResourceDownloader paramAEEditorResourceDownloader, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener, String paramString1, MetaMaterial paramMetaMaterial, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    AEEditorResourceDownloader.ResDownLoadListener localResDownLoadListener = this.a;
    if (localResDownLoadListener != null) {
      localResDownLoadListener.a(paramInt);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool3 = false;
    if (paramNetResp == null)
    {
      paramNetResp = this.a;
      if (paramNetResp != null) {
        paramNetResp.a(false);
      }
      this.f.a(this.b, false);
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str = this.f.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal-onDownloadFinish---isSuccess=");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(", id=");
    ((StringBuilder)localObject2).append(this.c.id);
    AEQLog.b(str, ((StringBuilder)localObject2).toString());
    boolean bool2 = bool3;
    if (bool1)
    {
      str = FileUtils.calcMd5(this.d);
      if ((str != null) && (str.equalsIgnoreCase(this.b)))
      {
        try
        {
          bool2 = this.f.a(this.d, this.e, this.c.id, this.b);
        }
        catch (Exception localException)
        {
          localObject2 = this.f.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=");
          localStringBuilder.append(this.c.id);
          AEQLog.a((String)localObject2, localStringBuilder.toString(), localException);
          localException.printStackTrace();
          bool2 = bool3;
        }
      }
      else
      {
        localObject1 = this.f.d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=");
        ((StringBuilder)localObject2).append(this.c.id);
        AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
        bool2 = bool3;
      }
    }
    this.f.a(bool1, paramNetResp.mErrCode, paramNetResp.reqCost, this.c.id);
    if (!bool2) {
      FileUtils.deleteDirectory(this.e);
    }
    FileUtils.deleteFile(this.d);
    paramNetResp = this.f.d;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downLoadOneResInternal-onDownloadFinish---REAL result=");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append(", id=");
    ((StringBuilder)localObject1).append(this.c.id);
    AEQLog.b(paramNetResp, ((StringBuilder)localObject1).toString());
    paramNetResp = this.a;
    if (paramNetResp != null) {
      paramNetResp.a(bool2);
    }
    this.f.a(this.b, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.5
 * JD-Core Version:    0.7.0.1
 */