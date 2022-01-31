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
  
  private static native void nLoadAllData(long paramLong);
  
  private static native void nNewFurLayers(long paramLong, int paramInt);
  
  private static native void nRender(long paramLong, float paramFloat);
  
  private static native void nResize(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nSetGlbData(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private static native void nSetHeadCount(long paramLong, int paramInt);
  
  private static native void nSetMaterialImage(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nSetMaterialTransform(long paramLong, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native void nSetMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  public boolean canUseShareContext()
  {
    return nCanUseShareContext(this.mNativeObject);
  }
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
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
  
  public void setGlbData(String paramString, byte[] paramArrayOfByte)
  {
    nSetGlbData(this.mNativeObject, paramString, paramArrayOfByte);
  }
  
  public void setHeadCount(int paramInt)
  {
    nSetHeadCount(this.mNativeObject, paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.FilamentJNI
 * JD-Core Version:    0.7.0.1
 */