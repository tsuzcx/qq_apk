import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class bahp
{
  private static long a()
  {
    boolean bool = bdep.a();
    long l1 = bdep.a();
    long l2 = bdep.b();
    if ((bool) && (l1 != 0L)) {
      return Math.min(l1, l2) * 1024L;
    }
    return l2 * 1024L;
  }
  
  /* Error */
  public static final String a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +11 -> 15
    //   7: aload 5
    //   9: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: ldc 38
    //   17: iconst_1
    //   18: ldc 40
    //   20: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: sipush 142
    //   29: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   32: checkcast 53	bagr
    //   35: astore 14
    //   37: new 55	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   44: astore_0
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: new 69	bafw
    //   61: dup
    //   62: invokespecial 70	bafw:<init>	()V
    //   65: astore 13
    //   67: ldc 72
    //   69: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   72: astore 15
    //   74: aload 15
    //   76: aconst_null
    //   77: iconst_1
    //   78: anewarray 80	javax/net/ssl/TrustManager
    //   81: dup
    //   82: iconst_0
    //   83: aload 13
    //   85: aastore
    //   86: aconst_null
    //   87: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   90: new 86	bafy
    //   93: dup
    //   94: aload 15
    //   96: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   99: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   102: astore 15
    //   104: aload 15
    //   106: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   109: new 100	java/net/URL
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   120: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   123: astore 13
    //   125: aload 13
    //   127: aload 15
    //   129: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   132: aload 13
    //   134: sipush 5000
    //   137: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   140: aload 13
    //   142: sipush 30000
    //   145: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   148: aload 13
    //   150: iconst_1
    //   151: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   154: aload 13
    //   156: iconst_1
    //   157: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   160: aload 13
    //   162: iconst_0
    //   163: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   166: aload 13
    //   168: ldc 129
    //   170: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload 13
    //   175: ldc 134
    //   177: ldc 136
    //   179: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 13
    //   184: ldc 142
    //   186: new 55	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 144
    //   192: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: ldc 147
    //   197: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   203: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 147
    //   208: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   214: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 147
    //   219: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   225: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 147
    //   230: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 163
    //   235: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 147
    //   240: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 165
    //   245: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 167
    //   250: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 13
    //   261: ldc 169
    //   263: ldc 171
    //   265: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 13
    //   270: ldc 173
    //   272: new 55	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   279: ldc 175
    //   281: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 177
    //   286: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: new 179	java/util/HashMap
    //   298: dup
    //   299: invokespecial 180	java/util/HashMap:<init>	()V
    //   302: astore 15
    //   304: aload 15
    //   306: ldc 134
    //   308: ldc 182
    //   310: invokeinterface 188 3 0
    //   315: pop
    //   316: aload 15
    //   318: ldc 190
    //   320: aload_3
    //   321: invokeinterface 188 3 0
    //   326: pop
    //   327: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   330: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   333: iconst_2
    //   334: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   337: checkcast 208	mqq/manager/TicketManager
    //   340: astore_0
    //   341: aload_0
    //   342: aload 5
    //   344: invokeinterface 212 2 0
    //   349: pop
    //   350: aload_1
    //   351: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +687 -> 1041
    //   357: aload_0
    //   358: aload 5
    //   360: ldc 214
    //   362: invokeinterface 218 3 0
    //   367: astore_0
    //   368: aload_0
    //   369: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +160 -> 532
    //   375: ldc 38
    //   377: iconst_1
    //   378: ldc 220
    //   380: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +18 -> 406
    //   391: aload 15
    //   393: ldc 227
    //   395: aload_0
    //   396: aload_1
    //   397: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokeinterface 188 3 0
    //   405: pop
    //   406: aload 15
    //   408: invokeinterface 234 1 0
    //   413: invokeinterface 240 1 0
    //   418: astore_0
    //   419: aload_0
    //   420: invokeinterface 245 1 0
    //   425: ifeq +147 -> 572
    //   428: aload_0
    //   429: invokeinterface 249 1 0
    //   434: checkcast 251	java/util/Map$Entry
    //   437: astore_1
    //   438: aload 13
    //   440: aload_1
    //   441: invokeinterface 254 1 0
    //   446: checkcast 256	java/lang/String
    //   449: aload_1
    //   450: invokeinterface 259 1 0
    //   455: checkcast 256	java/lang/String
    //   458: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -42 -> 419
    //   464: astore_1
    //   465: aload 13
    //   467: astore_0
    //   468: ldc_w 261
    //   471: iconst_1
    //   472: new 55	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 263
    //   482: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_1
    //   486: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 14
    //   500: iconst_1
    //   501: iconst_1
    //   502: iconst_2
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: ldc_w 268
    //   511: invokestatic 273	alud:a	(I)Ljava/lang/String;
    //   514: aastore
    //   515: dup
    //   516: iconst_1
    //   517: aload_3
    //   518: aastore
    //   519: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   522: aload_0
    //   523: ifnull +7 -> 530
    //   526: aload_0
    //   527: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   530: aconst_null
    //   531: areturn
    //   532: aload 15
    //   534: ldc_w 282
    //   537: new 55	java/lang/StringBuilder
    //   540: dup
    //   541: aload 4
    //   543: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokeinterface 188 3 0
    //   554: pop
    //   555: goto -149 -> 406
    //   558: astore_0
    //   559: aload 13
    //   561: astore_1
    //   562: aload_1
    //   563: ifnull +7 -> 570
    //   566: aload_1
    //   567: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   570: aload_0
    //   571: athrow
    //   572: aload 13
    //   574: invokevirtual 285	javax/net/ssl/HttpsURLConnection:connect	()V
    //   577: aload 13
    //   579: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   582: istore 7
    //   584: invokestatic 290	bahp:a	()J
    //   587: lstore 9
    //   589: iload 7
    //   591: i2l
    //   592: lload 9
    //   594: lcmp
    //   595: ifle +40 -> 635
    //   598: aload 14
    //   600: iconst_1
    //   601: iconst_1
    //   602: iconst_2
    //   603: anewarray 4	java/lang/Object
    //   606: dup
    //   607: iconst_0
    //   608: ldc_w 291
    //   611: invokestatic 273	alud:a	(I)Ljava/lang/String;
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: aload_3
    //   618: aastore
    //   619: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   622: aload 13
    //   624: ifnull -94 -> 530
    //   627: aload 13
    //   629: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   632: goto -102 -> 530
    //   635: aload 13
    //   637: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   640: astore 4
    //   642: new 297	java/io/ByteArrayOutputStream
    //   645: dup
    //   646: invokespecial 298	java/io/ByteArrayOutputStream:<init>	()V
    //   649: astore 5
    //   651: iconst_0
    //   652: istore 6
    //   654: sipush 10240
    //   657: newarray byte
    //   659: astore_0
    //   660: lconst_0
    //   661: lstore 9
    //   663: aload 4
    //   665: aload_0
    //   666: invokevirtual 304	java/io/InputStream:read	([B)I
    //   669: istore 8
    //   671: iload 8
    //   673: iconst_m1
    //   674: if_icmpeq +68 -> 742
    //   677: iload 6
    //   679: iload 8
    //   681: iadd
    //   682: istore 6
    //   684: aload 5
    //   686: aload_0
    //   687: iconst_0
    //   688: iload 8
    //   690: invokevirtual 308	java/io/ByteArrayOutputStream:write	([BII)V
    //   693: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   696: lstore 11
    //   698: lload 11
    //   700: lload 9
    //   702: lsub
    //   703: ldc2_w 314
    //   706: lcmp
    //   707: iflt +331 -> 1038
    //   710: aload 14
    //   712: iconst_4
    //   713: iconst_1
    //   714: iconst_1
    //   715: anewarray 4	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: iload 6
    //   722: bipush 100
    //   724: imul
    //   725: iload 7
    //   727: idiv
    //   728: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   731: aastore
    //   732: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   735: lload 11
    //   737: lstore 9
    //   739: goto +307 -> 1046
    //   742: aload 5
    //   744: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   747: aload 5
    //   749: invokevirtual 328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   752: astore 15
    //   754: new 55	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   761: getstatic 333	alof:bm	Ljava/lang/String;
    //   764: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_2
    //   768: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 337	arrr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   777: astore_2
    //   778: new 339	java/io/FileOutputStream
    //   781: dup
    //   782: new 341	java/io/File
    //   785: dup
    //   786: aload_2
    //   787: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   790: invokespecial 345	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   793: astore_1
    //   794: aload_1
    //   795: astore_0
    //   796: aload_1
    //   797: aload 15
    //   799: invokevirtual 348	java/io/FileOutputStream:write	([B)V
    //   802: iload 6
    //   804: iload 7
    //   806: if_icmplt +55 -> 861
    //   809: aload_1
    //   810: astore_0
    //   811: aload 14
    //   813: iconst_3
    //   814: iconst_1
    //   815: iconst_2
    //   816: anewarray 4	java/lang/Object
    //   819: dup
    //   820: iconst_0
    //   821: aload_2
    //   822: aastore
    //   823: dup
    //   824: iconst_1
    //   825: aload_3
    //   826: aastore
    //   827: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   830: aload 5
    //   832: ifnull +8 -> 840
    //   835: aload 5
    //   837: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   840: aload_1
    //   841: ifnull +7 -> 848
    //   844: aload_1
    //   845: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   848: aload 4
    //   850: ifnull -228 -> 622
    //   853: aload 4
    //   855: invokevirtual 350	java/io/InputStream:close	()V
    //   858: goto -236 -> 622
    //   861: aload_1
    //   862: astore_0
    //   863: aload 14
    //   865: iconst_1
    //   866: iconst_1
    //   867: iconst_2
    //   868: anewarray 4	java/lang/Object
    //   871: dup
    //   872: iconst_0
    //   873: ldc_w 351
    //   876: invokestatic 273	alud:a	(I)Ljava/lang/String;
    //   879: aastore
    //   880: dup
    //   881: iconst_1
    //   882: aload_3
    //   883: aastore
    //   884: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   887: goto -57 -> 830
    //   890: astore_2
    //   891: aload_1
    //   892: astore_0
    //   893: ldc_w 261
    //   896: iconst_1
    //   897: new 55	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   904: ldc_w 353
    //   907: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload_2
    //   911: invokevirtual 354	java/io/IOException:toString	()Ljava/lang/String;
    //   914: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: aload_1
    //   924: astore_0
    //   925: aload 14
    //   927: iconst_1
    //   928: iconst_1
    //   929: iconst_2
    //   930: anewarray 4	java/lang/Object
    //   933: dup
    //   934: iconst_0
    //   935: ldc_w 355
    //   938: invokestatic 273	alud:a	(I)Ljava/lang/String;
    //   941: aastore
    //   942: dup
    //   943: iconst_1
    //   944: aload_3
    //   945: aastore
    //   946: invokevirtual 277	bagr:notifyUI	(IZLjava/lang/Object;)V
    //   949: aload 5
    //   951: ifnull +8 -> 959
    //   954: aload 5
    //   956: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   959: aload_1
    //   960: ifnull +7 -> 967
    //   963: aload_1
    //   964: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   967: aload 4
    //   969: ifnull -347 -> 622
    //   972: aload 4
    //   974: invokevirtual 350	java/io/InputStream:close	()V
    //   977: goto -355 -> 622
    //   980: aload 5
    //   982: ifnull +8 -> 990
    //   985: aload 5
    //   987: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   990: aload_0
    //   991: ifnull +7 -> 998
    //   994: aload_0
    //   995: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   998: aload 4
    //   1000: ifnull +8 -> 1008
    //   1003: aload 4
    //   1005: invokevirtual 350	java/io/InputStream:close	()V
    //   1008: aload_1
    //   1009: athrow
    //   1010: astore_0
    //   1011: aconst_null
    //   1012: astore_1
    //   1013: goto -451 -> 562
    //   1016: astore_2
    //   1017: aload_0
    //   1018: astore_1
    //   1019: aload_2
    //   1020: astore_0
    //   1021: goto -459 -> 562
    //   1024: astore_1
    //   1025: goto -557 -> 468
    //   1028: astore_1
    //   1029: goto -49 -> 980
    //   1032: astore_2
    //   1033: aconst_null
    //   1034: astore_1
    //   1035: goto -144 -> 891
    //   1038: goto +8 -> 1046
    //   1041: aconst_null
    //   1042: astore_0
    //   1043: goto -675 -> 368
    //   1046: goto -383 -> 663
    //   1049: astore_1
    //   1050: aconst_null
    //   1051: astore_0
    //   1052: goto -72 -> 980
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1055	1	paramString1	String
    //   0	1055	2	paramString2	String
    //   0	1055	3	paramString3	String
    //   0	1055	4	paramString4	String
    //   0	1055	5	paramString5	String
    //   652	155	6	i	int
    //   582	225	7	j	int
    //   669	20	8	k	int
    //   587	151	9	l1	long
    //   696	40	11	l2	long
    //   65	571	13	localObject1	Object
    //   35	891	14	localbagr	bagr
    //   72	726	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   125	368	464	java/lang/Exception
    //   368	387	464	java/lang/Exception
    //   391	406	464	java/lang/Exception
    //   406	419	464	java/lang/Exception
    //   419	461	464	java/lang/Exception
    //   532	555	464	java/lang/Exception
    //   572	589	464	java/lang/Exception
    //   598	622	464	java/lang/Exception
    //   635	651	464	java/lang/Exception
    //   835	840	464	java/lang/Exception
    //   844	848	464	java/lang/Exception
    //   853	858	464	java/lang/Exception
    //   954	959	464	java/lang/Exception
    //   963	967	464	java/lang/Exception
    //   972	977	464	java/lang/Exception
    //   985	990	464	java/lang/Exception
    //   994	998	464	java/lang/Exception
    //   1003	1008	464	java/lang/Exception
    //   1008	1010	464	java/lang/Exception
    //   125	368	558	finally
    //   368	387	558	finally
    //   391	406	558	finally
    //   406	419	558	finally
    //   419	461	558	finally
    //   532	555	558	finally
    //   572	589	558	finally
    //   598	622	558	finally
    //   635	651	558	finally
    //   835	840	558	finally
    //   844	848	558	finally
    //   853	858	558	finally
    //   954	959	558	finally
    //   963	967	558	finally
    //   972	977	558	finally
    //   985	990	558	finally
    //   994	998	558	finally
    //   1003	1008	558	finally
    //   1008	1010	558	finally
    //   796	802	890	java/io/IOException
    //   811	830	890	java/io/IOException
    //   863	887	890	java/io/IOException
    //   58	125	1010	finally
    //   468	522	1016	finally
    //   58	125	1024	java/lang/Exception
    //   796	802	1028	finally
    //   811	830	1028	finally
    //   863	887	1028	finally
    //   893	923	1028	finally
    //   925	949	1028	finally
    //   654	660	1032	java/io/IOException
    //   663	671	1032	java/io/IOException
    //   684	698	1032	java/io/IOException
    //   710	735	1032	java/io/IOException
    //   742	794	1032	java/io/IOException
    //   654	660	1049	finally
    //   663	671	1049	finally
    //   684	698	1049	finally
    //   710	735	1049	finally
    //   742	794	1049	finally
  }
  
  /* Error */
  public static final String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +20 -> 27
    //   10: aload_0
    //   11: getfield 363	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   14: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +10 -> 27
    //   20: aload_1
    //   21: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +16 -> 40
    //   27: ldc 38
    //   29: iconst_1
    //   30: ldc_w 365
    //   33: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: areturn
    //   40: aload_0
    //   41: getfield 363	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   44: astore 5
    //   46: new 55	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   53: astore 9
    //   55: new 341	java/io/File
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 8
    //   66: aload 8
    //   68: ifnull +698 -> 766
    //   71: aload 8
    //   73: invokevirtual 368	java/io/File:exists	()Z
    //   76: ifeq +690 -> 766
    //   79: aload 5
    //   81: invokestatic 370	bahp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload 9
    //   87: ldc_w 372
    //   90: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 374
    //   100: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 376
    //   106: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 378
    //   116: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 8
    //   121: invokevirtual 381	java/io/File:getName	()Ljava/lang/String;
    //   124: ldc_w 383
    //   127: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 390
    //   136: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 392
    //   142: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 394
    //   148: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: astore 4
    //   153: aload_0
    //   154: getfield 397	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   157: ifnull +8 -> 165
    //   160: aload_0
    //   161: getfield 397	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   164: astore_3
    //   165: aload 4
    //   167: aload_3
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 399
    //   174: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 403	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:i	I
    //   181: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc_w 408
    //   187: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 411	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   194: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: invokestatic 416	bagk:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   202: ifeq +22 -> 224
    //   205: aload 9
    //   207: ldc_w 418
    //   210: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 420	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:a	Ljava/lang/String;
    //   217: invokestatic 425	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   220: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 9
    //   226: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 9
    //   231: aload 7
    //   233: astore 4
    //   235: new 69	bafw
    //   238: dup
    //   239: invokespecial 70	bafw:<init>	()V
    //   242: astore_3
    //   243: aload 7
    //   245: astore 4
    //   247: ldc 72
    //   249: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   252: astore 10
    //   254: aload 7
    //   256: astore 4
    //   258: aload 10
    //   260: aconst_null
    //   261: iconst_1
    //   262: anewarray 80	javax/net/ssl/TrustManager
    //   265: dup
    //   266: iconst_0
    //   267: aload_3
    //   268: aastore
    //   269: aconst_null
    //   270: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   273: aload 7
    //   275: astore 4
    //   277: new 86	bafy
    //   280: dup
    //   281: aload 10
    //   283: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   286: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   289: astore 10
    //   291: aload 7
    //   293: astore 4
    //   295: aload 10
    //   297: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   300: aload 7
    //   302: astore 4
    //   304: new 100	java/net/URL
    //   307: dup
    //   308: aload 9
    //   310: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   316: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   319: astore_3
    //   320: aload_3
    //   321: aload 10
    //   323: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   326: aload_3
    //   327: sipush 5000
    //   330: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   333: aload_3
    //   334: sipush 30000
    //   337: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   340: aload_3
    //   341: iconst_1
    //   342: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   345: aload_3
    //   346: iconst_1
    //   347: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   350: aload_3
    //   351: iconst_0
    //   352: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   355: aload_3
    //   356: ldc_w 430
    //   359: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   362: aload_3
    //   363: ldc 134
    //   365: ldc 136
    //   367: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_3
    //   371: ldc 142
    //   373: new 55	java/lang/StringBuilder
    //   376: dup
    //   377: ldc 144
    //   379: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: ldc 147
    //   384: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   390: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 147
    //   395: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   401: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 147
    //   406: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   412: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 147
    //   417: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 163
    //   422: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 147
    //   427: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc 165
    //   432: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 167
    //   437: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_3
    //   447: ldc 169
    //   449: ldc 171
    //   451: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_3
    //   455: ldc 173
    //   457: new 55	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   464: ldc 175
    //   466: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 177
    //   471: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: new 179	java/util/HashMap
    //   483: dup
    //   484: invokespecial 180	java/util/HashMap:<init>	()V
    //   487: astore 10
    //   489: aload 10
    //   491: ldc 134
    //   493: ldc 182
    //   495: invokeinterface 188 3 0
    //   500: pop
    //   501: aload 10
    //   503: ldc 190
    //   505: aload 9
    //   507: invokeinterface 188 3 0
    //   512: pop
    //   513: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   516: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   519: iconst_2
    //   520: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   523: checkcast 208	mqq/manager/TicketManager
    //   526: astore 4
    //   528: aload 4
    //   530: aload_1
    //   531: invokeinterface 212 2 0
    //   536: astore 11
    //   538: aload 9
    //   540: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne +819 -> 1362
    //   546: aload 4
    //   548: aload_1
    //   549: ldc 214
    //   551: invokeinterface 218 3 0
    //   556: astore 4
    //   558: aload 8
    //   560: ifnull +796 -> 1356
    //   563: aload 8
    //   565: invokevirtual 368	java/io/File:exists	()Z
    //   568: ifeq +788 -> 1356
    //   571: aload 5
    //   573: invokestatic 370	bahp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 5
    //   578: aload 4
    //   580: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifeq +194 -> 777
    //   586: ldc 38
    //   588: iconst_1
    //   589: ldc_w 432
    //   592: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   598: astore_1
    //   599: aload_1
    //   600: ifnull +20 -> 620
    //   603: aload 10
    //   605: ldc_w 282
    //   608: aload_1
    //   609: aload 9
    //   611: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   614: invokeinterface 188 3 0
    //   619: pop
    //   620: aload 10
    //   622: invokeinterface 234 1 0
    //   627: invokeinterface 240 1 0
    //   632: astore 4
    //   634: aload 4
    //   636: invokeinterface 245 1 0
    //   641: ifeq +246 -> 887
    //   644: aload 4
    //   646: invokeinterface 249 1 0
    //   651: checkcast 251	java/util/Map$Entry
    //   654: astore_1
    //   655: aload_3
    //   656: aload_1
    //   657: invokeinterface 254 1 0
    //   662: checkcast 256	java/lang/String
    //   665: aload_1
    //   666: invokeinterface 259 1 0
    //   671: checkcast 256	java/lang/String
    //   674: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: goto -43 -> 634
    //   680: astore 4
    //   682: aconst_null
    //   683: astore_0
    //   684: aload_3
    //   685: astore_1
    //   686: aload 4
    //   688: astore_3
    //   689: aload_1
    //   690: astore 4
    //   692: ldc_w 261
    //   695: iconst_1
    //   696: new 55	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 434
    //   706: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_3
    //   710: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   713: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: aload_0
    //   723: astore_3
    //   724: aload_1
    //   725: ifnull -687 -> 38
    //   728: aload_1
    //   729: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   732: aload_0
    //   733: areturn
    //   734: astore_0
    //   735: ldc 38
    //   737: iconst_1
    //   738: new 55	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 436
    //   748: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_0
    //   752: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   755: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aconst_null
    //   765: areturn
    //   766: ldc 38
    //   768: iconst_1
    //   769: ldc_w 438
    //   772: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aconst_null
    //   776: areturn
    //   777: new 55	java/lang/StringBuilder
    //   780: dup
    //   781: new 55	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   788: ldc_w 440
    //   791: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload 4
    //   796: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: ldc_w 442
    //   802: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload_1
    //   806: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 444
    //   812: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 11
    //   817: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   826: astore_1
    //   827: aload 5
    //   829: ifnull +29 -> 858
    //   832: aload_1
    //   833: new 55	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   840: ldc_w 446
    //   843: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload 5
    //   848: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 10
    //   860: ldc_w 282
    //   863: aload_1
    //   864: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokeinterface 188 3 0
    //   872: pop
    //   873: goto -253 -> 620
    //   876: astore_0
    //   877: aload_3
    //   878: ifnull +7 -> 885
    //   881: aload_3
    //   882: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   885: aload_0
    //   886: athrow
    //   887: aload_0
    //   888: getfield 411	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   891: iconst_1
    //   892: if_icmpeq +312 -> 1204
    //   895: new 448	java/io/DataOutputStream
    //   898: dup
    //   899: aload_3
    //   900: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   903: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   906: astore_1
    //   907: new 457	java/lang/StringBuffer
    //   910: dup
    //   911: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   914: astore_0
    //   915: aload_0
    //   916: ldc_w 460
    //   919: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   922: ldc_w 465
    //   925: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   928: ldc 177
    //   930: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   933: ldc_w 460
    //   936: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   939: pop
    //   940: aload_0
    //   941: ldc_w 467
    //   944: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   947: ldc_w 469
    //   950: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   953: ldc_w 471
    //   956: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   959: aload 8
    //   961: invokevirtual 381	java/io/File:getName	()Ljava/lang/String;
    //   964: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   967: ldc_w 473
    //   970: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   973: ldc_w 460
    //   976: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   979: pop
    //   980: aload_0
    //   981: new 55	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   988: ldc_w 475
    //   991: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: ldc_w 477
    //   997: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: ldc_w 479
    //   1003: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1012: pop
    //   1013: aload_1
    //   1014: aload_0
    //   1015: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1018: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1021: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1024: new 488	java/io/BufferedInputStream
    //   1027: dup
    //   1028: new 488	java/io/BufferedInputStream
    //   1031: dup
    //   1032: new 490	java/io/FileInputStream
    //   1035: dup
    //   1036: aload 8
    //   1038: invokespecial 491	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1041: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1044: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1047: astore_0
    //   1048: sipush 3072
    //   1051: newarray byte
    //   1053: astore 4
    //   1055: aload_0
    //   1056: aload 4
    //   1058: invokevirtual 495	java/io/BufferedInputStream:read	([B)I
    //   1061: istore_2
    //   1062: iload_2
    //   1063: iconst_m1
    //   1064: if_icmpeq +94 -> 1158
    //   1067: aload_1
    //   1068: aload 4
    //   1070: iconst_0
    //   1071: iload_2
    //   1072: invokevirtual 496	java/io/OutputStream:write	([BII)V
    //   1075: goto -20 -> 1055
    //   1078: astore 4
    //   1080: ldc 38
    //   1082: iconst_1
    //   1083: new 55	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1090: ldc_w 498
    //   1093: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: aload 8
    //   1098: invokevirtual 501	java/io/File:length	()J
    //   1101: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1104: ldc_w 506
    //   1107: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: aload 8
    //   1112: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1115: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: aload_1
    //   1125: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1128: aload_1
    //   1129: invokevirtual 513	java/io/OutputStream:close	()V
    //   1132: aload_3
    //   1133: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1136: aload 7
    //   1138: astore 4
    //   1140: aload_0
    //   1141: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1144: iconst_0
    //   1145: ifeq +11 -> 1156
    //   1148: new 516	java/lang/NullPointerException
    //   1151: dup
    //   1152: invokespecial 517	java/lang/NullPointerException:<init>	()V
    //   1155: athrow
    //   1156: aconst_null
    //   1157: areturn
    //   1158: aload_0
    //   1159: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1162: aload_1
    //   1163: new 55	java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1170: ldc_w 519
    //   1173: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: ldc 177
    //   1178: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: ldc_w 521
    //   1184: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1193: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1196: aload_1
    //   1197: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1200: aload_1
    //   1201: invokevirtual 513	java/io/OutputStream:close	()V
    //   1204: new 457	java/lang/StringBuffer
    //   1207: dup
    //   1208: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   1211: astore_0
    //   1212: aload_3
    //   1213: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1216: istore_2
    //   1217: iload_2
    //   1218: sipush 200
    //   1221: if_icmpeq +35 -> 1256
    //   1224: ldc 38
    //   1226: iconst_1
    //   1227: new 55	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1234: ldc_w 526
    //   1237: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: iload_2
    //   1241: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 528
    //   1247: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: new 532	java/io/BufferedReader
    //   1259: dup
    //   1260: new 534	java/io/InputStreamReader
    //   1263: dup
    //   1264: aload_3
    //   1265: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1268: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1271: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1274: astore_1
    //   1275: aload_1
    //   1276: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1279: astore 4
    //   1281: aload 4
    //   1283: ifnull +26 -> 1309
    //   1286: aload_0
    //   1287: aload 4
    //   1289: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1292: ldc_w 543
    //   1295: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1298: pop
    //   1299: goto -24 -> 1275
    //   1302: astore_1
    //   1303: aload_0
    //   1304: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1307: aload_1
    //   1308: athrow
    //   1309: aload_0
    //   1310: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1313: astore_0
    //   1314: aload_1
    //   1315: invokevirtual 544	java/io/BufferedReader:close	()V
    //   1318: aload_3
    //   1319: ifnull +35 -> 1354
    //   1322: aload_3
    //   1323: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1326: aload_0
    //   1327: areturn
    //   1328: astore_0
    //   1329: aload 4
    //   1331: astore_3
    //   1332: goto -455 -> 877
    //   1335: astore_3
    //   1336: aconst_null
    //   1337: astore_0
    //   1338: aload 6
    //   1340: astore_1
    //   1341: goto -652 -> 689
    //   1344: astore 4
    //   1346: aload_3
    //   1347: astore_1
    //   1348: aload 4
    //   1350: astore_3
    //   1351: goto -662 -> 689
    //   1354: aload_0
    //   1355: areturn
    //   1356: aconst_null
    //   1357: astore 5
    //   1359: goto -781 -> 578
    //   1362: aconst_null
    //   1363: astore 4
    //   1365: goto -807 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1368	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1368	1	paramString	String
    //   1061	180	2	i	int
    //   37	1295	3	localObject1	Object
    //   1335	12	3	localException1	java.lang.Exception
    //   1350	1	3	localObject2	Object
    //   151	494	4	localObject3	Object
    //   680	7	4	localException2	java.lang.Exception
    //   690	379	4	localObject4	Object
    //   1078	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1138	192	4	localObject5	Object
    //   1344	5	4	localException3	java.lang.Exception
    //   1363	1	4	localObject6	Object
    //   44	1314	5	str1	String
    //   4	1335	6	localObject7	Object
    //   1	1136	7	localObject8	Object
    //   64	1047	8	localFile	java.io.File
    //   53	557	9	localObject9	Object
    //   252	607	10	localObject10	Object
    //   536	280	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   320	558	680	java/lang/Exception
    //   563	578	680	java/lang/Exception
    //   578	599	680	java/lang/Exception
    //   603	620	680	java/lang/Exception
    //   620	634	680	java/lang/Exception
    //   634	677	680	java/lang/Exception
    //   777	827	680	java/lang/Exception
    //   832	858	680	java/lang/Exception
    //   858	873	680	java/lang/Exception
    //   887	1055	680	java/lang/Exception
    //   1158	1204	680	java/lang/Exception
    //   1204	1217	680	java/lang/Exception
    //   1224	1256	680	java/lang/Exception
    //   1256	1275	680	java/lang/Exception
    //   1275	1281	680	java/lang/Exception
    //   1286	1299	680	java/lang/Exception
    //   1303	1309	680	java/lang/Exception
    //   1309	1314	680	java/lang/Exception
    //   79	153	734	java/lang/Exception
    //   153	165	734	java/lang/Exception
    //   165	224	734	java/lang/Exception
    //   320	558	876	finally
    //   563	578	876	finally
    //   578	599	876	finally
    //   603	620	876	finally
    //   620	634	876	finally
    //   634	677	876	finally
    //   777	827	876	finally
    //   832	858	876	finally
    //   858	873	876	finally
    //   887	1055	876	finally
    //   1158	1204	876	finally
    //   1204	1217	876	finally
    //   1224	1256	876	finally
    //   1256	1275	876	finally
    //   1275	1281	876	finally
    //   1286	1299	876	finally
    //   1303	1309	876	finally
    //   1309	1314	876	finally
    //   1314	1318	876	finally
    //   1055	1062	1078	java/lang/OutOfMemoryError
    //   1067	1075	1078	java/lang/OutOfMemoryError
    //   1055	1062	1302	finally
    //   1067	1075	1302	finally
    //   1080	1136	1302	finally
    //   235	243	1328	finally
    //   247	254	1328	finally
    //   258	273	1328	finally
    //   277	291	1328	finally
    //   295	300	1328	finally
    //   304	320	1328	finally
    //   692	722	1328	finally
    //   1140	1144	1328	finally
    //   235	243	1335	java/lang/Exception
    //   247	254	1335	java/lang/Exception
    //   258	273	1335	java/lang/Exception
    //   277	291	1335	java/lang/Exception
    //   295	300	1335	java/lang/Exception
    //   304	320	1335	java/lang/Exception
    //   1140	1144	1335	java/lang/Exception
    //   1314	1318	1344	java/lang/Exception
  }
  
  /* Error */
  public static final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 341	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 368	java/io/File:exists	()Z
    //   18: ifeq +116 -> 134
    //   21: ldc_w 546
    //   24: invokestatic 551	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 5
    //   29: new 490	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore 7
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: aload 7
    //   56: invokevirtual 553	java/io/FileInputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: iconst_m1
    //   62: if_icmpeq +75 -> 137
    //   65: aload 4
    //   67: astore_0
    //   68: aload 5
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_1
    //   74: invokevirtual 556	java/security/MessageDigest:update	([BII)V
    //   77: goto -28 -> 49
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: ldc_w 558
    //   88: iconst_1
    //   89: new 55	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 560
    //   99: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: invokevirtual 561	java/io/FileInputStream:close	()V
    //   130: aload 6
    //   132: astore 5
    //   134: aload 5
    //   136: areturn
    //   137: aload 4
    //   139: astore_0
    //   140: aload 4
    //   142: invokevirtual 561	java/io/FileInputStream:close	()V
    //   145: aload 4
    //   147: astore_0
    //   148: new 55	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: invokevirtual 564	java/security/MessageDigest:digest	()[B
    //   165: astore 8
    //   167: aload 4
    //   169: astore_0
    //   170: aload 8
    //   172: arraylength
    //   173: istore_2
    //   174: iconst_0
    //   175: istore_1
    //   176: goto +195 -> 371
    //   179: aload 4
    //   181: astore_0
    //   182: aload 7
    //   184: aload 5
    //   186: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_0
    //   193: aload 7
    //   195: iload_3
    //   196: invokestatic 567	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   199: invokevirtual 570	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto +161 -> 371
    //   213: aload 4
    //   215: astore_0
    //   216: aload 7
    //   218: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: astore_0
    //   226: aload_0
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -97 -> 134
    //   234: aload 4
    //   236: invokevirtual 561	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore 4
    //   243: ldc_w 558
    //   246: iconst_1
    //   247: new 55	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 572
    //   257: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 4
    //   262: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   265: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: ldc_w 558
    //   280: iconst_1
    //   281: new 55	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 572
    //   291: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 561	java/io/FileInputStream:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore_0
    //   325: ldc_w 558
    //   328: iconst_1
    //   329: new 55	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 572
    //   339: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -34 -> 321
    //   358: astore 4
    //   360: goto -47 -> 313
    //   363: astore 5
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -286 -> 82
    //   371: iload_1
    //   372: iload_2
    //   373: if_icmpge -160 -> 213
    //   376: aload 8
    //   378: iload_1
    //   379: baload
    //   380: sipush 255
    //   383: iand
    //   384: istore_3
    //   385: iload_3
    //   386: bipush 16
    //   388: if_icmpge +11 -> 399
    //   391: ldc_w 574
    //   394: astore 5
    //   396: goto -217 -> 179
    //   399: ldc_w 576
    //   402: astore 5
    //   404: goto -225 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramString	String
    //   59	320	1	i	int
    //   173	201	2	j	int
    //   195	194	3	k	int
    //   37	198	4	localFileInputStream	java.io.FileInputStream
    //   241	20	4	localException1	java.lang.Exception
    //   309	13	4	localObject1	Object
    //   358	1	4	localObject2	Object
    //   366	1	4	localObject3	Object
    //   5	64	5	localObject4	Object
    //   80	23	5	localException2	java.lang.Exception
    //   118	110	5	localObject5	Object
    //   363	1	5	localException3	java.lang.Exception
    //   394	9	5	str	String
    //   1	130	6	localObject6	Object
    //   47	170	7	localObject7	Object
    //   165	212	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	49	80	java/lang/Exception
    //   52	60	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   140	145	80	java/lang/Exception
    //   148	157	80	java/lang/Exception
    //   160	167	80	java/lang/Exception
    //   170	174	80	java/lang/Exception
    //   182	190	80	java/lang/Exception
    //   193	206	80	java/lang/Exception
    //   216	223	80	java/lang/Exception
    //   234	239	241	java/lang/Exception
    //   125	130	276	java/lang/Exception
    //   21	39	309	finally
    //   317	321	324	java/lang/Exception
    //   42	49	358	finally
    //   52	60	358	finally
    //   68	77	358	finally
    //   85	116	358	finally
    //   140	145	358	finally
    //   148	157	358	finally
    //   160	167	358	finally
    //   170	174	358	finally
    //   182	190	358	finally
    //   193	206	358	finally
    //   216	223	358	finally
    //   21	39	363	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      Object localObject = UUID.randomUUID().toString().replaceAll("-", "");
      paramString1 = new StringBuilder("https://docs.qq.com/cgi-go/discuss/get_unread_reddot").append('?').append("globalPadId=").append(paramString1).append("&type=0").append("&xsrf=").append((String)localObject);
      localObject = new StringBuilder().append("TOK=").append((String)localObject);
      paramString1 = a(paramString2, paramString1.toString(), "docs.qq.com", ((StringBuilder)localObject).toString());
      if (paramString1 != null)
      {
        paramString2 = new JSONObject(paramString1);
        if (paramString2.optInt("ret", -1) == 0) {
          break label169;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHttpUtils", 2, "setPolicy4AllByHttp failed result" + paramString1);
        }
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHttpUtils", 2, paramString1, new Object[0]);
        }
      }
    }
    return "";
    label169:
    paramString1 = paramString2.getString("data");
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, null);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 5
    //   8: astore 6
    //   10: new 69	bafw
    //   13: dup
    //   14: invokespecial 70	bafw:<init>	()V
    //   17: astore 8
    //   19: aload 5
    //   21: astore 6
    //   23: ldc 72
    //   25: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   28: astore 9
    //   30: aload 5
    //   32: astore 6
    //   34: aload 9
    //   36: aconst_null
    //   37: iconst_1
    //   38: anewarray 80	javax/net/ssl/TrustManager
    //   41: dup
    //   42: iconst_0
    //   43: aload 8
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   50: aload 5
    //   52: astore 6
    //   54: new 86	bafy
    //   57: dup
    //   58: aload 9
    //   60: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   63: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   66: astore 8
    //   68: aload 5
    //   70: astore 6
    //   72: aload 8
    //   74: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   77: aload 5
    //   79: astore 6
    //   81: new 100	java/net/URL
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   95: astore 5
    //   97: aload 5
    //   99: aload 8
    //   101: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   104: aload 5
    //   106: sipush 5000
    //   109: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   112: aload 5
    //   114: sipush 15000
    //   117: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   120: aload 5
    //   122: iconst_1
    //   123: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   126: aload 5
    //   128: iconst_0
    //   129: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   132: aload 5
    //   134: ldc 129
    //   136: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   139: aload 5
    //   141: ldc 134
    //   143: ldc 136
    //   145: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 5
    //   150: ldc 142
    //   152: new 55	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 144
    //   158: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: ldc 147
    //   163: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   169: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 147
    //   174: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   180: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 147
    //   185: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   191: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 147
    //   196: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 163
    //   201: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 147
    //   206: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 165
    //   211: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 167
    //   216: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 5
    //   227: ldc 173
    //   229: ldc_w 631
    //   232: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 5
    //   237: ldc 169
    //   239: ldc 171
    //   241: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 5
    //   246: ldc_w 633
    //   249: ldc_w 383
    //   252: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: new 179	java/util/HashMap
    //   258: dup
    //   259: invokespecial 180	java/util/HashMap:<init>	()V
    //   262: astore 6
    //   264: aload 6
    //   266: ldc 134
    //   268: ldc 182
    //   270: invokeinterface 188 3 0
    //   275: pop
    //   276: aload 6
    //   278: ldc 190
    //   280: aload_1
    //   281: invokeinterface 188 3 0
    //   286: pop
    //   287: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   290: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   293: iconst_2
    //   294: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   297: checkcast 208	mqq/manager/TicketManager
    //   300: astore 8
    //   302: aload 8
    //   304: aload_0
    //   305: invokeinterface 212 2 0
    //   310: astore 7
    //   312: aload_1
    //   313: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifne +464 -> 780
    //   319: aload 8
    //   321: aload_0
    //   322: aload_2
    //   323: invokeinterface 218 3 0
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifeq +143 -> 476
    //   336: ldc 38
    //   338: iconst_1
    //   339: ldc_w 635
    //   342: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   348: astore_0
    //   349: aload_0
    //   350: ifnull +19 -> 369
    //   353: aload 6
    //   355: ldc_w 282
    //   358: aload_0
    //   359: aload_1
    //   360: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   363: invokeinterface 188 3 0
    //   368: pop
    //   369: aload 6
    //   371: invokeinterface 234 1 0
    //   376: invokeinterface 240 1 0
    //   381: astore_0
    //   382: aload_0
    //   383: invokeinterface 245 1 0
    //   388: ifeq +210 -> 598
    //   391: aload_0
    //   392: invokeinterface 249 1 0
    //   397: checkcast 251	java/util/Map$Entry
    //   400: astore_1
    //   401: aload 5
    //   403: aload_1
    //   404: invokeinterface 254 1 0
    //   409: checkcast 256	java/lang/String
    //   412: aload_1
    //   413: invokeinterface 259 1 0
    //   418: checkcast 256	java/lang/String
    //   421: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -42 -> 382
    //   427: astore_2
    //   428: aload 5
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_0
    //   433: ldc 38
    //   435: iconst_1
    //   436: new 55	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 637
    //   446: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_2
    //   450: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: astore_2
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   472: aload_0
    //   473: astore_2
    //   474: aload_2
    //   475: areturn
    //   476: new 55	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 440
    //   486: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_2
    //   490: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 442
    //   496: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 444
    //   506: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 7
    //   511: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: astore_0
    //   515: aload_3
    //   516: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   519: ifne +14 -> 533
    //   522: aload_0
    //   523: bipush 59
    //   525: invokevirtual 595	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   528: aload_3
    //   529: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 6
    //   535: ldc_w 282
    //   538: aload_0
    //   539: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokeinterface 188 3 0
    //   547: pop
    //   548: goto -179 -> 369
    //   551: astore_2
    //   552: aconst_null
    //   553: astore_0
    //   554: aload 5
    //   556: astore_1
    //   557: aload_1
    //   558: astore 6
    //   560: ldc 38
    //   562: iconst_1
    //   563: new 55	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 639
    //   573: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_2
    //   577: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_0
    //   587: astore_2
    //   588: aload_1
    //   589: ifnull -115 -> 474
    //   592: aload_1
    //   593: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   596: aload_0
    //   597: areturn
    //   598: new 457	java/lang/StringBuffer
    //   601: dup
    //   602: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   605: astore_0
    //   606: aload 5
    //   608: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   611: istore 4
    //   613: iload 4
    //   615: sipush 200
    //   618: if_icmpeq +36 -> 654
    //   621: ldc 38
    //   623: iconst_1
    //   624: new 55	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 641
    //   634: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 4
    //   639: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: ldc_w 528
    //   645: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: new 532	java/io/BufferedReader
    //   657: dup
    //   658: new 534	java/io/InputStreamReader
    //   661: dup
    //   662: aload 5
    //   664: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   667: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   670: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   673: astore_1
    //   674: aload_1
    //   675: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   678: astore_2
    //   679: aload_2
    //   680: ifnull +35 -> 715
    //   683: aload_0
    //   684: aload_2
    //   685: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   688: ldc_w 543
    //   691: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   694: pop
    //   695: goto -21 -> 674
    //   698: astore_0
    //   699: aload 5
    //   701: astore 6
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   713: aload_0
    //   714: athrow
    //   715: aload_0
    //   716: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   719: astore_0
    //   720: aload_1
    //   721: invokevirtual 544	java/io/BufferedReader:close	()V
    //   724: aload 5
    //   726: ifnull +52 -> 778
    //   729: aload 5
    //   731: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   734: aload_0
    //   735: areturn
    //   736: astore_0
    //   737: goto -34 -> 703
    //   740: astore_0
    //   741: aload_1
    //   742: astore 6
    //   744: goto -41 -> 703
    //   747: astore_2
    //   748: aconst_null
    //   749: astore_0
    //   750: aload 7
    //   752: astore_1
    //   753: goto -196 -> 557
    //   756: astore_2
    //   757: aload 5
    //   759: astore_1
    //   760: goto -203 -> 557
    //   763: astore_2
    //   764: aconst_null
    //   765: astore_1
    //   766: aconst_null
    //   767: astore_0
    //   768: goto -335 -> 433
    //   771: astore_2
    //   772: aload 5
    //   774: astore_1
    //   775: goto -342 -> 433
    //   778: aload_0
    //   779: areturn
    //   780: aconst_null
    //   781: astore_2
    //   782: goto -453 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	paramString1	String
    //   0	785	1	paramString2	String
    //   0	785	2	paramString3	String
    //   0	785	3	paramString4	String
    //   611	27	4	i	int
    //   1	772	5	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   8	735	6	localObject1	Object
    //   4	747	7	str	String
    //   17	303	8	localObject2	Object
    //   28	31	9	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   97	329	427	java/lang/Exception
    //   329	349	427	java/lang/Exception
    //   353	369	427	java/lang/Exception
    //   369	382	427	java/lang/Exception
    //   382	424	427	java/lang/Exception
    //   476	533	427	java/lang/Exception
    //   533	548	427	java/lang/Exception
    //   598	613	427	java/lang/Exception
    //   621	654	427	java/lang/Exception
    //   654	674	427	java/lang/Exception
    //   674	679	427	java/lang/Exception
    //   683	695	427	java/lang/Exception
    //   715	720	427	java/lang/Exception
    //   97	329	551	java/lang/OutOfMemoryError
    //   329	349	551	java/lang/OutOfMemoryError
    //   353	369	551	java/lang/OutOfMemoryError
    //   369	382	551	java/lang/OutOfMemoryError
    //   382	424	551	java/lang/OutOfMemoryError
    //   476	533	551	java/lang/OutOfMemoryError
    //   533	548	551	java/lang/OutOfMemoryError
    //   598	613	551	java/lang/OutOfMemoryError
    //   621	654	551	java/lang/OutOfMemoryError
    //   654	674	551	java/lang/OutOfMemoryError
    //   674	679	551	java/lang/OutOfMemoryError
    //   683	695	551	java/lang/OutOfMemoryError
    //   715	720	551	java/lang/OutOfMemoryError
    //   97	329	698	finally
    //   329	349	698	finally
    //   353	369	698	finally
    //   369	382	698	finally
    //   382	424	698	finally
    //   476	533	698	finally
    //   533	548	698	finally
    //   598	613	698	finally
    //   621	654	698	finally
    //   654	674	698	finally
    //   674	679	698	finally
    //   683	695	698	finally
    //   715	720	698	finally
    //   720	724	698	finally
    //   10	19	736	finally
    //   23	30	736	finally
    //   34	50	736	finally
    //   54	68	736	finally
    //   72	77	736	finally
    //   81	97	736	finally
    //   560	586	736	finally
    //   433	462	740	finally
    //   10	19	747	java/lang/OutOfMemoryError
    //   23	30	747	java/lang/OutOfMemoryError
    //   34	50	747	java/lang/OutOfMemoryError
    //   54	68	747	java/lang/OutOfMemoryError
    //   72	77	747	java/lang/OutOfMemoryError
    //   81	97	747	java/lang/OutOfMemoryError
    //   720	724	756	java/lang/OutOfMemoryError
    //   10	19	763	java/lang/Exception
    //   23	30	763	java/lang/Exception
    //   34	50	763	java/lang/Exception
    //   54	68	763	java/lang/Exception
    //   72	77	763	java/lang/Exception
    //   81	97	763	java/lang/Exception
    //   720	724	771	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, java.util.Map<String, String> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_2
    //   7: invokevirtual 643	java/lang/String:toString	()Ljava/lang/String;
    //   10: astore 11
    //   12: aload 10
    //   14: astore 8
    //   16: new 69	bafw
    //   19: dup
    //   20: invokespecial 70	bafw:<init>	()V
    //   23: astore_2
    //   24: aload 10
    //   26: astore 8
    //   28: ldc 72
    //   30: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   33: astore 12
    //   35: aload 10
    //   37: astore 8
    //   39: aload 12
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 80	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: aload 10
    //   56: astore 8
    //   58: new 86	bafy
    //   61: dup
    //   62: aload 12
    //   64: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: astore 12
    //   72: aload 10
    //   74: astore 8
    //   76: aload 12
    //   78: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 10
    //   83: astore 8
    //   85: new 100	java/net/URL
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   100: astore_2
    //   101: aload_2
    //   102: aload 12
    //   104: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload_2
    //   108: sipush 5000
    //   111: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   114: aload_2
    //   115: sipush 30000
    //   118: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   126: aload_2
    //   127: iconst_1
    //   128: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   131: aload_2
    //   132: iconst_0
    //   133: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   136: aload_2
    //   137: ldc_w 430
    //   140: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: ldc 134
    //   146: ldc 136
    //   148: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ldc 142
    //   154: new 55	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 144
    //   160: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: ldc 147
    //   165: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   171: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 147
    //   176: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   182: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 147
    //   187: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   193: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 147
    //   198: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 163
    //   203: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 147
    //   208: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 165
    //   213: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 167
    //   218: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: iload 6
    //   229: ifeq +147 -> 376
    //   232: aload_2
    //   233: ldc 173
    //   235: ldc_w 631
    //   238: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: ldc 169
    //   244: ldc 171
    //   246: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w 633
    //   253: ldc_w 383
    //   256: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 5
    //   261: ifnull +138 -> 399
    //   264: aload 5
    //   266: invokeinterface 234 1 0
    //   271: invokeinterface 240 1 0
    //   276: astore 5
    //   278: aload 5
    //   280: invokeinterface 245 1 0
    //   285: ifeq +114 -> 399
    //   288: aload 5
    //   290: invokeinterface 249 1 0
    //   295: checkcast 251	java/util/Map$Entry
    //   298: astore 8
    //   300: aload_2
    //   301: aload 8
    //   303: invokeinterface 254 1 0
    //   308: checkcast 256	java/lang/String
    //   311: aload 8
    //   313: invokeinterface 259 1 0
    //   318: checkcast 256	java/lang/String
    //   321: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: goto -46 -> 278
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_2
    //   331: astore_0
    //   332: aload_3
    //   333: astore_2
    //   334: aload_0
    //   335: astore 8
    //   337: ldc 38
    //   339: iconst_1
    //   340: new 55	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 637
    //   350: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_2
    //   354: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   357: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: ifnull +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   374: aload_1
    //   375: areturn
    //   376: aload_2
    //   377: ldc 173
    //   379: ldc_w 645
    //   382: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: goto -144 -> 241
    //   388: astore_0
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   397: aload_0
    //   398: athrow
    //   399: new 179	java/util/HashMap
    //   402: dup
    //   403: invokespecial 180	java/util/HashMap:<init>	()V
    //   406: astore 5
    //   408: aload 5
    //   410: ldc 134
    //   412: ldc 182
    //   414: invokeinterface 188 3 0
    //   419: pop
    //   420: aload 5
    //   422: ldc 190
    //   424: aload 11
    //   426: invokeinterface 188 3 0
    //   431: pop
    //   432: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   435: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   438: iconst_2
    //   439: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   442: checkcast 208	mqq/manager/TicketManager
    //   445: astore 9
    //   447: aload 9
    //   449: aload_1
    //   450: invokeinterface 212 2 0
    //   455: astore 8
    //   457: aload 11
    //   459: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +377 -> 839
    //   465: aload 9
    //   467: aload_1
    //   468: aload_3
    //   469: invokeinterface 218 3 0
    //   474: astore_3
    //   475: aload_3
    //   476: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +94 -> 573
    //   482: ldc 38
    //   484: iconst_1
    //   485: ldc_w 635
    //   488: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +20 -> 516
    //   499: aload 5
    //   501: ldc_w 282
    //   504: aload_1
    //   505: aload 11
    //   507: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokeinterface 188 3 0
    //   515: pop
    //   516: aload 5
    //   518: invokeinterface 234 1 0
    //   523: invokeinterface 240 1 0
    //   528: astore_1
    //   529: aload_1
    //   530: invokeinterface 245 1 0
    //   535: ifeq +115 -> 650
    //   538: aload_1
    //   539: invokeinterface 249 1 0
    //   544: checkcast 251	java/util/Map$Entry
    //   547: astore_3
    //   548: aload_2
    //   549: aload_3
    //   550: invokeinterface 254 1 0
    //   555: checkcast 256	java/lang/String
    //   558: aload_3
    //   559: invokeinterface 259 1 0
    //   564: checkcast 256	java/lang/String
    //   567: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: goto -41 -> 529
    //   573: new 55	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 440
    //   583: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_3
    //   587: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 442
    //   593: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 444
    //   603: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 8
    //   608: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: astore_1
    //   612: aload 4
    //   614: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   617: ifne +15 -> 632
    //   620: aload_1
    //   621: bipush 59
    //   623: invokevirtual 595	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   626: aload 4
    //   628: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 5
    //   634: ldc_w 282
    //   637: aload_1
    //   638: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokeinterface 188 3 0
    //   646: pop
    //   647: goto -131 -> 516
    //   650: new 448	java/io/DataOutputStream
    //   653: dup
    //   654: aload_2
    //   655: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   658: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   661: astore_1
    //   662: aload_1
    //   663: aload_0
    //   664: ldc_w 383
    //   667: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   670: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   673: aload_1
    //   674: invokevirtual 512	java/io/OutputStream:flush	()V
    //   677: aload_1
    //   678: invokevirtual 513	java/io/OutputStream:close	()V
    //   681: new 457	java/lang/StringBuffer
    //   684: dup
    //   685: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   688: astore_1
    //   689: aload_2
    //   690: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   693: istore 7
    //   695: iload 7
    //   697: sipush 200
    //   700: if_icmpeq +36 -> 736
    //   703: ldc 38
    //   705: iconst_1
    //   706: new 55	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 641
    //   716: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload 7
    //   721: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: ldc_w 528
    //   727: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: new 532	java/io/BufferedReader
    //   739: dup
    //   740: new 534	java/io/InputStreamReader
    //   743: dup
    //   744: aload_2
    //   745: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   748: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   751: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   754: astore_0
    //   755: aload_0
    //   756: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   759: astore_3
    //   760: aload_3
    //   761: ifnull +33 -> 794
    //   764: aload_1
    //   765: aload_3
    //   766: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   769: ldc_w 543
    //   772: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   775: pop
    //   776: goto -21 -> 755
    //   779: astore_0
    //   780: aload_1
    //   781: invokevirtual 513	java/io/OutputStream:close	()V
    //   784: aload_2
    //   785: ifnull +7 -> 792
    //   788: aload_2
    //   789: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   792: aconst_null
    //   793: areturn
    //   794: aload_1
    //   795: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   798: astore_1
    //   799: aload_0
    //   800: invokevirtual 544	java/io/BufferedReader:close	()V
    //   803: aload_2
    //   804: ifnull +33 -> 837
    //   807: aload_2
    //   808: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   811: aload_1
    //   812: areturn
    //   813: astore_0
    //   814: aload 8
    //   816: astore_2
    //   817: goto -428 -> 389
    //   820: astore_2
    //   821: aconst_null
    //   822: astore_1
    //   823: aload 9
    //   825: astore_0
    //   826: goto -492 -> 334
    //   829: astore_3
    //   830: aload_2
    //   831: astore_0
    //   832: aload_3
    //   833: astore_2
    //   834: goto -500 -> 334
    //   837: aload_1
    //   838: areturn
    //   839: aconst_null
    //   840: astore_3
    //   841: goto -366 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	paramString1	String
    //   0	844	1	paramString2	String
    //   0	844	2	paramString3	String
    //   0	844	3	paramString4	String
    //   0	844	4	paramString5	String
    //   0	844	5	paramMap	java.util.Map<String, String>
    //   0	844	6	paramBoolean	boolean
    //   693	27	7	i	int
    //   14	801	8	localObject1	Object
    //   4	820	9	localTicketManager	mqq.manager.TicketManager
    //   1	81	10	localObject2	Object
    //   10	496	11	str	String
    //   33	70	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	227	327	java/lang/Exception
    //   232	241	327	java/lang/Exception
    //   241	259	327	java/lang/Exception
    //   264	278	327	java/lang/Exception
    //   278	324	327	java/lang/Exception
    //   376	385	327	java/lang/Exception
    //   399	475	327	java/lang/Exception
    //   475	495	327	java/lang/Exception
    //   499	516	327	java/lang/Exception
    //   516	529	327	java/lang/Exception
    //   529	570	327	java/lang/Exception
    //   573	632	327	java/lang/Exception
    //   632	647	327	java/lang/Exception
    //   650	662	327	java/lang/Exception
    //   681	695	327	java/lang/Exception
    //   703	736	327	java/lang/Exception
    //   736	755	327	java/lang/Exception
    //   755	760	327	java/lang/Exception
    //   764	776	327	java/lang/Exception
    //   780	784	327	java/lang/Exception
    //   794	799	327	java/lang/Exception
    //   101	227	388	finally
    //   232	241	388	finally
    //   241	259	388	finally
    //   264	278	388	finally
    //   278	324	388	finally
    //   376	385	388	finally
    //   399	475	388	finally
    //   475	495	388	finally
    //   499	516	388	finally
    //   516	529	388	finally
    //   529	570	388	finally
    //   573	632	388	finally
    //   632	647	388	finally
    //   650	662	388	finally
    //   662	681	388	finally
    //   681	695	388	finally
    //   703	736	388	finally
    //   736	755	388	finally
    //   755	760	388	finally
    //   764	776	388	finally
    //   780	784	388	finally
    //   794	799	388	finally
    //   799	803	388	finally
    //   662	681	779	java/lang/Exception
    //   16	24	813	finally
    //   28	35	813	finally
    //   39	54	813	finally
    //   58	72	813	finally
    //   76	81	813	finally
    //   85	101	813	finally
    //   337	366	813	finally
    //   16	24	820	java/lang/Exception
    //   28	35	820	java/lang/Exception
    //   39	54	820	java/lang/Exception
    //   58	72	820	java/lang/Exception
    //   76	81	820	java/lang/Exception
    //   85	101	820	java/lang/Exception
    //   799	803	829	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +16 -> 30
    //   17: ldc 38
    //   19: iconst_1
    //   20: ldc_w 653
    //   23: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: new 55	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 372
    //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 658	bagj:o	Ljava/lang/String;
    //   54: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: getfield 660	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +16 -> 83
    //   70: aload 4
    //   72: ldc_w 662
    //   75: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 7
    //   90: aload 6
    //   92: astore 4
    //   94: new 69	bafw
    //   97: dup
    //   98: invokespecial 70	bafw:<init>	()V
    //   101: astore_1
    //   102: aload 6
    //   104: astore 4
    //   106: ldc 72
    //   108: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   111: astore 8
    //   113: aload 6
    //   115: astore 4
    //   117: aload 8
    //   119: aconst_null
    //   120: iconst_1
    //   121: anewarray 80	javax/net/ssl/TrustManager
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: aconst_null
    //   129: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   132: aload 6
    //   134: astore 4
    //   136: new 86	bafy
    //   139: dup
    //   140: aload 8
    //   142: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: astore 8
    //   150: aload 6
    //   152: astore 4
    //   154: aload 8
    //   156: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   159: aload 6
    //   161: astore 4
    //   163: new 100	java/net/URL
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   172: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   178: astore_1
    //   179: aload_1
    //   180: aload 8
    //   182: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   185: aload_1
    //   186: sipush 5000
    //   189: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   192: aload_1
    //   193: sipush 30000
    //   196: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   199: aload_1
    //   200: iconst_1
    //   201: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   204: aload_1
    //   205: iconst_1
    //   206: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   209: aload_1
    //   210: iconst_0
    //   211: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   214: aload_1
    //   215: ldc_w 430
    //   218: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: ldc 134
    //   224: ldc 136
    //   226: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 142
    //   232: new 55	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 144
    //   238: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: ldc 147
    //   243: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   249: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 147
    //   254: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   260: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 147
    //   265: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   271: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 147
    //   276: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 163
    //   281: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 147
    //   286: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 165
    //   291: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 167
    //   296: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ldc 173
    //   308: ldc_w 631
    //   311: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_1
    //   315: ldc 169
    //   317: ldc 171
    //   319: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: ldc_w 633
    //   326: ldc_w 383
    //   329: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: new 179	java/util/HashMap
    //   335: dup
    //   336: invokespecial 180	java/util/HashMap:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc 134
    //   345: ldc 182
    //   347: invokeinterface 188 3 0
    //   352: pop
    //   353: aload 5
    //   355: ldc 190
    //   357: aload 7
    //   359: invokeinterface 188 3 0
    //   364: pop
    //   365: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   368: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   371: iconst_2
    //   372: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   375: checkcast 208	mqq/manager/TicketManager
    //   378: astore 4
    //   380: aload 4
    //   382: aload_2
    //   383: invokeinterface 212 2 0
    //   388: astore 6
    //   390: aload 7
    //   392: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +429 -> 824
    //   398: aload 4
    //   400: aload_2
    //   401: ldc 214
    //   403: invokeinterface 218 3 0
    //   408: astore 4
    //   410: aload 4
    //   412: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifeq +144 -> 559
    //   418: ldc 38
    //   420: iconst_1
    //   421: ldc_w 635
    //   424: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   430: astore_2
    //   431: aload_2
    //   432: ifnull +20 -> 452
    //   435: aload 5
    //   437: ldc_w 282
    //   440: aload_2
    //   441: aload 7
    //   443: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokeinterface 188 3 0
    //   451: pop
    //   452: aload 5
    //   454: invokeinterface 234 1 0
    //   459: invokeinterface 240 1 0
    //   464: astore_2
    //   465: aload_2
    //   466: invokeinterface 245 1 0
    //   471: ifeq +165 -> 636
    //   474: aload_2
    //   475: invokeinterface 249 1 0
    //   480: checkcast 251	java/util/Map$Entry
    //   483: astore 4
    //   485: aload_1
    //   486: aload 4
    //   488: invokeinterface 254 1 0
    //   493: checkcast 256	java/lang/String
    //   496: aload 4
    //   498: invokeinterface 259 1 0
    //   503: checkcast 256	java/lang/String
    //   506: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -44 -> 465
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_0
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 38
    //   520: iconst_1
    //   521: new 55	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 664
    //   531: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   538: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: astore_2
    //   549: aload_1
    //   550: ifnull -522 -> 28
    //   553: aload_1
    //   554: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   557: aload_0
    //   558: areturn
    //   559: aload 5
    //   561: ldc_w 282
    //   564: new 55	java/lang/StringBuilder
    //   567: dup
    //   568: new 55	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 440
    //   578: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 4
    //   583: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 442
    //   589: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_2
    //   593: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 444
    //   599: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 6
    //   604: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokeinterface 188 3 0
    //   621: pop
    //   622: goto -170 -> 452
    //   625: astore_0
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   634: aload_0
    //   635: athrow
    //   636: new 448	java/io/DataOutputStream
    //   639: dup
    //   640: aload_1
    //   641: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   644: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   647: astore_2
    //   648: aload_2
    //   649: aload_0
    //   650: invokevirtual 665	org/json/JSONObject:toString	()Ljava/lang/String;
    //   653: ldc_w 383
    //   656: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   659: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   662: aload_2
    //   663: invokevirtual 512	java/io/OutputStream:flush	()V
    //   666: aload_2
    //   667: invokevirtual 513	java/io/OutputStream:close	()V
    //   670: new 457	java/lang/StringBuffer
    //   673: dup
    //   674: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   677: astore_0
    //   678: aload_1
    //   679: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   682: istore_3
    //   683: iload_3
    //   684: sipush 200
    //   687: if_icmpeq +35 -> 722
    //   690: ldc 38
    //   692: iconst_1
    //   693: new 55	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 667
    //   703: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: iload_3
    //   707: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: ldc_w 528
    //   713: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: new 532	java/io/BufferedReader
    //   725: dup
    //   726: new 534	java/io/InputStreamReader
    //   729: dup
    //   730: aload_1
    //   731: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   734: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   737: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   740: astore_2
    //   741: aload_2
    //   742: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   745: astore 4
    //   747: aload 4
    //   749: ifnull +34 -> 783
    //   752: aload_0
    //   753: aload 4
    //   755: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   758: ldc_w 543
    //   761: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: goto -24 -> 741
    //   768: astore_0
    //   769: aload_2
    //   770: invokevirtual 513	java/io/OutputStream:close	()V
    //   773: aload_1
    //   774: ifnull +7 -> 781
    //   777: aload_1
    //   778: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   781: aconst_null
    //   782: areturn
    //   783: aload_0
    //   784: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   787: astore_0
    //   788: aload_2
    //   789: invokevirtual 544	java/io/BufferedReader:close	()V
    //   792: aload_1
    //   793: ifnull +29 -> 822
    //   796: aload_1
    //   797: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   800: aload_0
    //   801: areturn
    //   802: astore_0
    //   803: aload 4
    //   805: astore_1
    //   806: goto -180 -> 626
    //   809: astore_2
    //   810: aconst_null
    //   811: astore_0
    //   812: aload 5
    //   814: astore_1
    //   815: goto -300 -> 515
    //   818: astore_2
    //   819: goto -304 -> 515
    //   822: aload_0
    //   823: areturn
    //   824: aconst_null
    //   825: astore 4
    //   827: goto -417 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	paramJSONObject	JSONObject
    //   0	830	1	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	830	2	paramString	String
    //   682	25	3	i	int
    //   37	789	4	localObject1	Object
    //   4	809	5	localHashMap	java.util.HashMap
    //   1	602	6	str1	String
    //   88	354	7	str2	String
    //   111	70	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   179	410	512	java/lang/Exception
    //   410	431	512	java/lang/Exception
    //   435	452	512	java/lang/Exception
    //   452	465	512	java/lang/Exception
    //   465	509	512	java/lang/Exception
    //   559	622	512	java/lang/Exception
    //   636	648	512	java/lang/Exception
    //   670	683	512	java/lang/Exception
    //   690	722	512	java/lang/Exception
    //   722	741	512	java/lang/Exception
    //   741	747	512	java/lang/Exception
    //   752	765	512	java/lang/Exception
    //   769	773	512	java/lang/Exception
    //   783	788	512	java/lang/Exception
    //   179	410	625	finally
    //   410	431	625	finally
    //   435	452	625	finally
    //   452	465	625	finally
    //   465	509	625	finally
    //   559	622	625	finally
    //   636	648	625	finally
    //   648	670	625	finally
    //   670	683	625	finally
    //   690	722	625	finally
    //   722	741	625	finally
    //   741	747	625	finally
    //   752	765	625	finally
    //   769	773	625	finally
    //   783	788	625	finally
    //   788	792	625	finally
    //   648	670	768	java/lang/Exception
    //   94	102	802	finally
    //   106	113	802	finally
    //   117	132	802	finally
    //   136	150	802	finally
    //   154	159	802	finally
    //   163	179	802	finally
    //   518	547	802	finally
    //   94	102	809	java/lang/Exception
    //   106	113	809	java/lang/Exception
    //   117	132	809	java/lang/Exception
    //   136	150	809	java/lang/Exception
    //   154	159	809	java/lang/Exception
    //   163	179	809	java/lang/Exception
    //   788	792	818	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +16 -> 29
    //   16: ldc 38
    //   18: iconst_1
    //   19: ldc_w 653
    //   22: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: new 55	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc_w 372
    //   43: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 374
    //   53: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 670
    //   59: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload_3
    //   71: astore 4
    //   73: new 69	bafw
    //   76: dup
    //   77: invokespecial 70	bafw:<init>	()V
    //   80: astore 7
    //   82: aload_3
    //   83: astore 4
    //   85: ldc 72
    //   87: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   90: astore 8
    //   92: aload_3
    //   93: astore 4
    //   95: aload 8
    //   97: aconst_null
    //   98: iconst_1
    //   99: anewarray 80	javax/net/ssl/TrustManager
    //   102: dup
    //   103: iconst_0
    //   104: aload 7
    //   106: aastore
    //   107: aconst_null
    //   108: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   111: aload_3
    //   112: astore 4
    //   114: new 86	bafy
    //   117: dup
    //   118: aload 8
    //   120: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   123: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   126: astore 7
    //   128: aload_3
    //   129: astore 4
    //   131: aload 7
    //   133: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   136: aload_3
    //   137: astore 4
    //   139: new 100	java/net/URL
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   151: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   154: astore_3
    //   155: aload_3
    //   156: aload 7
    //   158: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   161: aload_3
    //   162: sipush 5000
    //   165: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   168: aload_3
    //   169: sipush 30000
    //   172: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   175: aload_3
    //   176: iconst_1
    //   177: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   180: aload_3
    //   181: iconst_1
    //   182: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   185: aload_3
    //   186: iconst_0
    //   187: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   190: aload_3
    //   191: ldc_w 430
    //   194: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: ldc 134
    //   200: ldc 136
    //   202: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_3
    //   206: ldc 142
    //   208: new 55	java/lang/StringBuilder
    //   211: dup
    //   212: ldc 144
    //   214: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: ldc 147
    //   219: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   225: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 147
    //   230: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   236: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 147
    //   241: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   247: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 147
    //   252: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 163
    //   257: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 147
    //   262: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 165
    //   267: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 167
    //   272: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_3
    //   282: ldc 173
    //   284: ldc_w 631
    //   287: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_3
    //   291: ldc 169
    //   293: ldc 171
    //   295: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_3
    //   299: ldc_w 633
    //   302: ldc_w 383
    //   305: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: new 179	java/util/HashMap
    //   311: dup
    //   312: invokespecial 180	java/util/HashMap:<init>	()V
    //   315: astore 5
    //   317: aload 5
    //   319: ldc 134
    //   321: ldc 182
    //   323: invokeinterface 188 3 0
    //   328: pop
    //   329: aload 5
    //   331: ldc 190
    //   333: aload 6
    //   335: invokeinterface 188 3 0
    //   340: pop
    //   341: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   344: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   347: iconst_2
    //   348: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   351: checkcast 208	mqq/manager/TicketManager
    //   354: astore 4
    //   356: aload 4
    //   358: aload_1
    //   359: invokeinterface 212 2 0
    //   364: astore 7
    //   366: aload 6
    //   368: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +441 -> 812
    //   374: aload 4
    //   376: aload_1
    //   377: ldc 214
    //   379: invokeinterface 218 3 0
    //   384: astore 4
    //   386: aload 4
    //   388: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +150 -> 541
    //   394: ldc 38
    //   396: iconst_1
    //   397: ldc_w 635
    //   400: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +20 -> 428
    //   411: aload 5
    //   413: ldc_w 282
    //   416: aload_1
    //   417: aload 6
    //   419: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   422: invokeinterface 188 3 0
    //   427: pop
    //   428: aload 5
    //   430: invokeinterface 234 1 0
    //   435: invokeinterface 240 1 0
    //   440: astore_1
    //   441: aload_1
    //   442: invokeinterface 245 1 0
    //   447: ifeq +171 -> 618
    //   450: aload_1
    //   451: invokeinterface 249 1 0
    //   456: checkcast 251	java/util/Map$Entry
    //   459: astore 4
    //   461: aload_3
    //   462: aload 4
    //   464: invokeinterface 254 1 0
    //   469: checkcast 256	java/lang/String
    //   472: aload 4
    //   474: invokeinterface 259 1 0
    //   479: checkcast 256	java/lang/String
    //   482: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: goto -44 -> 441
    //   488: astore 4
    //   490: aconst_null
    //   491: astore_0
    //   492: aload_3
    //   493: astore_1
    //   494: aload 4
    //   496: astore_3
    //   497: aload_1
    //   498: astore 4
    //   500: ldc 38
    //   502: iconst_1
    //   503: new 55	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 664
    //   513: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   520: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: astore_3
    //   531: aload_1
    //   532: ifnull -505 -> 27
    //   535: aload_1
    //   536: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   539: aload_0
    //   540: areturn
    //   541: aload 5
    //   543: ldc_w 282
    //   546: new 55	java/lang/StringBuilder
    //   549: dup
    //   550: new 55	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 440
    //   560: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 4
    //   565: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: ldc_w 442
    //   571: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_1
    //   575: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 444
    //   581: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 7
    //   586: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokeinterface 188 3 0
    //   603: pop
    //   604: goto -176 -> 428
    //   607: astore_0
    //   608: aload_3
    //   609: ifnull +7 -> 616
    //   612: aload_3
    //   613: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   616: aload_0
    //   617: athrow
    //   618: new 448	java/io/DataOutputStream
    //   621: dup
    //   622: aload_3
    //   623: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   626: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   629: astore_1
    //   630: aload_1
    //   631: aload_0
    //   632: invokevirtual 665	org/json/JSONObject:toString	()Ljava/lang/String;
    //   635: ldc_w 383
    //   638: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   641: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   644: aload_1
    //   645: invokevirtual 512	java/io/OutputStream:flush	()V
    //   648: aload_1
    //   649: invokevirtual 513	java/io/OutputStream:close	()V
    //   652: new 457	java/lang/StringBuffer
    //   655: dup
    //   656: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   659: astore_0
    //   660: aload_3
    //   661: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   664: istore_2
    //   665: iload_2
    //   666: sipush 200
    //   669: if_icmpeq +35 -> 704
    //   672: ldc 38
    //   674: iconst_1
    //   675: new 55	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 667
    //   685: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload_2
    //   689: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: ldc_w 528
    //   695: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: new 532	java/io/BufferedReader
    //   707: dup
    //   708: new 534	java/io/InputStreamReader
    //   711: dup
    //   712: aload_3
    //   713: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   716: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   719: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   722: astore_1
    //   723: aload_1
    //   724: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   727: astore 4
    //   729: aload 4
    //   731: ifnull +34 -> 765
    //   734: aload_0
    //   735: aload 4
    //   737: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   740: ldc_w 543
    //   743: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: pop
    //   747: goto -24 -> 723
    //   750: astore_0
    //   751: aload_1
    //   752: invokevirtual 513	java/io/OutputStream:close	()V
    //   755: aload_3
    //   756: ifnull +7 -> 763
    //   759: aload_3
    //   760: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   763: aconst_null
    //   764: areturn
    //   765: aload_0
    //   766: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   769: astore_0
    //   770: aload_1
    //   771: invokevirtual 544	java/io/BufferedReader:close	()V
    //   774: aload_3
    //   775: ifnull +35 -> 810
    //   778: aload_3
    //   779: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   782: aload_0
    //   783: areturn
    //   784: astore_0
    //   785: aload 4
    //   787: astore_3
    //   788: goto -180 -> 608
    //   791: astore_3
    //   792: aconst_null
    //   793: astore_0
    //   794: aload 5
    //   796: astore_1
    //   797: goto -300 -> 497
    //   800: astore 4
    //   802: aload_3
    //   803: astore_1
    //   804: aload 4
    //   806: astore_3
    //   807: goto -310 -> 497
    //   810: aload_0
    //   811: areturn
    //   812: aconst_null
    //   813: astore 4
    //   815: goto -429 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramJSONObject	JSONObject
    //   0	818	1	paramString	String
    //   664	25	2	i	int
    //   1	787	3	localObject1	Object
    //   791	12	3	localException1	java.lang.Exception
    //   806	1	3	localObject2	Object
    //   36	437	4	localObject3	Object
    //   488	7	4	localException2	java.lang.Exception
    //   498	288	4	str1	String
    //   800	5	4	localException3	java.lang.Exception
    //   813	1	4	localObject4	Object
    //   3	792	5	localHashMap	java.util.HashMap
    //   68	350	6	str2	String
    //   80	505	7	localObject5	Object
    //   90	29	8	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   155	386	488	java/lang/Exception
    //   386	407	488	java/lang/Exception
    //   411	428	488	java/lang/Exception
    //   428	441	488	java/lang/Exception
    //   441	485	488	java/lang/Exception
    //   541	604	488	java/lang/Exception
    //   618	630	488	java/lang/Exception
    //   652	665	488	java/lang/Exception
    //   672	704	488	java/lang/Exception
    //   704	723	488	java/lang/Exception
    //   723	729	488	java/lang/Exception
    //   734	747	488	java/lang/Exception
    //   751	755	488	java/lang/Exception
    //   765	770	488	java/lang/Exception
    //   155	386	607	finally
    //   386	407	607	finally
    //   411	428	607	finally
    //   428	441	607	finally
    //   441	485	607	finally
    //   541	604	607	finally
    //   618	630	607	finally
    //   630	652	607	finally
    //   652	665	607	finally
    //   672	704	607	finally
    //   704	723	607	finally
    //   723	729	607	finally
    //   734	747	607	finally
    //   751	755	607	finally
    //   765	770	607	finally
    //   770	774	607	finally
    //   630	652	750	java/lang/Exception
    //   73	82	784	finally
    //   85	92	784	finally
    //   95	111	784	finally
    //   114	128	784	finally
    //   131	136	784	finally
    //   139	155	784	finally
    //   500	529	784	finally
    //   73	82	791	java/lang/Exception
    //   85	92	791	java/lang/Exception
    //   95	111	791	java/lang/Exception
    //   114	128	791	java/lang/Exception
    //   131	136	791	java/lang/Exception
    //   139	155	791	java/lang/Exception
    //   770	774	800	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_3
    //   14: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +16 -> 33
    //   20: ldc 38
    //   22: iconst_1
    //   23: ldc_w 365
    //   26: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: new 55	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: new 341	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: ifnull +553 -> 607
    //   57: aload 8
    //   59: invokevirtual 368	java/io/File:exists	()Z
    //   62: ifeq +545 -> 607
    //   65: aload 5
    //   67: aload_2
    //   68: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 7
    //   81: astore 5
    //   83: new 69	bafw
    //   86: dup
    //   87: invokespecial 70	bafw:<init>	()V
    //   90: astore_2
    //   91: aload 7
    //   93: astore 5
    //   95: ldc 72
    //   97: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   100: astore 10
    //   102: aload 7
    //   104: astore 5
    //   106: aload 10
    //   108: aconst_null
    //   109: iconst_1
    //   110: anewarray 80	javax/net/ssl/TrustManager
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   121: aload 7
    //   123: astore 5
    //   125: new 86	bafy
    //   128: dup
    //   129: aload 10
    //   131: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   134: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   137: astore 10
    //   139: aload 7
    //   141: astore 5
    //   143: aload 10
    //   145: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: aload 7
    //   150: astore 5
    //   152: new 100	java/net/URL
    //   155: dup
    //   156: aload 9
    //   158: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   161: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   164: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   167: astore_2
    //   168: aload_2
    //   169: aload 10
    //   171: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   174: aload_2
    //   175: sipush 5000
    //   178: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   181: aload_2
    //   182: sipush 30000
    //   185: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   188: aload_2
    //   189: iconst_1
    //   190: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   193: aload_2
    //   194: iconst_1
    //   195: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   198: aload_2
    //   199: iconst_0
    //   200: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   203: aload_2
    //   204: ldc_w 430
    //   207: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   210: aload_2
    //   211: ldc 134
    //   213: ldc 136
    //   215: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_2
    //   219: ldc 142
    //   221: new 55	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 144
    //   227: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: ldc 147
    //   232: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   238: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 147
    //   243: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   249: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 147
    //   254: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   260: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 147
    //   265: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 163
    //   270: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 147
    //   275: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 165
    //   280: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 167
    //   285: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: ldc 169
    //   297: ldc 171
    //   299: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: ldc 173
    //   305: new 55	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   312: ldc 175
    //   314: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 177
    //   319: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: new 179	java/util/HashMap
    //   331: dup
    //   332: invokespecial 180	java/util/HashMap:<init>	()V
    //   335: astore 10
    //   337: aload 10
    //   339: ldc 134
    //   341: ldc 182
    //   343: invokeinterface 188 3 0
    //   348: pop
    //   349: aload 10
    //   351: ldc 190
    //   353: aload 9
    //   355: invokeinterface 188 3 0
    //   360: pop
    //   361: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   364: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   367: iconst_2
    //   368: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   371: checkcast 208	mqq/manager/TicketManager
    //   374: astore 5
    //   376: aload 5
    //   378: aload_3
    //   379: invokeinterface 212 2 0
    //   384: astore 11
    //   386: aload 9
    //   388: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne +933 -> 1324
    //   394: aload 5
    //   396: aload_3
    //   397: ldc 214
    //   399: invokeinterface 218 3 0
    //   404: astore 5
    //   406: aload 8
    //   408: ifnull +911 -> 1319
    //   411: aload 8
    //   413: invokevirtual 368	java/io/File:exists	()Z
    //   416: ifeq +903 -> 1319
    //   419: aload_1
    //   420: invokestatic 370	bahp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   423: astore_1
    //   424: aload 5
    //   426: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifeq +189 -> 618
    //   432: ldc 38
    //   434: iconst_1
    //   435: ldc_w 432
    //   438: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +20 -> 466
    //   449: aload 10
    //   451: ldc_w 282
    //   454: aload_1
    //   455: aload 9
    //   457: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   460: invokeinterface 188 3 0
    //   465: pop
    //   466: aload 10
    //   468: invokeinterface 234 1 0
    //   473: invokeinterface 240 1 0
    //   478: astore_3
    //   479: aload_3
    //   480: invokeinterface 245 1 0
    //   485: ifeq +246 -> 731
    //   488: aload_3
    //   489: invokeinterface 249 1 0
    //   494: checkcast 251	java/util/Map$Entry
    //   497: astore_1
    //   498: aload_2
    //   499: aload_1
    //   500: invokeinterface 254 1 0
    //   505: checkcast 256	java/lang/String
    //   508: aload_1
    //   509: invokeinterface 259 1 0
    //   514: checkcast 256	java/lang/String
    //   517: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: goto -41 -> 479
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_0
    //   526: aload_2
    //   527: astore_1
    //   528: aload_3
    //   529: astore_2
    //   530: aload_1
    //   531: astore 5
    //   533: ldc_w 261
    //   536: iconst_1
    //   537: new 55	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 434
    //   547: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_2
    //   551: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   554: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_0
    //   564: astore_2
    //   565: aload_1
    //   566: ifnull -535 -> 31
    //   569: aload_1
    //   570: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   573: aload_0
    //   574: areturn
    //   575: astore_0
    //   576: ldc 38
    //   578: iconst_1
    //   579: new 55	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 436
    //   589: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_0
    //   593: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   596: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aconst_null
    //   606: areturn
    //   607: ldc 38
    //   609: iconst_1
    //   610: ldc_w 438
    //   613: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aconst_null
    //   617: areturn
    //   618: new 55	java/lang/StringBuilder
    //   621: dup
    //   622: new 55	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 440
    //   632: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload 5
    //   637: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: ldc_w 442
    //   643: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload_3
    //   647: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 444
    //   653: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 11
    //   658: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   667: astore_3
    //   668: aload_1
    //   669: ifnull +28 -> 697
    //   672: aload_3
    //   673: new 55	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 446
    //   683: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_1
    //   687: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 10
    //   699: ldc_w 282
    //   702: aload_3
    //   703: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokeinterface 188 3 0
    //   711: pop
    //   712: goto -246 -> 466
    //   715: astore_0
    //   716: aload_2
    //   717: astore 5
    //   719: aload 5
    //   721: ifnull +8 -> 729
    //   724: aload 5
    //   726: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   729: aload_0
    //   730: athrow
    //   731: new 448	java/io/DataOutputStream
    //   734: dup
    //   735: aload_2
    //   736: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   739: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   742: astore_1
    //   743: aload_0
    //   744: ifnull +132 -> 876
    //   747: new 55	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   754: astore 10
    //   756: aload_0
    //   757: invokevirtual 674	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   760: astore_3
    //   761: aload_3
    //   762: invokeinterface 245 1 0
    //   767: ifeq +97 -> 864
    //   770: aload_3
    //   771: invokeinterface 249 1 0
    //   776: checkcast 256	java/lang/String
    //   779: astore 5
    //   781: aload_0
    //   782: aload 5
    //   784: invokevirtual 625	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: astore 9
    //   789: aload 9
    //   791: ifnull -30 -> 761
    //   794: aload 10
    //   796: ldc_w 460
    //   799: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: ldc_w 465
    //   805: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc 177
    //   810: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc_w 460
    //   816: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 10
    //   822: new 55	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 467
    //   832: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 5
    //   837: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 676
    //   843: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 10
    //   855: aload 9
    //   857: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: goto -100 -> 761
    //   864: aload_1
    //   865: aload 10
    //   867: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokevirtual 483	java/lang/String:getBytes	()[B
    //   873: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   876: new 457	java/lang/StringBuffer
    //   879: dup
    //   880: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   883: astore_0
    //   884: aload_0
    //   885: ldc_w 460
    //   888: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   891: ldc_w 465
    //   894: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   897: ldc 177
    //   899: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   902: ldc_w 460
    //   905: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   908: pop
    //   909: aload_0
    //   910: ldc_w 467
    //   913: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   916: ldc_w 469
    //   919: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   922: ldc_w 471
    //   925: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   928: aload 8
    //   930: invokevirtual 381	java/io/File:getName	()Ljava/lang/String;
    //   933: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   936: ldc_w 473
    //   939: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   942: ldc_w 460
    //   945: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   948: pop
    //   949: aload_0
    //   950: new 55	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 475
    //   960: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: ldc_w 477
    //   966: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: ldc_w 479
    //   972: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   981: pop
    //   982: aload_1
    //   983: aload_0
    //   984: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   987: invokevirtual 483	java/lang/String:getBytes	()[B
    //   990: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   993: new 488	java/io/BufferedInputStream
    //   996: dup
    //   997: new 488	java/io/BufferedInputStream
    //   1000: dup
    //   1001: new 490	java/io/FileInputStream
    //   1004: dup
    //   1005: aload 8
    //   1007: invokespecial 491	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1010: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1013: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1016: astore_0
    //   1017: sipush 3072
    //   1020: newarray byte
    //   1022: astore_3
    //   1023: aload_0
    //   1024: aload_3
    //   1025: invokevirtual 495	java/io/BufferedInputStream:read	([B)I
    //   1028: istore 4
    //   1030: iload 4
    //   1032: iconst_m1
    //   1033: if_icmpeq +93 -> 1126
    //   1036: aload_1
    //   1037: aload_3
    //   1038: iconst_0
    //   1039: iload 4
    //   1041: invokevirtual 496	java/io/OutputStream:write	([BII)V
    //   1044: goto -21 -> 1023
    //   1047: astore_3
    //   1048: ldc 38
    //   1050: iconst_1
    //   1051: new 55	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 498
    //   1061: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload 8
    //   1066: invokevirtual 501	java/io/File:length	()J
    //   1069: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1072: ldc_w 506
    //   1075: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 8
    //   1080: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1083: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1092: aload_1
    //   1093: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1096: aload_1
    //   1097: invokevirtual 513	java/io/OutputStream:close	()V
    //   1100: aload_2
    //   1101: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1104: aload 7
    //   1106: astore 5
    //   1108: aload_0
    //   1109: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1112: iconst_0
    //   1113: ifeq +11 -> 1124
    //   1116: new 516	java/lang/NullPointerException
    //   1119: dup
    //   1120: invokespecial 517	java/lang/NullPointerException:<init>	()V
    //   1123: athrow
    //   1124: aconst_null
    //   1125: areturn
    //   1126: aload_0
    //   1127: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1130: aload_1
    //   1131: new 55	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 519
    //   1141: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: ldc 177
    //   1146: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: ldc_w 521
    //   1152: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1161: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1164: aload_1
    //   1165: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1168: aload_1
    //   1169: invokevirtual 513	java/io/OutputStream:close	()V
    //   1172: new 457	java/lang/StringBuffer
    //   1175: dup
    //   1176: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   1179: astore_0
    //   1180: aload_2
    //   1181: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1184: istore 4
    //   1186: iload 4
    //   1188: sipush 200
    //   1191: if_icmpeq +36 -> 1227
    //   1194: ldc 38
    //   1196: iconst_1
    //   1197: new 55	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 526
    //   1207: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: iload 4
    //   1212: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1215: ldc_w 528
    //   1218: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: new 532	java/io/BufferedReader
    //   1230: dup
    //   1231: new 534	java/io/InputStreamReader
    //   1234: dup
    //   1235: aload_2
    //   1236: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1239: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1242: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1245: astore_1
    //   1246: aload_1
    //   1247: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1250: astore_3
    //   1251: aload_3
    //   1252: ifnull +25 -> 1277
    //   1255: aload_0
    //   1256: aload_3
    //   1257: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1260: ldc_w 543
    //   1263: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1266: pop
    //   1267: goto -21 -> 1246
    //   1270: astore_1
    //   1271: aload_0
    //   1272: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1275: aload_1
    //   1276: athrow
    //   1277: aload_0
    //   1278: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1281: astore_0
    //   1282: aload_1
    //   1283: invokevirtual 544	java/io/BufferedReader:close	()V
    //   1286: aload_2
    //   1287: ifnull +30 -> 1317
    //   1290: aload_2
    //   1291: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1294: aload_0
    //   1295: areturn
    //   1296: astore_0
    //   1297: goto -578 -> 719
    //   1300: astore_2
    //   1301: aconst_null
    //   1302: astore_0
    //   1303: aload 6
    //   1305: astore_1
    //   1306: goto -776 -> 530
    //   1309: astore_3
    //   1310: aload_2
    //   1311: astore_1
    //   1312: aload_3
    //   1313: astore_2
    //   1314: goto -784 -> 530
    //   1317: aload_0
    //   1318: areturn
    //   1319: aconst_null
    //   1320: astore_1
    //   1321: goto -897 -> 424
    //   1324: aconst_null
    //   1325: astore 5
    //   1327: goto -921 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1330	0	paramJSONObject	JSONObject
    //   0	1330	1	paramString1	String
    //   0	1330	2	paramString2	String
    //   0	1330	3	paramString3	String
    //   1028	183	4	i	int
    //   40	1286	5	localObject1	Object
    //   4	1300	6	localObject2	Object
    //   1	1104	7	localObject3	Object
    //   50	1029	8	localFile	java.io.File
    //   77	779	9	str1	String
    //   100	766	10	localObject4	Object
    //   384	273	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   168	406	523	java/lang/Exception
    //   411	424	523	java/lang/Exception
    //   424	445	523	java/lang/Exception
    //   449	466	523	java/lang/Exception
    //   466	479	523	java/lang/Exception
    //   479	520	523	java/lang/Exception
    //   618	668	523	java/lang/Exception
    //   672	697	523	java/lang/Exception
    //   697	712	523	java/lang/Exception
    //   731	743	523	java/lang/Exception
    //   747	761	523	java/lang/Exception
    //   761	789	523	java/lang/Exception
    //   794	861	523	java/lang/Exception
    //   864	876	523	java/lang/Exception
    //   876	1023	523	java/lang/Exception
    //   1126	1186	523	java/lang/Exception
    //   1194	1227	523	java/lang/Exception
    //   1227	1246	523	java/lang/Exception
    //   1246	1251	523	java/lang/Exception
    //   1255	1267	523	java/lang/Exception
    //   1271	1277	523	java/lang/Exception
    //   1277	1282	523	java/lang/Exception
    //   65	72	575	java/lang/Exception
    //   168	406	715	finally
    //   411	424	715	finally
    //   424	445	715	finally
    //   449	466	715	finally
    //   466	479	715	finally
    //   479	520	715	finally
    //   618	668	715	finally
    //   672	697	715	finally
    //   697	712	715	finally
    //   731	743	715	finally
    //   747	761	715	finally
    //   761	789	715	finally
    //   794	861	715	finally
    //   864	876	715	finally
    //   876	1023	715	finally
    //   1126	1186	715	finally
    //   1194	1227	715	finally
    //   1227	1246	715	finally
    //   1246	1251	715	finally
    //   1255	1267	715	finally
    //   1271	1277	715	finally
    //   1277	1282	715	finally
    //   1282	1286	715	finally
    //   1023	1030	1047	java/lang/OutOfMemoryError
    //   1036	1044	1047	java/lang/OutOfMemoryError
    //   1023	1030	1270	finally
    //   1036	1044	1270	finally
    //   1048	1104	1270	finally
    //   83	91	1296	finally
    //   95	102	1296	finally
    //   106	121	1296	finally
    //   125	139	1296	finally
    //   143	148	1296	finally
    //   152	168	1296	finally
    //   533	563	1296	finally
    //   1108	1112	1296	finally
    //   83	91	1300	java/lang/Exception
    //   95	102	1300	java/lang/Exception
    //   106	121	1300	java/lang/Exception
    //   125	139	1300	java/lang/Exception
    //   143	148	1300	java/lang/Exception
    //   152	168	1300	java/lang/Exception
    //   1108	1112	1300	java/lang/Exception
    //   1282	1286	1309	java/lang/Exception
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, paramString4, null, true);
  }
  
  /* Error */
  public static final JSONObject a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: ldc 38
    //   16: iconst_1
    //   17: ldc 40
    //   19: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: sipush 157
    //   28: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   31: checkcast 682	baif
    //   34: astore 15
    //   36: aload 15
    //   38: iconst_2
    //   39: iconst_1
    //   40: aconst_null
    //   41: invokevirtual 683	baif:notifyUI	(IZLjava/lang/Object;)V
    //   44: aload 15
    //   46: iconst_4
    //   47: iconst_1
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: bipush 20
    //   56: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokevirtual 683	baif:notifyUI	(IZLjava/lang/Object;)V
    //   63: new 55	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: ldc_w 685
    //   75: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 17
    //   85: new 341	java/io/File
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 16
    //   95: aconst_null
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 12
    //   100: aconst_null
    //   101: astore 14
    //   103: aload 12
    //   105: astore 10
    //   107: aload_0
    //   108: astore 11
    //   110: new 69	bafw
    //   113: dup
    //   114: invokespecial 70	bafw:<init>	()V
    //   117: astore 13
    //   119: aload 12
    //   121: astore 10
    //   123: aload_0
    //   124: astore 11
    //   126: ldc 72
    //   128: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   131: astore 18
    //   133: aload 12
    //   135: astore 10
    //   137: aload_0
    //   138: astore 11
    //   140: aload 18
    //   142: aconst_null
    //   143: iconst_1
    //   144: anewarray 80	javax/net/ssl/TrustManager
    //   147: dup
    //   148: iconst_0
    //   149: aload 13
    //   151: aastore
    //   152: aconst_null
    //   153: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   156: aload 12
    //   158: astore 10
    //   160: aload_0
    //   161: astore 11
    //   163: new 86	bafy
    //   166: dup
    //   167: aload 18
    //   169: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   172: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   175: astore 13
    //   177: aload 12
    //   179: astore 10
    //   181: aload_0
    //   182: astore 11
    //   184: aload 13
    //   186: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   189: aload 12
    //   191: astore 10
    //   193: aload_0
    //   194: astore 11
    //   196: new 100	java/net/URL
    //   199: dup
    //   200: aload 17
    //   202: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   205: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   208: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   211: astore_0
    //   212: aload_0
    //   213: astore 10
    //   215: aload_0
    //   216: astore 11
    //   218: aload_0
    //   219: aload 13
    //   221: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   224: aload_0
    //   225: astore 10
    //   227: aload_0
    //   228: astore 11
    //   230: aload_0
    //   231: sipush 5000
    //   234: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   237: aload_0
    //   238: astore 10
    //   240: aload_0
    //   241: astore 11
    //   243: aload_0
    //   244: sipush 30000
    //   247: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   250: aload_0
    //   251: astore 10
    //   253: aload_0
    //   254: astore 11
    //   256: aload_0
    //   257: iconst_1
    //   258: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   261: aload_0
    //   262: astore 10
    //   264: aload_0
    //   265: astore 11
    //   267: aload_0
    //   268: iconst_1
    //   269: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   272: aload_0
    //   273: astore 10
    //   275: aload_0
    //   276: astore 11
    //   278: aload_0
    //   279: iconst_0
    //   280: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   283: aload_0
    //   284: astore 10
    //   286: aload_0
    //   287: astore 11
    //   289: aload_0
    //   290: ldc_w 430
    //   293: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: astore 10
    //   299: aload_0
    //   300: astore 11
    //   302: aload_0
    //   303: ldc 134
    //   305: ldc 136
    //   307: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: astore 10
    //   313: aload_0
    //   314: astore 11
    //   316: aload_0
    //   317: ldc 142
    //   319: new 55	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 144
    //   325: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: ldc 147
    //   330: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   336: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 147
    //   341: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   347: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 147
    //   352: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   358: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 147
    //   363: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc 163
    //   368: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 147
    //   373: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 165
    //   378: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc 167
    //   383: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: astore 10
    //   395: aload_0
    //   396: astore 11
    //   398: aload_0
    //   399: ldc 169
    //   401: ldc 171
    //   403: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: astore 10
    //   409: aload_0
    //   410: astore 11
    //   412: aload_0
    //   413: ldc 173
    //   415: new 55	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   422: ldc 175
    //   424: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 177
    //   429: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: astore 10
    //   441: aload_0
    //   442: astore 11
    //   444: new 179	java/util/HashMap
    //   447: dup
    //   448: invokespecial 180	java/util/HashMap:<init>	()V
    //   451: astore 18
    //   453: aload_0
    //   454: astore 10
    //   456: aload_0
    //   457: astore 11
    //   459: aload 18
    //   461: ldc 134
    //   463: ldc 182
    //   465: invokeinterface 188 3 0
    //   470: pop
    //   471: aload_0
    //   472: astore 10
    //   474: aload_0
    //   475: astore 11
    //   477: aload 18
    //   479: ldc 190
    //   481: aload 17
    //   483: invokeinterface 188 3 0
    //   488: pop
    //   489: aload_0
    //   490: astore 10
    //   492: aload_0
    //   493: astore 11
    //   495: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   498: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   501: iconst_2
    //   502: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   505: checkcast 208	mqq/manager/TicketManager
    //   508: astore 13
    //   510: aconst_null
    //   511: astore 12
    //   513: aload_0
    //   514: astore 10
    //   516: aload_0
    //   517: astore 11
    //   519: aload 13
    //   521: aload_2
    //   522: invokeinterface 212 2 0
    //   527: astore 19
    //   529: aload_0
    //   530: astore 10
    //   532: aload_0
    //   533: astore 11
    //   535: aload 17
    //   537: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   540: ifne +21 -> 561
    //   543: aload_0
    //   544: astore 10
    //   546: aload_0
    //   547: astore 11
    //   549: aload 13
    //   551: aload_2
    //   552: ldc 214
    //   554: invokeinterface 218 3 0
    //   559: astore 12
    //   561: aconst_null
    //   562: astore 10
    //   564: aload 10
    //   566: astore 13
    //   568: aload 16
    //   570: ifnull +33 -> 603
    //   573: aload 10
    //   575: astore 13
    //   577: aload_0
    //   578: astore 10
    //   580: aload_0
    //   581: astore 11
    //   583: aload 16
    //   585: invokevirtual 368	java/io/File:exists	()Z
    //   588: ifeq +15 -> 603
    //   591: aload_0
    //   592: astore 10
    //   594: aload_0
    //   595: astore 11
    //   597: aload_1
    //   598: invokestatic 370	bahp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 13
    //   603: aload_0
    //   604: astore 10
    //   606: aload_0
    //   607: astore 11
    //   609: aload 12
    //   611: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   614: ifeq +164 -> 778
    //   617: aload_0
    //   618: astore 10
    //   620: aload_0
    //   621: astore 11
    //   623: ldc 38
    //   625: iconst_1
    //   626: ldc_w 432
    //   629: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_0
    //   633: astore 10
    //   635: aload_0
    //   636: astore 11
    //   638: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   641: astore_1
    //   642: aload_1
    //   643: ifnull +26 -> 669
    //   646: aload_0
    //   647: astore 10
    //   649: aload_0
    //   650: astore 11
    //   652: aload 18
    //   654: ldc_w 282
    //   657: aload_1
    //   658: aload 17
    //   660: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokeinterface 188 3 0
    //   668: pop
    //   669: aload_0
    //   670: astore 10
    //   672: aload_0
    //   673: astore 11
    //   675: aload 18
    //   677: invokeinterface 234 1 0
    //   682: invokeinterface 240 1 0
    //   687: astore_1
    //   688: aload_0
    //   689: astore 10
    //   691: aload_0
    //   692: astore 11
    //   694: aload_1
    //   695: invokeinterface 245 1 0
    //   700: ifeq +220 -> 920
    //   703: aload_0
    //   704: astore 10
    //   706: aload_0
    //   707: astore 11
    //   709: aload_1
    //   710: invokeinterface 249 1 0
    //   715: checkcast 251	java/util/Map$Entry
    //   718: astore_2
    //   719: aload_0
    //   720: astore 10
    //   722: aload_0
    //   723: astore 11
    //   725: aload_0
    //   726: aload_2
    //   727: invokeinterface 254 1 0
    //   732: checkcast 256	java/lang/String
    //   735: aload_2
    //   736: invokeinterface 259 1 0
    //   741: checkcast 256	java/lang/String
    //   744: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -59 -> 688
    //   750: astore_2
    //   751: aconst_null
    //   752: astore_1
    //   753: aload 10
    //   755: astore_0
    //   756: aload_2
    //   757: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   760: aload_1
    //   761: ifnull +7 -> 768
    //   764: aload_1
    //   765: invokevirtual 693	java/util/Timer:cancel	()V
    //   768: aload_0
    //   769: ifnull +890 -> 1659
    //   772: aload_0
    //   773: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   776: aconst_null
    //   777: areturn
    //   778: aload_0
    //   779: astore 10
    //   781: aload_0
    //   782: astore 11
    //   784: new 55	java/lang/StringBuilder
    //   787: dup
    //   788: new 55	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 440
    //   798: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 12
    //   803: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc_w 442
    //   809: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_2
    //   813: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 444
    //   819: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 19
    //   824: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   833: astore_1
    //   834: aload 13
    //   836: ifnull +35 -> 871
    //   839: aload_0
    //   840: astore 10
    //   842: aload_0
    //   843: astore 11
    //   845: aload_1
    //   846: new 55	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 446
    //   856: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 13
    //   861: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload_0
    //   872: astore 10
    //   874: aload_0
    //   875: astore 11
    //   877: aload 18
    //   879: ldc_w 282
    //   882: aload_1
    //   883: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokeinterface 188 3 0
    //   891: pop
    //   892: goto -223 -> 669
    //   895: astore_1
    //   896: aload 11
    //   898: astore_0
    //   899: aload 14
    //   901: astore_2
    //   902: aload_2
    //   903: ifnull +7 -> 910
    //   906: aload_2
    //   907: invokevirtual 693	java/util/Timer:cancel	()V
    //   910: aload_0
    //   911: ifnull +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   918: aload_1
    //   919: athrow
    //   920: aload_0
    //   921: astore 10
    //   923: aload_0
    //   924: astore 11
    //   926: new 448	java/io/DataOutputStream
    //   929: dup
    //   930: aload_0
    //   931: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   934: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   937: astore_2
    //   938: aload_0
    //   939: astore 10
    //   941: aload_0
    //   942: astore 11
    //   944: new 457	java/lang/StringBuffer
    //   947: dup
    //   948: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   951: astore_1
    //   952: aload_0
    //   953: astore 10
    //   955: aload_0
    //   956: astore 11
    //   958: aload_1
    //   959: ldc_w 460
    //   962: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   965: ldc_w 465
    //   968: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   971: ldc 177
    //   973: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   976: ldc_w 460
    //   979: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload_0
    //   984: astore 10
    //   986: aload_0
    //   987: astore 11
    //   989: aload_1
    //   990: ldc_w 467
    //   993: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   996: ldc_w 469
    //   999: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1002: ldc_w 471
    //   1005: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1008: aload 16
    //   1010: invokevirtual 381	java/io/File:getName	()Ljava/lang/String;
    //   1013: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1016: ldc_w 473
    //   1019: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1022: ldc_w 460
    //   1025: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1028: pop
    //   1029: aload_0
    //   1030: astore 10
    //   1032: aload_0
    //   1033: astore 11
    //   1035: aload_1
    //   1036: new 55	java/lang/StringBuilder
    //   1039: dup
    //   1040: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1043: ldc_w 475
    //   1046: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 477
    //   1052: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 479
    //   1058: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1067: pop
    //   1068: aload_0
    //   1069: astore 10
    //   1071: aload_0
    //   1072: astore 11
    //   1074: aload_2
    //   1075: aload_1
    //   1076: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1079: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1082: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1085: aload_0
    //   1086: astore 10
    //   1088: aload_0
    //   1089: astore 11
    //   1091: new 488	java/io/BufferedInputStream
    //   1094: dup
    //   1095: new 488	java/io/BufferedInputStream
    //   1098: dup
    //   1099: new 490	java/io/FileInputStream
    //   1102: dup
    //   1103: aload 16
    //   1105: invokespecial 491	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1108: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1111: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1114: astore_1
    //   1115: aload_0
    //   1116: astore 10
    //   1118: aload_0
    //   1119: astore 11
    //   1121: sipush 3072
    //   1124: newarray byte
    //   1126: astore 12
    //   1128: aload_0
    //   1129: astore 10
    //   1131: aload_0
    //   1132: astore 11
    //   1134: aload 16
    //   1136: invokevirtual 501	java/io/File:length	()J
    //   1139: lstore 6
    //   1141: lload 6
    //   1143: l2i
    //   1144: istore 4
    //   1146: lconst_0
    //   1147: lstore 6
    //   1149: iconst_0
    //   1150: istore_3
    //   1151: aload_1
    //   1152: aload 12
    //   1154: invokevirtual 495	java/io/BufferedInputStream:read	([B)I
    //   1157: istore 5
    //   1159: iload 5
    //   1161: iconst_m1
    //   1162: if_icmpeq +65 -> 1227
    //   1165: iload_3
    //   1166: iload 5
    //   1168: iadd
    //   1169: istore_3
    //   1170: aload_2
    //   1171: aload 12
    //   1173: iconst_0
    //   1174: iload 5
    //   1176: invokevirtual 496	java/io/OutputStream:write	([BII)V
    //   1179: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1182: lstore 8
    //   1184: lload 8
    //   1186: lload 6
    //   1188: lsub
    //   1189: ldc2_w 314
    //   1192: lcmp
    //   1193: iflt +470 -> 1663
    //   1196: aload 15
    //   1198: iconst_4
    //   1199: iconst_1
    //   1200: iconst_1
    //   1201: anewarray 4	java/lang/Object
    //   1204: dup
    //   1205: iconst_0
    //   1206: iload_3
    //   1207: bipush 30
    //   1209: imul
    //   1210: iload 4
    //   1212: idiv
    //   1213: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1216: aastore
    //   1217: invokevirtual 683	baif:notifyUI	(IZLjava/lang/Object;)V
    //   1220: lload 8
    //   1222: lstore 6
    //   1224: goto -73 -> 1151
    //   1227: aload_0
    //   1228: astore 10
    //   1230: aload_0
    //   1231: astore 11
    //   1233: aload_1
    //   1234: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1237: aload_0
    //   1238: astore 10
    //   1240: aload_0
    //   1241: astore 11
    //   1243: iconst_1
    //   1244: newarray int
    //   1246: astore 12
    //   1248: aload 12
    //   1250: iconst_0
    //   1251: bipush 50
    //   1253: iastore
    //   1254: aload_0
    //   1255: astore 10
    //   1257: aload_0
    //   1258: astore 11
    //   1260: aload 15
    //   1262: iconst_4
    //   1263: iconst_1
    //   1264: iconst_1
    //   1265: anewarray 4	java/lang/Object
    //   1268: dup
    //   1269: iconst_0
    //   1270: aload 12
    //   1272: iconst_0
    //   1273: iaload
    //   1274: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: invokevirtual 683	baif:notifyUI	(IZLjava/lang/Object;)V
    //   1281: aload_0
    //   1282: astore 10
    //   1284: aload_0
    //   1285: astore 11
    //   1287: new 690	java/util/Timer
    //   1290: dup
    //   1291: invokespecial 694	java/util/Timer:<init>	()V
    //   1294: astore_1
    //   1295: aload_1
    //   1296: new 696	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1
    //   1299: dup
    //   1300: aload 12
    //   1302: aload 15
    //   1304: invokespecial 699	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1:<init>	([ILbaif;)V
    //   1307: lconst_0
    //   1308: ldc2_w 314
    //   1311: invokevirtual 703	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   1314: aload_2
    //   1315: new 55	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1322: ldc_w 519
    //   1325: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: ldc 177
    //   1330: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 521
    //   1336: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1345: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1348: aload_2
    //   1349: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1352: aload_2
    //   1353: invokevirtual 513	java/io/OutputStream:close	()V
    //   1356: new 457	java/lang/StringBuffer
    //   1359: dup
    //   1360: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   1363: astore 10
    //   1365: aload_0
    //   1366: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1369: istore_3
    //   1370: iload_3
    //   1371: sipush 200
    //   1374: if_icmpeq +35 -> 1409
    //   1377: ldc 38
    //   1379: iconst_1
    //   1380: new 55	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 526
    //   1390: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: iload_3
    //   1394: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1397: ldc_w 528
    //   1400: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: new 532	java/io/BufferedReader
    //   1412: dup
    //   1413: new 534	java/io/InputStreamReader
    //   1416: dup
    //   1417: aload_0
    //   1418: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1421: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1424: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1427: astore_2
    //   1428: aload_2
    //   1429: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1432: astore 11
    //   1434: aload 11
    //   1436: ifnull +135 -> 1571
    //   1439: aload 10
    //   1441: aload 11
    //   1443: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1446: ldc_w 543
    //   1449: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1452: pop
    //   1453: goto -25 -> 1428
    //   1456: astore_2
    //   1457: goto -701 -> 756
    //   1460: astore 10
    //   1462: ldc 38
    //   1464: iconst_1
    //   1465: new 55	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1472: ldc_w 498
    //   1475: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: aload 16
    //   1480: invokevirtual 501	java/io/File:length	()J
    //   1483: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1486: ldc_w 506
    //   1489: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload 16
    //   1494: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1497: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1506: aload_2
    //   1507: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1510: aload_2
    //   1511: invokevirtual 513	java/io/OutputStream:close	()V
    //   1514: aload_0
    //   1515: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1518: aconst_null
    //   1519: astore 11
    //   1521: aconst_null
    //   1522: astore 10
    //   1524: aload_1
    //   1525: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1528: iconst_0
    //   1529: ifeq +11 -> 1540
    //   1532: new 516	java/lang/NullPointerException
    //   1535: dup
    //   1536: invokespecial 517	java/lang/NullPointerException:<init>	()V
    //   1539: athrow
    //   1540: iconst_0
    //   1541: ifeq -1519 -> 22
    //   1544: new 516	java/lang/NullPointerException
    //   1547: dup
    //   1548: invokespecial 517	java/lang/NullPointerException:<init>	()V
    //   1551: athrow
    //   1552: astore_2
    //   1553: aload_0
    //   1554: astore 10
    //   1556: aload_0
    //   1557: astore 11
    //   1559: aload_1
    //   1560: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1563: aload_0
    //   1564: astore 10
    //   1566: aload_0
    //   1567: astore 11
    //   1569: aload_2
    //   1570: athrow
    //   1571: aload 10
    //   1573: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1576: astore 10
    //   1578: aload_2
    //   1579: invokevirtual 544	java/io/BufferedReader:close	()V
    //   1582: aload 15
    //   1584: iconst_4
    //   1585: iconst_1
    //   1586: iconst_1
    //   1587: anewarray 4	java/lang/Object
    //   1590: dup
    //   1591: iconst_0
    //   1592: bipush 100
    //   1594: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: aastore
    //   1598: invokevirtual 683	baif:notifyUI	(IZLjava/lang/Object;)V
    //   1601: new 608	org/json/JSONObject
    //   1604: dup
    //   1605: aload 10
    //   1607: invokespecial 609	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1610: astore_2
    //   1611: aload_1
    //   1612: ifnull +7 -> 1619
    //   1615: aload_1
    //   1616: invokevirtual 693	java/util/Timer:cancel	()V
    //   1619: aload_0
    //   1620: ifnull +41 -> 1661
    //   1623: aload_0
    //   1624: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1627: aload_2
    //   1628: areturn
    //   1629: astore_2
    //   1630: aload_2
    //   1631: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   1634: aconst_null
    //   1635: astore_2
    //   1636: goto -25 -> 1611
    //   1639: astore 10
    //   1641: aload_1
    //   1642: astore_2
    //   1643: aload 10
    //   1645: astore_1
    //   1646: goto -744 -> 902
    //   1649: astore 10
    //   1651: aload_1
    //   1652: astore_2
    //   1653: aload 10
    //   1655: astore_1
    //   1656: goto -754 -> 902
    //   1659: aconst_null
    //   1660: areturn
    //   1661: aload_2
    //   1662: areturn
    //   1663: goto -439 -> 1224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1666	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1666	1	paramString1	String
    //   0	1666	2	paramString2	String
    //   1150	244	3	i	int
    //   1144	69	4	j	int
    //   1157	18	5	k	int
    //   1139	84	6	l1	long
    //   1182	39	8	l2	long
    //   105	1335	10	localObject1	Object
    //   1460	1	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1522	84	10	localObject2	Object
    //   1639	5	10	localObject3	Object
    //   1649	5	10	localObject4	Object
    //   108	1460	11	localObject5	Object
    //   98	1203	12	localObject6	Object
    //   117	743	13	localObject7	Object
    //   101	799	14	localObject8	Object
    //   34	1549	15	localbaif	baif
    //   93	1400	16	localFile	java.io.File
    //   83	576	17	str1	String
    //   131	747	18	localObject9	Object
    //   527	296	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   110	119	750	java/lang/Exception
    //   126	133	750	java/lang/Exception
    //   140	156	750	java/lang/Exception
    //   163	177	750	java/lang/Exception
    //   184	189	750	java/lang/Exception
    //   196	212	750	java/lang/Exception
    //   218	224	750	java/lang/Exception
    //   230	237	750	java/lang/Exception
    //   243	250	750	java/lang/Exception
    //   256	261	750	java/lang/Exception
    //   267	272	750	java/lang/Exception
    //   278	283	750	java/lang/Exception
    //   289	296	750	java/lang/Exception
    //   302	310	750	java/lang/Exception
    //   316	392	750	java/lang/Exception
    //   398	406	750	java/lang/Exception
    //   412	438	750	java/lang/Exception
    //   444	453	750	java/lang/Exception
    //   459	471	750	java/lang/Exception
    //   477	489	750	java/lang/Exception
    //   495	510	750	java/lang/Exception
    //   519	529	750	java/lang/Exception
    //   535	543	750	java/lang/Exception
    //   549	561	750	java/lang/Exception
    //   583	591	750	java/lang/Exception
    //   597	603	750	java/lang/Exception
    //   609	617	750	java/lang/Exception
    //   623	632	750	java/lang/Exception
    //   638	642	750	java/lang/Exception
    //   652	669	750	java/lang/Exception
    //   675	688	750	java/lang/Exception
    //   694	703	750	java/lang/Exception
    //   709	719	750	java/lang/Exception
    //   725	747	750	java/lang/Exception
    //   784	834	750	java/lang/Exception
    //   845	871	750	java/lang/Exception
    //   877	892	750	java/lang/Exception
    //   926	938	750	java/lang/Exception
    //   944	952	750	java/lang/Exception
    //   958	983	750	java/lang/Exception
    //   989	1029	750	java/lang/Exception
    //   1035	1068	750	java/lang/Exception
    //   1074	1085	750	java/lang/Exception
    //   1091	1115	750	java/lang/Exception
    //   1121	1128	750	java/lang/Exception
    //   1134	1141	750	java/lang/Exception
    //   1233	1237	750	java/lang/Exception
    //   1243	1248	750	java/lang/Exception
    //   1260	1281	750	java/lang/Exception
    //   1287	1295	750	java/lang/Exception
    //   1524	1528	750	java/lang/Exception
    //   1559	1563	750	java/lang/Exception
    //   1569	1571	750	java/lang/Exception
    //   110	119	895	finally
    //   126	133	895	finally
    //   140	156	895	finally
    //   163	177	895	finally
    //   184	189	895	finally
    //   196	212	895	finally
    //   218	224	895	finally
    //   230	237	895	finally
    //   243	250	895	finally
    //   256	261	895	finally
    //   267	272	895	finally
    //   278	283	895	finally
    //   289	296	895	finally
    //   302	310	895	finally
    //   316	392	895	finally
    //   398	406	895	finally
    //   412	438	895	finally
    //   444	453	895	finally
    //   459	471	895	finally
    //   477	489	895	finally
    //   495	510	895	finally
    //   519	529	895	finally
    //   535	543	895	finally
    //   549	561	895	finally
    //   583	591	895	finally
    //   597	603	895	finally
    //   609	617	895	finally
    //   623	632	895	finally
    //   638	642	895	finally
    //   652	669	895	finally
    //   675	688	895	finally
    //   694	703	895	finally
    //   709	719	895	finally
    //   725	747	895	finally
    //   784	834	895	finally
    //   845	871	895	finally
    //   877	892	895	finally
    //   926	938	895	finally
    //   944	952	895	finally
    //   958	983	895	finally
    //   989	1029	895	finally
    //   1035	1068	895	finally
    //   1074	1085	895	finally
    //   1091	1115	895	finally
    //   1121	1128	895	finally
    //   1134	1141	895	finally
    //   1233	1237	895	finally
    //   1243	1248	895	finally
    //   1260	1281	895	finally
    //   1287	1295	895	finally
    //   1524	1528	895	finally
    //   1559	1563	895	finally
    //   1569	1571	895	finally
    //   1295	1370	1456	java/lang/Exception
    //   1377	1409	1456	java/lang/Exception
    //   1409	1428	1456	java/lang/Exception
    //   1428	1434	1456	java/lang/Exception
    //   1439	1453	1456	java/lang/Exception
    //   1571	1601	1456	java/lang/Exception
    //   1630	1634	1456	java/lang/Exception
    //   1151	1159	1460	java/lang/OutOfMemoryError
    //   1170	1184	1460	java/lang/OutOfMemoryError
    //   1196	1220	1460	java/lang/OutOfMemoryError
    //   1151	1159	1552	finally
    //   1170	1184	1552	finally
    //   1196	1220	1552	finally
    //   1462	1518	1552	finally
    //   1601	1611	1629	java/lang/Exception
    //   1295	1370	1639	finally
    //   1377	1409	1639	finally
    //   1409	1428	1639	finally
    //   1428	1434	1639	finally
    //   1439	1453	1639	finally
    //   1571	1601	1639	finally
    //   1601	1611	1639	finally
    //   1630	1634	1639	finally
    //   756	760	1649	finally
  }
  
  public static String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramTeamWorkFileImportInfo.f)) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    String str = UUID.randomUUID().toString().replaceAll("-", "");
    StringBuilder localStringBuilder = new StringBuilder().append("TOK=").append(str);
    Object localObject2 = paramTeamWorkFileImportInfo.f;
    try
    {
      localObject1 = URLEncoder.encode((String)localObject2, "UTF-8");
      localObject2 = new StringBuilder("https://docs.qq.com/cgi-go/imp/import_url2doc").append("?xsrf=").append(str);
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString)) {
        ((StringBuilder)localObject2).append("&folderId=").append(paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString);
      }
      ((StringBuilder)localObject2).append("&url=").append((String)localObject1);
      return a(paramString, ((StringBuilder)localObject2).toString(), "docs.qq.com", localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("TeamWorkHttpUtils", 2, "url2Doc error", localThrowable);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, null, null, false);
  }
  
  public static String b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, null, null, true);
  }
  
  /* Error */
  public static final String c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 363	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   10: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +16 -> 36
    //   23: ldc 38
    //   25: iconst_1
    //   26: ldc_w 365
    //   29: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_3
    //   35: areturn
    //   36: new 55	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: new 341	java/io/File
    //   48: dup
    //   49: aload_0
    //   50: getfield 363	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   53: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 7
    //   58: aload_0
    //   59: getfield 660	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore_3
    //   63: aload 7
    //   65: ifnull +590 -> 655
    //   68: aload 7
    //   70: invokevirtual 368	java/io/File:exists	()Z
    //   73: ifeq +582 -> 655
    //   76: aload 4
    //   78: ldc_w 372
    //   81: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 724	bagj:n	Ljava/lang/String;
    //   91: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +16 -> 115
    //   102: aload 4
    //   104: ldc_w 662
    //   107: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 8
    //   122: aload 6
    //   124: astore 4
    //   126: new 69	bafw
    //   129: dup
    //   130: invokespecial 70	bafw:<init>	()V
    //   133: astore_3
    //   134: aload 6
    //   136: astore 4
    //   138: ldc 72
    //   140: invokestatic 78	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   143: astore 9
    //   145: aload 6
    //   147: astore 4
    //   149: aload 9
    //   151: aconst_null
    //   152: iconst_1
    //   153: anewarray 80	javax/net/ssl/TrustManager
    //   156: dup
    //   157: iconst_0
    //   158: aload_3
    //   159: aastore
    //   160: aconst_null
    //   161: invokevirtual 84	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   164: aload 6
    //   166: astore 4
    //   168: new 86	bafy
    //   171: dup
    //   172: aload 9
    //   174: invokevirtual 90	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   177: invokespecial 93	bafy:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   180: astore 9
    //   182: aload 6
    //   184: astore 4
    //   186: aload 9
    //   188: invokestatic 98	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   191: aload 6
    //   193: astore 4
    //   195: new 100	java/net/URL
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   204: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   207: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   210: astore_3
    //   211: aload_3
    //   212: aload 9
    //   214: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   217: aload_3
    //   218: sipush 5000
    //   221: invokevirtual 114	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   224: aload_3
    //   225: sipush 30000
    //   228: invokevirtual 117	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   231: aload_3
    //   232: iconst_1
    //   233: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   236: aload_3
    //   237: iconst_1
    //   238: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   241: aload_3
    //   242: iconst_0
    //   243: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   246: aload_3
    //   247: ldc_w 430
    //   250: invokevirtual 132	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   253: aload_3
    //   254: ldc 134
    //   256: ldc 136
    //   258: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: ldc 142
    //   264: new 55	java/lang/StringBuilder
    //   267: dup
    //   268: ldc 144
    //   270: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: ldc 147
    //   275: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: getstatic 153	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   281: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 147
    //   286: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: getstatic 158	android/os/Build:DEVICE	Ljava/lang/String;
    //   292: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 147
    //   297: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: getstatic 161	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   303: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 147
    //   308: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 163
    //   313: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 147
    //   318: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 165
    //   323: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 167
    //   328: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_3
    //   338: ldc 169
    //   340: ldc 171
    //   342: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: ldc 173
    //   348: new 55	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   355: ldc 175
    //   357: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc 177
    //   362: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: new 179	java/util/HashMap
    //   374: dup
    //   375: invokespecial 180	java/util/HashMap:<init>	()V
    //   378: astore 9
    //   380: aload 9
    //   382: ldc 134
    //   384: ldc 182
    //   386: invokeinterface 188 3 0
    //   391: pop
    //   392: aload 9
    //   394: ldc 190
    //   396: aload 8
    //   398: invokeinterface 188 3 0
    //   403: pop
    //   404: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   407: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   410: iconst_2
    //   411: invokevirtual 206	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   414: checkcast 208	mqq/manager/TicketManager
    //   417: astore 4
    //   419: aload 4
    //   421: aload_1
    //   422: invokeinterface 212 2 0
    //   427: astore 10
    //   429: aload 8
    //   431: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   434: ifne +802 -> 1236
    //   437: aload 4
    //   439: aload_1
    //   440: ldc 214
    //   442: invokeinterface 218 3 0
    //   447: astore 4
    //   449: aload 7
    //   451: ifnull +780 -> 1231
    //   454: aload 7
    //   456: invokevirtual 368	java/io/File:exists	()Z
    //   459: ifeq +772 -> 1231
    //   462: aload_0
    //   463: getfield 363	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   466: invokestatic 370	bahp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_0
    //   470: aload 4
    //   472: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifeq +191 -> 666
    //   478: ldc 38
    //   480: iconst_1
    //   481: ldc_w 432
    //   484: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: invokestatic 225	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   490: astore_0
    //   491: aload_0
    //   492: ifnull +20 -> 512
    //   495: aload 9
    //   497: ldc_w 282
    //   500: aload_0
    //   501: aload 8
    //   503: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokeinterface 188 3 0
    //   511: pop
    //   512: aload 9
    //   514: invokeinterface 234 1 0
    //   519: invokeinterface 240 1 0
    //   524: astore_1
    //   525: aload_1
    //   526: invokeinterface 245 1 0
    //   531: ifeq +248 -> 779
    //   534: aload_1
    //   535: invokeinterface 249 1 0
    //   540: checkcast 251	java/util/Map$Entry
    //   543: astore_0
    //   544: aload_3
    //   545: aload_0
    //   546: invokeinterface 254 1 0
    //   551: checkcast 256	java/lang/String
    //   554: aload_0
    //   555: invokeinterface 259 1 0
    //   560: checkcast 256	java/lang/String
    //   563: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: goto -41 -> 525
    //   569: astore 4
    //   571: aconst_null
    //   572: astore_0
    //   573: aload_3
    //   574: astore_1
    //   575: aload 4
    //   577: astore_3
    //   578: aload_1
    //   579: astore 4
    //   581: ldc_w 261
    //   584: iconst_1
    //   585: new 55	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 434
    //   595: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_3
    //   599: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   602: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: astore_3
    //   613: aload_1
    //   614: ifnull -580 -> 34
    //   617: aload_1
    //   618: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   621: aload_0
    //   622: areturn
    //   623: astore_0
    //   624: ldc 38
    //   626: iconst_1
    //   627: new 55	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 436
    //   637: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload_0
    //   641: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   644: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aconst_null
    //   654: areturn
    //   655: ldc 38
    //   657: iconst_1
    //   658: ldc_w 438
    //   661: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aconst_null
    //   665: areturn
    //   666: new 55	java/lang/StringBuilder
    //   669: dup
    //   670: new 55	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 440
    //   680: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload 4
    //   685: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc_w 442
    //   691: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_1
    //   695: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 444
    //   701: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 10
    //   706: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   715: astore_1
    //   716: aload_0
    //   717: ifnull +28 -> 745
    //   720: aload_1
    //   721: new 55	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 446
    //   731: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_0
    //   735: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 9
    //   747: ldc_w 282
    //   750: aload_1
    //   751: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokeinterface 188 3 0
    //   759: pop
    //   760: goto -248 -> 512
    //   763: astore_0
    //   764: aload_3
    //   765: astore 4
    //   767: aload 4
    //   769: ifnull +8 -> 777
    //   772: aload 4
    //   774: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   777: aload_0
    //   778: athrow
    //   779: new 448	java/io/DataOutputStream
    //   782: dup
    //   783: aload_3
    //   784: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   787: invokespecial 455	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   790: astore_1
    //   791: new 457	java/lang/StringBuffer
    //   794: dup
    //   795: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   798: astore_0
    //   799: aload_0
    //   800: ldc_w 460
    //   803: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   806: ldc_w 465
    //   809: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   812: ldc 177
    //   814: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   817: ldc_w 460
    //   820: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   823: pop
    //   824: aload_0
    //   825: ldc_w 467
    //   828: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   831: ldc_w 469
    //   834: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   837: ldc_w 471
    //   840: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   843: aload 7
    //   845: invokevirtual 381	java/io/File:getName	()Ljava/lang/String;
    //   848: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   851: ldc_w 726
    //   854: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   857: pop
    //   858: aload_0
    //   859: new 55	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 475
    //   869: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 477
    //   875: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: ldc_w 479
    //   881: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   890: pop
    //   891: aload_1
    //   892: aload_0
    //   893: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   896: invokevirtual 483	java/lang/String:getBytes	()[B
    //   899: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   902: new 488	java/io/BufferedInputStream
    //   905: dup
    //   906: new 488	java/io/BufferedInputStream
    //   909: dup
    //   910: new 490	java/io/FileInputStream
    //   913: dup
    //   914: aload 7
    //   916: invokespecial 491	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   919: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   922: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   925: astore_0
    //   926: sipush 3072
    //   929: newarray byte
    //   931: astore 4
    //   933: aload_0
    //   934: aload 4
    //   936: invokevirtual 495	java/io/BufferedInputStream:read	([B)I
    //   939: istore_2
    //   940: iload_2
    //   941: iconst_m1
    //   942: if_icmpeq +94 -> 1036
    //   945: aload_1
    //   946: aload 4
    //   948: iconst_0
    //   949: iload_2
    //   950: invokevirtual 496	java/io/OutputStream:write	([BII)V
    //   953: goto -20 -> 933
    //   956: astore 4
    //   958: ldc 38
    //   960: iconst_1
    //   961: new 55	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   968: ldc_w 498
    //   971: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 7
    //   976: invokevirtual 501	java/io/File:length	()J
    //   979: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   982: ldc_w 506
    //   985: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload 7
    //   990: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   993: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1002: aload_1
    //   1003: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1006: aload_1
    //   1007: invokevirtual 513	java/io/OutputStream:close	()V
    //   1010: aload_3
    //   1011: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1014: aload 6
    //   1016: astore 4
    //   1018: aload_0
    //   1019: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1022: iconst_0
    //   1023: ifeq +11 -> 1034
    //   1026: new 516	java/lang/NullPointerException
    //   1029: dup
    //   1030: invokespecial 517	java/lang/NullPointerException:<init>	()V
    //   1033: athrow
    //   1034: aconst_null
    //   1035: areturn
    //   1036: aload_0
    //   1037: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1040: aload_1
    //   1041: new 55	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 519
    //   1051: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc 177
    //   1056: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc_w 521
    //   1062: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1071: invokevirtual 486	java/io/OutputStream:write	([B)V
    //   1074: aload_1
    //   1075: invokevirtual 512	java/io/OutputStream:flush	()V
    //   1078: aload_1
    //   1079: invokevirtual 513	java/io/OutputStream:close	()V
    //   1082: new 457	java/lang/StringBuffer
    //   1085: dup
    //   1086: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   1089: astore 4
    //   1091: aload_3
    //   1092: invokevirtual 524	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1095: istore_2
    //   1096: iload_2
    //   1097: sipush 200
    //   1100: if_icmpeq +35 -> 1135
    //   1103: ldc 38
    //   1105: iconst_1
    //   1106: new 55	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 526
    //   1116: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: iload_2
    //   1120: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1123: ldc_w 528
    //   1126: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: new 532	java/io/BufferedReader
    //   1138: dup
    //   1139: new 534	java/io/InputStreamReader
    //   1142: dup
    //   1143: aload_3
    //   1144: invokevirtual 295	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1147: invokespecial 535	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1150: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1153: astore_1
    //   1154: aload_1
    //   1155: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1158: astore_0
    //   1159: aload_0
    //   1160: ifnull +26 -> 1186
    //   1163: aload 4
    //   1165: aload_0
    //   1166: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1169: ldc_w 543
    //   1172: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1175: pop
    //   1176: goto -22 -> 1154
    //   1179: astore_1
    //   1180: aload_0
    //   1181: invokevirtual 514	java/io/BufferedInputStream:close	()V
    //   1184: aload_1
    //   1185: athrow
    //   1186: aload 4
    //   1188: invokevirtual 480	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1191: astore_0
    //   1192: aload_1
    //   1193: invokevirtual 544	java/io/BufferedReader:close	()V
    //   1196: aload_3
    //   1197: ifnull +32 -> 1229
    //   1200: aload_3
    //   1201: invokevirtual 280	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1204: aload_0
    //   1205: areturn
    //   1206: astore_0
    //   1207: goto -440 -> 767
    //   1210: astore_3
    //   1211: aconst_null
    //   1212: astore_0
    //   1213: aload 5
    //   1215: astore_1
    //   1216: goto -638 -> 578
    //   1219: astore 4
    //   1221: aload_3
    //   1222: astore_1
    //   1223: aload 4
    //   1225: astore_3
    //   1226: goto -648 -> 578
    //   1229: aload_0
    //   1230: areturn
    //   1231: aconst_null
    //   1232: astore_0
    //   1233: goto -763 -> 470
    //   1236: aconst_null
    //   1237: astore 4
    //   1239: goto -790 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1242	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1242	1	paramString	String
    //   939	181	2	i	int
    //   33	1168	3	localObject1	Object
    //   1210	12	3	localException1	java.lang.Exception
    //   1225	1	3	localObject2	Object
    //   43	428	4	localObject3	Object
    //   569	7	4	localException2	java.lang.Exception
    //   579	368	4	localObject4	Object
    //   956	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1016	171	4	localObject5	Object
    //   1219	5	4	localException3	java.lang.Exception
    //   1237	1	4	localObject6	Object
    //   4	1210	5	localObject7	Object
    //   1	1014	6	localObject8	Object
    //   56	933	7	localFile	java.io.File
    //   120	382	8	str1	String
    //   143	603	9	localObject9	Object
    //   427	278	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   211	449	569	java/lang/Exception
    //   454	470	569	java/lang/Exception
    //   470	491	569	java/lang/Exception
    //   495	512	569	java/lang/Exception
    //   512	525	569	java/lang/Exception
    //   525	566	569	java/lang/Exception
    //   666	716	569	java/lang/Exception
    //   720	745	569	java/lang/Exception
    //   745	760	569	java/lang/Exception
    //   779	933	569	java/lang/Exception
    //   1036	1096	569	java/lang/Exception
    //   1103	1135	569	java/lang/Exception
    //   1135	1154	569	java/lang/Exception
    //   1154	1159	569	java/lang/Exception
    //   1163	1176	569	java/lang/Exception
    //   1180	1186	569	java/lang/Exception
    //   1186	1192	569	java/lang/Exception
    //   76	115	623	java/lang/Exception
    //   211	449	763	finally
    //   454	470	763	finally
    //   470	491	763	finally
    //   495	512	763	finally
    //   512	525	763	finally
    //   525	566	763	finally
    //   666	716	763	finally
    //   720	745	763	finally
    //   745	760	763	finally
    //   779	933	763	finally
    //   1036	1096	763	finally
    //   1103	1135	763	finally
    //   1135	1154	763	finally
    //   1154	1159	763	finally
    //   1163	1176	763	finally
    //   1180	1186	763	finally
    //   1186	1192	763	finally
    //   1192	1196	763	finally
    //   933	940	956	java/lang/OutOfMemoryError
    //   945	953	956	java/lang/OutOfMemoryError
    //   933	940	1179	finally
    //   945	953	1179	finally
    //   958	1014	1179	finally
    //   126	134	1206	finally
    //   138	145	1206	finally
    //   149	164	1206	finally
    //   168	182	1206	finally
    //   186	191	1206	finally
    //   195	211	1206	finally
    //   581	611	1206	finally
    //   1018	1022	1206	finally
    //   126	134	1210	java/lang/Exception
    //   138	145	1210	java/lang/Exception
    //   149	164	1210	java/lang/Exception
    //   168	182	1210	java/lang/Exception
    //   186	191	1210	java/lang/Exception
    //   195	211	1210	java/lang/Exception
    //   1018	1022	1210	java/lang/Exception
    //   1192	1196	1219	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahp
 * JD-Core Version:    0.7.0.1
 */