import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.FDNative;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class axqa
  implements Handler.Callback, axru
{
  private static long jdField_a_of_type_Long = 1800000L;
  private static volatile axqa jdField_a_of_type_Axqa;
  static String jdField_a_of_type_JavaLangString;
  private static ThreadLocal<SimpleDateFormat> jdField_a_of_type_JavaLangThreadLocal = new axqb();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4113, 4113, 4097, 4097 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static String e;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private axqc jdField_a_of_type_Axqc = new axqc();
  private axtl jdField_a_of_type_Axtl = new axtl();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "/proc/" + Process.myPid() + "/fd";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "ls -l " + this.jdField_b_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  
  static long a(File paramFile, boolean paramBoolean)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.lastIndexOf("/") + 1);
      if ((paramFile.endsWith(".txt")) || ((paramBoolean) && (paramFile.endsWith(".zip")))) {
        return Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
      }
      if (paramFile.endsWith(".socket"))
      {
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 7)).longValue();
        return l;
      }
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  public static axqa a()
  {
    if (jdField_a_of_type_Axqa == null) {}
    try
    {
      if (jdField_a_of_type_Axqa == null)
      {
        jdField_a_of_type_Axqa = new axqa();
        if (axrn.jdField_a_of_type_Axru == null) {
          axrn.jdField_a_of_type_Axru = jdField_a_of_type_Axqa;
        }
      }
      return jdField_a_of_type_Axqa;
    }
    finally {}
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 185	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 11
    //   5: new 66	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 187
    //   11: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 16
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 192	axqa:jdField_b_of_type_Int	I
    //   21: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   24: lstore 7
    //   26: new 199	axqd
    //   29: dup
    //   30: invokespecial 200	axqd:<init>	()V
    //   33: astore 17
    //   35: aload 11
    //   37: aload_1
    //   38: invokevirtual 204	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 210	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore_1
    //   45: new 212	java/io/BufferedReader
    //   48: dup
    //   49: new 214	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 217	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 220	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore 12
    //   62: aload 12
    //   64: astore 14
    //   66: aload_1
    //   67: astore 13
    //   69: aload 12
    //   71: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore 15
    //   76: aload 15
    //   78: ifnull +286 -> 364
    //   81: aload 12
    //   83: astore 14
    //   85: aload_1
    //   86: astore 13
    //   88: aload 15
    //   90: ldc 225
    //   92: invokevirtual 228	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   95: istore 4
    //   97: aload 15
    //   99: astore 11
    //   101: iload 4
    //   103: ifle +26 -> 129
    //   106: aload 12
    //   108: astore 14
    //   110: aload_1
    //   111: astore 13
    //   113: aload 15
    //   115: iload 4
    //   117: iconst_2
    //   118: iadd
    //   119: aload 15
    //   121: invokevirtual 146	java/lang/String:length	()I
    //   124: invokevirtual 149	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: astore 11
    //   129: aload 12
    //   131: astore 14
    //   133: aload_1
    //   134: astore 13
    //   136: aload 17
    //   138: aload 11
    //   140: invokevirtual 230	axqd:a	(Ljava/lang/String;)V
    //   143: aload 12
    //   145: astore 14
    //   147: aload_1
    //   148: astore 13
    //   150: aload 16
    //   152: new 66	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   159: aload 11
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 232
    //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 12
    //   178: astore 14
    //   180: aload_1
    //   181: astore 13
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 192	axqa:jdField_b_of_type_Int	I
    //   188: iconst_1
    //   189: iadd
    //   190: putfield 192	axqa:jdField_b_of_type_Int	I
    //   193: iload_3
    //   194: ifeq -132 -> 62
    //   197: aload 12
    //   199: astore 14
    //   201: aload_1
    //   202: astore 13
    //   204: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -145 -> 62
    //   210: aload 12
    //   212: astore 14
    //   214: aload_1
    //   215: astore 13
    //   217: ldc 240
    //   219: iconst_2
    //   220: new 66	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   227: aload 11
    //   229: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 232
    //   234: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -181 -> 62
    //   246: astore 13
    //   248: aload_1
    //   249: astore 11
    //   251: aload 12
    //   253: astore_1
    //   254: aload 13
    //   256: astore 12
    //   258: ldc 240
    //   260: iconst_2
    //   261: new 66	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   268: ldc 245
    //   270: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 12
    //   275: invokevirtual 246	java/io/IOException:toString	()Ljava/lang/String;
    //   278: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 192	axqa:jdField_b_of_type_Int	I
    //   292: aload_1
    //   293: ifnull +7 -> 300
    //   296: aload_1
    //   297: invokevirtual 251	java/io/BufferedReader:close	()V
    //   300: aload 11
    //   302: ifnull +8 -> 310
    //   305: aload 11
    //   307: invokevirtual 254	java/io/InputStream:close	()V
    //   310: new 256	axtn
    //   313: dup
    //   314: invokespecial 257	axtn:<init>	()V
    //   317: astore_1
    //   318: aload 16
    //   320: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: ldc_w 259
    //   326: invokevirtual 263	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   329: astore 11
    //   331: aload 11
    //   333: arraylength
    //   334: istore 5
    //   336: iconst_0
    //   337: istore 4
    //   339: iload 4
    //   341: iload 5
    //   343: if_icmpge +686 -> 1029
    //   346: aload_1
    //   347: aload 11
    //   349: iload 4
    //   351: aaload
    //   352: invokevirtual 264	axtn:a	(Ljava/lang/String;)V
    //   355: iload 4
    //   357: iconst_1
    //   358: iadd
    //   359: istore 4
    //   361: goto -22 -> 339
    //   364: aload 12
    //   366: astore 14
    //   368: aload_1
    //   369: astore 13
    //   371: aload_0
    //   372: getfield 192	axqa:jdField_b_of_type_Int	I
    //   375: ifne +382 -> 757
    //   378: aload 12
    //   380: astore 14
    //   382: aload_1
    //   383: astore 13
    //   385: new 122	java/io/File
    //   388: dup
    //   389: aload_0
    //   390: getfield 90	axqa:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   393: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: astore 15
    //   398: aload 15
    //   400: ifnull +18 -> 418
    //   403: aload 12
    //   405: astore 14
    //   407: aload_1
    //   408: astore 13
    //   410: aload 15
    //   412: invokevirtual 269	java/io/File:list	()[Ljava/lang/String;
    //   415: ifnonnull +67 -> 482
    //   418: aload 12
    //   420: astore 14
    //   422: aload_1
    //   423: astore 13
    //   425: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +54 -> 482
    //   431: aload 12
    //   433: astore 14
    //   435: aload_1
    //   436: astore 13
    //   438: new 66	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 271
    //   448: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: astore 11
    //   453: aload 15
    //   455: ifnonnull +167 -> 622
    //   458: iconst_1
    //   459: istore_3
    //   460: aload 12
    //   462: astore 14
    //   464: aload_1
    //   465: astore 13
    //   467: ldc 240
    //   469: iconst_2
    //   470: aload 11
    //   472: iload_3
    //   473: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   476: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aload 12
    //   484: astore 14
    //   486: aload_1
    //   487: astore 13
    //   489: getstatic 279	android/os/Build$VERSION:SDK_INT	I
    //   492: bipush 21
    //   494: if_icmplt +133 -> 627
    //   497: iconst_1
    //   498: istore 4
    //   500: aload 12
    //   502: astore 14
    //   504: aload_1
    //   505: astore 13
    //   507: aload 15
    //   509: invokevirtual 283	java/io/File:listFiles	()[Ljava/io/File;
    //   512: astore 17
    //   514: aload 17
    //   516: ifnull +241 -> 757
    //   519: iconst_0
    //   520: istore 5
    //   522: aload 12
    //   524: astore 14
    //   526: aload_1
    //   527: astore 13
    //   529: aload 17
    //   531: arraylength
    //   532: istore 6
    //   534: iload 5
    //   536: iload 6
    //   538: if_icmpge +219 -> 757
    //   541: iload 4
    //   543: ifeq +90 -> 633
    //   546: aload 12
    //   548: astore 14
    //   550: aload_1
    //   551: astore 13
    //   553: aload 15
    //   555: invokevirtual 286	java/io/File:getPath	()Ljava/lang/String;
    //   558: invokestatic 292	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   561: astore 11
    //   563: aload 12
    //   565: astore 14
    //   567: aload_1
    //   568: astore 13
    //   570: aload 16
    //   572: new 66	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   579: aload 11
    //   581: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc 232
    //   586: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 12
    //   598: astore 14
    //   600: aload_1
    //   601: astore 13
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 192	axqa:jdField_b_of_type_Int	I
    //   608: iconst_1
    //   609: iadd
    //   610: putfield 192	axqa:jdField_b_of_type_Int	I
    //   613: iload 5
    //   615: iconst_1
    //   616: iadd
    //   617: istore 5
    //   619: goto -97 -> 522
    //   622: iconst_0
    //   623: istore_3
    //   624: goto -164 -> 460
    //   627: iconst_0
    //   628: istore 4
    //   630: goto -130 -> 500
    //   633: aload 12
    //   635: astore 14
    //   637: aload_1
    //   638: astore 13
    //   640: aload 15
    //   642: invokevirtual 295	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   645: astore 11
    //   647: goto -84 -> 563
    //   650: astore 11
    //   652: aload 12
    //   654: astore 14
    //   656: aload_1
    //   657: astore 13
    //   659: ldc 240
    //   661: iconst_1
    //   662: ldc_w 297
    //   665: aload 11
    //   667: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   670: goto -74 -> 596
    //   673: astore 13
    //   675: aload 12
    //   677: astore 11
    //   679: aload 13
    //   681: astore 12
    //   683: aload 11
    //   685: astore 14
    //   687: aload_1
    //   688: astore 13
    //   690: ldc 240
    //   692: iconst_2
    //   693: new 66	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 302
    //   703: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 12
    //   708: invokevirtual 303	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   711: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: aload 11
    //   722: astore 14
    //   724: aload_1
    //   725: astore 13
    //   727: aload_0
    //   728: iconst_0
    //   729: putfield 192	axqa:jdField_b_of_type_Int	I
    //   732: aload 11
    //   734: ifnull +8 -> 742
    //   737: aload 11
    //   739: invokevirtual 251	java/io/BufferedReader:close	()V
    //   742: aload_1
    //   743: ifnull -433 -> 310
    //   746: aload_1
    //   747: invokevirtual 254	java/io/InputStream:close	()V
    //   750: goto -440 -> 310
    //   753: astore_1
    //   754: goto -444 -> 310
    //   757: aload 12
    //   759: astore 14
    //   761: aload_1
    //   762: astore 13
    //   764: aload 16
    //   766: new 66	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   773: ldc_w 305
    //   776: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_0
    //   780: getfield 192	axqa:jdField_b_of_type_Int	I
    //   783: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload 12
    //   795: astore 14
    //   797: aload_1
    //   798: astore 13
    //   800: aload 16
    //   802: new 66	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 307
    //   812: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload_0
    //   816: getfield 309	axqa:jdField_a_of_type_Int	I
    //   819: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload 12
    //   831: astore 14
    //   833: aload_1
    //   834: astore 13
    //   836: aload 16
    //   838: new 66	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   845: ldc_w 311
    //   848: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: ldc_w 313
    //   854: lload 7
    //   856: invokestatic 319	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   859: invokeinterface 322 1 0
    //   864: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 12
    //   876: astore 14
    //   878: aload_1
    //   879: astore 13
    //   881: aload 16
    //   883: ldc_w 324
    //   886: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 12
    //   892: astore 14
    //   894: aload_1
    //   895: astore 13
    //   897: aload 16
    //   899: new 66	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 326
    //   909: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokestatic 331	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   915: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload 12
    //   927: astore 14
    //   929: aload_1
    //   930: astore 13
    //   932: aload 16
    //   934: new 66	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 333
    //   944: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: iconst_2
    //   948: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   951: ldc_w 335
    //   954: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload_0
    //   958: getfield 64	axqa:jdField_c_of_type_Int	I
    //   961: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   964: ldc 232
    //   966: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: aload 12
    //   978: ifnull +8 -> 986
    //   981: aload 12
    //   983: invokevirtual 251	java/io/BufferedReader:close	()V
    //   986: aload_1
    //   987: ifnull -677 -> 310
    //   990: aload_1
    //   991: invokevirtual 254	java/io/InputStream:close	()V
    //   994: goto -684 -> 310
    //   997: astore_1
    //   998: goto -688 -> 310
    //   1001: astore 11
    //   1003: aconst_null
    //   1004: astore_1
    //   1005: aconst_null
    //   1006: astore 12
    //   1008: aload 12
    //   1010: ifnull +8 -> 1018
    //   1013: aload 12
    //   1015: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1018: aload_1
    //   1019: ifnull +7 -> 1026
    //   1022: aload_1
    //   1023: invokevirtual 254	java/io/InputStream:close	()V
    //   1026: aload 11
    //   1028: athrow
    //   1029: aload_0
    //   1030: aload_0
    //   1031: getfield 104	axqa:jdField_a_of_type_Axtl	Laxtl;
    //   1034: aload_1
    //   1035: invokevirtual 338	axtl:a	(Laxtn;)Ljava/lang/String;
    //   1038: putfield 340	axqa:d	Ljava/lang/String;
    //   1041: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1044: ifeq +32 -> 1076
    //   1047: ldc 240
    //   1049: iconst_2
    //   1050: new 66	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 342
    //   1060: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_0
    //   1064: getfield 340	axqa:d	Ljava/lang/String;
    //   1067: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: getstatic 347	axqa:e	Ljava/lang/String;
    //   1079: ifnonnull +31 -> 1110
    //   1082: new 66	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1089: invokestatic 353	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1092: invokevirtual 357	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   1095: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1098: ldc_w 362
    //   1101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: putstatic 347	axqa:e	Ljava/lang/String;
    //   1110: invokestatic 353	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1113: ldc_w 364
    //   1116: iconst_0
    //   1117: invokevirtual 368	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1120: astore_1
    //   1121: aload_0
    //   1122: getfield 192	axqa:jdField_b_of_type_Int	I
    //   1125: ifne +72 -> 1197
    //   1128: aload_1
    //   1129: ldc_w 370
    //   1132: lconst_0
    //   1133: invokeinterface 376 4 0
    //   1138: lstore 9
    //   1140: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   1143: lload 9
    //   1145: lsub
    //   1146: ldc2_w 377
    //   1149: lcmp
    //   1150: ifle +47 -> 1197
    //   1153: invokestatic 353	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1156: invokevirtual 382	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1159: invokestatic 385	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1162: aconst_null
    //   1163: ldc_w 387
    //   1166: iconst_1
    //   1167: lconst_0
    //   1168: lconst_0
    //   1169: aconst_null
    //   1170: aconst_null
    //   1171: invokevirtual 390	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1174: aload_1
    //   1175: invokeinterface 394 1 0
    //   1180: ldc_w 370
    //   1183: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   1186: invokeinterface 400 4 0
    //   1191: invokeinterface 403 1 0
    //   1196: pop
    //   1197: aconst_null
    //   1198: astore_1
    //   1199: iload_2
    //   1200: ifeq +61 -> 1261
    //   1203: invokestatic 408	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   1206: astore_1
    //   1207: aload_1
    //   1208: invokestatic 414	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1211: ifne +16 -> 1227
    //   1214: aload 16
    //   1216: ldc_w 416
    //   1219: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_1
    //   1223: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: pop
    //   1227: new 66	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1234: getstatic 347	axqa:e	Ljava/lang/String;
    //   1237: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: lload 7
    //   1242: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1245: ldc 137
    //   1247: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: astore_1
    //   1254: aload_0
    //   1255: aload_1
    //   1256: aload 16
    //   1258: invokespecial 422	axqa:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   1261: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1264: ifeq +29 -> 1293
    //   1267: ldc 240
    //   1269: iconst_2
    //   1270: new 66	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1277: ldc_w 424
    //   1280: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: iload_2
    //   1284: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1287: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1293: aload_1
    //   1294: areturn
    //   1295: astore 11
    //   1297: goto -311 -> 986
    //   1300: astore_1
    //   1301: goto -1001 -> 300
    //   1304: astore_1
    //   1305: goto -995 -> 310
    //   1308: astore 11
    //   1310: goto -568 -> 742
    //   1313: astore 12
    //   1315: goto -297 -> 1018
    //   1318: astore_1
    //   1319: goto -293 -> 1026
    //   1322: astore 11
    //   1324: aconst_null
    //   1325: astore 12
    //   1327: goto -319 -> 1008
    //   1330: astore 11
    //   1332: aload 14
    //   1334: astore 12
    //   1336: aload 13
    //   1338: astore_1
    //   1339: goto -331 -> 1008
    //   1342: astore 12
    //   1344: aload 11
    //   1346: astore 13
    //   1348: aload 12
    //   1350: astore 11
    //   1352: aload_1
    //   1353: astore 12
    //   1355: aload 13
    //   1357: astore_1
    //   1358: goto -350 -> 1008
    //   1361: astore 12
    //   1363: aconst_null
    //   1364: astore_1
    //   1365: aconst_null
    //   1366: astore 11
    //   1368: goto -685 -> 683
    //   1371: astore 12
    //   1373: aconst_null
    //   1374: astore 11
    //   1376: goto -693 -> 683
    //   1379: astore 12
    //   1381: aconst_null
    //   1382: astore 11
    //   1384: aconst_null
    //   1385: astore_1
    //   1386: goto -1128 -> 258
    //   1389: astore 12
    //   1391: aconst_null
    //   1392: astore 13
    //   1394: aload_1
    //   1395: astore 11
    //   1397: aload 13
    //   1399: astore_1
    //   1400: goto -1142 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1403	0	this	axqa
    //   0	1403	1	paramString	String
    //   0	1403	2	paramBoolean1	boolean
    //   0	1403	3	paramBoolean2	boolean
    //   95	534	4	i	int
    //   334	284	5	j	int
    //   532	7	6	k	int
    //   24	1217	7	l1	long
    //   1138	6	9	l2	long
    //   3	643	11	localObject1	Object
    //   650	16	11	localThrowable	Throwable
    //   677	61	11	localObject2	Object
    //   1001	26	11	localObject3	Object
    //   1295	1	11	localIOException1	java.io.IOException
    //   1308	1	11	localIOException2	java.io.IOException
    //   1322	1	11	localObject4	Object
    //   1330	15	11	localObject5	Object
    //   1350	46	11	localObject6	Object
    //   60	954	12	localObject7	Object
    //   1313	1	12	localIOException3	java.io.IOException
    //   1325	10	12	localObject8	Object
    //   1342	7	12	localObject9	Object
    //   1353	1	12	str1	String
    //   1361	1	12	localNullPointerException1	NullPointerException
    //   1371	1	12	localNullPointerException2	NullPointerException
    //   1379	1	12	localIOException4	java.io.IOException
    //   1389	1	12	localIOException5	java.io.IOException
    //   67	149	13	str2	String
    //   246	9	13	localIOException6	java.io.IOException
    //   369	289	13	str3	String
    //   673	7	13	localNullPointerException3	NullPointerException
    //   688	710	13	localObject10	Object
    //   64	1269	14	localObject11	Object
    //   74	567	15	localObject12	Object
    //   14	1243	16	localStringBuilder	StringBuilder
    //   33	497	17	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   69	76	246	java/io/IOException
    //   88	97	246	java/io/IOException
    //   113	129	246	java/io/IOException
    //   136	143	246	java/io/IOException
    //   150	176	246	java/io/IOException
    //   183	193	246	java/io/IOException
    //   204	210	246	java/io/IOException
    //   217	243	246	java/io/IOException
    //   371	378	246	java/io/IOException
    //   385	398	246	java/io/IOException
    //   410	418	246	java/io/IOException
    //   425	431	246	java/io/IOException
    //   438	453	246	java/io/IOException
    //   467	482	246	java/io/IOException
    //   489	497	246	java/io/IOException
    //   507	514	246	java/io/IOException
    //   529	534	246	java/io/IOException
    //   553	563	246	java/io/IOException
    //   570	596	246	java/io/IOException
    //   603	613	246	java/io/IOException
    //   640	647	246	java/io/IOException
    //   659	670	246	java/io/IOException
    //   764	793	246	java/io/IOException
    //   800	829	246	java/io/IOException
    //   836	874	246	java/io/IOException
    //   881	890	246	java/io/IOException
    //   897	925	246	java/io/IOException
    //   932	976	246	java/io/IOException
    //   553	563	650	java/lang/Throwable
    //   570	596	650	java/lang/Throwable
    //   640	647	650	java/lang/Throwable
    //   69	76	673	java/lang/NullPointerException
    //   88	97	673	java/lang/NullPointerException
    //   113	129	673	java/lang/NullPointerException
    //   136	143	673	java/lang/NullPointerException
    //   150	176	673	java/lang/NullPointerException
    //   183	193	673	java/lang/NullPointerException
    //   204	210	673	java/lang/NullPointerException
    //   217	243	673	java/lang/NullPointerException
    //   371	378	673	java/lang/NullPointerException
    //   385	398	673	java/lang/NullPointerException
    //   410	418	673	java/lang/NullPointerException
    //   425	431	673	java/lang/NullPointerException
    //   438	453	673	java/lang/NullPointerException
    //   467	482	673	java/lang/NullPointerException
    //   489	497	673	java/lang/NullPointerException
    //   507	514	673	java/lang/NullPointerException
    //   529	534	673	java/lang/NullPointerException
    //   553	563	673	java/lang/NullPointerException
    //   570	596	673	java/lang/NullPointerException
    //   603	613	673	java/lang/NullPointerException
    //   640	647	673	java/lang/NullPointerException
    //   659	670	673	java/lang/NullPointerException
    //   764	793	673	java/lang/NullPointerException
    //   800	829	673	java/lang/NullPointerException
    //   836	874	673	java/lang/NullPointerException
    //   881	890	673	java/lang/NullPointerException
    //   897	925	673	java/lang/NullPointerException
    //   932	976	673	java/lang/NullPointerException
    //   746	750	753	java/io/IOException
    //   990	994	997	java/io/IOException
    //   35	45	1001	finally
    //   981	986	1295	java/io/IOException
    //   296	300	1300	java/io/IOException
    //   305	310	1304	java/io/IOException
    //   737	742	1308	java/io/IOException
    //   1013	1018	1313	java/io/IOException
    //   1022	1026	1318	java/io/IOException
    //   45	62	1322	finally
    //   69	76	1330	finally
    //   88	97	1330	finally
    //   113	129	1330	finally
    //   136	143	1330	finally
    //   150	176	1330	finally
    //   183	193	1330	finally
    //   204	210	1330	finally
    //   217	243	1330	finally
    //   371	378	1330	finally
    //   385	398	1330	finally
    //   410	418	1330	finally
    //   425	431	1330	finally
    //   438	453	1330	finally
    //   467	482	1330	finally
    //   489	497	1330	finally
    //   507	514	1330	finally
    //   529	534	1330	finally
    //   553	563	1330	finally
    //   570	596	1330	finally
    //   603	613	1330	finally
    //   640	647	1330	finally
    //   659	670	1330	finally
    //   690	720	1330	finally
    //   727	732	1330	finally
    //   764	793	1330	finally
    //   800	829	1330	finally
    //   836	874	1330	finally
    //   881	890	1330	finally
    //   897	925	1330	finally
    //   932	976	1330	finally
    //   258	292	1342	finally
    //   35	45	1361	java/lang/NullPointerException
    //   45	62	1371	java/lang/NullPointerException
    //   35	45	1379	java/io/IOException
    //   45	62	1389	java/io/IOException
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 122	java/io/File
    //   3: dup
    //   4: getstatic 347	axqa:e	Ljava/lang/String;
    //   7: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 122	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 427	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 430	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 427	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 433	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 435	java/io/BufferedWriter
    //   68: dup
    //   69: new 437	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 440	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 443	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 446	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 449	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 450	java/io/BufferedWriter:close	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 240
    //   123: iconst_2
    //   124: ldc 187
    //   126: aload_3
    //   127: invokestatic 452	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ifnull -25 -> 106
    //   134: aload_2
    //   135: invokevirtual 450	java/io/BufferedWriter:close	()V
    //   138: return
    //   139: astore_1
    //   140: return
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 450	java/io/BufferedWriter:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: return
    //   158: astore_2
    //   159: goto -5 -> 154
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -19 -> 146
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload_1
    //   172: astore_3
    //   173: goto -62 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	axqa
    //   0	176	1	paramString	String
    //   0	176	2	paramStringBuilder	StringBuilder
    //   23	80	3	localBufferedWriter	java.io.BufferedWriter
    //   107	20	3	localThrowable	Throwable
    //   141	29	3	localObject1	Object
    //   172	1	3	str	String
    //   25	84	4	localObject2	Object
    //   10	30	5	localFile1	File
    //   20	54	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   29	37	107	java/lang/Throwable
    //   39	45	107	java/lang/Throwable
    //   47	55	107	java/lang/Throwable
    //   57	63	107	java/lang/Throwable
    //   65	86	107	java/lang/Throwable
    //   134	138	139	java/io/IOException
    //   29	37	141	finally
    //   39	45	141	finally
    //   47	55	141	finally
    //   57	63	141	finally
    //   65	86	141	finally
    //   113	119	141	finally
    //   121	130	141	finally
    //   102	106	156	java/io/IOException
    //   150	154	158	java/io/IOException
    //   86	98	162	finally
    //   86	98	168	java/lang/Throwable
  }
  
  private void b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (new File(paramString).exists())
      {
        bbdx.b(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("FDStats", 2, "deleteFDFiles");
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("FDStats", 2, "deleteFDFiles");
    }
  }
  
  private void i()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new File(this.jdField_b_of_type_JavaLangString);
    boolean bool;
    if (((localObject == null) || (((File)localObject).list() == null)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("checkFDCount file:");
      if (localObject != null) {
        break label209;
      }
      bool = true;
      QLog.d("FDStats", 2, bool);
    }
    int i;
    int j;
    for (;;)
    {
      try
      {
        i = ((File)localObject).list().length;
      }
      catch (NullPointerException localNullPointerException1)
      {
        label209:
        i = 0;
      }
      try
      {
        axrn.jdField_a_of_type_Int = i;
        axrn.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 0;
        j = i;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
        if (j == 0)
        {
          l2 = ((SharedPreferences)localObject).getLong("key_last_count_failed_time", 0L);
          if ((System.currentTimeMillis() - l2 > 86400000L) && (l2 != 0L))
          {
            axrn.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "fdCountFailed", true, 0L, 0L, null, null);
            ((SharedPreferences)localObject).edit().putLong("key_last_count_failed_time", System.currentTimeMillis()).commit();
          }
        }
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
          break label241;
        }
        return;
      }
      catch (NullPointerException localNullPointerException2)
      {
        int k;
        long l3;
        long l4;
        int m;
        Message localMessage;
        break label219;
      }
      bool = false;
      break;
      label219:
      if (QLog.isColorLevel()) {
        QLog.e("FDStats", 2, localNullPointerException1.toString());
      }
      j = i;
    }
    label241:
    k = 0;
    long l2 = System.currentTimeMillis();
    l3 = localNullPointerException1.getLong("key_last_report", 0L);
    l4 = localNullPointerException1.getLong("key_last_threadhold_report", 0L);
    if (j >= 800)
    {
      m = localNullPointerException1.getInt("key_last_threadhold_size", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "lastReportTime:" + l3 + " lastThreadHoldTime:" + l4 + " lastSize:" + m);
      }
      if (Math.abs(l2 - l4) <= 86400000L)
      {
        i = k;
        if (j - m < 100) {}
      }
      else
      {
        k = 1;
        a(this.jdField_c_of_type_JavaLangString, true, false);
        a(true);
        localNullPointerException1.edit().putLong("key_last_threadhold_report", l2).commit();
        localNullPointerException1.edit().putInt("key_last_threadhold_size", j).commit();
        i = k;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          localMessage = Message.obtain();
          localMessage.obj = Long.valueOf(l3);
          localMessage.what = 1004;
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
          i = k;
        }
      }
    }
    for (;;)
    {
      if ((j > 900) && (i != 0) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1005);
      }
      l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FDStats", 2, "checkFDCount count:" + j + " time:" + (l2 - l1));
      return;
      i = k;
      if (Math.abs(l2 - l3) > 43200000L)
      {
        i = k;
        if (j > 800)
        {
          k = 1;
          a(this.jdField_c_of_type_JavaLangString, true, false);
          i = k;
          if (this.jdField_a_of_type_AndroidOsHandler != null)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
            i = k;
          }
        }
      }
    }
  }
  
  File a(long paramLong1, long paramLong2)
  {
    Object localObject2;
    if (e == null)
    {
      localObject2 = null;
      return localObject2;
    }
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      try
      {
        localObject1 = new ArrayList();
        localObject2 = new File(e);
        if (!((File)localObject2).exists()) {
          return null;
        }
        localObject2 = ((File)localObject2).listFiles();
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          File localFile = localObject2[i];
          if (localFile.getName().contains(".zip")) {
            break label342;
          }
          long l = a(localFile, false);
          if ((l == -1L) || (l >= paramLong2) || (l <= paramLong1)) {
            break label342;
          }
          ((List)localObject1).add(localFile.getAbsolutePath());
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject1 = null;
      }
      for (;;)
      {
        for (;;)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FDStats", 2, "", localThrowable1);
          return localObject1;
          if (jdField_a_of_type_JavaLangString != null)
          {
            localObject2 = new File(jdField_a_of_type_JavaLangString);
            if (((File)localObject2).exists())
            {
              localObject2 = ((File)localObject2).listFiles();
              j = localObject2.length;
              i = 0;
              while (i < j)
              {
                ((List)localObject1).add(localObject2[i].getAbsolutePath());
                i += 1;
              }
            }
          }
          if (((List)localObject1).size() <= 0) {
            break label335;
          }
          localObject2 = e + paramLong2 + ".zip";
          if (bbdx.a((List)localObject1, (String)localObject2)) {
            localObject1 = new File((String)localObject2);
          }
          label335:
          try
          {
            boolean bool = ((File)localObject1).exists();
            localObject2 = localObject1;
            if (bool) {
              break;
            }
            return null;
          }
          catch (Throwable localThrowable2) {}
        }
        QLog.e("FDStats", 2, "zip fail");
        b(e);
        b(jdField_a_of_type_JavaLangString);
        return null;
      }
      label342:
      i += 1;
    }
  }
  
  final String a()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.batteryCfg.name());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("#")))
    {
      localObject = ((String)localObject).split("#");
      if (localObject.length > 2) {
        return localObject[2];
      }
      return "";
    }
    return "";
  }
  
  String a(Date paramDate)
  {
    try
    {
      paramDate = ((SimpleDateFormat)jdField_a_of_type_JavaLangThreadLocal.get()).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate) {}
    return "";
  }
  
  public void a()
  {
    boolean bool = true;
    label277:
    for (;;)
    {
      try
      {
        e();
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, "already start");
          }
          return;
        }
        Object localObject1 = a();
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          Object localObject3 = ((String)localObject1).split(";");
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
          long l = ((SharedPreferences)localObject1).getLong("last_rand_timestamp", 0L);
          String str = ((SharedPreferences)localObject1).getString("rand_factor", "");
          localObject3 = localObject3[1];
          if ((Math.abs(System.currentTimeMillis() - l) > 43200000L) || (!str.equals(localObject3))) {
            ((SharedPreferences)localObject1).edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject3).commit();
          }
          if (Math.random() >= Float.valueOf((String)localObject3).floatValue()) {
            break label277;
          }
          if (bool) {
            f();
          }
          QLog.d("FDStats", 1, new Object[] { "enable background, enableHook:", Boolean.valueOf(bool), " new random.", str, ", ", localObject3 });
          this.jdField_b_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_Boolean = true;
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.d("FDStats", 2, localException.toString());
          continue;
          bool = false;
        }
      }
      finally {}
    }
  }
  
  void a(long paramLong)
  {
    int j = 0;
    if (e == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(e);
        if (!((File)localObject).exists()) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        int k = localObject.length;
        i = 0;
        if (i < k)
        {
          File localFile = localObject[i];
          long l = a(localFile, true);
          if ((l == -1L) || (l >= paramLong)) {
            break label220;
          }
          localFile.delete();
          break label220;
        }
        if (jdField_a_of_type_JavaLangString != null)
        {
          localObject = new File(jdField_a_of_type_JavaLangString);
          if ((((File)localObject).exists()) && (paramLong > 0L) && (System.currentTimeMillis() - paramLong > 86400000L))
          {
            localObject = ((File)localObject).listFiles();
            k = localObject.length;
            i = j;
            if (i < k)
            {
              localObject[i].delete();
              i += 1;
              continue;
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "", localThrowable);
        }
      }
      QLog.d("FDStats", 2, "cleanStorage " + paramLong);
      return;
      label220:
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      h();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FDStats", 1, "analyseCurFD on crash error", paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l2 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l1 = System.currentTimeMillis();
    Object localObject2;
    if ((Math.abs(l1 - l2) > 43200000L) || (paramBoolean))
    {
      localObject2 = a(l2, l1);
      if (localObject2 == null) {
        break label398;
      }
      ((SharedPreferences)localObject1).edit().putLong("key_last_report", l1).commit();
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fileObj1", ((File)localObject2).getAbsolutePath());
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("p_id", MagnifierSDK.a());
        ((JSONObject)localObject2).put("plugin", String.valueOf(137));
        ((JSONObject)localObject2).put("newplugin", String.valueOf(137));
        ((JSONObject)localObject1).put("fileObj", localJSONObject);
        ((JSONObject)localObject1).put("clientinfo", localObject2);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FDStats", 2, "report fail.", localThrowable);
        continue;
      }
      try
      {
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
        if (localObject2 == null) {
          break label438;
        }
        l1 = Long.parseLong(((QQAppInterface)localObject2).c());
      }
      catch (Exception localException)
      {
        QLog.e("FDStats", 2, "reportFileToAPM get uin " + 0L);
        l1 = 0L;
        continue;
      }
      ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
      localObject1 = a(new Date(axrn.jdField_a_of_type_Long));
      axpu.a(new Exception(String.format("FDStats countLastChecked: %d at %s", new Object[] { Integer.valueOf(axrn.jdField_a_of_type_Int), localObject1 })), this.d);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "reportFileToAPM");
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).obj = Long.valueOf(l2);
        ((Message)localObject1).what = 1004;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 500L);
      }
      return;
      label398:
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "no file to report");
      }
      localThrowable.edit().putLong("key_last_report", l1).commit();
      continue;
      label438:
      l1 = 0L;
    }
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
  }
  
  /* Error */
  void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 309	axqa:jdField_a_of_type_Int	I
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 185	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_3
    //   16: anewarray 41	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 739
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 741
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 743
    //   36: aastore
    //   37: invokevirtual 746	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +125 -> 167
    //   45: aload_1
    //   46: invokevirtual 210	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: astore_1
    //   50: new 212	java/io/BufferedReader
    //   53: dup
    //   54: new 214	java/io/InputStreamReader
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 217	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: sipush 7777
    //   65: invokespecial 749	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 5
    //   75: aload_3
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload 5
    //   82: ifnull +90 -> 172
    //   85: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +30 -> 118
    //   91: ldc 240
    //   93: iconst_2
    //   94: new 66	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 751
    //   104: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: aload 5
    //   121: invokestatic 754	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: putfield 309	axqa:jdField_a_of_type_Int	I
    //   127: goto -58 -> 69
    //   130: astore 4
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 240
    //   141: iconst_1
    //   142: ldc 245
    //   144: aload_3
    //   145: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 251	java/io/BufferedReader:close	()V
    //   156: aload_2
    //   157: ifnull -148 -> 9
    //   160: aload_2
    //   161: invokevirtual 254	java/io/InputStream:close	()V
    //   164: return
    //   165: astore_1
    //   166: return
    //   167: aconst_null
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 251	java/io/BufferedReader:close	()V
    //   182: aload_2
    //   183: ifnull -174 -> 9
    //   186: aload_2
    //   187: invokevirtual 254	java/io/InputStream:close	()V
    //   190: return
    //   191: astore_1
    //   192: return
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 251	java/io/BufferedReader:close	()V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 254	java/io/InputStream:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_1
    //   217: goto -35 -> 182
    //   220: astore_1
    //   221: goto -65 -> 156
    //   224: astore_3
    //   225: goto -19 -> 206
    //   228: astore_1
    //   229: goto -15 -> 214
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -37 -> 198
    //   238: astore_2
    //   239: goto -41 -> 198
    //   242: astore_3
    //   243: aload_2
    //   244: astore 4
    //   246: aload_3
    //   247: astore_2
    //   248: aload_1
    //   249: astore_3
    //   250: aload 4
    //   252: astore_1
    //   253: goto -55 -> 198
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -120 -> 139
    //   262: astore_3
    //   263: aconst_null
    //   264: astore 4
    //   266: aload_1
    //   267: astore_2
    //   268: aload 4
    //   270: astore_1
    //   271: goto -132 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	axqa
    //   13	140	1	localObject1	Object
    //   165	1	1	localIOException1	java.io.IOException
    //   191	1	1	localIOException2	java.io.IOException
    //   197	14	1	localObject2	Object
    //   216	1	1	localIOException3	java.io.IOException
    //   220	1	1	localIOException4	java.io.IOException
    //   228	21	1	localIOException5	java.io.IOException
    //   252	19	1	localObject3	Object
    //   1	186	2	localObject4	Object
    //   193	22	2	localObject5	Object
    //   232	1	2	localObject6	Object
    //   238	6	2	localObject7	Object
    //   247	21	2	localObject8	Object
    //   68	135	3	localObject9	Object
    //   224	1	3	localIOException6	java.io.IOException
    //   234	1	3	localObject10	Object
    //   242	5	3	localObject11	Object
    //   249	1	3	localIOException7	java.io.IOException
    //   256	1	3	localThrowable1	Throwable
    //   262	1	3	localThrowable2	Throwable
    //   76	1	4	localObject12	Object
    //   130	7	4	localThrowable3	Throwable
    //   168	101	4	localObject13	Object
    //   73	47	5	str	String
    // Exception table:
    //   from	to	target	type
    //   69	75	130	java/lang/Throwable
    //   85	118	130	java/lang/Throwable
    //   118	127	130	java/lang/Throwable
    //   160	164	165	java/io/IOException
    //   186	190	191	java/io/IOException
    //   14	41	193	finally
    //   45	50	193	finally
    //   177	182	216	java/io/IOException
    //   152	156	220	java/io/IOException
    //   202	206	224	java/io/IOException
    //   210	214	228	java/io/IOException
    //   50	69	232	finally
    //   69	75	238	finally
    //   85	118	238	finally
    //   118	127	238	finally
    //   139	148	242	finally
    //   14	41	256	java/lang/Throwable
    //   45	50	256	java/lang/Throwable
    //   50	69	262	java/lang/Throwable
  }
  
  void d() {}
  
  void e()
  {
    b(Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/fdmon/");
  }
  
  void f()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (FDNative.a()))
    {
      amvi localamvi = (amvi)ampl.a().a(546);
      if ((localamvi != null) && (localamvi.d == 1))
      {
        FDNative.a();
        FDNative.nativeSetColor(false);
        FDNative.a();
        FDNative.nativeRegister(".*\\.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libjavacore.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libEGL.so$");
        FDNative.a();
        FDNative.nativeStart();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        QLog.d("FDStats", 1, "fd hook start");
      }
    }
  }
  
  void g()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/fdbc/";
    }
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    FDNative.a().a(jdField_a_of_type_JavaLangString);
  }
  
  public void h()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      i();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      a(false);
      continue;
      a(((Long)paramMessage.obj).longValue());
      continue;
      d();
      continue;
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqa
 * JD-Core Version:    0.7.0.1
 */