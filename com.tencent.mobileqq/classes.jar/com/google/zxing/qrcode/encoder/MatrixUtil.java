package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil
{
  private static final int[][] a;
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt5 = { 1, 1, 1, 1, 1, 1, 1 };
    a = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 0, 0, 1 }, arrayOfInt2, arrayOfInt3, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt4, arrayOfInt5 };
    b = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 26, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 34, -1, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    arrayOfInt5 = new int[] { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt17 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt18 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt19 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt20 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt21 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt22 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt23 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt24 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt25 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt26 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt27 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt28 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt29 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt30 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt31 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt32 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt33 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, arrayOfInt1, { 6, 22, -1, -1, -1, -1, -1 }, arrayOfInt2, { 6, 30, -1, -1, -1, -1, -1 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, arrayOfInt29, { 6, 24, 50, 76, 102, 128, 154 }, arrayOfInt30, arrayOfInt31, arrayOfInt32, arrayOfInt33 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 3 };
    arrayOfInt3 = new int[] { 8, 4 };
    arrayOfInt4 = new int[] { 8, 5 };
    arrayOfInt5 = new int[] { 8, 7 };
    arrayOfInt6 = new int[] { 7, 8 };
    arrayOfInt7 = new int[] { 5, 8 };
    arrayOfInt8 = new int[] { 4, 8 };
    arrayOfInt9 = new int[] { 3, 8 };
    arrayOfInt10 = new int[] { 2, 8 };
    arrayOfInt11 = new int[] { 1, 8 };
    d = new int[][] { arrayOfInt1, { 8, 1 }, { 8, 2 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 8, 8 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, { 0, 8 } };
  }
  
  static int a(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    paramInt1 <<= i - 1;
    while (a(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << a(paramInt1) - i;
    }
    return paramInt1;
  }
  
  private static void a(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 8)
    {
      int j = paramInt1 + i;
      if (b(paramByteMatrix.a(j, paramInt2)))
      {
        paramByteMatrix.a(j, paramInt2, 0);
        i += 1;
      }
      else
      {
        throw new WriterException();
      }
    }
  }
  
  static void a(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
  {
    int k = paramByteMatrix.b() - 1;
    int j = paramByteMatrix.a() - 1;
    int i2 = 0;
    int m = -1;
    while (k > 0)
    {
      int n = k;
      int i = i2;
      int i1 = j;
      if (k == 6)
      {
        n = k - 1;
        i1 = j;
        i = i2;
      }
      while ((i1 >= 0) && (i1 < paramByteMatrix.a()))
      {
        j = 0;
        while (j < 2)
        {
          k = n - j;
          if (b(paramByteMatrix.a(k, i1)))
          {
            boolean bool1;
            if (i < paramBitArray.a())
            {
              bool1 = paramBitArray.a(i);
              i += 1;
            }
            else
            {
              bool1 = false;
            }
            boolean bool2 = bool1;
            if (paramInt != -1)
            {
              bool2 = bool1;
              if (MaskUtil.a(paramInt, k, i1)) {
                if (!bool1) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }
              }
            }
            paramByteMatrix.a(k, i1, bool2);
          }
          j += 1;
        }
        i1 += m;
      }
      m = -m;
      j = i1 + m;
      k = n - 2;
      i2 = i;
    }
    if (i2 == paramBitArray.a()) {
      return;
    }
    paramByteMatrix = new StringBuilder();
    paramByteMatrix.append("Not all bits consumed: ");
    paramByteMatrix.append(i2);
    paramByteMatrix.append('/');
    paramByteMatrix.append(paramBitArray.a());
    paramBitArray = new WriterException(paramByteMatrix.toString());
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  static void a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix)
  {
    a(paramByteMatrix);
    a(paramVersion, paramByteMatrix);
    a(paramErrorCorrectionLevel, paramInt, paramByteMatrix);
    b(paramVersion, paramByteMatrix);
    a(paramBitArray, paramInt, paramByteMatrix);
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
  {
    if (QRCode.b(paramInt))
    {
      paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
      paramBitArray.a(paramInt, 5);
      paramBitArray.a(a(paramInt, 1335), 10);
      paramErrorCorrectionLevel = new BitArray();
      paramErrorCorrectionLevel.a(21522, 15);
      paramBitArray.b(paramErrorCorrectionLevel);
      if (paramBitArray.a() == 15) {
        return;
      }
      paramErrorCorrectionLevel = new StringBuilder();
      paramErrorCorrectionLevel.append("should not happen but we got: ");
      paramErrorCorrectionLevel.append(paramBitArray.a());
      throw new WriterException(paramErrorCorrectionLevel.toString());
    }
    throw new WriterException("Invalid mask pattern");
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
  {
    BitArray localBitArray = new BitArray();
    a(paramErrorCorrectionLevel, paramInt, localBitArray);
    paramInt = 0;
    while (paramInt < localBitArray.a())
    {
      boolean bool = localBitArray.a(localBitArray.a() - 1 - paramInt);
      paramErrorCorrectionLevel = d;
      paramByteMatrix.a(paramErrorCorrectionLevel[paramInt][0], paramErrorCorrectionLevel[paramInt][1], bool);
      if (paramInt < 8) {
        paramByteMatrix.a(paramByteMatrix.b() - paramInt - 1, 8, bool);
      } else {
        paramByteMatrix.a(8, paramByteMatrix.a() - 7 + (paramInt - 8), bool);
      }
      paramInt += 1;
    }
  }
  
  static void a(Version paramVersion, BitArray paramBitArray)
  {
    paramBitArray.a(paramVersion.a(), 6);
    paramBitArray.a(a(paramVersion.a(), 7973), 12);
    if (paramBitArray.a() == 18) {
      return;
    }
    paramVersion = new StringBuilder();
    paramVersion.append("should not happen but we got: ");
    paramVersion.append(paramBitArray.a());
    throw new WriterException(paramVersion.toString());
  }
  
  static void a(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    d(paramByteMatrix);
    c(paramByteMatrix);
    c(paramVersion, paramByteMatrix);
    b(paramByteMatrix);
  }
  
  static void a(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.a((byte)-1);
  }
  
  private static void b(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      int j = paramInt2 + i;
      if (b(paramByteMatrix.a(paramInt1, j)))
      {
        paramByteMatrix.a(paramInt1, j, 0);
        i += 1;
      }
      else
      {
        throw new WriterException();
      }
    }
  }
  
  static void b(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 7) {
      return;
    }
    BitArray localBitArray = new BitArray();
    a(paramVersion, localBitArray);
    int j = 0;
    int i = 17;
    while (j < 6)
    {
      int k = 0;
      while (k < 3)
      {
        boolean bool = localBitArray.a(i);
        i -= 1;
        paramByteMatrix.a(j, paramByteMatrix.a() - 11 + k, bool);
        paramByteMatrix.a(paramByteMatrix.a() - 11 + k, j, bool);
        k += 1;
      }
      j += 1;
    }
  }
  
  private static void b(ByteMatrix paramByteMatrix)
  {
    int j;
    for (int i = 8; i < paramByteMatrix.b() - 8; i = j)
    {
      j = i + 1;
      int k = j % 2;
      if (b(paramByteMatrix.a(i, 6))) {
        paramByteMatrix.a(i, 6, k);
      }
      if (b(paramByteMatrix.a(6, i))) {
        paramByteMatrix.a(6, i, k);
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void c(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 2) {
      return;
    }
    int i = paramVersion.a() - 1;
    paramVersion = c;
    Object localObject = paramVersion[i];
    int k = paramVersion[i].length;
    i = 0;
    while (i < k)
    {
      int j = 0;
      while (j < k)
      {
        int m = localObject[i];
        int n = localObject[j];
        if ((n != -1) && (m != -1) && (b(paramByteMatrix.a(n, m)))) {
          c(n - 2, m - 2, paramByteMatrix);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(ByteMatrix paramByteMatrix)
  {
    if (paramByteMatrix.a(8, paramByteMatrix.a() - 8) != 0)
    {
      paramByteMatrix.a(8, paramByteMatrix.a() - 8, 1);
      return;
    }
    throw new WriterException();
  }
  
  private static void d(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(ByteMatrix paramByteMatrix)
  {
    int i = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.b() - i, 0, paramByteMatrix);
    d(0, paramByteMatrix.b() - i, paramByteMatrix);
    a(0, 7, paramByteMatrix);
    a(paramByteMatrix.b() - 8, 7, paramByteMatrix);
    a(0, paramByteMatrix.b() - 8, paramByteMatrix);
    b(7, 0, paramByteMatrix);
    b(paramByteMatrix.a() - 7 - 1, 0, paramByteMatrix);
    b(7, paramByteMatrix.a() - 7, paramByteMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.MatrixUtil
 * JD-Core Version:    0.7.0.1
 */