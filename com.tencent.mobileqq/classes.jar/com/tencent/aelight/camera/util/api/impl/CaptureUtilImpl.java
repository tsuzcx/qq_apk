package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;

public class CaptureUtilImpl
  implements ICaptureUtil
{
  public int alainSize(int paramInt)
  {
    return CaptureUtil.a(paramInt);
  }
  
  public int[] clipVideoSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    return CaptureUtil.a(paramInt1, paramInt2, paramInt3, paramInt4, paramFloat);
  }
  
  public boolean getGestureRecoglizeResult()
  {
    return CaptureUtil.e();
  }
  
  public int getPhotoOrientationDegree(int paramInt)
  {
    return CaptureUtil.c(paramInt);
  }
  
  public int getVideoOrientationDegree(int paramInt)
  {
    return CaptureUtil.b(paramInt);
  }
  
  public boolean loadEffectSo()
  {
    return CaptureUtil.b();
  }
  
  public int[] scaleVideoSize(int paramInt1, int paramInt2, int paramInt3)
  {
    return CaptureUtil.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void setGestureRecognitionResult(boolean paramBoolean1, boolean paramBoolean2)
  {
    CaptureUtil.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean supportCapture()
  {
    return CaptureUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.CaptureUtilImpl
 * JD-Core Version:    0.7.0.1
 */