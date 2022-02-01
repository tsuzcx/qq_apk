package com.tencent.mobileqq.app.identity.jwt;

public class Base64
  extends BaseNCodec
{
  static final byte[] a = { 13, 10 };
  private static final byte[] jdField_b_of_type_ArrayOfByte = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] jdField_c_of_type_ArrayOfByte = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private final int jdField_b_of_type_Int;
  private final int jdField_c_of_type_Int;
  private final byte[] e;
  private final byte[] f;
  private final byte[] g;
  
  public Base64()
  {
    this(0);
  }
  
  public Base64(int paramInt)
  {
    this(paramInt, a);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public static byte[] a(String paramString)
  {
    return new Base64().b(paramString);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext)
  {
    if (paramContext.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt2 < 0) {
      paramContext.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte;
      int j;
      if (i < paramInt2)
      {
        arrayOfByte = a(this.jdField_b_of_type_Int, paramContext);
        j = paramArrayOfByte[paramInt1];
        if (j == 61) {
          paramContext.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        if ((!paramContext.jdField_a_of_type_Boolean) || (paramContext.d == 0)) {
          break;
        }
        paramArrayOfByte = a(this.jdField_b_of_type_Int, paramContext);
      }
      switch (paramContext.d)
      {
      case 1: 
      default: 
        throw new IllegalStateException("Impossible modulus " + paramContext.d);
        if ((j >= 0) && (j < d.length))
        {
          j = d[j];
          if (j >= 0)
          {
            paramContext.d = ((paramContext.d + 1) % 4);
            paramContext.jdField_a_of_type_Int = (j + (paramContext.jdField_a_of_type_Int << 6));
            if (paramContext.d == 0)
            {
              j = paramContext.jdField_b_of_type_Int;
              paramContext.jdField_b_of_type_Int = (j + 1);
              arrayOfByte[j] = ((byte)(paramContext.jdField_a_of_type_Int >> 16 & 0xFF));
              j = paramContext.jdField_b_of_type_Int;
              paramContext.jdField_b_of_type_Int = (j + 1);
              arrayOfByte[j] = ((byte)(paramContext.jdField_a_of_type_Int >> 8 & 0xFF));
              j = paramContext.jdField_b_of_type_Int;
              paramContext.jdField_b_of_type_Int = (j + 1);
              arrayOfByte[j] = ((byte)(paramContext.jdField_a_of_type_Int & 0xFF));
            }
          }
        }
        i += 1;
        paramInt1 += 1;
      }
    }
    paramContext.jdField_a_of_type_Int >>= 4;
    paramInt1 = paramContext.jdField_b_of_type_Int;
    paramContext.jdField_b_of_type_Int = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(paramContext.jdField_a_of_type_Int & 0xFF));
    return;
    paramContext.jdField_a_of_type_Int >>= 2;
    paramInt1 = paramContext.jdField_b_of_type_Int;
    paramContext.jdField_b_of_type_Int = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(paramContext.jdField_a_of_type_Int >> 8 & 0xFF));
    paramInt1 = paramContext.jdField_b_of_type_Int;
    paramContext.jdField_b_of_type_Int = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(paramContext.jdField_a_of_type_Int & 0xFF));
  }
  
  protected boolean a(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.f.length) && (this.f[paramByte] != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.Base64
 * JD-Core Version:    0.7.0.1
 */