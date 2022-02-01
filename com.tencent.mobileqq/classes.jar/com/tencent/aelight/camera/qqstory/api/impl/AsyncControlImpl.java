package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;

public class AsyncControlImpl
  implements IAsyncControl
{
  static CaptureAsyncControl mAsyncControl = new CaptureAsyncControl();
  
  public Object createCaptureAsyncControl()
  {
    return new CaptureAsyncControl();
  }
  
  public void destory()
  {
    mAsyncControl.a();
  }
  
  public Object getAsynControl()
  {
    return mAsyncControl;
  }
  
  public String getCameraCreatedResultInfo()
  {
    CaptureAsyncControl localCaptureAsyncControl = mAsyncControl;
    return CaptureAsyncControl.b;
  }
  
  public boolean isCameraCreated()
  {
    CaptureAsyncControl localCaptureAsyncControl = mAsyncControl;
    return CaptureAsyncControl.d;
  }
  
  public boolean isCameraCreatedResult()
  {
    CaptureAsyncControl localCaptureAsyncControl = mAsyncControl;
    return CaptureAsyncControl.e;
  }
  
  public void startAsyncStep(int paramInt)
  {
    mAsyncControl.a(paramInt);
  }
  
  public void startAsyncStep(String paramString, Object[] paramArrayOfObject)
  {
    mAsyncControl.a(paramString, paramArrayOfObject);
  }
  
  public void startPeakPreLoadAsyncStep()
  {
    mAsyncControl.a("{1000,1002}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.AsyncControlImpl
 * JD-Core Version:    0.7.0.1
 */