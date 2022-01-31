package com.samsung.android.sdk.camera.delegator;

import android.hardware.camera2.CaptureRequest.Key;

public class AbstractSemCameraCaptureProcessor$CaptureParameter
{
  private final CaptureRequest.Key mKey;
  private final Object mValue;
  
  public <T> AbstractSemCameraCaptureProcessor$CaptureParameter(CaptureRequest.Key<T> paramKey, T paramT)
  {
    this.mKey = paramKey;
    this.mValue = paramT;
  }
  
  public CaptureRequest.Key getKey()
  {
    return this.mKey;
  }
  
  public Object getValue()
  {
    return this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureParameter
 * JD-Core Version:    0.7.0.1
 */