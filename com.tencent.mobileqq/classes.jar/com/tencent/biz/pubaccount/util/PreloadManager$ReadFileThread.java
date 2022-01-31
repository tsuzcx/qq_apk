package com.tencent.biz.pubaccount.util;

class PreloadManager$ReadFileThread
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  public PreloadManager$ReadFileThread(PreloadManager paramPreloadManager, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 36	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 23	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: ldc 38
    //   22: invokevirtual 44	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: putfield 21	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:jdField_a_of_type_Boolean	Z
    //   28: aload_0
    //   29: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   32: invokestatic 47	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
    //   35: aload 4
    //   37: invokevirtual 53	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 55	[B
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +436 -> 481
    //   48: new 57	java/io/File
    //   51: dup
    //   52: new 57	java/io/File
    //   55: dup
    //   56: getstatic 62	ajsd:cG	Ljava/lang/String;
    //   59: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: aload 4
    //   64: invokespecial 68	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 72	java/io/File:exists	()Z
    //   72: ifeq -58 -> 14
    //   75: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   78: aload_3
    //   79: invokevirtual 81	java/io/File:lastModified	()J
    //   82: lsub
    //   83: ldc2_w 82
    //   86: lcmp
    //   87: ifge -73 -> 14
    //   90: aconst_null
    //   91: astore_2
    //   92: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +30 -> 125
    //   98: ldc 90
    //   100: iconst_2
    //   101: new 92	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   108: ldc 95
    //   110: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   116: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: new 112	java/io/FileInputStream
    //   128: dup
    //   129: aload_3
    //   130: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 119	java/io/FileInputStream:available	()I
    //   138: newarray byte
    //   140: astore_2
    //   141: aload_3
    //   142: aload_2
    //   143: invokevirtual 123	java/io/FileInputStream:read	([B)I
    //   146: pop
    //   147: aload_3
    //   148: invokevirtual 126	java/io/FileInputStream:close	()V
    //   151: aload_0
    //   152: getfield 25	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:b	Ljava/lang/String;
    //   155: invokestatic 129	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)[B
    //   158: aload_2
    //   159: invokestatic 132	com/tencent/biz/pubaccount/util/PreloadManager:a	([B[B)[B
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +243 -> 407
    //   167: new 40	java/lang/String
    //   170: dup
    //   171: aload_2
    //   172: invokespecial 135	java/lang/String:<init>	([B)V
    //   175: astore_2
    //   176: aload_2
    //   177: aload_2
    //   178: ldc 137
    //   180: invokevirtual 141	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   183: bipush 10
    //   185: iadd
    //   186: aload_2
    //   187: invokevirtual 144	java/lang/String:length	()I
    //   190: invokevirtual 148	java/lang/String:substring	(II)Ljava/lang/String;
    //   193: astore 5
    //   195: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +29 -> 227
    //   201: ldc 90
    //   203: iconst_2
    //   204: new 92	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   211: ldc 150
    //   213: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: istore_1
    //   235: iload_1
    //   236: ifne +18 -> 254
    //   239: aload_3
    //   240: ifnull -226 -> 14
    //   243: aload_3
    //   244: invokevirtual 126	java/io/FileInputStream:close	()V
    //   247: return
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   253: return
    //   254: aload_2
    //   255: iconst_0
    //   256: aload_2
    //   257: ldc 137
    //   259: invokevirtual 141	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   262: invokevirtual 148	java/lang/String:substring	(II)Ljava/lang/String;
    //   265: astore 5
    //   267: aload_0
    //   268: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   271: getfield 161	com/tencent/biz/pubaccount/util/PreloadManager:c	Ljava/lang/Object;
    //   274: astore_2
    //   275: aload_2
    //   276: monitorenter
    //   277: aload_0
    //   278: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   281: invokestatic 47	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
    //   284: aload 4
    //   286: aload 5
    //   288: invokevirtual 165	java/lang/String:getBytes	()[B
    //   291: invokevirtual 169	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: aload_2
    //   296: monitorexit
    //   297: new 171	java/util/ArrayList
    //   300: dup
    //   301: invokespecial 172	java/util/ArrayList:<init>	()V
    //   304: pop
    //   305: aload_0
    //   306: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   309: aload 5
    //   311: aload_0
    //   312: getfield 21	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:jdField_a_of_type_Boolean	Z
    //   315: invokestatic 175	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   318: astore 5
    //   320: aload_0
    //   321: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   324: getfield 177	com/tencent/biz/pubaccount/util/PreloadManager:a	Ljava/lang/Object;
    //   327: astore_2
    //   328: aload_2
    //   329: monitorenter
    //   330: aload_0
    //   331: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   334: invokestatic 180	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
    //   337: aload 4
    //   339: aload 5
    //   341: invokevirtual 183	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: ldc 90
    //   347: iconst_2
    //   348: new 92	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   355: ldc 185
    //   357: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 4
    //   362: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_2
    //   372: monitorexit
    //   373: aload_0
    //   374: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   377: getfield 187	com/tencent/biz/pubaccount/util/PreloadManager:b	Z
    //   380: ifne +27 -> 407
    //   383: invokestatic 192	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   386: iconst_1
    //   387: if_icmpne +20 -> 407
    //   390: aload_0
    //   391: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   394: invokevirtual 194	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   397: ifeq +10 -> 407
    //   400: aload_0
    //   401: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   404: invokevirtual 196	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   407: aload_3
    //   408: ifnull -394 -> 14
    //   411: aload_3
    //   412: invokevirtual 126	java/io/FileInputStream:close	()V
    //   415: return
    //   416: astore_2
    //   417: aload_2
    //   418: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   421: return
    //   422: astore 4
    //   424: aload_2
    //   425: monitorexit
    //   426: aload 4
    //   428: athrow
    //   429: astore 4
    //   431: aload_3
    //   432: astore_2
    //   433: aload 4
    //   435: astore_3
    //   436: aload_3
    //   437: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   440: aload_2
    //   441: ifnull -427 -> 14
    //   444: aload_2
    //   445: invokevirtual 126	java/io/FileInputStream:close	()V
    //   448: return
    //   449: astore_2
    //   450: aload_2
    //   451: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   454: return
    //   455: astore 4
    //   457: aload_2
    //   458: monitorexit
    //   459: aload 4
    //   461: athrow
    //   462: astore_2
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 126	java/io/FileInputStream:close	()V
    //   471: aload_2
    //   472: athrow
    //   473: astore_3
    //   474: aload_3
    //   475: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   478: goto -7 -> 471
    //   481: new 171	java/util/ArrayList
    //   484: dup
    //   485: invokespecial 172	java/util/ArrayList:<init>	()V
    //   488: pop
    //   489: aload_0
    //   490: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   493: new 40	java/lang/String
    //   496: dup
    //   497: aload_2
    //   498: invokespecial 135	java/lang/String:<init>	([B)V
    //   501: aload_0
    //   502: getfield 21	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:jdField_a_of_type_Boolean	Z
    //   505: invokestatic 175	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   508: astore_3
    //   509: aload_0
    //   510: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   513: getfield 177	com/tencent/biz/pubaccount/util/PreloadManager:a	Ljava/lang/Object;
    //   516: astore_2
    //   517: aload_2
    //   518: monitorenter
    //   519: aload_0
    //   520: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   523: invokestatic 180	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
    //   526: aload 4
    //   528: aload_3
    //   529: invokevirtual 183	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   532: pop
    //   533: ldc 90
    //   535: iconst_2
    //   536: new 92	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   543: ldc 185
    //   545: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 4
    //   550: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aload_2
    //   560: monitorexit
    //   561: aload_0
    //   562: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   565: getfield 187	com/tencent/biz/pubaccount/util/PreloadManager:b	Z
    //   568: ifne -554 -> 14
    //   571: invokestatic 192	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   574: iconst_1
    //   575: if_icmpne -561 -> 14
    //   578: aload_0
    //   579: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   582: invokevirtual 194	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   585: ifeq -571 -> 14
    //   588: aload_0
    //   589: getfield 16	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   592: invokevirtual 196	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   595: return
    //   596: astore_2
    //   597: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq -586 -> 14
    //   603: ldc 90
    //   605: iconst_2
    //   606: ldc 198
    //   608: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: return
    //   612: astore_3
    //   613: aload_2
    //   614: monitorexit
    //   615: aload_3
    //   616: athrow
    //   617: astore_2
    //   618: aconst_null
    //   619: astore_3
    //   620: goto -157 -> 463
    //   623: astore 4
    //   625: aload_2
    //   626: astore_3
    //   627: aload 4
    //   629: astore_2
    //   630: goto -167 -> 463
    //   633: astore_3
    //   634: goto -198 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	ReadFileThread
    //   234	2	1	bool	boolean
    //   43	144	2	localObject1	Object
    //   248	9	2	localIOException1	java.io.IOException
    //   274	98	2	localObject2	Object
    //   416	9	2	localIOException2	java.io.IOException
    //   432	13	2	localObject3	Object
    //   449	9	2	localIOException3	java.io.IOException
    //   462	36	2	arrayOfByte	byte[]
    //   596	18	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   617	9	2	localObject5	Object
    //   629	1	2	localObject6	Object
    //   67	401	3	localObject7	Object
    //   473	2	3	localIOException4	java.io.IOException
    //   508	21	3	localArrayList	java.util.ArrayList
    //   612	4	3	localObject8	Object
    //   619	8	3	localObject9	Object
    //   633	1	3	localIOException5	java.io.IOException
    //   7	354	4	str	String
    //   422	5	4	localObject10	Object
    //   429	5	4	localIOException6	java.io.IOException
    //   455	94	4	localObject11	Object
    //   623	5	4	localObject12	Object
    //   193	147	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   243	247	248	java/io/IOException
    //   411	415	416	java/io/IOException
    //   277	297	422	finally
    //   424	426	422	finally
    //   134	163	429	java/io/IOException
    //   167	227	429	java/io/IOException
    //   227	235	429	java/io/IOException
    //   254	277	429	java/io/IOException
    //   297	330	429	java/io/IOException
    //   373	407	429	java/io/IOException
    //   426	429	429	java/io/IOException
    //   459	462	429	java/io/IOException
    //   444	448	449	java/io/IOException
    //   330	373	455	finally
    //   457	459	455	finally
    //   134	163	462	finally
    //   167	227	462	finally
    //   227	235	462	finally
    //   254	277	462	finally
    //   297	330	462	finally
    //   373	407	462	finally
    //   426	429	462	finally
    //   459	462	462	finally
    //   467	471	473	java/io/IOException
    //   489	509	596	java/lang/OutOfMemoryError
    //   519	561	612	finally
    //   613	615	612	finally
    //   92	125	617	finally
    //   125	134	617	finally
    //   436	440	623	finally
    //   92	125	633	java/io/IOException
    //   125	134	633	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.ReadFileThread
 * JD-Core Version:    0.7.0.1
 */