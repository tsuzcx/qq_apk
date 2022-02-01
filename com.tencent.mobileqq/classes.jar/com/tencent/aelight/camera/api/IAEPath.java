package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEPath
  extends QRouteApi
{
  public abstract String getCameraResPath();
  
  public abstract String getGifPreviewCache();
  
  public abstract String getPendantBasePath();
  
  public abstract String getTmpCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEPath
 * JD-Core Version:    0.7.0.1
 */