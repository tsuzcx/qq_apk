package com.tencent.TMG.ptt;

class PCMPlayer$PlayThread
  extends Thread
{
  PttListener.PlayFileListener callBack = null;
  public volatile boolean isRunning = true;
  public String playPath = "";
  
  public PCMPlayer$PlayThread(PCMPlayer paramPCMPlayer, String paramString, PttListener.PlayFileListener paramPlayFileListener)
  {
    this.playPath = paramString;
    this.callBack = paramPlayFileListener;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   3: invokevirtual 45	com/tencent/TMG/ptt/TraeJni:initTRAE	()Z
    //   6: pop
    //   7: new 47	java/io/FileInputStream
    //   10: dup
    //   11: new 49	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: getfield 25	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
    //   19: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 5
    //   27: aload 5
    //   29: invokevirtual 59	java/io/FileInputStream:available	()I
    //   32: istore_3
    //   33: aload_0
    //   34: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   37: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   40: astore 6
    //   42: new 66	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: ldc 69
    //   55: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 7
    //   61: iload_3
    //   62: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 6
    //   68: aload 7
    //   70: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: iload_3
    //   78: newarray byte
    //   80: astore 6
    //   82: aload 5
    //   84: aload 6
    //   86: invokevirtual 90	java/io/FileInputStream:read	([B)I
    //   89: istore_1
    //   90: aload_0
    //   91: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   94: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   97: astore 7
    //   99: new 66	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   106: astore 8
    //   108: aload 8
    //   110: ldc 92
    //   112: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 8
    //   118: iload_1
    //   119: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 7
    //   125: aload 8
    //   127: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   133: pop
    //   134: aload 5
    //   136: invokevirtual 95	java/io/FileInputStream:close	()V
    //   139: bipush 9
    //   141: istore_2
    //   142: iconst_0
    //   143: istore_1
    //   144: iload_2
    //   145: iload_3
    //   146: if_icmpge +166 -> 312
    //   149: aload_0
    //   150: getfield 21	com/tencent/TMG/ptt/PCMPlayer$PlayThread:isRunning	Z
    //   153: ifeq +159 -> 312
    //   156: aload 6
    //   158: iload_2
    //   159: iconst_1
    //   160: iadd
    //   161: baload
    //   162: bipush 8
    //   164: ishl
    //   165: aload 6
    //   167: iload_2
    //   168: baload
    //   169: iadd
    //   170: istore 4
    //   172: iload_2
    //   173: iconst_2
    //   174: iadd
    //   175: istore_2
    //   176: iload 4
    //   178: newarray byte
    //   180: astore 7
    //   182: aload 6
    //   184: iload_2
    //   185: aload 7
    //   187: iconst_0
    //   188: iload 4
    //   190: invokestatic 101	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   193: invokestatic 41	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   196: aload 7
    //   198: iload 4
    //   200: i2l
    //   201: invokevirtual 105	com/tencent/TMG/ptt/TraeJni:turnPCM	([BJ)[B
    //   204: astore 7
    //   206: iload_2
    //   207: iload 4
    //   209: iadd
    //   210: istore_2
    //   211: aload_0
    //   212: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   215: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   218: aload 7
    //   220: iconst_0
    //   221: aload 7
    //   223: arraylength
    //   224: invokevirtual 115	android/media/AudioTrack:write	([BII)I
    //   227: pop
    //   228: iload_1
    //   229: iconst_1
    //   230: iadd
    //   231: istore_1
    //   232: aload_0
    //   233: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   236: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   239: astore 8
    //   241: new 66	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   248: astore 9
    //   250: aload 9
    //   252: ldc 117
    //   254: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 9
    //   260: iload 4
    //   262: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 9
    //   268: ldc 119
    //   270: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 9
    //   276: aload 7
    //   278: arraylength
    //   279: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 9
    //   285: ldc 121
    //   287: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 9
    //   293: iload_1
    //   294: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 8
    //   300: aload 9
    //   302: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   308: pop
    //   309: goto -165 -> 144
    //   312: aload 5
    //   314: invokevirtual 95	java/io/FileInputStream:close	()V
    //   317: aload_0
    //   318: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   321: iconst_0
    //   322: aload_0
    //   323: getfield 25	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
    //   326: invokeinterface 130 3 0
    //   331: aload_0
    //   332: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   335: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   338: ldc 132
    //   340: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   343: pop
    //   344: aload_0
    //   345: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   348: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   351: ifnull +295 -> 646
    //   354: goto +263 -> 617
    //   357: astore 5
    //   359: goto +311 -> 670
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   368: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   371: astore 6
    //   373: new 66	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   380: astore 7
    //   382: aload 7
    //   384: ldc 134
    //   386: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 7
    //   392: aload 5
    //   394: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 6
    //   400: aload 7
    //   402: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   408: pop
    //   409: aload_0
    //   410: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   413: sipush 20484
    //   416: aconst_null
    //   417: invokeinterface 130 3 0
    //   422: aload_0
    //   423: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   426: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   429: ldc 132
    //   431: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   434: pop
    //   435: aload_0
    //   436: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   439: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   442: ifnull +204 -> 646
    //   445: goto +172 -> 617
    //   448: astore 5
    //   450: aload_0
    //   451: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   454: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   457: astore 6
    //   459: new 66	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   466: astore 7
    //   468: aload 7
    //   470: ldc 139
    //   472: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 7
    //   478: aload 5
    //   480: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 6
    //   486: aload 7
    //   488: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   494: pop
    //   495: aload_0
    //   496: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   499: sipush 20484
    //   502: aconst_null
    //   503: invokeinterface 130 3 0
    //   508: aload_0
    //   509: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   512: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   515: ldc 132
    //   517: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   520: pop
    //   521: aload_0
    //   522: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   525: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   528: ifnull +118 -> 646
    //   531: goto +86 -> 617
    //   534: astore 5
    //   536: aload_0
    //   537: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   540: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   543: astore 6
    //   545: new 66	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   552: astore 7
    //   554: aload 7
    //   556: ldc 141
    //   558: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 7
    //   564: aload 5
    //   566: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 6
    //   572: aload 7
    //   574: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   580: pop
    //   581: aload_0
    //   582: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   585: sipush 20484
    //   588: aconst_null
    //   589: invokeinterface 130 3 0
    //   594: aload_0
    //   595: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   598: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   601: ldc 132
    //   603: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   606: pop
    //   607: aload_0
    //   608: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   611: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   614: ifnull +32 -> 646
    //   617: aload_0
    //   618: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   621: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   624: invokevirtual 144	android/media/AudioTrack:stop	()V
    //   627: aload_0
    //   628: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   631: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   634: invokevirtual 147	android/media/AudioTrack:release	()V
    //   637: aload_0
    //   638: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   641: aconst_null
    //   642: invokestatic 151	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   645: pop
    //   646: aload_0
    //   647: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   650: astore 5
    //   652: aload 5
    //   654: aconst_null
    //   655: putfield 155	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   658: aload 5
    //   660: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   663: ldc 157
    //   665: invokestatic 160	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   668: pop
    //   669: return
    //   670: aload_0
    //   671: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   674: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   677: ldc 132
    //   679: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   682: pop
    //   683: aload_0
    //   684: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   687: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   690: ifnull +32 -> 722
    //   693: aload_0
    //   694: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   697: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   700: invokevirtual 144	android/media/AudioTrack:stop	()V
    //   703: aload_0
    //   704: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   707: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   710: invokevirtual 147	android/media/AudioTrack:release	()V
    //   713: aload_0
    //   714: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   717: aconst_null
    //   718: invokestatic 151	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   721: pop
    //   722: aload_0
    //   723: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   726: astore 6
    //   728: aload 6
    //   730: aconst_null
    //   731: putfield 155	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   734: aload 6
    //   736: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   739: ldc 157
    //   741: invokestatic 160	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   744: pop
    //   745: goto +6 -> 751
    //   748: aload 5
    //   750: athrow
    //   751: goto -3 -> 748
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	754	0	this	PlayThread
    //   89	205	1	i	int
    //   141	70	2	j	int
    //   32	115	3	k	int
    //   170	91	4	m	int
    //   25	288	5	localFileInputStream	java.io.FileInputStream
    //   357	1	5	localObject1	java.lang.Object
    //   362	31	5	localException	java.lang.Exception
    //   448	31	5	localIOException	java.io.IOException
    //   534	31	5	localFileNotFoundException	java.io.FileNotFoundException
    //   650	99	5	localPCMPlayer	PCMPlayer
    //   40	695	6	localObject2	java.lang.Object
    //   49	524	7	localObject3	java.lang.Object
    //   106	193	8	localObject4	java.lang.Object
    //   248	53	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	139	357	finally
    //   149	156	357	finally
    //   176	206	357	finally
    //   211	228	357	finally
    //   232	309	357	finally
    //   312	331	357	finally
    //   364	422	357	finally
    //   450	508	357	finally
    //   536	594	357	finally
    //   0	139	362	java/lang/Exception
    //   149	156	362	java/lang/Exception
    //   176	206	362	java/lang/Exception
    //   211	228	362	java/lang/Exception
    //   232	309	362	java/lang/Exception
    //   312	331	362	java/lang/Exception
    //   0	139	448	java/io/IOException
    //   149	156	448	java/io/IOException
    //   176	206	448	java/io/IOException
    //   211	228	448	java/io/IOException
    //   232	309	448	java/io/IOException
    //   312	331	448	java/io/IOException
    //   0	139	534	java/io/FileNotFoundException
    //   149	156	534	java/io/FileNotFoundException
    //   176	206	534	java/io/FileNotFoundException
    //   211	228	534	java/io/FileNotFoundException
    //   232	309	534	java/io/FileNotFoundException
    //   312	331	534	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PCMPlayer.PlayThread
 * JD-Core Version:    0.7.0.1
 */