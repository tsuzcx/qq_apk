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
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        i = paramInt3 / paramInt2 * paramInt2;
      }
      this.jdField_a_of_type_Int = i;
      this.d = paramInt4;
      return;
    }
  }
  
  private byte[] a(BaseNCodec.Context paramContext)
  {
    if (paramContext.jdField_a_of_type_ArrayOfByte == null)
    {
      paramContext.jdField_a_of_type_ArrayOfByte = new byte[a()];
      paramContext.b = 0;
      paramContext.c = 0;
    }
    for (;;)
    {
      return paramContext.jdField_a_of_type_ArrayOfByte;
      byte[] arrayOfByte = new byte[paramContext.jdField_a_of_type_ArrayOfByte.length * 2];
      System.arraycopy(paramContext.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, paramContext.jdField_a_of_type_ArrayOfByte.length);
      paramContext.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    }
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
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte b1 = paramArrayOfByte[i];
        if ((61 == b1) || (a(b1))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected byte[] a(int paramInt, BaseNCodec.Context paramContext)
  {
    if ((paramContext.jdField_a_of_type_ArrayOfByte == null) || (paramContext.jdField_a_of_type_ArrayOfByte.length < paramContext.b + paramInt)) {
      return a(paramContext);
    }
    return paramContext.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    BaseNCodec.Context localContext = new BaseNCodec.Context();
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localContext);
    a(paramArrayOfByte, 0, -1, localContext);
    paramArrayOfByte = new byte[localContext.b];
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localContext);
    return paramArrayOfByte;
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