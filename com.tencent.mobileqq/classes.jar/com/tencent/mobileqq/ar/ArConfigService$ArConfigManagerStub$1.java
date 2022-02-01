package com.tencent.mobileqq.ar;

import com.tencent.aelight.camera.download.old.api.AEOldDownloadCallBack;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.qphone.base.util.QLog;

class ArConfigService$ArConfigManagerStub$1
  implements AEOldDownloadCallBack
{
  ArConfigService$ArConfigManagerStub$1(ArConfigService.ArConfigManagerStub paramArConfigManagerStub) {}
  
  public void a(AEOldResInfo paramAEOldResInfo, long paramLong1, long paramLong2) {}
  
  public void a(AEOldResInfo paramAEOldResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadFaceResource onAEDownloadFinish downloaded = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",errorType = ");
    localStringBuilder.append(paramInt);
    QLog.d("ArConfig_ArConfigService", 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFaceResource onAEDownloadFinish downloaded = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",errorType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",localFilePath = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",aeResInfo = ");
      localStringBuilder.append(paramAEOldResInfo);
      QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.1
 * JD-Core Version:    0.7.0.1
 */