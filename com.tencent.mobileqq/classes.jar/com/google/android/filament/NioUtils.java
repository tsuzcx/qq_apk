package com.google.android.filament;

import androidx.annotation.NonNull;
import com.google.android.filament.proguard.UsedByNative;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

@UsedByNative("NioUtils.cpp")
final class NioUtils
{
  @UsedByNative("NioUtils.cpp")
  static Object getBaseArray(@NonNull Buffer paramBuffer)
  {
    if (paramBuffer.hasArray()) {
      return paramBuffer.array();
    }
    return null;
  }
  
  @UsedByNative("NioUtils.cpp")
  static int getBaseArrayOffset(@NonNull Buffer paramBuffer, int paramInt)
  {
    if (paramBuffer.hasArray()) {
      return paramBuffer.arrayOffset() + paramBuffer.position() << paramInt;
    }
    return 0;
  }
  
  @UsedByNative("NioUtils.cpp")
  static long getBasePointer(@NonNull Buffer paramBuffer, long paramLong, int paramInt)
  {
    long l = 0L;
    if (paramLong != 0L) {
      l = (paramBuffer.position() << paramInt) + paramLong;
    }
    return l;
  }
  
  @UsedByNative("NioUtils.cpp")
  static int getBufferType(@NonNull Buffer paramBuffer)
  {
    if ((paramBuffer instanceof ByteBuffer)) {
      return NioUtils.BufferType.BYTE.ordinal();
    }
    if ((paramBuffer instanceof CharBuffer)) {
      return NioUtils.BufferType.CHAR.ordinal();
    }
    if ((paramBuffer instanceof ShortBuffer)) {
      return NioUtils.BufferType.SHORT.ordinal();
    }
    if ((paramBuffer instanceof IntBuffer)) {
      return NioUtils.BufferType.INT.ordinal();
    }
    if ((paramBuffer instanceof LongBuffer)) {
      return NioUtils.BufferType.LONG.ordinal();
    }
    if ((paramBuffer instanceof FloatBuffer)) {
      return NioUtils.BufferType.FLOAT.ordinal();
    }
    return NioUtils.BufferType.DOUBLE.ordinal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.NioUtils
 * JD-Core Version:    0.7.0.1
 */