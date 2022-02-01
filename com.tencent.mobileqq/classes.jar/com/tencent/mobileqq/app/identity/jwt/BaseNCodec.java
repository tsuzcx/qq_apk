package com.tencent.mobileqq.app.identity.jwt;

public abstract class BaseNCodec
{
  private final int a;
  protected final byte b = 61;
  protected final int c;
  private final int d;
  private final int e;
  
  protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.d = paramInt2;
    int i = 0;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      i = paramInt3 / paramInt2 * paramInt2;
    }
    this.c = i;
    this.e = paramInt4;
  }
  
  private byte[] b(BaseNCodec.Context paramContext)
  {
    if (paramContext.b == null)
    {
      paramContext.b = new byte[a()];
      paramContext.c = 0;
      paramContext.d = 0;
    }
    else
    {
      byte[] arrayOfByte = new byte[paramContext.b.length * 2];
      System.arraycopy(paramContext.b, 0, arrayOfByte, 0, paramContext.b.length);
      paramContext.b = arrayOfByte;
    }
    return paramContext.b;
  }
  
  protected int a()
  {
    return 8192;
  }
  
  int a(BaseNCodec.Context paramContext)
  {
    if (paramContext.b != null) {
      return paramContext.c - paramContext.d;
    }
    return 0;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext);
  
  protected abstract boolean a(byte paramByte);
  
  protected byte[] a(int paramInt, BaseNCodec.Context paramContext)
  {
    if ((paramContext.b != null) && (paramContext.b.length >= paramContext.c + paramInt)) {
      return paramContext.b;
    }
    return b(paramContext);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      BaseNCodec.Context localContext = new BaseNCodec.Context();
      a(paramArrayOfByte, 0, paramArrayOfByte.length, localContext);
      a(paramArrayOfByte, 0, -1, localContext);
      arrayOfByte = new byte[localContext.c];
      b(arrayOfByte, 0, arrayOfByte.length, localContext);
    }
    return arrayOfByte;
  }
  
  int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext)
  {
    if (paramContext.b != null)
    {
      paramInt2 = Math.min(a(paramContext), paramInt2);
      System.arraycopy(paramContext.b, paramContext.d, paramArrayOfByte, paramInt1, paramInt2);
      paramContext.d += paramInt2;
      if (paramContext.d >= paramContext.c) {
        paramContext.b = null;
      }
      return paramInt2;
    }
    if (paramContext.e) {
      return -1;
    }
    return 0;
  }
  
  protected boolean b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b1 = paramArrayOfByte[i];
      if ((61 != b1) && (!a(b1))) {
        i += 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public byte[] b(String paramString)
  {
    return a(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.BaseNCodec
 * JD-Core Version:    0.7.0.1
 */