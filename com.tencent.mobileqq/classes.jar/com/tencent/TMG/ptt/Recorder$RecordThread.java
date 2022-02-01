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
    //   0: ldc 34
    //   2: new 36	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   9: ldc 39
    //   11: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: iconst_0
    //   26: istore_3
    //   27: iconst_0
    //   28: istore 5
    //   30: iconst_0
    //   31: istore 4
    //   33: iload_3
    //   34: istore_1
    //   35: iload 5
    //   37: istore_2
    //   38: aload_0
    //   39: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   42: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   45: ifnull +27 -> 72
    //   48: iload_3
    //   49: istore_1
    //   50: iload 5
    //   52: istore_2
    //   53: aload_0
    //   54: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   57: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   60: aload_0
    //   61: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   64: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   67: invokeinterface 66 2 0
    //   72: lconst_0
    //   73: lstore 9
    //   75: iload_3
    //   76: istore_1
    //   77: iload 5
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   84: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   87: newarray byte
    //   89: astore 15
    //   91: iload_3
    //   92: istore_1
    //   93: iload 5
    //   95: istore_2
    //   96: new 72	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   104: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   107: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: astore 14
    //   112: iload_3
    //   113: istore_1
    //   114: iload 5
    //   116: istore_2
    //   117: aload_0
    //   118: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   121: aload_0
    //   122: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   125: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   128: putfield 77	com/tencent/TMG/ptt/Recorder:silkFilePath	Ljava/lang/String;
    //   131: iload_3
    //   132: istore_1
    //   133: iload 5
    //   135: istore_2
    //   136: aload 14
    //   138: invokevirtual 81	java/io/File:exists	()Z
    //   141: ifeq +27 -> 168
    //   144: iload_3
    //   145: istore_1
    //   146: iload 5
    //   148: istore_2
    //   149: ldc 34
    //   151: ldc 83
    //   153: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: iload_3
    //   158: istore_1
    //   159: iload 5
    //   161: istore_2
    //   162: aload 14
    //   164: invokevirtual 86	java/io/File:delete	()Z
    //   167: pop
    //   168: iload_3
    //   169: istore_1
    //   170: iload 5
    //   172: istore_2
    //   173: aload 14
    //   175: invokevirtual 89	java/io/File:createNewFile	()Z
    //   178: pop
    //   179: iload_3
    //   180: istore_1
    //   181: iload 5
    //   183: istore_2
    //   184: new 91	java/io/FileOutputStream
    //   187: dup
    //   188: aload 14
    //   190: invokespecial 94	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   193: astore 16
    //   195: iload_3
    //   196: istore_1
    //   197: iload 5
    //   199: istore_2
    //   200: aload 16
    //   202: ldc 96
    //   204: invokevirtual 102	java/lang/String:getBytes	()[B
    //   207: invokevirtual 106	java/io/FileOutputStream:write	([B)V
    //   210: iload_3
    //   211: istore_1
    //   212: iload 5
    //   214: istore_2
    //   215: aload_0
    //   216: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   219: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   222: ifnull +377 -> 599
    //   225: iload_3
    //   226: istore_1
    //   227: iload 5
    //   229: istore_2
    //   230: aload_0
    //   231: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   234: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   237: invokevirtual 115	android/media/AudioRecord:startRecording	()V
    //   240: iload_3
    //   241: istore_1
    //   242: iload 5
    //   244: istore_2
    //   245: aload_0
    //   246: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   249: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   252: ifnull +1434 -> 1686
    //   255: iload_3
    //   256: istore_1
    //   257: iload 5
    //   259: istore_2
    //   260: aload_0
    //   261: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   264: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   267: invokeinterface 118 1 0
    //   272: goto +1414 -> 1686
    //   275: iload 4
    //   277: istore_1
    //   278: iload 4
    //   280: istore_2
    //   281: aload_0
    //   282: getfield 18	com/tencent/TMG/ptt/Recorder$RecordThread:isRunning	Z
    //   285: ifeq +47 -> 332
    //   288: lload 7
    //   290: lconst_0
    //   291: lcmp
    //   292: ifeq +523 -> 815
    //   295: iload 4
    //   297: istore_1
    //   298: iload 4
    //   300: istore_2
    //   301: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   304: lload 7
    //   306: lsub
    //   307: aload_0
    //   308: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   311: invokestatic 128	com/tencent/TMG/ptt/Recorder:access$300	(Lcom/tencent/TMG/ptt/Recorder;)J
    //   314: lcmp
    //   315: iflt +500 -> 815
    //   318: iload 4
    //   320: istore_1
    //   321: iload 4
    //   323: istore_2
    //   324: ldc 34
    //   326: ldc 130
    //   328: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   331: pop
    //   332: iload 4
    //   334: istore_1
    //   335: iload 4
    //   337: istore_2
    //   338: aload 16
    //   340: invokevirtual 133	java/io/FileOutputStream:flush	()V
    //   343: iload 4
    //   345: istore_1
    //   346: iload 4
    //   348: istore_2
    //   349: aload 16
    //   351: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   354: iload 4
    //   356: istore_1
    //   357: iload 4
    //   359: istore_2
    //   360: aload_0
    //   361: getfield 20	com/tencent/TMG/ptt/Recorder$RecordThread:unNormal	Z
    //   364: ifeq +1209 -> 1573
    //   367: iload 4
    //   369: istore_1
    //   370: iload 4
    //   372: istore_2
    //   373: aload 14
    //   375: invokevirtual 86	java/io/File:delete	()Z
    //   378: pop
    //   379: iload 4
    //   381: istore_1
    //   382: iload 4
    //   384: istore_2
    //   385: aload_0
    //   386: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   389: getfield 140	com/tencent/TMG/ptt/Recorder:mAudioManager	Landroid/media/AudioManager;
    //   392: ifnull +37 -> 429
    //   395: iload 4
    //   397: istore_1
    //   398: iload 4
    //   400: istore_2
    //   401: aload_0
    //   402: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   405: invokestatic 143	com/tencent/TMG/ptt/Recorder:access$1100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   408: iconst_m1
    //   409: if_icmpeq +20 -> 429
    //   412: iload 4
    //   414: istore_1
    //   415: iload 4
    //   417: istore_2
    //   418: aload_0
    //   419: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   422: getfield 140	com/tencent/TMG/ptt/Recorder:mAudioManager	Landroid/media/AudioManager;
    //   425: iconst_0
    //   426: invokevirtual 149	android/media/AudioManager:setMode	(I)V
    //   429: ldc 34
    //   431: new 36	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   438: ldc 151
    //   440: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 4
    //   445: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   454: pop
    //   455: aload_0
    //   456: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   459: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   462: return
    //   463: astore 13
    //   465: iload_3
    //   466: istore_1
    //   467: iload 5
    //   469: istore_2
    //   470: ldc 34
    //   472: new 36	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   479: ldc 160
    //   481: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_0
    //   485: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   488: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   491: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc 162
    //   496: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 13
    //   501: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   504: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   513: pop
    //   514: iload_3
    //   515: istore_1
    //   516: iload 5
    //   518: istore_2
    //   519: aload_0
    //   520: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   523: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   526: ifnull +28 -> 554
    //   529: iload_3
    //   530: istore_1
    //   531: iload 5
    //   533: istore_2
    //   534: aload_0
    //   535: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   538: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   541: aload_0
    //   542: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   545: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   548: iconst_2
    //   549: invokeinterface 169 3 0
    //   554: iload_3
    //   555: istore_1
    //   556: iload 5
    //   558: istore_2
    //   559: aload_0
    //   560: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   563: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   566: ldc 34
    //   568: new 36	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   575: ldc 151
    //   577: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: iconst_0
    //   581: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   584: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   590: pop
    //   591: aload_0
    //   592: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   595: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   598: return
    //   599: iload_3
    //   600: istore_1
    //   601: iload 5
    //   603: istore_2
    //   604: aload_0
    //   605: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   608: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   611: ifnull +28 -> 639
    //   614: iload_3
    //   615: istore_1
    //   616: iload 5
    //   618: istore_2
    //   619: aload_0
    //   620: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   623: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   626: aload_0
    //   627: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   630: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   633: iconst_4
    //   634: invokeinterface 169 3 0
    //   639: iload_3
    //   640: istore_1
    //   641: iload 5
    //   643: istore_2
    //   644: aload 16
    //   646: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   649: iload_3
    //   650: istore_1
    //   651: iload 5
    //   653: istore_2
    //   654: aload_0
    //   655: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   658: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   661: ldc 34
    //   663: new 36	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   670: ldc 151
    //   672: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: iconst_0
    //   676: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   685: pop
    //   686: aload_0
    //   687: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   690: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   693: return
    //   694: astore 13
    //   696: iload_3
    //   697: istore_1
    //   698: iload 5
    //   700: istore_2
    //   701: aload 13
    //   703: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   706: goto -57 -> 649
    //   709: astore 13
    //   711: iload_1
    //   712: istore_2
    //   713: ldc 34
    //   715: new 36	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   722: ldc 174
    //   724: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 13
    //   729: invokestatic 178	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   732: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: aload 13
    //   740: invokestatic 181	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   743: pop
    //   744: iload_1
    //   745: istore_2
    //   746: aload_0
    //   747: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   750: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   753: ifnull +29 -> 782
    //   756: iload_1
    //   757: istore_2
    //   758: aload_0
    //   759: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   762: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   765: aload_0
    //   766: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   769: getfield 26	com/tencent/TMG/ptt/Recorder:recorderPath	Ljava/lang/String;
    //   772: aload 13
    //   774: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   777: invokeinterface 186 3 0
    //   782: ldc 34
    //   784: new 36	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   791: ldc 151
    //   793: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: iload_1
    //   797: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   806: pop
    //   807: aload_0
    //   808: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   811: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   814: return
    //   815: iload 5
    //   817: istore_3
    //   818: lload 7
    //   820: lconst_0
    //   821: lcmp
    //   822: ifeq +114 -> 936
    //   825: iload 4
    //   827: istore_1
    //   828: iload 5
    //   830: istore_3
    //   831: iload 4
    //   833: istore_2
    //   834: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   837: lload 7
    //   839: lsub
    //   840: aload_0
    //   841: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   844: invokestatic 189	com/tencent/TMG/ptt/Recorder:access$400	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   847: i2l
    //   848: lcmp
    //   849: ifle +87 -> 936
    //   852: iload 5
    //   854: istore_3
    //   855: iload 5
    //   857: ifne +79 -> 936
    //   860: iconst_1
    //   861: istore 5
    //   863: iload 5
    //   865: istore_3
    //   866: lload 9
    //   868: lconst_0
    //   869: lcmp
    //   870: ifne +66 -> 936
    //   873: iload 4
    //   875: istore_1
    //   876: iload 5
    //   878: istore_3
    //   879: iload 4
    //   881: istore_2
    //   882: aload_0
    //   883: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   886: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   889: ifnull +47 -> 936
    //   892: iload 4
    //   894: istore_1
    //   895: iload 4
    //   897: istore_2
    //   898: aload_0
    //   899: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   902: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   905: iconst_0
    //   906: invokeinterface 192 2 0
    //   911: iload 4
    //   913: istore_1
    //   914: iload 4
    //   916: istore_2
    //   917: aload_0
    //   918: iconst_0
    //   919: putfield 18	com/tencent/TMG/ptt/Recorder$RecordThread:isRunning	Z
    //   922: iload 4
    //   924: istore_1
    //   925: iload 4
    //   927: istore_2
    //   928: aload_0
    //   929: iconst_1
    //   930: putfield 20	com/tencent/TMG/ptt/Recorder$RecordThread:unNormal	Z
    //   933: iload 5
    //   935: istore_3
    //   936: iconst_0
    //   937: istore 5
    //   939: aload 13
    //   941: ifnull +31 -> 972
    //   944: iload 4
    //   946: istore_1
    //   947: iload 4
    //   949: istore_2
    //   950: aload 13
    //   952: arraylength
    //   953: istore 5
    //   955: iload 4
    //   957: istore_1
    //   958: iload 4
    //   960: istore_2
    //   961: aload 13
    //   963: iconst_0
    //   964: aload 15
    //   966: iconst_0
    //   967: iload 5
    //   969: invokestatic 198	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   972: iload 4
    //   974: istore_1
    //   975: iload 4
    //   977: istore_2
    //   978: aload_0
    //   979: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   982: getfield 110	com/tencent/TMG/ptt/Recorder:mRecord	Landroid/media/AudioRecord;
    //   985: aload 15
    //   987: iload 5
    //   989: aload_0
    //   990: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   993: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   996: iload 5
    //   998: isub
    //   999: invokevirtual 202	android/media/AudioRecord:read	([BII)I
    //   1002: istore 6
    //   1004: lload 7
    //   1006: lstore 11
    //   1008: lload 7
    //   1010: lconst_0
    //   1011: lcmp
    //   1012: ifne +14 -> 1026
    //   1015: iload 4
    //   1017: istore_1
    //   1018: iload 4
    //   1020: istore_2
    //   1021: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   1024: lstore 11
    //   1026: iload 4
    //   1028: istore_1
    //   1029: iload 4
    //   1031: istore_2
    //   1032: aload_0
    //   1033: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1036: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1039: iload 5
    //   1041: isub
    //   1042: iload 6
    //   1044: if_icmpeq +53 -> 1097
    //   1047: iload 4
    //   1049: istore_1
    //   1050: iload 4
    //   1052: istore_2
    //   1053: ldc 34
    //   1055: new 36	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1062: ldc 204
    //   1064: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: aload_0
    //   1068: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1071: invokestatic 70	com/tencent/TMG/ptt/Recorder:access$100	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1074: iload 5
    //   1076: isub
    //   1077: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1080: ldc 206
    //   1082: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: iload 6
    //   1087: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1096: pop
    //   1097: iload 4
    //   1099: istore_1
    //   1100: iload 4
    //   1102: istore_2
    //   1103: aload_0
    //   1104: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1107: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1110: ifnull +21 -> 1131
    //   1113: iload 4
    //   1115: istore_1
    //   1116: iload 4
    //   1118: istore_2
    //   1119: aload_0
    //   1120: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1123: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1126: invokeinterface 209 1 0
    //   1131: iload 6
    //   1133: ifgt +25 -> 1158
    //   1136: iload 4
    //   1138: istore_1
    //   1139: iload 4
    //   1141: istore_2
    //   1142: ldc2_w 210
    //   1145: invokestatic 215	java/lang/Thread:sleep	(J)V
    //   1148: iload_3
    //   1149: istore 5
    //   1151: lload 11
    //   1153: lstore 7
    //   1155: goto -880 -> 275
    //   1158: lload 9
    //   1160: iload 6
    //   1162: i2l
    //   1163: ladd
    //   1164: lstore 9
    //   1166: iload 5
    //   1168: iload 6
    //   1170: iadd
    //   1171: istore 5
    //   1173: iload 5
    //   1175: sipush 160
    //   1178: irem
    //   1179: istore 6
    //   1181: iload 6
    //   1183: ifeq +497 -> 1680
    //   1186: iload 4
    //   1188: istore_1
    //   1189: iload 4
    //   1191: istore_2
    //   1192: iload 6
    //   1194: newarray byte
    //   1196: astore 13
    //   1198: iload 4
    //   1200: istore_1
    //   1201: iload 4
    //   1203: istore_2
    //   1204: aload 15
    //   1206: iload 5
    //   1208: iload 6
    //   1210: isub
    //   1211: aload 13
    //   1213: iconst_0
    //   1214: iload 6
    //   1216: invokestatic 198	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1219: iload 5
    //   1221: iload 6
    //   1223: isub
    //   1224: istore 5
    //   1226: iload 4
    //   1228: istore_1
    //   1229: iload 4
    //   1231: istore_2
    //   1232: aload_0
    //   1233: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1236: invokestatic 219	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   1239: aload 15
    //   1241: iload 5
    //   1243: invokevirtual 225	com/tencent/TMG/ptt/RingBuffer:Push	([BI)V
    //   1246: iload 4
    //   1248: istore_1
    //   1249: iload 4
    //   1251: istore_2
    //   1252: sipush 640
    //   1255: newarray byte
    //   1257: astore 17
    //   1259: iload 4
    //   1261: istore_1
    //   1262: iload 4
    //   1264: istore_2
    //   1265: aload_0
    //   1266: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1269: invokestatic 219	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   1272: invokevirtual 229	com/tencent/TMG/ptt/RingBuffer:RemainRead	()I
    //   1275: sipush 640
    //   1278: if_icmplt +269 -> 1547
    //   1281: iload 4
    //   1283: istore_1
    //   1284: iload 4
    //   1286: istore_2
    //   1287: aload_0
    //   1288: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1291: invokestatic 219	com/tencent/TMG/ptt/Recorder:access$500	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/RingBuffer;
    //   1294: aload 17
    //   1296: sipush 640
    //   1299: invokevirtual 233	com/tencent/TMG/ptt/RingBuffer:Pop	([BI)Z
    //   1302: ifeq -43 -> 1259
    //   1305: iload 4
    //   1307: iconst_1
    //   1308: iadd
    //   1309: istore 4
    //   1311: iload 4
    //   1313: istore_1
    //   1314: iload 4
    //   1316: istore_2
    //   1317: aload_0
    //   1318: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1321: invokestatic 237	com/tencent/TMG/ptt/Recorder:access$700	(Lcom/tencent/TMG/ptt/Recorder;)Ljava/lang/String;
    //   1324: aload_0
    //   1325: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1328: invokestatic 240	com/tencent/TMG/ptt/Recorder:access$600	(Lcom/tencent/TMG/ptt/Recorder;)Ljava/lang/String;
    //   1331: invokevirtual 244	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1334: ifeq +21 -> 1355
    //   1337: iload 4
    //   1339: istore_1
    //   1340: iload 4
    //   1342: istore_2
    //   1343: iload 4
    //   1345: aload_0
    //   1346: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1349: invokestatic 247	com/tencent/TMG/ptt/Recorder:access$800	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1352: if_icmple +21 -> 1373
    //   1355: iload 4
    //   1357: istore_1
    //   1358: iload 4
    //   1360: istore_2
    //   1361: iload 4
    //   1363: aload_0
    //   1364: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1367: invokestatic 250	com/tencent/TMG/ptt/Recorder:access$900	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1370: if_icmpgt +15 -> 1385
    //   1373: iload 4
    //   1375: istore_1
    //   1376: iload 4
    //   1378: istore_2
    //   1379: aload 17
    //   1381: iconst_0
    //   1382: invokestatic 256	java/util/Arrays:fill	([BB)V
    //   1385: iload 4
    //   1387: istore_1
    //   1388: iload 4
    //   1390: istore_2
    //   1391: invokestatic 262	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
    //   1394: aload 17
    //   1396: ldc2_w 263
    //   1399: invokevirtual 268	com/tencent/TMG/ptt/TraeJni:turnSilk	([BJ)[B
    //   1402: astore 18
    //   1404: iload 4
    //   1406: istore_1
    //   1407: iload 4
    //   1409: istore_2
    //   1410: ldc 34
    //   1412: new 36	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 270
    //   1422: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 18
    //   1427: arraylength
    //   1428: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1431: ldc_w 272
    //   1434: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: iload 4
    //   1439: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1442: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1445: invokestatic 275	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1448: pop
    //   1449: iload 4
    //   1451: istore_1
    //   1452: iload 4
    //   1454: istore_2
    //   1455: aload 16
    //   1457: aload 18
    //   1459: arraylength
    //   1460: sipush 255
    //   1463: iand
    //   1464: i2b
    //   1465: invokevirtual 277	java/io/FileOutputStream:write	(I)V
    //   1468: iload 4
    //   1470: istore_1
    //   1471: iload 4
    //   1473: istore_2
    //   1474: aload 16
    //   1476: aload 18
    //   1478: arraylength
    //   1479: bipush 8
    //   1481: ishr
    //   1482: sipush 255
    //   1485: iand
    //   1486: i2b
    //   1487: invokevirtual 277	java/io/FileOutputStream:write	(I)V
    //   1490: iload 4
    //   1492: istore_1
    //   1493: iload 4
    //   1495: istore_2
    //   1496: aload 16
    //   1498: aload 18
    //   1500: iconst_0
    //   1501: aload 18
    //   1503: arraylength
    //   1504: invokevirtual 280	java/io/FileOutputStream:write	([BII)V
    //   1507: goto -248 -> 1259
    //   1510: astore 13
    //   1512: ldc 34
    //   1514: new 36	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1521: ldc 151
    //   1523: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: iload_2
    //   1527: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1530: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1536: pop
    //   1537: aload_0
    //   1538: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1541: invokestatic 158	com/tencent/TMG/ptt/Recorder:access$200	(Lcom/tencent/TMG/ptt/Recorder;)V
    //   1544: aload 13
    //   1546: athrow
    //   1547: iload_3
    //   1548: istore 5
    //   1550: lload 11
    //   1552: lstore 7
    //   1554: goto -1279 -> 275
    //   1557: astore 13
    //   1559: iload 4
    //   1561: istore_1
    //   1562: iload 4
    //   1564: istore_2
    //   1565: aload 13
    //   1567: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   1570: goto -1216 -> 354
    //   1573: iload 4
    //   1575: istore_1
    //   1576: iload 4
    //   1578: istore_2
    //   1579: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   1582: lload 7
    //   1584: lsub
    //   1585: aload_0
    //   1586: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1589: invokestatic 283	com/tencent/TMG/ptt/Recorder:access$1000	(Lcom/tencent/TMG/ptt/Recorder;)I
    //   1592: i2l
    //   1593: lcmp
    //   1594: ifle +10 -> 1604
    //   1597: lload 7
    //   1599: lconst_0
    //   1600: lcmp
    //   1601: ifne +42 -> 1643
    //   1604: iload 4
    //   1606: istore_1
    //   1607: iload 4
    //   1609: istore_2
    //   1610: aload_0
    //   1611: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1614: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1617: ifnull -1238 -> 379
    //   1620: iload 4
    //   1622: istore_1
    //   1623: iload 4
    //   1625: istore_2
    //   1626: aload_0
    //   1627: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1630: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1633: aconst_null
    //   1634: iconst_5
    //   1635: invokeinterface 169 3 0
    //   1640: goto -1261 -> 379
    //   1643: iload 4
    //   1645: istore_1
    //   1646: iload 4
    //   1648: istore_2
    //   1649: aload_0
    //   1650: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1653: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1656: ifnull -1277 -> 379
    //   1659: iload 4
    //   1661: istore_1
    //   1662: iload 4
    //   1664: istore_2
    //   1665: aload_0
    //   1666: getfield 13	com/tencent/TMG/ptt/Recorder$RecordThread:this$0	Lcom/tencent/TMG/ptt/Recorder;
    //   1669: invokestatic 60	com/tencent/TMG/ptt/Recorder:access$000	(Lcom/tencent/TMG/ptt/Recorder;)Lcom/tencent/TMG/ptt/Recorder$OnQQRecorderListener;
    //   1672: invokeinterface 286 1 0
    //   1677: goto -1298 -> 379
    //   1680: aconst_null
    //   1681: astore 13
    //   1683: goto -457 -> 1226
    //   1686: lconst_0
    //   1687: lstore 7
    //   1689: aconst_null
    //   1690: astore 13
    //   1692: iconst_0
    //   1693: istore 5
    //   1695: goto -1420 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1698	0	this	RecordThread
    //   34	1628	1	i	int
    //   37	1628	2	j	int
    //   26	1522	3	k	int
    //   31	1632	4	m	int
    //   28	1666	5	n	int
    //   1002	222	6	i1	int
    //   288	721	7	localObject1	java.lang.Object
    //   1153	535	7	l1	long
    //   73	1092	9	l2	long
    //   1006	545	11	l3	long
    //   463	37	13	localIOException1	java.io.IOException
    //   694	8	13	localIOException2	java.io.IOException
    //   709	253	13	localException	java.lang.Exception
    //   1196	16	13	arrayOfByte1	byte[]
    //   1510	35	13	localObject2	java.lang.Object
    //   1557	9	13	localIOException3	java.io.IOException
    //   1681	10	13	localObject3	java.lang.Object
    //   110	264	14	localFile	java.io.File
    //   89	1151	15	arrayOfByte2	byte[]
    //   193	1304	16	localFileOutputStream	java.io.FileOutputStream
    //   1257	138	17	arrayOfByte3	byte[]
    //   1402	100	18	arrayOfByte4	byte[]
    // Exception table:
    //   from	to	target	type
    //   173	179	463	java/io/IOException
    //   644	649	694	java/io/IOException
    //   38	48	709	java/lang/Exception
    //   53	72	709	java/lang/Exception
    //   80	91	709	java/lang/Exception
    //   96	112	709	java/lang/Exception
    //   117	131	709	java/lang/Exception
    //   136	144	709	java/lang/Exception
    //   149	157	709	java/lang/Exception
    //   162	168	709	java/lang/Exception
    //   173	179	709	java/lang/Exception
    //   184	195	709	java/lang/Exception
    //   200	210	709	java/lang/Exception
    //   215	225	709	java/lang/Exception
    //   230	240	709	java/lang/Exception
    //   245	255	709	java/lang/Exception
    //   260	272	709	java/lang/Exception
    //   281	288	709	java/lang/Exception
    //   301	318	709	java/lang/Exception
    //   324	332	709	java/lang/Exception
    //   338	343	709	java/lang/Exception
    //   349	354	709	java/lang/Exception
    //   360	367	709	java/lang/Exception
    //   373	379	709	java/lang/Exception
    //   385	395	709	java/lang/Exception
    //   401	412	709	java/lang/Exception
    //   418	429	709	java/lang/Exception
    //   470	514	709	java/lang/Exception
    //   519	529	709	java/lang/Exception
    //   534	554	709	java/lang/Exception
    //   559	566	709	java/lang/Exception
    //   604	614	709	java/lang/Exception
    //   619	639	709	java/lang/Exception
    //   644	649	709	java/lang/Exception
    //   654	661	709	java/lang/Exception
    //   701	706	709	java/lang/Exception
    //   834	852	709	java/lang/Exception
    //   882	892	709	java/lang/Exception
    //   898	911	709	java/lang/Exception
    //   917	922	709	java/lang/Exception
    //   928	933	709	java/lang/Exception
    //   950	955	709	java/lang/Exception
    //   961	972	709	java/lang/Exception
    //   978	1004	709	java/lang/Exception
    //   1021	1026	709	java/lang/Exception
    //   1032	1047	709	java/lang/Exception
    //   1053	1097	709	java/lang/Exception
    //   1103	1113	709	java/lang/Exception
    //   1119	1131	709	java/lang/Exception
    //   1142	1148	709	java/lang/Exception
    //   1192	1198	709	java/lang/Exception
    //   1204	1219	709	java/lang/Exception
    //   1232	1246	709	java/lang/Exception
    //   1252	1259	709	java/lang/Exception
    //   1265	1281	709	java/lang/Exception
    //   1287	1305	709	java/lang/Exception
    //   1317	1337	709	java/lang/Exception
    //   1343	1355	709	java/lang/Exception
    //   1361	1373	709	java/lang/Exception
    //   1379	1385	709	java/lang/Exception
    //   1391	1404	709	java/lang/Exception
    //   1410	1449	709	java/lang/Exception
    //   1455	1468	709	java/lang/Exception
    //   1474	1490	709	java/lang/Exception
    //   1496	1507	709	java/lang/Exception
    //   1565	1570	709	java/lang/Exception
    //   1579	1597	709	java/lang/Exception
    //   1610	1620	709	java/lang/Exception
    //   1626	1640	709	java/lang/Exception
    //   1649	1659	709	java/lang/Exception
    //   1665	1677	709	java/lang/Exception
    //   38	48	1510	finally
    //   53	72	1510	finally
    //   80	91	1510	finally
    //   96	112	1510	finally
    //   117	131	1510	finally
    //   136	144	1510	finally
    //   149	157	1510	finally
    //   162	168	1510	finally
    //   173	179	1510	finally
    //   184	195	1510	finally
    //   200	210	1510	finally
    //   215	225	1510	finally
    //   230	240	1510	finally
    //   245	255	1510	finally
    //   260	272	1510	finally
    //   281	288	1510	finally
    //   301	318	1510	finally
    //   324	332	1510	finally
    //   338	343	1510	finally
    //   349	354	1510	finally
    //   360	367	1510	finally
    //   373	379	1510	finally
    //   385	395	1510	finally
    //   401	412	1510	finally
    //   418	429	1510	finally
    //   470	514	1510	finally
    //   519	529	1510	finally
    //   534	554	1510	finally
    //   559	566	1510	finally
    //   604	614	1510	finally
    //   619	639	1510	finally
    //   644	649	1510	finally
    //   654	661	1510	finally
    //   701	706	1510	finally
    //   713	744	1510	finally
    //   746	756	1510	finally
    //   758	782	1510	finally
    //   834	852	1510	finally
    //   882	892	1510	finally
    //   898	911	1510	finally
    //   917	922	1510	finally
    //   928	933	1510	finally
    //   950	955	1510	finally
    //   961	972	1510	finally
    //   978	1004	1510	finally
    //   1021	1026	1510	finally
    //   1032	1047	1510	finally
    //   1053	1097	1510	finally
    //   1103	1113	1510	finally
    //   1119	1131	1510	finally
    //   1142	1148	1510	finally
    //   1192	1198	1510	finally
    //   1204	1219	1510	finally
    //   1232	1246	1510	finally
    //   1252	1259	1510	finally
    //   1265	1281	1510	finally
    //   1287	1305	1510	finally
    //   1317	1337	1510	finally
    //   1343	1355	1510	finally
    //   1361	1373	1510	finally
    //   1379	1385	1510	finally
    //   1391	1404	1510	finally
    //   1410	1449	1510	finally
    //   1455	1468	1510	finally
    //   1474	1490	1510	finally
    //   1496	1507	1510	finally
    //   1565	1570	1510	finally
    //   1579	1597	1510	finally
    //   1610	1620	1510	finally
    //   1626	1640	1510	finally
    //   1649	1659	1510	finally
    //   1665	1677	1510	finally
    //   349	354	1557	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.ptt.Recorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */