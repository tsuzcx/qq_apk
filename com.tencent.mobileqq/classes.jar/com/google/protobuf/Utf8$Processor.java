package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class Utf8$Processor
{
  private static int e(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    paramInt1 += Utf8.b(paramByteBuffer, paramInt1, paramInt2);
    label245:
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      int i = paramInt1 + 1;
      int j = paramByteBuffer.get(paramInt1);
      paramInt1 = i;
      if (j < 0) {
        if (j < -32)
        {
          if (i >= paramInt2) {
            return j;
          }
          if (j >= -62)
          {
            if (paramByteBuffer.get(i) > -65) {
              return -1;
            }
            paramInt1 = i + 1;
          }
          else
          {
            return -1;
          }
        }
        else if (j < -16)
        {
          if (i >= paramInt2 - 1) {
            return Utf8.a(paramByteBuffer, j, i, paramInt2 - i);
          }
          paramInt1 = i + 1;
          i = paramByteBuffer.get(i);
          if ((i <= -65) && ((j != -32) || (i >= -96)) && ((j != -19) || (i < -96)))
          {
            if (paramByteBuffer.get(paramInt1) > -65) {
              return -1;
            }
            paramInt1 += 1;
          }
          else
          {
            return -1;
          }
        }
        else
        {
          if (i >= paramInt2 - 2) {
            return Utf8.a(paramByteBuffer, j, i, paramInt2 - i);
          }
          paramInt1 = i + 1;
          i = paramByteBuffer.get(i);
          if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
          {
            i = paramInt1 + 1;
            if (paramByteBuffer.get(paramInt1) <= -65)
            {
              paramInt1 = i + 1;
              if (paramByteBuffer.get(i) <= -65) {
                break label245;
              }
            }
          }
          return -1;
        }
      }
    }
  }
  
  final int a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return a(paramInt1, paramByteBuffer.array(), paramInt2 + i, i + paramInt3);
    }
    if (paramByteBuffer.isDirect()) {
      return b(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
    return c(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  abstract int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  abstract int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  final void a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(Utf8.a(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      b(paramCharSequence, paramByteBuffer);
      return;
    }
    c(paramCharSequence, paramByteBuffer);
  }
  
  final boolean a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (a(0, paramByteBuffer, paramInt1, paramInt2) == 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (a(0, paramArrayOfByte, paramInt1, paramInt2) == 0) {
      bool = true;
    }
    return bool;
  }
  
  abstract int b(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  final String b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return b(paramByteBuffer.array(), i + paramInt1, paramInt2);
    }
    if (paramByteBuffer.isDirect()) {
      return c(paramByteBuffer, paramInt1, paramInt2);
    }
    return d(paramByteBuffer, paramInt1, paramInt2);
  }
  
  abstract String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  abstract void b(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);
  
  final int c(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
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
          if (paramByteBuffer.get(paramInt2) <= -65) {
            break label309;
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
          paramInt1 = paramByteBuffer.get(paramInt2);
          if (i >= paramInt3) {
            return Utf8.a(n, paramInt1);
          }
        }
        if ((paramInt1 <= -65) && ((n != -32) || (paramInt1 >= -96)) && ((n != -19) || (paramInt1 < -96)))
        {
          paramInt1 = i + 1;
          if (paramByteBuffer.get(i) <= -65) {
            break label309;
          }
        }
        return -1;
      }
      i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
      int j = 0;
      if (i == 0)
      {
        k = paramInt2 + 1;
        int m = paramByteBuffer.get(paramInt2);
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
        k = paramByteBuffer.get(paramInt1);
        if (j >= paramInt3) {
          return Utf8.a(n, i, k);
        }
      }
      if ((i <= -65) && ((n << 28) + (i + 112) >> 30 == 0) && (k <= -65))
      {
        i = j + 1;
        if (paramByteBuffer.get(j) <= -65) {}
      }
      else
      {
        return -1;
      }
    }
    paramInt1 = i;
    label309:
    return e(paramByteBuffer, paramInt1, paramInt3);
  }
  
  abstract String c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  final void c(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int i2 = paramCharSequence.length();
    k = paramByteBuffer.position();
    j = 0;
    for (;;)
    {
      int n;
      int m;
      if (j < i2)
      {
        n = k;
        m = j;
      }
      try
      {
        i1 = paramCharSequence.charAt(j);
        if (i1 < 128)
        {
          n = k;
          m = j;
          paramByteBuffer.put(k + j, (byte)i1);
          j += 1;
        }
        else
        {
          if (j != i2) {
            break label685;
          }
          n = k;
          m = j;
          paramByteBuffer.position(k + j);
          return;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        for (;;)
        {
          int i1;
          int i;
          byte b;
          char c;
          int i3;
          j = m;
          continue;
          k += j;
          continue;
          j += 1;
          k += 1;
        }
      }
    }
    if (j < i2)
    {
      n = k;
      m = j;
      i = paramCharSequence.charAt(j);
      if (i < 128)
      {
        n = k;
        m = j;
        paramByteBuffer.put(k, (byte)i);
        break label695;
      }
      if (i < 2048)
      {
        n = k + 1;
        b = (byte)(i >>> 6 | 0xC0);
        m = n;
      }
    }
    try
    {
      paramByteBuffer.put(k, b);
      m = n;
      paramByteBuffer.put(n, (byte)(i & 0x3F | 0x80));
      k = n;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
    {
      label225:
      break label225;
    }
    n = m;
    break label574;
    if ((i >= 55296) && (57343 >= i))
    {
      m = j + 1;
      if (m != i2) {
        j = k;
      }
    }
    try
    {
      c = paramCharSequence.charAt(m);
      j = k;
      if (Character.isSurrogatePair(i, c))
      {
        j = k;
        i3 = Character.toCodePoint(i, c);
        n = k + 1;
        b = (byte)(i3 >>> 18 | 0xF0);
        j = n;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException3)
    {
      label424:
      label434:
      label445:
      break label434;
    }
    try
    {
      paramByteBuffer.put(k, b);
      i1 = n + 1;
      b = (byte)(i3 >>> 12 & 0x3F | 0x80);
      j = i1;
      paramByteBuffer.put(n, b);
      k = i1 + 1;
      b = (byte)(i3 >>> 6 & 0x3F | 0x80);
      j = k;
      paramByteBuffer.put(i1, b);
      j = k;
      paramByteBuffer.put(k, (byte)(i3 & 0x3F | 0x80));
      j = m;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException4)
    {
      break label424;
    }
    break label434;
    j = m;
    break label445;
    n = j;
    j = m;
    break label574;
    n = k;
    m = j;
    throw new Utf8.UnpairedSurrogateException(j, i2);
    i1 = k + 1;
    b = (byte)(i >>> 12 | 0xE0);
    m = i1;
    paramByteBuffer.put(k, b);
    k = i1 + 1;
    b = (byte)(i >>> 6 & 0x3F | 0x80);
    n = k;
    m = j;
    paramByteBuffer.put(i1, b);
    n = k;
    m = j;
    paramByteBuffer.put(k, (byte)(i & 0x3F | 0x80));
    break label695;
    n = k;
    m = j;
    paramByteBuffer.position(k);
    return;
    label574:
    k = paramByteBuffer.position();
    m = Math.max(j, n - paramByteBuffer.position() + 1);
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Failed writing ");
    paramByteBuffer.append(paramCharSequence.charAt(j));
    paramByteBuffer.append(" at index ");
    paramByteBuffer.append(k + m);
    paramCharSequence = new ArrayIndexOutOfBoundsException(paramByteBuffer.toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  final String d(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 | paramInt2 | paramByteBuffer.limit() - paramInt1 - paramInt2) >= 0)
    {
      int j = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      paramInt2 = 0;
      byte b1;
      while (paramInt1 < j)
      {
        b1 = paramByteBuffer.get(paramInt1);
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
        b1 = paramByteBuffer.get(paramInt2);
        if (Utf8.DecodeUtil.a(b1))
        {
          paramInt2 = paramInt1 + 1;
          Utf8.DecodeUtil.a(b1, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt2 < j)
          {
            b1 = paramByteBuffer.get(paramInt2);
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
            Utf8.DecodeUtil.a(b1, paramByteBuffer.get(i), arrayOfChar, paramInt1);
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
            Utf8.DecodeUtil.a(b1, paramByteBuffer.get(i), paramByteBuffer.get(paramInt2), arrayOfChar, paramInt1);
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
          byte b2 = paramByteBuffer.get(i);
          i = paramInt2 + 1;
          Utf8.DecodeUtil.a(b1, b2, paramByteBuffer.get(paramInt2), paramByteBuffer.get(i), arrayOfChar, paramInt1);
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
    paramByteBuffer = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Utf8.Processor
 * JD-Core Version:    0.7.0.1
 */