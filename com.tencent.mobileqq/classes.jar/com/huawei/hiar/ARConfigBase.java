package com.huawei.hiar;

import android.util.Log;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ARConfigBase
{
  public static final int ENABLE_DEPTH = 1;
  public static final int ENABLE_MASK = 2;
  public static final int ENABLE_NULL = 0;
  private static final String TAG = ARConfigBase.class.getSimpleName();
  protected final int BODY_AR = 2;
  protected final int FACE_AR = 16;
  protected final int HAND_AR = 4;
  protected final int IMAGE_AR = 128;
  protected final int WORLD_AR = 1;
  private final int arTypeCnt = 6;
  protected final String[] arTypeString = { "worldAR", "bodyAR", "handGestureAR", "handSkeletonAR", "faceAR", "imageAR" };
  long mNativeHandle;
  ARSession mSession;
  
  ARConfigBase()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARConfigBase(ARSession paramARSession)
  {
    if (paramARSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    this.mSession = paramARSession;
    this.mNativeHandle = nativeCreate(this.mSession.mNativeHandle);
  }
  
  private static native long nativeCreate(long paramLong);
  
  private static native void nativeDestroy(long paramLong);
  
  private native int nativeGetArType(long paramLong1, long paramLong2);
  
  private native long nativeGetAugmentedImageDatabase(long paramLong1, long paramLong2);
  
  private native int nativeGetCameraLensFacing(long paramLong1, long paramLong2);
  
  private native long nativeGetEnableItem(long paramLong1, long paramLong2);
  
  private native int nativeGetFocusMode(long paramLong1, long paramLong2);
  
  private native int nativeGetHandFindingMode(long paramLong1, long paramLong2);
  
  private native int nativeGetImageInputMode(long paramLong1, long paramLong2);
  
  private native int[] nativeGetInputSurfaceTypes(long paramLong1, long paramLong2);
  
  private native Surface[] nativeGetInputSurfaces(long paramLong1, long paramLong2);
  
  private native int nativeGetLightEstimationMode(long paramLong1, long paramLong2);
  
  private native int nativeGetPlaneFindingMode(long paramLong1, long paramLong2);
  
  private native int nativeGetPowerMode(long paramLong1, long paramLong2);
  
  private native int nativeGetUpdateMode(long paramLong1, long paramLong2);
  
  private native void nativeSetArType(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetAugmentedImageDatabase(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeSetCameraLensFacing(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetEnableItem(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeSetFocusMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetHandFindingMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetImageInputMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetLightEstimationMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetPlaneFindingMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetPowerMode(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSetUpdateMode(long paramLong1, long paramLong2, int paramInt);
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeDestroy(this.mNativeHandle);
    }
  }
  
  int getARType()
  {
    return nativeGetArType(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  String getArTypeString()
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = getARType();
    int i = 0;
    while (i < 6)
    {
      if ((k & j) > 0) {
        localStringBuilder.append(this.arTypeString[i]);
      }
      j <<= 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  ARAugmentedImageDatabase getAugmentedImageDatabase()
  {
    long l = nativeGetAugmentedImageDatabase(this.mSession.mNativeHandle, this.mNativeHandle);
    if (l == 0L) {
      return null;
    }
    return new ARAugmentedImageDatabase(this.mSession, l);
  }
  
  ARConfigBase.CameraLensFacing getCameraLensFacing()
  {
    return ARConfigBase.CameraLensFacing.forNumber(nativeGetCameraLensFacing(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public long getEnableItem()
  {
    return nativeGetEnableItem(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARConfigBase.FocusMode getFocusMode()
  {
    return ARConfigBase.FocusMode.forNumber(nativeGetFocusMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  @Deprecated
  ARConfigBase.HandFindingMode getHandFindingMode()
  {
    return ARConfigBase.HandFindingMode.forNumber(nativeGetHandFindingMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARConfigBase.ImageInputMode getImageInputMode()
  {
    if (this.mSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    return ARConfigBase.ImageInputMode.forNumber(nativeGetImageInputMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public List<ARConfigBase.SurfaceType> getImageInputSurfaceTypes()
  {
    if (this.mSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    int[] arrayOfInt = nativeGetInputSurfaceTypes(this.mSession.mNativeHandle, this.mNativeHandle);
    ArrayList localArrayList = new ArrayList(arrayOfInt.length);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(ARConfigBase.SurfaceType.forNumber(arrayOfInt[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<Surface> getImageInputSurfaces()
  {
    if (this.mSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    return Arrays.asList(nativeGetInputSurfaces(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARConfigBase.LightingMode getLightingMode()
  {
    return ARConfigBase.LightingMode.forNumber(nativeGetLightEstimationMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  ARConfigBase.PlaneFindingMode getPlaneFindingMode()
  {
    return ARConfigBase.PlaneFindingMode.forNumber(nativeGetPlaneFindingMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARConfigBase.PowerMode getPowerMode()
  {
    return ARConfigBase.PowerMode.forNumber(nativeGetPowerMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARConfigBase.UpdateMode getUpdateMode()
  {
    return ARConfigBase.UpdateMode.forNumber(nativeGetUpdateMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  void setARType(int paramInt)
  {
    if (this.mSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    nativeSetArType(this.mSession.mNativeHandle, this.mNativeHandle, paramInt);
  }
  
  void setAugmentedImageDatabase(ARAugmentedImageDatabase paramARAugmentedImageDatabase)
  {
    nativeSetAugmentedImageDatabase(this.mSession.mNativeHandle, this.mNativeHandle, paramARAugmentedImageDatabase.mNativeDatabaseHandle);
  }
  
  void setCameraLensFacing(ARConfigBase.CameraLensFacing paramCameraLensFacing)
  {
    if ((paramCameraLensFacing != null) && (this.mSession != null))
    {
      nativeSetCameraLensFacing(this.mSession.mNativeHandle, this.mNativeHandle, paramCameraLensFacing.nativeCode);
      return;
    }
    Log.e(TAG, "Parameter is null!");
    throw new IllegalArgumentException("Parameter is null!");
  }
  
  public void setEnableItem(long paramLong)
  {
    nativeSetEnableItem(this.mSession.mNativeHandle, this.mNativeHandle, paramLong);
  }
  
  public void setFocusMode(ARConfigBase.FocusMode paramFocusMode)
  {
    nativeSetFocusMode(this.mSession.mNativeHandle, this.mNativeHandle, paramFocusMode.mNativeCode);
  }
  
  @Deprecated
  void setHandFindingMode(ARConfigBase.HandFindingMode paramHandFindingMode)
  {
    nativeSetHandFindingMode(this.mSession.mNativeHandle, this.mNativeHandle, paramHandFindingMode.mNativeCode);
  }
  
  public void setImageInputMode(ARConfigBase.ImageInputMode paramImageInputMode)
  {
    if (this.mSession == null)
    {
      Log.e(TAG, "mSession is null!");
      throw new IllegalArgumentException("mSession is null!");
    }
    nativeSetImageInputMode(this.mSession.mNativeHandle, this.mNativeHandle, paramImageInputMode.mNativeCode);
  }
  
  public void setLightingMode(ARConfigBase.LightingMode paramLightingMode)
  {
    nativeSetLightEstimationMode(this.mSession.mNativeHandle, this.mNativeHandle, paramLightingMode.mNativeCode);
  }
  
  void setPlaneFindingMode(ARConfigBase.PlaneFindingMode paramPlaneFindingMode)
  {
    nativeSetPlaneFindingMode(this.mSession.mNativeHandle, this.mNativeHandle, paramPlaneFindingMode.mNativeCode);
  }
  
  public void setPowerMode(ARConfigBase.PowerMode paramPowerMode)
  {
    nativeSetPowerMode(this.mSession.mNativeHandle, this.mNativeHandle, paramPowerMode.mNativeCode);
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2)
  {
    ARServiceProxy.mPreviewSizeWidth = paramInt1;
    ARServiceProxy.mPreviewSizeHeight = paramInt2;
  }
  
  void setSession(ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = nativeCreate(this.mSession.mNativeHandle);
  }
  
  public void setUpdateMode(ARConfigBase.UpdateMode paramUpdateMode)
  {
    nativeSetUpdateMode(this.mSession.mNativeHandle, this.mNativeHandle, paramUpdateMode.mNativeCode);
  }
  
  public String toString()
  {
    return String.format("ARConfigBase: { AR type %s, CameraLensFacing=%s, UpdateMode=%s,  LightingMode=%s, PlaneFindingMode=%s }", new Object[] { getArTypeString(), getCameraLensFacing(), getUpdateMode(), getLightingMode(), getPlaneFindingMode() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARConfigBase
 * JD-Core Version:    0.7.0.1
 */