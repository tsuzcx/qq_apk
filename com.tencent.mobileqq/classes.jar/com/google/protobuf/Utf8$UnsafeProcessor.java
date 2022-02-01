package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8$UnsafeProcessor
  extends Utf8.Processor
{
  private static int a(long paramLong, int paramInt)
  {
    if (paramInt < 16) {
      return 0;
    }
    int j = 8 - ((int)paramLong & 0x7);
    int i = j;
    while (i > 0)
    {
      if (UnsafeUtil.a(paramLong) < 0) {
        return j - i;
      }
      i -= 1;
      paramLong = 1L + paramLong;
    }
    i = paramInt - j;
    while ((i >= 8) && ((UnsafeUtil.b(paramLong) & 0x80808080) == 0L))
    {
      paramLong += 8L;
      i -= 8;
    }
    return paramInt - i;
  }
  
  private static int a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return Utf8.a(paramInt1, UnsafeUtil.a(paramLong), UnsafeUtil.a(paramLong + 1L));
        }
        throw new AssertionError();
      }
      return Utf8.a(paramInt1, UnsafeUtil.a(paramLong));
    }
    return Utf8.a(paramInt1);
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return Utf8.a(paramInt1, UnsafeUtil.a(paramArrayOfByte, paramLong), UnsafeUtil.a(paramArrayOfByte, paramLong + 1L));
        }
        throw new AssertionError();
      }
      return Utf8.a(paramInt1, UnsafeUtil.a(paramArrayOfByte, paramLong));
    }
    return Utf8.a(paramInt1);
  }
  
  private static int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i = 0;
    if (paramInt < 16) {
      return 0;
    }
    while (i < paramInt)
    {
      if (UnsafeUtil.a(paramArrayOfByte, paramLong) < 0) {
        return i;
      }
      i += 1;
      paramLong = 1L + paramLong;
    }
    return paramInt;
  }
  
  static boolean a()
  {
    return (UnsafeUtil.a()) && (UnsafeUtil.b());
  }
  
  private static int b(long paramLong, int paramInt)
  {
    int i = a(paramLong, paramInt);
    paramLong += i;
    paramInt -= i;
    int j = 0;
    i = paramInt;
    paramInt = j;
    long l1;
    for (;;)
    {
      l1 = paramLong;
      if (i <= 0) {
        break;
      }
      l1 = paramLong + 1L;
      paramInt = UnsafeUtil.a(paramLong);
      if (paramInt < 0) {
        break;
      }
      i -= 1;
      paramLong = l1;
    }
    if (i == 0) {
      return 0;
    }
    i -= 1;
    if (paramInt < -32)
    {
      if (i == 0) {
        return paramInt;
      }
      i -= 1;
      if (paramInt >= -62)
      {
        paramLong = 1L + l1;
        paramInt = i;
        if (UnsafeUtil.a(l1) > -65) {
          return -1;
        }
      }
    }
    label196:
    label198:
    do
    {
      long l2;
      do
      {
        break;
        return -1;
        if (paramInt >= -16) {
          break label198;
        }
        if (i < 2) {
          return a(l1, paramInt, i);
        }
        i -= 2;
        l2 = l1 + 1L;
        j = UnsafeUtil.a(l1);
        if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96))) {
          break label196;
        }
        paramLong = 1L + l2;
        paramInt = i;
      } while (UnsafeUtil.a(l2) <= -65);
      return -1;
      if (i < 3) {
        return a(l1, paramInt, i);
      }
      i -= 3;
      paramLong = l1 + 1L;
      j = UnsafeUtil.a(l1);
      if ((j > -65) || ((paramInt << 28) + (j + 112) >> 30 != 0)) {
        break label281;
      }
      l1 = paramLong + 1L;
      if (UnsafeUtil.a(paramLong) > -65) {
        break label281;
      }
      paramLong = 1L + l1;
      paramInt = i;
    } while (UnsafeUtil.a(l1) <= -65);
    label281:
    return -1;
  }
  
  private static int b(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i = a(paramArrayOfByte, paramLong, paramInt);
    paramInt -= i;
    paramLong += i;
    int j = 0;
    i = paramInt;
    paramInt = j;
    long l1;
    for (;;)
    {
      l1 = paramLong;
      if (i <= 0) {
        break;
      }
      l1 = paramLong + 1L;
      paramInt = UnsafeUtil.a(paramArrayOfByte, paramLong);
      if (paramInt < 0) {
        break;
      }
      i -= 1;
      paramLong = l1;
    }
    if (i == 0) {
      return 0;
    }
    i -= 1;
    if (paramInt < -32)
    {
      if (i == 0) {
        return paramInt;
      }
      i -= 1;
      if (paramInt >= -62)
      {
        paramLong = 1L + l1;
        paramInt = i;
        if (UnsafeUtil.a(paramArrayOfByte, l1) > -65) {
          return -1;
        }
      }
    }
    label221:
    label223:
    do
    {
      long l2;
      do
      {
        break;
        return -1;
        if (paramInt >= -16) {
          break label223;
        }
        if (i < 2) {
          return a(paramArrayOfByte, paramInt, l1, i);
        }
        i -= 2;
        l2 = l1 + 1L;
        j = UnsafeUtil.a(paramArrayOfByte, l1);
        if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96))) {
          break label221;
        }
        paramLong = 1L + l2;
        paramInt = i;
      } while (UnsafeUtil.a(paramArrayOfByte, l2) <= -65);
      return -1;
      if (i < 3) {
        return a(paramArrayOfByte, paramInt, l1, i);
      }
      i -= 3;
      paramLong = l1 + 1L;
      j = UnsafeUtil.a(paramArrayOfByte, l1);
      if ((j > -65) || ((paramInt << 28) + (j + 112) >> 30 != 0)) {
        break label315;
      }
      l1 = paramLong + 1L;
      if (UnsafeUtil.a(paramArrayOfByte, paramLong) > -65) {
        break label315;
      }
      paramLong = 1L + l1;
      paramInt = i;
    } while (UnsafeUtil.a(paramArrayOfByte, l1) <= -65);
    label315:
    return -1;
  }
  
  int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if ((paramInt2 | paramInt3 | j - paramInt3) >= 0)
    {
      long l2 = paramInt2;
      long l4 = paramInt3;
      long l1;
      if (paramInt1 != 0)
      {
        if (l2 >= l4) {
          return paramInt1;
        }
        j = (byte)paramInt1;
        if (j < -32)
        {
          if (j >= -62)
          {
            l1 = l2 + 1L;
            if (UnsafeUtil.a(paramArrayOfByte, l2) <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          long l3;
          if (j < -16)
          {
            paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            l3 = l2;
            paramInt1 = paramInt2;
            if (paramInt2 == 0)
            {
              l3 = l2 + 1L;
              paramInt1 = UnsafeUtil.a(paramArrayOfByte, l2);
              if (l3 >= l4) {
                return Utf8.a(j, paramInt1);
              }
            }
            if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
            {
              l1 = l3 + 1L;
              if (UnsafeUtil.a(paramArrayOfByte, l3) <= -65) {}
            }
            else
            {
              return -1;
            }
          }
          else
          {
            paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            if (paramInt2 == 0)
            {
              l1 = l2 + 1L;
              paramInt2 = UnsafeUtil.a(paramArrayOfByte, l2);
              if (l1 >= l4) {
                return Utf8.a(j, paramInt2);
              }
              l2 = l1;
              paramInt1 = i;
            }
            else
            {
              paramInt1 = (byte)(paramInt1 >> 16);
            }
            paramInt3 = paramInt1;
            l3 = l2;
            if (paramInt1 == 0)
            {
              l3 = l2 + 1L;
              paramInt3 = UnsafeUtil.a(paramArrayOfByte, l2);
              if (l3 >= l4) {
                return Utf8.a(j, paramInt2, paramInt3);
              }
            }
            if ((paramInt2 <= -65) && ((j << 28) + (paramInt2 + 112) >> 30 == 0) && (paramInt3 <= -65))
            {
              l1 = l3 + 1L;
              if (UnsafeUtil.a(paramArrayOfByte, l3) <= -65) {}
            }
            else
            {
              return -1;
            }
          }
        }
      }
      else
      {
        l1 = l2;
      }
      return b(paramArrayOfByte, l1, (int)(l4 - l1));
    }
    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l2 = paramInt1;
    long l5 = paramInt2 + l2;
    int j = paramCharSequence.length();
    if ((j <= paramInt2) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
    {
      paramInt2 = 0;
      long l1;
      for (;;)
      {
        l1 = 1L;
        if (paramInt2 >= j) {
          break;
        }
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 >= 128) {
          break;
        }
        UnsafeUtil.a(paramArrayOfByte, l2, (byte)paramInt1);
        paramInt2 += 1;
        l2 = 1L + l2;
      }
      paramInt1 = paramInt2;
      long l3 = l2;
      if (paramInt2 == j) {
        return (int)l2;
      }
      while (paramInt1 < j)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < 128) && (l3 < l5))
        {
          UnsafeUtil.a(paramArrayOfByte, l3, (byte)i);
          long l4 = l1;
          l2 = l3 + l1;
          l1 = l4;
        }
        for (;;)
        {
          break;
          if ((i < 2048) && (l3 <= l5 - 2L))
          {
            l2 = l3 + l1;
            UnsafeUtil.a(paramArrayOfByte, l3, (byte)(i >>> 6 | 0x3C0));
            UnsafeUtil.a(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
            l2 += l1;
          }
          else if (((i < 55296) || (57343 < i)) && (l3 <= l5 - 3L))
          {
            l2 = l3 + l1;
            UnsafeUtil.a(paramArrayOfByte, l3, (byte)(i >>> 12 | 0x1E0));
            l1 = l2 + l1;
            UnsafeUtil.a(paramArrayOfByte, l2, (byte)(i >>> 6 & 0x3F | 0x80));
            UnsafeUtil.a(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
            l2 = l1 + 1L;
            l1 = 1L;
          }
          else
          {
            if (l3 > l5 - 4L) {
              break label511;
            }
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == j) {
              break label498;
            }
            char c = paramCharSequence.charAt(paramInt2);
            if (!Character.isSurrogatePair(i, c)) {
              break label495;
            }
            paramInt1 = Character.toCodePoint(i, c);
            l1 = l3 + 1L;
            UnsafeUtil.a(paramArrayOfByte, l3, (byte)(paramInt1 >>> 18 | 0xF0));
            l2 = l1 + 1L;
            UnsafeUtil.a(paramArrayOfByte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            l3 = l2 + 1L;
            UnsafeUtil.a(paramArrayOfByte, l2, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            l1 = 1L;
            l2 = l3 + 1L;
            UnsafeUtil.a(paramArrayOfByte, l3, (byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
          }
        }
        paramInt1 += 1;
        l3 = l2;
        continue;
        label495:
        paramInt1 = paramInt2;
        label498:
        throw new Utf8.UnpairedSurrogateException(paramInt1 - 1, j);
        label511:
        if ((55296 <= i) && (i <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
            throw new Utf8.UnpairedSurrogateException(paramInt1, j);
          }
        }
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l3);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      return (int)l3;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Failed writing ");
    paramArrayOfByte.append(paramCharSequence.charAt(j - 1));
    paramArrayOfByte.append(" at index ");
    paramArrayOfByte.append(paramInt1 + paramInt2);
    paramCharSequence = new ArrayIndexOutOfBoundsException(paramArrayOfByte.toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    int j = paramByteBuffer.limit();
    int i = 0;
    if ((paramInt2 | paramInt3 | j - paramInt3) >= 0)
    {
      long l2 = UnsafeUtil.a(paramByteBuffer) + paramInt2;
      long l4 = paramInt3 - paramInt2 + l2;
      long l1;
      if (paramInt1 != 0)
      {
        if (l2 >= l4) {
          return paramInt1;
        }
        j = (byte)paramInt1;
        if (j < -32)
        {
          if (j >= -62)
          {
            l1 = l2 + 1L;
            if (UnsafeUtil.a(l2) <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          long l3;
          if (j < -16)
          {
            paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            l3 = l2;
            paramInt1 = paramInt2;
            if (paramInt2 == 0)
            {
              l3 = l2 + 1L;
              paramInt1 = UnsafeUtil.a(l2);
              if (l3 >= l4) {
                return Utf8.a(j, paramInt1);
              }
            }
            if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
            {
              l1 = l3 + 1L;
              if (UnsafeUtil.a(l3) <= -65) {}
            }
            else
            {
              return -1;
            }
          }
          else
          {
            paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
            if (paramInt2 == 0)
            {
              l1 = l2 + 1L;
              paramInt2 = UnsafeUtil.a(l2);
              if (l1 >= l4) {
                return Utf8.a(j, paramInt2);
              }
              l2 = l1;
              paramInt1 = i;
            }
            else
            {
              paramInt1 = (byte)(paramInt1 >> 16);
            }
            paramInt3 = paramInt1;
            l3 = l2;
            if (paramInt1 == 0)
            {
              l3 = l2 + 1L;
              paramInt3 = UnsafeUtil.a(l2);
              if (l3 >= l4) {
                return Utf8.a(j, paramInt2, paramInt3);
              }
            }
            if ((paramInt2 <= -65) && ((j << 28) + (paramInt2 + 112) >> 30 == 0) && (paramInt3 <= -65))
            {
              l1 = l3 + 1L;
              if (UnsafeUtil.a(l3) <= -65) {}
            }
            else
            {
              return -1;
            }
          }
        }
      }
      else
      {
        l1 = l2;
      }
      return b(l1, (int)(l4 - l1));
    }
    throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
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
        b1 = UnsafeUtil.a(paramArrayOfByte, paramInt1);
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
        b1 = UnsafeUtil.a(paramArrayOfByte, paramInt2);
        if (Utf8.DecodeUtil.a(b1))
        {
          paramInt2 = paramInt1 + 1;
          Utf8.DecodeUtil.a(b1, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt2 < j)
          {
            b1 = UnsafeUtil.a(paramArrayOfByte, paramInt2);
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
            Utf8.DecodeUtil.a(b1, UnsafeUtil.a(paramArrayOfByte, i), arrayOfChar, paramInt1);
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
            Utf8.DecodeUtil.a(b1, UnsafeUtil.a(paramArrayOfByte, i), UnsafeUtil.a(paramArrayOfByte, paramInt2), arrayOfChar, paramInt1);
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
          byte b2 = UnsafeUtil.a(paramArrayOfByte, i);
          i = paramInt2 + 1;
          Utf8.DecodeUtil.a(b1, b2, UnsafeUtil.a(paramArrayOfByte, paramInt2), UnsafeUtil.a(paramArrayOfByte, i), arrayOfChar, paramInt1);
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
    long l4 = UnsafeUtil.a(paramByteBuffer);
    long l1 = paramByteBuffer.position() + l4;
    long l5 = paramByteBuffer.limit() + l4;
    int m = paramCharSequence.length();
    if (m <= l5 - l1)
    {
      int k = 0;
      while (k < m)
      {
        j = paramCharSequence.charAt(k);
        if (j >= 128) {
          break;
        }
        UnsafeUtil.a(l1, (byte)j);
        k += 1;
        l1 = 1L + l1;
      }
      long l2 = l4;
      long l3 = l1;
      int j = k;
      if (k == m)
      {
        paramByteBuffer.position((int)(l1 - l4));
        return;
      }
      while (j < m)
      {
        int i = paramCharSequence.charAt(j);
        if ((i < 128) && (l3 < l5))
        {
          UnsafeUtil.a(l3, (byte)i);
          l1 = l3 + 1L;
        }
        else
        {
          if ((i < 2048) && (l3 <= l5 - 2L))
          {
            l1 = l3 + 1L;
            UnsafeUtil.a(l3, (byte)(i >>> 6 | 0x3C0));
            UnsafeUtil.a(l1, (byte)(i & 0x3F | 0x80));
            l1 += 1L;
          }
          for (;;)
          {
            break;
            if (((i < 55296) || (57343 < i)) && (l3 <= l5 - 3L))
            {
              l1 = l3 + 1L;
              UnsafeUtil.a(l3, (byte)(i >>> 12 | 0x1E0));
              l3 = l1 + 1L;
              UnsafeUtil.a(l1, (byte)(i >>> 6 & 0x3F | 0x80));
              UnsafeUtil.a(l3, (byte)(i & 0x3F | 0x80));
              l1 = l3 + 1L;
            }
            else
            {
              if (l3 > l5 - 4L) {
                break label504;
              }
              k = j + 1;
              if (k == m) {
                break label490;
              }
              char c = paramCharSequence.charAt(k);
              j = k;
              if (!Character.isSurrogatePair(i, c)) {
                break label490;
              }
              j = Character.toCodePoint(i, c);
              l1 = l3 + 1L;
              UnsafeUtil.a(l3, (byte)(j >>> 18 | 0xF0));
              l3 = l1 + 1L;
              UnsafeUtil.a(l1, (byte)(j >>> 12 & 0x3F | 0x80));
              l1 = l3 + 1L;
              UnsafeUtil.a(l3, (byte)(j >>> 6 & 0x3F | 0x80));
              UnsafeUtil.a(l1, (byte)(j & 0x3F | 0x80));
              l1 += 1L;
              j = k;
            }
          }
        }
        j += 1;
        l3 = l1;
        continue;
        label490:
        throw new Utf8.UnpairedSurrogateException(j - 1, m);
        label504:
        if ((55296 <= i) && (i <= 57343))
        {
          k = j + 1;
          if ((k == m) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(k)))) {
            throw new Utf8.UnpairedSurrogateException(j, m);
          }
        }
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l3);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      paramByteBuffer.position((int)(l3 - l2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed writing ");
    localStringBuilder.append(paramCharSequence.charAt(m - 1));
    localStringBuilder.append(" at index ");
    localStringBuilder.append(paramByteBuffer.limit());
    paramCharSequence = new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  String c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 | paramInt2 | paramByteBuffer.limit() - paramInt1 - paramInt2) >= 0)
    {
      long l1 = UnsafeUtil.a(paramByteBuffer) + paramInt1;
      long l3 = paramInt2 + l1;
      paramByteBuffer = new char[paramInt2];
      paramInt1 = 0;
      long l2;
      byte b1;
      for (;;)
      {
        paramInt2 = paramInt1;
        l2 = l1;
        if (l1 >= l3) {
          break;
        }
        b1 = UnsafeUtil.a(l1);
        if (!Utf8.DecodeUtil.a(b1))
        {
          paramInt2 = paramInt1;
          l2 = l1;
          break;
        }
        l1 += 1L;
        Utf8.DecodeUtil.a(b1, paramByteBuffer, paramInt1);
        paramInt1 += 1;
      }
      for (;;)
      {
        paramInt1 = paramInt2;
        l1 = l2;
        for (;;)
        {
          if (l1 >= l3) {
            break label372;
          }
          l2 = l1 + 1L;
          b1 = UnsafeUtil.a(l1);
          if (Utf8.DecodeUtil.a(b1))
          {
            paramInt2 = paramInt1 + 1;
            Utf8.DecodeUtil.a(b1, paramByteBuffer, paramInt1);
            paramInt1 = paramInt2;
            l1 = l2;
            while (l1 < l3)
            {
              b1 = UnsafeUtil.a(l1);
              if (!Utf8.DecodeUtil.a(b1)) {
                break;
              }
              l1 += 1L;
              Utf8.DecodeUtil.a(b1, paramByteBuffer, paramInt1);
              paramInt1 += 1;
            }
          }
          else if (Utf8.DecodeUtil.b(b1))
          {
            if (l2 < l3)
            {
              l1 = l2 + 1L;
              Utf8.DecodeUtil.a(b1, UnsafeUtil.a(l2), paramByteBuffer, paramInt1);
              paramInt1 += 1;
            }
            else
            {
              throw InvalidProtocolBufferException.invalidUtf8();
            }
          }
          else
          {
            if (!Utf8.DecodeUtil.c(b1)) {
              break label299;
            }
            if (l2 >= l3 - 1L) {
              break;
            }
            l1 = l2 + 1L;
            Utf8.DecodeUtil.a(b1, UnsafeUtil.a(l2), UnsafeUtil.a(l1), paramByteBuffer, paramInt1);
            paramInt1 += 1;
            l1 += 1L;
          }
        }
        throw InvalidProtocolBufferException.invalidUtf8();
        label299:
        if (l2 >= l3 - 2L) {
          break;
        }
        l1 = l2 + 1L;
        byte b2 = UnsafeUtil.a(l2);
        long l4 = l1 + 1L;
        byte b3 = UnsafeUtil.a(l1);
        l2 = l4 + 1L;
        Utf8.DecodeUtil.a(b1, b2, b3, UnsafeUtil.a(l4), paramByteBuffer, paramInt1);
        paramInt2 = paramInt1 + 1 + 1;
      }
      throw InvalidProtocolBufferException.invalidUtf8();
      label372:
      return new String(paramByteBuffer, 0, paramInt1);
    }
    paramByteBuffer = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Utf8.UnsafeProcessor
 * JD-Core Version:    0.7.0.1
 */