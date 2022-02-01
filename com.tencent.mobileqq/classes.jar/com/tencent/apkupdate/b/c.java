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
    paramLong1 = (paramLong2 & paramLong3 | (0xFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
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
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new c().a(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      paramString = new StringBuilder().append(paramString);
      int j = arrayOfByte[i];
      char[] arrayOfChar = new char[16];
      char[] tmp56_54 = arrayOfChar;
      tmp56_54[0] = 48;
      char[] tmp61_56 = tmp56_54;
      tmp61_56[1] = 49;
      char[] tmp66_61 = tmp61_56;
      tmp66_61[2] = 50;
      char[] tmp71_66 = tmp66_61;
      tmp71_66[3] = 51;
      char[] tmp76_71 = tmp71_66;
      tmp76_71[4] = 52;
      char[] tmp81_76 = tmp76_71;
      tmp81_76[5] = 53;
      char[] tmp86_81 = tmp81_76;
      tmp86_81[6] = 54;
      char[] tmp92_86 = tmp86_81;
      tmp92_86[7] = 55;
      char[] tmp98_92 = tmp92_86;
      tmp98_92[8] = 56;
      char[] tmp104_98 = tmp98_92;
      tmp104_98[9] = 57;
      char[] tmp110_104 = tmp104_98;
      tmp110_104[10] = 65;
      char[] tmp116_110 = tmp110_104;
      tmp116_110[11] = 66;
      char[] tmp122_116 = tmp116_110;
      tmp122_116[12] = 67;
      char[] tmp128_122 = tmp122_116;
      tmp128_122[13] = 68;
      char[] tmp134_128 = tmp128_122;
      tmp134_128[14] = 69;
      char[] tmp140_134 = tmp134_128;
      tmp140_134[15] = 70;
      tmp140_134;
      paramString = new String(new char[] { arrayOfChar[(j >>> 4 & 0xF)], arrayOfChar[(j & 0xF)] });
      i += 1;
    }
    return paramString;
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
      m = 0;
      j = i;
      i = m;
    }
    for (;;)
    {
      arrayOfByte = this.d;
      while (k < paramInt - j)
      {
        arrayOfByte[(i + k)] = paramArrayOfByte[(j + k)];
        k += 1;
      }
      m = 0;
      i = j;
      j = m;
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
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore 9
    //   6: aload_0
    //   7: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   10: iconst_0
    //   11: laload
    //   12: iconst_3
    //   13: lushr
    //   14: l2i
    //   15: bipush 63
    //   17: iand
    //   18: istore 5
    //   20: aload_0
    //   21: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   24: astore 10
    //   26: aload 10
    //   28: iconst_0
    //   29: laload
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: ladd
    //   34: lstore 7
    //   36: aload 10
    //   38: iconst_0
    //   39: lload 7
    //   41: lastore
    //   42: lload 7
    //   44: lload_2
    //   45: iconst_3
    //   46: lshl
    //   47: lcmp
    //   48: ifge +19 -> 67
    //   51: aload_0
    //   52: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   55: astore 10
    //   57: aload 10
    //   59: iconst_1
    //   60: aload 10
    //   62: iconst_1
    //   63: laload
    //   64: lconst_1
    //   65: ladd
    //   66: lastore
    //   67: aload_0
    //   68: getfield 25	com/tencent/apkupdate/b/c:c	[J
    //   71: astore 10
    //   73: aload 10
    //   75: iconst_1
    //   76: aload 10
    //   78: iconst_1
    //   79: laload
    //   80: lload_2
    //   81: bipush 29
    //   83: lushr
    //   84: ladd
    //   85: lastore
    //   86: bipush 64
    //   88: iload 5
    //   90: isub
    //   91: istore 6
    //   93: lload_2
    //   94: iload 6
    //   96: i2l
    //   97: lcmp
    //   98: iflt +176 -> 274
    //   101: iload 6
    //   103: newarray byte
    //   105: astore 10
    //   107: aload_1
    //   108: aload 10
    //   110: iconst_0
    //   111: iload 6
    //   113: invokevirtual 110	java/io/InputStream:read	([BII)I
    //   116: pop
    //   117: aload_0
    //   118: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   121: astore 11
    //   123: iconst_0
    //   124: istore 4
    //   126: iload 4
    //   128: iload 6
    //   130: if_icmpge +27 -> 157
    //   133: aload 11
    //   135: iload 5
    //   137: iload 4
    //   139: iadd
    //   140: aload 10
    //   142: iconst_0
    //   143: iload 4
    //   145: iadd
    //   146: baload
    //   147: bastore
    //   148: iload 4
    //   150: iconst_1
    //   151: iadd
    //   152: istore 4
    //   154: goto -28 -> 126
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   162: invokespecial 98	com/tencent/apkupdate/b/c:b	([B)V
    //   165: iload 6
    //   167: istore 4
    //   169: iload 4
    //   171: bipush 63
    //   173: iadd
    //   174: i2l
    //   175: lload_2
    //   176: lcmp
    //   177: ifge +26 -> 203
    //   180: aload_1
    //   181: aload 9
    //   183: invokevirtual 113	java/io/InputStream:read	([B)I
    //   186: pop
    //   187: aload_0
    //   188: aload 9
    //   190: invokespecial 98	com/tencent/apkupdate/b/c:b	([B)V
    //   193: iload 4
    //   195: bipush 64
    //   197: iadd
    //   198: istore 4
    //   200: goto -31 -> 169
    //   203: iconst_0
    //   204: istore 6
    //   206: iload 4
    //   208: istore 5
    //   210: iload 6
    //   212: istore 4
    //   214: lload_2
    //   215: iload 5
    //   217: i2l
    //   218: lsub
    //   219: l2i
    //   220: newarray byte
    //   222: astore 9
    //   224: aload_1
    //   225: aload 9
    //   227: invokevirtual 113	java/io/InputStream:read	([B)I
    //   230: pop
    //   231: aload_0
    //   232: getfield 27	com/tencent/apkupdate/b/c:d	[B
    //   235: astore_1
    //   236: aload 9
    //   238: arraylength
    //   239: istore 6
    //   241: iconst_0
    //   242: istore 5
    //   244: iload 5
    //   246: iload 6
    //   248: if_icmpge +40 -> 288
    //   251: aload_1
    //   252: iload 4
    //   254: iload 5
    //   256: iadd
    //   257: aload 9
    //   259: iconst_0
    //   260: iload 5
    //   262: iadd
    //   263: baload
    //   264: bastore
    //   265: iload 5
    //   267: iconst_1
    //   268: iadd
    //   269: istore 5
    //   271: goto -27 -> 244
    //   274: iconst_0
    //   275: istore 6
    //   277: iload 5
    //   279: istore 4
    //   281: iload 6
    //   283: istore 5
    //   285: goto -71 -> 214
    //   288: iconst_1
    //   289: ireturn
    //   290: astore_1
    //   291: iconst_0
    //   292: ireturn
    //   293: astore_1
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_1
    //   297: iconst_0
    //   298: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	c
    //   0	299	1	paramInputStream	java.io.InputStream
    //   0	299	2	paramLong	long
    //   124	156	4	i	int
    //   18	266	5	j	int
    //   91	191	6	k	int
    //   34	9	7	l	long
    //   4	254	9	arrayOfByte1	byte[]
    //   24	117	10	localObject	Object
    //   121	13	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	117	290	java/lang/Exception
    //   180	187	293	java/lang/Exception
    //   224	231	296	java/lang/Exception
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    for (;;)
    {
      try
      {
        paramArrayOfByte = new byte[8];
        a(paramArrayOfByte, this.c, 8);
        i = (int)(this.c[0] >>> 3) & 0x3F;
        if (i >= 56) {
          continue;
        }
        i = 56 - i;
        a(a, i);
        a(paramArrayOfByte, 8);
        a(this.e, this.b, 16);
      }
      catch (Throwable paramArrayOfByte)
      {
        int i;
        continue;
      }
      return this.e;
      i = 120 - i;
    }
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 127	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray byte
    //   16: astore_3
    //   17: ldc 132
    //   19: invokestatic 138	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore 4
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +39 -> 65
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
    //   54: astore_3
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 145	java/io/InputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: aload 4
    //   67: invokevirtual 148	java/security/MessageDigest:digest	()[B
    //   70: invokestatic 151	com/tencent/apkupdate/b/c:c	([B)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_0
    //   75: invokevirtual 145	java/io/InputStream:close	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_0
    //   81: aload_3
    //   82: areturn
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 145	java/io/InputStream:close	()V
    //   94: aload_3
    //   95: athrow
    //   96: astore_0
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: goto -6 -> 94
    //   103: astore_3
    //   104: goto -18 -> 86
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_0
    //   110: goto -55 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString	String
    //   1	50	1	i	int
    //   34	16	2	j	int
    //   16	28	3	arrayOfByte	byte[]
    //   54	1	3	localException	java.lang.Exception
    //   73	9	3	str	String
    //   83	12	3	localObject1	Object
    //   103	1	3	localObject2	Object
    //   22	44	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   11	24	54	java/lang/Exception
    //   29	35	54	java/lang/Exception
    //   41	49	54	java/lang/Exception
    //   65	74	54	java/lang/Exception
    //   74	78	80	java/lang/Exception
    //   2	11	83	finally
    //   59	63	96	java/lang/Exception
    //   90	94	99	java/lang/Exception
    //   11	24	103	finally
    //   29	35	103	finally
    //   41	49	103	finally
    //   65	74	103	finally
    //   2	11	107	java/lang/Exception
  }
  
  private void b(byte[] paramArrayOfByte)
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
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 ^ paramLong3 ^ paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static String c(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
    return str.toUpperCase();
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = ((0xFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.apkupdate.b.c
 * JD-Core Version:    0.7.0.1
 */