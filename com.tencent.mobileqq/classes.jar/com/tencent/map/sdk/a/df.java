package com.tencent.map.sdk.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class df
{
  private static byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private long[] b = new long[4];
  private long[] c = new long[2];
  private byte[] d = new byte[64];
  private byte[] e = new byte[16];
  
  public df()
  {
    a();
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong3 | (0xFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        paramString = paramString.getBytes();
        continue;
        int i = 120 - i;
      }
      return localUnsupportedEncodingException.toString();
    }
    localObject = new df();
    ((df)localObject).a();
    ((df)localObject).a(new ByteArrayInputStream(paramString), paramString.length);
    paramString = new byte[8];
    a(paramString, ((df)localObject).c, 8);
    i = (int)(localObject.c[0] >>> 3) & 0x3F;
    if (i < 56)
    {
      i = 56 - i;
      ((df)localObject).a(a, i);
      ((df)localObject).a(paramString, 8);
      a(((df)localObject).e, ((df)localObject).b, 16);
      paramString = ((df)localObject).e;
      localObject = new StringBuilder();
      i = 0;
      while (i < 16)
      {
        int j = paramString[i];
        char[] arrayOfChar = new char[16];
        char[] tmp137_135 = arrayOfChar;
        tmp137_135[0] = 48;
        char[] tmp142_137 = tmp137_135;
        tmp142_137[1] = 49;
        char[] tmp147_142 = tmp142_137;
        tmp147_142[2] = 50;
        char[] tmp152_147 = tmp147_142;
        tmp152_147[3] = 51;
        char[] tmp157_152 = tmp152_147;
        tmp157_152[4] = 52;
        char[] tmp162_157 = tmp157_152;
        tmp162_157[5] = 53;
        char[] tmp167_162 = tmp162_157;
        tmp167_162[6] = 54;
        char[] tmp173_167 = tmp167_162;
        tmp173_167[7] = 55;
        char[] tmp179_173 = tmp173_167;
        tmp179_173[8] = 56;
        char[] tmp185_179 = tmp179_173;
        tmp185_179[9] = 57;
        char[] tmp191_185 = tmp185_179;
        tmp191_185[10] = 65;
        char[] tmp197_191 = tmp191_185;
        tmp197_191[11] = 66;
        char[] tmp203_197 = tmp197_191;
        tmp203_197[12] = 67;
        char[] tmp209_203 = tmp203_197;
        tmp209_203[13] = 68;
        char[] tmp215_209 = tmp209_203;
        tmp215_209[14] = 69;
        char[] tmp221_215 = tmp215_209;
        tmp221_215[15] = 70;
        tmp221_215;
        ((StringBuilder)localObject).append(new String(new char[] { arrayOfChar[(j >>> 4 & 0xF)], arrayOfChar[(j & 0xF)] }));
        i += 1;
      }
    }
  }
  
  private void a()
  {
    this.c[0] = 0L;
    this.c[1] = 0L;
    this.b[0] = 1732584193L;
    this.b[1] = 4023233417L;
    this.b[2] = 2562383102L;
    this.b[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l8 = this.b[0];
    long l5 = this.b[1];
    long l6 = this.b[2];
    long l7 = this.b[3];
    long[] arrayOfLong = new long[16];
    int j = 0;
    int i = 0;
    if (j < 64)
    {
      int k = paramArrayOfByte[j];
      if (k < 0)
      {
        l1 = k & 0xFF;
        label67:
        k = paramArrayOfByte[(j + 1)];
        if (k >= 0) {
          break label173;
        }
        l2 = k & 0xFF;
        label88:
        k = paramArrayOfByte[(j + 2)];
        if (k >= 0) {
          break label181;
        }
        l3 = k & 0xFF;
        label109:
        k = paramArrayOfByte[(j + 3)];
        if (k >= 0) {
          break label189;
        }
      }
      label173:
      label181:
      label189:
      for (l4 = k & 0xFF;; l4 = k)
      {
        arrayOfLong[i] = (l4 << 24 | l2 << 8 | l1 | l3 << 16);
        j += 4;
        i += 1;
        break;
        l1 = k;
        break label67;
        l2 = k;
        break label88;
        l3 = k;
        break label109;
      }
    }
    long l1 = a(l8, l5, l6, l7, arrayOfLong[0], 7L, 3614090360L);
    long l2 = a(l7, l1, l5, l6, arrayOfLong[1], 12L, 3905402710L);
    long l3 = a(l6, l2, l1, l5, arrayOfLong[2], 17L, 606105819L);
    long l4 = a(l5, l3, l2, l1, arrayOfLong[3], 22L, 3250441966L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[4], 7L, 4118548399L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[5], 12L, 1200080426L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[6], 17L, 2821735955L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[7], 22L, 4249261313L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[8], 7L, 1770035416L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[9], 12L, 2336552879L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[10], 17L, 4294925233L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[11], 22L, 2304563134L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[12], 7L, 1804603682L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[13], 12L, 4254626195L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[14], 17L, 2792965006L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[15], 22L, 1236535329L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[1], 5L, 4129170786L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[6], 9L, 3225465664L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[11], 14L, 643717713L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[0], 20L, 3921069994L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[5], 5L, 3593408605L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[10], 9L, 38016083L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[15], 14L, 3634488961L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[4], 20L, 3889429448L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[9], 5L, 568446438L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[14], 9L, 3275163606L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[3], 14L, 4107603335L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[8], 20L, 1163531501L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[13], 5L, 2850285829L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[2], 9L, 4243563512L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[7], 14L, 1735328473L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[12], 20L, 2368359562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[5], 4L, 4294588738L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[8], 11L, 2272392833L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[11], 16L, 1839030562L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[14], 23L, 4259657740L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[1], 4L, 2763975236L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[4], 11L, 1272893353L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[7], 16L, 4139469664L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[10], 23L, 3200236656L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[13], 4L, 681279174L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[0], 11L, 3936430074L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[3], 16L, 3572445317L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[6], 23L, 76029189L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[9], 4L, 3654602809L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[12], 11L, 3873151461L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[15], 16L, 530742520L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[2], 23L, 3299628645L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[0], 6L, 4096336452L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[7], 10L, 1126891415L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[14], 15L, 2878612391L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[5], 21L, 4237533241L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[12], 6L, 1700485571L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[3], 10L, 2399980690L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[10], 15L, 4293915773L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[1], 21L, 2240044497L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[8], 6L, 1873313359L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[15], 10L, 4264355552L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[6], 15L, 2734768916L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[13], 21L, 1309151649L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[4], 6L, 4149444226L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[11], 10L, 3174756917L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[2], 15L, 718787259L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l1;
    paramArrayOfByte = this.b;
    paramArrayOfByte[1] = (l4 + paramArrayOfByte[1]);
    paramArrayOfByte = this.b;
    paramArrayOfByte[2] += l3;
    paramArrayOfByte = this.b;
    paramArrayOfByte[3] += l2;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.c[0] >>> 3) & 0x3F;
    Object localObject = this.c;
    long l = localObject[0] + (paramInt << 3);
    localObject[0] = l;
    if (l < paramInt << 3)
    {
      localObject = this.c;
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramInt >>> 29);
    int m = 64 - j;
    int i;
    if (paramInt >= m)
    {
      localObject = this.d;
      i = 0;
      while (i < m)
      {
        localObject[(j + i)] = paramArrayOfByte[(i + 0)];
        i += 1;
      }
      a(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        j = 0;
        while (j < 64)
        {
          arrayOfByte[(j + 0)] = paramArrayOfByte[(i + j)];
          j += 1;
        }
        a(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    for (;;)
    {
      arrayOfByte = this.d;
      while (k < paramInt - i)
      {
        arrayOfByte[(j + k)] = paramArrayOfByte[(i + k)];
        k += 1;
      }
      i = 0;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    int k = 0;
    byte[] arrayOfByte1 = new byte[64];
    int j = (int)(this.c[0] >>> 3) & 0x3F;
    Object localObject = this.c;
    long l = localObject[0] + (paramLong << 3);
    localObject[0] = l;
    if (l < paramLong << 3)
    {
      localObject = this.c;
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramLong >>> 29);
    int m = 64 - j;
    int i;
    if (paramLong >= m)
    {
      localObject = new byte[m];
      try
      {
        paramInputStream.read((byte[])localObject, 0, m);
        byte[] arrayOfByte2 = this.d;
        i = 0;
        while (i < m)
        {
          arrayOfByte2[(j + i)] = localObject[(i + 0)];
          i += 1;
        }
        a(this.d);
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
      i = m;
      while (i + 63 < paramLong) {
        try
        {
          paramInputStream.read(arrayOfByte1);
          a(arrayOfByte1);
          i += 64;
        }
        catch (Exception paramInputStream)
        {
          paramInputStream.printStackTrace();
          return false;
        }
      }
      j = 0;
    }
    for (;;)
    {
      arrayOfByte1 = new byte[(int)(paramLong - i)];
      try
      {
        paramInputStream.read(arrayOfByte1);
        paramInputStream = this.d;
        m = arrayOfByte1.length;
        i = k;
        while (i < m)
        {
          paramInputStream[(j + i)] = arrayOfByte1[(i + 0)];
          i += 1;
          continue;
          i = 0;
        }
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  private static long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 ^ paramLong3 ^ paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = ((0xFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.df
 * JD-Core Version:    0.7.0.1
 */