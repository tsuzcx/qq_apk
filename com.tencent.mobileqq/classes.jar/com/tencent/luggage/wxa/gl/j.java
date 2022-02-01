package com.tencent.luggage.wxa.gl;

public class j
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 14	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 18	java/util/zip/Deflater:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 21	java/util/zip/Deflater:reset	()V
    //   14: aload 4
    //   16: aload_0
    //   17: invokevirtual 25	java/util/zip/Deflater:setInput	([B)V
    //   20: aload 4
    //   22: invokevirtual 28	java/util/zip/Deflater:finish	()V
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore_2
    //   29: new 30	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: aload_0
    //   34: arraylength
    //   35: invokespecial 33	java/io/ByteArrayOutputStream:<init>	(I)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_2
    //   41: sipush 1024
    //   44: newarray byte
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload 4
    //   51: invokevirtual 37	java/util/zip/Deflater:finished	()Z
    //   54: ifne +20 -> 74
    //   57: aload_1
    //   58: astore_2
    //   59: aload_1
    //   60: aload_3
    //   61: iconst_0
    //   62: aload 4
    //   64: aload_3
    //   65: invokevirtual 41	java/util/zip/Deflater:deflate	([B)I
    //   68: invokevirtual 45	java/io/ByteArrayOutputStream:write	([BII)V
    //   71: goto -24 -> 47
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: invokevirtual 49	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: astore_3
    //   81: aload_1
    //   82: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_3
    //   86: astore_2
    //   87: goto +125 -> 212
    //   90: astore_0
    //   91: ldc 54
    //   93: aload_0
    //   94: ldc 56
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: astore_2
    //   105: goto +107 -> 212
    //   108: astore_0
    //   109: goto +110 -> 219
    //   112: goto +11 -> 123
    //   115: astore_3
    //   116: goto +52 -> 168
    //   119: astore_0
    //   120: goto +99 -> 219
    //   123: aload_1
    //   124: astore_2
    //   125: new 63	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_1
    //   134: astore_2
    //   135: aload_3
    //   136: ldc 66
    //   138: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: aload_0
    //   146: arraylength
    //   147: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_1
    //   152: astore_2
    //   153: new 10	java/lang/OutOfMemoryError
    //   156: dup
    //   157: aload_3
    //   158: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 80	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   164: athrow
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: astore_2
    //   170: ldc 54
    //   172: aload_3
    //   173: ldc 56
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: astore_2
    //   184: aload_1
    //   185: ifnull +27 -> 212
    //   188: aload_1
    //   189: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   192: aload_0
    //   193: astore_2
    //   194: goto +18 -> 212
    //   197: astore_1
    //   198: ldc 54
    //   200: aload_1
    //   201: ldc 56
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_0
    //   211: astore_2
    //   212: aload 4
    //   214: invokevirtual 83	java/util/zip/Deflater:end	()V
    //   217: aload_2
    //   218: areturn
    //   219: aload_2
    //   220: ifnull +23 -> 243
    //   223: aload_2
    //   224: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   227: goto +16 -> 243
    //   230: astore_1
    //   231: ldc 54
    //   233: aload_1
    //   234: ldc 56
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: goto +5 -> 248
    //   246: aload_0
    //   247: athrow
    //   248: goto -2 -> 246
    //   251: astore_1
    //   252: aload_3
    //   253: astore_1
    //   254: goto -131 -> 123
    //   257: astore_2
    //   258: goto -146 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramArrayOfByte	byte[]
    //   38	151	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   197	4	1	localIOException1	java.io.IOException
    //   230	4	1	localIOException2	java.io.IOException
    //   251	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   253	1	1	localException1	java.lang.Exception
    //   28	196	2	localObject	Object
    //   257	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   26	78	3	arrayOfByte	byte[]
    //   115	1	3	localException2	java.lang.Exception
    //   132	26	3	localStringBuilder	java.lang.StringBuilder
    //   165	88	3	localException3	java.lang.Exception
    //   7	206	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   81	85	90	java/io/IOException
    //   41	47	108	finally
    //   49	57	108	finally
    //   59	71	108	finally
    //   76	81	108	finally
    //   170	182	108	finally
    //   41	47	115	java/lang/Exception
    //   49	57	115	java/lang/Exception
    //   59	71	115	java/lang/Exception
    //   76	81	115	java/lang/Exception
    //   29	39	119	finally
    //   125	133	119	finally
    //   135	142	119	finally
    //   144	151	119	finally
    //   153	165	119	finally
    //   29	39	165	java/lang/Exception
    //   188	192	197	java/io/IOException
    //   223	227	230	java/io/IOException
    //   29	39	251	java/lang/OutOfMemoryError
    //   41	47	257	java/lang/OutOfMemoryError
    //   49	57	257	java/lang/OutOfMemoryError
    //   59	71	257	java/lang/OutOfMemoryError
    //   76	81	257	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 87	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 88	java/util/zip/Inflater:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 89	java/util/zip/Inflater:reset	()V
    //   12: aload_3
    //   13: aload_0
    //   14: invokevirtual 90	java/util/zip/Inflater:setInput	([B)V
    //   17: new 30	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: arraylength
    //   23: invokespecial 33	java/io/ByteArrayOutputStream:<init>	(I)V
    //   26: astore 4
    //   28: sipush 1024
    //   31: newarray byte
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 91	java/util/zip/Inflater:finished	()Z
    //   38: ifne +18 -> 56
    //   41: aload 4
    //   43: aload_1
    //   44: iconst_0
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 94	java/util/zip/Inflater:inflate	([B)I
    //   50: invokevirtual 45	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -19 -> 34
    //   56: aload 4
    //   58: invokevirtual 49	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   61: astore_2
    //   62: aload 4
    //   64: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   67: goto +16 -> 83
    //   70: astore_0
    //   71: ldc 54
    //   73: aload_0
    //   74: ldc 56
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: goto +41 -> 128
    //   90: astore_0
    //   91: goto +56 -> 147
    //   94: astore_1
    //   95: ldc 54
    //   97: aload_1
    //   98: ldc 96
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload 4
    //   109: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   112: goto +16 -> 128
    //   115: astore_2
    //   116: ldc 54
    //   118: aload_2
    //   119: ldc 56
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokevirtual 97	java/util/zip/Inflater:end	()V
    //   132: aload_1
    //   133: ifnonnull +5 -> 138
    //   136: aload_0
    //   137: areturn
    //   138: new 8	java/lang/Exception
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 100	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   146: athrow
    //   147: aload 4
    //   149: invokevirtual 52	java/io/ByteArrayOutputStream:close	()V
    //   152: goto +16 -> 168
    //   155: astore_1
    //   156: ldc 54
    //   158: aload_1
    //   159: ldc 56
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 61	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto +5 -> 173
    //   171: aload_0
    //   172: athrow
    //   173: goto -2 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramArrayOfByte	byte[]
    //   33	52	1	arrayOfByte1	byte[]
    //   94	49	1	localException	java.lang.Exception
    //   155	4	1	localIOException1	java.io.IOException
    //   61	25	2	arrayOfByte2	byte[]
    //   115	4	2	localIOException2	java.io.IOException
    //   7	122	3	localInflater	java.util.zip.Inflater
    //   26	122	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	67	70	java/io/IOException
    //   28	34	90	finally
    //   34	53	90	finally
    //   56	62	90	finally
    //   95	107	90	finally
    //   28	34	94	java/lang/Exception
    //   34	53	94	java/lang/Exception
    //   56	62	94	java/lang/Exception
    //   107	112	115	java/io/IOException
    //   147	152	155	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.j
 * JD-Core Version:    0.7.0.1
 */