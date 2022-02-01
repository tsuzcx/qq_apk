package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.log.AEQLog;
import eipc.EIPCResult;
import java.util.List;

class AECMShowQipcModule$CmShowAEDownloadCallBack
  implements IAEDownloadCallBack
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  private int c;
  
  public AECMShowQipcModule$CmShowAEDownloadCallBack(AECMShowQipcModule paramAECMShowQipcModule, int paramInt)
  {
    this.c = paramInt;
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
      this.jdField_a_of_type_Int += 1;
      break label86;
      this.b += 1;
      label86:
      if (this.jdField_a_of_type_Int + this.b == AECMShowQipcModule.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowQipcModule).size())
      {
        paramAEResInfo = new EIPCResult();
        if (this.b != 0)
        {
          paramAEResInfo.code = -1;
          this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowQipcModule.callbackResult(this.c, paramAEResInfo);
          return;
        }
        paramAEResInfo.code = 0;
        this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowQipcModule.callbackResult(this.c, paramAEResInfo);
      }
      return;
    }
    finally {}
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.CmShowAEDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */