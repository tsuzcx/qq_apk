package com.tencent.mobileqq.activity.bless;

import aipw;

public class BlessManager$4
  implements Runnable
{
  public BlessManager$4(aipw paramaipw) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   4: iconst_1
    //   5: invokestatic 25	aipw:b	(Laipw;Z)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   13: invokevirtual 29	aipw:c	()Ljava/lang/String;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +13 -> 33
    //   23: aload_0
    //   24: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   27: iconst_0
    //   28: invokestatic 25	aipw:b	(Laipw;Z)Z
    //   31: pop
    //   32: return
    //   33: new 31	java/io/File
    //   36: dup
    //   37: aload 6
    //   39: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 38	java/io/File:exists	()Z
    //   45: ifeq +199 -> 244
    //   48: new 40	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   59: getfield 44	aipw:b	Ljava/lang/String;
    //   62: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   69: invokestatic 52	aipw:a	(Laipw;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   72: getfield 57	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFolderName	Ljava/lang/String;
    //   75: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 40	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   95: aload_2
    //   96: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   103: invokestatic 52	aipw:a	(Laipw;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   106: getfield 66	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFileName	Ljava/lang/String;
    //   109: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_1
    //   116: new 31	java/io/File
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 38	java/io/File:exists	()Z
    //   129: ifeq +8 -> 137
    //   132: aload_2
    //   133: invokevirtual 69	java/io/File:delete	()Z
    //   136: pop
    //   137: aload_2
    //   138: invokevirtual 72	java/io/File:mkdirs	()Z
    //   141: pop
    //   142: new 31	java/io/File
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: new 74	android/media/MediaMetadataRetriever
    //   159: dup
    //   160: invokespecial 75	android/media/MediaMetadataRetriever:<init>	()V
    //   163: astore 4
    //   165: aload_2
    //   166: astore_1
    //   167: aload 4
    //   169: aload 6
    //   171: invokevirtual 78	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   174: aload_2
    //   175: astore_1
    //   176: aload 4
    //   178: lconst_0
    //   179: invokevirtual 82	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   182: astore 6
    //   184: aload 6
    //   186: ifnull +320 -> 506
    //   189: aload_2
    //   190: astore_1
    //   191: new 84	java/io/BufferedOutputStream
    //   194: dup
    //   195: new 86	java/io/FileOutputStream
    //   198: dup
    //   199: aload 5
    //   201: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   204: invokespecial 92	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   207: astore_2
    //   208: aload 6
    //   210: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   213: bipush 100
    //   215: aload_2
    //   216: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   219: pop
    //   220: aload_2
    //   221: invokevirtual 107	java/io/BufferedOutputStream:flush	()V
    //   224: aload_0
    //   225: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   228: invokestatic 109	aipw:a	(Laipw;)V
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   239: aload 4
    //   241: invokevirtual 115	android/media/MediaMetadataRetriever:release	()V
    //   244: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +11 -> 258
    //   250: ldc 122
    //   252: iconst_2
    //   253: ldc 124
    //   255: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_0
    //   259: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   262: iconst_0
    //   263: invokestatic 25	aipw:b	(Laipw;Z)Z
    //   266: pop
    //   267: return
    //   268: astore_1
    //   269: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -33 -> 239
    //   275: ldc 122
    //   277: iconst_2
    //   278: new 40	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   285: ldc 130
    //   287: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_1
    //   291: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: goto -64 -> 239
    //   306: astore_1
    //   307: aload_3
    //   308: astore_2
    //   309: aload_1
    //   310: astore_3
    //   311: aload_2
    //   312: astore_1
    //   313: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +33 -> 349
    //   319: aload_2
    //   320: astore_1
    //   321: ldc 122
    //   323: iconst_2
    //   324: new 40	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   331: ldc 135
    //   333: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_3
    //   337: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   340: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 5
    //   351: ifnull +21 -> 372
    //   354: aload_2
    //   355: astore_1
    //   356: aload 5
    //   358: invokevirtual 38	java/io/File:exists	()Z
    //   361: ifeq +11 -> 372
    //   364: aload_2
    //   365: astore_1
    //   366: aload 5
    //   368: invokevirtual 69	java/io/File:delete	()Z
    //   371: pop
    //   372: aload_0
    //   373: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   376: invokestatic 109	aipw:a	(Laipw;)V
    //   379: aload_2
    //   380: ifnull +7 -> 387
    //   383: aload_2
    //   384: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   387: aload 4
    //   389: invokevirtual 115	android/media/MediaMetadataRetriever:release	()V
    //   392: goto -148 -> 244
    //   395: astore_1
    //   396: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -12 -> 387
    //   402: ldc 122
    //   404: iconst_2
    //   405: new 40	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   412: ldc 130
    //   414: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: goto -43 -> 387
    //   433: astore_3
    //   434: aload_1
    //   435: astore_2
    //   436: aload_3
    //   437: astore_1
    //   438: aload_0
    //   439: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Laipw;
    //   442: invokestatic 109	aipw:a	(Laipw;)V
    //   445: aload_2
    //   446: ifnull +7 -> 453
    //   449: aload_2
    //   450: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   453: aload 4
    //   455: invokevirtual 115	android/media/MediaMetadataRetriever:release	()V
    //   458: aload_1
    //   459: athrow
    //   460: astore_2
    //   461: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq -11 -> 453
    //   467: ldc 122
    //   469: iconst_2
    //   470: new 40	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   477: ldc 130
    //   479: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_2
    //   483: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -42 -> 453
    //   498: astore_1
    //   499: goto -61 -> 438
    //   502: astore_3
    //   503: goto -192 -> 311
    //   506: aconst_null
    //   507: astore_2
    //   508: goto -284 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	4
    //   115	76	1	localObject1	Object
    //   268	23	1	localException1	java.lang.Exception
    //   306	4	1	localException2	java.lang.Exception
    //   312	54	1	localObject2	Object
    //   395	40	1	localException3	java.lang.Exception
    //   437	22	1	localObject3	Object
    //   498	1	1	localObject4	Object
    //   87	363	2	localObject5	Object
    //   460	23	2	localException4	java.lang.Exception
    //   507	1	2	localObject6	Object
    //   155	182	3	localException5	java.lang.Exception
    //   433	4	3	localObject7	Object
    //   502	1	3	localException6	java.lang.Exception
    //   163	291	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   150	217	5	localFile	java.io.File
    //   16	193	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   235	239	268	java/lang/Exception
    //   167	174	306	java/lang/Exception
    //   176	184	306	java/lang/Exception
    //   191	208	306	java/lang/Exception
    //   383	387	395	java/lang/Exception
    //   167	174	433	finally
    //   176	184	433	finally
    //   191	208	433	finally
    //   313	319	433	finally
    //   321	349	433	finally
    //   356	364	433	finally
    //   366	372	433	finally
    //   449	453	460	java/lang/Exception
    //   208	224	498	finally
    //   208	224	502	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.4
 * JD-Core Version:    0.7.0.1
 */