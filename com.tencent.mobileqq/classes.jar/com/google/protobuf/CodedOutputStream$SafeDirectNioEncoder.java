package com.google.protobuf;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

final class CodedOutputStream$SafeDirectNioEncoder
  extends CodedOutputStream
{
  private final ByteBuffer b;
  private final ByteBuffer c;
  
  private void c(String paramString)
  {
    try
    {
      Utf8.a(paramString, this.c);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
  }
  
  public void a(byte paramByte)
  {
    try
    {
      this.c.put(paramByte);
      return;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(WireFormat.a(paramInt1, paramInt2));
  }
  
  public void a(int paramInt, ByteString paramByteString)
  {
    a(paramInt, 2);
    a(paramByteString);
  }
  
  public void a(int paramInt, MessageLite paramMessageLite)
  {
    a(paramInt, 2);
    a(paramMessageLite);
  }
  
  void a(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    a(paramInt, 2);
    a(paramMessageLite, paramSchema);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0);
    a((byte)paramBoolean);
  }
  
  public void a(ByteString paramByteString)
  {
    c(paramByteString.size());
    paramByteString.writeTo(this);
  }
  
  public void a(MessageLite paramMessageLite)
  {
    c(paramMessageLite.getSerializedSize());
    paramMessageLite.writeTo(this);
  }
  
  void a(MessageLite paramMessageLite, Schema paramSchema)
  {
    c(((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema));
    paramSchema.a(paramMessageLite, this.a);
  }
  
  public void a(String paramString)
  {
    int i = this.c.position();
    try
    {
      int j = j(paramString.length() * 3);
      int k = j(paramString.length());
      if (k == j)
      {
        j = this.c.position() + k;
        this.c.position(j);
        c(paramString);
        k = this.c.position();
        this.c.position(i);
        c(k - j);
        this.c.position(k);
        return;
      }
      c(Utf8.a(paramString));
      c(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      this.c.position(i);
      a(paramString, localUnpairedSurrogateException);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    b(paramByteBuffer);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.c.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (BufferOverflowException paramArrayOfByte)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
    }
  }
  
  public void b()
  {
    this.b.position(this.c.position());
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    b(paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    a(paramInt, 0);
    b(paramLong);
  }
  
  public void b(int paramInt, ByteString paramByteString)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramByteString);
    a(1, 4);
  }
  
  public void b(int paramInt, MessageLite paramMessageLite)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramMessageLite);
    a(1, 4);
  }
  
  public void b(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L) {}
      try
      {
        this.c.put((byte)(int)paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
      this.c.put((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
    for (;;)
    {
      CodedOutputStream.OutOfSpaceException localOutOfSpaceException;
      throw localOutOfSpaceException;
    }
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    try
    {
      this.c.put(paramByteBuffer);
      return;
    }
    catch (BufferOverflowException paramByteBuffer)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramByteBuffer);
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int c()
  {
    return this.c.remaining();
  }
  
  public void c(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0) {}
      try
      {
        this.c.put((byte)paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
      this.c.put((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
    for (;;)
    {
      CodedOutputStream.OutOfSpaceException localOutOfSpaceException;
      throw localOutOfSpaceException;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    c(paramInt2);
  }
  
  public void d(int paramInt, long paramLong)
  {
    a(paramInt, 1);
    d(paramLong);
  }
  
  public void d(long paramLong)
  {
    try
    {
      this.c.putLong(paramLong);
      return;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
    }
  }
  
  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.c.putInt(paramInt);
      return;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    a(paramInt1, 5);
    e(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.SafeDirectNioEncoder
 * JD-Core Version:    0.7.0.1
 */