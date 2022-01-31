import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.DataUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;

public class bgfz
  extends HttpDownloadUtil
{
  private static final int a;
  
  static
  {
    jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneOfflineDecodePhotoQuality", 90);
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   3: lstore 18
    //   5: new 46	java/lang/Object
    //   8: dup
    //   9: invokespecial 49	java/lang/Object:<init>	()V
    //   12: astore 31
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: ldc 51
    //   20: iconst_1
    //   21: ldc 53
    //   23: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_4
    //   27: ireturn
    //   28: iload 4
    //   30: istore 12
    //   32: iload 4
    //   34: ifge +6 -> 40
    //   37: iconst_2
    //   38: istore 12
    //   40: aload_2
    //   41: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +15 -> 61
    //   49: aload_0
    //   50: invokevirtual 69	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_0
    //   57: invokevirtual 72	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 78	java/net/URL:toString	()Ljava/lang/String;
    //   67: astore 30
    //   69: aload 30
    //   71: ldc 80
    //   73: invokestatic 83	bgfz:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 32
    //   78: new 85	org/apache/http/client/methods/HttpGet
    //   81: dup
    //   82: aload 30
    //   84: invokespecial 88	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   87: astore 28
    //   89: new 90	org/apache/http/params/BasicHttpParams
    //   92: dup
    //   93: invokespecial 91	org/apache/http/params/BasicHttpParams:<init>	()V
    //   96: astore 33
    //   98: sipush 20000
    //   101: istore 7
    //   103: ldc 92
    //   105: istore 4
    //   107: aload_3
    //   108: ifnull +101 -> 209
    //   111: invokestatic 97	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   114: astore 23
    //   116: invokestatic 101	android/net/Proxy:getDefaultPort	()I
    //   119: istore 4
    //   121: aload_3
    //   122: invokevirtual 106	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   125: astore 24
    //   127: aload_3
    //   128: invokestatic 111	badq:a	(Landroid/net/NetworkInfo;)Z
    //   131: ifeq +49 -> 180
    //   134: aload 24
    //   136: ifnull +13 -> 149
    //   139: aload 24
    //   141: ldc 113
    //   143: invokevirtual 119	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: ifeq +34 -> 180
    //   149: aload 23
    //   151: ifnull +29 -> 180
    //   154: iload 4
    //   156: ifle +24 -> 180
    //   159: aload 33
    //   161: ldc 121
    //   163: new 123	org/apache/http/HttpHost
    //   166: dup
    //   167: aload 23
    //   169: iload 4
    //   171: invokespecial 126	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   174: invokeinterface 132 3 0
    //   179: pop
    //   180: aload_3
    //   181: invokestatic 111	badq:a	(Landroid/net/NetworkInfo;)Z
    //   184: ifeq +2224 -> 2408
    //   187: sipush 20000
    //   190: istore 7
    //   192: ldc 92
    //   194: istore 4
    //   196: aload 33
    //   198: ldc 134
    //   200: sipush 2048
    //   203: invokeinterface 138 3 0
    //   208: pop
    //   209: aload 33
    //   211: ldc 140
    //   213: iload 7
    //   215: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokeinterface 132 3 0
    //   223: pop
    //   224: aload 33
    //   226: ldc 148
    //   228: iload 4
    //   230: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 132 3 0
    //   238: pop
    //   239: aload 28
    //   241: aload 33
    //   243: invokevirtual 152	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   246: new 61	java/io/File
    //   249: dup
    //   250: new 154	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   257: aload_2
    //   258: invokevirtual 158	java/io/File:getPath	()Ljava/lang/String;
    //   261: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 164
    //   266: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 34
    //   277: aload_2
    //   278: ifnull +15 -> 293
    //   281: aload_2
    //   282: invokevirtual 69	java/io/File:exists	()Z
    //   285: ifeq +8 -> 293
    //   288: aload_2
    //   289: invokevirtual 169	java/io/File:delete	()Z
    //   292: pop
    //   293: aload 34
    //   295: ifnull +17 -> 312
    //   298: aload 34
    //   300: invokevirtual 69	java/io/File:exists	()Z
    //   303: ifeq +9 -> 312
    //   306: aload 34
    //   308: invokevirtual 169	java/io/File:delete	()Z
    //   311: pop
    //   312: aconst_null
    //   313: astore_3
    //   314: iconst_m1
    //   315: istore 13
    //   317: iload 13
    //   319: ifne +35 -> 354
    //   322: aload 33
    //   324: ldc 121
    //   326: new 123	org/apache/http/HttpHost
    //   329: dup
    //   330: aload_1
    //   331: invokevirtual 172	java/net/URL:getHost	()Ljava/lang/String;
    //   334: aload_1
    //   335: invokevirtual 175	java/net/URL:getPort	()I
    //   338: invokespecial 126	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   341: invokeinterface 132 3 0
    //   346: pop
    //   347: aload 28
    //   349: aload 33
    //   351: invokevirtual 152	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   354: iconst_5
    //   355: istore 4
    //   357: aload_3
    //   358: astore 26
    //   360: aload_0
    //   361: astore 25
    //   363: iload 4
    //   365: istore 8
    //   367: aload 30
    //   369: iload 6
    //   371: invokestatic 180	bgjb:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   374: astore 23
    //   376: aload 23
    //   378: ifnull +55 -> 433
    //   381: aload_3
    //   382: astore 26
    //   384: aload_0
    //   385: astore 25
    //   387: iload 4
    //   389: istore 8
    //   391: aload 28
    //   393: ldc 182
    //   395: aload 23
    //   397: invokevirtual 186	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_3
    //   401: astore 26
    //   403: aload_0
    //   404: astore 25
    //   406: iload 4
    //   408: istore 8
    //   410: new 154	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   417: ldc 188
    //   419: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 23
    //   424: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 190	bgjb:a	(Ljava/lang/String;)V
    //   433: aload_3
    //   434: astore 26
    //   436: aload_0
    //   437: astore 25
    //   439: iload 4
    //   441: istore 8
    //   443: invokestatic 193	bgjb:b	()Z
    //   446: ifeq +22 -> 468
    //   449: aload_3
    //   450: astore 26
    //   452: aload_0
    //   453: astore 25
    //   455: iload 4
    //   457: istore 8
    //   459: aload 28
    //   461: ldc 195
    //   463: ldc 197
    //   465: invokevirtual 186	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload_3
    //   469: astore 26
    //   471: aload_0
    //   472: astore 25
    //   474: iload 4
    //   476: istore 8
    //   478: aload 28
    //   480: ldc 199
    //   482: aload 5
    //   484: invokevirtual 186	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload_3
    //   488: astore 26
    //   490: aload_0
    //   491: astore 25
    //   493: iload 4
    //   495: istore 8
    //   497: new 154	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   504: ldc 201
    //   506: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 5
    //   511: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 190	bgjb:a	(Ljava/lang/String;)V
    //   520: aload_3
    //   521: astore 26
    //   523: aload_0
    //   524: astore 25
    //   526: iload 4
    //   528: istore 8
    //   530: getstatic 204	bgfz:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   533: new 123	org/apache/http/HttpHost
    //   536: dup
    //   537: aload_1
    //   538: invokevirtual 172	java/net/URL:getHost	()Ljava/lang/String;
    //   541: invokespecial 205	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   544: aload 28
    //   546: invokevirtual 211	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   549: astore 23
    //   551: aload_3
    //   552: astore 26
    //   554: aload_0
    //   555: astore 25
    //   557: iload 4
    //   559: istore 8
    //   561: aload 23
    //   563: invokeinterface 217 1 0
    //   568: astore 24
    //   570: aload_3
    //   571: astore 26
    //   573: aload_0
    //   574: astore 25
    //   576: iload 4
    //   578: istore 8
    //   580: aload 23
    //   582: invokeinterface 221 1 0
    //   587: astore 35
    //   589: aload_3
    //   590: astore 26
    //   592: aload_0
    //   593: astore 25
    //   595: iload 4
    //   597: istore 8
    //   599: new 223	java/util/HashMap
    //   602: dup
    //   603: invokespecial 224	java/util/HashMap:<init>	()V
    //   606: astore 36
    //   608: aload_3
    //   609: astore 26
    //   611: aload_0
    //   612: astore 25
    //   614: iload 4
    //   616: istore 8
    //   618: aload 24
    //   620: invokeinterface 229 1 0
    //   625: istore 9
    //   627: aload_3
    //   628: astore 26
    //   630: aload_0
    //   631: astore 25
    //   633: iload 4
    //   635: istore 8
    //   637: aload 23
    //   639: invokeinterface 233 1 0
    //   644: astore 23
    //   646: aload 23
    //   648: astore_3
    //   649: iload 9
    //   651: istore 7
    //   653: aload_0
    //   654: astore 24
    //   656: sipush 200
    //   659: iload 9
    //   661: if_icmpne +1489 -> 2150
    //   664: aload_0
    //   665: astore 23
    //   667: iload 4
    //   669: istore 9
    //   671: aload_0
    //   672: astore 25
    //   674: iload 4
    //   676: istore 10
    //   678: aload_0
    //   679: astore 27
    //   681: iload 4
    //   683: istore 11
    //   685: aload_0
    //   686: astore 24
    //   688: iload 4
    //   690: istore 8
    //   692: aload_3
    //   693: astore 26
    //   695: aload_3
    //   696: invokeinterface 238 1 0
    //   701: lstore 20
    //   703: lconst_0
    //   704: lstore 14
    //   706: aload_0
    //   707: astore 25
    //   709: iload 4
    //   711: istore 10
    //   713: aload_0
    //   714: astore 27
    //   716: iload 4
    //   718: istore 11
    //   720: aload_0
    //   721: astore 24
    //   723: iload 4
    //   725: istore 8
    //   727: aload_3
    //   728: astore 26
    //   730: new 240	java/io/BufferedOutputStream
    //   733: dup
    //   734: new 242	java/io/FileOutputStream
    //   737: dup
    //   738: aload_2
    //   739: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   742: invokespecial 248	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   745: astore 23
    //   747: aload 23
    //   749: astore 24
    //   751: iload 4
    //   753: istore 8
    //   755: aload 23
    //   757: astore 25
    //   759: iload 4
    //   761: istore 7
    //   763: aload 23
    //   765: astore 26
    //   767: iload 4
    //   769: istore 9
    //   771: aload_3
    //   772: aload 23
    //   774: invokeinterface 251 2 0
    //   779: aload 23
    //   781: astore 24
    //   783: iload 4
    //   785: istore 8
    //   787: aload 23
    //   789: astore 25
    //   791: iload 4
    //   793: istore 7
    //   795: aload 23
    //   797: astore 26
    //   799: iload 4
    //   801: istore 9
    //   803: aload 23
    //   805: invokevirtual 256	java/io/OutputStream:flush	()V
    //   808: aload 23
    //   810: astore 24
    //   812: iload 4
    //   814: istore 8
    //   816: aload 23
    //   818: astore 25
    //   820: iload 4
    //   822: istore 7
    //   824: aload 23
    //   826: astore 26
    //   828: iload 4
    //   830: istore 9
    //   832: aload_2
    //   833: invokevirtual 259	java/io/File:length	()J
    //   836: lstore 16
    //   838: lload 16
    //   840: lstore 14
    //   842: aload 23
    //   844: astore 24
    //   846: iload 4
    //   848: istore 8
    //   850: aload 23
    //   852: astore 25
    //   854: iload 4
    //   856: istore 7
    //   858: aload 23
    //   860: astore 26
    //   862: iload 4
    //   864: istore 9
    //   866: aload_2
    //   867: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   870: invokevirtual 263	java/io/File:setLastModified	(J)Z
    //   873: pop
    //   874: aload 23
    //   876: astore 24
    //   878: iload 4
    //   880: istore 8
    //   882: aload 23
    //   884: astore 25
    //   886: iload 4
    //   888: istore 7
    //   890: aload 23
    //   892: astore 26
    //   894: iload 4
    //   896: istore 9
    //   898: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq +79 -> 980
    //   904: aload 23
    //   906: astore 24
    //   908: iload 4
    //   910: istore 8
    //   912: aload 23
    //   914: astore 25
    //   916: iload 4
    //   918: istore 7
    //   920: aload 23
    //   922: astore 26
    //   924: iload 4
    //   926: istore 9
    //   928: ldc 51
    //   930: iconst_2
    //   931: new 154	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 268
    //   941: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   947: lload 18
    //   949: lsub
    //   950: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   953: ldc_w 273
    //   956: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: lload 14
    //   961: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   964: ldc_w 275
    //   967: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_1
    //   971: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 281	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: iconst_0
    //   981: istore 7
    //   983: iload 7
    //   985: istore 4
    //   987: aload 32
    //   989: ifnull +99 -> 1088
    //   992: iload 7
    //   994: istore 4
    //   996: aload 32
    //   998: invokevirtual 283	java/lang/String:length	()I
    //   1001: ifeq +87 -> 1088
    //   1004: aload_2
    //   1005: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1008: ldc 197
    //   1010: aload 35
    //   1012: ldc_w 288
    //   1015: invokestatic 291	bgfz:a	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1018: invokevirtual 294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1021: invokestatic 297	bgfz:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1024: astore_0
    //   1025: iload 7
    //   1027: istore 4
    //   1029: aload_0
    //   1030: ifnull +58 -> 1088
    //   1033: iload 7
    //   1035: istore 4
    //   1037: aload_0
    //   1038: aload 32
    //   1040: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1043: ifne +45 -> 1088
    //   1046: ldc 51
    //   1048: iconst_2
    //   1049: new 154	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1056: ldc_w 303
    //   1059: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload 30
    //   1064: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: ldc_w 305
    //   1070: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload_0
    //   1074: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: sipush -999
    //   1086: istore 4
    //   1088: aload 23
    //   1090: astore_0
    //   1091: iload 4
    //   1093: istore 7
    //   1095: lload 20
    //   1097: lconst_0
    //   1098: lcmp
    //   1099: ifle +136 -> 1235
    //   1102: iload 4
    //   1104: istore 7
    //   1106: lload 14
    //   1108: lload 20
    //   1110: lcmp
    //   1111: ifge +124 -> 1235
    //   1114: aload_0
    //   1115: astore 23
    //   1117: iload 4
    //   1119: istore 9
    //   1121: aload_0
    //   1122: astore 25
    //   1124: iload 4
    //   1126: istore 10
    //   1128: aload_0
    //   1129: astore 27
    //   1131: iload 4
    //   1133: istore 11
    //   1135: aload_0
    //   1136: astore 24
    //   1138: iload 4
    //   1140: istore 8
    //   1142: aload_3
    //   1143: astore 26
    //   1145: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1148: ifeq +2856 -> 4004
    //   1151: aload_0
    //   1152: astore 23
    //   1154: iload 4
    //   1156: istore 9
    //   1158: aload_0
    //   1159: astore 25
    //   1161: iload 4
    //   1163: istore 10
    //   1165: aload_0
    //   1166: astore 27
    //   1168: iload 4
    //   1170: istore 11
    //   1172: aload_0
    //   1173: astore 24
    //   1175: iload 4
    //   1177: istore 8
    //   1179: aload_3
    //   1180: astore 26
    //   1182: ldc 51
    //   1184: iconst_2
    //   1185: new 154	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 310
    //   1195: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: lload 20
    //   1200: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: ldc_w 312
    //   1206: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload_2
    //   1210: invokevirtual 259	java/io/File:length	()J
    //   1213: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1216: ldc_w 314
    //   1219: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_1
    //   1223: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: goto +2772 -> 4004
    //   1235: iload 7
    //   1237: ifne +2124 -> 3361
    //   1240: aload_0
    //   1241: astore 23
    //   1243: iload 7
    //   1245: istore 9
    //   1247: aload_0
    //   1248: astore 25
    //   1250: iload 7
    //   1252: istore 10
    //   1254: aload_0
    //   1255: astore 27
    //   1257: iload 7
    //   1259: istore 11
    //   1261: aload_0
    //   1262: astore 24
    //   1264: iload 7
    //   1266: istore 8
    //   1268: aload_3
    //   1269: astore 26
    //   1271: ldc_w 316
    //   1274: aload 35
    //   1276: ldc_w 318
    //   1279: invokestatic 291	bgfz:a	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1282: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1285: ifeq +819 -> 2104
    //   1288: aload_0
    //   1289: astore 23
    //   1291: iload 7
    //   1293: istore 9
    //   1295: aload_0
    //   1296: astore 25
    //   1298: iload 7
    //   1300: istore 10
    //   1302: aload_0
    //   1303: astore 27
    //   1305: iload 7
    //   1307: istore 11
    //   1309: aload_0
    //   1310: astore 24
    //   1312: iload 7
    //   1314: istore 8
    //   1316: aload_3
    //   1317: astore 26
    //   1319: invokestatic 324	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1322: invokestatic 329	becs:a	(Landroid/content/Context;)Z
    //   1325: ifeq +1786 -> 3111
    //   1328: aload_0
    //   1329: astore 23
    //   1331: iload 7
    //   1333: istore 9
    //   1335: aload_0
    //   1336: astore 25
    //   1338: iload 7
    //   1340: istore 10
    //   1342: aload_0
    //   1343: astore 27
    //   1345: iload 7
    //   1347: istore 11
    //   1349: aload_0
    //   1350: astore 24
    //   1352: iload 7
    //   1354: istore 8
    //   1356: aload_3
    //   1357: astore 26
    //   1359: aload 30
    //   1361: invokestatic 332	bgjb:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1364: astore 38
    //   1366: aload_0
    //   1367: astore 23
    //   1369: iload 7
    //   1371: istore 9
    //   1373: aload_0
    //   1374: astore 25
    //   1376: iload 7
    //   1378: istore 10
    //   1380: aload_0
    //   1381: astore 27
    //   1383: iload 7
    //   1385: istore 11
    //   1387: aload_0
    //   1388: astore 24
    //   1390: iload 7
    //   1392: istore 8
    //   1394: aload_3
    //   1395: astore 26
    //   1397: ldc_w 334
    //   1400: aload 38
    //   1402: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1405: ifne +87 -> 1492
    //   1408: aload_0
    //   1409: astore 23
    //   1411: iload 7
    //   1413: istore 9
    //   1415: aload_0
    //   1416: astore 25
    //   1418: iload 7
    //   1420: istore 10
    //   1422: aload_0
    //   1423: astore 27
    //   1425: iload 7
    //   1427: istore 11
    //   1429: aload_0
    //   1430: astore 24
    //   1432: iload 7
    //   1434: istore 8
    //   1436: aload_3
    //   1437: astore 26
    //   1439: ldc_w 336
    //   1442: aload 38
    //   1444: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1447: ifne +45 -> 1492
    //   1450: aload_0
    //   1451: astore 23
    //   1453: iload 7
    //   1455: istore 9
    //   1457: aload_0
    //   1458: astore 25
    //   1460: iload 7
    //   1462: istore 10
    //   1464: aload_0
    //   1465: astore 27
    //   1467: iload 7
    //   1469: istore 11
    //   1471: aload_0
    //   1472: astore 24
    //   1474: iload 7
    //   1476: istore 8
    //   1478: aload_3
    //   1479: astore 26
    //   1481: ldc_w 338
    //   1484: aload 38
    //   1486: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1489: ifeq +615 -> 2104
    //   1492: aload_0
    //   1493: astore 23
    //   1495: iload 7
    //   1497: istore 9
    //   1499: aload_0
    //   1500: astore 25
    //   1502: iload 7
    //   1504: istore 10
    //   1506: aload_0
    //   1507: astore 27
    //   1509: iload 7
    //   1511: istore 11
    //   1513: aload_0
    //   1514: astore 24
    //   1516: iload 7
    //   1518: istore 8
    //   1520: aload_3
    //   1521: astore 26
    //   1523: aload_2
    //   1524: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1527: astore 37
    //   1529: aload_0
    //   1530: astore 23
    //   1532: iload 7
    //   1534: istore 9
    //   1536: aload_0
    //   1537: astore 25
    //   1539: iload 7
    //   1541: istore 10
    //   1543: aload_0
    //   1544: astore 27
    //   1546: iload 7
    //   1548: istore 11
    //   1550: aload_0
    //   1551: astore 24
    //   1553: iload 7
    //   1555: istore 8
    //   1557: aload_3
    //   1558: astore 26
    //   1560: aload_2
    //   1561: invokestatic 341	becs:a	(Ljava/io/File;)Ljava/io/File;
    //   1564: astore 39
    //   1566: aload_0
    //   1567: astore 23
    //   1569: iload 7
    //   1571: istore 9
    //   1573: aload_0
    //   1574: astore 25
    //   1576: iload 7
    //   1578: istore 10
    //   1580: aload_0
    //   1581: astore 27
    //   1583: iload 7
    //   1585: istore 11
    //   1587: aload_0
    //   1588: astore 24
    //   1590: iload 7
    //   1592: istore 8
    //   1594: aload_3
    //   1595: astore 26
    //   1597: aload 39
    //   1599: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1602: invokestatic 347	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1605: astore 40
    //   1607: aload_0
    //   1608: astore 23
    //   1610: iload 7
    //   1612: istore 9
    //   1614: aload_0
    //   1615: astore 25
    //   1617: iload 7
    //   1619: istore 10
    //   1621: aload_0
    //   1622: astore 27
    //   1624: iload 7
    //   1626: istore 11
    //   1628: aload_0
    //   1629: astore 24
    //   1631: iload 7
    //   1633: istore 8
    //   1635: aload_3
    //   1636: astore 26
    //   1638: new 61	java/io/File
    //   1641: dup
    //   1642: aload 37
    //   1644: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   1647: astore 41
    //   1649: aload 40
    //   1651: ifnull +1246 -> 2897
    //   1654: aload_0
    //   1655: astore 23
    //   1657: iload 7
    //   1659: istore 9
    //   1661: aload_0
    //   1662: astore 25
    //   1664: iload 7
    //   1666: istore 10
    //   1668: aload_0
    //   1669: astore 27
    //   1671: iload 7
    //   1673: istore 11
    //   1675: aload_0
    //   1676: astore 24
    //   1678: iload 7
    //   1680: istore 8
    //   1682: aload_3
    //   1683: astore 26
    //   1685: ldc_w 338
    //   1688: aload 38
    //   1690: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1693: ifeq +880 -> 2573
    //   1696: aload_0
    //   1697: astore 23
    //   1699: iload 7
    //   1701: istore 9
    //   1703: aload_0
    //   1704: astore 25
    //   1706: iload 7
    //   1708: istore 10
    //   1710: aload_0
    //   1711: astore 27
    //   1713: iload 7
    //   1715: istore 11
    //   1717: aload_0
    //   1718: astore 24
    //   1720: iload 7
    //   1722: istore 8
    //   1724: aload_3
    //   1725: astore 26
    //   1727: getstatic 353	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1730: astore 29
    //   1732: aload_0
    //   1733: astore 23
    //   1735: iload 7
    //   1737: istore 9
    //   1739: aload_0
    //   1740: astore 25
    //   1742: iload 7
    //   1744: istore 10
    //   1746: aload_0
    //   1747: astore 27
    //   1749: iload 7
    //   1751: istore 11
    //   1753: aload_0
    //   1754: astore 24
    //   1756: iload 7
    //   1758: istore 8
    //   1760: aload_3
    //   1761: astore 26
    //   1763: aload 40
    //   1765: aload 37
    //   1767: aload 29
    //   1769: getstatic 24	bgfz:jdField_a_of_type_Int	I
    //   1772: iconst_1
    //   1773: invokestatic 358	bgfo:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;IZ)Z
    //   1776: ifeq +836 -> 2612
    //   1779: aload_0
    //   1780: astore 23
    //   1782: iload 7
    //   1784: istore 9
    //   1786: aload_0
    //   1787: astore 25
    //   1789: iload 7
    //   1791: istore 10
    //   1793: aload_0
    //   1794: astore 27
    //   1796: iload 7
    //   1798: istore 11
    //   1800: aload_0
    //   1801: astore 24
    //   1803: iload 7
    //   1805: istore 8
    //   1807: aload_3
    //   1808: astore 26
    //   1810: aload 39
    //   1812: invokestatic 363	bgfb:a	(Ljava/io/File;)Z
    //   1815: pop
    //   1816: aload_0
    //   1817: astore 23
    //   1819: iload 7
    //   1821: istore 9
    //   1823: aload_0
    //   1824: astore 25
    //   1826: iload 7
    //   1828: istore 10
    //   1830: aload_0
    //   1831: astore 27
    //   1833: iload 7
    //   1835: istore 11
    //   1837: aload_0
    //   1838: astore 24
    //   1840: iload 7
    //   1842: istore 8
    //   1844: aload_3
    //   1845: astore 26
    //   1847: aload 41
    //   1849: invokevirtual 259	java/io/File:length	()J
    //   1852: lstore 14
    //   1854: aload_0
    //   1855: astore 23
    //   1857: iload 7
    //   1859: istore 9
    //   1861: aload_0
    //   1862: astore 25
    //   1864: iload 7
    //   1866: istore 10
    //   1868: aload_0
    //   1869: astore 27
    //   1871: iload 7
    //   1873: istore 11
    //   1875: aload_0
    //   1876: astore 24
    //   1878: iload 7
    //   1880: istore 8
    //   1882: aload_3
    //   1883: astore 26
    //   1885: ldc_w 338
    //   1888: aload 38
    //   1890: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1893: ifeq +2118 -> 4011
    //   1896: ldc_w 365
    //   1899: astore 29
    //   1901: aload_0
    //   1902: astore 23
    //   1904: iload 7
    //   1906: istore 9
    //   1908: aload_0
    //   1909: astore 25
    //   1911: iload 7
    //   1913: istore 10
    //   1915: aload_0
    //   1916: astore 27
    //   1918: iload 7
    //   1920: istore 11
    //   1922: aload_0
    //   1923: astore 24
    //   1925: iload 7
    //   1927: istore 8
    //   1929: aload_3
    //   1930: astore 26
    //   1932: aload 36
    //   1934: ldc_w 318
    //   1937: aload 29
    //   1939: invokevirtual 369	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1942: pop
    //   1943: aload_0
    //   1944: astore 23
    //   1946: iload 7
    //   1948: istore 9
    //   1950: aload_0
    //   1951: astore 25
    //   1953: iload 7
    //   1955: istore 10
    //   1957: aload_0
    //   1958: astore 27
    //   1960: iload 7
    //   1962: istore 11
    //   1964: aload_0
    //   1965: astore 24
    //   1967: iload 7
    //   1969: istore 8
    //   1971: aload_3
    //   1972: astore 26
    //   1974: aload 36
    //   1976: ldc_w 371
    //   1979: lload 14
    //   1981: invokestatic 374	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1984: invokevirtual 369	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1987: pop
    //   1988: aload_0
    //   1989: astore 23
    //   1991: iload 7
    //   1993: istore 9
    //   1995: aload_0
    //   1996: astore 25
    //   1998: iload 7
    //   2000: istore 10
    //   2002: aload_0
    //   2003: astore 27
    //   2005: iload 7
    //   2007: istore 11
    //   2009: aload_0
    //   2010: astore 24
    //   2012: iload 7
    //   2014: istore 8
    //   2016: aload_3
    //   2017: astore 26
    //   2019: invokestatic 377	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2022: ifeq +82 -> 2104
    //   2025: aload_0
    //   2026: astore 23
    //   2028: iload 7
    //   2030: istore 9
    //   2032: aload_0
    //   2033: astore 25
    //   2035: iload 7
    //   2037: istore 10
    //   2039: aload_0
    //   2040: astore 27
    //   2042: iload 7
    //   2044: istore 11
    //   2046: aload_0
    //   2047: astore 24
    //   2049: iload 7
    //   2051: istore 8
    //   2053: aload_3
    //   2054: astore 26
    //   2056: ldc 51
    //   2058: iconst_4
    //   2059: new 154	java/lang/StringBuilder
    //   2062: dup
    //   2063: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2066: ldc_w 379
    //   2069: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: lload 14
    //   2074: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: ldc_w 381
    //   2080: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: aload_1
    //   2084: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2087: ldc_w 383
    //   2090: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: aload 37
    //   2095: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2101: invokestatic 281	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2104: aload_0
    //   2105: astore 23
    //   2107: iload 7
    //   2109: istore 9
    //   2111: aload_0
    //   2112: astore 25
    //   2114: iload 7
    //   2116: istore 10
    //   2118: aload_0
    //   2119: astore 27
    //   2121: iload 7
    //   2123: istore 11
    //   2125: aload_0
    //   2126: astore 24
    //   2128: iload 7
    //   2130: istore 8
    //   2132: aload_3
    //   2133: astore 26
    //   2135: aload 35
    //   2137: aload 34
    //   2139: aload 30
    //   2141: aload 36
    //   2143: invokestatic 386	bgfz:a	([Lorg/apache/http/Header;Ljava/io/File;Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2146: pop
    //   2147: aload_0
    //   2148: astore 24
    //   2150: aload_3
    //   2151: ifnull +9 -> 2160
    //   2154: aload_3
    //   2155: invokeinterface 389 1 0
    //   2160: aload 24
    //   2162: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2165: pop
    //   2166: iload 7
    //   2168: ifeq +1831 -> 3999
    //   2171: aload_2
    //   2172: ifnull +75 -> 2247
    //   2175: aload_2
    //   2176: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   2179: astore_0
    //   2180: aload_0
    //   2181: ifnull +15 -> 2196
    //   2184: aload_0
    //   2185: invokevirtual 69	java/io/File:exists	()Z
    //   2188: ifne +8 -> 2196
    //   2191: aload_0
    //   2192: invokevirtual 72	java/io/File:mkdirs	()Z
    //   2195: pop
    //   2196: aload_2
    //   2197: invokevirtual 69	java/io/File:exists	()Z
    //   2200: ifeq +47 -> 2247
    //   2203: aload_2
    //   2204: invokevirtual 169	java/io/File:delete	()Z
    //   2207: istore 22
    //   2209: ldc 51
    //   2211: iconst_1
    //   2212: new 154	java/lang/StringBuilder
    //   2215: dup
    //   2216: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2219: ldc_w 396
    //   2222: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: iload 22
    //   2227: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2230: ldc_w 401
    //   2233: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: aload 30
    //   2238: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2244: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2247: aload_3
    //   2248: astore_0
    //   2249: iload 13
    //   2251: iconst_1
    //   2252: iadd
    //   2253: istore 13
    //   2255: iload 7
    //   2257: ifeq +1479 -> 3736
    //   2260: ldc 51
    //   2262: iconst_1
    //   2263: new 154	java/lang/StringBuilder
    //   2266: dup
    //   2267: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2270: ldc_w 403
    //   2273: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: iload 7
    //   2278: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2281: ldc_w 314
    //   2284: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: aload_1
    //   2288: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2291: ldc_w 408
    //   2294: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: iload 13
    //   2299: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2302: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2305: invokestatic 308	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2308: iload 7
    //   2310: ifeq +31 -> 2341
    //   2313: iload 7
    //   2315: sipush -999
    //   2318: if_icmpeq +23 -> 2341
    //   2321: iload 13
    //   2323: iconst_2
    //   2324: if_icmpge +17 -> 2341
    //   2327: aload 31
    //   2329: monitorenter
    //   2330: aload 31
    //   2332: ldc2_w 409
    //   2335: invokevirtual 414	java/lang/Object:wait	(J)V
    //   2338: aload 31
    //   2340: monitorexit
    //   2341: iload 7
    //   2343: ifeq +18 -> 2361
    //   2346: iload 7
    //   2348: sipush -999
    //   2351: if_icmpeq +10 -> 2361
    //   2354: iload 13
    //   2356: iload 12
    //   2358: if_icmplt +1633 -> 3991
    //   2361: iload 7
    //   2363: ireturn
    //   2364: astore_0
    //   2365: ldc 51
    //   2367: iconst_1
    //   2368: ldc_w 416
    //   2371: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2374: iconst_4
    //   2375: ireturn
    //   2376: astore 23
    //   2378: new 85	org/apache/http/client/methods/HttpGet
    //   2381: dup
    //   2382: aload 30
    //   2384: invokestatic 418	bgfz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2387: invokespecial 88	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2390: astore 28
    //   2392: goto -2303 -> 89
    //   2395: astore_0
    //   2396: ldc 51
    //   2398: iconst_1
    //   2399: ldc_w 420
    //   2402: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2405: bipush 13
    //   2407: ireturn
    //   2408: sipush 10000
    //   2411: istore 7
    //   2413: sipush 30000
    //   2416: istore 4
    //   2418: aload 33
    //   2420: ldc 134
    //   2422: sipush 4096
    //   2425: invokeinterface 138 3 0
    //   2430: pop
    //   2431: goto -2222 -> 209
    //   2434: astore 24
    //   2436: aload 23
    //   2438: astore_0
    //   2439: iconst_5
    //   2440: istore 4
    //   2442: aload 24
    //   2444: astore 23
    //   2446: ldc 51
    //   2448: iconst_1
    //   2449: new 154	java/lang/StringBuilder
    //   2452: dup
    //   2453: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2456: ldc_w 422
    //   2459: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: aload_2
    //   2463: invokevirtual 69	java/io/File:exists	()Z
    //   2466: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2469: ldc_w 424
    //   2472: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2475: aload_2
    //   2476: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   2479: invokevirtual 69	java/io/File:exists	()Z
    //   2482: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2485: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2488: aload 23
    //   2490: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2493: goto -1402 -> 1091
    //   2496: astore_0
    //   2497: lconst_0
    //   2498: lstore 14
    //   2500: aload 23
    //   2502: astore 24
    //   2504: iload 4
    //   2506: istore 8
    //   2508: aload 23
    //   2510: astore 25
    //   2512: iload 4
    //   2514: istore 7
    //   2516: aload 23
    //   2518: astore 26
    //   2520: iload 4
    //   2522: istore 9
    //   2524: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2527: ifeq +37 -> 2564
    //   2530: aload 23
    //   2532: astore 24
    //   2534: iload 4
    //   2536: istore 8
    //   2538: aload 23
    //   2540: astore 25
    //   2542: iload 4
    //   2544: istore 7
    //   2546: aload 23
    //   2548: astore 26
    //   2550: iload 4
    //   2552: istore 9
    //   2554: ldc 51
    //   2556: iconst_2
    //   2557: ldc_w 429
    //   2560: aload_0
    //   2561: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2564: iconst_4
    //   2565: istore 4
    //   2567: aload 23
    //   2569: astore_0
    //   2570: goto -1479 -> 1091
    //   2573: aload_0
    //   2574: astore 23
    //   2576: iload 7
    //   2578: istore 9
    //   2580: aload_0
    //   2581: astore 25
    //   2583: iload 7
    //   2585: istore 10
    //   2587: aload_0
    //   2588: astore 27
    //   2590: iload 7
    //   2592: istore 11
    //   2594: aload_0
    //   2595: astore 24
    //   2597: iload 7
    //   2599: istore 8
    //   2601: aload_3
    //   2602: astore 26
    //   2604: getstatic 432	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2607: astore 29
    //   2609: goto -877 -> 1732
    //   2612: aload_0
    //   2613: astore 23
    //   2615: iload 7
    //   2617: istore 9
    //   2619: aload_0
    //   2620: astore 25
    //   2622: iload 7
    //   2624: istore 10
    //   2626: aload_0
    //   2627: astore 27
    //   2629: iload 7
    //   2631: istore 11
    //   2633: aload_0
    //   2634: astore 24
    //   2636: iload 7
    //   2638: istore 8
    //   2640: aload_3
    //   2641: astore 26
    //   2643: aload 39
    //   2645: aload 41
    //   2647: invokevirtual 435	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2650: pop
    //   2651: goto -547 -> 2104
    //   2654: astore 24
    //   2656: iload 9
    //   2658: istore 4
    //   2660: aload_3
    //   2661: astore 26
    //   2663: aload 23
    //   2665: astore 25
    //   2667: iload 4
    //   2669: istore 8
    //   2671: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2674: ifeq +42 -> 2716
    //   2677: aload_3
    //   2678: astore 26
    //   2680: aload 23
    //   2682: astore 25
    //   2684: iload 4
    //   2686: istore 8
    //   2688: ldc 51
    //   2690: iconst_2
    //   2691: new 154	java/lang/StringBuilder
    //   2694: dup
    //   2695: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2698: ldc_w 437
    //   2701: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2704: aload_1
    //   2705: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2708: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2711: aload 24
    //   2713: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2716: aload_3
    //   2717: astore 26
    //   2719: aload 23
    //   2721: astore 25
    //   2723: iload 4
    //   2725: istore 8
    //   2727: aload 24
    //   2729: instanceof 439
    //   2732: istore 22
    //   2734: iload 22
    //   2736: ifeq +847 -> 3583
    //   2739: bipush 10
    //   2741: istore 4
    //   2743: aload_3
    //   2744: ifnull +9 -> 2753
    //   2747: aload_3
    //   2748: invokeinterface 389 1 0
    //   2753: aload 23
    //   2755: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2758: pop
    //   2759: iload 4
    //   2761: istore 7
    //   2763: aload_3
    //   2764: astore_0
    //   2765: aload 23
    //   2767: astore 24
    //   2769: iload 4
    //   2771: ifeq -522 -> 2249
    //   2774: iload 4
    //   2776: istore 7
    //   2778: aload_3
    //   2779: astore_0
    //   2780: aload 23
    //   2782: astore 24
    //   2784: aload_2
    //   2785: ifnull -536 -> 2249
    //   2788: aload_2
    //   2789: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   2792: astore_0
    //   2793: aload_0
    //   2794: ifnull +15 -> 2809
    //   2797: aload_0
    //   2798: invokevirtual 69	java/io/File:exists	()Z
    //   2801: ifne +8 -> 2809
    //   2804: aload_0
    //   2805: invokevirtual 72	java/io/File:mkdirs	()Z
    //   2808: pop
    //   2809: iload 4
    //   2811: istore 7
    //   2813: aload_3
    //   2814: astore_0
    //   2815: aload 23
    //   2817: astore 24
    //   2819: aload_2
    //   2820: invokevirtual 69	java/io/File:exists	()Z
    //   2823: ifeq -574 -> 2249
    //   2826: aload_2
    //   2827: invokevirtual 169	java/io/File:delete	()Z
    //   2830: istore 22
    //   2832: ldc 51
    //   2834: iconst_1
    //   2835: new 154	java/lang/StringBuilder
    //   2838: dup
    //   2839: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2842: ldc_w 396
    //   2845: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2848: iload 22
    //   2850: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2853: ldc_w 401
    //   2856: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: aload 30
    //   2861: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2867: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2870: iload 4
    //   2872: istore 7
    //   2874: aload_3
    //   2875: astore_0
    //   2876: aload 23
    //   2878: astore 24
    //   2880: goto -631 -> 2249
    //   2883: astore_0
    //   2884: iload 4
    //   2886: istore 7
    //   2888: aload_3
    //   2889: astore_0
    //   2890: aload 23
    //   2892: astore 24
    //   2894: goto -645 -> 2249
    //   2897: aload_0
    //   2898: astore 23
    //   2900: iload 7
    //   2902: istore 9
    //   2904: aload_0
    //   2905: astore 25
    //   2907: iload 7
    //   2909: istore 10
    //   2911: aload_0
    //   2912: astore 27
    //   2914: iload 7
    //   2916: istore 11
    //   2918: aload_0
    //   2919: astore 24
    //   2921: iload 7
    //   2923: istore 8
    //   2925: aload_3
    //   2926: astore 26
    //   2928: aload 39
    //   2930: aload 41
    //   2932: invokevirtual 435	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2935: pop
    //   2936: goto -832 -> 2104
    //   2939: astore_0
    //   2940: iload 10
    //   2942: istore 4
    //   2944: aload 25
    //   2946: astore 23
    //   2948: aload_0
    //   2949: astore 25
    //   2951: aload 23
    //   2953: astore 24
    //   2955: iload 4
    //   2957: istore 8
    //   2959: aload_3
    //   2960: astore 26
    //   2962: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2965: ifeq +42 -> 3007
    //   2968: aload 23
    //   2970: astore 24
    //   2972: iload 4
    //   2974: istore 8
    //   2976: aload_3
    //   2977: astore 26
    //   2979: ldc 51
    //   2981: iconst_2
    //   2982: new 154	java/lang/StringBuilder
    //   2985: dup
    //   2986: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2989: ldc_w 441
    //   2992: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2995: aload_1
    //   2996: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2999: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3002: aload 25
    //   3004: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3007: iconst_5
    //   3008: istore 7
    //   3010: aload_3
    //   3011: ifnull +9 -> 3020
    //   3014: aload_3
    //   3015: invokeinterface 389 1 0
    //   3020: aload 23
    //   3022: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3025: pop
    //   3026: aload_2
    //   3027: ifnull +75 -> 3102
    //   3030: aload_2
    //   3031: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   3034: astore_0
    //   3035: aload_0
    //   3036: ifnull +15 -> 3051
    //   3039: aload_0
    //   3040: invokevirtual 69	java/io/File:exists	()Z
    //   3043: ifne +8 -> 3051
    //   3046: aload_0
    //   3047: invokevirtual 72	java/io/File:mkdirs	()Z
    //   3050: pop
    //   3051: aload_2
    //   3052: invokevirtual 69	java/io/File:exists	()Z
    //   3055: ifeq +47 -> 3102
    //   3058: aload_2
    //   3059: invokevirtual 169	java/io/File:delete	()Z
    //   3062: istore 22
    //   3064: ldc 51
    //   3066: iconst_1
    //   3067: new 154	java/lang/StringBuilder
    //   3070: dup
    //   3071: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3074: ldc_w 396
    //   3077: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3080: iload 22
    //   3082: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3085: ldc_w 401
    //   3088: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3091: aload 30
    //   3093: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3096: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3099: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3102: aload_3
    //   3103: astore_0
    //   3104: aload 23
    //   3106: astore 24
    //   3108: goto -859 -> 2249
    //   3111: aload_0
    //   3112: astore 23
    //   3114: iload 7
    //   3116: istore 9
    //   3118: aload_0
    //   3119: astore 25
    //   3121: iload 7
    //   3123: istore 10
    //   3125: aload_0
    //   3126: astore 27
    //   3128: iload 7
    //   3130: istore 11
    //   3132: aload_0
    //   3133: astore 24
    //   3135: iload 7
    //   3137: istore 8
    //   3139: aload_3
    //   3140: astore 26
    //   3142: invokestatic 377	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3145: ifeq -1041 -> 2104
    //   3148: aload_0
    //   3149: astore 23
    //   3151: iload 7
    //   3153: istore 9
    //   3155: aload_0
    //   3156: astore 25
    //   3158: iload 7
    //   3160: istore 10
    //   3162: aload_0
    //   3163: astore 27
    //   3165: iload 7
    //   3167: istore 11
    //   3169: aload_0
    //   3170: astore 24
    //   3172: iload 7
    //   3174: istore 8
    //   3176: aload_3
    //   3177: astore 26
    //   3179: ldc 51
    //   3181: iconst_4
    //   3182: ldc_w 443
    //   3185: invokestatic 281	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3188: goto -1084 -> 2104
    //   3191: astore 25
    //   3193: iload 11
    //   3195: istore 4
    //   3197: aload 27
    //   3199: astore 23
    //   3201: aload 23
    //   3203: astore 24
    //   3205: iload 4
    //   3207: istore 8
    //   3209: aload_3
    //   3210: astore 26
    //   3212: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3215: ifeq +42 -> 3257
    //   3218: aload 23
    //   3220: astore 24
    //   3222: iload 4
    //   3224: istore 8
    //   3226: aload_3
    //   3227: astore 26
    //   3229: ldc 51
    //   3231: iconst_2
    //   3232: new 154	java/lang/StringBuilder
    //   3235: dup
    //   3236: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3239: ldc_w 441
    //   3242: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3245: aload_1
    //   3246: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3249: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3252: aload 25
    //   3254: invokestatic 446	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3257: iconst_5
    //   3258: istore 7
    //   3260: aload_3
    //   3261: ifnull +9 -> 3270
    //   3264: aload_3
    //   3265: invokeinterface 389 1 0
    //   3270: aload 23
    //   3272: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3275: pop
    //   3276: aload_2
    //   3277: ifnull +75 -> 3352
    //   3280: aload_2
    //   3281: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   3284: astore_0
    //   3285: aload_0
    //   3286: ifnull +15 -> 3301
    //   3289: aload_0
    //   3290: invokevirtual 69	java/io/File:exists	()Z
    //   3293: ifne +8 -> 3301
    //   3296: aload_0
    //   3297: invokevirtual 72	java/io/File:mkdirs	()Z
    //   3300: pop
    //   3301: aload_2
    //   3302: invokevirtual 69	java/io/File:exists	()Z
    //   3305: ifeq +47 -> 3352
    //   3308: aload_2
    //   3309: invokevirtual 169	java/io/File:delete	()Z
    //   3312: istore 22
    //   3314: ldc 51
    //   3316: iconst_1
    //   3317: new 154	java/lang/StringBuilder
    //   3320: dup
    //   3321: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3324: ldc_w 396
    //   3327: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3330: iload 22
    //   3332: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3335: ldc_w 401
    //   3338: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: aload 30
    //   3343: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3346: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3349: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3352: aload_3
    //   3353: astore_0
    //   3354: aload 23
    //   3356: astore 24
    //   3358: goto -1109 -> 2249
    //   3361: aload_0
    //   3362: astore 23
    //   3364: iload 7
    //   3366: istore 9
    //   3368: aload_0
    //   3369: astore 25
    //   3371: iload 7
    //   3373: istore 10
    //   3375: aload_0
    //   3376: astore 27
    //   3378: iload 7
    //   3380: istore 11
    //   3382: aload_0
    //   3383: astore 24
    //   3385: iload 7
    //   3387: istore 8
    //   3389: aload_3
    //   3390: astore 26
    //   3392: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3395: ifeq -1248 -> 2147
    //   3398: aload_0
    //   3399: astore 23
    //   3401: iload 7
    //   3403: istore 9
    //   3405: aload_0
    //   3406: astore 25
    //   3408: iload 7
    //   3410: istore 10
    //   3412: aload_0
    //   3413: astore 27
    //   3415: iload 7
    //   3417: istore 11
    //   3419: aload_0
    //   3420: astore 24
    //   3422: iload 7
    //   3424: istore 8
    //   3426: aload_3
    //   3427: astore 26
    //   3429: ldc 51
    //   3431: iconst_2
    //   3432: new 154	java/lang/StringBuilder
    //   3435: dup
    //   3436: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3439: ldc_w 448
    //   3442: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: aload_1
    //   3446: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3449: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3452: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3455: goto -1308 -> 2147
    //   3458: astore_1
    //   3459: aload 26
    //   3461: astore_3
    //   3462: aload 24
    //   3464: astore_0
    //   3465: aload_3
    //   3466: ifnull +9 -> 3475
    //   3469: aload_3
    //   3470: invokeinterface 389 1 0
    //   3475: aload_0
    //   3476: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3479: pop
    //   3480: iload 8
    //   3482: ifeq +79 -> 3561
    //   3485: aload_2
    //   3486: ifnull +75 -> 3561
    //   3489: aload_2
    //   3490: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   3493: astore_0
    //   3494: aload_0
    //   3495: ifnull +15 -> 3510
    //   3498: aload_0
    //   3499: invokevirtual 69	java/io/File:exists	()Z
    //   3502: ifne +8 -> 3510
    //   3505: aload_0
    //   3506: invokevirtual 72	java/io/File:mkdirs	()Z
    //   3509: pop
    //   3510: aload_2
    //   3511: invokevirtual 69	java/io/File:exists	()Z
    //   3514: ifeq +47 -> 3561
    //   3517: aload_2
    //   3518: invokevirtual 169	java/io/File:delete	()Z
    //   3521: istore 22
    //   3523: ldc 51
    //   3525: iconst_1
    //   3526: new 154	java/lang/StringBuilder
    //   3529: dup
    //   3530: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3533: ldc_w 396
    //   3536: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: iload 22
    //   3541: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3544: ldc_w 401
    //   3547: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3550: aload 30
    //   3552: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3555: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3558: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3561: aload_1
    //   3562: athrow
    //   3563: astore_0
    //   3564: ldc 51
    //   3566: iconst_1
    //   3567: ldc_w 450
    //   3570: aload_0
    //   3571: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3574: goto -1414 -> 2160
    //   3577: astore_0
    //   3578: aload_3
    //   3579: astore_0
    //   3580: goto -1331 -> 2249
    //   3583: aload_3
    //   3584: astore 26
    //   3586: aload 23
    //   3588: astore 25
    //   3590: iload 4
    //   3592: istore 8
    //   3594: aload 24
    //   3596: instanceof 454
    //   3599: ifne +420 -> 4019
    //   3602: aload_3
    //   3603: astore 26
    //   3605: aload 23
    //   3607: astore 25
    //   3609: iload 4
    //   3611: istore 8
    //   3613: aload 24
    //   3615: instanceof 456
    //   3618: ifeq +6 -> 3624
    //   3621: goto +398 -> 4019
    //   3624: aload_3
    //   3625: astore 26
    //   3627: aload 23
    //   3629: astore 25
    //   3631: iload 4
    //   3633: istore 8
    //   3635: aload 24
    //   3637: instanceof 458
    //   3640: istore 22
    //   3642: iload 22
    //   3644: ifeq +10 -> 3654
    //   3647: bipush 11
    //   3649: istore 4
    //   3651: goto -908 -> 2743
    //   3654: iconst_4
    //   3655: istore 4
    //   3657: goto -914 -> 2743
    //   3660: astore_0
    //   3661: ldc 51
    //   3663: iconst_1
    //   3664: ldc_w 450
    //   3667: aload_0
    //   3668: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3671: goto -918 -> 2753
    //   3674: astore_0
    //   3675: ldc 51
    //   3677: iconst_1
    //   3678: ldc_w 450
    //   3681: aload_0
    //   3682: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3685: goto -665 -> 3020
    //   3688: astore_0
    //   3689: aload_3
    //   3690: astore_0
    //   3691: aload 23
    //   3693: astore 24
    //   3695: goto -1446 -> 2249
    //   3698: astore_0
    //   3699: ldc 51
    //   3701: iconst_1
    //   3702: ldc_w 450
    //   3705: aload_0
    //   3706: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3709: goto -439 -> 3270
    //   3712: astore_0
    //   3713: aload_3
    //   3714: astore_0
    //   3715: aload 23
    //   3717: astore 24
    //   3719: goto -1470 -> 2249
    //   3722: astore_3
    //   3723: ldc 51
    //   3725: iconst_1
    //   3726: ldc_w 450
    //   3729: aload_3
    //   3730: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3733: goto -258 -> 3475
    //   3736: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3739: ifeq -1431 -> 2308
    //   3742: ldc 51
    //   3744: iconst_2
    //   3745: new 154	java/lang/StringBuilder
    //   3748: dup
    //   3749: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   3752: ldc_w 403
    //   3755: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: iload 7
    //   3760: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3763: ldc_w 314
    //   3766: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3769: aload_1
    //   3770: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3773: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3776: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3779: goto -1471 -> 2308
    //   3782: astore_0
    //   3783: aload 31
    //   3785: monitorexit
    //   3786: aload_0
    //   3787: athrow
    //   3788: astore_3
    //   3789: goto -1451 -> 2338
    //   3792: astore_0
    //   3793: goto -232 -> 3561
    //   3796: astore_1
    //   3797: aload 24
    //   3799: astore_0
    //   3800: goto -335 -> 3465
    //   3803: astore_1
    //   3804: aload 23
    //   3806: astore_0
    //   3807: iconst_0
    //   3808: istore 8
    //   3810: goto -345 -> 3465
    //   3813: astore_1
    //   3814: iload 4
    //   3816: istore 8
    //   3818: goto -353 -> 3465
    //   3821: astore_1
    //   3822: aload 26
    //   3824: astore_3
    //   3825: aload 25
    //   3827: astore_0
    //   3828: goto -363 -> 3465
    //   3831: astore_0
    //   3832: aload 25
    //   3834: astore 23
    //   3836: aload_0
    //   3837: astore 25
    //   3839: iload 7
    //   3841: istore 4
    //   3843: goto -642 -> 3201
    //   3846: astore 25
    //   3848: iconst_0
    //   3849: istore 4
    //   3851: goto -650 -> 3201
    //   3854: astore 25
    //   3856: aload_0
    //   3857: astore 23
    //   3859: goto -658 -> 3201
    //   3862: astore 25
    //   3864: aload_0
    //   3865: astore 23
    //   3867: goto -666 -> 3201
    //   3870: astore 25
    //   3872: aload 26
    //   3874: astore 23
    //   3876: iload 9
    //   3878: istore 4
    //   3880: goto -929 -> 2951
    //   3883: astore 25
    //   3885: iconst_0
    //   3886: istore 4
    //   3888: goto -937 -> 2951
    //   3891: astore 25
    //   3893: aload_0
    //   3894: astore 23
    //   3896: goto -945 -> 2951
    //   3899: astore 25
    //   3901: aload_0
    //   3902: astore 23
    //   3904: goto -953 -> 2951
    //   3907: astore 24
    //   3909: aload_0
    //   3910: astore 23
    //   3912: goto -1252 -> 2660
    //   3915: astore 24
    //   3917: goto -1257 -> 2660
    //   3920: astore 24
    //   3922: aload_0
    //   3923: astore 23
    //   3925: goto -1265 -> 2660
    //   3928: astore_0
    //   3929: goto -1429 -> 2500
    //   3932: astore_0
    //   3933: iconst_0
    //   3934: istore 4
    //   3936: goto -1436 -> 2500
    //   3939: astore 24
    //   3941: aload_0
    //   3942: astore 23
    //   3944: lconst_0
    //   3945: lstore 14
    //   3947: aload 24
    //   3949: astore_0
    //   3950: goto -1450 -> 2500
    //   3953: astore 24
    //   3955: aload 23
    //   3957: astore_0
    //   3958: iconst_5
    //   3959: istore 4
    //   3961: aload 24
    //   3963: astore 23
    //   3965: goto -1519 -> 2446
    //   3968: astore 24
    //   3970: aload 23
    //   3972: astore_0
    //   3973: iconst_0
    //   3974: istore 4
    //   3976: aload 24
    //   3978: astore 23
    //   3980: goto -1534 -> 2446
    //   3983: astore 23
    //   3985: iconst_5
    //   3986: istore 4
    //   3988: goto -1542 -> 2446
    //   3991: aload_0
    //   3992: astore_3
    //   3993: aload 24
    //   3995: astore_0
    //   3996: goto -3679 -> 317
    //   3999: aload_3
    //   4000: astore_0
    //   4001: goto -1752 -> 2249
    //   4004: bipush 8
    //   4006: istore 7
    //   4008: goto -2773 -> 1235
    //   4011: ldc_w 460
    //   4014: astore 29
    //   4016: goto -2115 -> 1901
    //   4019: iconst_2
    //   4020: istore 4
    //   4022: goto -1279 -> 2743
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4025	0	paramAppInterface	AppInterface
    //   0	4025	1	paramURL	URL
    //   0	4025	2	paramFile	File
    //   0	4025	3	paramNetworkInfo	NetworkInfo
    //   0	4025	4	paramInt1	int
    //   0	4025	5	paramString	String
    //   0	4025	6	paramInt2	int
    //   101	3906	7	i	int
    //   365	3452	8	j	int
    //   625	3252	9	k	int
    //   676	2735	10	m	int
    //   683	2735	11	n	int
    //   30	2329	12	i1	int
    //   315	2044	13	i2	int
    //   704	3242	14	l1	long
    //   836	3	16	l2	long
    //   3	945	18	l3	long
    //   701	498	20	l4	long
    //   2207	1436	22	bool	boolean
    //   114	1992	23	localObject1	Object
    //   2376	61	23	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2444	1535	23	localObject2	Object
    //   3983	1	23	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	2036	24	localObject3	Object
    //   2434	9	24	localFileNotFoundException2	java.io.FileNotFoundException
    //   2502	133	24	localObject4	Object
    //   2654	74	24	localIOException1	java.io.IOException
    //   2767	1031	24	localObject5	Object
    //   3907	1	24	localIOException2	java.io.IOException
    //   3915	1	24	localIOException3	java.io.IOException
    //   3920	1	24	localIOException4	java.io.IOException
    //   3939	9	24	localIOException5	java.io.IOException
    //   3953	9	24	localFileNotFoundException3	java.io.FileNotFoundException
    //   3968	26	24	localFileNotFoundException4	java.io.FileNotFoundException
    //   361	2796	25	localObject6	Object
    //   3191	62	25	localThrowable1	java.lang.Throwable
    //   3369	469	25	localObject7	Object
    //   3846	1	25	localThrowable2	java.lang.Throwable
    //   3854	1	25	localThrowable3	java.lang.Throwable
    //   3862	1	25	localThrowable4	java.lang.Throwable
    //   3870	1	25	localException1	Exception
    //   3883	1	25	localException2	Exception
    //   3891	1	25	localException3	Exception
    //   3899	1	25	localException4	Exception
    //   358	3515	26	localObject8	Object
    //   679	2735	27	localAppInterface	AppInterface
    //   87	2304	28	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1730	2285	29	localObject9	Object
    //   67	3484	30	str1	String
    //   12	3772	31	localObject10	Object
    //   76	963	32	str2	String
    //   96	2323	33	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   275	1863	34	localFile1	File
    //   587	1549	35	arrayOfHeader	Header[]
    //   606	1536	36	localHashMap	java.util.HashMap
    //   1527	567	37	str3	String
    //   1364	525	38	str4	String
    //   1564	1365	39	localFile2	File
    //   1605	159	40	localBitmap	android.graphics.Bitmap
    //   1647	1284	41	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   40	45	2364	java/lang/Exception
    //   49	61	2364	java/lang/Exception
    //   78	89	2376	java/lang/IllegalArgumentException
    //   2378	2392	2395	java/lang/IllegalArgumentException
    //   771	779	2434	java/io/FileNotFoundException
    //   803	808	2434	java/io/FileNotFoundException
    //   832	838	2434	java/io/FileNotFoundException
    //   771	779	2496	java/io/IOException
    //   803	808	2496	java/io/IOException
    //   832	838	2496	java/io/IOException
    //   695	703	2654	java/io/IOException
    //   1145	1151	2654	java/io/IOException
    //   1182	1232	2654	java/io/IOException
    //   1271	1288	2654	java/io/IOException
    //   1319	1328	2654	java/io/IOException
    //   1359	1366	2654	java/io/IOException
    //   1397	1408	2654	java/io/IOException
    //   1439	1450	2654	java/io/IOException
    //   1481	1492	2654	java/io/IOException
    //   1523	1529	2654	java/io/IOException
    //   1560	1566	2654	java/io/IOException
    //   1597	1607	2654	java/io/IOException
    //   1638	1649	2654	java/io/IOException
    //   1685	1696	2654	java/io/IOException
    //   1727	1732	2654	java/io/IOException
    //   1763	1779	2654	java/io/IOException
    //   1810	1816	2654	java/io/IOException
    //   1847	1854	2654	java/io/IOException
    //   1885	1896	2654	java/io/IOException
    //   1932	1943	2654	java/io/IOException
    //   1974	1988	2654	java/io/IOException
    //   2019	2025	2654	java/io/IOException
    //   2056	2104	2654	java/io/IOException
    //   2135	2147	2654	java/io/IOException
    //   2604	2609	2654	java/io/IOException
    //   2643	2651	2654	java/io/IOException
    //   2928	2936	2654	java/io/IOException
    //   3142	3148	2654	java/io/IOException
    //   3179	3188	2654	java/io/IOException
    //   3392	3398	2654	java/io/IOException
    //   3429	3455	2654	java/io/IOException
    //   2788	2793	2883	java/lang/Exception
    //   2797	2809	2883	java/lang/Exception
    //   2819	2870	2883	java/lang/Exception
    //   695	703	2939	java/lang/Exception
    //   730	747	2939	java/lang/Exception
    //   1145	1151	2939	java/lang/Exception
    //   1182	1232	2939	java/lang/Exception
    //   1271	1288	2939	java/lang/Exception
    //   1319	1328	2939	java/lang/Exception
    //   1359	1366	2939	java/lang/Exception
    //   1397	1408	2939	java/lang/Exception
    //   1439	1450	2939	java/lang/Exception
    //   1481	1492	2939	java/lang/Exception
    //   1523	1529	2939	java/lang/Exception
    //   1560	1566	2939	java/lang/Exception
    //   1597	1607	2939	java/lang/Exception
    //   1638	1649	2939	java/lang/Exception
    //   1685	1696	2939	java/lang/Exception
    //   1727	1732	2939	java/lang/Exception
    //   1763	1779	2939	java/lang/Exception
    //   1810	1816	2939	java/lang/Exception
    //   1847	1854	2939	java/lang/Exception
    //   1885	1896	2939	java/lang/Exception
    //   1932	1943	2939	java/lang/Exception
    //   1974	1988	2939	java/lang/Exception
    //   2019	2025	2939	java/lang/Exception
    //   2056	2104	2939	java/lang/Exception
    //   2135	2147	2939	java/lang/Exception
    //   2604	2609	2939	java/lang/Exception
    //   2643	2651	2939	java/lang/Exception
    //   2928	2936	2939	java/lang/Exception
    //   3142	3148	2939	java/lang/Exception
    //   3179	3188	2939	java/lang/Exception
    //   3392	3398	2939	java/lang/Exception
    //   3429	3455	2939	java/lang/Exception
    //   695	703	3191	java/lang/Throwable
    //   730	747	3191	java/lang/Throwable
    //   1145	1151	3191	java/lang/Throwable
    //   1182	1232	3191	java/lang/Throwable
    //   1271	1288	3191	java/lang/Throwable
    //   1319	1328	3191	java/lang/Throwable
    //   1359	1366	3191	java/lang/Throwable
    //   1397	1408	3191	java/lang/Throwable
    //   1439	1450	3191	java/lang/Throwable
    //   1481	1492	3191	java/lang/Throwable
    //   1523	1529	3191	java/lang/Throwable
    //   1560	1566	3191	java/lang/Throwable
    //   1597	1607	3191	java/lang/Throwable
    //   1638	1649	3191	java/lang/Throwable
    //   1685	1696	3191	java/lang/Throwable
    //   1727	1732	3191	java/lang/Throwable
    //   1763	1779	3191	java/lang/Throwable
    //   1810	1816	3191	java/lang/Throwable
    //   1847	1854	3191	java/lang/Throwable
    //   1885	1896	3191	java/lang/Throwable
    //   1932	1943	3191	java/lang/Throwable
    //   1974	1988	3191	java/lang/Throwable
    //   2019	2025	3191	java/lang/Throwable
    //   2056	2104	3191	java/lang/Throwable
    //   2135	2147	3191	java/lang/Throwable
    //   2604	2609	3191	java/lang/Throwable
    //   2643	2651	3191	java/lang/Throwable
    //   2928	2936	3191	java/lang/Throwable
    //   3142	3148	3191	java/lang/Throwable
    //   3179	3188	3191	java/lang/Throwable
    //   3392	3398	3191	java/lang/Throwable
    //   3429	3455	3191	java/lang/Throwable
    //   695	703	3458	finally
    //   730	747	3458	finally
    //   1145	1151	3458	finally
    //   1182	1232	3458	finally
    //   1271	1288	3458	finally
    //   1319	1328	3458	finally
    //   1359	1366	3458	finally
    //   1397	1408	3458	finally
    //   1439	1450	3458	finally
    //   1481	1492	3458	finally
    //   1523	1529	3458	finally
    //   1560	1566	3458	finally
    //   1597	1607	3458	finally
    //   1638	1649	3458	finally
    //   1685	1696	3458	finally
    //   1727	1732	3458	finally
    //   1763	1779	3458	finally
    //   1810	1816	3458	finally
    //   1847	1854	3458	finally
    //   1885	1896	3458	finally
    //   1932	1943	3458	finally
    //   1974	1988	3458	finally
    //   2019	2025	3458	finally
    //   2056	2104	3458	finally
    //   2135	2147	3458	finally
    //   2604	2609	3458	finally
    //   2643	2651	3458	finally
    //   2928	2936	3458	finally
    //   2962	2968	3458	finally
    //   2979	3007	3458	finally
    //   3142	3148	3458	finally
    //   3179	3188	3458	finally
    //   3212	3218	3458	finally
    //   3229	3257	3458	finally
    //   3392	3398	3458	finally
    //   3429	3455	3458	finally
    //   2154	2160	3563	java/io/IOException
    //   2175	2180	3577	java/lang/Exception
    //   2184	2196	3577	java/lang/Exception
    //   2196	2247	3577	java/lang/Exception
    //   2747	2753	3660	java/io/IOException
    //   3014	3020	3674	java/io/IOException
    //   3030	3035	3688	java/lang/Exception
    //   3039	3051	3688	java/lang/Exception
    //   3051	3102	3688	java/lang/Exception
    //   3264	3270	3698	java/io/IOException
    //   3280	3285	3712	java/lang/Exception
    //   3289	3301	3712	java/lang/Exception
    //   3301	3352	3712	java/lang/Exception
    //   3469	3475	3722	java/io/IOException
    //   2330	2338	3782	finally
    //   2338	2341	3782	finally
    //   3783	3786	3782	finally
    //   2330	2338	3788	java/lang/InterruptedException
    //   3489	3494	3792	java/lang/Exception
    //   3498	3510	3792	java/lang/Exception
    //   3510	3561	3792	java/lang/Exception
    //   771	779	3796	finally
    //   803	808	3796	finally
    //   832	838	3796	finally
    //   866	874	3796	finally
    //   898	904	3796	finally
    //   928	980	3796	finally
    //   2524	2530	3796	finally
    //   2554	2564	3796	finally
    //   996	1025	3803	finally
    //   1037	1083	3803	finally
    //   2446	2493	3813	finally
    //   367	376	3821	finally
    //   391	400	3821	finally
    //   410	433	3821	finally
    //   443	449	3821	finally
    //   459	468	3821	finally
    //   478	487	3821	finally
    //   497	520	3821	finally
    //   530	551	3821	finally
    //   561	570	3821	finally
    //   580	589	3821	finally
    //   599	608	3821	finally
    //   618	627	3821	finally
    //   637	646	3821	finally
    //   2671	2677	3821	finally
    //   2688	2716	3821	finally
    //   2727	2734	3821	finally
    //   3594	3602	3821	finally
    //   3613	3621	3821	finally
    //   3635	3642	3821	finally
    //   771	779	3831	java/lang/Throwable
    //   803	808	3831	java/lang/Throwable
    //   832	838	3831	java/lang/Throwable
    //   866	874	3831	java/lang/Throwable
    //   898	904	3831	java/lang/Throwable
    //   928	980	3831	java/lang/Throwable
    //   2524	2530	3831	java/lang/Throwable
    //   2554	2564	3831	java/lang/Throwable
    //   996	1025	3846	java/lang/Throwable
    //   1037	1083	3846	java/lang/Throwable
    //   2446	2493	3854	java/lang/Throwable
    //   367	376	3862	java/lang/Throwable
    //   391	400	3862	java/lang/Throwable
    //   410	433	3862	java/lang/Throwable
    //   443	449	3862	java/lang/Throwable
    //   459	468	3862	java/lang/Throwable
    //   478	487	3862	java/lang/Throwable
    //   497	520	3862	java/lang/Throwable
    //   530	551	3862	java/lang/Throwable
    //   561	570	3862	java/lang/Throwable
    //   580	589	3862	java/lang/Throwable
    //   599	608	3862	java/lang/Throwable
    //   618	627	3862	java/lang/Throwable
    //   637	646	3862	java/lang/Throwable
    //   771	779	3870	java/lang/Exception
    //   803	808	3870	java/lang/Exception
    //   832	838	3870	java/lang/Exception
    //   866	874	3870	java/lang/Exception
    //   898	904	3870	java/lang/Exception
    //   928	980	3870	java/lang/Exception
    //   2524	2530	3870	java/lang/Exception
    //   2554	2564	3870	java/lang/Exception
    //   996	1025	3883	java/lang/Exception
    //   1037	1083	3883	java/lang/Exception
    //   2446	2493	3891	java/lang/Exception
    //   367	376	3899	java/lang/Exception
    //   391	400	3899	java/lang/Exception
    //   410	433	3899	java/lang/Exception
    //   443	449	3899	java/lang/Exception
    //   459	468	3899	java/lang/Exception
    //   478	487	3899	java/lang/Exception
    //   497	520	3899	java/lang/Exception
    //   530	551	3899	java/lang/Exception
    //   561	570	3899	java/lang/Exception
    //   580	589	3899	java/lang/Exception
    //   599	608	3899	java/lang/Exception
    //   618	627	3899	java/lang/Exception
    //   637	646	3899	java/lang/Exception
    //   2446	2493	3907	java/io/IOException
    //   2524	2530	3915	java/io/IOException
    //   2554	2564	3915	java/io/IOException
    //   367	376	3920	java/io/IOException
    //   391	400	3920	java/io/IOException
    //   410	433	3920	java/io/IOException
    //   443	449	3920	java/io/IOException
    //   459	468	3920	java/io/IOException
    //   478	487	3920	java/io/IOException
    //   497	520	3920	java/io/IOException
    //   530	551	3920	java/io/IOException
    //   561	570	3920	java/io/IOException
    //   580	589	3920	java/io/IOException
    //   599	608	3920	java/io/IOException
    //   618	627	3920	java/io/IOException
    //   637	646	3920	java/io/IOException
    //   866	874	3928	java/io/IOException
    //   898	904	3928	java/io/IOException
    //   928	980	3928	java/io/IOException
    //   996	1025	3932	java/io/IOException
    //   1037	1083	3932	java/io/IOException
    //   730	747	3939	java/io/IOException
    //   866	874	3953	java/io/FileNotFoundException
    //   898	904	3953	java/io/FileNotFoundException
    //   928	980	3953	java/io/FileNotFoundException
    //   996	1025	3968	java/io/FileNotFoundException
    //   1037	1083	3968	java/io/FileNotFoundException
    //   730	747	3983	java/io/FileNotFoundException
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      str1 = str2;
      if (paramString1.length() != 0)
      {
        str1 = str2;
        if (paramString2 != null)
        {
          if (paramString2.length() != 0) {
            break label46;
          }
          str1 = str2;
        }
      }
    }
    return str1;
    label46:
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("\\&");
    int j = arrayOfString.length;
    int i = 0;
    paramString1 = str2;
    for (;;)
    {
      str1 = paramString1;
      if (i >= j) {
        break;
      }
      str1 = arrayOfString[i];
      if (str1.contains(paramString2)) {
        paramString1 = str1.replace(paramString2 + "=", "");
      }
      i += 1;
    }
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    paramString = b(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.toLowerCase();
    }
    return "";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 49;
    char[] tmp22_16 = tmp16_10;
    tmp22_16[2] = 50;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[3] = 51;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 52;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 53;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 54;
    char[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 55;
    char[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 56;
    char[] tmp67_60 = tmp60_53;
    tmp67_60[9] = 57;
    char[] tmp74_67 = tmp67_60;
    tmp74_67[10] = 65;
    char[] tmp81_74 = tmp74_67;
    tmp81_74[11] = 66;
    char[] tmp88_81 = tmp81_74;
    tmp88_81[12] = 67;
    char[] tmp95_88 = tmp88_81;
    tmp95_88[13] = 68;
    char[] tmp102_95 = tmp95_88;
    tmp102_95[14] = 69;
    char[] tmp109_102 = tmp102_95;
    tmp109_102[15] = 70;
    tmp109_102;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  private static String a(Header[] paramArrayOfHeader, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      if (paramArrayOfHeader != null)
      {
        int j = paramArrayOfHeader.length;
        int i = 0;
        while (i < j)
        {
          Header localHeader = paramArrayOfHeader[i];
          if ((localHeader != null) && (paramString.equals(localHeader.getName()))) {
            return localHeader.getValue();
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString1, File paramFile, String paramString2, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return false;
    }
    paramString1 = b(paramString1);
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        paramInt = a(paramAppInterface, paramString1, paramFile, localNetworkInfo, 2, paramString2, paramInt);
        if (QLog.isColorLevel()) {
          QLog.i("QZoneHttpDownloadUtil", 2, paramString2 + "\nurl = " + paramString1.toString() + "\nRESULT_CODE = " + paramInt);
        }
        if (paramInt == 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (MalformedURLException paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  private static boolean a(Header[] paramArrayOfHeader, File paramFile, String paramString, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 6
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: new 547	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 548	org/json/JSONObject:<init>	()V
    //   22: astore 13
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: arraylength
    //   29: istore 5
    //   31: iload 5
    //   33: ifle -20 -> 13
    //   36: new 242	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore 9
    //   46: iconst_0
    //   47: istore 4
    //   49: iload 4
    //   51: iload 5
    //   53: if_icmpge +296 -> 349
    //   56: aload_0
    //   57: iload 4
    //   59: aaload
    //   60: astore 11
    //   62: iload 6
    //   64: istore 7
    //   66: aload 9
    //   68: astore 10
    //   70: aload 11
    //   72: invokeinterface 518 1 0
    //   77: astore 14
    //   79: iload 6
    //   81: istore 7
    //   83: aload 9
    //   85: astore 10
    //   87: aload 11
    //   89: invokeinterface 521 1 0
    //   94: astore 12
    //   96: aload 12
    //   98: astore 11
    //   100: aload_3
    //   101: ifnull +43 -> 144
    //   104: aload 12
    //   106: astore 11
    //   108: iload 6
    //   110: istore 7
    //   112: aload 9
    //   114: astore 10
    //   116: aload_3
    //   117: aload 14
    //   119: invokevirtual 551	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +22 -> 144
    //   125: iload 6
    //   127: istore 7
    //   129: aload 9
    //   131: astore 10
    //   133: aload_3
    //   134: aload 14
    //   136: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 115	java/lang/String
    //   142: astore 11
    //   144: iload 6
    //   146: istore 7
    //   148: aload 9
    //   150: astore 10
    //   152: ldc_w 557
    //   155: aload 14
    //   157: invokevirtual 294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifne +407 -> 567
    //   163: iload 6
    //   165: istore 7
    //   167: aload 9
    //   169: astore 10
    //   171: ldc_w 559
    //   174: aload 14
    //   176: invokevirtual 294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifne +388 -> 567
    //   182: iload 6
    //   184: istore 7
    //   186: aload 9
    //   188: astore 10
    //   190: ldc_w 561
    //   193: aload 14
    //   195: invokevirtual 294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +366 -> 567
    //   204: iload 6
    //   206: istore 7
    //   208: aload 9
    //   210: astore 10
    //   212: aload_2
    //   213: invokestatic 563	bgjb:b	(Ljava/lang/String;)Z
    //   216: ifeq +29 -> 245
    //   219: iload 6
    //   221: istore 7
    //   223: aload 9
    //   225: astore 10
    //   227: ldc_w 288
    //   230: aload 14
    //   232: invokevirtual 294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: istore 8
    //   237: iload 8
    //   239: ifeq +6 -> 245
    //   242: goto +325 -> 567
    //   245: iload 6
    //   247: istore 7
    //   249: aload 9
    //   251: astore 10
    //   253: aload 13
    //   255: aload 14
    //   257: aload 11
    //   259: invokevirtual 566	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: iload 6
    //   265: istore 7
    //   267: aload 9
    //   269: astore 10
    //   271: new 154	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 568
    //   281: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 14
    //   286: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 570
    //   292: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 190	bgjb:a	(Ljava/lang/String;)V
    //   306: goto +261 -> 567
    //   309: astore 11
    //   311: iload 6
    //   313: istore 7
    //   315: aload 9
    //   317: astore 10
    //   319: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +254 -> 576
    //   325: iload 6
    //   327: istore 7
    //   329: aload 9
    //   331: astore 10
    //   333: ldc 51
    //   335: iconst_2
    //   336: aload 11
    //   338: invokevirtual 573	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   341: aload 11
    //   343: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto +230 -> 576
    //   349: iload 6
    //   351: ifeq +56 -> 407
    //   354: iload 6
    //   356: istore 7
    //   358: aload 9
    //   360: astore 10
    //   362: aload 9
    //   364: aload 13
    //   366: invokevirtual 574	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: ldc_w 576
    //   372: invokevirtual 580	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   375: invokevirtual 584	java/io/FileOutputStream:write	([B)V
    //   378: iload 6
    //   380: istore 7
    //   382: aload 9
    //   384: astore 10
    //   386: aload 9
    //   388: invokevirtual 585	java/io/FileOutputStream:flush	()V
    //   391: iload 6
    //   393: istore 7
    //   395: aload 9
    //   397: astore 10
    //   399: aload_1
    //   400: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   403: invokevirtual 263	java/io/File:setLastModified	(J)Z
    //   406: pop
    //   407: aload 9
    //   409: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   412: pop
    //   413: iload 6
    //   415: ireturn
    //   416: astore_0
    //   417: iload 7
    //   419: istore 6
    //   421: aload 10
    //   423: astore_0
    //   424: ldc 51
    //   426: iconst_1
    //   427: new 154	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 422
    //   437: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 69	java/io/File:exists	()Z
    //   444: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   447: ldc_w 424
    //   450: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   457: invokevirtual 69	java/io/File:exists	()Z
    //   460: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   463: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   473: pop
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_0
    //   477: aconst_null
    //   478: astore 9
    //   480: iload 8
    //   482: istore 6
    //   484: iload 6
    //   486: istore 7
    //   488: aload 9
    //   490: astore 10
    //   492: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +22 -> 517
    //   498: iload 6
    //   500: istore 7
    //   502: aload 9
    //   504: astore 10
    //   506: ldc 51
    //   508: iconst_2
    //   509: aload_0
    //   510: invokevirtual 586	java/io/IOException:getMessage	()Ljava/lang/String;
    //   513: aload_0
    //   514: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload 9
    //   519: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   522: pop
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_0
    //   526: iconst_1
    //   527: istore 6
    //   529: aconst_null
    //   530: astore 10
    //   532: aload 10
    //   534: invokestatic 394	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   537: pop
    //   538: iload 6
    //   540: ireturn
    //   541: astore_0
    //   542: iload 7
    //   544: istore 6
    //   546: goto -14 -> 532
    //   549: astore_1
    //   550: aload_0
    //   551: astore 10
    //   553: goto -21 -> 532
    //   556: astore_0
    //   557: goto -73 -> 484
    //   560: astore_0
    //   561: aload 9
    //   563: astore_0
    //   564: goto -140 -> 424
    //   567: iload 4
    //   569: iconst_1
    //   570: iadd
    //   571: istore 4
    //   573: goto -524 -> 49
    //   576: iconst_0
    //   577: istore 6
    //   579: goto -12 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	paramArrayOfHeader	Header[]
    //   0	582	1	paramFile	File
    //   0	582	2	paramString	String
    //   0	582	3	paramHashMap	java.util.HashMap<String, String>
    //   47	525	4	i	int
    //   29	25	5	j	int
    //   7	571	6	bool1	boolean
    //   1	542	7	bool2	boolean
    //   4	477	8	bool3	boolean
    //   44	518	9	localFileOutputStream	java.io.FileOutputStream
    //   25	527	10	localObject1	Object
    //   60	236	11	localObject2	Object
    //   309	33	11	localJSONException	org.json.JSONException
    //   94	11	12	str1	String
    //   22	343	13	localJSONObject	org.json.JSONObject
    //   77	208	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   253	263	309	org/json/JSONException
    //   271	306	309	org/json/JSONException
    //   36	46	416	java/io/FileNotFoundException
    //   36	46	476	java/io/IOException
    //   36	46	525	finally
    //   70	79	541	finally
    //   87	96	541	finally
    //   116	125	541	finally
    //   133	144	541	finally
    //   152	163	541	finally
    //   171	182	541	finally
    //   190	201	541	finally
    //   212	219	541	finally
    //   227	237	541	finally
    //   253	263	541	finally
    //   271	306	541	finally
    //   319	325	541	finally
    //   333	346	541	finally
    //   362	378	541	finally
    //   386	391	541	finally
    //   399	407	541	finally
    //   492	498	541	finally
    //   506	517	541	finally
    //   424	469	549	finally
    //   70	79	556	java/io/IOException
    //   87	96	556	java/io/IOException
    //   116	125	556	java/io/IOException
    //   133	144	556	java/io/IOException
    //   152	163	556	java/io/IOException
    //   171	182	556	java/io/IOException
    //   190	201	556	java/io/IOException
    //   212	219	556	java/io/IOException
    //   227	237	556	java/io/IOException
    //   253	263	556	java/io/IOException
    //   271	306	556	java/io/IOException
    //   319	325	556	java/io/IOException
    //   333	346	556	java/io/IOException
    //   362	378	556	java/io/IOException
    //   386	391	556	java/io/IOException
    //   399	407	556	java/io/IOException
    //   70	79	560	java/io/FileNotFoundException
    //   87	96	560	java/io/FileNotFoundException
    //   116	125	560	java/io/FileNotFoundException
    //   133	144	560	java/io/FileNotFoundException
    //   152	163	560	java/io/FileNotFoundException
    //   171	182	560	java/io/FileNotFoundException
    //   190	201	560	java/io/FileNotFoundException
    //   212	219	560	java/io/FileNotFoundException
    //   227	237	560	java/io/FileNotFoundException
    //   253	263	560	java/io/FileNotFoundException
    //   271	306	560	java/io/FileNotFoundException
    //   319	325	560	java/io/FileNotFoundException
    //   333	346	560	java/io/FileNotFoundException
    //   362	378	560	java/io/FileNotFoundException
    //   386	391	560	java/io/FileNotFoundException
    //   399	407	560	java/io/FileNotFoundException
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("#");
      str = paramString;
      if (i > -1) {
        str = paramString.substring(0, i);
      }
    }
    return str;
  }
  
  private static String b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    localObject3 = new File(paramString);
    if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile()))
    {
      QLog.w("QZoneHttpDownloadUtil", 2, "encode-File does not exist or is not file:" + paramString);
      return "";
    }
    localObject2 = null;
    paramString = null;
    str2 = paramString;
    localObject1 = localObject2;
    try
    {
      localObject3 = new BufferedInputStream(new FileInputStream((File)localObject3), 8192);
      if (!paramBoolean) {
        break label215;
      }
      str2 = paramString;
      localObject1 = localObject2;
      paramString = new GZIPInputStream((InputStream)localObject3);
    }
    catch (Exception paramString) {}finally
    {
      int i;
      String str1;
      DataUtils.closeDataObject(str1);
    }
    str2 = paramString;
    localObject1 = paramString;
    localObject3 = MessageDigest.getInstance("MD5");
    str2 = paramString;
    localObject1 = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgfz
 * JD-Core Version:    0.7.0.1
 */