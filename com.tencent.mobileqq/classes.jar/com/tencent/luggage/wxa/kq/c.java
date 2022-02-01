package com.tencent.luggage.wxa.kq;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import org.json.JSONObject;

public class c
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int a(JSONObject paramJSONObject)
  {
    float f2 = (float)paramJSONObject.optDouble("quality", 1.0D);
    float f1 = 100.0F;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    } else if (f2 <= 1.0F) {
      f1 = 100.0F * f2;
    }
    return (int)f1;
  }
  
  /* Error */
  private void a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject, com.tencent.luggage.wxa.kd.j paramj)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 39
    //   3: invokevirtual 43	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore 12
    //   8: aload_1
    //   9: aload_2
    //   10: ldc 45
    //   12: iconst_0
    //   13: invokevirtual 49	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   16: invokeinterface 55 2 0
    //   21: iload 12
    //   23: invokeinterface 61 2 0
    //   28: astore 19
    //   30: aload 19
    //   32: ifnonnull +33 -> 65
    //   35: ldc 63
    //   37: ldc 65
    //   39: iconst_1
    //   40: anewarray 67	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload 12
    //   47: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_3
    //   55: aload_0
    //   56: ldc 80
    //   58: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   64: return
    //   65: aload 19
    //   67: instanceof 90
    //   70: ifne +33 -> 103
    //   73: ldc 63
    //   75: ldc 92
    //   77: iconst_1
    //   78: anewarray 67	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload 12
    //   85: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_3
    //   93: aload_0
    //   94: ldc 94
    //   96: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   102: return
    //   103: aload 19
    //   105: checkcast 90	com/tencent/luggage/wxa/kt/b
    //   108: ldc 96
    //   110: invokevirtual 99	com/tencent/luggage/wxa/kt/b:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   113: checkcast 96	android/view/View
    //   116: astore 20
    //   118: aload 20
    //   120: ifnonnull +33 -> 153
    //   123: ldc 63
    //   125: ldc 101
    //   127: iconst_1
    //   128: anewarray 67	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload 12
    //   135: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_3
    //   143: aload_0
    //   144: ldc 103
    //   146: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   152: return
    //   153: aload 20
    //   155: invokevirtual 107	android/view/View:getMeasuredWidth	()I
    //   158: istore 17
    //   160: aload 20
    //   162: invokevirtual 110	android/view/View:getMeasuredHeight	()I
    //   165: istore 18
    //   167: getstatic 116	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   170: astore 19
    //   172: iload 17
    //   174: iload 18
    //   176: aload 19
    //   178: invokestatic 122	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   181: astore 19
    //   183: aload_2
    //   184: ldc 124
    //   186: invokestatic 129	com/tencent/luggage/wxa/pc/g:b	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   189: fstore 7
    //   191: aload_2
    //   192: ldc 131
    //   194: invokestatic 129	com/tencent/luggage/wxa/pc/g:b	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   197: fstore 8
    //   199: iload 17
    //   201: i2f
    //   202: fstore 9
    //   204: aload_2
    //   205: ldc 133
    //   207: fload 9
    //   209: invokestatic 136	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   212: fstore 5
    //   214: iload 18
    //   216: i2f
    //   217: fstore 10
    //   219: aload_2
    //   220: ldc 138
    //   222: fload 10
    //   224: invokestatic 136	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   227: fstore 6
    //   229: fload 5
    //   231: fstore 4
    //   233: fload 7
    //   235: fload 5
    //   237: fadd
    //   238: fload 9
    //   240: fcmpl
    //   241: ifle +10 -> 251
    //   244: fload 9
    //   246: fload 7
    //   248: fsub
    //   249: fstore 4
    //   251: fload 6
    //   253: fstore 5
    //   255: fload 8
    //   257: fload 6
    //   259: fadd
    //   260: fload 10
    //   262: fcmpl
    //   263: ifle +10 -> 273
    //   266: fload 10
    //   268: fload 8
    //   270: fsub
    //   271: fstore 5
    //   273: aload_2
    //   274: ldc 140
    //   276: invokevirtual 143	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   279: fload 4
    //   281: invokestatic 148	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;F)F
    //   284: fstore 6
    //   286: aload_2
    //   287: ldc 150
    //   289: invokevirtual 143	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   292: fload 5
    //   294: invokestatic 148	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;F)F
    //   297: fstore 11
    //   299: fload 7
    //   301: f2i
    //   302: istore 13
    //   304: iload 13
    //   306: iflt +724 -> 1030
    //   309: fload 8
    //   311: f2i
    //   312: istore 14
    //   314: iload 14
    //   316: iflt +711 -> 1027
    //   319: fload 4
    //   321: f2i
    //   322: istore 15
    //   324: iload 15
    //   326: ifle +698 -> 1024
    //   329: fload 5
    //   331: f2i
    //   332: istore 16
    //   334: iload 16
    //   336: ifle +685 -> 1021
    //   339: fload 7
    //   341: fload 4
    //   343: fadd
    //   344: f2i
    //   345: iload 17
    //   347: if_icmpgt +674 -> 1021
    //   350: fload 8
    //   352: fload 5
    //   354: fadd
    //   355: f2i
    //   356: iload 18
    //   358: if_icmpgt +663 -> 1021
    //   361: fload 6
    //   363: f2i
    //   364: istore 17
    //   366: iload 17
    //   368: ifle +653 -> 1021
    //   371: fload 11
    //   373: f2i
    //   374: istore 18
    //   376: iload 18
    //   378: ifgt +6 -> 384
    //   381: goto +640 -> 1021
    //   384: aload 20
    //   386: instanceof 152
    //   389: ifeq +26 -> 415
    //   392: aload 20
    //   394: checkcast 152	com/tencent/luggage/wxa/ji/b
    //   397: new 154	com/tencent/luggage/wxa/ja/f
    //   400: dup
    //   401: aload 19
    //   403: invokespecial 157	com/tencent/luggage/wxa/ja/f:<init>	(Landroid/graphics/Bitmap;)V
    //   406: invokeinterface 160 2 0
    //   411: pop
    //   412: goto +17 -> 429
    //   415: aload 20
    //   417: new 154	com/tencent/luggage/wxa/ja/f
    //   420: dup
    //   421: aload 19
    //   423: invokespecial 157	com/tencent/luggage/wxa/ja/f:<init>	(Landroid/graphics/Bitmap;)V
    //   426: invokevirtual 164	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   429: fload 4
    //   431: fload 9
    //   433: fcmpl
    //   434: ifne +17 -> 451
    //   437: fload 5
    //   439: fload 10
    //   441: fcmpl
    //   442: ifeq +6 -> 448
    //   445: goto +6 -> 451
    //   448: goto +45 -> 493
    //   451: aload 19
    //   453: iload 13
    //   455: iload 14
    //   457: iload 15
    //   459: iload 16
    //   461: aconst_null
    //   462: iconst_0
    //   463: invokestatic 167	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   466: astore 20
    //   468: ldc 63
    //   470: ldc 169
    //   472: iconst_1
    //   473: anewarray 67	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload 19
    //   480: aastore
    //   481: invokestatic 172	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 19
    //   486: invokevirtual 175	android/graphics/Bitmap:recycle	()V
    //   489: aload 20
    //   491: astore 19
    //   493: fload 4
    //   495: fload 6
    //   497: fcmpl
    //   498: ifne +15 -> 513
    //   501: aload 19
    //   503: astore 20
    //   505: fload 5
    //   507: fload 11
    //   509: fcmpl
    //   510: ifeq +36 -> 546
    //   513: aload 19
    //   515: iload 17
    //   517: iload 18
    //   519: iconst_0
    //   520: invokestatic 179	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   523: astore 20
    //   525: ldc 63
    //   527: ldc 169
    //   529: iconst_1
    //   530: anewarray 67	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: aload 19
    //   537: aastore
    //   538: invokestatic 172	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: aload 19
    //   543: invokevirtual 175	android/graphics/Bitmap:recycle	()V
    //   546: aload_2
    //   547: invokestatic 182	com/tencent/luggage/wxa/kq/c:b	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   550: astore 21
    //   552: aload 21
    //   554: getstatic 188	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   557: if_acmpne +10 -> 567
    //   560: ldc 190
    //   562: astore 19
    //   564: goto +7 -> 571
    //   567: ldc 192
    //   569: astore 19
    //   571: aload_1
    //   572: invokeinterface 196 1 0
    //   577: astore 22
    //   579: new 198	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   586: astore 23
    //   588: aload 23
    //   590: ldc 201
    //   592: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 23
    //   598: iload 12
    //   600: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 23
    //   606: ldc 210
    //   608: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 23
    //   614: aload 19
    //   616: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 22
    //   622: aload 23
    //   624: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokeinterface 220 2 0
    //   632: astore 22
    //   634: aload 22
    //   636: ifnonnull +21 -> 657
    //   639: ldc 63
    //   641: ldc 222
    //   643: invokestatic 225	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_3
    //   647: aload_0
    //   648: ldc 227
    //   650: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   653: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   656: return
    //   657: aload 22
    //   659: invokevirtual 232	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   662: astore 22
    //   664: ldc 63
    //   666: ldc 234
    //   668: iconst_1
    //   669: anewarray 67	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload 22
    //   676: aastore
    //   677: invokestatic 237	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 20
    //   682: aload_2
    //   683: invokestatic 239	com/tencent/luggage/wxa/kq/c:a	(Lorg/json/JSONObject;)I
    //   686: aload 21
    //   688: aload 22
    //   690: iconst_1
    //   691: invokestatic 244	com/tencent/luggage/wxa/qz/b:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   694: new 246	com/tencent/luggage/wxa/pc/i
    //   697: dup
    //   698: invokespecial 247	com/tencent/luggage/wxa/pc/i:<init>	()V
    //   701: astore_2
    //   702: aload_1
    //   703: invokeinterface 196 1 0
    //   708: new 229	com/tencent/luggage/wxa/rt/i
    //   711: dup
    //   712: aload 22
    //   714: invokespecial 249	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   717: aload 19
    //   719: iconst_1
    //   720: aload_2
    //   721: invokeinterface 252 5 0
    //   726: pop
    //   727: aload_2
    //   728: getfield 255	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   731: checkcast 257	java/lang/String
    //   734: astore_1
    //   735: ldc 63
    //   737: ldc_w 259
    //   740: iconst_1
    //   741: anewarray 67	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload_1
    //   747: aastore
    //   748: invokestatic 237	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: new 261	java/util/HashMap
    //   754: dup
    //   755: invokespecial 262	java/util/HashMap:<init>	()V
    //   758: astore_2
    //   759: aload_2
    //   760: ldc_w 264
    //   763: aload_1
    //   764: invokeinterface 270 3 0
    //   769: pop
    //   770: aload_3
    //   771: aload_0
    //   772: ldc_w 272
    //   775: aload_2
    //   776: invokevirtual 275	com/tencent/luggage/wxa/kq/c:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   779: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   782: return
    //   783: astore_1
    //   784: ldc 63
    //   786: ldc_w 277
    //   789: iconst_2
    //   790: anewarray 67	java/lang/Object
    //   793: dup
    //   794: iconst_0
    //   795: iload 12
    //   797: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: aload_1
    //   804: aastore
    //   805: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   808: aload_3
    //   809: aload_0
    //   810: ldc_w 279
    //   813: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   816: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   819: return
    //   820: astore_1
    //   821: ldc 63
    //   823: ldc_w 281
    //   826: iconst_2
    //   827: anewarray 67	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: iload 12
    //   834: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: dup
    //   839: iconst_1
    //   840: aload_1
    //   841: aastore
    //   842: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: aload_3
    //   846: aload_0
    //   847: ldc_w 279
    //   850: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   853: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   856: return
    //   857: astore_1
    //   858: goto +45 -> 903
    //   861: astore_1
    //   862: goto +41 -> 903
    //   865: astore_1
    //   866: ldc 63
    //   868: ldc_w 283
    //   871: iconst_2
    //   872: anewarray 67	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: iload 12
    //   879: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: aastore
    //   883: dup
    //   884: iconst_1
    //   885: aload_1
    //   886: aastore
    //   887: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: aload_3
    //   891: aload_0
    //   892: ldc_w 285
    //   895: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   898: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   901: return
    //   902: astore_1
    //   903: ldc 63
    //   905: ldc_w 287
    //   908: iconst_2
    //   909: anewarray 67	java/lang/Object
    //   912: dup
    //   913: iconst_0
    //   914: iload 12
    //   916: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   919: aastore
    //   920: dup
    //   921: iconst_1
    //   922: aload_1
    //   923: aastore
    //   924: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   927: aload_3
    //   928: aload_0
    //   929: ldc_w 285
    //   932: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   935: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   938: return
    //   939: astore_1
    //   940: goto +8 -> 948
    //   943: astore_1
    //   944: goto +41 -> 985
    //   947: astore_1
    //   948: ldc 63
    //   950: ldc_w 283
    //   953: iconst_2
    //   954: anewarray 67	java/lang/Object
    //   957: dup
    //   958: iconst_0
    //   959: iload 12
    //   961: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   964: aastore
    //   965: dup
    //   966: iconst_1
    //   967: aload_1
    //   968: aastore
    //   969: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   972: aload_3
    //   973: aload_0
    //   974: ldc_w 285
    //   977: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   980: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   983: return
    //   984: astore_1
    //   985: ldc 63
    //   987: ldc_w 287
    //   990: iconst_2
    //   991: anewarray 67	java/lang/Object
    //   994: dup
    //   995: iconst_0
    //   996: iload 12
    //   998: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: aload_1
    //   1005: aastore
    //   1006: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1009: aload_3
    //   1010: aload_0
    //   1011: ldc_w 285
    //   1014: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1017: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   1020: return
    //   1021: goto +9 -> 1030
    //   1024: goto +6 -> 1030
    //   1027: goto +3 -> 1030
    //   1030: ldc 63
    //   1032: ldc_w 289
    //   1035: iconst_5
    //   1036: anewarray 67	java/lang/Object
    //   1039: dup
    //   1040: iconst_0
    //   1041: fload 7
    //   1043: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1046: aastore
    //   1047: dup
    //   1048: iconst_1
    //   1049: fload 8
    //   1051: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_2
    //   1057: fload 4
    //   1059: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_3
    //   1065: fload 5
    //   1067: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1070: aastore
    //   1071: dup
    //   1072: iconst_4
    //   1073: iload 12
    //   1075: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1078: aastore
    //   1079: invokestatic 296	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1082: aload_3
    //   1083: aload_0
    //   1084: ldc_w 298
    //   1087: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   1093: return
    //   1094: astore_1
    //   1095: goto +41 -> 1136
    //   1098: astore_1
    //   1099: ldc 63
    //   1101: ldc_w 283
    //   1104: iconst_2
    //   1105: anewarray 67	java/lang/Object
    //   1108: dup
    //   1109: iconst_0
    //   1110: iload 12
    //   1112: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1115: aastore
    //   1116: dup
    //   1117: iconst_1
    //   1118: aload_1
    //   1119: aastore
    //   1120: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1123: aload_3
    //   1124: aload_0
    //   1125: ldc_w 285
    //   1128: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1131: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   1134: return
    //   1135: astore_1
    //   1136: ldc 63
    //   1138: ldc_w 287
    //   1141: iconst_2
    //   1142: anewarray 67	java/lang/Object
    //   1145: dup
    //   1146: iconst_0
    //   1147: iload 12
    //   1149: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload_1
    //   1156: aastore
    //   1157: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1160: aload_3
    //   1161: aload_0
    //   1162: ldc_w 285
    //   1165: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   1171: return
    //   1172: astore_1
    //   1173: ldc 63
    //   1175: ldc_w 300
    //   1178: iconst_1
    //   1179: anewarray 67	java/lang/Object
    //   1182: dup
    //   1183: iconst_0
    //   1184: aload_1
    //   1185: aastore
    //   1186: invokestatic 78	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1189: aload_3
    //   1190: aload_0
    //   1191: ldc_w 302
    //   1194: invokevirtual 83	com/tencent/luggage/wxa/kq/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1197: invokevirtual 88	com/tencent/luggage/wxa/kd/j:a	(Ljava/lang/String;)V
    //   1200: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1201	0	this	c
    //   0	1201	1	parame	com.tencent.luggage.wxa.jx.e
    //   0	1201	2	paramJSONObject	JSONObject
    //   0	1201	3	paramj	com.tencent.luggage.wxa.kd.j
    //   231	263	4	f1	float
    //   212	294	5	f2	float
    //   227	269	6	f3	float
    //   189	151	7	f4	float
    //   197	154	8	f5	float
    //   202	230	9	f6	float
    //   217	223	10	f7	float
    //   297	211	11	f8	float
    //   6	827	12	i	int
    //   302	152	13	j	int
    //   312	144	14	k	int
    //   322	136	15	m	int
    //   332	128	16	n	int
    //   158	358	17	i1	int
    //   165	353	18	i2	int
    //   28	690	19	localObject1	java.lang.Object
    //   116	565	20	localObject2	java.lang.Object
    //   550	137	21	localCompressFormat	Bitmap.CompressFormat
    //   577	136	22	localObject3	java.lang.Object
    //   586	37	23	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   680	694	783	java/lang/Throwable
    //   680	694	820	java/io/IOException
    //   525	546	857	java/lang/Exception
    //   513	525	865	java/lang/Throwable
    //   525	546	865	java/lang/Throwable
    //   513	525	902	java/lang/Exception
    //   468	489	939	java/lang/Throwable
    //   468	489	943	java/lang/Exception
    //   451	468	947	java/lang/Throwable
    //   451	468	984	java/lang/Exception
    //   172	183	1094	java/lang/Exception
    //   167	172	1098	java/lang/Throwable
    //   172	183	1098	java/lang/Throwable
    //   167	172	1135	java/lang/Exception
    //   0	8	1172	org/json/JSONException
  }
  
  public static Bitmap.CompressFormat b(JSONObject paramJSONObject)
  {
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    return localCompressFormat;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    l.a().c(new c.1(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.c
 * JD-Core Version:    0.7.0.1
 */