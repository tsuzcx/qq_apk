package com.tencent.aelight.camera.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICaptureUtil
  extends QRouteApi
{
  public static final int HW_SUPPORT_VERSION = 21;
  
  public abstract int alainSize(int paramInt);
  
  public abstract int[] clipVideoSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public abstract boolean getGestureRecoglizeResult();
  
  public abstract int getPhotoOrientationDegree(int paramInt);
  
  public abstract int getVideoOrientationDegree(int paramInt);
  
  public abstract boolean loadEffectSo();
  
  public abstract int[] scaleVideoSize(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setGestureRecognitionResult(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean supportCapture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.ICaptureUtil
 * JD-Core Version:    0.7.0.1
 */