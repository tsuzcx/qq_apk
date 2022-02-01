package com.tencent.aelight.camera.control.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IAECameraCategoryMaterialService
  extends IRuntimeService
{
  public abstract void doStep();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.control.api.IAECameraCategoryMaterialService
 * JD-Core Version:    0.7.0.1
 */