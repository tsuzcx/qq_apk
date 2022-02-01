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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bhhh
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, bhhk> a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public bhhh(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(bhhf parambhhf, String paramString, Context paramContext)
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
    //   18: invokevirtual 88	bhhf:a	()Lbhhe;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 90	bhhi
    //   28: dup
    //   29: invokespecial 91	bhhi:<init>	()V
    //   32: invokevirtual 94	bhhf:a	(Lbhhe;)V
    //   35: aload_1
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 97	bhhf:jdField_a_of_type_Bhhg	Lbhhg;
    //   43: getfield 102	bhhg:a	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifge +14 -> 62
    //   51: aload_0
    //   52: getfield 97	bhhf:jdField_a_of_type_Bhhg	Lbhhg;
    //   55: aload_1
    //   56: invokestatic 108	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: putfield 102	bhhg:a	J
    //   62: iload_3
    //   63: istore 4
    //   65: aload_0
    //   66: ifnull +2602 -> 2668
    //   69: iload_3
    //   70: istore 5
    //   72: aload_0
    //   73: invokestatic 113	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lbhhf;)V
    //   76: iload_3
    //   77: istore 5
    //   79: aload_0
    //   80: invokestatic 115	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lbhhf;)V
    //   83: aload_0
    //   84: invokevirtual 118	bhhf:c	()Z
    //   87: ifne +47 -> 134
    //   90: aload_0
    //   91: bipush 147
    //   93: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: invokevirtual 124	bhhf:e	()V
    //   100: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +8236 -> 8339
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
    //   131: goto +8208 -> 8339
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
    //   164: getfield 161	bhhf:jdField_e_of_type_Int	I
    //   167: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 157 3 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 164	bhhf:n	Z
    //   180: ifeq +8165 -> 8345
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
    //   210: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   213: ifnull +15 -> 228
    //   216: aload_0
    //   217: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   220: invokeinterface 177 1 0
    //   225: ifgt +47 -> 272
    //   228: aload_0
    //   229: bipush 149
    //   231: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   234: aload_0
    //   235: invokevirtual 124	bhhf:e	()V
    //   238: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +8102 -> 8343
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
    //   269: goto +8074 -> 8343
    //   272: aload_0
    //   273: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   276: invokeinterface 177 1 0
    //   281: istore 9
    //   283: iconst_0
    //   284: istore 14
    //   286: getstatic 184	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   289: istore 4
    //   291: iconst_1
    //   292: iload 4
    //   294: if_icmpne +1815 -> 2109
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
    //   316: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   319: invokeinterface 177 1 0
    //   324: if_icmpge +7117 -> 7441
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
    //   373: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   376: iload 11
    //   378: invokeinterface 197 2 0
    //   383: checkcast 199	java/lang/String
    //   386: astore 33
    //   388: iload 4
    //   390: istore 8
    //   392: aload_0
    //   393: aload 33
    //   395: putfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   398: iload 4
    //   400: istore 8
    //   402: aload_0
    //   403: getfield 205	bhhf:jdField_g_of_type_Int	I
    //   406: iconst_3
    //   407: if_icmpne +49 -> 456
    //   410: iload 10
    //   412: ifeq +44 -> 456
    //   415: iload 4
    //   417: istore 8
    //   419: bipush 30
    //   421: aconst_null
    //   422: aload_0
    //   423: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   426: invokestatic 210	anaw:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   429: iload 4
    //   431: istore 8
    //   433: bipush 30
    //   435: aload_0
    //   436: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   439: sipush 300
    //   442: invokestatic 213	anaw:a	(ILjava/lang/String;I)V
    //   445: iload 4
    //   447: istore 8
    //   449: aload_0
    //   450: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokestatic 216	com/tencent/mobileqq/apollo/utils/ApolloUtil:d	(Ljava/lang/String;)V
    //   456: iload 4
    //   458: istore 8
    //   460: aload_0
    //   461: getfield 217	bhhf:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   464: aload 33
    //   466: invokeinterface 222 2 0
    //   471: checkcast 224	java/io/File
    //   474: astore 38
    //   476: ldc 226
    //   478: astore 34
    //   480: aload 38
    //   482: ifnull +6857 -> 7339
    //   485: iload 4
    //   487: istore 8
    //   489: aload 38
    //   491: invokevirtual 230	java/io/File:getParentFile	()Ljava/io/File;
    //   494: astore 42
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 233	bhhf:h	Z
    //   504: ifeq +1611 -> 2115
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
    //   560: getfield 249	bhhf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   563: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +18 -> 584
    //   569: iload 4
    //   571: istore 8
    //   573: aload_0
    //   574: getfield 249	bhhf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   577: aload 33
    //   579: invokestatic 261	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   582: astore 32
    //   584: iload 4
    //   586: istore 8
    //   588: new 263	arul
    //   591: dup
    //   592: aload 32
    //   594: aconst_null
    //   595: iconst_0
    //   596: invokespecial 266	arul:<init>	(Ljava/lang/String;Ljava/io/File;I)V
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
    //   659: getfield 164	bhhf:n	Z
    //   662: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 277
    //   668: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_0
    //   672: getfield 280	bhhf:p	Z
    //   675: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: ldc_w 282
    //   681: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: getfield 284	bhhf:jdField_b_of_type_Int	I
    //   688: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: ldc_w 289
    //   694: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_0
    //   698: getfield 292	bhhf:s	Z
    //   701: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   704: astore 43
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
    //   729: invokevirtual 294	arul:a	()V
    //   732: iconst_1
    //   733: istore 14
    //   735: aload 42
    //   737: ifnull +23 -> 760
    //   740: aload 29
    //   742: astore 35
    //   744: aload 29
    //   746: astore 34
    //   748: iload 5
    //   750: istore 4
    //   752: aload 42
    //   754: invokevirtual 297	java/io/File:exists	()Z
    //   757: ifeq +27 -> 784
    //   760: aload 29
    //   762: astore 35
    //   764: aload 29
    //   766: astore 34
    //   768: iload 5
    //   770: istore 4
    //   772: aload 42
    //   774: invokevirtual 300	java/io/File:isDirectory	()Z
    //   777: istore 14
    //   779: iload 14
    //   781: ifne +1376 -> 2157
    //   784: iload 14
    //   786: ifne +21 -> 807
    //   789: aload 29
    //   791: astore 35
    //   793: aload 29
    //   795: astore 34
    //   797: iload 5
    //   799: istore 4
    //   801: aload 42
    //   803: invokevirtual 303	java/io/File:delete	()Z
    //   806: pop
    //   807: aload 29
    //   809: astore 35
    //   811: aload 29
    //   813: astore 34
    //   815: iload 5
    //   817: istore 4
    //   819: aload 42
    //   821: invokevirtual 306	java/io/File:mkdirs	()Z
    //   824: ifne +1333 -> 2157
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
    //   848: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   851: iload 13
    //   853: istore 5
    //   855: iload 8
    //   857: istore 4
    //   859: iload 8
    //   861: istore 6
    //   863: aload 43
    //   865: ldc_w 308
    //   868: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 42
    //   873: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   876: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc_w 313
    //   882: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokestatic 317	bgjw:a	()Z
    //   888: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   891: ldc_w 319
    //   894: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: invokestatic 321	bgjw:b	()J
    //   900: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: iload 13
    //   906: istore 5
    //   908: iload 8
    //   910: istore 4
    //   912: iload 8
    //   914: istore 6
    //   916: new 67	java/lang/Exception
    //   919: dup
    //   920: ldc_w 323
    //   923: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
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
    //   971: instanceof 326
    //   974: ifne +7379 -> 8353
    //   977: aload 33
    //   979: instanceof 328
    //   982: ifne +7371 -> 8353
    //   985: aload 33
    //   987: instanceof 330
    //   990: ifeq +6 -> 996
    //   993: goto +7360 -> 8353
    //   996: aload 33
    //   998: instanceof 65
    //   1001: ifeq +6033 -> 7034
    //   1004: aload_0
    //   1005: bipush 145
    //   1007: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   1010: aload_0
    //   1011: aload 33
    //   1013: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1016: putfield 335	bhhf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1019: iload 14
    //   1021: ifne +18 -> 1039
    //   1024: iload 7
    //   1026: ifeq +13 -> 1039
    //   1029: iload 6
    //   1031: ifeq +6078 -> 7109
    //   1034: aload_0
    //   1035: iconst_1
    //   1036: putfield 338	bhhf:jdField_f_of_type_Boolean	Z
    //   1039: aload 43
    //   1041: ldc_w 340
    //   1044: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokestatic 343	bgmg:a	()Z
    //   1050: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1053: ldc_w 345
    //   1056: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokestatic 348	bgmg:c	()F
    //   1062: ldc_w 349
    //   1065: fdiv
    //   1066: invokevirtual 352	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload 43
    //   1072: ldc_w 354
    //   1075: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 33
    //   1080: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1083: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: iload_3
    //   1088: istore 8
    //   1090: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1093: iload_3
    //   1094: istore 8
    //   1096: ldc 77
    //   1098: iconst_1
    //   1099: new 126	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1106: aload 43
    //   1108: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: ldc_w 361
    //   1117: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1123: lload 27
    //   1125: lsub
    //   1126: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: iload_3
    //   1136: istore 8
    //   1138: aload_0
    //   1139: getfield 205	bhhf:jdField_g_of_type_Int	I
    //   1142: iconst_3
    //   1143: if_icmpne +63 -> 1206
    //   1146: iload 10
    //   1148: ifeq +58 -> 1206
    //   1151: iload_3
    //   1152: istore 8
    //   1154: bipush 30
    //   1156: aload_0
    //   1157: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1160: sipush 300
    //   1163: iconst_1
    //   1164: anewarray 4	java/lang/Object
    //   1167: dup
    //   1168: iconst_0
    //   1169: new 126	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1176: aload 43
    //   1178: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: ldc_w 361
    //   1187: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1193: lload 27
    //   1195: lsub
    //   1196: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1199: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: aastore
    //   1203: invokestatic 367	anaw:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1206: iload_3
    //   1207: ifeq +112 -> 1319
    //   1210: iload_3
    //   1211: istore 8
    //   1213: aload_0
    //   1214: invokevirtual 369	bhhf:b	()Z
    //   1217: ifne +102 -> 1319
    //   1220: iload_3
    //   1221: istore 8
    //   1223: aload_0
    //   1224: getfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   1227: ifeq +92 -> 1319
    //   1230: iload_3
    //   1231: istore 8
    //   1233: aload 39
    //   1235: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   1238: ifeq +5913 -> 7151
    //   1241: iload_3
    //   1242: istore 8
    //   1244: aload 39
    //   1246: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1249: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1252: ifne +5865 -> 7117
    //   1255: iload_3
    //   1256: istore 8
    //   1258: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   1261: aload 39
    //   1263: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1266: aload 39
    //   1268: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1271: getstatic 34	bhhh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1274: aload 39
    //   1276: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1279: invokeinterface 222 2 0
    //   1284: checkcast 147	java/lang/Integer
    //   1287: invokevirtual 384	java/lang/Integer:intValue	()I
    //   1290: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1293: iload_3
    //   1294: istore 8
    //   1296: aload 39
    //   1298: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1301: aload 38
    //   1303: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   1306: iconst_m1
    //   1307: aload_2
    //   1308: invokestatic 392	bhhh:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   1311: iload_3
    //   1312: istore 8
    //   1314: aload_0
    //   1315: iconst_0
    //   1316: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   1319: iload_3
    //   1320: istore 8
    //   1322: new 126	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1329: astore 34
    //   1331: iload_3
    //   1332: istore 8
    //   1334: aload 39
    //   1336: getfield 396	arul:jdField_b_of_type_Boolean	Z
    //   1339: ifeq +7268 -> 8607
    //   1342: ldc_w 398
    //   1345: astore 33
    //   1347: iload_3
    //   1348: istore 8
    //   1350: aload 34
    //   1352: aload 33
    //   1354: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: astore 34
    //   1359: iload_3
    //   1360: istore 8
    //   1362: aload 39
    //   1364: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   1367: ifeq +7248 -> 8615
    //   1370: ldc_w 400
    //   1373: astore 33
    //   1375: iload_3
    //   1376: istore 8
    //   1378: aload 34
    //   1380: aload 33
    //   1382: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: astore 33
    //   1390: iload 12
    //   1392: iconst_1
    //   1393: iadd
    //   1394: istore 7
    //   1396: aload 32
    //   1398: ifnull +13 -> 1411
    //   1401: iload_3
    //   1402: istore 8
    //   1404: aload 32
    //   1406: invokeinterface 405 1 0
    //   1411: aload 31
    //   1413: ifnull +11 -> 1424
    //   1416: iload_3
    //   1417: istore 8
    //   1419: aload 31
    //   1421: invokevirtual 410	java/io/InputStream:close	()V
    //   1424: aload 30
    //   1426: ifnull +11 -> 1437
    //   1429: iload_3
    //   1430: istore 8
    //   1432: aload 30
    //   1434: invokevirtual 413	java/io/BufferedOutputStream:close	()V
    //   1437: iload 7
    //   1439: istore 8
    //   1441: lload 19
    //   1443: lstore 21
    //   1445: iload 4
    //   1447: istore 7
    //   1449: iload 5
    //   1451: istore 4
    //   1453: lload 17
    //   1455: lstore 19
    //   1457: lload 21
    //   1459: lstore 17
    //   1461: iload 8
    //   1463: istore 5
    //   1465: iload_3
    //   1466: ifeq +34 -> 1500
    //   1469: iload 7
    //   1471: ifne +29 -> 1500
    //   1474: iload_3
    //   1475: istore 8
    //   1477: iload 5
    //   1479: aload_0
    //   1480: getfield 284	bhhf:jdField_b_of_type_Int	I
    //   1483: if_icmpge +17 -> 1500
    //   1486: iload_3
    //   1487: istore 8
    //   1489: aload_0
    //   1490: invokevirtual 369	bhhf:b	()Z
    //   1493: istore 15
    //   1495: iload 15
    //   1497: ifeq +6801 -> 8298
    //   1500: aload 30
    //   1502: astore 34
    //   1504: lload 19
    //   1506: lstore 21
    //   1508: aload 32
    //   1510: astore 30
    //   1512: aload 31
    //   1514: astore 35
    //   1516: lload 17
    //   1518: lstore 19
    //   1520: lload 21
    //   1522: lstore 17
    //   1524: aload 29
    //   1526: astore 32
    //   1528: iload 5
    //   1530: istore 6
    //   1532: aload 30
    //   1534: astore 31
    //   1536: aload 35
    //   1538: astore 30
    //   1540: aload 34
    //   1542: astore 29
    //   1544: iload 4
    //   1546: istore 5
    //   1548: iload_3
    //   1549: istore 4
    //   1551: aload_0
    //   1552: invokevirtual 415	bhhf:d	()V
    //   1555: aload 37
    //   1557: ifnonnull +6708 -> 8265
    //   1560: iload_3
    //   1561: istore 4
    //   1563: new 192	java/util/HashMap
    //   1566: dup
    //   1567: invokespecial 193	java/util/HashMap:<init>	()V
    //   1570: astore 34
    //   1572: iload_3
    //   1573: istore 4
    //   1575: aload 34
    //   1577: ldc_w 417
    //   1580: aload 32
    //   1582: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1585: pop
    //   1586: iload_3
    //   1587: istore 4
    //   1589: aload 34
    //   1591: ldc_w 423
    //   1594: aload_0
    //   1595: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   1598: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1601: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1604: pop
    //   1605: iload_3
    //   1606: istore 4
    //   1608: aload 34
    //   1610: ldc_w 428
    //   1613: aload_0
    //   1614: getfield 430	bhhf:jdField_f_of_type_Int	I
    //   1617: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1620: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1623: pop
    //   1624: iload_3
    //   1625: istore 4
    //   1627: aload 34
    //   1629: ldc_w 432
    //   1632: iload 6
    //   1634: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1637: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1640: pop
    //   1641: iload_3
    //   1642: istore 4
    //   1644: aload 34
    //   1646: ldc_w 434
    //   1649: lload 17
    //   1651: invokestatic 437	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1654: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1657: pop
    //   1658: iload_3
    //   1659: istore 4
    //   1661: aload 34
    //   1663: ldc_w 439
    //   1666: aload_0
    //   1667: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1670: invokeinterface 177 1 0
    //   1675: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1678: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1681: pop
    //   1682: iload_3
    //   1683: istore 4
    //   1685: aload 34
    //   1687: ldc_w 441
    //   1690: aload_0
    //   1691: getfield 443	bhhf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1694: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1697: pop
    //   1698: iload_3
    //   1699: istore 4
    //   1701: aload 34
    //   1703: ldc_w 445
    //   1706: iload 14
    //   1708: invokestatic 450	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1711: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1714: pop
    //   1715: iload_3
    //   1716: istore 4
    //   1718: aload 34
    //   1720: ldc_w 452
    //   1723: aload 33
    //   1725: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1728: pop
    //   1729: ldc 226
    //   1731: astore 35
    //   1733: iload_3
    //   1734: istore 4
    //   1736: aload_0
    //   1737: getfield 335	bhhf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1740: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1743: ifne +6616 -> 8359
    //   1746: iload_3
    //   1747: istore 4
    //   1749: aload 34
    //   1751: ldc_w 454
    //   1754: aload_0
    //   1755: getfield 335	bhhf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1758: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1761: pop
    //   1762: iload_3
    //   1763: istore 4
    //   1765: aload_0
    //   1766: getfield 335	bhhf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1769: astore 35
    //   1771: goto +6588 -> 8359
    //   1774: iload_3
    //   1775: istore 4
    //   1777: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   1780: lstore 21
    //   1782: aload_2
    //   1783: ifnull +281 -> 2064
    //   1786: iload_3
    //   1787: istore 4
    //   1789: aload_1
    //   1790: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1793: istore 16
    //   1795: iload 16
    //   1797: ifne +267 -> 2064
    //   1800: ldc_w 456
    //   1803: aload 32
    //   1805: new 126	java/lang/StringBuilder
    //   1808: dup
    //   1809: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1812: aload_0
    //   1813: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   1816: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1819: ldc 226
    //   1821: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1827: new 126	java/lang/StringBuilder
    //   1830: dup
    //   1831: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1834: lload 17
    //   1836: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1839: ldc 226
    //   1841: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: aload_0
    //   1848: getfield 443	bhhf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1851: new 126	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1858: iload 14
    //   1860: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1863: ldc 226
    //   1865: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1871: aload 35
    //   1873: aload 33
    //   1875: ldc 226
    //   1877: ldc_w 458
    //   1880: invokestatic 463	bhab:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1883: aload_0
    //   1884: getfield 205	bhhf:jdField_g_of_type_Int	I
    //   1887: iconst_3
    //   1888: if_icmpne +79 -> 1967
    //   1891: iload 10
    //   1893: ifeq +74 -> 1967
    //   1896: bipush 30
    //   1898: aload_0
    //   1899: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1902: sipush 300
    //   1905: aload_0
    //   1906: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   1909: invokestatic 466	com/tencent/mobileqq/apollo/utils/ApolloUtil:f	(I)I
    //   1912: iconst_4
    //   1913: anewarray 4	java/lang/Object
    //   1916: dup
    //   1917: iconst_0
    //   1918: ldc_w 468
    //   1921: aastore
    //   1922: dup
    //   1923: iconst_1
    //   1924: aload_0
    //   1925: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   1928: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1931: aastore
    //   1932: dup
    //   1933: iconst_2
    //   1934: ldc_w 470
    //   1937: aastore
    //   1938: dup
    //   1939: iconst_3
    //   1940: aload_0
    //   1941: getfield 430	bhhf:jdField_f_of_type_Int	I
    //   1944: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1947: aastore
    //   1948: invokestatic 473	anaw:a	(ILjava/lang/String;II[Ljava/lang/Object;)V
    //   1951: aload_0
    //   1952: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   1955: ifne +12 -> 1967
    //   1958: bipush 30
    //   1960: aload_0
    //   1961: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1964: invokestatic 476	anaw:b	(ILjava/lang/String;)V
    //   1967: ldc_w 478
    //   1970: astore 33
    //   1972: aload 33
    //   1974: astore 32
    //   1976: aload_0
    //   1977: getfield 443	bhhf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1980: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1983: ifne +57 -> 2040
    //   1986: aload 33
    //   1988: astore 32
    //   1990: aload_0
    //   1991: getfield 443	bhhf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1994: ldc_w 480
    //   1997: invokevirtual 483	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2000: ifeq +40 -> 2040
    //   2003: ldc_w 485
    //   2006: astore 32
    //   2008: aload 34
    //   2010: ldc_w 487
    //   2013: aload_0
    //   2014: getfield 490	bhhf:r	Z
    //   2017: invokestatic 492	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2020: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2023: pop
    //   2024: aload 34
    //   2026: ldc_w 494
    //   2029: aload_0
    //   2030: getfield 497	bhhf:q	Z
    //   2033: invokestatic 492	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2036: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2039: pop
    //   2040: aload_2
    //   2041: invokestatic 502	bctj:a	(Landroid/content/Context;)Lbctj;
    //   2044: aload_1
    //   2045: aload 32
    //   2047: iload 15
    //   2049: lload 21
    //   2051: lload 25
    //   2053: lsub
    //   2054: lload 19
    //   2056: aload 34
    //   2058: ldc 226
    //   2060: iconst_0
    //   2061: invokevirtual 505	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2064: iload_3
    //   2065: ifne +5358 -> 7423
    //   2068: iload 9
    //   2070: iconst_1
    //   2071: isub
    //   2072: istore 4
    //   2074: iload 11
    //   2076: iconst_1
    //   2077: iadd
    //   2078: istore 11
    //   2080: aload 31
    //   2082: astore 32
    //   2084: iload_3
    //   2085: istore 8
    //   2087: aload 30
    //   2089: astore 31
    //   2091: iload 5
    //   2093: istore_3
    //   2094: aload 29
    //   2096: astore 30
    //   2098: aload 32
    //   2100: astore 29
    //   2102: iload 4
    //   2104: istore 9
    //   2106: goto -1797 -> 309
    //   2109: iconst_0
    //   2110: istore 10
    //   2112: goto -1812 -> 300
    //   2115: iload 4
    //   2117: istore 8
    //   2119: new 224	java/io/File
    //   2122: dup
    //   2123: aload 42
    //   2125: new 126	java/lang/StringBuilder
    //   2128: dup
    //   2129: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2132: aload 38
    //   2134: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   2137: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: ldc_w 507
    //   2143: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2149: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2152: astore 36
    //   2154: goto -1603 -> 551
    //   2157: aload 29
    //   2159: astore 35
    //   2161: aload 29
    //   2163: astore 34
    //   2165: iload 5
    //   2167: istore 4
    //   2169: getstatic 46	bhhh:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2172: ifnonnull +29 -> 2201
    //   2175: aload 29
    //   2177: astore 35
    //   2179: aload 29
    //   2181: astore 34
    //   2183: iload 5
    //   2185: istore 4
    //   2187: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2190: ldc 54
    //   2192: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2195: checkcast 60	android/net/ConnectivityManager
    //   2198: putstatic 46	bhhh:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   2201: aload 29
    //   2203: astore 35
    //   2205: aload 29
    //   2207: astore 34
    //   2209: iload 5
    //   2211: istore 4
    //   2213: invokestatic 513	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   2216: astore 44
    //   2218: aload 44
    //   2220: ifnonnull +487 -> 2707
    //   2223: bipush 152
    //   2225: istore 8
    //   2227: aload 29
    //   2229: astore 35
    //   2231: aload 29
    //   2233: astore 34
    //   2235: iload 5
    //   2237: istore 4
    //   2239: aload_0
    //   2240: bipush 152
    //   2242: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   2245: iload 13
    //   2247: istore 5
    //   2249: iload 8
    //   2251: istore 4
    //   2253: iload 8
    //   2255: istore 6
    //   2257: aload 43
    //   2259: ldc_w 515
    //   2262: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: pop
    //   2266: iload 13
    //   2268: istore 5
    //   2270: iload 8
    //   2272: istore 4
    //   2274: iload 8
    //   2276: istore 6
    //   2278: new 67	java/lang/Exception
    //   2281: dup
    //   2282: ldc_w 517
    //   2285: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2288: athrow
    //   2289: astore_1
    //   2290: iload 6
    //   2292: istore 4
    //   2294: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   2297: iload 6
    //   2299: istore 4
    //   2301: ldc 77
    //   2303: iconst_1
    //   2304: new 126	java/lang/StringBuilder
    //   2307: dup
    //   2308: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2311: aload 43
    //   2313: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2316: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: ldc_w 361
    //   2322: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2325: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2328: lload 27
    //   2330: lsub
    //   2331: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2334: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2337: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2340: iload 6
    //   2342: istore 4
    //   2344: aload_0
    //   2345: getfield 205	bhhf:jdField_g_of_type_Int	I
    //   2348: iconst_3
    //   2349: if_icmpne +64 -> 2413
    //   2352: iload 10
    //   2354: ifeq +59 -> 2413
    //   2357: iload 6
    //   2359: istore 4
    //   2361: bipush 30
    //   2363: aload_0
    //   2364: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2367: sipush 300
    //   2370: iconst_1
    //   2371: anewarray 4	java/lang/Object
    //   2374: dup
    //   2375: iconst_0
    //   2376: new 126	java/lang/StringBuilder
    //   2379: dup
    //   2380: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2383: aload 43
    //   2385: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2388: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2391: ldc_w 361
    //   2394: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2400: lload 27
    //   2402: lsub
    //   2403: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2406: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2409: aastore
    //   2410: invokestatic 367	anaw:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   2413: iload 6
    //   2415: ifeq +119 -> 2534
    //   2418: iload 6
    //   2420: istore 4
    //   2422: aload_0
    //   2423: invokevirtual 369	bhhf:b	()Z
    //   2426: ifne +108 -> 2534
    //   2429: iload 6
    //   2431: istore 4
    //   2433: aload_0
    //   2434: getfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   2437: ifeq +97 -> 2534
    //   2440: iload 6
    //   2442: istore 4
    //   2444: aload 39
    //   2446: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   2449: ifeq +4830 -> 7279
    //   2452: iload 6
    //   2454: istore 4
    //   2456: aload 39
    //   2458: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2461: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2464: ifne +4779 -> 7243
    //   2467: iload 6
    //   2469: istore 4
    //   2471: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   2474: aload 39
    //   2476: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2479: aload 39
    //   2481: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2484: getstatic 34	bhhh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   2487: aload 39
    //   2489: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2492: invokeinterface 222 2 0
    //   2497: checkcast 147	java/lang/Integer
    //   2500: invokevirtual 384	java/lang/Integer:intValue	()I
    //   2503: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2506: iload 6
    //   2508: istore 4
    //   2510: aload 39
    //   2512: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2515: aload 38
    //   2517: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   2520: iconst_m1
    //   2521: aload_2
    //   2522: invokestatic 392	bhhh:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2525: iload 6
    //   2527: istore 4
    //   2529: aload_0
    //   2530: iconst_0
    //   2531: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   2534: iload 6
    //   2536: istore 4
    //   2538: new 126	java/lang/StringBuilder
    //   2541: dup
    //   2542: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2545: astore_2
    //   2546: iload 6
    //   2548: istore 4
    //   2550: aload 39
    //   2552: getfield 396	arul:jdField_b_of_type_Boolean	Z
    //   2555: ifeq +6068 -> 8623
    //   2558: ldc_w 398
    //   2561: astore_0
    //   2562: iload 6
    //   2564: istore 4
    //   2566: aload_2
    //   2567: aload_0
    //   2568: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: astore_2
    //   2572: iload 6
    //   2574: istore 4
    //   2576: aload 39
    //   2578: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   2581: ifeq +6049 -> 8630
    //   2584: ldc_w 400
    //   2587: astore_0
    //   2588: iload 6
    //   2590: istore 4
    //   2592: aload_2
    //   2593: aload_0
    //   2594: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2600: pop
    //   2601: aload 33
    //   2603: ifnull +14 -> 2617
    //   2606: iload 6
    //   2608: istore 4
    //   2610: aload 33
    //   2612: invokeinterface 405 1 0
    //   2617: aload 31
    //   2619: ifnull +12 -> 2631
    //   2622: iload 6
    //   2624: istore 4
    //   2626: aload 31
    //   2628: invokevirtual 410	java/io/InputStream:close	()V
    //   2631: aload 32
    //   2633: ifnull +12 -> 2645
    //   2636: iload 6
    //   2638: istore 4
    //   2640: aload 32
    //   2642: invokevirtual 413	java/io/BufferedOutputStream:close	()V
    //   2645: iload 6
    //   2647: istore 4
    //   2649: aload_1
    //   2650: athrow
    //   2651: astore_0
    //   2652: iload 4
    //   2654: istore_3
    //   2655: ldc 77
    //   2657: iconst_1
    //   2658: aload_0
    //   2659: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2662: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2665: iload_3
    //   2666: istore 4
    //   2668: iload 4
    //   2670: istore_3
    //   2671: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2674: ifeq +5667 -> 8341
    //   2677: ldc 77
    //   2679: iconst_2
    //   2680: new 126	java/lang/StringBuilder
    //   2683: dup
    //   2684: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2687: ldc_w 521
    //   2690: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: iload 4
    //   2695: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2698: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2701: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2704: iload 4
    //   2706: ireturn
    //   2707: aload 29
    //   2709: astore 30
    //   2711: aload 29
    //   2713: astore 35
    //   2715: aload 29
    //   2717: astore 34
    //   2719: iload 5
    //   2721: istore 4
    //   2723: aload_0
    //   2724: getfield 497	bhhf:q	Z
    //   2727: ifeq +122 -> 2849
    //   2730: aload 29
    //   2732: astore 30
    //   2734: aload 29
    //   2736: astore 35
    //   2738: aload 29
    //   2740: astore 34
    //   2742: iload 5
    //   2744: istore 4
    //   2746: aload 29
    //   2748: ldc_w 523
    //   2751: invokevirtual 483	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2754: ifne +95 -> 2849
    //   2757: aload 29
    //   2759: astore 35
    //   2761: aload 29
    //   2763: astore 34
    //   2765: iload 5
    //   2767: istore 4
    //   2769: new 525	java/util/Random
    //   2772: dup
    //   2773: aload_1
    //   2774: invokestatic 529	azwm:a	(Ljava/lang/String;)J
    //   2777: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   2780: lor
    //   2781: invokespecial 532	java/util/Random:<init>	(J)V
    //   2784: invokevirtual 535	java/util/Random:nextInt	()I
    //   2787: istore 13
    //   2789: aload 29
    //   2791: astore 35
    //   2793: aload 29
    //   2795: astore 34
    //   2797: iload 5
    //   2799: istore 4
    //   2801: aload 29
    //   2803: invokestatic 538	bhhh:b	(Ljava/lang/String;)Z
    //   2806: ifeq +383 -> 3189
    //   2809: aload 29
    //   2811: astore 35
    //   2813: aload 29
    //   2815: astore 34
    //   2817: iload 5
    //   2819: istore 4
    //   2821: new 126	java/lang/StringBuilder
    //   2824: dup
    //   2825: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2828: aload 29
    //   2830: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: ldc_w 540
    //   2836: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: iload 13
    //   2841: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2844: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2847: astore 30
    //   2849: aload 30
    //   2851: astore 35
    //   2853: aload 30
    //   2855: astore 34
    //   2857: iload 5
    //   2859: istore 4
    //   2861: aload 30
    //   2863: invokestatic 543	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2866: astore 29
    //   2868: aload 29
    //   2870: astore 35
    //   2872: aload 29
    //   2874: astore 34
    //   2876: iload 5
    //   2878: istore 4
    //   2880: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2883: ifeq +42 -> 2925
    //   2886: aload 29
    //   2888: astore 35
    //   2890: aload 29
    //   2892: astore 34
    //   2894: iload 5
    //   2896: istore 4
    //   2898: ldc 77
    //   2900: iconst_2
    //   2901: new 126	java/lang/StringBuilder
    //   2904: dup
    //   2905: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2908: ldc_w 545
    //   2911: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: aload 29
    //   2916: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2919: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2922: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2925: aload 29
    //   2927: astore 35
    //   2929: aload 29
    //   2931: astore 34
    //   2933: iload 5
    //   2935: istore 4
    //   2937: aload_0
    //   2938: getfield 430	bhhf:jdField_f_of_type_Int	I
    //   2941: sipush 302
    //   2944: if_icmpne +5347 -> 8291
    //   2947: iload 12
    //   2949: ifne +5342 -> 8291
    //   2952: aload 29
    //   2954: astore 35
    //   2956: aload 29
    //   2958: astore 34
    //   2960: iload 5
    //   2962: istore 4
    //   2964: aload_0
    //   2965: getfield 490	bhhf:r	Z
    //   2968: ifeq +5323 -> 8291
    //   2971: aload 29
    //   2973: astore 35
    //   2975: aload 29
    //   2977: astore 34
    //   2979: iload 5
    //   2981: istore 4
    //   2983: aload 29
    //   2985: ldc_w 547
    //   2988: invokevirtual 550	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2991: ifeq +5300 -> 8291
    //   2994: aload 29
    //   2996: astore 35
    //   2998: aload 29
    //   3000: astore 34
    //   3002: iload 5
    //   3004: istore 4
    //   3006: aload_0
    //   3007: iconst_0
    //   3008: putfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   3011: iconst_1
    //   3012: istore 4
    //   3014: iconst_1
    //   3015: istore 5
    //   3017: aload 29
    //   3019: astore 35
    //   3021: aload 29
    //   3023: astore 34
    //   3025: aload 29
    //   3027: ldc_w 552
    //   3030: ldc_w 554
    //   3033: invokevirtual 557	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3036: astore 29
    //   3038: new 559	org/apache/http/client/methods/HttpGet
    //   3041: dup
    //   3042: aload 29
    //   3044: invokespecial 560	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   3047: astore 34
    //   3049: aload_0
    //   3050: invokevirtual 563	bhhf:a	()Ljava/util/Map;
    //   3053: astore 30
    //   3055: aload 30
    //   3057: ifnull +175 -> 3232
    //   3060: aload 30
    //   3062: invokeinterface 567 1 0
    //   3067: invokeinterface 573 1 0
    //   3072: astore 35
    //   3074: aload 35
    //   3076: invokeinterface 578 1 0
    //   3081: ifeq +151 -> 3232
    //   3084: aload 35
    //   3086: invokeinterface 582 1 0
    //   3091: checkcast 199	java/lang/String
    //   3094: astore 45
    //   3096: aload 30
    //   3098: aload 45
    //   3100: invokeinterface 222 2 0
    //   3105: checkcast 199	java/lang/String
    //   3108: astore 46
    //   3110: aload 34
    //   3112: aload 45
    //   3114: aload 46
    //   3116: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3119: aload 43
    //   3121: ldc_w 588
    //   3124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: aload 45
    //   3129: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: ldc_w 590
    //   3135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3138: aload 46
    //   3140: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: pop
    //   3144: goto -70 -> 3074
    //   3147: astore 35
    //   3149: aload 33
    //   3151: astore 34
    //   3153: iconst_0
    //   3154: istore 14
    //   3156: iload 5
    //   3158: istore 4
    //   3160: aload 32
    //   3162: astore 30
    //   3164: iload 6
    //   3166: istore 8
    //   3168: aload 35
    //   3170: astore 33
    //   3172: iload 7
    //   3174: istore 6
    //   3176: iload_3
    //   3177: istore 5
    //   3179: aload 34
    //   3181: astore 32
    //   3183: iload 8
    //   3185: istore_3
    //   3186: goto -2220 -> 966
    //   3189: aload 29
    //   3191: astore 35
    //   3193: aload 29
    //   3195: astore 34
    //   3197: iload 5
    //   3199: istore 4
    //   3201: new 126	java/lang/StringBuilder
    //   3204: dup
    //   3205: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3208: aload 29
    //   3210: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3213: ldc_w 592
    //   3216: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3219: iload 13
    //   3221: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3224: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3227: astore 30
    //   3229: goto -380 -> 2849
    //   3232: aload_0
    //   3233: getfield 595	bhhf:k	Z
    //   3236: ifeq +41 -> 3277
    //   3239: getstatic 598	bkdi:jdField_a_of_type_Boolean	Z
    //   3242: ifeq +35 -> 3277
    //   3245: invokestatic 599	bkdi:a	()Z
    //   3248: ifeq +29 -> 3277
    //   3251: aload 34
    //   3253: ldc_w 601
    //   3256: ldc_w 603
    //   3259: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3262: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3265: ifeq +12 -> 3277
    //   3268: ldc 77
    //   3270: iconst_2
    //   3271: ldc_w 605
    //   3274: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3277: aload_0
    //   3278: getfield 608	bhhf:l	Z
    //   3281: ifeq +154 -> 3435
    //   3284: invokestatic 613	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3287: getstatic 619	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   3290: invokevirtual 622	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   3293: invokevirtual 623	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3296: astore 30
    //   3298: aload 30
    //   3300: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3303: ifne +1016 -> 4319
    //   3306: aload 30
    //   3308: invokestatic 627	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3311: iconst_1
    //   3312: iand
    //   3313: iconst_1
    //   3314: if_icmpne +1005 -> 4319
    //   3317: aload 34
    //   3319: ldc_w 601
    //   3322: ldc_w 629
    //   3325: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3328: ldc_w 631
    //   3331: iconst_3
    //   3332: anewarray 4	java/lang/Object
    //   3335: dup
    //   3336: iconst_0
    //   3337: getstatic 27	bhhh:jdField_a_of_type_ArrayOfInt	[I
    //   3340: iconst_0
    //   3341: iaload
    //   3342: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3345: aastore
    //   3346: dup
    //   3347: iconst_1
    //   3348: getstatic 27	bhhh:jdField_a_of_type_ArrayOfInt	[I
    //   3351: iconst_1
    //   3352: iaload
    //   3353: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3356: aastore
    //   3357: dup
    //   3358: iconst_2
    //   3359: getstatic 27	bhhh:jdField_a_of_type_ArrayOfInt	[I
    //   3362: iconst_2
    //   3363: iaload
    //   3364: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3367: aastore
    //   3368: invokestatic 635	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3371: astore 30
    //   3373: aload 34
    //   3375: ldc_w 637
    //   3378: new 126	java/lang/StringBuilder
    //   3381: dup
    //   3382: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3385: ldc_w 639
    //   3388: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: aload 30
    //   3393: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3396: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3399: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3402: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3405: ifeq +30 -> 3435
    //   3408: ldc 77
    //   3410: iconst_2
    //   3411: new 126	java/lang/StringBuilder
    //   3414: dup
    //   3415: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3418: ldc_w 641
    //   3421: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: aload 29
    //   3426: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3432: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3435: aload 36
    //   3437: ifnull +80 -> 3517
    //   3440: aload 36
    //   3442: invokevirtual 297	java/io/File:exists	()Z
    //   3445: ifeq +72 -> 3517
    //   3448: aload 36
    //   3450: invokevirtual 644	java/io/File:length	()J
    //   3453: lstore 21
    //   3455: aload 34
    //   3457: ldc_w 646
    //   3460: new 126	java/lang/StringBuilder
    //   3463: dup
    //   3464: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3467: ldc_w 648
    //   3470: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3473: lload 21
    //   3475: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3478: ldc_w 650
    //   3481: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3490: aload 43
    //   3492: new 126	java/lang/StringBuilder
    //   3495: dup
    //   3496: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   3499: ldc_w 652
    //   3502: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3505: lload 21
    //   3507: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3510: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3513: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: pop
    //   3517: aload_0
    //   3518: getfield 655	bhhf:m	Z
    //   3521: ifne +119 -> 3640
    //   3524: aload_0
    //   3525: getfield 658	bhhf:j	Z
    //   3528: ifeq +112 -> 3640
    //   3531: aload 38
    //   3533: ifnull +107 -> 3640
    //   3536: aload 38
    //   3538: invokevirtual 297	java/io/File:exists	()Z
    //   3541: ifeq +99 -> 3640
    //   3544: aload_0
    //   3545: getfield 660	bhhf:jdField_i_of_type_Long	J
    //   3548: lconst_0
    //   3549: lcmp
    //   3550: ifle +787 -> 4337
    //   3553: aload_0
    //   3554: getfield 660	bhhf:jdField_i_of_type_Long	J
    //   3557: lstore 21
    //   3559: lload 21
    //   3561: lconst_0
    //   3562: lcmp
    //   3563: ifle +77 -> 3640
    //   3566: new 662	java/text/SimpleDateFormat
    //   3569: dup
    //   3570: ldc_w 664
    //   3573: getstatic 670	java/util/Locale:US	Ljava/util/Locale;
    //   3576: invokespecial 673	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3579: astore 30
    //   3581: aload 30
    //   3583: ldc_w 675
    //   3586: invokestatic 681	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3589: invokevirtual 685	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3592: aload 30
    //   3594: new 687	java/util/Date
    //   3597: dup
    //   3598: lload 21
    //   3600: invokespecial 688	java/util/Date:<init>	(J)V
    //   3603: invokevirtual 691	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3606: astore 30
    //   3608: aload 30
    //   3610: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3613: ifne +27 -> 3640
    //   3616: aload 34
    //   3618: ldc_w 693
    //   3621: aload 30
    //   3623: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3626: aload 43
    //   3628: ldc_w 695
    //   3631: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: aload 30
    //   3636: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3639: pop
    //   3640: getstatic 20	bhhh:jdField_a_of_type_Boolean	Z
    //   3643: ifeq +105 -> 3748
    //   3646: aload_0
    //   3647: getfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   3650: ifeq +98 -> 3748
    //   3653: aload_0
    //   3654: getfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   3657: ifeq +91 -> 3748
    //   3660: aload 39
    //   3662: getfield 396	arul:jdField_b_of_type_Boolean	Z
    //   3665: ifne +83 -> 3748
    //   3668: aload 39
    //   3670: invokestatic 698	bhhh:a	(Larul;)V
    //   3673: aload 39
    //   3675: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   3678: ifeq +70 -> 3748
    //   3681: aload 34
    //   3683: new 700	java/net/URI
    //   3686: dup
    //   3687: aload 39
    //   3689: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3692: invokespecial 701	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3695: invokevirtual 705	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3698: aload 34
    //   3700: ldc_w 707
    //   3703: aload 39
    //   3705: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3708: invokevirtual 586	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3711: aload 43
    //   3713: ldc_w 709
    //   3716: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: aload 39
    //   3721: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3724: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: ldc_w 711
    //   3730: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3733: aload 39
    //   3735: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3738: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3741: ldc_w 713
    //   3744: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3747: pop
    //   3748: aload 44
    //   3750: invokevirtual 718	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3753: invokestatic 722	bgva:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3756: astore 30
    //   3758: aload 30
    //   3760: aload_0
    //   3761: getfield 723	bhhf:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3764: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3767: ifne +14 -> 3781
    //   3770: aload_0
    //   3771: iconst_0
    //   3772: putfield 338	bhhf:jdField_f_of_type_Boolean	Z
    //   3775: aload_0
    //   3776: aload 30
    //   3778: putfield 723	bhhf:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3781: aload 44
    //   3783: invokestatic 732	bgnt:a	(Landroid/net/NetworkInfo;)Z
    //   3786: ifeq +561 -> 4347
    //   3789: aload_0
    //   3790: getfield 338	bhhf:jdField_f_of_type_Boolean	Z
    //   3793: ifne +4489 -> 8282
    //   3796: invokestatic 737	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3799: astore 30
    //   3801: invokestatic 740	android/net/Proxy:getDefaultPort	()I
    //   3804: istore 8
    //   3806: aload 30
    //   3808: ifnull +4467 -> 8275
    //   3811: iload 8
    //   3813: ifle +4462 -> 8275
    //   3816: aload 40
    //   3818: ldc_w 742
    //   3821: new 744	org/apache/http/HttpHost
    //   3824: dup
    //   3825: aload 30
    //   3827: iload 8
    //   3829: invokespecial 747	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3832: invokeinterface 157 3 0
    //   3837: pop
    //   3838: iconst_1
    //   3839: istore 4
    //   3841: aload 43
    //   3843: ldc_w 749
    //   3846: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3849: iconst_1
    //   3850: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3853: ldc_w 751
    //   3856: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3859: aload 30
    //   3861: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3864: ldc_w 753
    //   3867: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3870: iload 8
    //   3872: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3875: pop
    //   3876: iload 4
    //   3878: istore 7
    //   3880: iload_3
    //   3881: istore 4
    //   3883: iload 7
    //   3885: istore_3
    //   3886: aload_0
    //   3887: getfield 280	bhhf:p	Z
    //   3890: ifne +18 -> 3908
    //   3893: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3896: invokestatic 756	bgnt:h	(Landroid/content/Context;)Z
    //   3899: ifeq +9 -> 3908
    //   3902: aload 40
    //   3904: iconst_0
    //   3905: invokestatic 762	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3908: aload 40
    //   3910: ldc_w 764
    //   3913: iload 4
    //   3915: invokeinterface 768 3 0
    //   3920: pop
    //   3921: aload 34
    //   3923: aload 40
    //   3925: invokevirtual 772	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3928: aload_0
    //   3929: getfield 164	bhhf:n	Z
    //   3932: ifeq +425 -> 4357
    //   3935: ldc 166
    //   3937: astore 30
    //   3939: aload 34
    //   3941: ldc 168
    //   3943: aload 30
    //   3945: invokevirtual 775	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3948: ldc_w 776
    //   3951: invokestatic 780	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   3954: getstatic 785	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3957: aload 34
    //   3959: invokevirtual 791	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3962: astore 35
    //   3964: iload 5
    //   3966: istore 7
    //   3968: aload 35
    //   3970: invokeinterface 797 1 0
    //   3975: invokeinterface 802 1 0
    //   3980: istore 8
    //   3982: iload 5
    //   3984: istore 7
    //   3986: aload_0
    //   3987: iload 8
    //   3989: putfield 430	bhhf:jdField_f_of_type_Int	I
    //   3992: iload 5
    //   3994: istore 7
    //   3996: aload 39
    //   3998: iload 8
    //   4000: putfield 804	arul:jdField_c_of_type_Int	I
    //   4003: iload 5
    //   4005: istore 7
    //   4007: aload 43
    //   4009: ldc_w 806
    //   4012: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: aload 34
    //   4017: invokevirtual 810	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   4020: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4023: ldc_w 812
    //   4026: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4029: iload 8
    //   4031: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4034: ldc_w 814
    //   4037: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4040: pop
    //   4041: iload 5
    //   4043: istore 7
    //   4045: aload 35
    //   4047: invokeinterface 818 1 0
    //   4052: astore 30
    //   4054: iload 5
    //   4056: istore 7
    //   4058: aload 30
    //   4060: invokeinterface 821 1 0
    //   4065: ifeq +300 -> 4365
    //   4068: iload 5
    //   4070: istore 7
    //   4072: aload 30
    //   4074: invokeinterface 825 1 0
    //   4079: astore 34
    //   4081: iload 5
    //   4083: istore 7
    //   4085: aload 34
    //   4087: invokeinterface 828 1 0
    //   4092: astore 44
    //   4094: iload 5
    //   4096: istore 7
    //   4098: ldc_w 830
    //   4101: aload 44
    //   4103: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4106: ifne +138 -> 4244
    //   4109: iload 5
    //   4111: istore 7
    //   4113: ldc_w 835
    //   4116: aload 44
    //   4118: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4121: ifne +123 -> 4244
    //   4124: iload 5
    //   4126: istore 7
    //   4128: ldc_w 837
    //   4131: aload 44
    //   4133: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4136: ifne +108 -> 4244
    //   4139: iload 5
    //   4141: istore 7
    //   4143: ldc_w 839
    //   4146: aload 44
    //   4148: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4151: ifne +93 -> 4244
    //   4154: iload 5
    //   4156: istore 7
    //   4158: ldc_w 841
    //   4161: aload 44
    //   4163: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4166: ifne +78 -> 4244
    //   4169: iload 5
    //   4171: istore 7
    //   4173: ldc_w 843
    //   4176: aload 44
    //   4178: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4181: ifne +63 -> 4244
    //   4184: iload 5
    //   4186: istore 7
    //   4188: ldc_w 845
    //   4191: aload 44
    //   4193: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4196: ifne +48 -> 4244
    //   4199: iload 5
    //   4201: istore 7
    //   4203: ldc_w 847
    //   4206: aload 44
    //   4208: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4211: ifne +33 -> 4244
    //   4214: iload 5
    //   4216: istore 7
    //   4218: ldc_w 849
    //   4221: aload 44
    //   4223: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4226: ifne +18 -> 4244
    //   4229: iload 5
    //   4231: istore 7
    //   4233: ldc_w 851
    //   4236: aload 44
    //   4238: invokevirtual 833	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4241: ifeq -187 -> 4054
    //   4244: iload 5
    //   4246: istore 7
    //   4248: aload 43
    //   4250: ldc_w 588
    //   4253: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4256: aload 44
    //   4258: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4261: ldc_w 853
    //   4264: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: aload 34
    //   4269: invokeinterface 856 1 0
    //   4274: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4277: pop
    //   4278: goto -224 -> 4054
    //   4281: astore 34
    //   4283: iconst_1
    //   4284: istore 14
    //   4286: iload 4
    //   4288: istore 5
    //   4290: aload 32
    //   4292: astore 30
    //   4294: aload 33
    //   4296: astore 32
    //   4298: iload 6
    //   4300: istore 8
    //   4302: aload 34
    //   4304: astore 33
    //   4306: iload_3
    //   4307: istore 6
    //   4309: iload 7
    //   4311: istore 4
    //   4313: iload 8
    //   4315: istore_3
    //   4316: goto -3350 -> 966
    //   4319: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4322: ifeq -887 -> 3435
    //   4325: ldc 77
    //   4327: iconst_2
    //   4328: ldc_w 858
    //   4331: invokestatic 861	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4334: goto -899 -> 3435
    //   4337: aload 38
    //   4339: invokevirtual 864	java/io/File:lastModified	()J
    //   4342: lstore 21
    //   4344: goto -785 -> 3559
    //   4347: sipush 4096
    //   4350: istore 4
    //   4352: iconst_0
    //   4353: istore_3
    //   4354: goto -468 -> 3886
    //   4357: ldc_w 866
    //   4360: astore 30
    //   4362: goto -423 -> 3939
    //   4365: sipush 200
    //   4368: iload 8
    //   4370: if_icmpeq +11 -> 4381
    //   4373: sipush 206
    //   4376: iload 8
    //   4378: if_icmpne +2088 -> 6466
    //   4381: iload 5
    //   4383: istore 7
    //   4385: aload 35
    //   4387: invokeinterface 870 1 0
    //   4392: astore 30
    //   4394: aload 30
    //   4396: invokeinterface 873 1 0
    //   4401: lstore 23
    //   4403: lload 23
    //   4405: lstore 21
    //   4407: iload 5
    //   4409: istore 7
    //   4411: aload 43
    //   4413: ldc_w 875
    //   4416: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4419: lload 23
    //   4421: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4424: pop
    //   4425: lload 23
    //   4427: lstore 21
    //   4429: iload 5
    //   4431: istore 7
    //   4433: aload 35
    //   4435: ldc_w 877
    //   4438: invokeinterface 881 2 0
    //   4443: astore 33
    //   4445: lload 23
    //   4447: lstore 21
    //   4449: iload 5
    //   4451: istore 7
    //   4453: aload 35
    //   4455: ldc_w 837
    //   4458: invokeinterface 881 2 0
    //   4463: astore 34
    //   4465: aload 33
    //   4467: ifnull +250 -> 4717
    //   4470: lload 23
    //   4472: lstore 21
    //   4474: iload 5
    //   4476: istore 7
    //   4478: aload 33
    //   4480: invokeinterface 856 1 0
    //   4485: ldc_w 883
    //   4488: invokevirtual 887	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4491: iconst_1
    //   4492: aaload
    //   4493: invokestatic 627	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4496: i2l
    //   4497: lstore 17
    //   4499: lload 17
    //   4501: lstore 21
    //   4503: iload 5
    //   4505: istore 7
    //   4507: aload 36
    //   4509: invokevirtual 644	java/io/File:length	()J
    //   4512: lstore 23
    //   4514: lload 17
    //   4516: lstore 21
    //   4518: iload 5
    //   4520: istore 7
    //   4522: aload 43
    //   4524: ldc_w 889
    //   4527: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4530: lload 17
    //   4532: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4535: ldc_w 891
    //   4538: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4541: lload 23
    //   4543: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4546: pop
    //   4547: lload 17
    //   4549: lstore 21
    //   4551: iload 5
    //   4553: istore 7
    //   4555: aload_0
    //   4556: getfield 893	bhhf:jdField_g_of_type_Boolean	Z
    //   4559: ifne +10 -> 4569
    //   4562: lload 17
    //   4564: lconst_1
    //   4565: lcmp
    //   4566: iflt +38 -> 4604
    //   4569: lload 17
    //   4571: lstore 21
    //   4573: iload 5
    //   4575: istore 7
    //   4577: aload_0
    //   4578: getfield 895	bhhf:jdField_e_of_type_Long	J
    //   4581: lconst_0
    //   4582: lcmp
    //   4583: ifle +167 -> 4750
    //   4586: lload 17
    //   4588: lstore 21
    //   4590: iload 5
    //   4592: istore 7
    //   4594: lload 17
    //   4596: aload_0
    //   4597: getfield 895	bhhf:jdField_e_of_type_Long	J
    //   4600: lcmp
    //   4601: ifle +149 -> 4750
    //   4604: iconst_1
    //   4605: istore 7
    //   4607: iconst_1
    //   4608: istore 13
    //   4610: bipush 138
    //   4612: istore 8
    //   4614: lload 17
    //   4616: lstore 21
    //   4618: aload_0
    //   4619: bipush 138
    //   4621: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   4624: iload 8
    //   4626: istore 6
    //   4628: iload 13
    //   4630: istore 5
    //   4632: iload 8
    //   4634: istore 7
    //   4636: aload 43
    //   4638: ldc_w 897
    //   4641: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4644: aload_0
    //   4645: getfield 895	bhhf:jdField_e_of_type_Long	J
    //   4648: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4651: pop
    //   4652: iload 8
    //   4654: istore 6
    //   4656: iload 13
    //   4658: istore 5
    //   4660: iload 8
    //   4662: istore 7
    //   4664: new 67	java/lang/Exception
    //   4667: dup
    //   4668: ldc_w 899
    //   4671: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4674: athrow
    //   4675: astore 33
    //   4677: iload 6
    //   4679: istore 7
    //   4681: iload 4
    //   4683: istore 8
    //   4685: aload 30
    //   4687: astore 34
    //   4689: iload 5
    //   4691: istore 4
    //   4693: iconst_1
    //   4694: istore 14
    //   4696: iload_3
    //   4697: istore 6
    //   4699: iload 8
    //   4701: istore 5
    //   4703: aload 32
    //   4705: astore 30
    //   4707: aload 34
    //   4709: astore 32
    //   4711: iload 7
    //   4713: istore_3
    //   4714: goto -3748 -> 966
    //   4717: lload 23
    //   4719: lstore 17
    //   4721: aload 34
    //   4723: ifnull -224 -> 4499
    //   4726: lload 23
    //   4728: lstore 21
    //   4730: iload 5
    //   4732: istore 7
    //   4734: aload 34
    //   4736: invokeinterface 856 1 0
    //   4741: invokestatic 627	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4744: i2l
    //   4745: lstore 17
    //   4747: goto -248 -> 4499
    //   4750: lconst_0
    //   4751: lload 23
    //   4753: lcmp
    //   4754: ifeq +74 -> 4828
    //   4757: lload 23
    //   4759: lload 17
    //   4761: lcmp
    //   4762: iflt +66 -> 4828
    //   4765: lload 17
    //   4767: lstore 21
    //   4769: iload 5
    //   4771: istore 7
    //   4773: aload 36
    //   4775: invokevirtual 303	java/io/File:delete	()Z
    //   4778: pop
    //   4779: bipush 139
    //   4781: istore 8
    //   4783: lload 17
    //   4785: lstore 21
    //   4787: iload 5
    //   4789: istore 7
    //   4791: aload_0
    //   4792: bipush 139
    //   4794: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   4797: iload 8
    //   4799: istore 6
    //   4801: iload 8
    //   4803: istore 7
    //   4805: new 67	java/lang/Exception
    //   4808: dup
    //   4809: ldc_w 901
    //   4812: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4815: athrow
    //   4816: astore_1
    //   4817: iload 7
    //   4819: istore 6
    //   4821: aload 30
    //   4823: astore 33
    //   4825: goto -2535 -> 2290
    //   4828: lload 23
    //   4830: lconst_0
    //   4831: lcmp
    //   4832: ifeq +335 -> 5167
    //   4835: iconst_1
    //   4836: istore 14
    //   4838: lload 17
    //   4840: lstore 21
    //   4842: iload 5
    //   4844: istore 7
    //   4846: new 412	java/io/BufferedOutputStream
    //   4849: dup
    //   4850: new 903	java/io/FileOutputStream
    //   4853: dup
    //   4854: aload 36
    //   4856: iload 14
    //   4858: invokespecial 906	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4861: invokespecial 909	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4864: astore 33
    //   4866: aload 35
    //   4868: ldc_w 849
    //   4871: invokeinterface 881 2 0
    //   4876: ifnull +297 -> 5173
    //   4879: ldc 166
    //   4881: aload 35
    //   4883: ldc_w 849
    //   4886: invokeinterface 881 2 0
    //   4891: invokeinterface 856 1 0
    //   4896: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4899: ifeq +274 -> 5173
    //   4902: new 911	java/util/zip/GZIPInputStream
    //   4905: dup
    //   4906: aload 30
    //   4908: invokeinterface 915 1 0
    //   4913: invokespecial 918	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4916: astore 32
    //   4918: aload 43
    //   4920: ldc_w 920
    //   4923: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4926: pop
    //   4927: aload 32
    //   4929: astore 31
    //   4931: invokestatic 926	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4934: iload 4
    //   4936: invokevirtual 930	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4939: astore 44
    //   4941: iconst_0
    //   4942: istore 7
    //   4944: lload 19
    //   4946: lstore 21
    //   4948: aload_0
    //   4949: invokevirtual 369	bhhf:b	()Z
    //   4952: ifne +326 -> 5278
    //   4955: lload 19
    //   4957: lstore 21
    //   4959: aload 31
    //   4961: aload 44
    //   4963: invokevirtual 934	java/io/InputStream:read	([B)I
    //   4966: istore 8
    //   4968: iload 8
    //   4970: iconst_m1
    //   4971: if_icmpeq +307 -> 5278
    //   4974: lload 19
    //   4976: lstore 21
    //   4978: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4981: ifeq +64 -> 5045
    //   4984: lconst_0
    //   4985: lload 23
    //   4987: lcmp
    //   4988: ifne +57 -> 5045
    //   4991: aconst_null
    //   4992: astore 34
    //   4994: iload 8
    //   4996: iconst_4
    //   4997: if_icmple +192 -> 5189
    //   5000: iconst_m1
    //   5001: aload 44
    //   5003: iconst_0
    //   5004: baload
    //   5005: if_icmpne +184 -> 5189
    //   5008: bipush 216
    //   5010: aload 44
    //   5012: iconst_1
    //   5013: baload
    //   5014: if_icmpne +175 -> 5189
    //   5017: ldc_w 936
    //   5020: astore 32
    //   5022: aload 32
    //   5024: ifnull +21 -> 5045
    //   5027: lload 19
    //   5029: lstore 21
    //   5031: aload 43
    //   5033: ldc_w 938
    //   5036: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5039: aload 32
    //   5041: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5044: pop
    //   5045: lload 19
    //   5047: lstore 21
    //   5049: aload 33
    //   5051: aload 44
    //   5053: iconst_0
    //   5054: iload 8
    //   5056: invokevirtual 942	java/io/BufferedOutputStream:write	([BII)V
    //   5059: lload 23
    //   5061: iload 8
    //   5063: i2l
    //   5064: ladd
    //   5065: lstore 23
    //   5067: lload 19
    //   5069: iload 8
    //   5071: i2l
    //   5072: ladd
    //   5073: lstore 19
    //   5075: iload 7
    //   5077: iload 8
    //   5079: iadd
    //   5080: istore 7
    //   5082: lload 17
    //   5084: lconst_0
    //   5085: lcmp
    //   5086: ifle +3186 -> 8272
    //   5089: lload 19
    //   5091: lstore 21
    //   5093: aload_0
    //   5094: getfield 944	bhhf:jdField_f_of_type_Long	J
    //   5097: lconst_0
    //   5098: lcmp
    //   5099: ifne +17 -> 5116
    //   5102: lload 19
    //   5104: lstore 21
    //   5106: aload_0
    //   5107: lload 17
    //   5109: ldc2_w 945
    //   5112: ldiv
    //   5113: putfield 944	bhhf:jdField_f_of_type_Long	J
    //   5116: lload 19
    //   5118: lstore 21
    //   5120: iload 7
    //   5122: i2l
    //   5123: aload_0
    //   5124: getfield 944	bhhf:jdField_f_of_type_Long	J
    //   5127: lcmp
    //   5128: ifge +11 -> 5139
    //   5131: lload 23
    //   5133: lload 17
    //   5135: lcmp
    //   5136: iflt +3136 -> 8272
    //   5139: lload 19
    //   5141: lstore 21
    //   5143: aload_0
    //   5144: lload 17
    //   5146: lload 23
    //   5148: iload 11
    //   5150: invokevirtual 949	bhhf:a	(JJI)V
    //   5153: lload 19
    //   5155: lstore 21
    //   5157: aload_0
    //   5158: invokevirtual 951	bhhf:b	()V
    //   5161: iconst_0
    //   5162: istore 7
    //   5164: goto -220 -> 4944
    //   5167: iconst_0
    //   5168: istore 14
    //   5170: goto -332 -> 4838
    //   5173: aload 30
    //   5175: invokeinterface 915 1 0
    //   5180: astore 32
    //   5182: aload 32
    //   5184: astore 31
    //   5186: goto -255 -> 4931
    //   5189: iload 8
    //   5191: bipush 8
    //   5193: if_icmple +3180 -> 8373
    //   5196: bipush 137
    //   5198: aload 44
    //   5200: iconst_0
    //   5201: baload
    //   5202: if_icmpne +3171 -> 8373
    //   5205: bipush 80
    //   5207: aload 44
    //   5209: iconst_1
    //   5210: baload
    //   5211: if_icmpne +3162 -> 8373
    //   5214: bipush 78
    //   5216: aload 44
    //   5218: iconst_2
    //   5219: baload
    //   5220: if_icmpne +3153 -> 8373
    //   5223: bipush 71
    //   5225: aload 44
    //   5227: iconst_3
    //   5228: baload
    //   5229: if_icmpne +3144 -> 8373
    //   5232: bipush 13
    //   5234: aload 44
    //   5236: iconst_4
    //   5237: baload
    //   5238: if_icmpne +3135 -> 8373
    //   5241: bipush 10
    //   5243: aload 44
    //   5245: iconst_5
    //   5246: baload
    //   5247: if_icmpne +3126 -> 8373
    //   5250: bipush 26
    //   5252: aload 44
    //   5254: bipush 6
    //   5256: baload
    //   5257: if_icmpne +3116 -> 8373
    //   5260: bipush 10
    //   5262: aload 44
    //   5264: bipush 7
    //   5266: baload
    //   5267: if_icmpne +3106 -> 8373
    //   5270: ldc_w 953
    //   5273: astore 32
    //   5275: goto -253 -> 5022
    //   5278: lload 19
    //   5280: lstore 21
    //   5282: aload 33
    //   5284: invokevirtual 956	java/io/BufferedOutputStream:flush	()V
    //   5287: lload 19
    //   5289: lstore 21
    //   5291: invokestatic 926	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   5294: aload 44
    //   5296: invokevirtual 960	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   5299: lload 19
    //   5301: lstore 21
    //   5303: aload 36
    //   5305: invokevirtual 644	java/io/File:length	()J
    //   5308: lstore 23
    //   5310: lload 19
    //   5312: lstore 21
    //   5314: aload 43
    //   5316: ldc_w 962
    //   5319: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5322: lload 23
    //   5324: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5327: pop
    //   5328: lload 23
    //   5330: lload 17
    //   5332: lcmp
    //   5333: ifeq +80 -> 5413
    //   5336: lload 17
    //   5338: lconst_1
    //   5339: lcmp
    //   5340: ifge +21 -> 5361
    //   5343: lload 19
    //   5345: lstore 21
    //   5347: aload_0
    //   5348: getfield 893	bhhf:jdField_g_of_type_Boolean	Z
    //   5351: ifeq +10 -> 5361
    //   5354: lload 23
    //   5356: lconst_0
    //   5357: lcmp
    //   5358: ifgt +55 -> 5413
    //   5361: lload 19
    //   5363: lstore 21
    //   5365: aload 35
    //   5367: ldc_w 849
    //   5370: invokeinterface 881 2 0
    //   5375: ifnull +905 -> 6280
    //   5378: lload 19
    //   5380: lstore 21
    //   5382: ldc 166
    //   5384: aload 35
    //   5386: ldc_w 849
    //   5389: invokeinterface 881 2 0
    //   5394: invokeinterface 856 1 0
    //   5399: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5402: ifeq +878 -> 6280
    //   5405: lload 23
    //   5407: lload 17
    //   5409: lcmp
    //   5410: iflt +870 -> 6280
    //   5413: lload 19
    //   5415: lstore 21
    //   5417: aload_0
    //   5418: iconst_0
    //   5419: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   5422: aload 38
    //   5424: invokevirtual 297	java/io/File:exists	()Z
    //   5427: ifeq +9 -> 5436
    //   5430: aload 38
    //   5432: invokevirtual 303	java/io/File:delete	()Z
    //   5435: pop
    //   5436: aload 36
    //   5438: aload 38
    //   5440: invokevirtual 966	java/io/File:renameTo	(Ljava/io/File;)Z
    //   5443: istore 14
    //   5445: aload 43
    //   5447: ldc_w 968
    //   5450: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5453: iload 14
    //   5455: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5458: pop
    //   5459: aload_0
    //   5460: getfield 658	bhhf:j	Z
    //   5463: ifeq +158 -> 5621
    //   5466: aload 35
    //   5468: ldc_w 841
    //   5471: invokeinterface 971 2 0
    //   5476: ifeq +145 -> 5621
    //   5479: aload 35
    //   5481: ldc_w 841
    //   5484: invokeinterface 881 2 0
    //   5489: invokeinterface 856 1 0
    //   5494: astore 32
    //   5496: aload 32
    //   5498: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5501: istore 14
    //   5503: iload 14
    //   5505: ifne +116 -> 5621
    //   5508: new 662	java/text/SimpleDateFormat
    //   5511: dup
    //   5512: ldc_w 973
    //   5515: getstatic 670	java/util/Locale:US	Ljava/util/Locale;
    //   5518: invokespecial 673	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   5521: astore 34
    //   5523: aload 34
    //   5525: ldc_w 675
    //   5528: invokestatic 681	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   5531: invokevirtual 685	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   5534: aload 34
    //   5536: aload 32
    //   5538: invokevirtual 977	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   5541: invokevirtual 980	java/util/Date:getTime	()J
    //   5544: lstore 21
    //   5546: aload 38
    //   5548: lload 21
    //   5550: invokevirtual 984	java/io/File:setLastModified	(J)Z
    //   5553: pop
    //   5554: aload_0
    //   5555: lload 21
    //   5557: putfield 660	bhhf:jdField_i_of_type_Long	J
    //   5560: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5563: ifeq +58 -> 5621
    //   5566: ldc 77
    //   5568: iconst_2
    //   5569: new 126	java/lang/StringBuilder
    //   5572: dup
    //   5573: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5576: ldc_w 986
    //   5579: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5582: lload 21
    //   5584: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5587: ldc_w 988
    //   5590: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5593: aload 38
    //   5595: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   5598: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5601: ldc_w 990
    //   5604: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5607: aload 38
    //   5609: invokevirtual 864	java/io/File:lastModified	()J
    //   5612: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5615: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5618: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5621: iconst_0
    //   5622: istore 7
    //   5624: iload 5
    //   5626: istore 6
    //   5628: iload 7
    //   5630: istore 5
    //   5632: lload 19
    //   5634: lstore 21
    //   5636: aload 30
    //   5638: astore 32
    //   5640: aload 33
    //   5642: astore 30
    //   5644: iload 5
    //   5646: istore 7
    //   5648: iload 6
    //   5650: istore 5
    //   5652: lload 17
    //   5654: lstore 19
    //   5656: lload 21
    //   5658: lstore 17
    //   5660: iload 5
    //   5662: istore 6
    //   5664: getstatic 42	bhhh:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5667: ifnonnull +17 -> 5684
    //   5670: iload 5
    //   5672: istore 6
    //   5674: new 39	java/util/concurrent/ConcurrentHashMap
    //   5677: dup
    //   5678: invokespecial 40	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5681: putstatic 42	bhhh:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5684: iload 7
    //   5686: ifeq +1211 -> 6897
    //   5689: iload 5
    //   5691: istore 6
    //   5693: aload_0
    //   5694: invokevirtual 369	bhhf:b	()Z
    //   5697: ifne +1200 -> 6897
    //   5700: iload 5
    //   5702: istore 6
    //   5704: iload 12
    //   5706: aload_0
    //   5707: getfield 284	bhhf:jdField_b_of_type_Int	I
    //   5710: if_icmpge +1084 -> 6794
    //   5713: iload 5
    //   5715: istore 6
    //   5717: aload 41
    //   5719: monitorenter
    //   5720: sipush 2000
    //   5723: i2l
    //   5724: lstore 21
    //   5726: aload 41
    //   5728: lload 21
    //   5730: invokevirtual 993	java/lang/Object:wait	(J)V
    //   5733: aload 41
    //   5735: monitorexit
    //   5736: iload 5
    //   5738: istore 6
    //   5740: aload_0
    //   5741: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   5744: sipush 302
    //   5747: if_icmpne +44 -> 5791
    //   5750: iload 5
    //   5752: istore 6
    //   5754: aload 35
    //   5756: ldc_w 843
    //   5759: invokeinterface 881 2 0
    //   5764: astore 33
    //   5766: aload 33
    //   5768: ifnull +23 -> 5791
    //   5771: iload 5
    //   5773: istore 6
    //   5775: aload 37
    //   5777: ldc_w 995
    //   5780: aload 33
    //   5782: invokeinterface 856 1 0
    //   5787: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5790: pop
    //   5791: iload 7
    //   5793: istore 8
    //   5795: invokestatic 359	android/net/TrafficStats:clearThreadStatsTag	()V
    //   5798: iload 7
    //   5800: istore 8
    //   5802: ldc 77
    //   5804: iconst_1
    //   5805: new 126	java/lang/StringBuilder
    //   5808: dup
    //   5809: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5812: aload 43
    //   5814: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5817: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5820: ldc_w 361
    //   5823: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5826: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   5829: lload 27
    //   5831: lsub
    //   5832: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5835: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5838: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5841: iload 7
    //   5843: istore 8
    //   5845: aload_0
    //   5846: getfield 205	bhhf:jdField_g_of_type_Int	I
    //   5849: iconst_3
    //   5850: if_icmpne +64 -> 5914
    //   5853: iload 10
    //   5855: ifeq +59 -> 5914
    //   5858: iload 7
    //   5860: istore 8
    //   5862: bipush 30
    //   5864: aload_0
    //   5865: getfield 202	bhhf:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5868: sipush 300
    //   5871: iconst_1
    //   5872: anewarray 4	java/lang/Object
    //   5875: dup
    //   5876: iconst_0
    //   5877: new 126	java/lang/StringBuilder
    //   5880: dup
    //   5881: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   5884: aload 43
    //   5886: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5889: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5892: ldc_w 361
    //   5895: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5898: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   5901: lload 27
    //   5903: lsub
    //   5904: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5907: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5910: aastore
    //   5911: invokestatic 367	anaw:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   5914: iload 7
    //   5916: ifeq +119 -> 6035
    //   5919: iload 7
    //   5921: istore 8
    //   5923: aload_0
    //   5924: invokevirtual 369	bhhf:b	()Z
    //   5927: ifne +108 -> 6035
    //   5930: iload 7
    //   5932: istore 8
    //   5934: aload_0
    //   5935: getfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   5938: ifeq +97 -> 6035
    //   5941: iload 7
    //   5943: istore 8
    //   5945: aload 39
    //   5947: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   5950: ifeq +1001 -> 6951
    //   5953: iload 7
    //   5955: istore 8
    //   5957: aload 39
    //   5959: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5962: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5965: ifne +950 -> 6915
    //   5968: iload 7
    //   5970: istore 8
    //   5972: invokestatic 380	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   5975: aload 39
    //   5977: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5980: aload 39
    //   5982: getfield 374	arul:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5985: getstatic 34	bhhh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   5988: aload 39
    //   5990: getfield 381	arul:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5993: invokeinterface 222 2 0
    //   5998: checkcast 147	java/lang/Integer
    //   6001: invokevirtual 384	java/lang/Integer:intValue	()I
    //   6004: invokevirtual 388	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   6007: iload 7
    //   6009: istore 8
    //   6011: aload 39
    //   6013: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6016: aload 38
    //   6018: invokevirtual 236	java/io/File:getName	()Ljava/lang/String;
    //   6021: iconst_m1
    //   6022: aload_2
    //   6023: invokestatic 392	bhhh:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   6026: iload 7
    //   6028: istore 8
    //   6030: aload_0
    //   6031: iconst_0
    //   6032: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   6035: iload 7
    //   6037: istore 8
    //   6039: new 126	java/lang/StringBuilder
    //   6042: dup
    //   6043: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6046: astore 34
    //   6048: iload 7
    //   6050: istore 8
    //   6052: aload 39
    //   6054: getfield 396	arul:jdField_b_of_type_Boolean	Z
    //   6057: ifeq +2519 -> 8576
    //   6060: ldc_w 398
    //   6063: astore 33
    //   6065: iload 7
    //   6067: istore 8
    //   6069: aload 34
    //   6071: aload 33
    //   6073: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6076: astore 34
    //   6078: iload 7
    //   6080: istore 8
    //   6082: aload 39
    //   6084: getfield 372	arul:jdField_a_of_type_Boolean	Z
    //   6087: ifeq +2497 -> 8584
    //   6090: ldc_w 400
    //   6093: astore 33
    //   6095: iload 7
    //   6097: istore 8
    //   6099: aload 34
    //   6101: aload 33
    //   6103: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6109: astore 33
    //   6111: iload 12
    //   6113: iconst_1
    //   6114: iadd
    //   6115: istore 6
    //   6117: aload 32
    //   6119: ifnull +14 -> 6133
    //   6122: iload 7
    //   6124: istore 8
    //   6126: aload 32
    //   6128: invokeinterface 405 1 0
    //   6133: aload 31
    //   6135: ifnull +12 -> 6147
    //   6138: iload 7
    //   6140: istore 8
    //   6142: aload 31
    //   6144: invokevirtual 410	java/io/InputStream:close	()V
    //   6147: aload 30
    //   6149: ifnull +12 -> 6161
    //   6152: iload 7
    //   6154: istore 8
    //   6156: aload 30
    //   6158: invokevirtual 413	java/io/BufferedOutputStream:close	()V
    //   6161: iload 5
    //   6163: istore 8
    //   6165: iconst_1
    //   6166: istore 14
    //   6168: iload 6
    //   6170: istore 5
    //   6172: iload_3
    //   6173: istore 6
    //   6175: iload 7
    //   6177: istore_3
    //   6178: iload 8
    //   6180: istore 7
    //   6182: goto -4717 -> 1465
    //   6185: astore 34
    //   6187: ldc 77
    //   6189: iconst_1
    //   6190: new 126	java/lang/StringBuilder
    //   6193: dup
    //   6194: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6197: ldc_w 997
    //   6200: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6203: aload 32
    //   6205: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6208: ldc_w 999
    //   6211: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6214: aload 34
    //   6216: invokevirtual 1000	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6219: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6222: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6225: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6228: goto -607 -> 5621
    //   6231: astore 34
    //   6233: aload 33
    //   6235: astore 32
    //   6237: iconst_0
    //   6238: istore 8
    //   6240: aload 34
    //   6242: astore 33
    //   6244: iload 4
    //   6246: istore 7
    //   6248: aload 30
    //   6250: astore 34
    //   6252: iload 5
    //   6254: istore 4
    //   6256: iconst_1
    //   6257: istore 14
    //   6259: iload_3
    //   6260: istore 6
    //   6262: iload 7
    //   6264: istore 5
    //   6266: aload 32
    //   6268: astore 30
    //   6270: aload 34
    //   6272: astore 32
    //   6274: iload 8
    //   6276: istore_3
    //   6277: goto -5311 -> 966
    //   6280: lload 19
    //   6282: lstore 21
    //   6284: aload_0
    //   6285: invokevirtual 369	bhhf:b	()Z
    //   6288: istore 14
    //   6290: iload 14
    //   6292: ifeq +85 -> 6377
    //   6295: iconst_1
    //   6296: istore 7
    //   6298: bipush 150
    //   6300: istore 5
    //   6302: aload_0
    //   6303: bipush 150
    //   6305: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6308: iload 5
    //   6310: istore 6
    //   6312: aload 43
    //   6314: ldc_w 1002
    //   6317: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6320: pop
    //   6321: iload 7
    //   6323: istore 6
    //   6325: goto -693 -> 5632
    //   6328: astore 34
    //   6330: aload 33
    //   6332: astore 32
    //   6334: bipush 150
    //   6336: istore 7
    //   6338: iconst_1
    //   6339: istore 8
    //   6341: iconst_1
    //   6342: istore 14
    //   6344: aload 34
    //   6346: astore 33
    //   6348: iload 4
    //   6350: istore 5
    //   6352: aload 30
    //   6354: astore 34
    //   6356: iload_3
    //   6357: istore 6
    //   6359: iload 8
    //   6361: istore 4
    //   6363: aload 32
    //   6365: astore 30
    //   6367: aload 34
    //   6369: astore 32
    //   6371: iload 7
    //   6373: istore_3
    //   6374: goto -5408 -> 966
    //   6377: bipush 151
    //   6379: istore 7
    //   6381: lload 19
    //   6383: lstore 21
    //   6385: aload_0
    //   6386: bipush 151
    //   6388: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6391: iload 7
    //   6393: istore 6
    //   6395: aload 36
    //   6397: invokevirtual 303	java/io/File:delete	()Z
    //   6400: pop
    //   6401: iload 7
    //   6403: istore 6
    //   6405: new 67	java/lang/Exception
    //   6408: dup
    //   6409: ldc_w 1004
    //   6412: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6415: athrow
    //   6416: astore 35
    //   6418: aload 33
    //   6420: astore 32
    //   6422: bipush 151
    //   6424: istore 8
    //   6426: iload 4
    //   6428: istore 7
    //   6430: aload 30
    //   6432: astore 34
    //   6434: iconst_1
    //   6435: istore 14
    //   6437: iload 5
    //   6439: istore 4
    //   6441: aload 35
    //   6443: astore 33
    //   6445: iload_3
    //   6446: istore 6
    //   6448: iload 7
    //   6450: istore 5
    //   6452: aload 32
    //   6454: astore 30
    //   6456: aload 34
    //   6458: astore 32
    //   6460: iload 8
    //   6462: istore_3
    //   6463: goto -5497 -> 966
    //   6466: sipush 404
    //   6469: iload 8
    //   6471: if_icmpne +2029 -> 8500
    //   6474: iconst_1
    //   6475: istore 5
    //   6477: iconst_1
    //   6478: istore 7
    //   6480: aload_0
    //   6481: iload 8
    //   6483: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6486: lload 17
    //   6488: lstore 21
    //   6490: iload 8
    //   6492: istore 7
    //   6494: aload 32
    //   6496: astore 30
    //   6498: lload 19
    //   6500: lstore 17
    //   6502: lload 21
    //   6504: lstore 19
    //   6506: aload 33
    //   6508: astore 32
    //   6510: goto -850 -> 5660
    //   6513: iload 5
    //   6515: istore 7
    //   6517: aload_0
    //   6518: getfield 280	bhhf:p	Z
    //   6521: ifne +82 -> 6603
    //   6524: iconst_1
    //   6525: istore 13
    //   6527: iconst_1
    //   6528: istore 7
    //   6530: iload 13
    //   6532: istore 5
    //   6534: aload_0
    //   6535: getfield 490	bhhf:r	Z
    //   6538: ifeq +28 -> 6566
    //   6541: iload 13
    //   6543: istore 5
    //   6545: iload 8
    //   6547: sipush 302
    //   6550: if_icmpne +16 -> 6566
    //   6553: iload 13
    //   6555: istore 5
    //   6557: iload 12
    //   6559: iconst_m1
    //   6560: if_icmpne +6 -> 6566
    //   6563: iconst_0
    //   6564: istore 5
    //   6566: iload 5
    //   6568: istore 7
    //   6570: aload_0
    //   6571: iload 8
    //   6573: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6576: lload 17
    //   6578: lstore 21
    //   6580: iload 8
    //   6582: istore 7
    //   6584: aload 32
    //   6586: astore 30
    //   6588: lload 19
    //   6590: lstore 17
    //   6592: lload 21
    //   6594: lstore 19
    //   6596: aload 33
    //   6598: astore 32
    //   6600: goto -940 -> 5660
    //   6603: sipush 304
    //   6606: iload 8
    //   6608: if_icmpne +38 -> 6646
    //   6611: iload 5
    //   6613: istore 7
    //   6615: aload_0
    //   6616: iconst_0
    //   6617: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6620: lload 17
    //   6622: lstore 21
    //   6624: iconst_0
    //   6625: istore 7
    //   6627: aload 32
    //   6629: astore 30
    //   6631: lload 19
    //   6633: lstore 17
    //   6635: lload 21
    //   6637: lstore 19
    //   6639: aload 33
    //   6641: astore 32
    //   6643: goto -983 -> 5660
    //   6646: sipush 416
    //   6649: iload 8
    //   6651: if_icmpne +62 -> 6713
    //   6654: iload 5
    //   6656: istore 7
    //   6658: aload 36
    //   6660: invokevirtual 297	java/io/File:exists	()Z
    //   6663: ifeq +13 -> 6676
    //   6666: iload 5
    //   6668: istore 7
    //   6670: aload 36
    //   6672: invokevirtual 303	java/io/File:delete	()Z
    //   6675: pop
    //   6676: iload 5
    //   6678: istore 7
    //   6680: aload_0
    //   6681: iload 8
    //   6683: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6686: lload 17
    //   6688: lstore 21
    //   6690: iload 8
    //   6692: istore 7
    //   6694: aload 32
    //   6696: astore 30
    //   6698: lload 19
    //   6700: lstore 17
    //   6702: lload 21
    //   6704: lstore 19
    //   6706: aload 33
    //   6708: astore 32
    //   6710: goto -1050 -> 5660
    //   6713: iload 5
    //   6715: istore 7
    //   6717: aload_0
    //   6718: iload 8
    //   6720: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   6723: lload 17
    //   6725: lstore 21
    //   6727: iload 8
    //   6729: istore 7
    //   6731: aload 32
    //   6733: astore 30
    //   6735: lload 19
    //   6737: lstore 17
    //   6739: lload 21
    //   6741: lstore 19
    //   6743: aload 33
    //   6745: astore 32
    //   6747: goto -1087 -> 5660
    //   6750: astore 33
    //   6752: ldc 77
    //   6754: iconst_1
    //   6755: new 126	java/lang/StringBuilder
    //   6758: dup
    //   6759: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6762: ldc_w 1006
    //   6765: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6768: aload 29
    //   6770: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6773: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6776: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6779: goto -1046 -> 5733
    //   6782: astore 33
    //   6784: aload 41
    //   6786: monitorexit
    //   6787: iload 5
    //   6789: istore 6
    //   6791: aload 33
    //   6793: athrow
    //   6794: iload 5
    //   6796: istore 6
    //   6798: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   6801: ldc2_w 1007
    //   6804: ldiv
    //   6805: l2i
    //   6806: istore 8
    //   6808: iload 5
    //   6810: istore 6
    //   6812: aload_0
    //   6813: getfield 1010	bhhf:jdField_c_of_type_Boolean	Z
    //   6816: ifeq +23 -> 6839
    //   6819: iload 5
    //   6821: istore 6
    //   6823: getstatic 42	bhhh:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6826: aload_0
    //   6827: getfield 1012	bhhf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6830: iload 8
    //   6832: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6835: invokevirtual 1013	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6838: pop
    //   6839: iconst_1
    //   6840: istore 6
    //   6842: new 67	java/lang/Exception
    //   6845: dup
    //   6846: new 126	java/lang/StringBuilder
    //   6849: dup
    //   6850: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6853: ldc_w 1015
    //   6856: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6859: aload 29
    //   6861: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6864: ldc_w 1017
    //   6867: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6870: aload_0
    //   6871: getfield 371	bhhf:jdField_e_of_type_Boolean	Z
    //   6874: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6877: ldc_w 1019
    //   6880: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6883: aload_0
    //   6884: getfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   6887: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6890: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6893: invokespecial 324	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6896: athrow
    //   6897: iload 5
    //   6899: istore 6
    //   6901: getstatic 42	bhhh:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6904: aload_0
    //   6905: getfield 1012	bhhf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6908: invokevirtual 1022	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6911: pop
    //   6912: goto -1176 -> 5736
    //   6915: iload 7
    //   6917: istore 8
    //   6919: invokestatic 1027	bdud:a	()Lbdud;
    //   6922: astore 33
    //   6924: aload 33
    //   6926: ifnull -919 -> 6007
    //   6929: iload 7
    //   6931: istore 8
    //   6933: aload 33
    //   6935: aload 39
    //   6937: getfield 1029	arul:jdField_d_of_type_Int	I
    //   6940: aload 39
    //   6942: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6945: invokevirtual 1031	bdud:a	(ILjava/lang/String;)V
    //   6948: goto -941 -> 6007
    //   6951: iload 7
    //   6953: istore 8
    //   6955: aload_0
    //   6956: iconst_1
    //   6957: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   6960: goto -925 -> 6035
    //   6963: astore 34
    //   6965: iload 7
    //   6967: istore 8
    //   6969: ldc 77
    //   6971: iconst_1
    //   6972: new 126	java/lang/StringBuilder
    //   6975: dup
    //   6976: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   6979: ldc_w 1033
    //   6982: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6985: aload 34
    //   6987: invokevirtual 1034	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6990: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6993: ldc_w 1036
    //   6996: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6999: aload 29
    //   7001: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7004: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7007: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7010: iload 5
    //   7012: istore 8
    //   7014: iconst_1
    //   7015: istore 14
    //   7017: iload 6
    //   7019: istore 5
    //   7021: iload_3
    //   7022: istore 6
    //   7024: iload 7
    //   7026: istore_3
    //   7027: iload 8
    //   7029: istore 7
    //   7031: goto -5566 -> 1465
    //   7034: aload 33
    //   7036: instanceof 1038
    //   7039: ifeq +12 -> 7051
    //   7042: aload_0
    //   7043: bipush 144
    //   7045: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7048: goto -6038 -> 1010
    //   7051: aload 33
    //   7053: instanceof 326
    //   7056: ifne +11 -> 7067
    //   7059: aload 33
    //   7061: instanceof 328
    //   7064: ifeq +12 -> 7076
    //   7067: aload_0
    //   7068: bipush 143
    //   7070: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7073: goto -6063 -> 1010
    //   7076: aload 33
    //   7078: instanceof 330
    //   7081: ifeq +12 -> 7093
    //   7084: aload_0
    //   7085: bipush 142
    //   7087: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7090: goto -6080 -> 1010
    //   7093: aload_0
    //   7094: getfield 121	bhhf:jdField_a_of_type_Int	I
    //   7097: ifne -6087 -> 1010
    //   7100: aload_0
    //   7101: bipush 141
    //   7103: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7106: goto -6096 -> 1010
    //   7109: aload_0
    //   7110: iconst_0
    //   7111: putfield 338	bhhf:jdField_f_of_type_Boolean	Z
    //   7114: goto -6075 -> 1039
    //   7117: iload_3
    //   7118: istore 8
    //   7120: invokestatic 1027	bdud:a	()Lbdud;
    //   7123: astore 33
    //   7125: aload 33
    //   7127: ifnull -5834 -> 1293
    //   7130: iload_3
    //   7131: istore 8
    //   7133: aload 33
    //   7135: aload 39
    //   7137: getfield 1029	arul:jdField_d_of_type_Int	I
    //   7140: aload 39
    //   7142: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7145: invokevirtual 1031	bdud:a	(ILjava/lang/String;)V
    //   7148: goto -5855 -> 1293
    //   7151: iload_3
    //   7152: istore 8
    //   7154: aload_0
    //   7155: iconst_1
    //   7156: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   7159: goto -5840 -> 1319
    //   7162: astore 34
    //   7164: iload_3
    //   7165: istore 8
    //   7167: ldc 77
    //   7169: iconst_1
    //   7170: new 126	java/lang/StringBuilder
    //   7173: dup
    //   7174: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7177: ldc_w 1033
    //   7180: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7183: aload 34
    //   7185: invokevirtual 1034	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7188: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7191: ldc_w 1036
    //   7194: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7197: aload 29
    //   7199: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7202: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7205: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7208: iload 7
    //   7210: istore 8
    //   7212: lload 17
    //   7214: lstore 21
    //   7216: iload 5
    //   7218: istore 12
    //   7220: iload 4
    //   7222: istore 7
    //   7224: lload 19
    //   7226: lstore 17
    //   7228: iload 8
    //   7230: istore 5
    //   7232: lload 21
    //   7234: lstore 19
    //   7236: iload 12
    //   7238: istore 4
    //   7240: goto -5775 -> 1465
    //   7243: iload 6
    //   7245: istore 4
    //   7247: invokestatic 1027	bdud:a	()Lbdud;
    //   7250: astore 30
    //   7252: aload 30
    //   7254: ifnull -4748 -> 2506
    //   7257: iload 6
    //   7259: istore 4
    //   7261: aload 30
    //   7263: aload 39
    //   7265: getfield 1029	arul:jdField_d_of_type_Int	I
    //   7268: aload 39
    //   7270: getfield 389	arul:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7273: invokevirtual 1031	bdud:a	(ILjava/lang/String;)V
    //   7276: goto -4770 -> 2506
    //   7279: iload 6
    //   7281: istore 4
    //   7283: aload_0
    //   7284: iconst_1
    //   7285: putfield 394	bhhf:jdField_d_of_type_Boolean	Z
    //   7288: goto -4754 -> 2534
    //   7291: astore_0
    //   7292: iload 6
    //   7294: istore 4
    //   7296: ldc 77
    //   7298: iconst_1
    //   7299: new 126	java/lang/StringBuilder
    //   7302: dup
    //   7303: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7306: ldc_w 1033
    //   7309: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7312: aload_0
    //   7313: invokevirtual 1034	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7316: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7319: ldc_w 1036
    //   7322: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7325: aload 29
    //   7327: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7330: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7333: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7336: goto -4691 -> 2645
    //   7339: iload 4
    //   7341: istore 8
    //   7343: aload_0
    //   7344: bipush 146
    //   7346: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7349: iload 4
    //   7351: istore 8
    //   7353: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7356: ifeq +16 -> 7372
    //   7359: iload 4
    //   7361: istore 8
    //   7363: ldc 77
    //   7365: iconst_2
    //   7366: ldc_w 1040
    //   7369: invokestatic 861	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7372: lconst_0
    //   7373: lstore 19
    //   7375: iconst_m1
    //   7376: istore 6
    //   7378: iconst_m1
    //   7379: istore 4
    //   7381: lconst_0
    //   7382: lstore 17
    //   7384: aload 29
    //   7386: astore 32
    //   7388: iload_3
    //   7389: istore 5
    //   7391: aload 30
    //   7393: astore 29
    //   7395: aload 31
    //   7397: astore 30
    //   7399: aload 32
    //   7401: astore 31
    //   7403: aload 33
    //   7405: astore 32
    //   7407: aload 34
    //   7409: astore 33
    //   7411: iload 4
    //   7413: istore_3
    //   7414: goto -5866 -> 1548
    //   7417: iconst_0
    //   7418: istore 15
    //   7420: goto -5646 -> 1774
    //   7423: iload_3
    //   7424: istore 4
    //   7426: aload_0
    //   7427: getfield 1043	bhhf:o	Z
    //   7430: istore 15
    //   7432: iload 15
    //   7434: iconst_1
    //   7435: if_icmpne +823 -> 8258
    //   7438: iload_3
    //   7439: istore 4
    //   7441: iload 9
    //   7443: ifle +809 -> 8252
    //   7446: iload 4
    //   7448: istore 8
    //   7450: aload_0
    //   7451: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7454: invokeinterface 177 1 0
    //   7459: iconst_1
    //   7460: if_icmple +792 -> 8252
    //   7463: iload 4
    //   7465: istore 8
    //   7467: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7470: ifeq +52 -> 7522
    //   7473: iload 4
    //   7475: istore 8
    //   7477: ldc 77
    //   7479: iconst_2
    //   7480: new 126	java/lang/StringBuilder
    //   7483: dup
    //   7484: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   7487: ldc_w 1045
    //   7490: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7493: iload 9
    //   7495: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7498: ldc_w 1047
    //   7501: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7504: aload_0
    //   7505: getfield 171	bhhf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7508: invokeinterface 177 1 0
    //   7513: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7516: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7519: invokestatic 861	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7522: iload 4
    //   7524: istore 8
    //   7526: aload_0
    //   7527: bipush 148
    //   7529: putfield 121	bhhf:jdField_a_of_type_Int	I
    //   7532: iconst_m1
    //   7533: istore_3
    //   7534: iload_3
    //   7535: istore 5
    //   7537: aload_0
    //   7538: invokevirtual 369	bhhf:b	()Z
    //   7541: ifeq +43 -> 7584
    //   7544: iload_3
    //   7545: istore 5
    //   7547: aload_0
    //   7548: getfield 1049	bhhf:jdField_i_of_type_Boolean	Z
    //   7551: ifne +33 -> 7584
    //   7554: iload_3
    //   7555: istore 4
    //   7557: iload_3
    //   7558: istore 5
    //   7560: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7563: ifeq -4895 -> 2668
    //   7566: iload_3
    //   7567: istore 5
    //   7569: ldc 77
    //   7571: iconst_2
    //   7572: ldc_w 1051
    //   7575: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7578: iload_3
    //   7579: istore 4
    //   7581: goto -4913 -> 2668
    //   7584: iload_3
    //   7585: istore 5
    //   7587: aload_0
    //   7588: invokevirtual 369	bhhf:b	()Z
    //   7591: ifeq +1053 -> 8644
    //   7594: iload_3
    //   7595: istore 5
    //   7597: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7600: ifeq +15 -> 7615
    //   7603: iload_3
    //   7604: istore 5
    //   7606: ldc 77
    //   7608: iconst_2
    //   7609: ldc_w 1053
    //   7612: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7615: iload_3
    //   7616: istore 5
    //   7618: aload_0
    //   7619: iconst_2
    //   7620: invokevirtual 1055	bhhf:a	(I)V
    //   7623: iload_3
    //   7624: istore 5
    //   7626: aload_0
    //   7627: invokevirtual 1057	bhhf:c	()V
    //   7630: iload_3
    //   7631: istore 5
    //   7633: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7636: ifeq +15 -> 7651
    //   7639: iload_3
    //   7640: istore 5
    //   7642: ldc 77
    //   7644: iconst_2
    //   7645: ldc_w 1059
    //   7648: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7651: iload_3
    //   7652: istore 5
    //   7654: aload_0
    //   7655: invokevirtual 124	bhhf:e	()V
    //   7658: iload_3
    //   7659: istore 4
    //   7661: goto -4993 -> 2668
    //   7664: iload_3
    //   7665: istore 5
    //   7667: aload_0
    //   7668: iload 4
    //   7670: invokevirtual 1055	bhhf:a	(I)V
    //   7673: goto -43 -> 7630
    //   7676: iconst_m1
    //   7677: istore 4
    //   7679: goto -15 -> 7664
    //   7682: astore_0
    //   7683: iconst_m1
    //   7684: istore_3
    //   7685: goto -5030 -> 2655
    //   7688: astore 32
    //   7690: goto -5626 -> 2064
    //   7693: astore_1
    //   7694: aload 35
    //   7696: astore 29
    //   7698: goto -5408 -> 2290
    //   7701: astore_1
    //   7702: aload 30
    //   7704: astore 33
    //   7706: goto -5416 -> 2290
    //   7709: astore_1
    //   7710: aload 33
    //   7712: astore 32
    //   7714: aload 30
    //   7716: astore 33
    //   7718: goto -5428 -> 2290
    //   7721: astore_1
    //   7722: aload 32
    //   7724: astore 31
    //   7726: aload 33
    //   7728: astore 32
    //   7730: aload 30
    //   7732: astore 33
    //   7734: goto -5444 -> 2290
    //   7737: astore_1
    //   7738: aload 33
    //   7740: astore 32
    //   7742: aload 30
    //   7744: astore 33
    //   7746: goto -5456 -> 2290
    //   7749: astore_1
    //   7750: iconst_0
    //   7751: istore 6
    //   7753: aload 33
    //   7755: astore 32
    //   7757: aload 30
    //   7759: astore 33
    //   7761: goto -5471 -> 2290
    //   7764: astore_1
    //   7765: aload 33
    //   7767: astore 32
    //   7769: aload 30
    //   7771: astore 33
    //   7773: goto -5483 -> 2290
    //   7776: astore 29
    //   7778: aload 33
    //   7780: astore 35
    //   7782: iconst_0
    //   7783: istore 14
    //   7785: aload 32
    //   7787: astore 30
    //   7789: iload 6
    //   7791: istore 8
    //   7793: aload 29
    //   7795: astore 33
    //   7797: aload 34
    //   7799: astore 29
    //   7801: iload 7
    //   7803: istore 6
    //   7805: iload_3
    //   7806: istore 5
    //   7808: aload 35
    //   7810: astore 32
    //   7812: iload 8
    //   7814: istore_3
    //   7815: goto -6849 -> 966
    //   7818: astore 30
    //   7820: iconst_1
    //   7821: istore 8
    //   7823: aload 33
    //   7825: astore 34
    //   7827: iconst_0
    //   7828: istore 14
    //   7830: aload 30
    //   7832: astore 33
    //   7834: iload 5
    //   7836: istore 4
    //   7838: aload 32
    //   7840: astore 30
    //   7842: iload 6
    //   7844: istore 7
    //   7846: iload 8
    //   7848: istore 6
    //   7850: iload_3
    //   7851: istore 5
    //   7853: aload 34
    //   7855: astore 32
    //   7857: iload 7
    //   7859: istore_3
    //   7860: goto -6894 -> 966
    //   7863: astore 35
    //   7865: iload_3
    //   7866: istore 7
    //   7868: iload 4
    //   7870: istore_3
    //   7871: iconst_0
    //   7872: istore 14
    //   7874: aload 33
    //   7876: astore 34
    //   7878: iload 5
    //   7880: istore 4
    //   7882: aload 32
    //   7884: astore 30
    //   7886: iload 6
    //   7888: istore 8
    //   7890: aload 35
    //   7892: astore 33
    //   7894: iload 7
    //   7896: istore 6
    //   7898: iload_3
    //   7899: istore 5
    //   7901: aload 34
    //   7903: astore 32
    //   7905: iload 8
    //   7907: istore_3
    //   7908: goto -6942 -> 966
    //   7911: astore 33
    //   7913: iconst_1
    //   7914: istore 14
    //   7916: iload 4
    //   7918: istore 7
    //   7920: aload 30
    //   7922: astore 34
    //   7924: iload 6
    //   7926: istore 8
    //   7928: iload_3
    //   7929: istore 6
    //   7931: iload 5
    //   7933: istore 4
    //   7935: iload 7
    //   7937: istore 5
    //   7939: aload 32
    //   7941: astore 30
    //   7943: aload 34
    //   7945: astore 32
    //   7947: iload 8
    //   7949: istore_3
    //   7950: goto -6984 -> 966
    //   7953: astore 33
    //   7955: iload 6
    //   7957: istore 8
    //   7959: iload 4
    //   7961: istore 5
    //   7963: aload 30
    //   7965: astore 34
    //   7967: iconst_1
    //   7968: istore 14
    //   7970: iload 7
    //   7972: istore 4
    //   7974: lload 21
    //   7976: lstore 17
    //   7978: iload_3
    //   7979: istore 6
    //   7981: aload 32
    //   7983: astore 30
    //   7985: aload 34
    //   7987: astore 32
    //   7989: iload 8
    //   7991: istore_3
    //   7992: goto -7026 -> 966
    //   7995: astore 35
    //   7997: aload 33
    //   7999: astore 32
    //   8001: iload 6
    //   8003: istore 7
    //   8005: iload 4
    //   8007: istore 8
    //   8009: aload 30
    //   8011: astore 34
    //   8013: iconst_1
    //   8014: istore 14
    //   8016: iload 5
    //   8018: istore 4
    //   8020: aload 35
    //   8022: astore 33
    //   8024: iload_3
    //   8025: istore 6
    //   8027: iload 8
    //   8029: istore 5
    //   8031: aload 32
    //   8033: astore 30
    //   8035: aload 34
    //   8037: astore 32
    //   8039: iload 7
    //   8041: istore_3
    //   8042: goto -7076 -> 966
    //   8045: astore 35
    //   8047: aload 33
    //   8049: astore 31
    //   8051: iload 6
    //   8053: istore 7
    //   8055: iload 4
    //   8057: istore 8
    //   8059: aload 30
    //   8061: astore 34
    //   8063: iload 5
    //   8065: istore 4
    //   8067: iconst_1
    //   8068: istore 14
    //   8070: aload 35
    //   8072: astore 33
    //   8074: iload_3
    //   8075: istore 6
    //   8077: iload 8
    //   8079: istore 5
    //   8081: aload 31
    //   8083: astore 30
    //   8085: aload 32
    //   8087: astore 31
    //   8089: aload 34
    //   8091: astore 32
    //   8093: iload 7
    //   8095: istore_3
    //   8096: goto -7130 -> 966
    //   8099: astore 35
    //   8101: aload 33
    //   8103: astore 32
    //   8105: iload 6
    //   8107: istore 7
    //   8109: iload 4
    //   8111: istore 8
    //   8113: aload 30
    //   8115: astore 34
    //   8117: iconst_1
    //   8118: istore 14
    //   8120: iload 5
    //   8122: istore 4
    //   8124: aload 35
    //   8126: astore 33
    //   8128: iload_3
    //   8129: istore 6
    //   8131: iload 8
    //   8133: istore 5
    //   8135: aload 32
    //   8137: astore 30
    //   8139: aload 34
    //   8141: astore 32
    //   8143: iload 7
    //   8145: istore_3
    //   8146: goto -7180 -> 966
    //   8149: astore 35
    //   8151: lload 21
    //   8153: lstore 19
    //   8155: aload 33
    //   8157: astore 32
    //   8159: iload 6
    //   8161: istore 7
    //   8163: iload 4
    //   8165: istore 8
    //   8167: aload 30
    //   8169: astore 34
    //   8171: iconst_1
    //   8172: istore 14
    //   8174: iload 5
    //   8176: istore 4
    //   8178: aload 35
    //   8180: astore 33
    //   8182: iload_3
    //   8183: istore 6
    //   8185: iload 8
    //   8187: istore 5
    //   8189: aload 32
    //   8191: astore 30
    //   8193: aload 34
    //   8195: astore 32
    //   8197: iload 7
    //   8199: istore_3
    //   8200: goto -7234 -> 966
    //   8203: astore 34
    //   8205: aload 33
    //   8207: astore 32
    //   8209: iload 6
    //   8211: istore 7
    //   8213: iconst_1
    //   8214: istore 8
    //   8216: iconst_1
    //   8217: istore 14
    //   8219: aload 34
    //   8221: astore 33
    //   8223: iload 4
    //   8225: istore 5
    //   8227: aload 30
    //   8229: astore 34
    //   8231: iload_3
    //   8232: istore 6
    //   8234: iload 8
    //   8236: istore 4
    //   8238: aload 32
    //   8240: astore 30
    //   8242: aload 34
    //   8244: astore 32
    //   8246: iload 7
    //   8248: istore_3
    //   8249: goto -7283 -> 966
    //   8252: iload 4
    //   8254: istore_3
    //   8255: goto -721 -> 7534
    //   8258: iload 9
    //   8260: istore 4
    //   8262: goto -6188 -> 2074
    //   8265: aload 37
    //   8267: astore 34
    //   8269: goto -6697 -> 1572
    //   8272: goto -3328 -> 4944
    //   8275: iload 7
    //   8277: istore 4
    //   8279: goto -4403 -> 3876
    //   8282: iload_3
    //   8283: istore 4
    //   8285: iload 7
    //   8287: istore_3
    //   8288: goto -4402 -> 3886
    //   8291: iload 8
    //   8293: istore 5
    //   8295: goto -5257 -> 3038
    //   8298: aload 32
    //   8300: astore 33
    //   8302: iload_3
    //   8303: istore 8
    //   8305: iload 4
    //   8307: istore_3
    //   8308: lload 19
    //   8310: lstore 21
    //   8312: iload 6
    //   8314: istore 7
    //   8316: lload 17
    //   8318: lstore 19
    //   8320: lload 21
    //   8322: lstore 17
    //   8324: aload 30
    //   8326: astore 32
    //   8328: iload 8
    //   8330: istore 6
    //   8332: iload 5
    //   8334: istore 12
    //   8336: goto -7707 -> 629
    //   8339: iconst_m1
    //   8340: istore_3
    //   8341: iload_3
    //   8342: ireturn
    //   8343: iconst_m1
    //   8344: ireturn
    //   8345: ldc_w 866
    //   8348: astore 29
    //   8350: goto -8163 -> 187
    //   8353: iconst_1
    //   8354: istore 7
    //   8356: goto -7360 -> 996
    //   8359: iload_3
    //   8360: ifne -943 -> 7417
    //   8363: iconst_1
    //   8364: istore 15
    //   8366: goto -6592 -> 1774
    //   8369: astore_1
    //   8370: goto -6080 -> 2290
    //   8373: aload 34
    //   8375: astore 32
    //   8377: iload 8
    //   8379: bipush 12
    //   8381: if_icmple -3359 -> 5022
    //   8384: aload 34
    //   8386: astore 32
    //   8388: bipush 82
    //   8390: aload 44
    //   8392: iconst_0
    //   8393: baload
    //   8394: if_icmpne -3372 -> 5022
    //   8397: aload 34
    //   8399: astore 32
    //   8401: bipush 73
    //   8403: aload 44
    //   8405: iconst_1
    //   8406: baload
    //   8407: if_icmpne -3385 -> 5022
    //   8410: aload 34
    //   8412: astore 32
    //   8414: bipush 70
    //   8416: aload 44
    //   8418: iconst_2
    //   8419: baload
    //   8420: if_icmpne -3398 -> 5022
    //   8423: aload 34
    //   8425: astore 32
    //   8427: bipush 70
    //   8429: aload 44
    //   8431: iconst_3
    //   8432: baload
    //   8433: if_icmpne -3411 -> 5022
    //   8436: aload 34
    //   8438: astore 32
    //   8440: bipush 87
    //   8442: aload 44
    //   8444: bipush 8
    //   8446: baload
    //   8447: if_icmpne -3425 -> 5022
    //   8450: aload 34
    //   8452: astore 32
    //   8454: bipush 69
    //   8456: aload 44
    //   8458: bipush 9
    //   8460: baload
    //   8461: if_icmpne -3439 -> 5022
    //   8464: aload 34
    //   8466: astore 32
    //   8468: bipush 66
    //   8470: aload 44
    //   8472: bipush 10
    //   8474: baload
    //   8475: if_icmpne -3453 -> 5022
    //   8478: aload 34
    //   8480: astore 32
    //   8482: bipush 80
    //   8484: aload 44
    //   8486: bipush 11
    //   8488: baload
    //   8489: if_icmpne -3467 -> 5022
    //   8492: ldc_w 1061
    //   8495: astore 32
    //   8497: goto -3475 -> 5022
    //   8500: sipush 302
    //   8503: iload 8
    //   8505: if_icmpeq -1992 -> 6513
    //   8508: sipush 301
    //   8511: iload 8
    //   8513: if_icmpne -1910 -> 6603
    //   8516: goto -2003 -> 6513
    //   8519: astore 33
    //   8521: iconst_1
    //   8522: istore 14
    //   8524: iload 4
    //   8526: istore 5
    //   8528: lload 19
    //   8530: lstore 21
    //   8532: iload 6
    //   8534: istore 4
    //   8536: iload_3
    //   8537: istore 6
    //   8539: lload 17
    //   8541: lstore 19
    //   8543: lload 21
    //   8545: lstore 17
    //   8547: iload 7
    //   8549: istore_3
    //   8550: goto -7584 -> 966
    //   8553: astore_1
    //   8554: aload 32
    //   8556: astore 33
    //   8558: iload 7
    //   8560: istore 6
    //   8562: aload 30
    //   8564: astore 32
    //   8566: goto -6276 -> 2290
    //   8569: astore_0
    //   8570: iload 8
    //   8572: istore_3
    //   8573: goto -5918 -> 2655
    //   8576: ldc_w 1063
    //   8579: astore 33
    //   8581: goto -2516 -> 6065
    //   8584: ldc_w 1065
    //   8587: astore 33
    //   8589: goto -2494 -> 6095
    //   8592: astore_1
    //   8593: aload 32
    //   8595: astore 33
    //   8597: aload 30
    //   8599: astore 32
    //   8601: iload_3
    //   8602: istore 6
    //   8604: goto -6314 -> 2290
    //   8607: ldc_w 1063
    //   8610: astore 33
    //   8612: goto -7265 -> 1347
    //   8615: ldc_w 1065
    //   8618: astore 33
    //   8620: goto -7245 -> 1375
    //   8623: ldc_w 1063
    //   8626: astore_0
    //   8627: goto -6065 -> 2562
    //   8630: ldc_w 1065
    //   8633: astore_0
    //   8634: goto -6046 -> 2588
    //   8637: astore_0
    //   8638: iload 5
    //   8640: istore_3
    //   8641: goto -5986 -> 2655
    //   8644: iload_3
    //   8645: ifne -969 -> 7676
    //   8648: iconst_3
    //   8649: istore 4
    //   8651: goto -987 -> 7664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8654	0	parambhhf	bhhf
    //   0	8654	1	paramString	String
    //   0	8654	2	paramContext	Context
    //   16	8629	3	i	int
    //   63	8587	4	j	int
    //   70	8569	5	k	int
    //   612	7991	6	m	int
    //   606	7953	7	n	int
    //   307	8264	8	i1	int
    //   281	7978	9	i2	int
    //   298	5556	10	i3	int
    //   301	4848	11	i4	int
    //   609	7726	12	i5	int
    //   713	5841	13	i6	int
    //   284	8239	14	bool1	boolean
    //   1493	6872	15	bool2	boolean
    //   1793	3	16	bool3	boolean
    //   353	8193	17	l1	long
    //   615	7927	19	l2	long
    //   1443	7101	21	l3	long
    //   4401	1005	23	l4	long
    //   337	1715	25	l5	long
    //   636	5266	27	l6	long
    //   185	7512	29	localObject1	Object
    //   7776	18	29	localThrowable1	java.lang.Throwable
    //   7799	550	29	localObject2	Object
    //   203	7585	30	localObject3	Object
    //   7818	13	30	localThrowable2	java.lang.Throwable
    //   7840	758	30	localObject4	Object
    //   200	7888	31	localObject5	Object
    //   553	6853	32	localObject6	Object
    //   7688	1	32	localThrowable3	java.lang.Throwable
    //   7712	888	32	localObject7	Object
    //   386	4093	33	localObject8	Object
    //   4675	1	33	localThrowable4	java.lang.Throwable
    //   4823	1921	33	localObject9	Object
    //   6750	1	33	localInterruptedException	java.lang.InterruptedException
    //   6782	10	33	localObject10	Object
    //   6922	971	33	localObject11	Object
    //   7911	1	33	localThrowable5	java.lang.Throwable
    //   7953	45	33	localThrowable6	java.lang.Throwable
    //   8022	279	33	localObject12	Object
    //   8519	1	33	localThrowable7	java.lang.Throwable
    //   8556	63	33	localObject13	Object
    //   478	366	34	localObject14	Object
    //   927	36	34	localThrowable8	java.lang.Throwable
    //   1329	2939	34	localObject15	Object
    //   4281	22	34	localThrowable9	java.lang.Throwable
    //   4463	1637	34	localObject16	Object
    //   6185	30	34	localException	java.lang.Exception
    //   6231	10	34	localThrowable10	java.lang.Throwable
    //   6250	21	34	localObject17	Object
    //   6328	17	34	localThrowable11	java.lang.Throwable
    //   6354	103	34	localObject18	Object
    //   6963	23	34	localIOException1	java.io.IOException
    //   7162	636	34	localIOException2	java.io.IOException
    //   7825	369	34	localObject19	Object
    //   8203	17	34	localThrowable12	java.lang.Throwable
    //   8229	250	34	localObject20	Object
    //   717	2368	35	localObject21	Object
    //   3147	22	35	localThrowable13	java.lang.Throwable
    //   3191	2564	35	localObject22	Object
    //   6416	1279	35	localThrowable14	java.lang.Throwable
    //   7780	29	35	localObject23	Object
    //   7863	28	35	localThrowable15	java.lang.Throwable
    //   7995	26	35	localThrowable16	java.lang.Throwable
    //   8045	26	35	localThrowable17	java.lang.Throwable
    //   8099	26	35	localThrowable18	java.lang.Throwable
    //   8149	30	35	localThrowable19	java.lang.Throwable
    //   549	6122	36	localFile1	java.io.File
    //   366	7900	37	localHashMap	java.util.HashMap
    //   474	5543	38	localFile2	java.io.File
    //   599	6670	39	localarul	arul
    //   141	3783	40	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   350	6435	41	localObject24	Object
    //   494	1630	42	localFile3	java.io.File
    //   704	5609	43	localStringBuilder	java.lang.StringBuilder
    //   2216	6269	44	localObject25	Object
    //   3094	34	45	str1	String
    //   3108	31	46	str2	String
    // Exception table:
    //   from	to	target	type
    //   863	904	927	java/lang/Throwable
    //   916	927	927	java/lang/Throwable
    //   2257	2266	927	java/lang/Throwable
    //   2278	2289	927	java/lang/Throwable
    //   863	904	2289	finally
    //   916	927	2289	finally
    //   2257	2266	2289	finally
    //   2278	2289	2289	finally
    //   633	638	2651	java/lang/Throwable
    //   642	706	2651	java/lang/Throwable
    //   1551	1555	2651	java/lang/Throwable
    //   1563	1572	2651	java/lang/Throwable
    //   1575	1586	2651	java/lang/Throwable
    //   1589	1605	2651	java/lang/Throwable
    //   1608	1624	2651	java/lang/Throwable
    //   1627	1641	2651	java/lang/Throwable
    //   1644	1658	2651	java/lang/Throwable
    //   1661	1682	2651	java/lang/Throwable
    //   1685	1698	2651	java/lang/Throwable
    //   1701	1715	2651	java/lang/Throwable
    //   1718	1729	2651	java/lang/Throwable
    //   1736	1746	2651	java/lang/Throwable
    //   1749	1762	2651	java/lang/Throwable
    //   1765	1771	2651	java/lang/Throwable
    //   1777	1782	2651	java/lang/Throwable
    //   1789	1795	2651	java/lang/Throwable
    //   2294	2297	2651	java/lang/Throwable
    //   2301	2340	2651	java/lang/Throwable
    //   2344	2352	2651	java/lang/Throwable
    //   2361	2413	2651	java/lang/Throwable
    //   2422	2429	2651	java/lang/Throwable
    //   2433	2440	2651	java/lang/Throwable
    //   2444	2452	2651	java/lang/Throwable
    //   2456	2467	2651	java/lang/Throwable
    //   2471	2506	2651	java/lang/Throwable
    //   2510	2525	2651	java/lang/Throwable
    //   2529	2534	2651	java/lang/Throwable
    //   2538	2546	2651	java/lang/Throwable
    //   2550	2558	2651	java/lang/Throwable
    //   2566	2572	2651	java/lang/Throwable
    //   2576	2584	2651	java/lang/Throwable
    //   2592	2601	2651	java/lang/Throwable
    //   2610	2617	2651	java/lang/Throwable
    //   2626	2631	2651	java/lang/Throwable
    //   2640	2645	2651	java/lang/Throwable
    //   2649	2651	2651	java/lang/Throwable
    //   7247	7252	2651	java/lang/Throwable
    //   7261	7276	2651	java/lang/Throwable
    //   7283	7288	2651	java/lang/Throwable
    //   7296	7336	2651	java/lang/Throwable
    //   7426	7432	2651	java/lang/Throwable
    //   3038	3055	3147	java/lang/Throwable
    //   3060	3074	3147	java/lang/Throwable
    //   3074	3144	3147	java/lang/Throwable
    //   3232	3277	3147	java/lang/Throwable
    //   3277	3435	3147	java/lang/Throwable
    //   3440	3517	3147	java/lang/Throwable
    //   3517	3531	3147	java/lang/Throwable
    //   3536	3559	3147	java/lang/Throwable
    //   3566	3640	3147	java/lang/Throwable
    //   3640	3748	3147	java/lang/Throwable
    //   3748	3781	3147	java/lang/Throwable
    //   3781	3806	3147	java/lang/Throwable
    //   3816	3838	3147	java/lang/Throwable
    //   4319	4334	3147	java/lang/Throwable
    //   4337	4344	3147	java/lang/Throwable
    //   3968	3982	4281	java/lang/Throwable
    //   3986	3992	4281	java/lang/Throwable
    //   3996	4003	4281	java/lang/Throwable
    //   4007	4041	4281	java/lang/Throwable
    //   4045	4054	4281	java/lang/Throwable
    //   4058	4068	4281	java/lang/Throwable
    //   4072	4081	4281	java/lang/Throwable
    //   4085	4094	4281	java/lang/Throwable
    //   4098	4109	4281	java/lang/Throwable
    //   4113	4124	4281	java/lang/Throwable
    //   4128	4139	4281	java/lang/Throwable
    //   4143	4154	4281	java/lang/Throwable
    //   4158	4169	4281	java/lang/Throwable
    //   4173	4184	4281	java/lang/Throwable
    //   4188	4199	4281	java/lang/Throwable
    //   4203	4214	4281	java/lang/Throwable
    //   4218	4229	4281	java/lang/Throwable
    //   4233	4244	4281	java/lang/Throwable
    //   4248	4278	4281	java/lang/Throwable
    //   4385	4394	4281	java/lang/Throwable
    //   6480	6486	4281	java/lang/Throwable
    //   6517	6524	4281	java/lang/Throwable
    //   6534	6541	4281	java/lang/Throwable
    //   6570	6576	4281	java/lang/Throwable
    //   6615	6620	4281	java/lang/Throwable
    //   6658	6666	4281	java/lang/Throwable
    //   6670	6676	4281	java/lang/Throwable
    //   6680	6686	4281	java/lang/Throwable
    //   6717	6723	4281	java/lang/Throwable
    //   4636	4652	4675	java/lang/Throwable
    //   4664	4675	4675	java/lang/Throwable
    //   4805	4816	4675	java/lang/Throwable
    //   4636	4652	4816	finally
    //   4664	4675	4816	finally
    //   4805	4816	4816	finally
    //   5508	5621	6185	java/lang/Exception
    //   5422	5436	6231	java/lang/Throwable
    //   5436	5503	6231	java/lang/Throwable
    //   5508	5621	6231	java/lang/Throwable
    //   6187	6228	6231	java/lang/Throwable
    //   6312	6321	6328	java/lang/Throwable
    //   6395	6401	6416	java/lang/Throwable
    //   6405	6416	6416	java/lang/Throwable
    //   5726	5733	6750	java/lang/InterruptedException
    //   5726	5733	6782	finally
    //   5733	5736	6782	finally
    //   6752	6779	6782	finally
    //   6784	6787	6782	finally
    //   6126	6133	6963	java/io/IOException
    //   6142	6147	6963	java/io/IOException
    //   6156	6161	6963	java/io/IOException
    //   1404	1411	7162	java/io/IOException
    //   1419	1424	7162	java/io/IOException
    //   1432	1437	7162	java/io/IOException
    //   2610	2617	7291	java/io/IOException
    //   2626	2631	7291	java/io/IOException
    //   2640	2645	7291	java/io/IOException
    //   83	131	7682	java/lang/Throwable
    //   134	183	7682	java/lang/Throwable
    //   187	199	7682	java/lang/Throwable
    //   209	228	7682	java/lang/Throwable
    //   228	269	7682	java/lang/Throwable
    //   272	283	7682	java/lang/Throwable
    //   286	291	7682	java/lang/Throwable
    //   1800	1891	7688	java/lang/Throwable
    //   1896	1967	7688	java/lang/Throwable
    //   1976	1986	7688	java/lang/Throwable
    //   1990	2003	7688	java/lang/Throwable
    //   2008	2040	7688	java/lang/Throwable
    //   2040	2064	7688	java/lang/Throwable
    //   727	732	7693	finally
    //   752	760	7693	finally
    //   772	779	7693	finally
    //   801	807	7693	finally
    //   819	827	7693	finally
    //   845	851	7693	finally
    //   2169	2175	7693	finally
    //   2187	2201	7693	finally
    //   2213	2218	7693	finally
    //   2239	2245	7693	finally
    //   2723	2730	7693	finally
    //   2746	2757	7693	finally
    //   2769	2789	7693	finally
    //   2801	2809	7693	finally
    //   2821	2849	7693	finally
    //   2861	2868	7693	finally
    //   2880	2886	7693	finally
    //   2898	2925	7693	finally
    //   2937	2947	7693	finally
    //   2964	2971	7693	finally
    //   2983	2994	7693	finally
    //   3006	3011	7693	finally
    //   3025	3038	7693	finally
    //   3201	3229	7693	finally
    //   4394	4403	7701	finally
    //   4411	4425	7701	finally
    //   4433	4445	7701	finally
    //   4453	4465	7701	finally
    //   4478	4499	7701	finally
    //   4507	4514	7701	finally
    //   4522	4547	7701	finally
    //   4555	4562	7701	finally
    //   4577	4586	7701	finally
    //   4594	4604	7701	finally
    //   4618	4624	7701	finally
    //   4734	4747	7701	finally
    //   4773	4779	7701	finally
    //   4791	4797	7701	finally
    //   4846	4866	7701	finally
    //   4866	4918	7709	finally
    //   5173	5182	7709	finally
    //   4918	4927	7721	finally
    //   4931	4941	7737	finally
    //   4948	4955	7737	finally
    //   4959	4968	7737	finally
    //   4978	4984	7737	finally
    //   5031	5045	7737	finally
    //   5049	5059	7737	finally
    //   5093	5102	7737	finally
    //   5106	5116	7737	finally
    //   5120	5131	7737	finally
    //   5143	5153	7737	finally
    //   5157	5161	7737	finally
    //   5282	5287	7737	finally
    //   5291	5299	7737	finally
    //   5303	5310	7737	finally
    //   5314	5328	7737	finally
    //   5347	5354	7737	finally
    //   5365	5378	7737	finally
    //   5382	5405	7737	finally
    //   5417	5422	7737	finally
    //   6284	6290	7737	finally
    //   6302	6308	7737	finally
    //   6385	6391	7737	finally
    //   5422	5436	7749	finally
    //   5436	5503	7749	finally
    //   5508	5621	7749	finally
    //   6187	6228	7749	finally
    //   6312	6321	7764	finally
    //   6395	6401	7764	finally
    //   6405	6416	7764	finally
    //   727	732	7776	java/lang/Throwable
    //   752	760	7776	java/lang/Throwable
    //   772	779	7776	java/lang/Throwable
    //   801	807	7776	java/lang/Throwable
    //   819	827	7776	java/lang/Throwable
    //   845	851	7776	java/lang/Throwable
    //   2169	2175	7776	java/lang/Throwable
    //   2187	2201	7776	java/lang/Throwable
    //   2213	2218	7776	java/lang/Throwable
    //   2239	2245	7776	java/lang/Throwable
    //   2723	2730	7776	java/lang/Throwable
    //   2746	2757	7776	java/lang/Throwable
    //   2769	2789	7776	java/lang/Throwable
    //   2801	2809	7776	java/lang/Throwable
    //   2821	2849	7776	java/lang/Throwable
    //   2861	2868	7776	java/lang/Throwable
    //   2880	2886	7776	java/lang/Throwable
    //   2898	2925	7776	java/lang/Throwable
    //   2937	2947	7776	java/lang/Throwable
    //   2964	2971	7776	java/lang/Throwable
    //   2983	2994	7776	java/lang/Throwable
    //   3006	3011	7776	java/lang/Throwable
    //   3025	3038	7776	java/lang/Throwable
    //   3201	3229	7776	java/lang/Throwable
    //   3841	3876	7818	java/lang/Throwable
    //   3886	3908	7863	java/lang/Throwable
    //   3908	3935	7863	java/lang/Throwable
    //   3939	3964	7863	java/lang/Throwable
    //   4394	4403	7911	java/lang/Throwable
    //   4411	4425	7953	java/lang/Throwable
    //   4433	4445	7953	java/lang/Throwable
    //   4453	4465	7953	java/lang/Throwable
    //   4478	4499	7953	java/lang/Throwable
    //   4507	4514	7953	java/lang/Throwable
    //   4522	4547	7953	java/lang/Throwable
    //   4555	4562	7953	java/lang/Throwable
    //   4577	4586	7953	java/lang/Throwable
    //   4594	4604	7953	java/lang/Throwable
    //   4618	4624	7953	java/lang/Throwable
    //   4734	4747	7953	java/lang/Throwable
    //   4773	4779	7953	java/lang/Throwable
    //   4791	4797	7953	java/lang/Throwable
    //   4846	4866	7953	java/lang/Throwable
    //   4866	4918	7995	java/lang/Throwable
    //   5173	5182	7995	java/lang/Throwable
    //   4918	4927	8045	java/lang/Throwable
    //   4931	4941	8099	java/lang/Throwable
    //   4948	4955	8149	java/lang/Throwable
    //   4959	4968	8149	java/lang/Throwable
    //   4978	4984	8149	java/lang/Throwable
    //   5031	5045	8149	java/lang/Throwable
    //   5049	5059	8149	java/lang/Throwable
    //   5093	5102	8149	java/lang/Throwable
    //   5106	5116	8149	java/lang/Throwable
    //   5120	5131	8149	java/lang/Throwable
    //   5143	5153	8149	java/lang/Throwable
    //   5157	5161	8149	java/lang/Throwable
    //   5282	5287	8149	java/lang/Throwable
    //   5291	5299	8149	java/lang/Throwable
    //   5303	5310	8149	java/lang/Throwable
    //   5314	5328	8149	java/lang/Throwable
    //   5347	5354	8149	java/lang/Throwable
    //   5365	5378	8149	java/lang/Throwable
    //   5382	5405	8149	java/lang/Throwable
    //   5417	5422	8149	java/lang/Throwable
    //   6284	6290	8149	java/lang/Throwable
    //   6385	6391	8149	java/lang/Throwable
    //   6302	6308	8203	java/lang/Throwable
    //   3038	3055	8369	finally
    //   3060	3074	8369	finally
    //   3074	3144	8369	finally
    //   3232	3277	8369	finally
    //   3277	3435	8369	finally
    //   3440	3517	8369	finally
    //   3517	3531	8369	finally
    //   3536	3559	8369	finally
    //   3566	3640	8369	finally
    //   3640	3748	8369	finally
    //   3748	3781	8369	finally
    //   3781	3806	8369	finally
    //   3816	3838	8369	finally
    //   3841	3876	8369	finally
    //   3886	3908	8369	finally
    //   3908	3935	8369	finally
    //   3939	3964	8369	finally
    //   3968	3982	8369	finally
    //   3986	3992	8369	finally
    //   3996	4003	8369	finally
    //   4007	4041	8369	finally
    //   4045	4054	8369	finally
    //   4058	4068	8369	finally
    //   4072	4081	8369	finally
    //   4085	4094	8369	finally
    //   4098	4109	8369	finally
    //   4113	4124	8369	finally
    //   4128	4139	8369	finally
    //   4143	4154	8369	finally
    //   4158	4169	8369	finally
    //   4173	4184	8369	finally
    //   4188	4199	8369	finally
    //   4203	4214	8369	finally
    //   4218	4229	8369	finally
    //   4233	4244	8369	finally
    //   4248	4278	8369	finally
    //   4319	4334	8369	finally
    //   4337	4344	8369	finally
    //   4385	4394	8369	finally
    //   6480	6486	8369	finally
    //   6517	6524	8369	finally
    //   6534	6541	8369	finally
    //   6570	6576	8369	finally
    //   6615	6620	8369	finally
    //   6658	6666	8369	finally
    //   6670	6676	8369	finally
    //   6680	6686	8369	finally
    //   6717	6723	8369	finally
    //   5664	5670	8519	java/lang/Throwable
    //   5674	5684	8519	java/lang/Throwable
    //   5693	5700	8519	java/lang/Throwable
    //   5704	5713	8519	java/lang/Throwable
    //   5717	5720	8519	java/lang/Throwable
    //   5740	5750	8519	java/lang/Throwable
    //   5754	5766	8519	java/lang/Throwable
    //   5775	5791	8519	java/lang/Throwable
    //   6791	6794	8519	java/lang/Throwable
    //   6798	6808	8519	java/lang/Throwable
    //   6812	6819	8519	java/lang/Throwable
    //   6823	6839	8519	java/lang/Throwable
    //   6842	6897	8519	java/lang/Throwable
    //   6901	6912	8519	java/lang/Throwable
    //   5664	5670	8553	finally
    //   5674	5684	8553	finally
    //   5693	5700	8553	finally
    //   5704	5713	8553	finally
    //   5717	5720	8553	finally
    //   5740	5750	8553	finally
    //   5754	5766	8553	finally
    //   5775	5791	8553	finally
    //   6791	6794	8553	finally
    //   6798	6808	8553	finally
    //   6812	6819	8553	finally
    //   6823	6839	8553	finally
    //   6842	6897	8553	finally
    //   6901	6912	8553	finally
    //   313	327	8569	java/lang/Throwable
    //   334	339	8569	java/lang/Throwable
    //   343	352	8569	java/lang/Throwable
    //   359	368	8569	java/lang/Throwable
    //   372	388	8569	java/lang/Throwable
    //   392	398	8569	java/lang/Throwable
    //   402	410	8569	java/lang/Throwable
    //   419	429	8569	java/lang/Throwable
    //   433	445	8569	java/lang/Throwable
    //   449	456	8569	java/lang/Throwable
    //   460	476	8569	java/lang/Throwable
    //   489	496	8569	java/lang/Throwable
    //   500	507	8569	java/lang/Throwable
    //   511	551	8569	java/lang/Throwable
    //   559	569	8569	java/lang/Throwable
    //   573	584	8569	java/lang/Throwable
    //   588	601	8569	java/lang/Throwable
    //   1090	1093	8569	java/lang/Throwable
    //   1096	1135	8569	java/lang/Throwable
    //   1138	1146	8569	java/lang/Throwable
    //   1154	1206	8569	java/lang/Throwable
    //   1213	1220	8569	java/lang/Throwable
    //   1223	1230	8569	java/lang/Throwable
    //   1233	1241	8569	java/lang/Throwable
    //   1244	1255	8569	java/lang/Throwable
    //   1258	1293	8569	java/lang/Throwable
    //   1296	1311	8569	java/lang/Throwable
    //   1314	1319	8569	java/lang/Throwable
    //   1322	1331	8569	java/lang/Throwable
    //   1334	1342	8569	java/lang/Throwable
    //   1350	1359	8569	java/lang/Throwable
    //   1362	1370	8569	java/lang/Throwable
    //   1378	1390	8569	java/lang/Throwable
    //   1404	1411	8569	java/lang/Throwable
    //   1419	1424	8569	java/lang/Throwable
    //   1432	1437	8569	java/lang/Throwable
    //   1477	1486	8569	java/lang/Throwable
    //   1489	1495	8569	java/lang/Throwable
    //   2119	2154	8569	java/lang/Throwable
    //   5795	5798	8569	java/lang/Throwable
    //   5802	5841	8569	java/lang/Throwable
    //   5845	5853	8569	java/lang/Throwable
    //   5862	5914	8569	java/lang/Throwable
    //   5923	5930	8569	java/lang/Throwable
    //   5934	5941	8569	java/lang/Throwable
    //   5945	5953	8569	java/lang/Throwable
    //   5957	5968	8569	java/lang/Throwable
    //   5972	6007	8569	java/lang/Throwable
    //   6011	6026	8569	java/lang/Throwable
    //   6030	6035	8569	java/lang/Throwable
    //   6039	6048	8569	java/lang/Throwable
    //   6052	6060	8569	java/lang/Throwable
    //   6069	6078	8569	java/lang/Throwable
    //   6082	6090	8569	java/lang/Throwable
    //   6099	6111	8569	java/lang/Throwable
    //   6126	6133	8569	java/lang/Throwable
    //   6142	6147	8569	java/lang/Throwable
    //   6156	6161	8569	java/lang/Throwable
    //   6919	6924	8569	java/lang/Throwable
    //   6933	6948	8569	java/lang/Throwable
    //   6955	6960	8569	java/lang/Throwable
    //   6969	7010	8569	java/lang/Throwable
    //   7120	7125	8569	java/lang/Throwable
    //   7133	7148	8569	java/lang/Throwable
    //   7154	7159	8569	java/lang/Throwable
    //   7167	7208	8569	java/lang/Throwable
    //   7343	7349	8569	java/lang/Throwable
    //   7353	7359	8569	java/lang/Throwable
    //   7363	7372	8569	java/lang/Throwable
    //   7450	7463	8569	java/lang/Throwable
    //   7467	7473	8569	java/lang/Throwable
    //   7477	7522	8569	java/lang/Throwable
    //   7526	7532	8569	java/lang/Throwable
    //   969	985	8592	finally
    //   985	993	8592	finally
    //   996	1010	8592	finally
    //   1010	1019	8592	finally
    //   1034	1039	8592	finally
    //   1039	1087	8592	finally
    //   7034	7048	8592	finally
    //   7051	7067	8592	finally
    //   7067	7073	8592	finally
    //   7076	7090	8592	finally
    //   7093	7106	8592	finally
    //   7109	7114	8592	finally
    //   72	76	8637	java/lang/Throwable
    //   79	83	8637	java/lang/Throwable
    //   7537	7544	8637	java/lang/Throwable
    //   7547	7554	8637	java/lang/Throwable
    //   7560	7566	8637	java/lang/Throwable
    //   7569	7578	8637	java/lang/Throwable
    //   7587	7594	8637	java/lang/Throwable
    //   7597	7603	8637	java/lang/Throwable
    //   7606	7615	8637	java/lang/Throwable
    //   7618	7623	8637	java/lang/Throwable
    //   7626	7630	8637	java/lang/Throwable
    //   7633	7639	8637	java/lang/Throwable
    //   7642	7651	8637	java/lang/Throwable
    //   7654	7658	8637	java/lang/Throwable
    //   7667	7673	8637	java/lang/Throwable
  }
  
  public static int a(bhhf parambhhf, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((parambhhf.k) && (!bkdi.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(parambhhf, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(parambhhf, null, null);
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
  
  public static void a(arul paramarul)
  {
    if ((paramarul == null) || (TextUtils.isEmpty(paramarul.jdField_a_of_type_JavaLangString))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = InnerDns.getHostFromUrl(paramarul.jdField_a_of_type_JavaLangString);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramarul.jdField_a_of_type_JavaLangString.startsWith("http"))) {
          break;
        }
        str2 = InnerDns.getInstance().reqDns(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramarul.jdField_a_of_type_JavaLangString, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramarul.jdField_b_of_type_JavaLangString = str3;
        paramarul.jdField_c_of_type_JavaLangString = str1;
        paramarul.jdField_d_of_type_JavaLangString = str2;
        paramarul.jdField_a_of_type_Boolean = true;
        return;
      }
      paramarul.jdField_b_of_type_JavaLangString = paramarul.jdField_a_of_type_JavaLangString;
      return;
      HttpDownloadUtil.a(paramarul);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramarul.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(bgnt.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      bcst.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
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
      int i = bgnt.a(paramContext);
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
  
  public static boolean a(bhhf parambhhf)
  {
    if (parambhhf == null) {
      return false;
    }
    if ((parambhhf.jdField_a_of_type_JavaUtilList == null) || (parambhhf.jdField_a_of_type_JavaUtilMap == null) || (parambhhf.jdField_a_of_type_JavaUtilList.size() < 1) || (parambhhf.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(parambhhf.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    parambhhf = parambhhf.jdField_a_of_type_JavaUtilList.iterator();
    while (parambhhf.hasNext())
    {
      String str = (String)parambhhf.next();
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
    //   18: invokevirtual 297	java/io/File:exists	()Z
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
    //   44: invokevirtual 297	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1138	java/io/File:listFiles	()[Ljava/io/File;
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
    //   73: invokevirtual 300	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1138	java/io/File:listFiles	()[Ljava/io/File;
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
    //   111: invokevirtual 303	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 303	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 303	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 77
    //   148: iconst_2
    //   149: new 126	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1140
    //   159: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 1000	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1146	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1149	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 644	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1152	bita:a	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1153
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1153
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1156	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1161	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1163
    //   251: invokespecial 1166	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1169	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 410	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1170	java/io/InputStreamReader:close	()V
    //   282: ldc 77
    //   284: iconst_2
    //   285: new 126	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1140
    //   295: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1172
    //   308: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1174
    //   319: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1176
    //   330: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1179	java/lang/String:valueOf	([C)Ljava/lang/String;
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
    //   369: ldc_w 1181
    //   372: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1183
    //   387: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    //   416: invokevirtual 306	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 126	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1187	java/io/File:separatorChar	C
    //   438: invokevirtual 1190	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1194	nmk:a	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 303	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 77
    //   464: iconst_2
    //   465: new 126	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1196
    //   475: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    //   516: invokevirtual 410	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1170	java/io/InputStreamReader:close	()V
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
    //   546: invokevirtual 410	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1170	java/io/InputStreamReader:close	()V
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
  public bhhk a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +324 -> 329
    //   8: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+29 -> 44, 1:+33->48, 2:+107->122, 3:+176->191, 4:+245->260
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: iload_1
    //   52: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokevirtual 1197	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   58: ifeq +20 -> 78
    //   61: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   64: iload_1
    //   65: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 1198	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 1204	bhhk
    //   74: astore_2
    //   75: goto -31 -> 44
    //   78: new 1206	bhhj
    //   81: dup
    //   82: iconst_0
    //   83: invokespecial 1209	bhhj:<init>	(Z)V
    //   86: astore_2
    //   87: new 1211	bhhw
    //   90: dup
    //   91: invokestatic 1214	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   94: invokevirtual 1218	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   97: aload_2
    //   98: invokespecial 1221	bhhw:<init>	(Lmqq/app/AppRuntime;Lbhhj;)V
    //   101: astore_2
    //   102: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   105: iload_1
    //   106: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aload_2
    //   110: invokevirtual 1013	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: goto -70 -> 44
    //   117: astore_2
    //   118: aload_3
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   125: iload_1
    //   126: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokevirtual 1197	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   132: ifeq +20 -> 152
    //   135: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: iload_1
    //   139: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 1198	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 1204	bhhk
    //   148: astore_2
    //   149: goto -105 -> 44
    //   152: new 1206	bhhj
    //   155: dup
    //   156: iconst_0
    //   157: invokespecial 1209	bhhj:<init>	(Z)V
    //   160: astore_2
    //   161: new 1211	bhhw
    //   164: dup
    //   165: invokestatic 1214	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: invokevirtual 1218	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   171: aload_2
    //   172: invokespecial 1221	bhhw:<init>	(Lmqq/app/AppRuntime;Lbhhj;)V
    //   175: astore_2
    //   176: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   179: iload_1
    //   180: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aload_2
    //   184: invokevirtual 1013	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: goto -144 -> 44
    //   191: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: iload_1
    //   195: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 1197	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   201: ifeq +20 -> 221
    //   204: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   207: iload_1
    //   208: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 1198	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 1204	bhhk
    //   217: astore_2
    //   218: goto -174 -> 44
    //   221: new 1206	bhhj
    //   224: dup
    //   225: iconst_0
    //   226: invokespecial 1209	bhhj:<init>	(Z)V
    //   229: astore_2
    //   230: new 1223	amic
    //   233: dup
    //   234: invokestatic 1214	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   237: invokevirtual 1218	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   240: aload_2
    //   241: invokespecial 1224	amic:<init>	(Lmqq/app/AppRuntime;Lbhhj;)V
    //   244: astore_2
    //   245: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   248: iload_1
    //   249: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aload_2
    //   253: invokevirtual 1013	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: goto -213 -> 44
    //   260: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   263: iload_1
    //   264: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 1197	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   270: ifeq +20 -> 290
    //   273: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   276: iload_1
    //   277: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: invokevirtual 1198	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: checkcast 1204	bhhk
    //   286: astore_2
    //   287: goto -243 -> 44
    //   290: new 1206	bhhj
    //   293: dup
    //   294: iconst_0
    //   295: invokespecial 1209	bhhj:<init>	(Z)V
    //   298: astore_2
    //   299: new 1223	amic
    //   302: dup
    //   303: invokestatic 1214	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: invokevirtual 1218	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   309: aload_2
    //   310: invokespecial 1224	amic:<init>	(Lmqq/app/AppRuntime;Lbhhj;)V
    //   313: astore_2
    //   314: getstatic 44	bhhh:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   317: iload_1
    //   318: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aload_2
    //   322: invokevirtual 1013	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: goto -282 -> 44
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	bhhh
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
          ((bhhk)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhh
 * JD-Core Version:    0.7.0.1
 */