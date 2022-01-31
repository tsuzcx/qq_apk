package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

public class MaterialInstance
{
  private Material mMaterial;
  private long mNativeMaterial;
  private long mNativeObject;
  
  MaterialInstance(long paramLong1, long paramLong2)
  {
    this.mNativeMaterial = paramLong1;
    this.mNativeObject = paramLong2;
  }
  
  MaterialInstance(@NonNull Material paramMaterial, long paramLong)
  {
    this.mMaterial = paramMaterial;
    this.mNativeObject = paramLong;
  }
  
  private static native void nSetBooleanParameterArray(long paramLong, @NonNull String paramString, int paramInt1, @NonNull @Size(min=1L) boolean[] paramArrayOfBoolean, @IntRange(from=0L) int paramInt2, @IntRange(from=1L) int paramInt3);
  
  private static native void nSetCullingMode(long paramLong1, long paramLong2);
  
  private static native void nSetDoubleSided(long paramLong, boolean paramBoolean);
  
  private static native void nSetFloatParameterArray(long paramLong, @NonNull String paramString, int paramInt1, @NonNull @Size(min=1L) float[] paramArrayOfFloat, @IntRange(from=0L) int paramInt2, @IntRange(from=1L) int paramInt3);
  
  private static native void nSetIntParameterArray(long paramLong, @NonNull String paramString, int paramInt1, @NonNull @Size(min=1L) int[] paramArrayOfInt, @IntRange(from=0L) int paramInt2, @IntRange(from=1L) int paramInt3);
  
  private static native void nSetMaskThreshold(long paramLong, float paramFloat);
  
  private static native void nSetParameterBool(long paramLong, @NonNull String paramString, boolean paramBoolean);
  
  private static native void nSetParameterBool2(long paramLong, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nSetParameterBool3(long paramLong, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static native void nSetParameterBool4(long paramLong, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  private static native void nSetParameterFloat(long paramLong, @NonNull String paramString, float paramFloat);
  
  private static native void nSetParameterFloat2(long paramLong, @NonNull String paramString, float paramFloat1, float paramFloat2);
  
  private static native void nSetParameterFloat3(long paramLong, @NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetParameterFloat4(long paramLong, @NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private static native void nSetParameterInt(long paramLong, @NonNull String paramString, int paramInt);
  
  private static native void nSetParameterInt2(long paramLong, @NonNull String paramString, int paramInt1, int paramInt2);
  
  private static native void nSetParameterInt3(long paramLong, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nSetParameterInt4(long paramLong, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nSetParameterTexture(long paramLong1, @NonNull String paramString, long paramLong2, int paramInt);
  
  private static native void nSetPolygonOffset(long paramLong, float paramFloat1, float paramFloat2);
  
  private static native void nSetScissor(long paramLong, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4);
  
  private static native void nSetSpecularAntiAliasingThreshold(long paramLong, float paramFloat);
  
  private static native void nSetSpecularAntiAliasingVariance(long paramLong, float paramFloat);
  
  private static native void nUnsetScissor(long paramLong);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  public Material getMaterial()
  {
    if (this.mMaterial == null) {
      this.mMaterial = new Material(this.mNativeMaterial);
    }
    return this.mMaterial;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed MaterialInstance");
    }
    return this.mNativeObject;
  }
  
  public void setCullingMode(Material.CullingMode paramCullingMode)
  {
    nSetCullingMode(getNativeObject(), paramCullingMode.ordinal());
  }
  
  public void setDoubleSided(boolean paramBoolean)
  {
    nSetDoubleSided(getNativeObject(), paramBoolean);
  }
  
  public void setMaskThreshold(float paramFloat)
  {
    nSetMaskThreshold(getNativeObject(), paramFloat);
  }
  
  public void setParameter(@NonNull String paramString, float paramFloat)
  {
    nSetParameterFloat(getNativeObject(), paramString, paramFloat);
  }
  
  public void setParameter(@NonNull String paramString, float paramFloat1, float paramFloat2)
  {
    nSetParameterFloat2(getNativeObject(), paramString, paramFloat1, paramFloat2);
  }
  
  public void setParameter(@NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetParameterFloat3(getNativeObject(), paramString, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setParameter(@NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    nSetParameterFloat4(getNativeObject(), paramString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void setParameter(@NonNull String paramString, int paramInt)
  {
    nSetParameterInt(getNativeObject(), paramString, paramInt);
  }
  
  public void setParameter(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    nSetParameterInt2(getNativeObject(), paramString, paramInt1, paramInt2);
  }
  
  public void setParameter(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    nSetParameterInt3(getNativeObject(), paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void setParameter(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    nSetParameterInt4(getNativeObject(), paramString, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull Colors.RgbType paramRgbType, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramRgbType = Colors.toLinear(paramRgbType, paramFloat1, paramFloat2, paramFloat3);
    nSetParameterFloat3(getNativeObject(), paramString, paramRgbType[0], paramRgbType[1], paramRgbType[2]);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull Colors.RgbaType paramRgbaType, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramRgbaType = Colors.toLinear(paramRgbaType, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    nSetParameterFloat4(getNativeObject(), paramString, paramRgbaType[0], paramRgbaType[1], paramRgbaType[2], paramRgbaType[3]);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull MaterialInstance.BooleanElement paramBooleanElement, @NonNull boolean[] paramArrayOfBoolean, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    nSetBooleanParameterArray(getNativeObject(), paramString, paramBooleanElement.ordinal(), paramArrayOfBoolean, paramInt1, paramInt2);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull MaterialInstance.FloatElement paramFloatElement, @NonNull float[] paramArrayOfFloat, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    nSetFloatParameterArray(getNativeObject(), paramString, paramFloatElement.ordinal(), paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull MaterialInstance.IntElement paramIntElement, @NonNull int[] paramArrayOfInt, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    nSetIntParameterArray(getNativeObject(), paramString, paramIntElement.ordinal(), paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public void setParameter(@NonNull String paramString, @NonNull Texture paramTexture, @NonNull TextureSampler paramTextureSampler)
  {
    nSetParameterTexture(getNativeObject(), paramString, paramTexture.getNativeObject(), paramTextureSampler.mSampler);
  }
  
  public void setParameter(@NonNull String paramString, boolean paramBoolean)
  {
    nSetParameterBool(getNativeObject(), paramString, paramBoolean);
  }
  
  public void setParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    nSetParameterBool2(getNativeObject(), paramString, paramBoolean1, paramBoolean2);
  }
  
  public void setParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    nSetParameterBool3(getNativeObject(), paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void setParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    nSetParameterBool4(getNativeObject(), paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public void setPolygonOffset(float paramFloat1, float paramFloat2)
  {
    nSetPolygonOffset(getNativeObject(), paramFloat1, paramFloat2);
  }
  
  public void setScissor(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    nSetScissor(getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setSpecularAntiAliasingThreshold(float paramFloat)
  {
    nSetSpecularAntiAliasingThreshold(getNativeObject(), paramFloat);
  }
  
  public void setSpecularAntiAliasingVariance(float paramFloat)
  {
    nSetSpecularAntiAliasingVariance(getNativeObject(), paramFloat);
  }
  
  public void unsetScissor()
  {
    nUnsetScissor(getNativeObject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.MaterialInstance
 * JD-Core Version:    0.7.0.1
 */