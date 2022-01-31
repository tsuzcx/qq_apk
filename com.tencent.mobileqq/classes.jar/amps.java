import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.InputStream;

public class amps
  implements Runnable
{
  public amps(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 13
    //   15: new 32	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 17	amps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 39	java/io/File:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 42	java/io/File:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   48: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   71: iconst_0
    //   72: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 19	amps:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   80: invokevirtual 71	java/io/InputStream:close	()V
    //   83: iconst_0
    //   84: ifeq +11 -> 95
    //   87: new 73	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: return
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   103: goto -20 -> 83
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: new 79	java/io/FileOutputStream
    //   117: dup
    //   118: aload_0
    //   119: getfield 17	amps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 11
    //   127: aload 13
    //   129: astore 8
    //   131: aload 12
    //   133: astore 9
    //   135: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   138: sipush 8192
    //   141: invokevirtual 84	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   144: astore 10
    //   146: lconst_0
    //   147: lstore 6
    //   149: lconst_0
    //   150: lstore_2
    //   151: aload 10
    //   153: astore 8
    //   155: aload 10
    //   157: astore 9
    //   159: aload_0
    //   160: getfield 19	amps:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   163: aload 10
    //   165: invokevirtual 88	java/io/InputStream:read	([B)I
    //   168: istore_1
    //   169: iload_1
    //   170: iconst_m1
    //   171: if_icmpeq +129 -> 300
    //   174: aload 10
    //   176: astore 8
    //   178: aload 10
    //   180: astore 9
    //   182: aload_0
    //   183: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   186: invokestatic 91	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   189: ifeq +111 -> 300
    //   192: lload_2
    //   193: iload_1
    //   194: i2l
    //   195: ladd
    //   196: lstore 4
    //   198: aload 10
    //   200: astore 8
    //   202: aload 10
    //   204: astore 9
    //   206: aload 11
    //   208: aload 10
    //   210: iconst_0
    //   211: iload_1
    //   212: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   215: lload 4
    //   217: lstore_2
    //   218: aload 10
    //   220: astore 8
    //   222: aload 10
    //   224: astore 9
    //   226: lload 4
    //   228: lload 6
    //   230: lsub
    //   231: l2d
    //   232: aload_0
    //   233: getfield 21	amps:jdField_a_of_type_Long	J
    //   236: l2d
    //   237: ddiv
    //   238: ldc2_w 96
    //   241: dcmpl
    //   242: ifle -91 -> 151
    //   245: aload 10
    //   247: astore 8
    //   249: aload 10
    //   251: astore 9
    //   253: aload_0
    //   254: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   257: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   260: aload_0
    //   261: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   264: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   267: iconst_3
    //   268: lload 4
    //   270: l2d
    //   271: aload_0
    //   272: getfield 21	amps:jdField_a_of_type_Long	J
    //   275: l2d
    //   276: ddiv
    //   277: ldc2_w 98
    //   280: dmul
    //   281: d2i
    //   282: iconst_0
    //   283: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   286: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   289: pop
    //   290: lload 4
    //   292: lstore 6
    //   294: lload 4
    //   296: lstore_2
    //   297: goto -146 -> 151
    //   300: lload_2
    //   301: lconst_0
    //   302: lcmp
    //   303: ifne +43 -> 346
    //   306: aload 10
    //   308: astore 8
    //   310: aload 10
    //   312: astore 9
    //   314: aload_0
    //   315: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   318: ldc 108
    //   320: invokevirtual 112	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   323: putstatic 113	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   326: aload 10
    //   328: astore 8
    //   330: aload 10
    //   332: astore 9
    //   334: aload_0
    //   335: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   338: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   341: iconst_1
    //   342: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   345: pop
    //   346: aload 10
    //   348: astore 8
    //   350: aload 10
    //   352: astore 9
    //   354: aload_0
    //   355: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   358: invokestatic 91	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   361: ifeq +107 -> 468
    //   364: aload 10
    //   366: astore 8
    //   368: aload 10
    //   370: astore 9
    //   372: aload_0
    //   373: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   376: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   379: aload_0
    //   380: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   383: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   386: iconst_3
    //   387: bipush 100
    //   389: iconst_0
    //   390: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   393: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   396: pop
    //   397: aload 10
    //   399: astore 8
    //   401: aload 10
    //   403: astore 9
    //   405: aload_0
    //   406: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   409: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   412: iconst_2
    //   413: ldc2_w 114
    //   416: invokevirtual 119	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   419: pop
    //   420: aload 10
    //   422: ifnull +11 -> 433
    //   425: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   428: aload 10
    //   430: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   433: aload_0
    //   434: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   437: iconst_0
    //   438: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   441: pop
    //   442: aload_0
    //   443: getfield 19	amps:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   446: invokevirtual 71	java/io/InputStream:close	()V
    //   449: aload 11
    //   451: ifnull -356 -> 95
    //   454: aload 11
    //   456: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   459: return
    //   460: astore 8
    //   462: aload 8
    //   464: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   467: return
    //   468: aload 10
    //   470: astore 8
    //   472: aload 10
    //   474: astore 9
    //   476: aload 11
    //   478: invokestatic 126	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   481: aload 10
    //   483: astore 8
    //   485: aload 10
    //   487: astore 9
    //   489: aload 14
    //   491: invokevirtual 129	java/io/File:delete	()Z
    //   494: pop
    //   495: goto -75 -> 420
    //   498: astore 12
    //   500: aload 11
    //   502: astore 10
    //   504: aload 8
    //   506: astore 9
    //   508: aload 12
    //   510: astore 8
    //   512: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +13 -> 528
    //   518: ldc 136
    //   520: iconst_2
    //   521: ldc 138
    //   523: aload 8
    //   525: invokestatic 142	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   528: aload_0
    //   529: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   532: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   535: iconst_1
    //   536: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   539: pop
    //   540: aload 9
    //   542: ifnull +11 -> 553
    //   545: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   548: aload 9
    //   550: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   553: aload_0
    //   554: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   557: iconst_0
    //   558: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   561: pop
    //   562: aload_0
    //   563: getfield 19	amps:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   566: invokevirtual 71	java/io/InputStream:close	()V
    //   569: aload 10
    //   571: ifnull -476 -> 95
    //   574: aload 10
    //   576: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   579: return
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   587: return
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   595: goto -146 -> 449
    //   598: astore 8
    //   600: aload 8
    //   602: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   605: goto -36 -> 569
    //   608: astore 11
    //   610: aconst_null
    //   611: astore 9
    //   613: aload 8
    //   615: astore 10
    //   617: aload 11
    //   619: astore 8
    //   621: aload 10
    //   623: ifnull +11 -> 634
    //   626: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   629: aload 10
    //   631: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   634: aload_0
    //   635: getfield 15	amps:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   638: iconst_0
    //   639: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   642: pop
    //   643: aload_0
    //   644: getfield 19	amps:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   647: invokevirtual 71	java/io/InputStream:close	()V
    //   650: aload 9
    //   652: ifnull +8 -> 660
    //   655: aload 9
    //   657: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   660: aload 8
    //   662: athrow
    //   663: astore 10
    //   665: aload 10
    //   667: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   670: goto -20 -> 650
    //   673: astore 9
    //   675: aload 9
    //   677: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   680: goto -20 -> 660
    //   683: astore 8
    //   685: aload 9
    //   687: astore 10
    //   689: aload 11
    //   691: astore 9
    //   693: goto -72 -> 621
    //   696: astore 8
    //   698: aload 10
    //   700: astore 11
    //   702: aload 9
    //   704: astore 10
    //   706: aload 11
    //   708: astore 9
    //   710: goto -89 -> 621
    //   713: astore 8
    //   715: goto -203 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	amps
    //   168	44	1	i	int
    //   150	151	2	l1	long
    //   196	99	4	l2	long
    //   147	146	6	l3	long
    //   7	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   129	271	8	localObject2	Object
    //   460	3	8	localIOException3	java.io.IOException
    //   470	54	8	localObject3	Object
    //   580	3	8	localIOException4	java.io.IOException
    //   588	3	8	localIOException5	java.io.IOException
    //   598	16	8	localIOException6	java.io.IOException
    //   619	42	8	localObject4	Object
    //   683	1	8	localObject5	Object
    //   696	1	8	localObject6	Object
    //   713	1	8	localException1	java.lang.Exception
    //   4	652	9	localObject7	Object
    //   673	13	9	localIOException7	java.io.IOException
    //   691	18	9	localObject8	Object
    //   1	629	10	localObject9	Object
    //   663	3	10	localIOException8	java.io.IOException
    //   687	18	10	localObject10	Object
    //   125	376	11	localFileOutputStream	java.io.FileOutputStream
    //   608	82	11	localObject11	Object
    //   700	7	11	localObject12	Object
    //   10	122	12	localObject13	Object
    //   498	11	12	localException2	java.lang.Exception
    //   13	115	13	localObject14	Object
    //   26	464	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   454	459	460	java/io/IOException
    //   135	146	498	java/lang/Exception
    //   159	169	498	java/lang/Exception
    //   182	192	498	java/lang/Exception
    //   206	215	498	java/lang/Exception
    //   226	245	498	java/lang/Exception
    //   253	290	498	java/lang/Exception
    //   314	326	498	java/lang/Exception
    //   334	346	498	java/lang/Exception
    //   354	364	498	java/lang/Exception
    //   372	397	498	java/lang/Exception
    //   405	420	498	java/lang/Exception
    //   476	481	498	java/lang/Exception
    //   489	495	498	java/lang/Exception
    //   574	579	580	java/io/IOException
    //   442	449	588	java/io/IOException
    //   562	569	598	java/io/IOException
    //   15	56	608	finally
    //   114	127	608	finally
    //   643	650	663	java/io/IOException
    //   655	660	673	java/io/IOException
    //   135	146	683	finally
    //   159	169	683	finally
    //   182	192	683	finally
    //   206	215	683	finally
    //   226	245	683	finally
    //   253	290	683	finally
    //   314	326	683	finally
    //   334	346	683	finally
    //   354	364	683	finally
    //   372	397	683	finally
    //   405	420	683	finally
    //   476	481	683	finally
    //   489	495	683	finally
    //   512	528	696	finally
    //   528	540	696	finally
    //   15	56	713	java/lang/Exception
    //   114	127	713	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amps
 * JD-Core Version:    0.7.0.1
 */