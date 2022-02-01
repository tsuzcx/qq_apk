package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

public class VertexBuffer
{
  private long mNativeObject;
  
  private VertexBuffer(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nBuilderAttribute(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native void nBuilderBufferCount(long paramLong, int paramInt);
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderNormalized(long paramLong, int paramInt, boolean paramBoolean);
  
  private static native void nBuilderVertexCount(long paramLong, int paramInt);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native int nGetVertexCount(long paramLong);
  
  private static native void nPopulateTangentQuaternions(int paramInt1, int paramInt2, Buffer paramBuffer1, int paramInt3, int paramInt4, Buffer paramBuffer2, int paramInt5, int paramInt6, Buffer paramBuffer3, int paramInt7, int paramInt8);
  
  private static native int nSetBufferAt(long paramLong1, long paramLong2, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Runnable paramRunnable);
  
  public static void populateTangentQuaternions(@NonNull VertexBuffer.QuatTangentContext paramQuatTangentContext)
  {
    int j = paramQuatTangentContext.quatType.ordinal();
    int k = paramQuatTangentContext.quatCount;
    Buffer localBuffer1 = paramQuatTangentContext.outBuffer;
    int m = paramQuatTangentContext.outBuffer.remaining();
    int n = paramQuatTangentContext.outStride;
    Buffer localBuffer2 = paramQuatTangentContext.normals;
    int i1 = paramQuatTangentContext.normals.remaining();
    int i2 = paramQuatTangentContext.normalsStride;
    Buffer localBuffer3 = paramQuatTangentContext.tangents;
    if (paramQuatTangentContext.tangents != null) {}
    for (int i = paramQuatTangentContext.tangents.remaining();; i = 0)
    {
      nPopulateTangentQuaternions(j, k, localBuffer1, m, n, localBuffer2, i1, i2, localBuffer3, i, paramQuatTangentContext.tangentsStride);
      return;
    }
  }
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed VertexBuffer");
    }
    return this.mNativeObject;
  }
  
  @IntRange(from=0L)
  public int getVertexCount()
  {
    return nGetVertexCount(getNativeObject());
  }
  
  public void setBufferAt(@NonNull Engine paramEngine, int paramInt, @NonNull Buffer paramBuffer)
  {
    setBufferAt(paramEngine, paramInt, paramBuffer, 0, 0, null, null);
  }
  
  public void setBufferAt(@NonNull Engine paramEngine, int paramInt1, @NonNull Buffer paramBuffer, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    setBufferAt(paramEngine, paramInt1, paramBuffer, paramInt2, paramInt3, null, null);
  }
  
  public void setBufferAt(@NonNull Engine paramEngine, int paramInt1, @NonNull Buffer paramBuffer, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @Nullable Object paramObject, @Nullable Runnable paramRunnable)
  {
    long l1 = getNativeObject();
    long l2 = paramEngine.getNativeObject();
    int i = paramBuffer.remaining();
    if (paramInt3 == 0) {
      paramInt3 = paramBuffer.remaining();
    }
    while (nSetBufferAt(l1, l2, paramInt1, paramBuffer, i, paramInt2, paramInt3, paramObject, paramRunnable) < 0) {
      throw new BufferOverflowException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.VertexBuffer
 * JD-Core Version:    0.7.0.1
 */