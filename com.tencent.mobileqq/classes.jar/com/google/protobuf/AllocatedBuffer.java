package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class AllocatedBuffer
{
  public static AllocatedBuffer a(ByteBuffer paramByteBuffer)
  {
    Internal.a(paramByteBuffer, "buffer");
    return new AllocatedBuffer.1(paramByteBuffer);
  }
  
  public static AllocatedBuffer a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static AllocatedBuffer a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length)) {
      return b(paramArrayOfByte, paramInt1, paramInt2);
    }
    throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private static AllocatedBuffer b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new AllocatedBuffer.2(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract AllocatedBuffer a(int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract ByteBuffer c();
  
  public abstract byte[] d();
  
  public abstract int e();
  
  public abstract int f();
  
  public abstract int g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AllocatedBuffer
 * JD-Core Version:    0.7.0.1
 */