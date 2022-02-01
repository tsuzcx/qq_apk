package com.tencent.mm.opensdk.diffdev.a;

public final class e
{
  /* Error */
  public static byte[] a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +701 -> 702
    //   4: aload_0
    //   5: invokevirtual 20	java/lang/String:length	()I
    //   8: ifne +6 -> 14
    //   11: goto +691 -> 702
    //   14: new 22	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 26	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 30	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 32	java/net/HttpURLConnection
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +20 -> 50
    //   33: ldc 34
    //   35: ldc 36
    //   37: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: ifnull +7 -> 48
    //   44: aload_0
    //   45: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: ldc 48
    //   53: invokevirtual 51	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: ldc 52
    //   59: invokevirtual 56	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   62: aload_0
    //   63: ldc 52
    //   65: invokevirtual 59	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   68: aload_0
    //   69: invokevirtual 62	java/net/HttpURLConnection:getResponseCode	()I
    //   72: sipush 300
    //   75: if_icmplt +20 -> 95
    //   78: ldc 34
    //   80: ldc 64
    //   82: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   93: aconst_null
    //   94: areturn
    //   95: aload_0
    //   96: invokevirtual 68	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   99: astore_2
    //   100: new 70	java/io/ByteArrayOutputStream
    //   103: dup
    //   104: invokespecial 72	java/io/ByteArrayOutputStream:<init>	()V
    //   107: astore_3
    //   108: sipush 1024
    //   111: newarray byte
    //   113: astore 4
    //   115: aload_2
    //   116: aload 4
    //   118: invokevirtual 78	java/io/InputStream:read	([B)I
    //   121: istore_1
    //   122: iload_1
    //   123: iconst_m1
    //   124: if_icmpeq +14 -> 138
    //   127: aload_3
    //   128: aload 4
    //   130: iconst_0
    //   131: iload_1
    //   132: invokevirtual 82	java/io/ByteArrayOutputStream:write	([BII)V
    //   135: goto -20 -> 115
    //   138: aload_3
    //   139: invokevirtual 86	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore 4
    //   144: ldc 34
    //   146: ldc 88
    //   148: invokestatic 91	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: ifnull +10 -> 162
    //   155: aload_0
    //   156: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   159: goto +3 -> 162
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 94	java/io/InputStream:close	()V
    //   170: aload_3
    //   171: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   174: aload 4
    //   176: areturn
    //   177: astore 5
    //   179: aload_3
    //   180: astore 4
    //   182: aload 5
    //   184: astore_3
    //   185: goto +49 -> 234
    //   188: astore 6
    //   190: aload_2
    //   191: astore 4
    //   193: aload_3
    //   194: astore 5
    //   196: aload_0
    //   197: astore 7
    //   199: goto +137 -> 336
    //   202: astore 6
    //   204: aload_2
    //   205: astore 4
    //   207: aload_3
    //   208: astore 5
    //   210: aload_0
    //   211: astore 7
    //   213: goto +233 -> 446
    //   216: astore 6
    //   218: aload_2
    //   219: astore 4
    //   221: aload_3
    //   222: astore 5
    //   224: aload_0
    //   225: astore 7
    //   227: goto +329 -> 556
    //   230: astore_3
    //   231: aconst_null
    //   232: astore 4
    //   234: aload_2
    //   235: astore 5
    //   237: aload_3
    //   238: astore_2
    //   239: aload 5
    //   241: astore_3
    //   242: aload_0
    //   243: astore 5
    //   245: goto +421 -> 666
    //   248: astore 6
    //   250: aconst_null
    //   251: astore 5
    //   253: aload_2
    //   254: astore 4
    //   256: aload_0
    //   257: astore 7
    //   259: goto +77 -> 336
    //   262: astore 6
    //   264: aconst_null
    //   265: astore 5
    //   267: aload_2
    //   268: astore 4
    //   270: aload_0
    //   271: astore 7
    //   273: goto +173 -> 446
    //   276: astore 6
    //   278: aconst_null
    //   279: astore 5
    //   281: aload_2
    //   282: astore 4
    //   284: aload_0
    //   285: astore 7
    //   287: goto +269 -> 556
    //   290: astore_2
    //   291: goto +21 -> 312
    //   294: astore 6
    //   296: goto +31 -> 327
    //   299: astore 6
    //   301: goto +136 -> 437
    //   304: astore 6
    //   306: goto +241 -> 547
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_0
    //   312: aconst_null
    //   313: astore_3
    //   314: aconst_null
    //   315: astore 4
    //   317: aload_0
    //   318: astore 5
    //   320: goto +346 -> 666
    //   323: astore 6
    //   325: aconst_null
    //   326: astore_0
    //   327: aconst_null
    //   328: astore 4
    //   330: aconst_null
    //   331: astore 5
    //   333: aload_0
    //   334: astore 7
    //   336: aload 4
    //   338: astore_0
    //   339: aload 5
    //   341: astore_2
    //   342: aload 7
    //   344: astore_3
    //   345: new 97	java/lang/StringBuilder
    //   348: dup
    //   349: ldc 99
    //   351: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: astore 8
    //   356: aload 4
    //   358: astore_0
    //   359: aload 5
    //   361: astore_2
    //   362: aload 7
    //   364: astore_3
    //   365: aload 8
    //   367: aload 6
    //   369: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   372: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 4
    //   378: astore_0
    //   379: aload 5
    //   381: astore_2
    //   382: aload 7
    //   384: astore_3
    //   385: ldc 34
    //   387: aload 8
    //   389: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 7
    //   397: ifnull +11 -> 408
    //   400: aload 7
    //   402: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   405: goto +3 -> 408
    //   408: aload 4
    //   410: ifnull +11 -> 421
    //   413: aload 4
    //   415: invokevirtual 94	java/io/InputStream:close	()V
    //   418: goto +3 -> 421
    //   421: aload 5
    //   423: ifnull +8 -> 431
    //   426: aload 5
    //   428: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   431: aconst_null
    //   432: areturn
    //   433: astore 6
    //   435: aconst_null
    //   436: astore_0
    //   437: aconst_null
    //   438: astore 4
    //   440: aconst_null
    //   441: astore 5
    //   443: aload_0
    //   444: astore 7
    //   446: aload 4
    //   448: astore_0
    //   449: aload 5
    //   451: astore_2
    //   452: aload 7
    //   454: astore_3
    //   455: new 97	java/lang/StringBuilder
    //   458: dup
    //   459: ldc 99
    //   461: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: astore 8
    //   466: aload 4
    //   468: astore_0
    //   469: aload 5
    //   471: astore_2
    //   472: aload 7
    //   474: astore_3
    //   475: aload 8
    //   477: aload 6
    //   479: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   482: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 4
    //   488: astore_0
    //   489: aload 5
    //   491: astore_2
    //   492: aload 7
    //   494: astore_3
    //   495: ldc 34
    //   497: aload 8
    //   499: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload 7
    //   507: ifnull +11 -> 518
    //   510: aload 7
    //   512: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   515: goto +3 -> 518
    //   518: aload 4
    //   520: ifnull +11 -> 531
    //   523: aload 4
    //   525: invokevirtual 94	java/io/InputStream:close	()V
    //   528: goto +3 -> 531
    //   531: aload 5
    //   533: ifnull +8 -> 541
    //   536: aload 5
    //   538: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   541: aconst_null
    //   542: areturn
    //   543: astore 6
    //   545: aconst_null
    //   546: astore_0
    //   547: aconst_null
    //   548: astore 4
    //   550: aconst_null
    //   551: astore 5
    //   553: aload_0
    //   554: astore 7
    //   556: aload 4
    //   558: astore_0
    //   559: aload 5
    //   561: astore_2
    //   562: aload 7
    //   564: astore_3
    //   565: new 97	java/lang/StringBuilder
    //   568: dup
    //   569: ldc 99
    //   571: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: astore 8
    //   576: aload 4
    //   578: astore_0
    //   579: aload 5
    //   581: astore_2
    //   582: aload 7
    //   584: astore_3
    //   585: aload 8
    //   587: aload 6
    //   589: invokevirtual 113	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   592: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 4
    //   598: astore_0
    //   599: aload 5
    //   601: astore_2
    //   602: aload 7
    //   604: astore_3
    //   605: ldc 34
    //   607: aload 8
    //   609: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload 7
    //   617: ifnull +11 -> 628
    //   620: aload 7
    //   622: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   625: goto +3 -> 628
    //   628: aload 4
    //   630: ifnull +11 -> 641
    //   633: aload 4
    //   635: invokevirtual 94	java/io/InputStream:close	()V
    //   638: goto +3 -> 641
    //   641: aload 5
    //   643: ifnull +8 -> 651
    //   646: aload 5
    //   648: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   651: aconst_null
    //   652: areturn
    //   653: astore 6
    //   655: aload_3
    //   656: astore 5
    //   658: aload_2
    //   659: astore 4
    //   661: aload_0
    //   662: astore_3
    //   663: aload 6
    //   665: astore_2
    //   666: aload 5
    //   668: ifnull +11 -> 679
    //   671: aload 5
    //   673: invokevirtual 46	java/net/HttpURLConnection:disconnect	()V
    //   676: goto +3 -> 679
    //   679: aload_3
    //   680: ifnull +10 -> 690
    //   683: aload_3
    //   684: invokevirtual 94	java/io/InputStream:close	()V
    //   687: goto +3 -> 690
    //   690: aload 4
    //   692: ifnull +8 -> 700
    //   695: aload 4
    //   697: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   700: aload_2
    //   701: athrow
    //   702: ldc 34
    //   704: ldc 115
    //   706: invokestatic 42	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   709: aconst_null
    //   710: areturn
    //   711: astore_0
    //   712: aconst_null
    //   713: areturn
    //   714: astore_0
    //   715: aconst_null
    //   716: areturn
    //   717: astore_0
    //   718: goto -556 -> 162
    //   721: astore_0
    //   722: goto -552 -> 170
    //   725: astore_0
    //   726: aload 4
    //   728: areturn
    //   729: astore_0
    //   730: goto -322 -> 408
    //   733: astore_0
    //   734: goto -313 -> 421
    //   737: astore_0
    //   738: aconst_null
    //   739: areturn
    //   740: astore_0
    //   741: goto -223 -> 518
    //   744: astore_0
    //   745: goto -214 -> 531
    //   748: astore_0
    //   749: aconst_null
    //   750: areturn
    //   751: astore_0
    //   752: goto -124 -> 628
    //   755: astore_0
    //   756: goto -115 -> 641
    //   759: astore_0
    //   760: aconst_null
    //   761: areturn
    //   762: astore_0
    //   763: goto -84 -> 679
    //   766: astore_0
    //   767: goto -77 -> 690
    //   770: astore_0
    //   771: goto -71 -> 700
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	paramString	java.lang.String
    //   121	11	1	i	int
    //   99	183	2	localObject1	Object
    //   290	1	2	localObject2	Object
    //   309	1	2	localObject3	Object
    //   341	360	2	localObject4	Object
    //   107	115	3	localObject5	Object
    //   230	8	3	localObject6	Object
    //   241	443	3	localObject7	Object
    //   113	614	4	localObject8	Object
    //   177	6	5	localObject9	Object
    //   194	478	5	localObject10	Object
    //   188	1	6	localException1	java.lang.Exception
    //   202	1	6	localIOException1	java.io.IOException
    //   216	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   248	1	6	localException2	java.lang.Exception
    //   262	1	6	localIOException2	java.io.IOException
    //   276	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   294	1	6	localException3	java.lang.Exception
    //   299	1	6	localIOException3	java.io.IOException
    //   304	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   323	45	6	localException4	java.lang.Exception
    //   433	45	6	localIOException4	java.io.IOException
    //   543	45	6	localMalformedURLException4	java.net.MalformedURLException
    //   653	11	6	localObject11	Object
    //   197	424	7	str	java.lang.String
    //   354	254	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   108	115	177	finally
    //   115	122	177	finally
    //   127	135	177	finally
    //   138	151	177	finally
    //   108	115	188	java/lang/Exception
    //   115	122	188	java/lang/Exception
    //   127	135	188	java/lang/Exception
    //   138	151	188	java/lang/Exception
    //   108	115	202	java/io/IOException
    //   115	122	202	java/io/IOException
    //   127	135	202	java/io/IOException
    //   138	151	202	java/io/IOException
    //   108	115	216	java/net/MalformedURLException
    //   115	122	216	java/net/MalformedURLException
    //   127	135	216	java/net/MalformedURLException
    //   138	151	216	java/net/MalformedURLException
    //   100	108	230	finally
    //   100	108	248	java/lang/Exception
    //   100	108	262	java/io/IOException
    //   100	108	276	java/net/MalformedURLException
    //   33	40	290	finally
    //   50	85	290	finally
    //   95	100	290	finally
    //   33	40	294	java/lang/Exception
    //   50	85	294	java/lang/Exception
    //   95	100	294	java/lang/Exception
    //   33	40	299	java/io/IOException
    //   50	85	299	java/io/IOException
    //   95	100	299	java/io/IOException
    //   33	40	304	java/net/MalformedURLException
    //   50	85	304	java/net/MalformedURLException
    //   95	100	304	java/net/MalformedURLException
    //   14	29	309	finally
    //   14	29	323	java/lang/Exception
    //   14	29	433	java/io/IOException
    //   14	29	543	java/net/MalformedURLException
    //   345	356	653	finally
    //   365	376	653	finally
    //   385	395	653	finally
    //   455	466	653	finally
    //   475	486	653	finally
    //   495	505	653	finally
    //   565	576	653	finally
    //   585	596	653	finally
    //   605	615	653	finally
    //   44	48	711	java/lang/Throwable
    //   89	93	714	java/lang/Throwable
    //   155	159	717	java/lang/Throwable
    //   166	170	721	java/lang/Throwable
    //   170	174	725	java/lang/Throwable
    //   400	405	729	java/lang/Throwable
    //   413	418	733	java/lang/Throwable
    //   426	431	737	java/lang/Throwable
    //   510	515	740	java/lang/Throwable
    //   523	528	744	java/lang/Throwable
    //   536	541	748	java/lang/Throwable
    //   620	625	751	java/lang/Throwable
    //   633	638	755	java/lang/Throwable
    //   646	651	759	java/lang/Throwable
    //   671	676	762	java/lang/Throwable
    //   683	687	766	java/lang/Throwable
    //   695	700	770	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.e
 * JD-Core Version:    0.7.0.1
 */