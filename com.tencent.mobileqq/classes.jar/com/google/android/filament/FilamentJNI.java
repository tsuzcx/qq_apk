package com.google.android.filament;

import androidx.annotation.NonNull;

public class FilamentJNI
{
  private Camera camera;
  private long currentTime = 0L;
  private Engine engine;
  private long mNativeObject;
  private View view;
  
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
  
  private static native void nChangeAssetsDynamic(long paramLong, int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2);
  
  private static native long nCreateFilamentAsset(Object paramObject, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  private static native void nDestroy(long paramLong);
  
  private static native float[] nGetAnimationTime(long paramLong, String paramString);
  
  private static native long nGetCamera(long paramLong);
  
  private static native long nGetEngine(long paramLong);
  
  private static native float[] nGetFilamentAssetPosition(long paramLong);
  
  private static native long[] nGetFilamentAssets(long paramLong);
  
  private static native long[] nGetHitTestFilamentAssets(long paramLong, float[] paramArrayOfFloat);
  
  private static native int nGetMaxFaceCount(long paramLong);
  
  private static native long nGetView(long paramLong);
  
  private static native boolean nIsAnimationRunning(long paramLong, String paramString);
  
  private static native void nLoadAllData(long paramLong);
  
  private static native void nNewFurLayers(long paramLong, int paramInt);
  
  private static native void nPauseAnimation(long paramLong);
  
  private static native void nPlayAnimation(long paramLong, String paramString, int paramInt);
  
  private static native void nRegisterAnimation(long paramLong, String[] paramArrayOfString);
  
  private static native void nRender(long paramLong, float paramFloat);
  
  private static native void nReset(long paramLong);
  
  private static native void nResize(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nResumeAnimation(long paramLong);
  
  private static native void nRotateArModelToFront(long paramLong, int paramInt);
  
  private static native void nSetAverageL(long paramLong, float paramFloat);
  
  private static native void nSetBaseColorImage(long paramLong1, String paramString1, String paramString2, long paramLong2);
  
  private static native void nSetDynamicTexture(long paramLong, String[] paramArrayOfString, long[] paramArrayOfLong);
  
  private static native void nSetFilamentAssetScale(long paramLong, float paramFloat, float[] paramArrayOfFloat);
  
  private static native boolean nSetGlbData(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private static native void nSetHeadCount(long paramLong, int paramInt);
  
  private static native void nSetHitTestAfterUnprojection(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nSetImage(long paramLong1, long paramLong2);
  
  private static native void nSetMaterialImage(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  private static native void nSetMaterialTransform(long paramLong, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native void nSetMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  private static native void nShowArShadowPlane(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native void nShowOrHideAsset(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nShowOrHideAssetEntity(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  
  private static native void nStopAnimation(long paramLong, String paramString);
  
  private static native void nUpdateEyeNodeEuler(long paramLong, String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  private static native void nUpdateMesh(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  private static native void nUpdateMeshMorph(long paramLong, String paramString, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nUpdateMeshMorphBase(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  public boolean canUseShareContext()
  {
    return nCanUseShareContext(this.mNativeObject);
  }
  
  public void changeAssetsDynamic(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    nChangeAssetsDynamic(this.mNativeObject, paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
  }
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
  }
  
  public float[] getAnimationTime(String paramString)
  {
    return nGetAnimationTime(this.mNativeObject, paramString);
  }
  
  public Camera getCamera()
  {
    if (this.camera == null) {
      this.camera = new Camera(nGetCamera(this.mNativeObject));
    }
    return this.camera;
  }
  
  public Engine getEngine()
  {
    if (this.engine == null) {
      this.engine = new Engine(nGetEngine(this.mNativeObject));
    }
    return this.engine;
  }
  
  public float[] getFilamentAssetPosition()
  {
    return nGetFilamentAssetPosition(this.mNativeObject);
  }
  
  public long[] getFilamentAssets()
  {
    return nGetFilamentAssets(this.mNativeObject);
  }
  
  public long[] getHitTestFilamentAssets(float[] paramArrayOfFloat)
  {
    return nGetHitTestFilamentAssets(this.mNativeObject, paramArrayOfFloat);
  }
  
  public int getMaxFaceCount()
  {
    return nGetMaxFaceCount(this.mNativeObject);
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  public View getView()
  {
    if (this.view == null) {
      this.view = new View(nGetView(this.mNativeObject));
    }
    return this.view;
  }
  
  public boolean isAnimationRunning(String paramString)
  {
    return nIsAnimationRunning(this.mNativeObject, paramString);
  }
  
  public void loadAllData()
  {
    nLoadAllData(this.mNativeObject);
  }
  
  public void pauseAnimation()
  {
    nPauseAnimation(this.mNativeObject);
  }
  
  public void playAnimation(String paramString, int paramInt)
  {
    nPlayAnimation(this.mNativeObject, paramString, paramInt);
  }
  
  public void registerAnimation(String[] paramArrayOfString)
  {
    nRegisterAnimation(this.mNativeObject, paramArrayOfString);
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
  
  public void reset()
  {
    nReset(this.mNativeObject);
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    nResize(this.mNativeObject, paramInt1, paramInt2);
  }
  
  public void resumeAnimation()
  {
    nResumeAnimation(this.mNativeObject);
  }
  
  public void rotateArModelToFront(int paramInt)
  {
    nRotateArModelToFront(this.mNativeObject, paramInt);
  }
  
  public void setAverageL(float paramFloat)
  {
    nSetAverageL(this.mNativeObject, paramFloat);
  }
  
  public void setDynamicTexture(String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    nSetDynamicTexture(this.mNativeObject, paramArrayOfString, paramArrayOfLong);
  }
  
  public void setFilamentAssetScale(float paramFloat, float[] paramArrayOfFloat)
  {
    nSetFilamentAssetScale(this.mNativeObject, paramFloat, paramArrayOfFloat);
  }
  
  public boolean setGlbData(String paramString, byte[] paramArrayOfByte)
  {
    return nSetGlbData(this.mNativeObject, paramString, paramArrayOfByte);
  }
  
  public void setHeadCount(int paramInt)
  {
    nSetHeadCount(this.mNativeObject, paramInt);
  }
  
  public void setHitTestAfterUnprojection(float[] paramArrayOfFloat)
  {
    nSetHitTestAfterUnprojection(this.mNativeObject, paramArrayOfFloat);
  }
  
  public void setImage(Texture paramTexture)
  {
    nSetImage(this.mNativeObject, paramTexture.getNativeObject());
  }
  
  public void setMaterialImage(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    nSetMaterialImage(this.mNativeObject, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void setMaterialImage(String paramString1, String paramString2, Texture paramTexture)
  {
    nSetBaseColorImage(this.mNativeObject, paramString1, paramString2, paramTexture.getNativeObject());
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
  
  public void showArShadowPlane(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    nShowArShadowPlane(this.mNativeObject, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void showOrHideAsset(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    nShowOrHideAsset(this.mNativeObject, paramInt1, paramInt2, paramBoolean);
  }
  
  public void showOrHideAssetEntity(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    nShowOrHideAssetEntity(this.mNativeObject, paramInt1, paramInt2, paramString, paramBoolean);
  }
  
  public void stopAnimation(String paramString)
  {
    nStopAnimation(this.mNativeObject, paramString);
  }
  
  public void updateEyeNodeEuler(String paramString, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    nUpdateEyeNodeEuler(this.mNativeObject, paramString, paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public void updateMesh(String paramString, float[] paramArrayOfFloat)
  {
    nUpdateMesh(this.mNativeObject, paramString, paramArrayOfFloat);
  }
  
  public void updateMeshMorph(String paramString, int paramInt, float[] paramArrayOfFloat)
  {
    nUpdateMeshMorph(this.mNativeObject, paramString, paramInt, paramArrayOfFloat);
  }
  
  public void updateMeshMorphBase(String paramString, float[] paramArrayOfFloat)
  {
    nUpdateMeshMorphBase(this.mNativeObject, paramString, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.FilamentJNI
 * JD-Core Version:    0.7.0.1
 */