import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vip.DownloaderFactory.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.apache.http.HttpEntity;

public class bihw
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, bihz> a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public bihw(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(bihu parambihu, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 75
    //   8: iconst_2
    //   9: ldc 77
    //   11: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore_3
    //   17: aload_0
    //   18: invokevirtual 86	bihu:a	()Lbiht;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 88	bihx
    //   28: dup
    //   29: invokespecial 89	bihx:<init>	()V
    //   32: invokevirtual 92	bihu:a	(Lbiht;)V
    //   35: aload_1
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 95	bihu:jdField_a_of_type_Bihv	Lbihv;
    //   43: getfield 100	bihv:a	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifge +14 -> 62
    //   51: aload_0
    //   52: getfield 95	bihu:jdField_a_of_type_Bihv	Lbihv;
    //   55: aload_1
    //   56: invokestatic 106	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: putfield 100	bihv:a	J
    //   62: iload_3
    //   63: istore 4
    //   65: aload_0
    //   66: ifnull +2542 -> 2608
    //   69: iload_3
    //   70: istore 5
    //   72: aload_0
    //   73: invokestatic 111	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lbihu;)V
    //   76: iload_3
    //   77: istore 5
    //   79: aload_0
    //   80: invokestatic 113	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lbihu;)V
    //   83: aload_0
    //   84: invokevirtual 116	bihu:c	()Z
    //   87: ifne +47 -> 134
    //   90: aload_0
    //   91: bipush 147
    //   93: putfield 119	bihu:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: invokevirtual 122	bihu:e	()V
    //   100: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +7962 -> 8065
    //   106: ldc 75
    //   108: iconst_2
    //   109: new 124	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   116: ldc 127
    //   118: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto +7934 -> 8065
    //   134: new 140	org/apache/http/params/BasicHttpParams
    //   137: dup
    //   138: invokespecial 141	org/apache/http/params/BasicHttpParams:<init>	()V
    //   141: astore 40
    //   143: aload 40
    //   145: ldc 143
    //   147: sipush 10000
    //   150: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokeinterface 155 3 0
    //   158: pop
    //   159: aload 40
    //   161: ldc 157
    //   163: aload_0
    //   164: getfield 159	bihu:jdField_e_of_type_Int	I
    //   167: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 155 3 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 162	bihu:n	Z
    //   180: ifeq +7891 -> 8071
    //   183: ldc 164
    //   185: astore 29
    //   187: aload 40
    //   189: ldc 166
    //   191: aload 29
    //   193: invokeinterface 155 3 0
    //   198: pop
    //   199: aconst_null
    //   200: astore 31
    //   202: aconst_null
    //   203: astore 30
    //   205: sipush 2048
    //   208: istore_3
    //   209: aload_0
    //   210: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   213: ifnull +15 -> 228
    //   216: aload_0
    //   217: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   220: invokeinterface 175 1 0
    //   225: ifgt +47 -> 272
    //   228: aload_0
    //   229: bipush 149
    //   231: putfield 119	bihu:jdField_a_of_type_Int	I
    //   234: aload_0
    //   235: invokevirtual 122	bihu:e	()V
    //   238: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +7828 -> 8069
    //   244: ldc 75
    //   246: iconst_2
    //   247: new 124	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   254: ldc 177
    //   256: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto +7800 -> 8069
    //   272: aload_0
    //   273: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   276: invokeinterface 175 1 0
    //   281: istore 9
    //   283: iconst_0
    //   284: istore 14
    //   286: getstatic 182	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   289: istore 4
    //   291: iconst_1
    //   292: iload 4
    //   294: if_icmpne +1784 -> 2078
    //   297: iconst_1
    //   298: istore 10
    //   300: iconst_0
    //   301: istore 11
    //   303: aconst_null
    //   304: astore 29
    //   306: iconst_m1
    //   307: istore 8
    //   309: iload 8
    //   311: istore 4
    //   313: iload 11
    //   315: aload_0
    //   316: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   319: invokeinterface 175 1 0
    //   324: if_icmpge +6843 -> 7167
    //   327: iconst_m1
    //   328: istore 4
    //   330: iload 4
    //   332: istore 8
    //   334: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   337: lstore 25
    //   339: iload 4
    //   341: istore 8
    //   343: new 4	java/lang/Object
    //   346: dup
    //   347: invokespecial 37	java/lang/Object:<init>	()V
    //   350: astore 41
    //   352: lconst_0
    //   353: lstore 17
    //   355: iload 4
    //   357: istore 8
    //   359: new 190	java/util/HashMap
    //   362: dup
    //   363: invokespecial 191	java/util/HashMap:<init>	()V
    //   366: astore 37
    //   368: iload 4
    //   370: istore 8
    //   372: aload_0
    //   373: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   376: iload 11
    //   378: invokeinterface 195 2 0
    //   383: checkcast 197	java/lang/String
    //   386: astore 33
    //   388: iload 4
    //   390: istore 8
    //   392: aload_0
    //   393: aload 33
    //   395: putfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   398: iload 4
    //   400: istore 8
    //   402: aload_0
    //   403: getfield 203	bihu:jdField_g_of_type_Int	I
    //   406: iconst_3
    //   407: if_icmpne +49 -> 456
    //   410: iload 10
    //   412: ifeq +44 -> 456
    //   415: iload 4
    //   417: istore 8
    //   419: bipush 30
    //   421: aconst_null
    //   422: aload_0
    //   423: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   426: invokestatic 208	anmq:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   429: iload 4
    //   431: istore 8
    //   433: bipush 30
    //   435: aload_0
    //   436: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   439: sipush 300
    //   442: invokestatic 211	anmq:a	(ILjava/lang/String;I)V
    //   445: iload 4
    //   447: istore 8
    //   449: aload_0
    //   450: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokestatic 214	com/tencent/mobileqq/apollo/utils/ApolloUtil:d	(Ljava/lang/String;)V
    //   456: iload 4
    //   458: istore 8
    //   460: aload_0
    //   461: getfield 215	bihu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   464: aload 33
    //   466: invokeinterface 220 2 0
    //   471: checkcast 222	java/io/File
    //   474: astore 38
    //   476: ldc 224
    //   478: astore 34
    //   480: aload 38
    //   482: ifnull +6583 -> 7065
    //   485: iload 4
    //   487: istore 8
    //   489: aload 38
    //   491: invokevirtual 228	java/io/File:getParentFile	()Ljava/io/File;
    //   494: astore 43
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 231	bihu:h	Z
    //   504: ifeq +1580 -> 2084
    //   507: iload 4
    //   509: istore 8
    //   511: new 222	java/io/File
    //   514: dup
    //   515: aload 43
    //   517: new 124	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   524: aload 38
    //   526: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   529: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 236
    //   534: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokestatic 239	java/lang/System:nanoTime	()J
    //   540: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   543: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokespecial 245	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   549: astore 36
    //   551: aload 33
    //   553: astore 32
    //   555: iload 4
    //   557: istore 8
    //   559: aload_0
    //   560: getfield 247	bihu:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   563: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +18 -> 584
    //   569: iload 4
    //   571: istore 8
    //   573: aload_0
    //   574: getfield 247	bihu:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   577: aload 33
    //   579: invokestatic 259	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   582: astore 32
    //   584: iload 4
    //   586: istore 8
    //   588: new 261	asjz
    //   591: dup
    //   592: aload 32
    //   594: aconst_null
    //   595: iconst_0
    //   596: invokespecial 264	asjz:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   599: astore 39
    //   601: aload 32
    //   603: astore 34
    //   605: iconst_0
    //   606: istore 7
    //   608: iconst_m1
    //   609: istore 12
    //   611: iconst_m1
    //   612: istore 6
    //   614: lconst_0
    //   615: lstore 19
    //   617: aload 29
    //   619: astore 33
    //   621: aload 30
    //   623: astore 32
    //   625: aload 34
    //   627: astore 29
    //   629: iload 6
    //   631: istore 4
    //   633: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   636: lstore 27
    //   638: iload 6
    //   640: istore 4
    //   642: new 124	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 266
    //   649: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: ldc_w 270
    //   655: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 162	bihu:n	Z
    //   662: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 275
    //   668: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_0
    //   672: getfield 278	bihu:p	Z
    //   675: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: ldc_w 280
    //   681: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: getfield 282	bihu:jdField_b_of_type_Int	I
    //   688: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: ldc_w 287
    //   694: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_0
    //   698: getfield 290	bihu:s	Z
    //   701: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   704: astore 42
    //   706: iconst_0
    //   707: istore 8
    //   709: iconst_0
    //   710: istore 5
    //   712: iconst_0
    //   713: istore 13
    //   715: aload 29
    //   717: astore 35
    //   719: aload 29
    //   721: astore 34
    //   723: iload 5
    //   725: istore 4
    //   727: aload 39
    //   729: invokevirtual 292	asjz:a	()V
    //   732: iconst_1
    //   733: istore 14
    //   735: aload 43
    //   737: ifnull +23 -> 760
    //   740: aload 29
    //   742: astore 35
    //   744: aload 29
    //   746: astore 34
    //   748: iload 5
    //   750: istore 4
    //   752: aload 43
    //   754: invokevirtual 295	java/io/File:exists	()Z
    //   757: ifeq +27 -> 784
    //   760: aload 29
    //   762: astore 35
    //   764: aload 29
    //   766: astore 34
    //   768: iload 5
    //   770: istore 4
    //   772: aload 43
    //   774: invokevirtual 298	java/io/File:isDirectory	()Z
    //   777: istore 14
    //   779: iload 14
    //   781: ifne +1345 -> 2126
    //   784: iload 14
    //   786: ifne +21 -> 807
    //   789: aload 29
    //   791: astore 35
    //   793: aload 29
    //   795: astore 34
    //   797: iload 5
    //   799: istore 4
    //   801: aload 43
    //   803: invokevirtual 301	java/io/File:delete	()Z
    //   806: pop
    //   807: aload 29
    //   809: astore 35
    //   811: aload 29
    //   813: astore 34
    //   815: iload 5
    //   817: istore 4
    //   819: aload 43
    //   821: invokevirtual 304	java/io/File:mkdirs	()Z
    //   824: ifne +1302 -> 2126
    //   827: iconst_1
    //   828: istore 4
    //   830: iconst_1
    //   831: istore 13
    //   833: bipush 153
    //   835: istore 8
    //   837: aload 29
    //   839: astore 35
    //   841: aload 29
    //   843: astore 34
    //   845: aload_0
    //   846: bipush 153
    //   848: putfield 119	bihu:jdField_a_of_type_Int	I
    //   851: iload 13
    //   853: istore 5
    //   855: iload 8
    //   857: istore 4
    //   859: iload 8
    //   861: istore 6
    //   863: aload 42
    //   865: ldc_w 306
    //   868: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 43
    //   873: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   876: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc_w 311
    //   882: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokestatic 315	bhjx:a	()Z
    //   888: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   891: ldc_w 317
    //   894: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: invokestatic 319	bhjx:b	()J
    //   900: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: iload 13
    //   906: istore 5
    //   908: iload 8
    //   910: istore 4
    //   912: iload 8
    //   914: istore 6
    //   916: new 65	java/lang/Exception
    //   919: dup
    //   920: ldc_w 321
    //   923: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   926: athrow
    //   927: astore 34
    //   929: iload_3
    //   930: istore 6
    //   932: iconst_0
    //   933: istore 14
    //   935: iload 5
    //   937: istore 8
    //   939: iload 4
    //   941: istore_3
    //   942: aload 32
    //   944: astore 30
    //   946: aload 33
    //   948: astore 32
    //   950: iload 6
    //   952: istore 5
    //   954: iload 8
    //   956: istore 4
    //   958: iload 7
    //   960: istore 6
    //   962: aload 34
    //   964: astore 33
    //   966: iconst_0
    //   967: istore 7
    //   969: aload 33
    //   971: instanceof 324
    //   974: ifne +7105 -> 8079
    //   977: aload 33
    //   979: instanceof 326
    //   982: ifne +7097 -> 8079
    //   985: aload 33
    //   987: instanceof 328
    //   990: ifeq +6 -> 996
    //   993: goto +7086 -> 8079
    //   996: aload 33
    //   998: instanceof 330
    //   1001: ifeq +5873 -> 6874
    //   1004: aload_0
    //   1005: bipush 145
    //   1007: putfield 119	bihu:jdField_a_of_type_Int	I
    //   1010: aload_0
    //   1011: aload 33
    //   1013: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1016: putfield 335	bihu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1019: iload 14
    //   1021: ifne +18 -> 1039
    //   1024: iload 7
    //   1026: ifeq +13 -> 1039
    //   1029: iload 6
    //   1031: ifeq +5918 -> 6949
    //   1034: aload_0
    //   1035: iconst_1
    //   1036: putfield 338	bihu:jdField_f_of_type_Boolean	Z
    //   1039: aload 42
    //   1041: ldc_w 340
    //   1044: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokestatic 343	bhmi:a	()Z
    //   1050: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1053: ldc_w 345
    //   1056: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokestatic 348	bhmi:c	()F
    //   1062: ldc_w 349
    //   1065: fdiv
    //   1066: invokevirtual 352	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload 42
    //   1072: ldc_w 354
    //   1075: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 33
    //   1080: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1083: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: iload_3
    //   1088: istore 8
    //   1090: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1093: iload_3
    //   1094: istore 8
    //   1096: ldc 75
    //   1098: iconst_1
    //   1099: new 124	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1106: aload 42
    //   1108: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: ldc_w 361
    //   1117: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   1123: lload 27
    //   1125: lsub
    //   1126: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: iload_3
    //   1136: istore 8
    //   1138: aload_0
    //   1139: getfield 203	bihu:jdField_g_of_type_Int	I
    //   1142: iconst_3
    //   1143: if_icmpne +63 -> 1206
    //   1146: iload 10
    //   1148: ifeq +58 -> 1206
    //   1151: iload_3
    //   1152: istore 8
    //   1154: bipush 30
    //   1156: aload_0
    //   1157: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1160: sipush 300
    //   1163: iconst_1
    //   1164: anewarray 4	java/lang/Object
    //   1167: dup
    //   1168: iconst_0
    //   1169: new 124	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1176: aload 42
    //   1178: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: ldc_w 361
    //   1187: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   1193: lload 27
    //   1195: lsub
    //   1196: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1199: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: aastore
    //   1203: invokestatic 367	anmq:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1206: iload_3
    //   1207: ifeq +112 -> 1319
    //   1210: iload_3
    //   1211: istore 8
    //   1213: aload_0
    //   1214: invokevirtual 369	bihu:b	()Z
    //   1217: ifne +102 -> 1319
    //   1220: iload_3
    //   1221: istore 8
    //   1223: aload_0
    //   1224: getfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   1227: ifeq +92 -> 1319
    //   1230: iload_3
    //   1231: istore 8
    //   1233: aload 39
    //   1235: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   1238: ifeq +5753 -> 6991
    //   1241: iload_3
    //   1242: istore 8
    //   1244: aload 39
    //   1246: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1249: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1252: ifne +5705 -> 6957
    //   1255: iload_3
    //   1256: istore 8
    //   1258: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   1261: aload 39
    //   1263: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1266: aload 39
    //   1268: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1271: getstatic 34	bihw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1274: aload 39
    //   1276: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1279: invokeinterface 220 2 0
    //   1284: checkcast 145	java/lang/Integer
    //   1287: invokevirtual 384	java/lang/Integer:intValue	()I
    //   1290: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1293: iload_3
    //   1294: istore 8
    //   1296: aload 39
    //   1298: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1301: aload 38
    //   1303: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   1306: iconst_m1
    //   1307: aload_2
    //   1308: invokestatic 392	bihw:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   1311: iload_3
    //   1312: istore 8
    //   1314: aload_0
    //   1315: iconst_0
    //   1316: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   1319: iload_3
    //   1320: istore 8
    //   1322: new 124	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1329: astore 34
    //   1331: iload_3
    //   1332: istore 8
    //   1334: aload 39
    //   1336: getfield 396	asjz:jdField_b_of_type_Boolean	Z
    //   1339: ifeq +6986 -> 8325
    //   1342: ldc_w 398
    //   1345: astore 33
    //   1347: iload_3
    //   1348: istore 8
    //   1350: aload 34
    //   1352: aload 33
    //   1354: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: astore 34
    //   1359: iload_3
    //   1360: istore 8
    //   1362: aload 39
    //   1364: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   1367: ifeq +5635 -> 7002
    //   1370: ldc_w 400
    //   1373: astore 33
    //   1375: iload_3
    //   1376: istore 8
    //   1378: aload 34
    //   1380: aload 33
    //   1382: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: astore 33
    //   1390: iload_3
    //   1391: istore 8
    //   1393: aload 32
    //   1395: aload 31
    //   1397: aload 30
    //   1399: aload 29
    //   1401: invokestatic 403	bihw:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1404: iload 12
    //   1406: iconst_1
    //   1407: iadd
    //   1408: istore 7
    //   1410: iload 4
    //   1412: istore 8
    //   1414: iload 5
    //   1416: istore 4
    //   1418: lload 19
    //   1420: lstore 21
    //   1422: lload 17
    //   1424: lstore 19
    //   1426: lload 21
    //   1428: lstore 17
    //   1430: iload 7
    //   1432: istore 5
    //   1434: iload_3
    //   1435: ifeq +34 -> 1469
    //   1438: iload 8
    //   1440: ifne +29 -> 1469
    //   1443: iload_3
    //   1444: istore 8
    //   1446: iload 5
    //   1448: aload_0
    //   1449: getfield 282	bihu:jdField_b_of_type_Int	I
    //   1452: if_icmpge +17 -> 1469
    //   1455: iload_3
    //   1456: istore 8
    //   1458: aload_0
    //   1459: invokevirtual 369	bihu:b	()Z
    //   1462: istore 15
    //   1464: iload 15
    //   1466: ifeq +6558 -> 8024
    //   1469: aload 30
    //   1471: astore 34
    //   1473: lload 19
    //   1475: lstore 21
    //   1477: aload 32
    //   1479: astore 30
    //   1481: aload 31
    //   1483: astore 35
    //   1485: lload 17
    //   1487: lstore 19
    //   1489: lload 21
    //   1491: lstore 17
    //   1493: aload 29
    //   1495: astore 32
    //   1497: iload 5
    //   1499: istore 6
    //   1501: aload 30
    //   1503: astore 31
    //   1505: aload 35
    //   1507: astore 30
    //   1509: aload 34
    //   1511: astore 29
    //   1513: iload 4
    //   1515: istore 5
    //   1517: iload_3
    //   1518: istore 4
    //   1520: aload_0
    //   1521: invokevirtual 405	bihu:d	()V
    //   1524: aload 37
    //   1526: ifnonnull +6465 -> 7991
    //   1529: iload_3
    //   1530: istore 4
    //   1532: new 190	java/util/HashMap
    //   1535: dup
    //   1536: invokespecial 191	java/util/HashMap:<init>	()V
    //   1539: astore 34
    //   1541: iload_3
    //   1542: istore 4
    //   1544: aload 34
    //   1546: ldc_w 407
    //   1549: aload 32
    //   1551: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1554: pop
    //   1555: iload_3
    //   1556: istore 4
    //   1558: aload 34
    //   1560: ldc_w 413
    //   1563: aload_0
    //   1564: getfield 119	bihu:jdField_a_of_type_Int	I
    //   1567: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1570: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1573: pop
    //   1574: iload_3
    //   1575: istore 4
    //   1577: aload 34
    //   1579: ldc_w 418
    //   1582: aload_0
    //   1583: getfield 420	bihu:jdField_f_of_type_Int	I
    //   1586: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1589: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1592: pop
    //   1593: iload_3
    //   1594: istore 4
    //   1596: aload 34
    //   1598: ldc_w 422
    //   1601: iload 6
    //   1603: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1606: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1609: pop
    //   1610: iload_3
    //   1611: istore 4
    //   1613: aload 34
    //   1615: ldc_w 424
    //   1618: lload 17
    //   1620: invokestatic 427	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1623: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1626: pop
    //   1627: iload_3
    //   1628: istore 4
    //   1630: aload 34
    //   1632: ldc_w 429
    //   1635: aload_0
    //   1636: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1639: invokeinterface 175 1 0
    //   1644: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1647: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1650: pop
    //   1651: iload_3
    //   1652: istore 4
    //   1654: aload 34
    //   1656: ldc_w 431
    //   1659: aload_0
    //   1660: getfield 433	bihu:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1663: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1666: pop
    //   1667: iload_3
    //   1668: istore 4
    //   1670: aload 34
    //   1672: ldc_w 435
    //   1675: iload 14
    //   1677: invokestatic 440	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1680: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1683: pop
    //   1684: iload_3
    //   1685: istore 4
    //   1687: aload 34
    //   1689: ldc_w 442
    //   1692: aload 33
    //   1694: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1697: pop
    //   1698: ldc 224
    //   1700: astore 35
    //   1702: iload_3
    //   1703: istore 4
    //   1705: aload_0
    //   1706: getfield 335	bihu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1709: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1712: ifne +6373 -> 8085
    //   1715: iload_3
    //   1716: istore 4
    //   1718: aload 34
    //   1720: ldc_w 444
    //   1723: aload_0
    //   1724: getfield 335	bihu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1727: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1730: pop
    //   1731: iload_3
    //   1732: istore 4
    //   1734: aload_0
    //   1735: getfield 335	bihu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1738: astore 35
    //   1740: goto +6345 -> 8085
    //   1743: iload_3
    //   1744: istore 4
    //   1746: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   1749: lstore 21
    //   1751: aload_2
    //   1752: ifnull +281 -> 2033
    //   1755: iload_3
    //   1756: istore 4
    //   1758: aload_1
    //   1759: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1762: istore 16
    //   1764: iload 16
    //   1766: ifne +267 -> 2033
    //   1769: ldc_w 446
    //   1772: aload 32
    //   1774: new 124	java/lang/StringBuilder
    //   1777: dup
    //   1778: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1781: aload_0
    //   1782: getfield 119	bihu:jdField_a_of_type_Int	I
    //   1785: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1788: ldc 224
    //   1790: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1796: new 124	java/lang/StringBuilder
    //   1799: dup
    //   1800: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1803: lload 17
    //   1805: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1808: ldc 224
    //   1810: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1816: aload_0
    //   1817: getfield 433	bihu:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1820: new 124	java/lang/StringBuilder
    //   1823: dup
    //   1824: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1827: iload 14
    //   1829: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1832: ldc 224
    //   1834: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1840: aload 35
    //   1842: aload 33
    //   1844: ldc 224
    //   1846: ldc_w 448
    //   1849: invokestatic 453	biah:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1852: aload_0
    //   1853: getfield 203	bihu:jdField_g_of_type_Int	I
    //   1856: iconst_3
    //   1857: if_icmpne +79 -> 1936
    //   1860: iload 10
    //   1862: ifeq +74 -> 1936
    //   1865: bipush 30
    //   1867: aload_0
    //   1868: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1871: sipush 300
    //   1874: aload_0
    //   1875: getfield 119	bihu:jdField_a_of_type_Int	I
    //   1878: invokestatic 456	com/tencent/mobileqq/apollo/utils/ApolloUtil:f	(I)I
    //   1881: iconst_4
    //   1882: anewarray 4	java/lang/Object
    //   1885: dup
    //   1886: iconst_0
    //   1887: ldc_w 458
    //   1890: aastore
    //   1891: dup
    //   1892: iconst_1
    //   1893: aload_0
    //   1894: getfield 119	bihu:jdField_a_of_type_Int	I
    //   1897: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1900: aastore
    //   1901: dup
    //   1902: iconst_2
    //   1903: ldc_w 460
    //   1906: aastore
    //   1907: dup
    //   1908: iconst_3
    //   1909: aload_0
    //   1910: getfield 420	bihu:jdField_f_of_type_Int	I
    //   1913: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1916: aastore
    //   1917: invokestatic 463	anmq:a	(ILjava/lang/String;II[Ljava/lang/Object;)V
    //   1920: aload_0
    //   1921: getfield 119	bihu:jdField_a_of_type_Int	I
    //   1924: ifne +12 -> 1936
    //   1927: bipush 30
    //   1929: aload_0
    //   1930: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1933: invokestatic 466	anmq:b	(ILjava/lang/String;)V
    //   1936: ldc_w 468
    //   1939: astore 33
    //   1941: aload 33
    //   1943: astore 32
    //   1945: aload_0
    //   1946: getfield 433	bihu:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1949: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1952: ifne +57 -> 2009
    //   1955: aload 33
    //   1957: astore 32
    //   1959: aload_0
    //   1960: getfield 433	bihu:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1963: ldc_w 470
    //   1966: invokevirtual 473	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1969: ifeq +40 -> 2009
    //   1972: ldc_w 475
    //   1975: astore 32
    //   1977: aload 34
    //   1979: ldc_w 477
    //   1982: aload_0
    //   1983: getfield 480	bihu:r	Z
    //   1986: invokestatic 482	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1989: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1992: pop
    //   1993: aload 34
    //   1995: ldc_w 484
    //   1998: aload_0
    //   1999: getfield 487	bihu:q	Z
    //   2002: invokestatic 482	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2005: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload_2
    //   2010: invokestatic 492	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   2013: aload_1
    //   2014: aload 32
    //   2016: iload 15
    //   2018: lload 21
    //   2020: lload 25
    //   2022: lsub
    //   2023: lload 19
    //   2025: aload 34
    //   2027: ldc 224
    //   2029: iconst_0
    //   2030: invokevirtual 495	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2033: iload_3
    //   2034: ifne +5115 -> 7149
    //   2037: iload 9
    //   2039: iconst_1
    //   2040: isub
    //   2041: istore 4
    //   2043: iload 11
    //   2045: iconst_1
    //   2046: iadd
    //   2047: istore 11
    //   2049: aload 31
    //   2051: astore 32
    //   2053: iload_3
    //   2054: istore 8
    //   2056: aload 30
    //   2058: astore 31
    //   2060: iload 5
    //   2062: istore_3
    //   2063: aload 29
    //   2065: astore 30
    //   2067: aload 32
    //   2069: astore 29
    //   2071: iload 4
    //   2073: istore 9
    //   2075: goto -1766 -> 309
    //   2078: iconst_0
    //   2079: istore 10
    //   2081: goto -1781 -> 300
    //   2084: iload 4
    //   2086: istore 8
    //   2088: new 222	java/io/File
    //   2091: dup
    //   2092: aload 43
    //   2094: new 124	java/lang/StringBuilder
    //   2097: dup
    //   2098: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2101: aload 38
    //   2103: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   2106: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: ldc_w 497
    //   2112: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2118: invokespecial 245	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2121: astore 36
    //   2123: goto -1572 -> 551
    //   2126: aload 29
    //   2128: astore 35
    //   2130: aload 29
    //   2132: astore 34
    //   2134: iload 5
    //   2136: istore 4
    //   2138: getstatic 46	bihw:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2141: ifnonnull +29 -> 2170
    //   2144: aload 29
    //   2146: astore 35
    //   2148: aload 29
    //   2150: astore 34
    //   2152: iload 5
    //   2154: istore 4
    //   2156: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2159: ldc 54
    //   2161: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2164: checkcast 60	android/net/ConnectivityManager
    //   2167: putstatic 46	bihw:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2170: aload 29
    //   2172: astore 35
    //   2174: aload 29
    //   2176: astore 34
    //   2178: iload 5
    //   2180: istore 4
    //   2182: invokestatic 503	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   2185: astore 44
    //   2187: aload 44
    //   2189: ifnonnull +458 -> 2647
    //   2192: bipush 152
    //   2194: istore 8
    //   2196: aload 29
    //   2198: astore 35
    //   2200: aload 29
    //   2202: astore 34
    //   2204: iload 5
    //   2206: istore 4
    //   2208: aload_0
    //   2209: bipush 152
    //   2211: putfield 119	bihu:jdField_a_of_type_Int	I
    //   2214: iload 13
    //   2216: istore 5
    //   2218: iload 8
    //   2220: istore 4
    //   2222: iload 8
    //   2224: istore 6
    //   2226: aload 42
    //   2228: ldc_w 505
    //   2231: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: pop
    //   2235: iload 13
    //   2237: istore 5
    //   2239: iload 8
    //   2241: istore 4
    //   2243: iload 8
    //   2245: istore 6
    //   2247: new 65	java/lang/Exception
    //   2250: dup
    //   2251: ldc_w 507
    //   2254: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2257: athrow
    //   2258: astore_1
    //   2259: iload 6
    //   2261: istore 4
    //   2263: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   2266: iload 6
    //   2268: istore 4
    //   2270: ldc 75
    //   2272: iconst_1
    //   2273: new 124	java/lang/StringBuilder
    //   2276: dup
    //   2277: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2280: aload 42
    //   2282: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2285: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: ldc_w 361
    //   2291: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   2297: lload 27
    //   2299: lsub
    //   2300: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2303: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2306: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2309: iload 6
    //   2311: istore 4
    //   2313: aload_0
    //   2314: getfield 203	bihu:jdField_g_of_type_Int	I
    //   2317: iconst_3
    //   2318: if_icmpne +64 -> 2382
    //   2321: iload 10
    //   2323: ifeq +59 -> 2382
    //   2326: iload 6
    //   2328: istore 4
    //   2330: bipush 30
    //   2332: aload_0
    //   2333: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2336: sipush 300
    //   2339: iconst_1
    //   2340: anewarray 4	java/lang/Object
    //   2343: dup
    //   2344: iconst_0
    //   2345: new 124	java/lang/StringBuilder
    //   2348: dup
    //   2349: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2352: aload 42
    //   2354: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2357: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: ldc_w 361
    //   2363: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   2369: lload 27
    //   2371: lsub
    //   2372: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: aastore
    //   2379: invokestatic 367	anmq:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   2382: iload 6
    //   2384: ifeq +119 -> 2503
    //   2387: iload 6
    //   2389: istore 4
    //   2391: aload_0
    //   2392: invokevirtual 369	bihu:b	()Z
    //   2395: ifne +108 -> 2503
    //   2398: iload 6
    //   2400: istore 4
    //   2402: aload_0
    //   2403: getfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   2406: ifeq +97 -> 2503
    //   2409: iload 6
    //   2411: istore 4
    //   2413: aload 39
    //   2415: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   2418: ifeq +4628 -> 7046
    //   2421: iload 6
    //   2423: istore 4
    //   2425: aload 39
    //   2427: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2430: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2433: ifne +4577 -> 7010
    //   2436: iload 6
    //   2438: istore 4
    //   2440: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   2443: aload 39
    //   2445: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2448: aload 39
    //   2450: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2453: getstatic 34	bihw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   2456: aload 39
    //   2458: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2461: invokeinterface 220 2 0
    //   2466: checkcast 145	java/lang/Integer
    //   2469: invokevirtual 384	java/lang/Integer:intValue	()I
    //   2472: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2475: iload 6
    //   2477: istore 4
    //   2479: aload 39
    //   2481: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2484: aload 38
    //   2486: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   2489: iconst_m1
    //   2490: aload_2
    //   2491: invokestatic 392	bihw:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2494: iload 6
    //   2496: istore 4
    //   2498: aload_0
    //   2499: iconst_0
    //   2500: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   2503: iload 6
    //   2505: istore 4
    //   2507: new 124	java/lang/StringBuilder
    //   2510: dup
    //   2511: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2514: astore_2
    //   2515: iload 6
    //   2517: istore 4
    //   2519: aload 39
    //   2521: getfield 396	asjz:jdField_b_of_type_Boolean	Z
    //   2524: ifeq +5809 -> 8333
    //   2527: ldc_w 398
    //   2530: astore_0
    //   2531: iload 6
    //   2533: istore 4
    //   2535: aload_2
    //   2536: aload_0
    //   2537: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2540: astore_2
    //   2541: iload 6
    //   2543: istore 4
    //   2545: aload 39
    //   2547: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   2550: ifeq +4508 -> 7058
    //   2553: ldc_w 400
    //   2556: astore_0
    //   2557: iload 6
    //   2559: istore 4
    //   2561: aload_2
    //   2562: aload_0
    //   2563: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2569: pop
    //   2570: iload 6
    //   2572: istore 4
    //   2574: aload 33
    //   2576: aload 31
    //   2578: aload 32
    //   2580: aload 29
    //   2582: invokestatic 403	bihw:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   2585: iload 6
    //   2587: istore 4
    //   2589: aload_1
    //   2590: athrow
    //   2591: astore_0
    //   2592: iload 4
    //   2594: istore_3
    //   2595: ldc 75
    //   2597: iconst_1
    //   2598: aload_0
    //   2599: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2602: invokestatic 509	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2605: iload_3
    //   2606: istore 4
    //   2608: iload 4
    //   2610: istore_3
    //   2611: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2614: ifeq +5453 -> 8067
    //   2617: ldc 75
    //   2619: iconst_2
    //   2620: new 124	java/lang/StringBuilder
    //   2623: dup
    //   2624: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2627: ldc_w 511
    //   2630: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2633: iload 4
    //   2635: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2638: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2641: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2644: iload 4
    //   2646: ireturn
    //   2647: aload 29
    //   2649: astore 30
    //   2651: aload 29
    //   2653: astore 35
    //   2655: aload 29
    //   2657: astore 34
    //   2659: iload 5
    //   2661: istore 4
    //   2663: aload_0
    //   2664: getfield 487	bihu:q	Z
    //   2667: ifeq +122 -> 2789
    //   2670: aload 29
    //   2672: astore 30
    //   2674: aload 29
    //   2676: astore 35
    //   2678: aload 29
    //   2680: astore 34
    //   2682: iload 5
    //   2684: istore 4
    //   2686: aload 29
    //   2688: ldc_w 513
    //   2691: invokevirtual 473	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2694: ifne +95 -> 2789
    //   2697: aload 29
    //   2699: astore 35
    //   2701: aload 29
    //   2703: astore 34
    //   2705: iload 5
    //   2707: istore 4
    //   2709: new 515	java/util/Random
    //   2712: dup
    //   2713: aload_1
    //   2714: invokestatic 519	bapc:a	(Ljava/lang/String;)J
    //   2717: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   2720: lor
    //   2721: invokespecial 522	java/util/Random:<init>	(J)V
    //   2724: invokevirtual 525	java/util/Random:nextInt	()I
    //   2727: istore 13
    //   2729: aload 29
    //   2731: astore 35
    //   2733: aload 29
    //   2735: astore 34
    //   2737: iload 5
    //   2739: istore 4
    //   2741: aload 29
    //   2743: invokestatic 528	bihw:b	(Ljava/lang/String;)Z
    //   2746: ifeq +383 -> 3129
    //   2749: aload 29
    //   2751: astore 35
    //   2753: aload 29
    //   2755: astore 34
    //   2757: iload 5
    //   2759: istore 4
    //   2761: new 124	java/lang/StringBuilder
    //   2764: dup
    //   2765: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2768: aload 29
    //   2770: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2773: ldc_w 530
    //   2776: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: iload 13
    //   2781: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2784: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2787: astore 30
    //   2789: aload 30
    //   2791: astore 35
    //   2793: aload 30
    //   2795: astore 34
    //   2797: iload 5
    //   2799: istore 4
    //   2801: aload 30
    //   2803: invokestatic 533	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2806: astore 29
    //   2808: aload 29
    //   2810: astore 35
    //   2812: aload 29
    //   2814: astore 34
    //   2816: iload 5
    //   2818: istore 4
    //   2820: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2823: ifeq +42 -> 2865
    //   2826: aload 29
    //   2828: astore 35
    //   2830: aload 29
    //   2832: astore 34
    //   2834: iload 5
    //   2836: istore 4
    //   2838: ldc 75
    //   2840: iconst_2
    //   2841: new 124	java/lang/StringBuilder
    //   2844: dup
    //   2845: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   2848: ldc_w 535
    //   2851: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: aload 29
    //   2856: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2862: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2865: aload 29
    //   2867: astore 35
    //   2869: aload 29
    //   2871: astore 34
    //   2873: iload 5
    //   2875: istore 4
    //   2877: aload_0
    //   2878: getfield 420	bihu:jdField_f_of_type_Int	I
    //   2881: sipush 302
    //   2884: if_icmpne +5133 -> 8017
    //   2887: iload 12
    //   2889: ifne +5128 -> 8017
    //   2892: aload 29
    //   2894: astore 35
    //   2896: aload 29
    //   2898: astore 34
    //   2900: iload 5
    //   2902: istore 4
    //   2904: aload_0
    //   2905: getfield 480	bihu:r	Z
    //   2908: ifeq +5109 -> 8017
    //   2911: aload 29
    //   2913: astore 35
    //   2915: aload 29
    //   2917: astore 34
    //   2919: iload 5
    //   2921: istore 4
    //   2923: aload 29
    //   2925: ldc_w 537
    //   2928: invokevirtual 540	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2931: ifeq +5086 -> 8017
    //   2934: aload 29
    //   2936: astore 35
    //   2938: aload 29
    //   2940: astore 34
    //   2942: iload 5
    //   2944: istore 4
    //   2946: aload_0
    //   2947: iconst_0
    //   2948: putfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   2951: iconst_1
    //   2952: istore 4
    //   2954: iconst_1
    //   2955: istore 5
    //   2957: aload 29
    //   2959: astore 35
    //   2961: aload 29
    //   2963: astore 34
    //   2965: aload 29
    //   2967: ldc_w 542
    //   2970: ldc_w 544
    //   2973: invokevirtual 547	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2976: astore 29
    //   2978: new 549	org/apache/http/client/methods/HttpGet
    //   2981: dup
    //   2982: aload 29
    //   2984: invokespecial 550	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2987: astore 34
    //   2989: aload_0
    //   2990: invokevirtual 553	bihu:a	()Ljava/util/Map;
    //   2993: astore 30
    //   2995: aload 30
    //   2997: ifnull +175 -> 3172
    //   3000: aload 30
    //   3002: invokeinterface 557 1 0
    //   3007: invokeinterface 563 1 0
    //   3012: astore 35
    //   3014: aload 35
    //   3016: invokeinterface 568 1 0
    //   3021: ifeq +151 -> 3172
    //   3024: aload 35
    //   3026: invokeinterface 572 1 0
    //   3031: checkcast 197	java/lang/String
    //   3034: astore 45
    //   3036: aload 30
    //   3038: aload 45
    //   3040: invokeinterface 220 2 0
    //   3045: checkcast 197	java/lang/String
    //   3048: astore 46
    //   3050: aload 34
    //   3052: aload 45
    //   3054: aload 46
    //   3056: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3059: aload 42
    //   3061: ldc_w 578
    //   3064: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: aload 45
    //   3069: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3072: ldc_w 580
    //   3075: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: aload 46
    //   3080: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3083: pop
    //   3084: goto -70 -> 3014
    //   3087: astore 35
    //   3089: aload 33
    //   3091: astore 34
    //   3093: iconst_0
    //   3094: istore 14
    //   3096: iload 5
    //   3098: istore 4
    //   3100: aload 32
    //   3102: astore 30
    //   3104: iload 6
    //   3106: istore 8
    //   3108: aload 35
    //   3110: astore 33
    //   3112: iload 7
    //   3114: istore 6
    //   3116: iload_3
    //   3117: istore 5
    //   3119: aload 34
    //   3121: astore 32
    //   3123: iload 8
    //   3125: istore_3
    //   3126: goto -2160 -> 966
    //   3129: aload 29
    //   3131: astore 35
    //   3133: aload 29
    //   3135: astore 34
    //   3137: iload 5
    //   3139: istore 4
    //   3141: new 124	java/lang/StringBuilder
    //   3144: dup
    //   3145: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   3148: aload 29
    //   3150: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3153: ldc_w 582
    //   3156: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3159: iload 13
    //   3161: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3164: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3167: astore 30
    //   3169: goto -380 -> 2789
    //   3172: aload_0
    //   3173: getfield 585	bihu:k	Z
    //   3176: ifeq +41 -> 3217
    //   3179: getstatic 588	blem:jdField_a_of_type_Boolean	Z
    //   3182: ifeq +35 -> 3217
    //   3185: invokestatic 589	blem:a	()Z
    //   3188: ifeq +29 -> 3217
    //   3191: aload 34
    //   3193: ldc_w 591
    //   3196: ldc_w 593
    //   3199: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3202: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3205: ifeq +12 -> 3217
    //   3208: ldc 75
    //   3210: iconst_2
    //   3211: ldc_w 595
    //   3214: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3217: aload_0
    //   3218: getfield 598	bihu:l	Z
    //   3221: ifeq +154 -> 3375
    //   3224: invokestatic 603	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3227: getstatic 609	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   3230: invokevirtual 612	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   3233: invokevirtual 613	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3236: astore 30
    //   3238: aload 30
    //   3240: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3243: ifne +1016 -> 4259
    //   3246: aload 30
    //   3248: invokestatic 617	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3251: iconst_1
    //   3252: iand
    //   3253: iconst_1
    //   3254: if_icmpne +1005 -> 4259
    //   3257: aload 34
    //   3259: ldc_w 591
    //   3262: ldc_w 619
    //   3265: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3268: ldc_w 621
    //   3271: iconst_3
    //   3272: anewarray 4	java/lang/Object
    //   3275: dup
    //   3276: iconst_0
    //   3277: getstatic 27	bihw:jdField_a_of_type_ArrayOfInt	[I
    //   3280: iconst_0
    //   3281: iaload
    //   3282: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3285: aastore
    //   3286: dup
    //   3287: iconst_1
    //   3288: getstatic 27	bihw:jdField_a_of_type_ArrayOfInt	[I
    //   3291: iconst_1
    //   3292: iaload
    //   3293: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3296: aastore
    //   3297: dup
    //   3298: iconst_2
    //   3299: getstatic 27	bihw:jdField_a_of_type_ArrayOfInt	[I
    //   3302: iconst_2
    //   3303: iaload
    //   3304: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3307: aastore
    //   3308: invokestatic 625	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3311: astore 30
    //   3313: aload 34
    //   3315: ldc_w 627
    //   3318: new 124	java/lang/StringBuilder
    //   3321: dup
    //   3322: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   3325: ldc_w 629
    //   3328: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: aload 30
    //   3333: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3339: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3342: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3345: ifeq +30 -> 3375
    //   3348: ldc 75
    //   3350: iconst_2
    //   3351: new 124	java/lang/StringBuilder
    //   3354: dup
    //   3355: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   3358: ldc_w 631
    //   3361: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3364: aload 29
    //   3366: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3369: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3372: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3375: aload 36
    //   3377: ifnull +80 -> 3457
    //   3380: aload 36
    //   3382: invokevirtual 295	java/io/File:exists	()Z
    //   3385: ifeq +72 -> 3457
    //   3388: aload 36
    //   3390: invokevirtual 634	java/io/File:length	()J
    //   3393: lstore 21
    //   3395: aload 34
    //   3397: ldc_w 636
    //   3400: new 124	java/lang/StringBuilder
    //   3403: dup
    //   3404: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   3407: ldc_w 638
    //   3410: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3413: lload 21
    //   3415: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3418: ldc_w 640
    //   3421: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3427: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3430: aload 42
    //   3432: new 124	java/lang/StringBuilder
    //   3435: dup
    //   3436: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   3439: ldc_w 642
    //   3442: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: lload 21
    //   3447: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3450: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3453: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: pop
    //   3457: aload_0
    //   3458: getfield 645	bihu:m	Z
    //   3461: ifne +119 -> 3580
    //   3464: aload_0
    //   3465: getfield 648	bihu:j	Z
    //   3468: ifeq +112 -> 3580
    //   3471: aload 38
    //   3473: ifnull +107 -> 3580
    //   3476: aload 38
    //   3478: invokevirtual 295	java/io/File:exists	()Z
    //   3481: ifeq +99 -> 3580
    //   3484: aload_0
    //   3485: getfield 650	bihu:jdField_i_of_type_Long	J
    //   3488: lconst_0
    //   3489: lcmp
    //   3490: ifle +787 -> 4277
    //   3493: aload_0
    //   3494: getfield 650	bihu:jdField_i_of_type_Long	J
    //   3497: lstore 21
    //   3499: lload 21
    //   3501: lconst_0
    //   3502: lcmp
    //   3503: ifle +77 -> 3580
    //   3506: new 652	java/text/SimpleDateFormat
    //   3509: dup
    //   3510: ldc_w 654
    //   3513: getstatic 660	java/util/Locale:US	Ljava/util/Locale;
    //   3516: invokespecial 663	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3519: astore 30
    //   3521: aload 30
    //   3523: ldc_w 665
    //   3526: invokestatic 671	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3529: invokevirtual 675	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3532: aload 30
    //   3534: new 677	java/util/Date
    //   3537: dup
    //   3538: lload 21
    //   3540: invokespecial 678	java/util/Date:<init>	(J)V
    //   3543: invokevirtual 681	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3546: astore 30
    //   3548: aload 30
    //   3550: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3553: ifne +27 -> 3580
    //   3556: aload 34
    //   3558: ldc_w 683
    //   3561: aload 30
    //   3563: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3566: aload 42
    //   3568: ldc_w 685
    //   3571: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3574: aload 30
    //   3576: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: pop
    //   3580: getstatic 20	bihw:jdField_a_of_type_Boolean	Z
    //   3583: ifeq +105 -> 3688
    //   3586: aload_0
    //   3587: getfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   3590: ifeq +98 -> 3688
    //   3593: aload_0
    //   3594: getfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   3597: ifeq +91 -> 3688
    //   3600: aload 39
    //   3602: getfield 396	asjz:jdField_b_of_type_Boolean	Z
    //   3605: ifne +83 -> 3688
    //   3608: aload 39
    //   3610: invokestatic 688	bihw:a	(Lasjz;)V
    //   3613: aload 39
    //   3615: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   3618: ifeq +70 -> 3688
    //   3621: aload 34
    //   3623: new 690	java/net/URI
    //   3626: dup
    //   3627: aload 39
    //   3629: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3632: invokespecial 691	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3635: invokevirtual 695	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3638: aload 34
    //   3640: ldc_w 697
    //   3643: aload 39
    //   3645: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3648: invokevirtual 576	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3651: aload 42
    //   3653: ldc_w 699
    //   3656: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3659: aload 39
    //   3661: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3664: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3667: ldc_w 701
    //   3670: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3673: aload 39
    //   3675: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3678: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3681: ldc_w 703
    //   3684: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3687: pop
    //   3688: aload 44
    //   3690: invokevirtual 708	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3693: invokestatic 712	bhvd:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3696: astore 30
    //   3698: aload 30
    //   3700: aload_0
    //   3701: getfield 713	bihu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3704: invokevirtual 717	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3707: ifne +14 -> 3721
    //   3710: aload_0
    //   3711: iconst_0
    //   3712: putfield 338	bihu:jdField_f_of_type_Boolean	Z
    //   3715: aload_0
    //   3716: aload 30
    //   3718: putfield 713	bihu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3721: aload 44
    //   3723: invokestatic 722	bhnv:a	(Landroid/net/NetworkInfo;)Z
    //   3726: ifeq +561 -> 4287
    //   3729: aload_0
    //   3730: getfield 338	bihu:jdField_f_of_type_Boolean	Z
    //   3733: ifne +4275 -> 8008
    //   3736: invokestatic 727	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3739: astore 30
    //   3741: invokestatic 730	android/net/Proxy:getDefaultPort	()I
    //   3744: istore 8
    //   3746: aload 30
    //   3748: ifnull +4253 -> 8001
    //   3751: iload 8
    //   3753: ifle +4248 -> 8001
    //   3756: aload 40
    //   3758: ldc_w 732
    //   3761: new 734	org/apache/http/HttpHost
    //   3764: dup
    //   3765: aload 30
    //   3767: iload 8
    //   3769: invokespecial 737	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3772: invokeinterface 155 3 0
    //   3777: pop
    //   3778: iconst_1
    //   3779: istore 4
    //   3781: aload 42
    //   3783: ldc_w 739
    //   3786: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3789: iconst_1
    //   3790: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3793: ldc_w 741
    //   3796: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3799: aload 30
    //   3801: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3804: ldc_w 743
    //   3807: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3810: iload 8
    //   3812: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3815: pop
    //   3816: iload 4
    //   3818: istore 7
    //   3820: iload_3
    //   3821: istore 4
    //   3823: iload 7
    //   3825: istore_3
    //   3826: aload_0
    //   3827: getfield 278	bihu:p	Z
    //   3830: ifne +18 -> 3848
    //   3833: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3836: invokestatic 746	bhnv:h	(Landroid/content/Context;)Z
    //   3839: ifeq +9 -> 3848
    //   3842: aload 40
    //   3844: iconst_0
    //   3845: invokestatic 752	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3848: aload 40
    //   3850: ldc_w 754
    //   3853: iload 4
    //   3855: invokeinterface 758 3 0
    //   3860: pop
    //   3861: aload 34
    //   3863: aload 40
    //   3865: invokevirtual 762	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3868: aload_0
    //   3869: getfield 162	bihu:n	Z
    //   3872: ifeq +425 -> 4297
    //   3875: ldc 164
    //   3877: astore 30
    //   3879: aload 34
    //   3881: ldc 166
    //   3883: aload 30
    //   3885: invokevirtual 765	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3888: ldc_w 766
    //   3891: invokestatic 770	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   3894: getstatic 775	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3897: aload 34
    //   3899: invokevirtual 781	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3902: astore 35
    //   3904: iload 5
    //   3906: istore 7
    //   3908: aload 35
    //   3910: invokeinterface 787 1 0
    //   3915: invokeinterface 792 1 0
    //   3920: istore 8
    //   3922: iload 5
    //   3924: istore 7
    //   3926: aload_0
    //   3927: iload 8
    //   3929: putfield 420	bihu:jdField_f_of_type_Int	I
    //   3932: iload 5
    //   3934: istore 7
    //   3936: aload 39
    //   3938: iload 8
    //   3940: putfield 794	asjz:jdField_c_of_type_Int	I
    //   3943: iload 5
    //   3945: istore 7
    //   3947: aload 42
    //   3949: ldc_w 796
    //   3952: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3955: aload 34
    //   3957: invokevirtual 800	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3960: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3963: ldc_w 802
    //   3966: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3969: iload 8
    //   3971: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3974: ldc_w 804
    //   3977: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3980: pop
    //   3981: iload 5
    //   3983: istore 7
    //   3985: aload 35
    //   3987: invokeinterface 808 1 0
    //   3992: astore 30
    //   3994: iload 5
    //   3996: istore 7
    //   3998: aload 30
    //   4000: invokeinterface 811 1 0
    //   4005: ifeq +300 -> 4305
    //   4008: iload 5
    //   4010: istore 7
    //   4012: aload 30
    //   4014: invokeinterface 815 1 0
    //   4019: astore 34
    //   4021: iload 5
    //   4023: istore 7
    //   4025: aload 34
    //   4027: invokeinterface 818 1 0
    //   4032: astore 44
    //   4034: iload 5
    //   4036: istore 7
    //   4038: ldc_w 820
    //   4041: aload 44
    //   4043: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4046: ifne +138 -> 4184
    //   4049: iload 5
    //   4051: istore 7
    //   4053: ldc_w 825
    //   4056: aload 44
    //   4058: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4061: ifne +123 -> 4184
    //   4064: iload 5
    //   4066: istore 7
    //   4068: ldc_w 827
    //   4071: aload 44
    //   4073: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4076: ifne +108 -> 4184
    //   4079: iload 5
    //   4081: istore 7
    //   4083: ldc_w 829
    //   4086: aload 44
    //   4088: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4091: ifne +93 -> 4184
    //   4094: iload 5
    //   4096: istore 7
    //   4098: ldc_w 831
    //   4101: aload 44
    //   4103: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4106: ifne +78 -> 4184
    //   4109: iload 5
    //   4111: istore 7
    //   4113: ldc_w 833
    //   4116: aload 44
    //   4118: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4121: ifne +63 -> 4184
    //   4124: iload 5
    //   4126: istore 7
    //   4128: ldc_w 835
    //   4131: aload 44
    //   4133: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4136: ifne +48 -> 4184
    //   4139: iload 5
    //   4141: istore 7
    //   4143: ldc_w 837
    //   4146: aload 44
    //   4148: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4151: ifne +33 -> 4184
    //   4154: iload 5
    //   4156: istore 7
    //   4158: ldc_w 839
    //   4161: aload 44
    //   4163: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4166: ifne +18 -> 4184
    //   4169: iload 5
    //   4171: istore 7
    //   4173: ldc_w 841
    //   4176: aload 44
    //   4178: invokevirtual 823	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4181: ifeq -187 -> 3994
    //   4184: iload 5
    //   4186: istore 7
    //   4188: aload 42
    //   4190: ldc_w 578
    //   4193: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4196: aload 44
    //   4198: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4201: ldc_w 843
    //   4204: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4207: aload 34
    //   4209: invokeinterface 846 1 0
    //   4214: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4217: pop
    //   4218: goto -224 -> 3994
    //   4221: astore 34
    //   4223: iconst_1
    //   4224: istore 14
    //   4226: iload 4
    //   4228: istore 5
    //   4230: aload 32
    //   4232: astore 30
    //   4234: aload 33
    //   4236: astore 32
    //   4238: iload 6
    //   4240: istore 8
    //   4242: aload 34
    //   4244: astore 33
    //   4246: iload_3
    //   4247: istore 6
    //   4249: iload 7
    //   4251: istore 4
    //   4253: iload 8
    //   4255: istore_3
    //   4256: goto -3290 -> 966
    //   4259: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4262: ifeq -887 -> 3375
    //   4265: ldc 75
    //   4267: iconst_2
    //   4268: ldc_w 848
    //   4271: invokestatic 851	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4274: goto -899 -> 3375
    //   4277: aload 38
    //   4279: invokevirtual 854	java/io/File:lastModified	()J
    //   4282: lstore 21
    //   4284: goto -785 -> 3499
    //   4287: sipush 4096
    //   4290: istore 4
    //   4292: iconst_0
    //   4293: istore_3
    //   4294: goto -468 -> 3826
    //   4297: ldc_w 856
    //   4300: astore 30
    //   4302: goto -423 -> 3879
    //   4305: sipush 200
    //   4308: iload 8
    //   4310: if_icmpeq +11 -> 4321
    //   4313: sipush 206
    //   4316: iload 8
    //   4318: if_icmpne +2051 -> 6369
    //   4321: iload 5
    //   4323: istore 7
    //   4325: aload 35
    //   4327: invokeinterface 860 1 0
    //   4332: astore 30
    //   4334: aload 30
    //   4336: invokeinterface 865 1 0
    //   4341: lstore 23
    //   4343: lload 23
    //   4345: lstore 21
    //   4347: iload 5
    //   4349: istore 7
    //   4351: aload 42
    //   4353: ldc_w 867
    //   4356: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: lload 23
    //   4361: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4364: pop
    //   4365: lload 23
    //   4367: lstore 21
    //   4369: iload 5
    //   4371: istore 7
    //   4373: aload 35
    //   4375: ldc_w 869
    //   4378: invokeinterface 873 2 0
    //   4383: astore 33
    //   4385: lload 23
    //   4387: lstore 21
    //   4389: iload 5
    //   4391: istore 7
    //   4393: aload 35
    //   4395: ldc_w 827
    //   4398: invokeinterface 873 2 0
    //   4403: astore 34
    //   4405: aload 33
    //   4407: ifnull +250 -> 4657
    //   4410: lload 23
    //   4412: lstore 21
    //   4414: iload 5
    //   4416: istore 7
    //   4418: aload 33
    //   4420: invokeinterface 846 1 0
    //   4425: ldc_w 875
    //   4428: invokevirtual 879	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4431: iconst_1
    //   4432: aaload
    //   4433: invokestatic 617	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4436: i2l
    //   4437: lstore 17
    //   4439: lload 17
    //   4441: lstore 21
    //   4443: iload 5
    //   4445: istore 7
    //   4447: aload 36
    //   4449: invokevirtual 634	java/io/File:length	()J
    //   4452: lstore 23
    //   4454: lload 17
    //   4456: lstore 21
    //   4458: iload 5
    //   4460: istore 7
    //   4462: aload 42
    //   4464: ldc_w 881
    //   4467: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4470: lload 17
    //   4472: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4475: ldc_w 883
    //   4478: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4481: lload 23
    //   4483: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4486: pop
    //   4487: lload 17
    //   4489: lstore 21
    //   4491: iload 5
    //   4493: istore 7
    //   4495: aload_0
    //   4496: getfield 885	bihu:jdField_g_of_type_Boolean	Z
    //   4499: ifne +10 -> 4509
    //   4502: lload 17
    //   4504: lconst_1
    //   4505: lcmp
    //   4506: iflt +38 -> 4544
    //   4509: lload 17
    //   4511: lstore 21
    //   4513: iload 5
    //   4515: istore 7
    //   4517: aload_0
    //   4518: getfield 887	bihu:jdField_e_of_type_Long	J
    //   4521: lconst_0
    //   4522: lcmp
    //   4523: ifle +167 -> 4690
    //   4526: lload 17
    //   4528: lstore 21
    //   4530: iload 5
    //   4532: istore 7
    //   4534: lload 17
    //   4536: aload_0
    //   4537: getfield 887	bihu:jdField_e_of_type_Long	J
    //   4540: lcmp
    //   4541: ifle +149 -> 4690
    //   4544: iconst_1
    //   4545: istore 7
    //   4547: iconst_1
    //   4548: istore 13
    //   4550: bipush 138
    //   4552: istore 8
    //   4554: lload 17
    //   4556: lstore 21
    //   4558: aload_0
    //   4559: bipush 138
    //   4561: putfield 119	bihu:jdField_a_of_type_Int	I
    //   4564: iload 8
    //   4566: istore 6
    //   4568: iload 13
    //   4570: istore 5
    //   4572: iload 8
    //   4574: istore 7
    //   4576: aload 42
    //   4578: ldc_w 889
    //   4581: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4584: aload_0
    //   4585: getfield 887	bihu:jdField_e_of_type_Long	J
    //   4588: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4591: pop
    //   4592: iload 8
    //   4594: istore 6
    //   4596: iload 13
    //   4598: istore 5
    //   4600: iload 8
    //   4602: istore 7
    //   4604: new 65	java/lang/Exception
    //   4607: dup
    //   4608: ldc_w 891
    //   4611: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4614: athrow
    //   4615: astore 33
    //   4617: iload 6
    //   4619: istore 7
    //   4621: iload 4
    //   4623: istore 8
    //   4625: aload 30
    //   4627: astore 34
    //   4629: iload 5
    //   4631: istore 4
    //   4633: iconst_1
    //   4634: istore 14
    //   4636: iload_3
    //   4637: istore 6
    //   4639: iload 8
    //   4641: istore 5
    //   4643: aload 32
    //   4645: astore 30
    //   4647: aload 34
    //   4649: astore 32
    //   4651: iload 7
    //   4653: istore_3
    //   4654: goto -3688 -> 966
    //   4657: lload 23
    //   4659: lstore 17
    //   4661: aload 34
    //   4663: ifnull -224 -> 4439
    //   4666: lload 23
    //   4668: lstore 21
    //   4670: iload 5
    //   4672: istore 7
    //   4674: aload 34
    //   4676: invokeinterface 846 1 0
    //   4681: invokestatic 617	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4684: i2l
    //   4685: lstore 17
    //   4687: goto -248 -> 4439
    //   4690: lconst_0
    //   4691: lload 23
    //   4693: lcmp
    //   4694: ifeq +74 -> 4768
    //   4697: lload 23
    //   4699: lload 17
    //   4701: lcmp
    //   4702: iflt +66 -> 4768
    //   4705: lload 17
    //   4707: lstore 21
    //   4709: iload 5
    //   4711: istore 7
    //   4713: aload 36
    //   4715: invokevirtual 301	java/io/File:delete	()Z
    //   4718: pop
    //   4719: bipush 139
    //   4721: istore 8
    //   4723: lload 17
    //   4725: lstore 21
    //   4727: iload 5
    //   4729: istore 7
    //   4731: aload_0
    //   4732: bipush 139
    //   4734: putfield 119	bihu:jdField_a_of_type_Int	I
    //   4737: iload 8
    //   4739: istore 6
    //   4741: iload 8
    //   4743: istore 7
    //   4745: new 65	java/lang/Exception
    //   4748: dup
    //   4749: ldc_w 893
    //   4752: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4755: athrow
    //   4756: astore_1
    //   4757: iload 7
    //   4759: istore 6
    //   4761: aload 30
    //   4763: astore 33
    //   4765: goto -2506 -> 2259
    //   4768: lload 23
    //   4770: lconst_0
    //   4771: lcmp
    //   4772: ifeq +335 -> 5107
    //   4775: iconst_1
    //   4776: istore 14
    //   4778: lload 17
    //   4780: lstore 21
    //   4782: iload 5
    //   4784: istore 7
    //   4786: new 895	java/io/BufferedOutputStream
    //   4789: dup
    //   4790: new 897	java/io/FileOutputStream
    //   4793: dup
    //   4794: aload 36
    //   4796: iload 14
    //   4798: invokespecial 900	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4801: invokespecial 903	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4804: astore 33
    //   4806: aload 35
    //   4808: ldc_w 839
    //   4811: invokeinterface 873 2 0
    //   4816: ifnull +297 -> 5113
    //   4819: ldc 164
    //   4821: aload 35
    //   4823: ldc_w 839
    //   4826: invokeinterface 873 2 0
    //   4831: invokeinterface 846 1 0
    //   4836: invokevirtual 717	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4839: ifeq +274 -> 5113
    //   4842: new 905	java/util/zip/GZIPInputStream
    //   4845: dup
    //   4846: aload 30
    //   4848: invokeinterface 909 1 0
    //   4853: invokespecial 912	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4856: astore 32
    //   4858: aload 42
    //   4860: ldc_w 914
    //   4863: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4866: pop
    //   4867: aload 32
    //   4869: astore 31
    //   4871: invokestatic 920	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4874: iload 4
    //   4876: invokevirtual 924	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4879: astore 44
    //   4881: iconst_0
    //   4882: istore 7
    //   4884: lload 19
    //   4886: lstore 21
    //   4888: aload_0
    //   4889: invokevirtual 369	bihu:b	()Z
    //   4892: ifne +326 -> 5218
    //   4895: lload 19
    //   4897: lstore 21
    //   4899: aload 31
    //   4901: aload 44
    //   4903: invokevirtual 930	java/io/InputStream:read	([B)I
    //   4906: istore 8
    //   4908: iload 8
    //   4910: iconst_m1
    //   4911: if_icmpeq +307 -> 5218
    //   4914: lload 19
    //   4916: lstore 21
    //   4918: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4921: ifeq +64 -> 4985
    //   4924: lconst_0
    //   4925: lload 23
    //   4927: lcmp
    //   4928: ifne +57 -> 4985
    //   4931: aconst_null
    //   4932: astore 34
    //   4934: iload 8
    //   4936: iconst_4
    //   4937: if_icmple +192 -> 5129
    //   4940: iconst_m1
    //   4941: aload 44
    //   4943: iconst_0
    //   4944: baload
    //   4945: if_icmpne +184 -> 5129
    //   4948: bipush 216
    //   4950: aload 44
    //   4952: iconst_1
    //   4953: baload
    //   4954: if_icmpne +175 -> 5129
    //   4957: ldc_w 932
    //   4960: astore 32
    //   4962: aload 32
    //   4964: ifnull +21 -> 4985
    //   4967: lload 19
    //   4969: lstore 21
    //   4971: aload 42
    //   4973: ldc_w 934
    //   4976: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4979: aload 32
    //   4981: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4984: pop
    //   4985: lload 19
    //   4987: lstore 21
    //   4989: aload 33
    //   4991: aload 44
    //   4993: iconst_0
    //   4994: iload 8
    //   4996: invokevirtual 938	java/io/BufferedOutputStream:write	([BII)V
    //   4999: lload 23
    //   5001: iload 8
    //   5003: i2l
    //   5004: ladd
    //   5005: lstore 23
    //   5007: lload 19
    //   5009: iload 8
    //   5011: i2l
    //   5012: ladd
    //   5013: lstore 19
    //   5015: iload 7
    //   5017: iload 8
    //   5019: iadd
    //   5020: istore 7
    //   5022: lload 17
    //   5024: lconst_0
    //   5025: lcmp
    //   5026: ifle +2972 -> 7998
    //   5029: lload 19
    //   5031: lstore 21
    //   5033: aload_0
    //   5034: getfield 940	bihu:jdField_f_of_type_Long	J
    //   5037: lconst_0
    //   5038: lcmp
    //   5039: ifne +17 -> 5056
    //   5042: lload 19
    //   5044: lstore 21
    //   5046: aload_0
    //   5047: lload 17
    //   5049: ldc2_w 941
    //   5052: ldiv
    //   5053: putfield 940	bihu:jdField_f_of_type_Long	J
    //   5056: lload 19
    //   5058: lstore 21
    //   5060: iload 7
    //   5062: i2l
    //   5063: aload_0
    //   5064: getfield 940	bihu:jdField_f_of_type_Long	J
    //   5067: lcmp
    //   5068: ifge +11 -> 5079
    //   5071: lload 23
    //   5073: lload 17
    //   5075: lcmp
    //   5076: iflt +2922 -> 7998
    //   5079: lload 19
    //   5081: lstore 21
    //   5083: aload_0
    //   5084: lload 17
    //   5086: lload 23
    //   5088: iload 11
    //   5090: invokevirtual 945	bihu:a	(JJI)V
    //   5093: lload 19
    //   5095: lstore 21
    //   5097: aload_0
    //   5098: invokevirtual 947	bihu:b	()V
    //   5101: iconst_0
    //   5102: istore 7
    //   5104: goto -220 -> 4884
    //   5107: iconst_0
    //   5108: istore 14
    //   5110: goto -332 -> 4778
    //   5113: aload 30
    //   5115: invokeinterface 909 1 0
    //   5120: astore 32
    //   5122: aload 32
    //   5124: astore 31
    //   5126: goto -255 -> 4871
    //   5129: iload 8
    //   5131: bipush 8
    //   5133: if_icmple +2966 -> 8099
    //   5136: bipush 137
    //   5138: aload 44
    //   5140: iconst_0
    //   5141: baload
    //   5142: if_icmpne +2957 -> 8099
    //   5145: bipush 80
    //   5147: aload 44
    //   5149: iconst_1
    //   5150: baload
    //   5151: if_icmpne +2948 -> 8099
    //   5154: bipush 78
    //   5156: aload 44
    //   5158: iconst_2
    //   5159: baload
    //   5160: if_icmpne +2939 -> 8099
    //   5163: bipush 71
    //   5165: aload 44
    //   5167: iconst_3
    //   5168: baload
    //   5169: if_icmpne +2930 -> 8099
    //   5172: bipush 13
    //   5174: aload 44
    //   5176: iconst_4
    //   5177: baload
    //   5178: if_icmpne +2921 -> 8099
    //   5181: bipush 10
    //   5183: aload 44
    //   5185: iconst_5
    //   5186: baload
    //   5187: if_icmpne +2912 -> 8099
    //   5190: bipush 26
    //   5192: aload 44
    //   5194: bipush 6
    //   5196: baload
    //   5197: if_icmpne +2902 -> 8099
    //   5200: bipush 10
    //   5202: aload 44
    //   5204: bipush 7
    //   5206: baload
    //   5207: if_icmpne +2892 -> 8099
    //   5210: ldc_w 949
    //   5213: astore 32
    //   5215: goto -253 -> 4962
    //   5218: lload 19
    //   5220: lstore 21
    //   5222: aload 33
    //   5224: invokevirtual 952	java/io/BufferedOutputStream:flush	()V
    //   5227: lload 19
    //   5229: lstore 21
    //   5231: invokestatic 920	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   5234: aload 44
    //   5236: invokevirtual 956	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   5239: lload 19
    //   5241: lstore 21
    //   5243: aload 36
    //   5245: invokevirtual 634	java/io/File:length	()J
    //   5248: lstore 23
    //   5250: lload 19
    //   5252: lstore 21
    //   5254: aload 42
    //   5256: ldc_w 958
    //   5259: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: lload 23
    //   5264: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5267: pop
    //   5268: lload 23
    //   5270: lload 17
    //   5272: lcmp
    //   5273: ifeq +80 -> 5353
    //   5276: lload 17
    //   5278: lconst_1
    //   5279: lcmp
    //   5280: ifge +21 -> 5301
    //   5283: lload 19
    //   5285: lstore 21
    //   5287: aload_0
    //   5288: getfield 885	bihu:jdField_g_of_type_Boolean	Z
    //   5291: ifeq +10 -> 5301
    //   5294: lload 23
    //   5296: lconst_0
    //   5297: lcmp
    //   5298: ifgt +55 -> 5353
    //   5301: lload 19
    //   5303: lstore 21
    //   5305: aload 35
    //   5307: ldc_w 839
    //   5310: invokeinterface 873 2 0
    //   5315: ifnull +868 -> 6183
    //   5318: lload 19
    //   5320: lstore 21
    //   5322: ldc 164
    //   5324: aload 35
    //   5326: ldc_w 839
    //   5329: invokeinterface 873 2 0
    //   5334: invokeinterface 846 1 0
    //   5339: invokevirtual 717	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5342: ifeq +841 -> 6183
    //   5345: lload 23
    //   5347: lload 17
    //   5349: lcmp
    //   5350: iflt +833 -> 6183
    //   5353: lload 19
    //   5355: lstore 21
    //   5357: aload_0
    //   5358: iconst_0
    //   5359: putfield 119	bihu:jdField_a_of_type_Int	I
    //   5362: aload 38
    //   5364: invokevirtual 295	java/io/File:exists	()Z
    //   5367: ifeq +9 -> 5376
    //   5370: aload 38
    //   5372: invokevirtual 301	java/io/File:delete	()Z
    //   5375: pop
    //   5376: aload 36
    //   5378: aload 38
    //   5380: invokevirtual 962	java/io/File:renameTo	(Ljava/io/File;)Z
    //   5383: istore 14
    //   5385: aload 42
    //   5387: ldc_w 964
    //   5390: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5393: iload 14
    //   5395: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5398: pop
    //   5399: aload_0
    //   5400: getfield 648	bihu:j	Z
    //   5403: ifeq +158 -> 5561
    //   5406: aload 35
    //   5408: ldc_w 831
    //   5411: invokeinterface 967 2 0
    //   5416: ifeq +145 -> 5561
    //   5419: aload 35
    //   5421: ldc_w 831
    //   5424: invokeinterface 873 2 0
    //   5429: invokeinterface 846 1 0
    //   5434: astore 32
    //   5436: aload 32
    //   5438: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5441: istore 14
    //   5443: iload 14
    //   5445: ifne +116 -> 5561
    //   5448: new 652	java/text/SimpleDateFormat
    //   5451: dup
    //   5452: ldc_w 969
    //   5455: getstatic 660	java/util/Locale:US	Ljava/util/Locale;
    //   5458: invokespecial 663	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   5461: astore 34
    //   5463: aload 34
    //   5465: ldc_w 665
    //   5468: invokestatic 671	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   5471: invokevirtual 675	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   5474: aload 34
    //   5476: aload 32
    //   5478: invokevirtual 973	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   5481: invokevirtual 976	java/util/Date:getTime	()J
    //   5484: lstore 21
    //   5486: aload 38
    //   5488: lload 21
    //   5490: invokevirtual 980	java/io/File:setLastModified	(J)Z
    //   5493: pop
    //   5494: aload_0
    //   5495: lload 21
    //   5497: putfield 650	bihu:jdField_i_of_type_Long	J
    //   5500: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5503: ifeq +58 -> 5561
    //   5506: ldc 75
    //   5508: iconst_2
    //   5509: new 124	java/lang/StringBuilder
    //   5512: dup
    //   5513: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   5516: ldc_w 982
    //   5519: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5522: lload 21
    //   5524: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5527: ldc_w 984
    //   5530: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5533: aload 38
    //   5535: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   5538: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5541: ldc_w 986
    //   5544: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5547: aload 38
    //   5549: invokevirtual 854	java/io/File:lastModified	()J
    //   5552: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5555: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5558: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5561: iconst_0
    //   5562: istore 7
    //   5564: iload 5
    //   5566: istore 6
    //   5568: iload 7
    //   5570: istore 5
    //   5572: lload 19
    //   5574: lstore 21
    //   5576: aload 30
    //   5578: astore 32
    //   5580: aload 33
    //   5582: astore 30
    //   5584: iload 5
    //   5586: istore 7
    //   5588: iload 6
    //   5590: istore 5
    //   5592: lload 17
    //   5594: lstore 19
    //   5596: lload 21
    //   5598: lstore 17
    //   5600: iload 5
    //   5602: istore 6
    //   5604: getstatic 42	bihw:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5607: ifnonnull +17 -> 5624
    //   5610: iload 5
    //   5612: istore 6
    //   5614: new 39	java/util/concurrent/ConcurrentHashMap
    //   5617: dup
    //   5618: invokespecial 40	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5621: putstatic 42	bihw:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5624: iload 7
    //   5626: ifeq +1174 -> 6800
    //   5629: iload 5
    //   5631: istore 6
    //   5633: aload_0
    //   5634: invokevirtual 369	bihu:b	()Z
    //   5637: ifne +1163 -> 6800
    //   5640: iload 5
    //   5642: istore 6
    //   5644: iload 12
    //   5646: aload_0
    //   5647: getfield 282	bihu:jdField_b_of_type_Int	I
    //   5650: if_icmpge +1047 -> 6697
    //   5653: iload 5
    //   5655: istore 6
    //   5657: aload 41
    //   5659: monitorenter
    //   5660: sipush 2000
    //   5663: i2l
    //   5664: lstore 21
    //   5666: aload 41
    //   5668: lload 21
    //   5670: invokevirtual 989	java/lang/Object:wait	(J)V
    //   5673: aload 41
    //   5675: monitorexit
    //   5676: iload 5
    //   5678: istore 6
    //   5680: aload_0
    //   5681: getfield 119	bihu:jdField_a_of_type_Int	I
    //   5684: sipush 302
    //   5687: if_icmpne +44 -> 5731
    //   5690: iload 5
    //   5692: istore 6
    //   5694: aload 35
    //   5696: ldc_w 833
    //   5699: invokeinterface 873 2 0
    //   5704: astore 33
    //   5706: aload 33
    //   5708: ifnull +23 -> 5731
    //   5711: iload 5
    //   5713: istore 6
    //   5715: aload 37
    //   5717: ldc_w 991
    //   5720: aload 33
    //   5722: invokeinterface 846 1 0
    //   5727: invokevirtual 411	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5730: pop
    //   5731: iload 7
    //   5733: istore 8
    //   5735: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   5738: iload 7
    //   5740: istore 8
    //   5742: ldc 75
    //   5744: iconst_1
    //   5745: new 124	java/lang/StringBuilder
    //   5748: dup
    //   5749: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   5752: aload 42
    //   5754: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5757: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5760: ldc_w 361
    //   5763: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5766: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   5769: lload 27
    //   5771: lsub
    //   5772: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5775: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5778: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5781: iload 7
    //   5783: istore 8
    //   5785: aload_0
    //   5786: getfield 203	bihu:jdField_g_of_type_Int	I
    //   5789: iconst_3
    //   5790: if_icmpne +64 -> 5854
    //   5793: iload 10
    //   5795: ifeq +59 -> 5854
    //   5798: iload 7
    //   5800: istore 8
    //   5802: bipush 30
    //   5804: aload_0
    //   5805: getfield 200	bihu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5808: sipush 300
    //   5811: iconst_1
    //   5812: anewarray 4	java/lang/Object
    //   5815: dup
    //   5816: iconst_0
    //   5817: new 124	java/lang/StringBuilder
    //   5820: dup
    //   5821: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   5824: aload 42
    //   5826: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5829: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5832: ldc_w 361
    //   5835: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5838: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   5841: lload 27
    //   5843: lsub
    //   5844: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5847: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5850: aastore
    //   5851: invokestatic 367	anmq:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   5854: iload 7
    //   5856: ifeq +119 -> 5975
    //   5859: iload 7
    //   5861: istore 8
    //   5863: aload_0
    //   5864: invokevirtual 369	bihu:b	()Z
    //   5867: ifne +108 -> 5975
    //   5870: iload 7
    //   5872: istore 8
    //   5874: aload_0
    //   5875: getfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   5878: ifeq +97 -> 5975
    //   5881: iload 7
    //   5883: istore 8
    //   5885: aload 39
    //   5887: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   5890: ifeq +964 -> 6854
    //   5893: iload 7
    //   5895: istore 8
    //   5897: aload 39
    //   5899: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5902: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5905: ifne +913 -> 6818
    //   5908: iload 7
    //   5910: istore 8
    //   5912: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   5915: aload 39
    //   5917: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5920: aload 39
    //   5922: getfield 374	asjz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5925: getstatic 34	bihw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   5928: aload 39
    //   5930: getfield 381	asjz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5933: invokeinterface 220 2 0
    //   5938: checkcast 145	java/lang/Integer
    //   5941: invokevirtual 384	java/lang/Integer:intValue	()I
    //   5944: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5947: iload 7
    //   5949: istore 8
    //   5951: aload 39
    //   5953: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5956: aload 38
    //   5958: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   5961: iconst_m1
    //   5962: aload_2
    //   5963: invokestatic 392	bihw:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   5966: iload 7
    //   5968: istore 8
    //   5970: aload_0
    //   5971: iconst_0
    //   5972: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   5975: iload 7
    //   5977: istore 8
    //   5979: new 124	java/lang/StringBuilder
    //   5982: dup
    //   5983: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   5986: astore 34
    //   5988: iload 7
    //   5990: istore 8
    //   5992: aload 39
    //   5994: getfield 396	asjz:jdField_b_of_type_Boolean	Z
    //   5997: ifeq +2305 -> 8302
    //   6000: ldc_w 398
    //   6003: astore 33
    //   6005: iload 7
    //   6007: istore 8
    //   6009: aload 34
    //   6011: aload 33
    //   6013: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6016: astore 34
    //   6018: iload 7
    //   6020: istore 8
    //   6022: aload 39
    //   6024: getfield 372	asjz:jdField_a_of_type_Boolean	Z
    //   6027: ifeq +839 -> 6866
    //   6030: ldc_w 400
    //   6033: astore 33
    //   6035: iload 7
    //   6037: istore 8
    //   6039: aload 34
    //   6041: aload 33
    //   6043: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6046: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6049: astore 33
    //   6051: iload 7
    //   6053: istore 8
    //   6055: aload 32
    //   6057: aload 31
    //   6059: aload 30
    //   6061: aload 29
    //   6063: invokestatic 403	bihw:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   6066: iload 5
    //   6068: istore 8
    //   6070: iconst_1
    //   6071: istore 14
    //   6073: iload 12
    //   6075: iconst_1
    //   6076: iadd
    //   6077: istore 5
    //   6079: iload_3
    //   6080: istore 6
    //   6082: iload 7
    //   6084: istore_3
    //   6085: goto -4651 -> 1434
    //   6088: astore 34
    //   6090: ldc 75
    //   6092: iconst_1
    //   6093: new 124	java/lang/StringBuilder
    //   6096: dup
    //   6097: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   6100: ldc_w 993
    //   6103: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: aload 32
    //   6108: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6111: ldc_w 995
    //   6114: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6117: aload 34
    //   6119: invokevirtual 996	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6122: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6125: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6128: invokestatic 509	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6131: goto -570 -> 5561
    //   6134: astore 34
    //   6136: aload 33
    //   6138: astore 32
    //   6140: iconst_0
    //   6141: istore 8
    //   6143: aload 34
    //   6145: astore 33
    //   6147: iload 4
    //   6149: istore 7
    //   6151: aload 30
    //   6153: astore 34
    //   6155: iload 5
    //   6157: istore 4
    //   6159: iconst_1
    //   6160: istore 14
    //   6162: iload_3
    //   6163: istore 6
    //   6165: iload 7
    //   6167: istore 5
    //   6169: aload 32
    //   6171: astore 30
    //   6173: aload 34
    //   6175: astore 32
    //   6177: iload 8
    //   6179: istore_3
    //   6180: goto -5214 -> 966
    //   6183: lload 19
    //   6185: lstore 21
    //   6187: aload_0
    //   6188: invokevirtual 369	bihu:b	()Z
    //   6191: istore 14
    //   6193: iload 14
    //   6195: ifeq +85 -> 6280
    //   6198: iconst_1
    //   6199: istore 7
    //   6201: bipush 150
    //   6203: istore 5
    //   6205: aload_0
    //   6206: bipush 150
    //   6208: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6211: iload 5
    //   6213: istore 6
    //   6215: aload 42
    //   6217: ldc_w 998
    //   6220: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6223: pop
    //   6224: iload 7
    //   6226: istore 6
    //   6228: goto -656 -> 5572
    //   6231: astore 34
    //   6233: aload 33
    //   6235: astore 32
    //   6237: bipush 150
    //   6239: istore 7
    //   6241: iconst_1
    //   6242: istore 8
    //   6244: iconst_1
    //   6245: istore 14
    //   6247: aload 34
    //   6249: astore 33
    //   6251: iload 4
    //   6253: istore 5
    //   6255: aload 30
    //   6257: astore 34
    //   6259: iload_3
    //   6260: istore 6
    //   6262: iload 8
    //   6264: istore 4
    //   6266: aload 32
    //   6268: astore 30
    //   6270: aload 34
    //   6272: astore 32
    //   6274: iload 7
    //   6276: istore_3
    //   6277: goto -5311 -> 966
    //   6280: bipush 151
    //   6282: istore 7
    //   6284: lload 19
    //   6286: lstore 21
    //   6288: aload_0
    //   6289: bipush 151
    //   6291: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6294: iload 7
    //   6296: istore 6
    //   6298: aload 36
    //   6300: invokevirtual 301	java/io/File:delete	()Z
    //   6303: pop
    //   6304: iload 7
    //   6306: istore 6
    //   6308: new 65	java/lang/Exception
    //   6311: dup
    //   6312: ldc_w 1000
    //   6315: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6318: athrow
    //   6319: astore 35
    //   6321: aload 33
    //   6323: astore 32
    //   6325: bipush 151
    //   6327: istore 8
    //   6329: iload 4
    //   6331: istore 7
    //   6333: aload 30
    //   6335: astore 34
    //   6337: iconst_1
    //   6338: istore 14
    //   6340: iload 5
    //   6342: istore 4
    //   6344: aload 35
    //   6346: astore 33
    //   6348: iload_3
    //   6349: istore 6
    //   6351: iload 7
    //   6353: istore 5
    //   6355: aload 32
    //   6357: astore 30
    //   6359: aload 34
    //   6361: astore 32
    //   6363: iload 8
    //   6365: istore_3
    //   6366: goto -5400 -> 966
    //   6369: sipush 404
    //   6372: iload 8
    //   6374: if_icmpne +1852 -> 8226
    //   6377: iconst_1
    //   6378: istore 5
    //   6380: iconst_1
    //   6381: istore 7
    //   6383: aload_0
    //   6384: iload 8
    //   6386: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6389: lload 17
    //   6391: lstore 21
    //   6393: iload 8
    //   6395: istore 7
    //   6397: aload 32
    //   6399: astore 30
    //   6401: lload 19
    //   6403: lstore 17
    //   6405: lload 21
    //   6407: lstore 19
    //   6409: aload 33
    //   6411: astore 32
    //   6413: goto -813 -> 5600
    //   6416: iload 5
    //   6418: istore 7
    //   6420: aload_0
    //   6421: getfield 278	bihu:p	Z
    //   6424: ifne +82 -> 6506
    //   6427: iconst_1
    //   6428: istore 13
    //   6430: iconst_1
    //   6431: istore 7
    //   6433: iload 13
    //   6435: istore 5
    //   6437: aload_0
    //   6438: getfield 480	bihu:r	Z
    //   6441: ifeq +28 -> 6469
    //   6444: iload 13
    //   6446: istore 5
    //   6448: iload 8
    //   6450: sipush 302
    //   6453: if_icmpne +16 -> 6469
    //   6456: iload 13
    //   6458: istore 5
    //   6460: iload 12
    //   6462: iconst_m1
    //   6463: if_icmpne +6 -> 6469
    //   6466: iconst_0
    //   6467: istore 5
    //   6469: iload 5
    //   6471: istore 7
    //   6473: aload_0
    //   6474: iload 8
    //   6476: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6479: lload 17
    //   6481: lstore 21
    //   6483: iload 8
    //   6485: istore 7
    //   6487: aload 32
    //   6489: astore 30
    //   6491: lload 19
    //   6493: lstore 17
    //   6495: lload 21
    //   6497: lstore 19
    //   6499: aload 33
    //   6501: astore 32
    //   6503: goto -903 -> 5600
    //   6506: sipush 304
    //   6509: iload 8
    //   6511: if_icmpne +38 -> 6549
    //   6514: iload 5
    //   6516: istore 7
    //   6518: aload_0
    //   6519: iconst_0
    //   6520: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6523: lload 17
    //   6525: lstore 21
    //   6527: iconst_0
    //   6528: istore 7
    //   6530: aload 32
    //   6532: astore 30
    //   6534: lload 19
    //   6536: lstore 17
    //   6538: lload 21
    //   6540: lstore 19
    //   6542: aload 33
    //   6544: astore 32
    //   6546: goto -946 -> 5600
    //   6549: sipush 416
    //   6552: iload 8
    //   6554: if_icmpne +62 -> 6616
    //   6557: iload 5
    //   6559: istore 7
    //   6561: aload 36
    //   6563: invokevirtual 295	java/io/File:exists	()Z
    //   6566: ifeq +13 -> 6579
    //   6569: iload 5
    //   6571: istore 7
    //   6573: aload 36
    //   6575: invokevirtual 301	java/io/File:delete	()Z
    //   6578: pop
    //   6579: iload 5
    //   6581: istore 7
    //   6583: aload_0
    //   6584: iload 8
    //   6586: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6589: lload 17
    //   6591: lstore 21
    //   6593: iload 8
    //   6595: istore 7
    //   6597: aload 32
    //   6599: astore 30
    //   6601: lload 19
    //   6603: lstore 17
    //   6605: lload 21
    //   6607: lstore 19
    //   6609: aload 33
    //   6611: astore 32
    //   6613: goto -1013 -> 5600
    //   6616: iload 5
    //   6618: istore 7
    //   6620: aload_0
    //   6621: iload 8
    //   6623: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6626: lload 17
    //   6628: lstore 21
    //   6630: iload 8
    //   6632: istore 7
    //   6634: aload 32
    //   6636: astore 30
    //   6638: lload 19
    //   6640: lstore 17
    //   6642: lload 21
    //   6644: lstore 19
    //   6646: aload 33
    //   6648: astore 32
    //   6650: goto -1050 -> 5600
    //   6653: astore 33
    //   6655: ldc 75
    //   6657: iconst_1
    //   6658: new 124	java/lang/StringBuilder
    //   6661: dup
    //   6662: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   6665: ldc_w 1002
    //   6668: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6671: aload 29
    //   6673: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6676: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6679: invokestatic 509	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6682: goto -1009 -> 5673
    //   6685: astore 33
    //   6687: aload 41
    //   6689: monitorexit
    //   6690: iload 5
    //   6692: istore 6
    //   6694: aload 33
    //   6696: athrow
    //   6697: iload 5
    //   6699: istore 6
    //   6701: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   6704: ldc2_w 1003
    //   6707: ldiv
    //   6708: l2i
    //   6709: istore 8
    //   6711: iload 5
    //   6713: istore 6
    //   6715: aload_0
    //   6716: getfield 1006	bihu:jdField_c_of_type_Boolean	Z
    //   6719: ifeq +23 -> 6742
    //   6722: iload 5
    //   6724: istore 6
    //   6726: getstatic 42	bihw:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6729: aload_0
    //   6730: getfield 1008	bihu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6733: iload 8
    //   6735: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6738: invokevirtual 1009	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6741: pop
    //   6742: iconst_1
    //   6743: istore 6
    //   6745: new 65	java/lang/Exception
    //   6748: dup
    //   6749: new 124	java/lang/StringBuilder
    //   6752: dup
    //   6753: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   6756: ldc_w 1011
    //   6759: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6762: aload 29
    //   6764: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6767: ldc_w 1013
    //   6770: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6773: aload_0
    //   6774: getfield 371	bihu:jdField_e_of_type_Boolean	Z
    //   6777: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6780: ldc_w 1015
    //   6783: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6786: aload_0
    //   6787: getfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   6790: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6793: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6796: invokespecial 322	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6799: athrow
    //   6800: iload 5
    //   6802: istore 6
    //   6804: getstatic 42	bihw:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6807: aload_0
    //   6808: getfield 1008	bihu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6811: invokevirtual 1018	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6814: pop
    //   6815: goto -1139 -> 5676
    //   6818: iload 7
    //   6820: istore 8
    //   6822: invokestatic 1023	besx:a	()Lbesx;
    //   6825: astore 33
    //   6827: aload 33
    //   6829: ifnull -882 -> 5947
    //   6832: iload 7
    //   6834: istore 8
    //   6836: aload 33
    //   6838: aload 39
    //   6840: getfield 1025	asjz:jdField_d_of_type_Int	I
    //   6843: aload 39
    //   6845: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6848: invokevirtual 1027	besx:a	(ILjava/lang/String;)V
    //   6851: goto -904 -> 5947
    //   6854: iload 7
    //   6856: istore 8
    //   6858: aload_0
    //   6859: iconst_1
    //   6860: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   6863: goto -888 -> 5975
    //   6866: ldc_w 1029
    //   6869: astore 33
    //   6871: goto -836 -> 6035
    //   6874: aload 33
    //   6876: instanceof 1031
    //   6879: ifeq +12 -> 6891
    //   6882: aload_0
    //   6883: bipush 144
    //   6885: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6888: goto -5878 -> 1010
    //   6891: aload 33
    //   6893: instanceof 324
    //   6896: ifne +11 -> 6907
    //   6899: aload 33
    //   6901: instanceof 326
    //   6904: ifeq +12 -> 6916
    //   6907: aload_0
    //   6908: bipush 143
    //   6910: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6913: goto -5903 -> 1010
    //   6916: aload 33
    //   6918: instanceof 328
    //   6921: ifeq +12 -> 6933
    //   6924: aload_0
    //   6925: bipush 142
    //   6927: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6930: goto -5920 -> 1010
    //   6933: aload_0
    //   6934: getfield 119	bihu:jdField_a_of_type_Int	I
    //   6937: ifne -5927 -> 1010
    //   6940: aload_0
    //   6941: bipush 141
    //   6943: putfield 119	bihu:jdField_a_of_type_Int	I
    //   6946: goto -5936 -> 1010
    //   6949: aload_0
    //   6950: iconst_0
    //   6951: putfield 338	bihu:jdField_f_of_type_Boolean	Z
    //   6954: goto -5915 -> 1039
    //   6957: iload_3
    //   6958: istore 8
    //   6960: invokestatic 1023	besx:a	()Lbesx;
    //   6963: astore 33
    //   6965: aload 33
    //   6967: ifnull -5674 -> 1293
    //   6970: iload_3
    //   6971: istore 8
    //   6973: aload 33
    //   6975: aload 39
    //   6977: getfield 1025	asjz:jdField_d_of_type_Int	I
    //   6980: aload 39
    //   6982: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6985: invokevirtual 1027	besx:a	(ILjava/lang/String;)V
    //   6988: goto -5695 -> 1293
    //   6991: iload_3
    //   6992: istore 8
    //   6994: aload_0
    //   6995: iconst_1
    //   6996: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   6999: goto -5680 -> 1319
    //   7002: ldc_w 1029
    //   7005: astore 33
    //   7007: goto -5632 -> 1375
    //   7010: iload 6
    //   7012: istore 4
    //   7014: invokestatic 1023	besx:a	()Lbesx;
    //   7017: astore 30
    //   7019: aload 30
    //   7021: ifnull -4546 -> 2475
    //   7024: iload 6
    //   7026: istore 4
    //   7028: aload 30
    //   7030: aload 39
    //   7032: getfield 1025	asjz:jdField_d_of_type_Int	I
    //   7035: aload 39
    //   7037: getfield 389	asjz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7040: invokevirtual 1027	besx:a	(ILjava/lang/String;)V
    //   7043: goto -4568 -> 2475
    //   7046: iload 6
    //   7048: istore 4
    //   7050: aload_0
    //   7051: iconst_1
    //   7052: putfield 394	bihu:jdField_d_of_type_Boolean	Z
    //   7055: goto -4552 -> 2503
    //   7058: ldc_w 1029
    //   7061: astore_0
    //   7062: goto -4505 -> 2557
    //   7065: iload 4
    //   7067: istore 8
    //   7069: aload_0
    //   7070: bipush 146
    //   7072: putfield 119	bihu:jdField_a_of_type_Int	I
    //   7075: iload 4
    //   7077: istore 8
    //   7079: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7082: ifeq +16 -> 7098
    //   7085: iload 4
    //   7087: istore 8
    //   7089: ldc 75
    //   7091: iconst_2
    //   7092: ldc_w 1033
    //   7095: invokestatic 851	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7098: lconst_0
    //   7099: lstore 19
    //   7101: iconst_m1
    //   7102: istore 6
    //   7104: iconst_m1
    //   7105: istore 4
    //   7107: lconst_0
    //   7108: lstore 17
    //   7110: aload 29
    //   7112: astore 32
    //   7114: iload_3
    //   7115: istore 5
    //   7117: aload 30
    //   7119: astore 29
    //   7121: aload 31
    //   7123: astore 30
    //   7125: aload 32
    //   7127: astore 31
    //   7129: aload 33
    //   7131: astore 32
    //   7133: aload 34
    //   7135: astore 33
    //   7137: iload 4
    //   7139: istore_3
    //   7140: goto -5623 -> 1517
    //   7143: iconst_0
    //   7144: istore 15
    //   7146: goto -5403 -> 1743
    //   7149: iload_3
    //   7150: istore 4
    //   7152: aload_0
    //   7153: getfield 1036	bihu:o	Z
    //   7156: istore 15
    //   7158: iload 15
    //   7160: iconst_1
    //   7161: if_icmpne +823 -> 7984
    //   7164: iload_3
    //   7165: istore 4
    //   7167: iload 9
    //   7169: ifle +809 -> 7978
    //   7172: iload 4
    //   7174: istore 8
    //   7176: aload_0
    //   7177: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7180: invokeinterface 175 1 0
    //   7185: iconst_1
    //   7186: if_icmple +792 -> 7978
    //   7189: iload 4
    //   7191: istore 8
    //   7193: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7196: ifeq +52 -> 7248
    //   7199: iload 4
    //   7201: istore 8
    //   7203: ldc 75
    //   7205: iconst_2
    //   7206: new 124	java/lang/StringBuilder
    //   7209: dup
    //   7210: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7213: ldc_w 1038
    //   7216: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7219: iload 9
    //   7221: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7224: ldc_w 1040
    //   7227: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7230: aload_0
    //   7231: getfield 169	bihu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7234: invokeinterface 175 1 0
    //   7239: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7242: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7245: invokestatic 851	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7248: iload 4
    //   7250: istore 8
    //   7252: aload_0
    //   7253: bipush 148
    //   7255: putfield 119	bihu:jdField_a_of_type_Int	I
    //   7258: iconst_m1
    //   7259: istore_3
    //   7260: iload_3
    //   7261: istore 5
    //   7263: aload_0
    //   7264: invokevirtual 369	bihu:b	()Z
    //   7267: ifeq +43 -> 7310
    //   7270: iload_3
    //   7271: istore 5
    //   7273: aload_0
    //   7274: getfield 1042	bihu:jdField_i_of_type_Boolean	Z
    //   7277: ifne +33 -> 7310
    //   7280: iload_3
    //   7281: istore 4
    //   7283: iload_3
    //   7284: istore 5
    //   7286: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7289: ifeq -4681 -> 2608
    //   7292: iload_3
    //   7293: istore 5
    //   7295: ldc 75
    //   7297: iconst_2
    //   7298: ldc_w 1044
    //   7301: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7304: iload_3
    //   7305: istore 4
    //   7307: goto -4699 -> 2608
    //   7310: iload_3
    //   7311: istore 5
    //   7313: aload_0
    //   7314: invokevirtual 369	bihu:b	()Z
    //   7317: ifeq +1030 -> 8347
    //   7320: iload_3
    //   7321: istore 5
    //   7323: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7326: ifeq +15 -> 7341
    //   7329: iload_3
    //   7330: istore 5
    //   7332: ldc 75
    //   7334: iconst_2
    //   7335: ldc_w 1046
    //   7338: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7341: iload_3
    //   7342: istore 5
    //   7344: aload_0
    //   7345: iconst_2
    //   7346: invokevirtual 1048	bihu:a	(I)V
    //   7349: iload_3
    //   7350: istore 5
    //   7352: aload_0
    //   7353: invokevirtual 1050	bihu:c	()V
    //   7356: iload_3
    //   7357: istore 5
    //   7359: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7362: ifeq +15 -> 7377
    //   7365: iload_3
    //   7366: istore 5
    //   7368: ldc 75
    //   7370: iconst_2
    //   7371: ldc_w 1052
    //   7374: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7377: iload_3
    //   7378: istore 5
    //   7380: aload_0
    //   7381: invokevirtual 122	bihu:e	()V
    //   7384: iload_3
    //   7385: istore 4
    //   7387: goto -4779 -> 2608
    //   7390: iload_3
    //   7391: istore 5
    //   7393: aload_0
    //   7394: iload 4
    //   7396: invokevirtual 1048	bihu:a	(I)V
    //   7399: goto -43 -> 7356
    //   7402: iconst_m1
    //   7403: istore 4
    //   7405: goto -15 -> 7390
    //   7408: astore_0
    //   7409: iconst_m1
    //   7410: istore_3
    //   7411: goto -4816 -> 2595
    //   7414: astore 32
    //   7416: goto -5383 -> 2033
    //   7419: astore_1
    //   7420: aload 35
    //   7422: astore 29
    //   7424: goto -5165 -> 2259
    //   7427: astore_1
    //   7428: aload 30
    //   7430: astore 33
    //   7432: goto -5173 -> 2259
    //   7435: astore_1
    //   7436: aload 33
    //   7438: astore 32
    //   7440: aload 30
    //   7442: astore 33
    //   7444: goto -5185 -> 2259
    //   7447: astore_1
    //   7448: aload 32
    //   7450: astore 31
    //   7452: aload 33
    //   7454: astore 32
    //   7456: aload 30
    //   7458: astore 33
    //   7460: goto -5201 -> 2259
    //   7463: astore_1
    //   7464: aload 33
    //   7466: astore 32
    //   7468: aload 30
    //   7470: astore 33
    //   7472: goto -5213 -> 2259
    //   7475: astore_1
    //   7476: iconst_0
    //   7477: istore 6
    //   7479: aload 33
    //   7481: astore 32
    //   7483: aload 30
    //   7485: astore 33
    //   7487: goto -5228 -> 2259
    //   7490: astore_1
    //   7491: aload 33
    //   7493: astore 32
    //   7495: aload 30
    //   7497: astore 33
    //   7499: goto -5240 -> 2259
    //   7502: astore 29
    //   7504: aload 33
    //   7506: astore 35
    //   7508: iconst_0
    //   7509: istore 14
    //   7511: aload 32
    //   7513: astore 30
    //   7515: iload 6
    //   7517: istore 8
    //   7519: aload 29
    //   7521: astore 33
    //   7523: aload 34
    //   7525: astore 29
    //   7527: iload 7
    //   7529: istore 6
    //   7531: iload_3
    //   7532: istore 5
    //   7534: aload 35
    //   7536: astore 32
    //   7538: iload 8
    //   7540: istore_3
    //   7541: goto -6575 -> 966
    //   7544: astore 30
    //   7546: iconst_1
    //   7547: istore 8
    //   7549: aload 33
    //   7551: astore 34
    //   7553: iconst_0
    //   7554: istore 14
    //   7556: aload 30
    //   7558: astore 33
    //   7560: iload 5
    //   7562: istore 4
    //   7564: aload 32
    //   7566: astore 30
    //   7568: iload 6
    //   7570: istore 7
    //   7572: iload 8
    //   7574: istore 6
    //   7576: iload_3
    //   7577: istore 5
    //   7579: aload 34
    //   7581: astore 32
    //   7583: iload 7
    //   7585: istore_3
    //   7586: goto -6620 -> 966
    //   7589: astore 35
    //   7591: iload_3
    //   7592: istore 7
    //   7594: iload 4
    //   7596: istore_3
    //   7597: iconst_0
    //   7598: istore 14
    //   7600: aload 33
    //   7602: astore 34
    //   7604: iload 5
    //   7606: istore 4
    //   7608: aload 32
    //   7610: astore 30
    //   7612: iload 6
    //   7614: istore 8
    //   7616: aload 35
    //   7618: astore 33
    //   7620: iload 7
    //   7622: istore 6
    //   7624: iload_3
    //   7625: istore 5
    //   7627: aload 34
    //   7629: astore 32
    //   7631: iload 8
    //   7633: istore_3
    //   7634: goto -6668 -> 966
    //   7637: astore 33
    //   7639: iconst_1
    //   7640: istore 14
    //   7642: iload 4
    //   7644: istore 7
    //   7646: aload 30
    //   7648: astore 34
    //   7650: iload 6
    //   7652: istore 8
    //   7654: iload_3
    //   7655: istore 6
    //   7657: iload 5
    //   7659: istore 4
    //   7661: iload 7
    //   7663: istore 5
    //   7665: aload 32
    //   7667: astore 30
    //   7669: aload 34
    //   7671: astore 32
    //   7673: iload 8
    //   7675: istore_3
    //   7676: goto -6710 -> 966
    //   7679: astore 33
    //   7681: iload 6
    //   7683: istore 8
    //   7685: iload 4
    //   7687: istore 5
    //   7689: aload 30
    //   7691: astore 34
    //   7693: iconst_1
    //   7694: istore 14
    //   7696: iload 7
    //   7698: istore 4
    //   7700: lload 21
    //   7702: lstore 17
    //   7704: iload_3
    //   7705: istore 6
    //   7707: aload 32
    //   7709: astore 30
    //   7711: aload 34
    //   7713: astore 32
    //   7715: iload 8
    //   7717: istore_3
    //   7718: goto -6752 -> 966
    //   7721: astore 35
    //   7723: aload 33
    //   7725: astore 32
    //   7727: iload 6
    //   7729: istore 7
    //   7731: iload 4
    //   7733: istore 8
    //   7735: aload 30
    //   7737: astore 34
    //   7739: iconst_1
    //   7740: istore 14
    //   7742: iload 5
    //   7744: istore 4
    //   7746: aload 35
    //   7748: astore 33
    //   7750: iload_3
    //   7751: istore 6
    //   7753: iload 8
    //   7755: istore 5
    //   7757: aload 32
    //   7759: astore 30
    //   7761: aload 34
    //   7763: astore 32
    //   7765: iload 7
    //   7767: istore_3
    //   7768: goto -6802 -> 966
    //   7771: astore 35
    //   7773: aload 33
    //   7775: astore 31
    //   7777: iload 6
    //   7779: istore 7
    //   7781: iload 4
    //   7783: istore 8
    //   7785: aload 30
    //   7787: astore 34
    //   7789: iload 5
    //   7791: istore 4
    //   7793: iconst_1
    //   7794: istore 14
    //   7796: aload 35
    //   7798: astore 33
    //   7800: iload_3
    //   7801: istore 6
    //   7803: iload 8
    //   7805: istore 5
    //   7807: aload 31
    //   7809: astore 30
    //   7811: aload 32
    //   7813: astore 31
    //   7815: aload 34
    //   7817: astore 32
    //   7819: iload 7
    //   7821: istore_3
    //   7822: goto -6856 -> 966
    //   7825: astore 35
    //   7827: aload 33
    //   7829: astore 32
    //   7831: iload 6
    //   7833: istore 7
    //   7835: iload 4
    //   7837: istore 8
    //   7839: aload 30
    //   7841: astore 34
    //   7843: iconst_1
    //   7844: istore 14
    //   7846: iload 5
    //   7848: istore 4
    //   7850: aload 35
    //   7852: astore 33
    //   7854: iload_3
    //   7855: istore 6
    //   7857: iload 8
    //   7859: istore 5
    //   7861: aload 32
    //   7863: astore 30
    //   7865: aload 34
    //   7867: astore 32
    //   7869: iload 7
    //   7871: istore_3
    //   7872: goto -6906 -> 966
    //   7875: astore 35
    //   7877: lload 21
    //   7879: lstore 19
    //   7881: aload 33
    //   7883: astore 32
    //   7885: iload 6
    //   7887: istore 7
    //   7889: iload 4
    //   7891: istore 8
    //   7893: aload 30
    //   7895: astore 34
    //   7897: iconst_1
    //   7898: istore 14
    //   7900: iload 5
    //   7902: istore 4
    //   7904: aload 35
    //   7906: astore 33
    //   7908: iload_3
    //   7909: istore 6
    //   7911: iload 8
    //   7913: istore 5
    //   7915: aload 32
    //   7917: astore 30
    //   7919: aload 34
    //   7921: astore 32
    //   7923: iload 7
    //   7925: istore_3
    //   7926: goto -6960 -> 966
    //   7929: astore 34
    //   7931: aload 33
    //   7933: astore 32
    //   7935: iload 6
    //   7937: istore 7
    //   7939: iconst_1
    //   7940: istore 8
    //   7942: iconst_1
    //   7943: istore 14
    //   7945: aload 34
    //   7947: astore 33
    //   7949: iload 4
    //   7951: istore 5
    //   7953: aload 30
    //   7955: astore 34
    //   7957: iload_3
    //   7958: istore 6
    //   7960: iload 8
    //   7962: istore 4
    //   7964: aload 32
    //   7966: astore 30
    //   7968: aload 34
    //   7970: astore 32
    //   7972: iload 7
    //   7974: istore_3
    //   7975: goto -7009 -> 966
    //   7978: iload 4
    //   7980: istore_3
    //   7981: goto -721 -> 7260
    //   7984: iload 9
    //   7986: istore 4
    //   7988: goto -5945 -> 2043
    //   7991: aload 37
    //   7993: astore 34
    //   7995: goto -6454 -> 1541
    //   7998: goto -3114 -> 4884
    //   8001: iload 7
    //   8003: istore 4
    //   8005: goto -4189 -> 3816
    //   8008: iload_3
    //   8009: istore 4
    //   8011: iload 7
    //   8013: istore_3
    //   8014: goto -4188 -> 3826
    //   8017: iload 8
    //   8019: istore 5
    //   8021: goto -5043 -> 2978
    //   8024: aload 32
    //   8026: astore 33
    //   8028: iload_3
    //   8029: istore 8
    //   8031: iload 4
    //   8033: istore_3
    //   8034: lload 19
    //   8036: lstore 21
    //   8038: iload 6
    //   8040: istore 7
    //   8042: lload 17
    //   8044: lstore 19
    //   8046: lload 21
    //   8048: lstore 17
    //   8050: aload 30
    //   8052: astore 32
    //   8054: iload 8
    //   8056: istore 6
    //   8058: iload 5
    //   8060: istore 12
    //   8062: goto -7433 -> 629
    //   8065: iconst_m1
    //   8066: istore_3
    //   8067: iload_3
    //   8068: ireturn
    //   8069: iconst_m1
    //   8070: ireturn
    //   8071: ldc_w 856
    //   8074: astore 29
    //   8076: goto -7889 -> 187
    //   8079: iconst_1
    //   8080: istore 7
    //   8082: goto -7086 -> 996
    //   8085: iload_3
    //   8086: ifne -943 -> 7143
    //   8089: iconst_1
    //   8090: istore 15
    //   8092: goto -6349 -> 1743
    //   8095: astore_1
    //   8096: goto -5837 -> 2259
    //   8099: aload 34
    //   8101: astore 32
    //   8103: iload 8
    //   8105: bipush 12
    //   8107: if_icmple -3145 -> 4962
    //   8110: aload 34
    //   8112: astore 32
    //   8114: bipush 82
    //   8116: aload 44
    //   8118: iconst_0
    //   8119: baload
    //   8120: if_icmpne -3158 -> 4962
    //   8123: aload 34
    //   8125: astore 32
    //   8127: bipush 73
    //   8129: aload 44
    //   8131: iconst_1
    //   8132: baload
    //   8133: if_icmpne -3171 -> 4962
    //   8136: aload 34
    //   8138: astore 32
    //   8140: bipush 70
    //   8142: aload 44
    //   8144: iconst_2
    //   8145: baload
    //   8146: if_icmpne -3184 -> 4962
    //   8149: aload 34
    //   8151: astore 32
    //   8153: bipush 70
    //   8155: aload 44
    //   8157: iconst_3
    //   8158: baload
    //   8159: if_icmpne -3197 -> 4962
    //   8162: aload 34
    //   8164: astore 32
    //   8166: bipush 87
    //   8168: aload 44
    //   8170: bipush 8
    //   8172: baload
    //   8173: if_icmpne -3211 -> 4962
    //   8176: aload 34
    //   8178: astore 32
    //   8180: bipush 69
    //   8182: aload 44
    //   8184: bipush 9
    //   8186: baload
    //   8187: if_icmpne -3225 -> 4962
    //   8190: aload 34
    //   8192: astore 32
    //   8194: bipush 66
    //   8196: aload 44
    //   8198: bipush 10
    //   8200: baload
    //   8201: if_icmpne -3239 -> 4962
    //   8204: aload 34
    //   8206: astore 32
    //   8208: bipush 80
    //   8210: aload 44
    //   8212: bipush 11
    //   8214: baload
    //   8215: if_icmpne -3253 -> 4962
    //   8218: ldc_w 1054
    //   8221: astore 32
    //   8223: goto -3261 -> 4962
    //   8226: sipush 302
    //   8229: iload 8
    //   8231: if_icmpeq -1815 -> 6416
    //   8234: sipush 301
    //   8237: iload 8
    //   8239: if_icmpne -1733 -> 6506
    //   8242: goto -1826 -> 6416
    //   8245: astore 33
    //   8247: iconst_1
    //   8248: istore 14
    //   8250: iload 4
    //   8252: istore 5
    //   8254: lload 19
    //   8256: lstore 21
    //   8258: iload 6
    //   8260: istore 4
    //   8262: iload_3
    //   8263: istore 6
    //   8265: lload 17
    //   8267: lstore 19
    //   8269: lload 21
    //   8271: lstore 17
    //   8273: iload 7
    //   8275: istore_3
    //   8276: goto -7310 -> 966
    //   8279: astore_1
    //   8280: aload 32
    //   8282: astore 33
    //   8284: iload 7
    //   8286: istore 6
    //   8288: aload 30
    //   8290: astore 32
    //   8292: goto -6033 -> 2259
    //   8295: astore_0
    //   8296: iload 8
    //   8298: istore_3
    //   8299: goto -5704 -> 2595
    //   8302: ldc_w 1056
    //   8305: astore 33
    //   8307: goto -2302 -> 6005
    //   8310: astore_1
    //   8311: aload 32
    //   8313: astore 33
    //   8315: aload 30
    //   8317: astore 32
    //   8319: iload_3
    //   8320: istore 6
    //   8322: goto -6063 -> 2259
    //   8325: ldc_w 1056
    //   8328: astore 33
    //   8330: goto -6983 -> 1347
    //   8333: ldc_w 1056
    //   8336: astore_0
    //   8337: goto -5806 -> 2531
    //   8340: astore_0
    //   8341: iload 5
    //   8343: istore_3
    //   8344: goto -5749 -> 2595
    //   8347: iload_3
    //   8348: ifne -946 -> 7402
    //   8351: iconst_3
    //   8352: istore 4
    //   8354: goto -964 -> 7390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8357	0	parambihu	bihu
    //   0	8357	1	paramString	String
    //   0	8357	2	paramContext	Context
    //   16	8332	3	i	int
    //   63	8290	4	j	int
    //   70	8272	5	k	int
    //   612	7709	6	m	int
    //   606	7679	7	n	int
    //   307	7990	8	i1	int
    //   281	7704	9	i2	int
    //   298	5496	10	i3	int
    //   301	4788	11	i4	int
    //   609	7452	12	i5	int
    //   713	5744	13	i6	int
    //   284	7965	14	bool1	boolean
    //   1462	6629	15	bool2	boolean
    //   1762	3	16	bool3	boolean
    //   353	7919	17	l1	long
    //   615	7653	19	l2	long
    //   1420	6850	21	l3	long
    //   4341	1005	23	l4	long
    //   337	1684	25	l5	long
    //   636	5206	27	l6	long
    //   185	7238	29	localObject1	Object
    //   7502	18	29	localThrowable1	java.lang.Throwable
    //   7525	550	29	localObject2	Object
    //   203	7311	30	localObject3	Object
    //   7544	13	30	localThrowable2	java.lang.Throwable
    //   7566	750	30	localObject4	Object
    //   200	7614	31	localObject5	Object
    //   553	6579	32	localObject6	Object
    //   7414	1	32	localThrowable3	java.lang.Throwable
    //   7438	880	32	localObject7	Object
    //   386	4033	33	localObject8	Object
    //   4615	1	33	localThrowable4	java.lang.Throwable
    //   4763	1884	33	localObject9	Object
    //   6653	1	33	localInterruptedException	java.lang.InterruptedException
    //   6685	10	33	localObject10	Object
    //   6825	794	33	localObject11	Object
    //   7637	1	33	localThrowable5	java.lang.Throwable
    //   7679	45	33	localThrowable6	java.lang.Throwable
    //   7748	279	33	localObject12	Object
    //   8245	1	33	localThrowable7	java.lang.Throwable
    //   8282	47	33	localObject13	Object
    //   478	366	34	localObject14	Object
    //   927	36	34	localThrowable8	java.lang.Throwable
    //   1329	2879	34	localObject15	Object
    //   4221	22	34	localThrowable9	java.lang.Throwable
    //   4403	1637	34	localObject16	Object
    //   6088	30	34	localException	Exception
    //   6134	10	34	localThrowable10	java.lang.Throwable
    //   6153	21	34	localObject17	Object
    //   6231	17	34	localThrowable11	java.lang.Throwable
    //   6257	1663	34	localObject18	Object
    //   7929	17	34	localThrowable12	java.lang.Throwable
    //   7955	250	34	localObject19	Object
    //   717	2308	35	localObject20	Object
    //   3087	22	35	localThrowable13	java.lang.Throwable
    //   3131	2564	35	localObject21	Object
    //   6319	1102	35	localThrowable14	java.lang.Throwable
    //   7506	29	35	localObject22	Object
    //   7589	28	35	localThrowable15	java.lang.Throwable
    //   7721	26	35	localThrowable16	java.lang.Throwable
    //   7771	26	35	localThrowable17	java.lang.Throwable
    //   7825	26	35	localThrowable18	java.lang.Throwable
    //   7875	30	35	localThrowable19	java.lang.Throwable
    //   549	6025	36	localFile1	java.io.File
    //   366	7626	37	localHashMap	java.util.HashMap
    //   474	5483	38	localFile2	java.io.File
    //   599	6437	39	localasjz	asjz
    //   141	3723	40	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   350	6338	41	localObject23	Object
    //   704	5512	42	localStringBuilder	java.lang.StringBuilder
    //   494	1599	43	localFile3	java.io.File
    //   2185	6026	44	localObject24	Object
    //   3034	34	45	str1	String
    //   3048	31	46	str2	String
    // Exception table:
    //   from	to	target	type
    //   863	904	927	java/lang/Throwable
    //   916	927	927	java/lang/Throwable
    //   2226	2235	927	java/lang/Throwable
    //   2247	2258	927	java/lang/Throwable
    //   863	904	2258	finally
    //   916	927	2258	finally
    //   2226	2235	2258	finally
    //   2247	2258	2258	finally
    //   633	638	2591	java/lang/Throwable
    //   642	706	2591	java/lang/Throwable
    //   1520	1524	2591	java/lang/Throwable
    //   1532	1541	2591	java/lang/Throwable
    //   1544	1555	2591	java/lang/Throwable
    //   1558	1574	2591	java/lang/Throwable
    //   1577	1593	2591	java/lang/Throwable
    //   1596	1610	2591	java/lang/Throwable
    //   1613	1627	2591	java/lang/Throwable
    //   1630	1651	2591	java/lang/Throwable
    //   1654	1667	2591	java/lang/Throwable
    //   1670	1684	2591	java/lang/Throwable
    //   1687	1698	2591	java/lang/Throwable
    //   1705	1715	2591	java/lang/Throwable
    //   1718	1731	2591	java/lang/Throwable
    //   1734	1740	2591	java/lang/Throwable
    //   1746	1751	2591	java/lang/Throwable
    //   1758	1764	2591	java/lang/Throwable
    //   2263	2266	2591	java/lang/Throwable
    //   2270	2309	2591	java/lang/Throwable
    //   2313	2321	2591	java/lang/Throwable
    //   2330	2382	2591	java/lang/Throwable
    //   2391	2398	2591	java/lang/Throwable
    //   2402	2409	2591	java/lang/Throwable
    //   2413	2421	2591	java/lang/Throwable
    //   2425	2436	2591	java/lang/Throwable
    //   2440	2475	2591	java/lang/Throwable
    //   2479	2494	2591	java/lang/Throwable
    //   2498	2503	2591	java/lang/Throwable
    //   2507	2515	2591	java/lang/Throwable
    //   2519	2527	2591	java/lang/Throwable
    //   2535	2541	2591	java/lang/Throwable
    //   2545	2553	2591	java/lang/Throwable
    //   2561	2570	2591	java/lang/Throwable
    //   2574	2585	2591	java/lang/Throwable
    //   2589	2591	2591	java/lang/Throwable
    //   7014	7019	2591	java/lang/Throwable
    //   7028	7043	2591	java/lang/Throwable
    //   7050	7055	2591	java/lang/Throwable
    //   7152	7158	2591	java/lang/Throwable
    //   2978	2995	3087	java/lang/Throwable
    //   3000	3014	3087	java/lang/Throwable
    //   3014	3084	3087	java/lang/Throwable
    //   3172	3217	3087	java/lang/Throwable
    //   3217	3375	3087	java/lang/Throwable
    //   3380	3457	3087	java/lang/Throwable
    //   3457	3471	3087	java/lang/Throwable
    //   3476	3499	3087	java/lang/Throwable
    //   3506	3580	3087	java/lang/Throwable
    //   3580	3688	3087	java/lang/Throwable
    //   3688	3721	3087	java/lang/Throwable
    //   3721	3746	3087	java/lang/Throwable
    //   3756	3778	3087	java/lang/Throwable
    //   4259	4274	3087	java/lang/Throwable
    //   4277	4284	3087	java/lang/Throwable
    //   3908	3922	4221	java/lang/Throwable
    //   3926	3932	4221	java/lang/Throwable
    //   3936	3943	4221	java/lang/Throwable
    //   3947	3981	4221	java/lang/Throwable
    //   3985	3994	4221	java/lang/Throwable
    //   3998	4008	4221	java/lang/Throwable
    //   4012	4021	4221	java/lang/Throwable
    //   4025	4034	4221	java/lang/Throwable
    //   4038	4049	4221	java/lang/Throwable
    //   4053	4064	4221	java/lang/Throwable
    //   4068	4079	4221	java/lang/Throwable
    //   4083	4094	4221	java/lang/Throwable
    //   4098	4109	4221	java/lang/Throwable
    //   4113	4124	4221	java/lang/Throwable
    //   4128	4139	4221	java/lang/Throwable
    //   4143	4154	4221	java/lang/Throwable
    //   4158	4169	4221	java/lang/Throwable
    //   4173	4184	4221	java/lang/Throwable
    //   4188	4218	4221	java/lang/Throwable
    //   4325	4334	4221	java/lang/Throwable
    //   6383	6389	4221	java/lang/Throwable
    //   6420	6427	4221	java/lang/Throwable
    //   6437	6444	4221	java/lang/Throwable
    //   6473	6479	4221	java/lang/Throwable
    //   6518	6523	4221	java/lang/Throwable
    //   6561	6569	4221	java/lang/Throwable
    //   6573	6579	4221	java/lang/Throwable
    //   6583	6589	4221	java/lang/Throwable
    //   6620	6626	4221	java/lang/Throwable
    //   4576	4592	4615	java/lang/Throwable
    //   4604	4615	4615	java/lang/Throwable
    //   4745	4756	4615	java/lang/Throwable
    //   4576	4592	4756	finally
    //   4604	4615	4756	finally
    //   4745	4756	4756	finally
    //   5448	5561	6088	java/lang/Exception
    //   5362	5376	6134	java/lang/Throwable
    //   5376	5443	6134	java/lang/Throwable
    //   5448	5561	6134	java/lang/Throwable
    //   6090	6131	6134	java/lang/Throwable
    //   6215	6224	6231	java/lang/Throwable
    //   6298	6304	6319	java/lang/Throwable
    //   6308	6319	6319	java/lang/Throwable
    //   5666	5673	6653	java/lang/InterruptedException
    //   5666	5673	6685	finally
    //   5673	5676	6685	finally
    //   6655	6682	6685	finally
    //   6687	6690	6685	finally
    //   83	131	7408	java/lang/Throwable
    //   134	183	7408	java/lang/Throwable
    //   187	199	7408	java/lang/Throwable
    //   209	228	7408	java/lang/Throwable
    //   228	269	7408	java/lang/Throwable
    //   272	283	7408	java/lang/Throwable
    //   286	291	7408	java/lang/Throwable
    //   1769	1860	7414	java/lang/Throwable
    //   1865	1936	7414	java/lang/Throwable
    //   1945	1955	7414	java/lang/Throwable
    //   1959	1972	7414	java/lang/Throwable
    //   1977	2009	7414	java/lang/Throwable
    //   2009	2033	7414	java/lang/Throwable
    //   727	732	7419	finally
    //   752	760	7419	finally
    //   772	779	7419	finally
    //   801	807	7419	finally
    //   819	827	7419	finally
    //   845	851	7419	finally
    //   2138	2144	7419	finally
    //   2156	2170	7419	finally
    //   2182	2187	7419	finally
    //   2208	2214	7419	finally
    //   2663	2670	7419	finally
    //   2686	2697	7419	finally
    //   2709	2729	7419	finally
    //   2741	2749	7419	finally
    //   2761	2789	7419	finally
    //   2801	2808	7419	finally
    //   2820	2826	7419	finally
    //   2838	2865	7419	finally
    //   2877	2887	7419	finally
    //   2904	2911	7419	finally
    //   2923	2934	7419	finally
    //   2946	2951	7419	finally
    //   2965	2978	7419	finally
    //   3141	3169	7419	finally
    //   4334	4343	7427	finally
    //   4351	4365	7427	finally
    //   4373	4385	7427	finally
    //   4393	4405	7427	finally
    //   4418	4439	7427	finally
    //   4447	4454	7427	finally
    //   4462	4487	7427	finally
    //   4495	4502	7427	finally
    //   4517	4526	7427	finally
    //   4534	4544	7427	finally
    //   4558	4564	7427	finally
    //   4674	4687	7427	finally
    //   4713	4719	7427	finally
    //   4731	4737	7427	finally
    //   4786	4806	7427	finally
    //   4806	4858	7435	finally
    //   5113	5122	7435	finally
    //   4858	4867	7447	finally
    //   4871	4881	7463	finally
    //   4888	4895	7463	finally
    //   4899	4908	7463	finally
    //   4918	4924	7463	finally
    //   4971	4985	7463	finally
    //   4989	4999	7463	finally
    //   5033	5042	7463	finally
    //   5046	5056	7463	finally
    //   5060	5071	7463	finally
    //   5083	5093	7463	finally
    //   5097	5101	7463	finally
    //   5222	5227	7463	finally
    //   5231	5239	7463	finally
    //   5243	5250	7463	finally
    //   5254	5268	7463	finally
    //   5287	5294	7463	finally
    //   5305	5318	7463	finally
    //   5322	5345	7463	finally
    //   5357	5362	7463	finally
    //   6187	6193	7463	finally
    //   6205	6211	7463	finally
    //   6288	6294	7463	finally
    //   5362	5376	7475	finally
    //   5376	5443	7475	finally
    //   5448	5561	7475	finally
    //   6090	6131	7475	finally
    //   6215	6224	7490	finally
    //   6298	6304	7490	finally
    //   6308	6319	7490	finally
    //   727	732	7502	java/lang/Throwable
    //   752	760	7502	java/lang/Throwable
    //   772	779	7502	java/lang/Throwable
    //   801	807	7502	java/lang/Throwable
    //   819	827	7502	java/lang/Throwable
    //   845	851	7502	java/lang/Throwable
    //   2138	2144	7502	java/lang/Throwable
    //   2156	2170	7502	java/lang/Throwable
    //   2182	2187	7502	java/lang/Throwable
    //   2208	2214	7502	java/lang/Throwable
    //   2663	2670	7502	java/lang/Throwable
    //   2686	2697	7502	java/lang/Throwable
    //   2709	2729	7502	java/lang/Throwable
    //   2741	2749	7502	java/lang/Throwable
    //   2761	2789	7502	java/lang/Throwable
    //   2801	2808	7502	java/lang/Throwable
    //   2820	2826	7502	java/lang/Throwable
    //   2838	2865	7502	java/lang/Throwable
    //   2877	2887	7502	java/lang/Throwable
    //   2904	2911	7502	java/lang/Throwable
    //   2923	2934	7502	java/lang/Throwable
    //   2946	2951	7502	java/lang/Throwable
    //   2965	2978	7502	java/lang/Throwable
    //   3141	3169	7502	java/lang/Throwable
    //   3781	3816	7544	java/lang/Throwable
    //   3826	3848	7589	java/lang/Throwable
    //   3848	3875	7589	java/lang/Throwable
    //   3879	3904	7589	java/lang/Throwable
    //   4334	4343	7637	java/lang/Throwable
    //   4351	4365	7679	java/lang/Throwable
    //   4373	4385	7679	java/lang/Throwable
    //   4393	4405	7679	java/lang/Throwable
    //   4418	4439	7679	java/lang/Throwable
    //   4447	4454	7679	java/lang/Throwable
    //   4462	4487	7679	java/lang/Throwable
    //   4495	4502	7679	java/lang/Throwable
    //   4517	4526	7679	java/lang/Throwable
    //   4534	4544	7679	java/lang/Throwable
    //   4558	4564	7679	java/lang/Throwable
    //   4674	4687	7679	java/lang/Throwable
    //   4713	4719	7679	java/lang/Throwable
    //   4731	4737	7679	java/lang/Throwable
    //   4786	4806	7679	java/lang/Throwable
    //   4806	4858	7721	java/lang/Throwable
    //   5113	5122	7721	java/lang/Throwable
    //   4858	4867	7771	java/lang/Throwable
    //   4871	4881	7825	java/lang/Throwable
    //   4888	4895	7875	java/lang/Throwable
    //   4899	4908	7875	java/lang/Throwable
    //   4918	4924	7875	java/lang/Throwable
    //   4971	4985	7875	java/lang/Throwable
    //   4989	4999	7875	java/lang/Throwable
    //   5033	5042	7875	java/lang/Throwable
    //   5046	5056	7875	java/lang/Throwable
    //   5060	5071	7875	java/lang/Throwable
    //   5083	5093	7875	java/lang/Throwable
    //   5097	5101	7875	java/lang/Throwable
    //   5222	5227	7875	java/lang/Throwable
    //   5231	5239	7875	java/lang/Throwable
    //   5243	5250	7875	java/lang/Throwable
    //   5254	5268	7875	java/lang/Throwable
    //   5287	5294	7875	java/lang/Throwable
    //   5305	5318	7875	java/lang/Throwable
    //   5322	5345	7875	java/lang/Throwable
    //   5357	5362	7875	java/lang/Throwable
    //   6187	6193	7875	java/lang/Throwable
    //   6288	6294	7875	java/lang/Throwable
    //   6205	6211	7929	java/lang/Throwable
    //   2978	2995	8095	finally
    //   3000	3014	8095	finally
    //   3014	3084	8095	finally
    //   3172	3217	8095	finally
    //   3217	3375	8095	finally
    //   3380	3457	8095	finally
    //   3457	3471	8095	finally
    //   3476	3499	8095	finally
    //   3506	3580	8095	finally
    //   3580	3688	8095	finally
    //   3688	3721	8095	finally
    //   3721	3746	8095	finally
    //   3756	3778	8095	finally
    //   3781	3816	8095	finally
    //   3826	3848	8095	finally
    //   3848	3875	8095	finally
    //   3879	3904	8095	finally
    //   3908	3922	8095	finally
    //   3926	3932	8095	finally
    //   3936	3943	8095	finally
    //   3947	3981	8095	finally
    //   3985	3994	8095	finally
    //   3998	4008	8095	finally
    //   4012	4021	8095	finally
    //   4025	4034	8095	finally
    //   4038	4049	8095	finally
    //   4053	4064	8095	finally
    //   4068	4079	8095	finally
    //   4083	4094	8095	finally
    //   4098	4109	8095	finally
    //   4113	4124	8095	finally
    //   4128	4139	8095	finally
    //   4143	4154	8095	finally
    //   4158	4169	8095	finally
    //   4173	4184	8095	finally
    //   4188	4218	8095	finally
    //   4259	4274	8095	finally
    //   4277	4284	8095	finally
    //   4325	4334	8095	finally
    //   6383	6389	8095	finally
    //   6420	6427	8095	finally
    //   6437	6444	8095	finally
    //   6473	6479	8095	finally
    //   6518	6523	8095	finally
    //   6561	6569	8095	finally
    //   6573	6579	8095	finally
    //   6583	6589	8095	finally
    //   6620	6626	8095	finally
    //   5604	5610	8245	java/lang/Throwable
    //   5614	5624	8245	java/lang/Throwable
    //   5633	5640	8245	java/lang/Throwable
    //   5644	5653	8245	java/lang/Throwable
    //   5657	5660	8245	java/lang/Throwable
    //   5680	5690	8245	java/lang/Throwable
    //   5694	5706	8245	java/lang/Throwable
    //   5715	5731	8245	java/lang/Throwable
    //   6694	6697	8245	java/lang/Throwable
    //   6701	6711	8245	java/lang/Throwable
    //   6715	6722	8245	java/lang/Throwable
    //   6726	6742	8245	java/lang/Throwable
    //   6745	6800	8245	java/lang/Throwable
    //   6804	6815	8245	java/lang/Throwable
    //   5604	5610	8279	finally
    //   5614	5624	8279	finally
    //   5633	5640	8279	finally
    //   5644	5653	8279	finally
    //   5657	5660	8279	finally
    //   5680	5690	8279	finally
    //   5694	5706	8279	finally
    //   5715	5731	8279	finally
    //   6694	6697	8279	finally
    //   6701	6711	8279	finally
    //   6715	6722	8279	finally
    //   6726	6742	8279	finally
    //   6745	6800	8279	finally
    //   6804	6815	8279	finally
    //   313	327	8295	java/lang/Throwable
    //   334	339	8295	java/lang/Throwable
    //   343	352	8295	java/lang/Throwable
    //   359	368	8295	java/lang/Throwable
    //   372	388	8295	java/lang/Throwable
    //   392	398	8295	java/lang/Throwable
    //   402	410	8295	java/lang/Throwable
    //   419	429	8295	java/lang/Throwable
    //   433	445	8295	java/lang/Throwable
    //   449	456	8295	java/lang/Throwable
    //   460	476	8295	java/lang/Throwable
    //   489	496	8295	java/lang/Throwable
    //   500	507	8295	java/lang/Throwable
    //   511	551	8295	java/lang/Throwable
    //   559	569	8295	java/lang/Throwable
    //   573	584	8295	java/lang/Throwable
    //   588	601	8295	java/lang/Throwable
    //   1090	1093	8295	java/lang/Throwable
    //   1096	1135	8295	java/lang/Throwable
    //   1138	1146	8295	java/lang/Throwable
    //   1154	1206	8295	java/lang/Throwable
    //   1213	1220	8295	java/lang/Throwable
    //   1223	1230	8295	java/lang/Throwable
    //   1233	1241	8295	java/lang/Throwable
    //   1244	1255	8295	java/lang/Throwable
    //   1258	1293	8295	java/lang/Throwable
    //   1296	1311	8295	java/lang/Throwable
    //   1314	1319	8295	java/lang/Throwable
    //   1322	1331	8295	java/lang/Throwable
    //   1334	1342	8295	java/lang/Throwable
    //   1350	1359	8295	java/lang/Throwable
    //   1362	1370	8295	java/lang/Throwable
    //   1378	1390	8295	java/lang/Throwable
    //   1393	1404	8295	java/lang/Throwable
    //   1446	1455	8295	java/lang/Throwable
    //   1458	1464	8295	java/lang/Throwable
    //   2088	2123	8295	java/lang/Throwable
    //   5735	5738	8295	java/lang/Throwable
    //   5742	5781	8295	java/lang/Throwable
    //   5785	5793	8295	java/lang/Throwable
    //   5802	5854	8295	java/lang/Throwable
    //   5863	5870	8295	java/lang/Throwable
    //   5874	5881	8295	java/lang/Throwable
    //   5885	5893	8295	java/lang/Throwable
    //   5897	5908	8295	java/lang/Throwable
    //   5912	5947	8295	java/lang/Throwable
    //   5951	5966	8295	java/lang/Throwable
    //   5970	5975	8295	java/lang/Throwable
    //   5979	5988	8295	java/lang/Throwable
    //   5992	6000	8295	java/lang/Throwable
    //   6009	6018	8295	java/lang/Throwable
    //   6022	6030	8295	java/lang/Throwable
    //   6039	6051	8295	java/lang/Throwable
    //   6055	6066	8295	java/lang/Throwable
    //   6822	6827	8295	java/lang/Throwable
    //   6836	6851	8295	java/lang/Throwable
    //   6858	6863	8295	java/lang/Throwable
    //   6960	6965	8295	java/lang/Throwable
    //   6973	6988	8295	java/lang/Throwable
    //   6994	6999	8295	java/lang/Throwable
    //   7069	7075	8295	java/lang/Throwable
    //   7079	7085	8295	java/lang/Throwable
    //   7089	7098	8295	java/lang/Throwable
    //   7176	7189	8295	java/lang/Throwable
    //   7193	7199	8295	java/lang/Throwable
    //   7203	7248	8295	java/lang/Throwable
    //   7252	7258	8295	java/lang/Throwable
    //   969	985	8310	finally
    //   985	993	8310	finally
    //   996	1010	8310	finally
    //   1010	1019	8310	finally
    //   1034	1039	8310	finally
    //   1039	1087	8310	finally
    //   6874	6888	8310	finally
    //   6891	6907	8310	finally
    //   6907	6913	8310	finally
    //   6916	6930	8310	finally
    //   6933	6946	8310	finally
    //   6949	6954	8310	finally
    //   72	76	8340	java/lang/Throwable
    //   79	83	8340	java/lang/Throwable
    //   7263	7270	8340	java/lang/Throwable
    //   7273	7280	8340	java/lang/Throwable
    //   7286	7292	8340	java/lang/Throwable
    //   7295	7304	8340	java/lang/Throwable
    //   7313	7320	8340	java/lang/Throwable
    //   7323	7329	8340	java/lang/Throwable
    //   7332	7341	8340	java/lang/Throwable
    //   7344	7349	8340	java/lang/Throwable
    //   7352	7356	8340	java/lang/Throwable
    //   7359	7365	8340	java/lang/Throwable
    //   7368	7377	8340	java/lang/Throwable
    //   7380	7384	8340	java/lang/Throwable
    //   7393	7399	8340	java/lang/Throwable
  }
  
  public static int a(bihu parambihu, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((parambihu.k) && (!blem.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(parambihu, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(parambihu, null, null);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str2 = "http://[^/\\s]*/";
      String str1 = "http://" + paramString2 + "/";
      if (paramString1.startsWith("https"))
      {
        str2 = "https://[^/\\s]*/";
        str1 = "https://" + paramString2 + "/";
      }
      return paramString1.replaceFirst(str2, str1);
    }
    return null;
  }
  
  public static void a(asjz paramasjz)
  {
    if ((paramasjz == null) || (TextUtils.isEmpty(paramasjz.jdField_a_of_type_JavaLangString))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = InnerDns.getHostFromUrl(paramasjz.jdField_a_of_type_JavaLangString);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramasjz.jdField_a_of_type_JavaLangString.startsWith("http"))) {
          break;
        }
        str2 = InnerDns.getInstance().reqDns(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramasjz.jdField_a_of_type_JavaLangString, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramasjz.jdField_b_of_type_JavaLangString = str3;
        paramasjz.jdField_c_of_type_JavaLangString = str1;
        paramasjz.jdField_d_of_type_JavaLangString = str2;
        paramasjz.jdField_a_of_type_Boolean = true;
        return;
      }
      paramasjz.jdField_b_of_type_JavaLangString = paramasjz.jdField_a_of_type_JavaLangString;
      return;
      HttpDownloadUtil.a(paramasjz);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramasjz.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(bhnv.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      bdll.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  private static void a(HttpEntity paramHttpEntity, InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream, String paramString)
  {
    if (paramHttpEntity != null) {}
    try
    {
      paramHttpEntity.consumeContent();
      if (paramInputStream == null) {}
    }
    catch (Exception paramHttpEntity)
    {
      try
      {
        paramInputStream.close();
        if (paramBufferedOutputStream != null) {}
        try
        {
          paramBufferedOutputStream.close();
          return;
        }
        catch (Exception paramHttpEntity)
        {
          QLog.e("DownloaderFactory", 1, "doTask closeStream | download buffFileOS close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
        }
        paramHttpEntity = paramHttpEntity;
        QLog.e("DownloaderFactory", 1, "doTask closeStream | download close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
      }
      catch (Exception paramHttpEntity)
      {
        for (;;)
        {
          QLog.e("DownloaderFactory", 1, "doTask closeStream | download is close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = bhnv.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(bihu parambihu)
  {
    if (parambihu == null) {
      return false;
    }
    if ((parambihu.jdField_a_of_type_JavaUtilList == null) || (parambihu.jdField_a_of_type_JavaUtilMap == null) || (parambihu.jdField_a_of_type_JavaUtilList.size() < 1) || (parambihu.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(parambihu.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    parambihu = parambihu.jdField_a_of_type_JavaUtilList.iterator();
    while (parambihu.hasNext())
    {
      String str = (String)parambihu.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 8
    //   9: iload 8
    //   11: istore 6
    //   13: aload_0
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: invokevirtual 295	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 295	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1144	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 15
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: aload 15
    //   61: arraylength
    //   62: if_icmpge +358 -> 420
    //   65: aload 15
    //   67: iload_3
    //   68: aaload
    //   69: astore 16
    //   71: aload 16
    //   73: invokevirtual 298	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1144	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 17
    //   86: aload 17
    //   88: ifnull +535 -> 623
    //   91: aload 17
    //   93: arraylength
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: iload 5
    //   103: if_icmpge +21 -> 124
    //   106: aload 17
    //   108: iload 4
    //   110: aaload
    //   111: invokevirtual 301	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 301	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 301	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 75
    //   148: iconst_2
    //   149: new 124	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1146
    //   159: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 996	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1152	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1155	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 634	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1158	bjtz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1159
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1159
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1162	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1167	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1169
    //   251: invokespecial 1172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1175	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 1120	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1176	java/io/InputStreamReader:close	()V
    //   282: ldc 75
    //   284: iconst_2
    //   285: new 124	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1146
    //   295: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1178
    //   308: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1180
    //   319: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1182
    //   330: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1185	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 75
    //   361: iconst_2
    //   362: new 124	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1187
    //   372: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1189
    //   387: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 304	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 124	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1193	java/io/File:separatorChar	C
    //   438: invokevirtual 1196	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1200	nof:a	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 301	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 75
    //   464: iconst_2
    //   465: new 124	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1202
    //   475: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iconst_1
    //   492: istore_2
    //   493: goto -143 -> 350
    //   496: lload 11
    //   498: lstore 9
    //   500: goto -273 -> 227
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 15
    //   507: aconst_null
    //   508: astore_0
    //   509: aload 15
    //   511: ifnull +8 -> 519
    //   514: aload 15
    //   516: invokevirtual 1120	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1176	java/io/InputStreamReader:close	()V
    //   527: goto -245 -> 282
    //   530: astore_0
    //   531: goto -249 -> 282
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_0
    //   537: aload 16
    //   539: astore 15
    //   541: aload_0
    //   542: ifnull +7 -> 549
    //   545: aload_0
    //   546: invokevirtual 1120	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1176	java/io/InputStreamReader:close	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_0
    //   562: goto -290 -> 272
    //   565: astore_0
    //   566: goto -284 -> 282
    //   569: astore 15
    //   571: goto -52 -> 519
    //   574: astore_0
    //   575: goto -26 -> 549
    //   578: astore_0
    //   579: goto -20 -> 559
    //   582: astore_1
    //   583: aload 16
    //   585: astore 15
    //   587: goto -46 -> 541
    //   590: astore_1
    //   591: goto -50 -> 541
    //   594: astore 15
    //   596: aconst_null
    //   597: astore 16
    //   599: aload_0
    //   600: astore 15
    //   602: aload 16
    //   604: astore_0
    //   605: goto -96 -> 509
    //   608: astore 16
    //   610: aload_0
    //   611: astore 16
    //   613: aload 15
    //   615: astore_0
    //   616: aload 16
    //   618: astore 15
    //   620: goto -111 -> 509
    //   623: iload_3
    //   624: iconst_1
    //   625: iadd
    //   626: istore_3
    //   627: goto -569 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramFile1	java.io.File
    //   0	630	1	paramFile2	java.io.File
    //   0	630	2	paramBoolean	boolean
    //   57	570	3	i	int
    //   97	23	4	j	int
    //   94	10	5	k	int
    //   11	394	6	bool1	boolean
    //   4	344	7	bool2	boolean
    //   7	22	8	bool3	boolean
    //   225	274	9	l1	long
    //   199	298	11	l2	long
    //   41	338	13	l3	long
    //   54	80	15	arrayOfFile	java.io.File[]
    //   144	26	15	localException1	Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	java.io.File
    //   608	1	16	localException4	Exception
    //   611	6	16	localFile2	java.io.File
    //   84	239	17	localObject4	Object
    //   232	102	18	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   43	56	144	java/lang/Exception
    //   58	65	144	java/lang/Exception
    //   71	86	144	java/lang/Exception
    //   91	96	144	java/lang/Exception
    //   106	115	144	java/lang/Exception
    //   124	130	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   415	420	144	java/lang/Exception
    //   420	447	144	java/lang/Exception
    //   451	456	144	java/lang/Exception
    //   456	491	144	java/lang/Exception
    //   17	23	409	finally
    //   38	43	409	finally
    //   43	56	409	finally
    //   58	65	409	finally
    //   71	86	409	finally
    //   91	96	409	finally
    //   106	115	409	finally
    //   124	130	409	finally
    //   133	141	409	finally
    //   146	183	409	finally
    //   186	210	409	finally
    //   227	234	409	finally
    //   268	272	409	finally
    //   277	282	409	finally
    //   282	347	409	finally
    //   353	403	409	finally
    //   415	420	409	finally
    //   420	447	409	finally
    //   451	456	409	finally
    //   456	491	409	finally
    //   514	519	409	finally
    //   523	527	409	finally
    //   545	549	409	finally
    //   554	559	409	finally
    //   559	561	409	finally
    //   234	243	503	java/lang/Exception
    //   523	527	530	java/lang/Exception
    //   234	243	534	finally
    //   268	272	561	java/lang/Exception
    //   277	282	565	java/lang/Exception
    //   514	519	569	java/lang/Exception
    //   545	549	574	java/lang/Exception
    //   554	559	578	java/lang/Exception
    //   243	256	582	finally
    //   256	264	590	finally
    //   243	256	594	java/lang/Exception
    //   256	264	608	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        b.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.indexOf('?') > -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public bihz a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +324 -> 329
    //   8: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+29 -> 44, 1:+33->48, 2:+107->122, 3:+176->191, 4:+245->260
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: iload_1
    //   52: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokevirtual 1203	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   58: ifeq +20 -> 78
    //   61: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   64: iload_1
    //   65: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 1204	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 1210	bihz
    //   74: astore_2
    //   75: goto -31 -> 44
    //   78: new 1212	bihy
    //   81: dup
    //   82: iconst_0
    //   83: invokespecial 1215	bihy:<init>	(Z)V
    //   86: astore_2
    //   87: new 1217	biil
    //   90: dup
    //   91: invokestatic 1220	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   94: invokevirtual 1224	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   97: aload_2
    //   98: invokespecial 1227	biil:<init>	(Lmqq/app/AppRuntime;Lbihy;)V
    //   101: astore_2
    //   102: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   105: iload_1
    //   106: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aload_2
    //   110: invokevirtual 1009	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: goto -70 -> 44
    //   117: astore_2
    //   118: aload_3
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   125: iload_1
    //   126: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokevirtual 1203	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   132: ifeq +20 -> 152
    //   135: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: iload_1
    //   139: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 1204	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 1210	bihz
    //   148: astore_2
    //   149: goto -105 -> 44
    //   152: new 1212	bihy
    //   155: dup
    //   156: iconst_0
    //   157: invokespecial 1215	bihy:<init>	(Z)V
    //   160: astore_2
    //   161: new 1217	biil
    //   164: dup
    //   165: invokestatic 1220	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: invokevirtual 1224	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   171: aload_2
    //   172: invokespecial 1227	biil:<init>	(Lmqq/app/AppRuntime;Lbihy;)V
    //   175: astore_2
    //   176: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   179: iload_1
    //   180: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aload_2
    //   184: invokevirtual 1009	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: goto -144 -> 44
    //   191: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: iload_1
    //   195: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 1203	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   201: ifeq +20 -> 221
    //   204: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   207: iload_1
    //   208: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 1204	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 1210	bihz
    //   217: astore_2
    //   218: goto -174 -> 44
    //   221: new 1212	bihy
    //   224: dup
    //   225: iconst_0
    //   226: invokespecial 1215	bihy:<init>	(Z)V
    //   229: astore_2
    //   230: new 1229	amtw
    //   233: dup
    //   234: invokestatic 1220	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   237: invokevirtual 1224	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   240: aload_2
    //   241: invokespecial 1230	amtw:<init>	(Lmqq/app/AppRuntime;Lbihy;)V
    //   244: astore_2
    //   245: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   248: iload_1
    //   249: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aload_2
    //   253: invokevirtual 1009	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: goto -213 -> 44
    //   260: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   263: iload_1
    //   264: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 1203	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   270: ifeq +20 -> 290
    //   273: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   276: iload_1
    //   277: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: invokevirtual 1204	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: checkcast 1210	bihz
    //   286: astore_2
    //   287: goto -243 -> 44
    //   290: new 1212	bihy
    //   293: dup
    //   294: iconst_0
    //   295: invokespecial 1215	bihy:<init>	(Z)V
    //   298: astore_2
    //   299: new 1229	amtw
    //   302: dup
    //   303: invokestatic 1220	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: invokevirtual 1224	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   309: aload_2
    //   310: invokespecial 1230	amtw:<init>	(Lmqq/app/AppRuntime;Lbihy;)V
    //   313: astore_2
    //   314: getstatic 44	bihw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   317: iload_1
    //   318: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aload_2
    //   322: invokevirtual 1009	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: goto -282 -> 44
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	bihw
    //   0	331	1	paramInt	int
    //   1	109	2	localObject1	Object
    //   117	4	2	localObject2	Object
    //   148	174	2	localObject3	Object
    //   11	108	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   44	46	117	finally
    //   48	75	117	finally
    //   78	114	117	finally
    //   118	120	117	finally
    //   122	149	117	finally
    //   152	188	117	finally
    //   191	218	117	finally
    //   221	257	117	finally
    //   260	287	117	finally
    //   290	326	117	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloaderFactory", 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((bihz)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihw
 * JD-Core Version:    0.7.0.1
 */