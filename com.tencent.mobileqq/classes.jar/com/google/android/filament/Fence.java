package com.google.android.filament;

import androidx.annotation.NonNull;

public class Fence
{
  public static final long WAIT_FOR_EVER = -1L;
  private long mNativeObject;
  
  Fence(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native int nWait(long paramLong1, int paramInt, long paramLong2);
  
  private static native int nWaitAndDestroy(long paramLong, int paramInt);
  
  public static Fence.FenceStatus waitAndDestroy(@NonNull Fence paramFence, @NonNull Fence.Mode paramMode)
  {
    switch (nWaitAndDestroy(paramFence.getNativeObject(), paramMode.ordinal()))
    {
    default: 
      return Fence.FenceStatus.ERROR;
    case -1: 
      return Fence.FenceStatus.ERROR;
    }
    return Fence.FenceStatus.CONDITION_SATISFIED;
  }
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Fence");
    }
    return this.mNativeObject;
  }
  
  public Fence.FenceStatus wait(@NonNull Fence.Mode paramMode, long paramLong)
  {
    switch (nWait(getNativeObject(), paramMode.ordinal(), paramLong))
    {
    default: 
      return Fence.FenceStatus.ERROR;
    case -1: 
      return Fence.FenceStatus.ERROR;
    case 0: 
      return Fence.FenceStatus.CONDITION_SATISFIED;
    }
    return Fence.FenceStatus.TIMEOUT_EXPIRED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.Fence
 * JD-Core Version:    0.7.0.1
 */