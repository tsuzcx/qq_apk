package com.tencent.apkupdate.b;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public final class c
{
  private static byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private final long[] b = new long[4];
  private final long[] c = new long[2];
  private final byte[] d = new byte[64];
  private final byte[] e = new byte[16];
  
  public c()
  {
    a();
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)((paramLong2 & paramLong3 | (0xFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      byte[] arrayOfByte;
      label12:
      int i;
      break label12;
    }
    paramString = paramString.getBytes();
    arrayOfByte = new c().a(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      int j = arrayOfByte[i];
      paramString = new char[16];
      paramString[0] = 48;
      paramString[1] = 49;
      paramString[2] = 50;
      paramString[3] = 51;
      paramString[4] = 52;
      paramString[5] = 53;
      paramString[6] = 54;
      paramString[7] = 55;
      paramString[8] = 56;
      paramString[9] = 57;
      paramString[10] = 65;
      paramString[11] = 66;
      paramString[12] = 67;
      paramString[13] = 68;
      paramString[14] = 69;
      paramString[15] = 70;
      paramString;
      localStringBuilder.append(new String(new char[] { paramString[(j >>> 4 & 0xF)], paramString[(j & 0xF)] }));
      paramString = localStringBuilder.toString();
      i += 1;
    }
    return paramString;
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
        localObject[(j + i)] = paramArrayOfByte[(0 + i)];
        i += 1;
      }
      b(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        j = 0;
        while (j < 64)
        {
          arrayOfByte[(0 + j)] = paramArrayOfByte[(i + j)];
          j += 1;
        }
        b(arrayOfByte);
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
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore 11
    //   6: aload_0
    //   7: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   10: astore 12
    //   12: aload 12
    //   14: iconst_0
    //   15: laload
    //   16: iconst_3
    //   17: lushr
    //   18: l2i
    //   19: bipush 63
    //   21: iand
    //   22: istore 5
    //   24: aload 12
    //   26: iconst_0
    //   27: laload
    //   28: lstore 9
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: lstore 7
    //   35: lload 9
    //   37: lload 7
    //   39: ladd
    //   40: lstore 9
    //   42: aload 12
    //   44: iconst_0
    //   45: lload 9
    //   47: lastore
    //   48: lload 9
    //   50: lload 7
    //   52: lcmp
    //   53: ifge +13 -> 66
    //   56: aload 12
    //   58: iconst_1
    //   59: aload 12
    //   61: iconst_1
    //   62: laload
    //   63: lconst_1
    //   64: ladd
    //   65: lastore
    //   66: aload_0
    //   67: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   70: astore 12
    //   72: aload 12
    //   74: iconst_1
    //   75: aload 12
    //   77: iconst_1
    //   78: laload
    //   79: lload_2
    //   80: bipush 29
    //   82: lushr
    //   83: ladd
    //   84: lastore
    //   85: bipush 64
    //   87: iload 5
    //   89: isub
    //   90: istore 6
    //   92: lload_2
    //   93: iload 6
    //   95: i2l
    //   96: lcmp
    //   97: iflt +119 -> 216
    //   100: iload 6
    //   102: newarray byte
    //   104: astore 12
    //   106: aload_1
    //   107: aload 12
    //   109: iconst_0
    //   110: iload 6
    //   112: invokevirtual 110	java/io/InputStream:read	([BII)I
    //   115: pop
    //   116: aload_0
    //   117: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   120: astore 13
    //   122: iconst_0
    //   123: istore 4
    //   125: iload 4
    //   127: iload 6
    //   129: if_icmpge +27 -> 156
    //   132: aload 13
    //   134: iload 5
    //   136: iload 4
    //   138: iadd
    //   139: aload 12
    //   141: iconst_0
    //   142: iload 4
    //   144: iadd
    //   145: baload
    //   146: bastore
    //   147: iload 4
    //   149: iconst_1
    //   150: iadd
    //   151: istore 4
    //   153: goto -28 -> 125
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   161: invokespecial 98	com/tencent/apkupdate/b/c:b	([B)V
    //   164: iload 6
    //   166: istore 4
    //   168: iload 4
    //   170: bipush 63
    //   172: iadd
    //   173: i2l
    //   174: lload_2
    //   175: lcmp
    //   176: ifge +26 -> 202
    //   179: aload_1
    //   180: aload 11
    //   182: invokevirtual 113	java/io/InputStream:read	([B)I
    //   185: pop
    //   186: aload_0
    //   187: aload 11
    //   189: invokespecial 98	com/tencent/apkupdate/b/c:b	([B)V
    //   192: iload 4
    //   194: bipush 64
    //   196: iadd
    //   197: istore 4
    //   199: goto -31 -> 168
    //   202: iconst_0
    //   203: istore 6
    //   205: iload 4
    //   207: istore 5
    //   209: iload 6
    //   211: istore 4
    //   213: goto +14 -> 227
    //   216: iconst_0
    //   217: istore 6
    //   219: iload 5
    //   221: istore 4
    //   223: iload 6
    //   225: istore 5
    //   227: lload_2
    //   228: iload 5
    //   230: i2l
    //   231: lsub
    //   232: l2i
    //   233: newarray byte
    //   235: astore 11
    //   237: aload_1
    //   238: aload 11
    //   240: invokevirtual 113	java/io/InputStream:read	([B)I
    //   243: pop
    //   244: aload_0
    //   245: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   248: astore_1
    //   249: aload 11
    //   251: arraylength
    //   252: istore 6
    //   254: iconst_0
    //   255: istore 5
    //   257: iload 5
    //   259: iload 6
    //   261: if_icmpge +26 -> 287
    //   264: aload_1
    //   265: iload 4
    //   267: iload 5
    //   269: iadd
    //   270: aload 11
    //   272: iconst_0
    //   273: iload 5
    //   275: iadd
    //   276: baload
    //   277: bastore
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -27 -> 257
    //   287: iconst_1
    //   288: ireturn
    //   289: astore_1
    //   290: iconst_0
    //   291: ireturn
    //   292: astore_1
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_1
    //   296: iconst_0
    //   297: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	c
    //   0	298	1	paramInputStream	java.io.InputStream
    //   0	298	2	paramLong	long
    //   123	147	4	i	int
    //   22	261	5	j	int
    //   90	172	6	k	int
    //   33	18	7	l1	long
    //   28	21	9	l2	long
    //   4	267	11	arrayOfByte1	byte[]
    //   10	130	12	localObject	Object
    //   120	13	13	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   106	116	289	java/lang/Exception
    //   179	186	292	java/lang/Exception
    //   237	244	295	java/lang/Exception
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    try
    {
      paramArrayOfByte = new byte[8];
      a(paramArrayOfByte, this.c, 8);
      i = (int)(this.c[0] >>> 3) & 0x3F;
      if (i >= 56) {
        break label99;
      }
      i = 56 - i;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        continue;
        int i = 120 - i;
      }
    }
    a(a, i);
    a(paramArrayOfByte, 8);
    a(this.e, this.b, 16);
    return this.e;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)((paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 127	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_3
    //   15: ldc 132
    //   17: invokestatic 138	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 4
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +28 -> 54
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 113	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: istore_1
    //   37: iload_2
    //   38: ifle -14 -> 24
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 142	java/security/MessageDigest:update	([BII)V
    //   49: iload_2
    //   50: istore_1
    //   51: goto -27 -> 24
    //   54: aload 4
    //   56: invokevirtual 145	java/security/MessageDigest:digest	()[B
    //   59: invokestatic 148	com/tencent/apkupdate/b/c:c	([B)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_0
    //   64: invokevirtual 151	java/io/InputStream:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: astore_0
    //   76: goto +6 -> 82
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +7 -> 90
    //   86: aload_3
    //   87: invokevirtual 151	java/io/InputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 151	java/io/InputStream:close	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: goto -13 -> 92
    //   108: astore_3
    //   109: goto -15 -> 94
    //   112: astore_0
    //   113: aload_3
    //   114: areturn
    //   115: astore_3
    //   116: goto -26 -> 90
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   23	28	1	i	int
    //   34	16	2	j	int
    //   14	73	3	localObject1	Object
    //   108	6	3	localException1	java.lang.Exception
    //   115	1	3	localException2	java.lang.Exception
    //   20	35	4	localMessageDigest	java.security.MessageDigest
    //   69	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	69	finally
    //   29	35	69	finally
    //   41	49	69	finally
    //   54	63	69	finally
    //   0	9	79	finally
    //   0	9	104	java/lang/Exception
    //   9	22	108	java/lang/Exception
    //   29	35	108	java/lang/Exception
    //   41	49	108	java/lang/Exception
    //   54	63	108	java/lang/Exception
    //   63	67	112	java/lang/Exception
    //   86	90	115	java/lang/Exception
    //   98	102	119	java/lang/Exception
  }
  
  private void b(byte[] paramArrayOfByte)
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
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 ^ paramLong2 ^ paramLong4) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  private static String c(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str.toUpperCase();
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(((0xFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.c
 * JD-Core Version:    0.7.0.1
 */