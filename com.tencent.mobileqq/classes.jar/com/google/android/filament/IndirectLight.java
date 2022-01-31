package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.filament.proguard.UsedByReflection;

public class IndirectLight
{
  long mNativeObject;
  
  @UsedByReflection("KtxLoader.java")
  IndirectLight(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  @NonNull
  @Size(min=4L)
  public static float[] getColorEstimate(@Nullable @Size(min=4L) float[] paramArrayOfFloat1, @NonNull float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArrayOfFloat2.length < 27) {
      throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }
    paramArrayOfFloat1 = Asserts.assertFloat4(paramArrayOfFloat1);
    nGetColorEstimateStatic(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat1, paramFloat2, paramFloat3);
    return paramArrayOfFloat1;
  }
  
  @NonNull
  @Size(min=3L)
  public static float[] getDirectionEstimate(@NonNull float[] paramArrayOfFloat1, @Nullable @Size(min=3L) float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1.length < 27) {
      throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }
    paramArrayOfFloat2 = Asserts.assertFloat3(paramArrayOfFloat2);
    nGetDirectionEstimateStatic(paramArrayOfFloat1, paramArrayOfFloat2);
    return paramArrayOfFloat2;
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderReflections(long paramLong1, long paramLong2);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native void nGetColorEstimate(long paramLong, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nGetColorEstimateStatic(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nGetDirectionEstimate(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetDirectionEstimateStatic(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native float nGetIntensity(long paramLong);
  
  private static native void nGetRotation(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nIntensity(long paramLong, float paramFloat);
  
  private static native void nIrradiance(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nIrradianceAsTexture(long paramLong1, long paramLong2);
  
  private static native void nRadiance(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  private static native void nSetIntensity(long paramLong, float paramFloat);
  
  private static native void nSetRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  @Size(min=4L)
  public float[] getColorEstimate(@Nullable @Size(min=4L) float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramArrayOfFloat = Asserts.assertFloat4(paramArrayOfFloat);
    nGetColorEstimate(getNativeObject(), paramArrayOfFloat, paramFloat1, paramFloat2, paramFloat3);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getDirectionEstimate(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetDirectionEstimate(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public float getIntensity()
  {
    return nGetIntensity(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed IndirectLight");
    }
    return this.mNativeObject;
  }
  
  @NonNull
  @Size(min=9L)
  public float[] getRotation(@Nullable @Size(min=9L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat3f(paramArrayOfFloat);
    nGetRotation(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public void setIntensity(float paramFloat)
  {
    nSetIntensity(getNativeObject(), paramFloat);
  }
  
  public void setRotation(@NonNull @Size(min=9L) float[] paramArrayOfFloat)
  {
    Asserts.assertMat3fIn(paramArrayOfFloat);
    nSetRotation(getNativeObject(), paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5], paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.IndirectLight
 * JD-Core Version:    0.7.0.1
 */