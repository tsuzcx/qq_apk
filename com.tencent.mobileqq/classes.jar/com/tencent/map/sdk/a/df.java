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
    int i = (int)(paramLong1 + ((paramLong3 & paramLong2 | paramLong4 & (0xFFFFFFFF ^ paramLong2)) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
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
      Object localObject;
      label12:
      int i;
      break label12;
    }
    paramString = paramString.getBytes();
    localObject = new df();
    ((df)localObject).a();
    ((df)localObject).a(new ByteArrayInputStream(paramString), paramString.length);
    paramString = new byte[8];
    a(paramString, ((df)localObject).c, 8);
    i = (int)(localObject.c[0] >>> 3) & 0x3F;
    if (i < 56) {
      i = 56 - i;
    } else {
      i = 120 - i;
    }
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
      char[] tmp153_151 = arrayOfChar;
      tmp153_151[0] = 48;
      char[] tmp158_153 = tmp153_151;
      tmp158_153[1] = 49;
      char[] tmp163_158 = tmp158_153;
      tmp163_158[2] = 50;
      char[] tmp168_163 = tmp163_158;
      tmp168_163[3] = 51;
      char[] tmp173_168 = tmp168_163;
      tmp173_168[4] = 52;
      char[] tmp178_173 = tmp173_168;
      tmp178_173[5] = 53;
      char[] tmp183_178 = tmp178_173;
      tmp183_178[6] = 54;
      char[] tmp189_183 = tmp183_178;
      tmp189_183[7] = 55;
      char[] tmp195_189 = tmp189_183;
      tmp195_189[8] = 56;
      char[] tmp201_195 = tmp195_189;
      tmp201_195[9] = 57;
      char[] tmp207_201 = tmp201_195;
      tmp207_201[10] = 65;
      char[] tmp213_207 = tmp207_201;
      tmp213_207[11] = 66;
      char[] tmp219_213 = tmp213_207;
      tmp219_213[12] = 67;
      char[] tmp225_219 = tmp219_213;
      tmp225_219[13] = 68;
      char[] tmp231_225 = tmp225_219;
      tmp231_225[14] = 69;
      char[] tmp237_231 = tmp231_225;
      tmp237_231[15] = 70;
      tmp237_231;
      ((StringBuilder)localObject).append(new String(new char[] { arrayOfChar[(j >>> 4 & 0xF)], arrayOfChar[(j & 0xF)] }));
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private void a()
  {
    long[] arrayOfLong = this.c;
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = 0L;
    arrayOfLong = this.b;
    arrayOfLong[0] = 1732584193L;
    arrayOfLong[1] = 4023233417L;
    arrayOfLong[2] = 2562383102L;
    arrayOfLong[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = this.b;
    long l4 = arrayOfLong[0];
    long l1 = arrayOfLong[1];
    long l2 = arrayOfLong[2];
    long l3 = arrayOfLong[3];
    arrayOfLong = new long[16];
    int i = 0;
    int j = 0;
    while (i < 64)
    {
      int m = paramArrayOfByte[i];
      int k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l5 = k;
      m = paramArrayOfByte[(i + 1)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l6 = k;
      m = paramArrayOfByte[(i + 2)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l7 = k;
      m = paramArrayOfByte[(i + 3)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      arrayOfLong[j] = (l5 | l6 << 8 | l7 << 16 | k << 24);
      j += 1;
      i += 4;
    }
    l4 = a(l4, l1, l2, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[1], 12L, 3905402710L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[3], 22L, 3250441966L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[5], 12L, 1200080426L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[7], 22L, 4249261313L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[9], 12L, 2336552879L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[11], 22L, 2304563134L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[13], 12L, 4254626195L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[15], 22L, 1236535329L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[6], 9L, 3225465664L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[0], 20L, 3921069994L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[10], 9L, 38016083L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[4], 20L, 3889429448L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[14], 9L, 3275163606L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[8], 20L, 1163531501L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[2], 9L, 4243563512L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[12], 20L, 2368359562L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[8], 11L, 2272392833L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[14], 23L, 4259657740L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[4], 11L, 1272893353L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[10], 23L, 3200236656L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[0], 11L, 3936430074L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[6], 23L, 76029189L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[12], 11L, 3873151461L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[2], 23L, 3299628645L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[7], 10L, 1126891415L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[5], 21L, 4237533241L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[3], 10L, 2399980690L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[1], 21L, 2240044497L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[15], 10L, 4264355552L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[13], 21L, 1309151649L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[11], 10L, 3174756917L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l4;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte[2] += l2;
    paramArrayOfByte[3] += l3;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    Object localObject = this.c;
    int k = 0;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramInt << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
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
    else
    {
      i = 0;
    }
    arrayOfByte = this.d;
    while (k < paramInt - i)
    {
      arrayOfByte[(j + k)] = paramArrayOfByte[(i + k)];
      k += 1;
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
      paramArrayOfByte[(i + 3)] = ((byte)(int)(0xFF & paramArrayOfLong[j] >>> 24));
      j += 1;
      i += 4;
    }
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte1 = new byte[64];
    Object localObject = this.c;
    int k = 0;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramLong << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
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
        m = 0;
        j = i;
        i = m;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
    }
    else
    {
      m = 0;
      i = j;
      j = m;
    }
    arrayOfByte1 = new byte[(int)(paramLong - j)];
    try
    {
      paramInputStream.read(arrayOfByte1);
      paramInputStream = this.d;
      m = arrayOfByte1.length;
      j = k;
      while (j < m)
      {
        paramInputStream[(i + j)] = arrayOfByte1[(j + 0)];
        j += 1;
      }
      return true;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return false;
  }
  
  private static long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)((paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 ^ paramLong2 ^ paramLong4) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  private static long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 ^ (paramLong4 ^ 0xFFFFFFFF | paramLong2)) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.df
 * JD-Core Version:    0.7.0.1
 */