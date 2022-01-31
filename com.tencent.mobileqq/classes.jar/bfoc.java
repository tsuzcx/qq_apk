public class bfoc
{
  /* Error */
  public static void a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_1
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: new 12	java/io/File
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 20	java/io/File:listFiles	()[Ljava/io/File;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnull +29 -> 60
    //   34: aload 8
    //   36: arraylength
    //   37: istore 4
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge +18 -> 60
    //   45: aload 8
    //   47: iload_3
    //   48: aaload
    //   49: invokevirtual 24	java/io/File:delete	()Z
    //   52: pop
    //   53: iload_3
    //   54: iconst_1
    //   55: iadd
    //   56: istore_3
    //   57: goto -18 -> 39
    //   60: new 26	com/tencent/commonsdk/zip/QZipInputStream
    //   63: dup
    //   64: new 28	java/io/BufferedInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   72: aload_1
    //   73: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   76: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: invokespecial 44	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: astore 8
    //   84: aconst_null
    //   85: astore_0
    //   86: aload 8
    //   88: invokevirtual 48	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +281 -> 374
    //   96: sipush 4096
    //   99: newarray byte
    //   101: astore 7
    //   103: aload_1
    //   104: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +40 -> 149
    //   112: aload_1
    //   113: ldc 56
    //   115: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifeq +27 -> 149
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   133: iconst_0
    //   134: ifeq -48 -> 86
    //   137: new 70	java/lang/NullPointerException
    //   140: dup
    //   141: invokespecial 72	java/lang/NullPointerException:<init>	()V
    //   144: athrow
    //   145: astore_1
    //   146: goto -60 -> 86
    //   149: new 12	java/io/File
    //   152: dup
    //   153: new 74	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   160: aload_2
    //   161: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: new 12	java/io/File
    //   178: dup
    //   179: aload_1
    //   180: invokevirtual 85	java/io/File:getParent	()Ljava/lang/String;
    //   183: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: astore 6
    //   188: aload 6
    //   190: invokevirtual 88	java/io/File:exists	()Z
    //   193: ifne +9 -> 202
    //   196: aload 6
    //   198: invokevirtual 91	java/io/File:mkdirs	()Z
    //   201: pop
    //   202: new 93	java/io/FileOutputStream
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   210: astore_1
    //   211: new 64	java/io/BufferedOutputStream
    //   214: dup
    //   215: aload_1
    //   216: sipush 4096
    //   219: invokespecial 99	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   222: astore 6
    //   224: aload 8
    //   226: aload 7
    //   228: iconst_0
    //   229: sipush 4096
    //   232: invokevirtual 103	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   235: istore_3
    //   236: iload_3
    //   237: iconst_m1
    //   238: if_icmpeq +47 -> 285
    //   241: aload 6
    //   243: aload 7
    //   245: iconst_0
    //   246: iload_3
    //   247: invokevirtual 107	java/io/BufferedOutputStream:write	([BII)V
    //   250: goto -26 -> 224
    //   253: astore_0
    //   254: aload 6
    //   256: astore_0
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   265: aload_0
    //   266: astore 7
    //   268: aload_1
    //   269: ifnull +10 -> 279
    //   272: aload_1
    //   273: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   276: aload_0
    //   277: astore 7
    //   279: aload 7
    //   281: astore_0
    //   282: goto -196 -> 86
    //   285: aload 6
    //   287: invokevirtual 111	java/io/BufferedOutputStream:flush	()V
    //   290: aload_1
    //   291: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   294: aload 6
    //   296: ifnull +8 -> 304
    //   299: aload 6
    //   301: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   304: aload 6
    //   306: astore 7
    //   308: aload_1
    //   309: ifnull -30 -> 279
    //   312: aload_1
    //   313: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   316: aload 6
    //   318: astore 7
    //   320: goto -41 -> 279
    //   323: astore_0
    //   324: aload 6
    //   326: astore 7
    //   328: goto -49 -> 279
    //   331: astore_0
    //   332: aload_1
    //   333: astore_2
    //   334: aload_0
    //   335: astore_1
    //   336: aload 6
    //   338: ifnull +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   346: aload_2
    //   347: ifnull +7 -> 354
    //   350: aload_2
    //   351: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: aload 8
    //   359: ifnull -344 -> 15
    //   362: aload 8
    //   364: invokevirtual 113	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   367: return
    //   368: astore_0
    //   369: aload_0
    //   370: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   373: return
    //   374: aload 8
    //   376: ifnull -361 -> 15
    //   379: aload 8
    //   381: invokevirtual 113	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   384: return
    //   385: astore_0
    //   386: aload_0
    //   387: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   390: return
    //   391: astore_0
    //   392: aload 6
    //   394: astore 8
    //   396: aload 8
    //   398: ifnull +8 -> 406
    //   401: aload 8
    //   403: invokevirtual 113	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   406: aload_0
    //   407: athrow
    //   408: astore_1
    //   409: aload_1
    //   410: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   413: goto -7 -> 406
    //   416: astore_1
    //   417: goto -284 -> 133
    //   420: astore_0
    //   421: goto -117 -> 304
    //   424: astore 6
    //   426: goto -161 -> 265
    //   429: astore_1
    //   430: aload_0
    //   431: astore 7
    //   433: goto -154 -> 279
    //   436: astore_0
    //   437: goto -91 -> 346
    //   440: astore_0
    //   441: goto -87 -> 354
    //   444: astore_0
    //   445: goto -49 -> 396
    //   448: astore_0
    //   449: aload 7
    //   451: astore 8
    //   453: goto -96 -> 357
    //   456: astore_1
    //   457: aload 9
    //   459: astore_2
    //   460: aload_0
    //   461: astore 6
    //   463: goto -127 -> 336
    //   466: astore 6
    //   468: aload_1
    //   469: astore_2
    //   470: aload 6
    //   472: astore_1
    //   473: aload_0
    //   474: astore 6
    //   476: goto -140 -> 336
    //   479: astore_1
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -225 -> 257
    //   485: astore 6
    //   487: goto -230 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramContext	android.content.Context
    //   0	490	1	paramString1	java.lang.String
    //   0	490	2	paramString2	java.lang.String
    //   10	237	3	i	int
    //   37	6	4	j	int
    //   118	3	5	bool	boolean
    //   4	389	6	localObject1	Object
    //   424	1	6	localIOException	java.io.IOException
    //   461	1	6	localContext1	android.content.Context
    //   466	5	6	localObject2	Object
    //   474	1	6	localContext2	android.content.Context
    //   485	1	6	localException	java.lang.Exception
    //   1	449	7	localObject3	Object
    //   27	425	8	localObject4	Object
    //   7	451	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   137	145	145	java/io/IOException
    //   224	236	253	java/lang/Exception
    //   241	250	253	java/lang/Exception
    //   285	294	253	java/lang/Exception
    //   312	316	323	java/io/IOException
    //   224	236	331	finally
    //   241	250	331	finally
    //   285	294	331	finally
    //   86	92	356	java/lang/Exception
    //   129	133	356	java/lang/Exception
    //   137	145	356	java/lang/Exception
    //   261	265	356	java/lang/Exception
    //   272	276	356	java/lang/Exception
    //   299	304	356	java/lang/Exception
    //   312	316	356	java/lang/Exception
    //   341	346	356	java/lang/Exception
    //   350	354	356	java/lang/Exception
    //   354	356	356	java/lang/Exception
    //   362	367	368	java/io/IOException
    //   379	384	385	java/io/IOException
    //   16	29	391	finally
    //   34	39	391	finally
    //   45	53	391	finally
    //   60	84	391	finally
    //   401	406	408	java/io/IOException
    //   129	133	416	java/io/IOException
    //   299	304	420	java/io/IOException
    //   261	265	424	java/io/IOException
    //   272	276	429	java/io/IOException
    //   341	346	436	java/io/IOException
    //   350	354	440	java/io/IOException
    //   86	92	444	finally
    //   129	133	444	finally
    //   137	145	444	finally
    //   261	265	444	finally
    //   272	276	444	finally
    //   299	304	444	finally
    //   312	316	444	finally
    //   341	346	444	finally
    //   350	354	444	finally
    //   354	356	444	finally
    //   16	29	448	java/lang/Exception
    //   34	39	448	java/lang/Exception
    //   45	53	448	java/lang/Exception
    //   60	84	448	java/lang/Exception
    //   96	108	456	finally
    //   112	120	456	finally
    //   149	202	456	finally
    //   202	211	456	finally
    //   211	224	466	finally
    //   96	108	479	java/lang/Exception
    //   112	120	479	java/lang/Exception
    //   149	202	479	java/lang/Exception
    //   202	211	479	java/lang/Exception
    //   211	224	485	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfoc
 * JD-Core Version:    0.7.0.1
 */