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
    //   66: getfield 69	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:d	I
    //   69: aload_0
    //   70: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   73: getfield 72	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:e	I
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
    //   125: ifnonnull +27 -> 152
    //   128: aload 7
    //   130: ifnull +8 -> 138
    //   133: aload 7
    //   135: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   138: return
    //   139: astore 6
    //   141: ldc 102
    //   143: iconst_1
    //   144: ldc 104
    //   146: aload 6
    //   148: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: return
    //   152: aload 7
    //   154: astore 6
    //   156: aload 8
    //   158: invokevirtual 115	android/graphics/Bitmap:getHeight	()I
    //   161: istore_2
    //   162: aload 7
    //   164: astore 6
    //   166: aload 8
    //   168: invokevirtual 118	android/graphics/Bitmap:getWidth	()I
    //   171: istore_3
    //   172: aload 7
    //   174: astore 6
    //   176: aload_0
    //   177: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   180: getfield 69	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:d	I
    //   183: i2f
    //   184: aload_0
    //   185: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   188: getfield 72	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:e	I
    //   191: i2f
    //   192: fdiv
    //   193: fstore_1
    //   194: aload 7
    //   196: astore 6
    //   198: iload_3
    //   199: iload_2
    //   200: i2f
    //   201: fload_1
    //   202: fmul
    //   203: f2i
    //   204: invokestatic 124	java/lang/Math:min	(II)I
    //   207: istore 4
    //   209: aload 7
    //   211: astore 6
    //   213: iload 4
    //   215: i2f
    //   216: fload_1
    //   217: fdiv
    //   218: f2i
    //   219: istore 5
    //   221: aload 7
    //   223: astore 6
    //   225: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +411 -> 639
    //   231: aload 7
    //   233: astore 6
    //   235: ldc 102
    //   237: iconst_2
    //   238: new 130	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   245: ldc 133
    //   247: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 4
    //   252: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 142
    //   257: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload 5
    //   262: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: ldc 144
    //   267: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 9
    //   272: getfield 78	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   275: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto +355 -> 639
    //   287: aload 8
    //   289: ifnull +47 -> 336
    //   292: aload 7
    //   294: astore 6
    //   296: new 153	android/graphics/drawable/BitmapDrawable
    //   299: dup
    //   300: aload 10
    //   302: aload 8
    //   304: invokespecial 156	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   307: astore 8
    //   309: aload 7
    //   311: astore 6
    //   313: aload 8
    //   315: aload 10
    //   317: invokevirtual 162	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   320: invokevirtual 166	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   323: aload 7
    //   325: astore 6
    //   327: aload_0
    //   328: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   331: aload 8
    //   333: putfield 169	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   336: aload 7
    //   338: astore 6
    //   340: aload_0
    //   341: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   344: getfield 169	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   347: ifnull +21 -> 368
    //   350: aload 7
    //   352: astore 6
    //   354: aload_0
    //   355: getfield 14	com/tencent/mobileqq/activity/VipProfileCardDiyActivity$11:this$0	Lcom/tencent/mobileqq/activity/VipProfileCardDiyActivity;
    //   358: getfield 172	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:jdField_a_of_type_Bfob	Lbfob;
    //   361: iconst_3
    //   362: invokevirtual 178	bfob:obtainMessage	(I)Landroid/os/Message;
    //   365: invokevirtual 183	android/os/Message:sendToTarget	()V
    //   368: aload 7
    //   370: ifnull -232 -> 138
    //   373: aload 7
    //   375: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   378: return
    //   379: astore 6
    //   381: ldc 102
    //   383: iconst_1
    //   384: ldc 104
    //   386: aload 6
    //   388: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: return
    //   392: aload 7
    //   394: astore 6
    //   396: aload 8
    //   398: iconst_0
    //   399: iconst_0
    //   400: iload 4
    //   402: iload 5
    //   404: invokestatic 187	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   407: astore 9
    //   409: aload 7
    //   411: astore 6
    //   413: aload 8
    //   415: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   418: aload 7
    //   420: astore 6
    //   422: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +15 -> 440
    //   428: aload 7
    //   430: astore 6
    //   432: ldc 102
    //   434: iconst_2
    //   435: ldc 192
    //   437: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload 9
    //   442: astore 8
    //   444: goto -157 -> 287
    //   447: astore 8
    //   449: aconst_null
    //   450: astore 7
    //   452: aload 7
    //   454: astore 6
    //   456: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +36 -> 495
    //   462: aload 7
    //   464: astore 6
    //   466: ldc 102
    //   468: iconst_2
    //   469: new 130	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   476: ldc 194
    //   478: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload 8
    //   483: invokevirtual 197	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload 7
    //   497: ifnull -359 -> 138
    //   500: aload 7
    //   502: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   505: return
    //   506: astore 6
    //   508: ldc 102
    //   510: iconst_1
    //   511: ldc 104
    //   513: aload 6
    //   515: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   518: return
    //   519: astore 8
    //   521: aconst_null
    //   522: astore 7
    //   524: aload 7
    //   526: astore 6
    //   528: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +36 -> 567
    //   534: aload 7
    //   536: astore 6
    //   538: ldc 102
    //   540: iconst_2
    //   541: new 130	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   548: ldc 199
    //   550: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 8
    //   555: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload 7
    //   569: ifnull -431 -> 138
    //   572: aload 7
    //   574: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   577: return
    //   578: astore 6
    //   580: ldc 102
    //   582: iconst_1
    //   583: ldc 104
    //   585: aload 6
    //   587: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   590: return
    //   591: astore 7
    //   593: aconst_null
    //   594: astore 6
    //   596: aload 6
    //   598: ifnull +8 -> 606
    //   601: aload 6
    //   603: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   606: aload 7
    //   608: athrow
    //   609: astore 6
    //   611: ldc 102
    //   613: iconst_1
    //   614: ldc 104
    //   616: aload 6
    //   618: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: goto -15 -> 606
    //   624: astore 7
    //   626: goto -30 -> 596
    //   629: astore 8
    //   631: goto -107 -> 524
    //   634: astore 8
    //   636: goto -184 -> 452
    //   639: iload_3
    //   640: iload 4
    //   642: if_icmpne -250 -> 392
    //   645: iload_2
    //   646: iload 5
    //   648: if_icmpne -256 -> 392
    //   651: goto -364 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	11
    //   193	24	1	f	float
    //   161	488	2	i	int
    //   171	472	3	j	int
    //   207	436	4	k	int
    //   219	430	5	m	int
    //   111	1	6	localBufferedInputStream1	java.io.BufferedInputStream
    //   139	8	6	localException1	java.lang.Exception
    //   154	199	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   379	8	6	localException2	java.lang.Exception
    //   394	71	6	localBufferedInputStream3	java.io.BufferedInputStream
    //   506	8	6	localException3	java.lang.Exception
    //   526	11	6	localBufferedInputStream4	java.io.BufferedInputStream
    //   578	8	6	localException4	java.lang.Exception
    //   594	8	6	localObject1	Object
    //   609	8	6	localException5	java.lang.Exception
    //   107	466	7	localBufferedInputStream5	java.io.BufferedInputStream
    //   591	16	7	localObject2	Object
    //   624	1	7	localObject3	Object
    //   121	322	8	localObject4	Object
    //   447	35	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   519	35	8	localException6	java.lang.Exception
    //   629	1	8	localException7	java.lang.Exception
    //   634	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   7	434	9	localObject5	Object
    //   28	288	10	localResources	android.content.res.Resources
    // Exception table:
    //   from	to	target	type
    //   133	138	139	java/lang/Exception
    //   373	378	379	java/lang/Exception
    //   0	109	447	java/lang/OutOfMemoryError
    //   500	505	506	java/lang/Exception
    //   0	109	519	java/lang/Exception
    //   572	577	578	java/lang/Exception
    //   0	109	591	finally
    //   601	606	609	java/lang/Exception
    //   113	123	624	finally
    //   156	162	624	finally
    //   166	172	624	finally
    //   176	194	624	finally
    //   198	209	624	finally
    //   213	221	624	finally
    //   225	231	624	finally
    //   235	284	624	finally
    //   296	309	624	finally
    //   313	323	624	finally
    //   327	336	624	finally
    //   340	350	624	finally
    //   354	368	624	finally
    //   396	409	624	finally
    //   413	418	624	finally
    //   422	428	624	finally
    //   432	440	624	finally
    //   456	462	624	finally
    //   466	495	624	finally
    //   528	534	624	finally
    //   538	567	624	finally
    //   113	123	629	java/lang/Exception
    //   156	162	629	java/lang/Exception
    //   166	172	629	java/lang/Exception
    //   176	194	629	java/lang/Exception
    //   198	209	629	java/lang/Exception
    //   213	221	629	java/lang/Exception
    //   225	231	629	java/lang/Exception
    //   235	284	629	java/lang/Exception
    //   296	309	629	java/lang/Exception
    //   313	323	629	java/lang/Exception
    //   327	336	629	java/lang/Exception
    //   340	350	629	java/lang/Exception
    //   354	368	629	java/lang/Exception
    //   396	409	629	java/lang/Exception
    //   413	418	629	java/lang/Exception
    //   422	428	629	java/lang/Exception
    //   432	440	629	java/lang/Exception
    //   113	123	634	java/lang/OutOfMemoryError
    //   156	162	634	java/lang/OutOfMemoryError
    //   166	172	634	java/lang/OutOfMemoryError
    //   176	194	634	java/lang/OutOfMemoryError
    //   198	209	634	java/lang/OutOfMemoryError
    //   213	221	634	java/lang/OutOfMemoryError
    //   225	231	634	java/lang/OutOfMemoryError
    //   235	284	634	java/lang/OutOfMemoryError
    //   296	309	634	java/lang/OutOfMemoryError
    //   313	323	634	java/lang/OutOfMemoryError
    //   327	336	634	java/lang/OutOfMemoryError
    //   340	350	634	java/lang/OutOfMemoryError
    //   354	368	634	java/lang/OutOfMemoryError
    //   396	409	634	java/lang/OutOfMemoryError
    //   413	418	634	java/lang/OutOfMemoryError
    //   422	428	634	java/lang/OutOfMemoryError
    //   432	440	634	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.11
 * JD-Core Version:    0.7.0.1
 */