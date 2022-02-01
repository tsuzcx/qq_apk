package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.common.app.AppInterface;

public class AECaptureContextImpl
  implements IAECaptureContext
{
  public AppInterface getAppInterface()
  {
    return AECaptureContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.AECaptureContextImpl
 * JD-Core Version:    0.7.0.1
 */