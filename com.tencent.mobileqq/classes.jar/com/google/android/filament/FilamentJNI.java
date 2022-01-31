package com.google.android.filament;

import android.support.annotation.NonNull;

public class FilamentJNI
{
  private long currentTime = 0L;
  private long mNativeObject;
  
  FilamentJNI(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  @NonNull
  public static FilamentJNI create(@NonNull Object paramObject1, Object paramObject2, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (paramObject2 == null) {
      return new FilamentJNI(nCreateFilamentAsset(paramObject1, 0L, paramInt1, paramInt2, paramString1, paramString2, paramArrayOfByte));
    }
    return new FilamentJNI(nCreateFilamentAsset(paramObject1, Platform.get().getSharedContextNativeHandle(paramObject2), paramInt1, paramInt2, paramString1, paramString2, paramArrayOfByte));
  }
  
  private static native boolean nCanUseShareContext(long paramLong);
  
  private static native long nCreateFilamentAsset(Object paramObject, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  private static native void nDestroy(long paramLong);
  
  private static native float[] nGetDirectionColor(long paramLong);
  
  private static native int nGetDirectionIntensity(long paramLong);
  
  private static native int nGetIblIntensity(long paramLong);
  
  private static native int nGetIblRotation(long paramLong);
  
  private static native float[] nGetLightDirection(long paramLong);
  
  private static native int nGetMaxFaceCount(long paramLong);
  
  private static native float[] nGetPosition(long paramLong);
  
  private static native float[] nGetRotation(long paramLong);
  
  private static native float[] nGetScale(long paramLong);
  
  private static native void nLoadAllData(long paramLong);
  
  private static native void nNewFurLayers(long paramLong, int paramInt);
  
  private static native void nRender(long paramLong, float paramFloat);
  
  private static native void nResize(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nSetAverageL(long paramLong, float paramFloat);
  
  private static native void nSetDirectionColor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetDirectionIntensity(long paramLong, int paramInt);
  
  private static native boolean nSetGlbData(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private static native void nSetHeadCount(long paramLong, int paramInt);
  
  private static native void nSetIblDegree(long paramLong, float paramFloat);
  
  private static native void nSetIblIntensity(long paramLong, int paramInt);
  
  private static native void nSetLightDirection(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetMaterialImage(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nSetMaterialTransform(long paramLong, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native void nSetMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  private static native void nSetPosition(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetScale(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nUpdateIntensityMap(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public boolean canUseShareContext()
  {
    return nCanUseShareContext(this.mNativeObject);
  }
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
  }
  
  public float[] getDirectionColor()
  {
    return nGetDirectionColor(this.mNativeObject);
  }
  
  public int getDirectionIntensity()
  {
    return nGetDirectionIntensity(this.mNativeObject);
  }
  
  public int getIblIntensity()
  {
    return nGetIblIntensity(this.mNativeObject);
  }
  
  public int getIblRotation()
  {
    return nGetIblRotation(this.mNativeObject);
  }
  
  public float[] getLightDirection()
  {
    return nGetLightDirection(this.mNativeObject);
  }
  
  public int getMaxFaceCount()
  {
    return nGetMaxFaceCount(this.mNativeObject);
  }
  
  public float[] getPosition()
  {
    return nGetPosition(this.mNativeObject);
  }
  
  public float[] getRotation()
  {
    return nGetRotation(this.mNativeObject);
  }
  
  public float[] getScale()
  {
    return nGetScale(this.mNativeObject);
  }
  
  public void loadAllData()
  {
    nLoadAllData(this.mNativeObject);
  }
  
  public void render()
  {
    if (this.currentTime == 0L) {
      this.currentTime = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    nRender(this.mNativeObject, (float)(l - this.currentTime) / 1000.0F);
    this.currentTime = l;
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    nResize(this.mNativeObject, paramInt1, paramInt2);
  }
  
  public void setAverageL(float paramFloat)
  {
    nSetAverageL(this.mNativeObject, paramFloat);
  }
  
  public void setDirectionColor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetDirectionColor(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setDirectionIntensity(int paramInt)
  {
    nSetDirectionIntensity(this.mNativeObject, paramInt);
  }
  
  public boolean setGlbData(String paramString, byte[] paramArrayOfByte)
  {
    return nSetGlbData(this.mNativeObject, paramString, paramArrayOfByte);
  }
  
  public void setHeadCount(int paramInt)
  {
    nSetHeadCount(this.mNativeObject, paramInt);
  }
  
  public void setIblDegree(float paramFloat)
  {
    nSetIblDegree(this.mNativeObject, paramFloat);
  }
  
  public void setIblIntensity(int paramInt)
  {
    nSetIblIntensity(this.mNativeObject, paramInt);
  }
  
  public void setLightDirection(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetLightDirection(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setMaterialImage(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    nSetMaterialImage(this.mNativeObject, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
  }
  
  public void setMaterialTransform(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    nSetMaterialTransform(this.mNativeObject, paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void setMorphWeights(String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    nSetMorphWeights(this.mNativeObject, paramString, paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public void setNewFurLayers(int paramInt)
  {
    nNewFurLayers(this.mNativeObject, paramInt);
  }
  
  public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetPosition(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetRotation(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetScale(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void updateIntensityMap(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    nUpdateIntensityMap(this.mNativeObject, paramArrayOfFloat1, paramArrayOfFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.FilamentJNI
 * JD-Core Version:    0.7.0.1
 */