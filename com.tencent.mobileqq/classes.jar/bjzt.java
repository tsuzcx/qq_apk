import android.app.Activity;
import java.util.List;
import mqq.observer.BusinessObserver;

class bjzt
  implements BusinessObserver
{
  bjzt(bjzo parambjzo, long paramLong1, bjzb parambjzb, bjpq parambjpq, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3, List paramList, long paramLong2, String paramString4, Activity paramActivity) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 24	bjzt:jdField_a_of_type_Long	J
    //   7: lsub
    //   8: lstore 11
    //   10: aload_3
    //   11: ldc 62
    //   13: invokevirtual 68	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 17
    //   18: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +57 -> 78
    //   24: ldc 76
    //   26: iconst_2
    //   27: new 78	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   34: ldc 81
    //   36: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 17
    //   41: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 87
    //   46: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   53: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 94	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 96
    //   64: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload 11
    //   69: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   82: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload 17
    //   87: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +21 -> 111
    //   93: aload_0
    //   94: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   97: ifnull +13 -> 110
    //   100: aload_0
    //   101: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   104: iconst_0
    //   105: iconst_m1
    //   106: aconst_null
    //   107: invokevirtual 117	bjpq:a	(ZILbjpr;)V
    //   110: return
    //   111: aload_3
    //   112: ldc 119
    //   114: invokevirtual 123	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   117: istore 7
    //   119: iload_2
    //   120: ifeq +803 -> 923
    //   123: iconst_0
    //   124: istore 10
    //   126: iconst_0
    //   127: istore 8
    //   129: iconst_0
    //   130: istore 9
    //   132: aload_0
    //   133: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   136: invokestatic 128	bjzo:a	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   139: aload_0
    //   140: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_0
    //   144: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: new 142	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   154: dup
    //   155: invokespecial 143	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:<init>	()V
    //   158: astore 19
    //   160: iload 10
    //   162: istore 5
    //   164: iload 7
    //   166: istore 6
    //   168: aload 19
    //   170: astore 17
    //   172: aload_3
    //   173: ldc 145
    //   175: invokevirtual 149	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   178: astore 20
    //   180: iload 10
    //   182: istore 5
    //   184: iload 7
    //   186: istore 6
    //   188: aload 19
    //   190: astore 17
    //   192: aload_0
    //   193: getfield 32	bjzt:jdField_a_of_type_Boolean	Z
    //   196: ifeq +1100 -> 1296
    //   199: iload 10
    //   201: istore 5
    //   203: iload 7
    //   205: istore 6
    //   207: aload 19
    //   209: astore 17
    //   211: aload 20
    //   213: aload_0
    //   214: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   217: invokestatic 154	bjzy:b	([BLbjzb;)[B
    //   220: astore 20
    //   222: iload 9
    //   224: istore_1
    //   225: iload 7
    //   227: istore 4
    //   229: aload 19
    //   231: astore 18
    //   233: aload 20
    //   235: ifnull +386 -> 621
    //   238: iload 10
    //   240: istore 5
    //   242: iload 7
    //   244: istore 6
    //   246: aload 19
    //   248: astore 17
    //   250: aload 20
    //   252: arraylength
    //   253: i2l
    //   254: lstore 13
    //   256: iload 10
    //   258: istore 5
    //   260: iload 7
    //   262: istore 6
    //   264: aload 19
    //   266: astore 17
    //   268: aload 19
    //   270: aload 20
    //   272: invokevirtual 158	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   275: checkcast 142	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   278: astore 19
    //   280: iload 9
    //   282: istore_1
    //   283: iload 7
    //   285: istore 4
    //   287: aload 19
    //   289: astore 18
    //   291: aload 19
    //   293: ifnull +328 -> 621
    //   296: iload 10
    //   298: istore 5
    //   300: iload 7
    //   302: istore 6
    //   304: aload 19
    //   306: astore 17
    //   308: aload 19
    //   310: getfield 162	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   313: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   316: istore 4
    //   318: iload 4
    //   320: ifne +971 -> 1291
    //   323: aload_0
    //   324: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   327: aload_0
    //   328: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   331: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   334: aload 19
    //   336: getfield 172	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:expires_in	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   339: invokevirtual 176	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   342: aload 20
    //   344: invokestatic 179	bjzy:a	(Ljava/lang/String;Ljava/lang/String;J[B)V
    //   347: aload_0
    //   348: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   351: ifnull +18 -> 369
    //   354: aload_0
    //   355: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   358: iconst_1
    //   359: iload 4
    //   361: aload 19
    //   363: invokestatic 184	bjpr:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lbjpr;
    //   366: invokevirtual 117	bjpq:a	(ZILbjpr;)V
    //   369: iconst_1
    //   370: istore_1
    //   371: aload 19
    //   373: invokevirtual 188	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:toByteArray	()[B
    //   376: arraylength
    //   377: i2l
    //   378: lstore 15
    //   380: aload 19
    //   382: getfield 162	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   385: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   388: istore 5
    //   390: new 64	android/os/Bundle
    //   393: dup
    //   394: invokespecial 189	android/os/Bundle:<init>	()V
    //   397: astore 17
    //   399: aload 17
    //   401: ldc 191
    //   403: ldc 193
    //   405: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 17
    //   410: ldc 199
    //   412: ldc 201
    //   414: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload_3
    //   418: ldc 203
    //   420: iconst_0
    //   421: invokevirtual 207	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   424: ifeq +385 -> 809
    //   427: ldc 209
    //   429: astore_3
    //   430: aload 17
    //   432: ldc 211
    //   434: aload_3
    //   435: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 17
    //   440: ldc 213
    //   442: aload_0
    //   443: getfield 34	bjzt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   446: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: aload 17
    //   451: ldc 215
    //   453: new 78	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   460: ldc 217
    //   462: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 5
    //   467: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload 17
    //   478: ldc 222
    //   480: new 78	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   487: ldc 217
    //   489: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: lload 11
    //   494: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   497: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 197	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: invokestatic 227	bjqh:a	()Lbjqh;
    //   506: aload 17
    //   508: aload_0
    //   509: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   516: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   519: iconst_0
    //   520: invokevirtual 230	bjqh:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   523: invokestatic 235	bjvn:a	()Lbjvn;
    //   526: ldc 237
    //   528: aload_0
    //   529: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   532: invokestatic 239	bjzo:b	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   535: aload_0
    //   536: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: invokevirtual 242	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   542: checkcast 244	java/lang/Long
    //   545: invokevirtual 247	java/lang/Long:longValue	()J
    //   548: lload 13
    //   550: lload 15
    //   552: iconst_0
    //   553: aload_0
    //   554: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   557: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   560: invokestatic 251	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   563: ldc 253
    //   565: new 78	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   572: ldc 255
    //   574: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 5
    //   579: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokevirtual 258	bjvn:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   588: iconst_0
    //   589: ldc_w 260
    //   592: aload_0
    //   593: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   596: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   599: aload_0
    //   600: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   603: aconst_null
    //   604: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   607: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   610: iload 5
    //   612: iconst_1
    //   613: aconst_null
    //   614: invokestatic 271	bjqq:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   617: aload 19
    //   619: astore 18
    //   621: iload_1
    //   622: istore 5
    //   624: iload 4
    //   626: istore 6
    //   628: aload 18
    //   630: astore 17
    //   632: ldc 76
    //   634: iconst_1
    //   635: new 78	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 273
    //   645: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: getfield 34	bjzt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   652: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 275
    //   658: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   665: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   668: invokestatic 94	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   671: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: ldc_w 277
    //   677: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: iload 4
    //   682: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload 18
    //   693: astore 17
    //   695: iload_1
    //   696: ifne +25 -> 721
    //   699: aload_0
    //   700: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   703: ifnull +18 -> 721
    //   706: aload_0
    //   707: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   710: iconst_0
    //   711: iload 4
    //   713: aload 17
    //   715: invokestatic 184	bjpr:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lbjpr;
    //   718: invokevirtual 117	bjpq:a	(ZILbjpr;)V
    //   721: aload_0
    //   722: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   725: invokestatic 279	bjzo:c	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   728: aload_0
    //   729: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   732: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   735: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   741: pop
    //   742: ldc 76
    //   744: iconst_1
    //   745: new 78	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 281
    //   755: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_0
    //   759: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   762: invokestatic 279	bjzo:c	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   765: aload_0
    //   766: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   769: invokevirtual 242	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   772: checkcast 244	java/lang/Long
    //   775: invokevirtual 247	java/lang/Long:longValue	()J
    //   778: aload_0
    //   779: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   782: invokestatic 239	bjzo:b	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   785: aload_0
    //   786: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   789: invokevirtual 242	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   792: checkcast 244	java/lang/Long
    //   795: invokevirtual 247	java/lang/Long:longValue	()J
    //   798: lsub
    //   799: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: return
    //   809: ldc_w 283
    //   812: astore_3
    //   813: goto -383 -> 430
    //   816: astore_3
    //   817: ldc 76
    //   819: iconst_1
    //   820: ldc_w 285
    //   823: aload_3
    //   824: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   827: aload 19
    //   829: astore 18
    //   831: goto -210 -> 621
    //   834: astore_3
    //   835: iload 6
    //   837: istore 4
    //   839: iload 5
    //   841: istore_1
    //   842: aload_0
    //   843: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   846: ifnull +14 -> 860
    //   849: aload_0
    //   850: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   853: iconst_0
    //   854: iload 4
    //   856: aconst_null
    //   857: invokevirtual 117	bjpq:a	(ZILbjpr;)V
    //   860: ldc 76
    //   862: iconst_1
    //   863: new 78	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   870: ldc_w 273
    //   873: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload_0
    //   877: getfield 34	bjzt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   880: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: ldc_w 275
    //   886: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_0
    //   890: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   893: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   896: invokestatic 94	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   899: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: ldc_w 277
    //   905: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: iload 4
    //   910: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   913: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: aload_3
    //   917: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   920: goto -225 -> 695
    //   923: aload_0
    //   924: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   927: invokestatic 128	bjzo:a	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   930: aload_0
    //   931: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   934: invokevirtual 242	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   937: checkcast 130	java/lang/Integer
    //   940: astore_3
    //   941: aload_3
    //   942: ifnonnull +104 -> 1046
    //   945: iconst_0
    //   946: istore_1
    //   947: iload 7
    //   949: sipush 1002
    //   952: if_icmpne +102 -> 1054
    //   955: iload_1
    //   956: iconst_2
    //   957: if_icmpge +97 -> 1054
    //   960: iload_1
    //   961: iconst_1
    //   962: iadd
    //   963: istore_1
    //   964: ldc 76
    //   966: iconst_1
    //   967: iconst_2
    //   968: anewarray 4	java/lang/Object
    //   971: dup
    //   972: iconst_0
    //   973: ldc_w 290
    //   976: aastore
    //   977: dup
    //   978: iconst_1
    //   979: iload_1
    //   980: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   983: aastore
    //   984: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   987: aload_0
    //   988: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   991: invokestatic 128	bjzo:a	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   994: aload_0
    //   995: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   998: iload_1
    //   999: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1002: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1005: pop
    //   1006: aload_0
    //   1007: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   1010: aload_0
    //   1011: getfield 36	bjzt:jdField_b_of_type_Boolean	Z
    //   1014: aload_0
    //   1015: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1018: aload_0
    //   1019: getfield 38	bjzt:c	Ljava/lang/String;
    //   1022: aload_0
    //   1023: getfield 40	bjzt:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1026: aload_0
    //   1027: getfield 42	bjzt:jdField_b_of_type_Long	J
    //   1030: aload_0
    //   1031: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   1034: aload_0
    //   1035: getfield 44	bjzt:d	Ljava/lang/String;
    //   1038: aload_0
    //   1039: getfield 46	bjzt:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1042: invokevirtual 296	bjzo:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLbjpq;Ljava/lang/String;Landroid/app/Activity;)V
    //   1045: return
    //   1046: aload_3
    //   1047: invokevirtual 299	java/lang/Integer:intValue	()I
    //   1050: istore_1
    //   1051: goto -104 -> 947
    //   1054: aload_0
    //   1055: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   1058: ifnull +14 -> 1072
    //   1061: aload_0
    //   1062: getfield 28	bjzt:jdField_a_of_type_Bjpq	Lbjpq;
    //   1065: iconst_0
    //   1066: iload 7
    //   1068: aconst_null
    //   1069: invokevirtual 117	bjpq:a	(ZILbjpr;)V
    //   1072: invokestatic 235	bjvn:a	()Lbjvn;
    //   1075: ldc 237
    //   1077: aload_0
    //   1078: getfield 22	bjzt:jdField_a_of_type_Bjzo	Lbjzo;
    //   1081: invokestatic 239	bjzo:b	(Lbjzo;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1084: aload_0
    //   1085: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1088: invokevirtual 242	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1091: checkcast 244	java/lang/Long
    //   1094: invokevirtual 247	java/lang/Long:longValue	()J
    //   1097: lconst_0
    //   1098: lconst_0
    //   1099: iload 7
    //   1101: aload_0
    //   1102: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   1105: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1108: invokestatic 251	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1111: ldc 253
    //   1113: ldc 217
    //   1115: invokevirtual 258	bjvn:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   1118: iconst_1
    //   1119: ldc_w 260
    //   1122: aload_0
    //   1123: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   1126: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1129: aload_0
    //   1130: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1133: aconst_null
    //   1134: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   1137: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1140: sipush 3002
    //   1143: iconst_1
    //   1144: ldc 217
    //   1146: invokestatic 271	bjqq:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1149: invokestatic 227	bjqh:a	()Lbjqh;
    //   1152: aload_0
    //   1153: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   1156: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1159: ldc 217
    //   1161: aload_0
    //   1162: getfield 30	bjzt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1165: ldc_w 283
    //   1168: ldc_w 301
    //   1171: new 78	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1178: ldc 217
    //   1180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: sipush 3002
    //   1186: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: iconst_0
    //   1193: invokevirtual 304	bjqh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1196: ldc 76
    //   1198: iconst_1
    //   1199: new 78	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 273
    //   1209: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload_0
    //   1213: getfield 34	bjzt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1216: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: ldc_w 275
    //   1222: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: aload_0
    //   1226: getfield 26	bjzt:jdField_a_of_type_Bjzb	Lbjzb;
    //   1229: getfield 90	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1232: invokestatic 94	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1235: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: ldc_w 306
    //   1241: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: iload 7
    //   1246: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: goto -534 -> 721
    //   1258: astore_3
    //   1259: ldc 76
    //   1261: iconst_1
    //   1262: ldc_w 308
    //   1265: aload_3
    //   1266: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1269: goto -73 -> 1196
    //   1272: astore_3
    //   1273: iload 8
    //   1275: istore_1
    //   1276: aload 19
    //   1278: astore 17
    //   1280: goto -438 -> 842
    //   1283: astore_3
    //   1284: aload 19
    //   1286: astore 17
    //   1288: goto -446 -> 842
    //   1291: iconst_0
    //   1292: istore_1
    //   1293: goto -922 -> 371
    //   1296: goto -1074 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1299	0	this	bjzt
    //   0	1299	1	paramInt	int
    //   0	1299	2	paramBoolean	boolean
    //   0	1299	3	paramBundle	android.os.Bundle
    //   227	682	4	i	int
    //   162	678	5	j	int
    //   166	670	6	k	int
    //   117	1128	7	m	int
    //   127	1147	8	n	int
    //   130	151	9	i1	int
    //   124	173	10	i2	int
    //   8	485	11	l1	long
    //   254	295	13	l2	long
    //   378	173	15	l3	long
    //   16	1271	17	localObject	Object
    //   231	599	18	localAuthorizeResponse1	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   158	1127	19	localAuthorizeResponse2	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   178	165	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   371	427	816	java/lang/Exception
    //   430	617	816	java/lang/Exception
    //   172	180	834	java/lang/Exception
    //   192	199	834	java/lang/Exception
    //   211	222	834	java/lang/Exception
    //   250	256	834	java/lang/Exception
    //   268	280	834	java/lang/Exception
    //   308	318	834	java/lang/Exception
    //   632	691	834	java/lang/Exception
    //   1072	1196	1258	java/lang/Exception
    //   323	369	1272	java/lang/Exception
    //   817	827	1283	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjzt
 * JD-Core Version:    0.7.0.1
 */