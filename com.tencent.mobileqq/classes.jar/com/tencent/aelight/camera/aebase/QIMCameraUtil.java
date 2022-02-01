package com.tencent.aelight.camera.aebase;

public class QIMCameraUtil
{
  /* Error */
  public static android.graphics.Bitmap a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 19	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 15
    //   12: iload_1
    //   13: ifeq +526 -> 539
    //   16: getstatic 25	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   19: astore_0
    //   20: aload 15
    //   22: aload_0
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +352 -> 384
    //   35: aload_0
    //   36: astore 10
    //   38: aload_0
    //   39: invokeinterface 37 1 0
    //   44: istore_1
    //   45: iload_1
    //   46: ifeq +338 -> 384
    //   49: aconst_null
    //   50: astore 13
    //   52: aload 13
    //   54: astore 12
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload 13
    //   61: astore 11
    //   63: aload 12
    //   65: astore 9
    //   67: lload 5
    //   69: lstore 7
    //   71: aload_0
    //   72: astore 10
    //   74: aload_0
    //   75: aload_0
    //   76: ldc 39
    //   78: invokeinterface 43 2 0
    //   83: invokeinterface 47 2 0
    //   88: istore_2
    //   89: aload 13
    //   91: astore 11
    //   93: aload 12
    //   95: astore 9
    //   97: lload 5
    //   99: lstore 7
    //   101: aload_0
    //   102: astore 10
    //   104: aload_0
    //   105: aload_0
    //   106: ldc 49
    //   108: invokeinterface 43 2 0
    //   113: invokeinterface 53 2 0
    //   118: aload_0
    //   119: aload_0
    //   120: ldc 55
    //   122: invokeinterface 43 2 0
    //   127: invokeinterface 53 2 0
    //   132: invokestatic 61	java/lang/Math:max	(JJ)J
    //   135: lstore 5
    //   137: aload 13
    //   139: astore 11
    //   141: aload 12
    //   143: astore 9
    //   145: lload 5
    //   147: lstore 7
    //   149: aload_0
    //   150: astore 10
    //   152: aload_0
    //   153: aload_0
    //   154: ldc 63
    //   156: invokeinterface 43 2 0
    //   161: invokeinterface 67 2 0
    //   166: astore 12
    //   168: aload 13
    //   170: astore 11
    //   172: aload 12
    //   174: astore 9
    //   176: lload 5
    //   178: lstore 7
    //   180: aload_0
    //   181: astore 10
    //   183: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +98 -> 284
    //   189: aload 13
    //   191: astore 11
    //   193: aload 12
    //   195: astore 9
    //   197: lload 5
    //   199: lstore 7
    //   201: aload_0
    //   202: astore 10
    //   204: new 74	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   211: astore 14
    //   213: aload 13
    //   215: astore 11
    //   217: aload 12
    //   219: astore 9
    //   221: lload 5
    //   223: lstore 7
    //   225: aload_0
    //   226: astore 10
    //   228: aload 14
    //   230: ldc 77
    //   232: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 13
    //   238: astore 11
    //   240: aload 12
    //   242: astore 9
    //   244: lload 5
    //   246: lstore 7
    //   248: aload_0
    //   249: astore 10
    //   251: aload 14
    //   253: iload_2
    //   254: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 13
    //   260: astore 11
    //   262: aload 12
    //   264: astore 9
    //   266: lload 5
    //   268: lstore 7
    //   270: aload_0
    //   271: astore 10
    //   273: ldc 86
    //   275: iconst_2
    //   276: aload 14
    //   278: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 13
    //   286: astore 11
    //   288: aload 12
    //   290: astore 9
    //   292: lload 5
    //   294: lstore 7
    //   296: aload_0
    //   297: astore 10
    //   299: aload 15
    //   301: iload_2
    //   302: i2l
    //   303: iconst_3
    //   304: aconst_null
    //   305: invokestatic 100	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   308: astore 13
    //   310: aload 13
    //   312: ifnull +18 -> 330
    //   315: aload 13
    //   317: astore 9
    //   319: aload 12
    //   321: astore 11
    //   323: lload 5
    //   325: lstore 7
    //   327: goto +67 -> 394
    //   330: aload 13
    //   332: astore 11
    //   334: aload 12
    //   336: astore 9
    //   338: lload 5
    //   340: lstore 7
    //   342: aload_0
    //   343: astore 10
    //   345: aload_0
    //   346: invokeinterface 103 1 0
    //   351: istore_1
    //   352: iload_1
    //   353: ifne +18 -> 371
    //   356: aload 13
    //   358: astore 9
    //   360: aload 12
    //   362: astore 11
    //   364: lload 5
    //   366: lstore 7
    //   368: goto +26 -> 394
    //   371: goto -312 -> 59
    //   374: astore 12
    //   376: goto +105 -> 481
    //   379: astore 10
    //   381: goto +87 -> 468
    //   384: aconst_null
    //   385: astore 9
    //   387: aload 9
    //   389: astore 11
    //   391: lconst_0
    //   392: lstore 7
    //   394: aload_0
    //   395: astore 12
    //   397: aload 9
    //   399: astore 13
    //   401: aload 11
    //   403: astore 10
    //   405: lload 7
    //   407: lstore 5
    //   409: aload_0
    //   410: ifnull +28 -> 438
    //   413: lload 7
    //   415: lstore 5
    //   417: aload 11
    //   419: astore 10
    //   421: aload 9
    //   423: astore 11
    //   425: aload_0
    //   426: invokeinterface 106 1 0
    //   431: aload 11
    //   433: astore 13
    //   435: aload_0
    //   436: astore 12
    //   438: aload 13
    //   440: astore 9
    //   442: aload 10
    //   444: astore_0
    //   445: aload 12
    //   447: astore 10
    //   449: goto +102 -> 551
    //   452: astore 10
    //   454: goto +12 -> 466
    //   457: astore_0
    //   458: aconst_null
    //   459: astore 10
    //   461: goto +64 -> 525
    //   464: astore 10
    //   466: aconst_null
    //   467: astore_0
    //   468: aconst_null
    //   469: astore 11
    //   471: aconst_null
    //   472: astore 9
    //   474: lconst_0
    //   475: lstore 7
    //   477: aload 10
    //   479: astore 12
    //   481: aload_0
    //   482: astore 10
    //   484: ldc 86
    //   486: iconst_2
    //   487: ldc 108
    //   489: aload 12
    //   491: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_0
    //   495: astore 12
    //   497: aload 11
    //   499: astore 13
    //   501: aload 9
    //   503: astore 10
    //   505: lload 7
    //   507: lstore 5
    //   509: aload_0
    //   510: ifnull -72 -> 438
    //   513: aload 9
    //   515: astore 10
    //   517: lload 7
    //   519: lstore 5
    //   521: goto -96 -> 425
    //   524: astore_0
    //   525: aload 10
    //   527: ifnull +10 -> 537
    //   530: aload 10
    //   532: invokeinterface 106 1 0
    //   537: aload_0
    //   538: athrow
    //   539: aconst_null
    //   540: astore 9
    //   542: aload 9
    //   544: astore_0
    //   545: aload_0
    //   546: astore 10
    //   548: lconst_0
    //   549: lstore 5
    //   551: aload 10
    //   553: astore 11
    //   555: aload 15
    //   557: getstatic 115	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   560: aconst_null
    //   561: aconst_null
    //   562: aconst_null
    //   563: aconst_null
    //   564: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   567: astore 13
    //   569: aload 9
    //   571: astore 11
    //   573: aload_0
    //   574: astore 12
    //   576: aload 13
    //   578: ifnull +257 -> 835
    //   581: aload_0
    //   582: astore 10
    //   584: aload 9
    //   586: astore 11
    //   588: aload_0
    //   589: astore 12
    //   591: aload 13
    //   593: invokeinterface 37 1 0
    //   598: ifeq +237 -> 835
    //   601: aload_0
    //   602: astore 11
    //   604: aload 11
    //   606: astore 10
    //   608: aload 13
    //   610: aload 13
    //   612: ldc 39
    //   614: invokeinterface 43 2 0
    //   619: invokeinterface 47 2 0
    //   624: istore_2
    //   625: aload 11
    //   627: astore 10
    //   629: aload 13
    //   631: aload 13
    //   633: ldc 49
    //   635: invokeinterface 43 2 0
    //   640: invokeinterface 53 2 0
    //   645: aload 13
    //   647: aload 13
    //   649: ldc 55
    //   651: invokeinterface 43 2 0
    //   656: invokeinterface 53 2 0
    //   661: invokestatic 61	java/lang/Math:max	(JJ)J
    //   664: lstore 7
    //   666: aload 11
    //   668: astore 10
    //   670: aload 13
    //   672: aload 13
    //   674: ldc 63
    //   676: invokeinterface 43 2 0
    //   681: invokeinterface 67 2 0
    //   686: astore_0
    //   687: aload_0
    //   688: astore 10
    //   690: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +50 -> 743
    //   696: aload_0
    //   697: astore 10
    //   699: new 74	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   706: astore 11
    //   708: aload_0
    //   709: astore 10
    //   711: aload 11
    //   713: ldc 117
    //   715: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_0
    //   720: astore 10
    //   722: aload 11
    //   724: iload_2
    //   725: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload_0
    //   730: astore 10
    //   732: ldc 86
    //   734: iconst_2
    //   735: aload 11
    //   737: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: aload_0
    //   744: astore 10
    //   746: aload 15
    //   748: iload_2
    //   749: i2l
    //   750: iconst_3
    //   751: aconst_null
    //   752: invokestatic 120	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   755: astore 14
    //   757: aload 14
    //   759: ifnull +28 -> 787
    //   762: aload 9
    //   764: astore 11
    //   766: aload_0
    //   767: astore 12
    //   769: lload 7
    //   771: lload 5
    //   773: lcmp
    //   774: ifle +61 -> 835
    //   777: aload 14
    //   779: astore 11
    //   781: aload_0
    //   782: astore 12
    //   784: goto +51 -> 835
    //   787: aload_0
    //   788: astore 10
    //   790: aload 13
    //   792: invokeinterface 103 1 0
    //   797: istore_1
    //   798: aload_0
    //   799: astore 11
    //   801: iload_1
    //   802: ifne -198 -> 604
    //   805: aload 9
    //   807: astore 11
    //   809: aload_0
    //   810: astore 12
    //   812: goto +23 -> 835
    //   815: astore_0
    //   816: aload 13
    //   818: astore 11
    //   820: goto +219 -> 1039
    //   823: astore 12
    //   825: aload 10
    //   827: astore_0
    //   828: aload 13
    //   830: astore 10
    //   832: goto +40 -> 872
    //   835: aload 11
    //   837: astore 14
    //   839: aload 12
    //   841: astore 15
    //   843: aload 13
    //   845: ifnull +67 -> 912
    //   848: aload 13
    //   850: invokeinterface 106 1 0
    //   855: aload 11
    //   857: astore 14
    //   859: aload 12
    //   861: astore 15
    //   863: goto +49 -> 912
    //   866: astore_0
    //   867: goto +172 -> 1039
    //   870: astore 12
    //   872: aload 10
    //   874: astore 11
    //   876: ldc 86
    //   878: iconst_2
    //   879: ldc 122
    //   881: aload 12
    //   883: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   886: aload 9
    //   888: astore 14
    //   890: aload_0
    //   891: astore 15
    //   893: aload 10
    //   895: ifnull +17 -> 912
    //   898: aload 10
    //   900: invokeinterface 106 1 0
    //   905: aload_0
    //   906: astore 15
    //   908: aload 9
    //   910: astore 14
    //   912: aload 15
    //   914: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifne +119 -> 1036
    //   920: aload 14
    //   922: ifnull +114 -> 1036
    //   925: aload 15
    //   927: invokestatic 133	com/tencent/mobileqq/utils/ImageUtil:c	(Ljava/lang/String;)I
    //   930: istore_2
    //   931: iload_2
    //   932: ifeq +104 -> 1036
    //   935: iload_2
    //   936: bipush 90
    //   938: irem
    //   939: ifne +97 -> 1036
    //   942: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   945: ifeq +34 -> 979
    //   948: new 74	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   955: astore_0
    //   956: aload_0
    //   957: ldc 135
    //   959: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload_0
    //   964: iload_2
    //   965: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: ldc 86
    //   971: iconst_2
    //   972: aload_0
    //   973: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: aload 14
    //   981: invokevirtual 141	android/graphics/Bitmap:getWidth	()I
    //   984: istore_3
    //   985: aload 14
    //   987: invokevirtual 144	android/graphics/Bitmap:getHeight	()I
    //   990: istore 4
    //   992: new 146	android/graphics/Matrix
    //   995: dup
    //   996: invokespecial 147	android/graphics/Matrix:<init>	()V
    //   999: astore_0
    //   1000: aload_0
    //   1001: iload_2
    //   1002: i2f
    //   1003: iload_3
    //   1004: i2f
    //   1005: fconst_2
    //   1006: fdiv
    //   1007: iload 4
    //   1009: i2f
    //   1010: fconst_2
    //   1011: fdiv
    //   1012: invokevirtual 151	android/graphics/Matrix:postRotate	(FFF)Z
    //   1015: pop
    //   1016: aload 14
    //   1018: iconst_0
    //   1019: iconst_0
    //   1020: iload_3
    //   1021: iload 4
    //   1023: aload_0
    //   1024: iconst_1
    //   1025: invokestatic 155	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   1028: astore_0
    //   1029: aload 14
    //   1031: invokevirtual 158	android/graphics/Bitmap:recycle	()V
    //   1034: aload_0
    //   1035: areturn
    //   1036: aload 14
    //   1038: areturn
    //   1039: aload 11
    //   1041: ifnull +10 -> 1051
    //   1044: aload 11
    //   1046: invokeinterface 106 1 0
    //   1051: goto +5 -> 1056
    //   1054: aload_0
    //   1055: athrow
    //   1056: goto -2 -> 1054
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	paramContext	android.content.Context
    //   0	1059	1	paramBoolean	boolean
    //   88	914	2	i	int
    //   984	37	3	j	int
    //   990	32	4	k	int
    //   57	715	5	l1	long
    //   69	701	7	l2	long
    //   65	844	9	localObject1	Object
    //   36	308	10	localContext	android.content.Context
    //   379	1	10	localException1	java.lang.Exception
    //   403	45	10	localObject2	Object
    //   452	1	10	localException2	java.lang.Exception
    //   459	1	10	localObject3	Object
    //   464	14	10	localException3	java.lang.Exception
    //   482	417	10	localObject4	Object
    //   61	984	11	localObject5	Object
    //   54	307	12	localObject6	Object
    //   374	1	12	localException4	java.lang.Exception
    //   395	416	12	localObject7	Object
    //   823	37	12	localException5	java.lang.Exception
    //   870	12	12	localException6	java.lang.Exception
    //   50	799	13	localObject8	Object
    //   211	826	14	localObject9	Object
    //   10	916	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   74	89	374	java/lang/Exception
    //   104	137	374	java/lang/Exception
    //   152	168	374	java/lang/Exception
    //   183	189	374	java/lang/Exception
    //   204	213	374	java/lang/Exception
    //   228	236	374	java/lang/Exception
    //   251	258	374	java/lang/Exception
    //   273	284	374	java/lang/Exception
    //   299	310	374	java/lang/Exception
    //   345	352	374	java/lang/Exception
    //   38	45	379	java/lang/Exception
    //   20	31	452	java/lang/Exception
    //   16	20	457	finally
    //   20	31	457	finally
    //   16	20	464	java/lang/Exception
    //   38	45	524	finally
    //   74	89	524	finally
    //   104	137	524	finally
    //   152	168	524	finally
    //   183	189	524	finally
    //   204	213	524	finally
    //   228	236	524	finally
    //   251	258	524	finally
    //   273	284	524	finally
    //   299	310	524	finally
    //   345	352	524	finally
    //   484	494	524	finally
    //   591	601	815	finally
    //   608	625	815	finally
    //   629	666	815	finally
    //   670	687	815	finally
    //   690	696	815	finally
    //   699	708	815	finally
    //   711	719	815	finally
    //   722	729	815	finally
    //   732	743	815	finally
    //   746	757	815	finally
    //   790	798	815	finally
    //   591	601	823	java/lang/Exception
    //   608	625	823	java/lang/Exception
    //   629	666	823	java/lang/Exception
    //   670	687	823	java/lang/Exception
    //   690	696	823	java/lang/Exception
    //   699	708	823	java/lang/Exception
    //   711	719	823	java/lang/Exception
    //   722	729	823	java/lang/Exception
    //   732	743	823	java/lang/Exception
    //   746	757	823	java/lang/Exception
    //   790	798	823	java/lang/Exception
    //   555	569	866	finally
    //   876	886	866	finally
    //   555	569	870	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraUtil
 * JD-Core Version:    0.7.0.1
 */