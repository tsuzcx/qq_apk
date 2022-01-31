import com.dataline.activities.LiteActivity;
import java.io.InputStream;

public class bg
  implements Runnable
{
  public bg(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
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
    //   20: getfield 17	bg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 39	java/io/File:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 42	java/io/File:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   48: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   71: iconst_0
    //   72: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
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
    //   119: getfield 17	bg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   150: lstore 4
    //   152: aload 10
    //   154: astore 8
    //   156: aload 10
    //   158: astore 9
    //   160: aload_0
    //   161: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   164: aload 10
    //   166: invokevirtual 88	java/io/InputStream:read	([B)I
    //   169: istore_1
    //   170: iload_1
    //   171: iconst_m1
    //   172: if_icmpeq +126 -> 298
    //   175: aload 10
    //   177: astore 8
    //   179: aload 10
    //   181: astore 9
    //   183: aload_0
    //   184: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   187: invokestatic 91	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;)Z
    //   190: ifeq +108 -> 298
    //   193: lload 4
    //   195: iload_1
    //   196: i2l
    //   197: ladd
    //   198: lstore_2
    //   199: aload 10
    //   201: astore 8
    //   203: aload 10
    //   205: astore 9
    //   207: aload 11
    //   209: aload 10
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   216: lload_2
    //   217: lstore 4
    //   219: aload 10
    //   221: astore 8
    //   223: aload 10
    //   225: astore 9
    //   227: lload_2
    //   228: lload 6
    //   230: lsub
    //   231: l2d
    //   232: aload_0
    //   233: getfield 21	bg:jdField_a_of_type_Long	J
    //   236: l2d
    //   237: ddiv
    //   238: ldc2_w 96
    //   241: dcmpl
    //   242: ifle -90 -> 152
    //   245: aload 10
    //   247: astore 8
    //   249: aload 10
    //   251: astore 9
    //   253: aload_0
    //   254: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   257: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   260: aload_0
    //   261: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   264: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   267: iconst_3
    //   268: lload_2
    //   269: l2d
    //   270: aload_0
    //   271: getfield 21	bg:jdField_a_of_type_Long	J
    //   274: l2d
    //   275: ddiv
    //   276: ldc2_w 98
    //   279: dmul
    //   280: d2i
    //   281: iconst_0
    //   282: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   285: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   288: pop
    //   289: lload_2
    //   290: lstore 6
    //   292: lload_2
    //   293: lstore 4
    //   295: goto -143 -> 152
    //   298: lload 4
    //   300: lconst_0
    //   301: lcmp
    //   302: ifne +43 -> 345
    //   305: aload 10
    //   307: astore 8
    //   309: aload 10
    //   311: astore 9
    //   313: aload_0
    //   314: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   317: ldc 108
    //   319: invokevirtual 112	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   322: putstatic 115	com/dataline/activities/LiteActivity:c	Ljava/lang/String;
    //   325: aload 10
    //   327: astore 8
    //   329: aload 10
    //   331: astore 9
    //   333: aload_0
    //   334: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   337: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   340: iconst_1
    //   341: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   344: pop
    //   345: aload 10
    //   347: astore 8
    //   349: aload 10
    //   351: astore 9
    //   353: aload_0
    //   354: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   357: invokestatic 91	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;)Z
    //   360: ifeq +107 -> 467
    //   363: aload 10
    //   365: astore 8
    //   367: aload 10
    //   369: astore 9
    //   371: aload_0
    //   372: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   375: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   378: aload_0
    //   379: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   382: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   385: iconst_3
    //   386: bipush 100
    //   388: iconst_0
    //   389: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   392: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   395: pop
    //   396: aload 10
    //   398: astore 8
    //   400: aload 10
    //   402: astore 9
    //   404: aload_0
    //   405: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   408: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   411: iconst_2
    //   412: ldc2_w 116
    //   415: invokevirtual 121	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   418: pop
    //   419: aload 10
    //   421: ifnull +11 -> 432
    //   424: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   427: aload 10
    //   429: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   432: aload_0
    //   433: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   436: iconst_0
    //   437: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   440: pop
    //   441: aload_0
    //   442: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   445: invokevirtual 71	java/io/InputStream:close	()V
    //   448: aload 11
    //   450: ifnull -355 -> 95
    //   453: aload 11
    //   455: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   458: return
    //   459: astore 8
    //   461: aload 8
    //   463: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   466: return
    //   467: aload 10
    //   469: astore 8
    //   471: aload 10
    //   473: astore 9
    //   475: aload 11
    //   477: invokestatic 128	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   480: aload 10
    //   482: astore 8
    //   484: aload 10
    //   486: astore 9
    //   488: aload 14
    //   490: invokevirtual 131	java/io/File:delete	()Z
    //   493: pop
    //   494: goto -75 -> 419
    //   497: astore 12
    //   499: aload 11
    //   501: astore 10
    //   503: aload 8
    //   505: astore 9
    //   507: aload 12
    //   509: astore 8
    //   511: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +14 -> 528
    //   517: getstatic 137	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   520: iconst_2
    //   521: ldc 139
    //   523: aload 8
    //   525: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   528: aload_0
    //   529: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   532: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   535: iconst_1
    //   536: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   539: pop
    //   540: aload 9
    //   542: ifnull +11 -> 553
    //   545: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   548: aload 9
    //   550: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   553: aload_0
    //   554: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   557: iconst_0
    //   558: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   561: pop
    //   562: aload_0
    //   563: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   566: invokevirtual 71	java/io/InputStream:close	()V
    //   569: aload 10
    //   571: ifnull -476 -> 95
    //   574: aload 10
    //   576: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   579: return
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   587: return
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   595: goto -147 -> 448
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
    //   635: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   638: iconst_0
    //   639: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   642: pop
    //   643: aload_0
    //   644: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   647: invokevirtual 71	java/io/InputStream:close	()V
    //   650: aload 9
    //   652: ifnull +8 -> 660
    //   655: aload 9
    //   657: invokevirtual 122	java/io/FileOutputStream:close	()V
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
    //   715: goto -204 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	bg
    //   169	44	1	i	int
    //   198	95	2	l1	long
    //   150	149	4	l2	long
    //   147	144	6	l3	long
    //   7	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   129	270	8	localObject2	Object
    //   459	3	8	localIOException3	java.io.IOException
    //   469	55	8	localObject3	Object
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
    //   125	375	11	localFileOutputStream	java.io.FileOutputStream
    //   608	82	11	localObject11	Object
    //   700	7	11	localObject12	Object
    //   10	122	12	localObject13	Object
    //   497	11	12	localException2	java.lang.Exception
    //   13	115	13	localObject14	Object
    //   26	463	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   453	458	459	java/io/IOException
    //   135	146	497	java/lang/Exception
    //   160	170	497	java/lang/Exception
    //   183	193	497	java/lang/Exception
    //   207	216	497	java/lang/Exception
    //   227	245	497	java/lang/Exception
    //   253	289	497	java/lang/Exception
    //   313	325	497	java/lang/Exception
    //   333	345	497	java/lang/Exception
    //   353	363	497	java/lang/Exception
    //   371	396	497	java/lang/Exception
    //   404	419	497	java/lang/Exception
    //   475	480	497	java/lang/Exception
    //   488	494	497	java/lang/Exception
    //   574	579	580	java/io/IOException
    //   441	448	588	java/io/IOException
    //   562	569	598	java/io/IOException
    //   15	56	608	finally
    //   114	127	608	finally
    //   643	650	663	java/io/IOException
    //   655	660	673	java/io/IOException
    //   135	146	683	finally
    //   160	170	683	finally
    //   183	193	683	finally
    //   207	216	683	finally
    //   227	245	683	finally
    //   253	289	683	finally
    //   313	325	683	finally
    //   333	345	683	finally
    //   353	363	683	finally
    //   371	396	683	finally
    //   404	419	683	finally
    //   475	480	683	finally
    //   488	494	683	finally
    //   511	528	696	finally
    //   528	540	696	finally
    //   15	56	713	java/lang/Exception
    //   114	127	713	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bg
 * JD-Core Version:    0.7.0.1
 */