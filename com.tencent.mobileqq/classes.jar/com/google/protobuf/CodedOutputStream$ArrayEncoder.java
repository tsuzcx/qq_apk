package com.google.protobuf;

import java.nio.ByteBuffer;

class CodedOutputStream$ArrayEncoder
  extends CodedOutputStream
{
  private final byte[] b;
  private final int c;
  private final int d;
  private int e;
  
  CodedOutputStream$ArrayEncoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(null);
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = paramInt1 + paramInt2;
      if ((paramInt1 | paramInt2 | i - j) >= 0)
      {
        this.b = paramArrayOfByte;
        this.c = paramInt1;
        this.e = paramInt1;
        this.d = j;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    throw new NullPointerException("buffer");
  }
  
  public final void a(byte paramByte)
  {
    try
    {
      byte[] arrayOfByte = this.b;
      int i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = paramByte;
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    c(WireFormat.a(paramInt1, paramInt2));
  }
  
  public final void a(int paramInt, ByteString paramByteString)
  {
    a(paramInt, 2);
    a(paramByteString);
  }
  
  public final void a(int paramInt, MessageLite paramMessageLite)
  {
    a(paramInt, 2);
    a(paramMessageLite);
  }
  
  final void a(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    a(paramInt, 2);
    c(((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema));
    paramSchema.a(paramMessageLite, this.a);
  }
  
  public final void a(int paramInt, String paramString)
  {
    a(paramInt, 2);
    a(paramString);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0);
    a((byte)paramBoolean);
  }
  
  public final void a(ByteString paramByteString)
  {
    c(paramByteString.size());
    paramByteString.writeTo(this);
  }
  
  public final void a(MessageLite paramMessageLite)
  {
    c(paramMessageLite.getSerializedSize());
    paramMessageLite.writeTo(this);
  }
  
  final void a(MessageLite paramMessageLite, Schema paramSchema)
  {
    c(((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema));
    paramSchema.a(paramMessageLite, this.a);
  }
  
  public final void a(String paramString)
  {
    int i = this.e;
    try
    {
      int k = j(paramString.length() * 3);
      int j = j(paramString.length());
      if (j == k)
      {
        this.e = (i + j);
        k = Utf8.a(paramString, this.b, this.e, c());
        this.e = i;
        c(k - i - j);
        this.e = k;
        return;
      }
      c(Utf8.a(paramString));
      this.e = Utf8.a(paramString, this.b, this.e, c());
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      this.e = i;
      a(paramString, localUnpairedSurrogateException);
    }
  }
  
  public final void a(ByteBuffer paramByteBuffer)
  {
    b(paramByteBuffer);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.e, paramInt2);
      this.e += paramInt2;
      return;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(paramInt2) }), paramArrayOfByte);
    }
  }
  
  public void b() {}
  
  public final void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    b(paramInt2);
  }
  
  public final void b(int paramInt, long paramLong)
  {
    a(paramInt, 0);
    b(paramLong);
  }
  
  public final void b(int paramInt, ByteString paramByteString)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramByteString);
    a(1, 4);
  }
  
  public final void b(int paramInt, MessageLite paramMessageLite)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramMessageLite);
    a(1, 4);
  }
  
  public final void b(long paramLong)
  {
    long l = paramLong;
    byte[] arrayOfByte;
    int i;
    if (CodedOutputStream.e())
    {
      l = paramLong;
      if (c() >= 10) {
        for (;;)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            arrayOfByte = this.b;
            i = this.e;
            this.e = (i + 1);
            UnsafeUtil.a(arrayOfByte, i, (byte)(int)paramLong);
            return;
          }
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
    }
    for (;;)
    {
      if ((l & 0xFFFFFF80) == 0L) {}
      try
      {
        arrayOfByte = this.b;
        i = this.e;
        this.e = (i + 1);
        arrayOfByte[i] = ((byte)(int)l);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
      l >>>= 7;
    }
    for (;;)
    {
      CodedOutputStream.OutOfSpaceException localOutOfSpaceException;
      throw localOutOfSpaceException;
    }
  }
  
  public final void b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    try
    {
      paramByteBuffer.get(this.b, this.e, i);
      this.e += i;
      return;
    }
    catch (IndexOutOfBoundsException paramByteBuffer)
    {
      throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i) }), paramByteBuffer);
    }
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final int c()
  {
    return this.d - this.e;
  }
  
  public final void c(int paramInt)
  {
    int i = paramInt;
    byte[] arrayOfByte;
    if (CodedOutputStream.e())
    {
      i = paramInt;
      if (!Android.a())
      {
        i = paramInt;
        if (c() >= 5)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.b;
            i = this.e;
            this.e = (i + 1);
            UnsafeUtil.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.b;
            i = this.e;
            this.e = (i + 1);
            UnsafeUtil.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.b;
            i = this.e;
            this.e = (i + 1);
            UnsafeUtil.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.b;
            i = this.e;
            this.e = (i + 1);
            UnsafeUtil.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          arrayOfByte = this.b;
          i = this.e;
          this.e = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt >>> 7));
          return;
        }
      }
    }
    for (;;)
    {
      if ((i & 0xFFFFFF80) == 0) {}
      try
      {
        arrayOfByte = this.b;
        paramInt = this.e;
        this.e = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
      arrayOfByte = this.b;
      paramInt = this.e;
      this.e = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
      i >>>= 7;
    }
    for (;;)
    {
      CodedOutputStream.OutOfSpaceException localOutOfSpaceException;
      throw localOutOfSpaceException;
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    c(paramInt2);
  }
  
  public final void d(int paramInt, long paramLong)
  {
    a(paramInt, 1);
    d(paramLong);
  }
  
  public final void d(long paramLong)
  {
    try
    {
      byte[] arrayOfByte = this.b;
      int i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)paramLong & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 16) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void e(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = this.b;
      int i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
      arrayOfByte = this.b;
      i = this.e;
      this.e = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1) }), localIndexOutOfBoundsException);
    }
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    a(paramInt1, 5);
    e(paramInt2);
  }
  
  public final int f()
  {
    return this.e - this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.ArrayEncoder
 * JD-Core Version:    0.7.0.1
 */