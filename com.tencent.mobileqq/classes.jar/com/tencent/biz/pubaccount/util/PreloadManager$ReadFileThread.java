package com.tencent.biz.pubaccount.util;

class PreloadManager$ReadFileThread
  implements Runnable
{
  String a;
  String b;
  boolean c = false;
  
  public PreloadManager$ReadFileThread(PreloadManager paramPreloadManager, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:a	Ljava/lang/String;
    //   4: invokestatic 38	com/tencent/biz/pubaccount/util/PreloadManager:d	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 24	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:a	Ljava/lang/String;
    //   20: ldc 40
    //   22: invokevirtual 46	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: putfield 22	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:c	Z
    //   28: aload_0
    //   29: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   32: invokestatic 49	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
    //   35: aload 5
    //   37: invokevirtual 55	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 57	[B
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +495 -> 540
    //   48: new 59	java/io/File
    //   51: dup
    //   52: new 59	java/io/File
    //   55: dup
    //   56: getstatic 64	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   59: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: aload 5
    //   64: invokespecial 70	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 74	java/io/File:exists	()Z
    //   74: ifeq +586 -> 660
    //   77: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   80: aload 6
    //   82: invokevirtual 83	java/io/File:lastModified	()J
    //   85: lsub
    //   86: ldc2_w 84
    //   89: lcmp
    //   90: ifge +570 -> 660
    //   93: aconst_null
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +48 -> 151
    //   106: aload_3
    //   107: astore_2
    //   108: new 92	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   115: astore 7
    //   117: aload_3
    //   118: astore_2
    //   119: aload 7
    //   121: ldc 95
    //   123: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore_2
    //   129: aload 7
    //   131: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   134: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: astore_2
    //   140: ldc 104
    //   142: iconst_2
    //   143: aload 7
    //   145: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_3
    //   152: astore_2
    //   153: new 113	java/io/FileInputStream
    //   156: dup
    //   157: aload 6
    //   159: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 120	java/io/FileInputStream:available	()I
    //   167: newarray byte
    //   169: astore_2
    //   170: aload_3
    //   171: aload_2
    //   172: invokevirtual 124	java/io/FileInputStream:read	([B)I
    //   175: pop
    //   176: aload_3
    //   177: invokevirtual 127	java/io/FileInputStream:close	()V
    //   180: aload_0
    //   181: getfield 26	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:b	Ljava/lang/String;
    //   184: invokestatic 131	com/tencent/biz/pubaccount/util/PreloadManager:e	(Ljava/lang/String;)[B
    //   187: aload_2
    //   188: invokestatic 134	com/tencent/biz/pubaccount/util/PreloadManager:a	([B[B)[B
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +276 -> 469
    //   196: new 42	java/lang/String
    //   199: dup
    //   200: aload_2
    //   201: invokespecial 137	java/lang/String:<init>	([B)V
    //   204: astore_2
    //   205: aload_2
    //   206: aload_2
    //   207: ldc 139
    //   209: invokevirtual 143	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: bipush 10
    //   214: iadd
    //   215: aload_2
    //   216: invokevirtual 146	java/lang/String:length	()I
    //   219: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   222: astore 4
    //   224: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +39 -> 266
    //   230: new 92	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   237: astore 6
    //   239: aload 6
    //   241: ldc 152
    //   243: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 6
    //   249: aload 4
    //   251: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 104
    //   257: iconst_2
    //   258: aload 6
    //   260: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload 5
    //   268: aload 4
    //   270: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: istore_1
    //   274: iload_1
    //   275: ifne +14 -> 289
    //   278: aload_3
    //   279: invokevirtual 127	java/io/FileInputStream:close	()V
    //   282: return
    //   283: astore_2
    //   284: aload_2
    //   285: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: aload_2
    //   290: iconst_0
    //   291: aload_2
    //   292: ldc 139
    //   294: invokevirtual 143	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   297: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   300: astore 4
    //   302: aload_0
    //   303: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   306: getfield 163	com/tencent/biz/pubaccount/util/PreloadManager:g	Ljava/lang/Object;
    //   309: astore_2
    //   310: aload_2
    //   311: monitorenter
    //   312: aload_0
    //   313: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   316: invokestatic 49	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
    //   319: aload 5
    //   321: aload 4
    //   323: invokevirtual 167	java/lang/String:getBytes	()[B
    //   326: invokevirtual 171	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: aload_2
    //   331: monitorexit
    //   332: new 173	java/util/ArrayList
    //   335: dup
    //   336: invokespecial 174	java/util/ArrayList:<init>	()V
    //   339: pop
    //   340: aload_0
    //   341: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   344: aload 4
    //   346: aload_0
    //   347: getfield 22	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:c	Z
    //   350: invokestatic 177	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   353: astore 4
    //   355: aload_0
    //   356: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   359: getfield 179	com/tencent/biz/pubaccount/util/PreloadManager:d	Ljava/lang/Object;
    //   362: astore_2
    //   363: aload_2
    //   364: monitorenter
    //   365: aload_0
    //   366: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   369: invokestatic 182	com/tencent/biz/pubaccount/util/PreloadManager:d	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
    //   372: aload 5
    //   374: aload 4
    //   376: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: pop
    //   380: new 92	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   387: astore 4
    //   389: aload 4
    //   391: ldc 187
    //   393: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 4
    //   399: aload 5
    //   401: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: ldc 104
    //   407: iconst_2
    //   408: aload 4
    //   410: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_2
    //   417: monitorexit
    //   418: aload_0
    //   419: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   422: getfield 188	com/tencent/biz/pubaccount/util/PreloadManager:c	Z
    //   425: ifne +44 -> 469
    //   428: invokestatic 193	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   431: iconst_1
    //   432: if_icmpne +37 -> 469
    //   435: aload_0
    //   436: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   439: invokevirtual 195	com/tencent/biz/pubaccount/util/PreloadManager:g	()Z
    //   442: ifeq +27 -> 469
    //   445: aload_0
    //   446: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   449: invokevirtual 197	com/tencent/biz/pubaccount/util/PreloadManager:e	()V
    //   452: goto +17 -> 469
    //   455: astore 4
    //   457: aload_2
    //   458: monitorexit
    //   459: aload 4
    //   461: athrow
    //   462: astore 4
    //   464: aload_2
    //   465: monitorexit
    //   466: aload 4
    //   468: athrow
    //   469: aload_3
    //   470: invokevirtual 127	java/io/FileInputStream:close	()V
    //   473: return
    //   474: astore_2
    //   475: goto +47 -> 522
    //   478: astore 4
    //   480: goto +20 -> 500
    //   483: astore 4
    //   485: aload_2
    //   486: astore_3
    //   487: aload 4
    //   489: astore_2
    //   490: goto +32 -> 522
    //   493: astore_2
    //   494: aload 4
    //   496: astore_3
    //   497: aload_2
    //   498: astore 4
    //   500: aload_3
    //   501: astore_2
    //   502: aload 4
    //   504: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   507: aload_3
    //   508: ifnull +152 -> 660
    //   511: aload_3
    //   512: invokevirtual 127	java/io/FileInputStream:close	()V
    //   515: return
    //   516: astore_2
    //   517: aload_2
    //   518: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   521: return
    //   522: aload_3
    //   523: ifnull +15 -> 538
    //   526: aload_3
    //   527: invokevirtual 127	java/io/FileInputStream:close	()V
    //   530: goto +8 -> 538
    //   533: astore_3
    //   534: aload_3
    //   535: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   538: aload_2
    //   539: athrow
    //   540: new 173	java/util/ArrayList
    //   543: dup
    //   544: invokespecial 174	java/util/ArrayList:<init>	()V
    //   547: pop
    //   548: aload_0
    //   549: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   552: new 42	java/lang/String
    //   555: dup
    //   556: aload_2
    //   557: invokespecial 137	java/lang/String:<init>	([B)V
    //   560: aload_0
    //   561: getfield 22	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:c	Z
    //   564: invokestatic 177	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   567: astore_3
    //   568: aload_0
    //   569: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   572: getfield 179	com/tencent/biz/pubaccount/util/PreloadManager:d	Ljava/lang/Object;
    //   575: astore_2
    //   576: aload_2
    //   577: monitorenter
    //   578: aload_0
    //   579: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   582: invokestatic 182	com/tencent/biz/pubaccount/util/PreloadManager:d	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
    //   585: aload 5
    //   587: aload_3
    //   588: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   591: pop
    //   592: new 92	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   599: astore_3
    //   600: aload_3
    //   601: ldc 187
    //   603: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_3
    //   608: aload 5
    //   610: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: ldc 104
    //   616: iconst_2
    //   617: aload_3
    //   618: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload_2
    //   625: monitorexit
    //   626: aload_0
    //   627: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   630: getfield 188	com/tencent/biz/pubaccount/util/PreloadManager:c	Z
    //   633: ifne +27 -> 660
    //   636: invokestatic 193	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   639: iconst_1
    //   640: if_icmpne +20 -> 660
    //   643: aload_0
    //   644: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   647: invokevirtual 195	com/tencent/biz/pubaccount/util/PreloadManager:g	()Z
    //   650: ifeq +10 -> 660
    //   653: aload_0
    //   654: getfield 17	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
    //   657: invokevirtual 197	com/tencent/biz/pubaccount/util/PreloadManager:e	()V
    //   660: return
    //   661: astore_3
    //   662: aload_2
    //   663: monitorexit
    //   664: aload_3
    //   665: athrow
    //   666: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +11 -> 680
    //   672: ldc 104
    //   674: iconst_2
    //   675: ldc 199
    //   677: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: return
    //   681: astore_2
    //   682: goto -16 -> 666
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	ReadFileThread
    //   273	2	1	bool	boolean
    //   43	173	2	localObject1	Object
    //   283	9	2	localIOException1	java.io.IOException
    //   309	156	2	localObject2	Object
    //   474	12	2	localObject3	Object
    //   489	1	2	localObject4	Object
    //   493	5	2	localIOException2	java.io.IOException
    //   501	1	2	localObject5	Object
    //   516	41	2	localIOException3	java.io.IOException
    //   575	88	2	localObject6	Object
    //   681	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   97	430	3	localObject7	Object
    //   533	2	3	localIOException4	java.io.IOException
    //   567	51	3	localObject8	Object
    //   661	4	3	localObject9	Object
    //   94	315	4	localObject10	Object
    //   455	5	4	localObject11	Object
    //   462	5	4	localObject12	Object
    //   478	1	4	localIOException5	java.io.IOException
    //   483	12	4	localObject13	Object
    //   498	5	4	localIOException6	java.io.IOException
    //   7	602	5	str	String
    //   67	192	6	localObject14	Object
    //   115	29	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   278	282	283	java/io/IOException
    //   365	418	455	finally
    //   457	459	455	finally
    //   312	332	462	finally
    //   464	466	462	finally
    //   163	192	474	finally
    //   196	266	474	finally
    //   266	274	474	finally
    //   289	312	474	finally
    //   332	365	474	finally
    //   418	452	474	finally
    //   459	462	474	finally
    //   466	469	474	finally
    //   163	192	478	java/io/IOException
    //   196	266	478	java/io/IOException
    //   266	274	478	java/io/IOException
    //   289	312	478	java/io/IOException
    //   332	365	478	java/io/IOException
    //   418	452	478	java/io/IOException
    //   459	462	478	java/io/IOException
    //   466	469	478	java/io/IOException
    //   100	106	483	finally
    //   108	117	483	finally
    //   119	127	483	finally
    //   129	138	483	finally
    //   140	151	483	finally
    //   153	163	483	finally
    //   502	507	483	finally
    //   100	106	493	java/io/IOException
    //   108	117	493	java/io/IOException
    //   119	127	493	java/io/IOException
    //   129	138	493	java/io/IOException
    //   140	151	493	java/io/IOException
    //   153	163	493	java/io/IOException
    //   469	473	516	java/io/IOException
    //   511	515	516	java/io/IOException
    //   526	530	533	java/io/IOException
    //   578	626	661	finally
    //   662	664	661	finally
    //   548	568	681	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.ReadFileThread
 * JD-Core Version:    0.7.0.1
 */