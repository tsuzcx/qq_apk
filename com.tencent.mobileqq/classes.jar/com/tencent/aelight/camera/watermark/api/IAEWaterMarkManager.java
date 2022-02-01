package com.tencent.aelight.camera.watermark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

@QAPI(process={"all"})
public abstract interface IAEWaterMarkManager
  extends QRouteApi
{
  public abstract SosoLocation getLocation();
  
  public abstract void onConfigChange(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager
 * JD-Core Version:    0.7.0.1
 */