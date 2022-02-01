package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEFilterManagerHolder
  extends QRouteApi
{
  public abstract boolean isAEFilterManagerEmpty();
  
  public abstract void setIsAfterUpdateMaterial(boolean paramBoolean);
  
  public abstract void updateLutGL(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEFilterManagerHolder
 * JD-Core Version:    0.7.0.1
 */