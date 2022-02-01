package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import mqq.os.MqqHandler;

class GuideVideoHandler$2
  implements Runnable
{
  GuideVideoHandler$2(GuideVideoHandler paramGuideVideoHandler, Context paramContext, int paramInt, MqqHandler paramMqqHandler) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: new 41	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: ldc 44
    //   18: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 7
    //   24: aload_0
    //   25: getfield 20	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:a	Landroid/content/Context;
    //   28: invokevirtual 54	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: invokevirtual 58	android/content/Context:getPackageName	()Ljava/lang/String;
    //   34: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: ldc 60
    //   42: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: ldc 61
    //   50: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 73	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   62: astore 9
    //   64: aconst_null
    //   65: astore 11
    //   67: new 75	android/media/MediaMetadataRetriever
    //   70: dup
    //   71: invokespecial 76	android/media/MediaMetadataRetriever:<init>	()V
    //   74: astore 7
    //   76: aload 7
    //   78: astore 8
    //   80: aload 7
    //   82: aload_0
    //   83: getfield 20	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:a	Landroid/content/Context;
    //   86: aload 9
    //   88: invokevirtual 80	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   91: aload 7
    //   93: astore 8
    //   95: aload 7
    //   97: aload_0
    //   98: getfield 22	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:b	I
    //   101: sipush 1000
    //   104: imul
    //   105: i2l
    //   106: invokevirtual 84	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   109: astore 9
    //   111: aload 9
    //   113: ifnonnull +74 -> 187
    //   116: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +11 -> 130
    //   122: ldc 92
    //   124: iconst_2
    //   125: ldc 94
    //   127: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   134: bipush 101
    //   136: invokevirtual 104	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   139: pop
    //   140: aload_0
    //   141: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   144: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   147: astore 8
    //   149: aload 8
    //   151: aconst_null
    //   152: putfield 114	android/os/Message:obj	Ljava/lang/Object;
    //   155: aload 8
    //   157: bipush 101
    //   159: putfield 117	android/os/Message:what	I
    //   162: aload_0
    //   163: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   166: aload 8
    //   168: invokevirtual 121	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   171: pop
    //   172: aload 7
    //   174: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   177: aload_0
    //   178: getfield 18	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   181: iconst_0
    //   182: invokestatic 129	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:b	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   185: pop
    //   186: return
    //   187: aload_0
    //   188: getfield 20	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:a	Landroid/content/Context;
    //   191: invokevirtual 133	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   194: invokevirtual 139	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   197: getfield 144	android/util/DisplayMetrics:widthPixels	I
    //   200: istore_3
    //   201: aload_0
    //   202: getfield 20	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:a	Landroid/content/Context;
    //   205: invokevirtual 133	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   208: invokevirtual 139	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   211: getfield 147	android/util/DisplayMetrics:heightPixels	I
    //   214: istore 4
    //   216: iload_3
    //   217: i2f
    //   218: aload 9
    //   220: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   223: i2f
    //   224: fdiv
    //   225: fstore_1
    //   226: iload 4
    //   228: i2f
    //   229: aload 9
    //   231: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   234: i2f
    //   235: fdiv
    //   236: fstore_2
    //   237: new 158	android/graphics/Matrix
    //   240: dup
    //   241: invokespecial 159	android/graphics/Matrix:<init>	()V
    //   244: astore 8
    //   246: aload 8
    //   248: fload_1
    //   249: fload_2
    //   250: invokevirtual 163	android/graphics/Matrix:postScale	(FF)Z
    //   253: pop
    //   254: aload 9
    //   256: iconst_0
    //   257: iconst_0
    //   258: aload 9
    //   260: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   263: aload 9
    //   265: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   268: aload 8
    //   270: iconst_1
    //   271: invokestatic 167	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   274: astore 9
    //   276: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +63 -> 342
    //   282: new 41	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   289: astore 8
    //   291: aload 8
    //   293: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   296: lload 5
    //   298: lsub
    //   299: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 8
    //   305: ldc 172
    //   307: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 8
    //   313: aload 9
    //   315: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: ldc 92
    //   321: iconst_2
    //   322: iconst_2
    //   323: anewarray 4	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: ldc 177
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload 8
    //   335: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: aastore
    //   339: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   342: aload_0
    //   343: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   346: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   349: astore 8
    //   351: aload 8
    //   353: aload 9
    //   355: putfield 114	android/os/Message:obj	Ljava/lang/Object;
    //   358: goto +130 -> 488
    //   361: astore 8
    //   363: goto +171 -> 534
    //   366: astore 8
    //   368: aload 11
    //   370: astore 9
    //   372: goto +162 -> 534
    //   375: astore 10
    //   377: goto +20 -> 397
    //   380: astore 8
    //   382: aconst_null
    //   383: astore 7
    //   385: aload 11
    //   387: astore 9
    //   389: goto +145 -> 534
    //   392: astore 10
    //   394: aconst_null
    //   395: astore 7
    //   397: aload 7
    //   399: astore 9
    //   401: aload 7
    //   403: astore 8
    //   405: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +61 -> 469
    //   411: aload 7
    //   413: astore 8
    //   415: ldc 92
    //   417: iconst_2
    //   418: aload 10
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: ldc 182
    //   428: aastore
    //   429: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   432: aload 7
    //   434: astore 9
    //   436: goto +33 -> 469
    //   439: aload 7
    //   441: astore 9
    //   443: aload 7
    //   445: astore 8
    //   447: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +19 -> 469
    //   453: aload 7
    //   455: astore 8
    //   457: ldc 92
    //   459: iconst_2
    //   460: ldc 187
    //   462: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: aload 7
    //   467: astore 9
    //   469: aload_0
    //   470: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   473: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   476: astore 8
    //   478: aload 8
    //   480: aconst_null
    //   481: putfield 114	android/os/Message:obj	Ljava/lang/Object;
    //   484: aload 9
    //   486: astore 7
    //   488: aload 8
    //   490: bipush 101
    //   492: putfield 117	android/os/Message:what	I
    //   495: aload_0
    //   496: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   499: aload 8
    //   501: invokevirtual 121	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   504: pop
    //   505: aload 7
    //   507: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   510: aload_0
    //   511: getfield 18	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   514: iconst_0
    //   515: invokestatic 129	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:b	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   518: pop
    //   519: return
    //   520: astore 10
    //   522: aload 8
    //   524: astore 7
    //   526: aload 11
    //   528: astore 9
    //   530: aload 10
    //   532: astore 8
    //   534: aload_0
    //   535: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   538: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   541: astore 10
    //   543: aload 10
    //   545: aload 9
    //   547: putfield 114	android/os/Message:obj	Ljava/lang/Object;
    //   550: aload 10
    //   552: bipush 101
    //   554: putfield 117	android/os/Message:what	I
    //   557: aload_0
    //   558: getfield 24	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:c	Lmqq/os/MqqHandler;
    //   561: aload 10
    //   563: invokevirtual 121	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   566: pop
    //   567: aload 7
    //   569: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   572: aload_0
    //   573: getfield 18	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   576: iconst_0
    //   577: invokestatic 129	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:b	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   580: pop
    //   581: aload 8
    //   583: athrow
    //   584: astore 7
    //   586: goto +8 -> 594
    //   589: astore 8
    //   591: goto -152 -> 439
    //   594: aconst_null
    //   595: astore 7
    //   597: goto -158 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	2
    //   225	24	1	f1	float
    //   236	14	2	f2	float
    //   200	17	3	i	int
    //   214	13	4	j	int
    //   3	294	5	l	long
    //   12	556	7	localObject1	Object
    //   584	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   595	1	7	localObject2	Object
    //   78	274	8	localObject3	Object
    //   361	1	8	localObject4	Object
    //   366	1	8	localObject5	Object
    //   380	1	8	localObject6	Object
    //   403	179	8	localObject7	Object
    //   589	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   62	484	9	localObject8	Object
    //   375	1	10	localException1	java.lang.Exception
    //   392	27	10	localException2	java.lang.Exception
    //   520	11	10	localObject9	Object
    //   541	21	10	localMessage	android.os.Message
    //   65	462	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   276	342	361	finally
    //   116	130	366	finally
    //   130	140	366	finally
    //   187	276	366	finally
    //   80	91	375	java/lang/Exception
    //   95	111	375	java/lang/Exception
    //   116	130	375	java/lang/Exception
    //   130	140	375	java/lang/Exception
    //   187	276	375	java/lang/Exception
    //   276	342	375	java/lang/Exception
    //   67	76	380	finally
    //   67	76	392	java/lang/Exception
    //   80	91	520	finally
    //   95	111	520	finally
    //   405	411	520	finally
    //   415	432	520	finally
    //   447	453	520	finally
    //   457	465	520	finally
    //   67	76	584	java/lang/OutOfMemoryError
    //   80	91	589	java/lang/OutOfMemoryError
    //   95	111	589	java/lang/OutOfMemoryError
    //   116	130	589	java/lang/OutOfMemoryError
    //   130	140	589	java/lang/OutOfMemoryError
    //   187	276	589	java/lang/OutOfMemoryError
    //   276	342	589	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler.2
 * JD-Core Version:    0.7.0.1
 */