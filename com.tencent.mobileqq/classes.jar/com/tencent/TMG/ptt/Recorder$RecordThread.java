package com.tencent.TMG.ptt;

class Recorder$RecordThread
  extends Thread
{
  public volatile boolean isRunning = true;
  public volatile boolean unNormal = false;
  
  public Recorder$RecordThread(Recorder paramRecorder, String paramString)
  {
    paramRecorder.recorderPath = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: ldc 37
    //   13: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 14
    //   19: aload_0
    //   20: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 46
    //   26: aload 14
    //   28: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: aload_0
    //   36: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   39: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   42: astore 14
    //   44: aload 14
    //   46: ifnull +35 -> 81
    //   49: aload_0
    //   50: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   53: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   56: aload_0
    //   57: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   60: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   63: invokeinterface 66 2 0
    //   68: goto +13 -> 81
    //   71: astore 14
    //   73: goto +1373 -> 1446
    //   76: astore 14
    //   78: goto +1375 -> 1453
    //   81: aload_0
    //   82: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   85: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   88: newarray byte
    //   90: astore 16
    //   92: new 72	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   100: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   103: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore 15
    //   108: aload_0
    //   109: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   112: aload_0
    //   113: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   116: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   119: putfield 77	com/tencent/TMG/ptt/Recorder:silkFilePath	Ljava/lang/String;
    //   122: aload 15
    //   124: invokevirtual 81	java/io/File:exists	()Z
    //   127: istore 7
    //   129: iload 7
    //   131: ifeq +17 -> 148
    //   134: ldc 46
    //   136: ldc 83
    //   138: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: aload 15
    //   144: invokevirtual 86	java/io/File:delete	()Z
    //   147: pop
    //   148: aload 15
    //   150: invokevirtual 89	java/io/File:createNewFile	()Z
    //   153: pop
    //   154: new 91	java/io/FileOutputStream
    //   157: dup
    //   158: aload 15
    //   160: invokespecial 94	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: astore 17
    //   165: aload 17
    //   167: ldc 96
    //   169: invokevirtual 102	java/lang/String:getBytes	()[B
    //   172: invokevirtual 106	java/io/FileOutputStream:write	([B)V
    //   175: aload_0
    //   176: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   179: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   182: ifnull +1033 -> 1215
    //   185: aload_0
    //   186: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   189: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   192: invokevirtual 115	android/media/AudioRecord:startRecording	()V
    //   195: aload_0
    //   196: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   199: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   202: ifnull +15 -> 217
    //   205: aload_0
    //   206: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   209: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   212: invokeinterface 118 1 0
    //   217: lconst_0
    //   218: lstore 10
    //   220: lload 10
    //   222: lstore 12
    //   224: aconst_null
    //   225: astore 14
    //   227: iconst_0
    //   228: istore 5
    //   230: iconst_0
    //   231: istore_1
    //   232: iload_1
    //   233: istore_2
    //   234: iload_1
    //   235: istore_3
    //   236: aload_0
    //   237: getfield 18	com/tencent/TMG/ptt/Recorder$RecordThread:isRunning	Z
    //   240: ifeq +738 -> 978
    //   243: lload 10
    //   245: lconst_0
    //   246: lcmp
    //   247: ifeq +39 -> 286
    //   250: iload_1
    //   251: istore_2
    //   252: iload_1
    //   253: istore_3
    //   254: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   257: lload 10
    //   259: lsub
    //   260: aload_0
    //   261: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   264: invokestatic 128	com/tencent/TMG/ptt/Recorder:access$300	(Lcom/tencent/TMG/ptt/Recorder;)J
    //   267: lcmp
    //   268: iflt +18 -> 286
    //   271: iload_1
    //   272: istore_2
    //   273: iload_1
    //   274: istore_3
    //   275: ldc 46
    //   277: ldc 130
    //   279: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   282: pop
    //   283: goto +695 -> 978
    //   286: iload 5
    //   288: istore 4
    //   290: lload 10
    //   292: lconst_0
    //   293: lcmp
    //   294: ifeq +97 -> 391
    //   297: iload 5
    //   299: istore 4
    //   301: iload_1
    //   302: istore_2
    //   303: iload_1
    //   304: istore_3
    //   305: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   308: lload 10
    //   310: lsub
    //   311: aload_0
    //   312: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   315: invokestatic 133	com/tencent/TMG/ptt/Recorder:access$400	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   318: i2l
    //   319: lcmp
    //   320: ifle +71 -> 391
    //   323: iload 5
    //   325: istore 4
    //   327: iload 5
    //   329: ifne +62 -> 391
    //   332: lload 12
    //   334: lconst_0
    //   335: lcmp
    //   336: ifne +1295 -> 1631
    //   339: iload_1
    //   340: istore_2
    //   341: iload_1
    //   342: istore_3
    //   343: aload_0
    //   344: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   347: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   350: ifnull +1281 -> 1631
    //   353: iload_1
    //   354: istore_2
    //   355: iload_1
    //   356: istore_3
    //   357: aload_0
    //   358: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   361: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   364: iconst_0
    //   365: invokeinterface 137 2 0
    //   370: iload_1
    //   371: istore_2
    //   372: iload_1
    //   373: istore_3
    //   374: aload_0
    //   375: iconst_0
    //   376: putfield 18	com/tencent/TMG/ptt/Recorder$RecordThread:isRunning	Z
    //   379: iload_1
    //   380: istore_2
    //   381: iload_1
    //   382: istore_3
    //   383: aload_0
    //   384: iconst_1
    //   385: putfield 20	com/tencent/TMG/ptt/Recorder$RecordThread:unNormal	Z
    //   388: goto +1243 -> 1631
    //   391: aload 14
    //   393: ifnull +1244 -> 1637
    //   396: iload_1
    //   397: istore_2
    //   398: iload_1
    //   399: istore_3
    //   400: aload 14
    //   402: arraylength
    //   403: istore 5
    //   405: iload_1
    //   406: istore_2
    //   407: iload_1
    //   408: istore_3
    //   409: aload 14
    //   411: iconst_0
    //   412: aload 16
    //   414: iconst_0
    //   415: iload 5
    //   417: invokestatic 143	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   420: goto +3 -> 423
    //   423: iload_1
    //   424: istore_2
    //   425: iload_1
    //   426: istore_3
    //   427: aload_0
    //   428: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   431: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   434: aload 16
    //   436: iload 5
    //   438: aload_0
    //   439: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   442: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   445: iload 5
    //   447: isub
    //   448: invokevirtual 147	android/media/AudioRecord:read	([BII)I
    //   451: istore 6
    //   453: lload 10
    //   455: lstore 8
    //   457: lload 10
    //   459: lconst_0
    //   460: lcmp
    //   461: ifne +12 -> 473
    //   464: iload_1
    //   465: istore_2
    //   466: iload_1
    //   467: istore_3
    //   468: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   471: lstore 8
    //   473: iload_1
    //   474: istore_2
    //   475: iload_1
    //   476: istore_3
    //   477: aload_0
    //   478: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   481: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   484: iload 5
    //   486: isub
    //   487: iload 6
    //   489: if_icmpeq +1154 -> 1643
    //   492: iload_1
    //   493: istore_2
    //   494: iload_1
    //   495: istore_3
    //   496: new 34	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   503: astore 18
    //   505: iload_1
    //   506: istore_2
    //   507: iload_1
    //   508: istore_3
    //   509: aload 18
    //   511: ldc 149
    //   513: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: iload_1
    //   518: istore_2
    //   519: iload_1
    //   520: istore_3
    //   521: aload 18
    //   523: aload_0
    //   524: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   527: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   530: iload 5
    //   532: isub
    //   533: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: iload_1
    //   538: istore_2
    //   539: iload_1
    //   540: istore_3
    //   541: aload 18
    //   543: ldc 154
    //   545: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: iload_1
    //   550: istore_2
    //   551: iload_1
    //   552: istore_3
    //   553: aload 18
    //   555: iload 6
    //   557: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: iload_1
    //   562: istore_2
    //   563: iload_1
    //   564: istore_3
    //   565: ldc 46
    //   567: aload 18
    //   569: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   575: pop
    //   576: goto +3 -> 579
    //   579: iload_1
    //   580: istore_2
    //   581: iload_1
    //   582: istore_3
    //   583: aload_0
    //   584: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   587: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   590: ifnull +19 -> 609
    //   593: iload_1
    //   594: istore_2
    //   595: iload_1
    //   596: istore_3
    //   597: aload_0
    //   598: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   601: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   604: invokeinterface 157 1 0
    //   609: iload 6
    //   611: ifgt +16 -> 627
    //   614: iload_1
    //   615: istore_2
    //   616: iload_1
    //   617: istore_3
    //   618: ldc2_w 158
    //   621: invokestatic 163	java/lang/Thread:sleep	(J)V
    //   624: goto +1022 -> 1646
    //   627: lload 12
    //   629: iload 6
    //   631: i2l
    //   632: ladd
    //   633: lstore 12
    //   635: iload 6
    //   637: iload 5
    //   639: iadd
    //   640: istore 5
    //   642: iload 5
    //   644: sipush 160
    //   647: irem
    //   648: istore 6
    //   650: iload 6
    //   652: ifeq +1005 -> 1657
    //   655: iload_1
    //   656: istore_2
    //   657: iload_1
    //   658: istore_3
    //   659: iload 6
    //   661: newarray byte
    //   663: astore 14
    //   665: iload 5
    //   667: iload 6
    //   669: isub
    //   670: istore 5
    //   672: iload_1
    //   673: istore_2
    //   674: iload_1
    //   675: istore_3
    //   676: aload 16
    //   678: iload 5
    //   680: aload 14
    //   682: iconst_0
    //   683: iload 6
    //   685: invokestatic 143	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   688: goto +3 -> 691
    //   691: iload_1
    //   692: istore_2
    //   693: iload_1
    //   694: istore_3
    //   695: aload_0
    //   696: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   699: invokestatic 167	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   702: aload 16
    //   704: iload 5
    //   706: invokevirtual 173	com/tencent/TMG/ptt/RingBuffer:Push	([BI)V
    //   709: iload_1
    //   710: istore_2
    //   711: iload_1
    //   712: istore_3
    //   713: sipush 640
    //   716: newarray byte
    //   718: astore 18
    //   720: iload_1
    //   721: istore_2
    //   722: iload_1
    //   723: istore_3
    //   724: aload_0
    //   725: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   728: invokestatic 167	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   731: invokevirtual 177	com/tencent/TMG/ptt/RingBuffer:RemainRead	()I
    //   734: sipush 640
    //   737: if_icmplt +926 -> 1663
    //   740: iload_1
    //   741: istore_2
    //   742: iload_1
    //   743: istore_3
    //   744: aload_0
    //   745: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   748: invokestatic 167	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   751: aload 18
    //   753: sipush 640
    //   756: invokevirtual 181	com/tencent/TMG/ptt/RingBuffer:Pop	([BI)Z
    //   759: ifeq -39 -> 720
    //   762: iload_1
    //   763: iconst_1
    //   764: iadd
    //   765: istore_1
    //   766: iload_1
    //   767: istore_2
    //   768: iload_1
    //   769: istore_3
    //   770: aload_0
    //   771: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   774: invokestatic 185	com/tencent/TMG/ptt/Recorder:access$700	(Lcom/tencent/TMG/ptt/Recorder;)Ljava/lang/String;
    //   777: aload_0
    //   778: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   781: invokestatic 188	com/tencent/TMG/ptt/Recorder:access$600	(Lcom/tencent/TMG/ptt/Recorder;)Ljava/lang/String;
    //   784: invokevirtual 192	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   787: ifeq +18 -> 805
    //   790: iload_1
    //   791: istore_2
    //   792: iload_1
    //   793: istore_3
    //   794: iload_1
    //   795: aload_0
    //   796: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   799: invokestatic 195	com/tencent/TMG/ptt/Recorder:access$800	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   802: if_icmple +18 -> 820
    //   805: iload_1
    //   806: istore_2
    //   807: iload_1
    //   808: istore_3
    //   809: iload_1
    //   810: aload_0
    //   811: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   814: invokestatic 198	com/tencent/TMG/ptt/Recorder:access$900	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   817: if_icmpgt +13 -> 830
    //   820: iload_1
    //   821: istore_2
    //   822: iload_1
    //   823: istore_3
    //   824: aload 18
    //   826: iconst_0
    //   827: invokestatic 204	java/util/Arrays:fill	([BB)V
    //   830: iload_1
    //   831: istore_2
    //   832: iload_1
    //   833: istore_3
    //   834: invokestatic 210	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   837: aload 18
    //   839: ldc2_w 211
    //   842: invokevirtual 216	com/tencent/TMG/ptt/TraeJni:turnSilk	([BJ)[B
    //   845: astore 19
    //   847: iload_1
    //   848: istore_2
    //   849: iload_1
    //   850: istore_3
    //   851: new 34	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   858: astore 20
    //   860: iload_1
    //   861: istore_2
    //   862: iload_1
    //   863: istore_3
    //   864: aload 20
    //   866: ldc 218
    //   868: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: iload_1
    //   873: istore_2
    //   874: iload_1
    //   875: istore_3
    //   876: aload 20
    //   878: aload 19
    //   880: arraylength
    //   881: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: iload_1
    //   886: istore_2
    //   887: iload_1
    //   888: istore_3
    //   889: aload 20
    //   891: ldc 220
    //   893: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: iload_1
    //   898: istore_2
    //   899: iload_1
    //   900: istore_3
    //   901: aload 20
    //   903: iload_1
    //   904: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: iload_1
    //   909: istore_2
    //   910: iload_1
    //   911: istore_3
    //   912: ldc 46
    //   914: aload 20
    //   916: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   922: pop
    //   923: iload_1
    //   924: istore_2
    //   925: iload_1
    //   926: istore_3
    //   927: aload 17
    //   929: aload 19
    //   931: arraylength
    //   932: sipush 255
    //   935: iand
    //   936: i2b
    //   937: invokevirtual 225	java/io/FileOutputStream:write	(I)V
    //   940: iload_1
    //   941: istore_2
    //   942: iload_1
    //   943: istore_3
    //   944: aload 17
    //   946: aload 19
    //   948: arraylength
    //   949: bipush 8
    //   951: ishr
    //   952: sipush 255
    //   955: iand
    //   956: i2b
    //   957: invokevirtual 225	java/io/FileOutputStream:write	(I)V
    //   960: iload_1
    //   961: istore_2
    //   962: iload_1
    //   963: istore_3
    //   964: aload 17
    //   966: aload 19
    //   968: iconst_0
    //   969: aload 19
    //   971: arraylength
    //   972: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
    //   975: goto -255 -> 720
    //   978: iload_1
    //   979: istore_2
    //   980: iload_1
    //   981: istore_3
    //   982: aload 17
    //   984: invokevirtual 231	java/io/FileOutputStream:flush	()V
    //   987: iload_1
    //   988: istore_2
    //   989: iload_1
    //   990: istore_3
    //   991: aload 17
    //   993: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   996: goto +14 -> 1010
    //   999: astore 14
    //   1001: iload_1
    //   1002: istore_2
    //   1003: iload_1
    //   1004: istore_3
    //   1005: aload 14
    //   1007: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   1010: iload_1
    //   1011: istore_2
    //   1012: iload_1
    //   1013: istore_3
    //   1014: aload_0
    //   1015: getfield 20	com/tencent/TMG/ptt/Recorder$RecordThread:unNormal	Z
    //   1018: ifeq +16 -> 1034
    //   1021: iload_1
    //   1022: istore_2
    //   1023: iload_1
    //   1024: istore_3
    //   1025: aload 15
    //   1027: invokevirtual 86	java/io/File:delete	()Z
    //   1030: pop
    //   1031: goto +100 -> 1131
    //   1034: iload_1
    //   1035: istore_2
    //   1036: iload_1
    //   1037: istore_3
    //   1038: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   1041: lload 10
    //   1043: lsub
    //   1044: aload_0
    //   1045: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1048: invokestatic 240	com/tencent/TMG/ptt/Recorder:access$1000	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1051: i2l
    //   1052: lcmp
    //   1053: ifle +46 -> 1099
    //   1056: lload 10
    //   1058: lconst_0
    //   1059: lcmp
    //   1060: ifne +6 -> 1066
    //   1063: goto +36 -> 1099
    //   1066: iload_1
    //   1067: istore_2
    //   1068: iload_1
    //   1069: istore_3
    //   1070: aload_0
    //   1071: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1074: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1077: ifnull +54 -> 1131
    //   1080: iload_1
    //   1081: istore_2
    //   1082: iload_1
    //   1083: istore_3
    //   1084: aload_0
    //   1085: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1088: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1091: invokeinterface 243 1 0
    //   1096: goto +35 -> 1131
    //   1099: iload_1
    //   1100: istore_2
    //   1101: iload_1
    //   1102: istore_3
    //   1103: aload_0
    //   1104: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1107: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1110: ifnull +21 -> 1131
    //   1113: iload_1
    //   1114: istore_2
    //   1115: iload_1
    //   1116: istore_3
    //   1117: aload_0
    //   1118: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1121: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1124: aconst_null
    //   1125: iconst_5
    //   1126: invokeinterface 247 3 0
    //   1131: iload_1
    //   1132: istore_2
    //   1133: iload_1
    //   1134: istore_3
    //   1135: aload_0
    //   1136: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1139: getfield 251	com/tencent/TMG/ptt/Recorder:mAudioManager	Landroid/media/AudioManager;
    //   1142: ifnull +33 -> 1175
    //   1145: iload_1
    //   1146: istore_2
    //   1147: iload_1
    //   1148: istore_3
    //   1149: aload_0
    //   1150: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1153: invokestatic 254	com/tencent/TMG/ptt/Recorder:access$1100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1156: iconst_m1
    //   1157: if_icmpeq +18 -> 1175
    //   1160: iload_1
    //   1161: istore_2
    //   1162: iload_1
    //   1163: istore_3
    //   1164: aload_0
    //   1165: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1168: getfield 251	com/tencent/TMG/ptt/Recorder:mAudioManager	Landroid/media/AudioManager;
    //   1171: iconst_0
    //   1172: invokevirtual 259	android/media/AudioManager:setMode	(I)V
    //   1175: new 34	java/lang/StringBuilder
    //   1178: dup
    //   1179: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1182: astore 14
    //   1184: aload 14
    //   1186: ldc_w 261
    //   1189: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload 14
    //   1195: iload_1
    //   1196: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: goto +356 -> 1556
    //   1203: astore 14
    //   1205: goto +374 -> 1579
    //   1208: astore 14
    //   1210: iload_3
    //   1211: istore_1
    //   1212: goto +243 -> 1455
    //   1215: aload_0
    //   1216: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1219: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1222: ifnull +23 -> 1245
    //   1225: aload_0
    //   1226: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1229: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1232: aload_0
    //   1233: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1236: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   1239: iconst_4
    //   1240: invokeinterface 247 3 0
    //   1245: aload 17
    //   1247: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   1250: goto +10 -> 1260
    //   1253: astore 14
    //   1255: aload 14
    //   1257: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   1260: aload_0
    //   1261: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1264: invokestatic 265	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1267: new 34	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1274: astore 14
    //   1276: aload 14
    //   1278: ldc_w 261
    //   1281: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload 14
    //   1287: iconst_0
    //   1288: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: ldc 46
    //   1294: aload 14
    //   1296: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1302: pop
    //   1303: aload_0
    //   1304: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1307: invokestatic 265	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1310: return
    //   1311: astore 14
    //   1313: new 34	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1320: astore 15
    //   1322: aload 15
    //   1324: ldc_w 267
    //   1327: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: aload 15
    //   1333: aload_0
    //   1334: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1337: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   1340: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 15
    //   1346: ldc_w 269
    //   1349: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: aload 15
    //   1355: aload 14
    //   1357: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1360: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: ldc 46
    //   1366: aload 15
    //   1368: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1374: pop
    //   1375: aload_0
    //   1376: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1379: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1382: astore 14
    //   1384: aload 14
    //   1386: ifnull +23 -> 1409
    //   1389: aload_0
    //   1390: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1393: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1396: aload_0
    //   1397: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1400: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   1403: iconst_2
    //   1404: invokeinterface 247 3 0
    //   1409: aload_0
    //   1410: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1413: invokestatic 265	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1416: new 34	java/lang/StringBuilder
    //   1419: dup
    //   1420: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1423: astore 14
    //   1425: aload 14
    //   1427: ldc_w 261
    //   1430: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: pop
    //   1434: aload 14
    //   1436: iconst_0
    //   1437: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: goto -149 -> 1292
    //   1444: astore 14
    //   1446: iconst_0
    //   1447: istore_2
    //   1448: goto +131 -> 1579
    //   1451: astore 14
    //   1453: iconst_0
    //   1454: istore_1
    //   1455: new 34	java/lang/StringBuilder
    //   1458: dup
    //   1459: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1462: astore 15
    //   1464: aload 15
    //   1466: ldc_w 274
    //   1469: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload 15
    //   1475: aload 14
    //   1477: invokestatic 278	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1480: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: ldc 46
    //   1486: aload 15
    //   1488: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: aload 14
    //   1493: invokestatic 281	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1496: pop
    //   1497: aload_0
    //   1498: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1501: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1504: ifnull +27 -> 1531
    //   1507: aload_0
    //   1508: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1511: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1514: aload_0
    //   1515: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1518: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   1521: aload 14
    //   1523: invokevirtual 282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1526: invokeinterface 286 3 0
    //   1531: new 34	java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1538: astore 14
    //   1540: aload 14
    //   1542: ldc_w 261
    //   1545: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: pop
    //   1549: aload 14
    //   1551: iload_1
    //   1552: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: ldc 46
    //   1558: aload 14
    //   1560: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1563: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1566: pop
    //   1567: aload_0
    //   1568: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1571: invokestatic 265	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1574: return
    //   1575: astore 14
    //   1577: iload_1
    //   1578: istore_2
    //   1579: new 34	java/lang/StringBuilder
    //   1582: dup
    //   1583: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1586: astore 15
    //   1588: aload 15
    //   1590: ldc_w 261
    //   1593: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload 15
    //   1599: iload_2
    //   1600: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1603: pop
    //   1604: ldc 46
    //   1606: aload 15
    //   1608: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1611: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1614: pop
    //   1615: aload_0
    //   1616: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1619: invokestatic 265	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1622: goto +6 -> 1628
    //   1625: aload 14
    //   1627: athrow
    //   1628: goto -3 -> 1625
    //   1631: iconst_1
    //   1632: istore 4
    //   1634: goto -1243 -> 391
    //   1637: iconst_0
    //   1638: istore 5
    //   1640: goto -1217 -> 423
    //   1643: goto -1064 -> 579
    //   1646: lload 8
    //   1648: lstore 10
    //   1650: iload 4
    //   1652: istore 5
    //   1654: goto -1422 -> 232
    //   1657: aconst_null
    //   1658: astore 14
    //   1660: goto -969 -> 691
    //   1663: goto -17 -> 1646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1666	0	this	RecordThread
    //   231	1347	1	i	int
    //   233	1367	2	j	int
    //   235	976	3	k	int
    //   288	1363	4	m	int
    //   228	1425	5	n	int
    //   451	233	6	i1	int
    //   127	3	7	bool	boolean
    //   455	1192	8	l1	long
    //   218	1431	10	l2	long
    //   222	412	12	l3	long
    //   7	38	14	localObject1	java.lang.Object
    //   71	1	14	localObject2	java.lang.Object
    //   76	1	14	localException1	java.lang.Exception
    //   225	456	14	localObject3	java.lang.Object
    //   999	7	14	localIOException1	java.io.IOException
    //   1182	12	14	localStringBuilder1	java.lang.StringBuilder
    //   1203	1	14	localObject4	java.lang.Object
    //   1208	1	14	localException2	java.lang.Exception
    //   1253	3	14	localIOException2	java.io.IOException
    //   1274	21	14	localStringBuilder2	java.lang.StringBuilder
    //   1311	45	14	localIOException3	java.io.IOException
    //   1382	53	14	localObject5	java.lang.Object
    //   1444	1	14	localObject6	java.lang.Object
    //   1451	71	14	localException3	java.lang.Exception
    //   1538	21	14	localStringBuilder3	java.lang.StringBuilder
    //   1575	51	14	localObject7	java.lang.Object
    //   1658	1	14	localObject8	java.lang.Object
    //   106	1501	15	localObject9	java.lang.Object
    //   90	613	16	arrayOfByte1	byte[]
    //   163	1083	17	localFileOutputStream	java.io.FileOutputStream
    //   503	335	18	localObject10	java.lang.Object
    //   845	125	19	arrayOfByte2	byte[]
    //   858	57	20	localStringBuilder4	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   49	68	71	finally
    //   134	148	71	finally
    //   148	154	71	finally
    //   154	217	71	finally
    //   1215	1245	71	finally
    //   1245	1250	71	finally
    //   1255	1260	71	finally
    //   1260	1267	71	finally
    //   1389	1409	71	finally
    //   49	68	76	java/lang/Exception
    //   134	148	76	java/lang/Exception
    //   148	154	76	java/lang/Exception
    //   154	217	76	java/lang/Exception
    //   1215	1245	76	java/lang/Exception
    //   1245	1250	76	java/lang/Exception
    //   1255	1260	76	java/lang/Exception
    //   1260	1267	76	java/lang/Exception
    //   1389	1409	76	java/lang/Exception
    //   991	996	999	java/io/IOException
    //   236	243	1203	finally
    //   254	271	1203	finally
    //   275	283	1203	finally
    //   305	323	1203	finally
    //   343	353	1203	finally
    //   357	370	1203	finally
    //   374	379	1203	finally
    //   383	388	1203	finally
    //   400	405	1203	finally
    //   409	420	1203	finally
    //   427	453	1203	finally
    //   468	473	1203	finally
    //   477	492	1203	finally
    //   496	505	1203	finally
    //   509	517	1203	finally
    //   521	537	1203	finally
    //   541	549	1203	finally
    //   553	561	1203	finally
    //   565	576	1203	finally
    //   583	593	1203	finally
    //   597	609	1203	finally
    //   618	624	1203	finally
    //   659	665	1203	finally
    //   676	688	1203	finally
    //   695	709	1203	finally
    //   713	720	1203	finally
    //   724	740	1203	finally
    //   744	762	1203	finally
    //   770	790	1203	finally
    //   794	805	1203	finally
    //   809	820	1203	finally
    //   824	830	1203	finally
    //   834	847	1203	finally
    //   851	860	1203	finally
    //   864	872	1203	finally
    //   876	885	1203	finally
    //   889	897	1203	finally
    //   901	908	1203	finally
    //   912	923	1203	finally
    //   927	940	1203	finally
    //   944	960	1203	finally
    //   964	975	1203	finally
    //   982	987	1203	finally
    //   991	996	1203	finally
    //   1005	1010	1203	finally
    //   1014	1021	1203	finally
    //   1025	1031	1203	finally
    //   1038	1056	1203	finally
    //   1070	1080	1203	finally
    //   1084	1096	1203	finally
    //   1103	1113	1203	finally
    //   1117	1131	1203	finally
    //   1135	1145	1203	finally
    //   1149	1160	1203	finally
    //   1164	1175	1203	finally
    //   236	243	1208	java/lang/Exception
    //   254	271	1208	java/lang/Exception
    //   275	283	1208	java/lang/Exception
    //   305	323	1208	java/lang/Exception
    //   343	353	1208	java/lang/Exception
    //   357	370	1208	java/lang/Exception
    //   374	379	1208	java/lang/Exception
    //   383	388	1208	java/lang/Exception
    //   400	405	1208	java/lang/Exception
    //   409	420	1208	java/lang/Exception
    //   427	453	1208	java/lang/Exception
    //   468	473	1208	java/lang/Exception
    //   477	492	1208	java/lang/Exception
    //   496	505	1208	java/lang/Exception
    //   509	517	1208	java/lang/Exception
    //   521	537	1208	java/lang/Exception
    //   541	549	1208	java/lang/Exception
    //   553	561	1208	java/lang/Exception
    //   565	576	1208	java/lang/Exception
    //   583	593	1208	java/lang/Exception
    //   597	609	1208	java/lang/Exception
    //   618	624	1208	java/lang/Exception
    //   659	665	1208	java/lang/Exception
    //   676	688	1208	java/lang/Exception
    //   695	709	1208	java/lang/Exception
    //   713	720	1208	java/lang/Exception
    //   724	740	1208	java/lang/Exception
    //   744	762	1208	java/lang/Exception
    //   770	790	1208	java/lang/Exception
    //   794	805	1208	java/lang/Exception
    //   809	820	1208	java/lang/Exception
    //   824	830	1208	java/lang/Exception
    //   834	847	1208	java/lang/Exception
    //   851	860	1208	java/lang/Exception
    //   864	872	1208	java/lang/Exception
    //   876	885	1208	java/lang/Exception
    //   889	897	1208	java/lang/Exception
    //   901	908	1208	java/lang/Exception
    //   912	923	1208	java/lang/Exception
    //   927	940	1208	java/lang/Exception
    //   944	960	1208	java/lang/Exception
    //   964	975	1208	java/lang/Exception
    //   982	987	1208	java/lang/Exception
    //   991	996	1208	java/lang/Exception
    //   1005	1010	1208	java/lang/Exception
    //   1014	1021	1208	java/lang/Exception
    //   1025	1031	1208	java/lang/Exception
    //   1038	1056	1208	java/lang/Exception
    //   1070	1080	1208	java/lang/Exception
    //   1084	1096	1208	java/lang/Exception
    //   1103	1113	1208	java/lang/Exception
    //   1117	1131	1208	java/lang/Exception
    //   1135	1145	1208	java/lang/Exception
    //   1149	1160	1208	java/lang/Exception
    //   1164	1175	1208	java/lang/Exception
    //   1245	1250	1253	java/io/IOException
    //   148	154	1311	java/io/IOException
    //   35	44	1444	finally
    //   81	129	1444	finally
    //   1313	1384	1444	finally
    //   1409	1416	1444	finally
    //   35	44	1451	java/lang/Exception
    //   81	129	1451	java/lang/Exception
    //   1313	1384	1451	java/lang/Exception
    //   1409	1416	1451	java/lang/Exception
    //   1455	1531	1575	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.Recorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */