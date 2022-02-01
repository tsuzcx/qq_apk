import java.io.RandomAccessFile;

public class bdsu
  extends bdtc
{
  protected RandomAccessFile a;
  protected byte[] a;
  
  public bdsu(bdsv parambdsv, bdzn parambdzn)
  {
    super(parambdsv, parambdzn);
  }
  
  /* Error */
  public java.lang.String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 21	bdsu:jdField_a_of_type_ArrayOfByte	[B
    //   7: arraylength
    //   8: aload_0
    //   9: getfield 24	bdsu:jdField_b_of_type_ArrayOfByte	[B
    //   12: arraylength
    //   13: iadd
    //   14: newarray byte
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 21	bdsu:jdField_a_of_type_ArrayOfByte	[B
    //   22: iconst_0
    //   23: aload 7
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 21	bdsu:jdField_a_of_type_ArrayOfByte	[B
    //   30: arraylength
    //   31: invokestatic 30	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   34: aload_0
    //   35: getfield 24	bdsu:jdField_b_of_type_ArrayOfByte	[B
    //   38: iconst_0
    //   39: aload 7
    //   41: aload_0
    //   42: getfield 21	bdsu:jdField_a_of_type_ArrayOfByte	[B
    //   45: arraylength
    //   46: aload_0
    //   47: getfield 24	bdsu:jdField_b_of_type_ArrayOfByte	[B
    //   50: arraylength
    //   51: invokestatic 30	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   54: new 32	java/lang/StringBuilder
    //   57: dup
    //   58: invokestatic 36	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   61: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload 7
    //   66: invokestatic 45	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   69: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 51
    //   74: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 12
    //   82: invokestatic 60	android/os/SystemClock:uptimeMillis	()J
    //   85: lstore_2
    //   86: new 62	java/io/File
    //   89: dup
    //   90: aload 12
    //   92: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: invokevirtual 67	java/io/File:delete	()Z
    //   98: pop
    //   99: new 62	java/io/File
    //   102: dup
    //   103: aload 12
    //   105: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 7
    //   110: aload 7
    //   112: invokevirtual 70	java/io/File:exists	()Z
    //   115: istore 6
    //   117: iload 6
    //   119: ifne +9 -> 128
    //   122: aload 7
    //   124: invokevirtual 73	java/io/File:createNewFile	()Z
    //   127: pop
    //   128: new 75	java/io/FileOutputStream
    //   131: dup
    //   132: aload 7
    //   134: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: astore 7
    //   139: new 80	java/io/BufferedOutputStream
    //   142: dup
    //   143: aload 7
    //   145: invokespecial 83	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   148: astore 9
    //   150: aload 7
    //   152: astore 10
    //   154: aload 9
    //   156: astore 8
    //   158: aload_0
    //   159: getfield 85	bdsu:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   162: invokevirtual 90	java/io/RandomAccessFile:length	()J
    //   165: l2i
    //   166: newarray byte
    //   168: astore 11
    //   170: aload 7
    //   172: astore 10
    //   174: aload 9
    //   176: astore 8
    //   178: aload_0
    //   179: getfield 85	bdsu:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   182: aload 11
    //   184: invokevirtual 94	java/io/RandomAccessFile:read	([B)I
    //   187: pop
    //   188: aload 7
    //   190: astore 10
    //   192: aload 9
    //   194: astore 8
    //   196: aload 9
    //   198: aload 11
    //   200: invokevirtual 98	java/io/BufferedOutputStream:write	([B)V
    //   203: aload 7
    //   205: astore 10
    //   207: aload 9
    //   209: astore 8
    //   211: ldc 99
    //   213: newarray byte
    //   215: astore 11
    //   217: aload 7
    //   219: astore 10
    //   221: aload 9
    //   223: astore 8
    //   225: aload_0
    //   226: getfield 101	bdsu:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   229: aload 11
    //   231: invokevirtual 94	java/io/RandomAccessFile:read	([B)I
    //   234: istore_1
    //   235: iload_1
    //   236: iconst_m1
    //   237: if_icmpeq +87 -> 324
    //   240: aload 7
    //   242: astore 10
    //   244: aload 9
    //   246: astore 8
    //   248: aload 9
    //   250: aload 11
    //   252: iconst_0
    //   253: iload_1
    //   254: invokevirtual 104	java/io/BufferedOutputStream:write	([BII)V
    //   257: goto -40 -> 217
    //   260: astore 10
    //   262: aload 9
    //   264: astore 8
    //   266: aload 10
    //   268: astore 9
    //   270: aload 9
    //   272: invokevirtual 108	java/io/FileNotFoundException:printStackTrace	()V
    //   275: aload 8
    //   277: ifnull +8 -> 285
    //   280: aload 8
    //   282: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   285: aload 7
    //   287: ifnull +8 -> 295
    //   290: aload 7
    //   292: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   295: aload 12
    //   297: areturn
    //   298: astore 9
    //   300: aload 9
    //   302: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   305: goto -177 -> 128
    //   308: astore 9
    //   310: aconst_null
    //   311: astore 10
    //   313: aload 8
    //   315: astore 7
    //   317: aload 10
    //   319: astore 8
    //   321: goto -51 -> 270
    //   324: aload 7
    //   326: astore 10
    //   328: aload 9
    //   330: astore 8
    //   332: invokestatic 60	android/os/SystemClock:uptimeMillis	()J
    //   335: lstore 4
    //   337: aload 7
    //   339: astore 10
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 116	bdsu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc 118
    //   351: lload 4
    //   353: lload_2
    //   354: lsub
    //   355: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   358: invokevirtual 130	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: aload 9
    //   364: ifnull +8 -> 372
    //   367: aload 9
    //   369: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   372: aload 7
    //   374: ifnull -79 -> 295
    //   377: aload 7
    //   379: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   382: aload 12
    //   384: areturn
    //   385: astore 7
    //   387: aload 7
    //   389: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   392: aload 12
    //   394: areturn
    //   395: astore 8
    //   397: aload 8
    //   399: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   402: goto -30 -> 372
    //   405: astore 8
    //   407: aload 8
    //   409: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   412: goto -127 -> 285
    //   415: astore 7
    //   417: aload 7
    //   419: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   422: aload 12
    //   424: areturn
    //   425: astore 11
    //   427: aconst_null
    //   428: astore 7
    //   430: aconst_null
    //   431: astore 9
    //   433: aload 7
    //   435: astore 10
    //   437: aload 9
    //   439: astore 8
    //   441: aload 11
    //   443: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   446: aload 9
    //   448: ifnull +8 -> 456
    //   451: aload 9
    //   453: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   456: aload 7
    //   458: ifnull -163 -> 295
    //   461: aload 7
    //   463: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   466: aload 12
    //   468: areturn
    //   469: astore 7
    //   471: aload 7
    //   473: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   476: aload 12
    //   478: areturn
    //   479: astore 8
    //   481: aload 8
    //   483: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   486: goto -30 -> 456
    //   489: astore 11
    //   491: aconst_null
    //   492: astore 7
    //   494: aconst_null
    //   495: astore 9
    //   497: aload 7
    //   499: astore 10
    //   501: aload 9
    //   503: astore 8
    //   505: aload 11
    //   507: invokevirtual 131	java/lang/OutOfMemoryError:printStackTrace	()V
    //   510: aload 9
    //   512: ifnull +8 -> 520
    //   515: aload 9
    //   517: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   520: aload 7
    //   522: ifnull -227 -> 295
    //   525: aload 7
    //   527: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   530: aload 12
    //   532: areturn
    //   533: astore 7
    //   535: aload 7
    //   537: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   540: aload 12
    //   542: areturn
    //   543: astore 8
    //   545: aload 8
    //   547: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   550: goto -30 -> 520
    //   553: astore 9
    //   555: aconst_null
    //   556: astore 7
    //   558: aconst_null
    //   559: astore 8
    //   561: aload 8
    //   563: ifnull +8 -> 571
    //   566: aload 8
    //   568: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   571: aload 7
    //   573: ifnull +8 -> 581
    //   576: aload 7
    //   578: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   581: aload 9
    //   583: athrow
    //   584: astore 8
    //   586: aload 8
    //   588: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   591: goto -20 -> 571
    //   594: astore 7
    //   596: aload 7
    //   598: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   601: goto -20 -> 581
    //   604: astore 9
    //   606: aconst_null
    //   607: astore 8
    //   609: goto -48 -> 561
    //   612: astore 9
    //   614: aload 10
    //   616: astore 7
    //   618: goto -57 -> 561
    //   621: astore 9
    //   623: goto -62 -> 561
    //   626: astore 11
    //   628: aconst_null
    //   629: astore 9
    //   631: goto -134 -> 497
    //   634: astore 11
    //   636: goto -139 -> 497
    //   639: astore 11
    //   641: aconst_null
    //   642: astore 9
    //   644: goto -211 -> 433
    //   647: astore 11
    //   649: goto -216 -> 433
    //   652: astore 9
    //   654: aconst_null
    //   655: astore 8
    //   657: goto -387 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	bdsu
    //   234	20	1	i	int
    //   85	269	2	l1	long
    //   335	17	4	l2	long
    //   115	3	6	bool	boolean
    //   16	362	7	localObject1	java.lang.Object
    //   385	3	7	localIOException1	java.io.IOException
    //   415	3	7	localIOException2	java.io.IOException
    //   428	34	7	localObject2	java.lang.Object
    //   469	3	7	localIOException3	java.io.IOException
    //   492	34	7	localObject3	java.lang.Object
    //   533	3	7	localIOException4	java.io.IOException
    //   556	21	7	localObject4	java.lang.Object
    //   594	3	7	localIOException5	java.io.IOException
    //   616	1	7	localObject5	java.lang.Object
    //   1	343	8	localObject6	java.lang.Object
    //   395	3	8	localIOException6	java.io.IOException
    //   405	3	8	localIOException7	java.io.IOException
    //   439	1	8	localObject7	java.lang.Object
    //   479	3	8	localIOException8	java.io.IOException
    //   503	1	8	localObject8	java.lang.Object
    //   543	3	8	localIOException9	java.io.IOException
    //   559	8	8	localObject9	java.lang.Object
    //   584	3	8	localIOException10	java.io.IOException
    //   607	49	8	localObject10	java.lang.Object
    //   148	123	9	localObject11	java.lang.Object
    //   298	3	9	localIOException11	java.io.IOException
    //   308	60	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   431	85	9	localObject12	java.lang.Object
    //   553	29	9	localObject13	java.lang.Object
    //   604	1	9	localObject14	java.lang.Object
    //   612	1	9	localObject15	java.lang.Object
    //   621	1	9	localObject16	java.lang.Object
    //   629	14	9	localObject17	java.lang.Object
    //   652	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   152	91	10	localObject18	java.lang.Object
    //   260	7	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   311	304	10	localObject19	java.lang.Object
    //   168	83	11	arrayOfByte	byte[]
    //   425	17	11	localIOException12	java.io.IOException
    //   489	17	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   626	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   634	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   639	1	11	localIOException13	java.io.IOException
    //   647	1	11	localIOException14	java.io.IOException
    //   80	461	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   158	170	260	java/io/FileNotFoundException
    //   178	188	260	java/io/FileNotFoundException
    //   196	203	260	java/io/FileNotFoundException
    //   211	217	260	java/io/FileNotFoundException
    //   225	235	260	java/io/FileNotFoundException
    //   248	257	260	java/io/FileNotFoundException
    //   332	337	260	java/io/FileNotFoundException
    //   345	362	260	java/io/FileNotFoundException
    //   122	128	298	java/io/IOException
    //   82	117	308	java/io/FileNotFoundException
    //   122	128	308	java/io/FileNotFoundException
    //   128	139	308	java/io/FileNotFoundException
    //   300	305	308	java/io/FileNotFoundException
    //   377	382	385	java/io/IOException
    //   367	372	395	java/io/IOException
    //   280	285	405	java/io/IOException
    //   290	295	415	java/io/IOException
    //   82	117	425	java/io/IOException
    //   128	139	425	java/io/IOException
    //   300	305	425	java/io/IOException
    //   461	466	469	java/io/IOException
    //   451	456	479	java/io/IOException
    //   82	117	489	java/lang/OutOfMemoryError
    //   122	128	489	java/lang/OutOfMemoryError
    //   128	139	489	java/lang/OutOfMemoryError
    //   300	305	489	java/lang/OutOfMemoryError
    //   525	530	533	java/io/IOException
    //   515	520	543	java/io/IOException
    //   82	117	553	finally
    //   122	128	553	finally
    //   128	139	553	finally
    //   300	305	553	finally
    //   566	571	584	java/io/IOException
    //   576	581	594	java/io/IOException
    //   139	150	604	finally
    //   158	170	612	finally
    //   178	188	612	finally
    //   196	203	612	finally
    //   211	217	612	finally
    //   225	235	612	finally
    //   248	257	612	finally
    //   332	337	612	finally
    //   345	362	612	finally
    //   441	446	612	finally
    //   505	510	612	finally
    //   270	275	621	finally
    //   139	150	626	java/lang/OutOfMemoryError
    //   158	170	634	java/lang/OutOfMemoryError
    //   178	188	634	java/lang/OutOfMemoryError
    //   196	203	634	java/lang/OutOfMemoryError
    //   211	217	634	java/lang/OutOfMemoryError
    //   225	235	634	java/lang/OutOfMemoryError
    //   248	257	634	java/lang/OutOfMemoryError
    //   332	337	634	java/lang/OutOfMemoryError
    //   345	362	634	java/lang/OutOfMemoryError
    //   139	150	639	java/io/IOException
    //   158	170	647	java/io/IOException
    //   178	188	647	java/io/IOException
    //   196	203	647	java/io/IOException
    //   211	217	647	java/io/IOException
    //   225	235	647	java/io/IOException
    //   248	257	647	java/io/IOException
    //   332	337	647	java/io/IOException
    //   345	362	647	java/io/IOException
    //   139	150	652	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsu
 * JD-Core Version:    0.7.0.1
 */