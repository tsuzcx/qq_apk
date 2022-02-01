package com.tencent.aelight.camera.aeeditor.manage;

public class AEEditorEffectUtils
{
  /* Error */
  public static Object a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 19	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 26	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 28	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: new 33	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore_3
    //   38: sipush 1024
    //   41: newarray byte
    //   43: astore_2
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 38	java/io/FileInputStream:read	([B)I
    //   49: istore_1
    //   50: iload_1
    //   51: iconst_m1
    //   52: if_icmpeq +13 -> 65
    //   55: aload_3
    //   56: aload_2
    //   57: iconst_0
    //   58: iload_1
    //   59: invokevirtual 42	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -18 -> 44
    //   65: new 44	java/io/ByteArrayInputStream
    //   68: dup
    //   69: aload_3
    //   70: invokevirtual 48	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   76: astore_2
    //   77: new 53	java/io/ObjectInputStream
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 56	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore 6
    //   87: aload 6
    //   89: invokevirtual 60	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   92: astore 4
    //   94: aload 6
    //   96: invokevirtual 63	java/io/ObjectInputStream:close	()V
    //   99: aload_2
    //   100: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   103: aload_3
    //   104: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   107: aload_0
    //   108: invokevirtual 66	java/io/FileInputStream:close	()V
    //   111: aload 4
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   119: aload 4
    //   121: areturn
    //   122: astore 4
    //   124: aload_0
    //   125: astore 5
    //   127: aload_2
    //   128: astore 8
    //   130: aload 4
    //   132: astore_0
    //   133: aload_3
    //   134: astore 4
    //   136: aload 6
    //   138: astore 7
    //   140: aload 5
    //   142: astore_2
    //   143: aload 8
    //   145: astore_3
    //   146: goto +391 -> 537
    //   149: astore 4
    //   151: aload_0
    //   152: astore 7
    //   154: aload_2
    //   155: astore 8
    //   157: aload_3
    //   158: astore 5
    //   160: aload 6
    //   162: astore_0
    //   163: aload 7
    //   165: astore_2
    //   166: aload 8
    //   168: astore_3
    //   169: goto +219 -> 388
    //   172: astore 4
    //   174: aload_0
    //   175: astore 7
    //   177: aload_2
    //   178: astore 8
    //   180: aload_3
    //   181: astore 5
    //   183: aload 6
    //   185: astore_0
    //   186: aload 7
    //   188: astore_2
    //   189: aload 8
    //   191: astore_3
    //   192: goto +271 -> 463
    //   195: astore 4
    //   197: aload_0
    //   198: astore 6
    //   200: aload_2
    //   201: astore 7
    //   203: aload 4
    //   205: astore_0
    //   206: aload_3
    //   207: astore 4
    //   209: aload 6
    //   211: astore_2
    //   212: aload 7
    //   214: astore_3
    //   215: goto +326 -> 541
    //   218: astore 4
    //   220: aload_0
    //   221: astore 6
    //   223: aload_2
    //   224: astore 7
    //   226: aconst_null
    //   227: astore_0
    //   228: aload_3
    //   229: astore 5
    //   231: aload 6
    //   233: astore_2
    //   234: aload 7
    //   236: astore_3
    //   237: goto +151 -> 388
    //   240: astore 4
    //   242: aload_0
    //   243: astore 6
    //   245: aload_2
    //   246: astore 7
    //   248: aconst_null
    //   249: astore_0
    //   250: aload_3
    //   251: astore 5
    //   253: aload 6
    //   255: astore_2
    //   256: aload 7
    //   258: astore_3
    //   259: goto +204 -> 463
    //   262: astore 7
    //   264: aload_0
    //   265: astore_2
    //   266: aconst_null
    //   267: astore 6
    //   269: aload_3
    //   270: astore 4
    //   272: aload 7
    //   274: astore_0
    //   275: aload 6
    //   277: astore_3
    //   278: goto +263 -> 541
    //   281: astore 4
    //   283: aload_0
    //   284: astore_2
    //   285: aconst_null
    //   286: astore 6
    //   288: aload 6
    //   290: astore_0
    //   291: aload_3
    //   292: astore 5
    //   294: aload 6
    //   296: astore_3
    //   297: goto +91 -> 388
    //   300: astore 4
    //   302: aload_0
    //   303: astore_2
    //   304: aconst_null
    //   305: astore 6
    //   307: aload 6
    //   309: astore_0
    //   310: aload_3
    //   311: astore 5
    //   313: aload 6
    //   315: astore_3
    //   316: goto +147 -> 463
    //   319: astore 6
    //   321: aload_0
    //   322: astore_2
    //   323: aconst_null
    //   324: astore_3
    //   325: aload_3
    //   326: astore 4
    //   328: aload 6
    //   330: astore_0
    //   331: goto +210 -> 541
    //   334: astore 4
    //   336: aload_0
    //   337: astore_2
    //   338: aconst_null
    //   339: astore_3
    //   340: aload_3
    //   341: astore 5
    //   343: aload 5
    //   345: astore_0
    //   346: goto +42 -> 388
    //   349: astore 4
    //   351: aload_0
    //   352: astore_2
    //   353: aconst_null
    //   354: astore_3
    //   355: aload_3
    //   356: astore 5
    //   358: aload 5
    //   360: astore_0
    //   361: goto +102 -> 463
    //   364: astore_0
    //   365: aconst_null
    //   366: astore_3
    //   367: aload_3
    //   368: astore 4
    //   370: aload 4
    //   372: astore_2
    //   373: goto +168 -> 541
    //   376: astore 4
    //   378: aconst_null
    //   379: astore_3
    //   380: aload_3
    //   381: astore 5
    //   383: aload 5
    //   385: astore_0
    //   386: aload_0
    //   387: astore_2
    //   388: aload 5
    //   390: astore 6
    //   392: aload_0
    //   393: astore 7
    //   395: aload_2
    //   396: astore 8
    //   398: aload_3
    //   399: astore 9
    //   401: aload 4
    //   403: invokevirtual 70	java/lang/OutOfMemoryError:printStackTrace	()V
    //   406: aload_0
    //   407: ifnull +10 -> 417
    //   410: aload_0
    //   411: invokevirtual 63	java/io/ObjectInputStream:close	()V
    //   414: goto +3 -> 417
    //   417: aload_3
    //   418: ifnull +7 -> 425
    //   421: aload_3
    //   422: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   425: aload 5
    //   427: ifnull +8 -> 435
    //   430: aload 5
    //   432: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   435: aload_2
    //   436: ifnull +13 -> 449
    //   439: aload_2
    //   440: invokevirtual 66	java/io/FileInputStream:close	()V
    //   443: aconst_null
    //   444: areturn
    //   445: aload_0
    //   446: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   449: aconst_null
    //   450: areturn
    //   451: astore 4
    //   453: aconst_null
    //   454: astore_3
    //   455: aload_3
    //   456: astore 5
    //   458: aload 5
    //   460: astore_0
    //   461: aload_0
    //   462: astore_2
    //   463: aload 5
    //   465: astore 6
    //   467: aload_0
    //   468: astore 7
    //   470: aload_2
    //   471: astore 8
    //   473: aload_3
    //   474: astore 9
    //   476: aload 4
    //   478: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   481: aload_0
    //   482: ifnull +10 -> 492
    //   485: aload_0
    //   486: invokevirtual 63	java/io/ObjectInputStream:close	()V
    //   489: goto +3 -> 492
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   500: aload 5
    //   502: ifnull +8 -> 510
    //   505: aload 5
    //   507: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   510: aload_2
    //   511: ifnull +13 -> 524
    //   514: aload_2
    //   515: invokevirtual 66	java/io/FileInputStream:close	()V
    //   518: aconst_null
    //   519: areturn
    //   520: aload_0
    //   521: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   524: aconst_null
    //   525: areturn
    //   526: astore_0
    //   527: aload 9
    //   529: astore_3
    //   530: aload 8
    //   532: astore_2
    //   533: aload 6
    //   535: astore 4
    //   537: aload 7
    //   539: astore 5
    //   541: aload 5
    //   543: ifnull +11 -> 554
    //   546: aload 5
    //   548: invokevirtual 63	java/io/ObjectInputStream:close	()V
    //   551: goto +3 -> 554
    //   554: aload_3
    //   555: ifnull +7 -> 562
    //   558: aload_3
    //   559: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   562: aload 4
    //   564: ifnull +8 -> 572
    //   567: aload 4
    //   569: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   572: aload_2
    //   573: ifnull +14 -> 587
    //   576: aload_2
    //   577: invokevirtual 66	java/io/FileInputStream:close	()V
    //   580: goto +7 -> 587
    //   583: aload_2
    //   584: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   587: goto +5 -> 592
    //   590: aload_0
    //   591: athrow
    //   592: goto -2 -> 590
    //   595: astore_0
    //   596: goto -151 -> 445
    //   599: astore_0
    //   600: goto -80 -> 520
    //   603: astore_2
    //   604: goto -21 -> 583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramString	java.lang.String
    //   49	10	1	i	int
    //   43	541	2	localObject1	Object
    //   603	1	2	localIOException	java.io.IOException
    //   37	522	3	localObject2	Object
    //   92	28	4	localObject3	Object
    //   122	9	4	localObject4	Object
    //   134	1	4	localObject5	Object
    //   149	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   172	1	4	localException1	java.lang.Exception
    //   195	9	4	localObject6	Object
    //   207	1	4	localObject7	Object
    //   218	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   240	1	4	localException2	java.lang.Exception
    //   270	1	4	localObject8	Object
    //   281	1	4	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   300	1	4	localException3	java.lang.Exception
    //   326	1	4	localObject9	Object
    //   334	1	4	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   349	1	4	localException4	java.lang.Exception
    //   368	3	4	localObject10	Object
    //   376	26	4	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   451	26	4	localException5	java.lang.Exception
    //   535	33	4	localObject11	Object
    //   1	546	5	localObject12	Object
    //   85	229	6	localObject13	Object
    //   319	10	6	localObject14	Object
    //   390	144	6	localObject15	Object
    //   138	119	7	localObject16	Object
    //   262	11	7	localObject17	Object
    //   393	145	7	str	java.lang.String
    //   128	403	8	localObject18	Object
    //   399	129	9	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   94	111	114	java/io/IOException
    //   87	94	122	finally
    //   87	94	149	java/lang/OutOfMemoryError
    //   87	94	172	java/lang/Exception
    //   77	87	195	finally
    //   77	87	218	java/lang/OutOfMemoryError
    //   77	87	240	java/lang/Exception
    //   38	44	262	finally
    //   44	50	262	finally
    //   55	62	262	finally
    //   65	77	262	finally
    //   38	44	281	java/lang/OutOfMemoryError
    //   44	50	281	java/lang/OutOfMemoryError
    //   55	62	281	java/lang/OutOfMemoryError
    //   65	77	281	java/lang/OutOfMemoryError
    //   38	44	300	java/lang/Exception
    //   44	50	300	java/lang/Exception
    //   55	62	300	java/lang/Exception
    //   65	77	300	java/lang/Exception
    //   30	38	319	finally
    //   30	38	334	java/lang/OutOfMemoryError
    //   30	38	349	java/lang/Exception
    //   3	19	364	finally
    //   21	30	364	finally
    //   3	19	376	java/lang/OutOfMemoryError
    //   21	30	376	java/lang/OutOfMemoryError
    //   3	19	451	java/lang/Exception
    //   21	30	451	java/lang/Exception
    //   401	406	526	finally
    //   476	481	526	finally
    //   410	414	595	java/io/IOException
    //   421	425	595	java/io/IOException
    //   430	435	595	java/io/IOException
    //   439	443	595	java/io/IOException
    //   485	489	599	java/io/IOException
    //   496	500	599	java/io/IOException
    //   505	510	599	java/io/IOException
    //   514	518	599	java/io/IOException
    //   546	551	603	java/io/IOException
    //   558	562	603	java/io/IOException
    //   567	572	603	java/io/IOException
    //   576	580	603	java/io/IOException
  }
  
  /* Error */
  public static void a(Object paramObject, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: new 19	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 26	java/io/File:exists	()Z
    //   21: ifne +26 -> 47
    //   24: aload_1
    //   25: invokevirtual 78	java/io/File:getParentFile	()Ljava/io/File;
    //   28: invokevirtual 26	java/io/File:exists	()Z
    //   31: ifne +11 -> 42
    //   34: aload_1
    //   35: invokevirtual 78	java/io/File:getParentFile	()Ljava/io/File;
    //   38: invokevirtual 81	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 84	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 86	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: new 33	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore_1
    //   64: aload 4
    //   66: astore_3
    //   67: aload_1
    //   68: astore 4
    //   70: aload_2
    //   71: astore 6
    //   73: new 89	java/io/ObjectOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 92	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: astore 5
    //   83: aload 5
    //   85: aload_0
    //   86: invokevirtual 96	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload 5
    //   91: invokevirtual 99	java/io/ObjectOutputStream:flush	()V
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 102	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   99: aload 5
    //   101: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   108: aload_2
    //   109: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   112: return
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: aload_1
    //   119: astore_0
    //   120: aload 4
    //   122: astore_1
    //   123: goto +111 -> 234
    //   126: astore_3
    //   127: aload_1
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: goto +48 -> 179
    //   134: astore_3
    //   135: aload 7
    //   137: astore 5
    //   139: aload_1
    //   140: astore_0
    //   141: aload_3
    //   142: astore_1
    //   143: goto +36 -> 179
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: goto +85 -> 234
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 7
    //   157: astore 5
    //   159: goto +20 -> 179
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_0
    //   167: goto +67 -> 234
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_0
    //   175: aload 7
    //   177: astore 5
    //   179: aload 5
    //   181: astore_3
    //   182: aload_0
    //   183: astore 4
    //   185: aload_2
    //   186: astore 6
    //   188: aload_1
    //   189: invokevirtual 105	java/lang/Throwable:printStackTrace	()V
    //   192: aload 5
    //   194: ifnull +11 -> 205
    //   197: aload 5
    //   199: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   213: aload_2
    //   214: ifnull +12 -> 226
    //   217: aload_2
    //   218: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   221: return
    //   222: aload_0
    //   223: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aload 6
    //   230: astore_2
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   242: goto +3 -> 245
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull +14 -> 268
    //   257: aload_2
    //   258: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   261: goto +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: goto -49 -> 222
    //   274: astore_0
    //   275: goto -11 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramObject	Object
    //   0	278	1	paramString	java.lang.String
    //   55	203	2	localObject1	Object
    //   4	114	3	localObject2	Object
    //   126	4	3	localThrowable1	java.lang.Throwable
    //   134	8	3	localThrowable2	java.lang.Throwable
    //   181	58	3	localObject3	Object
    //   1	68	4	str	java.lang.String
    //   113	8	4	localObject4	Object
    //   183	49	4	localObject5	Object
    //   81	117	5	localObject6	Object
    //   71	158	6	localObject7	Object
    //   6	170	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   83	99	113	finally
    //   83	99	126	java/lang/Throwable
    //   73	83	134	java/lang/Throwable
    //   56	64	146	finally
    //   56	64	152	java/lang/Throwable
    //   8	42	162	finally
    //   42	47	162	finally
    //   47	56	162	finally
    //   8	42	170	java/lang/Throwable
    //   42	47	170	java/lang/Throwable
    //   47	56	170	java/lang/Throwable
    //   73	83	227	finally
    //   188	192	227	finally
    //   99	112	270	java/io/IOException
    //   197	202	270	java/io/IOException
    //   209	213	270	java/io/IOException
    //   217	221	270	java/io/IOException
    //   238	242	274	java/io/IOException
    //   249	253	274	java/io/IOException
    //   257	261	274	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectUtils
 * JD-Core Version:    0.7.0.1
 */