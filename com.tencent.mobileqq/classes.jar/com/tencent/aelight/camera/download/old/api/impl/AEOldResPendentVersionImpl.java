package com.tencent.aelight.camera.download.old.api.impl;

import com.tencent.aelight.camera.ae.download.old.AEOldPendantVersionManager;
import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;

public class AEOldResPendentVersionImpl
  implements IAEOldResPendentVersion
{
  public boolean checkConfigFileListIsOK(String paramString1, String paramString2)
  {
    return AEOldPendantVersionManager.a(paramString1, paramString2);
  }
  
  public boolean checkSignatureVersionIsOK(String paramString, int paramInt)
  {
    return AEOldPendantVersionManager.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.impl.AEOldResPendentVersionImpl
 * JD-Core Version:    0.7.0.1
 */