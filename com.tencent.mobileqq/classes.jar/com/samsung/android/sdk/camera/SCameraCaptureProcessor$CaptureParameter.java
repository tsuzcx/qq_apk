package com.samsung.android.sdk.camera;

import android.hardware.camera2.CaptureRequest.Key;

public class SCameraCaptureProcessor$CaptureParameter
{
  private final CaptureRequest.Key mKey;
  private final Object mValue;
  
  public <T> SCameraCaptureProcessor$CaptureParameter(CaptureRequest.Key<T> paramKey, T paramT)
  {
    this.mKey = paramKey;
    this.mValue = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureParameter
 * JD-Core Version:    0.7.0.1
 */