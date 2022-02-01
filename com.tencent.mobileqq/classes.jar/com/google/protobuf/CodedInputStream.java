package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class CodedInputStream
{
  int a;
  int b = 100;
  int c = 2147483647;
  CodedInputStreamReader d;
  private boolean e = false;
  
  public static int a(int paramInt, InputStream paramInputStream)
  {
    if ((paramInt & 0x80) == 0) {
      return paramInt;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    int j;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label67;
      }
      j = paramInputStream.read();
      if (j == -1) {
        break;
      }
      i |= (j & 0x7F) << paramInt;
      if ((j & 0x80) == 0) {
        return i;
      }
      paramInt += 7;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
    label67:
    while (j < 64)
    {
      paramInt = paramInputStream.read();
      if (paramInt != -1)
      {
        if ((paramInt & 0x80) == 0) {
          return i;
        }
        j += 7;
      }
      else
      {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    }
    paramInputStream = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static long a(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public static CodedInputStream a(InputStream paramInputStream)
  {
    return a(paramInputStream, 4096);
  }
  
  public static CodedInputStream a(InputStream paramInputStream, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInputStream == null) {
        return a(Internal.c);
      }
      return new CodedInputStream.StreamDecoder(paramInputStream, paramInt, null);
    }
    throw new IllegalArgumentException("bufferSize must be > 0");
  }
  
  public static CodedInputStream a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, false);
  }
  
  static CodedInputStream a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer.hasArray()) {
      return a(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining(), paramBoolean);
    }
    if ((paramByteBuffer.isDirect()) && (CodedInputStream.UnsafeDirectNioDecoder.A())) {
      return new CodedInputStream.UnsafeDirectNioDecoder(paramByteBuffer, paramBoolean, null);
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.duplicate().get(arrayOfByte);
    return a(arrayOfByte, 0, arrayOfByte.length, true);
  }
  
  public static CodedInputStream a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputStream a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  static CodedInputStream a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new CodedInputStream.ArrayDecoder(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, null);
    try
    {
      paramArrayOfByte.c(paramInt2);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static int e(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public abstract int a();
  
  public abstract <T extends MessageLite> T a(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void a(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract double b();
  
  public abstract boolean b(int paramInt);
  
  public abstract float c();
  
  public abstract int c(int paramInt);
  
  public abstract long d();
  
  public abstract void d(int paramInt);
  
  public abstract long e();
  
  public abstract int f();
  
  public abstract long g();
  
  public abstract int h();
  
  public abstract boolean i();
  
  public abstract String j();
  
  public abstract String k();
  
  public abstract ByteString l();
  
  public abstract int m();
  
  public abstract int n();
  
  public abstract int o();
  
  public abstract long p();
  
  public abstract int q();
  
  public abstract long r();
  
  public abstract int s();
  
  abstract long t();
  
  final void u()
  {
    this.e = true;
  }
  
  final void v()
  {
    this.e = false;
  }
  
  final boolean w()
  {
    return this.e;
  }
  
  public abstract int x();
  
  public abstract boolean y();
  
  public abstract int z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream
 * JD-Core Version:    0.7.0.1
 */