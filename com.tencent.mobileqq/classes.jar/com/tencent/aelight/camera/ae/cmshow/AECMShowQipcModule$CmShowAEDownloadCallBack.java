package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.log.AEQLog;
import eipc.EIPCResult;
import java.util.List;

class AECMShowQipcModule$CmShowAEDownloadCallBack
  implements IAEDownloadCallBack
{
  private int b = 0;
  private int c = 0;
  private int d;
  
  public AECMShowQipcModule$CmShowAEDownloadCallBack(AECMShowQipcModule paramAECMShowQipcModule, int paramInt)
  {
    this.d = paramInt;
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    paramAEResInfo = new StringBuilder();
    paramAEResInfo.append("CmShowAEDownloadCallBack, localFilePath=");
    paramAEResInfo.append(paramString);
    paramAEResInfo.append(", downloaded=");
    paramAEResInfo.append(paramBoolean);
    paramAEResInfo.append(", errorType=");
    paramAEResInfo.append(paramInt);
    AEQLog.b("AECMShowQipcModule", paramAEResInfo.toString());
    if (paramBoolean) {}
    try
    {
      this.b += 1;
      break label86;
      this.c += 1;
      label86:
      if (this.b + this.c == AECMShowQipcModule.c(this.a).size())
      {
        paramAEResInfo = new EIPCResult();
        if (this.c != 0)
        {
          paramAEResInfo.code = -1;
          this.a.callbackResult(this.d, paramAEResInfo);
          return;
        }
        paramAEResInfo.code = 0;
        this.a.callbackResult(this.d, paramAEResInfo);
      }
      return;
    }
    finally {}
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.CmShowAEDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */