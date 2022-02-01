package com.tencent.mobileqq;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class PicBusUtil
{
  public static boolean a(int paramInt)
  {
    return (paramInt >= 2000) || (paramInt == 3);
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 7
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 20	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 16
    //   28: aload 16
    //   30: invokevirtual 27	java/io/File:exists	()Z
    //   33: ifeq +461 -> 494
    //   36: aload_0
    //   37: invokestatic 32	com/tencent/mobileqq/utils/BaseImageUtil:e	(Ljava/lang/String;)Z
    //   40: ifne +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: invokestatic 36	com/tencent/mobileqq/utils/LogTag:a	()V
    //   48: aconst_null
    //   49: astore 9
    //   51: aconst_null
    //   52: astore 8
    //   54: aconst_null
    //   55: astore 11
    //   57: aconst_null
    //   58: astore 10
    //   60: aconst_null
    //   61: astore 14
    //   63: aconst_null
    //   64: astore 13
    //   66: aconst_null
    //   67: astore 12
    //   69: aconst_null
    //   70: astore 15
    //   72: new 38	java/io/FileInputStream
    //   75: dup
    //   76: aload 16
    //   78: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: astore_0
    //   82: aload 15
    //   84: astore 9
    //   86: aload 14
    //   88: astore 10
    //   90: aload 13
    //   92: astore 11
    //   94: aload_0
    //   95: invokevirtual 45	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   98: astore 8
    //   100: aload 8
    //   102: astore 9
    //   104: aload 8
    //   106: astore 10
    //   108: aload 8
    //   110: astore 11
    //   112: aload 8
    //   114: astore 12
    //   116: aload 8
    //   118: getstatic 51	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   121: lconst_0
    //   122: aload 8
    //   124: invokevirtual 57	java/nio/channels/FileChannel:size	()J
    //   127: invokevirtual 61	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   130: astore 13
    //   132: aload 8
    //   134: astore 9
    //   136: aload 8
    //   138: astore 10
    //   140: aload 8
    //   142: astore 11
    //   144: aload 8
    //   146: astore 12
    //   148: aload 8
    //   150: invokevirtual 57	java/nio/channels/FileChannel:size	()J
    //   153: l2i
    //   154: istore_3
    //   155: iconst_0
    //   156: istore_1
    //   157: iload 7
    //   159: istore 4
    //   161: iload_1
    //   162: iload_3
    //   163: if_icmpge +100 -> 263
    //   166: iload_1
    //   167: iconst_1
    //   168: iadd
    //   169: istore_2
    //   170: aload 8
    //   172: astore 9
    //   174: aload 8
    //   176: astore 10
    //   178: aload 8
    //   180: astore 11
    //   182: aload 8
    //   184: astore 12
    //   186: aload 13
    //   188: iload_1
    //   189: invokevirtual 67	java/nio/MappedByteBuffer:get	(I)B
    //   192: iconst_m1
    //   193: if_icmpne +65 -> 258
    //   196: iload_2
    //   197: iload_3
    //   198: if_icmpge +60 -> 258
    //   201: iload_2
    //   202: iconst_1
    //   203: iadd
    //   204: istore_1
    //   205: aload 8
    //   207: astore 9
    //   209: aload 8
    //   211: astore 10
    //   213: aload 8
    //   215: astore 11
    //   217: aload 8
    //   219: astore 12
    //   221: aload 13
    //   223: iload_2
    //   224: invokevirtual 67	java/nio/MappedByteBuffer:get	(I)B
    //   227: istore_2
    //   228: iload_2
    //   229: bipush 194
    //   231: if_icmpeq +21 -> 252
    //   234: iload_2
    //   235: bipush 198
    //   237: if_icmpeq +15 -> 252
    //   240: iload_2
    //   241: bipush 202
    //   243: if_icmpeq +9 -> 252
    //   246: iload_2
    //   247: bipush 206
    //   249: if_icmpne -92 -> 157
    //   252: iconst_1
    //   253: istore 4
    //   255: goto +8 -> 263
    //   258: iload_2
    //   259: istore_1
    //   260: goto -103 -> 157
    //   263: aload 8
    //   265: ifnull +18 -> 283
    //   268: aload 8
    //   270: invokevirtual 70	java/nio/channels/FileChannel:close	()V
    //   273: goto +10 -> 283
    //   276: astore 8
    //   278: aload 8
    //   280: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   283: iload 4
    //   285: istore 5
    //   287: aload_0
    //   288: invokevirtual 74	java/io/FileInputStream:close	()V
    //   291: goto +196 -> 487
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   299: iload 5
    //   301: istore 4
    //   303: goto +184 -> 487
    //   306: astore 8
    //   308: goto +16 -> 324
    //   311: goto +58 -> 369
    //   314: goto +96 -> 410
    //   317: goto +134 -> 451
    //   320: astore 8
    //   322: aconst_null
    //   323: astore_0
    //   324: aload 9
    //   326: ifnull +18 -> 344
    //   329: aload 9
    //   331: invokevirtual 70	java/nio/channels/FileChannel:close	()V
    //   334: goto +10 -> 344
    //   337: astore 9
    //   339: aload 9
    //   341: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   344: aload_0
    //   345: ifnull +15 -> 360
    //   348: aload_0
    //   349: invokevirtual 74	java/io/FileInputStream:close	()V
    //   352: goto +8 -> 360
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   360: aload 8
    //   362: athrow
    //   363: aconst_null
    //   364: astore_0
    //   365: aload 8
    //   367: astore 12
    //   369: aload 12
    //   371: ifnull +18 -> 389
    //   374: aload 12
    //   376: invokevirtual 70	java/nio/channels/FileChannel:close	()V
    //   379: goto +10 -> 389
    //   382: astore 8
    //   384: aload 8
    //   386: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   389: iload 6
    //   391: istore 4
    //   393: aload_0
    //   394: ifnull +93 -> 487
    //   397: aload_0
    //   398: invokevirtual 74	java/io/FileInputStream:close	()V
    //   401: iload 6
    //   403: istore 4
    //   405: goto +82 -> 487
    //   408: aconst_null
    //   409: astore_0
    //   410: aload 11
    //   412: ifnull +18 -> 430
    //   415: aload 11
    //   417: invokevirtual 70	java/nio/channels/FileChannel:close	()V
    //   420: goto +10 -> 430
    //   423: astore 8
    //   425: aload 8
    //   427: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   430: iload 6
    //   432: istore 4
    //   434: aload_0
    //   435: ifnull +52 -> 487
    //   438: aload_0
    //   439: invokevirtual 74	java/io/FileInputStream:close	()V
    //   442: iload 6
    //   444: istore 4
    //   446: goto +41 -> 487
    //   449: aconst_null
    //   450: astore_0
    //   451: aload 10
    //   453: ifnull +18 -> 471
    //   456: aload 10
    //   458: invokevirtual 70	java/nio/channels/FileChannel:close	()V
    //   461: goto +10 -> 471
    //   464: astore 8
    //   466: aload 8
    //   468: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   471: iload 6
    //   473: istore 4
    //   475: aload_0
    //   476: ifnull +11 -> 487
    //   479: aload_0
    //   480: invokevirtual 74	java/io/FileInputStream:close	()V
    //   483: iload 6
    //   485: istore 4
    //   487: ldc 76
    //   489: ldc 78
    //   491: invokestatic 81	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: iload 4
    //   496: ireturn
    //   497: astore_0
    //   498: goto -49 -> 449
    //   501: astore_0
    //   502: goto -94 -> 408
    //   505: astore_0
    //   506: goto -143 -> 363
    //   509: astore 8
    //   511: goto -194 -> 317
    //   514: astore 8
    //   516: goto -202 -> 314
    //   519: astore 8
    //   521: goto -210 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	paramString	String
    //   156	104	1	i	int
    //   169	90	2	j	int
    //   154	45	3	k	int
    //   7	488	4	bool1	boolean
    //   1	299	5	bool2	boolean
    //   4	480	6	bool3	boolean
    //   10	148	7	bool4	boolean
    //   52	217	8	localFileChannel	java.nio.channels.FileChannel
    //   276	3	8	localIOException1	java.io.IOException
    //   306	1	8	localObject1	Object
    //   320	46	8	localObject2	Object
    //   382	3	8	localIOException2	java.io.IOException
    //   423	3	8	localIOException3	java.io.IOException
    //   464	3	8	localIOException4	java.io.IOException
    //   509	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   514	1	8	localIOException5	java.io.IOException
    //   519	1	8	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   49	281	9	localObject3	Object
    //   337	3	9	localIOException6	java.io.IOException
    //   58	399	10	localObject4	Object
    //   55	361	11	localObject5	Object
    //   67	308	12	localObject6	Object
    //   64	158	13	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   61	26	14	localObject7	Object
    //   70	13	15	localObject8	Object
    //   26	51	16	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   268	273	276	java/io/IOException
    //   287	291	294	java/io/IOException
    //   397	401	294	java/io/IOException
    //   438	442	294	java/io/IOException
    //   479	483	294	java/io/IOException
    //   94	100	306	finally
    //   116	132	306	finally
    //   148	155	306	finally
    //   186	196	306	finally
    //   221	228	306	finally
    //   72	82	320	finally
    //   329	334	337	java/io/IOException
    //   348	352	355	java/io/IOException
    //   374	379	382	java/io/IOException
    //   415	420	423	java/io/IOException
    //   456	461	464	java/io/IOException
    //   72	82	497	java/io/FileNotFoundException
    //   72	82	501	java/io/IOException
    //   72	82	505	java/lang/IndexOutOfBoundsException
    //   94	100	509	java/io/FileNotFoundException
    //   116	132	509	java/io/FileNotFoundException
    //   148	155	509	java/io/FileNotFoundException
    //   186	196	509	java/io/FileNotFoundException
    //   221	228	509	java/io/FileNotFoundException
    //   94	100	514	java/io/IOException
    //   116	132	514	java/io/IOException
    //   148	155	514	java/io/IOException
    //   186	196	514	java/io/IOException
    //   221	228	514	java/io/IOException
    //   94	100	519	java/lang/IndexOutOfBoundsException
    //   116	132	519	java/lang/IndexOutOfBoundsException
    //   148	155	519	java/lang/IndexOutOfBoundsException
    //   186	196	519	java/lang/IndexOutOfBoundsException
    //   221	228	519	java/lang/IndexOutOfBoundsException
  }
  
  /* Error */
  public static java.util.ArrayList<java.lang.Integer> b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 20	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 27	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 36	com/tencent/mobileqq/utils/LogTag:a	()V
    //   33: new 85	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: aload_0
    //   38: invokevirtual 88	java/io/File:length	()J
    //   41: l2i
    //   42: invokespecial 91	java/io/ByteArrayOutputStream:<init>	(I)V
    //   45: astore 7
    //   47: iconst_0
    //   48: istore_2
    //   49: new 93	java/io/BufferedInputStream
    //   52: dup
    //   53: new 38	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 96	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore 4
    //   66: aload 4
    //   68: astore_0
    //   69: sipush 1024
    //   72: newarray byte
    //   74: astore 5
    //   76: aload 4
    //   78: astore_0
    //   79: aload 4
    //   81: aload 5
    //   83: iconst_0
    //   84: sipush 1024
    //   87: invokevirtual 100	java/io/BufferedInputStream:read	([BII)I
    //   90: istore_1
    //   91: iconst_m1
    //   92: iload_1
    //   93: if_icmpeq +18 -> 111
    //   96: aload 4
    //   98: astore_0
    //   99: aload 7
    //   101: aload 5
    //   103: iconst_0
    //   104: iload_1
    //   105: invokevirtual 104	java/io/ByteArrayOutputStream:write	([BII)V
    //   108: goto -32 -> 76
    //   111: aload 4
    //   113: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   116: goto +8 -> 124
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   124: iconst_1
    //   125: istore_1
    //   126: goto +49 -> 175
    //   129: astore 5
    //   131: goto +16 -> 147
    //   134: astore_0
    //   135: aload 5
    //   137: astore 4
    //   139: goto +167 -> 306
    //   142: astore 5
    //   144: aconst_null
    //   145: astore 4
    //   147: aload 4
    //   149: astore_0
    //   150: aload 5
    //   152: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   155: aload 4
    //   157: ifnull +16 -> 173
    //   160: aload 4
    //   162: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   165: goto +8 -> 173
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   173: iconst_0
    //   174: istore_1
    //   175: aload 6
    //   177: astore_0
    //   178: iload_1
    //   179: ifeq +95 -> 274
    //   182: new 107	java/util/ArrayList
    //   185: dup
    //   186: bipush 10
    //   188: invokespecial 108	java/util/ArrayList:<init>	(I)V
    //   191: astore 4
    //   193: aload 7
    //   195: invokevirtual 112	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: astore 5
    //   200: aload 5
    //   202: arraylength
    //   203: istore_3
    //   204: iload_2
    //   205: istore_1
    //   206: aload 4
    //   208: astore_0
    //   209: iload_1
    //   210: iload_3
    //   211: if_icmpge +63 -> 274
    //   214: iload_1
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: aload 5
    //   220: iload_1
    //   221: baload
    //   222: iconst_m1
    //   223: if_icmpne +46 -> 269
    //   226: aload 5
    //   228: iload_2
    //   229: baload
    //   230: bipush 217
    //   232: if_icmpne +9 -> 241
    //   235: aload 4
    //   237: astore_0
    //   238: goto +36 -> 274
    //   241: aload 5
    //   243: iload_2
    //   244: baload
    //   245: bipush 218
    //   247: if_icmpne +22 -> 269
    //   250: aload 4
    //   252: iload_2
    //   253: iconst_1
    //   254: isub
    //   255: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: iload_2
    //   263: iconst_1
    //   264: iadd
    //   265: istore_1
    //   266: goto -60 -> 206
    //   269: iload_2
    //   270: istore_1
    //   271: goto -65 -> 206
    //   274: aload 7
    //   276: invokevirtual 123	java/io/ByteArrayOutputStream:close	()V
    //   279: goto +10 -> 289
    //   282: astore 4
    //   284: aload 4
    //   286: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   289: ldc 76
    //   291: ldc 125
    //   293: invokestatic 81	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: areturn
    //   298: astore 5
    //   300: aload_0
    //   301: astore 4
    //   303: aload 5
    //   305: astore_0
    //   306: aload 4
    //   308: ifnull +18 -> 326
    //   311: aload 4
    //   313: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   316: goto +10 -> 326
    //   319: astore 4
    //   321: aload 4
    //   323: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   326: goto +5 -> 331
    //   329: aload_0
    //   330: athrow
    //   331: goto -2 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramString	String
    //   90	181	1	i	int
    //   48	222	2	j	int
    //   203	9	3	k	int
    //   64	187	4	localObject1	Object
    //   282	3	4	localIOException1	java.io.IOException
    //   301	11	4	str	String
    //   319	3	4	localIOException2	java.io.IOException
    //   1	101	5	arrayOfByte1	byte[]
    //   129	7	5	localIOException3	java.io.IOException
    //   142	9	5	localIOException4	java.io.IOException
    //   198	44	5	arrayOfByte2	byte[]
    //   298	6	5	localObject2	Object
    //   4	172	6	localObject3	Object
    //   45	230	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   111	116	119	java/io/IOException
    //   69	76	129	java/io/IOException
    //   79	91	129	java/io/IOException
    //   99	108	129	java/io/IOException
    //   49	66	134	finally
    //   49	66	142	java/io/IOException
    //   160	165	168	java/io/IOException
    //   274	279	282	java/io/IOException
    //   69	76	298	finally
    //   79	91	298	finally
    //   99	108	298	finally
    //   150	155	298	finally
    //   311	316	319	java/io/IOException
  }
  
  public static int c(String paramString)
  {
    paramString = FileUtils.estimateFileType(paramString);
    int i;
    if ("jpg".equals(paramString)) {
      i = 1000;
    } else if ("png".equals(paramString)) {
      i = 1001;
    } else if ("bmp".equals(paramString)) {
      i = 1005;
    } else if ("gif".equals(paramString)) {
      i = 2000;
    } else if ("apng".equals(paramString)) {
      i = 2001;
    } else if ("sharpp".equals(paramString)) {
      i = 1004;
    } else if ("webp".equals(paramString)) {
      i = 1002;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sender imgType is ");
      paramString.append(i);
      QLog.i("ImgType", 2, paramString.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.PicBusUtil
 * JD-Core Version:    0.7.0.1
 */