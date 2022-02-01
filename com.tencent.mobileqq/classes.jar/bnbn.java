public class bnbn
{
  /* Error */
  public static android.graphics.Bitmap a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +9 -> 10
    //   4: aconst_null
    //   5: astore 12
    //   7: aload 12
    //   9: areturn
    //   10: aload_0
    //   11: invokevirtual 14	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: astore 18
    //   16: aconst_null
    //   17: astore 14
    //   19: iload_1
    //   20: ifeq +993 -> 1013
    //   23: aload 18
    //   25: getstatic 20	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 26	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +964 -> 1001
    //   40: aload_0
    //   41: astore 14
    //   43: aload_0
    //   44: invokeinterface 32 1 0
    //   49: istore_1
    //   50: iload_1
    //   51: ifeq +950 -> 1001
    //   54: aconst_null
    //   55: astore 17
    //   57: lconst_0
    //   58: lstore 5
    //   60: aconst_null
    //   61: astore 16
    //   63: aload_0
    //   64: astore 14
    //   66: aload 17
    //   68: astore 12
    //   70: aload 16
    //   72: astore 13
    //   74: lload 5
    //   76: lstore 9
    //   78: aload_0
    //   79: aload_0
    //   80: ldc 34
    //   82: invokeinterface 38 2 0
    //   87: invokeinterface 42 2 0
    //   92: istore_2
    //   93: aload_0
    //   94: astore 14
    //   96: aload 17
    //   98: astore 12
    //   100: aload 16
    //   102: astore 13
    //   104: lload 5
    //   106: lstore 9
    //   108: aload_0
    //   109: aload_0
    //   110: ldc 44
    //   112: invokeinterface 38 2 0
    //   117: invokeinterface 48 2 0
    //   122: aload_0
    //   123: aload_0
    //   124: ldc 50
    //   126: invokeinterface 38 2 0
    //   131: invokeinterface 48 2 0
    //   136: invokestatic 56	java/lang/Math:max	(JJ)J
    //   139: lstore 7
    //   141: aload_0
    //   142: astore 14
    //   144: aload 17
    //   146: astore 12
    //   148: aload 16
    //   150: astore 13
    //   152: lload 7
    //   154: lstore 9
    //   156: aload_0
    //   157: aload_0
    //   158: ldc 58
    //   160: invokeinterface 38 2 0
    //   165: invokeinterface 62 2 0
    //   170: astore 15
    //   172: aload_0
    //   173: astore 14
    //   175: aload 15
    //   177: astore 12
    //   179: aload 16
    //   181: astore 13
    //   183: lload 7
    //   185: lstore 9
    //   187: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +43 -> 233
    //   193: aload_0
    //   194: astore 14
    //   196: aload 15
    //   198: astore 12
    //   200: aload 16
    //   202: astore 13
    //   204: lload 7
    //   206: lstore 9
    //   208: ldc 69
    //   210: iconst_2
    //   211: new 71	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   218: ldc 77
    //   220: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload_2
    //   224: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: astore 14
    //   236: aload 15
    //   238: astore 12
    //   240: aload 16
    //   242: astore 13
    //   244: lload 7
    //   246: lstore 9
    //   248: aload 18
    //   250: iload_2
    //   251: i2l
    //   252: iconst_3
    //   253: aconst_null
    //   254: invokestatic 98	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   257: astore 11
    //   259: aload 11
    //   261: ifnull +416 -> 677
    //   264: lload 7
    //   266: lstore 5
    //   268: aload 15
    //   270: astore 12
    //   272: aload_0
    //   273: ifnull +711 -> 984
    //   276: aload_0
    //   277: invokeinterface 101 1 0
    //   282: aload 12
    //   284: astore 13
    //   286: aload 11
    //   288: astore 14
    //   290: aload_0
    //   291: astore 12
    //   293: aload 13
    //   295: astore 11
    //   297: aload 14
    //   299: astore_0
    //   300: aload 18
    //   302: getstatic 104	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   305: aconst_null
    //   306: aconst_null
    //   307: aconst_null
    //   308: aconst_null
    //   309: invokevirtual 26	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   312: astore 13
    //   314: aload 13
    //   316: astore 12
    //   318: aload 12
    //   320: ifnull +634 -> 954
    //   323: aload 12
    //   325: astore 13
    //   327: aload 12
    //   329: invokeinterface 32 1 0
    //   334: istore_1
    //   335: iload_1
    //   336: ifeq +618 -> 954
    //   339: aload 11
    //   341: astore 15
    //   343: aload 12
    //   345: astore 13
    //   347: aload 15
    //   349: astore 14
    //   351: aload 12
    //   353: aload 12
    //   355: ldc 34
    //   357: invokeinterface 38 2 0
    //   362: invokeinterface 42 2 0
    //   367: istore_2
    //   368: aload 12
    //   370: astore 13
    //   372: aload 15
    //   374: astore 14
    //   376: aload 12
    //   378: aload 12
    //   380: ldc 44
    //   382: invokeinterface 38 2 0
    //   387: invokeinterface 48 2 0
    //   392: aload 12
    //   394: aload 12
    //   396: ldc 50
    //   398: invokeinterface 38 2 0
    //   403: invokeinterface 48 2 0
    //   408: invokestatic 56	java/lang/Math:max	(JJ)J
    //   411: lstore 7
    //   413: aload 12
    //   415: astore 13
    //   417: aload 15
    //   419: astore 14
    //   421: aload 12
    //   423: aload 12
    //   425: ldc 58
    //   427: invokeinterface 38 2 0
    //   432: invokeinterface 62 2 0
    //   437: astore 11
    //   439: aload 12
    //   441: astore 13
    //   443: aload 11
    //   445: astore 14
    //   447: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +36 -> 486
    //   453: aload 12
    //   455: astore 13
    //   457: aload 11
    //   459: astore 14
    //   461: ldc 69
    //   463: iconst_2
    //   464: new 71	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   471: ldc 106
    //   473: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload_2
    //   477: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload 12
    //   488: astore 13
    //   490: aload 11
    //   492: astore 14
    //   494: aload 18
    //   496: iload_2
    //   497: i2l
    //   498: iconst_3
    //   499: aconst_null
    //   500: invokestatic 109	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   503: astore 15
    //   505: aload 15
    //   507: ifnull +284 -> 791
    //   510: lload 7
    //   512: lload 5
    //   514: lcmp
    //   515: ifle +300 -> 815
    //   518: aload 11
    //   520: astore_0
    //   521: aload 15
    //   523: astore 11
    //   525: aload 12
    //   527: ifnull +414 -> 941
    //   530: aload 12
    //   532: invokeinterface 101 1 0
    //   537: aload 11
    //   539: astore 12
    //   541: aload_0
    //   542: astore 11
    //   544: aload 12
    //   546: astore_0
    //   547: aload_0
    //   548: astore 12
    //   550: aload 11
    //   552: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   555: ifne -548 -> 7
    //   558: aload_0
    //   559: astore 12
    //   561: aload_0
    //   562: ifnull -555 -> 7
    //   565: aload 11
    //   567: invokestatic 120	bgmo:b	(Ljava/lang/String;)I
    //   570: istore_2
    //   571: aload_0
    //   572: astore 12
    //   574: iload_2
    //   575: ifeq -568 -> 7
    //   578: aload_0
    //   579: astore 12
    //   581: iload_2
    //   582: bipush 90
    //   584: irem
    //   585: ifne -578 -> 7
    //   588: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +28 -> 619
    //   594: ldc 69
    //   596: iconst_2
    //   597: new 71	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   604: ldc 122
    //   606: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload_2
    //   610: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload_0
    //   620: invokevirtual 128	android/graphics/Bitmap:getWidth	()I
    //   623: istore_3
    //   624: aload_0
    //   625: invokevirtual 131	android/graphics/Bitmap:getHeight	()I
    //   628: istore 4
    //   630: new 133	android/graphics/Matrix
    //   633: dup
    //   634: invokespecial 134	android/graphics/Matrix:<init>	()V
    //   637: astore 11
    //   639: aload 11
    //   641: iload_2
    //   642: i2f
    //   643: iload_3
    //   644: i2f
    //   645: fconst_2
    //   646: fdiv
    //   647: iload 4
    //   649: i2f
    //   650: fconst_2
    //   651: fdiv
    //   652: invokevirtual 138	android/graphics/Matrix:postRotate	(FFF)Z
    //   655: pop
    //   656: aload_0
    //   657: iconst_0
    //   658: iconst_0
    //   659: iload_3
    //   660: iload 4
    //   662: aload 11
    //   664: iconst_1
    //   665: invokestatic 142	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   668: astore 11
    //   670: aload_0
    //   671: invokevirtual 145	android/graphics/Bitmap:recycle	()V
    //   674: aload 11
    //   676: areturn
    //   677: aload_0
    //   678: astore 14
    //   680: aload 15
    //   682: astore 12
    //   684: aload 11
    //   686: astore 13
    //   688: lload 7
    //   690: lstore 9
    //   692: aload_0
    //   693: invokeinterface 148 1 0
    //   698: istore_1
    //   699: aload 15
    //   701: astore 17
    //   703: aload 11
    //   705: astore 16
    //   707: lload 7
    //   709: lstore 5
    //   711: iload_1
    //   712: ifne -649 -> 63
    //   715: aload 15
    //   717: astore 12
    //   719: lload 7
    //   721: lstore 5
    //   723: goto -451 -> 272
    //   726: astore 14
    //   728: aconst_null
    //   729: astore 12
    //   731: lconst_0
    //   732: lstore 5
    //   734: aconst_null
    //   735: astore 11
    //   737: aconst_null
    //   738: astore_0
    //   739: ldc 69
    //   741: iconst_2
    //   742: ldc 150
    //   744: aload 14
    //   746: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   749: aload_0
    //   750: ifnull +217 -> 967
    //   753: aload_0
    //   754: invokeinterface 101 1 0
    //   759: aload_0
    //   760: astore 13
    //   762: aload 11
    //   764: astore_0
    //   765: aload 12
    //   767: astore 11
    //   769: aload 13
    //   771: astore 12
    //   773: goto -473 -> 300
    //   776: astore_0
    //   777: aload 14
    //   779: ifnull +10 -> 789
    //   782: aload 14
    //   784: invokeinterface 101 1 0
    //   789: aload_0
    //   790: athrow
    //   791: aload 12
    //   793: astore 13
    //   795: aload 11
    //   797: astore 14
    //   799: aload 12
    //   801: invokeinterface 148 1 0
    //   806: istore_1
    //   807: aload 11
    //   809: astore 15
    //   811: iload_1
    //   812: ifne -469 -> 343
    //   815: aload_0
    //   816: astore 13
    //   818: aload 11
    //   820: astore_0
    //   821: aload 13
    //   823: astore 11
    //   825: goto -300 -> 525
    //   828: astore 14
    //   830: aload 12
    //   832: astore 13
    //   834: ldc 69
    //   836: iconst_2
    //   837: ldc 156
    //   839: aload 14
    //   841: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   844: aload 12
    //   846: ifnull +92 -> 938
    //   849: aload 12
    //   851: invokeinterface 101 1 0
    //   856: goto -309 -> 547
    //   859: astore_0
    //   860: aload 12
    //   862: astore 13
    //   864: aload 13
    //   866: ifnull +10 -> 876
    //   869: aload 13
    //   871: invokeinterface 101 1 0
    //   876: aload_0
    //   877: athrow
    //   878: astore_0
    //   879: goto -15 -> 864
    //   882: astore 14
    //   884: goto -54 -> 830
    //   887: astore 13
    //   889: aload 14
    //   891: astore 11
    //   893: aload 13
    //   895: astore 14
    //   897: goto -67 -> 830
    //   900: astore 11
    //   902: aload_0
    //   903: astore 14
    //   905: aload 11
    //   907: astore_0
    //   908: goto -131 -> 777
    //   911: astore 14
    //   913: aconst_null
    //   914: astore 12
    //   916: lconst_0
    //   917: lstore 5
    //   919: aconst_null
    //   920: astore 11
    //   922: goto -183 -> 739
    //   925: astore 14
    //   927: aload 13
    //   929: astore 11
    //   931: lload 9
    //   933: lstore 5
    //   935: goto -196 -> 739
    //   938: goto -391 -> 547
    //   941: aload_0
    //   942: astore 12
    //   944: aload 11
    //   946: astore_0
    //   947: aload 12
    //   949: astore 11
    //   951: goto -404 -> 547
    //   954: aload_0
    //   955: astore 13
    //   957: aload 11
    //   959: astore_0
    //   960: aload 13
    //   962: astore 11
    //   964: goto -439 -> 525
    //   967: aload_0
    //   968: astore 13
    //   970: aload 11
    //   972: astore_0
    //   973: aload 12
    //   975: astore 11
    //   977: aload 13
    //   979: astore 12
    //   981: goto -681 -> 300
    //   984: aload_0
    //   985: astore 13
    //   987: aload 11
    //   989: astore_0
    //   990: aload 12
    //   992: astore 11
    //   994: aload 13
    //   996: astore 12
    //   998: goto -698 -> 300
    //   1001: aconst_null
    //   1002: astore 12
    //   1004: lconst_0
    //   1005: lstore 5
    //   1007: aconst_null
    //   1008: astore 11
    //   1010: goto -738 -> 272
    //   1013: aconst_null
    //   1014: astore_0
    //   1015: aconst_null
    //   1016: astore 11
    //   1018: aconst_null
    //   1019: astore 12
    //   1021: lconst_0
    //   1022: lstore 5
    //   1024: goto -724 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	paramContext	android.content.Context
    //   0	1027	1	paramBoolean	boolean
    //   92	550	2	i	int
    //   623	37	3	j	int
    //   628	33	4	k	int
    //   58	965	5	l1	long
    //   139	581	7	l2	long
    //   76	856	9	l3	long
    //   257	635	11	localObject1	Object
    //   900	6	11	localObject2	Object
    //   920	97	11	localObject3	Object
    //   5	1015	12	localObject4	Object
    //   72	798	13	localObject5	Object
    //   887	41	13	localException1	java.lang.Exception
    //   955	40	13	localContext	android.content.Context
    //   17	662	14	localObject6	Object
    //   726	57	14	localException2	java.lang.Exception
    //   797	1	14	localObject7	Object
    //   828	12	14	localException3	java.lang.Exception
    //   882	8	14	localException4	java.lang.Exception
    //   895	9	14	localObject8	Object
    //   911	1	14	localException5	java.lang.Exception
    //   925	1	14	localException6	java.lang.Exception
    //   170	640	15	localObject9	Object
    //   61	645	16	localObject10	Object
    //   55	647	17	localObject11	Object
    //   14	481	18	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   23	36	726	java/lang/Exception
    //   23	36	776	finally
    //   43	50	776	finally
    //   78	93	776	finally
    //   108	141	776	finally
    //   156	172	776	finally
    //   187	193	776	finally
    //   208	233	776	finally
    //   248	259	776	finally
    //   692	699	776	finally
    //   300	314	828	java/lang/Exception
    //   300	314	859	finally
    //   327	335	878	finally
    //   351	368	878	finally
    //   376	413	878	finally
    //   421	439	878	finally
    //   447	453	878	finally
    //   461	486	878	finally
    //   494	505	878	finally
    //   799	807	878	finally
    //   834	844	878	finally
    //   327	335	882	java/lang/Exception
    //   351	368	887	java/lang/Exception
    //   376	413	887	java/lang/Exception
    //   421	439	887	java/lang/Exception
    //   447	453	887	java/lang/Exception
    //   461	486	887	java/lang/Exception
    //   494	505	887	java/lang/Exception
    //   799	807	887	java/lang/Exception
    //   739	749	900	finally
    //   43	50	911	java/lang/Exception
    //   78	93	925	java/lang/Exception
    //   108	141	925	java/lang/Exception
    //   156	172	925	java/lang/Exception
    //   187	193	925	java/lang/Exception
    //   208	233	925	java/lang/Exception
    //   248	259	925	java/lang/Exception
    //   692	699	925	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbn
 * JD-Core Version:    0.7.0.1
 */