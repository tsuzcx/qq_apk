package com.github.henryye.nativeiv.comm;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.c.a;
import com.tencent.luggage.wxa.c.b;
import java.nio.ByteBuffer;

public class NativeImageJni
{
  private long a = 0L;
  
  static
  {
    b.a("NativeImageJni", "load library", new Object[0]);
    a.a("native-iv");
  }
  
  @Keep
  private native CommNativeBitmapStruct nativeDecodeNative(long paramLong, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
  
  @Keep
  private native void nativeDestroy(long paramLong);
  
  @Keep
  private native long nativeInit();
  
  @Keep
  private native void nativeRecycleNative(long paramLong1, long paramLong2);
  
  @Nullable
  protected CommNativeBitmapStruct a(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean)
  {
    long l = this.a;
    if (l != 0L) {
      return nativeDecodeNative(l, paramByteBuffer, paramInt, paramBoolean);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a == 0L)
    {
      this.a = nativeInit();
      return;
    }
    throw new IllegalStateException("NativeImageJni not released last time");
  }
  
  protected void a(long paramLong)
  {
    long l = this.a;
    if (l != 0L) {
      nativeRecycleNative(l, paramLong);
    }
  }
  
  public void b()
  {
    long l = this.a;
    if (l != 0L) {
      nativeDestroy(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImageJni
 * JD-Core Version:    0.7.0.1
 */