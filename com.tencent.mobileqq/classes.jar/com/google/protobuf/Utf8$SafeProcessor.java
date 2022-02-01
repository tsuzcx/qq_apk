package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8$SafeProcessor
  extends Utf8.Processor
{
  private static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
      paramInt1 += 1;
    }
    if (paramInt1 >= paramInt2) {
      return 0;
    }
    return d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    label207:
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      int i = paramInt1 + 1;
      int j = paramArrayOfByte[paramInt1];
      paramInt1 = i;
      if (j < 0) {
        if (j < -32)
        {
          if (i >= paramInt2) {
            return j;
          }
          if (j >= -62)
          {
            paramInt1 = i + 1;
            if (paramArrayOfByte[i] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else if (j < -16)
        {
          if (i >= paramInt2 - 1) {
            return Utf8.c(paramArrayOfByte, i, paramInt2);
          }
          int k = i + 1;
          paramInt1 = paramArrayOfByte[i];
          if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
          {
            paramInt1 = k + 1;
            if (paramArrayOfByte[k] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          if (i >= paramInt2 - 2) {
            return Utf8.c(paramArrayOfByte, i, paramInt2);
          }
          paramInt1 = i + 1;
          i = paramArrayOfByte[i];
          if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
          {
            i = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65)
            {
              paramInt1 = i + 1;
              if (paramArrayOfByte[i] <= -65) {
                break label207;
              }
            }
          }
          return -1;
        }
      }
    }
  }
  
  int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramInt2 >= paramInt3) {
        return paramInt1;
      }
      int n = (byte)paramInt1;
      if (n < -32)
      {
        if (n >= -62)
        {
          paramInt1 = paramInt2 + 1;
          if (paramArrayOfByte[paramInt2] <= -65) {
            break label297;
          }
        }
        return -1;
      }
      if (n < -16)
      {
        j = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt1 = j;
        i = paramInt2;
        if (j == 0)
        {
          i = paramInt2 + 1;
          paramInt1 = paramArrayOfByte[paramInt2];
          if (i >= paramInt3) {
            return Utf8.a(n, paramInt1);
          }
        }
        if ((paramInt1 <= -65) && ((n != -32) || (paramInt1 >= -96)) && ((n != -19) || (paramInt1 < -96)))
        {
          paramInt1 = i + 1;
          if (paramArrayOfByte[i] <= -65) {
            break label297;
          }
        }
        return -1;
      }
      i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
      int j = 0;
      if (i == 0)
      {
        k = paramInt2 + 1;
        int m = paramArrayOfByte[paramInt2];
        i = m;
        paramInt2 = j;
        paramInt1 = k;
        if (k >= paramInt3) {
          return Utf8.a(n, m);
        }
      }
      else
      {
        j = (byte)(paramInt1 >> 16);
        paramInt1 = paramInt2;
        paramInt2 = j;
      }
      int k = paramInt2;
      j = paramInt1;
      if (paramInt2 == 0)
      {
        j = paramInt1 + 1;
        k = paramArrayOfByte[paramInt1];
        if (j >= paramInt3) {
          return Utf8.a(n, i, k);
        }
      }
      if ((i <= -65) && ((n << 28) + (i + 112) >> 30 == 0) && (k <= -65))
      {
        i = j + 1;
        if (paramArrayOfByte[j] <= -65) {}
      }
      else
      {
        return -1;
      }
    }
    paramInt1 = i;
    label297:
    return c(paramArrayOfByte, paramInt1, paramInt3);
  }
  
  int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int m = paramInt2 + paramInt1;
    paramInt2 = 0;
    int n;
    while (paramInt2 < k)
    {
      j = paramInt2 + paramInt1;
      if (j >= m) {
        break;
      }
      n = paramCharSequence.charAt(paramInt2);
      if (n >= 128) {
        break;
      }
      paramArrayOfByte[j] = ((byte)n);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    int j = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < k)
    {
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 128) && (j < m))
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)i);
      }
      for (;;)
      {
        break;
        if ((i < 2048) && (j <= m - 2))
        {
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 6 | 0x3C0));
          paramInt2 = n + 1;
          paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
        }
        else if (((i < 55296) || (57343 < i)) && (j <= m - 3))
        {
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 12 | 0x1E0));
          j = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          if (j > m - 4) {
            break label456;
          }
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == paramCharSequence.length()) {
            break label443;
          }
          char c = paramCharSequence.charAt(paramInt2);
          if (!Character.isSurrogatePair(i, c)) {
            break label440;
          }
          paramInt1 = Character.toCodePoint(i, c);
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
      }
      paramInt1 += 1;
      j = paramInt2;
      continue;
      label440:
      paramInt1 = paramInt2;
      label443:
      throw new Utf8.UnpairedSurrogateException(paramInt1 - 1, k);
      label456:
      if ((55296 <= i) && (i <= 57343))
      {
        paramInt2 = paramInt1 + 1;
        if ((paramInt2 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
          throw new Utf8.UnpairedSurrogateException(paramInt1, k);
        }
      }
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("Failed writing ");
      paramCharSequence.append(i);
      paramCharSequence.append(" at index ");
      paramCharSequence.append(j);
      throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    }
    return j;
  }
  
  int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    return c(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt1 - paramInt2) >= 0)
    {
      int j = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      paramInt2 = 0;
      byte b1;
      while (paramInt1 < j)
      {
        b1 = paramArrayOfByte[paramInt1];
        if (!Utf8.DecodeUtil.a(b1)) {
          break;
        }
        paramInt1 += 1;
        Utf8.DecodeUtil.a(b1, arrayOfChar, paramInt2);
        paramInt2 += 1;
      }
      int i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        i = paramInt2 + 1;
        b1 = paramArrayOfByte[paramInt2];
        if (Utf8.DecodeUtil.a(b1))
        {
          paramInt2 = paramInt1 + 1;
          Utf8.DecodeUtil.a(b1, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt2 < j)
          {
            b1 = paramArrayOfByte[paramInt2];
            if (!Utf8.DecodeUtil.a(b1)) {
              break;
            }
            paramInt2 += 1;
            Utf8.DecodeUtil.a(b1, arrayOfChar, paramInt1);
            paramInt1 += 1;
          }
        }
        else if (Utf8.DecodeUtil.b(b1))
        {
          if (i < j)
          {
            Utf8.DecodeUtil.a(b1, paramArrayOfByte[i], arrayOfChar, paramInt1);
            paramInt2 = i + 1;
            paramInt1 += 1;
          }
          else
          {
            throw InvalidProtocolBufferException.invalidUtf8();
          }
        }
        else if (Utf8.DecodeUtil.c(b1))
        {
          if (i < j - 1)
          {
            paramInt2 = i + 1;
            Utf8.DecodeUtil.a(b1, paramArrayOfByte[i], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
            paramInt2 += 1;
            paramInt1 += 1;
          }
          else
          {
            throw InvalidProtocolBufferException.invalidUtf8();
          }
        }
        else if (i < j - 2)
        {
          paramInt2 = i + 1;
          byte b2 = paramArrayOfByte[i];
          i = paramInt2 + 1;
          Utf8.DecodeUtil.a(b1, b2, paramArrayOfByte[paramInt2], paramArrayOfByte[i], arrayOfChar, paramInt1);
          paramInt2 = i + 1;
          paramInt1 = paramInt1 + 1 + 1;
        }
        else
        {
          throw InvalidProtocolBufferException.invalidUtf8();
        }
      }
      return new String(arrayOfChar, 0, paramInt1);
    }
    paramArrayOfByte = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  void b(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    c(paramCharSequence, paramByteBuffer);
  }
  
  String c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    return d(paramByteBuffer, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Utf8.SafeProcessor
 * JD-Core Version:    0.7.0.1
 */