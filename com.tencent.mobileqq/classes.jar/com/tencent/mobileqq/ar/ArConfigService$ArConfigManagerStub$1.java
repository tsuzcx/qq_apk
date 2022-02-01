package com.tencent.mobileqq.ar;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldResInfo;
import dov.com.qq.im.ae.download.old.AEOldResManager.AEOldDownloadCallBack;

class ArConfigService$ArConfigManagerStub$1
  implements AEOldResManager.AEOldDownloadCallBack
{
  ArConfigService$ArConfigManagerStub$1(ArConfigService.ArConfigManagerStub paramArConfigManagerStub) {}
  
  public void a(AEOldResInfo paramAEOldResInfo, long paramLong1, long paramLong2) {}
  
  public void a(AEOldResInfo paramAEOldResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource onAEDownloadFinish downloaded = " + paramBoolean + ",errorType = " + paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadFaceResource onAEDownloadFinish downloaded = " + paramBoolean + ",errorType = " + paramInt + ",localFilePath = " + paramString + ",aeResInfo = " + paramAEOldResInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.1
 * JD-Core Version:    0.7.0.1
 */