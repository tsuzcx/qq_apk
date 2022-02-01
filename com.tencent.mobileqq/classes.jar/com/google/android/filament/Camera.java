package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

public class Camera
{
  private long mNativeObject;
  
  Camera(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native float nGetAperture(long paramLong);
  
  private static native float nGetCullingFar(long paramLong);
  
  private static native void nGetCullingProjectionMatrix(long paramLong, double[] paramArrayOfDouble);
  
  private static native void nGetForwardVector(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetLeftVector(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetModelMatrix(long paramLong, float[] paramArrayOfFloat);
  
  private static native float nGetNear(long paramLong);
  
  private static native void nGetPosition(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetProjectionMatrix(long paramLong, double[] paramArrayOfDouble);
  
  private static native float nGetSensitivity(long paramLong);
  
  private static native float nGetShutterSpeed(long paramLong);
  
  private static native void nGetUpVector(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetViewMatrix(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nLookAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9);
  
  private static native void nSetCustomProjection(long paramLong, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2);
  
  private static native void nSetExposure(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetLensProjection(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  private static native void nSetModelMatrix(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nSetProjection(long paramLong, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
  
  private static native void nSetProjectionFov(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public float getAperture()
  {
    return nGetAperture(getNativeObject());
  }
  
  public float getCullingFar()
  {
    return nGetCullingFar(getNativeObject());
  }
  
  @NonNull
  @Size(min=16L)
  public double[] getCullingProjectionMatrix(@Nullable @Size(min=16L) double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Asserts.assertMat4d(paramArrayOfDouble);
    nGetCullingProjectionMatrix(getNativeObject(), paramArrayOfDouble);
    return paramArrayOfDouble;
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getForwardVector(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetForwardVector(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getLeftVector(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetLeftVector(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=16L)
  public float[] getModelMatrix(@Nullable @Size(min=16L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat4f(paramArrayOfFloat);
    nGetModelMatrix(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Camera");
    }
    return this.mNativeObject;
  }
  
  public float getNear()
  {
    return nGetNear(getNativeObject());
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getPosition(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetPosition(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=16L)
  public double[] getProjectionMatrix(@Nullable @Size(min=16L) double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Asserts.assertMat4d(paramArrayOfDouble);
    nGetProjectionMatrix(getNativeObject(), paramArrayOfDouble);
    return paramArrayOfDouble;
  }
  
  public float getSensitivity()
  {
    return nGetSensitivity(getNativeObject());
  }
  
  public float getShutterSpeed()
  {
    return nGetShutterSpeed(getNativeObject());
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getUpVector(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetUpVector(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=16L)
  public float[] getViewMatrix(@Nullable @Size(min=16L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat4f(paramArrayOfFloat);
    nGetViewMatrix(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public void lookAt(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    nLookAt(getNativeObject(), paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDouble8, paramDouble9);
  }
  
  public void setCustomProjection(@NonNull @Size(min=16L) double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    Asserts.assertMat4dIn(paramArrayOfDouble);
    nSetCustomProjection(getNativeObject(), paramArrayOfDouble, paramDouble1, paramDouble2);
  }
  
  public void setExposure(float paramFloat)
  {
    setExposure(1.0F, 1.2F, 100.0F * (1.0F / paramFloat));
  }
  
  public void setExposure(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetExposure(getNativeObject(), paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setLensProjection(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    nSetLensProjection(getNativeObject(), paramDouble1, paramDouble2, paramDouble3);
  }
  
  public void setModelMatrix(@NonNull @Size(min=16L) float[] paramArrayOfFloat)
  {
    Asserts.assertMat4fIn(paramArrayOfFloat);
    nSetModelMatrix(getNativeObject(), paramArrayOfFloat);
  }
  
  public void setProjection(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, @NonNull Camera.Fov paramFov)
  {
    nSetProjectionFov(getNativeObject(), paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramFov.ordinal());
  }
  
  public void setProjection(@NonNull Camera.Projection paramProjection, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    nSetProjection(getNativeObject(), paramProjection.ordinal(), paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.Camera
 * JD-Core Version:    0.7.0.1
 */