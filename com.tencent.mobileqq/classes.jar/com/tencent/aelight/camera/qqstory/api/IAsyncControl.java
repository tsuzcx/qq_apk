package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAsyncControl
  extends QRouteApi
{
  public abstract Object createCaptureAsyncControl();
  
  public abstract void destory();
  
  public abstract Object getAsynControl();
  
  public abstract String getCameraCreatedResultInfo();
  
  public abstract boolean isCameraCreated();
  
  public abstract boolean isCameraCreatedResult();
  
  public abstract void startAsyncStep(int paramInt);
  
  public abstract void startAsyncStep(String paramString, Object[] paramArrayOfObject);
  
  public abstract void startPeakPreLoadAsyncStep();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IAsyncControl
 * JD-Core Version:    0.7.0.1
 */