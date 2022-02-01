package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8
{
  private static final Utf8.Processor a;
  
  static
  {
    Object localObject;
    if ((Utf8.UnsafeProcessor.a()) && (!Android.a())) {
      localObject = new Utf8.UnsafeProcessor();
    } else {
      localObject = new Utf8.SafeProcessor();
    }
    a = (Utf8.Processor)localObject;
  }
  
  static int a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  static int a(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while ((j < m) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    int i = m;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break label87;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int k = i + a(paramCharSequence, j);
    label87:
    if (k >= m) {
      return k;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    paramCharSequence = new IllegalArgumentException(paramCharSequence.toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      else
      {
        int k = i + 2;
        i = k;
        j = paramInt;
        if (55296 <= n)
        {
          i = k;
          j = paramInt;
          if (n <= 57343) {
            if (Character.codePointAt(paramCharSequence, paramInt) >= 65536)
            {
              j = paramInt + 1;
              i = k;
            }
            else
            {
              throw new Utf8.UnpairedSurrogateException(paramInt, m);
            }
          }
        }
      }
      paramInt = j + 1;
    }
    return i;
  }
  
  static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a.a(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static String a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    return a.b(paramByteBuffer, paramInt1, paramInt2);
  }
  
  static void a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    a.a(paramCharSequence, paramByteBuffer);
  }
  
  static boolean a(ByteBuffer paramByteBuffer)
  {
    return a.a(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return a.a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int b(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  private static int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1)
      {
        if (paramInt3 == 2) {
          return b(paramInt1, paramByteBuffer.get(paramInt2), paramByteBuffer.get(paramInt2 + 1));
        }
        throw new AssertionError();
      }
      return b(paramInt1, paramByteBuffer.get(paramInt2));
    }
    return b(paramInt1);
  }
  
  static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt2 - 7) && ((paramByteBuffer.getLong(i) & 0x80808080) == 0L)) {
      i += 8;
    }
    return i - paramInt1;
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return b(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return b(i, paramArrayOfByte[paramInt1]);
    }
    return b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Utf8
 * JD-Core Version:    0.7.0.1
 */