package com.tencent.aelight.camera.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEKitForQQ
  extends QRouteApi
{
  public abstract boolean init();
  
  public abstract boolean isSupported();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.IAEKitForQQ
 * JD-Core Version:    0.7.0.1
 */