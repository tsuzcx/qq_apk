package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.google.android.filament.proguard.UsedByReflection;

public class EntityManager
{
  private long mNativeObject = nGetEntityManager();
  
  @NonNull
  public static EntityManager get()
  {
    return EntityManager.Holder.INSTANCE;
  }
  
  private static native int nCreate(long paramLong);
  
  private static native void nCreateArray(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  private static native void nDestroy(long paramLong, int paramInt);
  
  private static native void nDestroyArray(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  private static native long nGetEntityManager();
  
  private static native boolean nIsAlive(long paramLong, int paramInt);
  
  @Entity
  public int create()
  {
    return nCreate(this.mNativeObject);
  }
  
  @NonNull
  @Entity
  public int[] create(@IntRange(from=1L) int paramInt)
  {
    if (paramInt < 1) {
      throw new ArrayIndexOutOfBoundsException("n must be at least 1");
    }
    int[] arrayOfInt = new int[paramInt];
    nCreateArray(this.mNativeObject, paramInt, arrayOfInt);
    return arrayOfInt;
  }
  
  @NonNull
  public int[] create(@NonNull @Entity int[] paramArrayOfInt)
  {
    nCreateArray(this.mNativeObject, paramArrayOfInt.length, paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  public void destroy(@Entity int paramInt)
  {
    nDestroy(this.mNativeObject, paramInt);
  }
  
  public void destroy(@NonNull @Entity int[] paramArrayOfInt)
  {
    nDestroyArray(this.mNativeObject, paramArrayOfInt.length, paramArrayOfInt);
  }
  
  @UsedByReflection("AssetLoader.java")
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  public boolean isAlive(@Entity int paramInt)
  {
    return nIsAlive(this.mNativeObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.EntityManager
 * JD-Core Version:    0.7.0.1
 */