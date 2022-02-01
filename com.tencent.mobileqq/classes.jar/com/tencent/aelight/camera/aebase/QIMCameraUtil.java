package com.tencent.aelight.camera.aebase;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class QIMCameraUtil
{
  /* Error */
  public static Bitmap a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 19	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: astore 13
    //   24: iload_1
    //   25: ifeq +402 -> 427
    //   28: aload 10
    //   30: astore 9
    //   32: getstatic 25	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   35: astore_0
    //   36: aload 10
    //   38: astore 9
    //   40: aload 13
    //   42: aload_0
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 10
    //   52: aload 10
    //   54: ifnull +260 -> 314
    //   57: aload 10
    //   59: invokeinterface 37 1 0
    //   64: istore_1
    //   65: iload_1
    //   66: ifeq +248 -> 314
    //   69: aconst_null
    //   70: astore 9
    //   72: aload 9
    //   74: astore_0
    //   75: lconst_0
    //   76: lstore 5
    //   78: aload 10
    //   80: aload 10
    //   82: ldc 39
    //   84: invokeinterface 43 2 0
    //   89: invokeinterface 47 2 0
    //   94: istore_2
    //   95: aload 10
    //   97: aload 10
    //   99: ldc 49
    //   101: invokeinterface 43 2 0
    //   106: invokeinterface 53 2 0
    //   111: lstore 7
    //   113: aload 10
    //   115: ldc 55
    //   117: invokeinterface 43 2 0
    //   122: istore_3
    //   123: lload 7
    //   125: aload 10
    //   127: iload_3
    //   128: invokeinterface 53 2 0
    //   133: invokestatic 61	java/lang/Math:max	(JJ)J
    //   136: lstore 7
    //   138: lload 7
    //   140: lstore 5
    //   142: aload 10
    //   144: aload 10
    //   146: ldc 63
    //   148: invokeinterface 43 2 0
    //   153: invokeinterface 67 2 0
    //   158: astore 11
    //   160: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +34 -> 197
    //   166: new 74	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   173: astore_0
    //   174: aload_0
    //   175: ldc 77
    //   177: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_0
    //   182: iload_2
    //   183: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 86
    //   189: iconst_2
    //   190: aload_0
    //   191: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 13
    //   199: iload_2
    //   200: i2l
    //   201: iconst_3
    //   202: aconst_null
    //   203: invokestatic 100	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   206: astore 12
    //   208: aload 12
    //   210: ifnull +6 -> 216
    //   213: goto +26 -> 239
    //   216: aload 10
    //   218: invokeinterface 103 1 0
    //   223: istore_1
    //   224: aload 12
    //   226: astore 9
    //   228: aload 11
    //   230: astore_0
    //   231: lload 7
    //   233: lstore 5
    //   235: iload_1
    //   236: ifne -158 -> 78
    //   239: aload 12
    //   241: astore 9
    //   243: goto +81 -> 324
    //   246: astore_0
    //   247: aload 12
    //   249: astore 9
    //   251: lload 7
    //   253: lstore 5
    //   255: goto +30 -> 285
    //   258: astore_0
    //   259: lload 7
    //   261: lstore 5
    //   263: goto +22 -> 285
    //   266: astore 12
    //   268: aload_0
    //   269: astore 11
    //   271: aload 12
    //   273: astore_0
    //   274: goto +11 -> 285
    //   277: astore 12
    //   279: aload_0
    //   280: astore 11
    //   282: aload 12
    //   284: astore_0
    //   285: aload_0
    //   286: astore 12
    //   288: aload 10
    //   290: astore_0
    //   291: aload 9
    //   293: astore 10
    //   295: goto +78 -> 373
    //   298: astore_0
    //   299: aload 10
    //   301: astore 9
    //   303: goto +110 -> 413
    //   306: astore 9
    //   308: aload 10
    //   310: astore_0
    //   311: goto +49 -> 360
    //   314: aconst_null
    //   315: astore 11
    //   317: lconst_0
    //   318: lstore 7
    //   320: aload 12
    //   322: astore 9
    //   324: aload 10
    //   326: ifnull +10 -> 336
    //   329: aload 10
    //   331: invokeinterface 106 1 0
    //   336: aload 11
    //   338: astore_0
    //   339: lload 7
    //   341: lstore 5
    //   343: goto +92 -> 435
    //   346: astore 9
    //   348: goto +9 -> 357
    //   351: astore_0
    //   352: goto +61 -> 413
    //   355: astore 9
    //   357: aload 11
    //   359: astore_0
    //   360: aconst_null
    //   361: astore 11
    //   363: aconst_null
    //   364: astore 10
    //   366: lconst_0
    //   367: lstore 5
    //   369: aload 9
    //   371: astore 12
    //   373: aload_0
    //   374: astore 9
    //   376: ldc 86
    //   378: iconst_2
    //   379: ldc 108
    //   381: aload 12
    //   383: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   386: aload_0
    //   387: ifnull +9 -> 396
    //   390: aload_0
    //   391: invokeinterface 106 1 0
    //   396: aload_0
    //   397: astore 12
    //   399: aload 10
    //   401: astore 9
    //   403: aload 11
    //   405: astore_0
    //   406: aload 12
    //   408: astore 10
    //   410: goto +25 -> 435
    //   413: aload 9
    //   415: ifnull +10 -> 425
    //   418: aload 9
    //   420: invokeinterface 106 1 0
    //   425: aload_0
    //   426: athrow
    //   427: aconst_null
    //   428: astore_0
    //   429: aload_0
    //   430: astore 10
    //   432: lconst_0
    //   433: lstore 5
    //   435: aload 10
    //   437: astore 11
    //   439: aload 13
    //   441: getstatic 115	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   444: aconst_null
    //   445: aconst_null
    //   446: aconst_null
    //   447: aconst_null
    //   448: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   451: astore 14
    //   453: aload 9
    //   455: astore 11
    //   457: aload_0
    //   458: astore 12
    //   460: aload 14
    //   462: ifnull +253 -> 715
    //   465: aload_0
    //   466: astore 10
    //   468: aload 9
    //   470: astore 11
    //   472: aload_0
    //   473: astore 12
    //   475: aload 14
    //   477: invokeinterface 37 1 0
    //   482: ifeq +233 -> 715
    //   485: aload_0
    //   486: astore 11
    //   488: aload 11
    //   490: astore 10
    //   492: aload 14
    //   494: aload 14
    //   496: ldc 39
    //   498: invokeinterface 43 2 0
    //   503: invokeinterface 47 2 0
    //   508: istore_2
    //   509: aload 11
    //   511: astore 10
    //   513: aload 14
    //   515: aload 14
    //   517: ldc 49
    //   519: invokeinterface 43 2 0
    //   524: invokeinterface 53 2 0
    //   529: aload 14
    //   531: aload 14
    //   533: ldc 55
    //   535: invokeinterface 43 2 0
    //   540: invokeinterface 53 2 0
    //   545: invokestatic 61	java/lang/Math:max	(JJ)J
    //   548: lstore 7
    //   550: aload 11
    //   552: astore 10
    //   554: aload 14
    //   556: aload 14
    //   558: ldc 63
    //   560: invokeinterface 43 2 0
    //   565: invokeinterface 67 2 0
    //   570: astore_0
    //   571: aload_0
    //   572: astore 10
    //   574: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +50 -> 627
    //   580: aload_0
    //   581: astore 10
    //   583: new 74	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   590: astore 11
    //   592: aload_0
    //   593: astore 10
    //   595: aload 11
    //   597: ldc 117
    //   599: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload_0
    //   604: astore 10
    //   606: aload 11
    //   608: iload_2
    //   609: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_0
    //   614: astore 10
    //   616: ldc 86
    //   618: iconst_2
    //   619: aload 11
    //   621: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload_0
    //   628: astore 10
    //   630: aload_0
    //   631: iconst_1
    //   632: invokestatic 123	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeBitmap	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   635: astore 13
    //   637: aload 13
    //   639: ifnull +28 -> 667
    //   642: aload 9
    //   644: astore 11
    //   646: aload_0
    //   647: astore 12
    //   649: lload 7
    //   651: lload 5
    //   653: lcmp
    //   654: ifle +61 -> 715
    //   657: aload 13
    //   659: astore 11
    //   661: aload_0
    //   662: astore 12
    //   664: goto +51 -> 715
    //   667: aload_0
    //   668: astore 10
    //   670: aload 14
    //   672: invokeinterface 103 1 0
    //   677: istore_1
    //   678: aload_0
    //   679: astore 11
    //   681: iload_1
    //   682: ifne -194 -> 488
    //   685: aload 9
    //   687: astore 11
    //   689: aload_0
    //   690: astore 12
    //   692: goto +23 -> 715
    //   695: astore_0
    //   696: aload 14
    //   698: astore 11
    //   700: goto +235 -> 935
    //   703: astore 12
    //   705: aload 10
    //   707: astore_0
    //   708: aload 14
    //   710: astore 10
    //   712: goto +40 -> 752
    //   715: aload 11
    //   717: astore 13
    //   719: aload 12
    //   721: astore 15
    //   723: aload 14
    //   725: ifnull +67 -> 792
    //   728: aload 14
    //   730: invokeinterface 106 1 0
    //   735: aload 11
    //   737: astore 13
    //   739: aload 12
    //   741: astore 15
    //   743: goto +49 -> 792
    //   746: astore_0
    //   747: goto +188 -> 935
    //   750: astore 12
    //   752: aload 10
    //   754: astore 11
    //   756: ldc 86
    //   758: iconst_2
    //   759: ldc 125
    //   761: aload 12
    //   763: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   766: aload 9
    //   768: astore 13
    //   770: aload_0
    //   771: astore 15
    //   773: aload 10
    //   775: ifnull +17 -> 792
    //   778: aload 10
    //   780: invokeinterface 106 1 0
    //   785: aload_0
    //   786: astore 15
    //   788: aload 9
    //   790: astore 13
    //   792: aload 13
    //   794: astore_0
    //   795: aload 15
    //   797: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   800: ifne +133 -> 933
    //   803: aload 13
    //   805: astore_0
    //   806: aload 13
    //   808: ifnull +125 -> 933
    //   811: aload 13
    //   813: invokestatic 134	com/tencent/aelight/camera/aebase/QIMCameraUtil:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   816: astore_0
    //   817: aload 15
    //   819: invokestatic 139	com/tencent/mobileqq/utils/ImageUtil:h	(Ljava/lang/String;)I
    //   822: istore_2
    //   823: iload_2
    //   824: ifeq +109 -> 933
    //   827: iload_2
    //   828: bipush 90
    //   830: irem
    //   831: ifne +102 -> 933
    //   834: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +38 -> 875
    //   840: new 74	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   847: astore 9
    //   849: aload 9
    //   851: ldc 141
    //   853: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 9
    //   859: iload_2
    //   860: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: ldc 86
    //   866: iconst_2
    //   867: aload 9
    //   869: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload_0
    //   876: invokevirtual 147	android/graphics/Bitmap:getWidth	()I
    //   879: istore_3
    //   880: aload_0
    //   881: invokevirtual 150	android/graphics/Bitmap:getHeight	()I
    //   884: istore 4
    //   886: new 152	android/graphics/Matrix
    //   889: dup
    //   890: invokespecial 153	android/graphics/Matrix:<init>	()V
    //   893: astore 9
    //   895: aload 9
    //   897: iload_2
    //   898: i2f
    //   899: iload_3
    //   900: i2f
    //   901: fconst_2
    //   902: fdiv
    //   903: iload 4
    //   905: i2f
    //   906: fconst_2
    //   907: fdiv
    //   908: invokevirtual 157	android/graphics/Matrix:postRotate	(FFF)Z
    //   911: pop
    //   912: aload_0
    //   913: iconst_0
    //   914: iconst_0
    //   915: iload_3
    //   916: iload 4
    //   918: aload 9
    //   920: iconst_1
    //   921: invokestatic 161	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   924: astore 9
    //   926: aload_0
    //   927: invokevirtual 164	android/graphics/Bitmap:recycle	()V
    //   930: aload 9
    //   932: areturn
    //   933: aload_0
    //   934: areturn
    //   935: aload 11
    //   937: ifnull +10 -> 947
    //   940: aload 11
    //   942: invokeinterface 106 1 0
    //   947: goto +5 -> 952
    //   950: aload_0
    //   951: athrow
    //   952: goto -2 -> 950
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	paramContext	android.content.Context
    //   0	955	1	paramBoolean	boolean
    //   94	804	2	i	int
    //   122	794	3	j	int
    //   884	33	4	k	int
    //   76	576	5	l1	long
    //   111	539	7	l2	long
    //   7	295	9	localObject1	Object
    //   306	1	9	localException1	java.lang.Exception
    //   322	1	9	localObject2	Object
    //   346	1	9	localException2	java.lang.Exception
    //   355	15	9	localException3	java.lang.Exception
    //   374	557	9	localObject3	Object
    //   1	778	10	localObject4	Object
    //   4	937	11	localObject5	Object
    //   10	238	12	localBitmap	Bitmap
    //   266	6	12	localException4	java.lang.Exception
    //   277	6	12	localException5	java.lang.Exception
    //   286	405	12	localObject6	Object
    //   703	37	12	localException6	java.lang.Exception
    //   750	12	12	localException7	java.lang.Exception
    //   22	790	13	localObject7	Object
    //   451	278	14	localCursor	android.database.Cursor
    //   721	97	15	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   216	224	246	java/lang/Exception
    //   160	197	258	java/lang/Exception
    //   197	208	258	java/lang/Exception
    //   123	138	266	java/lang/Exception
    //   142	160	266	java/lang/Exception
    //   78	123	277	java/lang/Exception
    //   57	65	298	finally
    //   78	123	298	finally
    //   123	138	298	finally
    //   142	160	298	finally
    //   160	197	298	finally
    //   197	208	298	finally
    //   216	224	298	finally
    //   57	65	306	java/lang/Exception
    //   40	52	346	java/lang/Exception
    //   32	36	351	finally
    //   40	52	351	finally
    //   376	386	351	finally
    //   32	36	355	java/lang/Exception
    //   475	485	695	finally
    //   492	509	695	finally
    //   513	550	695	finally
    //   554	571	695	finally
    //   574	580	695	finally
    //   583	592	695	finally
    //   595	603	695	finally
    //   606	613	695	finally
    //   616	627	695	finally
    //   630	637	695	finally
    //   670	678	695	finally
    //   475	485	703	java/lang/Exception
    //   492	509	703	java/lang/Exception
    //   513	550	703	java/lang/Exception
    //   554	571	703	java/lang/Exception
    //   574	580	703	java/lang/Exception
    //   583	592	703	java/lang/Exception
    //   595	603	703	java/lang/Exception
    //   606	613	703	java/lang/Exception
    //   616	627	703	java/lang/Exception
    //   630	637	703	java/lang/Exception
    //   670	678	703	java/lang/Exception
    //   439	453	746	finally
    //   756	766	746	finally
    //   439	453	750	java/lang/Exception
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return paramBitmap;
      }
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int k = Math.min(i, j);
      if (k > 50)
      {
        float f = 50.0F / k;
        Object localObject = new Matrix();
        ((Matrix)localObject).preScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
        if (localObject.equals(paramBitmap)) {
          return localObject;
        }
        paramBitmap.recycle();
        return localObject;
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraUtil
 * JD-Core Version:    0.7.0.1
 */