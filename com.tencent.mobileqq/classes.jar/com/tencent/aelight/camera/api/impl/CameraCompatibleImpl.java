package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.CameraCompatibleList;
import com.tencent.aelight.camera.api.ICameraCompatible;

public class CameraCompatibleImpl
  implements ICameraCompatible
{
  public boolean isFoundCoolPad()
  {
    return CameraCompatibleList.a();
  }
  
  public boolean isFoundProduct(String paramString)
  {
    return CameraCompatibleList.c(paramString);
  }
  
  public boolean isFoundProductByRomID(String paramString)
  {
    return CameraCompatibleList.b(paramString);
  }
  
  public boolean isFoundProductFeature(String paramString)
  {
    return CameraCompatibleList.a(paramString);
  }
  
  public boolean isFoundProductFeatureRom(String paramString)
  {
    return CameraCompatibleList.a(paramString);
  }
  
  public boolean isFoundProductManufacturer(String paramString)
  {
    return CameraCompatibleList.d(paramString);
  }
  
  public boolean isInARParticleBackList()
  {
    return CameraCompatibleList.d();
  }
  
  public boolean isNeedDrawOnOpenGLSingleThread()
  {
    return CameraCompatibleList.c();
  }
  
  public boolean isNotSupportFilterBasedSdk()
  {
    return CameraCompatibleList.b();
  }
  
  public boolean notSupportCameraFrontSysPhoto()
  {
    return CameraCompatibleList.g();
  }
  
  public void updateCompatibleList(String paramString, boolean paramBoolean)
  {
    CameraCompatibleList.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.CameraCompatibleImpl
 * JD-Core Version:    0.7.0.1
 */