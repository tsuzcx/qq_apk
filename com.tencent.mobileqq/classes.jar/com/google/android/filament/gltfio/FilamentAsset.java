package com.google.android.filament.gltfio;

import android.support.annotation.NonNull;
import com.google.android.filament.Box;
import com.google.android.filament.Entity;

public class FilamentAsset
{
  private long mNativeObject;
  
  FilamentAsset(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native long nGetAnimator(long paramLong);
  
  private static native void nGetBoundingBox(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetEntities(long paramLong, int[] paramArrayOfInt);
  
  private static native int nGetEntity(long paramLong, @NonNull String paramString);
  
  private static native int nGetEntityCount(long paramLong);
  
  private static native String nGetName(long paramLong, int paramInt);
  
  private static native int nGetRoot(long paramLong);
  
  private static native void nSetMorphBuffer(long paramLong, String paramString);
  
  private static native void nSetMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  private static native void nUpdateMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public Animator getAnimator()
  {
    return new Animator(nGetAnimator(this.mNativeObject));
  }
  
  @NonNull
  public Box getBoundingBox()
  {
    float[] arrayOfFloat = new float[6];
    nGetBoundingBox(this.mNativeObject, arrayOfFloat);
    return new Box(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
  }
  
  @Entity
  public int[] getEntities()
  {
    int[] arrayOfInt = new int[nGetEntityCount(this.mNativeObject)];
    nGetEntities(this.mNativeObject, arrayOfInt);
    return arrayOfInt;
  }
  
  @Entity
  public int getEntity(@NonNull String paramString)
  {
    return nGetEntity(this.mNativeObject, paramString);
  }
  
  public String getName(@Entity int paramInt)
  {
    return nGetName(getNativeObject(), paramInt);
  }
  
  long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  @Entity
  public int getRoot()
  {
    return nGetRoot(this.mNativeObject);
  }
  
  public void setMorphWeights(String paramString)
  {
    nSetMorphBuffer(getNativeObject(), paramString);
  }
  
  public void setMorphWeights(String paramString, float[] paramArrayOfFloat)
  {
    nSetMorphWeights(getNativeObject(), paramString, paramArrayOfFloat);
  }
  
  public void updateMorphWeights(String paramString, float[] paramArrayOfFloat)
  {
    nUpdateMorphWeights(getNativeObject(), paramString, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.gltfio.FilamentAsset
 * JD-Core Version:    0.7.0.1
 */