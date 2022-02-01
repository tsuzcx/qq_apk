import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class bhyq
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, bhyt> a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public bhyq(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(bhyo parambhyo, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 73
    //   8: iconst_2
    //   9: ldc 75
    //   11: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore 4
    //   18: aload_0
    //   19: invokevirtual 84	bhyo:a	()Lbhyn;
    //   22: ifnonnull +14 -> 36
    //   25: aload_0
    //   26: new 86	bhyr
    //   29: dup
    //   30: invokespecial 87	bhyr:<init>	()V
    //   33: invokevirtual 90	bhyo:a	(Lbhyn;)V
    //   36: aload_1
    //   37: ifnull +26 -> 63
    //   40: aload_0
    //   41: getfield 93	bhyo:jdField_a_of_type_Bhyp	Lbhyp;
    //   44: getfield 98	bhyp:a	J
    //   47: lconst_0
    //   48: lcmp
    //   49: ifge +14 -> 63
    //   52: aload_0
    //   53: getfield 93	bhyo:jdField_a_of_type_Bhyp	Lbhyp;
    //   56: aload_1
    //   57: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: putfield 98	bhyp:a	J
    //   63: iload 4
    //   65: istore_3
    //   66: aload_0
    //   67: ifnull +264 -> 331
    //   70: iload 4
    //   72: istore_3
    //   73: aload_0
    //   74: invokestatic 109	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lbhyo;)V
    //   77: iload 4
    //   79: istore_3
    //   80: aload_0
    //   81: invokestatic 111	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lbhyo;)V
    //   84: iconst_m1
    //   85: istore 4
    //   87: iload 4
    //   89: istore_3
    //   90: aload_0
    //   91: invokevirtual 114	bhyo:c	()Z
    //   94: ifne +62 -> 156
    //   97: iload 4
    //   99: istore_3
    //   100: aload_0
    //   101: bipush 147
    //   103: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   106: iload 4
    //   108: istore_3
    //   109: aload_0
    //   110: invokevirtual 120	bhyo:e	()V
    //   113: iload 4
    //   115: istore_3
    //   116: iload 4
    //   118: istore 5
    //   120: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +6896 -> 7019
    //   126: iload 4
    //   128: istore_3
    //   129: ldc 73
    //   131: iconst_2
    //   132: new 122	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   139: ldc 125
    //   141: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: iconst_m1
    //   155: ireturn
    //   156: iload 4
    //   158: istore_3
    //   159: new 138	org/apache/http/params/BasicHttpParams
    //   162: dup
    //   163: invokespecial 139	org/apache/http/params/BasicHttpParams:<init>	()V
    //   166: astore 38
    //   168: iload 4
    //   170: istore_3
    //   171: aload 38
    //   173: ldc 141
    //   175: sipush 10000
    //   178: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokeinterface 153 3 0
    //   186: pop
    //   187: iload 4
    //   189: istore_3
    //   190: aload 38
    //   192: ldc 155
    //   194: aload_0
    //   195: getfield 157	bhyo:jdField_e_of_type_Int	I
    //   198: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: invokeinterface 153 3 0
    //   206: pop
    //   207: iload 4
    //   209: istore_3
    //   210: aload_0
    //   211: getfield 160	bhyo:n	Z
    //   214: ifeq +153 -> 367
    //   217: ldc 162
    //   219: astore 28
    //   221: iload 4
    //   223: istore_3
    //   224: aload 38
    //   226: ldc 164
    //   228: aload 28
    //   230: invokeinterface 153 3 0
    //   235: pop
    //   236: iload 4
    //   238: istore_3
    //   239: aload_0
    //   240: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   243: ifnull +18 -> 261
    //   246: iload 4
    //   248: istore_3
    //   249: aload_0
    //   250: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   253: invokeinterface 173 1 0
    //   258: ifgt +116 -> 374
    //   261: iload 4
    //   263: istore_3
    //   264: aload_0
    //   265: bipush 149
    //   267: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   270: iload 4
    //   272: istore_3
    //   273: aload_0
    //   274: invokevirtual 120	bhyo:e	()V
    //   277: iload 4
    //   279: istore_3
    //   280: iload 4
    //   282: istore 5
    //   284: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +6732 -> 7019
    //   290: iload 4
    //   292: istore_3
    //   293: ldc 73
    //   295: iconst_2
    //   296: new 122	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   303: ldc 175
    //   305: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iconst_m1
    //   319: ireturn
    //   320: astore_0
    //   321: ldc 73
    //   323: iconst_1
    //   324: aload_0
    //   325: invokevirtual 178	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   328: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iload_3
    //   332: istore 5
    //   334: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +6682 -> 7019
    //   340: ldc 73
    //   342: iconst_2
    //   343: new 122	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   350: ldc 182
    //   352: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload_3
    //   356: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: iload_3
    //   366: ireturn
    //   367: ldc 187
    //   369: astore 28
    //   371: goto -150 -> 221
    //   374: iload 4
    //   376: istore_3
    //   377: aload_0
    //   378: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   381: invokeinterface 173 1 0
    //   386: istore 9
    //   388: iconst_0
    //   389: istore 13
    //   391: iload 4
    //   393: istore_3
    //   394: getstatic 192	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   397: istore 4
    //   399: iconst_1
    //   400: iload 4
    //   402: if_icmpne +1194 -> 1596
    //   405: iconst_1
    //   406: istore 14
    //   408: iconst_0
    //   409: istore 10
    //   411: aconst_null
    //   412: astore 28
    //   414: iconst_m1
    //   415: istore 8
    //   417: aconst_null
    //   418: astore 30
    //   420: aconst_null
    //   421: astore 29
    //   423: sipush 2048
    //   426: istore_3
    //   427: iload 8
    //   429: istore 4
    //   431: iload 10
    //   433: aload_0
    //   434: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   437: invokeinterface 173 1 0
    //   442: if_icmpge +5682 -> 6124
    //   445: iconst_m1
    //   446: istore 4
    //   448: iload 4
    //   450: istore 8
    //   452: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   455: lstore 24
    //   457: iconst_m1
    //   458: istore 5
    //   460: iload 4
    //   462: istore 8
    //   464: new 4	java/lang/Object
    //   467: dup
    //   468: invokespecial 37	java/lang/Object:<init>	()V
    //   471: astore 40
    //   473: lconst_0
    //   474: lstore 16
    //   476: iload 4
    //   478: istore 8
    //   480: new 200	java/util/HashMap
    //   483: dup
    //   484: invokespecial 201	java/util/HashMap:<init>	()V
    //   487: astore 39
    //   489: iload 4
    //   491: istore 8
    //   493: aload_0
    //   494: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   497: iload 10
    //   499: invokeinterface 205 2 0
    //   504: checkcast 207	java/lang/String
    //   507: astore 32
    //   509: iload 4
    //   511: istore 8
    //   513: aload_0
    //   514: aload 32
    //   516: putfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   519: iload 4
    //   521: istore 8
    //   523: aload_0
    //   524: getfield 213	bhyo:jdField_g_of_type_Int	I
    //   527: iconst_3
    //   528: if_icmpne +49 -> 577
    //   531: iload 14
    //   533: ifeq +44 -> 577
    //   536: iload 4
    //   538: istore 8
    //   540: bipush 30
    //   542: aconst_null
    //   543: aload_0
    //   544: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   547: invokestatic 218	anis:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   550: iload 4
    //   552: istore 8
    //   554: bipush 30
    //   556: aload_0
    //   557: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   560: sipush 300
    //   563: invokestatic 221	anis:a	(ILjava/lang/String;I)V
    //   566: iload 4
    //   568: istore 8
    //   570: aload_0
    //   571: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   574: invokestatic 224	com/tencent/mobileqq/apollo/utils/ApolloUtil:d	(Ljava/lang/String;)V
    //   577: iload 4
    //   579: istore 8
    //   581: aload_0
    //   582: getfield 225	bhyo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   585: aload 32
    //   587: invokeinterface 230 2 0
    //   592: checkcast 232	java/io/File
    //   595: astore 36
    //   597: ldc 234
    //   599: astore 33
    //   601: aload 36
    //   603: ifnull +5442 -> 6045
    //   606: iload 4
    //   608: istore 8
    //   610: aload 36
    //   612: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   615: astore 41
    //   617: iload 4
    //   619: istore 8
    //   621: aload_0
    //   622: getfield 241	bhyo:h	Z
    //   625: ifeq +977 -> 1602
    //   628: iload 4
    //   630: istore 8
    //   632: new 232	java/io/File
    //   635: dup
    //   636: aload 41
    //   638: new 122	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   645: aload 36
    //   647: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   650: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: ldc 246
    //   655: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokestatic 249	java/lang/System:nanoTime	()J
    //   661: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   664: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokespecial 255	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   670: astore 35
    //   672: aload 32
    //   674: astore 31
    //   676: iload 4
    //   678: istore 8
    //   680: aload_0
    //   681: getfield 257	bhyo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   684: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   687: ifne +18 -> 705
    //   690: iload 4
    //   692: istore 8
    //   694: aload_0
    //   695: getfield 257	bhyo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   698: aload 32
    //   700: invokestatic 269	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   703: astore 31
    //   705: iload 4
    //   707: istore 8
    //   709: new 271	asid
    //   712: dup
    //   713: aload 31
    //   715: aconst_null
    //   716: iconst_0
    //   717: invokespecial 274	asid:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   720: astore 37
    //   722: aload 31
    //   724: astore 33
    //   726: iconst_m1
    //   727: istore 11
    //   729: iconst_m1
    //   730: istore 6
    //   732: aload 29
    //   734: astore 31
    //   736: lconst_0
    //   737: lstore 18
    //   739: iconst_0
    //   740: istore 7
    //   742: aload 30
    //   744: astore 29
    //   746: aload 28
    //   748: astore 32
    //   750: aload 33
    //   752: astore 28
    //   754: iload 6
    //   756: istore 4
    //   758: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   761: lstore 26
    //   763: iload 6
    //   765: istore 4
    //   767: new 122	java/lang/StringBuilder
    //   770: dup
    //   771: ldc_w 276
    //   774: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   777: ldc_w 280
    //   780: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_0
    //   784: getfield 160	bhyo:n	Z
    //   787: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: ldc_w 285
    //   793: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_0
    //   797: getfield 288	bhyo:p	Z
    //   800: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   803: ldc_w 290
    //   806: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_0
    //   810: getfield 292	bhyo:jdField_b_of_type_Int	I
    //   813: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: ldc_w 294
    //   819: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload_0
    //   823: getfield 297	bhyo:s	Z
    //   826: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   829: astore 42
    //   831: iconst_0
    //   832: istore 8
    //   834: iconst_0
    //   835: istore 5
    //   837: iconst_0
    //   838: istore 12
    //   840: aload 28
    //   842: astore 34
    //   844: aload 28
    //   846: astore 33
    //   848: iload 5
    //   850: istore 4
    //   852: aload 37
    //   854: invokevirtual 299	asid:a	()V
    //   857: iconst_1
    //   858: istore 13
    //   860: aload 41
    //   862: ifnull +782 -> 1644
    //   865: aload 28
    //   867: astore 34
    //   869: aload 28
    //   871: astore 33
    //   873: iload 5
    //   875: istore 4
    //   877: aload 41
    //   879: invokevirtual 302	java/io/File:exists	()Z
    //   882: ifeq +27 -> 909
    //   885: aload 28
    //   887: astore 34
    //   889: aload 28
    //   891: astore 33
    //   893: iload 5
    //   895: istore 4
    //   897: aload 41
    //   899: invokevirtual 305	java/io/File:isDirectory	()Z
    //   902: istore 13
    //   904: iload 13
    //   906: ifne +738 -> 1644
    //   909: iload 13
    //   911: ifne +21 -> 932
    //   914: aload 28
    //   916: astore 34
    //   918: aload 28
    //   920: astore 33
    //   922: iload 5
    //   924: istore 4
    //   926: aload 41
    //   928: invokevirtual 308	java/io/File:delete	()Z
    //   931: pop
    //   932: aload 28
    //   934: astore 34
    //   936: aload 28
    //   938: astore 33
    //   940: iload 5
    //   942: istore 4
    //   944: aload 41
    //   946: invokevirtual 311	java/io/File:mkdirs	()Z
    //   949: ifne +695 -> 1644
    //   952: iconst_1
    //   953: istore 4
    //   955: iconst_1
    //   956: istore 12
    //   958: bipush 153
    //   960: istore 8
    //   962: aload 28
    //   964: astore 34
    //   966: aload 28
    //   968: astore 33
    //   970: aload_0
    //   971: bipush 153
    //   973: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   976: iload 12
    //   978: istore 4
    //   980: iload 8
    //   982: istore 5
    //   984: iload 8
    //   986: istore 6
    //   988: aload 42
    //   990: ldc_w 313
    //   993: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload 41
    //   998: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1001: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: ldc_w 318
    //   1007: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: invokestatic 322	bhbx:a	()Z
    //   1013: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1016: ldc_w 324
    //   1019: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokestatic 326	bhbx:b	()J
    //   1025: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: iload 12
    //   1031: istore 4
    //   1033: iload 8
    //   1035: istore 5
    //   1037: iload 8
    //   1039: istore 6
    //   1041: new 328	java/lang/Exception
    //   1044: dup
    //   1045: ldc_w 330
    //   1048: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1051: athrow
    //   1052: astore 34
    //   1054: iload_3
    //   1055: istore 6
    //   1057: aload 31
    //   1059: astore 33
    //   1061: iconst_0
    //   1062: istore 13
    //   1064: iload 5
    //   1066: istore_3
    //   1067: aload 32
    //   1069: astore 31
    //   1071: aload 29
    //   1073: astore 30
    //   1075: aload 33
    //   1077: astore 29
    //   1079: iload 6
    //   1081: istore 5
    //   1083: iload 7
    //   1085: istore 6
    //   1087: aload 34
    //   1089: astore 32
    //   1091: iconst_0
    //   1092: istore 7
    //   1094: aload 32
    //   1096: instanceof 333
    //   1099: ifne +5923 -> 7022
    //   1102: aload 32
    //   1104: instanceof 335
    //   1107: ifne +5915 -> 7022
    //   1110: aload 32
    //   1112: instanceof 337
    //   1115: ifeq +6 -> 1121
    //   1118: goto +5904 -> 7022
    //   1121: aload 32
    //   1123: instanceof 339
    //   1126: ifeq +4806 -> 5932
    //   1129: aload_0
    //   1130: bipush 145
    //   1132: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   1135: aload_0
    //   1136: aload 32
    //   1138: invokevirtual 178	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1141: putfield 341	bhyo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1144: iload 13
    //   1146: ifne +18 -> 1164
    //   1149: iload 7
    //   1151: ifeq +13 -> 1164
    //   1154: iload 6
    //   1156: ifeq +4851 -> 6007
    //   1159: aload_0
    //   1160: iconst_1
    //   1161: putfield 344	bhyo:jdField_f_of_type_Boolean	Z
    //   1164: aload 42
    //   1166: ldc_w 346
    //   1169: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokestatic 351	com/tencent/mobileqq/utils/FileUtils:hasSDCardAndWritable	()Z
    //   1175: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1178: ldc_w 353
    //   1181: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokestatic 357	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   1187: ldc_w 358
    //   1190: fdiv
    //   1191: invokevirtual 361	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload 42
    //   1197: ldc_w 363
    //   1200: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: aload 32
    //   1205: invokevirtual 178	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1208: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: iload_3
    //   1213: istore 8
    //   1215: invokestatic 368	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1218: iload_3
    //   1219: istore 8
    //   1221: ldc 73
    //   1223: iconst_1
    //   1224: new 122	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1231: aload 42
    //   1233: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: ldc_w 370
    //   1242: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1248: lload 26
    //   1250: lsub
    //   1251: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 373	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: iload_3
    //   1261: istore 8
    //   1263: aload_0
    //   1264: getfield 213	bhyo:jdField_g_of_type_Int	I
    //   1267: iconst_3
    //   1268: if_icmpne +63 -> 1331
    //   1271: iload 14
    //   1273: ifeq +58 -> 1331
    //   1276: iload_3
    //   1277: istore 8
    //   1279: bipush 30
    //   1281: aload_0
    //   1282: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1285: sipush 300
    //   1288: iconst_1
    //   1289: anewarray 4	java/lang/Object
    //   1292: dup
    //   1293: iconst_0
    //   1294: new 122	java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1301: aload 42
    //   1303: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: ldc_w 370
    //   1312: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1318: lload 26
    //   1320: lsub
    //   1321: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: aastore
    //   1328: invokestatic 376	anis:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1331: iload_3
    //   1332: istore 8
    //   1334: aload_0
    //   1335: aload_2
    //   1336: iload_3
    //   1337: aload 36
    //   1339: aload 37
    //   1341: invokestatic 379	bhyq:a	(Lbhyo;Landroid/content/Context;ILjava/io/File;Lasid;)V
    //   1344: iload_3
    //   1345: istore 8
    //   1347: new 122	java/lang/StringBuilder
    //   1350: dup
    //   1351: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1354: astore 33
    //   1356: iload_3
    //   1357: istore 8
    //   1359: aload 37
    //   1361: getfield 381	asid:jdField_b_of_type_Boolean	Z
    //   1364: ifeq +4651 -> 6015
    //   1367: ldc_w 383
    //   1370: astore 32
    //   1372: iload_3
    //   1373: istore 8
    //   1375: aload 33
    //   1377: aload 32
    //   1379: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: astore 33
    //   1384: iload_3
    //   1385: istore 8
    //   1387: aload 37
    //   1389: getfield 384	asid:jdField_a_of_type_Boolean	Z
    //   1392: ifeq +4631 -> 6023
    //   1395: ldc_w 386
    //   1398: astore 32
    //   1400: iload_3
    //   1401: istore 8
    //   1403: aload 33
    //   1405: aload 32
    //   1407: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: astore 32
    //   1415: iload_3
    //   1416: istore 8
    //   1418: aload 31
    //   1420: aload 30
    //   1422: aload 29
    //   1424: aload 28
    //   1426: invokestatic 389	bhyq:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1429: iload 5
    //   1431: istore 7
    //   1433: aload 29
    //   1435: astore 33
    //   1437: aload 30
    //   1439: astore 34
    //   1441: iload 11
    //   1443: iconst_1
    //   1444: iadd
    //   1445: istore 5
    //   1447: aload 28
    //   1449: astore 30
    //   1451: iload 4
    //   1453: istore 8
    //   1455: aload 31
    //   1457: astore 29
    //   1459: aload 34
    //   1461: astore 31
    //   1463: aload 33
    //   1465: astore 28
    //   1467: iload 7
    //   1469: istore 4
    //   1471: iload_3
    //   1472: ifeq +34 -> 1506
    //   1475: iload 8
    //   1477: ifne +29 -> 1506
    //   1480: iload_3
    //   1481: istore 8
    //   1483: iload 5
    //   1485: aload_0
    //   1486: getfield 292	bhyo:jdField_b_of_type_Int	I
    //   1489: if_icmpge +17 -> 1506
    //   1492: iload_3
    //   1493: istore 8
    //   1495: aload_0
    //   1496: invokevirtual 391	bhyo:b	()Z
    //   1499: istore 15
    //   1501: iload 15
    //   1503: ifeq +5475 -> 6978
    //   1506: aload 32
    //   1508: astore 33
    //   1510: aload 30
    //   1512: astore 32
    //   1514: aload 29
    //   1516: astore 30
    //   1518: aload 31
    //   1520: astore 29
    //   1522: aload_0
    //   1523: invokevirtual 393	bhyo:d	()V
    //   1526: aload_0
    //   1527: aload_1
    //   1528: aload_2
    //   1529: iload_3
    //   1530: iload 13
    //   1532: iload 14
    //   1534: lload 24
    //   1536: iload 5
    //   1538: lload 16
    //   1540: lload 18
    //   1542: aload 39
    //   1544: aload 32
    //   1546: aload 33
    //   1548: invokestatic 396	bhyq:a	(Lbhyo;Ljava/lang/String;Landroid/content/Context;IZZJIJJLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V
    //   1551: iload_3
    //   1552: ifne +4557 -> 6109
    //   1555: iload 9
    //   1557: iconst_1
    //   1558: isub
    //   1559: istore 5
    //   1561: iload 10
    //   1563: iconst_1
    //   1564: iadd
    //   1565: istore 10
    //   1567: aload 30
    //   1569: astore 31
    //   1571: iload_3
    //   1572: istore 8
    //   1574: aload 29
    //   1576: astore 30
    //   1578: iload 4
    //   1580: istore_3
    //   1581: aload 28
    //   1583: astore 29
    //   1585: aload 31
    //   1587: astore 28
    //   1589: iload 5
    //   1591: istore 9
    //   1593: goto -1166 -> 427
    //   1596: iconst_0
    //   1597: istore 14
    //   1599: goto -1191 -> 408
    //   1602: iload 4
    //   1604: istore 8
    //   1606: new 232	java/io/File
    //   1609: dup
    //   1610: aload 41
    //   1612: new 122	java/lang/StringBuilder
    //   1615: dup
    //   1616: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1619: aload 36
    //   1621: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   1624: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: ldc_w 398
    //   1630: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1636: invokespecial 255	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1639: astore 35
    //   1641: goto -969 -> 672
    //   1644: aload 28
    //   1646: astore 34
    //   1648: aload 28
    //   1650: astore 33
    //   1652: iload 5
    //   1654: istore 4
    //   1656: getstatic 46	bhyq:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1659: ifnonnull +29 -> 1688
    //   1662: aload 28
    //   1664: astore 34
    //   1666: aload 28
    //   1668: astore 33
    //   1670: iload 5
    //   1672: istore 4
    //   1674: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1677: ldc 54
    //   1679: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1682: checkcast 60	android/net/ConnectivityManager
    //   1685: putstatic 46	bhyq:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1688: aload 28
    //   1690: astore 34
    //   1692: aload 28
    //   1694: astore 33
    //   1696: iload 5
    //   1698: istore 4
    //   1700: invokestatic 404	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   1703: astore 43
    //   1705: aload 43
    //   1707: ifnonnull +303 -> 2010
    //   1710: bipush 152
    //   1712: istore 8
    //   1714: aload 28
    //   1716: astore 34
    //   1718: aload 28
    //   1720: astore 33
    //   1722: iload 5
    //   1724: istore 4
    //   1726: aload_0
    //   1727: bipush 152
    //   1729: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   1732: iload 12
    //   1734: istore 4
    //   1736: iload 8
    //   1738: istore 5
    //   1740: iload 8
    //   1742: istore 6
    //   1744: aload 42
    //   1746: ldc_w 406
    //   1749: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: pop
    //   1753: iload 12
    //   1755: istore 4
    //   1757: iload 8
    //   1759: istore 5
    //   1761: iload 8
    //   1763: istore 6
    //   1765: new 328	java/lang/Exception
    //   1768: dup
    //   1769: ldc_w 408
    //   1772: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1775: athrow
    //   1776: astore_1
    //   1777: iload 6
    //   1779: istore 4
    //   1781: invokestatic 368	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1784: iload 6
    //   1786: istore 4
    //   1788: ldc 73
    //   1790: iconst_1
    //   1791: new 122	java/lang/StringBuilder
    //   1794: dup
    //   1795: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1798: aload 42
    //   1800: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: ldc_w 370
    //   1809: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1815: lload 26
    //   1817: lsub
    //   1818: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1821: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1824: invokestatic 373	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1827: iload 6
    //   1829: istore 4
    //   1831: aload_0
    //   1832: getfield 213	bhyo:jdField_g_of_type_Int	I
    //   1835: iconst_3
    //   1836: if_icmpne +64 -> 1900
    //   1839: iload 14
    //   1841: ifeq +59 -> 1900
    //   1844: iload 6
    //   1846: istore 4
    //   1848: bipush 30
    //   1850: aload_0
    //   1851: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1854: sipush 300
    //   1857: iconst_1
    //   1858: anewarray 4	java/lang/Object
    //   1861: dup
    //   1862: iconst_0
    //   1863: new 122	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1870: aload 42
    //   1872: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1875: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: ldc_w 370
    //   1881: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1887: lload 26
    //   1889: lsub
    //   1890: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1893: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1896: aastore
    //   1897: invokestatic 376	anis:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1900: iload 6
    //   1902: istore 4
    //   1904: aload_0
    //   1905: aload_2
    //   1906: iload 6
    //   1908: aload 36
    //   1910: aload 37
    //   1912: invokestatic 379	bhyq:a	(Lbhyo;Landroid/content/Context;ILjava/io/File;Lasid;)V
    //   1915: iload 6
    //   1917: istore 4
    //   1919: new 122	java/lang/StringBuilder
    //   1922: dup
    //   1923: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1926: astore_2
    //   1927: iload 6
    //   1929: istore 4
    //   1931: aload 37
    //   1933: getfield 381	asid:jdField_b_of_type_Boolean	Z
    //   1936: ifeq +4095 -> 6031
    //   1939: ldc_w 383
    //   1942: astore_0
    //   1943: iload 6
    //   1945: istore 4
    //   1947: aload_2
    //   1948: aload_0
    //   1949: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: astore_2
    //   1953: iload 6
    //   1955: istore 4
    //   1957: aload 37
    //   1959: getfield 384	asid:jdField_a_of_type_Boolean	Z
    //   1962: ifeq +4076 -> 6038
    //   1965: ldc_w 386
    //   1968: astore_0
    //   1969: iload 6
    //   1971: istore 4
    //   1973: aload_2
    //   1974: aload_0
    //   1975: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1981: pop
    //   1982: iload 6
    //   1984: istore 4
    //   1986: aload 32
    //   1988: aload 29
    //   1990: aload 31
    //   1992: aload 28
    //   1994: invokestatic 389	bhyq:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1997: iload 6
    //   1999: istore 4
    //   2001: aload_1
    //   2002: athrow
    //   2003: astore_0
    //   2004: iload 4
    //   2006: istore_3
    //   2007: goto -1686 -> 321
    //   2010: aload 28
    //   2012: astore 30
    //   2014: aload 28
    //   2016: astore 34
    //   2018: aload 28
    //   2020: astore 33
    //   2022: iload 5
    //   2024: istore 4
    //   2026: aload_0
    //   2027: getfield 411	bhyo:q	Z
    //   2030: ifeq +122 -> 2152
    //   2033: aload 28
    //   2035: astore 30
    //   2037: aload 28
    //   2039: astore 34
    //   2041: aload 28
    //   2043: astore 33
    //   2045: iload 5
    //   2047: istore 4
    //   2049: aload 28
    //   2051: ldc_w 413
    //   2054: invokevirtual 416	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2057: ifne +95 -> 2152
    //   2060: aload 28
    //   2062: astore 34
    //   2064: aload 28
    //   2066: astore 33
    //   2068: iload 5
    //   2070: istore 4
    //   2072: new 418	java/util/Random
    //   2075: dup
    //   2076: aload_1
    //   2077: invokestatic 422	baps:a	(Ljava/lang/String;)J
    //   2080: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   2083: lor
    //   2084: invokespecial 425	java/util/Random:<init>	(J)V
    //   2087: invokevirtual 428	java/util/Random:nextInt	()I
    //   2090: istore 12
    //   2092: aload 28
    //   2094: astore 34
    //   2096: aload 28
    //   2098: astore 33
    //   2100: iload 5
    //   2102: istore 4
    //   2104: aload 28
    //   2106: invokestatic 431	bhyq:b	(Ljava/lang/String;)Z
    //   2109: ifeq +391 -> 2500
    //   2112: aload 28
    //   2114: astore 34
    //   2116: aload 28
    //   2118: astore 33
    //   2120: iload 5
    //   2122: istore 4
    //   2124: new 122	java/lang/StringBuilder
    //   2127: dup
    //   2128: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2131: aload 28
    //   2133: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: ldc_w 433
    //   2139: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2142: iload 12
    //   2144: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2147: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2150: astore 30
    //   2152: aload 30
    //   2154: astore 34
    //   2156: aload 30
    //   2158: astore 33
    //   2160: iload 5
    //   2162: istore 4
    //   2164: aload 30
    //   2166: invokestatic 436	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2169: astore 28
    //   2171: aload 28
    //   2173: astore 34
    //   2175: aload 28
    //   2177: astore 33
    //   2179: iload 5
    //   2181: istore 4
    //   2183: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2186: ifeq +42 -> 2228
    //   2189: aload 28
    //   2191: astore 34
    //   2193: aload 28
    //   2195: astore 33
    //   2197: iload 5
    //   2199: istore 4
    //   2201: ldc 73
    //   2203: iconst_2
    //   2204: new 122	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2211: ldc_w 438
    //   2214: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: aload 28
    //   2219: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2222: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2225: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2228: aload 28
    //   2230: astore 34
    //   2232: aload 28
    //   2234: astore 33
    //   2236: iload 5
    //   2238: istore 4
    //   2240: aload_0
    //   2241: getfield 440	bhyo:jdField_f_of_type_Int	I
    //   2244: sipush 302
    //   2247: if_icmpne +4724 -> 6971
    //   2250: iload 11
    //   2252: ifne +4719 -> 6971
    //   2255: aload 28
    //   2257: astore 34
    //   2259: aload 28
    //   2261: astore 33
    //   2263: iload 5
    //   2265: istore 4
    //   2267: aload_0
    //   2268: getfield 443	bhyo:r	Z
    //   2271: ifeq +4700 -> 6971
    //   2274: aload 28
    //   2276: astore 34
    //   2278: aload 28
    //   2280: astore 33
    //   2282: iload 5
    //   2284: istore 4
    //   2286: aload 28
    //   2288: ldc_w 445
    //   2291: invokevirtual 448	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2294: ifeq +4677 -> 6971
    //   2297: aload 28
    //   2299: astore 34
    //   2301: aload 28
    //   2303: astore 33
    //   2305: iload 5
    //   2307: istore 4
    //   2309: aload_0
    //   2310: iconst_0
    //   2311: putfield 450	bhyo:jdField_e_of_type_Boolean	Z
    //   2314: iconst_1
    //   2315: istore 4
    //   2317: iconst_1
    //   2318: istore 5
    //   2320: aload 28
    //   2322: astore 34
    //   2324: aload 28
    //   2326: astore 33
    //   2328: aload 28
    //   2330: ldc_w 452
    //   2333: ldc_w 454
    //   2336: invokevirtual 457	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2339: astore 28
    //   2341: new 459	org/apache/http/client/methods/HttpGet
    //   2344: dup
    //   2345: aload 28
    //   2347: invokespecial 460	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2350: astore 33
    //   2352: aload_0
    //   2353: invokevirtual 463	bhyo:a	()Ljava/util/Map;
    //   2356: astore 30
    //   2358: aload 30
    //   2360: ifnull +183 -> 2543
    //   2363: aload 30
    //   2365: invokeinterface 467 1 0
    //   2370: invokeinterface 473 1 0
    //   2375: astore 34
    //   2377: aload 34
    //   2379: invokeinterface 478 1 0
    //   2384: ifeq +159 -> 2543
    //   2387: aload 34
    //   2389: invokeinterface 482 1 0
    //   2394: checkcast 207	java/lang/String
    //   2397: astore 44
    //   2399: aload 30
    //   2401: aload 44
    //   2403: invokeinterface 230 2 0
    //   2408: checkcast 207	java/lang/String
    //   2411: astore 45
    //   2413: aload 33
    //   2415: aload 44
    //   2417: aload 45
    //   2419: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2422: aload 42
    //   2424: ldc_w 488
    //   2427: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2430: aload 44
    //   2432: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2435: ldc_w 490
    //   2438: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2441: aload 45
    //   2443: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: pop
    //   2447: goto -70 -> 2377
    //   2450: astore 34
    //   2452: aload 31
    //   2454: astore 30
    //   2456: iconst_0
    //   2457: istore 13
    //   2459: iload 6
    //   2461: istore 8
    //   2463: iload 5
    //   2465: istore 4
    //   2467: aload 32
    //   2469: astore 31
    //   2471: aload 29
    //   2473: astore 33
    //   2475: aload 34
    //   2477: astore 32
    //   2479: iload 7
    //   2481: istore 6
    //   2483: iload_3
    //   2484: istore 5
    //   2486: aload 30
    //   2488: astore 29
    //   2490: aload 33
    //   2492: astore 30
    //   2494: iload 8
    //   2496: istore_3
    //   2497: goto -1406 -> 1091
    //   2500: aload 28
    //   2502: astore 34
    //   2504: aload 28
    //   2506: astore 33
    //   2508: iload 5
    //   2510: istore 4
    //   2512: new 122	java/lang/StringBuilder
    //   2515: dup
    //   2516: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2519: aload 28
    //   2521: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2524: ldc_w 492
    //   2527: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2530: iload 12
    //   2532: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2535: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2538: astore 30
    //   2540: goto -388 -> 2152
    //   2543: aload_0
    //   2544: getfield 495	bhyo:k	Z
    //   2547: ifeq +41 -> 2588
    //   2550: getstatic 498	bkwb:jdField_a_of_type_Boolean	Z
    //   2553: ifeq +35 -> 2588
    //   2556: invokestatic 499	bkwb:a	()Z
    //   2559: ifeq +29 -> 2588
    //   2562: aload 33
    //   2564: ldc_w 501
    //   2567: ldc_w 503
    //   2570: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2573: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2576: ifeq +12 -> 2588
    //   2579: ldc 73
    //   2581: iconst_2
    //   2582: ldc_w 505
    //   2585: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2588: aload_0
    //   2589: getfield 508	bhyo:l	Z
    //   2592: ifeq +154 -> 2746
    //   2595: invokestatic 513	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   2598: getstatic 519	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   2601: invokevirtual 522	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   2604: invokevirtual 523	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2607: astore 30
    //   2609: aload 30
    //   2611: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2614: ifne +1016 -> 3630
    //   2617: aload 30
    //   2619: invokestatic 527	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2622: iconst_1
    //   2623: iand
    //   2624: iconst_1
    //   2625: if_icmpne +1005 -> 3630
    //   2628: aload 33
    //   2630: ldc_w 501
    //   2633: ldc_w 529
    //   2636: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2639: ldc_w 531
    //   2642: iconst_3
    //   2643: anewarray 4	java/lang/Object
    //   2646: dup
    //   2647: iconst_0
    //   2648: getstatic 27	bhyq:jdField_a_of_type_ArrayOfInt	[I
    //   2651: iconst_0
    //   2652: iaload
    //   2653: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2656: aastore
    //   2657: dup
    //   2658: iconst_1
    //   2659: getstatic 27	bhyq:jdField_a_of_type_ArrayOfInt	[I
    //   2662: iconst_1
    //   2663: iaload
    //   2664: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2667: aastore
    //   2668: dup
    //   2669: iconst_2
    //   2670: getstatic 27	bhyq:jdField_a_of_type_ArrayOfInt	[I
    //   2673: iconst_2
    //   2674: iaload
    //   2675: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2678: aastore
    //   2679: invokestatic 535	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2682: astore 30
    //   2684: aload 33
    //   2686: ldc_w 537
    //   2689: new 122	java/lang/StringBuilder
    //   2692: dup
    //   2693: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2696: ldc_w 539
    //   2699: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2702: aload 30
    //   2704: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2710: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2713: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2716: ifeq +30 -> 2746
    //   2719: ldc 73
    //   2721: iconst_2
    //   2722: new 122	java/lang/StringBuilder
    //   2725: dup
    //   2726: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2729: ldc_w 541
    //   2732: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2735: aload 28
    //   2737: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2740: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2743: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2746: aload 35
    //   2748: ifnull +80 -> 2828
    //   2751: aload 35
    //   2753: invokevirtual 302	java/io/File:exists	()Z
    //   2756: ifeq +72 -> 2828
    //   2759: aload 35
    //   2761: invokevirtual 544	java/io/File:length	()J
    //   2764: lstore 20
    //   2766: aload 33
    //   2768: ldc_w 546
    //   2771: new 122	java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2778: ldc_w 548
    //   2781: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: lload 20
    //   2786: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2789: ldc_w 550
    //   2792: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2795: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2798: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2801: aload 42
    //   2803: new 122	java/lang/StringBuilder
    //   2806: dup
    //   2807: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2810: ldc_w 552
    //   2813: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: lload 20
    //   2818: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2827: pop
    //   2828: aload_0
    //   2829: getfield 555	bhyo:m	Z
    //   2832: ifne +119 -> 2951
    //   2835: aload_0
    //   2836: getfield 558	bhyo:j	Z
    //   2839: ifeq +112 -> 2951
    //   2842: aload 36
    //   2844: ifnull +107 -> 2951
    //   2847: aload 36
    //   2849: invokevirtual 302	java/io/File:exists	()Z
    //   2852: ifeq +99 -> 2951
    //   2855: aload_0
    //   2856: getfield 560	bhyo:jdField_i_of_type_Long	J
    //   2859: lconst_0
    //   2860: lcmp
    //   2861: ifle +787 -> 3648
    //   2864: aload_0
    //   2865: getfield 560	bhyo:jdField_i_of_type_Long	J
    //   2868: lstore 20
    //   2870: lload 20
    //   2872: lconst_0
    //   2873: lcmp
    //   2874: ifle +77 -> 2951
    //   2877: new 562	java/text/SimpleDateFormat
    //   2880: dup
    //   2881: ldc_w 564
    //   2884: getstatic 570	java/util/Locale:US	Ljava/util/Locale;
    //   2887: invokespecial 573	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   2890: astore 30
    //   2892: aload 30
    //   2894: ldc_w 575
    //   2897: invokestatic 581	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   2900: invokevirtual 585	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   2903: aload 30
    //   2905: new 587	java/util/Date
    //   2908: dup
    //   2909: lload 20
    //   2911: invokespecial 588	java/util/Date:<init>	(J)V
    //   2914: invokevirtual 591	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2917: astore 30
    //   2919: aload 30
    //   2921: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2924: ifne +27 -> 2951
    //   2927: aload 33
    //   2929: ldc_w 593
    //   2932: aload 30
    //   2934: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2937: aload 42
    //   2939: ldc_w 595
    //   2942: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2945: aload 30
    //   2947: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: pop
    //   2951: getstatic 20	bhyq:jdField_a_of_type_Boolean	Z
    //   2954: ifeq +105 -> 3059
    //   2957: aload_0
    //   2958: getfield 450	bhyo:jdField_e_of_type_Boolean	Z
    //   2961: ifeq +98 -> 3059
    //   2964: aload_0
    //   2965: getfield 597	bhyo:jdField_d_of_type_Boolean	Z
    //   2968: ifeq +91 -> 3059
    //   2971: aload 37
    //   2973: getfield 381	asid:jdField_b_of_type_Boolean	Z
    //   2976: ifne +83 -> 3059
    //   2979: aload 37
    //   2981: invokestatic 600	bhyq:a	(Lasid;)V
    //   2984: aload 37
    //   2986: getfield 384	asid:jdField_a_of_type_Boolean	Z
    //   2989: ifeq +70 -> 3059
    //   2992: aload 33
    //   2994: new 602	java/net/URI
    //   2997: dup
    //   2998: aload 37
    //   3000: getfield 603	asid:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3003: invokespecial 604	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3006: invokevirtual 608	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3009: aload 33
    //   3011: ldc_w 610
    //   3014: aload 37
    //   3016: getfield 611	asid:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3019: invokevirtual 486	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3022: aload 42
    //   3024: ldc_w 613
    //   3027: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3030: aload 37
    //   3032: getfield 611	asid:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3035: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3038: ldc_w 615
    //   3041: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: aload 37
    //   3046: getfield 617	asid:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3049: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3052: ldc_w 619
    //   3055: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3058: pop
    //   3059: aload 43
    //   3061: invokevirtual 624	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3064: invokestatic 629	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   3067: astore 30
    //   3069: aload 30
    //   3071: aload_0
    //   3072: getfield 630	bhyo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3075: invokevirtual 634	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3078: ifne +14 -> 3092
    //   3081: aload_0
    //   3082: iconst_0
    //   3083: putfield 344	bhyo:jdField_f_of_type_Boolean	Z
    //   3086: aload_0
    //   3087: aload 30
    //   3089: putfield 630	bhyo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3092: aload 43
    //   3094: invokestatic 640	com/tencent/mobileqq/utils/NetworkUtil:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   3097: ifeq +561 -> 3658
    //   3100: aload_0
    //   3101: getfield 344	bhyo:jdField_f_of_type_Boolean	Z
    //   3104: ifne +3860 -> 6964
    //   3107: invokestatic 645	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3110: astore 30
    //   3112: invokestatic 648	android/net/Proxy:getDefaultPort	()I
    //   3115: istore 8
    //   3117: aload 30
    //   3119: ifnull +3838 -> 6957
    //   3122: iload 8
    //   3124: ifle +3833 -> 6957
    //   3127: aload 38
    //   3129: ldc_w 650
    //   3132: new 652	org/apache/http/HttpHost
    //   3135: dup
    //   3136: aload 30
    //   3138: iload 8
    //   3140: invokespecial 655	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3143: invokeinterface 153 3 0
    //   3148: pop
    //   3149: iconst_1
    //   3150: istore 4
    //   3152: aload 42
    //   3154: ldc_w 657
    //   3157: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: iconst_1
    //   3161: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3164: ldc_w 659
    //   3167: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: aload 30
    //   3172: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: ldc_w 661
    //   3178: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: iload 8
    //   3183: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3186: pop
    //   3187: aload_0
    //   3188: getfield 288	bhyo:p	Z
    //   3191: ifne +18 -> 3209
    //   3194: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3197: invokestatic 665	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   3200: ifeq +9 -> 3209
    //   3203: aload 38
    //   3205: iconst_0
    //   3206: invokestatic 671	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3209: aload 38
    //   3211: ldc_w 673
    //   3214: iload_3
    //   3215: invokeinterface 677 3 0
    //   3220: pop
    //   3221: aload 33
    //   3223: aload 38
    //   3225: invokevirtual 681	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3228: aload_0
    //   3229: getfield 160	bhyo:n	Z
    //   3232: ifeq +436 -> 3668
    //   3235: ldc 162
    //   3237: astore 30
    //   3239: aload 33
    //   3241: ldc 164
    //   3243: aload 30
    //   3245: invokevirtual 684	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3248: ldc_w 685
    //   3251: invokestatic 689	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   3254: getstatic 695	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3257: aload 33
    //   3259: invokevirtual 701	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3262: astore 34
    //   3264: iconst_1
    //   3265: istore 15
    //   3267: iload 5
    //   3269: istore 8
    //   3271: aload 34
    //   3273: invokeinterface 707 1 0
    //   3278: invokeinterface 712 1 0
    //   3283: istore 7
    //   3285: iload 5
    //   3287: istore 8
    //   3289: aload_0
    //   3290: iload 7
    //   3292: putfield 440	bhyo:jdField_f_of_type_Int	I
    //   3295: iload 5
    //   3297: istore 8
    //   3299: aload 37
    //   3301: iload 7
    //   3303: putfield 714	asid:jdField_c_of_type_Int	I
    //   3306: iload 5
    //   3308: istore 8
    //   3310: aload 42
    //   3312: ldc_w 716
    //   3315: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: aload 33
    //   3320: invokevirtual 720	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3323: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3326: ldc_w 722
    //   3329: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3332: iload 7
    //   3334: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3337: ldc_w 724
    //   3340: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3343: pop
    //   3344: iload 5
    //   3346: istore 8
    //   3348: aload 34
    //   3350: invokeinterface 728 1 0
    //   3355: astore 30
    //   3357: iload 5
    //   3359: istore 8
    //   3361: aload 30
    //   3363: invokeinterface 731 1 0
    //   3368: ifeq +307 -> 3675
    //   3371: iload 5
    //   3373: istore 8
    //   3375: aload 30
    //   3377: invokeinterface 735 1 0
    //   3382: astore 33
    //   3384: iload 5
    //   3386: istore 8
    //   3388: aload 33
    //   3390: invokeinterface 738 1 0
    //   3395: astore 43
    //   3397: iload 5
    //   3399: istore 8
    //   3401: ldc_w 740
    //   3404: aload 43
    //   3406: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3409: ifne +138 -> 3547
    //   3412: iload 5
    //   3414: istore 8
    //   3416: ldc_w 745
    //   3419: aload 43
    //   3421: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3424: ifne +123 -> 3547
    //   3427: iload 5
    //   3429: istore 8
    //   3431: ldc_w 747
    //   3434: aload 43
    //   3436: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3439: ifne +108 -> 3547
    //   3442: iload 5
    //   3444: istore 8
    //   3446: ldc_w 749
    //   3449: aload 43
    //   3451: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3454: ifne +93 -> 3547
    //   3457: iload 5
    //   3459: istore 8
    //   3461: ldc_w 751
    //   3464: aload 43
    //   3466: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3469: ifne +78 -> 3547
    //   3472: iload 5
    //   3474: istore 8
    //   3476: ldc_w 753
    //   3479: aload 43
    //   3481: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3484: ifne +63 -> 3547
    //   3487: iload 5
    //   3489: istore 8
    //   3491: ldc_w 755
    //   3494: aload 43
    //   3496: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3499: ifne +48 -> 3547
    //   3502: iload 5
    //   3504: istore 8
    //   3506: ldc_w 757
    //   3509: aload 43
    //   3511: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3514: ifne +33 -> 3547
    //   3517: iload 5
    //   3519: istore 8
    //   3521: ldc_w 759
    //   3524: aload 43
    //   3526: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3529: ifne +18 -> 3547
    //   3532: iload 5
    //   3534: istore 8
    //   3536: ldc_w 761
    //   3539: aload 43
    //   3541: invokevirtual 743	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3544: ifeq -187 -> 3357
    //   3547: iload 5
    //   3549: istore 8
    //   3551: aload 42
    //   3553: ldc_w 488
    //   3556: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3559: aload 43
    //   3561: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3564: ldc_w 763
    //   3567: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3570: aload 33
    //   3572: invokeinterface 766 1 0
    //   3577: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3580: pop
    //   3581: goto -224 -> 3357
    //   3584: astore 34
    //   3586: iconst_1
    //   3587: istore 13
    //   3589: aload 29
    //   3591: astore 30
    //   3593: aload 32
    //   3595: astore 33
    //   3597: aload 31
    //   3599: astore 29
    //   3601: iload 6
    //   3603: istore 7
    //   3605: aload 34
    //   3607: astore 32
    //   3609: iload 4
    //   3611: istore 6
    //   3613: iload 8
    //   3615: istore 4
    //   3617: iload_3
    //   3618: istore 5
    //   3620: aload 33
    //   3622: astore 31
    //   3624: iload 7
    //   3626: istore_3
    //   3627: goto -2536 -> 1091
    //   3630: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3633: ifeq -887 -> 2746
    //   3636: ldc 73
    //   3638: iconst_2
    //   3639: ldc_w 768
    //   3642: invokestatic 771	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3645: goto -899 -> 2746
    //   3648: aload 36
    //   3650: invokevirtual 774	java/io/File:lastModified	()J
    //   3653: lstore 20
    //   3655: goto -785 -> 2870
    //   3658: sipush 4096
    //   3661: istore_3
    //   3662: iconst_0
    //   3663: istore 4
    //   3665: goto -478 -> 3187
    //   3668: ldc 187
    //   3670: astore 30
    //   3672: goto -433 -> 3239
    //   3675: sipush 200
    //   3678: iload 7
    //   3680: if_icmpeq +11 -> 3691
    //   3683: sipush 206
    //   3686: iload 7
    //   3688: if_icmpne +1756 -> 5444
    //   3691: iload 5
    //   3693: istore 8
    //   3695: aload 34
    //   3697: invokeinterface 778 1 0
    //   3702: astore 30
    //   3704: aload 30
    //   3706: invokeinterface 783 1 0
    //   3711: lstore 22
    //   3713: lload 22
    //   3715: lstore 20
    //   3717: iload 5
    //   3719: istore 7
    //   3721: aload 42
    //   3723: ldc_w 785
    //   3726: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3729: lload 22
    //   3731: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3734: pop
    //   3735: lload 22
    //   3737: lstore 20
    //   3739: iload 5
    //   3741: istore 7
    //   3743: aload 34
    //   3745: ldc_w 787
    //   3748: invokeinterface 791 2 0
    //   3753: astore 32
    //   3755: lload 22
    //   3757: lstore 20
    //   3759: iload 5
    //   3761: istore 7
    //   3763: aload 34
    //   3765: ldc_w 747
    //   3768: invokeinterface 791 2 0
    //   3773: astore 33
    //   3775: aload 32
    //   3777: ifnull +254 -> 4031
    //   3780: lload 22
    //   3782: lstore 20
    //   3784: iload 5
    //   3786: istore 7
    //   3788: aload 32
    //   3790: invokeinterface 766 1 0
    //   3795: ldc_w 793
    //   3798: invokevirtual 797	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3801: iconst_1
    //   3802: aaload
    //   3803: invokestatic 527	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3806: i2l
    //   3807: lstore 16
    //   3809: lload 16
    //   3811: lstore 20
    //   3813: iload 5
    //   3815: istore 7
    //   3817: aload 35
    //   3819: invokevirtual 544	java/io/File:length	()J
    //   3822: lstore 22
    //   3824: lload 16
    //   3826: lstore 20
    //   3828: iload 5
    //   3830: istore 7
    //   3832: aload 42
    //   3834: ldc_w 799
    //   3837: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: lload 16
    //   3842: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3845: ldc_w 801
    //   3848: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: lload 22
    //   3853: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3856: pop
    //   3857: lload 16
    //   3859: lstore 20
    //   3861: iload 5
    //   3863: istore 7
    //   3865: aload_0
    //   3866: getfield 803	bhyo:jdField_g_of_type_Boolean	Z
    //   3869: ifne +10 -> 3879
    //   3872: lload 16
    //   3874: lconst_1
    //   3875: lcmp
    //   3876: iflt +38 -> 3914
    //   3879: lload 16
    //   3881: lstore 20
    //   3883: iload 5
    //   3885: istore 7
    //   3887: aload_0
    //   3888: getfield 805	bhyo:jdField_e_of_type_Long	J
    //   3891: lconst_0
    //   3892: lcmp
    //   3893: ifle +171 -> 4064
    //   3896: lload 16
    //   3898: lstore 20
    //   3900: iload 5
    //   3902: istore 7
    //   3904: lload 16
    //   3906: aload_0
    //   3907: getfield 805	bhyo:jdField_e_of_type_Long	J
    //   3910: lcmp
    //   3911: ifle +153 -> 4064
    //   3914: iconst_1
    //   3915: istore 7
    //   3917: iconst_1
    //   3918: istore 12
    //   3920: bipush 138
    //   3922: istore 8
    //   3924: lload 16
    //   3926: lstore 20
    //   3928: aload_0
    //   3929: bipush 138
    //   3931: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   3934: iload 8
    //   3936: istore 6
    //   3938: iload 12
    //   3940: istore 5
    //   3942: iload 8
    //   3944: istore 7
    //   3946: aload 42
    //   3948: ldc_w 807
    //   3951: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3954: aload_0
    //   3955: getfield 805	bhyo:jdField_e_of_type_Long	J
    //   3958: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3961: pop
    //   3962: iload 8
    //   3964: istore 6
    //   3966: iload 12
    //   3968: istore 5
    //   3970: iload 8
    //   3972: istore 7
    //   3974: new 328	java/lang/Exception
    //   3977: dup
    //   3978: ldc_w 809
    //   3981: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   3984: athrow
    //   3985: astore 32
    //   3987: aload 29
    //   3989: astore 33
    //   3991: aload 30
    //   3993: astore 34
    //   3995: iconst_1
    //   3996: istore 13
    //   3998: aload 31
    //   4000: astore 29
    //   4002: iload 6
    //   4004: istore 7
    //   4006: iload 4
    //   4008: istore 6
    //   4010: iload 5
    //   4012: istore 4
    //   4014: iload_3
    //   4015: istore 5
    //   4017: aload 33
    //   4019: astore 30
    //   4021: aload 34
    //   4023: astore 31
    //   4025: iload 7
    //   4027: istore_3
    //   4028: goto -2937 -> 1091
    //   4031: lload 22
    //   4033: lstore 16
    //   4035: aload 33
    //   4037: ifnull -228 -> 3809
    //   4040: lload 22
    //   4042: lstore 20
    //   4044: iload 5
    //   4046: istore 7
    //   4048: aload 33
    //   4050: invokeinterface 766 1 0
    //   4055: invokestatic 527	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4058: i2l
    //   4059: lstore 16
    //   4061: goto -252 -> 3809
    //   4064: lconst_0
    //   4065: lload 22
    //   4067: lcmp
    //   4068: ifeq +74 -> 4142
    //   4071: lload 22
    //   4073: lload 16
    //   4075: lcmp
    //   4076: iflt +66 -> 4142
    //   4079: lload 16
    //   4081: lstore 20
    //   4083: iload 5
    //   4085: istore 7
    //   4087: aload 35
    //   4089: invokevirtual 308	java/io/File:delete	()Z
    //   4092: pop
    //   4093: bipush 139
    //   4095: istore 8
    //   4097: lload 16
    //   4099: lstore 20
    //   4101: iload 5
    //   4103: istore 7
    //   4105: aload_0
    //   4106: bipush 139
    //   4108: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   4111: iload 8
    //   4113: istore 6
    //   4115: iload 8
    //   4117: istore 7
    //   4119: new 328	java/lang/Exception
    //   4122: dup
    //   4123: ldc_w 811
    //   4126: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4129: athrow
    //   4130: astore_1
    //   4131: iload 7
    //   4133: istore 6
    //   4135: aload 30
    //   4137: astore 32
    //   4139: goto -2362 -> 1777
    //   4142: lload 22
    //   4144: lconst_0
    //   4145: lcmp
    //   4146: ifeq +334 -> 4480
    //   4149: iconst_1
    //   4150: istore 13
    //   4152: lload 16
    //   4154: lstore 20
    //   4156: iload 5
    //   4158: istore 7
    //   4160: new 813	java/io/BufferedOutputStream
    //   4163: dup
    //   4164: new 815	java/io/FileOutputStream
    //   4167: dup
    //   4168: aload 35
    //   4170: iload 13
    //   4172: invokespecial 818	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4175: invokespecial 821	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4178: astore 32
    //   4180: aload 34
    //   4182: ldc_w 759
    //   4185: invokeinterface 791 2 0
    //   4190: ifnull +296 -> 4486
    //   4193: ldc 162
    //   4195: aload 34
    //   4197: ldc_w 759
    //   4200: invokeinterface 791 2 0
    //   4205: invokeinterface 766 1 0
    //   4210: invokevirtual 634	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4213: ifeq +273 -> 4486
    //   4216: new 823	java/util/zip/GZIPInputStream
    //   4219: dup
    //   4220: aload 30
    //   4222: invokeinterface 827 1 0
    //   4227: invokespecial 830	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4230: astore 31
    //   4232: aload 42
    //   4234: ldc_w 832
    //   4237: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4240: pop
    //   4241: aload 31
    //   4243: astore 29
    //   4245: invokestatic 838	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4248: iload_3
    //   4249: invokevirtual 842	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4252: astore 43
    //   4254: iconst_0
    //   4255: istore 7
    //   4257: lload 18
    //   4259: lstore 20
    //   4261: aload_0
    //   4262: invokevirtual 391	bhyo:b	()Z
    //   4265: ifne +326 -> 4591
    //   4268: lload 18
    //   4270: lstore 20
    //   4272: aload 29
    //   4274: aload 43
    //   4276: invokevirtual 848	java/io/InputStream:read	([B)I
    //   4279: istore 8
    //   4281: iload 8
    //   4283: iconst_m1
    //   4284: if_icmpeq +307 -> 4591
    //   4287: lload 18
    //   4289: lstore 20
    //   4291: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4294: ifeq +64 -> 4358
    //   4297: lconst_0
    //   4298: lload 22
    //   4300: lcmp
    //   4301: ifne +57 -> 4358
    //   4304: aconst_null
    //   4305: astore 33
    //   4307: iload 8
    //   4309: iconst_4
    //   4310: if_icmple +192 -> 4502
    //   4313: iconst_m1
    //   4314: aload 43
    //   4316: iconst_0
    //   4317: baload
    //   4318: if_icmpne +184 -> 4502
    //   4321: bipush 216
    //   4323: aload 43
    //   4325: iconst_1
    //   4326: baload
    //   4327: if_icmpne +175 -> 4502
    //   4330: ldc_w 850
    //   4333: astore 31
    //   4335: aload 31
    //   4337: ifnull +21 -> 4358
    //   4340: lload 18
    //   4342: lstore 20
    //   4344: aload 42
    //   4346: ldc_w 852
    //   4349: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: aload 31
    //   4354: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4357: pop
    //   4358: lload 18
    //   4360: lstore 20
    //   4362: aload 32
    //   4364: aload 43
    //   4366: iconst_0
    //   4367: iload 8
    //   4369: invokevirtual 856	java/io/BufferedOutputStream:write	([BII)V
    //   4372: lload 22
    //   4374: iload 8
    //   4376: i2l
    //   4377: ladd
    //   4378: lstore 22
    //   4380: lload 18
    //   4382: iload 8
    //   4384: i2l
    //   4385: ladd
    //   4386: lstore 18
    //   4388: iload 7
    //   4390: iload 8
    //   4392: iadd
    //   4393: istore 7
    //   4395: lload 16
    //   4397: lconst_0
    //   4398: lcmp
    //   4399: ifle +2555 -> 6954
    //   4402: lload 18
    //   4404: lstore 20
    //   4406: aload_0
    //   4407: getfield 858	bhyo:jdField_f_of_type_Long	J
    //   4410: lconst_0
    //   4411: lcmp
    //   4412: ifne +17 -> 4429
    //   4415: lload 18
    //   4417: lstore 20
    //   4419: aload_0
    //   4420: lload 16
    //   4422: ldc2_w 859
    //   4425: ldiv
    //   4426: putfield 858	bhyo:jdField_f_of_type_Long	J
    //   4429: lload 18
    //   4431: lstore 20
    //   4433: iload 7
    //   4435: i2l
    //   4436: aload_0
    //   4437: getfield 858	bhyo:jdField_f_of_type_Long	J
    //   4440: lcmp
    //   4441: ifge +11 -> 4452
    //   4444: lload 22
    //   4446: lload 16
    //   4448: lcmp
    //   4449: iflt +2505 -> 6954
    //   4452: lload 18
    //   4454: lstore 20
    //   4456: aload_0
    //   4457: lload 16
    //   4459: lload 22
    //   4461: iload 10
    //   4463: invokevirtual 863	bhyo:a	(JJI)V
    //   4466: lload 18
    //   4468: lstore 20
    //   4470: aload_0
    //   4471: invokevirtual 865	bhyo:b	()V
    //   4474: iconst_0
    //   4475: istore 7
    //   4477: goto -220 -> 4257
    //   4480: iconst_0
    //   4481: istore 13
    //   4483: goto -331 -> 4152
    //   4486: aload 30
    //   4488: invokeinterface 827 1 0
    //   4493: astore 31
    //   4495: aload 31
    //   4497: astore 29
    //   4499: goto -254 -> 4245
    //   4502: iload 8
    //   4504: bipush 8
    //   4506: if_icmple +2526 -> 7032
    //   4509: bipush 137
    //   4511: aload 43
    //   4513: iconst_0
    //   4514: baload
    //   4515: if_icmpne +2517 -> 7032
    //   4518: bipush 80
    //   4520: aload 43
    //   4522: iconst_1
    //   4523: baload
    //   4524: if_icmpne +2508 -> 7032
    //   4527: bipush 78
    //   4529: aload 43
    //   4531: iconst_2
    //   4532: baload
    //   4533: if_icmpne +2499 -> 7032
    //   4536: bipush 71
    //   4538: aload 43
    //   4540: iconst_3
    //   4541: baload
    //   4542: if_icmpne +2490 -> 7032
    //   4545: bipush 13
    //   4547: aload 43
    //   4549: iconst_4
    //   4550: baload
    //   4551: if_icmpne +2481 -> 7032
    //   4554: bipush 10
    //   4556: aload 43
    //   4558: iconst_5
    //   4559: baload
    //   4560: if_icmpne +2472 -> 7032
    //   4563: bipush 26
    //   4565: aload 43
    //   4567: bipush 6
    //   4569: baload
    //   4570: if_icmpne +2462 -> 7032
    //   4573: bipush 10
    //   4575: aload 43
    //   4577: bipush 7
    //   4579: baload
    //   4580: if_icmpne +2452 -> 7032
    //   4583: ldc_w 867
    //   4586: astore 31
    //   4588: goto -253 -> 4335
    //   4591: lload 18
    //   4593: lstore 20
    //   4595: aload 32
    //   4597: invokevirtual 870	java/io/BufferedOutputStream:flush	()V
    //   4600: lload 18
    //   4602: lstore 20
    //   4604: invokestatic 838	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4607: aload 43
    //   4609: invokevirtual 874	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   4612: lload 18
    //   4614: lstore 20
    //   4616: aload 35
    //   4618: invokevirtual 544	java/io/File:length	()J
    //   4621: lstore 22
    //   4623: lload 18
    //   4625: lstore 20
    //   4627: aload 42
    //   4629: ldc_w 876
    //   4632: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4635: lload 22
    //   4637: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4640: pop
    //   4641: lload 22
    //   4643: lload 16
    //   4645: lcmp
    //   4646: ifeq +80 -> 4726
    //   4649: lload 16
    //   4651: lconst_1
    //   4652: lcmp
    //   4653: ifge +21 -> 4674
    //   4656: lload 18
    //   4658: lstore 20
    //   4660: aload_0
    //   4661: getfield 803	bhyo:jdField_g_of_type_Boolean	Z
    //   4664: ifeq +10 -> 4674
    //   4667: lload 22
    //   4669: lconst_0
    //   4670: lcmp
    //   4671: ifgt +55 -> 4726
    //   4674: lload 18
    //   4676: lstore 20
    //   4678: aload 34
    //   4680: ldc_w 759
    //   4683: invokeinterface 791 2 0
    //   4688: ifnull +562 -> 5250
    //   4691: lload 18
    //   4693: lstore 20
    //   4695: ldc 162
    //   4697: aload 34
    //   4699: ldc_w 759
    //   4702: invokeinterface 791 2 0
    //   4707: invokeinterface 766 1 0
    //   4712: invokevirtual 634	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4715: ifeq +535 -> 5250
    //   4718: lload 22
    //   4720: lload 16
    //   4722: lcmp
    //   4723: iflt +527 -> 5250
    //   4726: lload 18
    //   4728: lstore 20
    //   4730: aload_0
    //   4731: iconst_0
    //   4732: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   4735: aload 36
    //   4737: invokevirtual 302	java/io/File:exists	()Z
    //   4740: ifeq +9 -> 4749
    //   4743: aload 36
    //   4745: invokevirtual 308	java/io/File:delete	()Z
    //   4748: pop
    //   4749: aload 35
    //   4751: aload 36
    //   4753: invokevirtual 880	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4756: istore 13
    //   4758: aload 42
    //   4760: ldc_w 882
    //   4763: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: iload 13
    //   4768: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4771: pop
    //   4772: aload_0
    //   4773: aload 36
    //   4775: aload 34
    //   4777: invokestatic 885	bhyq:a	(Lbhyo;Ljava/io/File;Lorg/apache/http/HttpResponse;)V
    //   4780: iconst_0
    //   4781: istore 7
    //   4783: iload 5
    //   4785: istore 6
    //   4787: iload 7
    //   4789: istore 5
    //   4791: lload 18
    //   4793: lstore 20
    //   4795: iload 5
    //   4797: istore 7
    //   4799: aload 30
    //   4801: astore 31
    //   4803: aload 29
    //   4805: astore 30
    //   4807: aload 32
    //   4809: astore 29
    //   4811: iload 6
    //   4813: istore 5
    //   4815: lload 16
    //   4817: lstore 18
    //   4819: lload 20
    //   4821: lstore 16
    //   4823: iload 5
    //   4825: istore 6
    //   4827: getstatic 42	bhyq:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4830: ifnonnull +17 -> 4847
    //   4833: iload 5
    //   4835: istore 6
    //   4837: new 39	java/util/concurrent/ConcurrentHashMap
    //   4840: dup
    //   4841: invokespecial 40	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   4844: putstatic 42	bhyq:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4847: iload 7
    //   4849: ifeq +1049 -> 5898
    //   4852: iload 5
    //   4854: istore 6
    //   4856: aload_0
    //   4857: invokevirtual 391	bhyo:b	()Z
    //   4860: ifne +1038 -> 5898
    //   4863: iload 5
    //   4865: istore 6
    //   4867: iload 11
    //   4869: aload_0
    //   4870: getfield 292	bhyo:jdField_b_of_type_Int	I
    //   4873: if_icmpge +922 -> 5795
    //   4876: iload 5
    //   4878: istore 6
    //   4880: aload 40
    //   4882: monitorenter
    //   4883: sipush 2000
    //   4886: i2l
    //   4887: lstore 20
    //   4889: aload 40
    //   4891: lload 20
    //   4893: invokevirtual 888	java/lang/Object:wait	(J)V
    //   4896: aload 40
    //   4898: monitorexit
    //   4899: iload 5
    //   4901: istore 6
    //   4903: aload_0
    //   4904: getfield 117	bhyo:jdField_a_of_type_Int	I
    //   4907: sipush 302
    //   4910: if_icmpne +44 -> 4954
    //   4913: iload 5
    //   4915: istore 6
    //   4917: aload 34
    //   4919: ldc_w 753
    //   4922: invokeinterface 791 2 0
    //   4927: astore 32
    //   4929: aload 32
    //   4931: ifnull +23 -> 4954
    //   4934: iload 5
    //   4936: istore 6
    //   4938: aload 39
    //   4940: ldc_w 890
    //   4943: aload 32
    //   4945: invokeinterface 766 1 0
    //   4950: invokevirtual 894	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4953: pop
    //   4954: iload 7
    //   4956: istore 8
    //   4958: invokestatic 368	android/net/TrafficStats:clearThreadStatsTag	()V
    //   4961: iload 7
    //   4963: istore 8
    //   4965: ldc 73
    //   4967: iconst_1
    //   4968: new 122	java/lang/StringBuilder
    //   4971: dup
    //   4972: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   4975: aload 42
    //   4977: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4980: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4983: ldc_w 370
    //   4986: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4989: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   4992: lload 26
    //   4994: lsub
    //   4995: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4998: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5001: invokestatic 373	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5004: iload 7
    //   5006: istore 8
    //   5008: aload_0
    //   5009: getfield 213	bhyo:jdField_g_of_type_Int	I
    //   5012: iconst_3
    //   5013: if_icmpne +64 -> 5077
    //   5016: iload 14
    //   5018: ifeq +59 -> 5077
    //   5021: iload 7
    //   5023: istore 8
    //   5025: bipush 30
    //   5027: aload_0
    //   5028: getfield 210	bhyo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5031: sipush 300
    //   5034: iconst_1
    //   5035: anewarray 4	java/lang/Object
    //   5038: dup
    //   5039: iconst_0
    //   5040: new 122	java/lang/StringBuilder
    //   5043: dup
    //   5044: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   5047: aload 42
    //   5049: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5052: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5055: ldc_w 370
    //   5058: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5061: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   5064: lload 26
    //   5066: lsub
    //   5067: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5070: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5073: aastore
    //   5074: invokestatic 376	anis:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   5077: iload 7
    //   5079: istore 8
    //   5081: aload_0
    //   5082: aload_2
    //   5083: iload 7
    //   5085: aload 36
    //   5087: aload 37
    //   5089: invokestatic 379	bhyq:a	(Lbhyo;Landroid/content/Context;ILjava/io/File;Lasid;)V
    //   5092: iload 7
    //   5094: istore 8
    //   5096: new 122	java/lang/StringBuilder
    //   5099: dup
    //   5100: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   5103: astore 33
    //   5105: iload 7
    //   5107: istore 8
    //   5109: aload 37
    //   5111: getfield 381	asid:jdField_b_of_type_Boolean	Z
    //   5114: ifeq +802 -> 5916
    //   5117: ldc_w 383
    //   5120: astore 32
    //   5122: iload 7
    //   5124: istore 8
    //   5126: aload 33
    //   5128: aload 32
    //   5130: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5133: astore 33
    //   5135: iload 7
    //   5137: istore 8
    //   5139: aload 37
    //   5141: getfield 384	asid:jdField_a_of_type_Boolean	Z
    //   5144: ifeq +780 -> 5924
    //   5147: ldc_w 386
    //   5150: astore 32
    //   5152: iload 7
    //   5154: istore 8
    //   5156: aload 33
    //   5158: aload 32
    //   5160: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5163: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5166: astore 33
    //   5168: iload 7
    //   5170: istore 8
    //   5172: aload 31
    //   5174: aload 30
    //   5176: aload 29
    //   5178: aload 28
    //   5180: invokestatic 389	bhyq:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   5183: iload 11
    //   5185: iconst_1
    //   5186: iadd
    //   5187: istore 11
    //   5189: aload 31
    //   5191: astore 32
    //   5193: aload 30
    //   5195: astore 31
    //   5197: lload 18
    //   5199: lstore 20
    //   5201: iload 4
    //   5203: istore 6
    //   5205: aload 28
    //   5207: astore 30
    //   5209: iload_3
    //   5210: istore 4
    //   5212: lload 16
    //   5214: lstore 18
    //   5216: aload 29
    //   5218: astore 28
    //   5220: aload 32
    //   5222: astore 29
    //   5224: iload 5
    //   5226: istore 8
    //   5228: iload 15
    //   5230: istore 13
    //   5232: iload 11
    //   5234: istore 5
    //   5236: lload 20
    //   5238: lstore 16
    //   5240: iload 7
    //   5242: istore_3
    //   5243: aload 33
    //   5245: astore 32
    //   5247: goto -3776 -> 1471
    //   5250: lload 18
    //   5252: lstore 20
    //   5254: aload_0
    //   5255: invokevirtual 391	bhyo:b	()Z
    //   5258: istore 13
    //   5260: iload 13
    //   5262: ifeq +93 -> 5355
    //   5265: iconst_1
    //   5266: istore 7
    //   5268: bipush 150
    //   5270: istore 5
    //   5272: aload_0
    //   5273: bipush 150
    //   5275: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5278: iload 5
    //   5280: istore 6
    //   5282: aload 42
    //   5284: ldc_w 896
    //   5287: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5290: pop
    //   5291: iload 7
    //   5293: istore 6
    //   5295: goto -504 -> 4791
    //   5298: astore 34
    //   5300: aload 29
    //   5302: astore 31
    //   5304: aload 30
    //   5306: astore 33
    //   5308: bipush 150
    //   5310: istore 7
    //   5312: iconst_1
    //   5313: istore 5
    //   5315: iconst_1
    //   5316: istore 13
    //   5318: aload 34
    //   5320: astore 30
    //   5322: aload 32
    //   5324: astore 29
    //   5326: aload 30
    //   5328: astore 32
    //   5330: iload 4
    //   5332: istore 6
    //   5334: iload 5
    //   5336: istore 4
    //   5338: iload_3
    //   5339: istore 5
    //   5341: aload 31
    //   5343: astore 30
    //   5345: aload 33
    //   5347: astore 31
    //   5349: iload 7
    //   5351: istore_3
    //   5352: goto -4261 -> 1091
    //   5355: bipush 151
    //   5357: istore 7
    //   5359: lload 18
    //   5361: lstore 20
    //   5363: aload_0
    //   5364: bipush 151
    //   5366: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5369: iload 7
    //   5371: istore 6
    //   5373: aload 35
    //   5375: invokevirtual 308	java/io/File:delete	()Z
    //   5378: pop
    //   5379: iload 7
    //   5381: istore 6
    //   5383: new 328	java/lang/Exception
    //   5386: dup
    //   5387: ldc_w 898
    //   5390: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   5393: athrow
    //   5394: astore 34
    //   5396: aload 29
    //   5398: astore 31
    //   5400: aload 30
    //   5402: astore 33
    //   5404: bipush 151
    //   5406: istore 7
    //   5408: aload 32
    //   5410: astore 29
    //   5412: iconst_1
    //   5413: istore 13
    //   5415: aload 34
    //   5417: astore 32
    //   5419: iload 4
    //   5421: istore 6
    //   5423: iload 5
    //   5425: istore 4
    //   5427: iload_3
    //   5428: istore 5
    //   5430: aload 31
    //   5432: astore 30
    //   5434: aload 33
    //   5436: astore 31
    //   5438: iload 7
    //   5440: istore_3
    //   5441: goto -4350 -> 1091
    //   5444: sipush 404
    //   5447: iload 7
    //   5449: if_icmpne +1710 -> 7159
    //   5452: iconst_1
    //   5453: istore 5
    //   5455: iconst_1
    //   5456: istore 8
    //   5458: aload_0
    //   5459: iload 7
    //   5461: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5464: lload 16
    //   5466: lstore 20
    //   5468: aload 29
    //   5470: astore 30
    //   5472: aload 31
    //   5474: astore 29
    //   5476: lload 18
    //   5478: lstore 16
    //   5480: lload 20
    //   5482: lstore 18
    //   5484: aload 32
    //   5486: astore 31
    //   5488: goto -665 -> 4823
    //   5491: iload 5
    //   5493: istore 8
    //   5495: aload_0
    //   5496: getfield 288	bhyo:p	Z
    //   5499: ifne +101 -> 5600
    //   5502: iconst_1
    //   5503: istore 12
    //   5505: iconst_1
    //   5506: istore 8
    //   5508: iload 12
    //   5510: istore 5
    //   5512: aload_0
    //   5513: getfield 443	bhyo:r	Z
    //   5516: ifeq +26 -> 5542
    //   5519: iload 7
    //   5521: sipush 302
    //   5524: if_icmpeq +1654 -> 7178
    //   5527: iload 12
    //   5529: istore 5
    //   5531: iload 7
    //   5533: sipush 301
    //   5536: if_icmpne +6 -> 5542
    //   5539: goto +1639 -> 7178
    //   5542: iload 5
    //   5544: istore 8
    //   5546: aload_0
    //   5547: iload 7
    //   5549: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5552: aload 34
    //   5554: ldc_w 753
    //   5557: invokeinterface 791 2 0
    //   5562: invokeinterface 766 1 0
    //   5567: astore 33
    //   5569: lload 16
    //   5571: lstore 20
    //   5573: aload 29
    //   5575: astore 30
    //   5577: aload 31
    //   5579: astore 29
    //   5581: aload 33
    //   5583: astore 28
    //   5585: lload 18
    //   5587: lstore 16
    //   5589: lload 20
    //   5591: lstore 18
    //   5593: aload 32
    //   5595: astore 31
    //   5597: goto -774 -> 4823
    //   5600: sipush 304
    //   5603: iload 7
    //   5605: if_icmpne +42 -> 5647
    //   5608: iload 5
    //   5610: istore 8
    //   5612: aload_0
    //   5613: iconst_0
    //   5614: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5617: lload 16
    //   5619: lstore 20
    //   5621: aload 29
    //   5623: astore 30
    //   5625: aload 31
    //   5627: astore 29
    //   5629: iconst_0
    //   5630: istore 7
    //   5632: lload 18
    //   5634: lstore 16
    //   5636: lload 20
    //   5638: lstore 18
    //   5640: aload 32
    //   5642: astore 31
    //   5644: goto -821 -> 4823
    //   5647: sipush 416
    //   5650: iload 7
    //   5652: if_icmpne +62 -> 5714
    //   5655: iload 5
    //   5657: istore 8
    //   5659: aload 35
    //   5661: invokevirtual 302	java/io/File:exists	()Z
    //   5664: ifeq +13 -> 5677
    //   5667: iload 5
    //   5669: istore 8
    //   5671: aload 35
    //   5673: invokevirtual 308	java/io/File:delete	()Z
    //   5676: pop
    //   5677: iload 5
    //   5679: istore 8
    //   5681: aload_0
    //   5682: iload 7
    //   5684: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5687: lload 16
    //   5689: lstore 20
    //   5691: aload 29
    //   5693: astore 30
    //   5695: aload 31
    //   5697: astore 29
    //   5699: lload 18
    //   5701: lstore 16
    //   5703: lload 20
    //   5705: lstore 18
    //   5707: aload 32
    //   5709: astore 31
    //   5711: goto -888 -> 4823
    //   5714: iload 5
    //   5716: istore 8
    //   5718: aload_0
    //   5719: iload 7
    //   5721: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5724: lload 16
    //   5726: lstore 20
    //   5728: aload 29
    //   5730: astore 30
    //   5732: aload 31
    //   5734: astore 29
    //   5736: lload 18
    //   5738: lstore 16
    //   5740: lload 20
    //   5742: lstore 18
    //   5744: aload 32
    //   5746: astore 31
    //   5748: goto -925 -> 4823
    //   5751: astore 32
    //   5753: ldc 73
    //   5755: iconst_1
    //   5756: new 122	java/lang/StringBuilder
    //   5759: dup
    //   5760: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   5763: ldc_w 900
    //   5766: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5769: aload 28
    //   5771: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5774: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5777: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5780: goto -884 -> 4896
    //   5783: astore 32
    //   5785: aload 40
    //   5787: monitorexit
    //   5788: iload 5
    //   5790: istore 6
    //   5792: aload 32
    //   5794: athrow
    //   5795: iload 5
    //   5797: istore 6
    //   5799: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   5802: ldc2_w 901
    //   5805: ldiv
    //   5806: l2i
    //   5807: istore 8
    //   5809: iload 5
    //   5811: istore 6
    //   5813: aload_0
    //   5814: getfield 904	bhyo:jdField_c_of_type_Boolean	Z
    //   5817: ifeq +23 -> 5840
    //   5820: iload 5
    //   5822: istore 6
    //   5824: getstatic 42	bhyq:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5827: aload_0
    //   5828: getfield 906	bhyo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5831: iload 8
    //   5833: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5836: invokevirtual 907	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5839: pop
    //   5840: iconst_1
    //   5841: istore 6
    //   5843: new 328	java/lang/Exception
    //   5846: dup
    //   5847: new 122	java/lang/StringBuilder
    //   5850: dup
    //   5851: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   5854: ldc_w 909
    //   5857: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5860: aload 28
    //   5862: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5865: ldc_w 911
    //   5868: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5871: aload_0
    //   5872: getfield 450	bhyo:jdField_e_of_type_Boolean	Z
    //   5875: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5878: ldc_w 913
    //   5881: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5884: aload_0
    //   5885: getfield 597	bhyo:jdField_d_of_type_Boolean	Z
    //   5888: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5891: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5894: invokespecial 331	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   5897: athrow
    //   5898: iload 5
    //   5900: istore 6
    //   5902: getstatic 42	bhyq:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5905: aload_0
    //   5906: getfield 906	bhyo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5909: invokevirtual 916	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5912: pop
    //   5913: goto -1014 -> 4899
    //   5916: ldc_w 918
    //   5919: astore 32
    //   5921: goto -799 -> 5122
    //   5924: ldc_w 920
    //   5927: astore 32
    //   5929: goto -777 -> 5152
    //   5932: aload 32
    //   5934: instanceof 922
    //   5937: ifeq +12 -> 5949
    //   5940: aload_0
    //   5941: bipush 144
    //   5943: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5946: goto -4811 -> 1135
    //   5949: aload 32
    //   5951: instanceof 333
    //   5954: ifne +11 -> 5965
    //   5957: aload 32
    //   5959: instanceof 335
    //   5962: ifeq +12 -> 5974
    //   5965: aload_0
    //   5966: bipush 143
    //   5968: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5971: goto -4836 -> 1135
    //   5974: aload 32
    //   5976: instanceof 337
    //   5979: ifeq +12 -> 5991
    //   5982: aload_0
    //   5983: bipush 142
    //   5985: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   5988: goto -4853 -> 1135
    //   5991: aload_0
    //   5992: getfield 117	bhyo:jdField_a_of_type_Int	I
    //   5995: ifne -4860 -> 1135
    //   5998: aload_0
    //   5999: bipush 141
    //   6001: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   6004: goto -4869 -> 1135
    //   6007: aload_0
    //   6008: iconst_0
    //   6009: putfield 344	bhyo:jdField_f_of_type_Boolean	Z
    //   6012: goto -4848 -> 1164
    //   6015: ldc_w 918
    //   6018: astore 32
    //   6020: goto -4648 -> 1372
    //   6023: ldc_w 920
    //   6026: astore 32
    //   6028: goto -4628 -> 1400
    //   6031: ldc_w 918
    //   6034: astore_0
    //   6035: goto -4092 -> 1943
    //   6038: ldc_w 920
    //   6041: astore_0
    //   6042: goto -4073 -> 1969
    //   6045: iload 4
    //   6047: istore 8
    //   6049: aload_0
    //   6050: bipush 146
    //   6052: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   6055: iload 4
    //   6057: istore 8
    //   6059: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6062: ifeq +16 -> 6078
    //   6065: iload 4
    //   6067: istore 8
    //   6069: ldc 73
    //   6071: iconst_2
    //   6072: ldc_w 924
    //   6075: invokestatic 771	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6078: iconst_m1
    //   6079: istore 6
    //   6081: lconst_0
    //   6082: lstore 18
    //   6084: aload 28
    //   6086: astore 31
    //   6088: iload_3
    //   6089: istore 4
    //   6091: aload 29
    //   6093: astore 28
    //   6095: aload 30
    //   6097: astore 29
    //   6099: aload 31
    //   6101: astore 30
    //   6103: iload 6
    //   6105: istore_3
    //   6106: goto -4584 -> 1522
    //   6109: aload_0
    //   6110: getfield 927	bhyo:o	Z
    //   6113: istore 15
    //   6115: iload 15
    //   6117: iconst_1
    //   6118: if_icmpne +829 -> 6947
    //   6121: iload_3
    //   6122: istore 4
    //   6124: iload 9
    //   6126: ifle +818 -> 6944
    //   6129: iload 4
    //   6131: istore 8
    //   6133: aload_0
    //   6134: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6137: invokeinterface 173 1 0
    //   6142: iconst_1
    //   6143: if_icmple +801 -> 6944
    //   6146: iload 4
    //   6148: istore 8
    //   6150: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6153: ifeq +52 -> 6205
    //   6156: iload 4
    //   6158: istore 8
    //   6160: ldc 73
    //   6162: iconst_2
    //   6163: new 122	java/lang/StringBuilder
    //   6166: dup
    //   6167: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   6170: ldc_w 929
    //   6173: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6176: iload 9
    //   6178: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6181: ldc_w 931
    //   6184: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6187: aload_0
    //   6188: getfield 167	bhyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6191: invokeinterface 173 1 0
    //   6196: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6199: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6202: invokestatic 771	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6205: iload 4
    //   6207: istore 8
    //   6209: aload_0
    //   6210: bipush 148
    //   6212: putfield 117	bhyo:jdField_a_of_type_Int	I
    //   6215: iconst_m1
    //   6216: istore 4
    //   6218: iload 4
    //   6220: istore_3
    //   6221: aload_0
    //   6222: iload 4
    //   6224: invokestatic 934	bhyq:a	(Lbhyo;I)V
    //   6227: iload 4
    //   6229: istore_3
    //   6230: goto -5899 -> 331
    //   6233: astore_0
    //   6234: iload 8
    //   6236: istore_3
    //   6237: goto -5916 -> 321
    //   6240: astore_0
    //   6241: goto -5920 -> 321
    //   6244: astore_1
    //   6245: aload 34
    //   6247: astore 28
    //   6249: goto -4472 -> 1777
    //   6252: astore_1
    //   6253: aload 30
    //   6255: astore 32
    //   6257: goto -4480 -> 1777
    //   6260: astore_1
    //   6261: aload 32
    //   6263: astore 31
    //   6265: aload 30
    //   6267: astore 32
    //   6269: goto -4492 -> 1777
    //   6272: astore_1
    //   6273: aload 31
    //   6275: astore 29
    //   6277: aload 32
    //   6279: astore 31
    //   6281: aload 30
    //   6283: astore 32
    //   6285: goto -4508 -> 1777
    //   6288: astore_1
    //   6289: aload 32
    //   6291: astore 31
    //   6293: aload 30
    //   6295: astore 32
    //   6297: goto -4520 -> 1777
    //   6300: astore_1
    //   6301: iconst_0
    //   6302: istore 6
    //   6304: aload 32
    //   6306: astore 31
    //   6308: aload 30
    //   6310: astore 32
    //   6312: goto -4535 -> 1777
    //   6315: astore_1
    //   6316: aload 32
    //   6318: astore 31
    //   6320: aload 30
    //   6322: astore 32
    //   6324: goto -4547 -> 1777
    //   6327: astore_1
    //   6328: iload 7
    //   6330: istore 6
    //   6332: goto -4555 -> 1777
    //   6335: astore 28
    //   6337: aload 31
    //   6339: astore 30
    //   6341: iconst_0
    //   6342: istore 13
    //   6344: iload 6
    //   6346: istore 8
    //   6348: aload 32
    //   6350: astore 31
    //   6352: aload 29
    //   6354: astore 34
    //   6356: aload 28
    //   6358: astore 32
    //   6360: aload 33
    //   6362: astore 28
    //   6364: iload 7
    //   6366: istore 6
    //   6368: iload_3
    //   6369: istore 5
    //   6371: aload 30
    //   6373: astore 29
    //   6375: aload 34
    //   6377: astore 30
    //   6379: iload 8
    //   6381: istore_3
    //   6382: goto -5291 -> 1091
    //   6385: astore 30
    //   6387: iconst_1
    //   6388: istore 8
    //   6390: iconst_0
    //   6391: istore 13
    //   6393: iload 6
    //   6395: istore 7
    //   6397: iload 5
    //   6399: istore 4
    //   6401: aload 32
    //   6403: astore 33
    //   6405: aload 29
    //   6407: astore 34
    //   6409: aload 30
    //   6411: astore 32
    //   6413: iload 8
    //   6415: istore 6
    //   6417: iload_3
    //   6418: istore 5
    //   6420: aload 31
    //   6422: astore 29
    //   6424: aload 34
    //   6426: astore 30
    //   6428: aload 33
    //   6430: astore 31
    //   6432: iload 7
    //   6434: istore_3
    //   6435: goto -5344 -> 1091
    //   6438: astore 34
    //   6440: iconst_0
    //   6441: istore 13
    //   6443: aload 31
    //   6445: astore 30
    //   6447: iload 6
    //   6449: istore 7
    //   6451: aload 32
    //   6453: astore 31
    //   6455: aload 29
    //   6457: astore 33
    //   6459: aload 34
    //   6461: astore 32
    //   6463: iload 4
    //   6465: istore 6
    //   6467: iload 5
    //   6469: istore 4
    //   6471: iload_3
    //   6472: istore 5
    //   6474: aload 30
    //   6476: astore 29
    //   6478: aload 33
    //   6480: astore 30
    //   6482: iload 7
    //   6484: istore_3
    //   6485: goto -5394 -> 1091
    //   6488: astore 32
    //   6490: iconst_1
    //   6491: istore 13
    //   6493: aload 29
    //   6495: astore 33
    //   6497: aload 30
    //   6499: astore 34
    //   6501: aload 31
    //   6503: astore 29
    //   6505: iload 6
    //   6507: istore 7
    //   6509: iload 4
    //   6511: istore 6
    //   6513: iload 5
    //   6515: istore 4
    //   6517: iload_3
    //   6518: istore 5
    //   6520: aload 33
    //   6522: astore 30
    //   6524: aload 34
    //   6526: astore 31
    //   6528: iload 7
    //   6530: istore_3
    //   6531: goto -5440 -> 1091
    //   6534: astore 32
    //   6536: aload 29
    //   6538: astore 33
    //   6540: aload 30
    //   6542: astore 34
    //   6544: lload 20
    //   6546: lstore 16
    //   6548: iconst_1
    //   6549: istore 13
    //   6551: aload 31
    //   6553: astore 29
    //   6555: iload 6
    //   6557: istore 8
    //   6559: iload 4
    //   6561: istore 6
    //   6563: iload 7
    //   6565: istore 4
    //   6567: iload_3
    //   6568: istore 5
    //   6570: aload 33
    //   6572: astore 30
    //   6574: aload 34
    //   6576: astore 31
    //   6578: iload 8
    //   6580: istore_3
    //   6581: goto -5490 -> 1091
    //   6584: astore 34
    //   6586: aload 29
    //   6588: astore 31
    //   6590: aload 30
    //   6592: astore 33
    //   6594: iload 6
    //   6596: istore 7
    //   6598: aload 32
    //   6600: astore 29
    //   6602: iconst_1
    //   6603: istore 13
    //   6605: aload 34
    //   6607: astore 32
    //   6609: iload 4
    //   6611: istore 6
    //   6613: iload 5
    //   6615: istore 4
    //   6617: iload_3
    //   6618: istore 5
    //   6620: aload 31
    //   6622: astore 30
    //   6624: aload 33
    //   6626: astore 31
    //   6628: iload 7
    //   6630: istore_3
    //   6631: goto -5540 -> 1091
    //   6634: astore 34
    //   6636: aload 30
    //   6638: astore 33
    //   6640: iload 6
    //   6642: istore 7
    //   6644: aload 32
    //   6646: astore 29
    //   6648: iconst_1
    //   6649: istore 13
    //   6651: aload 34
    //   6653: astore 32
    //   6655: iload 4
    //   6657: istore 6
    //   6659: iload 5
    //   6661: istore 4
    //   6663: iload_3
    //   6664: istore 5
    //   6666: aload 31
    //   6668: astore 30
    //   6670: aload 33
    //   6672: astore 31
    //   6674: iload 7
    //   6676: istore_3
    //   6677: goto -5586 -> 1091
    //   6680: astore 34
    //   6682: aload 29
    //   6684: astore 31
    //   6686: aload 30
    //   6688: astore 33
    //   6690: iload 6
    //   6692: istore 7
    //   6694: aload 32
    //   6696: astore 29
    //   6698: iconst_1
    //   6699: istore 13
    //   6701: aload 34
    //   6703: astore 32
    //   6705: iload 4
    //   6707: istore 6
    //   6709: iload 5
    //   6711: istore 4
    //   6713: iload_3
    //   6714: istore 5
    //   6716: aload 31
    //   6718: astore 30
    //   6720: aload 33
    //   6722: astore 31
    //   6724: iload 7
    //   6726: istore_3
    //   6727: goto -5636 -> 1091
    //   6730: astore 34
    //   6732: lload 20
    //   6734: lstore 18
    //   6736: aload 29
    //   6738: astore 31
    //   6740: aload 30
    //   6742: astore 33
    //   6744: iload 6
    //   6746: istore 7
    //   6748: aload 32
    //   6750: astore 29
    //   6752: iconst_1
    //   6753: istore 13
    //   6755: aload 34
    //   6757: astore 32
    //   6759: iload 4
    //   6761: istore 6
    //   6763: iload 5
    //   6765: istore 4
    //   6767: iload_3
    //   6768: istore 5
    //   6770: aload 31
    //   6772: astore 30
    //   6774: aload 33
    //   6776: astore 31
    //   6778: iload 7
    //   6780: istore_3
    //   6781: goto -5690 -> 1091
    //   6784: astore 34
    //   6786: aload 29
    //   6788: astore 31
    //   6790: aload 30
    //   6792: astore 33
    //   6794: iconst_0
    //   6795: istore 7
    //   6797: aload 34
    //   6799: astore 29
    //   6801: aload 32
    //   6803: astore 30
    //   6805: iconst_1
    //   6806: istore 13
    //   6808: aload 29
    //   6810: astore 32
    //   6812: iload 4
    //   6814: istore 6
    //   6816: iload 5
    //   6818: istore 4
    //   6820: iload_3
    //   6821: istore 5
    //   6823: aload 30
    //   6825: astore 29
    //   6827: aload 31
    //   6829: astore 30
    //   6831: aload 33
    //   6833: astore 31
    //   6835: iload 7
    //   6837: istore_3
    //   6838: goto -5747 -> 1091
    //   6841: astore 34
    //   6843: aload 29
    //   6845: astore 31
    //   6847: aload 30
    //   6849: astore 33
    //   6851: iload 6
    //   6853: istore 7
    //   6855: iconst_1
    //   6856: istore 5
    //   6858: iconst_1
    //   6859: istore 13
    //   6861: aload 34
    //   6863: astore 29
    //   6865: aload 32
    //   6867: astore 30
    //   6869: aload 29
    //   6871: astore 32
    //   6873: iload 4
    //   6875: istore 6
    //   6877: iload 5
    //   6879: istore 4
    //   6881: iload_3
    //   6882: istore 5
    //   6884: aload 30
    //   6886: astore 29
    //   6888: aload 31
    //   6890: astore 30
    //   6892: aload 33
    //   6894: astore 31
    //   6896: iload 7
    //   6898: istore_3
    //   6899: goto -5808 -> 1091
    //   6902: astore 34
    //   6904: iconst_1
    //   6905: istore 13
    //   6907: aload 32
    //   6909: astore 33
    //   6911: aload 29
    //   6913: astore 30
    //   6915: aload 34
    //   6917: astore 32
    //   6919: iload 4
    //   6921: istore 6
    //   6923: iload 5
    //   6925: istore 4
    //   6927: iload_3
    //   6928: istore 5
    //   6930: aload 31
    //   6932: astore 29
    //   6934: aload 33
    //   6936: astore 31
    //   6938: iload 7
    //   6940: istore_3
    //   6941: goto -5850 -> 1091
    //   6944: goto -726 -> 6218
    //   6947: iload 9
    //   6949: istore 5
    //   6951: goto -5390 -> 1561
    //   6954: goto -2697 -> 4257
    //   6957: iload 7
    //   6959: istore 4
    //   6961: goto -3774 -> 3187
    //   6964: iload 7
    //   6966: istore 4
    //   6968: goto -3781 -> 3187
    //   6971: iload 8
    //   6973: istore 5
    //   6975: goto -4634 -> 2341
    //   6978: aload 31
    //   6980: astore 33
    //   6982: iload_3
    //   6983: istore 8
    //   6985: aload 28
    //   6987: astore 31
    //   6989: aload 30
    //   6991: astore 28
    //   6993: iload 6
    //   6995: istore 7
    //   6997: iload 4
    //   6999: istore_3
    //   7000: aload 29
    //   7002: astore 32
    //   7004: aload 33
    //   7006: astore 29
    //   7008: iload 8
    //   7010: istore 6
    //   7012: iload 5
    //   7014: istore 11
    //   7016: goto -6262 -> 754
    //   7019: iload 5
    //   7021: ireturn
    //   7022: iconst_1
    //   7023: istore 7
    //   7025: goto -5904 -> 1121
    //   7028: astore_1
    //   7029: goto -5252 -> 1777
    //   7032: aload 33
    //   7034: astore 31
    //   7036: iload 8
    //   7038: bipush 12
    //   7040: if_icmple -2705 -> 4335
    //   7043: aload 33
    //   7045: astore 31
    //   7047: bipush 82
    //   7049: aload 43
    //   7051: iconst_0
    //   7052: baload
    //   7053: if_icmpne -2718 -> 4335
    //   7056: aload 33
    //   7058: astore 31
    //   7060: bipush 73
    //   7062: aload 43
    //   7064: iconst_1
    //   7065: baload
    //   7066: if_icmpne -2731 -> 4335
    //   7069: aload 33
    //   7071: astore 31
    //   7073: bipush 70
    //   7075: aload 43
    //   7077: iconst_2
    //   7078: baload
    //   7079: if_icmpne -2744 -> 4335
    //   7082: aload 33
    //   7084: astore 31
    //   7086: bipush 70
    //   7088: aload 43
    //   7090: iconst_3
    //   7091: baload
    //   7092: if_icmpne -2757 -> 4335
    //   7095: aload 33
    //   7097: astore 31
    //   7099: bipush 87
    //   7101: aload 43
    //   7103: bipush 8
    //   7105: baload
    //   7106: if_icmpne -2771 -> 4335
    //   7109: aload 33
    //   7111: astore 31
    //   7113: bipush 69
    //   7115: aload 43
    //   7117: bipush 9
    //   7119: baload
    //   7120: if_icmpne -2785 -> 4335
    //   7123: aload 33
    //   7125: astore 31
    //   7127: bipush 66
    //   7129: aload 43
    //   7131: bipush 10
    //   7133: baload
    //   7134: if_icmpne -2799 -> 4335
    //   7137: aload 33
    //   7139: astore 31
    //   7141: bipush 80
    //   7143: aload 43
    //   7145: bipush 11
    //   7147: baload
    //   7148: if_icmpne -2813 -> 4335
    //   7151: ldc_w 936
    //   7154: astore 31
    //   7156: goto -2821 -> 4335
    //   7159: sipush 302
    //   7162: iload 7
    //   7164: if_icmpeq -1673 -> 5491
    //   7167: sipush 301
    //   7170: iload 7
    //   7172: if_icmpne -1572 -> 5600
    //   7175: goto -1684 -> 5491
    //   7178: iload 12
    //   7180: istore 5
    //   7182: iload 11
    //   7184: iconst_m1
    //   7185: if_icmpne -1643 -> 5542
    //   7188: iconst_0
    //   7189: istore 5
    //   7191: goto -1649 -> 5542
    //   7194: astore 32
    //   7196: iconst_1
    //   7197: istore 13
    //   7199: lload 18
    //   7201: lstore 20
    //   7203: iload 6
    //   7205: istore 5
    //   7207: iload 4
    //   7209: istore 6
    //   7211: iload 5
    //   7213: istore 4
    //   7215: lload 16
    //   7217: lstore 18
    //   7219: lload 20
    //   7221: lstore 16
    //   7223: iload_3
    //   7224: istore 5
    //   7226: iload 7
    //   7228: istore_3
    //   7229: goto -6138 -> 1091
    //   7232: astore_1
    //   7233: aload 31
    //   7235: astore 32
    //   7237: iload 7
    //   7239: istore 6
    //   7241: aload 29
    //   7243: astore 31
    //   7245: aload 30
    //   7247: astore 29
    //   7249: goto -5472 -> 1777
    //   7252: astore_1
    //   7253: aload 31
    //   7255: astore 32
    //   7257: aload 29
    //   7259: astore 31
    //   7261: aload 30
    //   7263: astore 29
    //   7265: iload_3
    //   7266: istore 6
    //   7268: goto -5491 -> 1777
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7271	0	parambhyo	bhyo
    //   0	7271	1	paramString	String
    //   0	7271	2	paramContext	Context
    //   65	7201	3	i	int
    //   16	7198	4	j	int
    //   118	7107	5	k	int
    //   730	6537	6	m	int
    //   740	6498	7	n	int
    //   415	6626	8	i1	int
    //   386	6562	9	i2	int
    //   409	4053	10	i3	int
    //   727	6459	11	i4	int
    //   838	6341	12	i5	int
    //   389	6809	13	bool1	boolean
    //   406	4611	14	bool2	boolean
    //   1499	4620	15	bool3	boolean
    //   474	6748	16	l1	long
    //   737	6481	18	l2	long
    //   2764	4456	20	l3	long
    //   3711	1008	22	l4	long
    //   455	1080	24	l5	long
    //   761	4304	26	l6	long
    //   219	6029	28	localObject1	Object
    //   6335	22	28	localThrowable1	Throwable
    //   6362	630	28	localObject2	Object
    //   421	6843	29	localObject3	Object
    //   418	5960	30	localObject4	Object
    //   6385	25	30	localThrowable2	Throwable
    //   6426	836	30	localObject5	Object
    //   674	6586	31	localObject6	Object
    //   507	3282	32	localObject7	Object
    //   3985	1	32	localThrowable3	Throwable
    //   4137	1608	32	localObject8	Object
    //   5751	1	32	localInterruptedException	java.lang.InterruptedException
    //   5783	10	32	localObject9	Object
    //   5919	543	32	localObject10	Object
    //   6488	1	32	localThrowable4	Throwable
    //   6534	65	32	localThrowable5	Throwable
    //   6607	396	32	localObject11	Object
    //   7194	1	32	localThrowable6	Throwable
    //   7235	21	32	localObject12	Object
    //   599	6539	33	localObject13	Object
    //   842	123	34	localObject14	Object
    //   1052	36	34	localThrowable7	Throwable
    //   1439	949	34	localObject15	Object
    //   2450	26	34	localThrowable8	Throwable
    //   2502	847	34	localObject16	Object
    //   3584	180	34	localThrowable9	Throwable
    //   3993	925	34	localObject17	Object
    //   5298	21	34	localThrowable10	Throwable
    //   5394	852	34	localThrowable11	Throwable
    //   6354	71	34	localObject18	Object
    //   6438	22	34	localThrowable12	Throwable
    //   6499	76	34	localObject19	Object
    //   6584	22	34	localThrowable13	Throwable
    //   6634	18	34	localThrowable14	Throwable
    //   6680	22	34	localThrowable15	Throwable
    //   6730	26	34	localThrowable16	Throwable
    //   6784	14	34	localThrowable17	Throwable
    //   6841	21	34	localThrowable18	Throwable
    //   6902	14	34	localThrowable19	Throwable
    //   670	5002	35	localFile1	File
    //   595	4491	36	localFile2	File
    //   720	4420	37	localasid	asid
    //   166	3058	38	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   487	4452	39	localHashMap	HashMap
    //   471	5315	40	localObject20	Object
    //   615	996	41	localFile3	File
    //   829	4454	42	localStringBuilder	java.lang.StringBuilder
    //   1703	5441	43	localObject21	Object
    //   2397	34	44	str1	String
    //   2411	31	45	str2	String
    // Exception table:
    //   from	to	target	type
    //   73	77	320	java/lang/Throwable
    //   80	84	320	java/lang/Throwable
    //   90	97	320	java/lang/Throwable
    //   100	106	320	java/lang/Throwable
    //   109	113	320	java/lang/Throwable
    //   120	126	320	java/lang/Throwable
    //   129	154	320	java/lang/Throwable
    //   159	168	320	java/lang/Throwable
    //   171	187	320	java/lang/Throwable
    //   190	207	320	java/lang/Throwable
    //   210	217	320	java/lang/Throwable
    //   224	236	320	java/lang/Throwable
    //   239	246	320	java/lang/Throwable
    //   249	261	320	java/lang/Throwable
    //   264	270	320	java/lang/Throwable
    //   273	277	320	java/lang/Throwable
    //   284	290	320	java/lang/Throwable
    //   293	318	320	java/lang/Throwable
    //   377	388	320	java/lang/Throwable
    //   394	399	320	java/lang/Throwable
    //   6221	6227	320	java/lang/Throwable
    //   988	1029	1052	java/lang/Throwable
    //   1041	1052	1052	java/lang/Throwable
    //   1744	1753	1052	java/lang/Throwable
    //   1765	1776	1052	java/lang/Throwable
    //   988	1029	1776	finally
    //   1041	1052	1776	finally
    //   1744	1753	1776	finally
    //   1765	1776	1776	finally
    //   758	763	2003	java/lang/Throwable
    //   767	831	2003	java/lang/Throwable
    //   1781	1784	2003	java/lang/Throwable
    //   1788	1827	2003	java/lang/Throwable
    //   1831	1839	2003	java/lang/Throwable
    //   1848	1900	2003	java/lang/Throwable
    //   1904	1915	2003	java/lang/Throwable
    //   1919	1927	2003	java/lang/Throwable
    //   1931	1939	2003	java/lang/Throwable
    //   1947	1953	2003	java/lang/Throwable
    //   1957	1965	2003	java/lang/Throwable
    //   1973	1982	2003	java/lang/Throwable
    //   1986	1997	2003	java/lang/Throwable
    //   2001	2003	2003	java/lang/Throwable
    //   2341	2358	2450	java/lang/Throwable
    //   2363	2377	2450	java/lang/Throwable
    //   2377	2447	2450	java/lang/Throwable
    //   2543	2588	2450	java/lang/Throwable
    //   2588	2746	2450	java/lang/Throwable
    //   2751	2828	2450	java/lang/Throwable
    //   2828	2842	2450	java/lang/Throwable
    //   2847	2870	2450	java/lang/Throwable
    //   2877	2951	2450	java/lang/Throwable
    //   2951	3059	2450	java/lang/Throwable
    //   3059	3092	2450	java/lang/Throwable
    //   3092	3117	2450	java/lang/Throwable
    //   3127	3149	2450	java/lang/Throwable
    //   3630	3645	2450	java/lang/Throwable
    //   3648	3655	2450	java/lang/Throwable
    //   3271	3285	3584	java/lang/Throwable
    //   3289	3295	3584	java/lang/Throwable
    //   3299	3306	3584	java/lang/Throwable
    //   3310	3344	3584	java/lang/Throwable
    //   3348	3357	3584	java/lang/Throwable
    //   3361	3371	3584	java/lang/Throwable
    //   3375	3384	3584	java/lang/Throwable
    //   3388	3397	3584	java/lang/Throwable
    //   3401	3412	3584	java/lang/Throwable
    //   3416	3427	3584	java/lang/Throwable
    //   3431	3442	3584	java/lang/Throwable
    //   3446	3457	3584	java/lang/Throwable
    //   3461	3472	3584	java/lang/Throwable
    //   3476	3487	3584	java/lang/Throwable
    //   3491	3502	3584	java/lang/Throwable
    //   3506	3517	3584	java/lang/Throwable
    //   3521	3532	3584	java/lang/Throwable
    //   3536	3547	3584	java/lang/Throwable
    //   3551	3581	3584	java/lang/Throwable
    //   3695	3704	3584	java/lang/Throwable
    //   5458	5464	3584	java/lang/Throwable
    //   5495	5502	3584	java/lang/Throwable
    //   5512	5519	3584	java/lang/Throwable
    //   5546	5552	3584	java/lang/Throwable
    //   5612	5617	3584	java/lang/Throwable
    //   5659	5667	3584	java/lang/Throwable
    //   5671	5677	3584	java/lang/Throwable
    //   5681	5687	3584	java/lang/Throwable
    //   5718	5724	3584	java/lang/Throwable
    //   3946	3962	3985	java/lang/Throwable
    //   3974	3985	3985	java/lang/Throwable
    //   4119	4130	3985	java/lang/Throwable
    //   3946	3962	4130	finally
    //   3974	3985	4130	finally
    //   4119	4130	4130	finally
    //   5282	5291	5298	java/lang/Throwable
    //   5373	5379	5394	java/lang/Throwable
    //   5383	5394	5394	java/lang/Throwable
    //   4889	4896	5751	java/lang/InterruptedException
    //   4889	4896	5783	finally
    //   4896	4899	5783	finally
    //   5753	5780	5783	finally
    //   5785	5788	5783	finally
    //   431	445	6233	java/lang/Throwable
    //   452	457	6233	java/lang/Throwable
    //   464	473	6233	java/lang/Throwable
    //   480	489	6233	java/lang/Throwable
    //   493	509	6233	java/lang/Throwable
    //   513	519	6233	java/lang/Throwable
    //   523	531	6233	java/lang/Throwable
    //   540	550	6233	java/lang/Throwable
    //   554	566	6233	java/lang/Throwable
    //   570	577	6233	java/lang/Throwable
    //   581	597	6233	java/lang/Throwable
    //   610	617	6233	java/lang/Throwable
    //   621	628	6233	java/lang/Throwable
    //   632	672	6233	java/lang/Throwable
    //   680	690	6233	java/lang/Throwable
    //   694	705	6233	java/lang/Throwable
    //   709	722	6233	java/lang/Throwable
    //   1215	1218	6233	java/lang/Throwable
    //   1221	1260	6233	java/lang/Throwable
    //   1263	1271	6233	java/lang/Throwable
    //   1279	1331	6233	java/lang/Throwable
    //   1334	1344	6233	java/lang/Throwable
    //   1347	1356	6233	java/lang/Throwable
    //   1359	1367	6233	java/lang/Throwable
    //   1375	1384	6233	java/lang/Throwable
    //   1387	1395	6233	java/lang/Throwable
    //   1403	1415	6233	java/lang/Throwable
    //   1418	1429	6233	java/lang/Throwable
    //   1483	1492	6233	java/lang/Throwable
    //   1495	1501	6233	java/lang/Throwable
    //   1606	1641	6233	java/lang/Throwable
    //   4958	4961	6233	java/lang/Throwable
    //   4965	5004	6233	java/lang/Throwable
    //   5008	5016	6233	java/lang/Throwable
    //   5025	5077	6233	java/lang/Throwable
    //   5081	5092	6233	java/lang/Throwable
    //   5096	5105	6233	java/lang/Throwable
    //   5109	5117	6233	java/lang/Throwable
    //   5126	5135	6233	java/lang/Throwable
    //   5139	5147	6233	java/lang/Throwable
    //   5156	5168	6233	java/lang/Throwable
    //   5172	5183	6233	java/lang/Throwable
    //   6049	6055	6233	java/lang/Throwable
    //   6059	6065	6233	java/lang/Throwable
    //   6069	6078	6233	java/lang/Throwable
    //   6133	6146	6233	java/lang/Throwable
    //   6150	6156	6233	java/lang/Throwable
    //   6160	6205	6233	java/lang/Throwable
    //   6209	6215	6233	java/lang/Throwable
    //   1522	1551	6240	java/lang/Throwable
    //   6109	6115	6240	java/lang/Throwable
    //   852	857	6244	finally
    //   877	885	6244	finally
    //   897	904	6244	finally
    //   926	932	6244	finally
    //   944	952	6244	finally
    //   970	976	6244	finally
    //   1656	1662	6244	finally
    //   1674	1688	6244	finally
    //   1700	1705	6244	finally
    //   1726	1732	6244	finally
    //   2026	2033	6244	finally
    //   2049	2060	6244	finally
    //   2072	2092	6244	finally
    //   2104	2112	6244	finally
    //   2124	2152	6244	finally
    //   2164	2171	6244	finally
    //   2183	2189	6244	finally
    //   2201	2228	6244	finally
    //   2240	2250	6244	finally
    //   2267	2274	6244	finally
    //   2286	2297	6244	finally
    //   2309	2314	6244	finally
    //   2328	2341	6244	finally
    //   2512	2540	6244	finally
    //   3704	3713	6252	finally
    //   3721	3735	6252	finally
    //   3743	3755	6252	finally
    //   3763	3775	6252	finally
    //   3788	3809	6252	finally
    //   3817	3824	6252	finally
    //   3832	3857	6252	finally
    //   3865	3872	6252	finally
    //   3887	3896	6252	finally
    //   3904	3914	6252	finally
    //   3928	3934	6252	finally
    //   4048	4061	6252	finally
    //   4087	4093	6252	finally
    //   4105	4111	6252	finally
    //   4160	4180	6252	finally
    //   4180	4232	6260	finally
    //   4486	4495	6260	finally
    //   4232	4241	6272	finally
    //   4245	4254	6288	finally
    //   4261	4268	6288	finally
    //   4272	4281	6288	finally
    //   4291	4297	6288	finally
    //   4344	4358	6288	finally
    //   4362	4372	6288	finally
    //   4406	4415	6288	finally
    //   4419	4429	6288	finally
    //   4433	4444	6288	finally
    //   4456	4466	6288	finally
    //   4470	4474	6288	finally
    //   4595	4600	6288	finally
    //   4604	4612	6288	finally
    //   4616	4623	6288	finally
    //   4627	4641	6288	finally
    //   4660	4667	6288	finally
    //   4678	4691	6288	finally
    //   4695	4718	6288	finally
    //   4730	4735	6288	finally
    //   5254	5260	6288	finally
    //   5272	5278	6288	finally
    //   5363	5369	6288	finally
    //   4735	4749	6300	finally
    //   4749	4780	6300	finally
    //   5282	5291	6315	finally
    //   5373	5379	6315	finally
    //   5383	5394	6315	finally
    //   5552	5569	6327	finally
    //   852	857	6335	java/lang/Throwable
    //   877	885	6335	java/lang/Throwable
    //   897	904	6335	java/lang/Throwable
    //   926	932	6335	java/lang/Throwable
    //   944	952	6335	java/lang/Throwable
    //   970	976	6335	java/lang/Throwable
    //   1656	1662	6335	java/lang/Throwable
    //   1674	1688	6335	java/lang/Throwable
    //   1700	1705	6335	java/lang/Throwable
    //   1726	1732	6335	java/lang/Throwable
    //   2026	2033	6335	java/lang/Throwable
    //   2049	2060	6335	java/lang/Throwable
    //   2072	2092	6335	java/lang/Throwable
    //   2104	2112	6335	java/lang/Throwable
    //   2124	2152	6335	java/lang/Throwable
    //   2164	2171	6335	java/lang/Throwable
    //   2183	2189	6335	java/lang/Throwable
    //   2201	2228	6335	java/lang/Throwable
    //   2240	2250	6335	java/lang/Throwable
    //   2267	2274	6335	java/lang/Throwable
    //   2286	2297	6335	java/lang/Throwable
    //   2309	2314	6335	java/lang/Throwable
    //   2328	2341	6335	java/lang/Throwable
    //   2512	2540	6335	java/lang/Throwable
    //   3152	3187	6385	java/lang/Throwable
    //   3187	3209	6438	java/lang/Throwable
    //   3209	3235	6438	java/lang/Throwable
    //   3239	3264	6438	java/lang/Throwable
    //   3704	3713	6488	java/lang/Throwable
    //   3721	3735	6534	java/lang/Throwable
    //   3743	3755	6534	java/lang/Throwable
    //   3763	3775	6534	java/lang/Throwable
    //   3788	3809	6534	java/lang/Throwable
    //   3817	3824	6534	java/lang/Throwable
    //   3832	3857	6534	java/lang/Throwable
    //   3865	3872	6534	java/lang/Throwable
    //   3887	3896	6534	java/lang/Throwable
    //   3904	3914	6534	java/lang/Throwable
    //   3928	3934	6534	java/lang/Throwable
    //   4048	4061	6534	java/lang/Throwable
    //   4087	4093	6534	java/lang/Throwable
    //   4105	4111	6534	java/lang/Throwable
    //   4160	4180	6534	java/lang/Throwable
    //   4180	4232	6584	java/lang/Throwable
    //   4486	4495	6584	java/lang/Throwable
    //   4232	4241	6634	java/lang/Throwable
    //   4245	4254	6680	java/lang/Throwable
    //   4261	4268	6730	java/lang/Throwable
    //   4272	4281	6730	java/lang/Throwable
    //   4291	4297	6730	java/lang/Throwable
    //   4344	4358	6730	java/lang/Throwable
    //   4362	4372	6730	java/lang/Throwable
    //   4406	4415	6730	java/lang/Throwable
    //   4419	4429	6730	java/lang/Throwable
    //   4433	4444	6730	java/lang/Throwable
    //   4456	4466	6730	java/lang/Throwable
    //   4470	4474	6730	java/lang/Throwable
    //   4595	4600	6730	java/lang/Throwable
    //   4604	4612	6730	java/lang/Throwable
    //   4616	4623	6730	java/lang/Throwable
    //   4627	4641	6730	java/lang/Throwable
    //   4660	4667	6730	java/lang/Throwable
    //   4678	4691	6730	java/lang/Throwable
    //   4695	4718	6730	java/lang/Throwable
    //   4730	4735	6730	java/lang/Throwable
    //   5254	5260	6730	java/lang/Throwable
    //   5363	5369	6730	java/lang/Throwable
    //   4735	4749	6784	java/lang/Throwable
    //   4749	4780	6784	java/lang/Throwable
    //   5272	5278	6841	java/lang/Throwable
    //   5552	5569	6902	java/lang/Throwable
    //   2341	2358	7028	finally
    //   2363	2377	7028	finally
    //   2377	2447	7028	finally
    //   2543	2588	7028	finally
    //   2588	2746	7028	finally
    //   2751	2828	7028	finally
    //   2828	2842	7028	finally
    //   2847	2870	7028	finally
    //   2877	2951	7028	finally
    //   2951	3059	7028	finally
    //   3059	3092	7028	finally
    //   3092	3117	7028	finally
    //   3127	3149	7028	finally
    //   3152	3187	7028	finally
    //   3187	3209	7028	finally
    //   3209	3235	7028	finally
    //   3239	3264	7028	finally
    //   3271	3285	7028	finally
    //   3289	3295	7028	finally
    //   3299	3306	7028	finally
    //   3310	3344	7028	finally
    //   3348	3357	7028	finally
    //   3361	3371	7028	finally
    //   3375	3384	7028	finally
    //   3388	3397	7028	finally
    //   3401	3412	7028	finally
    //   3416	3427	7028	finally
    //   3431	3442	7028	finally
    //   3446	3457	7028	finally
    //   3461	3472	7028	finally
    //   3476	3487	7028	finally
    //   3491	3502	7028	finally
    //   3506	3517	7028	finally
    //   3521	3532	7028	finally
    //   3536	3547	7028	finally
    //   3551	3581	7028	finally
    //   3630	3645	7028	finally
    //   3648	3655	7028	finally
    //   3695	3704	7028	finally
    //   5458	5464	7028	finally
    //   5495	5502	7028	finally
    //   5512	5519	7028	finally
    //   5546	5552	7028	finally
    //   5612	5617	7028	finally
    //   5659	5667	7028	finally
    //   5671	5677	7028	finally
    //   5681	5687	7028	finally
    //   5718	5724	7028	finally
    //   4827	4833	7194	java/lang/Throwable
    //   4837	4847	7194	java/lang/Throwable
    //   4856	4863	7194	java/lang/Throwable
    //   4867	4876	7194	java/lang/Throwable
    //   4880	4883	7194	java/lang/Throwable
    //   4903	4913	7194	java/lang/Throwable
    //   4917	4929	7194	java/lang/Throwable
    //   4938	4954	7194	java/lang/Throwable
    //   5792	5795	7194	java/lang/Throwable
    //   5799	5809	7194	java/lang/Throwable
    //   5813	5820	7194	java/lang/Throwable
    //   5824	5840	7194	java/lang/Throwable
    //   5843	5898	7194	java/lang/Throwable
    //   5902	5913	7194	java/lang/Throwable
    //   4827	4833	7232	finally
    //   4837	4847	7232	finally
    //   4856	4863	7232	finally
    //   4867	4876	7232	finally
    //   4880	4883	7232	finally
    //   4903	4913	7232	finally
    //   4917	4929	7232	finally
    //   4938	4954	7232	finally
    //   5792	5795	7232	finally
    //   5799	5809	7232	finally
    //   5813	5820	7232	finally
    //   5824	5840	7232	finally
    //   5843	5898	7232	finally
    //   5902	5913	7232	finally
    //   1094	1110	7252	finally
    //   1110	1118	7252	finally
    //   1121	1135	7252	finally
    //   1135	1144	7252	finally
    //   1159	1164	7252	finally
    //   1164	1212	7252	finally
    //   5932	5946	7252	finally
    //   5949	5965	7252	finally
    //   5965	5971	7252	finally
    //   5974	5988	7252	finally
    //   5991	6004	7252	finally
    //   6007	6012	7252	finally
  }
  
  public static int a(bhyo parambhyo, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((parambhyo.k) && (!bkwb.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(parambhyo, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(parambhyo, null, null);
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
  
  public static void a(asid paramasid)
  {
    if ((paramasid == null) || (TextUtils.isEmpty(paramasid.jdField_a_of_type_JavaLangString))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = InnerDns.getHostFromUrl(paramasid.jdField_a_of_type_JavaLangString);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramasid.jdField_a_of_type_JavaLangString.startsWith("http"))) {
          break;
        }
        str2 = InnerDns.getInstance().reqDns(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramasid.jdField_a_of_type_JavaLangString, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramasid.jdField_b_of_type_JavaLangString = str3;
        paramasid.jdField_c_of_type_JavaLangString = str1;
        paramasid.jdField_d_of_type_JavaLangString = str2;
        paramasid.jdField_a_of_type_Boolean = true;
        return;
      }
      paramasid.jdField_b_of_type_JavaLangString = paramasid.jdField_a_of_type_JavaLangString;
      return;
      HttpDownloadUtil.replaceDomainWithIP(paramasid);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramasid.jdField_a_of_type_JavaLangString);
  }
  
  private static void a(bhyo parambhyo, int paramInt)
  {
    if ((parambhyo.b()) && (!parambhyo.jdField_i_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "no need to call onDone");
      }
      return;
    }
    if (parambhyo.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "canceled");
      }
      parambhyo.a(2);
      parambhyo.c();
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "onDoned");
      }
      parambhyo.e();
      return;
    }
    if (paramInt == 0) {}
    for (paramInt = 3;; paramInt = -1)
    {
      parambhyo.a(paramInt);
      break;
    }
  }
  
  private static void a(bhyo parambhyo, Context paramContext, int paramInt, File paramFile, asid paramasid)
  {
    if ((paramInt != 0) && (!parambhyo.b()) && (parambhyo.jdField_e_of_type_Boolean))
    {
      if (!paramasid.jdField_a_of_type_Boolean) {
        break label120;
      }
      if (TextUtils.isEmpty(paramasid.jdField_d_of_type_JavaLangString)) {
        break label92;
      }
      InnerDns.getInstance().reportBadIp(paramasid.jdField_c_of_type_JavaLangString, paramasid.jdField_d_of_type_JavaLangString, ((Integer)jdField_a_of_type_JavaUtilMap.get(paramasid.jdField_c_of_type_JavaLangString)).intValue());
    }
    for (;;)
    {
      a(paramasid.jdField_b_of_type_JavaLangString, paramFile.getName(), -1, paramContext);
      parambhyo.jdField_d_of_type_Boolean = false;
      return;
      label92:
      FMTSrvAddrProvider localFMTSrvAddrProvider = FMTSrvAddrProvider.getInstance();
      if (localFMTSrvAddrProvider != null) {
        localFMTSrvAddrProvider.onFailed(paramasid.jdField_d_of_type_Int, paramasid.jdField_b_of_type_JavaLangString);
      }
    }
    label120:
    parambhyo.jdField_d_of_type_Boolean = true;
  }
  
  private static void a(bhyo parambhyo, File paramFile, HttpResponse paramHttpResponse)
  {
    if ((parambhyo.j) && (paramHttpResponse.containsHeader("last-modified")))
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("last-modified").getValue();
      if (TextUtils.isEmpty(paramHttpResponse)) {}
    }
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      long l = localSimpleDateFormat.parse(paramHttpResponse).getTime();
      paramFile.setLastModified(l);
      parambhyo.jdField_i_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "doTask |set lastModifyTime=" + l + ",fileName=" + paramFile.getName() + ",lastModify=" + paramFile.lastModified());
      }
      return;
    }
    catch (Exception parambhyo)
    {
      QLog.e("DownloaderFactory", 1, "doTask | set lastModify=" + paramHttpResponse + ",exception msg=" + parambhyo.getMessage());
    }
  }
  
  private static void a(bhyo parambhyo, String paramString1, Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt2, long paramLong2, long paramLong3, HashMap<String, String> paramHashMap, String paramString2, String paramString3)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("param_Url", paramString2);
    ((HashMap)localObject).put("param_FailCode", String.valueOf(parambhyo.jdField_a_of_type_Int));
    ((HashMap)localObject).put("param_HttpCode", String.valueOf(parambhyo.jdField_f_of_type_Int));
    ((HashMap)localObject).put("param_TryCount", String.valueOf(paramInt2));
    ((HashMap)localObject).put("param_ContentLen", String.valueOf(paramLong2));
    ((HashMap)localObject).put("param_TaskDownSize", String.valueOf(parambhyo.jdField_a_of_type_JavaUtilList.size()));
    ((HashMap)localObject).put("param_BusinessCode", parambhyo.jdField_f_of_type_JavaLangString);
    ((HashMap)localObject).put("param_Executed", Boolean.toString(paramBoolean1));
    ((HashMap)localObject).put("param_UrlType", paramString3);
    paramHashMap = "";
    if (!TextUtils.isEmpty(parambhyo.jdField_b_of_type_JavaLangString))
    {
      ((HashMap)localObject).put("param_ErrMsg", parambhyo.jdField_b_of_type_JavaLangString);
      paramHashMap = parambhyo.jdField_b_of_type_JavaLangString;
    }
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      long l = System.currentTimeMillis();
      if ((paramContext != null) && (!TextUtils.isEmpty(paramString1))) {}
      try
      {
        bhpl.a("downloadfactoryType", paramString2, parambhyo.jdField_a_of_type_Int + "", paramLong2 + "", parambhyo.jdField_f_of_type_JavaLangString, paramBoolean1 + "", paramHashMap, paramString3, "", "8.4.10");
        if ((parambhyo.jdField_g_of_type_Int == 3) && (paramBoolean2))
        {
          anis.a(30, parambhyo.jdField_c_of_type_JavaLangString, 300, ApolloUtil.f(parambhyo.jdField_a_of_type_Int), new Object[] { "task done, errCode:", Integer.valueOf(parambhyo.jdField_a_of_type_Int), ",httpCode:", Integer.valueOf(parambhyo.jdField_f_of_type_Int) });
          if (parambhyo.jdField_a_of_type_Int == 0) {
            anis.b(30, parambhyo.jdField_c_of_type_JavaLangString);
          }
        }
        paramString2 = "VipDownload700";
        paramHashMap = paramString2;
        if (!TextUtils.isEmpty(parambhyo.jdField_f_of_type_JavaLangString))
        {
          paramHashMap = paramString2;
          if (parambhyo.jdField_f_of_type_JavaLangString.contains("apollo"))
          {
            paramHashMap = "CMShowDownload";
            ((HashMap)localObject).put("param_https", String.valueOf(parambhyo.r));
            ((HashMap)localObject).put("param_AddRandom", String.valueOf(parambhyo.q));
          }
        }
        StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, paramHashMap, bool, l - paramLong1, paramLong3, (HashMap)localObject, "", false);
        return;
      }
      catch (Throwable parambhyo) {}
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.getSystemNetwork(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      bdla.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
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
      int i = NetworkUtil.getSystemNetwork(paramContext);
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
  
  public static boolean a(bhyo parambhyo)
  {
    if (parambhyo == null) {
      return false;
    }
    if ((parambhyo.jdField_a_of_type_JavaUtilList == null) || (parambhyo.jdField_a_of_type_JavaUtilMap == null) || (parambhyo.jdField_a_of_type_JavaUtilList.size() < 1) || (parambhyo.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(parambhyo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    parambhyo = parambhyo.jdField_a_of_type_JavaUtilList.iterator();
    while (parambhyo.hasNext())
    {
      String str = (String)parambhyo.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean)
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
    //   18: invokevirtual 302	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 302	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1170	java/io/File:listFiles	()[Ljava/io/File;
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
    //   73: invokevirtual 305	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1170	java/io/File:listFiles	()[Ljava/io/File;
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
    //   111: invokevirtual 308	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 308	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 308	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 73
    //   148: iconst_2
    //   149: new 122	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1172
    //   159: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 1044	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1178	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1181	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 544	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1186	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1187
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1187
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1190	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1195	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1197
    //   251: invokespecial 1200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1203	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 1146	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1204	java/io/InputStreamReader:close	()V
    //   282: ldc 73
    //   284: iconst_2
    //   285: new 122	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1172
    //   295: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1206
    //   308: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1208
    //   319: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1210
    //   330: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1213	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 73
    //   361: iconst_2
    //   362: new 122	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1215
    //   372: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1217
    //   387: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 311	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 122	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1221	java/io/File:separatorChar	C
    //   438: invokevirtual 1224	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1228	nwp:a	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 308	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 73
    //   464: iconst_2
    //   465: new 122	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1230
    //   475: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   516: invokevirtual 1146	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1204	java/io/InputStreamReader:close	()V
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
    //   546: invokevirtual 1146	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1204	java/io/InputStreamReader:close	()V
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
    //   0	630	0	paramFile1	File
    //   0	630	1	paramFile2	File
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
    //   54	80	15	arrayOfFile	File[]
    //   144	26	15	localException1	Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	File
    //   608	1	16	localException4	Exception
    //   611	6	16	localFile2	File
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
  public bhyt a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +324 -> 329
    //   8: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+29 -> 44, 1:+33->48, 2:+107->122, 3:+176->191, 4:+245->260
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: iload_1
    //   52: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokevirtual 1231	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   58: ifeq +20 -> 78
    //   61: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   64: iload_1
    //   65: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 1232	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 1238	bhyt
    //   74: astore_2
    //   75: goto -31 -> 44
    //   78: new 1240	bhys
    //   81: dup
    //   82: iconst_0
    //   83: invokespecial 1243	bhys:<init>	(Z)V
    //   86: astore_2
    //   87: new 1245	bhzg
    //   90: dup
    //   91: invokestatic 1248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   94: invokevirtual 1252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   97: aload_2
    //   98: invokespecial 1255	bhzg:<init>	(Lmqq/app/AppRuntime;Lbhys;)V
    //   101: astore_2
    //   102: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   105: iload_1
    //   106: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aload_2
    //   110: invokevirtual 907	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: goto -70 -> 44
    //   117: astore_2
    //   118: aload_3
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   125: iload_1
    //   126: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokevirtual 1231	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   132: ifeq +20 -> 152
    //   135: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: iload_1
    //   139: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 1232	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 1238	bhyt
    //   148: astore_2
    //   149: goto -105 -> 44
    //   152: new 1240	bhys
    //   155: dup
    //   156: iconst_0
    //   157: invokespecial 1243	bhys:<init>	(Z)V
    //   160: astore_2
    //   161: new 1245	bhzg
    //   164: dup
    //   165: invokestatic 1248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: invokevirtual 1252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   171: aload_2
    //   172: invokespecial 1255	bhzg:<init>	(Lmqq/app/AppRuntime;Lbhys;)V
    //   175: astore_2
    //   176: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   179: iload_1
    //   180: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aload_2
    //   184: invokevirtual 907	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: goto -144 -> 44
    //   191: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: iload_1
    //   195: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 1231	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   201: ifeq +20 -> 221
    //   204: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   207: iload_1
    //   208: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 1232	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 1238	bhyt
    //   217: astore_2
    //   218: goto -174 -> 44
    //   221: new 1240	bhys
    //   224: dup
    //   225: iconst_0
    //   226: invokespecial 1243	bhys:<init>	(Z)V
    //   229: astore_2
    //   230: new 1257	amnh
    //   233: dup
    //   234: invokestatic 1248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   237: invokevirtual 1252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   240: aload_2
    //   241: invokespecial 1258	amnh:<init>	(Lmqq/app/AppRuntime;Lbhys;)V
    //   244: astore_2
    //   245: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   248: iload_1
    //   249: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aload_2
    //   253: invokevirtual 907	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: goto -213 -> 44
    //   260: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   263: iload_1
    //   264: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 1231	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   270: ifeq +20 -> 290
    //   273: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   276: iload_1
    //   277: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: invokevirtual 1232	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: checkcast 1238	bhyt
    //   286: astore_2
    //   287: goto -243 -> 44
    //   290: new 1240	bhys
    //   293: dup
    //   294: iconst_0
    //   295: invokespecial 1243	bhys:<init>	(Z)V
    //   298: astore_2
    //   299: new 1257	amnh
    //   302: dup
    //   303: invokestatic 1248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: invokevirtual 1252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   309: aload_2
    //   310: invokespecial 1258	amnh:<init>	(Lmqq/app/AppRuntime;Lbhys;)V
    //   313: astore_2
    //   314: getstatic 44	bhyq:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   317: iload_1
    //   318: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aload_2
    //   322: invokevirtual 907	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: goto -282 -> 44
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	bhyq
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
          ((bhyt)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyq
 * JD-Core Version:    0.7.0.1
 */