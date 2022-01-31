package com.google.android.filament;

import android.support.annotation.Nullable;

public class Scene
{
  @Nullable
  private IndirectLight mIndirectLight;
  private long mNativeObject;
  @Nullable
  private Skybox mSkybox;
  
  Scene(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nAddEntities(long paramLong, int[] paramArrayOfInt);
  
  private static native void nAddEntity(long paramLong, int paramInt);
  
  private static native int nGetLightCount(long paramLong);
  
  private static native int nGetRenderableCount(long paramLong);
  
  private static native void nRemove(long paramLong, int paramInt);
  
  private static native void nSetIndirectLight(long paramLong1, long paramLong2);
  
  private static native void nSetSkybox(long paramLong1, long paramLong2);
  
  public void addEntities(@Entity int[] paramArrayOfInt)
  {
    nAddEntities(getNativeObject(), paramArrayOfInt);
  }
  
  public void addEntity(@Entity int paramInt)
  {
    nAddEntity(getNativeObject(), paramInt);
  }
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @Nullable
  public IndirectLight getIndirectLight()
  {
    return this.mIndirectLight;
  }
  
  public int getLightCount()
  {
    return nGetLightCount(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Scene");
    }
    return this.mNativeObject;
  }
  
  public int getRenderableCount()
  {
    return nGetRenderableCount(getNativeObject());
  }
  
  @Nullable
  public Skybox getSkybox()
  {
    return this.mSkybox;
  }
  
  public void remove(@Entity int paramInt)
  {
    removeEntity(paramInt);
  }
  
  public void removeEntity(@Entity int paramInt)
  {
    nRemove(getNativeObject(), paramInt);
  }
  
  public void setIndirectLight(@Nullable IndirectLight paramIndirectLight)
  {
    this.mIndirectLight = paramIndirectLight;
    long l2 = getNativeObject();
    if (this.mIndirectLight != null) {}
    for (long l1 = this.mIndirectLight.getNativeObject();; l1 = 0L)
    {
      nSetIndirectLight(l2, l1);
      return;
    }
  }
  
  public void setSkybox(@Nullable Skybox paramSkybox)
  {
    this.mSkybox = paramSkybox;
    long l2 = getNativeObject();
    if (this.mSkybox != null) {}
    for (long l1 = this.mSkybox.getNativeObject();; l1 = 0L)
    {
      nSetSkybox(l2, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Scene
 * JD-Core Version:    0.7.0.1
 */