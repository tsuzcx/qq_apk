import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

public class bmfb
{
  public static AEEditorDownloadResBean a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
    if (paramAEEditorFilterBean == null) {
      return localAEEditorDownloadResBean;
    }
    localAEEditorDownloadResBean.setPreDownload(paramAEEditorFilterBean.getEditorEffectItem().getPreDownload());
    localAEEditorDownloadResBean.setMd5(paramAEEditorFilterBean.getEditorEffectItem().getResourceMD5());
    localAEEditorDownloadResBean.setUrl(paramAEEditorFilterBean.getEditorEffectItem().getResourceURL());
    localAEEditorDownloadResBean.setId(paramAEEditorFilterBean.getEditorEffectItem().getEffectID());
    return localAEEditorDownloadResBean;
  }
  
  /* Error */
  public static Object a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 58	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 64	java/io/File:exists	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +63 -> 81
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 66	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 66	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 66	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: aload 11
    //   59: astore_0
    //   60: iconst_0
    //   61: ifeq +11 -> 72
    //   64: new 66	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: aload_0
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: new 72	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 5
    //   91: new 77	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 6
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore_0
    //   106: aload 5
    //   108: aload_0
    //   109: invokevirtual 82	java/io/FileInputStream:read	([B)I
    //   112: istore_1
    //   113: iload_1
    //   114: iconst_m1
    //   115: if_icmpeq +89 -> 204
    //   118: aload 6
    //   120: aload_0
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 86	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -20 -> 106
    //   129: astore_3
    //   130: aconst_null
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 5
    //   137: astore 10
    //   139: aload 6
    //   141: astore 9
    //   143: aload 4
    //   145: astore 8
    //   147: aload_0
    //   148: astore 7
    //   150: aload_3
    //   151: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 95	java/io/ByteArrayInputStream:close	()V
    //   172: aload 6
    //   174: ifnull +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   182: aload 11
    //   184: astore_0
    //   185: aload 5
    //   187: ifnull -115 -> 72
    //   190: aload 5
    //   192: invokevirtual 97	java/io/FileInputStream:close	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   202: aconst_null
    //   203: areturn
    //   204: new 94	java/io/ByteArrayInputStream
    //   207: dup
    //   208: aload 6
    //   210: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   213: invokespecial 104	java/io/ByteArrayInputStream:<init>	([B)V
    //   216: astore 4
    //   218: new 89	java/io/ObjectInputStream
    //   221: dup
    //   222: aload 4
    //   224: invokespecial 107	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   227: astore_0
    //   228: aload 5
    //   230: astore 10
    //   232: aload 6
    //   234: astore 9
    //   236: aload 4
    //   238: astore 8
    //   240: aload_0
    //   241: astore 7
    //   243: aload_0
    //   244: invokevirtual 111	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   247: astore_3
    //   248: aload_0
    //   249: ifnull +7 -> 256
    //   252: aload_0
    //   253: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   256: aload 4
    //   258: ifnull +8 -> 266
    //   261: aload 4
    //   263: invokevirtual 95	java/io/ByteArrayInputStream:close	()V
    //   266: aload 6
    //   268: ifnull +8 -> 276
    //   271: aload 6
    //   273: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   276: aload_3
    //   277: astore_0
    //   278: aload 5
    //   280: ifnull -208 -> 72
    //   283: aload 5
    //   285: invokevirtual 97	java/io/FileInputStream:close	()V
    //   288: aload_3
    //   289: areturn
    //   290: astore_0
    //   291: aload_0
    //   292: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   295: aload_3
    //   296: areturn
    //   297: astore_3
    //   298: aconst_null
    //   299: astore 5
    //   301: aconst_null
    //   302: astore 6
    //   304: aconst_null
    //   305: astore 4
    //   307: aconst_null
    //   308: astore_0
    //   309: aload 5
    //   311: astore 10
    //   313: aload 6
    //   315: astore 9
    //   317: aload 4
    //   319: astore 8
    //   321: aload_0
    //   322: astore 7
    //   324: aload_3
    //   325: invokevirtual 112	java/lang/OutOfMemoryError:printStackTrace	()V
    //   328: aload_0
    //   329: ifnull +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   336: aload 4
    //   338: ifnull +8 -> 346
    //   341: aload 4
    //   343: invokevirtual 95	java/io/ByteArrayInputStream:close	()V
    //   346: aload 6
    //   348: ifnull +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   356: aload 11
    //   358: astore_0
    //   359: aload 5
    //   361: ifnull -289 -> 72
    //   364: aload 5
    //   366: invokevirtual 97	java/io/FileInputStream:close	()V
    //   369: aconst_null
    //   370: areturn
    //   371: astore_0
    //   372: aload_0
    //   373: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   376: aconst_null
    //   377: areturn
    //   378: astore_0
    //   379: aconst_null
    //   380: astore 5
    //   382: aconst_null
    //   383: astore 6
    //   385: aconst_null
    //   386: astore_3
    //   387: aconst_null
    //   388: astore 4
    //   390: aload 4
    //   392: ifnull +8 -> 400
    //   395: aload 4
    //   397: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   400: aload_3
    //   401: ifnull +7 -> 408
    //   404: aload_3
    //   405: invokevirtual 95	java/io/ByteArrayInputStream:close	()V
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   418: aload 5
    //   420: ifnull +8 -> 428
    //   423: aload 5
    //   425: invokevirtual 97	java/io/FileInputStream:close	()V
    //   428: aload_0
    //   429: athrow
    //   430: astore_3
    //   431: aload_3
    //   432: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   435: goto -7 -> 428
    //   438: astore_0
    //   439: aconst_null
    //   440: astore 6
    //   442: aconst_null
    //   443: astore_3
    //   444: aconst_null
    //   445: astore 4
    //   447: goto -57 -> 390
    //   450: astore_0
    //   451: aconst_null
    //   452: astore_3
    //   453: aconst_null
    //   454: astore 4
    //   456: goto -66 -> 390
    //   459: astore_0
    //   460: aconst_null
    //   461: astore 7
    //   463: aload 4
    //   465: astore_3
    //   466: aload 7
    //   468: astore 4
    //   470: goto -80 -> 390
    //   473: astore_0
    //   474: aload 10
    //   476: astore 5
    //   478: aload 9
    //   480: astore 6
    //   482: aload 8
    //   484: astore_3
    //   485: aload 7
    //   487: astore 4
    //   489: goto -99 -> 390
    //   492: astore_3
    //   493: aconst_null
    //   494: astore 6
    //   496: aconst_null
    //   497: astore 4
    //   499: aconst_null
    //   500: astore_0
    //   501: goto -192 -> 309
    //   504: astore_3
    //   505: aconst_null
    //   506: astore 4
    //   508: aconst_null
    //   509: astore_0
    //   510: goto -201 -> 309
    //   513: astore_3
    //   514: aconst_null
    //   515: astore_0
    //   516: goto -207 -> 309
    //   519: astore_3
    //   520: goto -211 -> 309
    //   523: astore_3
    //   524: aconst_null
    //   525: astore 5
    //   527: aconst_null
    //   528: astore 6
    //   530: aconst_null
    //   531: astore 4
    //   533: aconst_null
    //   534: astore_0
    //   535: goto -400 -> 135
    //   538: astore_3
    //   539: aconst_null
    //   540: astore 6
    //   542: aconst_null
    //   543: astore 4
    //   545: aconst_null
    //   546: astore_0
    //   547: goto -412 -> 135
    //   550: astore_3
    //   551: aconst_null
    //   552: astore_0
    //   553: goto -418 -> 135
    //   556: astore_3
    //   557: goto -422 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	paramString	java.lang.String
    //   112	11	1	i	int
    //   16	2	2	bool	boolean
    //   129	22	3	localException1	java.lang.Exception
    //   247	49	3	localObject1	Object
    //   297	28	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   386	19	3	localObject2	Object
    //   430	2	3	localIOException	java.io.IOException
    //   443	42	3	localObject3	Object
    //   492	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   504	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   513	1	3	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   519	1	3	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   523	1	3	localException2	java.lang.Exception
    //   538	1	3	localException3	java.lang.Exception
    //   550	1	3	localException4	java.lang.Exception
    //   556	1	3	localException5	java.lang.Exception
    //   131	413	4	localObject4	Object
    //   89	437	5	localObject5	Object
    //   98	443	6	localObject6	Object
    //   148	338	7	str	java.lang.String
    //   145	338	8	localObject7	Object
    //   141	338	9	localObject8	Object
    //   137	338	10	localObject9	Object
    //   1	356	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   25	33	74	java/io/IOException
    //   37	45	74	java/io/IOException
    //   49	57	74	java/io/IOException
    //   64	72	74	java/io/IOException
    //   100	106	129	java/lang/Exception
    //   106	113	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   204	218	129	java/lang/Exception
    //   158	162	197	java/io/IOException
    //   167	172	197	java/io/IOException
    //   177	182	197	java/io/IOException
    //   190	195	197	java/io/IOException
    //   252	256	290	java/io/IOException
    //   261	266	290	java/io/IOException
    //   271	276	290	java/io/IOException
    //   283	288	290	java/io/IOException
    //   3	17	297	java/lang/OutOfMemoryError
    //   81	91	297	java/lang/OutOfMemoryError
    //   332	336	371	java/io/IOException
    //   341	346	371	java/io/IOException
    //   351	356	371	java/io/IOException
    //   364	369	371	java/io/IOException
    //   3	17	378	finally
    //   81	91	378	finally
    //   395	400	430	java/io/IOException
    //   404	408	430	java/io/IOException
    //   413	418	430	java/io/IOException
    //   423	428	430	java/io/IOException
    //   91	100	438	finally
    //   100	106	450	finally
    //   106	113	450	finally
    //   118	126	450	finally
    //   204	218	450	finally
    //   218	228	459	finally
    //   150	154	473	finally
    //   243	248	473	finally
    //   324	328	473	finally
    //   91	100	492	java/lang/OutOfMemoryError
    //   100	106	504	java/lang/OutOfMemoryError
    //   106	113	504	java/lang/OutOfMemoryError
    //   118	126	504	java/lang/OutOfMemoryError
    //   204	218	504	java/lang/OutOfMemoryError
    //   218	228	513	java/lang/OutOfMemoryError
    //   243	248	519	java/lang/OutOfMemoryError
    //   3	17	523	java/lang/Exception
    //   81	91	523	java/lang/Exception
    //   91	100	538	java/lang/Exception
    //   218	228	550	java/lang/Exception
    //   243	248	556	java/lang/Exception
  }
  
  /* Error */
  public static void a(Object paramObject, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 58	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 64	java/io/File:exists	()Z
    //   18: ifne +26 -> 44
    //   21: aload_1
    //   22: invokevirtual 119	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 64	java/io/File:exists	()Z
    //   28: ifne +11 -> 39
    //   31: aload_1
    //   32: invokevirtual 119	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 122	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual 125	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: new 127	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: new 77	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore_3
    //   61: new 130	java/io/ObjectOutputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 133	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload_2
    //   71: aload_0
    //   72: invokevirtual 137	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   75: aload_2
    //   76: invokevirtual 140	java/io/ObjectOutputStream:flush	()V
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 143	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 144	java/io/ObjectOutputStream:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload 4
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 146	java/lang/Throwable:printStackTrace	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 144	java/io/ObjectOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull -39 -> 108
    //   150: aload_1
    //   151: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   154: return
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   160: return
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload 4
    //   168: astore_1
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 144	java/io/ObjectOutputStream:close	()V
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   200: goto -7 -> 193
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_2
    //   208: goto -39 -> 169
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -45 -> 169
    //   217: astore_0
    //   218: goto -49 -> 169
    //   221: astore 4
    //   223: aload_0
    //   224: astore_3
    //   225: aload 4
    //   227: astore_0
    //   228: goto -59 -> 169
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_0
    //   236: goto -110 -> 126
    //   239: astore 4
    //   241: aload_3
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_2
    //   245: aload 4
    //   247: astore_3
    //   248: goto -122 -> 126
    //   251: astore 4
    //   253: aload_3
    //   254: astore_0
    //   255: aload 4
    //   257: astore_3
    //   258: goto -132 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramObject	Object
    //   0	261	1	paramString	java.lang.String
    //   69	176	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	221	3	localObject1	Object
    //   231	11	3	localThrowable1	java.lang.Throwable
    //   247	11	3	localThrowable2	java.lang.Throwable
    //   1	1	4	localObject2	Object
    //   115	52	4	localThrowable3	java.lang.Throwable
    //   221	5	4	localObject3	Object
    //   239	7	4	localThrowable4	java.lang.Throwable
    //   251	5	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   88	92	109	java/io/IOException
    //   96	100	109	java/io/IOException
    //   104	108	109	java/io/IOException
    //   5	39	115	java/lang/Throwable
    //   39	44	115	java/lang/Throwable
    //   44	53	115	java/lang/Throwable
    //   134	138	155	java/io/IOException
    //   142	146	155	java/io/IOException
    //   150	154	155	java/io/IOException
    //   5	39	161	finally
    //   39	44	161	finally
    //   44	53	161	finally
    //   173	177	195	java/io/IOException
    //   181	185	195	java/io/IOException
    //   189	193	195	java/io/IOException
    //   53	61	203	finally
    //   61	70	211	finally
    //   70	84	217	finally
    //   126	130	221	finally
    //   53	61	231	java/lang/Throwable
    //   61	70	239	java/lang/Throwable
    //   70	84	251	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfb
 * JD-Core Version:    0.7.0.1
 */