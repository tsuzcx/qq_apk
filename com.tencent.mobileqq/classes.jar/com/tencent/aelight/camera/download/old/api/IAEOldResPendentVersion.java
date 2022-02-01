package com.tencent.aelight.camera.download.old.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEOldResPendentVersion
  extends QRouteApi
{
  public abstract boolean checkConfigFileListIsOK(String paramString1, String paramString2);
  
  public abstract boolean checkSignatureVersionIsOK(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion
 * JD-Core Version:    0.7.0.1
 */