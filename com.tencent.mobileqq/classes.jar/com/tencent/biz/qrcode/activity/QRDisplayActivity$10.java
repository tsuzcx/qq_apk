package com.tencent.biz.qrcode.activity;

class QRDisplayActivity$10
  implements Runnable
{
  QRDisplayActivity$10(QRDisplayActivity paramQRDisplayActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$10:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   16: getfield 31	com/tencent/biz/qrcode/activity/QRDisplayActivity:b	Landroid/graphics/Bitmap;
    //   19: astore 11
    //   21: aload 11
    //   23: ifnull +639 -> 662
    //   26: aload 11
    //   28: invokevirtual 37	android/graphics/Bitmap:isRecycled	()Z
    //   31: ifne +631 -> 662
    //   34: new 39	java/io/File
    //   37: dup
    //   38: getstatic 45	ajsf:bc	Ljava/lang/String;
    //   41: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 51	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 54	java/io/File:canWrite	()Z
    //   57: ifeq +605 -> 662
    //   60: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   63: invokestatic 66	java/lang/Long:toString	(J)Ljava/lang/String;
    //   66: astore 5
    //   68: new 68	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 45	ajsf:bc	Ljava/lang/String;
    //   78: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 75
    //   83: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 5
    //   88: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 77
    //   93: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 6
    //   101: new 39	java/io/File
    //   104: dup
    //   105: aload 6
    //   107: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: astore 7
    //   112: iconst_2
    //   113: istore_1
    //   114: aload 7
    //   116: invokevirtual 83	java/io/File:exists	()Z
    //   119: ifeq +69 -> 188
    //   122: iload_1
    //   123: ldc 84
    //   125: if_icmpge +63 -> 188
    //   128: new 68	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   135: getstatic 45	ajsf:bc	Ljava/lang/String;
    //   138: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 75
    //   143: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 86
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload_1
    //   157: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: ldc 91
    //   162: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 6
    //   170: new 39	java/io/File
    //   173: dup
    //   174: aload 6
    //   176: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: astore 7
    //   181: iload_1
    //   182: iconst_1
    //   183: iadd
    //   184: istore_1
    //   185: goto -71 -> 114
    //   188: new 93	java/io/BufferedOutputStream
    //   191: dup
    //   192: new 95	java/io/FileOutputStream
    //   195: dup
    //   196: aload 7
    //   198: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   201: sipush 8192
    //   204: invokespecial 101	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   207: astore 5
    //   209: aload 11
    //   211: getstatic 107	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   214: bipush 75
    //   216: aload 5
    //   218: invokevirtual 111	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   221: istore_3
    //   222: iload_3
    //   223: istore_2
    //   224: aload 5
    //   226: ifnull +10 -> 236
    //   229: aload 5
    //   231: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   234: iload_3
    //   235: istore_2
    //   236: iload_2
    //   237: ifne +17 -> 254
    //   240: aload 7
    //   242: invokevirtual 83	java/io/File:exists	()Z
    //   245: ifeq +9 -> 254
    //   248: aload 7
    //   250: invokevirtual 117	java/io/File:delete	()Z
    //   253: pop
    //   254: aload 6
    //   256: astore 4
    //   258: aload_0
    //   259: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$10:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   262: getfield 121	com/tencent/biz/qrcode/activity/QRDisplayActivity:jdField_c_of_type_Int	I
    //   265: iconst_2
    //   266: if_icmpne +60 -> 326
    //   269: aload_0
    //   270: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$10:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   273: getfield 123	com/tencent/biz/qrcode/activity/QRDisplayActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   276: astore 6
    //   278: aload_0
    //   279: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$10:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   282: getfield 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	I
    //   285: istore_1
    //   286: iload_2
    //   287: ifeq +343 -> 630
    //   290: ldc 128
    //   292: astore 5
    //   294: ldc 130
    //   296: ldc 132
    //   298: ldc 134
    //   300: iconst_0
    //   301: iconst_0
    //   302: iconst_3
    //   303: anewarray 136	java/lang/String
    //   306: dup
    //   307: iconst_0
    //   308: aload 6
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: iload_1
    //   314: invokestatic 140	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: aload 5
    //   322: aastore
    //   323: invokestatic 145	bbbb:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   326: aload_0
    //   327: getfield 12	com/tencent/biz/qrcode/activity/QRDisplayActivity$10:this$0	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   330: new 147	com/tencent/biz/qrcode/activity/QRDisplayActivity$10$1
    //   333: dup
    //   334: aload_0
    //   335: iload_2
    //   336: aload 4
    //   338: invokespecial 150	com/tencent/biz/qrcode/activity/QRDisplayActivity$10$1:<init>	(Lcom/tencent/biz/qrcode/activity/QRDisplayActivity$10;ZLjava/lang/String;)V
    //   341: invokevirtual 154	com/tencent/biz/qrcode/activity/QRDisplayActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   344: return
    //   345: astore 4
    //   347: iload_3
    //   348: istore_2
    //   349: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq -116 -> 236
    //   355: ldc 161
    //   357: iconst_2
    //   358: aload 4
    //   360: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: iload_3
    //   367: istore_2
    //   368: goto -132 -> 236
    //   371: astore 4
    //   373: aload 8
    //   375: astore 5
    //   377: aload 4
    //   379: astore 8
    //   381: aload 5
    //   383: astore 4
    //   385: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +18 -> 406
    //   391: aload 5
    //   393: astore 4
    //   395: ldc 161
    //   397: iconst_2
    //   398: aload 8
    //   400: invokevirtual 169	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   403: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: aload 5
    //   408: ifnull +249 -> 657
    //   411: aload 5
    //   413: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   416: iconst_0
    //   417: istore_2
    //   418: goto -182 -> 236
    //   421: astore 4
    //   423: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +14 -> 440
    //   429: ldc 161
    //   431: iconst_2
    //   432: aload 4
    //   434: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   437: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iconst_0
    //   441: istore_2
    //   442: goto -206 -> 236
    //   445: astore 8
    //   447: aload 9
    //   449: astore 5
    //   451: aload 5
    //   453: astore 4
    //   455: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +18 -> 476
    //   461: aload 5
    //   463: astore 4
    //   465: ldc 161
    //   467: iconst_2
    //   468: aload 8
    //   470: invokevirtual 170	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   473: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload 5
    //   478: ifnull +179 -> 657
    //   481: aload 5
    //   483: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   486: iconst_0
    //   487: istore_2
    //   488: goto -252 -> 236
    //   491: astore 4
    //   493: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +14 -> 510
    //   499: ldc 161
    //   501: iconst_2
    //   502: aload 4
    //   504: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   507: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: iconst_0
    //   511: istore_2
    //   512: goto -276 -> 236
    //   515: astore 8
    //   517: aload 10
    //   519: astore 5
    //   521: aload 5
    //   523: astore 4
    //   525: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +18 -> 546
    //   531: aload 5
    //   533: astore 4
    //   535: ldc 161
    //   537: iconst_2
    //   538: aload 8
    //   540: invokevirtual 171	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   543: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload 5
    //   548: ifnull +109 -> 657
    //   551: aload 5
    //   553: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   556: iconst_0
    //   557: istore_2
    //   558: goto -322 -> 236
    //   561: astore 4
    //   563: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +14 -> 580
    //   569: ldc 161
    //   571: iconst_2
    //   572: aload 4
    //   574: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   577: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: iconst_0
    //   581: istore_2
    //   582: goto -346 -> 236
    //   585: astore 6
    //   587: aload 4
    //   589: astore 5
    //   591: aload 6
    //   593: astore 4
    //   595: aload 5
    //   597: ifnull +8 -> 605
    //   600: aload 5
    //   602: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   605: aload 4
    //   607: athrow
    //   608: astore 5
    //   610: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq -8 -> 605
    //   616: ldc 161
    //   618: iconst_2
    //   619: aload 5
    //   621: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   624: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: goto -22 -> 605
    //   630: ldc 173
    //   632: astore 5
    //   634: goto -340 -> 294
    //   637: astore 4
    //   639: goto -44 -> 595
    //   642: astore 8
    //   644: goto -123 -> 521
    //   647: astore 8
    //   649: goto -198 -> 451
    //   652: astore 8
    //   654: goto -273 -> 381
    //   657: iconst_0
    //   658: istore_2
    //   659: goto -423 -> 236
    //   662: aconst_null
    //   663: astore 4
    //   665: iconst_0
    //   666: istore_2
    //   667: goto -409 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	10
    //   113	201	1	i	int
    //   223	444	2	bool1	boolean
    //   221	146	3	bool2	boolean
    //   7	330	4	localObject1	Object
    //   345	14	4	localIOException1	java.io.IOException
    //   371	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   383	11	4	localObject2	Object
    //   421	12	4	localIOException2	java.io.IOException
    //   453	11	4	localObject3	Object
    //   491	12	4	localIOException3	java.io.IOException
    //   523	11	4	localObject4	Object
    //   561	27	4	localIOException4	java.io.IOException
    //   593	13	4	localObject5	Object
    //   637	1	4	localObject6	Object
    //   663	1	4	localObject7	Object
    //   44	557	5	localObject8	Object
    //   608	12	5	localIOException5	java.io.IOException
    //   632	1	5	str1	java.lang.String
    //   99	210	6	str2	java.lang.String
    //   585	7	6	localObject9	Object
    //   110	139	7	localFile	java.io.File
    //   10	389	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   445	24	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   515	24	8	localIllegalStateException1	java.lang.IllegalStateException
    //   642	1	8	localIllegalStateException2	java.lang.IllegalStateException
    //   647	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   652	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	447	9	localObject10	Object
    //   4	514	10	localObject11	Object
    //   19	191	11	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   229	234	345	java/io/IOException
    //   188	209	371	java/io/FileNotFoundException
    //   411	416	421	java/io/IOException
    //   188	209	445	java/lang/OutOfMemoryError
    //   481	486	491	java/io/IOException
    //   188	209	515	java/lang/IllegalStateException
    //   551	556	561	java/io/IOException
    //   188	209	585	finally
    //   385	391	585	finally
    //   395	406	585	finally
    //   455	461	585	finally
    //   465	476	585	finally
    //   525	531	585	finally
    //   535	546	585	finally
    //   600	605	608	java/io/IOException
    //   209	222	637	finally
    //   209	222	642	java/lang/IllegalStateException
    //   209	222	647	java/lang/OutOfMemoryError
    //   209	222	652	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.10
 * JD-Core Version:    0.7.0.1
 */