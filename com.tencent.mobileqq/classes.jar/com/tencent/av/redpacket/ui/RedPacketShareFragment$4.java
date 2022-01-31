package com.tencent.av.redpacket.ui;

class RedPacketShareFragment$4
  implements Runnable
{
  RedPacketShareFragment$4(RedPacketShareFragment paramRedPacketShareFragment) {}
  
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
    //   13: getfield 12	com/tencent/av/redpacket/ui/RedPacketShareFragment$4:this$0	Lcom/tencent/av/redpacket/ui/RedPacketShareFragment;
    //   16: getfield 31	com/tencent/av/redpacket/ui/RedPacketShareFragment:a	Landroid/graphics/Bitmap;
    //   19: astore 11
    //   21: aload 11
    //   23: ifnull +586 -> 609
    //   26: aload 11
    //   28: invokevirtual 37	android/graphics/Bitmap:isRecycled	()Z
    //   31: ifne +578 -> 609
    //   34: new 39	java/io/File
    //   37: dup
    //   38: getstatic 45	aljq:bd	Ljava/lang/String;
    //   41: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 51	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 54	java/io/File:canWrite	()Z
    //   57: ifeq +552 -> 609
    //   60: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   63: invokestatic 66	java/lang/Long:toString	(J)Ljava/lang/String;
    //   66: astore 5
    //   68: new 68	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 45	aljq:bd	Ljava/lang/String;
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
    //   135: getstatic 45	aljq:bd	Ljava/lang/String;
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
    //   214: bipush 100
    //   216: aload 5
    //   218: invokevirtual 111	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   221: istore_2
    //   222: aload 5
    //   224: ifnull +382 -> 606
    //   227: aload 5
    //   229: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   232: iload_2
    //   233: istore_3
    //   234: aload 6
    //   236: astore 4
    //   238: iload_2
    //   239: ifne +29 -> 268
    //   242: iload_2
    //   243: istore_3
    //   244: aload 6
    //   246: astore 4
    //   248: aload 7
    //   250: invokevirtual 83	java/io/File:exists	()Z
    //   253: ifeq +15 -> 268
    //   256: aload 7
    //   258: invokevirtual 117	java/io/File:delete	()Z
    //   261: pop
    //   262: aload 6
    //   264: astore 4
    //   266: iload_2
    //   267: istore_3
    //   268: aload_0
    //   269: getfield 12	com/tencent/av/redpacket/ui/RedPacketShareFragment$4:this$0	Lcom/tencent/av/redpacket/ui/RedPacketShareFragment;
    //   272: invokevirtual 121	com/tencent/av/redpacket/ui/RedPacketShareFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   275: ifnull +24 -> 299
    //   278: aload_0
    //   279: getfield 12	com/tencent/av/redpacket/ui/RedPacketShareFragment$4:this$0	Lcom/tencent/av/redpacket/ui/RedPacketShareFragment;
    //   282: invokevirtual 121	com/tencent/av/redpacket/ui/RedPacketShareFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   285: new 123	com/tencent/av/redpacket/ui/RedPacketShareFragment$4$1
    //   288: dup
    //   289: aload_0
    //   290: iload_3
    //   291: aload 4
    //   293: invokespecial 126	com/tencent/av/redpacket/ui/RedPacketShareFragment$4$1:<init>	(Lcom/tencent/av/redpacket/ui/RedPacketShareFragment$4;ZLjava/lang/String;)V
    //   296: invokevirtual 132	android/support/v4/app/FragmentActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   299: return
    //   300: astore 4
    //   302: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +14 -> 319
    //   308: ldc 139
    //   310: iconst_2
    //   311: aload 4
    //   313: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   316: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: goto -87 -> 232
    //   322: astore 4
    //   324: aload 8
    //   326: astore 5
    //   328: aload 4
    //   330: astore 8
    //   332: aload 5
    //   334: astore 4
    //   336: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +18 -> 357
    //   342: aload 5
    //   344: astore 4
    //   346: ldc 139
    //   348: iconst_2
    //   349: aload 8
    //   351: invokevirtual 147	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   354: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 5
    //   359: ifnull +242 -> 601
    //   362: aload 5
    //   364: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   367: iconst_0
    //   368: istore_2
    //   369: goto -137 -> 232
    //   372: astore 4
    //   374: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +14 -> 391
    //   380: ldc 139
    //   382: iconst_2
    //   383: aload 4
    //   385: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   388: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: iconst_0
    //   392: istore_2
    //   393: goto -161 -> 232
    //   396: astore 8
    //   398: aload 9
    //   400: astore 5
    //   402: aload 5
    //   404: astore 4
    //   406: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +18 -> 427
    //   412: aload 5
    //   414: astore 4
    //   416: ldc 139
    //   418: iconst_2
    //   419: aload 8
    //   421: invokevirtual 148	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   424: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload 5
    //   429: ifnull +172 -> 601
    //   432: aload 5
    //   434: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   437: iconst_0
    //   438: istore_2
    //   439: goto -207 -> 232
    //   442: astore 4
    //   444: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +14 -> 461
    //   450: ldc 139
    //   452: iconst_2
    //   453: aload 4
    //   455: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   458: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: iconst_0
    //   462: istore_2
    //   463: goto -231 -> 232
    //   466: astore 8
    //   468: aload 10
    //   470: astore 5
    //   472: aload 5
    //   474: astore 4
    //   476: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +18 -> 497
    //   482: aload 5
    //   484: astore 4
    //   486: ldc 139
    //   488: iconst_2
    //   489: aload 8
    //   491: invokevirtual 149	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   494: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload 5
    //   499: ifnull +102 -> 601
    //   502: aload 5
    //   504: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   507: iconst_0
    //   508: istore_2
    //   509: goto -277 -> 232
    //   512: astore 4
    //   514: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +14 -> 531
    //   520: ldc 139
    //   522: iconst_2
    //   523: aload 4
    //   525: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   528: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iconst_0
    //   532: istore_2
    //   533: goto -301 -> 232
    //   536: astore 6
    //   538: aload 4
    //   540: astore 5
    //   542: aload 6
    //   544: astore 4
    //   546: aload 5
    //   548: ifnull +8 -> 556
    //   551: aload 5
    //   553: invokevirtual 114	java/io/BufferedOutputStream:close	()V
    //   556: aload 4
    //   558: athrow
    //   559: astore 5
    //   561: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq -8 -> 556
    //   567: ldc 139
    //   569: iconst_2
    //   570: aload 5
    //   572: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   575: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: goto -22 -> 556
    //   581: astore 4
    //   583: goto -37 -> 546
    //   586: astore 8
    //   588: goto -116 -> 472
    //   591: astore 8
    //   593: goto -191 -> 402
    //   596: astore 8
    //   598: goto -266 -> 332
    //   601: iconst_0
    //   602: istore_2
    //   603: goto -371 -> 232
    //   606: goto -374 -> 232
    //   609: aconst_null
    //   610: astore 4
    //   612: iconst_0
    //   613: istore_3
    //   614: goto -346 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	4
    //   113	72	1	i	int
    //   221	382	2	bool1	boolean
    //   233	381	3	bool2	boolean
    //   7	285	4	localObject1	Object
    //   300	12	4	localIOException1	java.io.IOException
    //   322	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   334	11	4	localObject2	Object
    //   372	12	4	localIOException2	java.io.IOException
    //   404	11	4	localObject3	Object
    //   442	12	4	localIOException3	java.io.IOException
    //   474	11	4	localObject4	Object
    //   512	27	4	localIOException4	java.io.IOException
    //   544	13	4	localObject5	Object
    //   581	1	4	localObject6	Object
    //   610	1	4	localObject7	Object
    //   44	508	5	localObject8	Object
    //   559	12	5	localIOException5	java.io.IOException
    //   99	164	6	str	java.lang.String
    //   536	7	6	localObject9	Object
    //   110	147	7	localFile	java.io.File
    //   10	340	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   396	24	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   466	24	8	localIllegalStateException1	java.lang.IllegalStateException
    //   586	1	8	localIllegalStateException2	java.lang.IllegalStateException
    //   591	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   596	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	398	9	localObject10	Object
    //   4	465	10	localObject11	Object
    //   19	191	11	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   227	232	300	java/io/IOException
    //   188	209	322	java/io/FileNotFoundException
    //   362	367	372	java/io/IOException
    //   188	209	396	java/lang/OutOfMemoryError
    //   432	437	442	java/io/IOException
    //   188	209	466	java/lang/IllegalStateException
    //   502	507	512	java/io/IOException
    //   188	209	536	finally
    //   336	342	536	finally
    //   346	357	536	finally
    //   406	412	536	finally
    //   416	427	536	finally
    //   476	482	536	finally
    //   486	497	536	finally
    //   551	556	559	java/io/IOException
    //   209	222	581	finally
    //   209	222	586	java/lang/IllegalStateException
    //   209	222	591	java/lang/OutOfMemoryError
    //   209	222	596	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.4
 * JD-Core Version:    0.7.0.1
 */