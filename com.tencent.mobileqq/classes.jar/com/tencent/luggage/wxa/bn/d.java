package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import org.json.JSONObject;

public class d
  extends a<h>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  /* Error */
  public static com.tencent.luggage.wxa.ku.f.a a(com.tencent.mm.plugin.appbrand.page.u paramu, JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 33
    //   3: invokevirtual 39	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore 15
    //   8: aload_0
    //   9: ifnonnull +17 -> 26
    //   12: new 41	com/tencent/luggage/wxa/ku/f$a
    //   15: dup
    //   16: ldc 43
    //   18: iconst_0
    //   19: anewarray 45	java/lang/Object
    //   22: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: areturn
    //   26: aload_0
    //   27: ldc 50
    //   29: invokevirtual 56	com/tencent/mm/plugin/appbrand/page/u:d	(Ljava/lang/Class;)Ljava/lang/Object;
    //   32: checkcast 50	com/tencent/luggage/wxa/bs/c
    //   35: astore 25
    //   37: aload_1
    //   38: ldc 58
    //   40: iconst_0
    //   41: invokevirtual 62	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   44: istore 22
    //   46: aload 25
    //   48: ifnull +1514 -> 1562
    //   51: aload 25
    //   53: invokeinterface 65 1 0
    //   58: ifnull +1504 -> 1562
    //   61: iload 22
    //   63: ifne +18 -> 81
    //   66: aload 25
    //   68: iload 15
    //   70: iload_2
    //   71: invokeinterface 68 3 0
    //   76: astore 25
    //   78: goto +36 -> 114
    //   81: aload 25
    //   83: invokeinterface 65 1 0
    //   88: invokevirtual 74	com/tencent/magicbrush/ui/i:getMagicBrush	()Lcom/tencent/magicbrush/e;
    //   91: invokevirtual 80	com/tencent/magicbrush/e:u	()Lcom/tencent/magicbrush/b;
    //   94: aload 25
    //   96: invokeinterface 65 1 0
    //   101: invokevirtual 84	com/tencent/magicbrush/ui/i:getVirtualElementId	()I
    //   104: iconst_m1
    //   105: iconst_1
    //   106: invokevirtual 89	com/tencent/magicbrush/b:a	(IIZ)Landroid/graphics/Bitmap;
    //   109: astore 25
    //   111: goto +3 -> 114
    //   114: aload 25
    //   116: ifnonnull +58 -> 174
    //   119: ldc 91
    //   121: ldc 93
    //   123: invokestatic 99	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 101
    //   128: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   131: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   134: astore_0
    //   135: iload 22
    //   137: ifeq +1431 -> 1568
    //   140: ldc2_w 108
    //   143: lstore 23
    //   145: goto +3 -> 148
    //   148: aload_0
    //   149: ldc2_w 110
    //   152: lload 23
    //   154: lconst_1
    //   155: invokeinterface 114 7 0
    //   160: new 41	com/tencent/luggage/wxa/ku/f$a
    //   163: dup
    //   164: ldc 116
    //   166: iconst_0
    //   167: anewarray 45	java/lang/Object
    //   170: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: areturn
    //   174: aload 25
    //   176: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   179: i2f
    //   180: fstore 11
    //   182: aload 25
    //   184: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   187: i2f
    //   188: fstore 12
    //   190: aload 25
    //   192: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   195: i2f
    //   196: fstore 14
    //   198: aload 25
    //   200: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   203: i2f
    //   204: fstore 13
    //   206: ldc 91
    //   208: ldc 126
    //   210: iconst_4
    //   211: anewarray 45	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: fload 11
    //   218: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: fload 12
    //   226: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: fload 14
    //   234: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   237: aastore
    //   238: dup
    //   239: iconst_3
    //   240: fload 13
    //   242: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   245: aastore
    //   246: invokestatic 135	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload_1
    //   250: ldc 137
    //   252: dconst_0
    //   253: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   256: d2f
    //   257: fstore 8
    //   259: aload_1
    //   260: ldc 143
    //   262: dconst_0
    //   263: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   266: d2f
    //   267: fstore 7
    //   269: aload_1
    //   270: ldc 145
    //   272: fload 14
    //   274: f2d
    //   275: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   278: d2f
    //   279: fstore 10
    //   281: aload_1
    //   282: ldc 147
    //   284: fload 13
    //   286: f2d
    //   287: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   290: d2f
    //   291: fstore 9
    //   293: ldc 91
    //   295: ldc 149
    //   297: iconst_4
    //   298: anewarray 45	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: fload 8
    //   305: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: fload 7
    //   313: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: fload 10
    //   321: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   324: aastore
    //   325: dup
    //   326: iconst_3
    //   327: fload 9
    //   329: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   332: aastore
    //   333: invokestatic 135	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: fload 7
    //   338: fstore 5
    //   340: fload 10
    //   342: fstore 4
    //   344: fload 8
    //   346: fstore 6
    //   348: fload 9
    //   350: fstore_3
    //   351: fload 14
    //   353: fconst_0
    //   354: fcmpl
    //   355: ifle +1221 -> 1576
    //   358: fload 7
    //   360: fstore 5
    //   362: fload 10
    //   364: fstore 4
    //   366: fload 8
    //   368: fstore 6
    //   370: fload 9
    //   372: fstore_3
    //   373: fload 13
    //   375: fconst_0
    //   376: fcmpl
    //   377: ifle +1199 -> 1576
    //   380: fload 11
    //   382: fload 14
    //   384: fcmpl
    //   385: ifne +26 -> 411
    //   388: fload 7
    //   390: fstore 5
    //   392: fload 10
    //   394: fstore 4
    //   396: fload 8
    //   398: fstore 6
    //   400: fload 9
    //   402: fstore_3
    //   403: fload 12
    //   405: fload 13
    //   407: fcmpl
    //   408: ifeq +1168 -> 1576
    //   411: fload 8
    //   413: fstore_3
    //   414: fload 8
    //   416: fconst_0
    //   417: fcmpl
    //   418: ifle +12 -> 430
    //   421: fload 8
    //   423: fload 14
    //   425: fdiv
    //   426: fload 11
    //   428: fmul
    //   429: fstore_3
    //   430: fload 7
    //   432: fstore 4
    //   434: fload 7
    //   436: fconst_0
    //   437: fcmpl
    //   438: ifle +13 -> 451
    //   441: fload 7
    //   443: fload 13
    //   445: fdiv
    //   446: fload 12
    //   448: fmul
    //   449: fstore 4
    //   451: fload 10
    //   453: fload 14
    //   455: fdiv
    //   456: fload 11
    //   458: fmul
    //   459: fstore 6
    //   461: fload 9
    //   463: fload 13
    //   465: fdiv
    //   466: fload 12
    //   468: fmul
    //   469: fstore 7
    //   471: fload 4
    //   473: fstore 5
    //   475: fload 6
    //   477: fstore 4
    //   479: fload_3
    //   480: fstore 6
    //   482: fload 7
    //   484: fstore_3
    //   485: goto +1091 -> 1576
    //   488: aload_1
    //   489: ldc 151
    //   491: fload 7
    //   493: f2d
    //   494: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   497: d2f
    //   498: fstore_3
    //   499: aload_1
    //   500: ldc 153
    //   502: fload 4
    //   504: f2d
    //   505: invokevirtual 141	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   508: d2f
    //   509: fstore 8
    //   511: ldc 91
    //   513: ldc 155
    //   515: bipush 8
    //   517: anewarray 45	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: fload 6
    //   524: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: fload 5
    //   532: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   535: aastore
    //   536: dup
    //   537: iconst_2
    //   538: fload 11
    //   540: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   543: aastore
    //   544: dup
    //   545: iconst_3
    //   546: fload 12
    //   548: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   551: aastore
    //   552: dup
    //   553: iconst_4
    //   554: fload 7
    //   556: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   559: aastore
    //   560: dup
    //   561: iconst_5
    //   562: fload 4
    //   564: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   567: aastore
    //   568: dup
    //   569: bipush 6
    //   571: fload_3
    //   572: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   575: aastore
    //   576: dup
    //   577: bipush 7
    //   579: fload 8
    //   581: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   584: aastore
    //   585: invokestatic 135	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: fload 6
    //   590: f2i
    //   591: istore 18
    //   593: iload 18
    //   595: iflt +1067 -> 1662
    //   598: fload 5
    //   600: f2i
    //   601: istore 19
    //   603: iload 19
    //   605: iflt +1057 -> 1662
    //   608: fload 7
    //   610: f2i
    //   611: istore 20
    //   613: iload 20
    //   615: ifle +1047 -> 1662
    //   618: fload 4
    //   620: f2i
    //   621: istore 21
    //   623: iload 21
    //   625: ifle +1037 -> 1662
    //   628: fload 6
    //   630: fload 7
    //   632: fadd
    //   633: f2i
    //   634: fload 11
    //   636: f2i
    //   637: if_icmpgt +1025 -> 1662
    //   640: fload 5
    //   642: fload 4
    //   644: fadd
    //   645: f2i
    //   646: fload 12
    //   648: f2i
    //   649: if_icmpgt +1013 -> 1662
    //   652: fload_3
    //   653: f2i
    //   654: istore 16
    //   656: iload 16
    //   658: ifle +1004 -> 1662
    //   661: fload 8
    //   663: f2i
    //   664: istore 17
    //   666: iload 17
    //   668: ifgt +953 -> 1621
    //   671: goto +669 -> 1340
    //   674: aload 25
    //   676: iload 18
    //   678: iload 19
    //   680: iload 20
    //   682: iload 21
    //   684: aconst_null
    //   685: iconst_0
    //   686: invokestatic 159	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   689: astore 26
    //   691: aload 25
    //   693: invokevirtual 162	android/graphics/Bitmap:recycle	()V
    //   696: aload 26
    //   698: astore 25
    //   700: aload 25
    //   702: ifnonnull +24 -> 726
    //   705: ldc 91
    //   707: ldc 164
    //   709: invokestatic 166	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: new 41	com/tencent/luggage/wxa/ku/f$a
    //   715: dup
    //   716: ldc 168
    //   718: iconst_0
    //   719: anewarray 45	java/lang/Object
    //   722: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: areturn
    //   726: aload 25
    //   728: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   731: ifle +587 -> 1318
    //   734: aload 25
    //   736: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   739: istore 18
    //   741: iload 18
    //   743: ifgt +6 -> 749
    //   746: goto +572 -> 1318
    //   749: fload 7
    //   751: fload_3
    //   752: fcmpl
    //   753: ifne +15 -> 768
    //   756: aload 25
    //   758: astore 26
    //   760: fload 4
    //   762: fload 8
    //   764: fcmpl
    //   765: ifeq +77 -> 842
    //   768: aload 25
    //   770: iload 16
    //   772: iload 17
    //   774: iconst_0
    //   775: invokestatic 172	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   778: astore 26
    //   780: aload 25
    //   782: invokevirtual 162	android/graphics/Bitmap:recycle	()V
    //   785: aload 26
    //   787: ifnonnull +55 -> 842
    //   790: ldc 101
    //   792: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   795: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   798: ldc2_w 110
    //   801: ldc2_w 173
    //   804: lconst_1
    //   805: invokeinterface 114 7 0
    //   810: new 41	com/tencent/luggage/wxa/ku/f$a
    //   813: dup
    //   814: ldc 176
    //   816: iconst_0
    //   817: anewarray 45	java/lang/Object
    //   820: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   823: astore_0
    //   824: aload_0
    //   825: areturn
    //   826: astore_0
    //   827: aload 26
    //   829: astore 25
    //   831: goto +294 -> 1125
    //   834: astore_0
    //   835: aload 26
    //   837: astore 25
    //   839: goto +383 -> 1222
    //   842: aload_1
    //   843: invokestatic 181	com/tencent/luggage/wxa/kq/c:b	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   846: astore 27
    //   848: aload 26
    //   850: astore 25
    //   852: aload 27
    //   854: getstatic 187	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   857: if_acmpne +38 -> 895
    //   860: aload 26
    //   862: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   865: aload 26
    //   867: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   870: getstatic 193	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   873: invokestatic 196	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   876: astore 25
    //   878: new 198	android/graphics/Canvas
    //   881: dup
    //   882: aload 25
    //   884: invokespecial 201	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   887: aload 26
    //   889: fconst_0
    //   890: fconst_0
    //   891: aconst_null
    //   892: invokevirtual 205	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   895: aload_0
    //   896: invokevirtual 209	com/tencent/mm/plugin/appbrand/page/u:getAppId	()Ljava/lang/String;
    //   899: astore 26
    //   901: new 211	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   908: astore 28
    //   910: aload 28
    //   912: ldc 214
    //   914: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 28
    //   920: iload 15
    //   922: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 26
    //   928: aload 28
    //   930: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 230	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:genMediaFilePath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   936: astore 26
    //   938: aload 25
    //   940: aload_1
    //   941: invokestatic 233	com/tencent/luggage/wxa/kq/c:a	(Lorg/json/JSONObject;)I
    //   944: aload 27
    //   946: aload 26
    //   948: iconst_1
    //   949: invokestatic 238	com/tencent/luggage/wxa/qz/b:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   952: aload_0
    //   953: invokevirtual 209	com/tencent/mm/plugin/appbrand/page/u:getAppId	()Ljava/lang/String;
    //   956: astore_1
    //   957: aload 27
    //   959: getstatic 241	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   962: if_acmpne +685 -> 1647
    //   965: ldc 243
    //   967: astore_0
    //   968: goto +3 -> 971
    //   971: aload_1
    //   972: aload 26
    //   974: aload_0
    //   975: iconst_1
    //   976: invokestatic 246	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/appstorage/d;
    //   979: astore_0
    //   980: aload_0
    //   981: ifnonnull +37 -> 1018
    //   984: ldc 91
    //   986: ldc 248
    //   988: iconst_1
    //   989: anewarray 45	java/lang/Object
    //   992: dup
    //   993: iconst_0
    //   994: iload 15
    //   996: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   999: aastore
    //   1000: invokestatic 255	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1003: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1006: dup
    //   1007: ldc_w 257
    //   1010: iconst_0
    //   1011: anewarray 45	java/lang/Object
    //   1014: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1017: areturn
    //   1018: new 259	java/util/HashMap
    //   1021: dup
    //   1022: invokespecial 260	java/util/HashMap:<init>	()V
    //   1025: astore_1
    //   1026: aload_1
    //   1027: ldc_w 262
    //   1030: aload_0
    //   1031: getfield 266	com/tencent/mm/plugin/appbrand/appstorage/d:a	Ljava/lang/String;
    //   1034: invokeinterface 272 3 0
    //   1039: pop
    //   1040: ldc 91
    //   1042: ldc_w 274
    //   1045: iconst_2
    //   1046: anewarray 45	java/lang/Object
    //   1049: dup
    //   1050: iconst_0
    //   1051: aload_0
    //   1052: getfield 266	com/tencent/mm/plugin/appbrand/appstorage/d:a	Ljava/lang/String;
    //   1055: aastore
    //   1056: dup
    //   1057: iconst_1
    //   1058: aload_0
    //   1059: getfield 276	com/tencent/mm/plugin/appbrand/appstorage/d:b	Ljava/lang/String;
    //   1062: aastore
    //   1063: invokestatic 279	com/tencent/luggage/wxa/qz/o:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1066: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1069: dup
    //   1070: ldc_w 281
    //   1073: iconst_0
    //   1074: anewarray 45	java/lang/Object
    //   1077: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1080: aload_1
    //   1081: invokevirtual 284	com/tencent/luggage/wxa/ku/f$a:b	(Ljava/util/Map;)Lcom/tencent/luggage/wxa/ku/f$a;
    //   1084: areturn
    //   1085: astore_0
    //   1086: ldc 91
    //   1088: ldc_w 286
    //   1091: iconst_2
    //   1092: anewarray 45	java/lang/Object
    //   1095: dup
    //   1096: iconst_0
    //   1097: iload 15
    //   1099: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_1
    //   1105: aload_0
    //   1106: aastore
    //   1107: invokestatic 255	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1110: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1113: dup
    //   1114: ldc_w 288
    //   1117: iconst_0
    //   1118: anewarray 45	java/lang/Object
    //   1121: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1124: areturn
    //   1125: ldc 91
    //   1127: ldc_w 290
    //   1130: iconst_4
    //   1131: anewarray 45	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: aload 25
    //   1138: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   1141: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1144: aastore
    //   1145: dup
    //   1146: iconst_1
    //   1147: aload 25
    //   1149: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   1152: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1155: aastore
    //   1156: dup
    //   1157: iconst_2
    //   1158: fload_3
    //   1159: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1162: aastore
    //   1163: dup
    //   1164: iconst_3
    //   1165: fload 8
    //   1167: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1170: aastore
    //   1171: invokestatic 255	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1174: ldc 91
    //   1176: aload_0
    //   1177: ldc_w 292
    //   1180: iconst_0
    //   1181: anewarray 45	java/lang/Object
    //   1184: invokestatic 295	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1187: ldc 101
    //   1189: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1192: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   1195: ldc2_w 110
    //   1198: ldc2_w 296
    //   1201: lconst_1
    //   1202: invokeinterface 114 7 0
    //   1207: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1210: dup
    //   1211: ldc_w 299
    //   1214: iconst_0
    //   1215: anewarray 45	java/lang/Object
    //   1218: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1221: areturn
    //   1222: ldc 91
    //   1224: ldc_w 301
    //   1227: iconst_4
    //   1228: anewarray 45	java/lang/Object
    //   1231: dup
    //   1232: iconst_0
    //   1233: aload 25
    //   1235: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   1238: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1241: aastore
    //   1242: dup
    //   1243: iconst_1
    //   1244: aload 25
    //   1246: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   1249: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1252: aastore
    //   1253: dup
    //   1254: iconst_2
    //   1255: fload_3
    //   1256: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1259: aastore
    //   1260: dup
    //   1261: iconst_3
    //   1262: fload 8
    //   1264: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1267: aastore
    //   1268: invokestatic 255	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1271: ldc 91
    //   1273: aload_0
    //   1274: ldc_w 303
    //   1277: iconst_0
    //   1278: anewarray 45	java/lang/Object
    //   1281: invokestatic 295	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1284: ldc 101
    //   1286: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1289: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   1292: ldc2_w 110
    //   1295: ldc2_w 173
    //   1298: lconst_1
    //   1299: invokeinterface 114 7 0
    //   1304: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1307: dup
    //   1308: ldc 176
    //   1310: iconst_0
    //   1311: anewarray 45	java/lang/Object
    //   1314: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1317: areturn
    //   1318: ldc 91
    //   1320: ldc_w 305
    //   1323: invokestatic 166	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1326: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1329: dup
    //   1330: ldc 168
    //   1332: iconst_0
    //   1333: anewarray 45	java/lang/Object
    //   1336: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1339: areturn
    //   1340: ldc 91
    //   1342: ldc_w 307
    //   1345: iconst_5
    //   1346: anewarray 45	java/lang/Object
    //   1349: dup
    //   1350: iconst_0
    //   1351: fload 6
    //   1353: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1356: aastore
    //   1357: dup
    //   1358: iconst_1
    //   1359: fload 5
    //   1361: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1364: aastore
    //   1365: dup
    //   1366: iconst_2
    //   1367: fload 7
    //   1369: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1372: aastore
    //   1373: dup
    //   1374: iconst_3
    //   1375: fload 4
    //   1377: invokestatic 132	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1380: aastore
    //   1381: dup
    //   1382: iconst_4
    //   1383: iload 15
    //   1385: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1388: aastore
    //   1389: invokestatic 309	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1392: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1395: dup
    //   1396: ldc_w 311
    //   1399: iconst_0
    //   1400: anewarray 45	java/lang/Object
    //   1403: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1406: astore_0
    //   1407: aload_0
    //   1408: areturn
    //   1409: astore_0
    //   1410: goto +45 -> 1455
    //   1413: astore_0
    //   1414: goto +44 -> 1458
    //   1417: astore_0
    //   1418: goto +96 -> 1514
    //   1421: astore_0
    //   1422: ldc 91
    //   1424: ldc_w 313
    //   1427: iconst_1
    //   1428: anewarray 45	java/lang/Object
    //   1431: dup
    //   1432: iconst_0
    //   1433: aload_0
    //   1434: aastore
    //   1435: invokestatic 255	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1438: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1441: dup
    //   1442: ldc_w 315
    //   1445: iconst_0
    //   1446: anewarray 45	java/lang/Object
    //   1449: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1452: astore_0
    //   1453: aload_0
    //   1454: areturn
    //   1455: goto +59 -> 1514
    //   1458: ldc 91
    //   1460: aload_0
    //   1461: ldc_w 317
    //   1464: iconst_0
    //   1465: anewarray 45	java/lang/Object
    //   1468: invokestatic 295	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1471: ldc 101
    //   1473: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1476: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   1479: ldc2_w 110
    //   1482: ldc2_w 318
    //   1485: lconst_1
    //   1486: iconst_0
    //   1487: invokeinterface 322 8 0
    //   1492: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1495: dup
    //   1496: ldc_w 324
    //   1499: iconst_1
    //   1500: anewarray 45	java/lang/Object
    //   1503: dup
    //   1504: iconst_0
    //   1505: aload_0
    //   1506: invokevirtual 325	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1509: aastore
    //   1510: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1513: areturn
    //   1514: ldc 91
    //   1516: aload_0
    //   1517: ldc_w 327
    //   1520: iconst_0
    //   1521: anewarray 45	java/lang/Object
    //   1524: invokestatic 295	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1527: ldc 101
    //   1529: invokestatic 107	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1532: checkcast 101	com/tencent/luggage/wxa/ot/c
    //   1535: ldc2_w 110
    //   1538: ldc2_w 328
    //   1541: lconst_1
    //   1542: invokeinterface 114 7 0
    //   1547: new 41	com/tencent/luggage/wxa/ku/f$a
    //   1550: dup
    //   1551: ldc_w 331
    //   1554: iconst_0
    //   1555: anewarray 45	java/lang/Object
    //   1558: invokespecial 48	com/tencent/luggage/wxa/ku/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1561: areturn
    //   1562: aconst_null
    //   1563: astore 25
    //   1565: goto -1451 -> 114
    //   1568: ldc2_w 332
    //   1571: lstore 23
    //   1573: goto -1425 -> 148
    //   1576: fload 4
    //   1578: fstore 7
    //   1580: fload 6
    //   1582: fload 4
    //   1584: fadd
    //   1585: fload 11
    //   1587: fcmpl
    //   1588: ifle +10 -> 1598
    //   1591: fload 11
    //   1593: fload 6
    //   1595: fsub
    //   1596: fstore 7
    //   1598: fload_3
    //   1599: fstore 4
    //   1601: fload 5
    //   1603: fload_3
    //   1604: fadd
    //   1605: fload 12
    //   1607: fcmpl
    //   1608: ifle -1120 -> 488
    //   1611: fload 12
    //   1613: fload 5
    //   1615: fsub
    //   1616: fstore 4
    //   1618: goto -1130 -> 488
    //   1621: fload 7
    //   1623: fload 11
    //   1625: fcmpl
    //   1626: ifne -952 -> 674
    //   1629: fload 4
    //   1631: fload 12
    //   1633: fcmpl
    //   1634: ifeq +6 -> 1640
    //   1637: goto -963 -> 674
    //   1640: goto -940 -> 700
    //   1643: astore_0
    //   1644: goto -186 -> 1458
    //   1647: ldc_w 335
    //   1650: astore_0
    //   1651: goto -680 -> 971
    //   1654: astore_0
    //   1655: goto -530 -> 1125
    //   1658: astore_0
    //   1659: goto -437 -> 1222
    //   1662: goto -322 -> 1340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1665	0	paramu	com.tencent.mm.plugin.appbrand.page.u
    //   0	1665	1	paramJSONObject	JSONObject
    //   0	1665	2	paramBoolean	boolean
    //   350	1254	3	f1	float
    //   342	1288	4	f2	float
    //   338	1276	5	f3	float
    //   346	1248	6	f4	float
    //   267	1355	7	f5	float
    //   257	1006	8	f6	float
    //   291	171	9	f7	float
    //   279	173	10	f8	float
    //   180	1444	11	f9	float
    //   188	1444	12	f10	float
    //   204	260	13	f11	float
    //   196	258	14	f12	float
    //   6	1378	15	i	int
    //   654	117	16	j	int
    //   664	109	17	k	int
    //   591	151	18	m	int
    //   601	78	19	n	int
    //   611	70	20	i1	int
    //   621	62	21	i2	int
    //   44	92	22	bool	boolean
    //   143	1429	23	l	long
    //   35	1529	25	localObject1	java.lang.Object
    //   689	284	26	localObject2	java.lang.Object
    //   846	112	27	localCompressFormat	android.graphics.Bitmap.CompressFormat
    //   908	21	28	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   790	824	826	java/lang/IllegalArgumentException
    //   790	824	834	java/lang/NullPointerException
    //   938	952	1085	java/io/IOException
    //   984	1003	1409	java/lang/OutOfMemoryError
    //   0	8	1413	java/lang/RuntimeException
    //   12	26	1413	java/lang/RuntimeException
    //   26	46	1413	java/lang/RuntimeException
    //   51	61	1413	java/lang/RuntimeException
    //   66	78	1413	java/lang/RuntimeException
    //   81	111	1413	java/lang/RuntimeException
    //   119	135	1413	java/lang/RuntimeException
    //   148	174	1413	java/lang/RuntimeException
    //   174	336	1413	java/lang/RuntimeException
    //   421	430	1413	java/lang/RuntimeException
    //   441	451	1413	java/lang/RuntimeException
    //   451	471	1413	java/lang/RuntimeException
    //   488	588	1413	java/lang/RuntimeException
    //   674	696	1413	java/lang/RuntimeException
    //   705	712	1413	java/lang/RuntimeException
    //   712	726	1413	java/lang/RuntimeException
    //   726	741	1413	java/lang/RuntimeException
    //   768	785	1413	java/lang/RuntimeException
    //   790	824	1413	java/lang/RuntimeException
    //   842	848	1413	java/lang/RuntimeException
    //   852	895	1413	java/lang/RuntimeException
    //   895	938	1413	java/lang/RuntimeException
    //   938	952	1413	java/lang/RuntimeException
    //   952	965	1413	java/lang/RuntimeException
    //   971	980	1413	java/lang/RuntimeException
    //   984	1003	1413	java/lang/RuntimeException
    //   1003	1018	1413	java/lang/RuntimeException
    //   1018	1066	1413	java/lang/RuntimeException
    //   1066	1085	1413	java/lang/RuntimeException
    //   1086	1125	1413	java/lang/RuntimeException
    //   1125	1222	1413	java/lang/RuntimeException
    //   1222	1271	1413	java/lang/RuntimeException
    //   1271	1304	1413	java/lang/RuntimeException
    //   1304	1318	1413	java/lang/RuntimeException
    //   1318	1326	1413	java/lang/RuntimeException
    //   1326	1340	1413	java/lang/RuntimeException
    //   1340	1407	1413	java/lang/RuntimeException
    //   1422	1453	1413	java/lang/RuntimeException
    //   0	8	1417	java/lang/OutOfMemoryError
    //   12	26	1417	java/lang/OutOfMemoryError
    //   26	46	1417	java/lang/OutOfMemoryError
    //   51	61	1417	java/lang/OutOfMemoryError
    //   66	78	1417	java/lang/OutOfMemoryError
    //   81	111	1417	java/lang/OutOfMemoryError
    //   119	135	1417	java/lang/OutOfMemoryError
    //   148	174	1417	java/lang/OutOfMemoryError
    //   174	336	1417	java/lang/OutOfMemoryError
    //   421	430	1417	java/lang/OutOfMemoryError
    //   441	451	1417	java/lang/OutOfMemoryError
    //   451	471	1417	java/lang/OutOfMemoryError
    //   488	588	1417	java/lang/OutOfMemoryError
    //   674	696	1417	java/lang/OutOfMemoryError
    //   705	712	1417	java/lang/OutOfMemoryError
    //   712	726	1417	java/lang/OutOfMemoryError
    //   726	741	1417	java/lang/OutOfMemoryError
    //   768	785	1417	java/lang/OutOfMemoryError
    //   790	824	1417	java/lang/OutOfMemoryError
    //   842	848	1417	java/lang/OutOfMemoryError
    //   852	895	1417	java/lang/OutOfMemoryError
    //   895	938	1417	java/lang/OutOfMemoryError
    //   938	952	1417	java/lang/OutOfMemoryError
    //   952	965	1417	java/lang/OutOfMemoryError
    //   971	980	1417	java/lang/OutOfMemoryError
    //   1003	1018	1417	java/lang/OutOfMemoryError
    //   1018	1066	1417	java/lang/OutOfMemoryError
    //   1066	1085	1417	java/lang/OutOfMemoryError
    //   1086	1125	1417	java/lang/OutOfMemoryError
    //   1125	1222	1417	java/lang/OutOfMemoryError
    //   1222	1271	1417	java/lang/OutOfMemoryError
    //   1271	1304	1417	java/lang/OutOfMemoryError
    //   1304	1318	1417	java/lang/OutOfMemoryError
    //   1318	1326	1417	java/lang/OutOfMemoryError
    //   1326	1340	1417	java/lang/OutOfMemoryError
    //   1340	1407	1417	java/lang/OutOfMemoryError
    //   1422	1453	1417	java/lang/OutOfMemoryError
    //   0	8	1421	org/json/JSONException
    //   768	785	1654	java/lang/IllegalArgumentException
    //   768	785	1658	java/lang/NullPointerException
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    l.a().c(new d.1(this, paramh, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.d
 * JD-Core Version:    0.7.0.1
 */