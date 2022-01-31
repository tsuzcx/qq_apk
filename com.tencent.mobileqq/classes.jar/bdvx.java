import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vip.DownloaderFactory.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bdvx
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, bdwa> a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public bdvx(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(bdvv parambdvv, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 77
    //   8: iconst_2
    //   9: ldc 79
    //   11: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore_3
    //   17: aload_0
    //   18: invokevirtual 88	bdvv:a	()Lbdvu;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 90	bdvy
    //   28: dup
    //   29: invokespecial 91	bdvy:<init>	()V
    //   32: invokevirtual 94	bdvv:a	(Lbdvu;)V
    //   35: aload_1
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 97	bdvv:jdField_a_of_type_Bdvw	Lbdvw;
    //   43: getfield 102	bdvw:a	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifge +14 -> 62
    //   51: aload_0
    //   52: getfield 97	bdvv:jdField_a_of_type_Bdvw	Lbdvw;
    //   55: aload_1
    //   56: invokestatic 108	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: putfield 102	bdvw:a	J
    //   62: iload_3
    //   63: istore 4
    //   65: aload_0
    //   66: ifnull +2576 -> 2642
    //   69: iload_3
    //   70: istore 5
    //   72: aload_0
    //   73: invokestatic 113	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lbdvv;)V
    //   76: iload_3
    //   77: istore 5
    //   79: aload_0
    //   80: invokestatic 115	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lbdvv;)V
    //   83: aload_0
    //   84: invokevirtual 118	bdvv:c	()Z
    //   87: ifne +47 -> 134
    //   90: aload_0
    //   91: bipush 147
    //   93: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: invokevirtual 124	bdvv:e	()V
    //   100: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +8197 -> 8300
    //   106: ldc 77
    //   108: iconst_2
    //   109: new 126	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   116: ldc 129
    //   118: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto +8169 -> 8300
    //   134: new 142	org/apache/http/params/BasicHttpParams
    //   137: dup
    //   138: invokespecial 143	org/apache/http/params/BasicHttpParams:<init>	()V
    //   141: astore 40
    //   143: aload 40
    //   145: ldc 145
    //   147: sipush 10000
    //   150: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokeinterface 157 3 0
    //   158: pop
    //   159: aload 40
    //   161: ldc 159
    //   163: aload_0
    //   164: getfield 161	bdvv:jdField_e_of_type_Int	I
    //   167: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 157 3 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 164	bdvv:n	Z
    //   180: ifeq +8126 -> 8306
    //   183: ldc 166
    //   185: astore 29
    //   187: aload 40
    //   189: ldc 168
    //   191: aload 29
    //   193: invokeinterface 157 3 0
    //   198: pop
    //   199: aconst_null
    //   200: astore 31
    //   202: aconst_null
    //   203: astore 30
    //   205: sipush 2048
    //   208: istore_3
    //   209: aload_0
    //   210: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   213: ifnull +15 -> 228
    //   216: aload_0
    //   217: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   220: invokeinterface 177 1 0
    //   225: ifgt +47 -> 272
    //   228: aload_0
    //   229: bipush 149
    //   231: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   234: aload_0
    //   235: invokevirtual 124	bdvv:e	()V
    //   238: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +8063 -> 8304
    //   244: ldc 77
    //   246: iconst_2
    //   247: new 126	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   254: ldc 179
    //   256: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto +8035 -> 8304
    //   272: aload_0
    //   273: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   276: invokeinterface 177 1 0
    //   281: istore 9
    //   283: iconst_0
    //   284: istore 14
    //   286: getstatic 184	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   289: istore 4
    //   291: iconst_1
    //   292: iload 4
    //   294: if_icmpne +1796 -> 2090
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
    //   316: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   319: invokeinterface 177 1 0
    //   324: if_icmpge +7078 -> 7402
    //   327: iconst_m1
    //   328: istore 4
    //   330: iload 4
    //   332: istore 8
    //   334: invokestatic 190	java/lang/System:currentTimeMillis	()J
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
    //   359: new 192	java/util/HashMap
    //   362: dup
    //   363: invokespecial 193	java/util/HashMap:<init>	()V
    //   366: astore 37
    //   368: iload 4
    //   370: istore 8
    //   372: aload_0
    //   373: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   376: iload 11
    //   378: invokeinterface 197 2 0
    //   383: checkcast 199	java/lang/String
    //   386: astore 33
    //   388: iload 4
    //   390: istore 8
    //   392: aload_0
    //   393: aload 33
    //   395: putfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   398: iload 4
    //   400: istore 8
    //   402: aload_0
    //   403: getfield 205	bdvv:jdField_g_of_type_Int	I
    //   406: iconst_3
    //   407: if_icmpne +49 -> 456
    //   410: iload 10
    //   412: ifeq +44 -> 456
    //   415: iload 4
    //   417: istore 8
    //   419: bipush 30
    //   421: aconst_null
    //   422: aload_0
    //   423: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   426: invokestatic 210	alda:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   429: iload 4
    //   431: istore 8
    //   433: bipush 30
    //   435: aload_0
    //   436: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   439: sipush 300
    //   442: invokestatic 213	alda:a	(ILjava/lang/String;I)V
    //   445: iload 4
    //   447: istore 8
    //   449: aload_0
    //   450: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokestatic 216	com/tencent/mobileqq/apollo/utils/ApolloUtil:d	(Ljava/lang/String;)V
    //   456: iload 4
    //   458: istore 8
    //   460: aload_0
    //   461: getfield 217	bdvv:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   464: aload 33
    //   466: invokeinterface 222 2 0
    //   471: checkcast 224	java/io/File
    //   474: astore 38
    //   476: ldc 226
    //   478: astore 34
    //   480: aload 38
    //   482: ifnull +6818 -> 7300
    //   485: iload 4
    //   487: istore 8
    //   489: aload 38
    //   491: invokevirtual 230	java/io/File:getParentFile	()Ljava/io/File;
    //   494: astore 42
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 233	bdvv:h	Z
    //   504: ifeq +1592 -> 2096
    //   507: iload 4
    //   509: istore 8
    //   511: new 224	java/io/File
    //   514: dup
    //   515: aload 42
    //   517: new 126	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   524: aload 38
    //   526: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   529: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 238
    //   534: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokestatic 241	java/lang/System:nanoTime	()J
    //   540: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   543: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   549: astore 36
    //   551: aload 33
    //   553: astore 32
    //   555: iload 4
    //   557: istore 8
    //   559: aload_0
    //   560: getfield 249	bdvv:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   563: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +18 -> 584
    //   569: iload 4
    //   571: istore 8
    //   573: aload_0
    //   574: getfield 249	bdvv:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   577: aload 33
    //   579: invokestatic 261	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   582: astore 32
    //   584: iload 4
    //   586: istore 8
    //   588: new 263	apnb
    //   591: dup
    //   592: aload 32
    //   594: aconst_null
    //   595: iconst_0
    //   596: invokespecial 266	apnb:<init>	(Ljava/lang/String;Ljava/io/File;I)V
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
    //   633: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   636: lstore 27
    //   638: iload 6
    //   640: istore 4
    //   642: new 126	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 268
    //   649: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: ldc_w 272
    //   655: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 164	bdvv:n	Z
    //   662: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 277
    //   668: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_0
    //   672: getfield 280	bdvv:p	Z
    //   675: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: ldc_w 282
    //   681: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: getfield 284	bdvv:jdField_b_of_type_Int	I
    //   688: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: astore 43
    //   693: iconst_0
    //   694: istore 8
    //   696: iconst_0
    //   697: istore 5
    //   699: iconst_0
    //   700: istore 13
    //   702: aload 29
    //   704: astore 35
    //   706: aload 29
    //   708: astore 34
    //   710: iload 5
    //   712: istore 4
    //   714: aload 39
    //   716: invokevirtual 289	apnb:a	()V
    //   719: iconst_1
    //   720: istore 14
    //   722: aload 42
    //   724: ifnull +23 -> 747
    //   727: aload 29
    //   729: astore 35
    //   731: aload 29
    //   733: astore 34
    //   735: iload 5
    //   737: istore 4
    //   739: aload 42
    //   741: invokevirtual 292	java/io/File:exists	()Z
    //   744: ifeq +27 -> 771
    //   747: aload 29
    //   749: astore 35
    //   751: aload 29
    //   753: astore 34
    //   755: iload 5
    //   757: istore 4
    //   759: aload 42
    //   761: invokevirtual 295	java/io/File:isDirectory	()Z
    //   764: istore 14
    //   766: iload 14
    //   768: ifne +1370 -> 2138
    //   771: iload 14
    //   773: ifne +21 -> 794
    //   776: aload 29
    //   778: astore 35
    //   780: aload 29
    //   782: astore 34
    //   784: iload 5
    //   786: istore 4
    //   788: aload 42
    //   790: invokevirtual 298	java/io/File:delete	()Z
    //   793: pop
    //   794: aload 29
    //   796: astore 35
    //   798: aload 29
    //   800: astore 34
    //   802: iload 5
    //   804: istore 4
    //   806: aload 42
    //   808: invokevirtual 301	java/io/File:mkdirs	()Z
    //   811: ifne +1327 -> 2138
    //   814: iconst_1
    //   815: istore 4
    //   817: iconst_1
    //   818: istore 13
    //   820: bipush 153
    //   822: istore 8
    //   824: aload 29
    //   826: astore 35
    //   828: aload 29
    //   830: astore 34
    //   832: aload_0
    //   833: bipush 153
    //   835: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   838: iload 13
    //   840: istore 5
    //   842: iload 8
    //   844: istore 4
    //   846: iload 8
    //   848: istore 6
    //   850: aload 43
    //   852: ldc_w 303
    //   855: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload 42
    //   860: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   863: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc_w 308
    //   869: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokestatic 312	bdal:a	()Z
    //   875: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: ldc_w 314
    //   881: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokestatic 316	bdal:b	()J
    //   887: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: iload 13
    //   893: istore 5
    //   895: iload 8
    //   897: istore 4
    //   899: iload 8
    //   901: istore 6
    //   903: new 67	java/lang/Exception
    //   906: dup
    //   907: ldc_w 318
    //   910: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   913: athrow
    //   914: astore 34
    //   916: iload_3
    //   917: istore 6
    //   919: iconst_0
    //   920: istore 14
    //   922: iload 5
    //   924: istore 8
    //   926: iload 4
    //   928: istore_3
    //   929: aload 32
    //   931: astore 30
    //   933: aload 33
    //   935: astore 32
    //   937: iload 6
    //   939: istore 5
    //   941: iload 8
    //   943: istore 4
    //   945: iload 7
    //   947: istore 6
    //   949: aload 34
    //   951: astore 33
    //   953: iconst_0
    //   954: istore 7
    //   956: aload 33
    //   958: instanceof 321
    //   961: ifne +7353 -> 8314
    //   964: aload 33
    //   966: instanceof 323
    //   969: ifne +7345 -> 8314
    //   972: aload 33
    //   974: instanceof 325
    //   977: ifeq +6 -> 983
    //   980: goto +7334 -> 8314
    //   983: aload 33
    //   985: instanceof 65
    //   988: ifeq +6007 -> 6995
    //   991: aload_0
    //   992: bipush 145
    //   994: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   997: aload_0
    //   998: aload 33
    //   1000: invokevirtual 328	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1003: putfield 330	bdvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1006: iload 14
    //   1008: ifne +18 -> 1026
    //   1011: iload 7
    //   1013: ifeq +13 -> 1026
    //   1016: iload 6
    //   1018: ifeq +6052 -> 7070
    //   1021: aload_0
    //   1022: iconst_1
    //   1023: putfield 333	bdvv:jdField_f_of_type_Boolean	Z
    //   1026: aload 43
    //   1028: ldc_w 335
    //   1031: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokestatic 338	bdcs:a	()Z
    //   1037: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1040: ldc_w 340
    //   1043: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokestatic 343	bdcs:c	()F
    //   1049: ldc_w 344
    //   1052: fdiv
    //   1053: invokevirtual 347	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 43
    //   1059: ldc_w 349
    //   1062: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload 33
    //   1067: invokevirtual 328	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1070: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: iload_3
    //   1075: istore 8
    //   1077: ldc 77
    //   1079: iconst_1
    //   1080: new 126	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1087: aload 43
    //   1089: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: ldc_w 351
    //   1098: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1104: lload 27
    //   1106: lsub
    //   1107: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: iload_3
    //   1117: istore 8
    //   1119: aload_0
    //   1120: getfield 205	bdvv:jdField_g_of_type_Int	I
    //   1123: iconst_3
    //   1124: if_icmpne +63 -> 1187
    //   1127: iload 10
    //   1129: ifeq +58 -> 1187
    //   1132: iload_3
    //   1133: istore 8
    //   1135: bipush 30
    //   1137: aload_0
    //   1138: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1141: sipush 300
    //   1144: iconst_1
    //   1145: anewarray 4	java/lang/Object
    //   1148: dup
    //   1149: iconst_0
    //   1150: new 126	java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1157: aload 43
    //   1159: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: ldc_w 351
    //   1168: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1174: lload 27
    //   1176: lsub
    //   1177: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1180: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: aastore
    //   1184: invokestatic 357	alda:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1187: iload_3
    //   1188: ifeq +112 -> 1300
    //   1191: iload_3
    //   1192: istore 8
    //   1194: aload_0
    //   1195: invokevirtual 359	bdvv:b	()Z
    //   1198: ifne +102 -> 1300
    //   1201: iload_3
    //   1202: istore 8
    //   1204: aload_0
    //   1205: getfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   1208: ifeq +92 -> 1300
    //   1211: iload_3
    //   1212: istore 8
    //   1214: aload 39
    //   1216: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   1219: ifeq +5893 -> 7112
    //   1222: iload_3
    //   1223: istore 8
    //   1225: aload 39
    //   1227: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1230: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1233: ifne +5845 -> 7078
    //   1236: iload_3
    //   1237: istore 8
    //   1239: invokestatic 369	bavf:a	()Lbavf;
    //   1242: aload 39
    //   1244: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1247: aload 39
    //   1249: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1252: getstatic 34	bdvx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1255: aload 39
    //   1257: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1260: invokeinterface 222 2 0
    //   1265: checkcast 147	java/lang/Integer
    //   1268: invokevirtual 373	java/lang/Integer:intValue	()I
    //   1271: invokevirtual 376	bavf:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1274: iload_3
    //   1275: istore 8
    //   1277: aload 39
    //   1279: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1282: aload 38
    //   1284: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   1287: iconst_m1
    //   1288: aload_2
    //   1289: invokestatic 380	bdvx:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   1292: iload_3
    //   1293: istore 8
    //   1295: aload_0
    //   1296: iconst_0
    //   1297: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   1300: iload_3
    //   1301: istore 8
    //   1303: new 126	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1310: astore 34
    //   1312: iload_3
    //   1313: istore 8
    //   1315: aload 39
    //   1317: getfield 384	apnb:jdField_b_of_type_Boolean	Z
    //   1320: ifeq +7248 -> 8568
    //   1323: ldc_w 386
    //   1326: astore 33
    //   1328: iload_3
    //   1329: istore 8
    //   1331: aload 34
    //   1333: aload 33
    //   1335: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: astore 34
    //   1340: iload_3
    //   1341: istore 8
    //   1343: aload 39
    //   1345: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   1348: ifeq +7228 -> 8576
    //   1351: ldc_w 388
    //   1354: astore 33
    //   1356: iload_3
    //   1357: istore 8
    //   1359: aload 34
    //   1361: aload 33
    //   1363: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: astore 33
    //   1371: iload 12
    //   1373: iconst_1
    //   1374: iadd
    //   1375: istore 7
    //   1377: aload 32
    //   1379: ifnull +13 -> 1392
    //   1382: iload_3
    //   1383: istore 8
    //   1385: aload 32
    //   1387: invokeinterface 393 1 0
    //   1392: aload 31
    //   1394: ifnull +11 -> 1405
    //   1397: iload_3
    //   1398: istore 8
    //   1400: aload 31
    //   1402: invokevirtual 398	java/io/InputStream:close	()V
    //   1405: aload 30
    //   1407: ifnull +11 -> 1418
    //   1410: iload_3
    //   1411: istore 8
    //   1413: aload 30
    //   1415: invokevirtual 401	java/io/BufferedOutputStream:close	()V
    //   1418: iload 7
    //   1420: istore 8
    //   1422: lload 19
    //   1424: lstore 21
    //   1426: iload 4
    //   1428: istore 7
    //   1430: iload 5
    //   1432: istore 4
    //   1434: lload 17
    //   1436: lstore 19
    //   1438: lload 21
    //   1440: lstore 17
    //   1442: iload 8
    //   1444: istore 5
    //   1446: iload_3
    //   1447: ifeq +34 -> 1481
    //   1450: iload 7
    //   1452: ifne +29 -> 1481
    //   1455: iload_3
    //   1456: istore 8
    //   1458: iload 5
    //   1460: aload_0
    //   1461: getfield 284	bdvv:jdField_b_of_type_Int	I
    //   1464: if_icmpge +17 -> 1481
    //   1467: iload_3
    //   1468: istore 8
    //   1470: aload_0
    //   1471: invokevirtual 359	bdvv:b	()Z
    //   1474: istore 15
    //   1476: iload 15
    //   1478: ifeq +6781 -> 8259
    //   1481: aload 30
    //   1483: astore 34
    //   1485: lload 19
    //   1487: lstore 21
    //   1489: aload 32
    //   1491: astore 30
    //   1493: aload 31
    //   1495: astore 35
    //   1497: lload 17
    //   1499: lstore 19
    //   1501: lload 21
    //   1503: lstore 17
    //   1505: aload 29
    //   1507: astore 32
    //   1509: iload 5
    //   1511: istore 6
    //   1513: aload 30
    //   1515: astore 31
    //   1517: aload 35
    //   1519: astore 30
    //   1521: aload 34
    //   1523: astore 29
    //   1525: iload 4
    //   1527: istore 5
    //   1529: iload_3
    //   1530: istore 4
    //   1532: aload_0
    //   1533: invokevirtual 403	bdvv:d	()V
    //   1536: aload 37
    //   1538: ifnonnull +6688 -> 8226
    //   1541: iload_3
    //   1542: istore 4
    //   1544: new 192	java/util/HashMap
    //   1547: dup
    //   1548: invokespecial 193	java/util/HashMap:<init>	()V
    //   1551: astore 34
    //   1553: iload_3
    //   1554: istore 4
    //   1556: aload 34
    //   1558: ldc_w 405
    //   1561: aload 32
    //   1563: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1566: pop
    //   1567: iload_3
    //   1568: istore 4
    //   1570: aload 34
    //   1572: ldc_w 411
    //   1575: aload_0
    //   1576: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   1579: invokestatic 414	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1582: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1585: pop
    //   1586: iload_3
    //   1587: istore 4
    //   1589: aload 34
    //   1591: ldc_w 416
    //   1594: aload_0
    //   1595: getfield 418	bdvv:jdField_f_of_type_Int	I
    //   1598: invokestatic 414	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1601: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1604: pop
    //   1605: iload_3
    //   1606: istore 4
    //   1608: aload 34
    //   1610: ldc_w 420
    //   1613: iload 6
    //   1615: invokestatic 414	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1618: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1621: pop
    //   1622: iload_3
    //   1623: istore 4
    //   1625: aload 34
    //   1627: ldc_w 422
    //   1630: lload 17
    //   1632: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1635: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1638: pop
    //   1639: iload_3
    //   1640: istore 4
    //   1642: aload 34
    //   1644: ldc_w 427
    //   1647: aload_0
    //   1648: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1651: invokeinterface 177 1 0
    //   1656: invokestatic 414	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1659: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1662: pop
    //   1663: iload_3
    //   1664: istore 4
    //   1666: aload 34
    //   1668: ldc_w 429
    //   1671: aload_0
    //   1672: getfield 431	bdvv:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1675: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1678: pop
    //   1679: iload_3
    //   1680: istore 4
    //   1682: aload 34
    //   1684: ldc_w 433
    //   1687: iload 14
    //   1689: invokestatic 438	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1692: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1695: pop
    //   1696: iload_3
    //   1697: istore 4
    //   1699: aload 34
    //   1701: ldc_w 440
    //   1704: aload 33
    //   1706: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1709: pop
    //   1710: ldc 226
    //   1712: astore 35
    //   1714: iload_3
    //   1715: istore 4
    //   1717: aload_0
    //   1718: getfield 330	bdvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1721: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1724: ifne +6596 -> 8320
    //   1727: iload_3
    //   1728: istore 4
    //   1730: aload 34
    //   1732: ldc_w 442
    //   1735: aload_0
    //   1736: getfield 330	bdvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1739: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1742: pop
    //   1743: iload_3
    //   1744: istore 4
    //   1746: aload_0
    //   1747: getfield 330	bdvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1750: astore 35
    //   1752: goto +6568 -> 8320
    //   1755: iload_3
    //   1756: istore 4
    //   1758: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1761: lstore 21
    //   1763: aload_2
    //   1764: ifnull +281 -> 2045
    //   1767: iload_3
    //   1768: istore 4
    //   1770: aload_1
    //   1771: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1774: istore 16
    //   1776: iload 16
    //   1778: ifne +267 -> 2045
    //   1781: ldc_w 444
    //   1784: aload 32
    //   1786: new 126	java/lang/StringBuilder
    //   1789: dup
    //   1790: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1793: aload_0
    //   1794: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   1797: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1800: ldc 226
    //   1802: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1808: new 126	java/lang/StringBuilder
    //   1811: dup
    //   1812: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1815: lload 17
    //   1817: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1820: ldc 226
    //   1822: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1828: aload_0
    //   1829: getfield 431	bdvv:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1832: new 126	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1839: iload 14
    //   1841: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1844: ldc 226
    //   1846: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1852: aload 35
    //   1854: aload 33
    //   1856: ldc 226
    //   1858: ldc_w 446
    //   1861: invokestatic 451	bdqr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1864: aload_0
    //   1865: getfield 205	bdvv:jdField_g_of_type_Int	I
    //   1868: iconst_3
    //   1869: if_icmpne +79 -> 1948
    //   1872: iload 10
    //   1874: ifeq +74 -> 1948
    //   1877: bipush 30
    //   1879: aload_0
    //   1880: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1883: sipush 300
    //   1886: aload_0
    //   1887: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   1890: invokestatic 454	com/tencent/mobileqq/apollo/utils/ApolloUtil:f	(I)I
    //   1893: iconst_4
    //   1894: anewarray 4	java/lang/Object
    //   1897: dup
    //   1898: iconst_0
    //   1899: ldc_w 456
    //   1902: aastore
    //   1903: dup
    //   1904: iconst_1
    //   1905: aload_0
    //   1906: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   1909: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1912: aastore
    //   1913: dup
    //   1914: iconst_2
    //   1915: ldc_w 458
    //   1918: aastore
    //   1919: dup
    //   1920: iconst_3
    //   1921: aload_0
    //   1922: getfield 418	bdvv:jdField_f_of_type_Int	I
    //   1925: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1928: aastore
    //   1929: invokestatic 461	alda:a	(ILjava/lang/String;II[Ljava/lang/Object;)V
    //   1932: aload_0
    //   1933: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   1936: ifne +12 -> 1948
    //   1939: bipush 30
    //   1941: aload_0
    //   1942: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1945: invokestatic 464	alda:b	(ILjava/lang/String;)V
    //   1948: ldc_w 466
    //   1951: astore 33
    //   1953: aload 33
    //   1955: astore 32
    //   1957: aload_0
    //   1958: getfield 431	bdvv:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1961: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1964: ifne +57 -> 2021
    //   1967: aload 33
    //   1969: astore 32
    //   1971: aload_0
    //   1972: getfield 431	bdvv:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1975: ldc_w 468
    //   1978: invokevirtual 471	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1981: ifeq +40 -> 2021
    //   1984: ldc_w 473
    //   1987: astore 32
    //   1989: aload 34
    //   1991: ldc_w 475
    //   1994: aload_0
    //   1995: getfield 478	bdvv:r	Z
    //   1998: invokestatic 480	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2001: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2004: pop
    //   2005: aload 34
    //   2007: ldc_w 482
    //   2010: aload_0
    //   2011: getfield 485	bdvv:q	Z
    //   2014: invokestatic 480	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2017: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2020: pop
    //   2021: aload_2
    //   2022: invokestatic 490	azmz:a	(Landroid/content/Context;)Lazmz;
    //   2025: aload_1
    //   2026: aload 32
    //   2028: iload 15
    //   2030: lload 21
    //   2032: lload 25
    //   2034: lsub
    //   2035: lload 19
    //   2037: aload 34
    //   2039: ldc 226
    //   2041: iconst_0
    //   2042: invokevirtual 493	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2045: iload_3
    //   2046: ifne +5338 -> 7384
    //   2049: iload 9
    //   2051: iconst_1
    //   2052: isub
    //   2053: istore 4
    //   2055: iload 11
    //   2057: iconst_1
    //   2058: iadd
    //   2059: istore 11
    //   2061: aload 31
    //   2063: astore 32
    //   2065: iload_3
    //   2066: istore 8
    //   2068: aload 30
    //   2070: astore 31
    //   2072: iload 5
    //   2074: istore_3
    //   2075: aload 29
    //   2077: astore 30
    //   2079: aload 32
    //   2081: astore 29
    //   2083: iload 4
    //   2085: istore 9
    //   2087: goto -1778 -> 309
    //   2090: iconst_0
    //   2091: istore 10
    //   2093: goto -1793 -> 300
    //   2096: iload 4
    //   2098: istore 8
    //   2100: new 224	java/io/File
    //   2103: dup
    //   2104: aload 42
    //   2106: new 126	java/lang/StringBuilder
    //   2109: dup
    //   2110: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2113: aload 38
    //   2115: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   2118: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2121: ldc_w 495
    //   2124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2130: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2133: astore 36
    //   2135: goto -1584 -> 551
    //   2138: aload 29
    //   2140: astore 35
    //   2142: aload 29
    //   2144: astore 34
    //   2146: iload 5
    //   2148: istore 4
    //   2150: getstatic 46	bdvx:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2153: ifnonnull +29 -> 2182
    //   2156: aload 29
    //   2158: astore 35
    //   2160: aload 29
    //   2162: astore 34
    //   2164: iload 5
    //   2166: istore 4
    //   2168: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2171: ldc 54
    //   2173: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2176: checkcast 60	android/net/ConnectivityManager
    //   2179: putstatic 46	bdvx:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2182: aload 29
    //   2184: astore 35
    //   2186: aload 29
    //   2188: astore 34
    //   2190: iload 5
    //   2192: istore 4
    //   2194: invokestatic 501	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   2197: astore 44
    //   2199: aload 44
    //   2201: ifnonnull +480 -> 2681
    //   2204: bipush 152
    //   2206: istore 8
    //   2208: aload 29
    //   2210: astore 35
    //   2212: aload 29
    //   2214: astore 34
    //   2216: iload 5
    //   2218: istore 4
    //   2220: aload_0
    //   2221: bipush 152
    //   2223: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   2226: iload 13
    //   2228: istore 5
    //   2230: iload 8
    //   2232: istore 4
    //   2234: iload 8
    //   2236: istore 6
    //   2238: aload 43
    //   2240: ldc_w 503
    //   2243: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: pop
    //   2247: iload 13
    //   2249: istore 5
    //   2251: iload 8
    //   2253: istore 4
    //   2255: iload 8
    //   2257: istore 6
    //   2259: new 67	java/lang/Exception
    //   2262: dup
    //   2263: ldc_w 505
    //   2266: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2269: athrow
    //   2270: astore_1
    //   2271: iload 6
    //   2273: istore 4
    //   2275: ldc 77
    //   2277: iconst_1
    //   2278: new 126	java/lang/StringBuilder
    //   2281: dup
    //   2282: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2285: aload 43
    //   2287: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2290: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: ldc_w 351
    //   2296: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2302: lload 27
    //   2304: lsub
    //   2305: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2308: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2311: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2314: iload 6
    //   2316: istore 4
    //   2318: aload_0
    //   2319: getfield 205	bdvv:jdField_g_of_type_Int	I
    //   2322: iconst_3
    //   2323: if_icmpne +64 -> 2387
    //   2326: iload 10
    //   2328: ifeq +59 -> 2387
    //   2331: iload 6
    //   2333: istore 4
    //   2335: bipush 30
    //   2337: aload_0
    //   2338: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2341: sipush 300
    //   2344: iconst_1
    //   2345: anewarray 4	java/lang/Object
    //   2348: dup
    //   2349: iconst_0
    //   2350: new 126	java/lang/StringBuilder
    //   2353: dup
    //   2354: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2357: aload 43
    //   2359: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2362: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: ldc_w 351
    //   2368: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2374: lload 27
    //   2376: lsub
    //   2377: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2380: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2383: aastore
    //   2384: invokestatic 357	alda:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   2387: iload 6
    //   2389: ifeq +119 -> 2508
    //   2392: iload 6
    //   2394: istore 4
    //   2396: aload_0
    //   2397: invokevirtual 359	bdvv:b	()Z
    //   2400: ifne +108 -> 2508
    //   2403: iload 6
    //   2405: istore 4
    //   2407: aload_0
    //   2408: getfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   2411: ifeq +97 -> 2508
    //   2414: iload 6
    //   2416: istore 4
    //   2418: aload 39
    //   2420: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   2423: ifeq +4817 -> 7240
    //   2426: iload 6
    //   2428: istore 4
    //   2430: aload 39
    //   2432: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2435: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2438: ifne +4766 -> 7204
    //   2441: iload 6
    //   2443: istore 4
    //   2445: invokestatic 369	bavf:a	()Lbavf;
    //   2448: aload 39
    //   2450: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2453: aload 39
    //   2455: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2458: getstatic 34	bdvx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   2461: aload 39
    //   2463: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2466: invokeinterface 222 2 0
    //   2471: checkcast 147	java/lang/Integer
    //   2474: invokevirtual 373	java/lang/Integer:intValue	()I
    //   2477: invokevirtual 376	bavf:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2480: iload 6
    //   2482: istore 4
    //   2484: aload 39
    //   2486: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2489: aload 38
    //   2491: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   2494: iconst_m1
    //   2495: aload_2
    //   2496: invokestatic 380	bdvx:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2499: iload 6
    //   2501: istore 4
    //   2503: aload_0
    //   2504: iconst_0
    //   2505: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   2508: iload 6
    //   2510: istore 4
    //   2512: new 126	java/lang/StringBuilder
    //   2515: dup
    //   2516: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2519: astore_2
    //   2520: iload 6
    //   2522: istore 4
    //   2524: aload 39
    //   2526: getfield 384	apnb:jdField_b_of_type_Boolean	Z
    //   2529: ifeq +6055 -> 8584
    //   2532: ldc_w 386
    //   2535: astore_0
    //   2536: iload 6
    //   2538: istore 4
    //   2540: aload_2
    //   2541: aload_0
    //   2542: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: astore_2
    //   2546: iload 6
    //   2548: istore 4
    //   2550: aload 39
    //   2552: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   2555: ifeq +6036 -> 8591
    //   2558: ldc_w 388
    //   2561: astore_0
    //   2562: iload 6
    //   2564: istore 4
    //   2566: aload_2
    //   2567: aload_0
    //   2568: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2574: pop
    //   2575: aload 33
    //   2577: ifnull +14 -> 2591
    //   2580: iload 6
    //   2582: istore 4
    //   2584: aload 33
    //   2586: invokeinterface 393 1 0
    //   2591: aload 31
    //   2593: ifnull +12 -> 2605
    //   2596: iload 6
    //   2598: istore 4
    //   2600: aload 31
    //   2602: invokevirtual 398	java/io/InputStream:close	()V
    //   2605: aload 32
    //   2607: ifnull +12 -> 2619
    //   2610: iload 6
    //   2612: istore 4
    //   2614: aload 32
    //   2616: invokevirtual 401	java/io/BufferedOutputStream:close	()V
    //   2619: iload 6
    //   2621: istore 4
    //   2623: aload_1
    //   2624: athrow
    //   2625: astore_0
    //   2626: iload 4
    //   2628: istore_3
    //   2629: ldc 77
    //   2631: iconst_1
    //   2632: aload_0
    //   2633: invokevirtual 328	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2636: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2639: iload_3
    //   2640: istore 4
    //   2642: iload 4
    //   2644: istore_3
    //   2645: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2648: ifeq +5654 -> 8302
    //   2651: ldc 77
    //   2653: iconst_2
    //   2654: new 126	java/lang/StringBuilder
    //   2657: dup
    //   2658: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2661: ldc_w 509
    //   2664: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: iload 4
    //   2669: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2672: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2675: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2678: iload 4
    //   2680: ireturn
    //   2681: aload 29
    //   2683: astore 30
    //   2685: aload 29
    //   2687: astore 35
    //   2689: aload 29
    //   2691: astore 34
    //   2693: iload 5
    //   2695: istore 4
    //   2697: aload_0
    //   2698: getfield 485	bdvv:q	Z
    //   2701: ifeq +122 -> 2823
    //   2704: aload 29
    //   2706: astore 30
    //   2708: aload 29
    //   2710: astore 35
    //   2712: aload 29
    //   2714: astore 34
    //   2716: iload 5
    //   2718: istore 4
    //   2720: aload 29
    //   2722: ldc_w 511
    //   2725: invokevirtual 471	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2728: ifne +95 -> 2823
    //   2731: aload 29
    //   2733: astore 35
    //   2735: aload 29
    //   2737: astore 34
    //   2739: iload 5
    //   2741: istore 4
    //   2743: new 513	java/util/Random
    //   2746: dup
    //   2747: aload_1
    //   2748: invokestatic 517	awwo:a	(Ljava/lang/String;)J
    //   2751: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2754: lor
    //   2755: invokespecial 520	java/util/Random:<init>	(J)V
    //   2758: invokevirtual 523	java/util/Random:nextInt	()I
    //   2761: istore 13
    //   2763: aload 29
    //   2765: astore 35
    //   2767: aload 29
    //   2769: astore 34
    //   2771: iload 5
    //   2773: istore 4
    //   2775: aload 29
    //   2777: invokestatic 526	bdvx:b	(Ljava/lang/String;)Z
    //   2780: ifeq +383 -> 3163
    //   2783: aload 29
    //   2785: astore 35
    //   2787: aload 29
    //   2789: astore 34
    //   2791: iload 5
    //   2793: istore 4
    //   2795: new 126	java/lang/StringBuilder
    //   2798: dup
    //   2799: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2802: aload 29
    //   2804: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: ldc_w 528
    //   2810: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: iload 13
    //   2815: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2818: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2821: astore 30
    //   2823: aload 30
    //   2825: astore 35
    //   2827: aload 30
    //   2829: astore 34
    //   2831: iload 5
    //   2833: istore 4
    //   2835: aload 30
    //   2837: invokestatic 531	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2840: astore 29
    //   2842: aload 29
    //   2844: astore 35
    //   2846: aload 29
    //   2848: astore 34
    //   2850: iload 5
    //   2852: istore 4
    //   2854: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2857: ifeq +42 -> 2899
    //   2860: aload 29
    //   2862: astore 35
    //   2864: aload 29
    //   2866: astore 34
    //   2868: iload 5
    //   2870: istore 4
    //   2872: ldc 77
    //   2874: iconst_2
    //   2875: new 126	java/lang/StringBuilder
    //   2878: dup
    //   2879: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2882: ldc_w 533
    //   2885: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2888: aload 29
    //   2890: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2896: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2899: aload 29
    //   2901: astore 35
    //   2903: aload 29
    //   2905: astore 34
    //   2907: iload 5
    //   2909: istore 4
    //   2911: aload_0
    //   2912: getfield 418	bdvv:jdField_f_of_type_Int	I
    //   2915: sipush 302
    //   2918: if_icmpne +5334 -> 8252
    //   2921: iload 12
    //   2923: ifne +5329 -> 8252
    //   2926: aload 29
    //   2928: astore 35
    //   2930: aload 29
    //   2932: astore 34
    //   2934: iload 5
    //   2936: istore 4
    //   2938: aload_0
    //   2939: getfield 478	bdvv:r	Z
    //   2942: ifeq +5310 -> 8252
    //   2945: aload 29
    //   2947: astore 35
    //   2949: aload 29
    //   2951: astore 34
    //   2953: iload 5
    //   2955: istore 4
    //   2957: aload 29
    //   2959: ldc_w 535
    //   2962: invokevirtual 538	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2965: ifeq +5287 -> 8252
    //   2968: aload 29
    //   2970: astore 35
    //   2972: aload 29
    //   2974: astore 34
    //   2976: iload 5
    //   2978: istore 4
    //   2980: aload_0
    //   2981: iconst_0
    //   2982: putfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   2985: iconst_1
    //   2986: istore 4
    //   2988: iconst_1
    //   2989: istore 5
    //   2991: aload 29
    //   2993: astore 35
    //   2995: aload 29
    //   2997: astore 34
    //   2999: aload 29
    //   3001: ldc_w 540
    //   3004: ldc_w 542
    //   3007: invokevirtual 545	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3010: astore 29
    //   3012: new 547	org/apache/http/client/methods/HttpGet
    //   3015: dup
    //   3016: aload 29
    //   3018: invokespecial 548	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   3021: astore 34
    //   3023: aload_0
    //   3024: invokevirtual 551	bdvv:a	()Ljava/util/Map;
    //   3027: astore 30
    //   3029: aload 30
    //   3031: ifnull +175 -> 3206
    //   3034: aload 30
    //   3036: invokeinterface 555 1 0
    //   3041: invokeinterface 561 1 0
    //   3046: astore 35
    //   3048: aload 35
    //   3050: invokeinterface 566 1 0
    //   3055: ifeq +151 -> 3206
    //   3058: aload 35
    //   3060: invokeinterface 570 1 0
    //   3065: checkcast 199	java/lang/String
    //   3068: astore 45
    //   3070: aload 30
    //   3072: aload 45
    //   3074: invokeinterface 222 2 0
    //   3079: checkcast 199	java/lang/String
    //   3082: astore 46
    //   3084: aload 34
    //   3086: aload 45
    //   3088: aload 46
    //   3090: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3093: aload 43
    //   3095: ldc_w 576
    //   3098: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3101: aload 45
    //   3103: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: ldc_w 578
    //   3109: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3112: aload 46
    //   3114: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3117: pop
    //   3118: goto -70 -> 3048
    //   3121: astore 35
    //   3123: aload 33
    //   3125: astore 34
    //   3127: iconst_0
    //   3128: istore 14
    //   3130: iload 5
    //   3132: istore 4
    //   3134: aload 32
    //   3136: astore 30
    //   3138: iload 6
    //   3140: istore 8
    //   3142: aload 35
    //   3144: astore 33
    //   3146: iload 7
    //   3148: istore 6
    //   3150: iload_3
    //   3151: istore 5
    //   3153: aload 34
    //   3155: astore 32
    //   3157: iload 8
    //   3159: istore_3
    //   3160: goto -2207 -> 953
    //   3163: aload 29
    //   3165: astore 35
    //   3167: aload 29
    //   3169: astore 34
    //   3171: iload 5
    //   3173: istore 4
    //   3175: new 126	java/lang/StringBuilder
    //   3178: dup
    //   3179: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3182: aload 29
    //   3184: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: ldc_w 580
    //   3190: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3193: iload 13
    //   3195: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3198: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3201: astore 30
    //   3203: goto -380 -> 2823
    //   3206: aload_0
    //   3207: getfield 583	bdvv:k	Z
    //   3210: ifeq +41 -> 3251
    //   3213: getstatic 586	bhlt:jdField_a_of_type_Boolean	Z
    //   3216: ifeq +35 -> 3251
    //   3219: invokestatic 587	bhlt:a	()Z
    //   3222: ifeq +29 -> 3251
    //   3225: aload 34
    //   3227: ldc_w 589
    //   3230: ldc_w 591
    //   3233: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3236: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3239: ifeq +12 -> 3251
    //   3242: ldc 77
    //   3244: iconst_2
    //   3245: ldc_w 593
    //   3248: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3251: aload_0
    //   3252: getfield 596	bdvv:l	Z
    //   3255: ifeq +154 -> 3409
    //   3258: invokestatic 601	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3261: getstatic 607	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   3264: invokevirtual 610	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   3267: invokevirtual 611	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3270: astore 30
    //   3272: aload 30
    //   3274: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3277: ifne +1010 -> 4287
    //   3280: aload 30
    //   3282: invokestatic 615	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3285: iconst_1
    //   3286: iand
    //   3287: iconst_1
    //   3288: if_icmpne +999 -> 4287
    //   3291: aload 34
    //   3293: ldc_w 589
    //   3296: ldc_w 617
    //   3299: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3302: ldc_w 619
    //   3305: iconst_3
    //   3306: anewarray 4	java/lang/Object
    //   3309: dup
    //   3310: iconst_0
    //   3311: getstatic 27	bdvx:jdField_a_of_type_ArrayOfInt	[I
    //   3314: iconst_0
    //   3315: iaload
    //   3316: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3319: aastore
    //   3320: dup
    //   3321: iconst_1
    //   3322: getstatic 27	bdvx:jdField_a_of_type_ArrayOfInt	[I
    //   3325: iconst_1
    //   3326: iaload
    //   3327: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3330: aastore
    //   3331: dup
    //   3332: iconst_2
    //   3333: getstatic 27	bdvx:jdField_a_of_type_ArrayOfInt	[I
    //   3336: iconst_2
    //   3337: iaload
    //   3338: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3341: aastore
    //   3342: invokestatic 623	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3345: astore 30
    //   3347: aload 34
    //   3349: ldc_w 625
    //   3352: new 126	java/lang/StringBuilder
    //   3355: dup
    //   3356: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3359: ldc_w 627
    //   3362: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: aload 30
    //   3367: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3373: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3376: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3379: ifeq +30 -> 3409
    //   3382: ldc 77
    //   3384: iconst_2
    //   3385: new 126	java/lang/StringBuilder
    //   3388: dup
    //   3389: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3392: ldc_w 629
    //   3395: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: aload 29
    //   3400: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3403: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3406: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3409: aload 36
    //   3411: ifnull +80 -> 3491
    //   3414: aload 36
    //   3416: invokevirtual 292	java/io/File:exists	()Z
    //   3419: ifeq +72 -> 3491
    //   3422: aload 36
    //   3424: invokevirtual 632	java/io/File:length	()J
    //   3427: lstore 21
    //   3429: aload 34
    //   3431: ldc_w 634
    //   3434: new 126	java/lang/StringBuilder
    //   3437: dup
    //   3438: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3441: ldc_w 636
    //   3444: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3447: lload 21
    //   3449: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3452: ldc_w 638
    //   3455: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3461: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3464: aload 43
    //   3466: new 126	java/lang/StringBuilder
    //   3469: dup
    //   3470: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3473: ldc_w 640
    //   3476: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: lload 21
    //   3481: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: pop
    //   3491: aload_0
    //   3492: getfield 643	bdvv:m	Z
    //   3495: ifne +119 -> 3614
    //   3498: aload_0
    //   3499: getfield 646	bdvv:j	Z
    //   3502: ifeq +112 -> 3614
    //   3505: aload 38
    //   3507: ifnull +107 -> 3614
    //   3510: aload 38
    //   3512: invokevirtual 292	java/io/File:exists	()Z
    //   3515: ifeq +99 -> 3614
    //   3518: aload_0
    //   3519: getfield 648	bdvv:jdField_i_of_type_Long	J
    //   3522: lconst_0
    //   3523: lcmp
    //   3524: ifle +781 -> 4305
    //   3527: aload_0
    //   3528: getfield 648	bdvv:jdField_i_of_type_Long	J
    //   3531: lstore 21
    //   3533: lload 21
    //   3535: lconst_0
    //   3536: lcmp
    //   3537: ifle +77 -> 3614
    //   3540: new 650	java/text/SimpleDateFormat
    //   3543: dup
    //   3544: ldc_w 652
    //   3547: getstatic 658	java/util/Locale:US	Ljava/util/Locale;
    //   3550: invokespecial 661	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3553: astore 30
    //   3555: aload 30
    //   3557: ldc_w 663
    //   3560: invokestatic 669	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3563: invokevirtual 673	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3566: aload 30
    //   3568: new 675	java/util/Date
    //   3571: dup
    //   3572: lload 21
    //   3574: invokespecial 676	java/util/Date:<init>	(J)V
    //   3577: invokevirtual 679	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3580: astore 30
    //   3582: aload 30
    //   3584: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3587: ifne +27 -> 3614
    //   3590: aload 34
    //   3592: ldc_w 681
    //   3595: aload 30
    //   3597: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3600: aload 43
    //   3602: ldc_w 683
    //   3605: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3608: aload 30
    //   3610: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3613: pop
    //   3614: getstatic 20	bdvx:jdField_a_of_type_Boolean	Z
    //   3617: ifeq +105 -> 3722
    //   3620: aload_0
    //   3621: getfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   3624: ifeq +98 -> 3722
    //   3627: aload_0
    //   3628: getfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   3631: ifeq +91 -> 3722
    //   3634: aload 39
    //   3636: getfield 384	apnb:jdField_b_of_type_Boolean	Z
    //   3639: ifne +83 -> 3722
    //   3642: aload 39
    //   3644: invokestatic 686	bdvx:a	(Lapnb;)V
    //   3647: aload 39
    //   3649: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   3652: ifeq +70 -> 3722
    //   3655: aload 34
    //   3657: new 688	java/net/URI
    //   3660: dup
    //   3661: aload 39
    //   3663: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3666: invokespecial 689	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3669: invokevirtual 693	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3672: aload 34
    //   3674: ldc_w 695
    //   3677: aload 39
    //   3679: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3682: invokevirtual 574	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3685: aload 43
    //   3687: ldc_w 697
    //   3690: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: aload 39
    //   3695: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3698: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: ldc_w 699
    //   3704: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3707: aload 39
    //   3709: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3712: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3715: ldc_w 701
    //   3718: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3721: pop
    //   3722: aload 44
    //   3724: invokevirtual 706	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3727: invokestatic 710	bdlr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3730: astore 30
    //   3732: aload 30
    //   3734: aload_0
    //   3735: getfield 711	bdvv:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3738: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3741: ifne +14 -> 3755
    //   3744: aload_0
    //   3745: iconst_0
    //   3746: putfield 333	bdvv:jdField_f_of_type_Boolean	Z
    //   3749: aload_0
    //   3750: aload 30
    //   3752: putfield 711	bdvv:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3755: aload 44
    //   3757: invokestatic 720	bdee:a	(Landroid/net/NetworkInfo;)Z
    //   3760: ifeq +555 -> 4315
    //   3763: aload_0
    //   3764: getfield 333	bdvv:jdField_f_of_type_Boolean	Z
    //   3767: ifne +4476 -> 8243
    //   3770: invokestatic 725	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3773: astore 30
    //   3775: invokestatic 728	android/net/Proxy:getDefaultPort	()I
    //   3778: istore 8
    //   3780: aload 30
    //   3782: ifnull +4454 -> 8236
    //   3785: iload 8
    //   3787: ifle +4449 -> 8236
    //   3790: aload 40
    //   3792: ldc_w 730
    //   3795: new 732	org/apache/http/HttpHost
    //   3798: dup
    //   3799: aload 30
    //   3801: iload 8
    //   3803: invokespecial 735	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3806: invokeinterface 157 3 0
    //   3811: pop
    //   3812: iconst_1
    //   3813: istore 4
    //   3815: aload 43
    //   3817: ldc_w 737
    //   3820: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3823: iconst_1
    //   3824: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3827: ldc_w 739
    //   3830: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3833: aload 30
    //   3835: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3838: ldc_w 741
    //   3841: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3844: iload 8
    //   3846: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3849: pop
    //   3850: iload 4
    //   3852: istore 7
    //   3854: iload_3
    //   3855: istore 4
    //   3857: iload 7
    //   3859: istore_3
    //   3860: aload_0
    //   3861: getfield 280	bdvv:p	Z
    //   3864: ifne +18 -> 3882
    //   3867: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3870: invokestatic 744	bdee:h	(Landroid/content/Context;)Z
    //   3873: ifeq +9 -> 3882
    //   3876: aload 40
    //   3878: iconst_0
    //   3879: invokestatic 750	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3882: aload 40
    //   3884: ldc_w 752
    //   3887: iload 4
    //   3889: invokeinterface 756 3 0
    //   3894: pop
    //   3895: aload 34
    //   3897: aload 40
    //   3899: invokevirtual 760	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3902: aload_0
    //   3903: getfield 164	bdvv:n	Z
    //   3906: ifeq +419 -> 4325
    //   3909: ldc 166
    //   3911: astore 30
    //   3913: aload 34
    //   3915: ldc 168
    //   3917: aload 30
    //   3919: invokevirtual 763	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3922: getstatic 768	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3925: aload 34
    //   3927: invokevirtual 774	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3930: astore 35
    //   3932: iload 5
    //   3934: istore 7
    //   3936: aload 35
    //   3938: invokeinterface 780 1 0
    //   3943: invokeinterface 785 1 0
    //   3948: istore 8
    //   3950: iload 5
    //   3952: istore 7
    //   3954: aload_0
    //   3955: iload 8
    //   3957: putfield 418	bdvv:jdField_f_of_type_Int	I
    //   3960: iload 5
    //   3962: istore 7
    //   3964: aload 39
    //   3966: iload 8
    //   3968: putfield 787	apnb:jdField_c_of_type_Int	I
    //   3971: iload 5
    //   3973: istore 7
    //   3975: aload 43
    //   3977: ldc_w 789
    //   3980: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3983: aload 34
    //   3985: invokevirtual 793	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3988: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3991: ldc_w 795
    //   3994: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3997: iload 8
    //   3999: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4002: ldc_w 797
    //   4005: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4008: pop
    //   4009: iload 5
    //   4011: istore 7
    //   4013: aload 35
    //   4015: invokeinterface 801 1 0
    //   4020: astore 30
    //   4022: iload 5
    //   4024: istore 7
    //   4026: aload 30
    //   4028: invokeinterface 804 1 0
    //   4033: ifeq +300 -> 4333
    //   4036: iload 5
    //   4038: istore 7
    //   4040: aload 30
    //   4042: invokeinterface 808 1 0
    //   4047: astore 34
    //   4049: iload 5
    //   4051: istore 7
    //   4053: aload 34
    //   4055: invokeinterface 811 1 0
    //   4060: astore 44
    //   4062: iload 5
    //   4064: istore 7
    //   4066: ldc_w 813
    //   4069: aload 44
    //   4071: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4074: ifne +138 -> 4212
    //   4077: iload 5
    //   4079: istore 7
    //   4081: ldc_w 818
    //   4084: aload 44
    //   4086: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4089: ifne +123 -> 4212
    //   4092: iload 5
    //   4094: istore 7
    //   4096: ldc_w 820
    //   4099: aload 44
    //   4101: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4104: ifne +108 -> 4212
    //   4107: iload 5
    //   4109: istore 7
    //   4111: ldc_w 822
    //   4114: aload 44
    //   4116: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4119: ifne +93 -> 4212
    //   4122: iload 5
    //   4124: istore 7
    //   4126: ldc_w 824
    //   4129: aload 44
    //   4131: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4134: ifne +78 -> 4212
    //   4137: iload 5
    //   4139: istore 7
    //   4141: ldc_w 826
    //   4144: aload 44
    //   4146: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4149: ifne +63 -> 4212
    //   4152: iload 5
    //   4154: istore 7
    //   4156: ldc_w 828
    //   4159: aload 44
    //   4161: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4164: ifne +48 -> 4212
    //   4167: iload 5
    //   4169: istore 7
    //   4171: ldc_w 830
    //   4174: aload 44
    //   4176: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4179: ifne +33 -> 4212
    //   4182: iload 5
    //   4184: istore 7
    //   4186: ldc_w 832
    //   4189: aload 44
    //   4191: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4194: ifne +18 -> 4212
    //   4197: iload 5
    //   4199: istore 7
    //   4201: ldc_w 834
    //   4204: aload 44
    //   4206: invokevirtual 816	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4209: ifeq -187 -> 4022
    //   4212: iload 5
    //   4214: istore 7
    //   4216: aload 43
    //   4218: ldc_w 576
    //   4221: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4224: aload 44
    //   4226: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: ldc_w 836
    //   4232: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4235: aload 34
    //   4237: invokeinterface 839 1 0
    //   4242: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4245: pop
    //   4246: goto -224 -> 4022
    //   4249: astore 34
    //   4251: iconst_1
    //   4252: istore 14
    //   4254: iload 4
    //   4256: istore 5
    //   4258: aload 32
    //   4260: astore 30
    //   4262: aload 33
    //   4264: astore 32
    //   4266: iload 6
    //   4268: istore 8
    //   4270: aload 34
    //   4272: astore 33
    //   4274: iload_3
    //   4275: istore 6
    //   4277: iload 7
    //   4279: istore 4
    //   4281: iload 8
    //   4283: istore_3
    //   4284: goto -3331 -> 953
    //   4287: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4290: ifeq -881 -> 3409
    //   4293: ldc 77
    //   4295: iconst_2
    //   4296: ldc_w 841
    //   4299: invokestatic 844	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4302: goto -893 -> 3409
    //   4305: aload 38
    //   4307: invokevirtual 847	java/io/File:lastModified	()J
    //   4310: lstore 21
    //   4312: goto -779 -> 3533
    //   4315: sipush 4096
    //   4318: istore 4
    //   4320: iconst_0
    //   4321: istore_3
    //   4322: goto -462 -> 3860
    //   4325: ldc_w 849
    //   4328: astore 30
    //   4330: goto -417 -> 3913
    //   4333: sipush 200
    //   4336: iload 8
    //   4338: if_icmpeq +11 -> 4349
    //   4341: sipush 206
    //   4344: iload 8
    //   4346: if_icmpne +2081 -> 6427
    //   4349: iload 5
    //   4351: istore 7
    //   4353: aload 35
    //   4355: invokeinterface 853 1 0
    //   4360: astore 30
    //   4362: aload 30
    //   4364: invokeinterface 856 1 0
    //   4369: lstore 23
    //   4371: lload 23
    //   4373: lstore 21
    //   4375: iload 5
    //   4377: istore 7
    //   4379: aload 43
    //   4381: ldc_w 858
    //   4384: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4387: lload 23
    //   4389: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4392: pop
    //   4393: lload 23
    //   4395: lstore 21
    //   4397: iload 5
    //   4399: istore 7
    //   4401: aload 35
    //   4403: ldc_w 860
    //   4406: invokeinterface 864 2 0
    //   4411: astore 33
    //   4413: lload 23
    //   4415: lstore 21
    //   4417: iload 5
    //   4419: istore 7
    //   4421: aload 35
    //   4423: ldc_w 820
    //   4426: invokeinterface 864 2 0
    //   4431: astore 34
    //   4433: aload 33
    //   4435: ifnull +250 -> 4685
    //   4438: lload 23
    //   4440: lstore 21
    //   4442: iload 5
    //   4444: istore 7
    //   4446: aload 33
    //   4448: invokeinterface 839 1 0
    //   4453: ldc_w 866
    //   4456: invokevirtual 870	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4459: iconst_1
    //   4460: aaload
    //   4461: invokestatic 615	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4464: i2l
    //   4465: lstore 17
    //   4467: lload 17
    //   4469: lstore 21
    //   4471: iload 5
    //   4473: istore 7
    //   4475: aload 36
    //   4477: invokevirtual 632	java/io/File:length	()J
    //   4480: lstore 23
    //   4482: lload 17
    //   4484: lstore 21
    //   4486: iload 5
    //   4488: istore 7
    //   4490: aload 43
    //   4492: ldc_w 872
    //   4495: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4498: lload 17
    //   4500: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4503: ldc_w 874
    //   4506: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4509: lload 23
    //   4511: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4514: pop
    //   4515: lload 17
    //   4517: lstore 21
    //   4519: iload 5
    //   4521: istore 7
    //   4523: aload_0
    //   4524: getfield 876	bdvv:jdField_g_of_type_Boolean	Z
    //   4527: ifne +10 -> 4537
    //   4530: lload 17
    //   4532: lconst_1
    //   4533: lcmp
    //   4534: iflt +38 -> 4572
    //   4537: lload 17
    //   4539: lstore 21
    //   4541: iload 5
    //   4543: istore 7
    //   4545: aload_0
    //   4546: getfield 878	bdvv:jdField_e_of_type_Long	J
    //   4549: lconst_0
    //   4550: lcmp
    //   4551: ifle +167 -> 4718
    //   4554: lload 17
    //   4556: lstore 21
    //   4558: iload 5
    //   4560: istore 7
    //   4562: lload 17
    //   4564: aload_0
    //   4565: getfield 878	bdvv:jdField_e_of_type_Long	J
    //   4568: lcmp
    //   4569: ifle +149 -> 4718
    //   4572: iconst_1
    //   4573: istore 7
    //   4575: iconst_1
    //   4576: istore 13
    //   4578: bipush 138
    //   4580: istore 8
    //   4582: lload 17
    //   4584: lstore 21
    //   4586: aload_0
    //   4587: bipush 138
    //   4589: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   4592: iload 8
    //   4594: istore 6
    //   4596: iload 13
    //   4598: istore 5
    //   4600: iload 8
    //   4602: istore 7
    //   4604: aload 43
    //   4606: ldc_w 880
    //   4609: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4612: aload_0
    //   4613: getfield 878	bdvv:jdField_e_of_type_Long	J
    //   4616: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4619: pop
    //   4620: iload 8
    //   4622: istore 6
    //   4624: iload 13
    //   4626: istore 5
    //   4628: iload 8
    //   4630: istore 7
    //   4632: new 67	java/lang/Exception
    //   4635: dup
    //   4636: ldc_w 882
    //   4639: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4642: athrow
    //   4643: astore 33
    //   4645: iload 6
    //   4647: istore 7
    //   4649: iload 4
    //   4651: istore 8
    //   4653: aload 30
    //   4655: astore 34
    //   4657: iload 5
    //   4659: istore 4
    //   4661: iconst_1
    //   4662: istore 14
    //   4664: iload_3
    //   4665: istore 6
    //   4667: iload 8
    //   4669: istore 5
    //   4671: aload 32
    //   4673: astore 30
    //   4675: aload 34
    //   4677: astore 32
    //   4679: iload 7
    //   4681: istore_3
    //   4682: goto -3729 -> 953
    //   4685: lload 23
    //   4687: lstore 17
    //   4689: aload 34
    //   4691: ifnull -224 -> 4467
    //   4694: lload 23
    //   4696: lstore 21
    //   4698: iload 5
    //   4700: istore 7
    //   4702: aload 34
    //   4704: invokeinterface 839 1 0
    //   4709: invokestatic 615	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4712: i2l
    //   4713: lstore 17
    //   4715: goto -248 -> 4467
    //   4718: lconst_0
    //   4719: lload 23
    //   4721: lcmp
    //   4722: ifeq +74 -> 4796
    //   4725: lload 23
    //   4727: lload 17
    //   4729: lcmp
    //   4730: iflt +66 -> 4796
    //   4733: lload 17
    //   4735: lstore 21
    //   4737: iload 5
    //   4739: istore 7
    //   4741: aload 36
    //   4743: invokevirtual 298	java/io/File:delete	()Z
    //   4746: pop
    //   4747: bipush 139
    //   4749: istore 8
    //   4751: lload 17
    //   4753: lstore 21
    //   4755: iload 5
    //   4757: istore 7
    //   4759: aload_0
    //   4760: bipush 139
    //   4762: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   4765: iload 8
    //   4767: istore 6
    //   4769: iload 8
    //   4771: istore 7
    //   4773: new 67	java/lang/Exception
    //   4776: dup
    //   4777: ldc_w 884
    //   4780: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4783: athrow
    //   4784: astore_1
    //   4785: iload 7
    //   4787: istore 6
    //   4789: aload 30
    //   4791: astore 33
    //   4793: goto -2522 -> 2271
    //   4796: lload 23
    //   4798: lconst_0
    //   4799: lcmp
    //   4800: ifeq +335 -> 5135
    //   4803: iconst_1
    //   4804: istore 14
    //   4806: lload 17
    //   4808: lstore 21
    //   4810: iload 5
    //   4812: istore 7
    //   4814: new 400	java/io/BufferedOutputStream
    //   4817: dup
    //   4818: new 886	java/io/FileOutputStream
    //   4821: dup
    //   4822: aload 36
    //   4824: iload 14
    //   4826: invokespecial 889	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4829: invokespecial 892	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4832: astore 33
    //   4834: aload 35
    //   4836: ldc_w 832
    //   4839: invokeinterface 864 2 0
    //   4844: ifnull +297 -> 5141
    //   4847: ldc 166
    //   4849: aload 35
    //   4851: ldc_w 832
    //   4854: invokeinterface 864 2 0
    //   4859: invokeinterface 839 1 0
    //   4864: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4867: ifeq +274 -> 5141
    //   4870: new 894	java/util/zip/GZIPInputStream
    //   4873: dup
    //   4874: aload 30
    //   4876: invokeinterface 898 1 0
    //   4881: invokespecial 901	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4884: astore 32
    //   4886: aload 43
    //   4888: ldc_w 903
    //   4891: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4894: pop
    //   4895: aload 32
    //   4897: astore 31
    //   4899: invokestatic 909	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4902: iload 4
    //   4904: invokevirtual 913	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4907: astore 44
    //   4909: iconst_0
    //   4910: istore 7
    //   4912: lload 19
    //   4914: lstore 21
    //   4916: aload_0
    //   4917: invokevirtual 359	bdvv:b	()Z
    //   4920: ifne +326 -> 5246
    //   4923: lload 19
    //   4925: lstore 21
    //   4927: aload 31
    //   4929: aload 44
    //   4931: invokevirtual 917	java/io/InputStream:read	([B)I
    //   4934: istore 8
    //   4936: iload 8
    //   4938: iconst_m1
    //   4939: if_icmpeq +307 -> 5246
    //   4942: lload 19
    //   4944: lstore 21
    //   4946: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4949: ifeq +64 -> 5013
    //   4952: lconst_0
    //   4953: lload 23
    //   4955: lcmp
    //   4956: ifne +57 -> 5013
    //   4959: aconst_null
    //   4960: astore 34
    //   4962: iload 8
    //   4964: iconst_4
    //   4965: if_icmple +192 -> 5157
    //   4968: iconst_m1
    //   4969: aload 44
    //   4971: iconst_0
    //   4972: baload
    //   4973: if_icmpne +184 -> 5157
    //   4976: bipush 216
    //   4978: aload 44
    //   4980: iconst_1
    //   4981: baload
    //   4982: if_icmpne +175 -> 5157
    //   4985: ldc_w 919
    //   4988: astore 32
    //   4990: aload 32
    //   4992: ifnull +21 -> 5013
    //   4995: lload 19
    //   4997: lstore 21
    //   4999: aload 43
    //   5001: ldc_w 921
    //   5004: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5007: aload 32
    //   5009: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5012: pop
    //   5013: lload 19
    //   5015: lstore 21
    //   5017: aload 33
    //   5019: aload 44
    //   5021: iconst_0
    //   5022: iload 8
    //   5024: invokevirtual 925	java/io/BufferedOutputStream:write	([BII)V
    //   5027: lload 23
    //   5029: iload 8
    //   5031: i2l
    //   5032: ladd
    //   5033: lstore 23
    //   5035: lload 19
    //   5037: iload 8
    //   5039: i2l
    //   5040: ladd
    //   5041: lstore 19
    //   5043: iload 7
    //   5045: iload 8
    //   5047: iadd
    //   5048: istore 7
    //   5050: lload 17
    //   5052: lconst_0
    //   5053: lcmp
    //   5054: ifle +3179 -> 8233
    //   5057: lload 19
    //   5059: lstore 21
    //   5061: aload_0
    //   5062: getfield 927	bdvv:jdField_f_of_type_Long	J
    //   5065: lconst_0
    //   5066: lcmp
    //   5067: ifne +17 -> 5084
    //   5070: lload 19
    //   5072: lstore 21
    //   5074: aload_0
    //   5075: lload 17
    //   5077: ldc2_w 928
    //   5080: ldiv
    //   5081: putfield 927	bdvv:jdField_f_of_type_Long	J
    //   5084: lload 19
    //   5086: lstore 21
    //   5088: iload 7
    //   5090: i2l
    //   5091: aload_0
    //   5092: getfield 927	bdvv:jdField_f_of_type_Long	J
    //   5095: lcmp
    //   5096: ifge +11 -> 5107
    //   5099: lload 23
    //   5101: lload 17
    //   5103: lcmp
    //   5104: iflt +3129 -> 8233
    //   5107: lload 19
    //   5109: lstore 21
    //   5111: aload_0
    //   5112: lload 17
    //   5114: lload 23
    //   5116: iload 11
    //   5118: invokevirtual 932	bdvv:a	(JJI)V
    //   5121: lload 19
    //   5123: lstore 21
    //   5125: aload_0
    //   5126: invokevirtual 934	bdvv:b	()V
    //   5129: iconst_0
    //   5130: istore 7
    //   5132: goto -220 -> 4912
    //   5135: iconst_0
    //   5136: istore 14
    //   5138: goto -332 -> 4806
    //   5141: aload 30
    //   5143: invokeinterface 898 1 0
    //   5148: astore 32
    //   5150: aload 32
    //   5152: astore 31
    //   5154: goto -255 -> 4899
    //   5157: iload 8
    //   5159: bipush 8
    //   5161: if_icmple +3173 -> 8334
    //   5164: bipush 137
    //   5166: aload 44
    //   5168: iconst_0
    //   5169: baload
    //   5170: if_icmpne +3164 -> 8334
    //   5173: bipush 80
    //   5175: aload 44
    //   5177: iconst_1
    //   5178: baload
    //   5179: if_icmpne +3155 -> 8334
    //   5182: bipush 78
    //   5184: aload 44
    //   5186: iconst_2
    //   5187: baload
    //   5188: if_icmpne +3146 -> 8334
    //   5191: bipush 71
    //   5193: aload 44
    //   5195: iconst_3
    //   5196: baload
    //   5197: if_icmpne +3137 -> 8334
    //   5200: bipush 13
    //   5202: aload 44
    //   5204: iconst_4
    //   5205: baload
    //   5206: if_icmpne +3128 -> 8334
    //   5209: bipush 10
    //   5211: aload 44
    //   5213: iconst_5
    //   5214: baload
    //   5215: if_icmpne +3119 -> 8334
    //   5218: bipush 26
    //   5220: aload 44
    //   5222: bipush 6
    //   5224: baload
    //   5225: if_icmpne +3109 -> 8334
    //   5228: bipush 10
    //   5230: aload 44
    //   5232: bipush 7
    //   5234: baload
    //   5235: if_icmpne +3099 -> 8334
    //   5238: ldc_w 936
    //   5241: astore 32
    //   5243: goto -253 -> 4990
    //   5246: lload 19
    //   5248: lstore 21
    //   5250: aload 33
    //   5252: invokevirtual 939	java/io/BufferedOutputStream:flush	()V
    //   5255: lload 19
    //   5257: lstore 21
    //   5259: invokestatic 909	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   5262: aload 44
    //   5264: invokevirtual 943	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   5267: lload 19
    //   5269: lstore 21
    //   5271: aload 36
    //   5273: invokevirtual 632	java/io/File:length	()J
    //   5276: lstore 23
    //   5278: lload 19
    //   5280: lstore 21
    //   5282: aload 43
    //   5284: ldc_w 945
    //   5287: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5290: lload 23
    //   5292: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5295: pop
    //   5296: lload 23
    //   5298: lload 17
    //   5300: lcmp
    //   5301: ifeq +80 -> 5381
    //   5304: lload 17
    //   5306: lconst_1
    //   5307: lcmp
    //   5308: ifge +21 -> 5329
    //   5311: lload 19
    //   5313: lstore 21
    //   5315: aload_0
    //   5316: getfield 876	bdvv:jdField_g_of_type_Boolean	Z
    //   5319: ifeq +10 -> 5329
    //   5322: lload 23
    //   5324: lconst_0
    //   5325: lcmp
    //   5326: ifgt +55 -> 5381
    //   5329: lload 19
    //   5331: lstore 21
    //   5333: aload 35
    //   5335: ldc_w 832
    //   5338: invokeinterface 864 2 0
    //   5343: ifnull +898 -> 6241
    //   5346: lload 19
    //   5348: lstore 21
    //   5350: ldc 166
    //   5352: aload 35
    //   5354: ldc_w 832
    //   5357: invokeinterface 864 2 0
    //   5362: invokeinterface 839 1 0
    //   5367: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5370: ifeq +871 -> 6241
    //   5373: lload 23
    //   5375: lload 17
    //   5377: lcmp
    //   5378: iflt +863 -> 6241
    //   5381: lload 19
    //   5383: lstore 21
    //   5385: aload_0
    //   5386: iconst_0
    //   5387: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   5390: aload 38
    //   5392: invokevirtual 292	java/io/File:exists	()Z
    //   5395: ifeq +9 -> 5404
    //   5398: aload 38
    //   5400: invokevirtual 298	java/io/File:delete	()Z
    //   5403: pop
    //   5404: aload 36
    //   5406: aload 38
    //   5408: invokevirtual 949	java/io/File:renameTo	(Ljava/io/File;)Z
    //   5411: istore 14
    //   5413: aload 43
    //   5415: ldc_w 951
    //   5418: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: iload 14
    //   5423: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5426: pop
    //   5427: aload_0
    //   5428: getfield 646	bdvv:j	Z
    //   5431: ifeq +158 -> 5589
    //   5434: aload 35
    //   5436: ldc_w 824
    //   5439: invokeinterface 954 2 0
    //   5444: ifeq +145 -> 5589
    //   5447: aload 35
    //   5449: ldc_w 824
    //   5452: invokeinterface 864 2 0
    //   5457: invokeinterface 839 1 0
    //   5462: astore 32
    //   5464: aload 32
    //   5466: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5469: istore 14
    //   5471: iload 14
    //   5473: ifne +116 -> 5589
    //   5476: new 650	java/text/SimpleDateFormat
    //   5479: dup
    //   5480: ldc_w 956
    //   5483: getstatic 658	java/util/Locale:US	Ljava/util/Locale;
    //   5486: invokespecial 661	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   5489: astore 34
    //   5491: aload 34
    //   5493: ldc_w 663
    //   5496: invokestatic 669	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   5499: invokevirtual 673	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   5502: aload 34
    //   5504: aload 32
    //   5506: invokevirtual 960	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   5509: invokevirtual 963	java/util/Date:getTime	()J
    //   5512: lstore 21
    //   5514: aload 38
    //   5516: lload 21
    //   5518: invokevirtual 967	java/io/File:setLastModified	(J)Z
    //   5521: pop
    //   5522: aload_0
    //   5523: lload 21
    //   5525: putfield 648	bdvv:jdField_i_of_type_Long	J
    //   5528: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5531: ifeq +58 -> 5589
    //   5534: ldc 77
    //   5536: iconst_2
    //   5537: new 126	java/lang/StringBuilder
    //   5540: dup
    //   5541: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5544: ldc_w 969
    //   5547: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: lload 21
    //   5552: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5555: ldc_w 971
    //   5558: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5561: aload 38
    //   5563: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   5566: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5569: ldc_w 973
    //   5572: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5575: aload 38
    //   5577: invokevirtual 847	java/io/File:lastModified	()J
    //   5580: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5583: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5586: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5589: iconst_0
    //   5590: istore 7
    //   5592: iload 5
    //   5594: istore 6
    //   5596: iload 7
    //   5598: istore 5
    //   5600: lload 19
    //   5602: lstore 21
    //   5604: aload 30
    //   5606: astore 32
    //   5608: aload 33
    //   5610: astore 30
    //   5612: iload 5
    //   5614: istore 7
    //   5616: iload 6
    //   5618: istore 5
    //   5620: lload 17
    //   5622: lstore 19
    //   5624: lload 21
    //   5626: lstore 17
    //   5628: iload 5
    //   5630: istore 6
    //   5632: getstatic 42	bdvx:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5635: ifnonnull +17 -> 5652
    //   5638: iload 5
    //   5640: istore 6
    //   5642: new 39	java/util/concurrent/ConcurrentHashMap
    //   5645: dup
    //   5646: invokespecial 40	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5649: putstatic 42	bdvx:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5652: iload 7
    //   5654: ifeq +1204 -> 6858
    //   5657: iload 5
    //   5659: istore 6
    //   5661: aload_0
    //   5662: invokevirtual 359	bdvv:b	()Z
    //   5665: ifne +1193 -> 6858
    //   5668: iload 5
    //   5670: istore 6
    //   5672: iload 12
    //   5674: aload_0
    //   5675: getfield 284	bdvv:jdField_b_of_type_Int	I
    //   5678: if_icmpge +1077 -> 6755
    //   5681: iload 5
    //   5683: istore 6
    //   5685: aload 41
    //   5687: monitorenter
    //   5688: sipush 2000
    //   5691: i2l
    //   5692: lstore 21
    //   5694: aload 41
    //   5696: lload 21
    //   5698: invokevirtual 976	java/lang/Object:wait	(J)V
    //   5701: aload 41
    //   5703: monitorexit
    //   5704: iload 5
    //   5706: istore 6
    //   5708: aload_0
    //   5709: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   5712: sipush 302
    //   5715: if_icmpne +44 -> 5759
    //   5718: iload 5
    //   5720: istore 6
    //   5722: aload 35
    //   5724: ldc_w 826
    //   5727: invokeinterface 864 2 0
    //   5732: astore 33
    //   5734: aload 33
    //   5736: ifnull +23 -> 5759
    //   5739: iload 5
    //   5741: istore 6
    //   5743: aload 37
    //   5745: ldc_w 978
    //   5748: aload 33
    //   5750: invokeinterface 839 1 0
    //   5755: invokevirtual 409	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5758: pop
    //   5759: iload 7
    //   5761: istore 8
    //   5763: ldc 77
    //   5765: iconst_1
    //   5766: new 126	java/lang/StringBuilder
    //   5769: dup
    //   5770: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5773: aload 43
    //   5775: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5778: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5781: ldc_w 351
    //   5784: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5787: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   5790: lload 27
    //   5792: lsub
    //   5793: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5796: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5799: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5802: iload 7
    //   5804: istore 8
    //   5806: aload_0
    //   5807: getfield 205	bdvv:jdField_g_of_type_Int	I
    //   5810: iconst_3
    //   5811: if_icmpne +64 -> 5875
    //   5814: iload 10
    //   5816: ifeq +59 -> 5875
    //   5819: iload 7
    //   5821: istore 8
    //   5823: bipush 30
    //   5825: aload_0
    //   5826: getfield 202	bdvv:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5829: sipush 300
    //   5832: iconst_1
    //   5833: anewarray 4	java/lang/Object
    //   5836: dup
    //   5837: iconst_0
    //   5838: new 126	java/lang/StringBuilder
    //   5841: dup
    //   5842: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5845: aload 43
    //   5847: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5850: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5853: ldc_w 351
    //   5856: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5859: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   5862: lload 27
    //   5864: lsub
    //   5865: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5868: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5871: aastore
    //   5872: invokestatic 357	alda:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   5875: iload 7
    //   5877: ifeq +119 -> 5996
    //   5880: iload 7
    //   5882: istore 8
    //   5884: aload_0
    //   5885: invokevirtual 359	bdvv:b	()Z
    //   5888: ifne +108 -> 5996
    //   5891: iload 7
    //   5893: istore 8
    //   5895: aload_0
    //   5896: getfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   5899: ifeq +97 -> 5996
    //   5902: iload 7
    //   5904: istore 8
    //   5906: aload 39
    //   5908: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   5911: ifeq +1001 -> 6912
    //   5914: iload 7
    //   5916: istore 8
    //   5918: aload 39
    //   5920: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5923: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5926: ifne +950 -> 6876
    //   5929: iload 7
    //   5931: istore 8
    //   5933: invokestatic 369	bavf:a	()Lbavf;
    //   5936: aload 39
    //   5938: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5941: aload 39
    //   5943: getfield 364	apnb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5946: getstatic 34	bdvx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   5949: aload 39
    //   5951: getfield 370	apnb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5954: invokeinterface 222 2 0
    //   5959: checkcast 147	java/lang/Integer
    //   5962: invokevirtual 373	java/lang/Integer:intValue	()I
    //   5965: invokevirtual 376	bavf:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5968: iload 7
    //   5970: istore 8
    //   5972: aload 39
    //   5974: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5977: aload 38
    //   5979: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   5982: iconst_m1
    //   5983: aload_2
    //   5984: invokestatic 380	bdvx:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   5987: iload 7
    //   5989: istore 8
    //   5991: aload_0
    //   5992: iconst_0
    //   5993: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   5996: iload 7
    //   5998: istore 8
    //   6000: new 126	java/lang/StringBuilder
    //   6003: dup
    //   6004: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6007: astore 34
    //   6009: iload 7
    //   6011: istore 8
    //   6013: aload 39
    //   6015: getfield 384	apnb:jdField_b_of_type_Boolean	Z
    //   6018: ifeq +2519 -> 8537
    //   6021: ldc_w 386
    //   6024: astore 33
    //   6026: iload 7
    //   6028: istore 8
    //   6030: aload 34
    //   6032: aload 33
    //   6034: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6037: astore 34
    //   6039: iload 7
    //   6041: istore 8
    //   6043: aload 39
    //   6045: getfield 362	apnb:jdField_a_of_type_Boolean	Z
    //   6048: ifeq +2497 -> 8545
    //   6051: ldc_w 388
    //   6054: astore 33
    //   6056: iload 7
    //   6058: istore 8
    //   6060: aload 34
    //   6062: aload 33
    //   6064: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6067: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6070: astore 33
    //   6072: iload 12
    //   6074: iconst_1
    //   6075: iadd
    //   6076: istore 6
    //   6078: aload 32
    //   6080: ifnull +14 -> 6094
    //   6083: iload 7
    //   6085: istore 8
    //   6087: aload 32
    //   6089: invokeinterface 393 1 0
    //   6094: aload 31
    //   6096: ifnull +12 -> 6108
    //   6099: iload 7
    //   6101: istore 8
    //   6103: aload 31
    //   6105: invokevirtual 398	java/io/InputStream:close	()V
    //   6108: aload 30
    //   6110: ifnull +12 -> 6122
    //   6113: iload 7
    //   6115: istore 8
    //   6117: aload 30
    //   6119: invokevirtual 401	java/io/BufferedOutputStream:close	()V
    //   6122: iload 5
    //   6124: istore 8
    //   6126: iconst_1
    //   6127: istore 14
    //   6129: iload 6
    //   6131: istore 5
    //   6133: iload_3
    //   6134: istore 6
    //   6136: iload 7
    //   6138: istore_3
    //   6139: iload 8
    //   6141: istore 7
    //   6143: goto -4697 -> 1446
    //   6146: astore 34
    //   6148: ldc 77
    //   6150: iconst_1
    //   6151: new 126	java/lang/StringBuilder
    //   6154: dup
    //   6155: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6158: ldc_w 980
    //   6161: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6164: aload 32
    //   6166: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6169: ldc_w 982
    //   6172: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6175: aload 34
    //   6177: invokevirtual 983	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6180: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6183: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6186: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6189: goto -600 -> 5589
    //   6192: astore 34
    //   6194: aload 33
    //   6196: astore 32
    //   6198: iconst_0
    //   6199: istore 8
    //   6201: aload 34
    //   6203: astore 33
    //   6205: iload 4
    //   6207: istore 7
    //   6209: aload 30
    //   6211: astore 34
    //   6213: iload 5
    //   6215: istore 4
    //   6217: iconst_1
    //   6218: istore 14
    //   6220: iload_3
    //   6221: istore 6
    //   6223: iload 7
    //   6225: istore 5
    //   6227: aload 32
    //   6229: astore 30
    //   6231: aload 34
    //   6233: astore 32
    //   6235: iload 8
    //   6237: istore_3
    //   6238: goto -5285 -> 953
    //   6241: lload 19
    //   6243: lstore 21
    //   6245: aload_0
    //   6246: invokevirtual 359	bdvv:b	()Z
    //   6249: istore 14
    //   6251: iload 14
    //   6253: ifeq +85 -> 6338
    //   6256: iconst_1
    //   6257: istore 7
    //   6259: bipush 150
    //   6261: istore 5
    //   6263: aload_0
    //   6264: bipush 150
    //   6266: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6269: iload 5
    //   6271: istore 6
    //   6273: aload 43
    //   6275: ldc_w 985
    //   6278: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6281: pop
    //   6282: iload 7
    //   6284: istore 6
    //   6286: goto -686 -> 5600
    //   6289: astore 34
    //   6291: aload 33
    //   6293: astore 32
    //   6295: bipush 150
    //   6297: istore 7
    //   6299: iconst_1
    //   6300: istore 8
    //   6302: iconst_1
    //   6303: istore 14
    //   6305: aload 34
    //   6307: astore 33
    //   6309: iload 4
    //   6311: istore 5
    //   6313: aload 30
    //   6315: astore 34
    //   6317: iload_3
    //   6318: istore 6
    //   6320: iload 8
    //   6322: istore 4
    //   6324: aload 32
    //   6326: astore 30
    //   6328: aload 34
    //   6330: astore 32
    //   6332: iload 7
    //   6334: istore_3
    //   6335: goto -5382 -> 953
    //   6338: bipush 151
    //   6340: istore 7
    //   6342: lload 19
    //   6344: lstore 21
    //   6346: aload_0
    //   6347: bipush 151
    //   6349: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6352: iload 7
    //   6354: istore 6
    //   6356: aload 36
    //   6358: invokevirtual 298	java/io/File:delete	()Z
    //   6361: pop
    //   6362: iload 7
    //   6364: istore 6
    //   6366: new 67	java/lang/Exception
    //   6369: dup
    //   6370: ldc_w 987
    //   6373: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6376: athrow
    //   6377: astore 35
    //   6379: aload 33
    //   6381: astore 32
    //   6383: bipush 151
    //   6385: istore 8
    //   6387: iload 4
    //   6389: istore 7
    //   6391: aload 30
    //   6393: astore 34
    //   6395: iconst_1
    //   6396: istore 14
    //   6398: iload 5
    //   6400: istore 4
    //   6402: aload 35
    //   6404: astore 33
    //   6406: iload_3
    //   6407: istore 6
    //   6409: iload 7
    //   6411: istore 5
    //   6413: aload 32
    //   6415: astore 30
    //   6417: aload 34
    //   6419: astore 32
    //   6421: iload 8
    //   6423: istore_3
    //   6424: goto -5471 -> 953
    //   6427: sipush 404
    //   6430: iload 8
    //   6432: if_icmpne +2029 -> 8461
    //   6435: iconst_1
    //   6436: istore 5
    //   6438: iconst_1
    //   6439: istore 7
    //   6441: aload_0
    //   6442: iload 8
    //   6444: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6447: lload 17
    //   6449: lstore 21
    //   6451: iload 8
    //   6453: istore 7
    //   6455: aload 32
    //   6457: astore 30
    //   6459: lload 19
    //   6461: lstore 17
    //   6463: lload 21
    //   6465: lstore 19
    //   6467: aload 33
    //   6469: astore 32
    //   6471: goto -843 -> 5628
    //   6474: iload 5
    //   6476: istore 7
    //   6478: aload_0
    //   6479: getfield 280	bdvv:p	Z
    //   6482: ifne +82 -> 6564
    //   6485: iconst_1
    //   6486: istore 13
    //   6488: iconst_1
    //   6489: istore 7
    //   6491: iload 13
    //   6493: istore 5
    //   6495: aload_0
    //   6496: getfield 478	bdvv:r	Z
    //   6499: ifeq +28 -> 6527
    //   6502: iload 13
    //   6504: istore 5
    //   6506: iload 8
    //   6508: sipush 302
    //   6511: if_icmpne +16 -> 6527
    //   6514: iload 13
    //   6516: istore 5
    //   6518: iload 12
    //   6520: iconst_m1
    //   6521: if_icmpne +6 -> 6527
    //   6524: iconst_0
    //   6525: istore 5
    //   6527: iload 5
    //   6529: istore 7
    //   6531: aload_0
    //   6532: iload 8
    //   6534: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6537: lload 17
    //   6539: lstore 21
    //   6541: iload 8
    //   6543: istore 7
    //   6545: aload 32
    //   6547: astore 30
    //   6549: lload 19
    //   6551: lstore 17
    //   6553: lload 21
    //   6555: lstore 19
    //   6557: aload 33
    //   6559: astore 32
    //   6561: goto -933 -> 5628
    //   6564: sipush 304
    //   6567: iload 8
    //   6569: if_icmpne +38 -> 6607
    //   6572: iload 5
    //   6574: istore 7
    //   6576: aload_0
    //   6577: iconst_0
    //   6578: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6581: lload 17
    //   6583: lstore 21
    //   6585: iconst_0
    //   6586: istore 7
    //   6588: aload 32
    //   6590: astore 30
    //   6592: lload 19
    //   6594: lstore 17
    //   6596: lload 21
    //   6598: lstore 19
    //   6600: aload 33
    //   6602: astore 32
    //   6604: goto -976 -> 5628
    //   6607: sipush 416
    //   6610: iload 8
    //   6612: if_icmpne +62 -> 6674
    //   6615: iload 5
    //   6617: istore 7
    //   6619: aload 36
    //   6621: invokevirtual 292	java/io/File:exists	()Z
    //   6624: ifeq +13 -> 6637
    //   6627: iload 5
    //   6629: istore 7
    //   6631: aload 36
    //   6633: invokevirtual 298	java/io/File:delete	()Z
    //   6636: pop
    //   6637: iload 5
    //   6639: istore 7
    //   6641: aload_0
    //   6642: iload 8
    //   6644: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6647: lload 17
    //   6649: lstore 21
    //   6651: iload 8
    //   6653: istore 7
    //   6655: aload 32
    //   6657: astore 30
    //   6659: lload 19
    //   6661: lstore 17
    //   6663: lload 21
    //   6665: lstore 19
    //   6667: aload 33
    //   6669: astore 32
    //   6671: goto -1043 -> 5628
    //   6674: iload 5
    //   6676: istore 7
    //   6678: aload_0
    //   6679: iload 8
    //   6681: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   6684: lload 17
    //   6686: lstore 21
    //   6688: iload 8
    //   6690: istore 7
    //   6692: aload 32
    //   6694: astore 30
    //   6696: lload 19
    //   6698: lstore 17
    //   6700: lload 21
    //   6702: lstore 19
    //   6704: aload 33
    //   6706: astore 32
    //   6708: goto -1080 -> 5628
    //   6711: astore 33
    //   6713: ldc 77
    //   6715: iconst_1
    //   6716: new 126	java/lang/StringBuilder
    //   6719: dup
    //   6720: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6723: ldc_w 989
    //   6726: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6729: aload 29
    //   6731: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6734: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6737: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6740: goto -1039 -> 5701
    //   6743: astore 33
    //   6745: aload 41
    //   6747: monitorexit
    //   6748: iload 5
    //   6750: istore 6
    //   6752: aload 33
    //   6754: athrow
    //   6755: iload 5
    //   6757: istore 6
    //   6759: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   6762: ldc2_w 990
    //   6765: ldiv
    //   6766: l2i
    //   6767: istore 8
    //   6769: iload 5
    //   6771: istore 6
    //   6773: aload_0
    //   6774: getfield 993	bdvv:jdField_c_of_type_Boolean	Z
    //   6777: ifeq +23 -> 6800
    //   6780: iload 5
    //   6782: istore 6
    //   6784: getstatic 42	bdvx:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6787: aload_0
    //   6788: getfield 995	bdvv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6791: iload 8
    //   6793: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6796: invokevirtual 996	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6799: pop
    //   6800: iconst_1
    //   6801: istore 6
    //   6803: new 67	java/lang/Exception
    //   6806: dup
    //   6807: new 126	java/lang/StringBuilder
    //   6810: dup
    //   6811: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6814: ldc_w 998
    //   6817: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6820: aload 29
    //   6822: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6825: ldc_w 1000
    //   6828: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6831: aload_0
    //   6832: getfield 361	bdvv:jdField_e_of_type_Boolean	Z
    //   6835: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6838: ldc_w 1002
    //   6841: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6844: aload_0
    //   6845: getfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   6848: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6851: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6854: invokespecial 319	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6857: athrow
    //   6858: iload 5
    //   6860: istore 6
    //   6862: getstatic 42	bdvx:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6865: aload_0
    //   6866: getfield 995	bdvv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6869: invokevirtual 1005	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6872: pop
    //   6873: goto -1169 -> 5704
    //   6876: iload 7
    //   6878: istore 8
    //   6880: invokestatic 1010	baoc:a	()Lbaoc;
    //   6883: astore 33
    //   6885: aload 33
    //   6887: ifnull -919 -> 5968
    //   6890: iload 7
    //   6892: istore 8
    //   6894: aload 33
    //   6896: aload 39
    //   6898: getfield 1012	apnb:jdField_d_of_type_Int	I
    //   6901: aload 39
    //   6903: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6906: invokevirtual 1014	baoc:a	(ILjava/lang/String;)V
    //   6909: goto -941 -> 5968
    //   6912: iload 7
    //   6914: istore 8
    //   6916: aload_0
    //   6917: iconst_1
    //   6918: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   6921: goto -925 -> 5996
    //   6924: astore 34
    //   6926: iload 7
    //   6928: istore 8
    //   6930: ldc 77
    //   6932: iconst_1
    //   6933: new 126	java/lang/StringBuilder
    //   6936: dup
    //   6937: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6940: ldc_w 1016
    //   6943: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6946: aload 34
    //   6948: invokevirtual 1017	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6951: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6954: ldc_w 1019
    //   6957: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6960: aload 29
    //   6962: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6965: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6968: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6971: iload 5
    //   6973: istore 8
    //   6975: iconst_1
    //   6976: istore 14
    //   6978: iload 6
    //   6980: istore 5
    //   6982: iload_3
    //   6983: istore 6
    //   6985: iload 7
    //   6987: istore_3
    //   6988: iload 8
    //   6990: istore 7
    //   6992: goto -5546 -> 1446
    //   6995: aload 33
    //   6997: instanceof 1021
    //   7000: ifeq +12 -> 7012
    //   7003: aload_0
    //   7004: bipush 144
    //   7006: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7009: goto -6012 -> 997
    //   7012: aload 33
    //   7014: instanceof 321
    //   7017: ifne +11 -> 7028
    //   7020: aload 33
    //   7022: instanceof 323
    //   7025: ifeq +12 -> 7037
    //   7028: aload_0
    //   7029: bipush 143
    //   7031: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7034: goto -6037 -> 997
    //   7037: aload 33
    //   7039: instanceof 325
    //   7042: ifeq +12 -> 7054
    //   7045: aload_0
    //   7046: bipush 142
    //   7048: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7051: goto -6054 -> 997
    //   7054: aload_0
    //   7055: getfield 121	bdvv:jdField_a_of_type_Int	I
    //   7058: ifne -6061 -> 997
    //   7061: aload_0
    //   7062: bipush 141
    //   7064: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7067: goto -6070 -> 997
    //   7070: aload_0
    //   7071: iconst_0
    //   7072: putfield 333	bdvv:jdField_f_of_type_Boolean	Z
    //   7075: goto -6049 -> 1026
    //   7078: iload_3
    //   7079: istore 8
    //   7081: invokestatic 1010	baoc:a	()Lbaoc;
    //   7084: astore 33
    //   7086: aload 33
    //   7088: ifnull -5814 -> 1274
    //   7091: iload_3
    //   7092: istore 8
    //   7094: aload 33
    //   7096: aload 39
    //   7098: getfield 1012	apnb:jdField_d_of_type_Int	I
    //   7101: aload 39
    //   7103: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7106: invokevirtual 1014	baoc:a	(ILjava/lang/String;)V
    //   7109: goto -5835 -> 1274
    //   7112: iload_3
    //   7113: istore 8
    //   7115: aload_0
    //   7116: iconst_1
    //   7117: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   7120: goto -5820 -> 1300
    //   7123: astore 34
    //   7125: iload_3
    //   7126: istore 8
    //   7128: ldc 77
    //   7130: iconst_1
    //   7131: new 126	java/lang/StringBuilder
    //   7134: dup
    //   7135: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7138: ldc_w 1016
    //   7141: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7144: aload 34
    //   7146: invokevirtual 1017	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7149: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7152: ldc_w 1019
    //   7155: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7158: aload 29
    //   7160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7163: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7166: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7169: iload 7
    //   7171: istore 8
    //   7173: lload 17
    //   7175: lstore 21
    //   7177: iload 5
    //   7179: istore 12
    //   7181: iload 4
    //   7183: istore 7
    //   7185: lload 19
    //   7187: lstore 17
    //   7189: iload 8
    //   7191: istore 5
    //   7193: lload 21
    //   7195: lstore 19
    //   7197: iload 12
    //   7199: istore 4
    //   7201: goto -5755 -> 1446
    //   7204: iload 6
    //   7206: istore 4
    //   7208: invokestatic 1010	baoc:a	()Lbaoc;
    //   7211: astore 30
    //   7213: aload 30
    //   7215: ifnull -4735 -> 2480
    //   7218: iload 6
    //   7220: istore 4
    //   7222: aload 30
    //   7224: aload 39
    //   7226: getfield 1012	apnb:jdField_d_of_type_Int	I
    //   7229: aload 39
    //   7231: getfield 377	apnb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7234: invokevirtual 1014	baoc:a	(ILjava/lang/String;)V
    //   7237: goto -4757 -> 2480
    //   7240: iload 6
    //   7242: istore 4
    //   7244: aload_0
    //   7245: iconst_1
    //   7246: putfield 382	bdvv:jdField_d_of_type_Boolean	Z
    //   7249: goto -4741 -> 2508
    //   7252: astore_0
    //   7253: iload 6
    //   7255: istore 4
    //   7257: ldc 77
    //   7259: iconst_1
    //   7260: new 126	java/lang/StringBuilder
    //   7263: dup
    //   7264: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7267: ldc_w 1016
    //   7270: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7273: aload_0
    //   7274: invokevirtual 1017	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7277: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7280: ldc_w 1019
    //   7283: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7286: aload 29
    //   7288: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7291: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7294: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7297: goto -4678 -> 2619
    //   7300: iload 4
    //   7302: istore 8
    //   7304: aload_0
    //   7305: bipush 146
    //   7307: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7310: iload 4
    //   7312: istore 8
    //   7314: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7317: ifeq +16 -> 7333
    //   7320: iload 4
    //   7322: istore 8
    //   7324: ldc 77
    //   7326: iconst_2
    //   7327: ldc_w 1023
    //   7330: invokestatic 844	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7333: lconst_0
    //   7334: lstore 19
    //   7336: iconst_m1
    //   7337: istore 6
    //   7339: iconst_m1
    //   7340: istore 4
    //   7342: lconst_0
    //   7343: lstore 17
    //   7345: aload 29
    //   7347: astore 32
    //   7349: iload_3
    //   7350: istore 5
    //   7352: aload 30
    //   7354: astore 29
    //   7356: aload 31
    //   7358: astore 30
    //   7360: aload 32
    //   7362: astore 31
    //   7364: aload 33
    //   7366: astore 32
    //   7368: aload 34
    //   7370: astore 33
    //   7372: iload 4
    //   7374: istore_3
    //   7375: goto -5846 -> 1529
    //   7378: iconst_0
    //   7379: istore 15
    //   7381: goto -5626 -> 1755
    //   7384: iload_3
    //   7385: istore 4
    //   7387: aload_0
    //   7388: getfield 1026	bdvv:o	Z
    //   7391: istore 15
    //   7393: iload 15
    //   7395: iconst_1
    //   7396: if_icmpne +823 -> 8219
    //   7399: iload_3
    //   7400: istore 4
    //   7402: iload 9
    //   7404: ifle +809 -> 8213
    //   7407: iload 4
    //   7409: istore 8
    //   7411: aload_0
    //   7412: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7415: invokeinterface 177 1 0
    //   7420: iconst_1
    //   7421: if_icmple +792 -> 8213
    //   7424: iload 4
    //   7426: istore 8
    //   7428: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7431: ifeq +52 -> 7483
    //   7434: iload 4
    //   7436: istore 8
    //   7438: ldc 77
    //   7440: iconst_2
    //   7441: new 126	java/lang/StringBuilder
    //   7444: dup
    //   7445: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7448: ldc_w 1028
    //   7451: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7454: iload 9
    //   7456: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7459: ldc_w 1030
    //   7462: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7465: aload_0
    //   7466: getfield 171	bdvv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7469: invokeinterface 177 1 0
    //   7474: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7477: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7480: invokestatic 844	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7483: iload 4
    //   7485: istore 8
    //   7487: aload_0
    //   7488: bipush 148
    //   7490: putfield 121	bdvv:jdField_a_of_type_Int	I
    //   7493: iconst_m1
    //   7494: istore_3
    //   7495: iload_3
    //   7496: istore 5
    //   7498: aload_0
    //   7499: invokevirtual 359	bdvv:b	()Z
    //   7502: ifeq +43 -> 7545
    //   7505: iload_3
    //   7506: istore 5
    //   7508: aload_0
    //   7509: getfield 1032	bdvv:jdField_i_of_type_Boolean	Z
    //   7512: ifne +33 -> 7545
    //   7515: iload_3
    //   7516: istore 4
    //   7518: iload_3
    //   7519: istore 5
    //   7521: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7524: ifeq -4882 -> 2642
    //   7527: iload_3
    //   7528: istore 5
    //   7530: ldc 77
    //   7532: iconst_2
    //   7533: ldc_w 1034
    //   7536: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7539: iload_3
    //   7540: istore 4
    //   7542: goto -4900 -> 2642
    //   7545: iload_3
    //   7546: istore 5
    //   7548: aload_0
    //   7549: invokevirtual 359	bdvv:b	()Z
    //   7552: ifeq +1053 -> 8605
    //   7555: iload_3
    //   7556: istore 5
    //   7558: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7561: ifeq +15 -> 7576
    //   7564: iload_3
    //   7565: istore 5
    //   7567: ldc 77
    //   7569: iconst_2
    //   7570: ldc_w 1036
    //   7573: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7576: iload_3
    //   7577: istore 5
    //   7579: aload_0
    //   7580: iconst_2
    //   7581: invokevirtual 1039	bdvv:a	(I)V
    //   7584: iload_3
    //   7585: istore 5
    //   7587: aload_0
    //   7588: invokevirtual 1041	bdvv:c	()V
    //   7591: iload_3
    //   7592: istore 5
    //   7594: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7597: ifeq +15 -> 7612
    //   7600: iload_3
    //   7601: istore 5
    //   7603: ldc 77
    //   7605: iconst_2
    //   7606: ldc_w 1043
    //   7609: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7612: iload_3
    //   7613: istore 5
    //   7615: aload_0
    //   7616: invokevirtual 124	bdvv:e	()V
    //   7619: iload_3
    //   7620: istore 4
    //   7622: goto -4980 -> 2642
    //   7625: iload_3
    //   7626: istore 5
    //   7628: aload_0
    //   7629: iload 4
    //   7631: invokevirtual 1039	bdvv:a	(I)V
    //   7634: goto -43 -> 7591
    //   7637: iconst_m1
    //   7638: istore 4
    //   7640: goto -15 -> 7625
    //   7643: astore_0
    //   7644: iconst_m1
    //   7645: istore_3
    //   7646: goto -5017 -> 2629
    //   7649: astore 32
    //   7651: goto -5606 -> 2045
    //   7654: astore_1
    //   7655: aload 35
    //   7657: astore 29
    //   7659: goto -5388 -> 2271
    //   7662: astore_1
    //   7663: aload 30
    //   7665: astore 33
    //   7667: goto -5396 -> 2271
    //   7670: astore_1
    //   7671: aload 33
    //   7673: astore 32
    //   7675: aload 30
    //   7677: astore 33
    //   7679: goto -5408 -> 2271
    //   7682: astore_1
    //   7683: aload 32
    //   7685: astore 31
    //   7687: aload 33
    //   7689: astore 32
    //   7691: aload 30
    //   7693: astore 33
    //   7695: goto -5424 -> 2271
    //   7698: astore_1
    //   7699: aload 33
    //   7701: astore 32
    //   7703: aload 30
    //   7705: astore 33
    //   7707: goto -5436 -> 2271
    //   7710: astore_1
    //   7711: iconst_0
    //   7712: istore 6
    //   7714: aload 33
    //   7716: astore 32
    //   7718: aload 30
    //   7720: astore 33
    //   7722: goto -5451 -> 2271
    //   7725: astore_1
    //   7726: aload 33
    //   7728: astore 32
    //   7730: aload 30
    //   7732: astore 33
    //   7734: goto -5463 -> 2271
    //   7737: astore 29
    //   7739: aload 33
    //   7741: astore 35
    //   7743: iconst_0
    //   7744: istore 14
    //   7746: aload 32
    //   7748: astore 30
    //   7750: iload 6
    //   7752: istore 8
    //   7754: aload 29
    //   7756: astore 33
    //   7758: aload 34
    //   7760: astore 29
    //   7762: iload 7
    //   7764: istore 6
    //   7766: iload_3
    //   7767: istore 5
    //   7769: aload 35
    //   7771: astore 32
    //   7773: iload 8
    //   7775: istore_3
    //   7776: goto -6823 -> 953
    //   7779: astore 30
    //   7781: iconst_1
    //   7782: istore 8
    //   7784: aload 33
    //   7786: astore 34
    //   7788: iconst_0
    //   7789: istore 14
    //   7791: aload 30
    //   7793: astore 33
    //   7795: iload 5
    //   7797: istore 4
    //   7799: aload 32
    //   7801: astore 30
    //   7803: iload 6
    //   7805: istore 7
    //   7807: iload 8
    //   7809: istore 6
    //   7811: iload_3
    //   7812: istore 5
    //   7814: aload 34
    //   7816: astore 32
    //   7818: iload 7
    //   7820: istore_3
    //   7821: goto -6868 -> 953
    //   7824: astore 35
    //   7826: iload_3
    //   7827: istore 7
    //   7829: iload 4
    //   7831: istore_3
    //   7832: iconst_0
    //   7833: istore 14
    //   7835: aload 33
    //   7837: astore 34
    //   7839: iload 5
    //   7841: istore 4
    //   7843: aload 32
    //   7845: astore 30
    //   7847: iload 6
    //   7849: istore 8
    //   7851: aload 35
    //   7853: astore 33
    //   7855: iload 7
    //   7857: istore 6
    //   7859: iload_3
    //   7860: istore 5
    //   7862: aload 34
    //   7864: astore 32
    //   7866: iload 8
    //   7868: istore_3
    //   7869: goto -6916 -> 953
    //   7872: astore 33
    //   7874: iconst_1
    //   7875: istore 14
    //   7877: iload 4
    //   7879: istore 7
    //   7881: aload 30
    //   7883: astore 34
    //   7885: iload 6
    //   7887: istore 8
    //   7889: iload_3
    //   7890: istore 6
    //   7892: iload 5
    //   7894: istore 4
    //   7896: iload 7
    //   7898: istore 5
    //   7900: aload 32
    //   7902: astore 30
    //   7904: aload 34
    //   7906: astore 32
    //   7908: iload 8
    //   7910: istore_3
    //   7911: goto -6958 -> 953
    //   7914: astore 33
    //   7916: iload 6
    //   7918: istore 8
    //   7920: iload 4
    //   7922: istore 5
    //   7924: aload 30
    //   7926: astore 34
    //   7928: iconst_1
    //   7929: istore 14
    //   7931: iload 7
    //   7933: istore 4
    //   7935: lload 21
    //   7937: lstore 17
    //   7939: iload_3
    //   7940: istore 6
    //   7942: aload 32
    //   7944: astore 30
    //   7946: aload 34
    //   7948: astore 32
    //   7950: iload 8
    //   7952: istore_3
    //   7953: goto -7000 -> 953
    //   7956: astore 35
    //   7958: aload 33
    //   7960: astore 32
    //   7962: iload 6
    //   7964: istore 7
    //   7966: iload 4
    //   7968: istore 8
    //   7970: aload 30
    //   7972: astore 34
    //   7974: iconst_1
    //   7975: istore 14
    //   7977: iload 5
    //   7979: istore 4
    //   7981: aload 35
    //   7983: astore 33
    //   7985: iload_3
    //   7986: istore 6
    //   7988: iload 8
    //   7990: istore 5
    //   7992: aload 32
    //   7994: astore 30
    //   7996: aload 34
    //   7998: astore 32
    //   8000: iload 7
    //   8002: istore_3
    //   8003: goto -7050 -> 953
    //   8006: astore 35
    //   8008: aload 33
    //   8010: astore 31
    //   8012: iload 6
    //   8014: istore 7
    //   8016: iload 4
    //   8018: istore 8
    //   8020: aload 30
    //   8022: astore 34
    //   8024: iload 5
    //   8026: istore 4
    //   8028: iconst_1
    //   8029: istore 14
    //   8031: aload 35
    //   8033: astore 33
    //   8035: iload_3
    //   8036: istore 6
    //   8038: iload 8
    //   8040: istore 5
    //   8042: aload 31
    //   8044: astore 30
    //   8046: aload 32
    //   8048: astore 31
    //   8050: aload 34
    //   8052: astore 32
    //   8054: iload 7
    //   8056: istore_3
    //   8057: goto -7104 -> 953
    //   8060: astore 35
    //   8062: aload 33
    //   8064: astore 32
    //   8066: iload 6
    //   8068: istore 7
    //   8070: iload 4
    //   8072: istore 8
    //   8074: aload 30
    //   8076: astore 34
    //   8078: iconst_1
    //   8079: istore 14
    //   8081: iload 5
    //   8083: istore 4
    //   8085: aload 35
    //   8087: astore 33
    //   8089: iload_3
    //   8090: istore 6
    //   8092: iload 8
    //   8094: istore 5
    //   8096: aload 32
    //   8098: astore 30
    //   8100: aload 34
    //   8102: astore 32
    //   8104: iload 7
    //   8106: istore_3
    //   8107: goto -7154 -> 953
    //   8110: astore 35
    //   8112: lload 21
    //   8114: lstore 19
    //   8116: aload 33
    //   8118: astore 32
    //   8120: iload 6
    //   8122: istore 7
    //   8124: iload 4
    //   8126: istore 8
    //   8128: aload 30
    //   8130: astore 34
    //   8132: iconst_1
    //   8133: istore 14
    //   8135: iload 5
    //   8137: istore 4
    //   8139: aload 35
    //   8141: astore 33
    //   8143: iload_3
    //   8144: istore 6
    //   8146: iload 8
    //   8148: istore 5
    //   8150: aload 32
    //   8152: astore 30
    //   8154: aload 34
    //   8156: astore 32
    //   8158: iload 7
    //   8160: istore_3
    //   8161: goto -7208 -> 953
    //   8164: astore 34
    //   8166: aload 33
    //   8168: astore 32
    //   8170: iload 6
    //   8172: istore 7
    //   8174: iconst_1
    //   8175: istore 8
    //   8177: iconst_1
    //   8178: istore 14
    //   8180: aload 34
    //   8182: astore 33
    //   8184: iload 4
    //   8186: istore 5
    //   8188: aload 30
    //   8190: astore 34
    //   8192: iload_3
    //   8193: istore 6
    //   8195: iload 8
    //   8197: istore 4
    //   8199: aload 32
    //   8201: astore 30
    //   8203: aload 34
    //   8205: astore 32
    //   8207: iload 7
    //   8209: istore_3
    //   8210: goto -7257 -> 953
    //   8213: iload 4
    //   8215: istore_3
    //   8216: goto -721 -> 7495
    //   8219: iload 9
    //   8221: istore 4
    //   8223: goto -6168 -> 2055
    //   8226: aload 37
    //   8228: astore 34
    //   8230: goto -6677 -> 1553
    //   8233: goto -3321 -> 4912
    //   8236: iload 7
    //   8238: istore 4
    //   8240: goto -4390 -> 3850
    //   8243: iload_3
    //   8244: istore 4
    //   8246: iload 7
    //   8248: istore_3
    //   8249: goto -4389 -> 3860
    //   8252: iload 8
    //   8254: istore 5
    //   8256: goto -5244 -> 3012
    //   8259: aload 32
    //   8261: astore 33
    //   8263: iload_3
    //   8264: istore 8
    //   8266: iload 4
    //   8268: istore_3
    //   8269: lload 19
    //   8271: lstore 21
    //   8273: iload 6
    //   8275: istore 7
    //   8277: lload 17
    //   8279: lstore 19
    //   8281: lload 21
    //   8283: lstore 17
    //   8285: aload 30
    //   8287: astore 32
    //   8289: iload 8
    //   8291: istore 6
    //   8293: iload 5
    //   8295: istore 12
    //   8297: goto -7668 -> 629
    //   8300: iconst_m1
    //   8301: istore_3
    //   8302: iload_3
    //   8303: ireturn
    //   8304: iconst_m1
    //   8305: ireturn
    //   8306: ldc_w 849
    //   8309: astore 29
    //   8311: goto -8124 -> 187
    //   8314: iconst_1
    //   8315: istore 7
    //   8317: goto -7334 -> 983
    //   8320: iload_3
    //   8321: ifne -943 -> 7378
    //   8324: iconst_1
    //   8325: istore 15
    //   8327: goto -6572 -> 1755
    //   8330: astore_1
    //   8331: goto -6060 -> 2271
    //   8334: aload 34
    //   8336: astore 32
    //   8338: iload 8
    //   8340: bipush 12
    //   8342: if_icmple -3352 -> 4990
    //   8345: aload 34
    //   8347: astore 32
    //   8349: bipush 82
    //   8351: aload 44
    //   8353: iconst_0
    //   8354: baload
    //   8355: if_icmpne -3365 -> 4990
    //   8358: aload 34
    //   8360: astore 32
    //   8362: bipush 73
    //   8364: aload 44
    //   8366: iconst_1
    //   8367: baload
    //   8368: if_icmpne -3378 -> 4990
    //   8371: aload 34
    //   8373: astore 32
    //   8375: bipush 70
    //   8377: aload 44
    //   8379: iconst_2
    //   8380: baload
    //   8381: if_icmpne -3391 -> 4990
    //   8384: aload 34
    //   8386: astore 32
    //   8388: bipush 70
    //   8390: aload 44
    //   8392: iconst_3
    //   8393: baload
    //   8394: if_icmpne -3404 -> 4990
    //   8397: aload 34
    //   8399: astore 32
    //   8401: bipush 87
    //   8403: aload 44
    //   8405: bipush 8
    //   8407: baload
    //   8408: if_icmpne -3418 -> 4990
    //   8411: aload 34
    //   8413: astore 32
    //   8415: bipush 69
    //   8417: aload 44
    //   8419: bipush 9
    //   8421: baload
    //   8422: if_icmpne -3432 -> 4990
    //   8425: aload 34
    //   8427: astore 32
    //   8429: bipush 66
    //   8431: aload 44
    //   8433: bipush 10
    //   8435: baload
    //   8436: if_icmpne -3446 -> 4990
    //   8439: aload 34
    //   8441: astore 32
    //   8443: bipush 80
    //   8445: aload 44
    //   8447: bipush 11
    //   8449: baload
    //   8450: if_icmpne -3460 -> 4990
    //   8453: ldc_w 1045
    //   8456: astore 32
    //   8458: goto -3468 -> 4990
    //   8461: sipush 302
    //   8464: iload 8
    //   8466: if_icmpeq -1992 -> 6474
    //   8469: sipush 301
    //   8472: iload 8
    //   8474: if_icmpne -1910 -> 6564
    //   8477: goto -2003 -> 6474
    //   8480: astore 33
    //   8482: iconst_1
    //   8483: istore 14
    //   8485: iload 4
    //   8487: istore 5
    //   8489: lload 19
    //   8491: lstore 21
    //   8493: iload 6
    //   8495: istore 4
    //   8497: iload_3
    //   8498: istore 6
    //   8500: lload 17
    //   8502: lstore 19
    //   8504: lload 21
    //   8506: lstore 17
    //   8508: iload 7
    //   8510: istore_3
    //   8511: goto -7558 -> 953
    //   8514: astore_1
    //   8515: aload 32
    //   8517: astore 33
    //   8519: iload 7
    //   8521: istore 6
    //   8523: aload 30
    //   8525: astore 32
    //   8527: goto -6256 -> 2271
    //   8530: astore_0
    //   8531: iload 8
    //   8533: istore_3
    //   8534: goto -5905 -> 2629
    //   8537: ldc_w 1047
    //   8540: astore 33
    //   8542: goto -2516 -> 6026
    //   8545: ldc_w 1049
    //   8548: astore 33
    //   8550: goto -2494 -> 6056
    //   8553: astore_1
    //   8554: aload 32
    //   8556: astore 33
    //   8558: aload 30
    //   8560: astore 32
    //   8562: iload_3
    //   8563: istore 6
    //   8565: goto -6294 -> 2271
    //   8568: ldc_w 1047
    //   8571: astore 33
    //   8573: goto -7245 -> 1328
    //   8576: ldc_w 1049
    //   8579: astore 33
    //   8581: goto -7225 -> 1356
    //   8584: ldc_w 1047
    //   8587: astore_0
    //   8588: goto -6052 -> 2536
    //   8591: ldc_w 1049
    //   8594: astore_0
    //   8595: goto -6033 -> 2562
    //   8598: astore_0
    //   8599: iload 5
    //   8601: istore_3
    //   8602: goto -5973 -> 2629
    //   8605: iload_3
    //   8606: ifne -969 -> 7637
    //   8609: iconst_3
    //   8610: istore 4
    //   8612: goto -987 -> 7625
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8615	0	parambdvv	bdvv
    //   0	8615	1	paramString	String
    //   0	8615	2	paramContext	Context
    //   16	8590	3	i	int
    //   63	8548	4	j	int
    //   70	8530	5	k	int
    //   612	7952	6	m	int
    //   606	7914	7	n	int
    //   307	8225	8	i1	int
    //   281	7939	9	i2	int
    //   298	5517	10	i3	int
    //   301	4816	11	i4	int
    //   609	7687	12	i5	int
    //   700	5815	13	i6	int
    //   284	8200	14	bool1	boolean
    //   1474	6852	15	bool2	boolean
    //   1774	3	16	bool3	boolean
    //   353	8154	17	l1	long
    //   615	7888	19	l2	long
    //   1424	7081	21	l3	long
    //   4369	1005	23	l4	long
    //   337	1696	25	l5	long
    //   636	5227	27	l6	long
    //   185	7473	29	localObject1	Object
    //   7737	18	29	localThrowable1	java.lang.Throwable
    //   7760	550	29	localObject2	Object
    //   203	7546	30	localObject3	Object
    //   7779	13	30	localThrowable2	java.lang.Throwable
    //   7801	758	30	localObject4	Object
    //   200	7849	31	localObject5	Object
    //   553	6814	32	localObject6	Object
    //   7649	1	32	localThrowable3	java.lang.Throwable
    //   7673	888	32	localObject7	Object
    //   386	4061	33	localObject8	Object
    //   4643	1	33	localThrowable4	java.lang.Throwable
    //   4791	1914	33	localObject9	Object
    //   6711	1	33	localInterruptedException	java.lang.InterruptedException
    //   6743	10	33	localObject10	Object
    //   6883	971	33	localObject11	Object
    //   7872	1	33	localThrowable5	java.lang.Throwable
    //   7914	45	33	localThrowable6	java.lang.Throwable
    //   7983	279	33	localObject12	Object
    //   8480	1	33	localThrowable7	java.lang.Throwable
    //   8517	63	33	localObject13	Object
    //   478	353	34	localObject14	Object
    //   914	36	34	localThrowable8	java.lang.Throwable
    //   1310	2926	34	localObject15	Object
    //   4249	22	34	localThrowable9	java.lang.Throwable
    //   4431	1630	34	localObject16	Object
    //   6146	30	34	localException	java.lang.Exception
    //   6192	10	34	localThrowable10	java.lang.Throwable
    //   6211	21	34	localObject17	Object
    //   6289	17	34	localThrowable11	java.lang.Throwable
    //   6315	103	34	localObject18	Object
    //   6924	23	34	localIOException1	java.io.IOException
    //   7123	636	34	localIOException2	java.io.IOException
    //   7786	369	34	localObject19	Object
    //   8164	17	34	localThrowable12	java.lang.Throwable
    //   8190	250	34	localObject20	Object
    //   704	2355	35	localObject21	Object
    //   3121	22	35	localThrowable13	java.lang.Throwable
    //   3165	2558	35	localObject22	Object
    //   6377	1279	35	localThrowable14	java.lang.Throwable
    //   7741	29	35	localObject23	Object
    //   7824	28	35	localThrowable15	java.lang.Throwable
    //   7956	26	35	localThrowable16	java.lang.Throwable
    //   8006	26	35	localThrowable17	java.lang.Throwable
    //   8060	26	35	localThrowable18	java.lang.Throwable
    //   8110	30	35	localThrowable19	java.lang.Throwable
    //   549	6083	36	localFile1	java.io.File
    //   366	7861	37	localHashMap	java.util.HashMap
    //   474	5504	38	localFile2	java.io.File
    //   599	6631	39	localapnb	apnb
    //   141	3757	40	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   350	6396	41	localObject24	Object
    //   494	1611	42	localFile3	java.io.File
    //   691	5583	43	localStringBuilder	java.lang.StringBuilder
    //   2197	6249	44	localObject25	Object
    //   3068	34	45	str1	String
    //   3082	31	46	str2	String
    // Exception table:
    //   from	to	target	type
    //   850	891	914	java/lang/Throwable
    //   903	914	914	java/lang/Throwable
    //   2238	2247	914	java/lang/Throwable
    //   2259	2270	914	java/lang/Throwable
    //   850	891	2270	finally
    //   903	914	2270	finally
    //   2238	2247	2270	finally
    //   2259	2270	2270	finally
    //   633	638	2625	java/lang/Throwable
    //   642	693	2625	java/lang/Throwable
    //   1532	1536	2625	java/lang/Throwable
    //   1544	1553	2625	java/lang/Throwable
    //   1556	1567	2625	java/lang/Throwable
    //   1570	1586	2625	java/lang/Throwable
    //   1589	1605	2625	java/lang/Throwable
    //   1608	1622	2625	java/lang/Throwable
    //   1625	1639	2625	java/lang/Throwable
    //   1642	1663	2625	java/lang/Throwable
    //   1666	1679	2625	java/lang/Throwable
    //   1682	1696	2625	java/lang/Throwable
    //   1699	1710	2625	java/lang/Throwable
    //   1717	1727	2625	java/lang/Throwable
    //   1730	1743	2625	java/lang/Throwable
    //   1746	1752	2625	java/lang/Throwable
    //   1758	1763	2625	java/lang/Throwable
    //   1770	1776	2625	java/lang/Throwable
    //   2275	2314	2625	java/lang/Throwable
    //   2318	2326	2625	java/lang/Throwable
    //   2335	2387	2625	java/lang/Throwable
    //   2396	2403	2625	java/lang/Throwable
    //   2407	2414	2625	java/lang/Throwable
    //   2418	2426	2625	java/lang/Throwable
    //   2430	2441	2625	java/lang/Throwable
    //   2445	2480	2625	java/lang/Throwable
    //   2484	2499	2625	java/lang/Throwable
    //   2503	2508	2625	java/lang/Throwable
    //   2512	2520	2625	java/lang/Throwable
    //   2524	2532	2625	java/lang/Throwable
    //   2540	2546	2625	java/lang/Throwable
    //   2550	2558	2625	java/lang/Throwable
    //   2566	2575	2625	java/lang/Throwable
    //   2584	2591	2625	java/lang/Throwable
    //   2600	2605	2625	java/lang/Throwable
    //   2614	2619	2625	java/lang/Throwable
    //   2623	2625	2625	java/lang/Throwable
    //   7208	7213	2625	java/lang/Throwable
    //   7222	7237	2625	java/lang/Throwable
    //   7244	7249	2625	java/lang/Throwable
    //   7257	7297	2625	java/lang/Throwable
    //   7387	7393	2625	java/lang/Throwable
    //   3012	3029	3121	java/lang/Throwable
    //   3034	3048	3121	java/lang/Throwable
    //   3048	3118	3121	java/lang/Throwable
    //   3206	3251	3121	java/lang/Throwable
    //   3251	3409	3121	java/lang/Throwable
    //   3414	3491	3121	java/lang/Throwable
    //   3491	3505	3121	java/lang/Throwable
    //   3510	3533	3121	java/lang/Throwable
    //   3540	3614	3121	java/lang/Throwable
    //   3614	3722	3121	java/lang/Throwable
    //   3722	3755	3121	java/lang/Throwable
    //   3755	3780	3121	java/lang/Throwable
    //   3790	3812	3121	java/lang/Throwable
    //   4287	4302	3121	java/lang/Throwable
    //   4305	4312	3121	java/lang/Throwable
    //   3936	3950	4249	java/lang/Throwable
    //   3954	3960	4249	java/lang/Throwable
    //   3964	3971	4249	java/lang/Throwable
    //   3975	4009	4249	java/lang/Throwable
    //   4013	4022	4249	java/lang/Throwable
    //   4026	4036	4249	java/lang/Throwable
    //   4040	4049	4249	java/lang/Throwable
    //   4053	4062	4249	java/lang/Throwable
    //   4066	4077	4249	java/lang/Throwable
    //   4081	4092	4249	java/lang/Throwable
    //   4096	4107	4249	java/lang/Throwable
    //   4111	4122	4249	java/lang/Throwable
    //   4126	4137	4249	java/lang/Throwable
    //   4141	4152	4249	java/lang/Throwable
    //   4156	4167	4249	java/lang/Throwable
    //   4171	4182	4249	java/lang/Throwable
    //   4186	4197	4249	java/lang/Throwable
    //   4201	4212	4249	java/lang/Throwable
    //   4216	4246	4249	java/lang/Throwable
    //   4353	4362	4249	java/lang/Throwable
    //   6441	6447	4249	java/lang/Throwable
    //   6478	6485	4249	java/lang/Throwable
    //   6495	6502	4249	java/lang/Throwable
    //   6531	6537	4249	java/lang/Throwable
    //   6576	6581	4249	java/lang/Throwable
    //   6619	6627	4249	java/lang/Throwable
    //   6631	6637	4249	java/lang/Throwable
    //   6641	6647	4249	java/lang/Throwable
    //   6678	6684	4249	java/lang/Throwable
    //   4604	4620	4643	java/lang/Throwable
    //   4632	4643	4643	java/lang/Throwable
    //   4773	4784	4643	java/lang/Throwable
    //   4604	4620	4784	finally
    //   4632	4643	4784	finally
    //   4773	4784	4784	finally
    //   5476	5589	6146	java/lang/Exception
    //   5390	5404	6192	java/lang/Throwable
    //   5404	5471	6192	java/lang/Throwable
    //   5476	5589	6192	java/lang/Throwable
    //   6148	6189	6192	java/lang/Throwable
    //   6273	6282	6289	java/lang/Throwable
    //   6356	6362	6377	java/lang/Throwable
    //   6366	6377	6377	java/lang/Throwable
    //   5694	5701	6711	java/lang/InterruptedException
    //   5694	5701	6743	finally
    //   5701	5704	6743	finally
    //   6713	6740	6743	finally
    //   6745	6748	6743	finally
    //   6087	6094	6924	java/io/IOException
    //   6103	6108	6924	java/io/IOException
    //   6117	6122	6924	java/io/IOException
    //   1385	1392	7123	java/io/IOException
    //   1400	1405	7123	java/io/IOException
    //   1413	1418	7123	java/io/IOException
    //   2584	2591	7252	java/io/IOException
    //   2600	2605	7252	java/io/IOException
    //   2614	2619	7252	java/io/IOException
    //   83	131	7643	java/lang/Throwable
    //   134	183	7643	java/lang/Throwable
    //   187	199	7643	java/lang/Throwable
    //   209	228	7643	java/lang/Throwable
    //   228	269	7643	java/lang/Throwable
    //   272	283	7643	java/lang/Throwable
    //   286	291	7643	java/lang/Throwable
    //   1781	1872	7649	java/lang/Throwable
    //   1877	1948	7649	java/lang/Throwable
    //   1957	1967	7649	java/lang/Throwable
    //   1971	1984	7649	java/lang/Throwable
    //   1989	2021	7649	java/lang/Throwable
    //   2021	2045	7649	java/lang/Throwable
    //   714	719	7654	finally
    //   739	747	7654	finally
    //   759	766	7654	finally
    //   788	794	7654	finally
    //   806	814	7654	finally
    //   832	838	7654	finally
    //   2150	2156	7654	finally
    //   2168	2182	7654	finally
    //   2194	2199	7654	finally
    //   2220	2226	7654	finally
    //   2697	2704	7654	finally
    //   2720	2731	7654	finally
    //   2743	2763	7654	finally
    //   2775	2783	7654	finally
    //   2795	2823	7654	finally
    //   2835	2842	7654	finally
    //   2854	2860	7654	finally
    //   2872	2899	7654	finally
    //   2911	2921	7654	finally
    //   2938	2945	7654	finally
    //   2957	2968	7654	finally
    //   2980	2985	7654	finally
    //   2999	3012	7654	finally
    //   3175	3203	7654	finally
    //   4362	4371	7662	finally
    //   4379	4393	7662	finally
    //   4401	4413	7662	finally
    //   4421	4433	7662	finally
    //   4446	4467	7662	finally
    //   4475	4482	7662	finally
    //   4490	4515	7662	finally
    //   4523	4530	7662	finally
    //   4545	4554	7662	finally
    //   4562	4572	7662	finally
    //   4586	4592	7662	finally
    //   4702	4715	7662	finally
    //   4741	4747	7662	finally
    //   4759	4765	7662	finally
    //   4814	4834	7662	finally
    //   4834	4886	7670	finally
    //   5141	5150	7670	finally
    //   4886	4895	7682	finally
    //   4899	4909	7698	finally
    //   4916	4923	7698	finally
    //   4927	4936	7698	finally
    //   4946	4952	7698	finally
    //   4999	5013	7698	finally
    //   5017	5027	7698	finally
    //   5061	5070	7698	finally
    //   5074	5084	7698	finally
    //   5088	5099	7698	finally
    //   5111	5121	7698	finally
    //   5125	5129	7698	finally
    //   5250	5255	7698	finally
    //   5259	5267	7698	finally
    //   5271	5278	7698	finally
    //   5282	5296	7698	finally
    //   5315	5322	7698	finally
    //   5333	5346	7698	finally
    //   5350	5373	7698	finally
    //   5385	5390	7698	finally
    //   6245	6251	7698	finally
    //   6263	6269	7698	finally
    //   6346	6352	7698	finally
    //   5390	5404	7710	finally
    //   5404	5471	7710	finally
    //   5476	5589	7710	finally
    //   6148	6189	7710	finally
    //   6273	6282	7725	finally
    //   6356	6362	7725	finally
    //   6366	6377	7725	finally
    //   714	719	7737	java/lang/Throwable
    //   739	747	7737	java/lang/Throwable
    //   759	766	7737	java/lang/Throwable
    //   788	794	7737	java/lang/Throwable
    //   806	814	7737	java/lang/Throwable
    //   832	838	7737	java/lang/Throwable
    //   2150	2156	7737	java/lang/Throwable
    //   2168	2182	7737	java/lang/Throwable
    //   2194	2199	7737	java/lang/Throwable
    //   2220	2226	7737	java/lang/Throwable
    //   2697	2704	7737	java/lang/Throwable
    //   2720	2731	7737	java/lang/Throwable
    //   2743	2763	7737	java/lang/Throwable
    //   2775	2783	7737	java/lang/Throwable
    //   2795	2823	7737	java/lang/Throwable
    //   2835	2842	7737	java/lang/Throwable
    //   2854	2860	7737	java/lang/Throwable
    //   2872	2899	7737	java/lang/Throwable
    //   2911	2921	7737	java/lang/Throwable
    //   2938	2945	7737	java/lang/Throwable
    //   2957	2968	7737	java/lang/Throwable
    //   2980	2985	7737	java/lang/Throwable
    //   2999	3012	7737	java/lang/Throwable
    //   3175	3203	7737	java/lang/Throwable
    //   3815	3850	7779	java/lang/Throwable
    //   3860	3882	7824	java/lang/Throwable
    //   3882	3909	7824	java/lang/Throwable
    //   3913	3932	7824	java/lang/Throwable
    //   4362	4371	7872	java/lang/Throwable
    //   4379	4393	7914	java/lang/Throwable
    //   4401	4413	7914	java/lang/Throwable
    //   4421	4433	7914	java/lang/Throwable
    //   4446	4467	7914	java/lang/Throwable
    //   4475	4482	7914	java/lang/Throwable
    //   4490	4515	7914	java/lang/Throwable
    //   4523	4530	7914	java/lang/Throwable
    //   4545	4554	7914	java/lang/Throwable
    //   4562	4572	7914	java/lang/Throwable
    //   4586	4592	7914	java/lang/Throwable
    //   4702	4715	7914	java/lang/Throwable
    //   4741	4747	7914	java/lang/Throwable
    //   4759	4765	7914	java/lang/Throwable
    //   4814	4834	7914	java/lang/Throwable
    //   4834	4886	7956	java/lang/Throwable
    //   5141	5150	7956	java/lang/Throwable
    //   4886	4895	8006	java/lang/Throwable
    //   4899	4909	8060	java/lang/Throwable
    //   4916	4923	8110	java/lang/Throwable
    //   4927	4936	8110	java/lang/Throwable
    //   4946	4952	8110	java/lang/Throwable
    //   4999	5013	8110	java/lang/Throwable
    //   5017	5027	8110	java/lang/Throwable
    //   5061	5070	8110	java/lang/Throwable
    //   5074	5084	8110	java/lang/Throwable
    //   5088	5099	8110	java/lang/Throwable
    //   5111	5121	8110	java/lang/Throwable
    //   5125	5129	8110	java/lang/Throwable
    //   5250	5255	8110	java/lang/Throwable
    //   5259	5267	8110	java/lang/Throwable
    //   5271	5278	8110	java/lang/Throwable
    //   5282	5296	8110	java/lang/Throwable
    //   5315	5322	8110	java/lang/Throwable
    //   5333	5346	8110	java/lang/Throwable
    //   5350	5373	8110	java/lang/Throwable
    //   5385	5390	8110	java/lang/Throwable
    //   6245	6251	8110	java/lang/Throwable
    //   6346	6352	8110	java/lang/Throwable
    //   6263	6269	8164	java/lang/Throwable
    //   3012	3029	8330	finally
    //   3034	3048	8330	finally
    //   3048	3118	8330	finally
    //   3206	3251	8330	finally
    //   3251	3409	8330	finally
    //   3414	3491	8330	finally
    //   3491	3505	8330	finally
    //   3510	3533	8330	finally
    //   3540	3614	8330	finally
    //   3614	3722	8330	finally
    //   3722	3755	8330	finally
    //   3755	3780	8330	finally
    //   3790	3812	8330	finally
    //   3815	3850	8330	finally
    //   3860	3882	8330	finally
    //   3882	3909	8330	finally
    //   3913	3932	8330	finally
    //   3936	3950	8330	finally
    //   3954	3960	8330	finally
    //   3964	3971	8330	finally
    //   3975	4009	8330	finally
    //   4013	4022	8330	finally
    //   4026	4036	8330	finally
    //   4040	4049	8330	finally
    //   4053	4062	8330	finally
    //   4066	4077	8330	finally
    //   4081	4092	8330	finally
    //   4096	4107	8330	finally
    //   4111	4122	8330	finally
    //   4126	4137	8330	finally
    //   4141	4152	8330	finally
    //   4156	4167	8330	finally
    //   4171	4182	8330	finally
    //   4186	4197	8330	finally
    //   4201	4212	8330	finally
    //   4216	4246	8330	finally
    //   4287	4302	8330	finally
    //   4305	4312	8330	finally
    //   4353	4362	8330	finally
    //   6441	6447	8330	finally
    //   6478	6485	8330	finally
    //   6495	6502	8330	finally
    //   6531	6537	8330	finally
    //   6576	6581	8330	finally
    //   6619	6627	8330	finally
    //   6631	6637	8330	finally
    //   6641	6647	8330	finally
    //   6678	6684	8330	finally
    //   5632	5638	8480	java/lang/Throwable
    //   5642	5652	8480	java/lang/Throwable
    //   5661	5668	8480	java/lang/Throwable
    //   5672	5681	8480	java/lang/Throwable
    //   5685	5688	8480	java/lang/Throwable
    //   5708	5718	8480	java/lang/Throwable
    //   5722	5734	8480	java/lang/Throwable
    //   5743	5759	8480	java/lang/Throwable
    //   6752	6755	8480	java/lang/Throwable
    //   6759	6769	8480	java/lang/Throwable
    //   6773	6780	8480	java/lang/Throwable
    //   6784	6800	8480	java/lang/Throwable
    //   6803	6858	8480	java/lang/Throwable
    //   6862	6873	8480	java/lang/Throwable
    //   5632	5638	8514	finally
    //   5642	5652	8514	finally
    //   5661	5668	8514	finally
    //   5672	5681	8514	finally
    //   5685	5688	8514	finally
    //   5708	5718	8514	finally
    //   5722	5734	8514	finally
    //   5743	5759	8514	finally
    //   6752	6755	8514	finally
    //   6759	6769	8514	finally
    //   6773	6780	8514	finally
    //   6784	6800	8514	finally
    //   6803	6858	8514	finally
    //   6862	6873	8514	finally
    //   313	327	8530	java/lang/Throwable
    //   334	339	8530	java/lang/Throwable
    //   343	352	8530	java/lang/Throwable
    //   359	368	8530	java/lang/Throwable
    //   372	388	8530	java/lang/Throwable
    //   392	398	8530	java/lang/Throwable
    //   402	410	8530	java/lang/Throwable
    //   419	429	8530	java/lang/Throwable
    //   433	445	8530	java/lang/Throwable
    //   449	456	8530	java/lang/Throwable
    //   460	476	8530	java/lang/Throwable
    //   489	496	8530	java/lang/Throwable
    //   500	507	8530	java/lang/Throwable
    //   511	551	8530	java/lang/Throwable
    //   559	569	8530	java/lang/Throwable
    //   573	584	8530	java/lang/Throwable
    //   588	601	8530	java/lang/Throwable
    //   1077	1116	8530	java/lang/Throwable
    //   1119	1127	8530	java/lang/Throwable
    //   1135	1187	8530	java/lang/Throwable
    //   1194	1201	8530	java/lang/Throwable
    //   1204	1211	8530	java/lang/Throwable
    //   1214	1222	8530	java/lang/Throwable
    //   1225	1236	8530	java/lang/Throwable
    //   1239	1274	8530	java/lang/Throwable
    //   1277	1292	8530	java/lang/Throwable
    //   1295	1300	8530	java/lang/Throwable
    //   1303	1312	8530	java/lang/Throwable
    //   1315	1323	8530	java/lang/Throwable
    //   1331	1340	8530	java/lang/Throwable
    //   1343	1351	8530	java/lang/Throwable
    //   1359	1371	8530	java/lang/Throwable
    //   1385	1392	8530	java/lang/Throwable
    //   1400	1405	8530	java/lang/Throwable
    //   1413	1418	8530	java/lang/Throwable
    //   1458	1467	8530	java/lang/Throwable
    //   1470	1476	8530	java/lang/Throwable
    //   2100	2135	8530	java/lang/Throwable
    //   5763	5802	8530	java/lang/Throwable
    //   5806	5814	8530	java/lang/Throwable
    //   5823	5875	8530	java/lang/Throwable
    //   5884	5891	8530	java/lang/Throwable
    //   5895	5902	8530	java/lang/Throwable
    //   5906	5914	8530	java/lang/Throwable
    //   5918	5929	8530	java/lang/Throwable
    //   5933	5968	8530	java/lang/Throwable
    //   5972	5987	8530	java/lang/Throwable
    //   5991	5996	8530	java/lang/Throwable
    //   6000	6009	8530	java/lang/Throwable
    //   6013	6021	8530	java/lang/Throwable
    //   6030	6039	8530	java/lang/Throwable
    //   6043	6051	8530	java/lang/Throwable
    //   6060	6072	8530	java/lang/Throwable
    //   6087	6094	8530	java/lang/Throwable
    //   6103	6108	8530	java/lang/Throwable
    //   6117	6122	8530	java/lang/Throwable
    //   6880	6885	8530	java/lang/Throwable
    //   6894	6909	8530	java/lang/Throwable
    //   6916	6921	8530	java/lang/Throwable
    //   6930	6971	8530	java/lang/Throwable
    //   7081	7086	8530	java/lang/Throwable
    //   7094	7109	8530	java/lang/Throwable
    //   7115	7120	8530	java/lang/Throwable
    //   7128	7169	8530	java/lang/Throwable
    //   7304	7310	8530	java/lang/Throwable
    //   7314	7320	8530	java/lang/Throwable
    //   7324	7333	8530	java/lang/Throwable
    //   7411	7424	8530	java/lang/Throwable
    //   7428	7434	8530	java/lang/Throwable
    //   7438	7483	8530	java/lang/Throwable
    //   7487	7493	8530	java/lang/Throwable
    //   956	972	8553	finally
    //   972	980	8553	finally
    //   983	997	8553	finally
    //   997	1006	8553	finally
    //   1021	1026	8553	finally
    //   1026	1074	8553	finally
    //   6995	7009	8553	finally
    //   7012	7028	8553	finally
    //   7028	7034	8553	finally
    //   7037	7051	8553	finally
    //   7054	7067	8553	finally
    //   7070	7075	8553	finally
    //   72	76	8598	java/lang/Throwable
    //   79	83	8598	java/lang/Throwable
    //   7498	7505	8598	java/lang/Throwable
    //   7508	7515	8598	java/lang/Throwable
    //   7521	7527	8598	java/lang/Throwable
    //   7530	7539	8598	java/lang/Throwable
    //   7548	7555	8598	java/lang/Throwable
    //   7558	7564	8598	java/lang/Throwable
    //   7567	7576	8598	java/lang/Throwable
    //   7579	7584	8598	java/lang/Throwable
    //   7587	7591	8598	java/lang/Throwable
    //   7594	7600	8598	java/lang/Throwable
    //   7603	7612	8598	java/lang/Throwable
    //   7615	7619	8598	java/lang/Throwable
    //   7628	7634	8598	java/lang/Throwable
  }
  
  public static int a(bdvv parambdvv, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((parambdvv.k) && (!bhlt.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(parambdvv, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(parambdvv, null, null);
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
  
  public static void a(apnb paramapnb)
  {
    if ((paramapnb == null) || (TextUtils.isEmpty(paramapnb.jdField_a_of_type_JavaLangString))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = bavf.a(paramapnb.jdField_a_of_type_JavaLangString);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramapnb.jdField_a_of_type_JavaLangString.startsWith("http"))) {
          break;
        }
        str2 = bavf.a().a(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramapnb.jdField_a_of_type_JavaLangString, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramapnb.jdField_b_of_type_JavaLangString = str3;
        paramapnb.jdField_c_of_type_JavaLangString = str1;
        paramapnb.jdField_d_of_type_JavaLangString = str2;
        paramapnb.jdField_a_of_type_Boolean = true;
        return;
      }
      paramapnb.jdField_b_of_type_JavaLangString = paramapnb.jdField_a_of_type_JavaLangString;
      return;
      HttpDownloadUtil.a(paramapnb);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramapnb.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(bdee.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      azmj.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = bdee.a(paramContext);
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
  
  public static boolean a(bdvv parambdvv)
  {
    if (parambdvv == null) {
      return false;
    }
    if ((parambdvv.jdField_a_of_type_JavaUtilList == null) || (parambdvv.jdField_a_of_type_JavaUtilMap == null) || (parambdvv.jdField_a_of_type_JavaUtilList.size() < 1) || (parambdvv.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(parambdvv.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    parambdvv = parambdvv.jdField_a_of_type_JavaUtilList.iterator();
    while (parambdvv.hasNext())
    {
      String str = (String)parambdvv.next();
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
    //   18: invokevirtual 292	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 292	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1119	java/io/File:listFiles	()[Ljava/io/File;
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
    //   73: invokevirtual 295	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1119	java/io/File:listFiles	()[Ljava/io/File;
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
    //   111: invokevirtual 298	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 298	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 298	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 77
    //   148: iconst_2
    //   149: new 126	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1121
    //   159: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 983	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1127	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1130	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 632	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1133	bfhi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1134
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1134
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1137	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1142	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1144
    //   251: invokespecial 1147	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1150	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 398	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1151	java/io/InputStreamReader:close	()V
    //   282: ldc 77
    //   284: iconst_2
    //   285: new 126	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1121
    //   295: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1153
    //   308: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1155
    //   319: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1157
    //   330: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1160	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 77
    //   361: iconst_2
    //   362: new 126	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1162
    //   372: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1164
    //   387: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 301	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 126	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1168	java/io/File:separatorChar	C
    //   438: invokevirtual 1171	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1175	ndr:a	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 298	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 77
    //   464: iconst_2
    //   465: new 126	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1177
    //   475: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 306	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   516: invokevirtual 398	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1151	java/io/InputStreamReader:close	()V
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
    //   546: invokevirtual 398	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1151	java/io/InputStreamReader:close	()V
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
    //   144	26	15	localException1	java.lang.Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	java.lang.Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	java.lang.Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	java.io.File
    //   608	1	16	localException4	java.lang.Exception
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
  public bdwa a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +251 -> 256
    //   8: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+25 -> 40, 1:+29->44, 2:+103->118, 3:+172->187
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: iload_1
    //   48: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokevirtual 1178	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifeq +20 -> 74
    //   57: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   60: iload_1
    //   61: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: invokevirtual 1179	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 1185	bdwa
    //   70: astore_2
    //   71: goto -31 -> 40
    //   74: new 1187	bdvz
    //   77: dup
    //   78: iconst_0
    //   79: invokespecial 1190	bdvz:<init>	(Z)V
    //   82: astore_2
    //   83: new 1192	bdwl
    //   86: dup
    //   87: invokestatic 1195	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   90: invokevirtual 1199	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   93: aload_2
    //   94: invokespecial 1202	bdwl:<init>	(Lmqq/app/AppRuntime;Lbdvz;)V
    //   97: astore_2
    //   98: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   101: iload_1
    //   102: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aload_2
    //   106: invokevirtual 996	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: goto -70 -> 40
    //   113: astore_2
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: iload_1
    //   122: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 1178	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   128: ifeq +20 -> 148
    //   131: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: iload_1
    //   135: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokevirtual 1179	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 1185	bdwa
    //   144: astore_2
    //   145: goto -105 -> 40
    //   148: new 1187	bdvz
    //   151: dup
    //   152: iconst_0
    //   153: invokespecial 1190	bdvz:<init>	(Z)V
    //   156: astore_2
    //   157: new 1192	bdwl
    //   160: dup
    //   161: invokestatic 1195	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   164: invokevirtual 1199	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   167: aload_2
    //   168: invokespecial 1202	bdwl:<init>	(Lmqq/app/AppRuntime;Lbdvz;)V
    //   171: astore_2
    //   172: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   175: iload_1
    //   176: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aload_2
    //   180: invokevirtual 996	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: goto -144 -> 40
    //   187: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   190: iload_1
    //   191: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: invokevirtual 1178	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   197: ifeq +20 -> 217
    //   200: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: iload_1
    //   204: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 1179	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 1185	bdwa
    //   213: astore_2
    //   214: goto -174 -> 40
    //   217: new 1187	bdvz
    //   220: dup
    //   221: iconst_0
    //   222: invokespecial 1190	bdvz:<init>	(Z)V
    //   225: astore_2
    //   226: new 1204	akkh
    //   229: dup
    //   230: invokestatic 1195	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   233: invokevirtual 1199	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   236: aload_2
    //   237: invokespecial 1205	akkh:<init>	(Lmqq/app/AppRuntime;Lbdvz;)V
    //   240: astore_2
    //   241: getstatic 44	bdvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   244: iload_1
    //   245: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aload_2
    //   249: invokevirtual 996	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: goto -213 -> 40
    //   256: aconst_null
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	bdvx
    //   0	258	1	paramInt	int
    //   1	105	2	localObject1	Object
    //   113	4	2	localObject2	Object
    //   144	105	2	localObject3	Object
    //   11	104	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   40	42	113	finally
    //   44	71	113	finally
    //   74	110	113	finally
    //   114	116	113	finally
    //   118	145	113	finally
    //   148	184	113	finally
    //   187	214	113	finally
    //   217	253	113	finally
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
          ((bdwa)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvx
 * JD-Core Version:    0.7.0.1
 */