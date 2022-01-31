package com.tencent.mobileqq.activity.bless;

import afaz;

public class BlessManager$4
  implements Runnable
{
  public BlessManager$4(afaz paramafaz) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   4: iconst_1
    //   5: invokestatic 25	afaz:b	(Lafaz;Z)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   13: invokevirtual 29	afaz:c	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +13 -> 31
    //   21: aload_0
    //   22: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   25: iconst_0
    //   26: invokestatic 25	afaz:b	(Lafaz;Z)Z
    //   29: pop
    //   30: return
    //   31: new 31	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 38	java/io/File:exists	()Z
    //   42: ifeq +200 -> 242
    //   45: new 40	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   56: getfield 44	afaz:b	Ljava/lang/String;
    //   59: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   66: invokestatic 52	afaz:a	(Lafaz;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   69: getfield 57	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFolderName	Ljava/lang/String;
    //   72: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   78: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_3
    //   85: new 40	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   92: aload_3
    //   93: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   100: invokestatic 52	afaz:a	(Lafaz;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   103: getfield 66	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFileName	Ljava/lang/String;
    //   106: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_2
    //   113: new 31	java/io/File
    //   116: dup
    //   117: aload_3
    //   118: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 38	java/io/File:exists	()Z
    //   126: ifeq +8 -> 134
    //   129: aload_3
    //   130: invokevirtual 69	java/io/File:delete	()Z
    //   133: pop
    //   134: aload_3
    //   135: invokevirtual 72	java/io/File:mkdirs	()Z
    //   138: pop
    //   139: new 31	java/io/File
    //   142: dup
    //   143: aload_2
    //   144: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore 4
    //   149: new 74	android/media/MediaMetadataRetriever
    //   152: dup
    //   153: invokespecial 75	android/media/MediaMetadataRetriever:<init>	()V
    //   156: astore 5
    //   158: aload 5
    //   160: aload_1
    //   161: invokevirtual 78	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   164: aload 5
    //   166: lconst_0
    //   167: invokevirtual 82	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   170: astore 6
    //   172: aload 6
    //   174: ifnull +316 -> 490
    //   177: new 84	java/io/BufferedOutputStream
    //   180: dup
    //   181: new 86	java/io/FileOutputStream
    //   184: dup
    //   185: aload 4
    //   187: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: invokespecial 92	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   193: astore_2
    //   194: aload_2
    //   195: astore_1
    //   196: aload_2
    //   197: astore_3
    //   198: aload 6
    //   200: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   203: bipush 100
    //   205: aload_2
    //   206: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   209: pop
    //   210: aload_2
    //   211: astore_1
    //   212: aload_2
    //   213: astore_3
    //   214: aload_2
    //   215: invokevirtual 107	java/io/BufferedOutputStream:flush	()V
    //   218: aload_2
    //   219: astore_1
    //   220: aload_2
    //   221: astore_3
    //   222: aload 5
    //   224: invokevirtual 110	android/media/MediaMetadataRetriever:release	()V
    //   227: aload_0
    //   228: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   231: invokestatic 112	afaz:a	(Lafaz;)V
    //   234: aload_2
    //   235: ifnull +7 -> 242
    //   238: aload_2
    //   239: invokevirtual 115	java/io/BufferedOutputStream:close	()V
    //   242: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +11 -> 256
    //   248: ldc 122
    //   250: iconst_2
    //   251: ldc 124
    //   253: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_0
    //   257: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   260: iconst_0
    //   261: invokestatic 25	afaz:b	(Lafaz;Z)Z
    //   264: pop
    //   265: return
    //   266: astore_1
    //   267: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -28 -> 242
    //   273: ldc 122
    //   275: iconst_2
    //   276: new 40	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   283: ldc 130
    //   285: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: goto -59 -> 242
    //   304: astore_2
    //   305: aconst_null
    //   306: astore_3
    //   307: aload_3
    //   308: astore_1
    //   309: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +33 -> 345
    //   315: aload_3
    //   316: astore_1
    //   317: ldc 122
    //   319: iconst_2
    //   320: new 40	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   327: ldc 135
    //   329: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 4
    //   347: ifnull +21 -> 368
    //   350: aload_3
    //   351: astore_1
    //   352: aload 4
    //   354: invokevirtual 38	java/io/File:exists	()Z
    //   357: ifeq +11 -> 368
    //   360: aload_3
    //   361: astore_1
    //   362: aload 4
    //   364: invokevirtual 69	java/io/File:delete	()Z
    //   367: pop
    //   368: aload_0
    //   369: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   372: invokestatic 112	afaz:a	(Lafaz;)V
    //   375: aload_3
    //   376: ifnull -134 -> 242
    //   379: aload_3
    //   380: invokevirtual 115	java/io/BufferedOutputStream:close	()V
    //   383: goto -141 -> 242
    //   386: astore_1
    //   387: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq -148 -> 242
    //   393: ldc 122
    //   395: iconst_2
    //   396: new 40	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   403: ldc 130
    //   405: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   412: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto -179 -> 242
    //   424: astore_2
    //   425: aconst_null
    //   426: astore_1
    //   427: aload_0
    //   428: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lafaz;
    //   431: invokestatic 112	afaz:a	(Lafaz;)V
    //   434: aload_1
    //   435: ifnull +7 -> 442
    //   438: aload_1
    //   439: invokevirtual 115	java/io/BufferedOutputStream:close	()V
    //   442: aload_2
    //   443: athrow
    //   444: astore_1
    //   445: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq -6 -> 442
    //   451: ldc 122
    //   453: iconst_2
    //   454: new 40	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   461: ldc 130
    //   463: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_1
    //   467: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   470: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: goto -37 -> 442
    //   482: astore_2
    //   483: goto -56 -> 427
    //   486: astore_2
    //   487: goto -180 -> 307
    //   490: aconst_null
    //   491: astore_2
    //   492: goto -274 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	4
    //   16	204	1	localObject1	Object
    //   266	23	1	localException1	java.lang.Exception
    //   308	54	1	localObject2	Object
    //   386	23	1	localException2	java.lang.Exception
    //   426	13	1	localObject3	Object
    //   444	23	1	localException3	java.lang.Exception
    //   112	127	2	localObject4	Object
    //   304	29	2	localException4	java.lang.Exception
    //   424	19	2	localObject5	Object
    //   482	1	2	localObject6	Object
    //   486	1	2	localException5	java.lang.Exception
    //   491	1	2	localObject7	Object
    //   84	296	3	localObject8	Object
    //   147	216	4	localFile	java.io.File
    //   156	67	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   170	29	6	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   238	242	266	java/lang/Exception
    //   149	172	304	java/lang/Exception
    //   177	194	304	java/lang/Exception
    //   379	383	386	java/lang/Exception
    //   149	172	424	finally
    //   177	194	424	finally
    //   438	442	444	java/lang/Exception
    //   198	210	482	finally
    //   214	218	482	finally
    //   222	227	482	finally
    //   309	315	482	finally
    //   317	345	482	finally
    //   352	360	482	finally
    //   362	368	482	finally
    //   198	210	486	java/lang/Exception
    //   214	218	486	java/lang/Exception
    //   222	227	486	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.4
 * JD-Core Version:    0.7.0.1
 */