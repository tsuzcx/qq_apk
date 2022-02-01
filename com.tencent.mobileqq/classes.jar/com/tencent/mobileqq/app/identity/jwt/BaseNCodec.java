package com.tencent.mobileqq.app.identity.jwt;

public abstract class BaseNCodec
{
  protected final byte a;
  protected final int a;
  private final int b;
  private final int c;
  private final int d;
  
  protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Byte = 61;
    this.b = paramInt1;
    this.c = paramInt2;
    int i = 0;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      i = paramInt3 / paramInt2 * paramInt2;
    }
    this.jdField_a_of_type_Int = i;
    this.d = paramInt4;
  }
  
  private byte[] a(BaseNCodec.Context paramContext)
  {
    if (paramContext.jdField_a_of_type_ArrayOfByte == null)
    {
      paramContext.jdField_a_of_type_ArrayOfByte = new byte[a()];
      paramContext.b = 0;
      paramContext.c = 0;
    }
    else
    {
      byte[] arrayOfByte = new byte[paramContext.jdField_a_of_type_ArrayOfByte.length * 2];
      System.arraycopy(paramContext.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, paramContext.jdField_a_of_type_ArrayOfByte.length);
      paramContext.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    }
    return paramContext.jdField_a_of_type_ArrayOfByte;
  }
  
  protected int a()
  {
    return 8192;
  }
  
  int a(BaseNCodec.Context paramContext)
  {
    if (paramContext.jdField_a_of_type_ArrayOfByte != null) {
      return paramContext.b - paramContext.c;
    }
    return 0;
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext)
  {
    if (paramContext.jdField_a_of_type_ArrayOfByte != null)
    {
      paramInt2 = Math.min(a(paramContext), paramInt2);
      System.arraycopy(paramContext.jdField_a_of_type_ArrayOfByte, paramContext.c, paramArrayOfByte, paramInt1, paramInt2);
      paramContext.c += paramInt2;
      if (paramContext.c >= paramContext.b) {
        paramContext.jdField_a_of_type_ArrayOfByte = null;
      }
      return paramInt2;
    }
    if (paramContext.jdField_a_of_type_Boolean) {
      return -1;
    }
    return 0;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext);
  
  protected abstract boolean a(byte paramByte);
  
  protected boolean a(byte[] paramArrayOfByte)
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
  
  protected byte[] a(int paramInt, BaseNCodec.Context paramContext)
  {
    if ((paramContext.jdField_a_of_type_ArrayOfByte != null) && (paramContext.jdField_a_of_type_ArrayOfByte.length >= paramContext.b + paramInt)) {
      return paramContext.jdField_a_of_type_ArrayOfByte;
    }
    return a(paramContext);
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
      arrayOfByte = new byte[localContext.b];
      a(arrayOfByte, 0, arrayOfByte.length, localContext);
    }
    return arrayOfByte;
  }
  
  public byte[] b(String paramString)
  {
    return a(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.BaseNCodec
 * JD-Core Version:    0.7.0.1
 */