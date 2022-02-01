import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.utils.NetworkUtils;
import cooperation.weiyun.upload.WyUploadJob;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class bnal
  implements bnaj
{
  protected int a;
  private long jdField_a_of_type_Long;
  private final bnak jdField_a_of_type_Bnak;
  protected final UploadRequest a;
  protected final WyUploadJob a;
  public ArrayList<SoftReference<bnam>> a;
  protected DefaultHttpClient a;
  protected final byte[] a;
  protected int b;
  private long b;
  protected final byte[] b;
  protected int c;
  protected int d = 4;
  
  public bnal(UploadRequest paramUploadRequest, WyUploadJob paramWyUploadJob)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest = paramUploadRequest;
    this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob = paramWyUploadJob;
    this.jdField_a_of_type_ArrayOfByte = bnau.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.checkKey());
    this.jdField_b_of_type_ArrayOfByte = bnau.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.sha());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.size();
    this.jdField_a_of_type_Bnak = new bnak();
    try
    {
      this.jdField_a_of_type_Bnak.jdField_a_of_type_JavaLangString = a().toString();
      label99:
      this.jdField_a_of_type_Bnak.jdField_a_of_type_Int = a(new Object[] { this.jdField_a_of_type_Bnak.jdField_a_of_type_JavaLangString, this });
      this.jdField_a_of_type_Bnak.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadRequest)
    {
      break label99;
    }
  }
  
  public static int a(Context paramContext)
  {
    int i = NetworkUtils.getNetworkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  public static int a(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + new Random().nextInt();
  }
  
  private static String a(int paramInt)
  {
    return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetworkType(BaseApplicationImpl.getApplication())), Integer.valueOf(paramInt) });
  }
  
  private URL a()
  {
    if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {
      return new URL("https", "upload.weiyun.com", a(31532));
    }
    return new URL("http", this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverIp(), this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverPort(), a(31532));
  }
  
  private HttpPost a(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient == null) {
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = bmyn.a();
    }
    bmyn.a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_Int);
    return paramURL;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient != null)
    {
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = null;
    }
  }
  
  public int a()
  {
    return b();
  }
  
  /* Error */
  int a(bnai parambnai, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 234	bnal:a	()Lbnam;
    //   4: astore 20
    //   6: aconst_null
    //   7: astore 17
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 206	bnal:jdField_a_of_type_Int	I
    //   14: iconst_0
    //   15: istore 10
    //   17: iconst_0
    //   18: istore 8
    //   20: iconst_0
    //   21: istore 12
    //   23: iconst_0
    //   24: istore 9
    //   26: iload 12
    //   28: iconst_3
    //   29: if_icmplt +22 -> 51
    //   32: iload 9
    //   34: istore 11
    //   36: iload 10
    //   38: ifeq +1179 -> 1217
    //   41: iload 9
    //   43: istore 11
    //   45: iload 8
    //   47: iconst_3
    //   48: if_icmpge +1169 -> 1217
    //   51: aload_0
    //   52: getfield 37	bnal:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   55: invokevirtual 239	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   58: ifne +26 -> 84
    //   61: ldc 240
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +1086 -> 1153
    //   70: iconst_1
    //   71: istore 14
    //   73: aload_0
    //   74: aload 20
    //   76: iload 14
    //   78: invokevirtual 243	bnal:a	(Lbnam;Z)V
    //   81: iload 4
    //   83: ireturn
    //   84: iload 5
    //   86: sipush 8192
    //   89: if_icmple +1121 -> 1210
    //   92: iload 12
    //   94: i2d
    //   95: dstore 6
    //   97: iload 5
    //   99: ldc2_w 244
    //   102: dload 6
    //   104: invokestatic 251	java/lang/Math:pow	(DD)D
    //   107: d2i
    //   108: idiv
    //   109: sipush 8192
    //   112: invokestatic 255	java/lang/Math:max	(II)I
    //   115: istore 11
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 57	bnal:jdField_a_of_type_Long	J
    //   122: iload 11
    //   124: aload_3
    //   125: iconst_0
    //   126: iload 4
    //   128: invokevirtual 260	bnai:a	(JI[BII)I
    //   131: istore 13
    //   133: aload_0
    //   134: aload_2
    //   135: invokespecial 262	bnal:a	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   138: astore 18
    //   140: aload 18
    //   142: new 264	bnah
    //   145: dup
    //   146: aload_3
    //   147: iconst_0
    //   148: iload 13
    //   150: iload 11
    //   152: iadd
    //   153: invokespecial 267	bnah:<init>	([BII)V
    //   156: invokevirtual 271	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   159: iconst_0
    //   160: istore 13
    //   162: aload_0
    //   163: getfield 200	bnal:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   166: aload 18
    //   168: invokevirtual 275	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   171: astore 18
    //   173: aload 18
    //   175: astore 17
    //   177: aload 17
    //   179: ifnonnull +59 -> 238
    //   182: aload 17
    //   184: astore 18
    //   186: aload_0
    //   187: invokespecial 277	bnal:a	()V
    //   190: iload 9
    //   192: istore 10
    //   194: aload 17
    //   196: ifnull +1039 -> 1235
    //   199: iload 9
    //   201: istore 10
    //   203: aload 17
    //   205: invokeinterface 283 1 0
    //   210: ifnull +1025 -> 1235
    //   213: aload 17
    //   215: invokeinterface 283 1 0
    //   220: invokeinterface 288 1 0
    //   225: iload 13
    //   227: istore 10
    //   229: iload 12
    //   231: iconst_1
    //   232: iadd
    //   233: istore 12
    //   235: goto -209 -> 26
    //   238: aload 17
    //   240: astore 18
    //   242: aload 17
    //   244: invokeinterface 292 1 0
    //   249: invokeinterface 297 1 0
    //   254: istore 9
    //   256: iload 9
    //   258: sipush 200
    //   261: if_icmpeq +118 -> 379
    //   264: iload 9
    //   266: ldc_w 298
    //   269: iadd
    //   270: istore 10
    //   272: aload 17
    //   274: astore 18
    //   276: aload 17
    //   278: ldc_w 300
    //   281: invokeinterface 304 2 0
    //   286: astore 19
    //   288: iload 10
    //   290: istore 9
    //   292: aload 19
    //   294: ifnull +35 -> 329
    //   297: iload 10
    //   299: istore 9
    //   301: aload 17
    //   303: astore 18
    //   305: aload 19
    //   307: arraylength
    //   308: ifle +21 -> 329
    //   311: aload 17
    //   313: astore 18
    //   315: aload 19
    //   317: iconst_0
    //   318: aaload
    //   319: invokeinterface 309 1 0
    //   324: invokestatic 313	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   327: istore 9
    //   329: aload 17
    //   331: astore 18
    //   333: aload_0
    //   334: invokespecial 277	bnal:a	()V
    //   337: iload 9
    //   339: istore 10
    //   341: aload 17
    //   343: ifnull +892 -> 1235
    //   346: iload 9
    //   348: istore 10
    //   350: aload 17
    //   352: invokeinterface 283 1 0
    //   357: ifnull +878 -> 1235
    //   360: aload 17
    //   362: invokeinterface 283 1 0
    //   367: invokeinterface 288 1 0
    //   372: iload 13
    //   374: istore 10
    //   376: goto -147 -> 229
    //   379: aload 17
    //   381: astore 18
    //   383: new 315	java/io/BufferedInputStream
    //   386: dup
    //   387: aload 17
    //   389: invokeinterface 283 1 0
    //   394: invokeinterface 319 1 0
    //   399: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   402: aload 20
    //   404: getfield 325	bnam:jdField_a_of_type_ArrayOfByte	[B
    //   407: invokevirtual 331	java/io/InputStream:read	([B)I
    //   410: istore 10
    //   412: iload 10
    //   414: ifgt +55 -> 469
    //   417: ldc_w 332
    //   420: istore 9
    //   422: iload 9
    //   424: istore 10
    //   426: aload 17
    //   428: ifnull +807 -> 1235
    //   431: iload 9
    //   433: istore 10
    //   435: aload 17
    //   437: invokeinterface 283 1 0
    //   442: ifnull +793 -> 1235
    //   445: aload 17
    //   447: invokeinterface 283 1 0
    //   452: invokeinterface 288 1 0
    //   457: ldc_w 332
    //   460: istore 9
    //   462: iload 13
    //   464: istore 10
    //   466: goto -237 -> 229
    //   469: iload 9
    //   471: sipush 200
    //   474: if_icmpne +177 -> 651
    //   477: iconst_1
    //   478: istore 14
    //   480: aload 17
    //   482: astore 18
    //   484: aload_1
    //   485: iload 14
    //   487: aload 20
    //   489: getfield 325	bnam:jdField_a_of_type_ArrayOfByte	[B
    //   492: iload 10
    //   494: invokevirtual 335	bnai:a	(Z[BI)I
    //   497: istore 9
    //   499: iload 9
    //   501: ifne +392 -> 893
    //   504: aload 17
    //   506: astore 18
    //   508: aload_0
    //   509: iconst_0
    //   510: putfield 206	bnal:jdField_a_of_type_Int	I
    //   513: aload 17
    //   515: astore 18
    //   517: aload_0
    //   518: iload 11
    //   520: putfield 337	bnal:jdField_b_of_type_Int	I
    //   523: iload 12
    //   525: ifne +57 -> 582
    //   528: aload 17
    //   530: astore 18
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 339	bnal:c	I
    //   537: iconst_1
    //   538: iadd
    //   539: putfield 339	bnal:c	I
    //   542: aload 17
    //   544: astore 18
    //   546: aload_0
    //   547: getfield 339	bnal:c	I
    //   550: aload_0
    //   551: getfield 28	bnal:d	I
    //   554: if_icmplt +28 -> 582
    //   557: aload 17
    //   559: astore 18
    //   561: aload_0
    //   562: aload_0
    //   563: getfield 337	bnal:jdField_b_of_type_Int	I
    //   566: sipush 8192
    //   569: iadd
    //   570: putfield 337	bnal:jdField_b_of_type_Int	I
    //   573: aload 17
    //   575: astore 18
    //   577: aload_0
    //   578: iconst_0
    //   579: putfield 339	bnal:c	I
    //   582: aload 17
    //   584: astore 18
    //   586: aload_0
    //   587: getfield 337	bnal:jdField_b_of_type_Int	I
    //   590: sipush 8192
    //   593: if_icmpge +64 -> 657
    //   596: aload 17
    //   598: astore 18
    //   600: aload_0
    //   601: sipush 8192
    //   604: putfield 337	bnal:jdField_b_of_type_Int	I
    //   607: iconst_0
    //   608: istore 4
    //   610: iload 4
    //   612: istore 11
    //   614: aload 17
    //   616: ifnull +601 -> 1217
    //   619: iload 4
    //   621: istore 11
    //   623: aload 17
    //   625: invokeinterface 283 1 0
    //   630: ifnull +587 -> 1217
    //   633: aload 17
    //   635: invokeinterface 283 1 0
    //   640: invokeinterface 288 1 0
    //   645: iconst_0
    //   646: istore 4
    //   648: goto -583 -> 65
    //   651: iconst_0
    //   652: istore 14
    //   654: goto -174 -> 480
    //   657: aload 17
    //   659: astore 18
    //   661: aload_0
    //   662: getfield 337	bnal:jdField_b_of_type_Int	I
    //   665: ldc 99
    //   667: if_icmple -60 -> 607
    //   670: aload 17
    //   672: astore 18
    //   674: aload_0
    //   675: ldc 99
    //   677: putfield 337	bnal:jdField_b_of_type_Int	I
    //   680: goto -73 -> 607
    //   683: astore 19
    //   685: iconst_0
    //   686: istore 10
    //   688: aload 17
    //   690: astore 18
    //   692: aload_0
    //   693: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   696: aload 19
    //   698: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   701: aload 17
    //   703: astore 18
    //   705: aload 19
    //   707: invokestatic 348	com/tencent/weiyun/transmission/utils/ErrorCodeUtil:getErrorCode4IOException	(Ljava/io/IOException;)I
    //   710: istore 13
    //   712: iload 10
    //   714: istore 11
    //   716: iload 13
    //   718: istore 9
    //   720: aload 17
    //   722: astore 18
    //   724: aload 17
    //   726: ifnull +49 -> 775
    //   729: iload 10
    //   731: istore 11
    //   733: iload 13
    //   735: istore 9
    //   737: aload 17
    //   739: astore 18
    //   741: aload 17
    //   743: invokeinterface 283 1 0
    //   748: ifnull +27 -> 775
    //   751: aload 17
    //   753: invokeinterface 283 1 0
    //   758: invokeinterface 288 1 0
    //   763: aload 17
    //   765: astore 18
    //   767: iload 13
    //   769: istore 9
    //   771: iload 10
    //   773: istore 11
    //   775: aload_0
    //   776: iconst_0
    //   777: putfield 339	bnal:c	I
    //   780: aload_0
    //   781: aload_0
    //   782: getfield 28	bnal:d	I
    //   785: i2d
    //   786: ldc2_w 349
    //   789: dmul
    //   790: d2i
    //   791: putfield 28	bnal:d	I
    //   794: iload 9
    //   796: ldc_w 351
    //   799: if_icmpne +305 -> 1104
    //   802: aload_0
    //   803: aload_0
    //   804: getfield 206	bnal:jdField_a_of_type_Int	I
    //   807: iconst_1
    //   808: iadd
    //   809: putfield 206	bnal:jdField_a_of_type_Int	I
    //   812: iload 9
    //   814: ldc_w 352
    //   817: if_icmpeq +59 -> 876
    //   820: iload 9
    //   822: ldc_w 351
    //   825: if_icmpeq +51 -> 876
    //   828: iload 9
    //   830: ldc_w 353
    //   833: if_icmpeq +43 -> 876
    //   836: iload 9
    //   838: ldc_w 354
    //   841: if_icmpeq +35 -> 876
    //   844: iload 9
    //   846: ldc_w 355
    //   849: if_icmpeq +27 -> 876
    //   852: iload 9
    //   854: ldc_w 356
    //   857: if_icmpeq +19 -> 876
    //   860: iload 9
    //   862: ldc_w 357
    //   865: if_icmpeq +11 -> 876
    //   868: iload 9
    //   870: ldc_w 358
    //   873: if_icmpne +351 -> 1224
    //   876: invokestatic 118	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   879: invokestatic 362	com/tencent/weiyun/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   882: ifne +230 -> 1112
    //   885: ldc_w 363
    //   888: istore 4
    //   890: goto -825 -> 65
    //   893: ldc_w 364
    //   896: iload 9
    //   898: if_icmpne +45 -> 943
    //   901: iload 9
    //   903: istore 10
    //   905: aload 17
    //   907: ifnull +328 -> 1235
    //   910: iload 9
    //   912: istore 10
    //   914: aload 17
    //   916: invokeinterface 283 1 0
    //   921: ifnull +314 -> 1235
    //   924: aload 17
    //   926: invokeinterface 283 1 0
    //   931: invokeinterface 288 1 0
    //   936: iload 13
    //   938: istore 10
    //   940: goto -711 -> 229
    //   943: iload 9
    //   945: istore 11
    //   947: aload 17
    //   949: ifnull +268 -> 1217
    //   952: iload 9
    //   954: istore 11
    //   956: aload 17
    //   958: invokeinterface 283 1 0
    //   963: ifnull +254 -> 1217
    //   966: aload 17
    //   968: invokeinterface 283 1 0
    //   973: invokeinterface 288 1 0
    //   978: iload 9
    //   980: istore 4
    //   982: goto -917 -> 65
    //   985: astore 19
    //   987: iconst_0
    //   988: istore 10
    //   990: aload 17
    //   992: astore 18
    //   994: aload_0
    //   995: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   998: aload 19
    //   1000: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   1003: ldc_w 365
    //   1006: istore 13
    //   1008: iload 10
    //   1010: istore 11
    //   1012: iload 13
    //   1014: istore 9
    //   1016: aload 17
    //   1018: astore 18
    //   1020: aload 17
    //   1022: ifnull -247 -> 775
    //   1025: iload 10
    //   1027: istore 11
    //   1029: iload 13
    //   1031: istore 9
    //   1033: aload 17
    //   1035: astore 18
    //   1037: aload 17
    //   1039: invokeinterface 283 1 0
    //   1044: ifnull -269 -> 775
    //   1047: aload 17
    //   1049: invokeinterface 283 1 0
    //   1054: invokeinterface 288 1 0
    //   1059: iload 10
    //   1061: istore 11
    //   1063: iload 13
    //   1065: istore 9
    //   1067: aload 17
    //   1069: astore 18
    //   1071: goto -296 -> 775
    //   1074: astore_1
    //   1075: aload 18
    //   1077: ifnull +25 -> 1102
    //   1080: aload 18
    //   1082: invokeinterface 283 1 0
    //   1087: ifnull +15 -> 1102
    //   1090: aload 18
    //   1092: invokeinterface 283 1 0
    //   1097: invokeinterface 288 1 0
    //   1102: aload_1
    //   1103: athrow
    //   1104: aload_0
    //   1105: iconst_0
    //   1106: putfield 206	bnal:jdField_a_of_type_Int	I
    //   1109: goto -297 -> 812
    //   1112: iload 8
    //   1114: iconst_1
    //   1115: iadd
    //   1116: istore 8
    //   1118: ldc2_w 366
    //   1121: ldc2_w 244
    //   1124: iload 12
    //   1126: i2d
    //   1127: ldc2_w 368
    //   1130: invokestatic 251	java/lang/Math:pow	(DD)D
    //   1133: dadd
    //   1134: dmul
    //   1135: d2l
    //   1136: lstore 15
    //   1138: lload 15
    //   1140: invokestatic 375	java/lang/Thread:sleep	(J)V
    //   1143: aload 18
    //   1145: astore 17
    //   1147: iconst_1
    //   1148: istore 10
    //   1150: goto -921 -> 229
    //   1153: iconst_0
    //   1154: istore 14
    //   1156: goto -1083 -> 73
    //   1159: astore_1
    //   1160: iload 9
    //   1162: istore 4
    //   1164: goto -1099 -> 65
    //   1167: astore_1
    //   1168: aload 17
    //   1170: astore 18
    //   1172: goto -97 -> 1075
    //   1175: astore 19
    //   1177: goto -187 -> 990
    //   1180: astore 19
    //   1182: iconst_0
    //   1183: istore 10
    //   1185: goto -195 -> 990
    //   1188: astore 19
    //   1190: goto -502 -> 688
    //   1193: astore 19
    //   1195: iconst_0
    //   1196: istore 10
    //   1198: goto -510 -> 688
    //   1201: astore 18
    //   1203: iload 10
    //   1205: istore 9
    //   1207: goto -878 -> 329
    //   1210: iload 5
    //   1212: istore 11
    //   1214: goto -1097 -> 117
    //   1217: iload 11
    //   1219: istore 4
    //   1221: goto -1156 -> 65
    //   1224: aload 18
    //   1226: astore 17
    //   1228: iload 11
    //   1230: istore 10
    //   1232: goto -1003 -> 229
    //   1235: iload 10
    //   1237: istore 9
    //   1239: iload 13
    //   1241: istore 10
    //   1243: goto -1014 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1246	0	this	bnal
    //   0	1246	1	parambnai	bnai
    //   0	1246	2	paramURL	URL
    //   0	1246	3	paramArrayOfByte	byte[]
    //   0	1246	4	paramInt1	int
    //   0	1246	5	paramInt2	int
    //   95	8	6	d1	double
    //   18	1099	8	i	int
    //   24	1214	9	j	int
    //   15	1227	10	k	int
    //   34	1195	11	m	int
    //   21	1104	12	n	int
    //   131	1109	13	i1	int
    //   71	1084	14	bool	boolean
    //   1136	3	15	l	long
    //   7	1220	17	localObject1	Object
    //   138	1033	18	localObject2	Object
    //   1201	24	18	localThrowable	java.lang.Throwable
    //   286	30	19	arrayOfHeader	org.apache.http.Header[]
    //   683	23	19	localIOException1	IOException
    //   985	14	19	localException1	java.lang.Exception
    //   1175	1	19	localException2	java.lang.Exception
    //   1180	1	19	localException3	java.lang.Exception
    //   1188	1	19	localIOException2	IOException
    //   1193	1	19	localIOException3	IOException
    //   4	484	20	localbnam	bnam
    // Exception table:
    //   from	to	target	type
    //   186	190	683	java/io/IOException
    //   242	256	683	java/io/IOException
    //   276	288	683	java/io/IOException
    //   305	311	683	java/io/IOException
    //   315	329	683	java/io/IOException
    //   333	337	683	java/io/IOException
    //   383	412	683	java/io/IOException
    //   484	499	683	java/io/IOException
    //   508	513	683	java/io/IOException
    //   517	523	683	java/io/IOException
    //   532	542	683	java/io/IOException
    //   546	557	683	java/io/IOException
    //   561	573	683	java/io/IOException
    //   577	582	683	java/io/IOException
    //   586	596	683	java/io/IOException
    //   600	607	683	java/io/IOException
    //   661	670	683	java/io/IOException
    //   674	680	683	java/io/IOException
    //   186	190	985	java/lang/Exception
    //   242	256	985	java/lang/Exception
    //   276	288	985	java/lang/Exception
    //   305	311	985	java/lang/Exception
    //   315	329	985	java/lang/Exception
    //   333	337	985	java/lang/Exception
    //   383	412	985	java/lang/Exception
    //   484	499	985	java/lang/Exception
    //   508	513	985	java/lang/Exception
    //   517	523	985	java/lang/Exception
    //   532	542	985	java/lang/Exception
    //   546	557	985	java/lang/Exception
    //   561	573	985	java/lang/Exception
    //   577	582	985	java/lang/Exception
    //   586	596	985	java/lang/Exception
    //   600	607	985	java/lang/Exception
    //   661	670	985	java/lang/Exception
    //   674	680	985	java/lang/Exception
    //   186	190	1074	finally
    //   242	256	1074	finally
    //   276	288	1074	finally
    //   305	311	1074	finally
    //   315	329	1074	finally
    //   333	337	1074	finally
    //   383	412	1074	finally
    //   484	499	1074	finally
    //   508	513	1074	finally
    //   517	523	1074	finally
    //   532	542	1074	finally
    //   546	557	1074	finally
    //   561	573	1074	finally
    //   577	582	1074	finally
    //   586	596	1074	finally
    //   600	607	1074	finally
    //   661	670	1074	finally
    //   674	680	1074	finally
    //   692	701	1074	finally
    //   705	712	1074	finally
    //   994	1003	1074	finally
    //   1138	1143	1159	java/lang/InterruptedException
    //   97	117	1167	finally
    //   117	159	1167	finally
    //   162	173	1167	finally
    //   97	117	1175	java/lang/Exception
    //   117	159	1175	java/lang/Exception
    //   162	173	1180	java/lang/Exception
    //   97	117	1188	java/io/IOException
    //   117	159	1188	java/io/IOException
    //   162	173	1193	java/io/IOException
    //   276	288	1201	java/lang/Throwable
    //   305	311	1201	java/lang/Throwable
    //   315	329	1201	java/lang/Throwable
  }
  
  public bnam a()
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i > 0)
        {
          bnam localbnam1 = (bnam)((SoftReference)this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1)).get();
          if (localbnam1 != null)
          {
            bnam localbnam2 = localbnam1;
            if (localbnam1 == null) {
              localbnam2 = new bnam(new byte[40960]);
            }
            return localbnam2;
          }
          i -= 1;
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  void a(bnai parambnai, int paramInt)
  {
    switch (parambnai.a())
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
    a(parambnai, this.jdField_a_of_type_Long + paramInt);
  }
  
  void a(bnai parambnai, long paramLong)
  {
    if (paramLong != parambnai.a()) {}
    for (this.jdField_a_of_type_Long = parambnai.a();; this.jdField_a_of_type_Long = paramLong)
    {
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  /* Error */
  public void a(bnam parambnam, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	bnal:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 377	java/util/ArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: bipush 10
    //   13: if_icmple +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 33	bnal:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: new 383	java/lang/ref/SoftReference
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 406	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   31: invokevirtual 410	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	bnal
    //   0	43	1	parambnam	bnam
    //   0	43	2	paramBoolean	boolean
    //   9	5	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	38	finally
    //   19	35	38	finally
  }
  
  void a(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile) {}
  }
  
  /* Error */
  int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	bnal:a	()Ljava/net/URL;
    //   4: astore 15
    //   6: new 413	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 35	bnal:jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest	Lcom/tencent/weiyun/uploader/UploadRequest;
    //   14: invokevirtual 423	com/tencent/weiyun/uploader/UploadRequest:path	()Ljava/lang/String;
    //   17: ldc_w 425
    //   20: invokespecial 427	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 14
    //   25: aload_0
    //   26: getfield 63	bnal:jdField_b_of_type_Long	J
    //   29: ldc2_w 428
    //   32: lcmp
    //   33: ifle +95 -> 128
    //   36: new 257	bnai
    //   39: dup
    //   40: sipush 1007
    //   43: aload_0
    //   44: getfield 55	bnal:jdField_b_of_type_ArrayOfByte	[B
    //   47: aload_0
    //   48: getfield 63	bnal:jdField_b_of_type_Long	J
    //   51: aload_0
    //   52: getfield 50	bnal:jdField_a_of_type_ArrayOfByte	[B
    //   55: iconst_0
    //   56: i2l
    //   57: invokespecial 432	bnai:<init>	(I[BJ[BJ)V
    //   60: astore 13
    //   62: ldc_w 433
    //   65: newarray byte
    //   67: astore 16
    //   69: iconst_0
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 37	bnal:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   75: invokevirtual 239	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifne +90 -> 172
    //   85: aload_0
    //   86: aload 14
    //   88: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   91: aload_0
    //   92: invokespecial 277	bnal:a	()V
    //   95: ldc 240
    //   97: ireturn
    //   98: astore 13
    //   100: aload_0
    //   101: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   104: aload 13
    //   106: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   109: ldc_w 436
    //   112: ireturn
    //   113: astore 13
    //   115: aload_0
    //   116: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   119: aload 13
    //   121: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   124: ldc_w 437
    //   127: ireturn
    //   128: new 257	bnai
    //   131: dup
    //   132: sipush 1000
    //   135: aload_0
    //   136: getfield 55	bnal:jdField_b_of_type_ArrayOfByte	[B
    //   139: aload_0
    //   140: getfield 63	bnal:jdField_b_of_type_Long	J
    //   143: aload_0
    //   144: getfield 50	bnal:jdField_a_of_type_ArrayOfByte	[B
    //   147: iconst_0
    //   148: i2l
    //   149: invokespecial 432	bnai:<init>	(I[BJ[BJ)V
    //   152: astore 13
    //   154: goto -92 -> 62
    //   157: astore 13
    //   159: aload_0
    //   160: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   163: aload 13
    //   165: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   168: ldc_w 438
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 337	bnal:jdField_b_of_type_Int	I
    //   176: ifgt +33 -> 209
    //   179: invokestatic 118	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   182: invokestatic 440	bnal:a	(Landroid/content/Context;)I
    //   185: istore_2
    //   186: iload_2
    //   187: ifge +17 -> 204
    //   190: aload_0
    //   191: aload 14
    //   193: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   196: aload_0
    //   197: invokespecial 277	bnal:a	()V
    //   200: ldc_w 363
    //   203: ireturn
    //   204: aload_0
    //   205: iload_2
    //   206: putfield 337	bnal:jdField_b_of_type_Int	I
    //   209: invokestatic 89	android/os/SystemClock:uptimeMillis	()J
    //   212: lstore 5
    //   214: aload_0
    //   215: getfield 57	bnal:jdField_a_of_type_Long	J
    //   218: lstore 7
    //   220: aload 14
    //   222: lload 7
    //   224: invokevirtual 443	java/io/RandomAccessFile:seek	(J)V
    //   227: aload 13
    //   229: invokevirtual 445	bnai:a	()I
    //   232: istore_3
    //   233: aload 14
    //   235: aload 16
    //   237: iload_3
    //   238: aload_0
    //   239: getfield 337	bnal:jdField_b_of_type_Int	I
    //   242: invokevirtual 448	java/io/RandomAccessFile:read	([BII)I
    //   245: istore_2
    //   246: iload_2
    //   247: ifgt +37 -> 284
    //   250: aload_0
    //   251: getfield 57	bnal:jdField_a_of_type_Long	J
    //   254: lstore 9
    //   256: aload_0
    //   257: getfield 63	bnal:jdField_b_of_type_Long	J
    //   260: lstore 11
    //   262: lload 9
    //   264: lload 11
    //   266: lcmp
    //   267: ifge +17 -> 284
    //   270: aload_0
    //   271: aload 14
    //   273: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   276: aload_0
    //   277: invokespecial 277	bnal:a	()V
    //   280: ldc_w 449
    //   283: ireturn
    //   284: iload_2
    //   285: ifgt +35 -> 320
    //   288: aload_0
    //   289: getfield 57	bnal:jdField_a_of_type_Long	J
    //   292: lstore 9
    //   294: aload_0
    //   295: getfield 63	bnal:jdField_b_of_type_Long	J
    //   298: lstore 11
    //   300: lload 9
    //   302: lload 11
    //   304: lcmp
    //   305: ifne +15 -> 320
    //   308: aload_0
    //   309: aload 14
    //   311: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   314: aload_0
    //   315: invokespecial 277	bnal:a	()V
    //   318: iconst_0
    //   319: ireturn
    //   320: iload_1
    //   321: iconst_1
    //   322: iadd
    //   323: istore_1
    //   324: iload_1
    //   325: i2l
    //   326: lstore 9
    //   328: aload 13
    //   330: lload 9
    //   332: invokevirtual 451	bnai:a	(J)V
    //   335: aload_0
    //   336: aload 13
    //   338: aload 15
    //   340: aload 16
    //   342: iload_3
    //   343: iload_2
    //   344: invokevirtual 453	bnal:a	(Lbnai;Ljava/net/URL;[BII)I
    //   347: istore_3
    //   348: iload_3
    //   349: ifeq +15 -> 364
    //   352: aload_0
    //   353: aload 14
    //   355: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   358: aload_0
    //   359: invokespecial 277	bnal:a	()V
    //   362: iload_3
    //   363: ireturn
    //   364: aload_0
    //   365: getfield 37	bnal:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   368: invokevirtual 239	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   371: istore 4
    //   373: iload 4
    //   375: ifne +16 -> 391
    //   378: aload_0
    //   379: aload 14
    //   381: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   384: aload_0
    //   385: invokespecial 277	bnal:a	()V
    //   388: ldc 240
    //   390: ireturn
    //   391: aload_0
    //   392: aload 13
    //   394: iload_2
    //   395: invokevirtual 455	bnal:a	(Lbnai;I)V
    //   398: aload_0
    //   399: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   402: astore 17
    //   404: aload 17
    //   406: aload 17
    //   408: getfield 456	bnak:jdField_b_of_type_Long	J
    //   411: invokestatic 89	android/os/SystemClock:uptimeMillis	()J
    //   414: lload 5
    //   416: lsub
    //   417: ladd
    //   418: putfield 456	bnak:jdField_b_of_type_Long	J
    //   421: aload_0
    //   422: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   425: astore 17
    //   427: aload 17
    //   429: aload 17
    //   431: getfield 458	bnak:c	J
    //   434: aload_0
    //   435: getfield 57	bnal:jdField_a_of_type_Long	J
    //   438: lload 7
    //   440: lsub
    //   441: ladd
    //   442: putfield 458	bnak:c	J
    //   445: aload_0
    //   446: getfield 57	bnal:jdField_a_of_type_Long	J
    //   449: aload_0
    //   450: getfield 63	bnal:jdField_b_of_type_Long	J
    //   453: lcmp
    //   454: ifeq -146 -> 308
    //   457: aload_0
    //   458: getfield 57	bnal:jdField_a_of_type_Long	J
    //   461: lstore 5
    //   463: aload_0
    //   464: getfield 63	bnal:jdField_b_of_type_Long	J
    //   467: lstore 7
    //   469: lload 5
    //   471: lload 7
    //   473: lcmp
    //   474: ifle +17 -> 491
    //   477: aload_0
    //   478: aload 14
    //   480: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   483: aload_0
    //   484: invokespecial 277	bnal:a	()V
    //   487: ldc_w 459
    //   490: ireturn
    //   491: goto -420 -> 71
    //   494: astore 13
    //   496: aload_0
    //   497: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   500: aload 13
    //   502: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   505: aload_0
    //   506: aload 14
    //   508: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   511: aload_0
    //   512: invokespecial 277	bnal:a	()V
    //   515: ldc_w 460
    //   518: ireturn
    //   519: astore 13
    //   521: aload_0
    //   522: getfield 68	bnal:jdField_a_of_type_Bnak	Lbnak;
    //   525: aload 13
    //   527: putfield 342	bnak:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   530: aload_0
    //   531: aload 14
    //   533: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   536: aload_0
    //   537: invokespecial 277	bnal:a	()V
    //   540: ldc_w 365
    //   543: ireturn
    //   544: astore 13
    //   546: aload_0
    //   547: aload 14
    //   549: invokevirtual 435	bnal:a	(Ljava/io/RandomAccessFile;)V
    //   552: aload_0
    //   553: invokespecial 277	bnal:a	()V
    //   556: aload 13
    //   558: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	bnal
    //   70	255	1	i	int
    //   185	210	2	j	int
    //   232	131	3	k	int
    //   78	296	4	bool	boolean
    //   212	258	5	l1	long
    //   218	254	7	l2	long
    //   254	77	9	l3	long
    //   260	43	11	l4	long
    //   60	1	13	localbnai1	bnai
    //   98	7	13	localFileNotFoundException	java.io.FileNotFoundException
    //   113	7	13	localMalformedURLException	MalformedURLException
    //   152	1	13	localbnai2	bnai
    //   157	236	13	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   494	7	13	localIOException	IOException
    //   519	7	13	localException	java.lang.Exception
    //   544	13	13	localObject	Object
    //   23	525	14	localRandomAccessFile	RandomAccessFile
    //   4	335	15	localURL	URL
    //   67	274	16	arrayOfByte	byte[]
    //   402	28	17	localbnak	bnak
    // Exception table:
    //   from	to	target	type
    //   0	25	98	java/io/FileNotFoundException
    //   0	25	113	java/net/MalformedURLException
    //   25	62	157	java/lang/IllegalArgumentException
    //   128	154	157	java/lang/IllegalArgumentException
    //   71	80	494	java/io/IOException
    //   172	186	494	java/io/IOException
    //   204	209	494	java/io/IOException
    //   209	246	494	java/io/IOException
    //   250	262	494	java/io/IOException
    //   288	300	494	java/io/IOException
    //   328	348	494	java/io/IOException
    //   364	373	494	java/io/IOException
    //   391	469	494	java/io/IOException
    //   71	80	519	java/lang/Exception
    //   172	186	519	java/lang/Exception
    //   204	209	519	java/lang/Exception
    //   209	246	519	java/lang/Exception
    //   250	262	519	java/lang/Exception
    //   288	300	519	java/lang/Exception
    //   328	348	519	java/lang/Exception
    //   364	373	519	java/lang/Exception
    //   391	469	519	java/lang/Exception
    //   71	80	544	finally
    //   172	186	544	finally
    //   204	209	544	finally
    //   209	246	544	finally
    //   250	262	544	finally
    //   288	300	544	finally
    //   328	348	544	finally
    //   364	373	544	finally
    //   391	469	544	finally
    //   496	505	544	finally
    //   521	530	544	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnal
 * JD-Core Version:    0.7.0.1
 */