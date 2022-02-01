package com.tencent.mobileqq.activity;

class VipProfileCardDiyActivity$11
  implements Runnable
{
  VipProfileCardDiyActivity$11(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 27	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 28	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: iconst_1
    //   12: putfield 32	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   19: getfield 38	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: invokevirtual 50	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 16	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:a	Ljava/lang/String;
    //   34: aload 9
    //   36: invokestatic 56	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: pop
    //   40: aload 9
    //   42: iconst_0
    //   43: putfield 32	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload 9
    //   48: getstatic 62	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   51: putfield 65	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   54: aload 9
    //   56: aload_0
    //   57: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   60: aload 9
    //   62: aload_0
    //   63: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   66: getfield 69	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:O	I
    //   69: aload_0
    //   70: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   73: getfield 72	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:P	I
    //   76: invokevirtual 75	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   79: putfield 78	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: new 80	java/io/BufferedInputStream
    //   85: dup
    //   86: new 82	java/io/FileInputStream
    //   89: dup
    //   90: new 84	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: getfield 16	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:a	Ljava/lang/String;
    //   98: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 7
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: aconst_null
    //   116: aload 9
    //   118: invokestatic 97	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   121: astore 8
    //   123: aload 8
    //   125: ifnonnull +22 -> 147
    //   128: aload 7
    //   130: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   133: return
    //   134: astore 6
    //   136: ldc 102
    //   138: iconst_1
    //   139: ldc 104
    //   141: aload 6
    //   143: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: return
    //   147: aload 7
    //   149: astore 6
    //   151: aload 8
    //   153: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   156: istore_2
    //   157: aload 7
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 119	android/graphics/Bitmap:getWidth	()I
    //   166: istore_3
    //   167: aload 7
    //   169: astore 6
    //   171: aload_0
    //   172: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   175: getfield 69	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:O	I
    //   178: i2f
    //   179: aload_0
    //   180: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   183: getfield 72	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:P	I
    //   186: i2f
    //   187: fdiv
    //   188: fstore_1
    //   189: aload 7
    //   191: astore 6
    //   193: iload_3
    //   194: iload_2
    //   195: i2f
    //   196: fload_1
    //   197: fmul
    //   198: f2i
    //   199: invokestatic 125	java/lang/Math:min	(II)I
    //   202: istore 4
    //   204: aload 7
    //   206: astore 6
    //   208: iload 4
    //   210: i2f
    //   211: fload_1
    //   212: fdiv
    //   213: f2i
    //   214: istore 5
    //   216: aload 7
    //   218: astore 6
    //   220: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +478 -> 701
    //   226: aload 7
    //   228: astore 6
    //   230: new 131	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   237: astore 11
    //   239: aload 7
    //   241: astore 6
    //   243: aload 11
    //   245: ldc 134
    //   247: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 7
    //   253: astore 6
    //   255: aload 11
    //   257: iload 4
    //   259: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 7
    //   265: astore 6
    //   267: aload 11
    //   269: ldc 143
    //   271: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 7
    //   277: astore 6
    //   279: aload 11
    //   281: iload 5
    //   283: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 7
    //   289: astore 6
    //   291: aload 11
    //   293: ldc 145
    //   295: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: astore 6
    //   303: aload 11
    //   305: aload 9
    //   307: getfield 78	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   310: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 7
    //   316: astore 6
    //   318: ldc 102
    //   320: iconst_2
    //   321: aload 11
    //   323: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto +372 -> 701
    //   332: aload 7
    //   334: astore 6
    //   336: aload 8
    //   338: iconst_0
    //   339: iconst_0
    //   340: iload 4
    //   342: iload 5
    //   344: invokestatic 157	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   347: astore 9
    //   349: aload 7
    //   351: astore 6
    //   353: aload 8
    //   355: invokevirtual 160	android/graphics/Bitmap:recycle	()V
    //   358: aload 7
    //   360: astore 6
    //   362: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +351 -> 716
    //   368: aload 7
    //   370: astore 6
    //   372: ldc 102
    //   374: iconst_2
    //   375: ldc 162
    //   377: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto +336 -> 716
    //   383: aload 8
    //   385: ifnull +47 -> 432
    //   388: aload 7
    //   390: astore 6
    //   392: new 164	android/graphics/drawable/BitmapDrawable
    //   395: dup
    //   396: aload 10
    //   398: aload 8
    //   400: invokespecial 167	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   403: astore 8
    //   405: aload 7
    //   407: astore 6
    //   409: aload 8
    //   411: aload 10
    //   413: invokevirtual 173	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   416: invokevirtual 177	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   419: aload 7
    //   421: astore 6
    //   423: aload_0
    //   424: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   427: aload 8
    //   429: putfield 181	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:ag	Landroid/graphics/drawable/Drawable;
    //   432: aload 7
    //   434: astore 6
    //   436: aload_0
    //   437: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   440: getfield 181	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:ag	Landroid/graphics/drawable/Drawable;
    //   443: ifnull +21 -> 464
    //   446: aload 7
    //   448: astore 6
    //   450: aload_0
    //   451: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   454: getfield 185	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:ak	Lcom/tencent/util/WeakReferenceHandler;
    //   457: iconst_3
    //   458: invokevirtual 191	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   461: invokevirtual 196	android/os/Message:sendToTarget	()V
    //   464: aload 7
    //   466: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   469: return
    //   470: astore 8
    //   472: goto +21 -> 493
    //   475: astore 8
    //   477: goto +97 -> 574
    //   480: astore 6
    //   482: aconst_null
    //   483: astore 7
    //   485: goto +188 -> 673
    //   488: astore 8
    //   490: aconst_null
    //   491: astore 7
    //   493: aload 7
    //   495: astore 6
    //   497: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +58 -> 558
    //   503: aload 7
    //   505: astore 6
    //   507: new 131	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   514: astore 9
    //   516: aload 7
    //   518: astore 6
    //   520: aload 9
    //   522: ldc 198
    //   524: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 7
    //   530: astore 6
    //   532: aload 9
    //   534: aload 8
    //   536: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   539: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 7
    //   545: astore 6
    //   547: ldc 102
    //   549: iconst_2
    //   550: aload 9
    //   552: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload 7
    //   560: ifnull +102 -> 662
    //   563: aload 7
    //   565: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   568: return
    //   569: astore 8
    //   571: aconst_null
    //   572: astore 7
    //   574: aload 7
    //   576: astore 6
    //   578: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +58 -> 639
    //   584: aload 7
    //   586: astore 6
    //   588: new 131	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   595: astore 9
    //   597: aload 7
    //   599: astore 6
    //   601: aload 9
    //   603: ldc 203
    //   605: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 7
    //   611: astore 6
    //   613: aload 9
    //   615: aload 8
    //   617: invokevirtual 204	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   620: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 7
    //   626: astore 6
    //   628: ldc 102
    //   630: iconst_2
    //   631: aload 9
    //   633: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: aload 7
    //   641: ifnull +21 -> 662
    //   644: aload 7
    //   646: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   649: return
    //   650: astore 6
    //   652: ldc 102
    //   654: iconst_1
    //   655: ldc 104
    //   657: aload 6
    //   659: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   662: return
    //   663: astore 8
    //   665: aload 6
    //   667: astore 7
    //   669: aload 8
    //   671: astore 6
    //   673: aload 7
    //   675: ifnull +23 -> 698
    //   678: aload 7
    //   680: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   683: goto +15 -> 698
    //   686: astore 7
    //   688: ldc 102
    //   690: iconst_1
    //   691: ldc 104
    //   693: aload 7
    //   695: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   698: aload 6
    //   700: athrow
    //   701: iload_3
    //   702: iload 4
    //   704: if_icmpne -372 -> 332
    //   707: iload_2
    //   708: iload 5
    //   710: if_icmpne -378 -> 332
    //   713: goto -330 -> 383
    //   716: aload 9
    //   718: astore 8
    //   720: goto -337 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	11
    //   188	24	1	f	float
    //   156	555	2	i	int
    //   166	539	3	j	int
    //   202	503	4	k	int
    //   214	497	5	m	int
    //   111	1	6	localObject1	Object
    //   134	8	6	localException1	java.lang.Exception
    //   149	300	6	localObject2	Object
    //   480	1	6	localObject3	Object
    //   495	132	6	localObject4	Object
    //   650	16	6	localException2	java.lang.Exception
    //   671	28	6	localObject5	Object
    //   107	572	7	localObject6	Object
    //   686	8	7	localException3	java.lang.Exception
    //   121	307	8	localObject7	Object
    //   470	1	8	localException4	java.lang.Exception
    //   475	1	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   488	47	8	localException5	java.lang.Exception
    //   569	47	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   663	7	8	localObject8	Object
    //   718	1	8	localObject9	Object
    //   7	710	9	localObject10	Object
    //   28	384	10	localResources	android.content.res.Resources
    //   237	85	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   128	133	134	java/lang/Exception
    //   113	123	470	java/lang/Exception
    //   151	157	470	java/lang/Exception
    //   161	167	470	java/lang/Exception
    //   171	189	470	java/lang/Exception
    //   193	204	470	java/lang/Exception
    //   208	216	470	java/lang/Exception
    //   220	226	470	java/lang/Exception
    //   230	239	470	java/lang/Exception
    //   243	251	470	java/lang/Exception
    //   255	263	470	java/lang/Exception
    //   267	275	470	java/lang/Exception
    //   279	287	470	java/lang/Exception
    //   291	299	470	java/lang/Exception
    //   303	314	470	java/lang/Exception
    //   318	329	470	java/lang/Exception
    //   336	349	470	java/lang/Exception
    //   353	358	470	java/lang/Exception
    //   362	368	470	java/lang/Exception
    //   372	380	470	java/lang/Exception
    //   392	405	470	java/lang/Exception
    //   409	419	470	java/lang/Exception
    //   423	432	470	java/lang/Exception
    //   436	446	470	java/lang/Exception
    //   450	464	470	java/lang/Exception
    //   113	123	475	java/lang/OutOfMemoryError
    //   151	157	475	java/lang/OutOfMemoryError
    //   161	167	475	java/lang/OutOfMemoryError
    //   171	189	475	java/lang/OutOfMemoryError
    //   193	204	475	java/lang/OutOfMemoryError
    //   208	216	475	java/lang/OutOfMemoryError
    //   220	226	475	java/lang/OutOfMemoryError
    //   230	239	475	java/lang/OutOfMemoryError
    //   243	251	475	java/lang/OutOfMemoryError
    //   255	263	475	java/lang/OutOfMemoryError
    //   267	275	475	java/lang/OutOfMemoryError
    //   279	287	475	java/lang/OutOfMemoryError
    //   291	299	475	java/lang/OutOfMemoryError
    //   303	314	475	java/lang/OutOfMemoryError
    //   318	329	475	java/lang/OutOfMemoryError
    //   336	349	475	java/lang/OutOfMemoryError
    //   353	358	475	java/lang/OutOfMemoryError
    //   362	368	475	java/lang/OutOfMemoryError
    //   372	380	475	java/lang/OutOfMemoryError
    //   392	405	475	java/lang/OutOfMemoryError
    //   409	419	475	java/lang/OutOfMemoryError
    //   423	432	475	java/lang/OutOfMemoryError
    //   436	446	475	java/lang/OutOfMemoryError
    //   450	464	475	java/lang/OutOfMemoryError
    //   0	109	480	finally
    //   0	109	488	java/lang/Exception
    //   0	109	569	java/lang/OutOfMemoryError
    //   464	469	650	java/lang/Exception
    //   563	568	650	java/lang/Exception
    //   644	649	650	java/lang/Exception
    //   113	123	663	finally
    //   151	157	663	finally
    //   161	167	663	finally
    //   171	189	663	finally
    //   193	204	663	finally
    //   208	216	663	finally
    //   220	226	663	finally
    //   230	239	663	finally
    //   243	251	663	finally
    //   255	263	663	finally
    //   267	275	663	finally
    //   279	287	663	finally
    //   291	299	663	finally
    //   303	314	663	finally
    //   318	329	663	finally
    //   336	349	663	finally
    //   353	358	663	finally
    //   362	368	663	finally
    //   372	380	663	finally
    //   392	405	663	finally
    //   409	419	663	finally
    //   423	432	663	finally
    //   436	446	663	finally
    //   450	464	663	finally
    //   497	503	663	finally
    //   507	516	663	finally
    //   520	528	663	finally
    //   532	543	663	finally
    //   547	558	663	finally
    //   578	584	663	finally
    //   588	597	663	finally
    //   601	609	663	finally
    //   613	624	663	finally
    //   628	639	663	finally
    //   678	683	686	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.11
 * JD-Core Version:    0.7.0.1
 */