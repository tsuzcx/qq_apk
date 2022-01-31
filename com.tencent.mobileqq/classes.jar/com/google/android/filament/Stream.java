package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ReadOnlyBufferException;

public class Stream
{
  private long mNativeEngine;
  private long mNativeObject;
  
  Stream(long paramLong, Engine paramEngine)
  {
    this.mNativeObject = paramLong;
    this.mNativeEngine = paramEngine.getNativeObject();
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderHeight(long paramLong, int paramInt);
  
  private static native void nBuilderStream(long paramLong1, long paramLong2);
  
  private static native void nBuilderStreamSource(long paramLong, Object paramObject);
  
  private static native void nBuilderWidth(long paramLong, int paramInt);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native long nGetTimestamp(long paramLong);
  
  private static native boolean nIsNative(long paramLong);
  
  private static native int nReadPixels(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Buffer paramBuffer, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, Object paramObject, Runnable paramRunnable);
  
  private static native void nSetDimensions(long paramLong, int paramInt1, int paramInt2);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Stream");
    }
    return this.mNativeObject;
  }
  
  public long getTimestamp()
  {
    return nGetTimestamp(getNativeObject());
  }
  
  public boolean isNative()
  {
    return nIsNative(getNativeObject());
  }
  
  public void readPixels(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor)
  {
    if (paramPixelBufferDescriptor.storage.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (nReadPixels(getNativeObject(), this.mNativeEngine, paramInt1, paramInt2, paramInt3, paramInt4, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public void setDimensions(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    nSetDimensions(getNativeObject(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Stream
 * JD-Core Version:    0.7.0.1
 */