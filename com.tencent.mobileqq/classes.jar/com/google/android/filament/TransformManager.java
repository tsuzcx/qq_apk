package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

public class TransformManager
{
  private long mNativeObject;
  
  TransformManager(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nCommitLocalTransformTransaction(long paramLong);
  
  private static native int nCreate(long paramLong, int paramInt);
  
  private static native int nCreateArray(long paramLong, int paramInt1, int paramInt2, float[] paramArrayOfFloat);
  
  private static native void nDestroy(long paramLong, int paramInt);
  
  private static native int nGetInstance(long paramLong, int paramInt);
  
  private static native void nGetTransform(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nGetWorldTransform(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native boolean nHasComponent(long paramLong, int paramInt);
  
  private static native void nOpenLocalTransformTransaction(long paramLong);
  
  private static native void nSetParent(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nSetTransform(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  public void commitLocalTransformTransaction()
  {
    nCommitLocalTransformTransaction(this.mNativeObject);
  }
  
  @EntityInstance
  public int create(@Entity int paramInt)
  {
    return nCreate(this.mNativeObject, paramInt);
  }
  
  @EntityInstance
  public int create(@Entity int paramInt1, @EntityInstance int paramInt2, @Nullable @Size(min=16L) float[] paramArrayOfFloat)
  {
    return nCreateArray(this.mNativeObject, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public void destroy(@Entity int paramInt)
  {
    nDestroy(this.mNativeObject, paramInt);
  }
  
  @EntityInstance
  public int getInstance(@Entity int paramInt)
  {
    return nGetInstance(this.mNativeObject, paramInt);
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  @NonNull
  @Size(min=16L)
  public float[] getTransform(@EntityInstance int paramInt, @Nullable @Size(min=16L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat4f(paramArrayOfFloat);
    nGetTransform(this.mNativeObject, paramInt, paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=16L)
  public float[] getWorldTransform(@EntityInstance int paramInt, @Nullable @Size(min=16L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat4f(paramArrayOfFloat);
    nGetWorldTransform(this.mNativeObject, paramInt, paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public boolean hasComponent(@Entity int paramInt)
  {
    return nHasComponent(this.mNativeObject, paramInt);
  }
  
  public void openLocalTransformTransaction()
  {
    nOpenLocalTransformTransaction(this.mNativeObject);
  }
  
  public void setParent(@EntityInstance int paramInt1, @EntityInstance int paramInt2)
  {
    nSetParent(this.mNativeObject, paramInt1, paramInt2);
  }
  
  public void setTransform(@EntityInstance int paramInt, @NonNull @Size(min=16L) float[] paramArrayOfFloat)
  {
    Asserts.assertMat4fIn(paramArrayOfFloat);
    nSetTransform(this.mNativeObject, paramInt, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.TransformManager
 * JD-Core Version:    0.7.0.1
 */