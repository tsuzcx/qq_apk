package com.tencent.mobileqq.activity.bless;

class BlessManager$4
  implements Runnable
{
  BlessManager$4(BlessManager paramBlessManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   4: iconst_1
    //   5: invokestatic 25	com/tencent/mobileqq/activity/bless/BlessManager:b	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   13: invokevirtual 29	com/tencent/mobileqq/activity/bless/BlessManager:c	()Ljava/lang/String;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +13 -> 33
    //   23: aload_0
    //   24: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   27: iconst_0
    //   28: invokestatic 25	com/tencent/mobileqq/activity/bless/BlessManager:b	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   31: pop
    //   32: return
    //   33: new 31	java/io/File
    //   36: dup
    //   37: aload 7
    //   39: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 38	java/io/File:exists	()Z
    //   45: ifeq +466 -> 511
    //   48: new 40	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   61: getfield 44	com/tencent/mobileqq/activity/bless/BlessManager:b	Ljava/lang/String;
    //   64: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   73: invokestatic 52	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   76: getfield 57	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFolderName	Ljava/lang/String;
    //   79: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_1
    //   96: new 40	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   103: astore_2
    //   104: aload_2
    //   105: aload_1
    //   106: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_0
    //   112: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   115: invokestatic 52	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   118: getfield 66	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFileName	Ljava/lang/String;
    //   121: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_2
    //   126: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore_2
    //   130: new 31	java/io/File
    //   133: dup
    //   134: aload_1
    //   135: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 38	java/io/File:exists	()Z
    //   143: ifeq +8 -> 151
    //   146: aload_1
    //   147: invokevirtual 69	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_1
    //   152: invokevirtual 72	java/io/File:mkdirs	()Z
    //   155: pop
    //   156: new 31	java/io/File
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore 6
    //   166: aconst_null
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_3
    //   170: aconst_null
    //   171: astore 4
    //   173: new 74	android/media/MediaMetadataRetriever
    //   176: dup
    //   177: invokespecial 75	android/media/MediaMetadataRetriever:<init>	()V
    //   180: astore 5
    //   182: aload_2
    //   183: astore_1
    //   184: aload 5
    //   186: aload 7
    //   188: invokevirtual 78	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: astore_1
    //   193: aload 5
    //   195: lconst_0
    //   196: invokevirtual 82	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   199: astore 7
    //   201: aload 4
    //   203: astore_1
    //   204: aload 7
    //   206: ifnull +55 -> 261
    //   209: aload_2
    //   210: astore_1
    //   211: new 84	java/io/BufferedOutputStream
    //   214: dup
    //   215: new 86	java/io/FileOutputStream
    //   218: dup
    //   219: aload 6
    //   221: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 92	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore_2
    //   228: aload 7
    //   230: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   233: bipush 100
    //   235: aload_2
    //   236: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   239: pop
    //   240: aload_2
    //   241: invokevirtual 107	java/io/BufferedOutputStream:flush	()V
    //   244: aload_2
    //   245: astore_1
    //   246: goto +15 -> 261
    //   249: astore_3
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: goto +191 -> 445
    //   257: astore_3
    //   258: goto +79 -> 337
    //   261: aload_0
    //   262: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   265: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   268: aload_1
    //   269: ifnull +51 -> 320
    //   272: aload_1
    //   273: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   276: goto +44 -> 320
    //   279: astore_1
    //   280: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +37 -> 320
    //   286: new 40	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   293: astore_2
    //   294: aload_2
    //   295: ldc 119
    //   297: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: aload_1
    //   303: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: ldc 124
    //   312: iconst_2
    //   313: aload_2
    //   314: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 5
    //   322: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   325: goto +186 -> 511
    //   328: astore_2
    //   329: goto +116 -> 445
    //   332: astore_1
    //   333: aload_3
    //   334: astore_2
    //   335: aload_1
    //   336: astore_3
    //   337: aload_2
    //   338: astore_1
    //   339: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +49 -> 391
    //   345: aload_2
    //   346: astore_1
    //   347: new 40	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   354: astore 4
    //   356: aload_2
    //   357: astore_1
    //   358: aload 4
    //   360: ldc 133
    //   362: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: astore_1
    //   368: aload 4
    //   370: aload_3
    //   371: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   374: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_2
    //   379: astore_1
    //   380: ldc 124
    //   382: iconst_2
    //   383: aload 4
    //   385: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_2
    //   392: astore_1
    //   393: aload 6
    //   395: invokevirtual 38	java/io/File:exists	()Z
    //   398: ifeq +11 -> 409
    //   401: aload_2
    //   402: astore_1
    //   403: aload 6
    //   405: invokevirtual 69	java/io/File:delete	()Z
    //   408: pop
    //   409: aload_0
    //   410: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   413: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   416: aload_2
    //   417: ifnull -97 -> 320
    //   420: aload_2
    //   421: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   424: goto -104 -> 320
    //   427: astore_1
    //   428: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -111 -> 320
    //   434: new 40	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   441: astore_2
    //   442: goto -148 -> 294
    //   445: aload_0
    //   446: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   449: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   452: aload_1
    //   453: ifnull +51 -> 504
    //   456: aload_1
    //   457: invokevirtual 112	java/io/BufferedOutputStream:close	()V
    //   460: goto +44 -> 504
    //   463: astore_1
    //   464: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +37 -> 504
    //   470: new 40	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   477: astore_3
    //   478: aload_3
    //   479: ldc 119
    //   481: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_3
    //   486: aload_1
    //   487: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   490: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: ldc 124
    //   496: iconst_2
    //   497: aload_3
    //   498: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload 5
    //   506: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   509: aload_2
    //   510: athrow
    //   511: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +11 -> 525
    //   517: ldc 124
    //   519: iconst_2
    //   520: ldc 135
    //   522: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: aload_0
    //   526: getfield 12	com/tencent/mobileqq/activity/bless/BlessManager$4:this$0	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   529: iconst_0
    //   530: invokestatic 25	com/tencent/mobileqq/activity/bless/BlessManager:b	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   533: pop
    //   534: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	4
    //   55	218	1	localObject1	Object
    //   279	24	1	localException1	java.lang.Exception
    //   332	4	1	localException2	java.lang.Exception
    //   338	65	1	localObject2	Object
    //   427	30	1	localException3	java.lang.Exception
    //   463	24	1	localException4	java.lang.Exception
    //   103	211	2	localObject3	Object
    //   328	1	2	localObject4	Object
    //   334	176	2	localObject5	Object
    //   169	1	3	localObject6	Object
    //   249	4	3	localObject7	Object
    //   257	77	3	localException5	java.lang.Exception
    //   336	162	3	localObject8	Object
    //   171	213	4	localStringBuilder	java.lang.StringBuilder
    //   180	325	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   164	240	6	localFile	java.io.File
    //   16	213	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   228	244	249	finally
    //   228	244	257	java/lang/Exception
    //   272	276	279	java/lang/Exception
    //   184	191	328	finally
    //   193	201	328	finally
    //   211	228	328	finally
    //   339	345	328	finally
    //   347	356	328	finally
    //   358	366	328	finally
    //   368	378	328	finally
    //   380	391	328	finally
    //   393	401	328	finally
    //   403	409	328	finally
    //   184	191	332	java/lang/Exception
    //   193	201	332	java/lang/Exception
    //   211	228	332	java/lang/Exception
    //   420	424	427	java/lang/Exception
    //   456	460	463	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.4
 * JD-Core Version:    0.7.0.1
 */