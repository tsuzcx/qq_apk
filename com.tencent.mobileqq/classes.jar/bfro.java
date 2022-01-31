import android.app.Activity;
import java.util.List;
import mqq.observer.BusinessObserver;

class bfro
  implements BusinessObserver
{
  bfro(bfrj parambfrj, long paramLong1, bfqv parambfqv, bfrs parambfrs, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, List paramList, long paramLong2, String paramString3, Activity paramActivity) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 23	bfro:jdField_a_of_type_Long	J
    //   7: lsub
    //   8: lstore 11
    //   10: aload_3
    //   11: ldc 59
    //   13: invokevirtual 65	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 17
    //   18: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +57 -> 78
    //   24: ldc 73
    //   26: iconst_2
    //   27: new 75	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   34: ldc 78
    //   36: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 17
    //   41: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 84
    //   46: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   53: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 91	bfii:a	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 93
    //   64: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload 11
    //   69: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   82: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload 17
    //   87: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +21 -> 111
    //   93: aload_0
    //   94: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   97: ifnull +13 -> 110
    //   100: aload_0
    //   101: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   104: iconst_0
    //   105: iconst_m1
    //   106: aconst_null
    //   107: invokevirtual 115	bfrs:a	(ZILcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)V
    //   110: return
    //   111: aload_3
    //   112: ldc 117
    //   114: invokevirtual 121	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   117: istore 7
    //   119: aload_0
    //   120: getfield 29	bfro:jdField_a_of_type_Boolean	Z
    //   123: ifne +1177 -> 1300
    //   126: ldc 123
    //   128: astore 20
    //   130: iload_2
    //   131: ifeq +796 -> 927
    //   134: iconst_0
    //   135: istore 10
    //   137: iconst_0
    //   138: istore 8
    //   140: iconst_0
    //   141: istore 9
    //   143: aload_0
    //   144: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   147: invokestatic 128	bfrj:a	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   150: aload_0
    //   151: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_0
    //   155: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: new 142	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   165: dup
    //   166: invokespecial 143	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:<init>	()V
    //   169: astore 19
    //   171: iload 10
    //   173: istore 5
    //   175: iload 7
    //   177: istore 6
    //   179: aload 19
    //   181: astore 17
    //   183: aload_3
    //   184: ldc 145
    //   186: invokevirtual 149	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   189: astore 21
    //   191: iload 10
    //   193: istore 5
    //   195: iload 7
    //   197: istore 6
    //   199: aload 19
    //   201: astore 17
    //   203: aload_0
    //   204: getfield 29	bfro:jdField_a_of_type_Boolean	Z
    //   207: ifne +1090 -> 1297
    //   210: iload 10
    //   212: istore 5
    //   214: iload 7
    //   216: istore 6
    //   218: aload 19
    //   220: astore 17
    //   222: aload 21
    //   224: aload_0
    //   225: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   228: invokestatic 154	bfru:b	([BLbfqv;)[B
    //   231: astore 21
    //   233: iload 9
    //   235: istore_1
    //   236: iload 7
    //   238: istore 4
    //   240: aload 19
    //   242: astore 18
    //   244: aload 21
    //   246: ifnull +386 -> 632
    //   249: iload 10
    //   251: istore 5
    //   253: iload 7
    //   255: istore 6
    //   257: aload 19
    //   259: astore 17
    //   261: aload 21
    //   263: arraylength
    //   264: i2l
    //   265: lstore 13
    //   267: iload 10
    //   269: istore 5
    //   271: iload 7
    //   273: istore 6
    //   275: aload 19
    //   277: astore 17
    //   279: aload 19
    //   281: aload 21
    //   283: invokevirtual 158	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   286: checkcast 142	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   289: astore 19
    //   291: iload 9
    //   293: istore_1
    //   294: iload 7
    //   296: istore 4
    //   298: aload 19
    //   300: astore 18
    //   302: aload 19
    //   304: ifnull +328 -> 632
    //   307: iload 10
    //   309: istore 5
    //   311: iload 7
    //   313: istore 6
    //   315: aload 19
    //   317: astore 17
    //   319: aload 19
    //   321: getfield 162	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   324: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   327: istore 4
    //   329: iload 4
    //   331: ifne +961 -> 1292
    //   334: aload_0
    //   335: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   338: aload_0
    //   339: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   342: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   345: aload 19
    //   347: getfield 172	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:expires_in	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   350: invokevirtual 176	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   353: aload 21
    //   355: invokestatic 179	bfru:a	(Ljava/lang/String;Ljava/lang/String;J[B)V
    //   358: aload_0
    //   359: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   362: ifnull +15 -> 377
    //   365: aload_0
    //   366: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   369: iconst_1
    //   370: iload 4
    //   372: aload 19
    //   374: invokevirtual 115	bfrs:a	(ZILcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)V
    //   377: iconst_1
    //   378: istore_1
    //   379: aload 19
    //   381: invokevirtual 183	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:toByteArray	()[B
    //   384: arraylength
    //   385: i2l
    //   386: lstore 15
    //   388: aload 19
    //   390: getfield 162	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   393: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   396: istore 5
    //   398: new 61	android/os/Bundle
    //   401: dup
    //   402: invokespecial 184	android/os/Bundle:<init>	()V
    //   405: astore 17
    //   407: aload 17
    //   409: ldc 186
    //   411: ldc 188
    //   413: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload 17
    //   418: ldc 194
    //   420: ldc 196
    //   422: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload_3
    //   426: ldc 198
    //   428: iconst_0
    //   429: invokevirtual 202	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   432: ifeq +383 -> 815
    //   435: ldc 204
    //   437: astore_3
    //   438: aload 17
    //   440: ldc 206
    //   442: aload_3
    //   443: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload 17
    //   448: ldc 208
    //   450: aload_0
    //   451: getfield 33	bfro:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   454: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 17
    //   459: ldc 210
    //   461: new 75	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   468: ldc 212
    //   470: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: iload 5
    //   475: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload 17
    //   486: ldc 217
    //   488: new 75	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   495: ldc 212
    //   497: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: lload 11
    //   502: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: invokestatic 222	bfhz:a	()Lbfhz;
    //   514: aload 17
    //   516: aload_0
    //   517: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   520: aload_0
    //   521: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   524: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   527: iconst_0
    //   528: invokevirtual 225	bfhz:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   531: invokestatic 230	bfng:a	()Lbfng;
    //   534: ldc 232
    //   536: aload_0
    //   537: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   540: invokestatic 234	bfrj:b	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   543: aload_0
    //   544: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   547: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   550: checkcast 239	java/lang/Long
    //   553: invokevirtual 242	java/lang/Long:longValue	()J
    //   556: lload 13
    //   558: lload 15
    //   560: iconst_0
    //   561: aload_0
    //   562: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   565: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: invokestatic 246	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   571: ldc 248
    //   573: new 75	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   580: ldc 250
    //   582: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: iload 5
    //   587: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 253	bfng:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   596: invokestatic 258	bfnj:a	()Lbfnj;
    //   599: iconst_0
    //   600: ldc_w 260
    //   603: aload_0
    //   604: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   607: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   610: aload_0
    //   611: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   614: aconst_null
    //   615: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   618: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: iload 5
    //   623: iconst_1
    //   624: aconst_null
    //   625: invokevirtual 271	bfnj:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   628: aload 19
    //   630: astore 18
    //   632: iload_1
    //   633: istore 5
    //   635: iload 4
    //   637: istore 6
    //   639: aload 18
    //   641: astore 17
    //   643: ldc 73
    //   645: iconst_1
    //   646: new 75	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 273
    //   656: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 20
    //   661: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 275
    //   667: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_0
    //   671: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   674: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   677: invokestatic 91	bfii:a	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 277
    //   686: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: iload 4
    //   691: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: aload 18
    //   702: astore 17
    //   704: iload_1
    //   705: ifne +22 -> 727
    //   708: aload_0
    //   709: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   712: ifnull +15 -> 727
    //   715: aload_0
    //   716: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   719: iconst_0
    //   720: iload 4
    //   722: aload 17
    //   724: invokevirtual 115	bfrs:a	(ZILcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)V
    //   727: aload_0
    //   728: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   731: invokestatic 279	bfrj:c	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   734: aload_0
    //   735: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   738: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   741: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   744: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   747: pop
    //   748: ldc 73
    //   750: iconst_1
    //   751: new 75	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 281
    //   761: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_0
    //   765: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   768: invokestatic 279	bfrj:c	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   771: aload_0
    //   772: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   775: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   778: checkcast 239	java/lang/Long
    //   781: invokevirtual 242	java/lang/Long:longValue	()J
    //   784: aload_0
    //   785: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   788: invokestatic 234	bfrj:b	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   791: aload_0
    //   792: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   795: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   798: checkcast 239	java/lang/Long
    //   801: invokevirtual 242	java/lang/Long:longValue	()J
    //   804: lsub
    //   805: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   808: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: return
    //   815: ldc_w 283
    //   818: astore_3
    //   819: goto -381 -> 438
    //   822: astore_3
    //   823: ldc 73
    //   825: iconst_1
    //   826: ldc_w 285
    //   829: aload_3
    //   830: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   833: aload 19
    //   835: astore 18
    //   837: goto -205 -> 632
    //   840: astore_3
    //   841: iload 6
    //   843: istore 4
    //   845: iload 5
    //   847: istore_1
    //   848: aload_0
    //   849: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   852: ifnull +14 -> 866
    //   855: aload_0
    //   856: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   859: iconst_0
    //   860: iload 4
    //   862: aconst_null
    //   863: invokevirtual 115	bfrs:a	(ZILcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)V
    //   866: ldc 73
    //   868: iconst_1
    //   869: new 75	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 273
    //   879: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 20
    //   884: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: ldc_w 275
    //   890: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload_0
    //   894: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   897: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   900: invokestatic 91	bfii:a	(Ljava/lang/String;)Ljava/lang/String;
    //   903: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: ldc_w 277
    //   909: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: iload 4
    //   914: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   917: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: aload_3
    //   921: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   924: goto -220 -> 704
    //   927: aload_0
    //   928: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   931: invokestatic 128	bfrj:a	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   934: aload_0
    //   935: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   938: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   941: checkcast 130	java/lang/Integer
    //   944: astore_3
    //   945: aload_3
    //   946: ifnonnull +100 -> 1046
    //   949: iconst_0
    //   950: istore_1
    //   951: iload 7
    //   953: sipush 1002
    //   956: if_icmpne +98 -> 1054
    //   959: iload_1
    //   960: iconst_2
    //   961: if_icmpge +93 -> 1054
    //   964: iload_1
    //   965: iconst_1
    //   966: iadd
    //   967: istore_1
    //   968: ldc 73
    //   970: iconst_1
    //   971: iconst_2
    //   972: anewarray 4	java/lang/Object
    //   975: dup
    //   976: iconst_0
    //   977: ldc_w 290
    //   980: aastore
    //   981: dup
    //   982: iconst_1
    //   983: iload_1
    //   984: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   987: aastore
    //   988: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   991: aload_0
    //   992: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   995: invokestatic 128	bfrj:a	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   998: aload_0
    //   999: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1002: iload_1
    //   1003: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1006: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1009: pop
    //   1010: aload_0
    //   1011: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   1014: aload_0
    //   1015: getfield 35	bfro:jdField_b_of_type_Boolean	Z
    //   1018: aload_0
    //   1019: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1022: aload_0
    //   1023: getfield 37	bfro:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1026: aload_0
    //   1027: getfield 39	bfro:jdField_b_of_type_Long	J
    //   1030: aload_0
    //   1031: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   1034: aload_0
    //   1035: getfield 41	bfro:c	Ljava/lang/String;
    //   1038: aload_0
    //   1039: getfield 43	bfro:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1042: invokevirtual 296	bfrj:a	(ZLjava/lang/String;Ljava/util/List;JLbfrs;Ljava/lang/String;Landroid/app/Activity;)V
    //   1045: return
    //   1046: aload_3
    //   1047: invokevirtual 299	java/lang/Integer:intValue	()I
    //   1050: istore_1
    //   1051: goto -100 -> 951
    //   1054: aload_0
    //   1055: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   1058: ifnull +14 -> 1072
    //   1061: aload_0
    //   1062: getfield 27	bfro:jdField_a_of_type_Bfrs	Lbfrs;
    //   1065: iconst_0
    //   1066: iload 7
    //   1068: aconst_null
    //   1069: invokevirtual 115	bfrs:a	(ZILcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)V
    //   1072: invokestatic 230	bfng:a	()Lbfng;
    //   1075: ldc 232
    //   1077: aload_0
    //   1078: getfield 21	bfro:jdField_a_of_type_Bfrj	Lbfrj;
    //   1081: invokestatic 234	bfrj:b	(Lbfrj;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1084: aload_0
    //   1085: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1088: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1091: checkcast 239	java/lang/Long
    //   1094: invokevirtual 242	java/lang/Long:longValue	()J
    //   1097: lconst_0
    //   1098: lconst_0
    //   1099: iload 7
    //   1101: aload_0
    //   1102: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   1105: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1108: invokestatic 246	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1111: ldc 248
    //   1113: ldc 212
    //   1115: invokevirtual 253	bfng:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   1118: invokestatic 258	bfnj:a	()Lbfnj;
    //   1121: iconst_1
    //   1122: ldc_w 260
    //   1125: aload_0
    //   1126: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   1129: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1132: aload_0
    //   1133: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1136: aconst_null
    //   1137: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   1140: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1143: sipush 3002
    //   1146: iconst_1
    //   1147: ldc 212
    //   1149: invokevirtual 271	bfnj:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1152: invokestatic 222	bfhz:a	()Lbfhz;
    //   1155: aload_0
    //   1156: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   1159: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1162: ldc 212
    //   1164: aload_0
    //   1165: getfield 31	bfro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1168: ldc_w 283
    //   1171: ldc_w 301
    //   1174: new 75	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1181: ldc 212
    //   1183: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: sipush 3002
    //   1189: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: iconst_0
    //   1196: invokevirtual 304	bfhz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1199: ldc 73
    //   1201: iconst_1
    //   1202: new 75	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 273
    //   1212: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 20
    //   1217: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: ldc_w 275
    //   1223: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: aload_0
    //   1227: getfield 25	bfro:jdField_a_of_type_Bfqv	Lbfqv;
    //   1230: getfield 87	bfqv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1233: invokestatic 91	bfii:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1236: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: ldc_w 306
    //   1242: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: iload 7
    //   1247: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: goto -529 -> 727
    //   1259: astore_3
    //   1260: ldc 73
    //   1262: iconst_1
    //   1263: ldc_w 308
    //   1266: aload_3
    //   1267: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1270: goto -71 -> 1199
    //   1273: astore_3
    //   1274: iload 8
    //   1276: istore_1
    //   1277: aload 19
    //   1279: astore 17
    //   1281: goto -433 -> 848
    //   1284: astore_3
    //   1285: aload 19
    //   1287: astore 17
    //   1289: goto -441 -> 848
    //   1292: iconst_0
    //   1293: istore_1
    //   1294: goto -915 -> 379
    //   1297: goto -1064 -> 233
    //   1300: ldc_w 310
    //   1303: astore 20
    //   1305: goto -1175 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1308	0	this	bfro
    //   0	1308	1	paramInt	int
    //   0	1308	2	paramBoolean	boolean
    //   0	1308	3	paramBundle	android.os.Bundle
    //   238	675	4	i	int
    //   173	673	5	j	int
    //   177	665	6	k	int
    //   117	1129	7	m	int
    //   138	1137	8	n	int
    //   141	151	9	i1	int
    //   135	173	10	i2	int
    //   8	493	11	l1	long
    //   265	292	13	l2	long
    //   386	173	15	l3	long
    //   16	1272	17	localObject	Object
    //   242	594	18	localAuthorizeResponse1	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   169	1117	19	localAuthorizeResponse2	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   128	1176	20	str	String
    //   189	165	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   379	435	822	java/lang/Exception
    //   438	628	822	java/lang/Exception
    //   183	191	840	java/lang/Exception
    //   203	210	840	java/lang/Exception
    //   222	233	840	java/lang/Exception
    //   261	267	840	java/lang/Exception
    //   279	291	840	java/lang/Exception
    //   319	329	840	java/lang/Exception
    //   643	700	840	java/lang/Exception
    //   1072	1199	1259	java/lang/Exception
    //   334	377	1273	java/lang/Exception
    //   823	833	1284	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfro
 * JD-Core Version:    0.7.0.1
 */