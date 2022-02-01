package com.tencent.av.utils;

class QQRecorder$RecordThread
  extends Thread
{
  public volatile boolean a;
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 22
    //   8: iconst_2
    //   9: new 24	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   16: ldc 29
    //   18: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aconst_null
    //   32: astore 12
    //   34: aconst_null
    //   35: astore 10
    //   37: aconst_null
    //   38: astore 11
    //   40: aload 10
    //   42: astore 9
    //   44: aload_0
    //   45: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   48: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   51: ifnull +26 -> 77
    //   54: aload 10
    //   56: astore 9
    //   58: aload_0
    //   59: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   62: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   65: aload_0
    //   66: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   69: getfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokeinterface 59 2 0
    //   77: lconst_0
    //   78: lstore 5
    //   80: iconst_0
    //   81: istore_3
    //   82: aload 10
    //   84: astore 9
    //   86: aload_0
    //   87: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   90: invokestatic 62	com/tencent/av/utils/QQRecorder:a	(Lcom/tencent/av/utils/QQRecorder;)I
    //   93: newarray byte
    //   95: astore 13
    //   97: aload 10
    //   99: astore 9
    //   101: new 64	java/io/File
    //   104: dup
    //   105: aload_0
    //   106: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   109: getfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 14
    //   117: aload 10
    //   119: astore 9
    //   121: aload 14
    //   123: invokevirtual 69	java/io/File:exists	()Z
    //   126: ifeq +35 -> 161
    //   129: aload 10
    //   131: astore 9
    //   133: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +15 -> 151
    //   139: aload 10
    //   141: astore 9
    //   143: ldc 22
    //   145: iconst_2
    //   146: ldc 71
    //   148: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 10
    //   153: astore 9
    //   155: aload 14
    //   157: invokevirtual 74	java/io/File:delete	()Z
    //   160: pop
    //   161: aload 10
    //   163: astore 9
    //   165: aload 14
    //   167: invokevirtual 77	java/io/File:createNewFile	()Z
    //   170: pop
    //   171: aload 10
    //   173: astore 9
    //   175: aload_0
    //   176: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   179: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   182: ifnull +512 -> 694
    //   185: aload 10
    //   187: astore 9
    //   189: aload_0
    //   190: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   193: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   196: invokevirtual 85	android/media/AudioRecord:startRecording	()V
    //   199: aload 10
    //   201: astore 9
    //   203: aload_0
    //   204: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   207: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   210: ifnull +19 -> 229
    //   213: aload 10
    //   215: astore 9
    //   217: aload_0
    //   218: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   221: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   224: invokeinterface 87 1 0
    //   229: aload 10
    //   231: astore 9
    //   233: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   236: lstore 7
    //   238: iconst_0
    //   239: istore_2
    //   240: aload 10
    //   242: astore 9
    //   244: new 95	java/io/FileOutputStream
    //   247: dup
    //   248: aload 14
    //   250: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   253: astore 10
    //   255: aload 12
    //   257: astore 9
    //   259: aload_0
    //   260: getfield 100	com/tencent/av/utils/QQRecorder$RecordThread:a	Z
    //   263: ifeq +648 -> 911
    //   266: iload_2
    //   267: istore_1
    //   268: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   271: lload 7
    //   273: lsub
    //   274: ldc2_w 101
    //   277: lcmp
    //   278: ifle +105 -> 383
    //   281: iload_2
    //   282: istore_1
    //   283: iload_2
    //   284: ifne +99 -> 383
    //   287: iconst_1
    //   288: istore_2
    //   289: lload 5
    //   291: lconst_0
    //   292: lcmp
    //   293: ifeq +9 -> 302
    //   296: iload_2
    //   297: istore_1
    //   298: iload_3
    //   299: ifne +84 -> 383
    //   302: aload_0
    //   303: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   306: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   309: ifnull +29 -> 338
    //   312: aload_0
    //   313: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   316: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   319: astore 11
    //   321: lload 5
    //   323: lconst_0
    //   324: lcmp
    //   325: ifne +494 -> 819
    //   328: iconst_0
    //   329: istore_1
    //   330: aload 11
    //   332: iload_1
    //   333: invokeinterface 105 2 0
    //   338: iload_2
    //   339: istore_1
    //   340: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +40 -> 383
    //   346: ldc 22
    //   348: iconst_2
    //   349: new 24	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   356: ldc 107
    //   358: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: lload 5
    //   363: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: ldc 112
    //   368: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload_3
    //   372: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: iload_2
    //   382: istore_1
    //   383: iconst_0
    //   384: istore_2
    //   385: aload 9
    //   387: ifnull +17 -> 404
    //   390: aload 9
    //   392: arraylength
    //   393: istore_2
    //   394: aload 9
    //   396: iconst_0
    //   397: aload 13
    //   399: iconst_0
    //   400: iload_2
    //   401: invokestatic 119	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   404: aload_0
    //   405: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   408: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   411: aload 13
    //   413: iload_2
    //   414: aload_0
    //   415: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   418: invokestatic 62	com/tencent/av/utils/QQRecorder:a	(Lcom/tencent/av/utils/QQRecorder;)I
    //   421: iload_2
    //   422: isub
    //   423: invokevirtual 123	android/media/AudioRecord:read	([BII)I
    //   426: istore 4
    //   428: aload_0
    //   429: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   432: invokestatic 62	com/tencent/av/utils/QQRecorder:a	(Lcom/tencent/av/utils/QQRecorder;)I
    //   435: iload_2
    //   436: isub
    //   437: iload 4
    //   439: if_icmpeq +46 -> 485
    //   442: ldc 22
    //   444: iconst_2
    //   445: new 24	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   452: ldc 125
    //   454: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   461: invokestatic 62	com/tencent/av/utils/QQRecorder:a	(Lcom/tencent/av/utils/QQRecorder;)I
    //   464: iload_2
    //   465: isub
    //   466: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: ldc 127
    //   471: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: iload 4
    //   476: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   479: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_0
    //   486: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   489: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   492: ifnull +15 -> 507
    //   495: aload_0
    //   496: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   499: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   502: invokeinterface 130 1 0
    //   507: iload 4
    //   509: ifgt +315 -> 824
    //   512: ldc2_w 131
    //   515: invokestatic 136	java/lang/Thread:sleep	(J)V
    //   518: iload_1
    //   519: istore_2
    //   520: goto -261 -> 259
    //   523: astore 12
    //   525: aload 10
    //   527: astore 9
    //   529: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +36 -> 568
    //   535: aload 10
    //   537: astore 9
    //   539: ldc 22
    //   541: iconst_2
    //   542: new 24	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   549: ldc 138
    //   551: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 12
    //   556: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   559: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: aload 10
    //   570: astore 9
    //   572: aload_0
    //   573: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   576: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   579: ifnull +27 -> 606
    //   582: aload 10
    //   584: astore 9
    //   586: aload_0
    //   587: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   590: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   593: aload_0
    //   594: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   597: getfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   600: iconst_2
    //   601: invokeinterface 147 3 0
    //   606: aload_0
    //   607: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   610: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   613: ifnull +13 -> 626
    //   616: aload_0
    //   617: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   620: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   623: invokevirtual 150	android/media/AudioRecord:release	()V
    //   626: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +28 -> 657
    //   632: ldc 22
    //   634: iconst_2
    //   635: new 24	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   642: ldc 152
    //   644: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_0
    //   648: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: aload_0
    //   658: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   661: aconst_null
    //   662: putfield 155	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   665: aload_0
    //   666: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   669: aconst_null
    //   670: putfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   673: iconst_0
    //   674: ifeq +11 -> 685
    //   677: new 157	java/lang/NullPointerException
    //   680: dup
    //   681: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   684: athrow
    //   685: return
    //   686: astore 9
    //   688: aload 9
    //   690: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   693: return
    //   694: aload 10
    //   696: astore 9
    //   698: aload_0
    //   699: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   702: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   705: ifnull +27 -> 732
    //   708: aload 10
    //   710: astore 9
    //   712: aload_0
    //   713: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   716: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   719: aload_0
    //   720: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   723: getfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   726: iconst_4
    //   727: invokeinterface 147 3 0
    //   732: aload_0
    //   733: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   736: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   739: ifnull +13 -> 752
    //   742: aload_0
    //   743: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   746: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   749: invokevirtual 150	android/media/AudioRecord:release	()V
    //   752: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   755: ifeq +28 -> 783
    //   758: ldc 22
    //   760: iconst_2
    //   761: new 24	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   768: ldc 152
    //   770: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload_0
    //   774: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_0
    //   784: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   787: aconst_null
    //   788: putfield 155	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   791: aload_0
    //   792: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   795: aconst_null
    //   796: putfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   799: iconst_0
    //   800: ifeq -115 -> 685
    //   803: new 157	java/lang/NullPointerException
    //   806: dup
    //   807: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   810: athrow
    //   811: astore 9
    //   813: aload 9
    //   815: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   818: return
    //   819: iconst_1
    //   820: istore_1
    //   821: goto -491 -> 330
    //   824: aconst_null
    //   825: astore 9
    //   827: lload 5
    //   829: iload 4
    //   831: i2l
    //   832: ladd
    //   833: lstore 5
    //   835: iload_2
    //   836: iload 4
    //   838: iadd
    //   839: istore_2
    //   840: iload_2
    //   841: sipush 160
    //   844: irem
    //   845: istore 4
    //   847: iload 4
    //   849: ifeq +500 -> 1349
    //   852: iload 4
    //   854: newarray byte
    //   856: astore 9
    //   858: aload 13
    //   860: iload_2
    //   861: iload 4
    //   863: isub
    //   864: aload 9
    //   866: iconst_0
    //   867: iload 4
    //   869: invokestatic 119	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   872: iload_2
    //   873: iload 4
    //   875: isub
    //   876: istore_2
    //   877: iload_3
    //   878: aload_0
    //   879: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   882: getfield 164	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   885: aload 13
    //   887: iload_2
    //   888: fconst_1
    //   889: invokestatic 169	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   892: l2i
    //   893: invokestatic 175	java/lang/Math:max	(II)I
    //   896: istore_3
    //   897: aload 10
    //   899: aload 13
    //   901: iconst_0
    //   902: iload_2
    //   903: invokevirtual 179	java/io/FileOutputStream:write	([BII)V
    //   906: iload_1
    //   907: istore_2
    //   908: goto -649 -> 259
    //   911: aload 10
    //   913: invokevirtual 182	java/io/FileOutputStream:flush	()V
    //   916: aload_0
    //   917: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   920: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   923: ifnull +15 -> 938
    //   926: aload_0
    //   927: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   930: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   933: invokeinterface 185 1 0
    //   938: aload_0
    //   939: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   942: getfield 188	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   945: ifnull +25 -> 970
    //   948: aload_0
    //   949: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   952: getfield 191	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Int	I
    //   955: iconst_m1
    //   956: if_icmpeq +14 -> 970
    //   959: aload_0
    //   960: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   963: getfield 188	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   966: iconst_0
    //   967: invokevirtual 196	android/media/AudioManager:setMode	(I)V
    //   970: aload_0
    //   971: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   974: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   977: ifnull +13 -> 990
    //   980: aload_0
    //   981: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   984: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   987: invokevirtual 150	android/media/AudioRecord:release	()V
    //   990: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   993: ifeq +28 -> 1021
    //   996: ldc 22
    //   998: iconst_2
    //   999: new 24	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   1006: ldc 152
    //   1008: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_0
    //   1012: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload_0
    //   1022: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1025: aconst_null
    //   1026: putfield 155	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   1029: aload_0
    //   1030: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1033: aconst_null
    //   1034: putfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1037: aload 10
    //   1039: ifnull -354 -> 685
    //   1042: aload 10
    //   1044: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   1047: return
    //   1048: astore 9
    //   1050: aload 9
    //   1052: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   1055: return
    //   1056: astore 9
    //   1058: aload 11
    //   1060: astore 10
    //   1062: aload 9
    //   1064: astore 11
    //   1066: aload 10
    //   1068: astore 9
    //   1070: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1073: ifeq +38 -> 1111
    //   1076: aload 10
    //   1078: astore 9
    //   1080: ldc 22
    //   1082: iconst_2
    //   1083: new 24	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   1090: ldc 201
    //   1092: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload 11
    //   1097: invokestatic 207	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1100: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: aload 11
    //   1108: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1111: aload 10
    //   1113: astore 9
    //   1115: aload_0
    //   1116: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1119: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   1122: ifnull +31 -> 1153
    //   1125: aload 10
    //   1127: astore 9
    //   1129: aload_0
    //   1130: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1133: getfield 51	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Msw	Lmsw;
    //   1136: aload_0
    //   1137: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1140: getfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1143: aload 11
    //   1145: invokevirtual 211	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1148: invokeinterface 214 3 0
    //   1153: aload_0
    //   1154: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1157: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   1160: ifnull +13 -> 1173
    //   1163: aload_0
    //   1164: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1167: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   1170: invokevirtual 150	android/media/AudioRecord:release	()V
    //   1173: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1176: ifeq +28 -> 1204
    //   1179: ldc 22
    //   1181: iconst_2
    //   1182: new 24	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   1189: ldc 152
    //   1191: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: aload_0
    //   1195: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1198: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1204: aload_0
    //   1205: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1208: aconst_null
    //   1209: putfield 155	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   1212: aload_0
    //   1213: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1216: aconst_null
    //   1217: putfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1220: aload 10
    //   1222: ifnull -537 -> 685
    //   1225: aload 10
    //   1227: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   1230: return
    //   1231: astore 9
    //   1233: aload 9
    //   1235: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   1238: return
    //   1239: astore 11
    //   1241: aload 9
    //   1243: astore 10
    //   1245: aload 11
    //   1247: astore 9
    //   1249: aload_0
    //   1250: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1253: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   1256: ifnull +13 -> 1269
    //   1259: aload_0
    //   1260: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1263: getfield 80	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   1266: invokevirtual 150	android/media/AudioRecord:release	()V
    //   1269: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +28 -> 1300
    //   1275: ldc 22
    //   1277: iconst_2
    //   1278: new 24	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   1285: ldc 152
    //   1287: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload_0
    //   1291: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1294: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: aload_0
    //   1301: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1304: aconst_null
    //   1305: putfield 155	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   1308: aload_0
    //   1309: getfield 46	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   1312: aconst_null
    //   1313: putfield 54	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1316: aload 10
    //   1318: ifnull +8 -> 1326
    //   1321: aload 10
    //   1323: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   1326: aload 9
    //   1328: athrow
    //   1329: astore 10
    //   1331: aload 10
    //   1333: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   1336: goto -10 -> 1326
    //   1339: astore 9
    //   1341: goto -92 -> 1249
    //   1344: astore 11
    //   1346: goto -280 -> 1066
    //   1349: goto -472 -> 877
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1352	0	this	RecordThread
    //   267	640	1	i	int
    //   239	669	2	j	int
    //   81	816	3	k	int
    //   426	450	4	m	int
    //   78	756	5	l1	long
    //   236	36	7	l2	long
    //   42	543	9	localObject1	java.lang.Object
    //   686	3	9	localIOException1	java.io.IOException
    //   696	15	9	localObject2	java.lang.Object
    //   811	3	9	localIOException2	java.io.IOException
    //   825	40	9	arrayOfByte1	byte[]
    //   1048	3	9	localIOException3	java.io.IOException
    //   1056	7	9	localThrowable1	java.lang.Throwable
    //   1068	60	9	localObject3	java.lang.Object
    //   1231	11	9	localIOException4	java.io.IOException
    //   1247	80	9	localObject4	java.lang.Object
    //   1339	1	9	localObject5	java.lang.Object
    //   35	1287	10	localObject6	java.lang.Object
    //   1329	3	10	localIOException5	java.io.IOException
    //   38	1106	11	localObject7	java.lang.Object
    //   1239	7	11	localObject8	java.lang.Object
    //   1344	1	11	localThrowable2	java.lang.Throwable
    //   32	224	12	localObject9	java.lang.Object
    //   523	32	12	localIOException6	java.io.IOException
    //   95	805	13	arrayOfByte2	byte[]
    //   115	134	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   165	171	523	java/io/IOException
    //   677	685	686	java/io/IOException
    //   803	811	811	java/io/IOException
    //   1042	1047	1048	java/io/IOException
    //   44	54	1056	java/lang/Throwable
    //   58	77	1056	java/lang/Throwable
    //   86	97	1056	java/lang/Throwable
    //   101	117	1056	java/lang/Throwable
    //   121	129	1056	java/lang/Throwable
    //   133	139	1056	java/lang/Throwable
    //   143	151	1056	java/lang/Throwable
    //   155	161	1056	java/lang/Throwable
    //   165	171	1056	java/lang/Throwable
    //   175	185	1056	java/lang/Throwable
    //   189	199	1056	java/lang/Throwable
    //   203	213	1056	java/lang/Throwable
    //   217	229	1056	java/lang/Throwable
    //   233	238	1056	java/lang/Throwable
    //   244	255	1056	java/lang/Throwable
    //   529	535	1056	java/lang/Throwable
    //   539	568	1056	java/lang/Throwable
    //   572	582	1056	java/lang/Throwable
    //   586	606	1056	java/lang/Throwable
    //   698	708	1056	java/lang/Throwable
    //   712	732	1056	java/lang/Throwable
    //   1225	1230	1231	java/io/IOException
    //   44	54	1239	finally
    //   58	77	1239	finally
    //   86	97	1239	finally
    //   101	117	1239	finally
    //   121	129	1239	finally
    //   133	139	1239	finally
    //   143	151	1239	finally
    //   155	161	1239	finally
    //   165	171	1239	finally
    //   175	185	1239	finally
    //   189	199	1239	finally
    //   203	213	1239	finally
    //   217	229	1239	finally
    //   233	238	1239	finally
    //   244	255	1239	finally
    //   529	535	1239	finally
    //   539	568	1239	finally
    //   572	582	1239	finally
    //   586	606	1239	finally
    //   698	708	1239	finally
    //   712	732	1239	finally
    //   1070	1076	1239	finally
    //   1080	1111	1239	finally
    //   1115	1125	1239	finally
    //   1129	1153	1239	finally
    //   1321	1326	1329	java/io/IOException
    //   259	266	1339	finally
    //   268	281	1339	finally
    //   302	321	1339	finally
    //   330	338	1339	finally
    //   340	381	1339	finally
    //   390	404	1339	finally
    //   404	485	1339	finally
    //   485	507	1339	finally
    //   512	518	1339	finally
    //   852	872	1339	finally
    //   877	906	1339	finally
    //   911	938	1339	finally
    //   938	970	1339	finally
    //   259	266	1344	java/lang/Throwable
    //   268	281	1344	java/lang/Throwable
    //   302	321	1344	java/lang/Throwable
    //   330	338	1344	java/lang/Throwable
    //   340	381	1344	java/lang/Throwable
    //   390	404	1344	java/lang/Throwable
    //   404	485	1344	java/lang/Throwable
    //   485	507	1344	java/lang/Throwable
    //   512	518	1344	java/lang/Throwable
    //   852	872	1344	java/lang/Throwable
    //   877	906	1344	java/lang/Throwable
    //   911	938	1344	java/lang/Throwable
    //   938	970	1344	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.QQRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */