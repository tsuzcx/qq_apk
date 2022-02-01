import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class bebo
{
  private static long a()
  {
    boolean bool = bhjr.a();
    long l1 = bhjr.a();
    long l2 = bhjr.b();
    if ((bool) && (l1 != 0L)) {
      return l1 * 1024L;
    }
    return l2 * 1024L;
  }
  
  /* Error */
  public static final String a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +11 -> 15
    //   7: aload 5
    //   9: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: ldc 32
    //   17: iconst_1
    //   18: ldc 34
    //   20: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: sipush 142
    //   29: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   32: checkcast 47	beaq
    //   35: astore 14
    //   37: new 49	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   44: astore_0
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: new 63	bdzv
    //   61: dup
    //   62: invokespecial 64	bdzv:<init>	()V
    //   65: astore 13
    //   67: ldc 66
    //   69: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   72: astore 15
    //   74: aload 15
    //   76: aconst_null
    //   77: iconst_1
    //   78: anewarray 74	javax/net/ssl/TrustManager
    //   81: dup
    //   82: iconst_0
    //   83: aload 13
    //   85: aastore
    //   86: aconst_null
    //   87: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   90: new 80	bdzx
    //   93: dup
    //   94: aload 15
    //   96: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   99: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   102: astore 15
    //   104: aload 15
    //   106: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   109: new 94	java/net/URL
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   120: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   123: astore 13
    //   125: aload 13
    //   127: aload 15
    //   129: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   132: aload 13
    //   134: sipush 5000
    //   137: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   140: aload 13
    //   142: sipush 30000
    //   145: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   148: aload 13
    //   150: iconst_1
    //   151: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   154: aload 13
    //   156: iconst_1
    //   157: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   160: aload 13
    //   162: iconst_0
    //   163: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   166: aload 13
    //   168: ldc 123
    //   170: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload 13
    //   175: ldc 128
    //   177: ldc 130
    //   179: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 13
    //   184: ldc 136
    //   186: new 49	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 138
    //   192: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: ldc 141
    //   197: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   203: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 141
    //   208: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   214: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 141
    //   219: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   225: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 141
    //   230: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 157
    //   235: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 141
    //   240: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 159
    //   245: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 161
    //   250: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 13
    //   261: ldc 163
    //   263: ldc 165
    //   265: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 13
    //   270: ldc 167
    //   272: new 49	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   279: ldc 169
    //   281: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 171
    //   286: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: new 173	java/util/HashMap
    //   298: dup
    //   299: invokespecial 174	java/util/HashMap:<init>	()V
    //   302: astore 15
    //   304: aload 15
    //   306: ldc 128
    //   308: ldc 176
    //   310: invokeinterface 182 3 0
    //   315: pop
    //   316: aload 15
    //   318: ldc 184
    //   320: aload_3
    //   321: invokeinterface 182 3 0
    //   326: pop
    //   327: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   330: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   333: iconst_2
    //   334: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   337: checkcast 202	mqq/manager/TicketManager
    //   340: astore_0
    //   341: aload_0
    //   342: aload 5
    //   344: invokeinterface 206 2 0
    //   349: pop
    //   350: aload_1
    //   351: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +685 -> 1039
    //   357: aload_0
    //   358: aload 5
    //   360: ldc 208
    //   362: invokeinterface 212 3 0
    //   367: astore_0
    //   368: aload_0
    //   369: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +159 -> 531
    //   375: ldc 32
    //   377: iconst_1
    //   378: ldc 214
    //   380: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +18 -> 406
    //   391: aload 15
    //   393: ldc 221
    //   395: aload_0
    //   396: aload_1
    //   397: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokeinterface 182 3 0
    //   405: pop
    //   406: aload 15
    //   408: invokeinterface 228 1 0
    //   413: invokeinterface 234 1 0
    //   418: astore_0
    //   419: aload_0
    //   420: invokeinterface 239 1 0
    //   425: ifeq +146 -> 571
    //   428: aload_0
    //   429: invokeinterface 243 1 0
    //   434: checkcast 245	java/util/Map$Entry
    //   437: astore_1
    //   438: aload 13
    //   440: aload_1
    //   441: invokeinterface 248 1 0
    //   446: checkcast 250	java/lang/String
    //   449: aload_1
    //   450: invokeinterface 253 1 0
    //   455: checkcast 250	java/lang/String
    //   458: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -42 -> 419
    //   464: astore_1
    //   465: aload 13
    //   467: astore_0
    //   468: ldc 255
    //   470: iconst_1
    //   471: new 49	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 257
    //   481: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   488: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload 14
    //   499: iconst_1
    //   500: iconst_1
    //   501: iconst_2
    //   502: anewarray 4	java/lang/Object
    //   505: dup
    //   506: iconst_0
    //   507: ldc_w 262
    //   510: invokestatic 267	anzj:a	(I)Ljava/lang/String;
    //   513: aastore
    //   514: dup
    //   515: iconst_1
    //   516: aload_3
    //   517: aastore
    //   518: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   521: aload_0
    //   522: ifnull +7 -> 529
    //   525: aload_0
    //   526: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   529: aconst_null
    //   530: areturn
    //   531: aload 15
    //   533: ldc_w 276
    //   536: new 49	java/lang/StringBuilder
    //   539: dup
    //   540: aload 4
    //   542: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokeinterface 182 3 0
    //   553: pop
    //   554: goto -148 -> 406
    //   557: astore_0
    //   558: aload 13
    //   560: astore_1
    //   561: aload_1
    //   562: ifnull +7 -> 569
    //   565: aload_1
    //   566: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   569: aload_0
    //   570: athrow
    //   571: aload 13
    //   573: invokevirtual 279	javax/net/ssl/HttpsURLConnection:connect	()V
    //   576: aload 13
    //   578: invokevirtual 283	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   581: istore 7
    //   583: invokestatic 284	bebo:a	()J
    //   586: lstore 9
    //   588: iload 7
    //   590: i2l
    //   591: lload 9
    //   593: lcmp
    //   594: ifle +40 -> 634
    //   597: aload 14
    //   599: iconst_1
    //   600: iconst_1
    //   601: iconst_2
    //   602: anewarray 4	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: ldc_w 285
    //   610: invokestatic 267	anzj:a	(I)Ljava/lang/String;
    //   613: aastore
    //   614: dup
    //   615: iconst_1
    //   616: aload_3
    //   617: aastore
    //   618: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   621: aload 13
    //   623: ifnull -94 -> 529
    //   626: aload 13
    //   628: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   631: goto -102 -> 529
    //   634: aload 13
    //   636: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   639: astore 4
    //   641: new 291	java/io/ByteArrayOutputStream
    //   644: dup
    //   645: invokespecial 292	java/io/ByteArrayOutputStream:<init>	()V
    //   648: astore 5
    //   650: iconst_0
    //   651: istore 6
    //   653: sipush 10240
    //   656: newarray byte
    //   658: astore_0
    //   659: lconst_0
    //   660: lstore 9
    //   662: aload 4
    //   664: aload_0
    //   665: invokevirtual 298	java/io/InputStream:read	([B)I
    //   668: istore 8
    //   670: iload 8
    //   672: iconst_m1
    //   673: if_icmpeq +68 -> 741
    //   676: iload 6
    //   678: iload 8
    //   680: iadd
    //   681: istore 6
    //   683: aload 5
    //   685: aload_0
    //   686: iconst_0
    //   687: iload 8
    //   689: invokevirtual 302	java/io/ByteArrayOutputStream:write	([BII)V
    //   692: invokestatic 307	java/lang/System:currentTimeMillis	()J
    //   695: lstore 11
    //   697: lload 11
    //   699: lload 9
    //   701: lsub
    //   702: ldc2_w 308
    //   705: lcmp
    //   706: iflt +330 -> 1036
    //   709: aload 14
    //   711: iconst_4
    //   712: iconst_1
    //   713: iconst_1
    //   714: anewarray 4	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: iload 6
    //   721: bipush 100
    //   723: imul
    //   724: iload 7
    //   726: idiv
    //   727: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   730: aastore
    //   731: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   734: lload 11
    //   736: lstore 9
    //   738: goto +306 -> 1044
    //   741: aload 5
    //   743: invokevirtual 318	java/io/ByteArrayOutputStream:close	()V
    //   746: aload 5
    //   748: invokevirtual 322	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   751: astore 15
    //   753: new 49	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   760: getstatic 327	antf:bp	Ljava/lang/String;
    //   763: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload_2
    //   767: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 331	aunj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   776: astore_2
    //   777: new 333	java/io/FileOutputStream
    //   780: dup
    //   781: new 335	java/io/File
    //   784: dup
    //   785: aload_2
    //   786: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   789: invokespecial 339	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   792: astore_1
    //   793: aload_1
    //   794: astore_0
    //   795: aload_1
    //   796: aload 15
    //   798: invokevirtual 342	java/io/FileOutputStream:write	([B)V
    //   801: iload 6
    //   803: iload 7
    //   805: if_icmplt +55 -> 860
    //   808: aload_1
    //   809: astore_0
    //   810: aload 14
    //   812: iconst_3
    //   813: iconst_1
    //   814: iconst_2
    //   815: anewarray 4	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: aload_2
    //   821: aastore
    //   822: dup
    //   823: iconst_1
    //   824: aload_3
    //   825: aastore
    //   826: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   829: aload 5
    //   831: ifnull +8 -> 839
    //   834: aload 5
    //   836: invokevirtual 318	java/io/ByteArrayOutputStream:close	()V
    //   839: aload_1
    //   840: ifnull +7 -> 847
    //   843: aload_1
    //   844: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   847: aload 4
    //   849: ifnull -228 -> 621
    //   852: aload 4
    //   854: invokevirtual 344	java/io/InputStream:close	()V
    //   857: goto -236 -> 621
    //   860: aload_1
    //   861: astore_0
    //   862: aload 14
    //   864: iconst_1
    //   865: iconst_1
    //   866: iconst_2
    //   867: anewarray 4	java/lang/Object
    //   870: dup
    //   871: iconst_0
    //   872: ldc_w 345
    //   875: invokestatic 267	anzj:a	(I)Ljava/lang/String;
    //   878: aastore
    //   879: dup
    //   880: iconst_1
    //   881: aload_3
    //   882: aastore
    //   883: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   886: goto -57 -> 829
    //   889: astore_2
    //   890: aload_1
    //   891: astore_0
    //   892: ldc 255
    //   894: iconst_1
    //   895: new 49	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   902: ldc_w 347
    //   905: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload_2
    //   909: invokevirtual 348	java/io/IOException:toString	()Ljava/lang/String;
    //   912: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   921: aload_1
    //   922: astore_0
    //   923: aload 14
    //   925: iconst_1
    //   926: iconst_1
    //   927: iconst_2
    //   928: anewarray 4	java/lang/Object
    //   931: dup
    //   932: iconst_0
    //   933: ldc_w 349
    //   936: invokestatic 267	anzj:a	(I)Ljava/lang/String;
    //   939: aastore
    //   940: dup
    //   941: iconst_1
    //   942: aload_3
    //   943: aastore
    //   944: invokevirtual 271	beaq:notifyUI	(IZLjava/lang/Object;)V
    //   947: aload 5
    //   949: ifnull +8 -> 957
    //   952: aload 5
    //   954: invokevirtual 318	java/io/ByteArrayOutputStream:close	()V
    //   957: aload_1
    //   958: ifnull +7 -> 965
    //   961: aload_1
    //   962: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   965: aload 4
    //   967: ifnull -346 -> 621
    //   970: aload 4
    //   972: invokevirtual 344	java/io/InputStream:close	()V
    //   975: goto -354 -> 621
    //   978: aload 5
    //   980: ifnull +8 -> 988
    //   983: aload 5
    //   985: invokevirtual 318	java/io/ByteArrayOutputStream:close	()V
    //   988: aload_0
    //   989: ifnull +7 -> 996
    //   992: aload_0
    //   993: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   996: aload 4
    //   998: ifnull +8 -> 1006
    //   1001: aload 4
    //   1003: invokevirtual 344	java/io/InputStream:close	()V
    //   1006: aload_1
    //   1007: athrow
    //   1008: astore_0
    //   1009: aconst_null
    //   1010: astore_1
    //   1011: goto -450 -> 561
    //   1014: astore_2
    //   1015: aload_0
    //   1016: astore_1
    //   1017: aload_2
    //   1018: astore_0
    //   1019: goto -458 -> 561
    //   1022: astore_1
    //   1023: goto -555 -> 468
    //   1026: astore_1
    //   1027: goto -49 -> 978
    //   1030: astore_2
    //   1031: aconst_null
    //   1032: astore_1
    //   1033: goto -143 -> 890
    //   1036: goto +8 -> 1044
    //   1039: aconst_null
    //   1040: astore_0
    //   1041: goto -673 -> 368
    //   1044: goto -382 -> 662
    //   1047: astore_1
    //   1048: aconst_null
    //   1049: astore_0
    //   1050: goto -72 -> 978
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1053	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1053	1	paramString1	String
    //   0	1053	2	paramString2	String
    //   0	1053	3	paramString3	String
    //   0	1053	4	paramString4	String
    //   0	1053	5	paramString5	String
    //   651	155	6	i	int
    //   581	225	7	j	int
    //   668	20	8	k	int
    //   586	151	9	l1	long
    //   695	40	11	l2	long
    //   65	570	13	localObject1	Object
    //   35	889	14	localbeaq	beaq
    //   72	725	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   125	368	464	java/lang/Exception
    //   368	387	464	java/lang/Exception
    //   391	406	464	java/lang/Exception
    //   406	419	464	java/lang/Exception
    //   419	461	464	java/lang/Exception
    //   531	554	464	java/lang/Exception
    //   571	588	464	java/lang/Exception
    //   597	621	464	java/lang/Exception
    //   634	650	464	java/lang/Exception
    //   834	839	464	java/lang/Exception
    //   843	847	464	java/lang/Exception
    //   852	857	464	java/lang/Exception
    //   952	957	464	java/lang/Exception
    //   961	965	464	java/lang/Exception
    //   970	975	464	java/lang/Exception
    //   983	988	464	java/lang/Exception
    //   992	996	464	java/lang/Exception
    //   1001	1006	464	java/lang/Exception
    //   1006	1008	464	java/lang/Exception
    //   125	368	557	finally
    //   368	387	557	finally
    //   391	406	557	finally
    //   406	419	557	finally
    //   419	461	557	finally
    //   531	554	557	finally
    //   571	588	557	finally
    //   597	621	557	finally
    //   634	650	557	finally
    //   834	839	557	finally
    //   843	847	557	finally
    //   852	857	557	finally
    //   952	957	557	finally
    //   961	965	557	finally
    //   970	975	557	finally
    //   983	988	557	finally
    //   992	996	557	finally
    //   1001	1006	557	finally
    //   1006	1008	557	finally
    //   795	801	889	java/io/IOException
    //   810	829	889	java/io/IOException
    //   862	886	889	java/io/IOException
    //   58	125	1008	finally
    //   468	521	1014	finally
    //   58	125	1022	java/lang/Exception
    //   795	801	1026	finally
    //   810	829	1026	finally
    //   862	886	1026	finally
    //   892	921	1026	finally
    //   923	947	1026	finally
    //   653	659	1030	java/io/IOException
    //   662	670	1030	java/io/IOException
    //   683	697	1030	java/io/IOException
    //   709	734	1030	java/io/IOException
    //   741	793	1030	java/io/IOException
    //   653	659	1047	finally
    //   662	670	1047	finally
    //   683	697	1047	finally
    //   709	734	1047	finally
    //   741	793	1047	finally
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
    //   11: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   14: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +10 -> 27
    //   20: aload_1
    //   21: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +16 -> 40
    //   27: ldc 32
    //   29: iconst_1
    //   30: ldc_w 359
    //   33: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: areturn
    //   40: aload_0
    //   41: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   44: astore 5
    //   46: new 49	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   53: astore 9
    //   55: new 335	java/io/File
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 8
    //   66: aload 8
    //   68: ifnull +696 -> 764
    //   71: aload 8
    //   73: invokevirtual 362	java/io/File:exists	()Z
    //   76: ifeq +688 -> 764
    //   79: aload 5
    //   81: invokestatic 364	bebo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload 9
    //   87: ldc_w 366
    //   90: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 368
    //   100: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 370
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 372
    //   116: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 8
    //   121: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   124: ldc_w 377
    //   127: invokestatic 382	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 384
    //   136: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 386
    //   142: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 388
    //   148: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: astore 4
    //   153: aload_0
    //   154: getfield 391	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   157: ifnull +8 -> 165
    //   160: aload_0
    //   161: getfield 391	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   164: astore_3
    //   165: aload 4
    //   167: aload_3
    //   168: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 393
    //   174: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 397	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:i	I
    //   181: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc_w 402
    //   187: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 405	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   194: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: invokestatic 410	beaj:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   202: ifeq +22 -> 224
    //   205: aload 9
    //   207: ldc_w 412
    //   210: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 414	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:a	Ljava/lang/String;
    //   217: invokestatic 419	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   220: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 9
    //   226: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 9
    //   231: aload 7
    //   233: astore 4
    //   235: new 63	bdzv
    //   238: dup
    //   239: invokespecial 64	bdzv:<init>	()V
    //   242: astore 10
    //   244: aload 7
    //   246: astore 4
    //   248: ldc 66
    //   250: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   253: astore_3
    //   254: aload 7
    //   256: astore 4
    //   258: aload_3
    //   259: aconst_null
    //   260: iconst_1
    //   261: anewarray 74	javax/net/ssl/TrustManager
    //   264: dup
    //   265: iconst_0
    //   266: aload 10
    //   268: aastore
    //   269: aconst_null
    //   270: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   273: aload 7
    //   275: astore 4
    //   277: new 80	bdzx
    //   280: dup
    //   281: aload_3
    //   282: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   285: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   288: astore 10
    //   290: aload 7
    //   292: astore 4
    //   294: aload 10
    //   296: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   299: aload 7
    //   301: astore 4
    //   303: new 94	java/net/URL
    //   306: dup
    //   307: aload 9
    //   309: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   312: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   315: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   318: astore_3
    //   319: aload_3
    //   320: aload 10
    //   322: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   325: aload_3
    //   326: sipush 5000
    //   329: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   332: aload_3
    //   333: sipush 30000
    //   336: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   339: aload_3
    //   340: iconst_1
    //   341: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   344: aload_3
    //   345: iconst_1
    //   346: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   349: aload_3
    //   350: iconst_0
    //   351: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   354: aload_3
    //   355: ldc_w 424
    //   358: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   361: aload_3
    //   362: ldc 128
    //   364: ldc 130
    //   366: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_3
    //   370: ldc 136
    //   372: new 49	java/lang/StringBuilder
    //   375: dup
    //   376: ldc 138
    //   378: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: ldc 141
    //   383: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   389: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc 141
    //   394: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   400: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc 141
    //   405: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   411: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 141
    //   416: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc 157
    //   421: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc 141
    //   426: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc 159
    //   431: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 161
    //   436: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload_3
    //   446: ldc 163
    //   448: ldc 165
    //   450: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_3
    //   454: ldc 167
    //   456: new 49	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   463: ldc 169
    //   465: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 171
    //   470: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: new 173	java/util/HashMap
    //   482: dup
    //   483: invokespecial 174	java/util/HashMap:<init>	()V
    //   486: astore 10
    //   488: aload 10
    //   490: ldc 128
    //   492: ldc 176
    //   494: invokeinterface 182 3 0
    //   499: pop
    //   500: aload 10
    //   502: ldc 184
    //   504: aload 9
    //   506: invokeinterface 182 3 0
    //   511: pop
    //   512: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   515: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   518: iconst_2
    //   519: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   522: checkcast 202	mqq/manager/TicketManager
    //   525: astore 4
    //   527: aload 4
    //   529: aload_1
    //   530: invokeinterface 206 2 0
    //   535: astore 11
    //   537: aload 9
    //   539: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   542: ifne +820 -> 1362
    //   545: aload 4
    //   547: aload_1
    //   548: ldc 208
    //   550: invokeinterface 212 3 0
    //   555: astore 4
    //   557: aload 8
    //   559: ifnull +797 -> 1356
    //   562: aload 8
    //   564: invokevirtual 362	java/io/File:exists	()Z
    //   567: ifeq +789 -> 1356
    //   570: aload 5
    //   572: invokestatic 364	bebo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   575: astore 5
    //   577: aload 4
    //   579: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   582: ifeq +193 -> 775
    //   585: ldc 32
    //   587: iconst_1
    //   588: ldc_w 426
    //   591: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   597: astore_1
    //   598: aload_1
    //   599: ifnull +20 -> 619
    //   602: aload 10
    //   604: ldc_w 276
    //   607: aload_1
    //   608: aload 9
    //   610: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   613: invokeinterface 182 3 0
    //   618: pop
    //   619: aload 10
    //   621: invokeinterface 228 1 0
    //   626: invokeinterface 234 1 0
    //   631: astore 4
    //   633: aload 4
    //   635: invokeinterface 239 1 0
    //   640: ifeq +250 -> 890
    //   643: aload 4
    //   645: invokeinterface 243 1 0
    //   650: checkcast 245	java/util/Map$Entry
    //   653: astore_1
    //   654: aload_3
    //   655: aload_1
    //   656: invokeinterface 248 1 0
    //   661: checkcast 250	java/lang/String
    //   664: aload_1
    //   665: invokeinterface 253 1 0
    //   670: checkcast 250	java/lang/String
    //   673: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: goto -43 -> 633
    //   679: astore 4
    //   681: aconst_null
    //   682: astore_0
    //   683: aload_3
    //   684: astore_1
    //   685: aload 4
    //   687: astore_3
    //   688: aload_1
    //   689: astore 4
    //   691: ldc 255
    //   693: iconst_1
    //   694: new 49	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 428
    //   704: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload_3
    //   708: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   711: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: aload_0
    //   721: astore_3
    //   722: aload_1
    //   723: ifnull -685 -> 38
    //   726: aload_1
    //   727: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   730: aload_0
    //   731: areturn
    //   732: astore_0
    //   733: ldc 32
    //   735: iconst_1
    //   736: new 49	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 430
    //   746: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_0
    //   750: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   753: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aconst_null
    //   763: areturn
    //   764: ldc 32
    //   766: iconst_1
    //   767: ldc_w 432
    //   770: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: aconst_null
    //   774: areturn
    //   775: new 49	java/lang/StringBuilder
    //   778: dup
    //   779: new 49	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 434
    //   789: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload 4
    //   794: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc_w 436
    //   800: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload_1
    //   804: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc_w 438
    //   810: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload 11
    //   815: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   824: astore_1
    //   825: aload 5
    //   827: ifnull +29 -> 856
    //   830: aload_1
    //   831: new 49	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   838: ldc_w 440
    //   841: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload 5
    //   846: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload 10
    //   858: ldc_w 276
    //   861: aload_1
    //   862: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokeinterface 182 3 0
    //   870: pop
    //   871: goto -252 -> 619
    //   874: astore_0
    //   875: aload_3
    //   876: astore 4
    //   878: aload 4
    //   880: ifnull +8 -> 888
    //   883: aload 4
    //   885: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   888: aload_0
    //   889: athrow
    //   890: aload_0
    //   891: getfield 405	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   894: iconst_1
    //   895: if_icmpeq +312 -> 1207
    //   898: new 442	java/io/DataOutputStream
    //   901: dup
    //   902: aload_3
    //   903: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   906: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   909: astore_1
    //   910: new 451	java/lang/StringBuffer
    //   913: dup
    //   914: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   917: astore_0
    //   918: aload_0
    //   919: ldc_w 454
    //   922: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   925: ldc_w 459
    //   928: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   931: ldc 171
    //   933: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   936: ldc_w 454
    //   939: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   942: pop
    //   943: aload_0
    //   944: ldc_w 461
    //   947: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   950: ldc_w 463
    //   953: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   956: ldc_w 465
    //   959: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   962: aload 8
    //   964: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   967: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   970: ldc_w 467
    //   973: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   976: ldc_w 454
    //   979: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload_0
    //   984: new 49	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   991: ldc_w 469
    //   994: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: ldc_w 471
    //   1000: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 473
    //   1006: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1015: pop
    //   1016: aload_1
    //   1017: aload_0
    //   1018: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1021: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1024: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1027: new 482	java/io/BufferedInputStream
    //   1030: dup
    //   1031: new 482	java/io/BufferedInputStream
    //   1034: dup
    //   1035: new 484	java/io/FileInputStream
    //   1038: dup
    //   1039: aload 8
    //   1041: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1044: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1047: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1050: astore_0
    //   1051: sipush 3072
    //   1054: newarray byte
    //   1056: astore 4
    //   1058: aload_0
    //   1059: aload 4
    //   1061: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1064: istore_2
    //   1065: iload_2
    //   1066: iconst_m1
    //   1067: if_icmpeq +94 -> 1161
    //   1070: aload_1
    //   1071: aload 4
    //   1073: iconst_0
    //   1074: iload_2
    //   1075: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1078: goto -20 -> 1058
    //   1081: astore 4
    //   1083: ldc 32
    //   1085: iconst_1
    //   1086: new 49	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 492
    //   1096: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload 8
    //   1101: invokevirtual 495	java/io/File:length	()J
    //   1104: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1107: ldc_w 500
    //   1110: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload 8
    //   1115: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1118: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1127: aload_1
    //   1128: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1131: aload_1
    //   1132: invokevirtual 507	java/io/OutputStream:close	()V
    //   1135: aload_3
    //   1136: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1139: aload 7
    //   1141: astore 4
    //   1143: aload_0
    //   1144: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1147: iconst_0
    //   1148: ifeq +11 -> 1159
    //   1151: new 510	java/lang/NullPointerException
    //   1154: dup
    //   1155: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1158: athrow
    //   1159: aconst_null
    //   1160: areturn
    //   1161: aload_0
    //   1162: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1165: aload_1
    //   1166: new 49	java/lang/StringBuilder
    //   1169: dup
    //   1170: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1173: ldc_w 513
    //   1176: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: ldc 171
    //   1181: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: ldc_w 515
    //   1187: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1196: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1199: aload_1
    //   1200: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1203: aload_1
    //   1204: invokevirtual 507	java/io/OutputStream:close	()V
    //   1207: new 451	java/lang/StringBuffer
    //   1210: dup
    //   1211: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1214: astore 4
    //   1216: aload_3
    //   1217: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1220: istore_2
    //   1221: iload_2
    //   1222: sipush 200
    //   1225: if_icmpeq +35 -> 1260
    //   1228: ldc 32
    //   1230: iconst_1
    //   1231: new 49	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 520
    //   1241: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: iload_2
    //   1245: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: ldc_w 522
    //   1251: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: new 526	java/io/BufferedReader
    //   1263: dup
    //   1264: new 528	java/io/InputStreamReader
    //   1267: dup
    //   1268: aload_3
    //   1269: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1272: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1275: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1278: astore_1
    //   1279: aload_1
    //   1280: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1283: astore_0
    //   1284: aload_0
    //   1285: ifnull +26 -> 1311
    //   1288: aload 4
    //   1290: aload_0
    //   1291: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1294: ldc_w 537
    //   1297: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1300: pop
    //   1301: goto -22 -> 1279
    //   1304: astore_1
    //   1305: aload_0
    //   1306: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1309: aload_1
    //   1310: athrow
    //   1311: aload 4
    //   1313: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1316: astore_0
    //   1317: aload_1
    //   1318: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1321: aload_3
    //   1322: ifnull +32 -> 1354
    //   1325: aload_3
    //   1326: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1329: aload_0
    //   1330: areturn
    //   1331: astore_0
    //   1332: goto -454 -> 878
    //   1335: astore_3
    //   1336: aconst_null
    //   1337: astore_0
    //   1338: aload 6
    //   1340: astore_1
    //   1341: goto -653 -> 688
    //   1344: astore 4
    //   1346: aload_3
    //   1347: astore_1
    //   1348: aload 4
    //   1350: astore_3
    //   1351: goto -663 -> 688
    //   1354: aload_0
    //   1355: areturn
    //   1356: aconst_null
    //   1357: astore 5
    //   1359: goto -782 -> 577
    //   1362: aconst_null
    //   1363: astore 4
    //   1365: goto -808 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1368	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1368	1	paramString	String
    //   1064	181	2	i	int
    //   37	1289	3	localObject1	Object
    //   1335	12	3	localException1	java.lang.Exception
    //   1350	1	3	localObject2	Object
    //   151	493	4	localObject3	Object
    //   679	7	4	localException2	java.lang.Exception
    //   689	383	4	localObject4	Object
    //   1081	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1141	171	4	localObject5	Object
    //   1344	5	4	localException3	java.lang.Exception
    //   1363	1	4	localObject6	Object
    //   44	1314	5	str1	String
    //   4	1335	6	localObject7	Object
    //   1	1139	7	localObject8	Object
    //   64	1050	8	localFile	java.io.File
    //   53	556	9	localObject9	Object
    //   242	615	10	localObject10	Object
    //   535	279	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   319	557	679	java/lang/Exception
    //   562	577	679	java/lang/Exception
    //   577	598	679	java/lang/Exception
    //   602	619	679	java/lang/Exception
    //   619	633	679	java/lang/Exception
    //   633	676	679	java/lang/Exception
    //   775	825	679	java/lang/Exception
    //   830	856	679	java/lang/Exception
    //   856	871	679	java/lang/Exception
    //   890	1058	679	java/lang/Exception
    //   1161	1207	679	java/lang/Exception
    //   1207	1221	679	java/lang/Exception
    //   1228	1260	679	java/lang/Exception
    //   1260	1279	679	java/lang/Exception
    //   1279	1284	679	java/lang/Exception
    //   1288	1301	679	java/lang/Exception
    //   1305	1311	679	java/lang/Exception
    //   1311	1317	679	java/lang/Exception
    //   79	153	732	java/lang/Exception
    //   153	165	732	java/lang/Exception
    //   165	224	732	java/lang/Exception
    //   319	557	874	finally
    //   562	577	874	finally
    //   577	598	874	finally
    //   602	619	874	finally
    //   619	633	874	finally
    //   633	676	874	finally
    //   775	825	874	finally
    //   830	856	874	finally
    //   856	871	874	finally
    //   890	1058	874	finally
    //   1161	1207	874	finally
    //   1207	1221	874	finally
    //   1228	1260	874	finally
    //   1260	1279	874	finally
    //   1279	1284	874	finally
    //   1288	1301	874	finally
    //   1305	1311	874	finally
    //   1311	1317	874	finally
    //   1317	1321	874	finally
    //   1058	1065	1081	java/lang/OutOfMemoryError
    //   1070	1078	1081	java/lang/OutOfMemoryError
    //   1058	1065	1304	finally
    //   1070	1078	1304	finally
    //   1083	1139	1304	finally
    //   235	244	1331	finally
    //   248	254	1331	finally
    //   258	273	1331	finally
    //   277	290	1331	finally
    //   294	299	1331	finally
    //   303	319	1331	finally
    //   691	720	1331	finally
    //   1143	1147	1331	finally
    //   235	244	1335	java/lang/Exception
    //   248	254	1335	java/lang/Exception
    //   258	273	1335	java/lang/Exception
    //   277	290	1335	java/lang/Exception
    //   294	299	1335	java/lang/Exception
    //   303	319	1335	java/lang/Exception
    //   1143	1147	1335	java/lang/Exception
    //   1317	1321	1344	java/lang/Exception
  }
  
  /* Error */
  public static final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 335	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 362	java/io/File:exists	()Z
    //   18: ifeq +116 -> 134
    //   21: ldc_w 540
    //   24: invokestatic 545	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 5
    //   29: new 484	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 546	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
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
    //   56: invokevirtual 547	java/io/FileInputStream:read	([B)I
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
    //   74: invokevirtual 550	java/security/MessageDigest:update	([BII)V
    //   77: goto -28 -> 49
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: ldc_w 552
    //   88: iconst_1
    //   89: new 49	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 554
    //   99: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: invokevirtual 555	java/io/FileInputStream:close	()V
    //   130: aload 6
    //   132: astore 5
    //   134: aload 5
    //   136: areturn
    //   137: aload 4
    //   139: astore_0
    //   140: aload 4
    //   142: invokevirtual 555	java/io/FileInputStream:close	()V
    //   145: aload 4
    //   147: astore_0
    //   148: new 49	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: invokevirtual 558	java/security/MessageDigest:digest	()[B
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
    //   186: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_0
    //   193: aload 7
    //   195: iload_3
    //   196: invokestatic 561	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   199: invokevirtual 564	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto +161 -> 371
    //   213: aload 4
    //   215: astore_0
    //   216: aload 7
    //   218: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: astore_0
    //   226: aload_0
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -97 -> 134
    //   234: aload 4
    //   236: invokevirtual 555	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore 4
    //   243: ldc_w 552
    //   246: iconst_1
    //   247: new 49	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 566
    //   257: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 4
    //   262: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   265: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: ldc_w 552
    //   280: iconst_1
    //   281: new 49	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 566
    //   291: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 555	java/io/FileInputStream:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore_0
    //   325: ldc_w 552
    //   328: iconst_1
    //   329: new 49	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 566
    //   339: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   391: ldc_w 568
    //   394: astore 5
    //   396: goto -217 -> 179
    //   399: ldc_w 570
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
    //   10: new 63	bdzv
    //   13: dup
    //   14: invokespecial 64	bdzv:<init>	()V
    //   17: astore 8
    //   19: aload 5
    //   21: astore 6
    //   23: ldc 66
    //   25: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   28: astore 9
    //   30: aload 5
    //   32: astore 6
    //   34: aload 9
    //   36: aconst_null
    //   37: iconst_1
    //   38: anewarray 74	javax/net/ssl/TrustManager
    //   41: dup
    //   42: iconst_0
    //   43: aload 8
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   50: aload 5
    //   52: astore 6
    //   54: new 80	bdzx
    //   57: dup
    //   58: aload 9
    //   60: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   63: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   66: astore 8
    //   68: aload 5
    //   70: astore 6
    //   72: aload 8
    //   74: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   77: aload 5
    //   79: astore 6
    //   81: new 94	java/net/URL
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   95: astore 5
    //   97: aload 5
    //   99: aload 8
    //   101: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   104: aload 5
    //   106: sipush 5000
    //   109: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   112: aload 5
    //   114: sipush 15000
    //   117: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   120: aload 5
    //   122: iconst_1
    //   123: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   126: aload 5
    //   128: iconst_0
    //   129: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   132: aload 5
    //   134: ldc 123
    //   136: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   139: aload 5
    //   141: ldc 128
    //   143: ldc 130
    //   145: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 5
    //   150: ldc 136
    //   152: new 49	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 138
    //   158: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: ldc 141
    //   163: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   169: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 141
    //   174: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   180: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 141
    //   185: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   191: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 141
    //   196: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 157
    //   201: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 141
    //   206: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 159
    //   211: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 161
    //   216: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 5
    //   227: ldc 167
    //   229: ldc_w 625
    //   232: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 5
    //   237: ldc 163
    //   239: ldc 165
    //   241: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 5
    //   246: ldc_w 627
    //   249: ldc_w 377
    //   252: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: new 173	java/util/HashMap
    //   258: dup
    //   259: invokespecial 174	java/util/HashMap:<init>	()V
    //   262: astore 6
    //   264: aload 6
    //   266: ldc 128
    //   268: ldc 176
    //   270: invokeinterface 182 3 0
    //   275: pop
    //   276: aload 6
    //   278: ldc 184
    //   280: aload_1
    //   281: invokeinterface 182 3 0
    //   286: pop
    //   287: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   290: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   293: iconst_2
    //   294: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   297: checkcast 202	mqq/manager/TicketManager
    //   300: astore 8
    //   302: aload 8
    //   304: aload_0
    //   305: invokeinterface 206 2 0
    //   310: astore 7
    //   312: aload_1
    //   313: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifne +464 -> 780
    //   319: aload 8
    //   321: aload_0
    //   322: aload_2
    //   323: invokeinterface 212 3 0
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifeq +143 -> 476
    //   336: ldc 32
    //   338: iconst_1
    //   339: ldc_w 629
    //   342: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   348: astore_0
    //   349: aload_0
    //   350: ifnull +19 -> 369
    //   353: aload 6
    //   355: ldc_w 276
    //   358: aload_0
    //   359: aload_1
    //   360: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   363: invokeinterface 182 3 0
    //   368: pop
    //   369: aload 6
    //   371: invokeinterface 228 1 0
    //   376: invokeinterface 234 1 0
    //   381: astore_0
    //   382: aload_0
    //   383: invokeinterface 239 1 0
    //   388: ifeq +210 -> 598
    //   391: aload_0
    //   392: invokeinterface 243 1 0
    //   397: checkcast 245	java/util/Map$Entry
    //   400: astore_1
    //   401: aload 5
    //   403: aload_1
    //   404: invokeinterface 248 1 0
    //   409: checkcast 250	java/lang/String
    //   412: aload_1
    //   413: invokeinterface 253 1 0
    //   418: checkcast 250	java/lang/String
    //   421: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -42 -> 382
    //   427: astore_2
    //   428: aload 5
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_0
    //   433: ldc 32
    //   435: iconst_1
    //   436: new 49	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 631
    //   446: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_2
    //   450: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: astore_2
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   472: aload_0
    //   473: astore_2
    //   474: aload_2
    //   475: areturn
    //   476: new 49	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 434
    //   486: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_2
    //   490: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 436
    //   496: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 438
    //   506: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 7
    //   511: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: astore_0
    //   515: aload_3
    //   516: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   519: ifne +14 -> 533
    //   522: aload_0
    //   523: bipush 59
    //   525: invokevirtual 589	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   528: aload_3
    //   529: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 6
    //   535: ldc_w 276
    //   538: aload_0
    //   539: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokeinterface 182 3 0
    //   547: pop
    //   548: goto -179 -> 369
    //   551: astore_2
    //   552: aconst_null
    //   553: astore_0
    //   554: aload 5
    //   556: astore_1
    //   557: aload_1
    //   558: astore 6
    //   560: ldc 32
    //   562: iconst_1
    //   563: new 49	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 633
    //   573: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_2
    //   577: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_0
    //   587: astore_2
    //   588: aload_1
    //   589: ifnull -115 -> 474
    //   592: aload_1
    //   593: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   596: aload_0
    //   597: areturn
    //   598: new 451	java/lang/StringBuffer
    //   601: dup
    //   602: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   605: astore_0
    //   606: aload 5
    //   608: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   611: istore 4
    //   613: iload 4
    //   615: sipush 200
    //   618: if_icmpeq +36 -> 654
    //   621: ldc 32
    //   623: iconst_1
    //   624: new 49	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 635
    //   634: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 4
    //   639: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: ldc_w 522
    //   645: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: new 526	java/io/BufferedReader
    //   657: dup
    //   658: new 528	java/io/InputStreamReader
    //   661: dup
    //   662: aload 5
    //   664: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   667: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   670: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   673: astore_1
    //   674: aload_1
    //   675: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   678: astore_2
    //   679: aload_2
    //   680: ifnull +35 -> 715
    //   683: aload_0
    //   684: aload_2
    //   685: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   688: ldc_w 537
    //   691: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   694: pop
    //   695: goto -21 -> 674
    //   698: astore_0
    //   699: aload 5
    //   701: astore 6
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   713: aload_0
    //   714: athrow
    //   715: aload_0
    //   716: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   719: astore_0
    //   720: aload_1
    //   721: invokevirtual 538	java/io/BufferedReader:close	()V
    //   724: aload 5
    //   726: ifnull +52 -> 778
    //   729: aload 5
    //   731: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
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
    //   7: invokevirtual 637	java/lang/String:toString	()Ljava/lang/String;
    //   10: astore 11
    //   12: aload 10
    //   14: astore 8
    //   16: new 63	bdzv
    //   19: dup
    //   20: invokespecial 64	bdzv:<init>	()V
    //   23: astore_2
    //   24: aload 10
    //   26: astore 8
    //   28: ldc 66
    //   30: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   33: astore 12
    //   35: aload 10
    //   37: astore 8
    //   39: aload 12
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 74	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: aload 10
    //   56: astore 8
    //   58: new 80	bdzx
    //   61: dup
    //   62: aload 12
    //   64: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: astore 12
    //   72: aload 10
    //   74: astore 8
    //   76: aload 12
    //   78: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 10
    //   83: astore 8
    //   85: new 94	java/net/URL
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   100: astore_2
    //   101: aload_2
    //   102: aload 12
    //   104: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload_2
    //   108: sipush 5000
    //   111: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   114: aload_2
    //   115: sipush 30000
    //   118: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   126: aload_2
    //   127: iconst_1
    //   128: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   131: aload_2
    //   132: iconst_0
    //   133: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   136: aload_2
    //   137: ldc_w 424
    //   140: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: ldc 128
    //   146: ldc 130
    //   148: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ldc 136
    //   154: new 49	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 138
    //   160: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: ldc 141
    //   165: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   171: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 141
    //   176: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   182: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 141
    //   187: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   193: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 141
    //   198: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 157
    //   203: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 141
    //   208: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 159
    //   213: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 161
    //   218: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: iload 6
    //   229: ifeq +147 -> 376
    //   232: aload_2
    //   233: ldc 167
    //   235: ldc_w 625
    //   238: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: ldc 163
    //   244: ldc 165
    //   246: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w 627
    //   253: ldc_w 377
    //   256: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 5
    //   261: ifnull +138 -> 399
    //   264: aload 5
    //   266: invokeinterface 228 1 0
    //   271: invokeinterface 234 1 0
    //   276: astore 5
    //   278: aload 5
    //   280: invokeinterface 239 1 0
    //   285: ifeq +114 -> 399
    //   288: aload 5
    //   290: invokeinterface 243 1 0
    //   295: checkcast 245	java/util/Map$Entry
    //   298: astore 8
    //   300: aload_2
    //   301: aload 8
    //   303: invokeinterface 248 1 0
    //   308: checkcast 250	java/lang/String
    //   311: aload 8
    //   313: invokeinterface 253 1 0
    //   318: checkcast 250	java/lang/String
    //   321: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   337: ldc 32
    //   339: iconst_1
    //   340: new 49	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 631
    //   350: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_2
    //   354: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   357: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: ifnull +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   374: aload_1
    //   375: areturn
    //   376: aload_2
    //   377: ldc 167
    //   379: ldc_w 639
    //   382: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: goto -144 -> 241
    //   388: astore_0
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   397: aload_0
    //   398: athrow
    //   399: new 173	java/util/HashMap
    //   402: dup
    //   403: invokespecial 174	java/util/HashMap:<init>	()V
    //   406: astore 5
    //   408: aload 5
    //   410: ldc 128
    //   412: ldc 176
    //   414: invokeinterface 182 3 0
    //   419: pop
    //   420: aload 5
    //   422: ldc 184
    //   424: aload 11
    //   426: invokeinterface 182 3 0
    //   431: pop
    //   432: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   435: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   438: iconst_2
    //   439: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   442: checkcast 202	mqq/manager/TicketManager
    //   445: astore 9
    //   447: aload 9
    //   449: aload_1
    //   450: invokeinterface 206 2 0
    //   455: astore 8
    //   457: aload 11
    //   459: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +377 -> 839
    //   465: aload 9
    //   467: aload_1
    //   468: aload_3
    //   469: invokeinterface 212 3 0
    //   474: astore_3
    //   475: aload_3
    //   476: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +94 -> 573
    //   482: ldc 32
    //   484: iconst_1
    //   485: ldc_w 629
    //   488: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +20 -> 516
    //   499: aload 5
    //   501: ldc_w 276
    //   504: aload_1
    //   505: aload 11
    //   507: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokeinterface 182 3 0
    //   515: pop
    //   516: aload 5
    //   518: invokeinterface 228 1 0
    //   523: invokeinterface 234 1 0
    //   528: astore_1
    //   529: aload_1
    //   530: invokeinterface 239 1 0
    //   535: ifeq +115 -> 650
    //   538: aload_1
    //   539: invokeinterface 243 1 0
    //   544: checkcast 245	java/util/Map$Entry
    //   547: astore_3
    //   548: aload_2
    //   549: aload_3
    //   550: invokeinterface 248 1 0
    //   555: checkcast 250	java/lang/String
    //   558: aload_3
    //   559: invokeinterface 253 1 0
    //   564: checkcast 250	java/lang/String
    //   567: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: goto -41 -> 529
    //   573: new 49	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 434
    //   583: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_3
    //   587: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 436
    //   593: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 438
    //   603: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 8
    //   608: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: astore_1
    //   612: aload 4
    //   614: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   617: ifne +15 -> 632
    //   620: aload_1
    //   621: bipush 59
    //   623: invokevirtual 589	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   626: aload 4
    //   628: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 5
    //   634: ldc_w 276
    //   637: aload_1
    //   638: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokeinterface 182 3 0
    //   646: pop
    //   647: goto -131 -> 516
    //   650: new 442	java/io/DataOutputStream
    //   653: dup
    //   654: aload_2
    //   655: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   658: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   661: astore_1
    //   662: aload_1
    //   663: aload_0
    //   664: ldc_w 377
    //   667: invokevirtual 642	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   670: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   673: aload_1
    //   674: invokevirtual 506	java/io/OutputStream:flush	()V
    //   677: aload_1
    //   678: invokevirtual 507	java/io/OutputStream:close	()V
    //   681: new 451	java/lang/StringBuffer
    //   684: dup
    //   685: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   688: astore_1
    //   689: aload_2
    //   690: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   693: istore 7
    //   695: iload 7
    //   697: sipush 200
    //   700: if_icmpeq +36 -> 736
    //   703: ldc 32
    //   705: iconst_1
    //   706: new 49	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 635
    //   716: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload 7
    //   721: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: ldc_w 522
    //   727: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: new 526	java/io/BufferedReader
    //   739: dup
    //   740: new 528	java/io/InputStreamReader
    //   743: dup
    //   744: aload_2
    //   745: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   748: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   751: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   754: astore_0
    //   755: aload_0
    //   756: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   759: astore_3
    //   760: aload_3
    //   761: ifnull +33 -> 794
    //   764: aload_1
    //   765: aload_3
    //   766: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   769: ldc_w 537
    //   772: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   775: pop
    //   776: goto -21 -> 755
    //   779: astore_0
    //   780: aload_1
    //   781: invokevirtual 507	java/io/OutputStream:close	()V
    //   784: aload_2
    //   785: ifnull +7 -> 792
    //   788: aload_2
    //   789: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   792: aconst_null
    //   793: areturn
    //   794: aload_1
    //   795: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   798: astore_1
    //   799: aload_0
    //   800: invokevirtual 538	java/io/BufferedReader:close	()V
    //   803: aload_2
    //   804: ifnull +33 -> 837
    //   807: aload_2
    //   808: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
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
    //   11: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +16 -> 30
    //   17: ldc 32
    //   19: iconst_1
    //   20: ldc_w 647
    //   23: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 366
    //   44: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 652	beai:o	Ljava/lang/String;
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: getfield 654	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +16 -> 83
    //   70: aload 4
    //   72: ldc_w 656
    //   75: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 7
    //   90: aload 6
    //   92: astore 4
    //   94: new 63	bdzv
    //   97: dup
    //   98: invokespecial 64	bdzv:<init>	()V
    //   101: astore_1
    //   102: aload 6
    //   104: astore 4
    //   106: ldc 66
    //   108: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   111: astore 8
    //   113: aload 6
    //   115: astore 4
    //   117: aload 8
    //   119: aconst_null
    //   120: iconst_1
    //   121: anewarray 74	javax/net/ssl/TrustManager
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: aconst_null
    //   129: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   132: aload 6
    //   134: astore 4
    //   136: new 80	bdzx
    //   139: dup
    //   140: aload 8
    //   142: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: astore 8
    //   150: aload 6
    //   152: astore 4
    //   154: aload 8
    //   156: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   159: aload 6
    //   161: astore 4
    //   163: new 94	java/net/URL
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   172: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   178: astore_1
    //   179: aload_1
    //   180: aload 8
    //   182: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   185: aload_1
    //   186: sipush 5000
    //   189: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   192: aload_1
    //   193: sipush 30000
    //   196: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   199: aload_1
    //   200: iconst_1
    //   201: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   204: aload_1
    //   205: iconst_1
    //   206: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   209: aload_1
    //   210: iconst_0
    //   211: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   214: aload_1
    //   215: ldc_w 424
    //   218: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: ldc 128
    //   224: ldc 130
    //   226: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 136
    //   232: new 49	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 138
    //   238: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: ldc 141
    //   243: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   249: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 141
    //   254: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   260: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 141
    //   265: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   271: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 141
    //   276: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 157
    //   281: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 141
    //   286: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 159
    //   291: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 161
    //   296: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ldc 167
    //   308: ldc_w 625
    //   311: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_1
    //   315: ldc 163
    //   317: ldc 165
    //   319: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: ldc_w 627
    //   326: ldc_w 377
    //   329: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: new 173	java/util/HashMap
    //   335: dup
    //   336: invokespecial 174	java/util/HashMap:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc 128
    //   345: ldc 176
    //   347: invokeinterface 182 3 0
    //   352: pop
    //   353: aload 5
    //   355: ldc 184
    //   357: aload 7
    //   359: invokeinterface 182 3 0
    //   364: pop
    //   365: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   368: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   371: iconst_2
    //   372: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   375: checkcast 202	mqq/manager/TicketManager
    //   378: astore 4
    //   380: aload 4
    //   382: aload_2
    //   383: invokeinterface 206 2 0
    //   388: astore 6
    //   390: aload 7
    //   392: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +429 -> 824
    //   398: aload 4
    //   400: aload_2
    //   401: ldc 208
    //   403: invokeinterface 212 3 0
    //   408: astore 4
    //   410: aload 4
    //   412: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifeq +144 -> 559
    //   418: ldc 32
    //   420: iconst_1
    //   421: ldc_w 629
    //   424: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   430: astore_2
    //   431: aload_2
    //   432: ifnull +20 -> 452
    //   435: aload 5
    //   437: ldc_w 276
    //   440: aload_2
    //   441: aload 7
    //   443: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokeinterface 182 3 0
    //   451: pop
    //   452: aload 5
    //   454: invokeinterface 228 1 0
    //   459: invokeinterface 234 1 0
    //   464: astore_2
    //   465: aload_2
    //   466: invokeinterface 239 1 0
    //   471: ifeq +165 -> 636
    //   474: aload_2
    //   475: invokeinterface 243 1 0
    //   480: checkcast 245	java/util/Map$Entry
    //   483: astore 4
    //   485: aload_1
    //   486: aload 4
    //   488: invokeinterface 248 1 0
    //   493: checkcast 250	java/lang/String
    //   496: aload 4
    //   498: invokeinterface 253 1 0
    //   503: checkcast 250	java/lang/String
    //   506: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -44 -> 465
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_0
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 32
    //   520: iconst_1
    //   521: new 49	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 658
    //   531: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   538: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: astore_2
    //   549: aload_1
    //   550: ifnull -522 -> 28
    //   553: aload_1
    //   554: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   557: aload_0
    //   558: areturn
    //   559: aload 5
    //   561: ldc_w 276
    //   564: new 49	java/lang/StringBuilder
    //   567: dup
    //   568: new 49	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 434
    //   578: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 4
    //   583: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 436
    //   589: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_2
    //   593: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 438
    //   599: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 6
    //   604: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokeinterface 182 3 0
    //   621: pop
    //   622: goto -170 -> 452
    //   625: astore_0
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   634: aload_0
    //   635: athrow
    //   636: new 442	java/io/DataOutputStream
    //   639: dup
    //   640: aload_1
    //   641: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   644: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   647: astore_2
    //   648: aload_2
    //   649: aload_0
    //   650: invokevirtual 659	org/json/JSONObject:toString	()Ljava/lang/String;
    //   653: ldc_w 377
    //   656: invokevirtual 642	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   659: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   662: aload_2
    //   663: invokevirtual 506	java/io/OutputStream:flush	()V
    //   666: aload_2
    //   667: invokevirtual 507	java/io/OutputStream:close	()V
    //   670: new 451	java/lang/StringBuffer
    //   673: dup
    //   674: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   677: astore_0
    //   678: aload_1
    //   679: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   682: istore_3
    //   683: iload_3
    //   684: sipush 200
    //   687: if_icmpeq +35 -> 722
    //   690: ldc 32
    //   692: iconst_1
    //   693: new 49	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 661
    //   703: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: iload_3
    //   707: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: ldc_w 522
    //   713: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: new 526	java/io/BufferedReader
    //   725: dup
    //   726: new 528	java/io/InputStreamReader
    //   729: dup
    //   730: aload_1
    //   731: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   734: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   737: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   740: astore_2
    //   741: aload_2
    //   742: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   745: astore 4
    //   747: aload 4
    //   749: ifnull +34 -> 783
    //   752: aload_0
    //   753: aload 4
    //   755: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   758: ldc_w 537
    //   761: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: goto -24 -> 741
    //   768: astore_0
    //   769: aload_2
    //   770: invokevirtual 507	java/io/OutputStream:close	()V
    //   773: aload_1
    //   774: ifnull +7 -> 781
    //   777: aload_1
    //   778: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   781: aconst_null
    //   782: areturn
    //   783: aload_0
    //   784: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   787: astore_0
    //   788: aload_2
    //   789: invokevirtual 538	java/io/BufferedReader:close	()V
    //   792: aload_1
    //   793: ifnull +29 -> 822
    //   796: aload_1
    //   797: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
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
    //   10: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +16 -> 29
    //   16: ldc 32
    //   18: iconst_1
    //   19: ldc_w 647
    //   22: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: new 49	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc_w 366
    //   43: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 368
    //   53: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 664
    //   59: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload_3
    //   71: astore 4
    //   73: new 63	bdzv
    //   76: dup
    //   77: invokespecial 64	bdzv:<init>	()V
    //   80: astore 7
    //   82: aload_3
    //   83: astore 4
    //   85: ldc 66
    //   87: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   90: astore 8
    //   92: aload_3
    //   93: astore 4
    //   95: aload 8
    //   97: aconst_null
    //   98: iconst_1
    //   99: anewarray 74	javax/net/ssl/TrustManager
    //   102: dup
    //   103: iconst_0
    //   104: aload 7
    //   106: aastore
    //   107: aconst_null
    //   108: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   111: aload_3
    //   112: astore 4
    //   114: new 80	bdzx
    //   117: dup
    //   118: aload 8
    //   120: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   123: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   126: astore 7
    //   128: aload_3
    //   129: astore 4
    //   131: aload 7
    //   133: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   136: aload_3
    //   137: astore 4
    //   139: new 94	java/net/URL
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   151: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   154: astore_3
    //   155: aload_3
    //   156: aload 7
    //   158: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   161: aload_3
    //   162: sipush 5000
    //   165: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   168: aload_3
    //   169: sipush 30000
    //   172: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   175: aload_3
    //   176: iconst_1
    //   177: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   180: aload_3
    //   181: iconst_1
    //   182: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   185: aload_3
    //   186: iconst_0
    //   187: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   190: aload_3
    //   191: ldc_w 424
    //   194: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: ldc 128
    //   200: ldc 130
    //   202: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_3
    //   206: ldc 136
    //   208: new 49	java/lang/StringBuilder
    //   211: dup
    //   212: ldc 138
    //   214: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: ldc 141
    //   219: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   225: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 141
    //   230: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   236: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 141
    //   241: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   247: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 141
    //   252: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 157
    //   257: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 141
    //   262: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 159
    //   267: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 161
    //   272: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_3
    //   282: ldc 167
    //   284: ldc_w 625
    //   287: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_3
    //   291: ldc 163
    //   293: ldc 165
    //   295: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_3
    //   299: ldc_w 627
    //   302: ldc_w 377
    //   305: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: new 173	java/util/HashMap
    //   311: dup
    //   312: invokespecial 174	java/util/HashMap:<init>	()V
    //   315: astore 5
    //   317: aload 5
    //   319: ldc 128
    //   321: ldc 176
    //   323: invokeinterface 182 3 0
    //   328: pop
    //   329: aload 5
    //   331: ldc 184
    //   333: aload 6
    //   335: invokeinterface 182 3 0
    //   340: pop
    //   341: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   344: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   347: iconst_2
    //   348: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   351: checkcast 202	mqq/manager/TicketManager
    //   354: astore 4
    //   356: aload 4
    //   358: aload_1
    //   359: invokeinterface 206 2 0
    //   364: astore 7
    //   366: aload 6
    //   368: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +441 -> 812
    //   374: aload 4
    //   376: aload_1
    //   377: ldc 208
    //   379: invokeinterface 212 3 0
    //   384: astore 4
    //   386: aload 4
    //   388: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +150 -> 541
    //   394: ldc 32
    //   396: iconst_1
    //   397: ldc_w 629
    //   400: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +20 -> 428
    //   411: aload 5
    //   413: ldc_w 276
    //   416: aload_1
    //   417: aload 6
    //   419: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   422: invokeinterface 182 3 0
    //   427: pop
    //   428: aload 5
    //   430: invokeinterface 228 1 0
    //   435: invokeinterface 234 1 0
    //   440: astore_1
    //   441: aload_1
    //   442: invokeinterface 239 1 0
    //   447: ifeq +171 -> 618
    //   450: aload_1
    //   451: invokeinterface 243 1 0
    //   456: checkcast 245	java/util/Map$Entry
    //   459: astore 4
    //   461: aload_3
    //   462: aload 4
    //   464: invokeinterface 248 1 0
    //   469: checkcast 250	java/lang/String
    //   472: aload 4
    //   474: invokeinterface 253 1 0
    //   479: checkcast 250	java/lang/String
    //   482: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   500: ldc 32
    //   502: iconst_1
    //   503: new 49	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 658
    //   513: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   520: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: astore_3
    //   531: aload_1
    //   532: ifnull -505 -> 27
    //   535: aload_1
    //   536: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   539: aload_0
    //   540: areturn
    //   541: aload 5
    //   543: ldc_w 276
    //   546: new 49	java/lang/StringBuilder
    //   549: dup
    //   550: new 49	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 434
    //   560: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 4
    //   565: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: ldc_w 436
    //   571: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_1
    //   575: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 438
    //   581: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 7
    //   586: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokeinterface 182 3 0
    //   603: pop
    //   604: goto -176 -> 428
    //   607: astore_0
    //   608: aload_3
    //   609: ifnull +7 -> 616
    //   612: aload_3
    //   613: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   616: aload_0
    //   617: athrow
    //   618: new 442	java/io/DataOutputStream
    //   621: dup
    //   622: aload_3
    //   623: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   626: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   629: astore_1
    //   630: aload_1
    //   631: aload_0
    //   632: invokevirtual 659	org/json/JSONObject:toString	()Ljava/lang/String;
    //   635: ldc_w 377
    //   638: invokevirtual 642	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   641: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   644: aload_1
    //   645: invokevirtual 506	java/io/OutputStream:flush	()V
    //   648: aload_1
    //   649: invokevirtual 507	java/io/OutputStream:close	()V
    //   652: new 451	java/lang/StringBuffer
    //   655: dup
    //   656: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   659: astore_0
    //   660: aload_3
    //   661: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   664: istore_2
    //   665: iload_2
    //   666: sipush 200
    //   669: if_icmpeq +35 -> 704
    //   672: ldc 32
    //   674: iconst_1
    //   675: new 49	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 661
    //   685: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload_2
    //   689: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: ldc_w 522
    //   695: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: new 526	java/io/BufferedReader
    //   707: dup
    //   708: new 528	java/io/InputStreamReader
    //   711: dup
    //   712: aload_3
    //   713: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   716: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   719: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   722: astore_1
    //   723: aload_1
    //   724: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   727: astore 4
    //   729: aload 4
    //   731: ifnull +34 -> 765
    //   734: aload_0
    //   735: aload 4
    //   737: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   740: ldc_w 537
    //   743: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: pop
    //   747: goto -24 -> 723
    //   750: astore_0
    //   751: aload_1
    //   752: invokevirtual 507	java/io/OutputStream:close	()V
    //   755: aload_3
    //   756: ifnull +7 -> 763
    //   759: aload_3
    //   760: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   763: aconst_null
    //   764: areturn
    //   765: aload_0
    //   766: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   769: astore_0
    //   770: aload_1
    //   771: invokevirtual 538	java/io/BufferedReader:close	()V
    //   774: aload_3
    //   775: ifnull +35 -> 810
    //   778: aload_3
    //   779: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
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
    //   7: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_3
    //   14: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +16 -> 33
    //   20: ldc 32
    //   22: iconst_1
    //   23: ldc_w 359
    //   26: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: new 49	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: new 335	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: ifnull +552 -> 606
    //   57: aload 8
    //   59: invokevirtual 362	java/io/File:exists	()Z
    //   62: ifeq +544 -> 606
    //   65: aload 5
    //   67: aload_2
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 7
    //   81: astore 5
    //   83: new 63	bdzv
    //   86: dup
    //   87: invokespecial 64	bdzv:<init>	()V
    //   90: astore_2
    //   91: aload 7
    //   93: astore 5
    //   95: ldc 66
    //   97: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   100: astore 10
    //   102: aload 7
    //   104: astore 5
    //   106: aload 10
    //   108: aconst_null
    //   109: iconst_1
    //   110: anewarray 74	javax/net/ssl/TrustManager
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   121: aload 7
    //   123: astore 5
    //   125: new 80	bdzx
    //   128: dup
    //   129: aload 10
    //   131: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   134: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   137: astore 10
    //   139: aload 7
    //   141: astore 5
    //   143: aload 10
    //   145: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: aload 7
    //   150: astore 5
    //   152: new 94	java/net/URL
    //   155: dup
    //   156: aload 9
    //   158: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   161: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   164: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   167: astore_2
    //   168: aload_2
    //   169: aload 10
    //   171: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   174: aload_2
    //   175: sipush 5000
    //   178: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   181: aload_2
    //   182: sipush 30000
    //   185: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   188: aload_2
    //   189: iconst_1
    //   190: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   193: aload_2
    //   194: iconst_1
    //   195: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   198: aload_2
    //   199: iconst_0
    //   200: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   203: aload_2
    //   204: ldc_w 424
    //   207: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   210: aload_2
    //   211: ldc 128
    //   213: ldc 130
    //   215: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_2
    //   219: ldc 136
    //   221: new 49	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 138
    //   227: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: ldc 141
    //   232: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   238: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 141
    //   243: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   249: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 141
    //   254: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   260: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 141
    //   265: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 157
    //   270: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 141
    //   275: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 159
    //   280: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 161
    //   285: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: ldc 163
    //   297: ldc 165
    //   299: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: ldc 167
    //   305: new 49	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   312: ldc 169
    //   314: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 171
    //   319: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: new 173	java/util/HashMap
    //   331: dup
    //   332: invokespecial 174	java/util/HashMap:<init>	()V
    //   335: astore 10
    //   337: aload 10
    //   339: ldc 128
    //   341: ldc 176
    //   343: invokeinterface 182 3 0
    //   348: pop
    //   349: aload 10
    //   351: ldc 184
    //   353: aload 9
    //   355: invokeinterface 182 3 0
    //   360: pop
    //   361: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   364: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   367: iconst_2
    //   368: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   371: checkcast 202	mqq/manager/TicketManager
    //   374: astore 5
    //   376: aload 5
    //   378: aload_3
    //   379: invokeinterface 206 2 0
    //   384: astore 11
    //   386: aload 9
    //   388: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne +928 -> 1319
    //   394: aload 5
    //   396: aload_3
    //   397: ldc 208
    //   399: invokeinterface 212 3 0
    //   404: astore 5
    //   406: aload 8
    //   408: ifnull +906 -> 1314
    //   411: aload 8
    //   413: invokevirtual 362	java/io/File:exists	()Z
    //   416: ifeq +898 -> 1314
    //   419: aload_1
    //   420: invokestatic 364	bebo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   423: astore_1
    //   424: aload 5
    //   426: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifeq +188 -> 617
    //   432: ldc 32
    //   434: iconst_1
    //   435: ldc_w 426
    //   438: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +20 -> 466
    //   449: aload 10
    //   451: ldc_w 276
    //   454: aload_1
    //   455: aload 9
    //   457: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   460: invokeinterface 182 3 0
    //   465: pop
    //   466: aload 10
    //   468: invokeinterface 228 1 0
    //   473: invokeinterface 234 1 0
    //   478: astore_3
    //   479: aload_3
    //   480: invokeinterface 239 1 0
    //   485: ifeq +240 -> 725
    //   488: aload_3
    //   489: invokeinterface 243 1 0
    //   494: checkcast 245	java/util/Map$Entry
    //   497: astore_1
    //   498: aload_2
    //   499: aload_1
    //   500: invokeinterface 248 1 0
    //   505: checkcast 250	java/lang/String
    //   508: aload_1
    //   509: invokeinterface 253 1 0
    //   514: checkcast 250	java/lang/String
    //   517: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   533: ldc 255
    //   535: iconst_1
    //   536: new 49	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 428
    //   546: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_2
    //   550: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   553: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload_0
    //   563: astore_2
    //   564: aload_1
    //   565: ifnull -534 -> 31
    //   568: aload_1
    //   569: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   572: aload_0
    //   573: areturn
    //   574: astore_0
    //   575: ldc 32
    //   577: iconst_1
    //   578: new 49	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 430
    //   588: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload_0
    //   592: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   595: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aconst_null
    //   605: areturn
    //   606: ldc 32
    //   608: iconst_1
    //   609: ldc_w 432
    //   612: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aconst_null
    //   616: areturn
    //   617: new 49	java/lang/StringBuilder
    //   620: dup
    //   621: new 49	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 434
    //   631: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 5
    //   636: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 436
    //   642: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_3
    //   646: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 438
    //   652: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 11
    //   657: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   666: astore_3
    //   667: aload_1
    //   668: ifnull +28 -> 696
    //   671: aload_3
    //   672: new 49	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 440
    //   682: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 10
    //   698: ldc_w 276
    //   701: aload_3
    //   702: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokeinterface 182 3 0
    //   710: pop
    //   711: goto -245 -> 466
    //   714: astore_0
    //   715: aload_2
    //   716: ifnull +7 -> 723
    //   719: aload_2
    //   720: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   723: aload_0
    //   724: athrow
    //   725: new 442	java/io/DataOutputStream
    //   728: dup
    //   729: aload_2
    //   730: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   733: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   736: astore_1
    //   737: aload_0
    //   738: ifnull +130 -> 868
    //   741: new 49	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   748: astore_3
    //   749: aload_0
    //   750: invokevirtual 668	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   753: astore 10
    //   755: aload 10
    //   757: invokeinterface 239 1 0
    //   762: ifeq +95 -> 857
    //   765: aload 10
    //   767: invokeinterface 243 1 0
    //   772: checkcast 250	java/lang/String
    //   775: astore 9
    //   777: aload_0
    //   778: aload 9
    //   780: invokevirtual 619	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 5
    //   785: aload 5
    //   787: ifnull -32 -> 755
    //   790: aload_3
    //   791: ldc_w 454
    //   794: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc_w 459
    //   800: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc 171
    //   805: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 454
    //   811: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_3
    //   816: new 49	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 461
    //   826: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload 9
    //   831: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: ldc_w 670
    //   837: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_3
    //   848: aload 5
    //   850: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: goto -99 -> 755
    //   857: aload_1
    //   858: aload_3
    //   859: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokevirtual 477	java/lang/String:getBytes	()[B
    //   865: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   868: new 451	java/lang/StringBuffer
    //   871: dup
    //   872: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   875: astore_0
    //   876: aload_0
    //   877: ldc_w 454
    //   880: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   883: ldc_w 459
    //   886: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   889: ldc 171
    //   891: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   894: ldc_w 454
    //   897: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   900: pop
    //   901: aload_0
    //   902: ldc_w 461
    //   905: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   908: ldc_w 463
    //   911: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   914: ldc_w 465
    //   917: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   920: aload 8
    //   922: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   925: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   928: ldc_w 467
    //   931: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   934: ldc_w 454
    //   937: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   940: pop
    //   941: aload_0
    //   942: new 49	java/lang/StringBuilder
    //   945: dup
    //   946: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   949: ldc_w 469
    //   952: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: ldc_w 471
    //   958: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 473
    //   964: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   973: pop
    //   974: aload_1
    //   975: aload_0
    //   976: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   979: invokevirtual 477	java/lang/String:getBytes	()[B
    //   982: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   985: new 482	java/io/BufferedInputStream
    //   988: dup
    //   989: new 482	java/io/BufferedInputStream
    //   992: dup
    //   993: new 484	java/io/FileInputStream
    //   996: dup
    //   997: aload 8
    //   999: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1002: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1005: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1008: astore_0
    //   1009: sipush 3072
    //   1012: newarray byte
    //   1014: astore_3
    //   1015: aload_0
    //   1016: aload_3
    //   1017: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1020: istore 4
    //   1022: iload 4
    //   1024: iconst_m1
    //   1025: if_icmpeq +93 -> 1118
    //   1028: aload_1
    //   1029: aload_3
    //   1030: iconst_0
    //   1031: iload 4
    //   1033: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1036: goto -21 -> 1015
    //   1039: astore_3
    //   1040: ldc 32
    //   1042: iconst_1
    //   1043: new 49	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1050: ldc_w 492
    //   1053: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 8
    //   1058: invokevirtual 495	java/io/File:length	()J
    //   1061: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1064: ldc_w 500
    //   1067: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload 8
    //   1072: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1075: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: aload_1
    //   1085: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1088: aload_1
    //   1089: invokevirtual 507	java/io/OutputStream:close	()V
    //   1092: aload_2
    //   1093: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1096: aload 7
    //   1098: astore 5
    //   1100: aload_0
    //   1101: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1104: iconst_0
    //   1105: ifeq +11 -> 1116
    //   1108: new 510	java/lang/NullPointerException
    //   1111: dup
    //   1112: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1115: athrow
    //   1116: aconst_null
    //   1117: areturn
    //   1118: aload_0
    //   1119: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1122: aload_1
    //   1123: new 49	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1130: ldc_w 513
    //   1133: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: ldc 171
    //   1138: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: ldc_w 515
    //   1144: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1153: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1156: aload_1
    //   1157: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1160: aload_1
    //   1161: invokevirtual 507	java/io/OutputStream:close	()V
    //   1164: new 451	java/lang/StringBuffer
    //   1167: dup
    //   1168: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1171: astore_3
    //   1172: aload_2
    //   1173: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1176: istore 4
    //   1178: iload 4
    //   1180: sipush 200
    //   1183: if_icmpeq +36 -> 1219
    //   1186: ldc 32
    //   1188: iconst_1
    //   1189: new 49	java/lang/StringBuilder
    //   1192: dup
    //   1193: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1196: ldc_w 520
    //   1199: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: iload 4
    //   1204: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 522
    //   1210: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1219: new 526	java/io/BufferedReader
    //   1222: dup
    //   1223: new 528	java/io/InputStreamReader
    //   1226: dup
    //   1227: aload_2
    //   1228: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1231: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1234: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1237: astore_1
    //   1238: aload_1
    //   1239: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1242: astore_0
    //   1243: aload_0
    //   1244: ifnull +25 -> 1269
    //   1247: aload_3
    //   1248: aload_0
    //   1249: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1252: ldc_w 537
    //   1255: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1258: pop
    //   1259: goto -21 -> 1238
    //   1262: astore_1
    //   1263: aload_0
    //   1264: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1267: aload_1
    //   1268: athrow
    //   1269: aload_3
    //   1270: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1273: astore_0
    //   1274: aload_1
    //   1275: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1278: aload_2
    //   1279: ifnull +33 -> 1312
    //   1282: aload_2
    //   1283: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1286: aload_0
    //   1287: areturn
    //   1288: astore_0
    //   1289: aload 5
    //   1291: astore_2
    //   1292: goto -577 -> 715
    //   1295: astore_2
    //   1296: aconst_null
    //   1297: astore_0
    //   1298: aload 6
    //   1300: astore_1
    //   1301: goto -771 -> 530
    //   1304: astore_3
    //   1305: aload_2
    //   1306: astore_1
    //   1307: aload_3
    //   1308: astore_2
    //   1309: goto -779 -> 530
    //   1312: aload_0
    //   1313: areturn
    //   1314: aconst_null
    //   1315: astore_1
    //   1316: goto -892 -> 424
    //   1319: aconst_null
    //   1320: astore 5
    //   1322: goto -916 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1325	0	paramJSONObject	JSONObject
    //   0	1325	1	paramString1	String
    //   0	1325	2	paramString2	String
    //   0	1325	3	paramString3	String
    //   1020	183	4	i	int
    //   40	1281	5	localObject1	Object
    //   4	1295	6	localObject2	Object
    //   1	1096	7	localObject3	Object
    //   50	1021	8	localFile	java.io.File
    //   77	753	9	str1	String
    //   100	666	10	localObject4	Object
    //   384	272	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   168	406	523	java/lang/Exception
    //   411	424	523	java/lang/Exception
    //   424	445	523	java/lang/Exception
    //   449	466	523	java/lang/Exception
    //   466	479	523	java/lang/Exception
    //   479	520	523	java/lang/Exception
    //   617	667	523	java/lang/Exception
    //   671	696	523	java/lang/Exception
    //   696	711	523	java/lang/Exception
    //   725	737	523	java/lang/Exception
    //   741	755	523	java/lang/Exception
    //   755	785	523	java/lang/Exception
    //   790	854	523	java/lang/Exception
    //   857	868	523	java/lang/Exception
    //   868	1015	523	java/lang/Exception
    //   1118	1178	523	java/lang/Exception
    //   1186	1219	523	java/lang/Exception
    //   1219	1238	523	java/lang/Exception
    //   1238	1243	523	java/lang/Exception
    //   1247	1259	523	java/lang/Exception
    //   1263	1269	523	java/lang/Exception
    //   1269	1274	523	java/lang/Exception
    //   65	72	574	java/lang/Exception
    //   168	406	714	finally
    //   411	424	714	finally
    //   424	445	714	finally
    //   449	466	714	finally
    //   466	479	714	finally
    //   479	520	714	finally
    //   617	667	714	finally
    //   671	696	714	finally
    //   696	711	714	finally
    //   725	737	714	finally
    //   741	755	714	finally
    //   755	785	714	finally
    //   790	854	714	finally
    //   857	868	714	finally
    //   868	1015	714	finally
    //   1118	1178	714	finally
    //   1186	1219	714	finally
    //   1219	1238	714	finally
    //   1238	1243	714	finally
    //   1247	1259	714	finally
    //   1263	1269	714	finally
    //   1269	1274	714	finally
    //   1274	1278	714	finally
    //   1015	1022	1039	java/lang/OutOfMemoryError
    //   1028	1036	1039	java/lang/OutOfMemoryError
    //   1015	1022	1262	finally
    //   1028	1036	1262	finally
    //   1040	1096	1262	finally
    //   83	91	1288	finally
    //   95	102	1288	finally
    //   106	121	1288	finally
    //   125	139	1288	finally
    //   143	148	1288	finally
    //   152	168	1288	finally
    //   533	562	1288	finally
    //   1100	1104	1288	finally
    //   83	91	1295	java/lang/Exception
    //   95	102	1295	java/lang/Exception
    //   106	121	1295	java/lang/Exception
    //   125	139	1295	java/lang/Exception
    //   143	148	1295	java/lang/Exception
    //   152	168	1295	java/lang/Exception
    //   1100	1104	1295	java/lang/Exception
    //   1274	1278	1304	java/lang/Exception
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
    //   1: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: ldc 32
    //   16: iconst_1
    //   17: ldc 34
    //   19: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: sipush 157
    //   28: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   31: checkcast 676	bece
    //   34: astore 15
    //   36: aload 15
    //   38: iconst_2
    //   39: iconst_1
    //   40: aconst_null
    //   41: invokevirtual 677	bece:notifyUI	(IZLjava/lang/Object;)V
    //   44: aload 15
    //   46: iconst_4
    //   47: iconst_1
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: bipush 20
    //   56: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokevirtual 677	bece:notifyUI	(IZLjava/lang/Object;)V
    //   63: new 49	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: ldc_w 679
    //   75: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 17
    //   85: new 335	java/io/File
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 16
    //   95: aconst_null
    //   96: astore 12
    //   98: aconst_null
    //   99: astore_0
    //   100: aconst_null
    //   101: astore 14
    //   103: aload_0
    //   104: astore 10
    //   106: aload 12
    //   108: astore 11
    //   110: new 63	bdzv
    //   113: dup
    //   114: invokespecial 64	bdzv:<init>	()V
    //   117: astore 18
    //   119: aload_0
    //   120: astore 10
    //   122: aload 12
    //   124: astore 11
    //   126: ldc 66
    //   128: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   131: astore 13
    //   133: aload_0
    //   134: astore 10
    //   136: aload 12
    //   138: astore 11
    //   140: aload 13
    //   142: aconst_null
    //   143: iconst_1
    //   144: anewarray 74	javax/net/ssl/TrustManager
    //   147: dup
    //   148: iconst_0
    //   149: aload 18
    //   151: aastore
    //   152: aconst_null
    //   153: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   156: aload_0
    //   157: astore 10
    //   159: aload 12
    //   161: astore 11
    //   163: new 80	bdzx
    //   166: dup
    //   167: aload 13
    //   169: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   172: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   175: astore 13
    //   177: aload_0
    //   178: astore 10
    //   180: aload 12
    //   182: astore 11
    //   184: aload 13
    //   186: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   189: aload_0
    //   190: astore 10
    //   192: aload 12
    //   194: astore 11
    //   196: new 94	java/net/URL
    //   199: dup
    //   200: aload 17
    //   202: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   205: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   208: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   211: astore_0
    //   212: aload_0
    //   213: astore 10
    //   215: aload_0
    //   216: astore 11
    //   218: aload_0
    //   219: aload 13
    //   221: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   224: aload_0
    //   225: astore 10
    //   227: aload_0
    //   228: astore 11
    //   230: aload_0
    //   231: sipush 5000
    //   234: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   237: aload_0
    //   238: astore 10
    //   240: aload_0
    //   241: astore 11
    //   243: aload_0
    //   244: sipush 30000
    //   247: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   250: aload_0
    //   251: astore 10
    //   253: aload_0
    //   254: astore 11
    //   256: aload_0
    //   257: iconst_1
    //   258: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   261: aload_0
    //   262: astore 10
    //   264: aload_0
    //   265: astore 11
    //   267: aload_0
    //   268: iconst_1
    //   269: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   272: aload_0
    //   273: astore 10
    //   275: aload_0
    //   276: astore 11
    //   278: aload_0
    //   279: iconst_0
    //   280: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   283: aload_0
    //   284: astore 10
    //   286: aload_0
    //   287: astore 11
    //   289: aload_0
    //   290: ldc_w 424
    //   293: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: astore 10
    //   299: aload_0
    //   300: astore 11
    //   302: aload_0
    //   303: ldc 128
    //   305: ldc 130
    //   307: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: astore 10
    //   313: aload_0
    //   314: astore 11
    //   316: aload_0
    //   317: ldc 136
    //   319: new 49	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 138
    //   325: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: ldc 141
    //   330: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   336: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 141
    //   341: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   347: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 141
    //   352: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   358: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 141
    //   363: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc 157
    //   368: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 141
    //   373: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 159
    //   378: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc 161
    //   383: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: astore 10
    //   395: aload_0
    //   396: astore 11
    //   398: aload_0
    //   399: ldc 163
    //   401: ldc 165
    //   403: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: astore 10
    //   409: aload_0
    //   410: astore 11
    //   412: aload_0
    //   413: ldc 167
    //   415: new 49	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   422: ldc 169
    //   424: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 171
    //   429: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: astore 10
    //   441: aload_0
    //   442: astore 11
    //   444: new 173	java/util/HashMap
    //   447: dup
    //   448: invokespecial 174	java/util/HashMap:<init>	()V
    //   451: astore 18
    //   453: aload_0
    //   454: astore 10
    //   456: aload_0
    //   457: astore 11
    //   459: aload 18
    //   461: ldc 128
    //   463: ldc 176
    //   465: invokeinterface 182 3 0
    //   470: pop
    //   471: aload_0
    //   472: astore 10
    //   474: aload_0
    //   475: astore 11
    //   477: aload 18
    //   479: ldc 184
    //   481: aload 17
    //   483: invokeinterface 182 3 0
    //   488: pop
    //   489: aload_0
    //   490: astore 10
    //   492: aload_0
    //   493: astore 11
    //   495: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   498: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   501: iconst_2
    //   502: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   505: checkcast 202	mqq/manager/TicketManager
    //   508: astore 13
    //   510: aconst_null
    //   511: astore 12
    //   513: aload_0
    //   514: astore 10
    //   516: aload_0
    //   517: astore 11
    //   519: aload 13
    //   521: aload_2
    //   522: invokeinterface 206 2 0
    //   527: astore 19
    //   529: aload_0
    //   530: astore 10
    //   532: aload_0
    //   533: astore 11
    //   535: aload 17
    //   537: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   540: ifne +21 -> 561
    //   543: aload_0
    //   544: astore 10
    //   546: aload_0
    //   547: astore 11
    //   549: aload 13
    //   551: aload_2
    //   552: ldc 208
    //   554: invokeinterface 212 3 0
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
    //   585: invokevirtual 362	java/io/File:exists	()Z
    //   588: ifeq +15 -> 603
    //   591: aload_0
    //   592: astore 10
    //   594: aload_0
    //   595: astore 11
    //   597: aload_1
    //   598: invokestatic 364	bebo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 13
    //   603: aload_0
    //   604: astore 10
    //   606: aload_0
    //   607: astore 11
    //   609: aload 12
    //   611: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   614: ifeq +164 -> 778
    //   617: aload_0
    //   618: astore 10
    //   620: aload_0
    //   621: astore 11
    //   623: ldc 32
    //   625: iconst_1
    //   626: ldc_w 426
    //   629: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_0
    //   633: astore 10
    //   635: aload_0
    //   636: astore 11
    //   638: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   641: astore_1
    //   642: aload_1
    //   643: ifnull +26 -> 669
    //   646: aload_0
    //   647: astore 10
    //   649: aload_0
    //   650: astore 11
    //   652: aload 18
    //   654: ldc_w 276
    //   657: aload_1
    //   658: aload 17
    //   660: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokeinterface 182 3 0
    //   668: pop
    //   669: aload_0
    //   670: astore 10
    //   672: aload_0
    //   673: astore 11
    //   675: aload 18
    //   677: invokeinterface 228 1 0
    //   682: invokeinterface 234 1 0
    //   687: astore_2
    //   688: aload_0
    //   689: astore 10
    //   691: aload_0
    //   692: astore 11
    //   694: aload_2
    //   695: invokeinterface 239 1 0
    //   700: ifeq +220 -> 920
    //   703: aload_0
    //   704: astore 10
    //   706: aload_0
    //   707: astore 11
    //   709: aload_2
    //   710: invokeinterface 243 1 0
    //   715: checkcast 245	java/util/Map$Entry
    //   718: astore_1
    //   719: aload_0
    //   720: astore 10
    //   722: aload_0
    //   723: astore 11
    //   725: aload_0
    //   726: aload_1
    //   727: invokeinterface 248 1 0
    //   732: checkcast 250	java/lang/String
    //   735: aload_1
    //   736: invokeinterface 253 1 0
    //   741: checkcast 250	java/lang/String
    //   744: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -59 -> 688
    //   750: astore_2
    //   751: aconst_null
    //   752: astore_1
    //   753: aload 10
    //   755: astore_0
    //   756: aload_2
    //   757: invokevirtual 682	java/lang/Exception:printStackTrace	()V
    //   760: aload_1
    //   761: ifnull +7 -> 768
    //   764: aload_1
    //   765: invokevirtual 687	java/util/Timer:cancel	()V
    //   768: aload_0
    //   769: ifnull +890 -> 1659
    //   772: aload_0
    //   773: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   776: aconst_null
    //   777: areturn
    //   778: aload_0
    //   779: astore 10
    //   781: aload_0
    //   782: astore 11
    //   784: new 49	java/lang/StringBuilder
    //   787: dup
    //   788: new 49	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 434
    //   798: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 12
    //   803: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc_w 436
    //   809: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_2
    //   813: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 438
    //   819: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 19
    //   824: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   833: astore_1
    //   834: aload 13
    //   836: ifnull +35 -> 871
    //   839: aload_0
    //   840: astore 10
    //   842: aload_0
    //   843: astore 11
    //   845: aload_1
    //   846: new 49	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 440
    //   856: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 13
    //   861: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload_0
    //   872: astore 10
    //   874: aload_0
    //   875: astore 11
    //   877: aload 18
    //   879: ldc_w 276
    //   882: aload_1
    //   883: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokeinterface 182 3 0
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
    //   907: invokevirtual 687	java/util/Timer:cancel	()V
    //   910: aload_0
    //   911: ifnull +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   918: aload_1
    //   919: athrow
    //   920: aload_0
    //   921: astore 10
    //   923: aload_0
    //   924: astore 11
    //   926: new 442	java/io/DataOutputStream
    //   929: dup
    //   930: aload_0
    //   931: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   934: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   937: astore_2
    //   938: aload_0
    //   939: astore 10
    //   941: aload_0
    //   942: astore 11
    //   944: new 451	java/lang/StringBuffer
    //   947: dup
    //   948: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   951: astore_1
    //   952: aload_0
    //   953: astore 10
    //   955: aload_0
    //   956: astore 11
    //   958: aload_1
    //   959: ldc_w 454
    //   962: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   965: ldc_w 459
    //   968: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   971: ldc 171
    //   973: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   976: ldc_w 454
    //   979: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload_0
    //   984: astore 10
    //   986: aload_0
    //   987: astore 11
    //   989: aload_1
    //   990: ldc_w 461
    //   993: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   996: ldc_w 463
    //   999: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1002: ldc_w 465
    //   1005: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1008: aload 16
    //   1010: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   1013: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1016: ldc_w 467
    //   1019: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1022: ldc_w 454
    //   1025: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1028: pop
    //   1029: aload_0
    //   1030: astore 10
    //   1032: aload_0
    //   1033: astore 11
    //   1035: aload_1
    //   1036: new 49	java/lang/StringBuilder
    //   1039: dup
    //   1040: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1043: ldc_w 469
    //   1046: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 471
    //   1052: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 473
    //   1058: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1067: pop
    //   1068: aload_0
    //   1069: astore 10
    //   1071: aload_0
    //   1072: astore 11
    //   1074: aload_2
    //   1075: aload_1
    //   1076: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1079: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1082: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1085: aload_0
    //   1086: astore 10
    //   1088: aload_0
    //   1089: astore 11
    //   1091: new 482	java/io/BufferedInputStream
    //   1094: dup
    //   1095: new 482	java/io/BufferedInputStream
    //   1098: dup
    //   1099: new 484	java/io/FileInputStream
    //   1102: dup
    //   1103: aload 16
    //   1105: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1108: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1111: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   1136: invokevirtual 495	java/io/File:length	()J
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
    //   1154: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
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
    //   1176: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1179: invokestatic 307	java/lang/System:currentTimeMillis	()J
    //   1182: lstore 8
    //   1184: lload 8
    //   1186: lload 6
    //   1188: lsub
    //   1189: ldc2_w 308
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
    //   1213: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1216: aastore
    //   1217: invokevirtual 677	bece:notifyUI	(IZLjava/lang/Object;)V
    //   1220: lload 8
    //   1222: lstore 6
    //   1224: goto -73 -> 1151
    //   1227: aload_0
    //   1228: astore 10
    //   1230: aload_0
    //   1231: astore 11
    //   1233: aload_1
    //   1234: invokevirtual 508	java/io/BufferedInputStream:close	()V
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
    //   1274: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: invokevirtual 677	bece:notifyUI	(IZLjava/lang/Object;)V
    //   1281: aload_0
    //   1282: astore 10
    //   1284: aload_0
    //   1285: astore 11
    //   1287: new 684	java/util/Timer
    //   1290: dup
    //   1291: invokespecial 688	java/util/Timer:<init>	()V
    //   1294: astore_1
    //   1295: aload_1
    //   1296: new 690	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1
    //   1299: dup
    //   1300: aload 12
    //   1302: aload 15
    //   1304: invokespecial 693	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1:<init>	([ILbece;)V
    //   1307: lconst_0
    //   1308: ldc2_w 308
    //   1311: invokevirtual 697	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   1314: aload_2
    //   1315: new 49	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1322: ldc_w 513
    //   1325: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: ldc 171
    //   1330: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 515
    //   1336: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1345: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1348: aload_2
    //   1349: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1352: aload_2
    //   1353: invokevirtual 507	java/io/OutputStream:close	()V
    //   1356: new 451	java/lang/StringBuffer
    //   1359: dup
    //   1360: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1363: astore 11
    //   1365: aload_0
    //   1366: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1369: istore_3
    //   1370: iload_3
    //   1371: sipush 200
    //   1374: if_icmpeq +35 -> 1409
    //   1377: ldc 32
    //   1379: iconst_1
    //   1380: new 49	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 520
    //   1390: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: iload_3
    //   1394: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1397: ldc_w 522
    //   1400: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: new 526	java/io/BufferedReader
    //   1412: dup
    //   1413: new 528	java/io/InputStreamReader
    //   1416: dup
    //   1417: aload_0
    //   1418: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1421: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1424: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1427: astore_2
    //   1428: aload_2
    //   1429: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1432: astore 10
    //   1434: aload 10
    //   1436: ifnull +135 -> 1571
    //   1439: aload 11
    //   1441: aload 10
    //   1443: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1446: ldc_w 537
    //   1449: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1452: pop
    //   1453: goto -25 -> 1428
    //   1456: astore_2
    //   1457: goto -701 -> 756
    //   1460: astore 10
    //   1462: ldc 32
    //   1464: iconst_1
    //   1465: new 49	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1472: ldc_w 492
    //   1475: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: aload 16
    //   1480: invokevirtual 495	java/io/File:length	()J
    //   1483: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1486: ldc_w 500
    //   1489: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload 16
    //   1494: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1497: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1506: aload_2
    //   1507: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1510: aload_2
    //   1511: invokevirtual 507	java/io/OutputStream:close	()V
    //   1514: aload_0
    //   1515: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1518: aconst_null
    //   1519: astore 11
    //   1521: aconst_null
    //   1522: astore 10
    //   1524: aload_1
    //   1525: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1528: iconst_0
    //   1529: ifeq +11 -> 1540
    //   1532: new 510	java/lang/NullPointerException
    //   1535: dup
    //   1536: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1539: athrow
    //   1540: iconst_0
    //   1541: ifeq -1519 -> 22
    //   1544: new 510	java/lang/NullPointerException
    //   1547: dup
    //   1548: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1551: athrow
    //   1552: astore_2
    //   1553: aload_0
    //   1554: astore 10
    //   1556: aload_0
    //   1557: astore 11
    //   1559: aload_1
    //   1560: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1563: aload_0
    //   1564: astore 10
    //   1566: aload_0
    //   1567: astore 11
    //   1569: aload_2
    //   1570: athrow
    //   1571: aload 11
    //   1573: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1576: astore 10
    //   1578: aload_2
    //   1579: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1582: aload 15
    //   1584: iconst_4
    //   1585: iconst_1
    //   1586: iconst_1
    //   1587: anewarray 4	java/lang/Object
    //   1590: dup
    //   1591: iconst_0
    //   1592: bipush 100
    //   1594: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: aastore
    //   1598: invokevirtual 677	bece:notifyUI	(IZLjava/lang/Object;)V
    //   1601: new 602	org/json/JSONObject
    //   1604: dup
    //   1605: aload 10
    //   1607: invokespecial 603	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1610: astore_2
    //   1611: aload_1
    //   1612: ifnull +7 -> 1619
    //   1615: aload_1
    //   1616: invokevirtual 687	java/util/Timer:cancel	()V
    //   1619: aload_0
    //   1620: ifnull +41 -> 1661
    //   1623: aload_0
    //   1624: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1627: aload_2
    //   1628: areturn
    //   1629: astore_2
    //   1630: aload_2
    //   1631: invokevirtual 682	java/lang/Exception:printStackTrace	()V
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
    //   104	1338	10	localObject1	Object
    //   1460	1	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1522	84	10	localObject2	Object
    //   1639	5	10	localObject3	Object
    //   1649	5	10	localObject4	Object
    //   108	1464	11	localObject5	Object
    //   96	1205	12	localObject6	Object
    //   131	729	13	localObject7	Object
    //   101	799	14	localObject8	Object
    //   34	1549	15	localbece	bece
    //   93	1400	16	localFile	java.io.File
    //   83	576	17	str1	String
    //   117	761	18	localObject9	Object
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
    //   7: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   10: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +16 -> 36
    //   23: ldc 32
    //   25: iconst_1
    //   26: ldc_w 359
    //   29: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_3
    //   35: areturn
    //   36: new 49	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: new 335	java/io/File
    //   48: dup
    //   49: aload_0
    //   50: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   53: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 7
    //   58: aload_0
    //   59: getfield 654	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore_3
    //   63: aload 7
    //   65: ifnull +589 -> 654
    //   68: aload 7
    //   70: invokevirtual 362	java/io/File:exists	()Z
    //   73: ifeq +581 -> 654
    //   76: aload 4
    //   78: ldc_w 366
    //   81: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 718	beai:n	Ljava/lang/String;
    //   91: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +16 -> 115
    //   102: aload 4
    //   104: ldc_w 656
    //   107: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 8
    //   122: aload 6
    //   124: astore 4
    //   126: new 63	bdzv
    //   129: dup
    //   130: invokespecial 64	bdzv:<init>	()V
    //   133: astore_3
    //   134: aload 6
    //   136: astore 4
    //   138: ldc 66
    //   140: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   143: astore 9
    //   145: aload 6
    //   147: astore 4
    //   149: aload 9
    //   151: aconst_null
    //   152: iconst_1
    //   153: anewarray 74	javax/net/ssl/TrustManager
    //   156: dup
    //   157: iconst_0
    //   158: aload_3
    //   159: aastore
    //   160: aconst_null
    //   161: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   164: aload 6
    //   166: astore 4
    //   168: new 80	bdzx
    //   171: dup
    //   172: aload 9
    //   174: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   177: invokespecial 87	bdzx:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   180: astore 9
    //   182: aload 6
    //   184: astore 4
    //   186: aload 9
    //   188: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   191: aload 6
    //   193: astore 4
    //   195: new 94	java/net/URL
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   204: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   207: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   210: astore_3
    //   211: aload_3
    //   212: aload 9
    //   214: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   217: aload_3
    //   218: sipush 5000
    //   221: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   224: aload_3
    //   225: sipush 30000
    //   228: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   231: aload_3
    //   232: iconst_1
    //   233: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   236: aload_3
    //   237: iconst_1
    //   238: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   241: aload_3
    //   242: iconst_0
    //   243: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   246: aload_3
    //   247: ldc_w 424
    //   250: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   253: aload_3
    //   254: ldc 128
    //   256: ldc 130
    //   258: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: ldc 136
    //   264: new 49	java/lang/StringBuilder
    //   267: dup
    //   268: ldc 138
    //   270: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: ldc 141
    //   275: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   281: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 141
    //   286: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   292: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 141
    //   297: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   303: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 141
    //   308: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 157
    //   313: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 141
    //   318: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 159
    //   323: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 161
    //   328: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_3
    //   338: ldc 163
    //   340: ldc 165
    //   342: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: ldc 167
    //   348: new 49	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   355: ldc 169
    //   357: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc 171
    //   362: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: new 173	java/util/HashMap
    //   374: dup
    //   375: invokespecial 174	java/util/HashMap:<init>	()V
    //   378: astore 9
    //   380: aload 9
    //   382: ldc 128
    //   384: ldc 176
    //   386: invokeinterface 182 3 0
    //   391: pop
    //   392: aload 9
    //   394: ldc 184
    //   396: aload 8
    //   398: invokeinterface 182 3 0
    //   403: pop
    //   404: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   407: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   410: iconst_2
    //   411: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   414: checkcast 202	mqq/manager/TicketManager
    //   417: astore 4
    //   419: aload 4
    //   421: aload_1
    //   422: invokeinterface 206 2 0
    //   427: astore 10
    //   429: aload 8
    //   431: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   434: ifne +799 -> 1233
    //   437: aload 4
    //   439: aload_1
    //   440: ldc 208
    //   442: invokeinterface 212 3 0
    //   447: astore 4
    //   449: aload 7
    //   451: ifnull +777 -> 1228
    //   454: aload 7
    //   456: invokevirtual 362	java/io/File:exists	()Z
    //   459: ifeq +769 -> 1228
    //   462: aload_0
    //   463: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   466: invokestatic 364	bebo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_0
    //   470: aload 4
    //   472: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifeq +190 -> 665
    //   478: ldc 32
    //   480: iconst_1
    //   481: ldc_w 426
    //   484: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   490: astore_0
    //   491: aload_0
    //   492: ifnull +20 -> 512
    //   495: aload 9
    //   497: ldc_w 276
    //   500: aload_0
    //   501: aload 8
    //   503: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokeinterface 182 3 0
    //   511: pop
    //   512: aload 9
    //   514: invokeinterface 228 1 0
    //   519: invokeinterface 234 1 0
    //   524: astore_1
    //   525: aload_1
    //   526: invokeinterface 239 1 0
    //   531: ifeq +242 -> 773
    //   534: aload_1
    //   535: invokeinterface 243 1 0
    //   540: checkcast 245	java/util/Map$Entry
    //   543: astore_0
    //   544: aload_3
    //   545: aload_0
    //   546: invokeinterface 248 1 0
    //   551: checkcast 250	java/lang/String
    //   554: aload_0
    //   555: invokeinterface 253 1 0
    //   560: checkcast 250	java/lang/String
    //   563: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   581: ldc 255
    //   583: iconst_1
    //   584: new 49	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 428
    //   594: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_3
    //   598: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   601: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload_0
    //   611: astore_3
    //   612: aload_1
    //   613: ifnull -579 -> 34
    //   616: aload_1
    //   617: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   620: aload_0
    //   621: areturn
    //   622: astore_0
    //   623: ldc 32
    //   625: iconst_1
    //   626: new 49	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   633: ldc_w 430
    //   636: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload_0
    //   640: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   643: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: aconst_null
    //   653: areturn
    //   654: ldc 32
    //   656: iconst_1
    //   657: ldc_w 432
    //   660: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: aconst_null
    //   664: areturn
    //   665: new 49	java/lang/StringBuilder
    //   668: dup
    //   669: new 49	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 434
    //   679: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 4
    //   684: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 436
    //   690: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_1
    //   694: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 438
    //   700: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 10
    //   705: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   714: astore_1
    //   715: aload_0
    //   716: ifnull +28 -> 744
    //   719: aload_1
    //   720: new 49	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 440
    //   730: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_0
    //   734: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 9
    //   746: ldc_w 276
    //   749: aload_1
    //   750: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokeinterface 182 3 0
    //   758: pop
    //   759: goto -247 -> 512
    //   762: astore_0
    //   763: aload_3
    //   764: ifnull +7 -> 771
    //   767: aload_3
    //   768: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   771: aload_0
    //   772: athrow
    //   773: new 442	java/io/DataOutputStream
    //   776: dup
    //   777: aload_3
    //   778: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   781: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   784: astore_1
    //   785: new 451	java/lang/StringBuffer
    //   788: dup
    //   789: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   792: astore_0
    //   793: aload_0
    //   794: ldc_w 454
    //   797: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   800: ldc_w 459
    //   803: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   806: ldc 171
    //   808: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   811: ldc_w 454
    //   814: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   817: pop
    //   818: aload_0
    //   819: ldc_w 461
    //   822: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   825: ldc_w 463
    //   828: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   831: ldc_w 465
    //   834: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   837: aload 7
    //   839: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   842: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   845: ldc_w 720
    //   848: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   851: pop
    //   852: aload_0
    //   853: new 49	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 469
    //   863: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc_w 471
    //   869: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 473
    //   875: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   884: pop
    //   885: aload_1
    //   886: aload_0
    //   887: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   890: invokevirtual 477	java/lang/String:getBytes	()[B
    //   893: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   896: new 482	java/io/BufferedInputStream
    //   899: dup
    //   900: new 482	java/io/BufferedInputStream
    //   903: dup
    //   904: new 484	java/io/FileInputStream
    //   907: dup
    //   908: aload 7
    //   910: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   913: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   916: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   919: astore_0
    //   920: sipush 3072
    //   923: newarray byte
    //   925: astore 4
    //   927: aload_0
    //   928: aload 4
    //   930: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   933: istore_2
    //   934: iload_2
    //   935: iconst_m1
    //   936: if_icmpeq +94 -> 1030
    //   939: aload_1
    //   940: aload 4
    //   942: iconst_0
    //   943: iload_2
    //   944: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   947: goto -20 -> 927
    //   950: astore 4
    //   952: ldc 32
    //   954: iconst_1
    //   955: new 49	java/lang/StringBuilder
    //   958: dup
    //   959: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   962: ldc_w 492
    //   965: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload 7
    //   970: invokevirtual 495	java/io/File:length	()J
    //   973: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   976: ldc_w 500
    //   979: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: aload 7
    //   984: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   987: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_1
    //   997: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1000: aload_1
    //   1001: invokevirtual 507	java/io/OutputStream:close	()V
    //   1004: aload_3
    //   1005: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1008: aload 6
    //   1010: astore 4
    //   1012: aload_0
    //   1013: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1016: iconst_0
    //   1017: ifeq +11 -> 1028
    //   1020: new 510	java/lang/NullPointerException
    //   1023: dup
    //   1024: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1027: athrow
    //   1028: aconst_null
    //   1029: areturn
    //   1030: aload_0
    //   1031: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1034: aload_1
    //   1035: new 49	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1042: ldc_w 513
    //   1045: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: ldc 171
    //   1050: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: ldc_w 515
    //   1056: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1065: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1068: aload_1
    //   1069: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1072: aload_1
    //   1073: invokevirtual 507	java/io/OutputStream:close	()V
    //   1076: new 451	java/lang/StringBuffer
    //   1079: dup
    //   1080: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1083: astore 4
    //   1085: aload_3
    //   1086: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1089: istore_2
    //   1090: iload_2
    //   1091: sipush 200
    //   1094: if_icmpeq +35 -> 1129
    //   1097: ldc 32
    //   1099: iconst_1
    //   1100: new 49	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1107: ldc_w 520
    //   1110: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: iload_2
    //   1114: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1117: ldc_w 522
    //   1120: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1126: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1129: new 526	java/io/BufferedReader
    //   1132: dup
    //   1133: new 528	java/io/InputStreamReader
    //   1136: dup
    //   1137: aload_3
    //   1138: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1141: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1144: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1147: astore_1
    //   1148: aload_1
    //   1149: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1152: astore_0
    //   1153: aload_0
    //   1154: ifnull +26 -> 1180
    //   1157: aload 4
    //   1159: aload_0
    //   1160: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1163: ldc_w 537
    //   1166: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1169: pop
    //   1170: goto -22 -> 1148
    //   1173: astore_1
    //   1174: aload_0
    //   1175: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1178: aload_1
    //   1179: athrow
    //   1180: aload 4
    //   1182: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1185: astore_0
    //   1186: aload_1
    //   1187: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1190: aload_3
    //   1191: ifnull +35 -> 1226
    //   1194: aload_3
    //   1195: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1198: aload_0
    //   1199: areturn
    //   1200: astore_0
    //   1201: aload 4
    //   1203: astore_3
    //   1204: goto -441 -> 763
    //   1207: astore_3
    //   1208: aconst_null
    //   1209: astore_0
    //   1210: aload 5
    //   1212: astore_1
    //   1213: goto -635 -> 578
    //   1216: astore 4
    //   1218: aload_3
    //   1219: astore_1
    //   1220: aload 4
    //   1222: astore_3
    //   1223: goto -645 -> 578
    //   1226: aload_0
    //   1227: areturn
    //   1228: aconst_null
    //   1229: astore_0
    //   1230: goto -760 -> 470
    //   1233: aconst_null
    //   1234: astore 4
    //   1236: goto -787 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1239	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1239	1	paramString	String
    //   933	181	2	i	int
    //   33	1171	3	localObject1	Object
    //   1207	12	3	localException1	java.lang.Exception
    //   1222	1	3	localObject2	Object
    //   43	428	4	localObject3	Object
    //   569	7	4	localException2	java.lang.Exception
    //   579	362	4	localObject4	Object
    //   950	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1010	192	4	localObject5	Object
    //   1216	5	4	localException3	java.lang.Exception
    //   1234	1	4	localObject6	Object
    //   4	1207	5	localObject7	Object
    //   1	1008	6	localObject8	Object
    //   56	927	7	localFile	java.io.File
    //   120	382	8	str1	String
    //   143	602	9	localObject9	Object
    //   427	277	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   211	449	569	java/lang/Exception
    //   454	470	569	java/lang/Exception
    //   470	491	569	java/lang/Exception
    //   495	512	569	java/lang/Exception
    //   512	525	569	java/lang/Exception
    //   525	566	569	java/lang/Exception
    //   665	715	569	java/lang/Exception
    //   719	744	569	java/lang/Exception
    //   744	759	569	java/lang/Exception
    //   773	927	569	java/lang/Exception
    //   1030	1090	569	java/lang/Exception
    //   1097	1129	569	java/lang/Exception
    //   1129	1148	569	java/lang/Exception
    //   1148	1153	569	java/lang/Exception
    //   1157	1170	569	java/lang/Exception
    //   1174	1180	569	java/lang/Exception
    //   1180	1186	569	java/lang/Exception
    //   76	115	622	java/lang/Exception
    //   211	449	762	finally
    //   454	470	762	finally
    //   470	491	762	finally
    //   495	512	762	finally
    //   512	525	762	finally
    //   525	566	762	finally
    //   665	715	762	finally
    //   719	744	762	finally
    //   744	759	762	finally
    //   773	927	762	finally
    //   1030	1090	762	finally
    //   1097	1129	762	finally
    //   1129	1148	762	finally
    //   1148	1153	762	finally
    //   1157	1170	762	finally
    //   1174	1180	762	finally
    //   1180	1186	762	finally
    //   1186	1190	762	finally
    //   927	934	950	java/lang/OutOfMemoryError
    //   939	947	950	java/lang/OutOfMemoryError
    //   927	934	1173	finally
    //   939	947	1173	finally
    //   952	1008	1173	finally
    //   126	134	1200	finally
    //   138	145	1200	finally
    //   149	164	1200	finally
    //   168	182	1200	finally
    //   186	191	1200	finally
    //   195	211	1200	finally
    //   581	610	1200	finally
    //   1012	1016	1200	finally
    //   126	134	1207	java/lang/Exception
    //   138	145	1207	java/lang/Exception
    //   149	164	1207	java/lang/Exception
    //   168	182	1207	java/lang/Exception
    //   186	191	1207	java/lang/Exception
    //   195	211	1207	java/lang/Exception
    //   1012	1016	1207	java/lang/Exception
    //   1186	1190	1216	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebo
 * JD-Core Version:    0.7.0.1
 */