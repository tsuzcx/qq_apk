package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.jx.c;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class a
  extends com.tencent.luggage.wxa.jx.a<c>
{
  public static final int CTRL_INDEX = 372;
  public static final String NAME = "canvasGetImageData";
  
  private static ByteBuffer a(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 4];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfInt.length)
    {
      int k = j + 1;
      arrayOfByte[j] = ((byte)(paramArrayOfInt[i] >> 16 & 0xFF));
      j = k + 1;
      arrayOfByte[k] = ((byte)(paramArrayOfInt[i] >> 8 & 0xFF));
      k = j + 1;
      arrayOfByte[j] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = k + 1;
      arrayOfByte[k] = ((byte)(paramArrayOfInt[i] >> 24 & 0xFF));
      i += 1;
    }
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  private static Map<String, Object> a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramArrayOfInt = a(paramArrayOfInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramArrayOfInt);
    localHashMap.put("width", Integer.valueOf(paramInt1));
    localHashMap.put("height", Integer.valueOf(paramInt2));
    return localHashMap;
  }
  
  /* Error */
  public void a(c paramc, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 58
    //   3: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore 16
    //   8: aload_1
    //   9: ldc 66
    //   11: invokeinterface 71 2 0
    //   16: checkcast 66	com/tencent/luggage/wxa/kd/g
    //   19: aload_1
    //   20: aload_2
    //   21: invokeinterface 74 3 0
    //   26: astore 19
    //   28: aload 19
    //   30: ifnonnull +24 -> 54
    //   33: ldc 76
    //   35: ldc 78
    //   37: invokestatic 84	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_1
    //   41: iload_3
    //   42: aload_0
    //   43: ldc 86
    //   45: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokeinterface 93 3 0
    //   53: return
    //   54: aload 19
    //   56: aload_2
    //   57: ldc 95
    //   59: iconst_0
    //   60: invokevirtual 99	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   63: invokeinterface 104 2 0
    //   68: iload 16
    //   70: invokeinterface 109 2 0
    //   75: astore 19
    //   77: aload 19
    //   79: ifnonnull +36 -> 115
    //   82: ldc 76
    //   84: ldc 111
    //   86: iconst_1
    //   87: anewarray 113	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: iload 16
    //   94: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 116	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_1
    //   102: iload_3
    //   103: aload_0
    //   104: ldc 118
    //   106: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokeinterface 93 3 0
    //   114: return
    //   115: aload 19
    //   117: instanceof 120
    //   120: ifne +36 -> 156
    //   123: ldc 76
    //   125: ldc 122
    //   127: iconst_1
    //   128: anewarray 113	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload 16
    //   135: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokestatic 116	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_1
    //   143: iload_3
    //   144: aload_0
    //   145: ldc 124
    //   147: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokeinterface 93 3 0
    //   155: return
    //   156: aload 19
    //   158: checkcast 120	com/tencent/luggage/wxa/kt/b
    //   161: ldc 126
    //   163: invokevirtual 129	com/tencent/luggage/wxa/kt/b:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   166: checkcast 126	android/view/View
    //   169: astore 19
    //   171: aload 19
    //   173: instanceof 131
    //   176: ifne +36 -> 212
    //   179: ldc 76
    //   181: ldc 133
    //   183: iconst_1
    //   184: anewarray 113	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: iload 16
    //   191: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_1
    //   199: iload_3
    //   200: aload_0
    //   201: ldc 124
    //   203: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokeinterface 93 3 0
    //   211: return
    //   212: invokestatic 141	com/tencent/luggage/wxa/pc/g:a	()F
    //   215: fstore 4
    //   217: aload_2
    //   218: ldc 143
    //   220: invokevirtual 146	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   223: istore 10
    //   225: aload_2
    //   226: ldc 148
    //   228: invokevirtual 146	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   231: istore 6
    //   233: aload_2
    //   234: ldc 41
    //   236: invokevirtual 146	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   239: istore 9
    //   241: aload_2
    //   242: ldc 49
    //   244: invokevirtual 146	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   247: istore 5
    //   249: iload 9
    //   251: ifeq +667 -> 918
    //   254: iload 5
    //   256: ifne +6 -> 262
    //   259: goto +659 -> 918
    //   262: iload 10
    //   264: istore 8
    //   266: iload 9
    //   268: istore 7
    //   270: iload 9
    //   272: ifge +15 -> 287
    //   275: iload 10
    //   277: iload 9
    //   279: iadd
    //   280: istore 8
    //   282: iload 9
    //   284: ineg
    //   285: istore 7
    //   287: iload 6
    //   289: istore 10
    //   291: iload 5
    //   293: istore 9
    //   295: iload 5
    //   297: ifge +15 -> 312
    //   300: iload 6
    //   302: iload 5
    //   304: iadd
    //   305: istore 10
    //   307: iload 5
    //   309: ineg
    //   310: istore 9
    //   312: iload 8
    //   314: i2f
    //   315: fload 4
    //   317: fmul
    //   318: invokestatic 154	java/lang/Math:round	(F)I
    //   321: istore 14
    //   323: iload 10
    //   325: i2f
    //   326: fload 4
    //   328: fmul
    //   329: invokestatic 154	java/lang/Math:round	(F)I
    //   332: istore 13
    //   334: iload 7
    //   336: i2f
    //   337: fload 4
    //   339: fmul
    //   340: invokestatic 154	java/lang/Math:round	(F)I
    //   343: istore 5
    //   345: iload 9
    //   347: i2f
    //   348: fload 4
    //   350: fmul
    //   351: invokestatic 154	java/lang/Math:round	(F)I
    //   354: istore 6
    //   356: aload 19
    //   358: invokevirtual 158	android/view/View:getMeasuredWidth	()I
    //   361: istore 18
    //   363: aload 19
    //   365: invokevirtual 161	android/view/View:getMeasuredHeight	()I
    //   368: istore 17
    //   370: iload 14
    //   372: ifge +9 -> 381
    //   375: iconst_0
    //   376: istore 11
    //   378: goto +43 -> 421
    //   381: iload 14
    //   383: iload 18
    //   385: if_icmplt +32 -> 417
    //   388: aload_1
    //   389: iload_3
    //   390: aload_0
    //   391: aload_1
    //   392: ldc 163
    //   394: iload 7
    //   396: iload 9
    //   398: imul
    //   399: newarray int
    //   401: iload 7
    //   403: iload 9
    //   405: invokestatic 165	com/tencent/luggage/wxa/kq/a:a	([III)Ljava/util/Map;
    //   408: invokevirtual 168	com/tencent/luggage/wxa/kq/a:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   411: invokeinterface 93 3 0
    //   416: return
    //   417: iload 14
    //   419: istore 11
    //   421: iload 13
    //   423: ifge +9 -> 432
    //   426: iconst_0
    //   427: istore 12
    //   429: goto +43 -> 472
    //   432: iload 13
    //   434: iload 17
    //   436: if_icmplt +32 -> 468
    //   439: aload_1
    //   440: iload_3
    //   441: aload_0
    //   442: aload_1
    //   443: ldc 163
    //   445: iload 7
    //   447: iload 9
    //   449: imul
    //   450: newarray int
    //   452: iload 7
    //   454: iload 9
    //   456: invokestatic 165	com/tencent/luggage/wxa/kq/a:a	([III)Ljava/util/Map;
    //   459: invokevirtual 168	com/tencent/luggage/wxa/kq/a:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   462: invokeinterface 93 3 0
    //   467: return
    //   468: iload 13
    //   470: istore 12
    //   472: iload 14
    //   474: iload 5
    //   476: iadd
    //   477: istore 15
    //   479: iload 15
    //   481: iload 18
    //   483: if_icmple +13 -> 496
    //   486: iload 18
    //   488: iload 11
    //   490: isub
    //   491: istore 5
    //   493: goto +46 -> 539
    //   496: iload 15
    //   498: ifgt +32 -> 530
    //   501: aload_1
    //   502: iload_3
    //   503: aload_0
    //   504: aload_1
    //   505: ldc 163
    //   507: iload 7
    //   509: iload 9
    //   511: imul
    //   512: newarray int
    //   514: iload 7
    //   516: iload 9
    //   518: invokestatic 165	com/tencent/luggage/wxa/kq/a:a	([III)Ljava/util/Map;
    //   521: invokevirtual 168	com/tencent/luggage/wxa/kq/a:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   524: invokeinterface 93 3 0
    //   529: return
    //   530: iload 14
    //   532: ifge +7 -> 539
    //   535: iload 15
    //   537: istore 5
    //   539: iload 13
    //   541: iload 6
    //   543: iadd
    //   544: istore 14
    //   546: iload 14
    //   548: iload 17
    //   550: if_icmple +13 -> 563
    //   553: iload 17
    //   555: iload 12
    //   557: isub
    //   558: istore 6
    //   560: goto +46 -> 606
    //   563: iload 14
    //   565: ifgt +32 -> 597
    //   568: aload_1
    //   569: iload_3
    //   570: aload_0
    //   571: aload_1
    //   572: ldc 163
    //   574: iload 7
    //   576: iload 9
    //   578: imul
    //   579: newarray int
    //   581: iload 7
    //   583: iload 9
    //   585: invokestatic 165	com/tencent/luggage/wxa/kq/a:a	([III)Ljava/util/Map;
    //   588: invokevirtual 168	com/tencent/luggage/wxa/kq/a:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   591: invokeinterface 93 3 0
    //   596: return
    //   597: iload 13
    //   599: ifge +7 -> 606
    //   602: iload 14
    //   604: istore 6
    //   606: iload 11
    //   608: i2f
    //   609: fload 4
    //   611: fdiv
    //   612: invokestatic 154	java/lang/Math:round	(F)I
    //   615: istore 13
    //   617: iload 12
    //   619: i2f
    //   620: fload 4
    //   622: fdiv
    //   623: invokestatic 154	java/lang/Math:round	(F)I
    //   626: istore 14
    //   628: iload 5
    //   630: i2f
    //   631: fload 4
    //   633: fdiv
    //   634: invokestatic 154	java/lang/Math:round	(F)I
    //   637: istore 15
    //   639: iload 6
    //   641: i2f
    //   642: fload 4
    //   644: fdiv
    //   645: invokestatic 154	java/lang/Math:round	(F)I
    //   648: istore 17
    //   650: iload 5
    //   652: iload 6
    //   654: getstatic 174	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   657: invokestatic 180	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   660: astore 20
    //   662: new 182	com/tencent/luggage/wxa/ja/f
    //   665: dup
    //   666: aload 20
    //   668: invokespecial 185	com/tencent/luggage/wxa/ja/f:<init>	(Landroid/graphics/Bitmap;)V
    //   671: astore 21
    //   673: aload 21
    //   675: invokevirtual 190	android/graphics/Canvas:save	()I
    //   678: pop
    //   679: aload 21
    //   681: iload 11
    //   683: ineg
    //   684: i2f
    //   685: iload 12
    //   687: ineg
    //   688: i2f
    //   689: invokevirtual 194	android/graphics/Canvas:translate	(FF)V
    //   692: aload 19
    //   694: checkcast 131	com/tencent/luggage/wxa/ji/b
    //   697: aload 21
    //   699: invokeinterface 197 2 0
    //   704: pop
    //   705: aload 21
    //   707: invokevirtual 200	android/graphics/Canvas:restore	()V
    //   710: aload 20
    //   712: iload 15
    //   714: iload 17
    //   716: iconst_0
    //   717: invokestatic 204	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   720: astore 19
    //   722: iload 7
    //   724: iload 9
    //   726: imul
    //   727: newarray int
    //   729: astore 20
    //   731: aload 19
    //   733: aload 20
    //   735: iload 14
    //   737: iload 10
    //   739: isub
    //   740: iload 7
    //   742: imul
    //   743: iload 13
    //   745: iload 8
    //   747: isub
    //   748: iadd
    //   749: iload 7
    //   751: iconst_0
    //   752: iconst_0
    //   753: iload 15
    //   755: iload 17
    //   757: invokevirtual 208	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   760: aload_1
    //   761: iload_3
    //   762: aload_0
    //   763: aload_1
    //   764: ldc 163
    //   766: aload 20
    //   768: iload 7
    //   770: iload 9
    //   772: invokestatic 165	com/tencent/luggage/wxa/kq/a:a	([III)Ljava/util/Map;
    //   775: invokevirtual 168	com/tencent/luggage/wxa/kq/a:a	(Lcom/tencent/luggage/wxa/jx/c;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   778: invokeinterface 93 3 0
    //   783: return
    //   784: astore 19
    //   786: ldc 76
    //   788: ldc 210
    //   790: iconst_2
    //   791: anewarray 113	java/lang/Object
    //   794: dup
    //   795: iconst_0
    //   796: iload 16
    //   798: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   801: aastore
    //   802: dup
    //   803: iconst_1
    //   804: aload 19
    //   806: aastore
    //   807: invokestatic 116	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   810: ldc 76
    //   812: ldc 212
    //   814: bipush 6
    //   816: anewarray 113	java/lang/Object
    //   819: dup
    //   820: iconst_0
    //   821: iload 13
    //   823: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   826: aastore
    //   827: dup
    //   828: iconst_1
    //   829: iload 14
    //   831: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   834: aastore
    //   835: dup
    //   836: iconst_2
    //   837: iload 15
    //   839: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   842: aastore
    //   843: dup
    //   844: iconst_3
    //   845: iload 17
    //   847: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   850: aastore
    //   851: dup
    //   852: iconst_4
    //   853: iload 7
    //   855: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: aastore
    //   859: dup
    //   860: iconst_5
    //   861: aload_2
    //   862: aastore
    //   863: invokestatic 116	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload_1
    //   867: iload_3
    //   868: aload_0
    //   869: ldc 214
    //   871: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokeinterface 93 3 0
    //   879: return
    //   880: astore_2
    //   881: ldc 76
    //   883: ldc 216
    //   885: iconst_2
    //   886: anewarray 113	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: iload 16
    //   893: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   896: aastore
    //   897: dup
    //   898: iconst_1
    //   899: aload_2
    //   900: aastore
    //   901: invokestatic 116	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   904: aload_1
    //   905: iload_3
    //   906: aload_0
    //   907: ldc 218
    //   909: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   912: invokeinterface 93 3 0
    //   917: return
    //   918: ldc 76
    //   920: ldc 220
    //   922: iconst_3
    //   923: anewarray 113	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: iload 9
    //   930: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   933: aastore
    //   934: dup
    //   935: iconst_1
    //   936: iload 5
    //   938: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   941: aastore
    //   942: dup
    //   943: iconst_2
    //   944: iload 16
    //   946: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   949: aastore
    //   950: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: aload_1
    //   954: iload_3
    //   955: aload_0
    //   956: ldc 222
    //   958: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   961: invokeinterface 93 3 0
    //   966: return
    //   967: astore_2
    //   968: ldc 76
    //   970: ldc 224
    //   972: iconst_1
    //   973: anewarray 113	java/lang/Object
    //   976: dup
    //   977: iconst_0
    //   978: aload_2
    //   979: invokestatic 230	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   982: aastore
    //   983: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   986: aload_1
    //   987: iload_3
    //   988: aload_0
    //   989: ldc 232
    //   991: invokevirtual 90	com/tencent/luggage/wxa/kq/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   994: invokeinterface 93 3 0
    //   999: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	this	a
    //   0	1000	1	paramc	c
    //   0	1000	2	paramJSONObject	org.json.JSONObject
    //   0	1000	3	paramInt	int
    //   215	428	4	f	float
    //   247	690	5	i	int
    //   231	422	6	j	int
    //   268	586	7	k	int
    //   264	484	8	m	int
    //   239	690	9	n	int
    //   223	517	10	i1	int
    //   376	306	11	i2	int
    //   427	259	12	i3	int
    //   332	490	13	i4	int
    //   321	509	14	i5	int
    //   477	361	15	i6	int
    //   6	939	16	i7	int
    //   368	478	17	i8	int
    //   361	130	18	i9	int
    //   26	706	19	localObject1	Object
    //   784	21	19	localException	java.lang.Exception
    //   660	107	20	localObject2	Object
    //   671	35	21	localf	com.tencent.luggage.wxa.ja.f
    // Exception table:
    //   from	to	target	type
    //   731	760	784	java/lang/Exception
    //   650	722	880	java/lang/Exception
    //   0	8	967	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.a
 * JD-Core Version:    0.7.0.1
 */