package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

public class IndexBuffer
{
  private long mNativeObject;
  
  private IndexBuffer(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nBuilderBufferType(long paramLong, int paramInt);
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderIndexCount(long paramLong, int paramInt);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native int nGetIndexCount(long paramLong);
  
  private static native int nSetBuffer(long paramLong1, long paramLong2, Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Object paramObject, Runnable paramRunnable);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @IntRange(from=0L)
  public int getIndexCount()
  {
    return nGetIndexCount(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed IndexBuffer");
    }
    return this.mNativeObject;
  }
  
  public void setBuffer(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer)
  {
    setBuffer(paramEngine, paramBuffer, 0, 0, null, null);
  }
  
  public void setBuffer(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    setBuffer(paramEngine, paramBuffer, paramInt1, paramInt2, null, null);
  }
  
  public void setBuffer(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @Nullable Object paramObject, @Nullable Runnable paramRunnable)
  {
    long l1 = getNativeObject();
    long l2 = paramEngine.getNativeObject();
    int i = paramBuffer.remaining();
    if (paramInt2 == 0) {
      paramInt2 = paramBuffer.remaining();
    }
    while (nSetBuffer(l1, l2, paramBuffer, i, paramInt1, paramInt2, paramObject, paramRunnable) < 0) {
      throw new BufferOverflowException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.IndexBuffer
 * JD-Core Version:    0.7.0.1
 */