import android.app.Activity;
import java.util.List;
import mqq.observer.BusinessObserver;

class bifd
  implements BusinessObserver
{
  bifd(biey parambiey, long paramLong1, biej parambiej, String paramString1, boolean paramBoolean1, String paramString2, List paramList, long paramLong2, bhvf parambhvf, String paramString3, Activity paramActivity, boolean paramBoolean2, String paramString4) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 24	bifd:jdField_a_of_type_Long	J
    //   7: lsub
    //   8: lstore 10
    //   10: aload_3
    //   11: ldc 62
    //   13: invokevirtual 68	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 16
    //   18: ldc 70
    //   20: iconst_1
    //   21: new 72	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   28: ldc 75
    //   30: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 16
    //   35: invokestatic 83	bhwf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 85
    //   43: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   50: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: invokestatic 83	bhwf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 90
    //   61: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 10
    //   66: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_3
    //   76: ldc 104
    //   78: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   81: istore 7
    //   83: aload_0
    //   84: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   87: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: aload 16
    //   92: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +154 -> 249
    //   98: aload_0
    //   99: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   102: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   105: aload_0
    //   106: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 127	java/lang/Integer
    //   115: astore_3
    //   116: aload_3
    //   117: ifnonnull +87 -> 204
    //   120: iconst_0
    //   121: istore_1
    //   122: iload 7
    //   124: sipush 1002
    //   127: if_icmpne +85 -> 212
    //   130: iload_1
    //   131: iconst_1
    //   132: if_icmpge +80 -> 212
    //   135: ldc 70
    //   137: iconst_1
    //   138: ldc 129
    //   140: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   147: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   150: aload_0
    //   151: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload_0
    //   165: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   168: aload_0
    //   169: getfield 30	bifd:jdField_a_of_type_Boolean	Z
    //   172: aload_0
    //   173: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   176: aload_0
    //   177: getfield 32	bifd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 34	bifd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   184: aload_0
    //   185: getfield 36	bifd:jdField_b_of_type_Long	J
    //   188: aload_0
    //   189: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   192: aload_0
    //   193: getfield 40	bifd:c	Ljava/lang/String;
    //   196: aload_0
    //   197: getfield 42	bifd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: invokevirtual 140	biey:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLbhvf;Ljava/lang/String;Landroid/app/Activity;)V
    //   203: return
    //   204: aload_3
    //   205: invokevirtual 144	java/lang/Integer:intValue	()I
    //   208: istore_1
    //   209: goto -87 -> 122
    //   212: aload_0
    //   213: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   216: ifnull -13 -> 203
    //   219: aload_0
    //   220: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   223: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   226: aload_0
    //   227: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_0
    //   239: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   242: iconst_0
    //   243: iconst_m1
    //   244: aconst_null
    //   245: invokevirtual 149	bhvf:a	(ZILbhvg;)V
    //   248: return
    //   249: iload_2
    //   250: ifeq +777 -> 1027
    //   253: iconst_0
    //   254: istore 9
    //   256: iconst_0
    //   257: istore 8
    //   259: iconst_0
    //   260: istore_1
    //   261: aload_0
    //   262: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   265: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   268: aload_0
    //   269: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: iconst_0
    //   273: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: new 151	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   283: dup
    //   284: invokespecial 152	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:<init>	()V
    //   287: astore 18
    //   289: iload 9
    //   291: istore 5
    //   293: iload 7
    //   295: istore 6
    //   297: aload 18
    //   299: astore 16
    //   301: aload_3
    //   302: ldc 154
    //   304: invokevirtual 158	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   307: astore 19
    //   309: iload 9
    //   311: istore 5
    //   313: iload 7
    //   315: istore 6
    //   317: aload 18
    //   319: astore 16
    //   321: aload_0
    //   322: getfield 44	bifd:jdField_b_of_type_Boolean	Z
    //   325: ifeq +1078 -> 1403
    //   328: iload 9
    //   330: istore 5
    //   332: iload 7
    //   334: istore 6
    //   336: aload 18
    //   338: astore 16
    //   340: aload 19
    //   342: aload_0
    //   343: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   346: invokestatic 163	bifi:b	([BLbiej;)[B
    //   349: astore 19
    //   351: iload 7
    //   353: istore 4
    //   355: aload 18
    //   357: astore 17
    //   359: aload 19
    //   361: ifnull +368 -> 729
    //   364: iload 9
    //   366: istore 5
    //   368: iload 7
    //   370: istore 6
    //   372: aload 18
    //   374: astore 16
    //   376: aload 19
    //   378: arraylength
    //   379: i2l
    //   380: lstore 12
    //   382: iload 9
    //   384: istore 5
    //   386: iload 7
    //   388: istore 6
    //   390: aload 18
    //   392: astore 16
    //   394: aload 18
    //   396: aload 19
    //   398: invokevirtual 167	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   401: checkcast 151	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   404: astore 17
    //   406: iload 9
    //   408: istore 5
    //   410: iload 7
    //   412: istore 6
    //   414: aload 17
    //   416: astore 16
    //   418: aload 17
    //   420: getfield 171	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   423: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   426: istore 4
    //   428: iload 4
    //   430: ifne +968 -> 1398
    //   433: aload_0
    //   434: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   437: aload_0
    //   438: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   441: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   444: aload 17
    //   446: getfield 179	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:expires_in	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   449: invokevirtual 183	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   452: aload 19
    //   454: invokestatic 186	bifi:a	(Ljava/lang/String;Ljava/lang/String;J[B)V
    //   457: aload_0
    //   458: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   461: ifnull +18 -> 479
    //   464: aload_0
    //   465: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   468: iconst_1
    //   469: iload 4
    //   471: aload 17
    //   473: invokestatic 191	bhvg:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lbhvg;
    //   476: invokevirtual 149	bhvf:a	(ZILbhvg;)V
    //   479: iconst_1
    //   480: istore_1
    //   481: aload 17
    //   483: invokevirtual 195	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:toByteArray	()[B
    //   486: arraylength
    //   487: i2l
    //   488: lstore 14
    //   490: aload 17
    //   492: getfield 171	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore 5
    //   500: new 64	android/os/Bundle
    //   503: dup
    //   504: invokespecial 196	android/os/Bundle:<init>	()V
    //   507: astore 16
    //   509: aload 16
    //   511: ldc 198
    //   513: ldc 200
    //   515: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 16
    //   520: ldc 206
    //   522: ldc 208
    //   524: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_3
    //   528: ldc 210
    //   530: iconst_0
    //   531: invokevirtual 214	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   534: ifeq +383 -> 917
    //   537: ldc 216
    //   539: astore_3
    //   540: aload 16
    //   542: ldc 218
    //   544: aload_3
    //   545: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 16
    //   550: ldc 220
    //   552: aload_0
    //   553: getfield 46	bifd:d	Ljava/lang/String;
    //   556: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 16
    //   561: ldc 222
    //   563: new 72	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   570: ldc 224
    //   572: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload 5
    //   577: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 16
    //   588: ldc 229
    //   590: new 72	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   597: ldc 224
    //   599: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: lload 10
    //   604: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: invokestatic 234	bhvw:a	()Lbhvw;
    //   616: aload 16
    //   618: aload_0
    //   619: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: aload_0
    //   623: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   626: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   629: iconst_0
    //   630: invokevirtual 237	bhvw:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   633: invokestatic 242	biaz:a	()Lbiaz;
    //   636: ldc 244
    //   638: aload_0
    //   639: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   642: invokestatic 246	biey:b	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   645: aload_0
    //   646: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   649: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   652: checkcast 248	java/lang/Long
    //   655: invokevirtual 251	java/lang/Long:longValue	()J
    //   658: lload 12
    //   660: lload 14
    //   662: iconst_0
    //   663: aload_0
    //   664: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   667: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   670: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   673: ldc_w 257
    //   676: new 72	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 259
    //   686: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: iload 5
    //   691: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokevirtual 262	biaz:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   700: iconst_0
    //   701: ldc_w 264
    //   704: aload_0
    //   705: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   708: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   711: aload_0
    //   712: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   715: aconst_null
    //   716: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   719: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: iload 5
    //   724: iconst_1
    //   725: aconst_null
    //   726: invokestatic 275	bhwf:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   729: iload_1
    //   730: istore 5
    //   732: iload 4
    //   734: istore 6
    //   736: aload 17
    //   738: astore 16
    //   740: ldc 70
    //   742: iconst_1
    //   743: new 72	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   750: ldc_w 277
    //   753: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload_0
    //   757: getfield 46	bifd:d	Ljava/lang/String;
    //   760: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: ldc_w 279
    //   766: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_0
    //   770: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   773: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: invokestatic 83	bhwf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   779: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 281
    //   785: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 4
    //   790: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   799: aload 17
    //   801: astore 16
    //   803: iload_1
    //   804: ifne +25 -> 829
    //   807: aload_0
    //   808: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   811: ifnull +18 -> 829
    //   814: aload_0
    //   815: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   818: iconst_0
    //   819: iload 4
    //   821: aload 16
    //   823: invokestatic 191	bhvg:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lbhvg;
    //   826: invokevirtual 149	bhvf:a	(ZILbhvg;)V
    //   829: aload_0
    //   830: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   833: invokestatic 283	biey:c	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   836: aload_0
    //   837: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   843: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   846: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   849: pop
    //   850: ldc 70
    //   852: iconst_1
    //   853: new 72	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 285
    //   863: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   870: invokestatic 283	biey:c	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   873: aload_0
    //   874: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   877: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   880: checkcast 248	java/lang/Long
    //   883: invokevirtual 251	java/lang/Long:longValue	()J
    //   886: aload_0
    //   887: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   890: invokestatic 246	biey:b	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   893: aload_0
    //   894: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   897: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   900: checkcast 248	java/lang/Long
    //   903: invokevirtual 251	java/lang/Long:longValue	()J
    //   906: lsub
    //   907: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   910: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   916: return
    //   917: ldc_w 287
    //   920: astore_3
    //   921: goto -381 -> 540
    //   924: astore_3
    //   925: ldc 70
    //   927: iconst_1
    //   928: ldc_w 289
    //   931: aload_3
    //   932: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   935: goto -206 -> 729
    //   938: astore_3
    //   939: iload 6
    //   941: istore 4
    //   943: iload 5
    //   945: istore_1
    //   946: aload_0
    //   947: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   950: ifnull +14 -> 964
    //   953: aload_0
    //   954: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   957: iconst_0
    //   958: iload 4
    //   960: aconst_null
    //   961: invokevirtual 149	bhvf:a	(ZILbhvg;)V
    //   964: ldc 70
    //   966: iconst_1
    //   967: new 72	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   974: ldc_w 277
    //   977: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload_0
    //   981: getfield 46	bifd:d	Ljava/lang/String;
    //   984: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: ldc_w 279
    //   990: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload_0
    //   994: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   997: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1000: invokestatic 83	bhwf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1003: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: ldc_w 281
    //   1009: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: iload 4
    //   1014: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: aload_3
    //   1021: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1024: goto -221 -> 803
    //   1027: aload_0
    //   1028: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   1031: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1034: aload_0
    //   1035: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1038: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1041: checkcast 127	java/lang/Integer
    //   1044: astore_3
    //   1045: aload_3
    //   1046: ifnonnull +87 -> 1133
    //   1049: iconst_0
    //   1050: istore_1
    //   1051: iload 7
    //   1053: sipush 1002
    //   1056: if_icmpne +85 -> 1141
    //   1059: iload_1
    //   1060: iconst_1
    //   1061: if_icmpge +80 -> 1141
    //   1064: ldc 70
    //   1066: iconst_1
    //   1067: ldc 129
    //   1069: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: aload_0
    //   1073: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   1076: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1079: aload_0
    //   1080: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1083: iload_1
    //   1084: iconst_1
    //   1085: iadd
    //   1086: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1089: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: pop
    //   1093: aload_0
    //   1094: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   1097: aload_0
    //   1098: getfield 30	bifd:jdField_a_of_type_Boolean	Z
    //   1101: aload_0
    //   1102: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1105: aload_0
    //   1106: getfield 32	bifd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1109: aload_0
    //   1110: getfield 34	bifd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1113: aload_0
    //   1114: getfield 36	bifd:jdField_b_of_type_Long	J
    //   1117: aload_0
    //   1118: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   1121: aload_0
    //   1122: getfield 40	bifd:c	Ljava/lang/String;
    //   1125: aload_0
    //   1126: getfield 42	bifd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1129: invokevirtual 140	biey:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLbhvf;Ljava/lang/String;Landroid/app/Activity;)V
    //   1132: return
    //   1133: aload_3
    //   1134: invokevirtual 144	java/lang/Integer:intValue	()I
    //   1137: istore_1
    //   1138: goto -87 -> 1051
    //   1141: aload_0
    //   1142: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   1145: invokestatic 119	biey:a	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1148: aload_0
    //   1149: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1152: iconst_0
    //   1153: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1156: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1159: pop
    //   1160: aload_0
    //   1161: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   1164: ifnull +14 -> 1178
    //   1167: aload_0
    //   1168: getfield 38	bifd:jdField_a_of_type_Bhvf	Lbhvf;
    //   1171: iconst_0
    //   1172: iload 7
    //   1174: aconst_null
    //   1175: invokevirtual 149	bhvf:a	(ZILbhvg;)V
    //   1178: invokestatic 242	biaz:a	()Lbiaz;
    //   1181: ldc 244
    //   1183: aload_0
    //   1184: getfield 22	bifd:jdField_a_of_type_Biey	Lbiey;
    //   1187: invokestatic 246	biey:b	(Lbiey;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1190: aload_0
    //   1191: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1194: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1197: checkcast 248	java/lang/Long
    //   1200: invokevirtual 251	java/lang/Long:longValue	()J
    //   1203: lconst_0
    //   1204: lconst_0
    //   1205: iload 7
    //   1207: aload_0
    //   1208: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   1211: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1214: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1217: ldc_w 257
    //   1220: ldc 224
    //   1222: invokevirtual 262	biaz:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   1225: iconst_1
    //   1226: ldc_w 264
    //   1229: aload_0
    //   1230: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   1233: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1236: aload_0
    //   1237: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1240: aconst_null
    //   1241: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   1244: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1247: sipush 3002
    //   1250: iconst_1
    //   1251: ldc 224
    //   1253: invokestatic 275	bhwf:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1256: invokestatic 234	bhvw:a	()Lbhvw;
    //   1259: aload_0
    //   1260: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   1263: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1266: ldc 224
    //   1268: aload_0
    //   1269: getfield 28	bifd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1272: ldc_w 287
    //   1275: ldc_w 294
    //   1278: new 72	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   1285: ldc 224
    //   1287: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: sipush 3002
    //   1293: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: iconst_0
    //   1300: invokevirtual 297	bhvw:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1303: ldc 70
    //   1305: iconst_1
    //   1306: new 72	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   1313: ldc_w 277
    //   1316: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: aload_0
    //   1320: getfield 46	bifd:d	Ljava/lang/String;
    //   1323: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: ldc_w 279
    //   1329: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: aload_0
    //   1333: getfield 26	bifd:jdField_a_of_type_Biej	Lbiej;
    //   1336: getfield 88	biej:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1339: invokestatic 83	bhwf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1342: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: ldc_w 299
    //   1348: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: iload 7
    //   1353: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1359: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1362: goto -533 -> 829
    //   1365: astore_3
    //   1366: ldc 70
    //   1368: iconst_1
    //   1369: ldc_w 301
    //   1372: aload_3
    //   1373: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1376: goto -73 -> 1303
    //   1379: astore_3
    //   1380: iload 8
    //   1382: istore_1
    //   1383: aload 17
    //   1385: astore 16
    //   1387: goto -441 -> 946
    //   1390: astore_3
    //   1391: aload 17
    //   1393: astore 16
    //   1395: goto -449 -> 946
    //   1398: iconst_0
    //   1399: istore_1
    //   1400: goto -919 -> 481
    //   1403: goto -1052 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	bifd
    //   0	1406	1	paramInt	int
    //   0	1406	2	paramBoolean	boolean
    //   0	1406	3	paramBundle	android.os.Bundle
    //   353	660	4	i	int
    //   291	653	5	j	int
    //   295	645	6	k	int
    //   81	1271	7	m	int
    //   257	1124	8	n	int
    //   254	153	9	i1	int
    //   8	595	10	l1	long
    //   380	279	12	l2	long
    //   488	173	14	l3	long
    //   16	1378	16	localObject	Object
    //   357	1035	17	localAuthorizeResponse1	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   287	108	18	localAuthorizeResponse2	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   307	146	19	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   481	537	924	java/lang/Exception
    //   540	729	924	java/lang/Exception
    //   301	309	938	java/lang/Exception
    //   321	328	938	java/lang/Exception
    //   340	351	938	java/lang/Exception
    //   376	382	938	java/lang/Exception
    //   394	406	938	java/lang/Exception
    //   418	428	938	java/lang/Exception
    //   740	799	938	java/lang/Exception
    //   1178	1303	1365	java/lang/Exception
    //   433	479	1379	java/lang/Exception
    //   925	935	1390	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bifd
 * JD-Core Version:    0.7.0.1
 */