package com.tencent.mobileqq.activity.registerGuideLogin;

public class GuideVideoHandler$2
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 24	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: new 26	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   12: ldc 31
    //   14: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 37	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   21: invokevirtual 43	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 47	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 49
    //   32: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 50
    //   37: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 62	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: astore 8
    //   48: aconst_null
    //   49: astore 9
    //   51: aconst_null
    //   52: astore 7
    //   54: new 64	android/media/MediaMetadataRetriever
    //   57: dup
    //   58: invokespecial 65	android/media/MediaMetadataRetriever:<init>	()V
    //   61: astore 10
    //   63: aload 10
    //   65: aload_0
    //   66: getfield 37	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   69: aload 8
    //   71: invokevirtual 69	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   74: aload 10
    //   76: aload_0
    //   77: getfield 71	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_Int	I
    //   80: sipush 1000
    //   83: imul
    //   84: i2l
    //   85: invokevirtual 75	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   88: astore 7
    //   90: aload 7
    //   92: ifnonnull +79 -> 171
    //   95: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +11 -> 109
    //   101: ldc 83
    //   103: iconst_2
    //   104: ldc 85
    //   106: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   113: bipush 101
    //   115: invokevirtual 97	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   118: pop
    //   119: aload_0
    //   120: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   123: invokevirtual 101	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   126: astore 8
    //   128: aload 8
    //   130: aconst_null
    //   131: putfield 107	android/os/Message:obj	Ljava/lang/Object;
    //   134: aload 8
    //   136: bipush 101
    //   138: putfield 110	android/os/Message:what	I
    //   141: aload_0
    //   142: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   145: aload 8
    //   147: invokevirtual 114	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   150: pop
    //   151: aload 7
    //   153: ifnull +3 -> 156
    //   156: aload 10
    //   158: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   161: aload_0
    //   162: getfield 119	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lalrj;
    //   165: iconst_0
    //   166: invokestatic 124	alrj:a	(Lalrj;Z)Z
    //   169: pop
    //   170: return
    //   171: aload_0
    //   172: getfield 37	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   175: invokevirtual 128	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   178: invokevirtual 134	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   181: getfield 139	android/util/DisplayMetrics:widthPixels	I
    //   184: istore_3
    //   185: aload_0
    //   186: getfield 37	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   189: invokevirtual 128	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   192: invokevirtual 134	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   195: getfield 142	android/util/DisplayMetrics:heightPixels	I
    //   198: istore 4
    //   200: iload_3
    //   201: i2f
    //   202: aload 7
    //   204: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   207: i2f
    //   208: fdiv
    //   209: fstore_1
    //   210: iload 4
    //   212: i2f
    //   213: aload 7
    //   215: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   218: i2f
    //   219: fdiv
    //   220: fstore_2
    //   221: new 153	android/graphics/Matrix
    //   224: dup
    //   225: invokespecial 154	android/graphics/Matrix:<init>	()V
    //   228: astore 8
    //   230: aload 8
    //   232: fload_1
    //   233: fload_2
    //   234: invokevirtual 158	android/graphics/Matrix:postScale	(FF)Z
    //   237: pop
    //   238: aload 7
    //   240: iconst_0
    //   241: iconst_0
    //   242: aload 7
    //   244: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   247: aload 7
    //   249: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   252: aload 8
    //   254: iconst_1
    //   255: invokestatic 162	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   258: astore 8
    //   260: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +50 -> 313
    //   266: ldc 83
    //   268: iconst_2
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc 164
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: new 26	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   287: invokestatic 24	java/lang/System:currentTimeMillis	()J
    //   290: lload 5
    //   292: lsub
    //   293: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc 169
    //   298: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 8
    //   303: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: aastore
    //   310: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   313: aload_0
    //   314: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   317: invokevirtual 101	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   320: astore 9
    //   322: aload 9
    //   324: aload 8
    //   326: putfield 107	android/os/Message:obj	Ljava/lang/Object;
    //   329: aload 9
    //   331: bipush 101
    //   333: putfield 110	android/os/Message:what	I
    //   336: aload_0
    //   337: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   340: aload 9
    //   342: invokevirtual 114	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   345: pop
    //   346: aload 8
    //   348: aload 7
    //   350: if_acmpeq +3 -> 353
    //   353: aload 10
    //   355: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   358: aload_0
    //   359: getfield 119	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lalrj;
    //   362: iconst_0
    //   363: invokestatic 124	alrj:a	(Lalrj;Z)Z
    //   366: pop
    //   367: return
    //   368: astore 8
    //   370: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +11 -> 384
    //   376: ldc 83
    //   378: iconst_2
    //   379: ldc 177
    //   381: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_0
    //   385: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   388: invokevirtual 101	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   391: astore 8
    //   393: aload 8
    //   395: aconst_null
    //   396: putfield 107	android/os/Message:obj	Ljava/lang/Object;
    //   399: aload 8
    //   401: bipush 101
    //   403: putfield 110	android/os/Message:what	I
    //   406: aload_0
    //   407: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   410: aload 8
    //   412: invokevirtual 114	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   415: pop
    //   416: iconst_0
    //   417: ifeq +3 -> 420
    //   420: aload 7
    //   422: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   425: aload_0
    //   426: getfield 119	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lalrj;
    //   429: iconst_0
    //   430: invokestatic 124	alrj:a	(Lalrj;Z)Z
    //   433: pop
    //   434: return
    //   435: astore 7
    //   437: aconst_null
    //   438: astore 10
    //   440: aconst_null
    //   441: astore 9
    //   443: aconst_null
    //   444: astore 8
    //   446: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +20 -> 469
    //   452: ldc 83
    //   454: iconst_2
    //   455: aload 7
    //   457: iconst_1
    //   458: anewarray 4	java/lang/Object
    //   461: dup
    //   462: iconst_0
    //   463: ldc 179
    //   465: aastore
    //   466: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   469: aload_0
    //   470: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   473: invokevirtual 101	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   476: astore 7
    //   478: aload 7
    //   480: aconst_null
    //   481: putfield 107	android/os/Message:obj	Ljava/lang/Object;
    //   484: aload 7
    //   486: bipush 101
    //   488: putfield 110	android/os/Message:what	I
    //   491: aload_0
    //   492: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   495: aload 7
    //   497: invokevirtual 114	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   500: pop
    //   501: iconst_0
    //   502: ifeq +3 -> 505
    //   505: aload 10
    //   507: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   510: aload_0
    //   511: getfield 119	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lalrj;
    //   514: iconst_0
    //   515: invokestatic 124	alrj:a	(Lalrj;Z)Z
    //   518: pop
    //   519: return
    //   520: astore 7
    //   522: aconst_null
    //   523: astore 10
    //   525: aconst_null
    //   526: astore 8
    //   528: aload_0
    //   529: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   532: invokevirtual 101	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   535: astore 11
    //   537: aload 11
    //   539: aload 8
    //   541: putfield 107	android/os/Message:obj	Ljava/lang/Object;
    //   544: aload 11
    //   546: bipush 101
    //   548: putfield 110	android/os/Message:what	I
    //   551: aload_0
    //   552: getfield 91	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   555: aload 11
    //   557: invokevirtual 114	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   560: pop
    //   561: aload 8
    //   563: aload 9
    //   565: if_acmpeq +3 -> 568
    //   568: aload 10
    //   570: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   573: aload_0
    //   574: getfield 119	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lalrj;
    //   577: iconst_0
    //   578: invokestatic 124	alrj:a	(Lalrj;Z)Z
    //   581: pop
    //   582: aload 7
    //   584: athrow
    //   585: astore 7
    //   587: aconst_null
    //   588: astore 8
    //   590: goto -62 -> 528
    //   593: astore 8
    //   595: aload 7
    //   597: astore 9
    //   599: aload 8
    //   601: astore 7
    //   603: aconst_null
    //   604: astore 8
    //   606: goto -78 -> 528
    //   609: astore 11
    //   611: aload 7
    //   613: astore 9
    //   615: aload 11
    //   617: astore 7
    //   619: goto -91 -> 528
    //   622: astore 8
    //   624: aload 7
    //   626: astore 10
    //   628: aload 8
    //   630: astore 7
    //   632: aconst_null
    //   633: astore 8
    //   635: aconst_null
    //   636: astore 9
    //   638: goto -110 -> 528
    //   641: astore 7
    //   643: goto -115 -> 528
    //   646: astore 7
    //   648: goto -208 -> 440
    //   651: astore 7
    //   653: aload 10
    //   655: astore 7
    //   657: goto -287 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	2
    //   209	24	1	f1	float
    //   220	14	2	f2	float
    //   184	17	3	i	int
    //   198	13	4	j	int
    //   3	288	5	l	long
    //   52	369	7	localBitmap	android.graphics.Bitmap
    //   435	21	7	localException1	java.lang.Exception
    //   476	20	7	localMessage1	android.os.Message
    //   520	63	7	localObject1	Object
    //   585	11	7	localObject2	Object
    //   601	30	7	localObject3	Object
    //   641	1	7	localObject4	Object
    //   646	1	7	localException2	java.lang.Exception
    //   651	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   655	1	7	localObject5	Object
    //   46	301	8	localObject6	Object
    //   368	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   391	198	8	localMessage2	android.os.Message
    //   593	7	8	localObject7	Object
    //   604	1	8	localObject8	Object
    //   622	7	8	localObject9	Object
    //   633	1	8	localObject10	Object
    //   49	588	9	localObject11	Object
    //   61	593	10	localObject12	Object
    //   535	21	11	localMessage3	android.os.Message
    //   609	7	11	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   54	63	368	java/lang/OutOfMemoryError
    //   54	63	435	java/lang/Exception
    //   54	63	520	finally
    //   63	90	585	finally
    //   95	109	593	finally
    //   109	119	593	finally
    //   171	260	593	finally
    //   260	313	609	finally
    //   370	384	622	finally
    //   446	469	641	finally
    //   63	90	646	java/lang/Exception
    //   95	109	646	java/lang/Exception
    //   109	119	646	java/lang/Exception
    //   171	260	646	java/lang/Exception
    //   260	313	646	java/lang/Exception
    //   63	90	651	java/lang/OutOfMemoryError
    //   95	109	651	java/lang/OutOfMemoryError
    //   109	119	651	java/lang/OutOfMemoryError
    //   171	260	651	java/lang/OutOfMemoryError
    //   260	313	651	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler.2
 * JD-Core Version:    0.7.0.1
 */