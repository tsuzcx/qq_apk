import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class bdit
{
  private static long a()
  {
    boolean bool = bgjq.a();
    long l1 = bgjq.a();
    long l2 = bgjq.b();
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
    //   29: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   32: checkcast 47	bdhv
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
    //   58: new 63	bdha
    //   61: dup
    //   62: invokespecial 64	bdha:<init>	()V
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
    //   90: new 80	bdhc
    //   93: dup
    //   94: aload 15
    //   96: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   99: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   510: invokestatic 267	anni:a	(I)Ljava/lang/String;
    //   513: aastore
    //   514: dup
    //   515: iconst_1
    //   516: aload_3
    //   517: aastore
    //   518: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   583: invokestatic 284	bdit:a	()J
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
    //   610: invokestatic 267	anni:a	(I)Ljava/lang/String;
    //   613: aastore
    //   614: dup
    //   615: iconst_1
    //   616: aload_3
    //   617: aastore
    //   618: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   731: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   760: getstatic 327	anhk:bp	Ljava/lang/String;
    //   763: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload_2
    //   767: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 331	atvo:b	(Ljava/lang/String;)Ljava/lang/String;
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
    //   826: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   875: invokestatic 267	anni:a	(I)Ljava/lang/String;
    //   878: aastore
    //   879: dup
    //   880: iconst_1
    //   881: aload_3
    //   882: aastore
    //   883: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   936: invokestatic 267	anni:a	(I)Ljava/lang/String;
    //   939: aastore
    //   940: dup
    //   941: iconst_1
    //   942: aload_3
    //   943: aastore
    //   944: invokevirtual 271	bdhv:notifyUI	(IZLjava/lang/Object;)V
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
    //   35	889	14	localbdhv	bdhv
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
    //   53: astore 4
    //   55: new 335	java/io/File
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 8
    //   66: aload 8
    //   68: ifnull +697 -> 765
    //   71: aload 8
    //   73: invokevirtual 362	java/io/File:exists	()Z
    //   76: ifeq +689 -> 765
    //   79: aload 5
    //   81: invokestatic 364	bdit:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload 4
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
    //   151: astore 9
    //   153: aload_0
    //   154: getfield 391	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   157: ifnull +8 -> 165
    //   160: aload_0
    //   161: getfield 391	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   164: astore_3
    //   165: aload 9
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
    //   199: invokestatic 410	bdho:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   202: ifeq +22 -> 224
    //   205: aload 4
    //   207: ldc_w 412
    //   210: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 414	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:a	Ljava/lang/String;
    //   217: invokestatic 419	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   220: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 9
    //   231: aload 7
    //   233: astore 4
    //   235: new 63	bdha
    //   238: dup
    //   239: invokespecial 64	bdha:<init>	()V
    //   242: astore_3
    //   243: aload 7
    //   245: astore 4
    //   247: ldc 66
    //   249: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   252: astore 10
    //   254: aload 7
    //   256: astore 4
    //   258: aload 10
    //   260: aconst_null
    //   261: iconst_1
    //   262: anewarray 74	javax/net/ssl/TrustManager
    //   265: dup
    //   266: iconst_0
    //   267: aload_3
    //   268: aastore
    //   269: aconst_null
    //   270: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   273: aload 7
    //   275: astore 4
    //   277: new 80	bdhc
    //   280: dup
    //   281: aload 10
    //   283: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   286: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   289: astore 10
    //   291: aload 7
    //   293: astore 4
    //   295: aload 10
    //   297: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   300: aload 7
    //   302: astore 4
    //   304: new 94	java/net/URL
    //   307: dup
    //   308: aload 9
    //   310: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   316: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   319: astore_3
    //   320: aload_3
    //   321: aload 10
    //   323: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   326: aload_3
    //   327: sipush 5000
    //   330: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   333: aload_3
    //   334: sipush 30000
    //   337: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   340: aload_3
    //   341: iconst_1
    //   342: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   345: aload_3
    //   346: iconst_1
    //   347: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   350: aload_3
    //   351: iconst_0
    //   352: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   355: aload_3
    //   356: ldc_w 424
    //   359: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   362: aload_3
    //   363: ldc 128
    //   365: ldc 130
    //   367: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_3
    //   371: ldc 136
    //   373: new 49	java/lang/StringBuilder
    //   376: dup
    //   377: ldc 138
    //   379: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: ldc 141
    //   384: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   390: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 141
    //   395: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   401: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 141
    //   406: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   412: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 141
    //   417: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 157
    //   422: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 141
    //   427: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc 159
    //   432: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 161
    //   437: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_3
    //   447: ldc 163
    //   449: ldc 165
    //   451: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_3
    //   455: ldc 167
    //   457: new 49	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   464: ldc 169
    //   466: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 171
    //   471: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: new 173	java/util/HashMap
    //   483: dup
    //   484: invokespecial 174	java/util/HashMap:<init>	()V
    //   487: astore 10
    //   489: aload 10
    //   491: ldc 128
    //   493: ldc 176
    //   495: invokeinterface 182 3 0
    //   500: pop
    //   501: aload 10
    //   503: ldc 184
    //   505: aload 9
    //   507: invokeinterface 182 3 0
    //   512: pop
    //   513: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   516: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   519: iconst_2
    //   520: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   523: checkcast 202	mqq/manager/TicketManager
    //   526: astore 4
    //   528: aload 4
    //   530: aload_1
    //   531: invokeinterface 206 2 0
    //   536: astore 11
    //   538: aload 9
    //   540: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne +818 -> 1361
    //   546: aload 4
    //   548: aload_1
    //   549: ldc 208
    //   551: invokeinterface 212 3 0
    //   556: astore 4
    //   558: aload 8
    //   560: ifnull +795 -> 1355
    //   563: aload 8
    //   565: invokevirtual 362	java/io/File:exists	()Z
    //   568: ifeq +787 -> 1355
    //   571: aload 5
    //   573: invokestatic 364	bdit:a	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 5
    //   578: aload 4
    //   580: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifeq +193 -> 776
    //   586: ldc 32
    //   588: iconst_1
    //   589: ldc_w 426
    //   592: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   598: astore_1
    //   599: aload_1
    //   600: ifnull +20 -> 620
    //   603: aload 10
    //   605: ldc_w 276
    //   608: aload_1
    //   609: aload 9
    //   611: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   614: invokeinterface 182 3 0
    //   619: pop
    //   620: aload 10
    //   622: invokeinterface 228 1 0
    //   627: invokeinterface 234 1 0
    //   632: astore 4
    //   634: aload 4
    //   636: invokeinterface 239 1 0
    //   641: ifeq +245 -> 886
    //   644: aload 4
    //   646: invokeinterface 243 1 0
    //   651: checkcast 245	java/util/Map$Entry
    //   654: astore_1
    //   655: aload_3
    //   656: aload_1
    //   657: invokeinterface 248 1 0
    //   662: checkcast 250	java/lang/String
    //   665: aload_1
    //   666: invokeinterface 253 1 0
    //   671: checkcast 250	java/lang/String
    //   674: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   692: ldc 255
    //   694: iconst_1
    //   695: new 49	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 428
    //   705: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_3
    //   709: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   712: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload_0
    //   722: astore_3
    //   723: aload_1
    //   724: ifnull -686 -> 38
    //   727: aload_1
    //   728: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   731: aload_0
    //   732: areturn
    //   733: astore_0
    //   734: ldc 32
    //   736: iconst_1
    //   737: new 49	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 430
    //   747: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_0
    //   751: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   754: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: aconst_null
    //   764: areturn
    //   765: ldc 32
    //   767: iconst_1
    //   768: ldc_w 432
    //   771: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aconst_null
    //   775: areturn
    //   776: new 49	java/lang/StringBuilder
    //   779: dup
    //   780: new 49	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 434
    //   790: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 4
    //   795: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: ldc_w 436
    //   801: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_1
    //   805: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 438
    //   811: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 11
    //   816: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   825: astore_1
    //   826: aload 5
    //   828: ifnull +29 -> 857
    //   831: aload_1
    //   832: new 49	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 440
    //   842: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 5
    //   847: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 10
    //   859: ldc_w 276
    //   862: aload_1
    //   863: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokeinterface 182 3 0
    //   871: pop
    //   872: goto -252 -> 620
    //   875: astore_0
    //   876: aload_3
    //   877: ifnull +7 -> 884
    //   880: aload_3
    //   881: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   884: aload_0
    //   885: athrow
    //   886: aload_0
    //   887: getfield 405	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   890: iconst_1
    //   891: if_icmpeq +312 -> 1203
    //   894: new 442	java/io/DataOutputStream
    //   897: dup
    //   898: aload_3
    //   899: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   902: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   905: astore_1
    //   906: new 451	java/lang/StringBuffer
    //   909: dup
    //   910: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   913: astore_0
    //   914: aload_0
    //   915: ldc_w 454
    //   918: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   921: ldc_w 459
    //   924: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   927: ldc 171
    //   929: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   932: ldc_w 454
    //   935: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   938: pop
    //   939: aload_0
    //   940: ldc_w 461
    //   943: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   946: ldc_w 463
    //   949: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   952: ldc_w 465
    //   955: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   958: aload 8
    //   960: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   963: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   966: ldc_w 467
    //   969: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   972: ldc_w 454
    //   975: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   978: pop
    //   979: aload_0
    //   980: new 49	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   987: ldc_w 469
    //   990: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 471
    //   996: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc_w 473
    //   1002: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1011: pop
    //   1012: aload_1
    //   1013: aload_0
    //   1014: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1017: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1020: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1023: new 482	java/io/BufferedInputStream
    //   1026: dup
    //   1027: new 482	java/io/BufferedInputStream
    //   1030: dup
    //   1031: new 484	java/io/FileInputStream
    //   1034: dup
    //   1035: aload 8
    //   1037: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1040: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1043: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1046: astore_0
    //   1047: sipush 3072
    //   1050: newarray byte
    //   1052: astore 4
    //   1054: aload_0
    //   1055: aload 4
    //   1057: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1060: istore_2
    //   1061: iload_2
    //   1062: iconst_m1
    //   1063: if_icmpeq +94 -> 1157
    //   1066: aload_1
    //   1067: aload 4
    //   1069: iconst_0
    //   1070: iload_2
    //   1071: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1074: goto -20 -> 1054
    //   1077: astore 4
    //   1079: ldc 32
    //   1081: iconst_1
    //   1082: new 49	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 492
    //   1092: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload 8
    //   1097: invokevirtual 495	java/io/File:length	()J
    //   1100: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: ldc_w 500
    //   1106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload 8
    //   1111: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1114: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1123: aload_1
    //   1124: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1127: aload_1
    //   1128: invokevirtual 507	java/io/OutputStream:close	()V
    //   1131: aload_3
    //   1132: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1135: aload 7
    //   1137: astore 4
    //   1139: aload_0
    //   1140: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1143: iconst_0
    //   1144: ifeq +11 -> 1155
    //   1147: new 510	java/lang/NullPointerException
    //   1150: dup
    //   1151: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1154: athrow
    //   1155: aconst_null
    //   1156: areturn
    //   1157: aload_0
    //   1158: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1161: aload_1
    //   1162: new 49	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1169: ldc_w 513
    //   1172: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: ldc 171
    //   1177: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: ldc_w 515
    //   1183: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1192: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1195: aload_1
    //   1196: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1199: aload_1
    //   1200: invokevirtual 507	java/io/OutputStream:close	()V
    //   1203: new 451	java/lang/StringBuffer
    //   1206: dup
    //   1207: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1210: astore 4
    //   1212: aload_3
    //   1213: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1216: istore_2
    //   1217: iload_2
    //   1218: sipush 200
    //   1221: if_icmpeq +35 -> 1256
    //   1224: ldc 32
    //   1226: iconst_1
    //   1227: new 49	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1234: ldc_w 520
    //   1237: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: iload_2
    //   1241: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 522
    //   1247: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: new 526	java/io/BufferedReader
    //   1259: dup
    //   1260: new 528	java/io/InputStreamReader
    //   1263: dup
    //   1264: aload_3
    //   1265: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1268: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1271: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1274: astore_1
    //   1275: aload_1
    //   1276: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1279: astore_0
    //   1280: aload_0
    //   1281: ifnull +26 -> 1307
    //   1284: aload 4
    //   1286: aload_0
    //   1287: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1290: ldc_w 537
    //   1293: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1296: pop
    //   1297: goto -22 -> 1275
    //   1300: astore_1
    //   1301: aload_0
    //   1302: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1305: aload_1
    //   1306: athrow
    //   1307: aload 4
    //   1309: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1312: astore_0
    //   1313: aload_1
    //   1314: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1317: aload_3
    //   1318: ifnull +35 -> 1353
    //   1321: aload_3
    //   1322: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1325: aload_0
    //   1326: areturn
    //   1327: astore_0
    //   1328: aload 4
    //   1330: astore_3
    //   1331: goto -455 -> 876
    //   1334: astore_3
    //   1335: aconst_null
    //   1336: astore_0
    //   1337: aload 6
    //   1339: astore_1
    //   1340: goto -651 -> 689
    //   1343: astore 4
    //   1345: aload_3
    //   1346: astore_1
    //   1347: aload 4
    //   1349: astore_3
    //   1350: goto -661 -> 689
    //   1353: aload_0
    //   1354: areturn
    //   1355: aconst_null
    //   1356: astore 5
    //   1358: goto -780 -> 578
    //   1361: aconst_null
    //   1362: astore 4
    //   1364: goto -806 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1367	1	paramString	String
    //   1060	181	2	i	int
    //   37	1294	3	localObject1	Object
    //   1334	12	3	localException1	java.lang.Exception
    //   1349	1	3	localObject2	Object
    //   53	592	4	localObject3	Object
    //   680	7	4	localException2	java.lang.Exception
    //   690	378	4	localObject4	Object
    //   1077	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1137	192	4	localObject5	Object
    //   1343	5	4	localException3	java.lang.Exception
    //   1362	1	4	localObject6	Object
    //   44	1313	5	str1	String
    //   4	1334	6	localObject7	Object
    //   1	1135	7	localObject8	Object
    //   64	1046	8	localFile	java.io.File
    //   151	459	9	localObject9	Object
    //   252	606	10	localObject10	Object
    //   536	279	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   320	558	680	java/lang/Exception
    //   563	578	680	java/lang/Exception
    //   578	599	680	java/lang/Exception
    //   603	620	680	java/lang/Exception
    //   620	634	680	java/lang/Exception
    //   634	677	680	java/lang/Exception
    //   776	826	680	java/lang/Exception
    //   831	857	680	java/lang/Exception
    //   857	872	680	java/lang/Exception
    //   886	1054	680	java/lang/Exception
    //   1157	1203	680	java/lang/Exception
    //   1203	1217	680	java/lang/Exception
    //   1224	1256	680	java/lang/Exception
    //   1256	1275	680	java/lang/Exception
    //   1275	1280	680	java/lang/Exception
    //   1284	1297	680	java/lang/Exception
    //   1301	1307	680	java/lang/Exception
    //   1307	1313	680	java/lang/Exception
    //   79	153	733	java/lang/Exception
    //   153	165	733	java/lang/Exception
    //   165	224	733	java/lang/Exception
    //   320	558	875	finally
    //   563	578	875	finally
    //   578	599	875	finally
    //   603	620	875	finally
    //   620	634	875	finally
    //   634	677	875	finally
    //   776	826	875	finally
    //   831	857	875	finally
    //   857	872	875	finally
    //   886	1054	875	finally
    //   1157	1203	875	finally
    //   1203	1217	875	finally
    //   1224	1256	875	finally
    //   1256	1275	875	finally
    //   1275	1280	875	finally
    //   1284	1297	875	finally
    //   1301	1307	875	finally
    //   1307	1313	875	finally
    //   1313	1317	875	finally
    //   1054	1061	1077	java/lang/OutOfMemoryError
    //   1066	1074	1077	java/lang/OutOfMemoryError
    //   1054	1061	1300	finally
    //   1066	1074	1300	finally
    //   1079	1135	1300	finally
    //   235	243	1327	finally
    //   247	254	1327	finally
    //   258	273	1327	finally
    //   277	291	1327	finally
    //   295	300	1327	finally
    //   304	320	1327	finally
    //   692	721	1327	finally
    //   1139	1143	1327	finally
    //   235	243	1334	java/lang/Exception
    //   247	254	1334	java/lang/Exception
    //   258	273	1334	java/lang/Exception
    //   277	291	1334	java/lang/Exception
    //   295	300	1334	java/lang/Exception
    //   304	320	1334	java/lang/Exception
    //   1139	1143	1334	java/lang/Exception
    //   1313	1317	1343	java/lang/Exception
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
    //   10: new 63	bdha
    //   13: dup
    //   14: invokespecial 64	bdha:<init>	()V
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
    //   54: new 80	bdhc
    //   57: dup
    //   58: aload 9
    //   60: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   63: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   16: new 63	bdha
    //   19: dup
    //   20: invokespecial 64	bdha:<init>	()V
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
    //   58: new 80	bdhc
    //   61: dup
    //   62: aload 12
    //   64: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   51: getstatic 652	bdhn:o	Ljava/lang/String;
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
    //   94: new 63	bdha
    //   97: dup
    //   98: invokespecial 64	bdha:<init>	()V
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
    //   136: new 80	bdhc
    //   139: dup
    //   140: aload 8
    //   142: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   73: new 63	bdha
    //   76: dup
    //   77: invokespecial 64	bdha:<init>	()V
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
    //   114: new 80	bdhc
    //   117: dup
    //   118: aload 8
    //   120: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   123: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   54: ifnull +551 -> 605
    //   57: aload 8
    //   59: invokevirtual 362	java/io/File:exists	()Z
    //   62: ifeq +543 -> 605
    //   65: aload 5
    //   67: aload_2
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 7
    //   81: astore 5
    //   83: new 63	bdha
    //   86: dup
    //   87: invokespecial 64	bdha:<init>	()V
    //   90: astore 10
    //   92: aload 7
    //   94: astore 5
    //   96: ldc 66
    //   98: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   101: astore_2
    //   102: aload 7
    //   104: astore 5
    //   106: aload_2
    //   107: aconst_null
    //   108: iconst_1
    //   109: anewarray 74	javax/net/ssl/TrustManager
    //   112: dup
    //   113: iconst_0
    //   114: aload 10
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   121: aload 7
    //   123: astore 5
    //   125: new 80	bdhc
    //   128: dup
    //   129: aload_2
    //   130: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   133: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   136: astore 10
    //   138: aload 7
    //   140: astore 5
    //   142: aload 10
    //   144: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   147: aload 7
    //   149: astore 5
    //   151: new 94	java/net/URL
    //   154: dup
    //   155: aload 9
    //   157: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   160: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   163: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   166: astore_2
    //   167: aload_2
    //   168: aload 10
    //   170: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   173: aload_2
    //   174: sipush 5000
    //   177: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   180: aload_2
    //   181: sipush 30000
    //   184: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   187: aload_2
    //   188: iconst_1
    //   189: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   192: aload_2
    //   193: iconst_1
    //   194: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   197: aload_2
    //   198: iconst_0
    //   199: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   202: aload_2
    //   203: ldc_w 424
    //   206: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   209: aload_2
    //   210: ldc 128
    //   212: ldc 130
    //   214: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_2
    //   218: ldc 136
    //   220: new 49	java/lang/StringBuilder
    //   223: dup
    //   224: ldc 138
    //   226: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: ldc 141
    //   231: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   237: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 141
    //   242: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   248: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 141
    //   253: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   259: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 141
    //   264: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 157
    //   269: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 141
    //   274: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc 159
    //   279: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc 161
    //   284: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_2
    //   294: ldc 163
    //   296: ldc 165
    //   298: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_2
    //   302: ldc 167
    //   304: new 49	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   311: ldc 169
    //   313: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 171
    //   318: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: new 173	java/util/HashMap
    //   330: dup
    //   331: invokespecial 174	java/util/HashMap:<init>	()V
    //   334: astore 10
    //   336: aload 10
    //   338: ldc 128
    //   340: ldc 176
    //   342: invokeinterface 182 3 0
    //   347: pop
    //   348: aload 10
    //   350: ldc 184
    //   352: aload 9
    //   354: invokeinterface 182 3 0
    //   359: pop
    //   360: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   363: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   366: iconst_2
    //   367: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   370: checkcast 202	mqq/manager/TicketManager
    //   373: astore 5
    //   375: aload 5
    //   377: aload_3
    //   378: invokeinterface 206 2 0
    //   383: astore 11
    //   385: aload 9
    //   387: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   390: ifne +928 -> 1318
    //   393: aload 5
    //   395: aload_3
    //   396: ldc 208
    //   398: invokeinterface 212 3 0
    //   403: astore 5
    //   405: aload 8
    //   407: ifnull +906 -> 1313
    //   410: aload 8
    //   412: invokevirtual 362	java/io/File:exists	()Z
    //   415: ifeq +898 -> 1313
    //   418: aload_1
    //   419: invokestatic 364	bdit:a	(Ljava/lang/String;)Ljava/lang/String;
    //   422: astore_1
    //   423: aload 5
    //   425: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +188 -> 616
    //   431: ldc 32
    //   433: iconst_1
    //   434: ldc_w 426
    //   437: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   443: astore_1
    //   444: aload_1
    //   445: ifnull +20 -> 465
    //   448: aload 10
    //   450: ldc_w 276
    //   453: aload_1
    //   454: aload 9
    //   456: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   459: invokeinterface 182 3 0
    //   464: pop
    //   465: aload 10
    //   467: invokeinterface 228 1 0
    //   472: invokeinterface 234 1 0
    //   477: astore_1
    //   478: aload_1
    //   479: invokeinterface 239 1 0
    //   484: ifeq +240 -> 724
    //   487: aload_1
    //   488: invokeinterface 243 1 0
    //   493: checkcast 245	java/util/Map$Entry
    //   496: astore_3
    //   497: aload_2
    //   498: aload_3
    //   499: invokeinterface 248 1 0
    //   504: checkcast 250	java/lang/String
    //   507: aload_3
    //   508: invokeinterface 253 1 0
    //   513: checkcast 250	java/lang/String
    //   516: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -41 -> 478
    //   522: astore_3
    //   523: aconst_null
    //   524: astore_0
    //   525: aload_2
    //   526: astore_1
    //   527: aload_3
    //   528: astore_2
    //   529: aload_1
    //   530: astore 5
    //   532: ldc 255
    //   534: iconst_1
    //   535: new 49	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   542: ldc_w 428
    //   545: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_2
    //   549: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   552: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_0
    //   562: astore_2
    //   563: aload_1
    //   564: ifnull -533 -> 31
    //   567: aload_1
    //   568: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   571: aload_0
    //   572: areturn
    //   573: astore_0
    //   574: ldc 32
    //   576: iconst_1
    //   577: new 49	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 430
    //   587: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   594: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aconst_null
    //   604: areturn
    //   605: ldc 32
    //   607: iconst_1
    //   608: ldc_w 432
    //   611: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aconst_null
    //   615: areturn
    //   616: new 49	java/lang/StringBuilder
    //   619: dup
    //   620: new 49	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 434
    //   630: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 5
    //   635: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc_w 436
    //   641: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload_3
    //   645: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: ldc_w 438
    //   651: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 11
    //   656: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: astore_3
    //   666: aload_1
    //   667: ifnull +28 -> 695
    //   670: aload_3
    //   671: new 49	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   678: ldc_w 440
    //   681: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_1
    //   685: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 10
    //   697: ldc_w 276
    //   700: aload_3
    //   701: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokeinterface 182 3 0
    //   709: pop
    //   710: goto -245 -> 465
    //   713: astore_0
    //   714: aload_2
    //   715: ifnull +7 -> 722
    //   718: aload_2
    //   719: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   722: aload_0
    //   723: athrow
    //   724: new 442	java/io/DataOutputStream
    //   727: dup
    //   728: aload_2
    //   729: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   732: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   735: astore_1
    //   736: aload_0
    //   737: ifnull +130 -> 867
    //   740: new 49	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   747: astore_3
    //   748: aload_0
    //   749: invokevirtual 668	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   752: astore 10
    //   754: aload 10
    //   756: invokeinterface 239 1 0
    //   761: ifeq +95 -> 856
    //   764: aload 10
    //   766: invokeinterface 243 1 0
    //   771: checkcast 250	java/lang/String
    //   774: astore 5
    //   776: aload_0
    //   777: aload 5
    //   779: invokevirtual 619	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   782: astore 9
    //   784: aload 9
    //   786: ifnull -32 -> 754
    //   789: aload_3
    //   790: ldc_w 454
    //   793: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: ldc_w 459
    //   799: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: ldc 171
    //   804: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc_w 454
    //   810: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: pop
    //   814: aload_3
    //   815: new 49	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   822: ldc_w 461
    //   825: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 5
    //   830: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc_w 670
    //   836: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload_3
    //   847: aload 9
    //   849: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: goto -99 -> 754
    //   856: aload_1
    //   857: aload_3
    //   858: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokevirtual 477	java/lang/String:getBytes	()[B
    //   864: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   867: new 451	java/lang/StringBuffer
    //   870: dup
    //   871: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   874: astore_0
    //   875: aload_0
    //   876: ldc_w 454
    //   879: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   882: ldc_w 459
    //   885: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   888: ldc 171
    //   890: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   893: ldc_w 454
    //   896: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   899: pop
    //   900: aload_0
    //   901: ldc_w 461
    //   904: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   907: ldc_w 463
    //   910: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   913: ldc_w 465
    //   916: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   919: aload 8
    //   921: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   924: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   927: ldc_w 467
    //   930: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   933: ldc_w 454
    //   936: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   939: pop
    //   940: aload_0
    //   941: new 49	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   948: ldc_w 469
    //   951: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: ldc_w 471
    //   957: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: ldc_w 473
    //   963: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   972: pop
    //   973: aload_1
    //   974: aload_0
    //   975: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   978: invokevirtual 477	java/lang/String:getBytes	()[B
    //   981: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   984: new 482	java/io/BufferedInputStream
    //   987: dup
    //   988: new 482	java/io/BufferedInputStream
    //   991: dup
    //   992: new 484	java/io/FileInputStream
    //   995: dup
    //   996: aload 8
    //   998: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1001: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1004: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1007: astore_0
    //   1008: sipush 3072
    //   1011: newarray byte
    //   1013: astore_3
    //   1014: aload_0
    //   1015: aload_3
    //   1016: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   1019: istore 4
    //   1021: iload 4
    //   1023: iconst_m1
    //   1024: if_icmpeq +93 -> 1117
    //   1027: aload_1
    //   1028: aload_3
    //   1029: iconst_0
    //   1030: iload 4
    //   1032: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   1035: goto -21 -> 1014
    //   1038: astore_3
    //   1039: ldc 32
    //   1041: iconst_1
    //   1042: new 49	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 492
    //   1052: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 8
    //   1057: invokevirtual 495	java/io/File:length	()J
    //   1060: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1063: ldc_w 500
    //   1066: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload 8
    //   1071: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1074: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: aload_1
    //   1084: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1087: aload_1
    //   1088: invokevirtual 507	java/io/OutputStream:close	()V
    //   1091: aload_2
    //   1092: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1095: aload 7
    //   1097: astore 5
    //   1099: aload_0
    //   1100: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1103: iconst_0
    //   1104: ifeq +11 -> 1115
    //   1107: new 510	java/lang/NullPointerException
    //   1110: dup
    //   1111: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1114: athrow
    //   1115: aconst_null
    //   1116: areturn
    //   1117: aload_0
    //   1118: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1121: aload_1
    //   1122: new 49	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1129: ldc_w 513
    //   1132: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: ldc 171
    //   1137: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: ldc_w 515
    //   1143: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1152: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1155: aload_1
    //   1156: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1159: aload_1
    //   1160: invokevirtual 507	java/io/OutputStream:close	()V
    //   1163: new 451	java/lang/StringBuffer
    //   1166: dup
    //   1167: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1170: astore_0
    //   1171: aload_2
    //   1172: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1175: istore 4
    //   1177: iload 4
    //   1179: sipush 200
    //   1182: if_icmpeq +36 -> 1218
    //   1185: ldc 32
    //   1187: iconst_1
    //   1188: new 49	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1195: ldc_w 520
    //   1198: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: iload 4
    //   1203: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: ldc_w 522
    //   1209: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: new 526	java/io/BufferedReader
    //   1221: dup
    //   1222: new 528	java/io/InputStreamReader
    //   1225: dup
    //   1226: aload_2
    //   1227: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1230: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1233: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1236: astore_1
    //   1237: aload_1
    //   1238: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1241: astore_3
    //   1242: aload_3
    //   1243: ifnull +25 -> 1268
    //   1246: aload_0
    //   1247: aload_3
    //   1248: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1251: ldc_w 537
    //   1254: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1257: pop
    //   1258: goto -21 -> 1237
    //   1261: astore_1
    //   1262: aload_0
    //   1263: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1266: aload_1
    //   1267: athrow
    //   1268: aload_0
    //   1269: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1272: astore_0
    //   1273: aload_1
    //   1274: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1277: aload_2
    //   1278: ifnull +33 -> 1311
    //   1281: aload_2
    //   1282: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1285: aload_0
    //   1286: areturn
    //   1287: astore_0
    //   1288: aload 5
    //   1290: astore_2
    //   1291: goto -577 -> 714
    //   1294: astore_2
    //   1295: aconst_null
    //   1296: astore_0
    //   1297: aload 6
    //   1299: astore_1
    //   1300: goto -771 -> 529
    //   1303: astore_3
    //   1304: aload_2
    //   1305: astore_1
    //   1306: aload_3
    //   1307: astore_2
    //   1308: goto -779 -> 529
    //   1311: aload_0
    //   1312: areturn
    //   1313: aconst_null
    //   1314: astore_1
    //   1315: goto -892 -> 423
    //   1318: aconst_null
    //   1319: astore 5
    //   1321: goto -916 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1324	0	paramJSONObject	JSONObject
    //   0	1324	1	paramString1	String
    //   0	1324	2	paramString2	String
    //   0	1324	3	paramString3	String
    //   1019	183	4	i	int
    //   40	1280	5	localObject1	Object
    //   4	1294	6	localObject2	Object
    //   1	1095	7	localObject3	Object
    //   50	1020	8	localFile	java.io.File
    //   77	771	9	str1	String
    //   90	675	10	localObject4	Object
    //   383	272	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   167	405	522	java/lang/Exception
    //   410	423	522	java/lang/Exception
    //   423	444	522	java/lang/Exception
    //   448	465	522	java/lang/Exception
    //   465	478	522	java/lang/Exception
    //   478	519	522	java/lang/Exception
    //   616	666	522	java/lang/Exception
    //   670	695	522	java/lang/Exception
    //   695	710	522	java/lang/Exception
    //   724	736	522	java/lang/Exception
    //   740	754	522	java/lang/Exception
    //   754	784	522	java/lang/Exception
    //   789	853	522	java/lang/Exception
    //   856	867	522	java/lang/Exception
    //   867	1014	522	java/lang/Exception
    //   1117	1177	522	java/lang/Exception
    //   1185	1218	522	java/lang/Exception
    //   1218	1237	522	java/lang/Exception
    //   1237	1242	522	java/lang/Exception
    //   1246	1258	522	java/lang/Exception
    //   1262	1268	522	java/lang/Exception
    //   1268	1273	522	java/lang/Exception
    //   65	72	573	java/lang/Exception
    //   167	405	713	finally
    //   410	423	713	finally
    //   423	444	713	finally
    //   448	465	713	finally
    //   465	478	713	finally
    //   478	519	713	finally
    //   616	666	713	finally
    //   670	695	713	finally
    //   695	710	713	finally
    //   724	736	713	finally
    //   740	754	713	finally
    //   754	784	713	finally
    //   789	853	713	finally
    //   856	867	713	finally
    //   867	1014	713	finally
    //   1117	1177	713	finally
    //   1185	1218	713	finally
    //   1218	1237	713	finally
    //   1237	1242	713	finally
    //   1246	1258	713	finally
    //   1262	1268	713	finally
    //   1268	1273	713	finally
    //   1273	1277	713	finally
    //   1014	1021	1038	java/lang/OutOfMemoryError
    //   1027	1035	1038	java/lang/OutOfMemoryError
    //   1014	1021	1261	finally
    //   1027	1035	1261	finally
    //   1039	1095	1261	finally
    //   83	92	1287	finally
    //   96	102	1287	finally
    //   106	121	1287	finally
    //   125	138	1287	finally
    //   142	147	1287	finally
    //   151	167	1287	finally
    //   532	561	1287	finally
    //   1099	1103	1287	finally
    //   83	92	1294	java/lang/Exception
    //   96	102	1294	java/lang/Exception
    //   106	121	1294	java/lang/Exception
    //   125	138	1294	java/lang/Exception
    //   142	147	1294	java/lang/Exception
    //   151	167	1294	java/lang/Exception
    //   1099	1103	1294	java/lang/Exception
    //   1273	1277	1303	java/lang/Exception
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
    //   28: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   31: checkcast 676	bdjj
    //   34: astore 15
    //   36: aload 15
    //   38: iconst_2
    //   39: iconst_1
    //   40: aconst_null
    //   41: invokevirtual 677	bdjj:notifyUI	(IZLjava/lang/Object;)V
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
    //   60: invokevirtual 677	bdjj:notifyUI	(IZLjava/lang/Object;)V
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
    //   110: new 63	bdha
    //   113: dup
    //   114: invokespecial 64	bdha:<init>	()V
    //   117: astore 13
    //   119: aload_0
    //   120: astore 10
    //   122: aload 12
    //   124: astore 11
    //   126: ldc 66
    //   128: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   131: astore 18
    //   133: aload_0
    //   134: astore 10
    //   136: aload 12
    //   138: astore 11
    //   140: aload 18
    //   142: aconst_null
    //   143: iconst_1
    //   144: anewarray 74	javax/net/ssl/TrustManager
    //   147: dup
    //   148: iconst_0
    //   149: aload 13
    //   151: aastore
    //   152: aconst_null
    //   153: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   156: aload_0
    //   157: astore 10
    //   159: aload 12
    //   161: astore 11
    //   163: new 80	bdhc
    //   166: dup
    //   167: aload 18
    //   169: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   172: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   598: invokestatic 364	bdit:a	(Ljava/lang/String;)Ljava/lang/String;
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
    //   687: astore_1
    //   688: aload_0
    //   689: astore 10
    //   691: aload_0
    //   692: astore 11
    //   694: aload_1
    //   695: invokeinterface 239 1 0
    //   700: ifeq +220 -> 920
    //   703: aload_0
    //   704: astore 10
    //   706: aload_0
    //   707: astore 11
    //   709: aload_1
    //   710: invokeinterface 243 1 0
    //   715: checkcast 245	java/util/Map$Entry
    //   718: astore_2
    //   719: aload_0
    //   720: astore 10
    //   722: aload_0
    //   723: astore 11
    //   725: aload_0
    //   726: aload_2
    //   727: invokeinterface 248 1 0
    //   732: checkcast 250	java/lang/String
    //   735: aload_2
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
    //   1217: invokevirtual 677	bdjj:notifyUI	(IZLjava/lang/Object;)V
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
    //   1278: invokevirtual 677	bdjj:notifyUI	(IZLjava/lang/Object;)V
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
    //   1304: invokespecial 693	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1:<init>	([ILbdjj;)V
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
    //   1598: invokevirtual 677	bdjj:notifyUI	(IZLjava/lang/Object;)V
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
    //   117	743	13	localObject7	Object
    //   101	799	14	localObject8	Object
    //   34	1549	15	localbdjj	bdjj
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
    //   43: astore_3
    //   44: new 335	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   52: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 654	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   61: astore 4
    //   63: aload 7
    //   65: ifnull +588 -> 653
    //   68: aload 7
    //   70: invokevirtual 362	java/io/File:exists	()Z
    //   73: ifeq +580 -> 653
    //   76: aload_3
    //   77: ldc_w 366
    //   80: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: getstatic 718	bdhn:n	Ljava/lang/String;
    //   90: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +16 -> 115
    //   102: aload_3
    //   103: ldc_w 656
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_3
    //   116: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 8
    //   121: aload 6
    //   123: astore 4
    //   125: new 63	bdha
    //   128: dup
    //   129: invokespecial 64	bdha:<init>	()V
    //   132: astore_3
    //   133: aload 6
    //   135: astore 4
    //   137: ldc 66
    //   139: invokestatic 72	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   142: astore 9
    //   144: aload 6
    //   146: astore 4
    //   148: aload 9
    //   150: aconst_null
    //   151: iconst_1
    //   152: anewarray 74	javax/net/ssl/TrustManager
    //   155: dup
    //   156: iconst_0
    //   157: aload_3
    //   158: aastore
    //   159: aconst_null
    //   160: invokevirtual 78	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   163: aload 6
    //   165: astore 4
    //   167: new 80	bdhc
    //   170: dup
    //   171: aload 9
    //   173: invokevirtual 84	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   176: invokespecial 87	bdhc:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   179: astore 9
    //   181: aload 6
    //   183: astore 4
    //   185: aload 9
    //   187: invokestatic 92	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   190: aload 6
    //   192: astore 4
    //   194: new 94	java/net/URL
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   203: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   206: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   209: astore_3
    //   210: aload_3
    //   211: aload 9
    //   213: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   216: aload_3
    //   217: sipush 5000
    //   220: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   223: aload_3
    //   224: sipush 30000
    //   227: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   230: aload_3
    //   231: iconst_1
    //   232: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   235: aload_3
    //   236: iconst_1
    //   237: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   240: aload_3
    //   241: iconst_0
    //   242: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   245: aload_3
    //   246: ldc_w 424
    //   249: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: ldc 128
    //   255: ldc 130
    //   257: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_3
    //   261: ldc 136
    //   263: new 49	java/lang/StringBuilder
    //   266: dup
    //   267: ldc 138
    //   269: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: ldc 141
    //   274: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 147	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   280: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 141
    //   285: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: getstatic 152	android/os/Build:DEVICE	Ljava/lang/String;
    //   291: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 141
    //   296: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: getstatic 155	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   302: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 141
    //   307: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 157
    //   312: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 141
    //   317: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 159
    //   322: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 161
    //   327: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload_3
    //   337: ldc 163
    //   339: ldc 165
    //   341: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_3
    //   345: ldc 167
    //   347: new 49	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   354: ldc 169
    //   356: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 171
    //   361: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: new 173	java/util/HashMap
    //   373: dup
    //   374: invokespecial 174	java/util/HashMap:<init>	()V
    //   377: astore 9
    //   379: aload 9
    //   381: ldc 128
    //   383: ldc 176
    //   385: invokeinterface 182 3 0
    //   390: pop
    //   391: aload 9
    //   393: ldc 184
    //   395: aload 8
    //   397: invokeinterface 182 3 0
    //   402: pop
    //   403: invokestatic 190	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   406: invokevirtual 194	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   409: iconst_2
    //   410: invokevirtual 200	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   413: checkcast 202	mqq/manager/TicketManager
    //   416: astore 4
    //   418: aload 4
    //   420: aload_1
    //   421: invokeinterface 206 2 0
    //   426: astore 10
    //   428: aload 8
    //   430: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifne +799 -> 1232
    //   436: aload 4
    //   438: aload_1
    //   439: ldc 208
    //   441: invokeinterface 212 3 0
    //   446: astore 4
    //   448: aload 7
    //   450: ifnull +777 -> 1227
    //   453: aload 7
    //   455: invokevirtual 362	java/io/File:exists	()Z
    //   458: ifeq +769 -> 1227
    //   461: aload_0
    //   462: getfield 357	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   465: invokestatic 364	bdit:a	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore_0
    //   469: aload 4
    //   471: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifeq +190 -> 664
    //   477: ldc 32
    //   479: iconst_1
    //   480: ldc_w 426
    //   483: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: invokestatic 219	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   489: astore_0
    //   490: aload_0
    //   491: ifnull +20 -> 511
    //   494: aload 9
    //   496: ldc_w 276
    //   499: aload_0
    //   500: aload 8
    //   502: invokevirtual 224	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   505: invokeinterface 182 3 0
    //   510: pop
    //   511: aload 9
    //   513: invokeinterface 228 1 0
    //   518: invokeinterface 234 1 0
    //   523: astore_0
    //   524: aload_0
    //   525: invokeinterface 239 1 0
    //   530: ifeq +242 -> 772
    //   533: aload_0
    //   534: invokeinterface 243 1 0
    //   539: checkcast 245	java/util/Map$Entry
    //   542: astore_1
    //   543: aload_3
    //   544: aload_1
    //   545: invokeinterface 248 1 0
    //   550: checkcast 250	java/lang/String
    //   553: aload_1
    //   554: invokeinterface 253 1 0
    //   559: checkcast 250	java/lang/String
    //   562: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: goto -41 -> 524
    //   568: astore 4
    //   570: aconst_null
    //   571: astore_0
    //   572: aload_3
    //   573: astore_1
    //   574: aload 4
    //   576: astore_3
    //   577: aload_1
    //   578: astore 4
    //   580: ldc 255
    //   582: iconst_1
    //   583: new 49	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 428
    //   593: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_3
    //   597: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   600: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_0
    //   610: astore_3
    //   611: aload_1
    //   612: ifnull -578 -> 34
    //   615: aload_1
    //   616: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   619: aload_0
    //   620: areturn
    //   621: astore_0
    //   622: ldc 32
    //   624: iconst_1
    //   625: new 49	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 430
    //   635: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_0
    //   639: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   642: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: aconst_null
    //   652: areturn
    //   653: ldc 32
    //   655: iconst_1
    //   656: ldc_w 432
    //   659: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: aconst_null
    //   663: areturn
    //   664: new 49	java/lang/StringBuilder
    //   667: dup
    //   668: new 49	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 434
    //   678: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 4
    //   683: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc_w 436
    //   689: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_1
    //   693: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 438
    //   699: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 10
    //   704: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   713: astore_1
    //   714: aload_0
    //   715: ifnull +28 -> 743
    //   718: aload_1
    //   719: new 49	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 440
    //   729: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_0
    //   733: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 9
    //   745: ldc_w 276
    //   748: aload_1
    //   749: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokeinterface 182 3 0
    //   757: pop
    //   758: goto -247 -> 511
    //   761: astore_0
    //   762: aload_3
    //   763: ifnull +7 -> 770
    //   766: aload_3
    //   767: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   770: aload_0
    //   771: athrow
    //   772: new 442	java/io/DataOutputStream
    //   775: dup
    //   776: aload_3
    //   777: invokevirtual 446	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   780: invokespecial 449	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   783: astore_1
    //   784: new 451	java/lang/StringBuffer
    //   787: dup
    //   788: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   791: astore_0
    //   792: aload_0
    //   793: ldc_w 454
    //   796: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   799: ldc_w 459
    //   802: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   805: ldc 171
    //   807: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   810: ldc_w 454
    //   813: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   816: pop
    //   817: aload_0
    //   818: ldc_w 461
    //   821: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   824: ldc_w 463
    //   827: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   830: ldc_w 465
    //   833: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   836: aload 7
    //   838: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   841: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   844: ldc_w 720
    //   847: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   850: pop
    //   851: aload_0
    //   852: new 49	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   859: ldc_w 469
    //   862: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc_w 471
    //   868: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc_w 473
    //   874: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   883: pop
    //   884: aload_1
    //   885: aload_0
    //   886: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   889: invokevirtual 477	java/lang/String:getBytes	()[B
    //   892: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   895: new 482	java/io/BufferedInputStream
    //   898: dup
    //   899: new 482	java/io/BufferedInputStream
    //   902: dup
    //   903: new 484	java/io/FileInputStream
    //   906: dup
    //   907: aload 7
    //   909: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   912: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   915: invokespecial 488	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   918: astore_0
    //   919: sipush 3072
    //   922: newarray byte
    //   924: astore 4
    //   926: aload_0
    //   927: aload 4
    //   929: invokevirtual 489	java/io/BufferedInputStream:read	([B)I
    //   932: istore_2
    //   933: iload_2
    //   934: iconst_m1
    //   935: if_icmpeq +94 -> 1029
    //   938: aload_1
    //   939: aload 4
    //   941: iconst_0
    //   942: iload_2
    //   943: invokevirtual 490	java/io/OutputStream:write	([BII)V
    //   946: goto -20 -> 926
    //   949: astore 4
    //   951: ldc 32
    //   953: iconst_1
    //   954: new 49	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   961: ldc_w 492
    //   964: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload 7
    //   969: invokevirtual 495	java/io/File:length	()J
    //   972: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   975: ldc_w 500
    //   978: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload 7
    //   983: invokevirtual 503	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   986: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokestatic 40	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   995: aload_1
    //   996: invokevirtual 506	java/io/OutputStream:flush	()V
    //   999: aload_1
    //   1000: invokevirtual 507	java/io/OutputStream:close	()V
    //   1003: aload_3
    //   1004: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1007: aload 6
    //   1009: astore 4
    //   1011: aload_0
    //   1012: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1015: iconst_0
    //   1016: ifeq +11 -> 1027
    //   1019: new 510	java/lang/NullPointerException
    //   1022: dup
    //   1023: invokespecial 511	java/lang/NullPointerException:<init>	()V
    //   1026: athrow
    //   1027: aconst_null
    //   1028: areturn
    //   1029: aload_0
    //   1030: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1033: aload_1
    //   1034: new 49	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1041: ldc_w 513
    //   1044: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc 171
    //   1049: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc_w 515
    //   1055: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokevirtual 477	java/lang/String:getBytes	()[B
    //   1064: invokevirtual 480	java/io/OutputStream:write	([B)V
    //   1067: aload_1
    //   1068: invokevirtual 506	java/io/OutputStream:flush	()V
    //   1071: aload_1
    //   1072: invokevirtual 507	java/io/OutputStream:close	()V
    //   1075: new 451	java/lang/StringBuffer
    //   1078: dup
    //   1079: invokespecial 452	java/lang/StringBuffer:<init>	()V
    //   1082: astore 4
    //   1084: aload_3
    //   1085: invokevirtual 518	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1088: istore_2
    //   1089: iload_2
    //   1090: sipush 200
    //   1093: if_icmpeq +35 -> 1128
    //   1096: ldc 32
    //   1098: iconst_1
    //   1099: new 49	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 520
    //   1109: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: iload_2
    //   1113: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: ldc_w 522
    //   1119: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1125: invokestatic 524	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1128: new 526	java/io/BufferedReader
    //   1131: dup
    //   1132: new 528	java/io/InputStreamReader
    //   1135: dup
    //   1136: aload_3
    //   1137: invokevirtual 289	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1140: invokespecial 529	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1143: invokespecial 532	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1146: astore_1
    //   1147: aload_1
    //   1148: invokevirtual 535	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1151: astore_0
    //   1152: aload_0
    //   1153: ifnull +26 -> 1179
    //   1156: aload 4
    //   1158: aload_0
    //   1159: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1162: ldc_w 537
    //   1165: invokevirtual 457	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1168: pop
    //   1169: goto -22 -> 1147
    //   1172: astore_1
    //   1173: aload_0
    //   1174: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   1177: aload_1
    //   1178: athrow
    //   1179: aload 4
    //   1181: invokevirtual 474	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1184: astore_0
    //   1185: aload_1
    //   1186: invokevirtual 538	java/io/BufferedReader:close	()V
    //   1189: aload_3
    //   1190: ifnull +35 -> 1225
    //   1193: aload_3
    //   1194: invokevirtual 274	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1197: aload_0
    //   1198: areturn
    //   1199: astore_0
    //   1200: aload 4
    //   1202: astore_3
    //   1203: goto -441 -> 762
    //   1206: astore_3
    //   1207: aconst_null
    //   1208: astore_0
    //   1209: aload 5
    //   1211: astore_1
    //   1212: goto -635 -> 577
    //   1215: astore 4
    //   1217: aload_3
    //   1218: astore_1
    //   1219: aload 4
    //   1221: astore_3
    //   1222: goto -645 -> 577
    //   1225: aload_0
    //   1226: areturn
    //   1227: aconst_null
    //   1228: astore_0
    //   1229: goto -760 -> 469
    //   1232: aconst_null
    //   1233: astore 4
    //   1235: goto -787 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1238	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1238	1	paramString	String
    //   932	181	2	i	int
    //   33	1170	3	localObject1	Object
    //   1206	12	3	localException1	java.lang.Exception
    //   1221	1	3	localObject2	Object
    //   61	409	4	localObject3	Object
    //   568	7	4	localException2	java.lang.Exception
    //   578	362	4	localObject4	Object
    //   949	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1009	192	4	localObject5	Object
    //   1215	5	4	localException3	java.lang.Exception
    //   1233	1	4	localObject6	Object
    //   4	1206	5	localObject7	Object
    //   1	1007	6	localObject8	Object
    //   55	927	7	localFile	java.io.File
    //   119	382	8	str1	String
    //   142	602	9	localObject9	Object
    //   426	277	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   210	448	568	java/lang/Exception
    //   453	469	568	java/lang/Exception
    //   469	490	568	java/lang/Exception
    //   494	511	568	java/lang/Exception
    //   511	524	568	java/lang/Exception
    //   524	565	568	java/lang/Exception
    //   664	714	568	java/lang/Exception
    //   718	743	568	java/lang/Exception
    //   743	758	568	java/lang/Exception
    //   772	926	568	java/lang/Exception
    //   1029	1089	568	java/lang/Exception
    //   1096	1128	568	java/lang/Exception
    //   1128	1147	568	java/lang/Exception
    //   1147	1152	568	java/lang/Exception
    //   1156	1169	568	java/lang/Exception
    //   1173	1179	568	java/lang/Exception
    //   1179	1185	568	java/lang/Exception
    //   76	115	621	java/lang/Exception
    //   210	448	761	finally
    //   453	469	761	finally
    //   469	490	761	finally
    //   494	511	761	finally
    //   511	524	761	finally
    //   524	565	761	finally
    //   664	714	761	finally
    //   718	743	761	finally
    //   743	758	761	finally
    //   772	926	761	finally
    //   1029	1089	761	finally
    //   1096	1128	761	finally
    //   1128	1147	761	finally
    //   1147	1152	761	finally
    //   1156	1169	761	finally
    //   1173	1179	761	finally
    //   1179	1185	761	finally
    //   1185	1189	761	finally
    //   926	933	949	java/lang/OutOfMemoryError
    //   938	946	949	java/lang/OutOfMemoryError
    //   926	933	1172	finally
    //   938	946	1172	finally
    //   951	1007	1172	finally
    //   125	133	1199	finally
    //   137	144	1199	finally
    //   148	163	1199	finally
    //   167	181	1199	finally
    //   185	190	1199	finally
    //   194	210	1199	finally
    //   580	609	1199	finally
    //   1011	1015	1199	finally
    //   125	133	1206	java/lang/Exception
    //   137	144	1206	java/lang/Exception
    //   148	163	1206	java/lang/Exception
    //   167	181	1206	java/lang/Exception
    //   185	190	1206	java/lang/Exception
    //   194	210	1206	java/lang/Exception
    //   1011	1015	1206	java/lang/Exception
    //   1185	1189	1215	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdit
 * JD-Core Version:    0.7.0.1
 */