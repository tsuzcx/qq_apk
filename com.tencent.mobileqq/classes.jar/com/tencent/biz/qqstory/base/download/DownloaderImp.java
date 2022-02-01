package com.tencent.biz.qqstory.base.download;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(14)
public class DownloaderImp
  implements Downloader
{
  protected int a;
  protected DownloadProgressListener a;
  protected String a;
  protected volatile boolean a;
  protected volatile boolean b = false;
  
  public DownloaderImp()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 10;
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, int paramInt, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 21	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Boolean	Z
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 23	com/tencent/biz/qqstory/base/download/DownloaderImp:b	Z
    //   10: aload_0
    //   11: aload_2
    //   12: putfield 25	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: new 45	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   22: astore 28
    //   24: aload 28
    //   26: ldc 48
    //   28: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 28
    //   34: aload_2
    //   35: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 54
    //   41: aload 28
    //   43: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 63	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: new 45	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   56: astore 28
    //   58: aload 28
    //   60: ldc 65
    //   62: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 28
    //   68: aload_1
    //   69: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 54
    //   75: aload 28
    //   77: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 63	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield 67	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   87: astore 28
    //   89: aload 28
    //   91: ifnull +12 -> 103
    //   94: aload 28
    //   96: aload_1
    //   97: aload_2
    //   98: invokeinterface 71 3 0
    //   103: iload 4
    //   105: ifle +10 -> 115
    //   108: iload 4
    //   110: istore 14
    //   112: goto +7 -> 119
    //   115: ldc 72
    //   117: istore 14
    //   119: aconst_null
    //   120: astore 31
    //   122: new 74	java/net/URL
    //   125: dup
    //   126: aload_1
    //   127: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
    //   130: astore 28
    //   132: aload 28
    //   134: astore 56
    //   136: aload 28
    //   138: invokestatic 82	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Z
    //   141: ifne +10 -> 151
    //   144: aload 28
    //   146: invokestatic 85	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Ljava/net/URL;
    //   149: astore 56
    //   151: aload_2
    //   152: invokestatic 91	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   155: astore 28
    //   157: aload 28
    //   159: invokevirtual 97	java/io/File:exists	()Z
    //   162: ifne +9 -> 171
    //   165: aload 28
    //   167: invokevirtual 100	java/io/File:createNewFile	()Z
    //   170: pop
    //   171: new 102	java/io/RandomAccessFile
    //   174: dup
    //   175: aload 28
    //   177: ldc 104
    //   179: invokespecial 107	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: astore 28
    //   184: aconst_null
    //   185: astore 29
    //   187: iconst_0
    //   188: istore 4
    //   190: iconst_0
    //   191: istore 8
    //   193: iload 4
    //   195: aload_0
    //   196: getfield 27	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Int	I
    //   199: if_icmple +9 -> 208
    //   202: aload 28
    //   204: astore_3
    //   205: goto +852 -> 1057
    //   208: aload_0
    //   209: getfield 21	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Boolean	Z
    //   212: ifeq +13 -> 225
    //   215: aload 28
    //   217: astore_3
    //   218: bipush 6
    //   220: istore 8
    //   222: goto +835 -> 1057
    //   225: aload_0
    //   226: aload 31
    //   228: aload 29
    //   230: invokespecial 110	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   233: aload 56
    //   235: invokevirtual 114	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   238: checkcast 116	java/net/HttpURLConnection
    //   241: astore 30
    //   243: aload 30
    //   245: iconst_0
    //   246: invokevirtual 120	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   249: aload 30
    //   251: sipush 5000
    //   254: invokevirtual 124	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   257: aload 30
    //   259: sipush 5000
    //   262: invokevirtual 127	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   265: aload 30
    //   267: ldc 129
    //   269: ldc 131
    //   271: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_3
    //   275: aload 30
    //   277: invokestatic 137	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/util/HashMap;Ljava/net/HttpURLConnection;)V
    //   280: aload 28
    //   282: lload 5
    //   284: invokevirtual 141	java/io/RandomAccessFile:seek	(J)V
    //   287: new 45	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   294: astore 31
    //   296: iload 4
    //   298: istore 9
    //   300: aload 31
    //   302: ldc 143
    //   304: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 31
    //   310: lload 5
    //   312: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 31
    //   318: ldc 148
    //   320: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 30
    //   326: ldc 150
    //   328: aload 31
    //   330: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: new 45	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   343: astore 31
    //   345: aload 31
    //   347: ldc 152
    //   349: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 31
    //   355: lload 5
    //   357: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: ldc 54
    //   363: aload 31
    //   365: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 63	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 30
    //   373: invokevirtual 156	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   376: astore 31
    //   378: aload 28
    //   380: astore 40
    //   382: aload 31
    //   384: astore 32
    //   386: aload 28
    //   388: astore 41
    //   390: aload 31
    //   392: astore 33
    //   394: aload 28
    //   396: astore 42
    //   398: aload 31
    //   400: astore 34
    //   402: aload 28
    //   404: astore 43
    //   406: aload 31
    //   408: astore 35
    //   410: lload 5
    //   412: lstore 17
    //   414: aload 28
    //   416: astore 44
    //   418: aload 31
    //   420: astore 36
    //   422: iload 9
    //   424: istore 10
    //   426: lload 5
    //   428: lstore 19
    //   430: aload 28
    //   432: astore 45
    //   434: aload 31
    //   436: astore 37
    //   438: iload 9
    //   440: istore 11
    //   442: lload 5
    //   444: lstore 21
    //   446: aload 28
    //   448: astore 46
    //   450: aload 31
    //   452: astore 38
    //   454: iload 9
    //   456: istore 12
    //   458: lload 5
    //   460: lstore 23
    //   462: aload 28
    //   464: astore 47
    //   466: aload 31
    //   468: astore 39
    //   470: iload 9
    //   472: istore 13
    //   474: aload 30
    //   476: invokevirtual 160	java/net/HttpURLConnection:getContentLength	()I
    //   479: i2l
    //   480: lstore 25
    //   482: aload 28
    //   484: astore 40
    //   486: aload 31
    //   488: astore 32
    //   490: aload 28
    //   492: astore 41
    //   494: aload 31
    //   496: astore 33
    //   498: aload 28
    //   500: astore 42
    //   502: aload 31
    //   504: astore 34
    //   506: aload 28
    //   508: astore 43
    //   510: aload 31
    //   512: astore 35
    //   514: lload 5
    //   516: lstore 17
    //   518: aload 28
    //   520: astore 44
    //   522: aload 31
    //   524: astore 36
    //   526: iload 9
    //   528: istore 10
    //   530: lload 5
    //   532: lstore 19
    //   534: aload 28
    //   536: astore 45
    //   538: aload 31
    //   540: astore 37
    //   542: iload 9
    //   544: istore 11
    //   546: lload 5
    //   548: lstore 21
    //   550: aload 28
    //   552: astore 46
    //   554: aload 31
    //   556: astore 38
    //   558: iload 9
    //   560: istore 12
    //   562: lload 5
    //   564: lstore 23
    //   566: aload 28
    //   568: astore 47
    //   570: aload 31
    //   572: astore 39
    //   574: iload 9
    //   576: istore 13
    //   578: iload 14
    //   580: newarray byte
    //   582: astore 48
    //   584: iload 9
    //   586: istore 4
    //   588: aload 31
    //   590: astore 29
    //   592: lload 5
    //   594: lstore 15
    //   596: aload 48
    //   598: astore 31
    //   600: aload 28
    //   602: astore 40
    //   604: aload 29
    //   606: astore 32
    //   608: aload 28
    //   610: astore 41
    //   612: aload 29
    //   614: astore 33
    //   616: aload 28
    //   618: astore 42
    //   620: aload 29
    //   622: astore 34
    //   624: aload 28
    //   626: astore 43
    //   628: aload 29
    //   630: astore 35
    //   632: lload 15
    //   634: lstore 17
    //   636: aload 28
    //   638: astore 44
    //   640: aload 29
    //   642: astore 36
    //   644: iload 4
    //   646: istore 10
    //   648: lload 15
    //   650: lstore 19
    //   652: aload 28
    //   654: astore 45
    //   656: aload 29
    //   658: astore 37
    //   660: iload 4
    //   662: istore 11
    //   664: lload 15
    //   666: lstore 21
    //   668: aload 28
    //   670: astore 46
    //   672: aload 29
    //   674: astore 38
    //   676: iload 4
    //   678: istore 12
    //   680: lload 15
    //   682: lstore 23
    //   684: aload 28
    //   686: astore 47
    //   688: aload 29
    //   690: astore 39
    //   692: iload 4
    //   694: istore 13
    //   696: aload 29
    //   698: aload 31
    //   700: invokevirtual 166	java/io/InputStream:read	([B)I
    //   703: istore 9
    //   705: iload 9
    //   707: iconst_m1
    //   708: if_icmpeq +322 -> 1030
    //   711: aload_0
    //   712: getfield 21	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Boolean	Z
    //   715: ifeq +10 -> 725
    //   718: bipush 6
    //   720: istore 8
    //   722: goto +308 -> 1030
    //   725: aload 28
    //   727: aload 31
    //   729: iconst_0
    //   730: iload 9
    //   732: invokevirtual 170	java/io/RandomAccessFile:write	([BII)V
    //   735: lload 15
    //   737: iload 9
    //   739: i2l
    //   740: ladd
    //   741: lstore 15
    //   743: aload_0
    //   744: getfield 67	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   747: ifnull +3282 -> 4029
    //   750: aload_0
    //   751: getfield 67	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   754: astore 32
    //   756: aload 32
    //   758: aload_1
    //   759: lload 15
    //   761: lload 5
    //   763: lload 25
    //   765: ladd
    //   766: invokeinterface 173 6 0
    //   771: goto +3 -> 774
    //   774: invokestatic 178	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
    //   777: istore 27
    //   779: iload 7
    //   781: ifeq +15 -> 796
    //   784: iload 27
    //   786: ifne +10 -> 796
    //   789: bipush 7
    //   791: istore 8
    //   793: goto +237 -> 1030
    //   796: goto -196 -> 600
    //   799: astore 31
    //   801: goto +20 -> 821
    //   804: astore 31
    //   806: goto +40 -> 846
    //   809: astore 31
    //   811: goto +60 -> 871
    //   814: astore 31
    //   816: goto +80 -> 896
    //   819: astore 31
    //   821: lload 15
    //   823: lstore 5
    //   825: aload 31
    //   827: astore 55
    //   829: aload 29
    //   831: astore 32
    //   833: aload 30
    //   835: astore 33
    //   837: aload 28
    //   839: astore 31
    //   841: goto +831 -> 1672
    //   844: astore 31
    //   846: lload 15
    //   848: lstore 5
    //   850: aload 31
    //   852: astore 55
    //   854: aload 29
    //   856: astore 32
    //   858: aload 30
    //   860: astore 33
    //   862: aload 28
    //   864: astore 31
    //   866: goto +1137 -> 2003
    //   869: astore 31
    //   871: lload 15
    //   873: lstore 5
    //   875: aload 31
    //   877: astore 55
    //   879: aload 29
    //   881: astore 32
    //   883: aload 30
    //   885: astore 33
    //   887: aload 28
    //   889: astore 31
    //   891: goto +1443 -> 2334
    //   894: astore 31
    //   896: lload 15
    //   898: lstore 5
    //   900: aload 31
    //   902: astore 55
    //   904: aload 29
    //   906: astore 32
    //   908: aload 30
    //   910: astore 33
    //   912: aload 28
    //   914: astore 31
    //   916: goto +1749 -> 2665
    //   919: astore_2
    //   920: aload 29
    //   922: astore_3
    //   923: aload 28
    //   925: astore_1
    //   926: goto +336 -> 1262
    //   929: astore_3
    //   930: aload 28
    //   932: astore_2
    //   933: aload 29
    //   935: astore 28
    //   937: goto +348 -> 1285
    //   940: astore_3
    //   941: aload 28
    //   943: astore_2
    //   944: aload 29
    //   946: astore 28
    //   948: goto +358 -> 1306
    //   951: astore_3
    //   952: aload 28
    //   954: astore_2
    //   955: aload 29
    //   957: astore 28
    //   959: goto +368 -> 1327
    //   962: astore 32
    //   964: aload 28
    //   966: astore 31
    //   968: aload 32
    //   970: astore 28
    //   972: aload 29
    //   974: astore 32
    //   976: goto +382 -> 1358
    //   979: astore 32
    //   981: aload 28
    //   983: astore 31
    //   985: aload 32
    //   987: astore 28
    //   989: aload 29
    //   991: astore 32
    //   993: goto +398 -> 1391
    //   996: astore 32
    //   998: aload 28
    //   1000: astore 31
    //   1002: aload 32
    //   1004: astore 28
    //   1006: aload 29
    //   1008: astore 32
    //   1010: goto +414 -> 1424
    //   1013: astore 32
    //   1015: aload 28
    //   1017: astore 31
    //   1019: aload 32
    //   1021: astore 28
    //   1023: aload 29
    //   1025: astore 32
    //   1027: goto +430 -> 1457
    //   1030: aload 28
    //   1032: astore 31
    //   1034: aload 29
    //   1036: astore 32
    //   1038: aload_0
    //   1039: aload 30
    //   1041: aload 32
    //   1043: invokespecial 110	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   1046: aload 32
    //   1048: astore 29
    //   1050: aload 31
    //   1052: astore_3
    //   1053: aload 30
    //   1055: astore 31
    //   1057: aload_3
    //   1058: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   1061: aload 31
    //   1063: ifnull +20 -> 1083
    //   1066: aload 31
    //   1068: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   1071: goto +12 -> 1083
    //   1074: astore_2
    //   1075: ldc 54
    //   1077: ldc 186
    //   1079: aload_2
    //   1080: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1083: iload 8
    //   1085: istore 4
    //   1087: aload 29
    //   1089: ifnull +2842 -> 3931
    //   1092: aload 29
    //   1094: invokevirtual 191	java/io/InputStream:close	()V
    //   1097: iload 8
    //   1099: istore 4
    //   1101: goto +2830 -> 3931
    //   1104: astore_2
    //   1105: ldc 54
    //   1107: ldc 193
    //   1109: aload_2
    //   1110: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1113: iload 8
    //   1115: istore 4
    //   1117: goto +2814 -> 3931
    //   1120: astore_1
    //   1121: aload 29
    //   1123: astore_2
    //   1124: goto +479 -> 1603
    //   1127: astore_2
    //   1128: aload 29
    //   1130: astore 48
    //   1132: aload 31
    //   1134: astore 41
    //   1136: goto +1963 -> 3099
    //   1139: astore_2
    //   1140: goto +477 -> 1617
    //   1143: astore_2
    //   1144: goto +484 -> 1628
    //   1147: astore 28
    //   1149: aload 31
    //   1151: astore 44
    //   1153: aload 28
    //   1155: astore 31
    //   1157: aload 29
    //   1159: astore 51
    //   1161: goto +2309 -> 3470
    //   1164: astore_2
    //   1165: aload 29
    //   1167: astore 52
    //   1169: aload 31
    //   1171: astore 45
    //   1173: goto +2459 -> 3632
    //   1176: astore_2
    //   1177: aload 29
    //   1179: astore 53
    //   1181: aload 31
    //   1183: astore 46
    //   1185: goto +2547 -> 3732
    //   1188: astore_2
    //   1189: goto +450 -> 1639
    //   1192: aload 28
    //   1194: astore_1
    //   1195: aload 29
    //   1197: astore_3
    //   1198: astore_2
    //   1199: goto +63 -> 1262
    //   1202: aload 28
    //   1204: astore_2
    //   1205: aload 29
    //   1207: astore 28
    //   1209: astore_3
    //   1210: goto +75 -> 1285
    //   1213: aload 28
    //   1215: astore_2
    //   1216: aload 29
    //   1218: astore 28
    //   1220: astore_3
    //   1221: goto +85 -> 1306
    //   1224: aload 28
    //   1226: astore_2
    //   1227: aload 29
    //   1229: astore 28
    //   1231: astore_3
    //   1232: goto +95 -> 1327
    //   1235: astore 28
    //   1237: goto +121 -> 1358
    //   1240: astore 28
    //   1242: goto +149 -> 1391
    //   1245: astore 28
    //   1247: goto +177 -> 1424
    //   1250: astore 28
    //   1252: goto +205 -> 1457
    //   1255: astore_2
    //   1256: aload 40
    //   1258: astore_1
    //   1259: aload 32
    //   1261: astore_3
    //   1262: aload_3
    //   1263: astore 28
    //   1265: aload_2
    //   1266: astore_3
    //   1267: aload 28
    //   1269: astore_2
    //   1270: aload 30
    //   1272: astore 29
    //   1274: goto +2683 -> 3957
    //   1277: astore_3
    //   1278: aload 41
    //   1280: astore_2
    //   1281: aload 33
    //   1283: astore 28
    //   1285: aload_3
    //   1286: astore 32
    //   1288: aload 28
    //   1290: astore_3
    //   1291: aload 30
    //   1293: astore 31
    //   1295: goto +1916 -> 3211
    //   1298: astore_3
    //   1299: aload 42
    //   1301: astore_2
    //   1302: aload 34
    //   1304: astore 28
    //   1306: aload_3
    //   1307: astore 32
    //   1309: aload 28
    //   1311: astore_3
    //   1312: aload 30
    //   1314: astore 31
    //   1316: goto +1996 -> 3312
    //   1319: astore_3
    //   1320: aload 43
    //   1322: astore_2
    //   1323: aload 35
    //   1325: astore 28
    //   1327: aload_3
    //   1328: astore 32
    //   1330: aload 28
    //   1332: astore_3
    //   1333: aload 30
    //   1335: astore 31
    //   1337: goto +2507 -> 3844
    //   1340: astore 28
    //   1342: iload 10
    //   1344: istore 4
    //   1346: aload 44
    //   1348: astore 31
    //   1350: aload 36
    //   1352: astore 32
    //   1354: lload 17
    //   1356: lstore 15
    //   1358: aload 28
    //   1360: astore 55
    //   1362: lload 15
    //   1364: lstore 5
    //   1366: aload 30
    //   1368: astore 33
    //   1370: goto +302 -> 1672
    //   1373: astore 28
    //   1375: iload 11
    //   1377: istore 4
    //   1379: aload 45
    //   1381: astore 31
    //   1383: aload 37
    //   1385: astore 32
    //   1387: lload 19
    //   1389: lstore 15
    //   1391: aload 28
    //   1393: astore 55
    //   1395: lload 15
    //   1397: lstore 5
    //   1399: aload 30
    //   1401: astore 33
    //   1403: goto +600 -> 2003
    //   1406: astore 28
    //   1408: iload 12
    //   1410: istore 4
    //   1412: aload 46
    //   1414: astore 31
    //   1416: aload 38
    //   1418: astore 32
    //   1420: lload 21
    //   1422: lstore 15
    //   1424: aload 28
    //   1426: astore 55
    //   1428: lload 15
    //   1430: lstore 5
    //   1432: aload 30
    //   1434: astore 33
    //   1436: goto +898 -> 2334
    //   1439: astore 28
    //   1441: iload 13
    //   1443: istore 4
    //   1445: aload 47
    //   1447: astore 31
    //   1449: aload 39
    //   1451: astore 32
    //   1453: lload 23
    //   1455: lstore 15
    //   1457: aload 28
    //   1459: astore 55
    //   1461: lload 15
    //   1463: lstore 5
    //   1465: aload 30
    //   1467: astore 33
    //   1469: goto +1196 -> 2665
    //   1472: astore 31
    //   1474: goto +52 -> 1526
    //   1477: astore 31
    //   1479: goto +52 -> 1531
    //   1482: astore 31
    //   1484: goto +52 -> 1536
    //   1487: astore 31
    //   1489: goto +52 -> 1541
    //   1492: astore_1
    //   1493: aload 29
    //   1495: astore_2
    //   1496: aload 30
    //   1498: astore 29
    //   1500: goto +1580 -> 3080
    //   1503: astore_2
    //   1504: aload 28
    //   1506: astore_3
    //   1507: goto +1692 -> 3199
    //   1510: astore_2
    //   1511: aload 28
    //   1513: astore_3
    //   1514: goto +1786 -> 3300
    //   1517: astore_2
    //   1518: aload 28
    //   1520: astore_3
    //   1521: goto +2311 -> 3832
    //   1524: astore 31
    //   1526: goto +130 -> 1656
    //   1529: astore 31
    //   1531: goto +2511 -> 4042
    //   1534: astore 31
    //   1536: goto +2535 -> 4071
    //   1539: astore 31
    //   1541: goto +2559 -> 4100
    //   1544: astore_1
    //   1545: aload 29
    //   1547: astore_2
    //   1548: aload 30
    //   1550: astore 29
    //   1552: goto +1528 -> 3080
    //   1555: astore_2
    //   1556: aload 28
    //   1558: astore_3
    //   1559: goto +1640 -> 3199
    //   1562: astore_2
    //   1563: aload 28
    //   1565: astore_3
    //   1566: goto +1734 -> 3300
    //   1569: astore_2
    //   1570: aload 28
    //   1572: astore_3
    //   1573: goto +2259 -> 3832
    //   1576: astore 31
    //   1578: goto +78 -> 1656
    //   1581: astore 31
    //   1583: goto +2459 -> 4042
    //   1586: astore 31
    //   1588: goto +2483 -> 4071
    //   1591: astore 31
    //   1593: goto +2507 -> 4100
    //   1596: astore_1
    //   1597: aload 28
    //   1599: astore_3
    //   1600: aload 29
    //   1602: astore_2
    //   1603: aload 31
    //   1605: astore 29
    //   1607: aload_3
    //   1608: astore 28
    //   1610: goto +1470 -> 3080
    //   1613: astore_2
    //   1614: aload 28
    //   1616: astore_3
    //   1617: aload 31
    //   1619: astore 30
    //   1621: goto +1578 -> 3199
    //   1624: astore_2
    //   1625: aload 28
    //   1627: astore_3
    //   1628: aload 31
    //   1630: astore 30
    //   1632: goto +1668 -> 3300
    //   1635: astore_2
    //   1636: aload 28
    //   1638: astore_3
    //   1639: aload 31
    //   1641: astore 30
    //   1643: goto +2189 -> 3832
    //   1646: astore 32
    //   1648: aload 31
    //   1650: astore 30
    //   1652: aload 32
    //   1654: astore 31
    //   1656: aload 31
    //   1658: astore 55
    //   1660: aload 28
    //   1662: astore 31
    //   1664: aload 30
    //   1666: astore 33
    //   1668: aload 29
    //   1670: astore 32
    //   1672: aload 32
    //   1674: astore 48
    //   1676: aload 33
    //   1678: astore 41
    //   1680: aload 31
    //   1682: astore 34
    //   1684: aload 32
    //   1686: astore 49
    //   1688: aload 33
    //   1690: astore 42
    //   1692: aload 31
    //   1694: astore 35
    //   1696: aload 32
    //   1698: astore 50
    //   1700: aload 33
    //   1702: astore 43
    //   1704: aload 31
    //   1706: astore 36
    //   1708: aload 32
    //   1710: astore 51
    //   1712: aload 33
    //   1714: astore 44
    //   1716: aload 31
    //   1718: astore 37
    //   1720: aload 32
    //   1722: astore 52
    //   1724: aload 33
    //   1726: astore 45
    //   1728: aload 31
    //   1730: astore 38
    //   1732: aload 32
    //   1734: astore 53
    //   1736: aload 33
    //   1738: astore 46
    //   1740: aload 31
    //   1742: astore 39
    //   1744: aload 32
    //   1746: astore 54
    //   1748: aload 33
    //   1750: astore 47
    //   1752: aload 31
    //   1754: astore 40
    //   1756: aload 32
    //   1758: astore 30
    //   1760: aload 33
    //   1762: astore 29
    //   1764: aload 31
    //   1766: astore 28
    //   1768: ldc 54
    //   1770: ldc 193
    //   1772: aload 55
    //   1774: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1777: aload 32
    //   1779: astore 48
    //   1781: aload 33
    //   1783: astore 41
    //   1785: aload 31
    //   1787: astore 34
    //   1789: aload 32
    //   1791: astore 49
    //   1793: aload 33
    //   1795: astore 42
    //   1797: aload 31
    //   1799: astore 35
    //   1801: aload 32
    //   1803: astore 50
    //   1805: aload 33
    //   1807: astore 43
    //   1809: aload 31
    //   1811: astore 36
    //   1813: aload 32
    //   1815: astore 51
    //   1817: aload 33
    //   1819: astore 44
    //   1821: aload 31
    //   1823: astore 37
    //   1825: aload 32
    //   1827: astore 52
    //   1829: aload 33
    //   1831: astore 45
    //   1833: aload 31
    //   1835: astore 38
    //   1837: aload 32
    //   1839: astore 53
    //   1841: aload 33
    //   1843: astore 46
    //   1845: aload 31
    //   1847: astore 39
    //   1849: aload 32
    //   1851: astore 54
    //   1853: aload 33
    //   1855: astore 47
    //   1857: aload 31
    //   1859: astore 40
    //   1861: aload 32
    //   1863: astore 30
    //   1865: aload 33
    //   1867: astore 29
    //   1869: aload 31
    //   1871: astore 28
    //   1873: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1876: pop
    //   1877: aload 32
    //   1879: astore 48
    //   1881: aload 33
    //   1883: astore 41
    //   1885: aload 31
    //   1887: astore 34
    //   1889: aload 32
    //   1891: astore 49
    //   1893: aload 33
    //   1895: astore 42
    //   1897: aload 31
    //   1899: astore 35
    //   1901: aload 32
    //   1903: astore 50
    //   1905: aload 33
    //   1907: astore 43
    //   1909: aload 31
    //   1911: astore 36
    //   1913: aload 32
    //   1915: astore 51
    //   1917: aload 33
    //   1919: astore 44
    //   1921: aload 31
    //   1923: astore 37
    //   1925: aload 32
    //   1927: astore 52
    //   1929: aload 33
    //   1931: astore 45
    //   1933: aload 31
    //   1935: astore 38
    //   1937: aload 32
    //   1939: astore 53
    //   1941: aload 33
    //   1943: astore 46
    //   1945: aload 31
    //   1947: astore 39
    //   1949: aload 32
    //   1951: astore 54
    //   1953: aload 33
    //   1955: astore 47
    //   1957: aload 31
    //   1959: astore 40
    //   1961: aload 32
    //   1963: astore 30
    //   1965: aload 33
    //   1967: astore 29
    //   1969: aload 31
    //   1971: astore 28
    //   1973: ldc2_w 200
    //   1976: invokestatic 204	java/lang/Thread:sleep	(J)V
    //   1979: iload 4
    //   1981: iconst_1
    //   1982: iadd
    //   1983: istore 4
    //   1985: aload 31
    //   1987: astore 28
    //   1989: iconst_5
    //   1990: istore 8
    //   1992: aload 33
    //   1994: astore 31
    //   1996: aload 32
    //   1998: astore 29
    //   2000: goto -1807 -> 193
    //   2003: aload 32
    //   2005: astore 48
    //   2007: aload 33
    //   2009: astore 41
    //   2011: aload 31
    //   2013: astore 34
    //   2015: aload 32
    //   2017: astore 49
    //   2019: aload 33
    //   2021: astore 42
    //   2023: aload 31
    //   2025: astore 35
    //   2027: aload 32
    //   2029: astore 50
    //   2031: aload 33
    //   2033: astore 43
    //   2035: aload 31
    //   2037: astore 36
    //   2039: aload 32
    //   2041: astore 51
    //   2043: aload 33
    //   2045: astore 44
    //   2047: aload 31
    //   2049: astore 37
    //   2051: aload 32
    //   2053: astore 52
    //   2055: aload 33
    //   2057: astore 45
    //   2059: aload 31
    //   2061: astore 38
    //   2063: aload 32
    //   2065: astore 53
    //   2067: aload 33
    //   2069: astore 46
    //   2071: aload 31
    //   2073: astore 39
    //   2075: aload 32
    //   2077: astore 54
    //   2079: aload 33
    //   2081: astore 47
    //   2083: aload 31
    //   2085: astore 40
    //   2087: aload 32
    //   2089: astore 30
    //   2091: aload 33
    //   2093: astore 29
    //   2095: aload 31
    //   2097: astore 28
    //   2099: ldc 54
    //   2101: ldc 193
    //   2103: aload 55
    //   2105: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2108: aload 32
    //   2110: astore 48
    //   2112: aload 33
    //   2114: astore 41
    //   2116: aload 31
    //   2118: astore 34
    //   2120: aload 32
    //   2122: astore 49
    //   2124: aload 33
    //   2126: astore 42
    //   2128: aload 31
    //   2130: astore 35
    //   2132: aload 32
    //   2134: astore 50
    //   2136: aload 33
    //   2138: astore 43
    //   2140: aload 31
    //   2142: astore 36
    //   2144: aload 32
    //   2146: astore 51
    //   2148: aload 33
    //   2150: astore 44
    //   2152: aload 31
    //   2154: astore 37
    //   2156: aload 32
    //   2158: astore 52
    //   2160: aload 33
    //   2162: astore 45
    //   2164: aload 31
    //   2166: astore 38
    //   2168: aload 32
    //   2170: astore 53
    //   2172: aload 33
    //   2174: astore 46
    //   2176: aload 31
    //   2178: astore 39
    //   2180: aload 32
    //   2182: astore 54
    //   2184: aload 33
    //   2186: astore 47
    //   2188: aload 31
    //   2190: astore 40
    //   2192: aload 32
    //   2194: astore 30
    //   2196: aload 33
    //   2198: astore 29
    //   2200: aload 31
    //   2202: astore 28
    //   2204: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2207: pop
    //   2208: aload 32
    //   2210: astore 48
    //   2212: aload 33
    //   2214: astore 41
    //   2216: aload 31
    //   2218: astore 34
    //   2220: aload 32
    //   2222: astore 49
    //   2224: aload 33
    //   2226: astore 42
    //   2228: aload 31
    //   2230: astore 35
    //   2232: aload 32
    //   2234: astore 50
    //   2236: aload 33
    //   2238: astore 43
    //   2240: aload 31
    //   2242: astore 36
    //   2244: aload 32
    //   2246: astore 51
    //   2248: aload 33
    //   2250: astore 44
    //   2252: aload 31
    //   2254: astore 37
    //   2256: aload 32
    //   2258: astore 52
    //   2260: aload 33
    //   2262: astore 45
    //   2264: aload 31
    //   2266: astore 38
    //   2268: aload 32
    //   2270: astore 53
    //   2272: aload 33
    //   2274: astore 46
    //   2276: aload 31
    //   2278: astore 39
    //   2280: aload 32
    //   2282: astore 54
    //   2284: aload 33
    //   2286: astore 47
    //   2288: aload 31
    //   2290: astore 40
    //   2292: aload 32
    //   2294: astore 30
    //   2296: aload 33
    //   2298: astore 29
    //   2300: aload 31
    //   2302: astore 28
    //   2304: ldc2_w 200
    //   2307: invokestatic 204	java/lang/Thread:sleep	(J)V
    //   2310: iload 4
    //   2312: iconst_1
    //   2313: iadd
    //   2314: istore 4
    //   2316: aload 31
    //   2318: astore 28
    //   2320: iconst_3
    //   2321: istore 8
    //   2323: aload 33
    //   2325: astore 31
    //   2327: aload 32
    //   2329: astore 29
    //   2331: goto -2138 -> 193
    //   2334: aload 32
    //   2336: astore 48
    //   2338: aload 33
    //   2340: astore 41
    //   2342: aload 31
    //   2344: astore 34
    //   2346: aload 32
    //   2348: astore 49
    //   2350: aload 33
    //   2352: astore 42
    //   2354: aload 31
    //   2356: astore 35
    //   2358: aload 32
    //   2360: astore 50
    //   2362: aload 33
    //   2364: astore 43
    //   2366: aload 31
    //   2368: astore 36
    //   2370: aload 32
    //   2372: astore 51
    //   2374: aload 33
    //   2376: astore 44
    //   2378: aload 31
    //   2380: astore 37
    //   2382: aload 32
    //   2384: astore 52
    //   2386: aload 33
    //   2388: astore 45
    //   2390: aload 31
    //   2392: astore 38
    //   2394: aload 32
    //   2396: astore 53
    //   2398: aload 33
    //   2400: astore 46
    //   2402: aload 31
    //   2404: astore 39
    //   2406: aload 32
    //   2408: astore 54
    //   2410: aload 33
    //   2412: astore 47
    //   2414: aload 31
    //   2416: astore 40
    //   2418: aload 32
    //   2420: astore 30
    //   2422: aload 33
    //   2424: astore 29
    //   2426: aload 31
    //   2428: astore 28
    //   2430: ldc 54
    //   2432: ldc 193
    //   2434: aload 55
    //   2436: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2439: aload 32
    //   2441: astore 48
    //   2443: aload 33
    //   2445: astore 41
    //   2447: aload 31
    //   2449: astore 34
    //   2451: aload 32
    //   2453: astore 49
    //   2455: aload 33
    //   2457: astore 42
    //   2459: aload 31
    //   2461: astore 35
    //   2463: aload 32
    //   2465: astore 50
    //   2467: aload 33
    //   2469: astore 43
    //   2471: aload 31
    //   2473: astore 36
    //   2475: aload 32
    //   2477: astore 51
    //   2479: aload 33
    //   2481: astore 44
    //   2483: aload 31
    //   2485: astore 37
    //   2487: aload 32
    //   2489: astore 52
    //   2491: aload 33
    //   2493: astore 45
    //   2495: aload 31
    //   2497: astore 38
    //   2499: aload 32
    //   2501: astore 53
    //   2503: aload 33
    //   2505: astore 46
    //   2507: aload 31
    //   2509: astore 39
    //   2511: aload 32
    //   2513: astore 54
    //   2515: aload 33
    //   2517: astore 47
    //   2519: aload 31
    //   2521: astore 40
    //   2523: aload 32
    //   2525: astore 30
    //   2527: aload 33
    //   2529: astore 29
    //   2531: aload 31
    //   2533: astore 28
    //   2535: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2538: pop
    //   2539: aload 32
    //   2541: astore 48
    //   2543: aload 33
    //   2545: astore 41
    //   2547: aload 31
    //   2549: astore 34
    //   2551: aload 32
    //   2553: astore 49
    //   2555: aload 33
    //   2557: astore 42
    //   2559: aload 31
    //   2561: astore 35
    //   2563: aload 32
    //   2565: astore 50
    //   2567: aload 33
    //   2569: astore 43
    //   2571: aload 31
    //   2573: astore 36
    //   2575: aload 32
    //   2577: astore 51
    //   2579: aload 33
    //   2581: astore 44
    //   2583: aload 31
    //   2585: astore 37
    //   2587: aload 32
    //   2589: astore 52
    //   2591: aload 33
    //   2593: astore 45
    //   2595: aload 31
    //   2597: astore 38
    //   2599: aload 32
    //   2601: astore 53
    //   2603: aload 33
    //   2605: astore 46
    //   2607: aload 31
    //   2609: astore 39
    //   2611: aload 32
    //   2613: astore 54
    //   2615: aload 33
    //   2617: astore 47
    //   2619: aload 31
    //   2621: astore 40
    //   2623: aload 32
    //   2625: astore 30
    //   2627: aload 33
    //   2629: astore 29
    //   2631: aload 31
    //   2633: astore 28
    //   2635: ldc2_w 200
    //   2638: invokestatic 204	java/lang/Thread:sleep	(J)V
    //   2641: iload 4
    //   2643: iconst_1
    //   2644: iadd
    //   2645: istore 4
    //   2647: aload 31
    //   2649: astore 28
    //   2651: iconst_2
    //   2652: istore 8
    //   2654: aload 33
    //   2656: astore 31
    //   2658: aload 32
    //   2660: astore 29
    //   2662: goto -2469 -> 193
    //   2665: aload 32
    //   2667: astore 48
    //   2669: aload 33
    //   2671: astore 41
    //   2673: aload 31
    //   2675: astore 34
    //   2677: aload 32
    //   2679: astore 49
    //   2681: aload 33
    //   2683: astore 42
    //   2685: aload 31
    //   2687: astore 35
    //   2689: aload 32
    //   2691: astore 50
    //   2693: aload 33
    //   2695: astore 43
    //   2697: aload 31
    //   2699: astore 36
    //   2701: aload 32
    //   2703: astore 51
    //   2705: aload 33
    //   2707: astore 44
    //   2709: aload 31
    //   2711: astore 37
    //   2713: aload 32
    //   2715: astore 52
    //   2717: aload 33
    //   2719: astore 45
    //   2721: aload 31
    //   2723: astore 38
    //   2725: aload 32
    //   2727: astore 53
    //   2729: aload 33
    //   2731: astore 46
    //   2733: aload 31
    //   2735: astore 39
    //   2737: aload 32
    //   2739: astore 54
    //   2741: aload 33
    //   2743: astore 47
    //   2745: aload 31
    //   2747: astore 40
    //   2749: aload 32
    //   2751: astore 30
    //   2753: aload 33
    //   2755: astore 29
    //   2757: aload 31
    //   2759: astore 28
    //   2761: ldc 54
    //   2763: ldc 193
    //   2765: aload 55
    //   2767: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2770: aload 32
    //   2772: astore 48
    //   2774: aload 33
    //   2776: astore 41
    //   2778: aload 31
    //   2780: astore 34
    //   2782: aload 32
    //   2784: astore 49
    //   2786: aload 33
    //   2788: astore 42
    //   2790: aload 31
    //   2792: astore 35
    //   2794: aload 32
    //   2796: astore 50
    //   2798: aload 33
    //   2800: astore 43
    //   2802: aload 31
    //   2804: astore 36
    //   2806: aload 32
    //   2808: astore 51
    //   2810: aload 33
    //   2812: astore 44
    //   2814: aload 31
    //   2816: astore 37
    //   2818: aload 32
    //   2820: astore 52
    //   2822: aload 33
    //   2824: astore 45
    //   2826: aload 31
    //   2828: astore 38
    //   2830: aload 32
    //   2832: astore 53
    //   2834: aload 33
    //   2836: astore 46
    //   2838: aload 31
    //   2840: astore 39
    //   2842: aload 32
    //   2844: astore 54
    //   2846: aload 33
    //   2848: astore 47
    //   2850: aload 31
    //   2852: astore 40
    //   2854: aload 32
    //   2856: astore 30
    //   2858: aload 33
    //   2860: astore 29
    //   2862: aload 31
    //   2864: astore 28
    //   2866: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2869: pop
    //   2870: aload 32
    //   2872: astore 48
    //   2874: aload 33
    //   2876: astore 41
    //   2878: aload 31
    //   2880: astore 34
    //   2882: aload 32
    //   2884: astore 49
    //   2886: aload 33
    //   2888: astore 42
    //   2890: aload 31
    //   2892: astore 35
    //   2894: aload 32
    //   2896: astore 50
    //   2898: aload 33
    //   2900: astore 43
    //   2902: aload 31
    //   2904: astore 36
    //   2906: aload 32
    //   2908: astore 51
    //   2910: aload 33
    //   2912: astore 44
    //   2914: aload 31
    //   2916: astore 37
    //   2918: aload 32
    //   2920: astore 52
    //   2922: aload 33
    //   2924: astore 45
    //   2926: aload 31
    //   2928: astore 38
    //   2930: aload 32
    //   2932: astore 53
    //   2934: aload 33
    //   2936: astore 46
    //   2938: aload 31
    //   2940: astore 39
    //   2942: aload 32
    //   2944: astore 54
    //   2946: aload 33
    //   2948: astore 47
    //   2950: aload 31
    //   2952: astore 40
    //   2954: aload 32
    //   2956: astore 30
    //   2958: aload 33
    //   2960: astore 29
    //   2962: aload 31
    //   2964: astore 28
    //   2966: ldc2_w 200
    //   2969: invokestatic 204	java/lang/Thread:sleep	(J)V
    //   2972: iload 4
    //   2974: iconst_1
    //   2975: iadd
    //   2976: istore 4
    //   2978: aload 31
    //   2980: astore 28
    //   2982: iconst_1
    //   2983: istore 8
    //   2985: aload 33
    //   2987: astore 31
    //   2989: aload 32
    //   2991: astore 29
    //   2993: goto -2800 -> 193
    //   2996: astore_2
    //   2997: aload 34
    //   2999: astore_3
    //   3000: goto +99 -> 3099
    //   3003: astore_2
    //   3004: aload 49
    //   3006: astore 29
    //   3008: aload 42
    //   3010: astore 30
    //   3012: aload 35
    //   3014: astore_3
    //   3015: goto +184 -> 3199
    //   3018: astore_2
    //   3019: aload 50
    //   3021: astore 29
    //   3023: aload 43
    //   3025: astore 30
    //   3027: aload 36
    //   3029: astore_3
    //   3030: goto +270 -> 3300
    //   3033: astore 31
    //   3035: aload 37
    //   3037: astore_3
    //   3038: goto +432 -> 3470
    //   3041: astore_2
    //   3042: aload 38
    //   3044: astore_3
    //   3045: goto +587 -> 3632
    //   3048: astore_2
    //   3049: aload 39
    //   3051: astore_3
    //   3052: goto +680 -> 3732
    //   3055: astore_2
    //   3056: aload 54
    //   3058: astore 29
    //   3060: aload 47
    //   3062: astore 30
    //   3064: aload 40
    //   3066: astore_3
    //   3067: goto +765 -> 3832
    //   3070: astore_1
    //   3071: aconst_null
    //   3072: astore_2
    //   3073: aload_2
    //   3074: astore 29
    //   3076: aload 29
    //   3078: astore 28
    //   3080: aload_1
    //   3081: astore_3
    //   3082: aload 28
    //   3084: astore_1
    //   3085: goto +872 -> 3957
    //   3088: astore_2
    //   3089: aconst_null
    //   3090: astore 48
    //   3092: aload 48
    //   3094: astore 41
    //   3096: aload 41
    //   3098: astore_3
    //   3099: aload 48
    //   3101: astore 30
    //   3103: aload 41
    //   3105: astore 29
    //   3107: aload_3
    //   3108: astore 28
    //   3110: ldc 54
    //   3112: ldc 193
    //   3114: aload_2
    //   3115: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3118: aload 41
    //   3120: ifnull +20 -> 3140
    //   3123: aload 41
    //   3125: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3128: goto +12 -> 3140
    //   3131: astore_2
    //   3132: ldc 54
    //   3134: ldc 186
    //   3136: aload_2
    //   3137: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3140: aload 48
    //   3142: ifnull +20 -> 3162
    //   3145: aload 48
    //   3147: invokevirtual 191	java/io/InputStream:close	()V
    //   3150: goto +12 -> 3162
    //   3153: astore_2
    //   3154: ldc 54
    //   3156: ldc 193
    //   3158: aload_2
    //   3159: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3162: aload_3
    //   3163: ifnull +19 -> 3182
    //   3166: aload_3
    //   3167: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3170: goto +12 -> 3182
    //   3173: astore_2
    //   3174: ldc 54
    //   3176: ldc 193
    //   3178: aload_2
    //   3179: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3182: iconst_5
    //   3183: istore 4
    //   3185: goto +746 -> 3931
    //   3188: astore_2
    //   3189: aconst_null
    //   3190: astore 29
    //   3192: aload 29
    //   3194: astore 30
    //   3196: aload 30
    //   3198: astore_3
    //   3199: aload_2
    //   3200: astore 32
    //   3202: aload_3
    //   3203: astore_2
    //   3204: aload 30
    //   3206: astore 31
    //   3208: aload 29
    //   3210: astore_3
    //   3211: aload_3
    //   3212: astore 30
    //   3214: aload 31
    //   3216: astore 29
    //   3218: aload_2
    //   3219: astore 28
    //   3221: ldc 54
    //   3223: ldc 193
    //   3225: aload 32
    //   3227: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3230: aload 31
    //   3232: ifnull +22 -> 3254
    //   3235: aload 31
    //   3237: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3240: goto +14 -> 3254
    //   3243: astore 28
    //   3245: ldc 54
    //   3247: ldc 186
    //   3249: aload 28
    //   3251: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3254: aload_3
    //   3255: ifnull +19 -> 3274
    //   3258: aload_3
    //   3259: invokevirtual 191	java/io/InputStream:close	()V
    //   3262: goto +12 -> 3274
    //   3265: astore_3
    //   3266: ldc 54
    //   3268: ldc 193
    //   3270: aload_3
    //   3271: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3274: aload_2
    //   3275: ifnull +440 -> 3715
    //   3278: aload_2
    //   3279: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3282: goto +433 -> 3715
    //   3285: astore_2
    //   3286: goto +421 -> 3707
    //   3289: astore_2
    //   3290: aconst_null
    //   3291: astore 29
    //   3293: aload 29
    //   3295: astore 30
    //   3297: aload 30
    //   3299: astore_3
    //   3300: aload_2
    //   3301: astore 32
    //   3303: aload_3
    //   3304: astore_2
    //   3305: aload 30
    //   3307: astore 31
    //   3309: aload 29
    //   3311: astore_3
    //   3312: aload_3
    //   3313: astore 30
    //   3315: aload 31
    //   3317: astore 29
    //   3319: aload_2
    //   3320: astore 28
    //   3322: new 45	java/lang/StringBuilder
    //   3325: dup
    //   3326: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3329: astore 33
    //   3331: aload_3
    //   3332: astore 30
    //   3334: aload 31
    //   3336: astore 29
    //   3338: aload_2
    //   3339: astore 28
    //   3341: aload 33
    //   3343: ldc 206
    //   3345: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3348: pop
    //   3349: aload_3
    //   3350: astore 30
    //   3352: aload 31
    //   3354: astore 29
    //   3356: aload_2
    //   3357: astore 28
    //   3359: aload 33
    //   3361: aload_1
    //   3362: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: pop
    //   3366: aload_3
    //   3367: astore 30
    //   3369: aload 31
    //   3371: astore 29
    //   3373: aload_2
    //   3374: astore 28
    //   3376: ldc 54
    //   3378: aload 33
    //   3380: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3383: aload 32
    //   3385: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3388: aload 31
    //   3390: ifnull +22 -> 3412
    //   3393: aload 31
    //   3395: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3398: goto +14 -> 3412
    //   3401: astore 28
    //   3403: ldc 54
    //   3405: ldc 186
    //   3407: aload 28
    //   3409: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3412: aload_3
    //   3413: ifnull +19 -> 3432
    //   3416: aload_3
    //   3417: invokevirtual 191	java/io/InputStream:close	()V
    //   3420: goto +12 -> 3432
    //   3423: astore_3
    //   3424: ldc 54
    //   3426: ldc 193
    //   3428: aload_3
    //   3429: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3432: aload_2
    //   3433: ifnull +19 -> 3452
    //   3436: aload_2
    //   3437: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3440: goto +12 -> 3452
    //   3443: astore_2
    //   3444: ldc 54
    //   3446: ldc 193
    //   3448: aload_2
    //   3449: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3452: iconst_4
    //   3453: istore 4
    //   3455: goto +476 -> 3931
    //   3458: astore 31
    //   3460: aconst_null
    //   3461: astore 51
    //   3463: aload 51
    //   3465: astore 44
    //   3467: aload 44
    //   3469: astore_3
    //   3470: aload 51
    //   3472: astore 30
    //   3474: aload 44
    //   3476: astore 29
    //   3478: aload_3
    //   3479: astore 28
    //   3481: new 93	java/io/File
    //   3484: dup
    //   3485: aload_2
    //   3486: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   3489: astore_2
    //   3490: aload 51
    //   3492: astore 30
    //   3494: aload 44
    //   3496: astore 29
    //   3498: aload_3
    //   3499: astore 28
    //   3501: aload_2
    //   3502: invokevirtual 97	java/io/File:exists	()Z
    //   3505: ifeq +19 -> 3524
    //   3508: aload 51
    //   3510: astore 30
    //   3512: aload 44
    //   3514: astore 29
    //   3516: aload_3
    //   3517: astore 28
    //   3519: aload_2
    //   3520: invokevirtual 210	java/io/File:delete	()Z
    //   3523: pop
    //   3524: aload 51
    //   3526: astore 30
    //   3528: aload 44
    //   3530: astore 29
    //   3532: aload_3
    //   3533: astore 28
    //   3535: ldc 54
    //   3537: ldc 193
    //   3539: aload 31
    //   3541: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3544: aload 44
    //   3546: ifnull +20 -> 3566
    //   3549: aload 44
    //   3551: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3554: goto +12 -> 3566
    //   3557: astore_2
    //   3558: ldc 54
    //   3560: ldc 186
    //   3562: aload_2
    //   3563: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3566: aload 51
    //   3568: ifnull +20 -> 3588
    //   3571: aload 51
    //   3573: invokevirtual 191	java/io/InputStream:close	()V
    //   3576: goto +12 -> 3588
    //   3579: astore_2
    //   3580: ldc 54
    //   3582: ldc 193
    //   3584: aload_2
    //   3585: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3588: aload_3
    //   3589: ifnull +19 -> 3608
    //   3592: aload_3
    //   3593: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3596: goto +12 -> 3608
    //   3599: astore_2
    //   3600: ldc 54
    //   3602: ldc 193
    //   3604: aload_2
    //   3605: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3608: iconst_3
    //   3609: istore 4
    //   3611: goto +320 -> 3931
    //   3614: astore_1
    //   3615: aload 30
    //   3617: astore_2
    //   3618: goto -538 -> 3080
    //   3621: astore_2
    //   3622: aconst_null
    //   3623: astore 52
    //   3625: aload 52
    //   3627: astore 45
    //   3629: aload 45
    //   3631: astore_3
    //   3632: aload 52
    //   3634: astore 30
    //   3636: aload 45
    //   3638: astore 29
    //   3640: aload_3
    //   3641: astore 28
    //   3643: ldc 54
    //   3645: ldc 193
    //   3647: aload_2
    //   3648: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3651: aload 45
    //   3653: ifnull +20 -> 3673
    //   3656: aload 45
    //   3658: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3661: goto +12 -> 3673
    //   3664: astore_2
    //   3665: ldc 54
    //   3667: ldc 186
    //   3669: aload_2
    //   3670: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3673: aload 52
    //   3675: ifnull +20 -> 3695
    //   3678: aload 52
    //   3680: invokevirtual 191	java/io/InputStream:close	()V
    //   3683: goto +12 -> 3695
    //   3686: astore_2
    //   3687: ldc 54
    //   3689: ldc 193
    //   3691: aload_2
    //   3692: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3695: aload_3
    //   3696: ifnull +19 -> 3715
    //   3699: aload_3
    //   3700: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3703: goto +12 -> 3715
    //   3706: astore_2
    //   3707: ldc 54
    //   3709: ldc 193
    //   3711: aload_2
    //   3712: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3715: iconst_1
    //   3716: istore 4
    //   3718: goto +213 -> 3931
    //   3721: astore_2
    //   3722: aconst_null
    //   3723: astore 53
    //   3725: aload 53
    //   3727: astore 46
    //   3729: aload 46
    //   3731: astore_3
    //   3732: aload 53
    //   3734: astore 30
    //   3736: aload 46
    //   3738: astore 29
    //   3740: aload_3
    //   3741: astore 28
    //   3743: ldc 54
    //   3745: ldc 193
    //   3747: aload_2
    //   3748: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3751: aload 46
    //   3753: ifnull +20 -> 3773
    //   3756: aload 46
    //   3758: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3761: goto +12 -> 3773
    //   3764: astore_2
    //   3765: ldc 54
    //   3767: ldc 186
    //   3769: aload_2
    //   3770: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3773: aload 53
    //   3775: ifnull +20 -> 3795
    //   3778: aload 53
    //   3780: invokevirtual 191	java/io/InputStream:close	()V
    //   3783: goto +12 -> 3795
    //   3786: astore_2
    //   3787: ldc 54
    //   3789: ldc 193
    //   3791: aload_2
    //   3792: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3795: aload_3
    //   3796: ifnull +19 -> 3815
    //   3799: aload_3
    //   3800: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3803: goto +12 -> 3815
    //   3806: astore_2
    //   3807: ldc 54
    //   3809: ldc 193
    //   3811: aload_2
    //   3812: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3815: iconst_2
    //   3816: istore 4
    //   3818: goto +113 -> 3931
    //   3821: astore_2
    //   3822: aconst_null
    //   3823: astore 29
    //   3825: aload 29
    //   3827: astore 30
    //   3829: aload 30
    //   3831: astore_3
    //   3832: aload_2
    //   3833: astore 32
    //   3835: aload_3
    //   3836: astore_2
    //   3837: aload 30
    //   3839: astore 31
    //   3841: aload 29
    //   3843: astore_3
    //   3844: aload_3
    //   3845: astore 30
    //   3847: aload 31
    //   3849: astore 29
    //   3851: aload_2
    //   3852: astore 28
    //   3854: ldc 54
    //   3856: ldc 193
    //   3858: aload 32
    //   3860: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3863: aload 31
    //   3865: ifnull +22 -> 3887
    //   3868: aload 31
    //   3870: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3873: goto +14 -> 3887
    //   3876: astore 28
    //   3878: ldc 54
    //   3880: ldc 186
    //   3882: aload 28
    //   3884: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3887: aload_3
    //   3888: ifnull +19 -> 3907
    //   3891: aload_3
    //   3892: invokevirtual 191	java/io/InputStream:close	()V
    //   3895: goto +12 -> 3907
    //   3898: astore_3
    //   3899: ldc 54
    //   3901: ldc 193
    //   3903: aload_3
    //   3904: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3907: aload_2
    //   3908: ifnull +19 -> 3927
    //   3911: aload_2
    //   3912: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   3915: goto +12 -> 3927
    //   3918: astore_2
    //   3919: ldc 54
    //   3921: ldc 193
    //   3923: aload_2
    //   3924: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3927: bipush 6
    //   3929: istore 4
    //   3931: aload_0
    //   3932: getfield 67	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   3935: astore_2
    //   3936: aload_2
    //   3937: ifnull +12 -> 3949
    //   3940: aload_2
    //   3941: aload_1
    //   3942: iload 4
    //   3944: invokeinterface 213 3 0
    //   3949: aload_0
    //   3950: iconst_0
    //   3951: putfield 23	com/tencent/biz/qqstory/base/download/DownloaderImp:b	Z
    //   3954: iload 4
    //   3956: ireturn
    //   3957: aload 29
    //   3959: ifnull +22 -> 3981
    //   3962: aload 29
    //   3964: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   3967: goto +14 -> 3981
    //   3970: astore 28
    //   3972: ldc 54
    //   3974: ldc 186
    //   3976: aload 28
    //   3978: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3981: aload_2
    //   3982: ifnull +19 -> 4001
    //   3985: aload_2
    //   3986: invokevirtual 191	java/io/InputStream:close	()V
    //   3989: goto +12 -> 4001
    //   3992: astore_2
    //   3993: ldc 54
    //   3995: ldc 193
    //   3997: aload_2
    //   3998: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4001: aload_1
    //   4002: ifnull +19 -> 4021
    //   4005: aload_1
    //   4006: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   4009: goto +12 -> 4021
    //   4012: astore_1
    //   4013: ldc 54
    //   4015: ldc 193
    //   4017: aload_1
    //   4018: invokestatic 190	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4021: goto +5 -> 4026
    //   4024: aload_3
    //   4025: athrow
    //   4026: goto -2 -> 4024
    //   4029: goto -3255 -> 774
    //   4032: astore 32
    //   4034: aload 31
    //   4036: astore 30
    //   4038: aload 32
    //   4040: astore 31
    //   4042: aload 31
    //   4044: astore 55
    //   4046: aload 29
    //   4048: astore 32
    //   4050: aload 30
    //   4052: astore 33
    //   4054: aload 28
    //   4056: astore 31
    //   4058: goto -2055 -> 2003
    //   4061: astore 32
    //   4063: aload 31
    //   4065: astore 30
    //   4067: aload 32
    //   4069: astore 31
    //   4071: aload 31
    //   4073: astore 55
    //   4075: aload 29
    //   4077: astore 32
    //   4079: aload 30
    //   4081: astore 33
    //   4083: aload 28
    //   4085: astore 31
    //   4087: goto -1753 -> 2334
    //   4090: astore 32
    //   4092: aload 31
    //   4094: astore 30
    //   4096: aload 32
    //   4098: astore 31
    //   4100: aload 31
    //   4102: astore 55
    //   4104: aload 29
    //   4106: astore 32
    //   4108: aload 30
    //   4110: astore 33
    //   4112: aload 28
    //   4114: astore 31
    //   4116: goto -1451 -> 2665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4119	0	this	DownloaderImp
    //   0	4119	1	paramString1	String
    //   0	4119	2	paramString2	String
    //   0	4119	3	paramHashMap	HashMap<String, String>
    //   0	4119	4	paramInt	int
    //   0	4119	5	paramLong	long
    //   0	4119	7	paramBoolean	boolean
    //   191	2793	8	i	int
    //   298	440	9	j	int
    //   424	919	10	k	int
    //   440	936	11	m	int
    //   456	953	12	n	int
    //   472	970	13	i1	int
    //   110	469	14	i2	int
    //   594	868	15	l1	long
    //   412	943	17	l2	long
    //   428	960	19	l3	long
    //   444	977	21	l4	long
    //   460	994	23	l5	long
    //   480	284	25	l6	long
    //   777	8	27	bool	boolean
    //   22	1009	28	localObject1	Object
    //   1147	56	28	localFileNotFoundException1	java.io.FileNotFoundException
    //   1207	23	28	localObject2	Object
    //   1235	1	28	localException1	Exception
    //   1240	1	28	localFileNotFoundException2	java.io.FileNotFoundException
    //   1245	1	28	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1250	1	28	localSocketException1	java.net.SocketException
    //   1263	68	28	localObject3	Object
    //   1340	19	28	localException2	Exception
    //   1373	19	28	localFileNotFoundException3	java.io.FileNotFoundException
    //   1406	19	28	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1439	159	28	localSocketException2	java.net.SocketException
    //   1608	1612	28	localObject4	Object
    //   3243	7	28	localException3	Exception
    //   3320	55	28	str	String
    //   3401	7	28	localException4	Exception
    //   3479	374	28	localObject5	Object
    //   3876	7	28	localException5	Exception
    //   3970	143	28	localException6	Exception
    //   185	3920	29	localObject6	Object
    //   241	3868	30	localObject7	Object
    //   120	608	31	localObject8	Object
    //   799	1	31	localException7	Exception
    //   804	1	31	localFileNotFoundException4	java.io.FileNotFoundException
    //   809	1	31	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   814	1	31	localSocketException3	java.net.SocketException
    //   819	7	31	localException8	Exception
    //   839	1	31	localObject9	Object
    //   844	7	31	localFileNotFoundException5	java.io.FileNotFoundException
    //   864	1	31	localObject10	Object
    //   869	7	31	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   889	1	31	localObject11	Object
    //   894	7	31	localSocketException4	java.net.SocketException
    //   914	534	31	localObject12	Object
    //   1472	1	31	localException9	Exception
    //   1477	1	31	localFileNotFoundException6	java.io.FileNotFoundException
    //   1482	1	31	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   1487	1	31	localSocketException5	java.net.SocketException
    //   1524	1	31	localException10	Exception
    //   1529	1	31	localFileNotFoundException7	java.io.FileNotFoundException
    //   1534	1	31	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   1539	1	31	localSocketException6	java.net.SocketException
    //   1576	1	31	localException11	Exception
    //   1581	1	31	localFileNotFoundException8	java.io.FileNotFoundException
    //   1586	1	31	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   1591	58	31	localSocketException7	java.net.SocketException
    //   1654	1334	31	localObject13	Object
    //   3033	1	31	localFileNotFoundException9	java.io.FileNotFoundException
    //   3206	188	31	localObject14	Object
    //   3458	82	31	localFileNotFoundException10	java.io.FileNotFoundException
    //   3839	276	31	localObject15	Object
    //   384	523	32	localObject16	Object
    //   962	7	32	localException12	Exception
    //   974	1	32	localObject17	Object
    //   979	7	32	localFileNotFoundException11	java.io.FileNotFoundException
    //   991	1	32	localObject18	Object
    //   996	7	32	localSocketTimeoutException8	java.net.SocketTimeoutException
    //   1008	1	32	localObject19	Object
    //   1013	7	32	localSocketException8	java.net.SocketException
    //   1025	427	32	localObject20	Object
    //   1646	7	32	localException13	Exception
    //   1670	2189	32	localObject21	Object
    //   4032	7	32	localFileNotFoundException12	java.io.FileNotFoundException
    //   4048	1	32	localObject22	Object
    //   4061	7	32	localSocketTimeoutException9	java.net.SocketTimeoutException
    //   4077	1	32	localObject23	Object
    //   4090	7	32	localSocketException9	java.net.SocketException
    //   4106	1	32	localObject24	Object
    //   392	3719	33	localObject25	Object
    //   400	2598	34	localObject26	Object
    //   408	2605	35	localObject27	Object
    //   420	2608	36	localObject28	Object
    //   436	2600	37	localObject29	Object
    //   452	2591	38	localObject30	Object
    //   468	2582	39	localObject31	Object
    //   380	2685	40	localObject32	Object
    //   388	2736	41	localObject33	Object
    //   396	2613	42	localObject34	Object
    //   404	2620	43	localObject35	Object
    //   416	3134	44	localObject36	Object
    //   432	3225	45	localObject37	Object
    //   448	3309	46	localObject38	Object
    //   464	2597	47	localObject39	Object
    //   582	2564	48	localObject40	Object
    //   1686	1319	49	localObject41	Object
    //   1698	1322	50	localObject42	Object
    //   1159	2413	51	localObject43	Object
    //   1167	2512	52	localObject44	Object
    //   1179	2600	53	localObject45	Object
    //   1746	1311	54	localObject46	Object
    //   827	3276	55	localObject47	Object
    //   134	100	56	localObject48	Object
    // Exception table:
    //   from	to	target	type
    //   756	771	799	java/lang/Exception
    //   774	779	799	java/lang/Exception
    //   756	771	804	java/io/FileNotFoundException
    //   774	779	804	java/io/FileNotFoundException
    //   756	771	809	java/net/SocketTimeoutException
    //   774	779	809	java/net/SocketTimeoutException
    //   756	771	814	java/net/SocketException
    //   774	779	814	java/net/SocketException
    //   743	756	819	java/lang/Exception
    //   743	756	844	java/io/FileNotFoundException
    //   743	756	869	java/net/SocketTimeoutException
    //   743	756	894	java/net/SocketException
    //   711	718	919	finally
    //   725	735	919	finally
    //   743	756	919	finally
    //   711	718	929	java/io/IOException
    //   725	735	929	java/io/IOException
    //   743	756	929	java/io/IOException
    //   711	718	940	java/net/MalformedURLException
    //   725	735	940	java/net/MalformedURLException
    //   743	756	940	java/net/MalformedURLException
    //   711	718	951	java/lang/InterruptedException
    //   725	735	951	java/lang/InterruptedException
    //   743	756	951	java/lang/InterruptedException
    //   711	718	962	java/lang/Exception
    //   725	735	962	java/lang/Exception
    //   711	718	979	java/io/FileNotFoundException
    //   725	735	979	java/io/FileNotFoundException
    //   711	718	996	java/net/SocketTimeoutException
    //   725	735	996	java/net/SocketTimeoutException
    //   711	718	1013	java/net/SocketException
    //   725	735	1013	java/net/SocketException
    //   1066	1071	1074	java/lang/Exception
    //   1092	1097	1104	java/io/IOException
    //   1057	1061	1120	finally
    //   1057	1061	1127	java/lang/Exception
    //   1057	1061	1139	java/io/IOException
    //   1057	1061	1143	java/net/MalformedURLException
    //   1057	1061	1147	java/io/FileNotFoundException
    //   1057	1061	1164	java/net/SocketException
    //   1057	1061	1176	java/net/SocketTimeoutException
    //   1057	1061	1188	java/lang/InterruptedException
    //   756	771	1192	finally
    //   774	779	1192	finally
    //   1038	1046	1192	finally
    //   756	771	1202	java/io/IOException
    //   774	779	1202	java/io/IOException
    //   1038	1046	1202	java/io/IOException
    //   756	771	1213	java/net/MalformedURLException
    //   774	779	1213	java/net/MalformedURLException
    //   1038	1046	1213	java/net/MalformedURLException
    //   756	771	1224	java/lang/InterruptedException
    //   774	779	1224	java/lang/InterruptedException
    //   1038	1046	1224	java/lang/InterruptedException
    //   1038	1046	1235	java/lang/Exception
    //   1038	1046	1240	java/io/FileNotFoundException
    //   1038	1046	1245	java/net/SocketTimeoutException
    //   1038	1046	1250	java/net/SocketException
    //   474	482	1255	finally
    //   578	584	1255	finally
    //   696	705	1255	finally
    //   474	482	1277	java/io/IOException
    //   578	584	1277	java/io/IOException
    //   696	705	1277	java/io/IOException
    //   474	482	1298	java/net/MalformedURLException
    //   578	584	1298	java/net/MalformedURLException
    //   696	705	1298	java/net/MalformedURLException
    //   474	482	1319	java/lang/InterruptedException
    //   578	584	1319	java/lang/InterruptedException
    //   696	705	1319	java/lang/InterruptedException
    //   474	482	1340	java/lang/Exception
    //   578	584	1340	java/lang/Exception
    //   696	705	1340	java/lang/Exception
    //   474	482	1373	java/io/FileNotFoundException
    //   578	584	1373	java/io/FileNotFoundException
    //   696	705	1373	java/io/FileNotFoundException
    //   474	482	1406	java/net/SocketTimeoutException
    //   578	584	1406	java/net/SocketTimeoutException
    //   696	705	1406	java/net/SocketTimeoutException
    //   474	482	1439	java/net/SocketException
    //   578	584	1439	java/net/SocketException
    //   696	705	1439	java/net/SocketException
    //   300	378	1472	java/lang/Exception
    //   300	378	1477	java/io/FileNotFoundException
    //   300	378	1482	java/net/SocketTimeoutException
    //   300	378	1487	java/net/SocketException
    //   287	296	1492	finally
    //   300	378	1492	finally
    //   287	296	1503	java/io/IOException
    //   300	378	1503	java/io/IOException
    //   287	296	1510	java/net/MalformedURLException
    //   300	378	1510	java/net/MalformedURLException
    //   287	296	1517	java/lang/InterruptedException
    //   300	378	1517	java/lang/InterruptedException
    //   287	296	1524	java/lang/Exception
    //   287	296	1529	java/io/FileNotFoundException
    //   287	296	1534	java/net/SocketTimeoutException
    //   287	296	1539	java/net/SocketException
    //   243	287	1544	finally
    //   243	287	1555	java/io/IOException
    //   243	287	1562	java/net/MalformedURLException
    //   243	287	1569	java/lang/InterruptedException
    //   243	287	1576	java/lang/Exception
    //   243	287	1581	java/io/FileNotFoundException
    //   243	287	1586	java/net/SocketTimeoutException
    //   243	287	1591	java/net/SocketException
    //   193	202	1596	finally
    //   208	215	1596	finally
    //   225	243	1596	finally
    //   193	202	1613	java/io/IOException
    //   208	215	1613	java/io/IOException
    //   225	243	1613	java/io/IOException
    //   193	202	1624	java/net/MalformedURLException
    //   208	215	1624	java/net/MalformedURLException
    //   225	243	1624	java/net/MalformedURLException
    //   193	202	1635	java/lang/InterruptedException
    //   208	215	1635	java/lang/InterruptedException
    //   225	243	1635	java/lang/InterruptedException
    //   193	202	1646	java/lang/Exception
    //   208	215	1646	java/lang/Exception
    //   225	243	1646	java/lang/Exception
    //   1768	1777	2996	java/lang/Exception
    //   1873	1877	2996	java/lang/Exception
    //   1973	1979	2996	java/lang/Exception
    //   2099	2108	2996	java/lang/Exception
    //   2204	2208	2996	java/lang/Exception
    //   2304	2310	2996	java/lang/Exception
    //   2430	2439	2996	java/lang/Exception
    //   2535	2539	2996	java/lang/Exception
    //   2635	2641	2996	java/lang/Exception
    //   2761	2770	2996	java/lang/Exception
    //   2866	2870	2996	java/lang/Exception
    //   2966	2972	2996	java/lang/Exception
    //   1768	1777	3003	java/io/IOException
    //   1873	1877	3003	java/io/IOException
    //   1973	1979	3003	java/io/IOException
    //   2099	2108	3003	java/io/IOException
    //   2204	2208	3003	java/io/IOException
    //   2304	2310	3003	java/io/IOException
    //   2430	2439	3003	java/io/IOException
    //   2535	2539	3003	java/io/IOException
    //   2635	2641	3003	java/io/IOException
    //   2761	2770	3003	java/io/IOException
    //   2866	2870	3003	java/io/IOException
    //   2966	2972	3003	java/io/IOException
    //   1768	1777	3018	java/net/MalformedURLException
    //   1873	1877	3018	java/net/MalformedURLException
    //   1973	1979	3018	java/net/MalformedURLException
    //   2099	2108	3018	java/net/MalformedURLException
    //   2204	2208	3018	java/net/MalformedURLException
    //   2304	2310	3018	java/net/MalformedURLException
    //   2430	2439	3018	java/net/MalformedURLException
    //   2535	2539	3018	java/net/MalformedURLException
    //   2635	2641	3018	java/net/MalformedURLException
    //   2761	2770	3018	java/net/MalformedURLException
    //   2866	2870	3018	java/net/MalformedURLException
    //   2966	2972	3018	java/net/MalformedURLException
    //   1768	1777	3033	java/io/FileNotFoundException
    //   1873	1877	3033	java/io/FileNotFoundException
    //   1973	1979	3033	java/io/FileNotFoundException
    //   2099	2108	3033	java/io/FileNotFoundException
    //   2204	2208	3033	java/io/FileNotFoundException
    //   2304	2310	3033	java/io/FileNotFoundException
    //   2430	2439	3033	java/io/FileNotFoundException
    //   2535	2539	3033	java/io/FileNotFoundException
    //   2635	2641	3033	java/io/FileNotFoundException
    //   2761	2770	3033	java/io/FileNotFoundException
    //   2866	2870	3033	java/io/FileNotFoundException
    //   2966	2972	3033	java/io/FileNotFoundException
    //   1768	1777	3041	java/net/SocketException
    //   1873	1877	3041	java/net/SocketException
    //   1973	1979	3041	java/net/SocketException
    //   2099	2108	3041	java/net/SocketException
    //   2204	2208	3041	java/net/SocketException
    //   2304	2310	3041	java/net/SocketException
    //   2430	2439	3041	java/net/SocketException
    //   2535	2539	3041	java/net/SocketException
    //   2635	2641	3041	java/net/SocketException
    //   2761	2770	3041	java/net/SocketException
    //   2866	2870	3041	java/net/SocketException
    //   2966	2972	3041	java/net/SocketException
    //   1768	1777	3048	java/net/SocketTimeoutException
    //   1873	1877	3048	java/net/SocketTimeoutException
    //   1973	1979	3048	java/net/SocketTimeoutException
    //   2099	2108	3048	java/net/SocketTimeoutException
    //   2204	2208	3048	java/net/SocketTimeoutException
    //   2304	2310	3048	java/net/SocketTimeoutException
    //   2430	2439	3048	java/net/SocketTimeoutException
    //   2535	2539	3048	java/net/SocketTimeoutException
    //   2635	2641	3048	java/net/SocketTimeoutException
    //   2761	2770	3048	java/net/SocketTimeoutException
    //   2866	2870	3048	java/net/SocketTimeoutException
    //   2966	2972	3048	java/net/SocketTimeoutException
    //   1768	1777	3055	java/lang/InterruptedException
    //   1873	1877	3055	java/lang/InterruptedException
    //   1973	1979	3055	java/lang/InterruptedException
    //   2099	2108	3055	java/lang/InterruptedException
    //   2204	2208	3055	java/lang/InterruptedException
    //   2304	2310	3055	java/lang/InterruptedException
    //   2430	2439	3055	java/lang/InterruptedException
    //   2535	2539	3055	java/lang/InterruptedException
    //   2635	2641	3055	java/lang/InterruptedException
    //   2761	2770	3055	java/lang/InterruptedException
    //   2866	2870	3055	java/lang/InterruptedException
    //   2966	2972	3055	java/lang/InterruptedException
    //   122	132	3070	finally
    //   136	151	3070	finally
    //   151	171	3070	finally
    //   171	184	3070	finally
    //   122	132	3088	java/lang/Exception
    //   136	151	3088	java/lang/Exception
    //   151	171	3088	java/lang/Exception
    //   171	184	3088	java/lang/Exception
    //   3123	3128	3131	java/lang/Exception
    //   3145	3150	3153	java/io/IOException
    //   3166	3170	3173	java/io/IOException
    //   122	132	3188	java/io/IOException
    //   136	151	3188	java/io/IOException
    //   151	171	3188	java/io/IOException
    //   171	184	3188	java/io/IOException
    //   3235	3240	3243	java/lang/Exception
    //   3258	3262	3265	java/io/IOException
    //   3278	3282	3285	java/io/IOException
    //   122	132	3289	java/net/MalformedURLException
    //   136	151	3289	java/net/MalformedURLException
    //   151	171	3289	java/net/MalformedURLException
    //   171	184	3289	java/net/MalformedURLException
    //   3393	3398	3401	java/lang/Exception
    //   3416	3420	3423	java/io/IOException
    //   3436	3440	3443	java/io/IOException
    //   122	132	3458	java/io/FileNotFoundException
    //   136	151	3458	java/io/FileNotFoundException
    //   151	171	3458	java/io/FileNotFoundException
    //   171	184	3458	java/io/FileNotFoundException
    //   3549	3554	3557	java/lang/Exception
    //   3571	3576	3579	java/io/IOException
    //   3592	3596	3599	java/io/IOException
    //   1768	1777	3614	finally
    //   1873	1877	3614	finally
    //   1973	1979	3614	finally
    //   2099	2108	3614	finally
    //   2204	2208	3614	finally
    //   2304	2310	3614	finally
    //   2430	2439	3614	finally
    //   2535	2539	3614	finally
    //   2635	2641	3614	finally
    //   2761	2770	3614	finally
    //   2866	2870	3614	finally
    //   2966	2972	3614	finally
    //   3110	3118	3614	finally
    //   3221	3230	3614	finally
    //   3322	3331	3614	finally
    //   3341	3349	3614	finally
    //   3359	3366	3614	finally
    //   3376	3388	3614	finally
    //   3481	3490	3614	finally
    //   3501	3508	3614	finally
    //   3519	3524	3614	finally
    //   3535	3544	3614	finally
    //   3643	3651	3614	finally
    //   3743	3751	3614	finally
    //   3854	3863	3614	finally
    //   122	132	3621	java/net/SocketException
    //   136	151	3621	java/net/SocketException
    //   151	171	3621	java/net/SocketException
    //   171	184	3621	java/net/SocketException
    //   3656	3661	3664	java/lang/Exception
    //   3678	3683	3686	java/io/IOException
    //   3699	3703	3706	java/io/IOException
    //   122	132	3721	java/net/SocketTimeoutException
    //   136	151	3721	java/net/SocketTimeoutException
    //   151	171	3721	java/net/SocketTimeoutException
    //   171	184	3721	java/net/SocketTimeoutException
    //   3756	3761	3764	java/lang/Exception
    //   3778	3783	3786	java/io/IOException
    //   3799	3803	3806	java/io/IOException
    //   122	132	3821	java/lang/InterruptedException
    //   136	151	3821	java/lang/InterruptedException
    //   151	171	3821	java/lang/InterruptedException
    //   171	184	3821	java/lang/InterruptedException
    //   3868	3873	3876	java/lang/Exception
    //   3891	3895	3898	java/io/IOException
    //   3911	3915	3918	java/io/IOException
    //   3962	3967	3970	java/lang/Exception
    //   3985	3989	3992	java/io/IOException
    //   4005	4009	4012	java/io/IOException
    //   193	202	4032	java/io/FileNotFoundException
    //   208	215	4032	java/io/FileNotFoundException
    //   225	243	4032	java/io/FileNotFoundException
    //   193	202	4061	java/net/SocketTimeoutException
    //   208	215	4061	java/net/SocketTimeoutException
    //   225	243	4061	java/net/SocketTimeoutException
    //   193	202	4090	java/net/SocketException
    //   208	215	4090	java/net/SocketException
    //   225	243	4090	java/net/SocketException
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      if (paramInputStream == null) {
        break label28;
      }
      paramInputStream.close();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      label20:
      label28:
      break label20;
    }
    SLog.b("Q.qqstory.download:DownloaderImp", "", paramHttpURLConnection);
  }
  
  public static void a(HashMap<String, String> paramHashMap, HttpURLConnection paramHttpURLConnection)
  {
    if (paramHashMap == null) {
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((str != null) && (localObject != null)) {
        paramHttpURLConnection.setRequestProperty(str, (String)localObject);
      }
    }
  }
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, null, 65536, paramLong, false);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DownloadProgressListener paramDownloadProgressListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener = paramDownloadProgressListener;
  }
  
  public boolean a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloaderImp
 * JD-Core Version:    0.7.0.1
 */