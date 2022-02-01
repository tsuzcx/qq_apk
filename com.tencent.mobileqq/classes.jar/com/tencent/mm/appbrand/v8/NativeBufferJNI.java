package com.tencent.mm.appbrand.v8;

import java.nio.ByteBuffer;

public class NativeBufferJNI
  implements f
{
  private long a = nativeCreate();
  
  static
  {
    com.tencent.luggage.wxa.hg.f.a("mmv8", i.class.getClassLoader());
    com.tencent.luggage.wxa.hg.f.a("mmnode", i.class.getClassLoader());
    com.tencent.luggage.wxa.hg.f.a("mmj2v8", i.class.getClassLoader());
  }
  
  private native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3);
  
  private native long nativeCreate();
  
  private native void nativeDestroy(long paramLong);
  
  private native int nativeGenerateId(long paramLong);
  
  private native byte[] nativeGetBuffer(long paramLong, int paramInt);
  
  private native ByteBuffer nativeGetDirectBuffer(long paramLong, int paramInt);
  
  private native void nativeSetBuffer(long paramLong, int paramInt, ByteBuffer paramByteBuffer);
  
  private native void nativeSetBufferForLegacyArray(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public int a()
  {
    return nativeGenerateId(this.a);
  }
  
  public ByteBuffer a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return nativeGetDirectBuffer(this.a, paramInt);
    }
    byte[] arrayOfByte = nativeGetBuffer(this.a, paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return;
    }
    if (paramByteBuffer.capacity() == 0) {
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      nativeSetBuffer(this.a, paramInt, paramByteBuffer);
      return;
    }
    paramByteBuffer = paramByteBuffer.array();
    nativeSetBufferForLegacyArray(this.a, paramInt, paramByteBuffer, paramByteBuffer.length);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    b(paramLong1, paramLong2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    nativeBindTo(this.a, paramLong1, paramLong2);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected void finalize()
  {
    super.finalize();
    long l = this.a;
    if (l != 0L)
    {
      nativeDestroy(l);
      this.a = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.NativeBufferJNI
 * JD-Core Version:    0.7.0.1
 */