package com.tencent.aelight.camera.ae.util;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class AEDownloader$InnerDownloadListener
  implements INetEngineListener
{
  private String a;
  private String b;
  private AEDownloader.DownloadListener c;
  
  AEDownloader$InnerDownloadListener(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResp url: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" resultcode: ");
    ((StringBuilder)localObject).append(paramNetResp.mResult);
    AEQLog.b("AEDownloader", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((AEDownloader.DownloadListener)localObject).a(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.c;
    if (paramNetReq != null) {
      paramNetReq.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AEDownloader.InnerDownloadListener
 * JD-Core Version:    0.7.0.1
 */