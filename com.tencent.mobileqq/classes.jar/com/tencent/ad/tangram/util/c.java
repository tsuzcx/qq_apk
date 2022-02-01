package com.tencent.ad.tangram.util;

public final class c
{
  private static final String TAG = "AdZipUtil";
  
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +155 -> 156
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 19	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_3
    //   22: new 22	java/util/zip/GZIPOutputStream
    //   25: dup
    //   26: aload 4
    //   28: invokespecial 25	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual 29	java/util/zip/GZIPOutputStream:write	([B)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 32	java/util/zip/GZIPOutputStream:finish	()V
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   59: aload_0
    //   60: astore_1
    //   61: aload 4
    //   63: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: ldc 8
    //   71: ldc 42
    //   73: aload_0
    //   74: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_1
    //   78: areturn
    //   79: astore_0
    //   80: goto +49 -> 129
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: aload_1
    //   87: astore_2
    //   88: goto +12 -> 100
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: goto +35 -> 129
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: astore_1
    //   102: ldc 8
    //   104: ldc 42
    //   106: aload_2
    //   107: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_0
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: astore_1
    //   116: aload_0
    //   117: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   137: aload 4
    //   139: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   142: goto +12 -> 154
    //   145: astore_1
    //   146: ldc 8
    //   148: ldc 42
    //   150: aload_1
    //   151: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_0
    //   155: athrow
    //   156: aload_0
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramArrayOfByte	byte[]
    //   33	45	1	localObject1	Object
    //   83	4	1	localThrowable1	java.lang.Throwable
    //   93	41	1	localObject2	Object
    //   145	6	1	localThrowable2	java.lang.Throwable
    //   31	57	2	localObject3	Object
    //   97	10	2	localThrowable3	java.lang.Throwable
    //   21	100	3	localObject4	Object
    //   18	120	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   55	59	68	java/lang/Throwable
    //   61	66	68	java/lang/Throwable
    //   116	120	68	java/lang/Throwable
    //   122	127	68	java/lang/Throwable
    //   34	39	79	finally
    //   41	45	79	finally
    //   47	53	79	finally
    //   102	110	79	finally
    //   34	39	83	java/lang/Throwable
    //   41	45	83	java/lang/Throwable
    //   47	53	83	java/lang/Throwable
    //   22	32	91	finally
    //   22	32	97	java/lang/Throwable
    //   133	137	145	java/lang/Throwable
    //   137	142	145	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] decompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +211 -> 212
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 51	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 53	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore 5
    //   21: new 19	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 4
    //   33: new 55	java/util/zip/GZIPInputStream
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 58	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_2
    //   43: aload_2
    //   44: astore_0
    //   45: sipush 256
    //   48: newarray byte
    //   50: astore_3
    //   51: aload_2
    //   52: astore_0
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 62	java/util/zip/GZIPInputStream:read	([B)I
    //   58: istore_1
    //   59: iload_1
    //   60: iflt +16 -> 76
    //   63: aload_2
    //   64: astore_0
    //   65: aload 6
    //   67: aload_3
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual 65	java/io/ByteArrayOutputStream:write	([BII)V
    //   73: goto -22 -> 51
    //   76: aload_2
    //   77: astore_0
    //   78: aload 6
    //   80: invokevirtual 68	java/io/ByteArrayOutputStream:flush	()V
    //   83: aload_2
    //   84: astore_0
    //   85: aload 6
    //   87: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: astore_3
    //   91: aload_3
    //   92: astore_0
    //   93: aload_2
    //   94: invokevirtual 69	java/util/zip/GZIPInputStream:close	()V
    //   97: aload_3
    //   98: astore_0
    //   99: aload 5
    //   101: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   104: aload_3
    //   105: astore_0
    //   106: aload 6
    //   108: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_3
    //   112: areturn
    //   113: astore_2
    //   114: ldc 8
    //   116: ldc 72
    //   118: aload_2
    //   119: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: goto +55 -> 180
    //   128: astore_3
    //   129: goto +12 -> 141
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: goto +45 -> 180
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: astore_0
    //   143: ldc 8
    //   145: ldc 74
    //   147: aload_3
    //   148: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_2
    //   152: ifnull +10 -> 162
    //   155: aload 4
    //   157: astore_0
    //   158: aload_2
    //   159: invokevirtual 69	java/util/zip/GZIPInputStream:close	()V
    //   162: aload 4
    //   164: astore_0
    //   165: aload 5
    //   167: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   170: aload 4
    //   172: astore_0
    //   173: aload 6
    //   175: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 69	java/util/zip/GZIPInputStream:close	()V
    //   188: aload 5
    //   190: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   193: aload 6
    //   195: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   198: goto +12 -> 210
    //   201: astore_0
    //   202: ldc 8
    //   204: ldc 72
    //   206: aload_0
    //   207: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_2
    //   211: athrow
    //   212: aload_0
    //   213: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramArrayOfByte	byte[]
    //   58	12	1	i	int
    //   42	52	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   113	6	2	localThrowable1	java.lang.Throwable
    //   124	1	2	localObject1	Object
    //   132	1	2	localObject2	Object
    //   140	71	2	localObject3	Object
    //   50	62	3	arrayOfByte	byte[]
    //   128	1	3	localThrowable2	java.lang.Throwable
    //   138	10	3	localThrowable3	java.lang.Throwable
    //   31	140	4	localObject4	Object
    //   19	170	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   28	166	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   93	97	113	java/lang/Throwable
    //   99	104	113	java/lang/Throwable
    //   106	111	113	java/lang/Throwable
    //   158	162	113	java/lang/Throwable
    //   165	170	113	java/lang/Throwable
    //   173	178	113	java/lang/Throwable
    //   45	51	124	finally
    //   53	59	124	finally
    //   65	73	124	finally
    //   78	83	124	finally
    //   85	91	124	finally
    //   143	151	124	finally
    //   45	51	128	java/lang/Throwable
    //   53	59	128	java/lang/Throwable
    //   65	73	128	java/lang/Throwable
    //   78	83	128	java/lang/Throwable
    //   85	91	128	java/lang/Throwable
    //   33	43	132	finally
    //   33	43	138	java/lang/Throwable
    //   184	188	201	java/lang/Throwable
    //   188	198	201	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.c
 * JD-Core Version:    0.7.0.1
 */