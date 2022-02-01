package com.tencent.aelight.camera.aioeditor.takevideo.publish;

public class HWEncodeMergeThumbSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private final String a;
  
  public HWEncodeMergeThumbSegment()
  {
    this(null);
  }
  
  public HWEncodeMergeThumbSegment(String paramString)
  {
    this.a = paramString;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 29	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:j	Ljava/lang/String;
    //   4: astore 5
    //   6: aload 5
    //   8: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +18 -> 29
    //   14: aload_0
    //   15: new 37	com/tencent/biz/qqstory/base/ErrorMessage
    //   18: dup
    //   19: iconst_m1
    //   20: ldc 39
    //   22: invokespecial 42	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   25: invokespecial 46	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   28: return
    //   29: aload_0
    //   30: getfield 17	com/tencent/aelight/camera/aioeditor/takevideo/publish/HWEncodeMergeThumbSegment:a	Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore 7
    //   37: aload_1
    //   38: ifnonnull +18 -> 56
    //   41: aload_2
    //   42: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:b	I
    //   45: aload_2
    //   46: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:p	Ljava/lang/String;
    //   49: ldc 55
    //   51: invokestatic 60	com/tencent/aelight/camera/aioeditor/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 7
    //   56: aload_2
    //   57: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   60: getfield 69	com/tencent/mobileqq/editor/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   63: astore 11
    //   65: aload_2
    //   66: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   69: getfield 72	com/tencent/mobileqq/editor/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   72: astore 10
    //   74: aload_2
    //   75: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   78: astore_1
    //   79: aconst_null
    //   80: astore 8
    //   82: aload_1
    //   83: ldc 74
    //   85: aconst_null
    //   86: invokevirtual 78	com/tencent/mobileqq/editor/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 12
    //   91: aload_2
    //   92: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   95: ldc 80
    //   97: aconst_null
    //   98: invokevirtual 78	com/tencent/mobileqq/editor/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 9
    //   103: iconst_0
    //   104: istore_3
    //   105: aload 11
    //   107: ifnonnull +89 -> 196
    //   110: aload 10
    //   112: ifnonnull +84 -> 196
    //   115: aload 12
    //   117: ifnonnull +79 -> 196
    //   120: aload 9
    //   122: ifnonnull +74 -> 196
    //   125: ldc 82
    //   127: ldc 84
    //   129: aload 7
    //   131: invokestatic 89	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   134: new 91	java/io/File
    //   137: dup
    //   138: aload 5
    //   140: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: new 91	java/io/File
    //   146: dup
    //   147: aload 7
    //   149: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: invokestatic 97	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   155: ifeq +17 -> 172
    //   158: aload_2
    //   159: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   162: aload 7
    //   164: putfield 100	com/tencent/mobileqq/editor/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   167: iconst_1
    //   168: istore_3
    //   169: goto +693 -> 862
    //   172: ldc 82
    //   174: ldc 102
    //   176: iconst_2
    //   177: anewarray 104	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload 5
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 7
    //   189: aastore
    //   190: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto +669 -> 862
    //   196: new 109	java/io/BufferedInputStream
    //   199: dup
    //   200: new 111	java/io/FileInputStream
    //   203: dup
    //   204: aload 5
    //   206: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   209: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   212: astore 5
    //   214: aload 5
    //   216: astore_1
    //   217: aload 5
    //   219: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   222: astore 6
    //   224: aload 5
    //   226: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   229: goto +104 -> 333
    //   232: astore_1
    //   233: ldc 82
    //   235: ldc 126
    //   237: aload_1
    //   238: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: goto +92 -> 333
    //   244: astore 6
    //   246: goto +20 -> 266
    //   249: astore 6
    //   251: goto +45 -> 296
    //   254: astore_1
    //   255: aconst_null
    //   256: astore 5
    //   258: goto +638 -> 896
    //   261: astore 6
    //   263: aconst_null
    //   264: astore 5
    //   266: aload 5
    //   268: astore_1
    //   269: ldc 82
    //   271: ldc 131
    //   273: aload 6
    //   275: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload 5
    //   280: ifnull +50 -> 330
    //   283: aload 5
    //   285: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   288: goto +42 -> 330
    //   291: astore 6
    //   293: aconst_null
    //   294: astore 5
    //   296: aload 5
    //   298: astore_1
    //   299: ldc 82
    //   301: ldc 133
    //   303: aload 6
    //   305: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 5
    //   310: ifnull +20 -> 330
    //   313: aload 5
    //   315: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   318: goto +12 -> 330
    //   321: astore_1
    //   322: ldc 82
    //   324: ldc 126
    //   326: aload_1
    //   327: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: aconst_null
    //   331: astore 6
    //   333: aload 6
    //   335: ifnonnull +21 -> 356
    //   338: aload_0
    //   339: new 37	com/tencent/biz/qqstory/base/ErrorMessage
    //   342: dup
    //   343: iconst_m1
    //   344: ldc 134
    //   346: invokestatic 139	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   349: invokespecial 42	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   352: invokespecial 46	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   355: return
    //   356: aload 12
    //   358: ifnull +83 -> 441
    //   361: aload 12
    //   363: invokestatic 144	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   366: astore 5
    //   368: goto +76 -> 444
    //   371: astore 5
    //   373: aload 8
    //   375: astore_1
    //   376: new 146	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   383: astore 12
    //   385: aload 8
    //   387: astore_1
    //   388: aload 12
    //   390: ldc 149
    //   392: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 8
    //   398: astore_1
    //   399: aload 12
    //   401: aload 10
    //   403: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 8
    //   409: astore_1
    //   410: aload 12
    //   412: ldc 155
    //   414: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 8
    //   420: astore_1
    //   421: ldc 82
    //   423: aload 12
    //   425: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: aload 5
    //   430: invokestatic 162	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   433: goto +8 -> 441
    //   436: astore 5
    //   438: goto +187 -> 625
    //   441: aconst_null
    //   442: astore 5
    //   444: aload 5
    //   446: astore_1
    //   447: aload 5
    //   449: ifnonnull +65 -> 514
    //   452: aload 5
    //   454: astore_1
    //   455: aload 11
    //   457: ifnull +57 -> 514
    //   460: aload 5
    //   462: astore_1
    //   463: aload 11
    //   465: aconst_null
    //   466: invokestatic 165	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)Landroid/graphics/Bitmap;
    //   469: astore 5
    //   471: aload 5
    //   473: astore_1
    //   474: ldc 82
    //   476: ldc 167
    //   478: iconst_1
    //   479: anewarray 104	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: aload 11
    //   486: aastore
    //   487: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 5
    //   492: astore_1
    //   493: goto +21 -> 514
    //   496: astore 5
    //   498: aconst_null
    //   499: astore_1
    //   500: goto +125 -> 625
    //   503: astore 5
    //   505: ldc 82
    //   507: ldc 169
    //   509: aload 5
    //   511: invokestatic 162	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   514: aload_1
    //   515: astore 5
    //   517: aload_1
    //   518: ifnonnull +71 -> 589
    //   521: aload_1
    //   522: astore 5
    //   524: aload 10
    //   526: ifnull +63 -> 589
    //   529: aload 10
    //   531: invokestatic 172	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   534: astore 5
    //   536: goto +53 -> 589
    //   539: astore 5
    //   541: new 146	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   548: astore 8
    //   550: aload 8
    //   552: ldc 149
    //   554: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 8
    //   560: aload 10
    //   562: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 8
    //   568: ldc 155
    //   570: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: ldc 82
    //   576: aload 8
    //   578: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: aload 5
    //   583: invokestatic 162	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   586: aload_1
    //   587: astore 5
    //   589: aload 5
    //   591: ifnull +72 -> 663
    //   594: aload 6
    //   596: aload 5
    //   598: invokestatic 175	com/tencent/biz/qqstory/utils/BitmapUtils:b	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   601: astore 8
    //   603: aload 8
    //   605: astore_1
    //   606: aload 5
    //   608: invokevirtual 180	android/graphics/Bitmap:recycle	()V
    //   611: aload 8
    //   613: astore_1
    //   614: aload 6
    //   616: invokevirtual 180	android/graphics/Bitmap:recycle	()V
    //   619: aload 8
    //   621: astore_1
    //   622: goto +44 -> 666
    //   625: new 146	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   632: astore 6
    //   634: aload 6
    //   636: ldc 182
    //   638: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 6
    //   644: aload 5
    //   646: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc 82
    //   652: aload 6
    //   654: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 189	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: goto +6 -> 666
    //   663: aload 6
    //   665: astore_1
    //   666: aload_1
    //   667: astore 5
    //   669: aload_1
    //   670: ifnull +108 -> 778
    //   673: aload_1
    //   674: astore 5
    //   676: aload 9
    //   678: ifnull +100 -> 778
    //   681: aload 9
    //   683: invokestatic 172	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   686: astore 8
    //   688: aload_1
    //   689: astore 5
    //   691: aload 8
    //   693: ifnull +85 -> 778
    //   696: aload_1
    //   697: aload 8
    //   699: invokestatic 175	com/tencent/biz/qqstory/utils/BitmapUtils:b	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   702: astore 6
    //   704: aload_1
    //   705: astore 5
    //   707: aload 6
    //   709: ifnull +69 -> 778
    //   712: aload_1
    //   713: invokevirtual 180	android/graphics/Bitmap:recycle	()V
    //   716: aload 8
    //   718: invokevirtual 180	android/graphics/Bitmap:recycle	()V
    //   721: aload 6
    //   723: astore 5
    //   725: goto +53 -> 778
    //   728: astore 5
    //   730: new 146	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   737: astore 6
    //   739: aload 6
    //   741: ldc 149
    //   743: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 6
    //   749: aload 9
    //   751: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload 6
    //   757: ldc 155
    //   759: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: ldc 82
    //   765: aload 6
    //   767: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: aload 5
    //   772: invokestatic 162	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   775: aload_1
    //   776: astore 5
    //   778: aload 5
    //   780: ifnonnull +6 -> 786
    //   783: goto +79 -> 862
    //   786: getstatic 194	com/tencent/biz/qqstory/app/QQStoryConstant:g	Ljava/lang/String;
    //   789: invokestatic 197	com/tencent/biz/qqstory/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   792: pop
    //   793: aload 5
    //   795: aload 7
    //   797: invokestatic 200	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   800: istore 4
    //   802: aload 5
    //   804: invokevirtual 180	android/graphics/Bitmap:recycle	()V
    //   807: iload 4
    //   809: ifeq +46 -> 855
    //   812: aload_2
    //   813: getfield 64	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   816: aload 7
    //   818: putfield 100	com/tencent/mobileqq/editor/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   821: new 146	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   828: astore_1
    //   829: aload_1
    //   830: ldc 202
    //   832: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload_1
    //   837: aload 7
    //   839: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: ldc 82
    //   845: aload_1
    //   846: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 204	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: goto -685 -> 167
    //   855: ldc 82
    //   857: ldc 206
    //   859: invokestatic 208	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: iload_3
    //   863: ifeq +9 -> 872
    //   866: aload_0
    //   867: aload_2
    //   868: invokespecial 212	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   871: return
    //   872: aload_0
    //   873: new 37	com/tencent/biz/qqstory/base/ErrorMessage
    //   876: dup
    //   877: iconst_m1
    //   878: ldc 213
    //   880: invokestatic 139	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   883: invokespecial 42	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   886: invokespecial 46	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   889: return
    //   890: astore_2
    //   891: aload_1
    //   892: astore 5
    //   894: aload_2
    //   895: astore_1
    //   896: aload 5
    //   898: ifnull +20 -> 918
    //   901: aload 5
    //   903: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   906: goto +12 -> 918
    //   909: astore_2
    //   910: ldc 82
    //   912: ldc 126
    //   914: aload_2
    //   915: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   918: goto +5 -> 923
    //   921: aload_1
    //   922: athrow
    //   923: goto -2 -> 921
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	HWEncodeMergeThumbSegment
    //   0	926	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	926	2	paramGenerateContext	GenerateContext
    //   104	759	3	i	int
    //   800	8	4	bool	boolean
    //   4	363	5	localObject1	java.lang.Object
    //   371	58	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   436	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   442	49	5	localBitmap1	android.graphics.Bitmap
    //   496	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   503	7	5	localIOException	java.io.IOException
    //   515	20	5	localObject2	java.lang.Object
    //   539	43	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   587	137	5	localObject3	java.lang.Object
    //   728	43	5	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   776	126	5	localJobContext	com.tribe.async.async.JobContext
    //   222	1	6	localBitmap2	android.graphics.Bitmap
    //   244	1	6	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   249	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   261	13	6	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   291	13	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   331	435	6	localObject4	java.lang.Object
    //   35	803	7	localObject5	java.lang.Object
    //   80	637	8	localObject6	java.lang.Object
    //   101	649	9	str1	String
    //   72	489	10	str2	String
    //   63	422	11	str3	String
    //   89	335	12	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   224	229	232	java/io/IOException
    //   217	224	244	java/lang/OutOfMemoryError
    //   217	224	249	java/io/FileNotFoundException
    //   196	214	254	finally
    //   196	214	261	java/lang/OutOfMemoryError
    //   196	214	291	java/io/FileNotFoundException
    //   283	288	321	java/io/IOException
    //   313	318	321	java/io/IOException
    //   361	368	371	java/lang/OutOfMemoryError
    //   376	385	436	java/lang/OutOfMemoryError
    //   388	396	436	java/lang/OutOfMemoryError
    //   399	407	436	java/lang/OutOfMemoryError
    //   410	418	436	java/lang/OutOfMemoryError
    //   421	433	436	java/lang/OutOfMemoryError
    //   606	611	436	java/lang/OutOfMemoryError
    //   614	619	436	java/lang/OutOfMemoryError
    //   463	471	496	java/lang/OutOfMemoryError
    //   474	490	496	java/lang/OutOfMemoryError
    //   505	514	496	java/lang/OutOfMemoryError
    //   541	586	496	java/lang/OutOfMemoryError
    //   594	603	496	java/lang/OutOfMemoryError
    //   463	471	503	java/io/IOException
    //   474	490	503	java/io/IOException
    //   529	536	539	java/lang/OutOfMemoryError
    //   681	688	728	java/lang/OutOfMemoryError
    //   696	704	728	java/lang/OutOfMemoryError
    //   712	721	728	java/lang/OutOfMemoryError
    //   217	224	890	finally
    //   269	278	890	finally
    //   299	308	890	finally
    //   901	906	909	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeMergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */