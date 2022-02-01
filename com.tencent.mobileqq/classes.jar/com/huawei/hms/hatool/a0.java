package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public abstract class a0
{
  public static b0 a(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    return a(paramString, paramArrayOfByte, paramMap, "POST");
  }
  
  /* Error */
  public static b0 a(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: new 36	com/huawei/hms/hatool/b0
    //   10: dup
    //   11: bipush 156
    //   13: ldc 38
    //   15: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   18: areturn
    //   19: bipush 154
    //   21: istore 4
    //   23: aconst_null
    //   24: astore 6
    //   26: aload_0
    //   27: aload_1
    //   28: arraylength
    //   29: aload_2
    //   30: aload_3
    //   31: invokestatic 45	com/huawei/hms/hatool/a0:a	(Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +33 -> 69
    //   39: new 36	com/huawei/hms/hatool/b0
    //   42: dup
    //   43: bipush 155
    //   45: ldc 38
    //   47: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   50: astore_1
    //   51: aconst_null
    //   52: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   55: aconst_null
    //   56: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: invokevirtual 59	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   73: astore_2
    //   74: new 61	java/io/BufferedOutputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: astore 8
    //   84: aload_0
    //   85: astore_3
    //   86: aload_2
    //   87: astore 6
    //   89: aload 8
    //   91: astore 7
    //   93: aload 8
    //   95: aload_1
    //   96: invokevirtual 68	java/io/BufferedOutputStream:write	([B)V
    //   99: aload_0
    //   100: astore_3
    //   101: aload_2
    //   102: astore 6
    //   104: aload 8
    //   106: astore 7
    //   108: aload 8
    //   110: invokevirtual 72	java/io/BufferedOutputStream:flush	()V
    //   113: aload_0
    //   114: astore_3
    //   115: aload_2
    //   116: astore 6
    //   118: aload 8
    //   120: astore 7
    //   122: aload_0
    //   123: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
    //   126: istore 5
    //   128: aload_0
    //   129: astore_3
    //   130: aload_2
    //   131: astore 6
    //   133: aload 8
    //   135: astore 7
    //   137: new 36	com/huawei/hms/hatool/b0
    //   140: dup
    //   141: iload 5
    //   143: aload_0
    //   144: invokestatic 80	com/huawei/hms/hatool/a0:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   147: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   150: astore_1
    //   151: aload 8
    //   153: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   156: aload_2
    //   157: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   168: aload_1
    //   169: areturn
    //   170: iload 5
    //   172: istore 4
    //   174: goto +119 -> 293
    //   177: iload 5
    //   179: istore 4
    //   181: goto +175 -> 356
    //   184: iload 5
    //   186: istore 4
    //   188: goto +231 -> 419
    //   191: iload 5
    //   193: istore 4
    //   195: goto +287 -> 482
    //   198: iload 5
    //   200: istore 4
    //   202: goto +343 -> 545
    //   205: iload 5
    //   207: istore 4
    //   209: goto +399 -> 608
    //   212: astore 7
    //   214: aload 6
    //   216: astore_1
    //   217: aload_0
    //   218: astore_3
    //   219: aload 7
    //   221: astore_0
    //   222: goto +512 -> 734
    //   225: astore 7
    //   227: aconst_null
    //   228: astore_2
    //   229: aload 6
    //   231: astore_1
    //   232: aload_0
    //   233: astore_3
    //   234: aload 7
    //   236: astore_0
    //   237: goto +497 -> 734
    //   240: aconst_null
    //   241: astore_2
    //   242: goto +48 -> 290
    //   245: aconst_null
    //   246: astore_2
    //   247: goto +106 -> 353
    //   250: aconst_null
    //   251: astore_2
    //   252: goto +164 -> 416
    //   255: aconst_null
    //   256: astore_2
    //   257: goto +222 -> 479
    //   260: aconst_null
    //   261: astore_2
    //   262: goto +280 -> 542
    //   265: aconst_null
    //   266: astore_2
    //   267: goto +338 -> 605
    //   270: aconst_null
    //   271: astore_2
    //   272: goto +396 -> 668
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_3
    //   279: astore_2
    //   280: aload 6
    //   282: astore_1
    //   283: goto +451 -> 734
    //   286: aconst_null
    //   287: astore_0
    //   288: aload_0
    //   289: astore_2
    //   290: aconst_null
    //   291: astore 8
    //   293: aload_0
    //   294: astore_3
    //   295: aload_2
    //   296: astore 6
    //   298: aload 8
    //   300: astore 7
    //   302: ldc 82
    //   304: ldc 84
    //   306: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: astore_3
    //   311: aload_2
    //   312: astore 6
    //   314: aload 8
    //   316: astore 7
    //   318: new 36	com/huawei/hms/hatool/b0
    //   321: dup
    //   322: iload 4
    //   324: ldc 38
    //   326: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   329: astore_1
    //   330: aload 8
    //   332: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   335: aload_2
    //   336: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   347: aload_1
    //   348: areturn
    //   349: aconst_null
    //   350: astore_0
    //   351: aload_0
    //   352: astore_2
    //   353: aconst_null
    //   354: astore 8
    //   356: aload_0
    //   357: astore_3
    //   358: aload_2
    //   359: astore 6
    //   361: aload 8
    //   363: astore 7
    //   365: ldc 82
    //   367: ldc 92
    //   369: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: astore_3
    //   374: aload_2
    //   375: astore 6
    //   377: aload 8
    //   379: astore 7
    //   381: new 36	com/huawei/hms/hatool/b0
    //   384: dup
    //   385: iload 4
    //   387: ldc 38
    //   389: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   392: astore_1
    //   393: aload 8
    //   395: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   398: aload_2
    //   399: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   402: aload_0
    //   403: ifnull +7 -> 410
    //   406: aload_0
    //   407: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   410: aload_1
    //   411: areturn
    //   412: aconst_null
    //   413: astore_0
    //   414: aload_0
    //   415: astore_2
    //   416: aconst_null
    //   417: astore 8
    //   419: aload_0
    //   420: astore_3
    //   421: aload_2
    //   422: astore 6
    //   424: aload 8
    //   426: astore 7
    //   428: ldc 82
    //   430: ldc 94
    //   432: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_0
    //   436: astore_3
    //   437: aload_2
    //   438: astore 6
    //   440: aload 8
    //   442: astore 7
    //   444: new 36	com/huawei/hms/hatool/b0
    //   447: dup
    //   448: iload 4
    //   450: ldc 38
    //   452: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   455: astore_1
    //   456: aload 8
    //   458: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   461: aload_2
    //   462: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   465: aload_0
    //   466: ifnull +7 -> 473
    //   469: aload_0
    //   470: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   473: aload_1
    //   474: areturn
    //   475: aconst_null
    //   476: astore_0
    //   477: aload_0
    //   478: astore_2
    //   479: aconst_null
    //   480: astore 8
    //   482: aload_0
    //   483: astore_3
    //   484: aload_2
    //   485: astore 6
    //   487: aload 8
    //   489: astore 7
    //   491: ldc 82
    //   493: ldc 96
    //   495: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload_0
    //   499: astore_3
    //   500: aload_2
    //   501: astore 6
    //   503: aload 8
    //   505: astore 7
    //   507: new 36	com/huawei/hms/hatool/b0
    //   510: dup
    //   511: iload 4
    //   513: ldc 38
    //   515: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   518: astore_1
    //   519: aload 8
    //   521: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   524: aload_2
    //   525: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   528: aload_0
    //   529: ifnull +7 -> 536
    //   532: aload_0
    //   533: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   536: aload_1
    //   537: areturn
    //   538: aconst_null
    //   539: astore_0
    //   540: aload_0
    //   541: astore_2
    //   542: aconst_null
    //   543: astore 8
    //   545: aload_0
    //   546: astore_3
    //   547: aload_2
    //   548: astore 6
    //   550: aload 8
    //   552: astore 7
    //   554: ldc 82
    //   556: ldc 98
    //   558: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload_0
    //   562: astore_3
    //   563: aload_2
    //   564: astore 6
    //   566: aload 8
    //   568: astore 7
    //   570: new 36	com/huawei/hms/hatool/b0
    //   573: dup
    //   574: iload 4
    //   576: ldc 38
    //   578: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   581: astore_1
    //   582: aload 8
    //   584: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   587: aload_2
    //   588: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   591: aload_0
    //   592: ifnull +7 -> 599
    //   595: aload_0
    //   596: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   599: aload_1
    //   600: areturn
    //   601: aconst_null
    //   602: astore_0
    //   603: aload_0
    //   604: astore_2
    //   605: aconst_null
    //   606: astore 8
    //   608: aload_0
    //   609: astore_3
    //   610: aload_2
    //   611: astore 6
    //   613: aload 8
    //   615: astore 7
    //   617: ldc 82
    //   619: ldc 100
    //   621: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload_0
    //   625: astore_3
    //   626: aload_2
    //   627: astore 6
    //   629: aload 8
    //   631: astore 7
    //   633: new 36	com/huawei/hms/hatool/b0
    //   636: dup
    //   637: iload 4
    //   639: ldc 38
    //   641: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   644: astore_1
    //   645: aload 8
    //   647: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   650: aload_2
    //   651: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   654: aload_0
    //   655: ifnull +7 -> 662
    //   658: aload_0
    //   659: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   662: aload_1
    //   663: areturn
    //   664: aconst_null
    //   665: astore_0
    //   666: aload_0
    //   667: astore_2
    //   668: aconst_null
    //   669: astore 8
    //   671: aload_0
    //   672: astore_3
    //   673: aload_2
    //   674: astore 6
    //   676: aload 8
    //   678: astore 7
    //   680: ldc 82
    //   682: ldc 102
    //   684: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: aload_0
    //   688: astore_3
    //   689: aload_2
    //   690: astore 6
    //   692: aload 8
    //   694: astore 7
    //   696: new 36	com/huawei/hms/hatool/b0
    //   699: dup
    //   700: bipush 155
    //   702: ldc 38
    //   704: invokespecial 42	com/huawei/hms/hatool/b0:<init>	(ILjava/lang/String;)V
    //   707: astore_1
    //   708: aload 8
    //   710: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   713: aload_2
    //   714: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   717: aload_0
    //   718: ifnull +7 -> 725
    //   721: aload_0
    //   722: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   725: aload_1
    //   726: areturn
    //   727: astore_0
    //   728: aload 7
    //   730: astore_1
    //   731: aload 6
    //   733: astore_2
    //   734: aload_1
    //   735: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   738: aload_2
    //   739: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   742: aload_3
    //   743: ifnull +7 -> 750
    //   746: aload_3
    //   747: invokestatic 53	com/huawei/hms/hatool/r0:a	(Ljava/net/HttpURLConnection;)V
    //   750: aload_0
    //   751: athrow
    //   752: astore_0
    //   753: goto -89 -> 664
    //   756: astore_0
    //   757: goto -156 -> 601
    //   760: astore_0
    //   761: goto -223 -> 538
    //   764: astore_0
    //   765: goto -290 -> 475
    //   768: astore_0
    //   769: goto -357 -> 412
    //   772: astore_0
    //   773: goto -424 -> 349
    //   776: astore_0
    //   777: goto -491 -> 286
    //   780: astore_1
    //   781: goto -511 -> 270
    //   784: astore_1
    //   785: goto -520 -> 265
    //   788: astore_1
    //   789: goto -529 -> 260
    //   792: astore_1
    //   793: goto -538 -> 255
    //   796: astore_1
    //   797: goto -547 -> 250
    //   800: astore_1
    //   801: goto -556 -> 245
    //   804: astore_1
    //   805: goto -565 -> 240
    //   808: astore_1
    //   809: goto -141 -> 668
    //   812: astore_1
    //   813: goto -208 -> 605
    //   816: astore_1
    //   817: goto -275 -> 542
    //   820: astore_1
    //   821: goto -342 -> 479
    //   824: astore_1
    //   825: goto -409 -> 416
    //   828: astore_1
    //   829: goto -476 -> 353
    //   832: astore_1
    //   833: goto -543 -> 290
    //   836: astore_1
    //   837: goto -166 -> 671
    //   840: astore_1
    //   841: goto -233 -> 608
    //   844: astore_1
    //   845: goto -300 -> 545
    //   848: astore_1
    //   849: goto -367 -> 482
    //   852: astore_1
    //   853: goto -434 -> 419
    //   856: astore_1
    //   857: goto -501 -> 356
    //   860: astore_1
    //   861: goto -568 -> 293
    //   864: astore_1
    //   865: goto -660 -> 205
    //   868: astore_1
    //   869: goto -671 -> 198
    //   872: astore_1
    //   873: goto -682 -> 191
    //   876: astore_1
    //   877: goto -693 -> 184
    //   880: astore_1
    //   881: goto -704 -> 177
    //   884: astore_1
    //   885: goto -715 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	888	0	paramString1	String
    //   0	888	1	paramArrayOfByte	byte[]
    //   0	888	2	paramMap	Map<String, String>
    //   0	888	3	paramString2	String
    //   21	617	4	i	int
    //   126	80	5	j	int
    //   24	708	6	localMap	Map<String, String>
    //   91	45	7	localBufferedOutputStream1	java.io.BufferedOutputStream
    //   212	8	7	localObject1	Object
    //   225	10	7	localObject2	Object
    //   300	429	7	localBufferedOutputStream2	java.io.BufferedOutputStream
    //   82	627	8	localBufferedOutputStream3	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   74	84	212	finally
    //   39	51	225	finally
    //   69	74	225	finally
    //   26	35	275	finally
    //   93	99	727	finally
    //   108	113	727	finally
    //   122	128	727	finally
    //   137	151	727	finally
    //   302	309	727	finally
    //   318	330	727	finally
    //   365	372	727	finally
    //   381	393	727	finally
    //   428	435	727	finally
    //   444	456	727	finally
    //   491	498	727	finally
    //   507	519	727	finally
    //   554	561	727	finally
    //   570	582	727	finally
    //   617	624	727	finally
    //   633	645	727	finally
    //   680	687	727	finally
    //   696	708	727	finally
    //   26	35	752	com/huawei/hms/hatool/a0$a
    //   26	35	756	java/lang/SecurityException
    //   26	35	760	javax/net/ssl/SSLPeerUnverifiedException
    //   26	35	764	javax/net/ssl/SSLHandshakeException
    //   26	35	768	java/net/ConnectException
    //   26	35	772	java/net/UnknownHostException
    //   26	35	776	java/io/IOException
    //   39	51	780	com/huawei/hms/hatool/a0$a
    //   69	74	780	com/huawei/hms/hatool/a0$a
    //   39	51	784	java/lang/SecurityException
    //   69	74	784	java/lang/SecurityException
    //   39	51	788	javax/net/ssl/SSLPeerUnverifiedException
    //   69	74	788	javax/net/ssl/SSLPeerUnverifiedException
    //   39	51	792	javax/net/ssl/SSLHandshakeException
    //   69	74	792	javax/net/ssl/SSLHandshakeException
    //   39	51	796	java/net/ConnectException
    //   69	74	796	java/net/ConnectException
    //   39	51	800	java/net/UnknownHostException
    //   69	74	800	java/net/UnknownHostException
    //   39	51	804	java/io/IOException
    //   69	74	804	java/io/IOException
    //   74	84	808	com/huawei/hms/hatool/a0$a
    //   74	84	812	java/lang/SecurityException
    //   74	84	816	javax/net/ssl/SSLPeerUnverifiedException
    //   74	84	820	javax/net/ssl/SSLHandshakeException
    //   74	84	824	java/net/ConnectException
    //   74	84	828	java/net/UnknownHostException
    //   74	84	832	java/io/IOException
    //   93	99	836	com/huawei/hms/hatool/a0$a
    //   108	113	836	com/huawei/hms/hatool/a0$a
    //   122	128	836	com/huawei/hms/hatool/a0$a
    //   137	151	836	com/huawei/hms/hatool/a0$a
    //   93	99	840	java/lang/SecurityException
    //   108	113	840	java/lang/SecurityException
    //   122	128	840	java/lang/SecurityException
    //   93	99	844	javax/net/ssl/SSLPeerUnverifiedException
    //   108	113	844	javax/net/ssl/SSLPeerUnverifiedException
    //   122	128	844	javax/net/ssl/SSLPeerUnverifiedException
    //   93	99	848	javax/net/ssl/SSLHandshakeException
    //   108	113	848	javax/net/ssl/SSLHandshakeException
    //   122	128	848	javax/net/ssl/SSLHandshakeException
    //   93	99	852	java/net/ConnectException
    //   108	113	852	java/net/ConnectException
    //   122	128	852	java/net/ConnectException
    //   93	99	856	java/net/UnknownHostException
    //   108	113	856	java/net/UnknownHostException
    //   122	128	856	java/net/UnknownHostException
    //   93	99	860	java/io/IOException
    //   108	113	860	java/io/IOException
    //   122	128	860	java/io/IOException
    //   137	151	864	java/lang/SecurityException
    //   137	151	868	javax/net/ssl/SSLPeerUnverifiedException
    //   137	151	872	javax/net/ssl/SSLHandshakeException
    //   137	151	876	java/net/ConnectException
    //   137	151	880	java/net/UnknownHostException
    //   137	151	884	java/io/IOException
  }
  
  public static HttpURLConnection a(String paramString1, int paramInt, Map<String, String> paramMap, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      y.b("hmsSdk", "CreateConnection: invalid urlPath.");
      return null;
    }
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    a(paramString1);
    paramString1.setRequestMethod(paramString2);
    paramString1.setConnectTimeout(15000);
    paramString1.setReadTimeout(15000);
    paramString1.setDoOutput(true);
    paramString1.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    paramString1.setRequestProperty("Content-Length", String.valueOf(paramInt));
    paramString1.setRequestProperty("Connection", "close");
    if (paramMap != null)
    {
      if (paramMap.size() < 1) {
        return paramString1;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramString2 = (Map.Entry)paramMap.next();
        String str = (String)paramString2.getKey();
        if ((str != null) && (!TextUtils.isEmpty(str))) {
          paramString1.setRequestProperty(str, (String)paramString2.getValue());
        }
      }
    }
    return paramString1;
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    HttpsURLConnection localHttpsURLConnection;
    Object localObject;
    if ((paramHttpURLConnection instanceof HttpsURLConnection))
    {
      localHttpsURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      localObject = null;
    }
    try
    {
      paramHttpURLConnection = SecureSSLSocketFactory.getInstance(b.f());
    }
    catch (NoSuchAlgorithmException paramHttpURLConnection)
    {
      break label48;
    }
    catch (KeyStoreException paramHttpURLConnection)
    {
      break label42;
    }
    catch (GeneralSecurityException paramHttpURLConnection)
    {
      break label36;
    }
    catch (IOException paramHttpURLConnection)
    {
      break label30;
    }
    catch (IllegalAccessException paramHttpURLConnection)
    {
      label24:
      label30:
      break label24;
    }
    paramHttpURLConnection = "getSocketFactory(): Illegal Access Exception ";
    break label51;
    paramHttpURLConnection = "getSocketFactory(): IO Exception!";
    break label51;
    label36:
    paramHttpURLConnection = "getSocketFactory(): General Security Exception";
    break label51;
    label42:
    paramHttpURLConnection = "getSocketFactory(): Key Store exception";
    break label51;
    label48:
    paramHttpURLConnection = "getSocketFactory(): Algorithm Exception!";
    label51:
    y.f("hmsSdk", paramHttpURLConnection);
    paramHttpURLConnection = localObject;
    if (paramHttpURLConnection != null)
    {
      localHttpsURLConnection.setSSLSocketFactory(paramHttpURLConnection);
      localHttpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
      return;
    }
    throw new a0.a("No ssl socket factory set");
  }
  
  /* Error */
  public static String b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 234	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload 4
    //   12: astore_2
    //   13: aload 4
    //   15: astore_3
    //   16: aload 4
    //   18: invokestatic 237	com/huawei/hms/hatool/r0:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   21: astore 5
    //   23: aload 4
    //   25: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   28: aload 5
    //   30: areturn
    //   31: astore_0
    //   32: goto +55 -> 87
    //   35: aload_3
    //   36: astore_2
    //   37: aload_0
    //   38: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
    //   41: istore_1
    //   42: aload_3
    //   43: astore_2
    //   44: new 239	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   51: astore_0
    //   52: aload_3
    //   53: astore_2
    //   54: aload_0
    //   55: ldc 242
    //   57: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: iload_1
    //   65: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: astore_2
    //   71: ldc 82
    //   73: aload_0
    //   74: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 90	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_3
    //   81: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   84: ldc 38
    //   86: areturn
    //   87: aload_2
    //   88: invokestatic 50	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_2
    //   94: goto -59 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramHttpURLConnection	HttpURLConnection
    //   41	24	1	i	int
    //   3	85	2	localObject1	Object
    //   93	1	2	localIOException	IOException
    //   1	80	3	localObject2	Object
    //   8	16	4	localInputStream	java.io.InputStream
    //   21	8	5	str	String
    // Exception table:
    //   from	to	target	type
    //   4	10	31	finally
    //   16	23	31	finally
    //   37	42	31	finally
    //   44	52	31	finally
    //   54	61	31	finally
    //   63	69	31	finally
    //   71	80	31	finally
    //   4	10	93	java/io/IOException
    //   16	23	93	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.a0
 * JD-Core Version:    0.7.0.1
 */