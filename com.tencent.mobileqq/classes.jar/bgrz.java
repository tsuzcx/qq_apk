public class bgrz
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private static final char[] jdField_a_of_type_ArrayOfChar = { 73, 69, 78, 68 };
  private static final char[] b = { 118, 80, 78, 103 };
  
  /* Error */
  public static boolean a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 6
    //   11: iload 6
    //   13: istore 4
    //   15: aload_0
    //   16: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +14 -> 33
    //   22: aload_1
    //   23: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +10 -> 36
    //   29: iload 6
    //   31: istore 4
    //   33: iload 4
    //   35: ireturn
    //   36: new 45	java/io/RandomAccessFile
    //   39: dup
    //   40: aload_0
    //   41: ldc 47
    //   43: invokespecial 51	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: astore_0
    //   47: new 53	java/io/FileOutputStream
    //   50: dup
    //   51: new 55	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore 7
    //   64: aload 7
    //   66: astore 9
    //   68: aload_0
    //   69: astore 8
    //   71: new 63	bgsb
    //   74: dup
    //   75: aconst_null
    //   76: invokespecial 66	bgsb:<init>	(Lbgsa;)V
    //   79: astore 10
    //   81: aload 7
    //   83: astore 9
    //   85: aload_0
    //   86: astore 8
    //   88: bipush 8
    //   90: newarray byte
    //   92: astore 11
    //   94: aload 7
    //   96: astore 9
    //   98: aload_0
    //   99: astore 8
    //   101: bipush 8
    //   103: newarray byte
    //   105: astore 12
    //   107: aload 7
    //   109: astore 9
    //   111: aload_0
    //   112: astore 8
    //   114: aload_0
    //   115: aload 12
    //   117: iconst_0
    //   118: bipush 8
    //   120: invokevirtual 70	java/io/RandomAccessFile:read	([BII)I
    //   123: ifle +25 -> 148
    //   126: aload 7
    //   128: astore 9
    //   130: aload_0
    //   131: astore 8
    //   133: getstatic 28	bgrz:jdField_a_of_type_ArrayOfByte	[B
    //   136: aload 12
    //   138: invokestatic 76	java/util/Arrays:equals	([B[B)Z
    //   141: istore 4
    //   143: iload 4
    //   145: ifne +61 -> 206
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   156: iload 6
    //   158: istore 4
    //   160: aload 7
    //   162: ifnull -129 -> 33
    //   165: aload 7
    //   167: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   184: goto -28 -> 156
    //   187: aload 7
    //   189: astore 9
    //   191: aload_0
    //   192: astore 8
    //   194: aload_0
    //   195: aload 10
    //   197: getfield 86	bgsb:jdField_a_of_type_Int	I
    //   200: iconst_4
    //   201: iadd
    //   202: invokevirtual 90	java/io/RandomAccessFile:skipBytes	(I)I
    //   205: pop
    //   206: aload 7
    //   208: astore 9
    //   210: aload_0
    //   211: astore 8
    //   213: aload_0
    //   214: aload 11
    //   216: iconst_0
    //   217: bipush 8
    //   219: invokevirtual 70	java/io/RandomAccessFile:read	([BII)I
    //   222: pop
    //   223: aload 7
    //   225: astore 9
    //   227: aload_0
    //   228: astore 8
    //   230: aload 10
    //   232: aload 11
    //   234: invokestatic 93	bgsb:a	(Lbgsb;[B)V
    //   237: aload 7
    //   239: astore 9
    //   241: aload_0
    //   242: astore 8
    //   244: getstatic 21	bgrz:b	[C
    //   247: aload 10
    //   249: getfield 94	bgsb:jdField_a_of_type_ArrayOfChar	[C
    //   252: invokestatic 97	java/util/Arrays:equals	([C[C)Z
    //   255: ifeq +107 -> 362
    //   258: aload 7
    //   260: astore 9
    //   262: aload_0
    //   263: astore 8
    //   265: aload 10
    //   267: getfield 86	bgsb:jdField_a_of_type_Int	I
    //   270: istore_2
    //   271: aload 7
    //   273: astore 9
    //   275: aload_0
    //   276: astore 8
    //   278: iload_2
    //   279: newarray byte
    //   281: astore 10
    //   283: aload 7
    //   285: astore 9
    //   287: aload_0
    //   288: astore 8
    //   290: aload_0
    //   291: aload 10
    //   293: iconst_0
    //   294: iload_2
    //   295: invokevirtual 70	java/io/RandomAccessFile:read	([BII)I
    //   298: pop
    //   299: aload 7
    //   301: astore 9
    //   303: aload_0
    //   304: astore 8
    //   306: aload 7
    //   308: aload 10
    //   310: iconst_0
    //   311: iload_2
    //   312: invokevirtual 101	java/io/FileOutputStream:write	([BII)V
    //   315: iconst_1
    //   316: istore 4
    //   318: aload_0
    //   319: ifnull +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   326: iload 4
    //   328: istore_3
    //   329: aload 7
    //   331: ifnull +11 -> 342
    //   334: aload 7
    //   336: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   339: iload 4
    //   341: istore_3
    //   342: iload_3
    //   343: istore 4
    //   345: iload_3
    //   346: ifne -313 -> 33
    //   349: new 55	java/io/File
    //   352: dup
    //   353: aload_1
    //   354: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: invokevirtual 104	java/io/File:deleteOnExit	()V
    //   360: iload_3
    //   361: ireturn
    //   362: aload 7
    //   364: astore 9
    //   366: aload_0
    //   367: astore 8
    //   369: getstatic 16	bgrz:jdField_a_of_type_ArrayOfChar	[C
    //   372: aload 10
    //   374: getfield 94	bgsb:jdField_a_of_type_ArrayOfChar	[C
    //   377: invokestatic 97	java/util/Arrays:equals	([C[C)Z
    //   380: istore 4
    //   382: iload 4
    //   384: ifeq -197 -> 187
    //   387: iload_3
    //   388: istore 4
    //   390: goto -72 -> 318
    //   393: astore_0
    //   394: aload_0
    //   395: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   398: goto -72 -> 326
    //   401: astore_0
    //   402: aload_0
    //   403: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   406: iload 4
    //   408: istore_3
    //   409: goto -67 -> 342
    //   412: astore 8
    //   414: aconst_null
    //   415: astore_0
    //   416: aload 8
    //   418: invokevirtual 105	java/io/FileNotFoundException:printStackTrace	()V
    //   421: aload 7
    //   423: ifnull +8 -> 431
    //   426: aload 7
    //   428: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   431: iload 5
    //   433: istore_3
    //   434: aload_0
    //   435: ifnull -93 -> 342
    //   438: aload_0
    //   439: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   442: iload 5
    //   444: istore_3
    //   445: goto -103 -> 342
    //   448: astore_0
    //   449: aload_0
    //   450: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   453: iload 5
    //   455: istore_3
    //   456: goto -114 -> 342
    //   459: astore 7
    //   461: aload 7
    //   463: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   466: goto -35 -> 431
    //   469: astore 10
    //   471: aconst_null
    //   472: astore 7
    //   474: aconst_null
    //   475: astore_0
    //   476: aload 7
    //   478: astore 9
    //   480: aload_0
    //   481: astore 8
    //   483: aload 10
    //   485: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   488: aload_0
    //   489: ifnull +7 -> 496
    //   492: aload_0
    //   493: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   496: iload 5
    //   498: istore_3
    //   499: aload 7
    //   501: ifnull -159 -> 342
    //   504: aload 7
    //   506: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   509: iload 5
    //   511: istore_3
    //   512: goto -170 -> 342
    //   515: astore_0
    //   516: aload_0
    //   517: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   520: iload 5
    //   522: istore_3
    //   523: goto -181 -> 342
    //   526: astore_0
    //   527: aload_0
    //   528: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   531: goto -35 -> 496
    //   534: astore_1
    //   535: aconst_null
    //   536: astore 7
    //   538: aconst_null
    //   539: astore_0
    //   540: aload_0
    //   541: ifnull +7 -> 548
    //   544: aload_0
    //   545: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   548: aload 7
    //   550: ifnull +8 -> 558
    //   553: aload 7
    //   555: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   558: aload_1
    //   559: athrow
    //   560: astore_0
    //   561: aload_0
    //   562: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   565: goto -17 -> 548
    //   568: astore_0
    //   569: aload_0
    //   570: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   573: goto -15 -> 558
    //   576: astore_1
    //   577: aconst_null
    //   578: astore 7
    //   580: goto -40 -> 540
    //   583: astore_1
    //   584: aload 9
    //   586: astore 7
    //   588: aload 8
    //   590: astore_0
    //   591: goto -51 -> 540
    //   594: astore_1
    //   595: aload 7
    //   597: astore 8
    //   599: aload_0
    //   600: astore 7
    //   602: aload 8
    //   604: astore_0
    //   605: goto -65 -> 540
    //   608: astore 10
    //   610: aconst_null
    //   611: astore 7
    //   613: goto -137 -> 476
    //   616: astore 10
    //   618: goto -142 -> 476
    //   621: astore 8
    //   623: aconst_null
    //   624: astore 9
    //   626: aload_0
    //   627: astore 7
    //   629: aload 9
    //   631: astore_0
    //   632: goto -216 -> 416
    //   635: astore 8
    //   637: aload_0
    //   638: astore 9
    //   640: aload 7
    //   642: astore_0
    //   643: aload 9
    //   645: astore 7
    //   647: goto -231 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	paramString1	java.lang.String
    //   0	650	1	paramString2	java.lang.String
    //   270	42	2	i	int
    //   4	519	3	bool1	boolean
    //   13	394	4	bool2	boolean
    //   6	515	5	bool3	boolean
    //   9	148	6	bool4	boolean
    //   1	426	7	localFileOutputStream	java.io.FileOutputStream
    //   459	3	7	localIOException1	java.io.IOException
    //   472	174	7	localObject1	Object
    //   69	299	8	str	java.lang.String
    //   412	5	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   481	122	8	localObject2	Object
    //   621	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   635	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   66	578	9	localObject3	Object
    //   79	294	10	localObject4	Object
    //   469	15	10	localIOException2	java.io.IOException
    //   608	1	10	localIOException3	java.io.IOException
    //   616	1	10	localIOException4	java.io.IOException
    //   92	141	11	arrayOfByte1	byte[]
    //   105	32	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   165	170	172	java/io/IOException
    //   152	156	179	java/io/IOException
    //   322	326	393	java/io/IOException
    //   334	339	401	java/io/IOException
    //   36	47	412	java/io/FileNotFoundException
    //   438	442	448	java/io/IOException
    //   426	431	459	java/io/IOException
    //   36	47	469	java/io/IOException
    //   504	509	515	java/io/IOException
    //   492	496	526	java/io/IOException
    //   36	47	534	finally
    //   544	548	560	java/io/IOException
    //   553	558	568	java/io/IOException
    //   47	64	576	finally
    //   71	81	583	finally
    //   88	94	583	finally
    //   101	107	583	finally
    //   114	126	583	finally
    //   133	143	583	finally
    //   194	206	583	finally
    //   213	223	583	finally
    //   230	237	583	finally
    //   244	258	583	finally
    //   265	271	583	finally
    //   278	283	583	finally
    //   290	299	583	finally
    //   306	315	583	finally
    //   369	382	583	finally
    //   483	488	583	finally
    //   416	421	594	finally
    //   47	64	608	java/io/IOException
    //   71	81	616	java/io/IOException
    //   88	94	616	java/io/IOException
    //   101	107	616	java/io/IOException
    //   114	126	616	java/io/IOException
    //   133	143	616	java/io/IOException
    //   194	206	616	java/io/IOException
    //   213	223	616	java/io/IOException
    //   230	237	616	java/io/IOException
    //   244	258	616	java/io/IOException
    //   265	271	616	java/io/IOException
    //   278	283	616	java/io/IOException
    //   290	299	616	java/io/IOException
    //   306	315	616	java/io/IOException
    //   369	382	616	java/io/IOException
    //   47	64	621	java/io/FileNotFoundException
    //   71	81	635	java/io/FileNotFoundException
    //   88	94	635	java/io/FileNotFoundException
    //   101	107	635	java/io/FileNotFoundException
    //   114	126	635	java/io/FileNotFoundException
    //   133	143	635	java/io/FileNotFoundException
    //   194	206	635	java/io/FileNotFoundException
    //   213	223	635	java/io/FileNotFoundException
    //   230	237	635	java/io/FileNotFoundException
    //   244	258	635	java/io/FileNotFoundException
    //   265	271	635	java/io/FileNotFoundException
    //   278	283	635	java/io/FileNotFoundException
    //   290	299	635	java/io/FileNotFoundException
    //   306	315	635	java/io/FileNotFoundException
    //   369	382	635	java/io/FileNotFoundException
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrz
 * JD-Core Version:    0.7.0.1
 */