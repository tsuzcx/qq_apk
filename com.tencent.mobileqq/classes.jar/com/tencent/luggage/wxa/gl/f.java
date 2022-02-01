package com.tencent.luggage.wxa.gl;

public class f
{
  public static char a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, int paramInt1, byte[] paramArrayOfByte3, int paramInt2)
  {
    e locale2 = new e(paramArrayOfByte1);
    e locale3 = new e(paramArrayOfByte2);
    paramArrayOfByte2 = new e[16];
    int i = 0;
    while (i < 16)
    {
      paramArrayOfByte2[i] = new e(new byte[48]);
      i += 1;
    }
    e locale4 = new e(new byte[256]);
    paramArrayOfByte1 = new e(new byte[24]);
    e locale11 = new e(new byte[64]);
    e locale12 = new e();
    e locale13 = new e();
    e locale5 = new e();
    e locale6 = new e();
    e locale7 = new e(new byte[64]);
    e locale8 = new e(new byte[48]);
    e locale9 = new e(new byte[32]);
    e locale10 = new e(new byte[9]);
    e locale1 = new e(new byte[8]);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      long l = paramLong + 7L & 0xFFFFFFF8;
      paramLong = 0L;
      if (l != 0L)
      {
        a(locale7, locale11, locale12, locale13, locale5, locale6);
        a(paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, paramInt1, locale11, locale12, locale13, locale4);
        i = locale3.b;
        paramInt1 = locale2.b;
        if (paramInt2 == 0)
        {
          a(locale2, locale10, paramArrayOfByte2, paramInt2, locale7, locale8, locale9, locale5, locale6, locale4);
          paramArrayOfByte1 = locale1;
          d(paramArrayOfByte1, locale2, 8);
          for (locale2.b += 8; paramLong < l >> 3; locale3.b += 8)
          {
            a(paramArrayOfByte1, paramArrayOfByte1, locale3);
            a(locale2, paramArrayOfByte1, paramArrayOfByte2, paramInt2, locale7, locale8, locale9, locale5, locale6, locale4);
            d(paramArrayOfByte1, locale2, 8);
            paramLong += 1L;
            locale2.b += 8;
          }
        }
        else
        {
          d(locale10, locale3, 8);
          locale3.b += 8;
          paramLong = 1L;
          paramArrayOfByte1 = paramArrayOfByte2;
          while (paramLong < l >> 3)
          {
            a(locale1, locale3, paramArrayOfByte1, paramInt2, locale7, locale8, locale9, locale5, locale6, locale4);
            a(locale2, locale1, locale10);
            d(locale10, locale3, 8);
            paramLong += 1L;
            locale2.b += 8;
            locale3.b += 8;
          }
        }
        locale3.b = i;
        locale2.b = paramInt1;
        return '\001';
      }
    }
    return '\000';
  }
  
  private static void a(e parame, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      parame.a[(parame.b + i)] = ((byte)paramInt1);
      i += 1;
    }
  }
  
  private static void a(e parame1, e parame2)
  {
    byte[] arrayOfByte10 = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 };
    byte[] arrayOfByte11 = { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 };
    byte[] arrayOfByte12 = { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 };
    byte[] arrayOfByte13 = { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 };
    byte[] arrayOfByte17 = { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 };
    byte[] arrayOfByte18 = { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 };
    byte[] arrayOfByte19 = { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 };
    byte[] arrayOfByte20 = { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 };
    byte[] arrayOfByte1 = { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 };
    byte[] arrayOfByte2 = { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 };
    byte[] arrayOfByte5 = { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 };
    byte[] arrayOfByte6 = { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 };
    byte[] arrayOfByte3 = { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 };
    byte[] arrayOfByte4 = { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 };
    byte[] arrayOfByte14 = { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 };
    byte[] arrayOfByte15 = { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 };
    byte[] arrayOfByte16 = { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 };
    byte[] arrayOfByte7 = { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 };
    byte[] arrayOfByte8 = { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 };
    byte[] arrayOfByte9 = { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };
    int j = parame2.b;
    int k = parame1.b;
    int i = 0;
    while (i < 8)
    {
      int m = (byte)((parame2.a[(parame2.b + 0)] << 1) + parame2.a[(parame2.b + 5)]);
      int n = (byte)((parame2.a[(parame2.b + 1)] << 3) + (parame2.a[(parame2.b + 2)] << 2) + (parame2.a[(parame2.b + 3)] << 1) + parame2.a[(parame2.b + 4)]);
      b(parame1, new e(new byte[][][] { { arrayOfByte10, arrayOfByte11, arrayOfByte12, arrayOfByte13 }, { arrayOfByte17, arrayOfByte18, arrayOfByte19, arrayOfByte20 }, { arrayOfByte1, { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 }, arrayOfByte2, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } }, { arrayOfByte5, { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 }, { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 }, arrayOfByte6 }, { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 }, { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 }, { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 }, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } }, { arrayOfByte3, arrayOfByte4, { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 }, { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } }, { arrayOfByte14, arrayOfByte15, arrayOfByte16, { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } }, { arrayOfByte7, { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 }, arrayOfByte8, arrayOfByte9 } }[i][m][n]), 4);
      i = (byte)(i + 1);
      parame2.b += 6;
      parame1.b += 4;
    }
    parame2.b = j;
    parame1.b = k;
  }
  
  private static void a(e parame1, e parame2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      byte[] arrayOfByte = parame1.a;
      int j = parame1.b + i;
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ parame2.a[(parame2.b + i)]));
      i += 1;
    }
  }
  
  private static void a(e parame1, e parame2, int paramInt1, int paramInt2)
  {
    d(parame2, parame1, paramInt2);
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramInt1 - paramInt2) {
        break;
      }
      parame1.a[(parame1.b + i)] = parame1.a[(parame1.b + i + paramInt2)];
      i += 1;
    }
    while (j < paramInt2)
    {
      parame1.a[(parame1.b + j + paramInt1 - paramInt2)] = parame2.a[(parame2.b + j)];
      j += 1;
    }
  }
  
  private static void a(e parame1, e parame2, e parame3)
  {
    int i = 0;
    while (i < 8)
    {
      parame1.a[(parame1.b + i)] = ((byte)(parame2.a[(parame2.b + i)] ^ parame3.a[(parame3.b + i)]));
      i += 1;
    }
  }
  
  private static void a(e parame1, e parame2, e parame3, e parame4)
  {
    a(parame3, parame1, new byte[] { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 }, 48, parame4);
    a(parame3, parame2, 48);
    a(parame1, parame3);
    a(parame1, parame1, new byte[] { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 }, 32, parame4);
  }
  
  private static void a(e parame1, e parame2, e parame3, e parame4, e parame5, e parame6)
  {
    parame3.b = 0;
    parame3.a = parame2.a;
    parame4.b = 28;
    parame4.a = parame2.a;
    parame5.b = 0;
    parame5.a = parame1.a;
    parame6.b = 32;
    parame6.a = parame1.a;
  }
  
  private static void a(e parame1, e parame2, byte[] paramArrayOfByte, int paramInt, e parame3)
  {
    int i = 0;
    while (i < paramInt)
    {
      parame3.a[(parame3.b + i)] = parame2.a[(parame2.b + paramArrayOfByte[i] - 1)];
      i += 1;
    }
    d(parame1, parame3, paramInt);
  }
  
  private static void a(e parame1, e parame2, e[] paramArrayOfe, int paramInt, e parame3, e parame4, e parame5, e parame6, e parame7, e parame8)
  {
    b(parame3, parame2, 64);
    a(parame3, parame3, new byte[] { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 }, 64, parame8);
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < 16)
      {
        d(parame5, parame7, 32);
        a(parame7, paramArrayOfe[paramInt], parame4, parame8);
        a(parame7, parame6, 32);
        d(parame6, parame5, 32);
        paramInt += 1;
      }
    }
    paramInt = 15;
    while (paramInt >= 0)
    {
      d(parame5, parame6, 32);
      a(parame6, paramArrayOfe[paramInt], parame4, parame8);
      a(parame6, parame7, 32);
      d(parame7, parame5, 32);
      paramInt -= 1;
    }
    a(parame3, parame3, new byte[] { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 }, 64, parame8);
    c(parame1, parame3, 64);
  }
  
  private static void a(e[] paramArrayOfe, e parame1, e parame2, e parame3, e parame4, e parame5)
  {
    byte[] arrayOfByte = new byte[16];
    byte[] tmp8_6 = arrayOfByte;
    tmp8_6[0] = 1;
    byte[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 1;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 2;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 2;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 2;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 2;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 2;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 2;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 1;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 2;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 2;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 2;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 2;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 2;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 2;
    byte[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 1;
    tmp92_86;
    b(parame2, parame1, 64);
    a(parame2, parame2, new byte[] { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 }, 56, parame5);
    int i = 0;
    while (i < 16)
    {
      a(parame3, parame5, 28, arrayOfByte[i]);
      a(parame4, parame5, 28, arrayOfByte[i]);
      a(paramArrayOfe[i], parame2, new byte[] { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 }, 48, parame5);
      i += 1;
    }
  }
  
  private static void a(e[] paramArrayOfe, e parame1, byte[] paramArrayOfByte, int paramInt, e parame2, e parame3, e parame4, e parame5)
  {
    a(parame1, 0, 24);
    paramArrayOfByte = new e(paramArrayOfByte);
    int i = paramInt;
    if (paramInt > 24) {
      i = 24;
    }
    d(parame1, paramArrayOfByte, i);
    a(paramArrayOfe, parame1, parame2, parame3, parame4, parame5);
  }
  
  private static void b(e parame1, e parame2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      parame1.a[(parame1.b + i)] = ((byte)(parame2.a[((i >> 3) + parame2.b)] >> (i & 0x7) & 0x1));
      i += 1;
    }
  }
  
  private static void c(e parame1, e parame2, int paramInt)
  {
    int i = 0;
    a(parame1, 0, paramInt >> 3);
    while (i < paramInt)
    {
      byte[] arrayOfByte = parame1.a;
      int j = parame1.b + (i >> 3);
      arrayOfByte[j] = ((byte)(arrayOfByte[j] | parame2.a[(parame2.b + i)] << (i & 0x7)));
      i += 1;
    }
  }
  
  private static void d(e parame1, e parame2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      parame1.a[(parame1.b + i)] = parame2.a[(parame2.b + i)];
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.f
 * JD-Core Version:    0.7.0.1
 */