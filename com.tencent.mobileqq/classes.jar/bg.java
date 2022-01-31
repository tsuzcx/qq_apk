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
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
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
    //   125: astore 10
    //   127: aload 13
    //   129: astore 9
    //   131: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: sipush 8192
    //   137: invokevirtual 84	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   140: astore 11
    //   142: lconst_0
    //   143: lstore 6
    //   145: lconst_0
    //   146: lstore 4
    //   148: aload 11
    //   150: astore 8
    //   152: aload 11
    //   154: astore 9
    //   156: aload_0
    //   157: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   160: aload 11
    //   162: invokevirtual 88	java/io/InputStream:read	([B)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +126 -> 294
    //   171: aload 11
    //   173: astore 8
    //   175: aload 11
    //   177: astore 9
    //   179: aload_0
    //   180: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   183: invokestatic 91	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;)Z
    //   186: ifeq +108 -> 294
    //   189: lload 4
    //   191: iload_1
    //   192: i2l
    //   193: ladd
    //   194: lstore_2
    //   195: aload 11
    //   197: astore 8
    //   199: aload 11
    //   201: astore 9
    //   203: aload 10
    //   205: aload 11
    //   207: iconst_0
    //   208: iload_1
    //   209: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   212: lload_2
    //   213: lstore 4
    //   215: aload 11
    //   217: astore 8
    //   219: aload 11
    //   221: astore 9
    //   223: lload_2
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 21	bg:jdField_a_of_type_Long	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 96
    //   237: dcmpl
    //   238: ifle -90 -> 148
    //   241: aload 11
    //   243: astore 8
    //   245: aload 11
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   253: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   256: aload_0
    //   257: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   260: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   263: iconst_3
    //   264: lload_2
    //   265: l2d
    //   266: aload_0
    //   267: getfield 21	bg:jdField_a_of_type_Long	J
    //   270: l2d
    //   271: ddiv
    //   272: ldc2_w 98
    //   275: dmul
    //   276: d2i
    //   277: iconst_0
    //   278: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   281: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   284: pop
    //   285: lload_2
    //   286: lstore 6
    //   288: lload_2
    //   289: lstore 4
    //   291: goto -143 -> 148
    //   294: lload 4
    //   296: lconst_0
    //   297: lcmp
    //   298: ifne +43 -> 341
    //   301: aload 11
    //   303: astore 8
    //   305: aload 11
    //   307: astore 9
    //   309: aload_0
    //   310: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   313: ldc 108
    //   315: invokevirtual 112	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   318: putstatic 115	com/dataline/activities/LiteActivity:c	Ljava/lang/String;
    //   321: aload 11
    //   323: astore 8
    //   325: aload 11
    //   327: astore 9
    //   329: aload_0
    //   330: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   333: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   336: iconst_1
    //   337: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   340: pop
    //   341: aload 11
    //   343: astore 8
    //   345: aload 11
    //   347: astore 9
    //   349: aload_0
    //   350: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   353: invokestatic 91	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;)Z
    //   356: ifeq +107 -> 463
    //   359: aload 11
    //   361: astore 8
    //   363: aload 11
    //   365: astore 9
    //   367: aload_0
    //   368: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   371: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   374: aload_0
    //   375: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   378: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   381: iconst_3
    //   382: bipush 100
    //   384: iconst_0
    //   385: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   388: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   391: pop
    //   392: aload 11
    //   394: astore 8
    //   396: aload 11
    //   398: astore 9
    //   400: aload_0
    //   401: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   404: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   407: iconst_2
    //   408: ldc2_w 116
    //   411: invokevirtual 121	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   414: pop
    //   415: aload 11
    //   417: ifnull +11 -> 428
    //   420: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   423: aload 11
    //   425: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   428: aload_0
    //   429: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   432: iconst_0
    //   433: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   436: pop
    //   437: aload_0
    //   438: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   441: invokevirtual 71	java/io/InputStream:close	()V
    //   444: aload 10
    //   446: ifnull -351 -> 95
    //   449: aload 10
    //   451: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   454: return
    //   455: astore 8
    //   457: aload 8
    //   459: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   462: return
    //   463: aload 11
    //   465: astore 8
    //   467: aload 11
    //   469: astore 9
    //   471: aload 10
    //   473: invokestatic 128	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   476: aload 11
    //   478: astore 8
    //   480: aload 11
    //   482: astore 9
    //   484: aload 14
    //   486: invokevirtual 131	java/io/File:delete	()Z
    //   489: pop
    //   490: goto -75 -> 415
    //   493: astore 11
    //   495: aload 8
    //   497: astore 9
    //   499: aload 11
    //   501: astore 8
    //   503: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +14 -> 520
    //   509: getstatic 137	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   512: iconst_2
    //   513: ldc 139
    //   515: aload 8
    //   517: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   524: getfield 47	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   527: iconst_1
    //   528: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   531: pop
    //   532: aload 9
    //   534: ifnull +11 -> 545
    //   537: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   540: aload 9
    //   542: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   545: aload_0
    //   546: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   549: iconst_0
    //   550: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   553: pop
    //   554: aload_0
    //   555: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   558: invokevirtual 71	java/io/InputStream:close	()V
    //   561: aload 10
    //   563: ifnull -468 -> 95
    //   566: aload 10
    //   568: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   571: return
    //   572: astore 8
    //   574: aload 8
    //   576: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   579: return
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   587: goto -143 -> 444
    //   590: astore 8
    //   592: aload 8
    //   594: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   597: goto -36 -> 561
    //   600: astore 8
    //   602: aconst_null
    //   603: astore 10
    //   605: aload 9
    //   607: ifnull +11 -> 618
    //   610: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   613: aload 9
    //   615: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   618: aload_0
    //   619: getfield 15	bg:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   622: iconst_0
    //   623: invokestatic 66	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   626: pop
    //   627: aload_0
    //   628: getfield 19	bg:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   631: invokevirtual 71	java/io/InputStream:close	()V
    //   634: aload 10
    //   636: ifnull +8 -> 644
    //   639: aload 10
    //   641: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   644: aload 8
    //   646: athrow
    //   647: astore 9
    //   649: aload 9
    //   651: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   654: goto -20 -> 634
    //   657: astore 9
    //   659: aload 9
    //   661: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   664: goto -20 -> 644
    //   667: astore 8
    //   669: goto -64 -> 605
    //   672: astore 8
    //   674: goto -69 -> 605
    //   677: astore 8
    //   679: aload 12
    //   681: astore 9
    //   683: aload 11
    //   685: astore 10
    //   687: goto -184 -> 503
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	bg
    //   165	44	1	i	int
    //   194	95	2	l1	long
    //   146	149	4	l2	long
    //   143	144	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   150	245	8	arrayOfByte1	byte[]
    //   455	3	8	localIOException3	java.io.IOException
    //   465	51	8	localObject2	Object
    //   572	3	8	localIOException4	java.io.IOException
    //   580	3	8	localIOException5	java.io.IOException
    //   590	3	8	localIOException6	java.io.IOException
    //   600	45	8	localObject3	Object
    //   667	1	8	localObject4	Object
    //   672	1	8	localObject5	Object
    //   677	1	8	localException1	java.lang.Exception
    //   7	607	9	localObject6	Object
    //   647	3	9	localIOException7	java.io.IOException
    //   657	3	9	localIOException8	java.io.IOException
    //   681	1	9	localObject7	Object
    //   125	561	10	localObject8	Object
    //   1	480	11	arrayOfByte2	byte[]
    //   493	191	11	localException2	java.lang.Exception
    //   4	676	12	localObject9	Object
    //   10	118	13	localObject10	Object
    //   26	459	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   449	454	455	java/io/IOException
    //   131	142	493	java/lang/Exception
    //   156	166	493	java/lang/Exception
    //   179	189	493	java/lang/Exception
    //   203	212	493	java/lang/Exception
    //   223	241	493	java/lang/Exception
    //   249	285	493	java/lang/Exception
    //   309	321	493	java/lang/Exception
    //   329	341	493	java/lang/Exception
    //   349	359	493	java/lang/Exception
    //   367	392	493	java/lang/Exception
    //   400	415	493	java/lang/Exception
    //   471	476	493	java/lang/Exception
    //   484	490	493	java/lang/Exception
    //   566	571	572	java/io/IOException
    //   437	444	580	java/io/IOException
    //   554	561	590	java/io/IOException
    //   15	56	600	finally
    //   114	127	600	finally
    //   627	634	647	java/io/IOException
    //   639	644	657	java/io/IOException
    //   131	142	667	finally
    //   156	166	667	finally
    //   179	189	667	finally
    //   203	212	667	finally
    //   223	241	667	finally
    //   249	285	667	finally
    //   309	321	667	finally
    //   329	341	667	finally
    //   349	359	667	finally
    //   367	392	667	finally
    //   400	415	667	finally
    //   471	476	667	finally
    //   484	490	667	finally
    //   503	520	672	finally
    //   520	532	672	finally
    //   15	56	677	java/lang/Exception
    //   114	127	677	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bg
 * JD-Core Version:    0.7.0.1
 */