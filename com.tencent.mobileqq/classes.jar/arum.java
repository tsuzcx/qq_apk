public class arum
{
  /* Error */
  public static byte[] a(com.tencent.mobileqq.data.MessageForFuDai paramMessageForFuDai)
  {
    // Byte code:
    //   0: new 12	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 16	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 18	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 21	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore 5
    //   20: aload_3
    //   21: astore 4
    //   23: aload_2
    //   24: aload_0
    //   25: invokestatic 27	com/tencent/mobileqq/data/MessageForFuDai:access$000	(Lcom/tencent/mobileqq/data/MessageForFuDai;)I
    //   28: invokevirtual 31	java/io/ObjectOutputStream:writeInt	(I)V
    //   31: aload_2
    //   32: astore 5
    //   34: aload_3
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 35	com/tencent/mobileqq/data/MessageForFuDai:hostUin	Ljava/lang/String;
    //   41: invokestatic 41	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   44: astore_1
    //   45: aload_2
    //   46: astore 5
    //   48: aload_3
    //   49: astore 4
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 45	java/lang/Long:longValue	()J
    //   56: invokevirtual 49	java/io/ObjectOutputStream:writeLong	(J)V
    //   59: aload_2
    //   60: astore 5
    //   62: aload_3
    //   63: astore 4
    //   65: aload_2
    //   66: aload_0
    //   67: getfield 52	com/tencent/mobileqq/data/MessageForFuDai:fdId	Ljava/lang/String;
    //   70: invokevirtual 56	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: astore 5
    //   76: aload_3
    //   77: astore 4
    //   79: aload_2
    //   80: aload_0
    //   81: getfield 60	com/tencent/mobileqq/data/MessageForFuDai:shareType	I
    //   84: invokevirtual 31	java/io/ObjectOutputStream:writeInt	(I)V
    //   87: aload_2
    //   88: astore 5
    //   90: aload_3
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 63	com/tencent/mobileqq/data/MessageForFuDai:targetId	Ljava/lang/String;
    //   97: invokestatic 41	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   100: astore_1
    //   101: aload_2
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 45	java/lang/Long:longValue	()J
    //   112: invokevirtual 49	java/io/ObjectOutputStream:writeLong	(J)V
    //   115: aload_2
    //   116: astore 5
    //   118: aload_3
    //   119: astore 4
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 66	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
    //   126: invokevirtual 56	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: astore 5
    //   132: aload_3
    //   133: astore 4
    //   135: aload_2
    //   136: aload_0
    //   137: getfield 69	com/tencent/mobileqq/data/MessageForFuDai:aioTails	Ljava/lang/String;
    //   140: invokevirtual 56	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: astore 5
    //   146: aload_3
    //   147: astore 4
    //   149: aload_2
    //   150: aload_0
    //   151: getfield 72	com/tencent/mobileqq/data/MessageForFuDai:busiId	I
    //   154: invokevirtual 31	java/io/ObjectOutputStream:writeInt	(I)V
    //   157: aload_2
    //   158: astore 5
    //   160: aload_3
    //   161: astore 4
    //   163: aload_2
    //   164: aload_0
    //   165: invokestatic 76	com/tencent/mobileqq/data/MessageForFuDai:access$100	(Lcom/tencent/mobileqq/data/MessageForFuDai;)Ljava/lang/String;
    //   168: invokevirtual 56	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   171: aload_2
    //   172: astore 5
    //   174: aload_3
    //   175: astore 4
    //   177: aload_2
    //   178: aload_0
    //   179: getfield 79	com/tencent/mobileqq/data/MessageForFuDai:expireTime	I
    //   182: invokevirtual 31	java/io/ObjectOutputStream:writeInt	(I)V
    //   185: aload_2
    //   186: astore 5
    //   188: aload_3
    //   189: astore 4
    //   191: aload_2
    //   192: aload_0
    //   193: getfield 82	com/tencent/mobileqq/data/MessageForFuDai:themeId	I
    //   196: invokevirtual 31	java/io/ObjectOutputStream:writeInt	(I)V
    //   199: aload_2
    //   200: astore 5
    //   202: aload_3
    //   203: astore 4
    //   205: aload_2
    //   206: invokevirtual 85	java/io/ObjectOutputStream:flush	()V
    //   209: aload_2
    //   210: astore 5
    //   212: aload_3
    //   213: astore 4
    //   215: aload_3
    //   216: invokevirtual 89	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   219: astore_0
    //   220: aload_2
    //   221: astore 5
    //   223: aload_3
    //   224: astore 4
    //   226: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +40 -> 269
    //   232: aload_2
    //   233: astore 5
    //   235: aload_3
    //   236: astore 4
    //   238: ldc 97
    //   240: iconst_2
    //   241: new 99	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   248: ldc 102
    //   250: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: arraylength
    //   255: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 111
    //   260: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 122	java/io/ObjectOutputStream:close	()V
    //   277: aload_0
    //   278: astore_1
    //   279: aload_3
    //   280: ifnull +9 -> 289
    //   283: aload_3
    //   284: invokevirtual 123	java/io/ByteArrayOutputStream:close	()V
    //   287: aload_0
    //   288: astore_1
    //   289: aload_1
    //   290: areturn
    //   291: astore_1
    //   292: aload_2
    //   293: astore 5
    //   295: aload_3
    //   296: astore 4
    //   298: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +233 -> 534
    //   304: aload_2
    //   305: astore 5
    //   307: aload_3
    //   308: astore 4
    //   310: ldc 97
    //   312: iconst_2
    //   313: ldc 125
    //   315: aload_1
    //   316: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: goto +215 -> 534
    //   322: astore_1
    //   323: aload_2
    //   324: astore 5
    //   326: aload_3
    //   327: astore 4
    //   329: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +18 -> 350
    //   335: aload_2
    //   336: astore 5
    //   338: aload_3
    //   339: astore 4
    //   341: ldc 97
    //   343: iconst_2
    //   344: ldc 131
    //   346: aload_1
    //   347: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   350: lconst_0
    //   351: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   354: astore_1
    //   355: goto -254 -> 101
    //   358: astore_1
    //   359: ldc 97
    //   361: iconst_1
    //   362: ldc 136
    //   364: aload_1
    //   365: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   368: goto -91 -> 277
    //   371: astore_1
    //   372: ldc 97
    //   374: iconst_1
    //   375: ldc 136
    //   377: aload_1
    //   378: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload_0
    //   382: areturn
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_2
    //   386: aconst_null
    //   387: astore_3
    //   388: aconst_null
    //   389: astore_0
    //   390: aload_2
    //   391: astore 5
    //   393: aload_3
    //   394: astore 4
    //   396: ldc 97
    //   398: iconst_1
    //   399: ldc 136
    //   401: aload_1
    //   402: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: aload_2
    //   406: ifnull +7 -> 413
    //   409: aload_2
    //   410: invokevirtual 122	java/io/ObjectOutputStream:close	()V
    //   413: aload_0
    //   414: astore_1
    //   415: aload_3
    //   416: ifnull -127 -> 289
    //   419: aload_3
    //   420: invokevirtual 123	java/io/ByteArrayOutputStream:close	()V
    //   423: aload_0
    //   424: areturn
    //   425: astore_1
    //   426: ldc 97
    //   428: iconst_1
    //   429: ldc 136
    //   431: aload_1
    //   432: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   435: aload_0
    //   436: areturn
    //   437: astore_1
    //   438: ldc 97
    //   440: iconst_1
    //   441: ldc 136
    //   443: aload_1
    //   444: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: goto -34 -> 413
    //   450: astore_0
    //   451: aconst_null
    //   452: astore 5
    //   454: aconst_null
    //   455: astore_3
    //   456: aload 5
    //   458: ifnull +8 -> 466
    //   461: aload 5
    //   463: invokevirtual 122	java/io/ObjectOutputStream:close	()V
    //   466: aload_3
    //   467: ifnull +7 -> 474
    //   470: aload_3
    //   471: invokevirtual 123	java/io/ByteArrayOutputStream:close	()V
    //   474: aload_0
    //   475: athrow
    //   476: astore_1
    //   477: ldc 97
    //   479: iconst_1
    //   480: ldc 136
    //   482: aload_1
    //   483: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: goto -20 -> 466
    //   489: astore_1
    //   490: ldc 97
    //   492: iconst_1
    //   493: ldc 136
    //   495: aload_1
    //   496: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   499: goto -25 -> 474
    //   502: astore_0
    //   503: aconst_null
    //   504: astore 5
    //   506: goto -50 -> 456
    //   509: astore_0
    //   510: aload 4
    //   512: astore_3
    //   513: goto -57 -> 456
    //   516: astore_1
    //   517: aconst_null
    //   518: astore_2
    //   519: aconst_null
    //   520: astore_0
    //   521: goto -131 -> 390
    //   524: astore_1
    //   525: aconst_null
    //   526: astore_0
    //   527: goto -137 -> 390
    //   530: astore_1
    //   531: goto -141 -> 390
    //   534: lconst_0
    //   535: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   538: astore_1
    //   539: goto -494 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	paramMessageForFuDai	com.tencent.mobileqq.data.MessageForFuDai
    //   44	246	1	localObject1	Object
    //   291	25	1	localException1	java.lang.Exception
    //   322	25	1	localException2	java.lang.Exception
    //   354	1	1	localLong1	java.lang.Long
    //   358	7	1	localIOException1	java.io.IOException
    //   371	7	1	localIOException2	java.io.IOException
    //   383	19	1	localException3	java.lang.Exception
    //   414	1	1	localMessageForFuDai	com.tencent.mobileqq.data.MessageForFuDai
    //   425	7	1	localIOException3	java.io.IOException
    //   437	7	1	localIOException4	java.io.IOException
    //   476	7	1	localIOException5	java.io.IOException
    //   489	7	1	localIOException6	java.io.IOException
    //   516	1	1	localException4	java.lang.Exception
    //   524	1	1	localException5	java.lang.Exception
    //   530	1	1	localException6	java.lang.Exception
    //   538	1	1	localLong2	java.lang.Long
    //   16	503	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   7	506	3	localObject2	Object
    //   21	490	4	localObject3	Object
    //   18	487	5	localObjectOutputStream2	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	45	291	java/lang/Exception
    //   93	101	322	java/lang/Exception
    //   273	277	358	java/io/IOException
    //   283	287	371	java/io/IOException
    //   0	8	383	java/lang/Exception
    //   419	423	425	java/io/IOException
    //   409	413	437	java/io/IOException
    //   0	8	450	finally
    //   461	466	476	java/io/IOException
    //   470	474	489	java/io/IOException
    //   8	17	502	finally
    //   23	31	509	finally
    //   37	45	509	finally
    //   51	59	509	finally
    //   65	73	509	finally
    //   79	87	509	finally
    //   93	101	509	finally
    //   107	115	509	finally
    //   121	129	509	finally
    //   135	143	509	finally
    //   149	157	509	finally
    //   163	171	509	finally
    //   177	185	509	finally
    //   191	199	509	finally
    //   205	209	509	finally
    //   215	220	509	finally
    //   226	232	509	finally
    //   238	269	509	finally
    //   298	304	509	finally
    //   310	319	509	finally
    //   329	335	509	finally
    //   341	350	509	finally
    //   396	405	509	finally
    //   8	17	516	java/lang/Exception
    //   23	31	524	java/lang/Exception
    //   51	59	524	java/lang/Exception
    //   65	73	524	java/lang/Exception
    //   79	87	524	java/lang/Exception
    //   107	115	524	java/lang/Exception
    //   121	129	524	java/lang/Exception
    //   135	143	524	java/lang/Exception
    //   149	157	524	java/lang/Exception
    //   163	171	524	java/lang/Exception
    //   177	185	524	java/lang/Exception
    //   191	199	524	java/lang/Exception
    //   205	209	524	java/lang/Exception
    //   215	220	524	java/lang/Exception
    //   298	304	524	java/lang/Exception
    //   310	319	524	java/lang/Exception
    //   329	335	524	java/lang/Exception
    //   341	350	524	java/lang/Exception
    //   226	232	530	java/lang/Exception
    //   238	269	530	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arum
 * JD-Core Version:    0.7.0.1
 */