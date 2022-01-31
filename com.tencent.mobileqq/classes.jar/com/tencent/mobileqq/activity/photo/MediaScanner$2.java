package com.tencent.mobileqq.activity.photo;

import agmg;
import java.lang.ref.WeakReference;

public class MediaScanner$2
  implements Runnable
{
  public MediaScanner$2(agmg paramagmg, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/activity/photo/MediaScanner$2:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 36	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 19	com/tencent/mobileqq/activity/photo/MediaScanner$2:b	Ljava/lang/ref/WeakReference;
    //   16: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   19: checkcast 38	agmh
    //   22: astore 7
    //   24: aload 6
    //   26: ifnull +8 -> 34
    //   29: aload 7
    //   31: ifnonnull +12 -> 43
    //   34: ldc 40
    //   36: iconst_2
    //   37: ldc 42
    //   39: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload 6
    //   45: getfield 52	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   48: ldc 54
    //   50: invokevirtual 60	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +478 -> 531
    //   56: new 62	android/media/MediaMetadataRetriever
    //   59: dup
    //   60: invokespecial 63	android/media/MediaMetadataRetriever:<init>	()V
    //   63: astore 8
    //   65: aload 8
    //   67: aload 6
    //   69: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   72: invokevirtual 70	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   75: aload 8
    //   77: bipush 9
    //   79: invokevirtual 74	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   82: astore 9
    //   84: aload 6
    //   86: aload 9
    //   88: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   91: putfield 84	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   94: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   97: bipush 17
    //   99: if_icmplt +22 -> 121
    //   102: aload 8
    //   104: bipush 24
    //   106: invokevirtual 74	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: astore 9
    //   111: aload 6
    //   113: aload 9
    //   115: invokestatic 96	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   118: putfield 99	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   121: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   124: bipush 14
    //   126: if_icmplt +41 -> 167
    //   129: aload 8
    //   131: bipush 18
    //   133: invokevirtual 74	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   136: astore 9
    //   138: aload 8
    //   140: bipush 19
    //   142: invokevirtual 74	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: astore 10
    //   147: aload 6
    //   149: aload 9
    //   151: invokestatic 96	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   154: putfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   157: aload 6
    //   159: aload 10
    //   161: invokestatic 96	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: putfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   167: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   170: bipush 15
    //   172: if_icmplt +135 -> 307
    //   175: aload 8
    //   177: bipush 23
    //   179: invokevirtual 74	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   182: astore 9
    //   184: aload 9
    //   186: ifnull +121 -> 307
    //   189: new 107	java/util/ArrayList
    //   192: dup
    //   193: iconst_3
    //   194: invokespecial 110	java/util/ArrayList:<init>	(I)V
    //   197: astore 10
    //   199: new 112	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   206: astore 11
    //   208: aload 9
    //   210: invokevirtual 117	java/lang/String:toCharArray	()[C
    //   213: astore 12
    //   215: aload 12
    //   217: arraylength
    //   218: istore 5
    //   220: iconst_0
    //   221: istore_2
    //   222: iconst_0
    //   223: istore 4
    //   225: goto +629 -> 854
    //   228: iload_2
    //   229: istore_3
    //   230: aload 11
    //   232: invokevirtual 121	java/lang/StringBuilder:length	()I
    //   235: ifle +35 -> 270
    //   238: aload 10
    //   240: aload 11
    //   242: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 131	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   248: ldc2_w 132
    //   251: dmul
    //   252: d2i
    //   253: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   259: pop
    //   260: aload 11
    //   262: iconst_0
    //   263: invokevirtual 144	java/lang/StringBuilder:setLength	(I)V
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_3
    //   270: aload 11
    //   272: iload_1
    //   273: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: iload_3
    //   278: istore_2
    //   279: goto +618 -> 897
    //   282: iload_1
    //   283: invokestatic 154	java/lang/Character:isDigit	(C)Z
    //   286: ifne +9 -> 295
    //   289: iload_1
    //   290: bipush 46
    //   292: if_icmpne +129 -> 421
    //   295: aload 11
    //   297: iload_1
    //   298: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: goto +595 -> 897
    //   305: astore 9
    //   307: aload 8
    //   309: invokevirtual 157	android/media/MediaMetadataRetriever:release	()V
    //   312: aload 7
    //   314: aload 6
    //   316: iconst_1
    //   317: invokeinterface 160 3 0
    //   322: invokestatic 166	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   325: invokestatic 171	agmg:a	(Landroid/content/Context;)Lagmg;
    //   328: invokestatic 174	agmg:a	(Lagmg;)Laglu;
    //   331: aload 6
    //   333: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   336: aload 6
    //   338: getfield 84	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   341: invokevirtual 179	aglu:a	(Ljava/lang/String;J)V
    //   344: return
    //   345: astore 8
    //   347: ldc 40
    //   349: iconst_2
    //   350: new 112	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   357: ldc 181
    //   359: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 8
    //   364: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: ldc 40
    //   378: iconst_2
    //   379: new 112	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   386: ldc 189
    //   388: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 8
    //   393: invokestatic 195	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   396: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload 7
    //   407: ifnull +446 -> 853
    //   410: aload 7
    //   412: aload 6
    //   414: iconst_0
    //   415: invokeinterface 160 3 0
    //   420: return
    //   421: ldc 40
    //   423: iconst_2
    //   424: new 112	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   431: ldc 197
    //   433: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 9
    //   438: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc 199
    //   443: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: goto +445 -> 897
    //   455: aload 11
    //   457: invokevirtual 121	java/lang/StringBuilder:length	()I
    //   460: ifle +25 -> 485
    //   463: aload 10
    //   465: aload 11
    //   467: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 131	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   473: ldc2_w 132
    //   476: dmul
    //   477: d2i
    //   478: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   481: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   484: pop
    //   485: aload 10
    //   487: invokevirtual 202	java/util/ArrayList:size	()I
    //   490: iconst_2
    //   491: if_icmplt -184 -> 307
    //   494: aload 6
    //   496: aload 10
    //   498: iconst_0
    //   499: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   502: checkcast 92	java/lang/Integer
    //   505: invokevirtual 208	java/lang/Integer:intValue	()I
    //   508: putfield 211	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   511: aload 6
    //   513: aload 10
    //   515: iconst_1
    //   516: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   519: checkcast 92	java/lang/Integer
    //   522: invokevirtual 208	java/lang/Integer:intValue	()I
    //   525: putfield 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   528: goto -221 -> 307
    //   531: new 216	android/media/ExifInterface
    //   534: dup
    //   535: aload 6
    //   537: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   540: invokespecial 218	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   543: astore 11
    //   545: aload 11
    //   547: ldc 220
    //   549: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   552: astore 8
    //   554: aload 11
    //   556: ldc 226
    //   558: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   561: astore 9
    //   563: aload 11
    //   565: ldc 228
    //   567: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   570: astore 10
    //   572: aload 11
    //   574: ldc 230
    //   576: invokevirtual 224	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   579: astore 11
    //   581: aload 8
    //   583: ifnull +58 -> 641
    //   586: aload 9
    //   588: ifnull +53 -> 641
    //   591: aload 10
    //   593: ifnull +48 -> 641
    //   596: aload 11
    //   598: ifnull +43 -> 641
    //   601: aload 9
    //   603: ldc 232
    //   605: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   608: ifeq +200 -> 808
    //   611: aload 6
    //   613: aload 8
    //   615: invokestatic 239	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   618: putfield 211	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   621: aload 11
    //   623: ldc 241
    //   625: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: ifeq +195 -> 823
    //   631: aload 6
    //   633: aload 10
    //   635: invokestatic 239	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   638: putfield 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   641: aload 6
    //   643: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   646: ifeq +11 -> 657
    //   649: aload 6
    //   651: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   654: ifne +143 -> 797
    //   657: ldc 40
    //   659: iconst_2
    //   660: new 112	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   667: ldc 243
    //   669: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 6
    //   674: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   677: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: new 245	android/graphics/BitmapFactory$Options
    //   689: dup
    //   690: invokespecial 246	android/graphics/BitmapFactory$Options:<init>	()V
    //   693: astore 8
    //   695: aload 8
    //   697: iconst_1
    //   698: putfield 250	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   701: aload 6
    //   703: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   706: aload 8
    //   708: invokestatic 256	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   711: pop
    //   712: aload 6
    //   714: aload 8
    //   716: getfield 259	android/graphics/BitmapFactory$Options:outWidth	I
    //   719: putfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   722: aload 6
    //   724: aload 8
    //   726: getfield 262	android/graphics/BitmapFactory$Options:outHeight	I
    //   729: putfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   732: aload 8
    //   734: getfield 265	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   737: astore 8
    //   739: ldc 40
    //   741: iconst_2
    //   742: new 112	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   749: ldc_w 267
    //   752: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload 6
    //   757: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   760: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: ldc_w 272
    //   766: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload 6
    //   771: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   774: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   777: ldc_w 274
    //   780: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 6
    //   785: getfield 52	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   788: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: aload 7
    //   799: aload 6
    //   801: iconst_1
    //   802: invokeinterface 160 3 0
    //   807: return
    //   808: aload 6
    //   810: iconst_0
    //   811: aload 8
    //   813: invokestatic 239	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   816: isub
    //   817: putfield 211	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   820: goto -199 -> 621
    //   823: aload 6
    //   825: iconst_0
    //   826: aload 10
    //   828: invokestatic 239	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   831: isub
    //   832: putfield 214	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   835: goto -194 -> 641
    //   838: astore 9
    //   840: goto -673 -> 167
    //   843: astore 9
    //   845: goto -724 -> 121
    //   848: astore 9
    //   850: goto -756 -> 94
    //   853: return
    //   854: iload 4
    //   856: iload 5
    //   858: if_icmpge -403 -> 455
    //   861: aload 12
    //   863: iload 4
    //   865: caload
    //   866: istore_1
    //   867: iload_2
    //   868: iconst_2
    //   869: if_icmpge -414 -> 455
    //   872: iload_1
    //   873: bipush 43
    //   875: if_icmpeq -647 -> 228
    //   878: iload_1
    //   879: bipush 45
    //   881: if_icmpeq -653 -> 228
    //   884: iload_1
    //   885: bipush 10
    //   887: if_icmpeq -659 -> 228
    //   890: iload_1
    //   891: ifne -609 -> 282
    //   894: goto -666 -> 228
    //   897: iload 4
    //   899: iconst_1
    //   900: iadd
    //   901: istore 4
    //   903: goto -49 -> 854
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	906	0	this	2
    //   272	619	1	c	char
    //   221	649	2	i	int
    //   229	49	3	j	int
    //   223	679	4	k	int
    //   218	641	5	m	int
    //   10	814	6	localLocalMediaInfo	LocalMediaInfo
    //   22	776	7	localagmh	agmh
    //   63	245	8	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   345	47	8	localException	java.lang.Exception
    //   552	260	8	localObject1	Object
    //   82	127	9	str1	java.lang.String
    //   305	132	9	localNumberFormatException1	java.lang.NumberFormatException
    //   561	41	9	str2	java.lang.String
    //   838	1	9	localNumberFormatException2	java.lang.NumberFormatException
    //   843	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   848	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   145	682	10	localObject2	Object
    //   206	416	11	localObject3	Object
    //   213	649	12	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   189	220	305	java/lang/NumberFormatException
    //   230	266	305	java/lang/NumberFormatException
    //   270	277	305	java/lang/NumberFormatException
    //   282	289	305	java/lang/NumberFormatException
    //   295	302	305	java/lang/NumberFormatException
    //   421	452	305	java/lang/NumberFormatException
    //   455	485	305	java/lang/NumberFormatException
    //   485	528	305	java/lang/NumberFormatException
    //   34	42	345	java/lang/Exception
    //   43	84	345	java/lang/Exception
    //   84	94	345	java/lang/Exception
    //   94	111	345	java/lang/Exception
    //   111	121	345	java/lang/Exception
    //   121	147	345	java/lang/Exception
    //   147	167	345	java/lang/Exception
    //   167	184	345	java/lang/Exception
    //   189	220	345	java/lang/Exception
    //   230	266	345	java/lang/Exception
    //   270	277	345	java/lang/Exception
    //   282	289	345	java/lang/Exception
    //   295	302	345	java/lang/Exception
    //   307	344	345	java/lang/Exception
    //   421	452	345	java/lang/Exception
    //   455	485	345	java/lang/Exception
    //   485	528	345	java/lang/Exception
    //   531	581	345	java/lang/Exception
    //   601	621	345	java/lang/Exception
    //   621	641	345	java/lang/Exception
    //   641	657	345	java/lang/Exception
    //   657	797	345	java/lang/Exception
    //   797	807	345	java/lang/Exception
    //   808	820	345	java/lang/Exception
    //   823	835	345	java/lang/Exception
    //   147	167	838	java/lang/NumberFormatException
    //   111	121	843	java/lang/NumberFormatException
    //   84	94	848	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.2
 * JD-Core Version:    0.7.0.1
 */