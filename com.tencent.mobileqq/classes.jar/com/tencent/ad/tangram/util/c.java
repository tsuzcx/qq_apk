package com.tencent.ad.tangram.util;

public final class c
{
  private static final String TAG = "AdZipUtil";
  
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 19	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: new 22	java/util/zip/GZIPOutputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 25	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 29	java/util/zip/GZIPOutputStream:write	([B)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 32	java/util/zip/GZIPOutputStream:finish	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: astore_0
    //   51: aload_2
    //   52: ifnull +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   59: aload 4
    //   61: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: ldc 8
    //   69: ldc 42
    //   71: aload_1
    //   72: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_0
    //   76: areturn
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: astore_1
    //   82: ldc 8
    //   84: ldc 42
    //   86: aload_3
    //   87: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   98: aload 4
    //   100: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: ldc 8
    //   108: ldc 42
    //   110: aload_0
    //   111: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 39	java/util/zip/GZIPOutputStream:close	()V
    //   127: aload 4
    //   129: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_1
    //   135: ldc 8
    //   137: ldc 42
    //   139: aload_1
    //   140: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -11 -> 132
    //   146: astore_0
    //   147: goto -28 -> 119
    //   150: astore_3
    //   151: aload_2
    //   152: astore_0
    //   153: goto -73 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramArrayOfByte	byte[]
    //   31	14	1	localGZIPOutputStream1	java.util.zip.GZIPOutputStream
    //   66	6	1	localThrowable1	java.lang.Throwable
    //   81	43	1	arrayOfByte	byte[]
    //   134	6	1	localThrowable2	java.lang.Throwable
    //   29	123	2	localGZIPOutputStream2	java.util.zip.GZIPOutputStream
    //   77	10	3	localThrowable3	java.lang.Throwable
    //   150	1	3	localThrowable4	java.lang.Throwable
    //   18	110	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   55	59	66	java/lang/Throwable
    //   59	64	66	java/lang/Throwable
    //   20	30	77	java/lang/Throwable
    //   94	98	105	java/lang/Throwable
    //   98	103	105	java/lang/Throwable
    //   20	30	116	finally
    //   123	127	134	java/lang/Throwable
    //   127	132	134	java/lang/Throwable
    //   32	37	146	finally
    //   39	43	146	finally
    //   45	51	146	finally
    //   82	90	146	finally
    //   32	37	150	java/lang/Throwable
    //   39	43	150	java/lang/Throwable
    //   45	51	150	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] decompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 51	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 53	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore 4
    //   21: new 19	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   28: astore 5
    //   30: new 55	java/util/zip/GZIPInputStream
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 58	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_0
    //   42: sipush 256
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_2
    //   49: astore_0
    //   50: aload_2
    //   51: aload_3
    //   52: invokevirtual 62	java/util/zip/GZIPInputStream:read	([B)I
    //   55: istore_1
    //   56: iload_1
    //   57: iflt +58 -> 115
    //   60: aload_2
    //   61: astore_0
    //   62: aload 5
    //   64: aload_3
    //   65: iconst_0
    //   66: iload_1
    //   67: invokevirtual 65	java/io/ByteArrayOutputStream:write	([BII)V
    //   70: goto -22 -> 48
    //   73: astore_3
    //   74: aload_2
    //   75: astore_0
    //   76: ldc 8
    //   78: ldc 67
    //   80: aload_3
    //   81: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 68	java/util/zip/GZIPInputStream:close	()V
    //   92: aload 4
    //   94: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   97: aload 5
    //   99: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: ldc 8
    //   107: ldc 71
    //   109: aload_0
    //   110: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_2
    //   116: astore_0
    //   117: aload 5
    //   119: invokevirtual 74	java/io/ByteArrayOutputStream:flush	()V
    //   122: aload_2
    //   123: astore_0
    //   124: aload 5
    //   126: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 68	java/util/zip/GZIPInputStream:close	()V
    //   138: aload 4
    //   140: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   143: aload 5
    //   145: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   148: aload_3
    //   149: areturn
    //   150: astore_0
    //   151: ldc 8
    //   153: ldc 71
    //   155: aload_0
    //   156: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: aload_3
    //   160: areturn
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 68	java/util/zip/GZIPInputStream:close	()V
    //   172: aload 4
    //   174: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   177: aload 5
    //   179: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   182: aload_2
    //   183: athrow
    //   184: astore_0
    //   185: ldc 8
    //   187: ldc 71
    //   189: aload_0
    //   190: invokestatic 48	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -11 -> 182
    //   196: astore_2
    //   197: goto -33 -> 164
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -129 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramArrayOfByte	byte[]
    //   55	12	1	i	int
    //   39	96	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   161	22	2	localObject1	Object
    //   196	1	2	localObject2	Object
    //   202	1	2	localObject3	Object
    //   47	18	3	arrayOfByte1	byte[]
    //   73	8	3	localThrowable1	java.lang.Throwable
    //   129	31	3	arrayOfByte2	byte[]
    //   200	1	3	localThrowable2	java.lang.Throwable
    //   19	154	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   28	150	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	48	73	java/lang/Throwable
    //   50	56	73	java/lang/Throwable
    //   62	70	73	java/lang/Throwable
    //   117	122	73	java/lang/Throwable
    //   124	130	73	java/lang/Throwable
    //   88	92	104	java/lang/Throwable
    //   92	102	104	java/lang/Throwable
    //   134	138	150	java/lang/Throwable
    //   138	148	150	java/lang/Throwable
    //   30	40	161	finally
    //   168	172	184	java/lang/Throwable
    //   172	182	184	java/lang/Throwable
    //   42	48	196	finally
    //   50	56	196	finally
    //   62	70	196	finally
    //   76	84	196	finally
    //   117	122	196	finally
    //   124	130	196	finally
    //   30	40	200	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.c
 * JD-Core Version:    0.7.0.1
 */