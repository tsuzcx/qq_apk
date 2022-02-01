package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICameraCompatible
  extends QRouteApi
{
  public abstract boolean isFoundCoolPad();
  
  public abstract boolean isFoundProduct(String paramString);
  
  public abstract boolean isFoundProductByRomID(String paramString);
  
  public abstract boolean isFoundProductFeature(String paramString);
  
  public abstract boolean isFoundProductFeatureRom(String paramString);
  
  public abstract boolean isFoundProductManufacturer(String paramString);
  
  public abstract boolean isInARParticleBackList();
  
  public abstract boolean isNeedDrawOnOpenGLSingleThread();
  
  public abstract boolean isNotSupportFilterBasedSdk();
  
  public abstract boolean notSupportCameraFrontSysPhoto();
  
  public abstract void updateCompatibleList(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.ICameraCompatible
 * JD-Core Version:    0.7.0.1
 */