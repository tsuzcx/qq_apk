package com.tencent.aelight.camera.ae.control;

import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.common.app.AppInterface;

public abstract class IAEQIMManager
{
  public AppInterface getApp()
  {
    return AECaptureContext.a();
  }
  
  public abstract void onDestroy();
  
  public abstract void onInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.control.IAEQIMManager
 * JD-Core Version:    0.7.0.1
 */