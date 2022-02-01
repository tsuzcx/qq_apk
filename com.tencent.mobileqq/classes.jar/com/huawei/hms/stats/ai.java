package com.huawei.hms.stats;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

public abstract class ai
{
  public static aj a(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    return a(paramString, paramArrayOfByte, paramMap, "POST");
  }
  
  /* Error */
  public static aj a(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 13
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 14
    //   24: aconst_null
    //   25: astore 6
    //   27: aload_0
    //   28: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +17 -> 48
    //   34: new 36	com/huawei/hms/stats/aj
    //   37: dup
    //   38: bipush 156
    //   40: ldc 38
    //   42: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
    //   48: bipush 154
    //   50: istore 5
    //   52: aload_0
    //   53: aload_1
    //   54: arraylength
    //   55: aload_2
    //   56: aload_3
    //   57: invokestatic 45	com/huawei/hms/stats/ai:a	(Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnonnull +35 -> 97
    //   65: new 36	com/huawei/hms/stats/aj
    //   68: dup
    //   69: bipush 155
    //   71: ldc 38
    //   73: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   76: astore_2
    //   77: aconst_null
    //   78: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   81: aconst_null
    //   82: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull -42 -> 46
    //   91: aload_0
    //   92: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   95: aload_2
    //   96: areturn
    //   97: aload_0
    //   98: invokevirtual 59	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   101: astore_3
    //   102: aload_0
    //   103: astore 7
    //   105: aload 14
    //   107: astore 8
    //   109: aload_3
    //   110: astore 6
    //   112: new 61	java/io/BufferedOutputStream
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: astore_2
    //   121: aload_2
    //   122: aload_1
    //   123: invokevirtual 68	java/io/BufferedOutputStream:write	([B)V
    //   126: aload_2
    //   127: invokevirtual 72	java/io/BufferedOutputStream:flush	()V
    //   130: aload_0
    //   131: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
    //   134: istore 4
    //   136: new 36	com/huawei/hms/stats/aj
    //   139: dup
    //   140: iload 4
    //   142: aload_0
    //   143: invokestatic 80	com/huawei/hms/stats/ai:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   146: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   149: astore 6
    //   151: aload_2
    //   152: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   155: aload_3
    //   156: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   159: aload 6
    //   161: astore_1
    //   162: aload_0
    //   163: ifnull -117 -> 46
    //   166: aload_0
    //   167: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   170: aload 6
    //   172: areturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_0
    //   178: aload 6
    //   180: astore_1
    //   181: ldc 82
    //   183: ldc 84
    //   185: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: new 36	com/huawei/hms/stats/aj
    //   191: dup
    //   192: bipush 155
    //   194: ldc 38
    //   196: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   199: astore_3
    //   200: aload_0
    //   201: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   204: aload_1
    //   205: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   208: aload_3
    //   209: astore_1
    //   210: aload_2
    //   211: ifnull -165 -> 46
    //   214: aload_2
    //   215: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   218: aload_3
    //   219: areturn
    //   220: astore_0
    //   221: bipush 154
    //   223: istore 4
    //   225: aconst_null
    //   226: astore_3
    //   227: aconst_null
    //   228: astore_2
    //   229: aload 7
    //   231: astore_0
    //   232: ldc 82
    //   234: ldc 92
    //   236: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: new 36	com/huawei/hms/stats/aj
    //   242: dup
    //   243: iload 4
    //   245: ldc 38
    //   247: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   250: astore 6
    //   252: aload_2
    //   253: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   256: aload_3
    //   257: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   260: aload 6
    //   262: astore_1
    //   263: aload_0
    //   264: ifnull -218 -> 46
    //   267: aload_0
    //   268: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   271: aload 6
    //   273: areturn
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_3
    //   279: aload 9
    //   281: astore_0
    //   282: aload_2
    //   283: astore 7
    //   285: aload_0
    //   286: astore 8
    //   288: aload_3
    //   289: astore 6
    //   291: ldc 82
    //   293: ldc 94
    //   295: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_2
    //   299: astore 7
    //   301: aload_0
    //   302: astore 8
    //   304: aload_3
    //   305: astore 6
    //   307: new 36	com/huawei/hms/stats/aj
    //   310: dup
    //   311: iload 5
    //   313: ldc 38
    //   315: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   318: astore 9
    //   320: aload_0
    //   321: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   324: aload_3
    //   325: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   328: aload 9
    //   330: astore_1
    //   331: aload_2
    //   332: ifnull -286 -> 46
    //   335: aload_2
    //   336: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   339: aload 9
    //   341: areturn
    //   342: astore_0
    //   343: aconst_null
    //   344: astore_2
    //   345: aconst_null
    //   346: astore_3
    //   347: aload 10
    //   349: astore_0
    //   350: aload_2
    //   351: astore 7
    //   353: aload_0
    //   354: astore 8
    //   356: aload_3
    //   357: astore 6
    //   359: ldc 82
    //   361: ldc 96
    //   363: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_2
    //   367: astore 7
    //   369: aload_0
    //   370: astore 8
    //   372: aload_3
    //   373: astore 6
    //   375: new 36	com/huawei/hms/stats/aj
    //   378: dup
    //   379: iload 5
    //   381: ldc 38
    //   383: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   386: astore 9
    //   388: aload_0
    //   389: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   392: aload_3
    //   393: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   396: aload 9
    //   398: astore_1
    //   399: aload_2
    //   400: ifnull -354 -> 46
    //   403: aload_2
    //   404: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   407: aload 9
    //   409: areturn
    //   410: astore_0
    //   411: aconst_null
    //   412: astore_2
    //   413: aconst_null
    //   414: astore_3
    //   415: aload 11
    //   417: astore_0
    //   418: aload_2
    //   419: astore 7
    //   421: aload_0
    //   422: astore 8
    //   424: aload_3
    //   425: astore 6
    //   427: ldc 82
    //   429: ldc 98
    //   431: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_2
    //   435: astore 7
    //   437: aload_0
    //   438: astore 8
    //   440: aload_3
    //   441: astore 6
    //   443: new 36	com/huawei/hms/stats/aj
    //   446: dup
    //   447: iload 5
    //   449: ldc 38
    //   451: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   454: astore 9
    //   456: aload_0
    //   457: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   460: aload_3
    //   461: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   464: aload 9
    //   466: astore_1
    //   467: aload_2
    //   468: ifnull -422 -> 46
    //   471: aload_2
    //   472: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   475: aload 9
    //   477: areturn
    //   478: astore_0
    //   479: aconst_null
    //   480: astore_2
    //   481: aconst_null
    //   482: astore_3
    //   483: aload 12
    //   485: astore_0
    //   486: aload_2
    //   487: astore 7
    //   489: aload_0
    //   490: astore 8
    //   492: aload_3
    //   493: astore 6
    //   495: ldc 82
    //   497: ldc 100
    //   499: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_2
    //   503: astore 7
    //   505: aload_0
    //   506: astore 8
    //   508: aload_3
    //   509: astore 6
    //   511: new 36	com/huawei/hms/stats/aj
    //   514: dup
    //   515: iload 5
    //   517: ldc 38
    //   519: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   522: astore 9
    //   524: aload_0
    //   525: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   528: aload_3
    //   529: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   532: aload 9
    //   534: astore_1
    //   535: aload_2
    //   536: ifnull -490 -> 46
    //   539: aload_2
    //   540: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   543: aload 9
    //   545: areturn
    //   546: astore_0
    //   547: aconst_null
    //   548: astore_2
    //   549: aconst_null
    //   550: astore_3
    //   551: aload 13
    //   553: astore_0
    //   554: aload_2
    //   555: astore 7
    //   557: aload_0
    //   558: astore 8
    //   560: aload_3
    //   561: astore 6
    //   563: ldc 82
    //   565: ldc 102
    //   567: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload_2
    //   571: astore 7
    //   573: aload_0
    //   574: astore 8
    //   576: aload_3
    //   577: astore 6
    //   579: new 36	com/huawei/hms/stats/aj
    //   582: dup
    //   583: iload 5
    //   585: ldc 38
    //   587: invokespecial 42	com/huawei/hms/stats/aj:<init>	(ILjava/lang/String;)V
    //   590: astore 9
    //   592: aload_0
    //   593: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   596: aload_3
    //   597: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   600: aload 9
    //   602: astore_1
    //   603: aload_2
    //   604: ifnull -558 -> 46
    //   607: aload_2
    //   608: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   611: aload 9
    //   613: areturn
    //   614: astore_1
    //   615: aconst_null
    //   616: astore_0
    //   617: aconst_null
    //   618: astore_3
    //   619: aload 8
    //   621: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   624: aload_3
    //   625: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   628: aload_0
    //   629: ifnull +7 -> 636
    //   632: aload_0
    //   633: invokestatic 53	com/huawei/hms/stats/ba:a	(Ljava/net/HttpURLConnection;)V
    //   636: aload_1
    //   637: athrow
    //   638: astore_1
    //   639: aconst_null
    //   640: astore_3
    //   641: goto -22 -> 619
    //   644: astore_1
    //   645: aload 7
    //   647: astore_0
    //   648: aload 6
    //   650: astore_3
    //   651: goto -32 -> 619
    //   654: astore_1
    //   655: aload_2
    //   656: astore 8
    //   658: goto -39 -> 619
    //   661: astore 6
    //   663: aload_0
    //   664: astore 8
    //   666: aload_1
    //   667: astore_3
    //   668: aload 6
    //   670: astore_1
    //   671: aload_2
    //   672: astore_0
    //   673: goto -54 -> 619
    //   676: astore_1
    //   677: aload_2
    //   678: astore 8
    //   680: goto -61 -> 619
    //   683: astore_1
    //   684: aconst_null
    //   685: astore_3
    //   686: aload_0
    //   687: astore_2
    //   688: aload 13
    //   690: astore_0
    //   691: goto -137 -> 554
    //   694: astore_1
    //   695: aload_0
    //   696: astore_2
    //   697: aload 13
    //   699: astore_0
    //   700: goto -146 -> 554
    //   703: astore_1
    //   704: aload_2
    //   705: astore_1
    //   706: aload_0
    //   707: astore_2
    //   708: aload_1
    //   709: astore_0
    //   710: goto -156 -> 554
    //   713: astore_1
    //   714: aload_2
    //   715: astore_1
    //   716: aload_0
    //   717: astore_2
    //   718: aload_1
    //   719: astore_0
    //   720: iload 4
    //   722: istore 5
    //   724: goto -170 -> 554
    //   727: astore_1
    //   728: aconst_null
    //   729: astore_3
    //   730: aload_0
    //   731: astore_2
    //   732: aload 12
    //   734: astore_0
    //   735: goto -249 -> 486
    //   738: astore_1
    //   739: aload_0
    //   740: astore_2
    //   741: aload 12
    //   743: astore_0
    //   744: goto -258 -> 486
    //   747: astore_1
    //   748: aload_2
    //   749: astore_1
    //   750: aload_0
    //   751: astore_2
    //   752: aload_1
    //   753: astore_0
    //   754: goto -268 -> 486
    //   757: astore_1
    //   758: aload_2
    //   759: astore_1
    //   760: aload_0
    //   761: astore_2
    //   762: aload_1
    //   763: astore_0
    //   764: iload 4
    //   766: istore 5
    //   768: goto -282 -> 486
    //   771: astore_1
    //   772: aconst_null
    //   773: astore_3
    //   774: aload_0
    //   775: astore_2
    //   776: aload 11
    //   778: astore_0
    //   779: goto -361 -> 418
    //   782: astore_1
    //   783: aload_0
    //   784: astore_2
    //   785: aload 11
    //   787: astore_0
    //   788: goto -370 -> 418
    //   791: astore_1
    //   792: aload_2
    //   793: astore_1
    //   794: aload_0
    //   795: astore_2
    //   796: aload_1
    //   797: astore_0
    //   798: goto -380 -> 418
    //   801: astore_1
    //   802: aload_2
    //   803: astore_1
    //   804: aload_0
    //   805: astore_2
    //   806: aload_1
    //   807: astore_0
    //   808: iload 4
    //   810: istore 5
    //   812: goto -394 -> 418
    //   815: astore_1
    //   816: aconst_null
    //   817: astore_3
    //   818: aload_0
    //   819: astore_2
    //   820: aload 10
    //   822: astore_0
    //   823: goto -473 -> 350
    //   826: astore_1
    //   827: aload_0
    //   828: astore_2
    //   829: aload 10
    //   831: astore_0
    //   832: goto -482 -> 350
    //   835: astore_1
    //   836: aload_2
    //   837: astore_1
    //   838: aload_0
    //   839: astore_2
    //   840: aload_1
    //   841: astore_0
    //   842: goto -492 -> 350
    //   845: astore_1
    //   846: aload_2
    //   847: astore_1
    //   848: aload_0
    //   849: astore_2
    //   850: aload_1
    //   851: astore_0
    //   852: iload 4
    //   854: istore 5
    //   856: goto -506 -> 350
    //   859: astore_1
    //   860: aconst_null
    //   861: astore_3
    //   862: aload_0
    //   863: astore_2
    //   864: aload 9
    //   866: astore_0
    //   867: goto -585 -> 282
    //   870: astore_1
    //   871: aload_0
    //   872: astore_2
    //   873: aload 9
    //   875: astore_0
    //   876: goto -594 -> 282
    //   879: astore_1
    //   880: aload_2
    //   881: astore_1
    //   882: aload_0
    //   883: astore_2
    //   884: aload_1
    //   885: astore_0
    //   886: goto -604 -> 282
    //   889: astore_1
    //   890: aload_2
    //   891: astore_1
    //   892: aload_0
    //   893: astore_2
    //   894: aload_1
    //   895: astore_0
    //   896: iload 4
    //   898: istore 5
    //   900: goto -618 -> 282
    //   903: astore_1
    //   904: aconst_null
    //   905: astore_3
    //   906: aconst_null
    //   907: astore_2
    //   908: bipush 154
    //   910: istore 4
    //   912: goto -680 -> 232
    //   915: astore_1
    //   916: aconst_null
    //   917: astore_2
    //   918: bipush 154
    //   920: istore 4
    //   922: goto -690 -> 232
    //   925: astore_1
    //   926: bipush 154
    //   928: istore 4
    //   930: goto -698 -> 232
    //   933: astore_1
    //   934: goto -702 -> 232
    //   937: astore_1
    //   938: aconst_null
    //   939: astore_3
    //   940: aload_0
    //   941: astore_2
    //   942: aload 6
    //   944: astore_1
    //   945: aload_3
    //   946: astore_0
    //   947: goto -766 -> 181
    //   950: astore_1
    //   951: aconst_null
    //   952: astore 6
    //   954: aload_3
    //   955: astore_1
    //   956: aload_0
    //   957: astore_2
    //   958: aload 6
    //   960: astore_0
    //   961: goto -780 -> 181
    //   964: astore_1
    //   965: aload_3
    //   966: astore_1
    //   967: aload_2
    //   968: astore_3
    //   969: aload_0
    //   970: astore_2
    //   971: aload_3
    //   972: astore_0
    //   973: goto -792 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	976	0	paramString1	String
    //   0	976	1	paramArrayOfByte	byte[]
    //   0	976	2	paramMap	Map<String, String>
    //   0	976	3	paramString2	String
    //   134	795	4	i	int
    //   50	849	5	j	int
    //   25	624	6	localObject1	Object
    //   661	282	6	localObject2	Object
    //   952	7	6	localObject3	Object
    //   1	645	7	localObject4	Object
    //   19	660	8	localObject5	Object
    //   4	870	9	localaj	aj
    //   7	823	10	localObject6	Object
    //   10	776	11	localObject7	Object
    //   13	729	12	localObject8	Object
    //   16	682	13	localObject9	Object
    //   22	84	14	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   52	61	173	com/huawei/hms/stats/ai$a
    //   52	61	220	java/lang/SecurityException
    //   52	61	274	javax/net/ssl/SSLPeerUnverifiedException
    //   52	61	342	javax/net/ssl/SSLHandshakeException
    //   52	61	410	java/net/ConnectException
    //   52	61	478	java/net/UnknownHostException
    //   52	61	546	java/io/IOException
    //   52	61	614	finally
    //   65	77	638	finally
    //   97	102	638	finally
    //   112	121	644	finally
    //   291	298	644	finally
    //   307	320	644	finally
    //   359	366	644	finally
    //   375	388	644	finally
    //   427	434	644	finally
    //   443	456	644	finally
    //   495	502	644	finally
    //   511	524	644	finally
    //   563	570	644	finally
    //   579	592	644	finally
    //   121	136	654	finally
    //   136	151	654	finally
    //   181	200	661	finally
    //   232	252	676	finally
    //   65	77	683	java/io/IOException
    //   97	102	683	java/io/IOException
    //   112	121	694	java/io/IOException
    //   121	136	703	java/io/IOException
    //   136	151	713	java/io/IOException
    //   65	77	727	java/net/UnknownHostException
    //   97	102	727	java/net/UnknownHostException
    //   112	121	738	java/net/UnknownHostException
    //   121	136	747	java/net/UnknownHostException
    //   136	151	757	java/net/UnknownHostException
    //   65	77	771	java/net/ConnectException
    //   97	102	771	java/net/ConnectException
    //   112	121	782	java/net/ConnectException
    //   121	136	791	java/net/ConnectException
    //   136	151	801	java/net/ConnectException
    //   65	77	815	javax/net/ssl/SSLHandshakeException
    //   97	102	815	javax/net/ssl/SSLHandshakeException
    //   112	121	826	javax/net/ssl/SSLHandshakeException
    //   121	136	835	javax/net/ssl/SSLHandshakeException
    //   136	151	845	javax/net/ssl/SSLHandshakeException
    //   65	77	859	javax/net/ssl/SSLPeerUnverifiedException
    //   97	102	859	javax/net/ssl/SSLPeerUnverifiedException
    //   112	121	870	javax/net/ssl/SSLPeerUnverifiedException
    //   121	136	879	javax/net/ssl/SSLPeerUnverifiedException
    //   136	151	889	javax/net/ssl/SSLPeerUnverifiedException
    //   65	77	903	java/lang/SecurityException
    //   97	102	903	java/lang/SecurityException
    //   112	121	915	java/lang/SecurityException
    //   121	136	925	java/lang/SecurityException
    //   136	151	933	java/lang/SecurityException
    //   65	77	937	com/huawei/hms/stats/ai$a
    //   97	102	937	com/huawei/hms/stats/ai$a
    //   112	121	950	com/huawei/hms/stats/ai$a
    //   121	136	964	com/huawei/hms/stats/ai$a
    //   136	151	964	com/huawei/hms/stats/ai$a
  }
  
  private static HttpURLConnection a(String paramString1, int paramInt, Map<String, String> paramMap, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      af.d("HttpClient", "CreateConnection: invalid urlPath.");
      paramString1 = null;
    }
    HttpURLConnection localHttpURLConnection;
    do
    {
      do
      {
        return paramString1;
        localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
        a(localHttpURLConnection);
        localHttpURLConnection.setRequestMethod(paramString2);
        localHttpURLConnection.setConnectTimeout(15000);
        localHttpURLConnection.setReadTimeout(15000);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(paramInt));
        localHttpURLConnection.setRequestProperty("Connection", "close");
        paramString1 = localHttpURLConnection;
      } while (paramMap == null);
      paramString1 = localHttpURLConnection;
    } while (paramMap.size() < 1);
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      paramString1 = localHttpURLConnection;
      if (!paramMap.hasNext()) {
        break;
      }
      paramString1 = (Map.Entry)paramMap.next();
      paramString2 = (String)paramString1.getKey();
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2))) {
        localHttpURLConnection.setRequestProperty(paramString2, (String)paramString1.getValue());
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
  {
    if ((paramHttpURLConnection instanceof HttpsURLConnection))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      SocketFactory localSocketFactory = ah.a(b.j());
      if ((localSocketFactory != null) && ((localSocketFactory instanceof SSLSocketFactory)))
      {
        paramHttpURLConnection.setSSLSocketFactory((SSLSocketFactory)localSocketFactory);
        paramHttpURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
      }
    }
    else
    {
      return;
    }
    throw new ai.a("No ssl socket factory set");
  }
  
  /* Error */
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 219	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6: astore_3
    //   7: aload_3
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 222	com/huawei/hms/stats/ba:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   13: astore_3
    //   14: aload_2
    //   15: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   18: aload_3
    //   19: areturn
    //   20: astore_3
    //   21: aload_0
    //   22: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
    //   25: istore_1
    //   26: ldc 82
    //   28: new 224	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   35: ldc 227
    //   37: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_1
    //   41: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 90	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_2
    //   51: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   54: ldc 38
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 50	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: athrow
    //   66: astore_0
    //   67: goto -7 -> 60
    //   70: astore_0
    //   71: goto -11 -> 60
    //   74: astore_3
    //   75: goto -54 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramHttpURLConnection	HttpURLConnection
    //   25	16	1	i	int
    //   1	60	2	localObject1	Object
    //   6	13	3	localObject2	Object
    //   20	1	3	localIOException1	java.io.IOException
    //   74	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	7	20	java/io/IOException
    //   2	7	57	finally
    //   9	14	66	finally
    //   21	50	70	finally
    //   9	14	74	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ai
 * JD-Core Version:    0.7.0.1
 */