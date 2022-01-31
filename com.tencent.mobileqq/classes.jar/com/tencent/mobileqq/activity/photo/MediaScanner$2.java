package com.tencent.mobileqq.activity.photo;

import agak;
import java.lang.ref.WeakReference;

public class MediaScanner$2
  implements Runnable
{
  public MediaScanner$2(agak paramagak, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
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
    //   19: checkcast 38	agal
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
    //   53: ifeq +449 -> 502
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
    //   225: goto +600 -> 825
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
    //   279: goto +589 -> 868
    //   282: iload_1
    //   283: invokestatic 154	java/lang/Character:isDigit	(C)Z
    //   286: ifne +9 -> 295
    //   289: iload_1
    //   290: bipush 46
    //   292: if_icmpne +100 -> 392
    //   295: aload 11
    //   297: iload_1
    //   298: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: goto +566 -> 868
    //   305: astore 9
    //   307: aload 8
    //   309: invokevirtual 157	android/media/MediaMetadataRetriever:release	()V
    //   312: aload 7
    //   314: aload 6
    //   316: iconst_1
    //   317: invokeinterface 160 3 0
    //   322: invokestatic 166	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   325: invokestatic 171	agak:a	(Landroid/content/Context;)Lagak;
    //   328: invokestatic 174	agak:a	(Lagak;)Lafzy;
    //   331: aload 6
    //   333: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   336: aload 6
    //   338: getfield 84	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   341: invokevirtual 179	afzy:a	(Ljava/lang/String;J)V
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
    //   376: aload 7
    //   378: ifnull +446 -> 824
    //   381: aload 7
    //   383: aload 6
    //   385: iconst_0
    //   386: invokeinterface 160 3 0
    //   391: return
    //   392: ldc 40
    //   394: iconst_2
    //   395: new 112	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   402: ldc 189
    //   404: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 9
    //   409: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc 191
    //   414: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto +445 -> 868
    //   426: aload 11
    //   428: invokevirtual 121	java/lang/StringBuilder:length	()I
    //   431: ifle +25 -> 456
    //   434: aload 10
    //   436: aload 11
    //   438: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 131	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   444: ldc2_w 132
    //   447: dmul
    //   448: d2i
    //   449: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   455: pop
    //   456: aload 10
    //   458: invokevirtual 194	java/util/ArrayList:size	()I
    //   461: iconst_2
    //   462: if_icmplt -155 -> 307
    //   465: aload 6
    //   467: aload 10
    //   469: iconst_0
    //   470: invokevirtual 197	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   473: checkcast 92	java/lang/Integer
    //   476: invokevirtual 200	java/lang/Integer:intValue	()I
    //   479: putfield 203	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   482: aload 6
    //   484: aload 10
    //   486: iconst_1
    //   487: invokevirtual 197	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   490: checkcast 92	java/lang/Integer
    //   493: invokevirtual 200	java/lang/Integer:intValue	()I
    //   496: putfield 206	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   499: goto -192 -> 307
    //   502: new 208	android/media/ExifInterface
    //   505: dup
    //   506: aload 6
    //   508: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   511: invokespecial 210	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   514: astore 11
    //   516: aload 11
    //   518: ldc 212
    //   520: invokevirtual 216	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore 8
    //   525: aload 11
    //   527: ldc 218
    //   529: invokevirtual 216	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   532: astore 9
    //   534: aload 11
    //   536: ldc 220
    //   538: invokevirtual 216	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   541: astore 10
    //   543: aload 11
    //   545: ldc 222
    //   547: invokevirtual 216	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   550: astore 11
    //   552: aload 8
    //   554: ifnull +58 -> 612
    //   557: aload 9
    //   559: ifnull +53 -> 612
    //   562: aload 10
    //   564: ifnull +48 -> 612
    //   567: aload 11
    //   569: ifnull +43 -> 612
    //   572: aload 9
    //   574: ldc 224
    //   576: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   579: ifeq +200 -> 779
    //   582: aload 6
    //   584: aload 8
    //   586: invokestatic 231	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   589: putfield 203	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   592: aload 11
    //   594: ldc 233
    //   596: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   599: ifeq +195 -> 794
    //   602: aload 6
    //   604: aload 10
    //   606: invokestatic 231	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   609: putfield 206	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   612: aload 6
    //   614: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   617: ifeq +11 -> 628
    //   620: aload 6
    //   622: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   625: ifne +143 -> 768
    //   628: ldc 40
    //   630: iconst_2
    //   631: new 112	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   638: ldc 235
    //   640: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: aload 6
    //   645: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   648: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: new 237	android/graphics/BitmapFactory$Options
    //   660: dup
    //   661: invokespecial 238	android/graphics/BitmapFactory$Options:<init>	()V
    //   664: astore 8
    //   666: aload 8
    //   668: iconst_1
    //   669: putfield 242	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   672: aload 6
    //   674: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   677: aload 8
    //   679: invokestatic 248	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   682: pop
    //   683: aload 6
    //   685: aload 8
    //   687: getfield 251	android/graphics/BitmapFactory$Options:outWidth	I
    //   690: putfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   693: aload 6
    //   695: aload 8
    //   697: getfield 254	android/graphics/BitmapFactory$Options:outHeight	I
    //   700: putfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   703: aload 8
    //   705: getfield 257	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   708: astore 8
    //   710: ldc 40
    //   712: iconst_2
    //   713: new 112	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 259
    //   723: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload 6
    //   728: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   731: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: ldc_w 264
    //   737: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 6
    //   742: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   745: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: ldc_w 266
    //   751: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload 6
    //   756: getfield 52	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   759: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: aload 7
    //   770: aload 6
    //   772: iconst_1
    //   773: invokeinterface 160 3 0
    //   778: return
    //   779: aload 6
    //   781: iconst_0
    //   782: aload 8
    //   784: invokestatic 231	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   787: isub
    //   788: putfield 203	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   791: goto -199 -> 592
    //   794: aload 6
    //   796: iconst_0
    //   797: aload 10
    //   799: invokestatic 231	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   802: isub
    //   803: putfield 206	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   806: goto -194 -> 612
    //   809: astore 9
    //   811: goto -644 -> 167
    //   814: astore 9
    //   816: goto -695 -> 121
    //   819: astore 9
    //   821: goto -727 -> 94
    //   824: return
    //   825: iload 4
    //   827: iload 5
    //   829: if_icmpge -403 -> 426
    //   832: aload 12
    //   834: iload 4
    //   836: caload
    //   837: istore_1
    //   838: iload_2
    //   839: iconst_2
    //   840: if_icmpge -414 -> 426
    //   843: iload_1
    //   844: bipush 43
    //   846: if_icmpeq -618 -> 228
    //   849: iload_1
    //   850: bipush 45
    //   852: if_icmpeq -624 -> 228
    //   855: iload_1
    //   856: bipush 10
    //   858: if_icmpeq -630 -> 228
    //   861: iload_1
    //   862: ifne -580 -> 282
    //   865: goto -637 -> 228
    //   868: iload 4
    //   870: iconst_1
    //   871: iadd
    //   872: istore 4
    //   874: goto -49 -> 825
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	877	0	this	2
    //   272	590	1	c	char
    //   221	620	2	i	int
    //   229	49	3	j	int
    //   223	650	4	k	int
    //   218	612	5	m	int
    //   10	785	6	localLocalMediaInfo	LocalMediaInfo
    //   22	747	7	localagal	agal
    //   63	245	8	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   345	18	8	localException	java.lang.Exception
    //   523	260	8	localObject1	Object
    //   82	127	9	str1	java.lang.String
    //   305	103	9	localNumberFormatException1	java.lang.NumberFormatException
    //   532	41	9	str2	java.lang.String
    //   809	1	9	localNumberFormatException2	java.lang.NumberFormatException
    //   814	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   819	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   145	653	10	localObject2	Object
    //   206	387	11	localObject3	Object
    //   213	620	12	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   189	220	305	java/lang/NumberFormatException
    //   230	266	305	java/lang/NumberFormatException
    //   270	277	305	java/lang/NumberFormatException
    //   282	289	305	java/lang/NumberFormatException
    //   295	302	305	java/lang/NumberFormatException
    //   392	423	305	java/lang/NumberFormatException
    //   426	456	305	java/lang/NumberFormatException
    //   456	499	305	java/lang/NumberFormatException
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
    //   392	423	345	java/lang/Exception
    //   426	456	345	java/lang/Exception
    //   456	499	345	java/lang/Exception
    //   502	552	345	java/lang/Exception
    //   572	592	345	java/lang/Exception
    //   592	612	345	java/lang/Exception
    //   612	628	345	java/lang/Exception
    //   628	768	345	java/lang/Exception
    //   768	778	345	java/lang/Exception
    //   779	791	345	java/lang/Exception
    //   794	806	345	java/lang/Exception
    //   147	167	809	java/lang/NumberFormatException
    //   111	121	814	java/lang/NumberFormatException
    //   84	94	819	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner.2
 * JD-Core Version:    0.7.0.1
 */