package com.google.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output
  extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final int b;
  private final ArrayList<ByteString> c;
  private int d;
  private byte[] e;
  private int f;
  
  ByteString$Output(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.b = paramInt;
      this.c = new ArrayList();
      this.e = new byte[paramInt];
      return;
    }
    throw new IllegalArgumentException("Buffer size < 0");
  }
  
  private void a(int paramInt)
  {
    this.c.add(new ByteString.LiteralByteString(this.e));
    this.d += this.e.length;
    this.e = new byte[Math.max(this.b, Math.max(paramInt, this.d >>> 1))];
    this.f = 0;
  }
  
  public int a()
  {
    try
    {
      int i = this.d;
      int j = this.f;
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a()) });
  }
  
  public void write(int paramInt)
  {
    try
    {
      if (this.f == this.e.length) {
        a(1);
      }
      byte[] arrayOfByte = this.e;
      int i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramInt2 <= this.e.length - this.f)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.f, paramInt2);
        this.f += paramInt2;
      }
      else
      {
        int i = this.e.length - this.f;
        System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.f, i);
        paramInt2 -= i;
        a(paramInt2);
        System.arraycopy(paramArrayOfByte, paramInt1 + i, this.e, 0, paramInt2);
        this.f = paramInt2;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.Output
 * JD-Core Version:    0.7.0.1
 */