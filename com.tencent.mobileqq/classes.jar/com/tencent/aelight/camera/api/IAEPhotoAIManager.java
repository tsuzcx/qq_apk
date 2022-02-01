package com.tencent.aelight.camera.api;

import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEPhotoAIManager
  extends QRouteApi
{
  public abstract void downloadPhotoAIRes();
  
  public abstract AEPhotoAIResult getPhotoAIResult(String paramString);
  
  public abstract boolean isPhotoAIResExist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEPhotoAIManager
 * JD-Core Version:    0.7.0.1
 */