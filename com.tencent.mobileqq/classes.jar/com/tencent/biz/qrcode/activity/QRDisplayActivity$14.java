package com.tencent.biz.qrcode.activity;

class QRDisplayActivity$14
  implements Runnable
{
  QRDisplayActivity$14(QRDisplayActivity paramQRDisplayActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$14:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   4: getfield 31	com/tencent/biz/qrcode/activity/QRDisplayActivity:b	Landroid/graphics/Bitmap;
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aload 11
    //   26: ifnull +548 -> 574
    //   29: aload 11
    //   31: invokevirtual 37	android/graphics/Bitmap:isRecycled	()Z
    //   34: ifne +540 -> 574
    //   37: new 39	java/io/File
    //   40: dup
    //   41: getstatic 45	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   44: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 51	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: aload 6
    //   57: invokevirtual 54	java/io/File:canWrite	()Z
    //   60: ifeq +514 -> 574
    //   63: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   66: invokestatic 66	java/lang/Long:toString	(J)Ljava/lang/String;
    //   69: astore 5
    //   71: new 68	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: getstatic 45	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   85: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 6
    //   91: ldc 75
    //   93: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 6
    //   99: aload 5
    //   101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: ldc 77
    //   109: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 6
    //   120: new 39	java/io/File
    //   123: dup
    //   124: aload 6
    //   126: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore 7
    //   131: iconst_2
    //   132: istore_1
    //   133: aload 7
    //   135: invokevirtual 83	java/io/File:exists	()Z
    //   138: ifeq +91 -> 229
    //   141: iload_1
    //   142: ldc 84
    //   144: if_icmpge +85 -> 229
    //   147: new 68	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   154: astore 6
    //   156: aload 6
    //   158: getstatic 45	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc 75
    //   169: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 6
    //   175: aload 5
    //   177: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 6
    //   183: ldc 86
    //   185: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 6
    //   191: iload_1
    //   192: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: ldc 91
    //   200: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 6
    //   206: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 6
    //   211: new 39	java/io/File
    //   214: dup
    //   215: aload 6
    //   217: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: astore 7
    //   222: iload_1
    //   223: iconst_1
    //   224: iadd
    //   225: istore_1
    //   226: goto -93 -> 133
    //   229: new 93	java/io/BufferedOutputStream
    //   232: dup
    //   233: new 95	java/io/FileOutputStream
    //   236: dup
    //   237: aload 7
    //   239: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   242: sipush 8192
    //   245: invokespecial 101	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   248: astore 5
    //   250: aload 11
    //   252: getstatic 107	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   255: bipush 75
    //   257: aload 5
    //   259: invokevirtual 111	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   262: istore_3
    //   263: aload 5
    //   265: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   268: iload_3
    //   269: istore_2
    //   270: goto +244 -> 514
    //   273: astore 4
    //   275: iload_3
    //   276: istore_2
    //   277: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +234 -> 514
    //   283: ldc 121
    //   285: iconst_2
    //   286: aload 4
    //   288: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   291: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iload_3
    //   295: istore_2
    //   296: goto +218 -> 514
    //   299: astore 6
    //   301: aload 5
    //   303: astore 4
    //   305: aload 6
    //   307: astore 5
    //   309: goto +230 -> 539
    //   312: astore 8
    //   314: goto +28 -> 342
    //   317: astore 8
    //   319: goto +89 -> 408
    //   322: astore 8
    //   324: goto +139 -> 463
    //   327: astore 5
    //   329: goto +210 -> 539
    //   332: astore 4
    //   334: aload 8
    //   336: astore 5
    //   338: aload 4
    //   340: astore 8
    //   342: aload 5
    //   344: astore 4
    //   346: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +18 -> 367
    //   352: aload 5
    //   354: astore 4
    //   356: ldc 121
    //   358: iconst_2
    //   359: aload 8
    //   361: invokevirtual 129	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   364: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload 5
    //   369: ifnull +143 -> 512
    //   372: aload 5
    //   374: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   377: goto +135 -> 512
    //   380: astore 4
    //   382: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +127 -> 512
    //   388: ldc 121
    //   390: iconst_2
    //   391: aload 4
    //   393: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto +113 -> 512
    //   402: astore 8
    //   404: aload 9
    //   406: astore 5
    //   408: aload 5
    //   410: astore 4
    //   412: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +18 -> 433
    //   418: aload 5
    //   420: astore 4
    //   422: ldc 121
    //   424: iconst_2
    //   425: aload 8
    //   427: invokevirtual 130	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   430: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload 5
    //   435: ifnull +77 -> 512
    //   438: aload 5
    //   440: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   443: goto +69 -> 512
    //   446: astore 4
    //   448: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +61 -> 512
    //   454: goto -66 -> 388
    //   457: astore 8
    //   459: aload 10
    //   461: astore 5
    //   463: aload 5
    //   465: astore 4
    //   467: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +18 -> 488
    //   473: aload 5
    //   475: astore 4
    //   477: ldc 121
    //   479: iconst_2
    //   480: aload 8
    //   482: invokevirtual 131	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   485: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload 5
    //   490: ifnull +22 -> 512
    //   493: aload 5
    //   495: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   498: goto +14 -> 512
    //   501: astore 4
    //   503: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +6 -> 512
    //   509: goto -121 -> 388
    //   512: iconst_0
    //   513: istore_2
    //   514: iload_2
    //   515: ifne +17 -> 532
    //   518: aload 7
    //   520: invokevirtual 83	java/io/File:exists	()Z
    //   523: ifeq +9 -> 532
    //   526: aload 7
    //   528: invokevirtual 134	java/io/File:delete	()Z
    //   531: pop
    //   532: aload 6
    //   534: astore 4
    //   536: goto +44 -> 580
    //   539: aload 4
    //   541: ifnull +30 -> 571
    //   544: aload 4
    //   546: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   549: goto +22 -> 571
    //   552: astore 4
    //   554: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +14 -> 571
    //   560: ldc 121
    //   562: iconst_2
    //   563: aload 4
    //   565: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   568: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload 5
    //   573: athrow
    //   574: iconst_0
    //   575: istore_2
    //   576: aload 5
    //   578: astore 4
    //   580: aload_0
    //   581: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$14:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   584: getfield 138	com/tencent/biz/qrcode/activity/QRDisplayActivity:jdField_c_of_type_Int	I
    //   587: iconst_2
    //   588: if_icmpne +67 -> 655
    //   591: aload_0
    //   592: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$14:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   595: getfield 140	com/tencent/biz/qrcode/activity/QRDisplayActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   598: astore 6
    //   600: aload_0
    //   601: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$14:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   604: getfield 143	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	I
    //   607: istore_1
    //   608: iload_2
    //   609: ifeq +10 -> 619
    //   612: ldc 145
    //   614: astore 5
    //   616: goto +7 -> 623
    //   619: ldc 147
    //   621: astore 5
    //   623: ldc 149
    //   625: ldc 151
    //   627: ldc 153
    //   629: iconst_0
    //   630: iconst_0
    //   631: iconst_3
    //   632: anewarray 155	java/lang/String
    //   635: dup
    //   636: iconst_0
    //   637: aload 6
    //   639: aastore
    //   640: dup
    //   641: iconst_1
    //   642: iload_1
    //   643: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   646: aastore
    //   647: dup
    //   648: iconst_2
    //   649: aload 5
    //   651: aastore
    //   652: invokestatic 164	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   655: aload_0
    //   656: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$14:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   659: new 166	com/tencent/biz/qrcode/activity/QRDisplayActivity$14$1
    //   662: dup
    //   663: aload_0
    //   664: iload_2
    //   665: aload 4
    //   667: invokespecial 169	com/tencent/biz/qrcode/activity/QRDisplayActivity$14$1:<init>	(Lcom/tencent/biz/qrcode/activity/QRDisplayActivity$14;ZLjava/lang/String;)V
    //   670: invokevirtual 173	com/tencent/biz/qrcode/activity/QRDisplayActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   673: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	14
    //   132	511	1	i	int
    //   269	396	2	bool1	boolean
    //   262	33	3	bool2	boolean
    //   22	1	4	localObject1	Object
    //   273	14	4	localIOException1	java.io.IOException
    //   303	1	4	localObject2	Object
    //   332	7	4	localIllegalStateException1	java.lang.IllegalStateException
    //   344	11	4	localObject3	Object
    //   380	12	4	localIOException2	java.io.IOException
    //   410	11	4	localObject4	Object
    //   446	1	4	localIOException3	java.io.IOException
    //   465	11	4	localObject5	Object
    //   501	1	4	localIOException4	java.io.IOException
    //   534	11	4	localObject6	Object
    //   552	12	4	localIOException5	java.io.IOException
    //   578	88	4	localObject7	Object
    //   19	289	5	localObject8	Object
    //   327	1	5	localObject9	Object
    //   336	314	5	localObject10	Object
    //   47	169	6	localObject11	Object
    //   299	234	6	localObject12	Object
    //   598	40	6	str	java.lang.String
    //   129	398	7	localFile	java.io.File
    //   10	1	8	localObject13	Object
    //   312	1	8	localIllegalStateException2	java.lang.IllegalStateException
    //   317	1	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   322	13	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   340	20	8	localObject14	Object
    //   402	24	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   457	24	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   13	392	9	localObject15	Object
    //   16	444	10	localObject16	Object
    //   7	244	11	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   263	268	273	java/io/IOException
    //   250	263	299	finally
    //   250	263	312	java/lang/IllegalStateException
    //   250	263	317	java/lang/OutOfMemoryError
    //   250	263	322	java/io/FileNotFoundException
    //   229	250	327	finally
    //   346	352	327	finally
    //   356	367	327	finally
    //   412	418	327	finally
    //   422	433	327	finally
    //   467	473	327	finally
    //   477	488	327	finally
    //   229	250	332	java/lang/IllegalStateException
    //   372	377	380	java/io/IOException
    //   229	250	402	java/lang/OutOfMemoryError
    //   438	443	446	java/io/IOException
    //   229	250	457	java/io/FileNotFoundException
    //   493	498	501	java/io/IOException
    //   544	549	552	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.14
 * JD-Core Version:    0.7.0.1
 */