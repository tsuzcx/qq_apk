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
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 41	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   5: invokevirtual 45	com/tencent/TMG/ptt/TraeJni:initTRAE	()Z
    //   8: pop
    //   9: new 47	java/io/FileInputStream
    //   12: dup
    //   13: new 49	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield 25	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
    //   21: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 59	java/io/FileInputStream:available	()I
    //   34: istore_3
    //   35: aload_0
    //   36: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   39: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   42: new 66	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   49: ldc 69
    //   51: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_3
    //   55: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 6
    //   70: aload 5
    //   72: aload 6
    //   74: invokevirtual 90	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: aload_0
    //   79: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   82: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   85: new 66	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   92: ldc 92
    //   94: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_2
    //   98: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   107: pop
    //   108: aload 5
    //   110: invokevirtual 95	java/io/FileInputStream:close	()V
    //   113: bipush 9
    //   115: istore_2
    //   116: iload_2
    //   117: iload_3
    //   118: if_icmpge +260 -> 378
    //   121: aload_0
    //   122: getfield 21	com/tencent/TMG/ptt/PCMPlayer$PlayThread:isRunning	Z
    //   125: ifeq +253 -> 378
    //   128: aload 6
    //   130: iload_2
    //   131: iconst_1
    //   132: iadd
    //   133: baload
    //   134: bipush 8
    //   136: ishl
    //   137: aload 6
    //   139: iload_2
    //   140: baload
    //   141: iadd
    //   142: istore 4
    //   144: iload_2
    //   145: iconst_2
    //   146: iadd
    //   147: istore_2
    //   148: iload 4
    //   150: newarray byte
    //   152: astore 7
    //   154: aload 6
    //   156: iload_2
    //   157: aload 7
    //   159: iconst_0
    //   160: iload 4
    //   162: invokestatic 101	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   165: invokestatic 41	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   168: aload 7
    //   170: iload 4
    //   172: i2l
    //   173: invokevirtual 105	com/tencent/TMG/ptt/TraeJni:turnPCM	([BJ)[B
    //   176: astore 7
    //   178: iload_2
    //   179: iload 4
    //   181: iadd
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   187: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   190: aload 7
    //   192: iconst_0
    //   193: aload 7
    //   195: arraylength
    //   196: invokevirtual 115	android/media/AudioTrack:write	([BII)I
    //   199: pop
    //   200: iload_1
    //   201: iconst_1
    //   202: iadd
    //   203: istore_1
    //   204: aload_0
    //   205: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   208: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   211: new 66	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   218: ldc 117
    //   220: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 4
    //   225: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc 119
    //   230: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 7
    //   235: arraylength
    //   236: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc 121
    //   241: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_1
    //   245: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: goto -139 -> 116
    //   258: astore 5
    //   260: aload_0
    //   261: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   264: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   267: new 66	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   274: ldc 126
    //   276: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   290: pop
    //   291: aload_0
    //   292: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   295: sipush 20484
    //   298: aconst_null
    //   299: invokeinterface 135 3 0
    //   304: aload_0
    //   305: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   308: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   311: ldc 137
    //   313: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   316: pop
    //   317: aload_0
    //   318: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   321: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   324: ifnull +32 -> 356
    //   327: aload_0
    //   328: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   331: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   334: invokevirtual 140	android/media/AudioTrack:stop	()V
    //   337: aload_0
    //   338: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   341: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   344: invokevirtual 143	android/media/AudioTrack:release	()V
    //   347: aload_0
    //   348: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   351: aconst_null
    //   352: invokestatic 147	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   355: pop
    //   356: aload_0
    //   357: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   360: aconst_null
    //   361: putfield 151	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   364: aload_0
    //   365: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   368: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   371: ldc 153
    //   373: invokestatic 156	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   376: pop
    //   377: return
    //   378: aload 5
    //   380: ifnull +8 -> 388
    //   383: aload 5
    //   385: invokevirtual 95	java/io/FileInputStream:close	()V
    //   388: aload_0
    //   389: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   392: iconst_0
    //   393: aload_0
    //   394: getfield 25	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
    //   397: invokeinterface 135 3 0
    //   402: aload_0
    //   403: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   406: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   409: ldc 137
    //   411: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: aload_0
    //   416: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   419: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   422: ifnull +32 -> 454
    //   425: aload_0
    //   426: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   429: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   432: invokevirtual 140	android/media/AudioTrack:stop	()V
    //   435: aload_0
    //   436: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   439: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   442: invokevirtual 143	android/media/AudioTrack:release	()V
    //   445: aload_0
    //   446: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   449: aconst_null
    //   450: invokestatic 147	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   453: pop
    //   454: aload_0
    //   455: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   458: aconst_null
    //   459: putfield 151	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   462: aload_0
    //   463: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   466: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   469: ldc 153
    //   471: invokestatic 156	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   474: pop
    //   475: return
    //   476: astore 5
    //   478: aload_0
    //   479: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   482: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   485: new 66	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   492: ldc 158
    //   494: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 5
    //   499: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   508: pop
    //   509: aload_0
    //   510: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   513: sipush 20484
    //   516: aconst_null
    //   517: invokeinterface 135 3 0
    //   522: aload_0
    //   523: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   526: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   529: ldc 137
    //   531: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   534: pop
    //   535: aload_0
    //   536: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   539: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   542: ifnull +32 -> 574
    //   545: aload_0
    //   546: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   549: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   552: invokevirtual 140	android/media/AudioTrack:stop	()V
    //   555: aload_0
    //   556: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   559: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   562: invokevirtual 143	android/media/AudioTrack:release	()V
    //   565: aload_0
    //   566: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   569: aconst_null
    //   570: invokestatic 147	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   573: pop
    //   574: aload_0
    //   575: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   578: aconst_null
    //   579: putfield 151	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   582: aload_0
    //   583: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   586: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   589: ldc 153
    //   591: invokestatic 156	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   594: pop
    //   595: return
    //   596: astore 5
    //   598: aload_0
    //   599: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   602: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   605: new 66	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   612: ldc 160
    //   614: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload 5
    //   619: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   628: pop
    //   629: aload_0
    //   630: getfield 27	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
    //   633: sipush 20484
    //   636: aconst_null
    //   637: invokeinterface 135 3 0
    //   642: aload_0
    //   643: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   646: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   649: ldc 137
    //   651: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   654: pop
    //   655: aload_0
    //   656: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   659: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   662: ifnull +32 -> 694
    //   665: aload_0
    //   666: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   669: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   672: invokevirtual 140	android/media/AudioTrack:stop	()V
    //   675: aload_0
    //   676: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   679: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   682: invokevirtual 143	android/media/AudioTrack:release	()V
    //   685: aload_0
    //   686: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   689: aconst_null
    //   690: invokestatic 147	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   693: pop
    //   694: aload_0
    //   695: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   698: aconst_null
    //   699: putfield 151	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   702: aload_0
    //   703: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   706: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   709: ldc 153
    //   711: invokestatic 156	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   714: pop
    //   715: return
    //   716: astore 5
    //   718: aload_0
    //   719: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   722: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   725: ldc 137
    //   727: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   730: pop
    //   731: aload_0
    //   732: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   735: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   738: ifnull +32 -> 770
    //   741: aload_0
    //   742: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   745: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   748: invokevirtual 140	android/media/AudioTrack:stop	()V
    //   751: aload_0
    //   752: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   755: invokestatic 109	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
    //   758: invokevirtual 143	android/media/AudioTrack:release	()V
    //   761: aload_0
    //   762: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   765: aconst_null
    //   766: invokestatic 147	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   769: pop
    //   770: aload_0
    //   771: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   774: aconst_null
    //   775: putfield 151	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
    //   778: aload_0
    //   779: getfield 16	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
    //   782: getfield 64	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   785: ldc 153
    //   787: invokestatic 156	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   790: pop
    //   791: aload 5
    //   793: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	PlayThread
    //   1	244	1	i	int
    //   77	106	2	j	int
    //   34	85	3	k	int
    //   142	82	4	m	int
    //   27	82	5	localFileInputStream	java.io.FileInputStream
    //   258	126	5	localFileNotFoundException	java.io.FileNotFoundException
    //   476	22	5	localIOException	java.io.IOException
    //   596	22	5	localException	java.lang.Exception
    //   716	76	5	localObject	java.lang.Object
    //   68	87	6	arrayOfByte1	byte[]
    //   152	82	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	113	258	java/io/FileNotFoundException
    //   121	128	258	java/io/FileNotFoundException
    //   148	178	258	java/io/FileNotFoundException
    //   183	200	258	java/io/FileNotFoundException
    //   204	255	258	java/io/FileNotFoundException
    //   383	388	258	java/io/FileNotFoundException
    //   388	402	258	java/io/FileNotFoundException
    //   2	113	476	java/io/IOException
    //   121	128	476	java/io/IOException
    //   148	178	476	java/io/IOException
    //   183	200	476	java/io/IOException
    //   204	255	476	java/io/IOException
    //   383	388	476	java/io/IOException
    //   388	402	476	java/io/IOException
    //   2	113	596	java/lang/Exception
    //   121	128	596	java/lang/Exception
    //   148	178	596	java/lang/Exception
    //   183	200	596	java/lang/Exception
    //   204	255	596	java/lang/Exception
    //   383	388	596	java/lang/Exception
    //   388	402	596	java/lang/Exception
    //   2	113	716	finally
    //   121	128	716	finally
    //   148	178	716	finally
    //   183	200	716	finally
    //   204	255	716	finally
    //   260	304	716	finally
    //   383	388	716	finally
    //   388	402	716	finally
    //   478	522	716	finally
    //   598	642	716	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PCMPlayer.PlayThread
 * JD-Core Version:    0.7.0.1
 */