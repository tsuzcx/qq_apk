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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class bdkc
  implements Handler.Callback, StatisticCollector.StatisticCallback
{
  private static long jdField_a_of_type_Long = 1800000L;
  private static volatile bdkc jdField_a_of_type_Bdkc;
  static String jdField_a_of_type_JavaLangString;
  private static ThreadLocal<SimpleDateFormat> jdField_a_of_type_JavaLangThreadLocal = new bdkd();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4113, 4113, 4097, 4097 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static String e;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private bdke jdField_a_of_type_Bdke = new bdke();
  private bdmp jdField_a_of_type_Bdmp = new bdmp();
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
  
  public static bdkc a()
  {
    if (jdField_a_of_type_Bdkc == null) {}
    try
    {
      if (jdField_a_of_type_Bdkc == null)
      {
        jdField_a_of_type_Bdkc = new bdkc();
        if (StatisticCollector.sFdDetectCallback == null) {
          StatisticCollector.sFdDetectCallback = jdField_a_of_type_Bdkc;
        }
      }
      return jdField_a_of_type_Bdkc;
    }
    finally {}
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 186	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 11
    //   5: new 66	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 188
    //   11: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 16
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 193	bdkc:jdField_b_of_type_Int	I
    //   21: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   24: lstore 7
    //   26: new 200	bdkf
    //   29: dup
    //   30: invokespecial 201	bdkf:<init>	()V
    //   33: astore 17
    //   35: aload 11
    //   37: aload_1
    //   38: invokevirtual 205	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 211	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore_1
    //   45: new 213	java/io/BufferedReader
    //   48: dup
    //   49: new 215	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 218	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 221	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore 12
    //   62: aload 12
    //   64: astore 14
    //   66: aload_1
    //   67: astore 13
    //   69: aload 12
    //   71: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore 15
    //   76: aload 15
    //   78: ifnull +286 -> 364
    //   81: aload 12
    //   83: astore 14
    //   85: aload_1
    //   86: astore 13
    //   88: aload 15
    //   90: ldc 226
    //   92: invokevirtual 229	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   140: invokevirtual 231	bdkf:a	(Ljava/lang/String;)V
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
    //   164: ldc 233
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
    //   185: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   188: iconst_1
    //   189: iadd
    //   190: putfield 193	bdkc:jdField_b_of_type_Int	I
    //   193: iload_3
    //   194: ifeq -132 -> 62
    //   197: aload 12
    //   199: astore 14
    //   201: aload_1
    //   202: astore 13
    //   204: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -145 -> 62
    //   210: aload 12
    //   212: astore 14
    //   214: aload_1
    //   215: astore 13
    //   217: ldc 241
    //   219: iconst_2
    //   220: new 66	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   227: aload 11
    //   229: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 233
    //   234: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -181 -> 62
    //   246: astore 13
    //   248: aload_1
    //   249: astore 11
    //   251: aload 12
    //   253: astore_1
    //   254: aload 13
    //   256: astore 12
    //   258: ldc 241
    //   260: iconst_2
    //   261: new 66	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   268: ldc 246
    //   270: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 12
    //   275: invokevirtual 247	java/io/IOException:toString	()Ljava/lang/String;
    //   278: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 193	bdkc:jdField_b_of_type_Int	I
    //   292: aload_1
    //   293: ifnull +7 -> 300
    //   296: aload_1
    //   297: invokevirtual 252	java/io/BufferedReader:close	()V
    //   300: aload 11
    //   302: ifnull +8 -> 310
    //   305: aload 11
    //   307: invokevirtual 255	java/io/InputStream:close	()V
    //   310: new 257	bdmr
    //   313: dup
    //   314: invokespecial 258	bdmr:<init>	()V
    //   317: astore_1
    //   318: aload 16
    //   320: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: ldc_w 260
    //   326: invokevirtual 264	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   329: astore 11
    //   331: aload 11
    //   333: arraylength
    //   334: istore 5
    //   336: iconst_0
    //   337: istore 4
    //   339: iload 4
    //   341: iload 5
    //   343: if_icmpge +759 -> 1102
    //   346: aload_1
    //   347: aload 11
    //   349: iload 4
    //   351: aaload
    //   352: invokevirtual 265	bdmr:a	(Ljava/lang/String;)V
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
    //   372: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   375: ifne +374 -> 749
    //   378: aload 12
    //   380: astore 14
    //   382: aload_1
    //   383: astore 13
    //   385: new 122	java/io/File
    //   388: dup
    //   389: aload_0
    //   390: getfield 90	bdkc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   393: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: astore 11
    //   398: aload 11
    //   400: ifnull +18 -> 418
    //   403: aload 12
    //   405: astore 14
    //   407: aload_1
    //   408: astore 13
    //   410: aload 11
    //   412: invokevirtual 270	java/io/File:list	()[Ljava/lang/String;
    //   415: ifnonnull +67 -> 482
    //   418: aload 12
    //   420: astore 14
    //   422: aload_1
    //   423: astore 13
    //   425: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +54 -> 482
    //   431: aload 12
    //   433: astore 14
    //   435: aload_1
    //   436: astore 13
    //   438: new 66	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 272
    //   448: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: astore 15
    //   453: aload 11
    //   455: ifnonnull +208 -> 663
    //   458: iconst_1
    //   459: istore_3
    //   460: aload 12
    //   462: astore 14
    //   464: aload_1
    //   465: astore 13
    //   467: ldc 241
    //   469: iconst_2
    //   470: aload 15
    //   472: iload_3
    //   473: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   476: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aload 12
    //   484: astore 14
    //   486: aload_1
    //   487: astore 13
    //   489: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   492: bipush 21
    //   494: if_icmplt +174 -> 668
    //   497: iconst_1
    //   498: istore 4
    //   500: aload 12
    //   502: astore 14
    //   504: aload_1
    //   505: astore 13
    //   507: aload 11
    //   509: invokevirtual 284	java/io/File:listFiles	()[Ljava/io/File;
    //   512: astore 15
    //   514: aload 15
    //   516: ifnull +233 -> 749
    //   519: aload 12
    //   521: astore 14
    //   523: aload_1
    //   524: astore 13
    //   526: new 66	java/lang/StringBuilder
    //   529: dup
    //   530: sipush 200
    //   533: invokespecial 287	java/lang/StringBuilder:<init>	(I)V
    //   536: astore 17
    //   538: aload 12
    //   540: astore 14
    //   542: aload_1
    //   543: astore 13
    //   545: aload 17
    //   547: ldc_w 289
    //   550: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: iconst_0
    //   555: istore 5
    //   557: iconst_0
    //   558: istore 6
    //   560: aload 12
    //   562: astore 14
    //   564: aload_1
    //   565: astore 13
    //   567: iload 5
    //   569: aload 15
    //   571: arraylength
    //   572: if_icmpge +154 -> 726
    //   575: aload 15
    //   577: iload 5
    //   579: aaload
    //   580: astore 18
    //   582: iload 4
    //   584: ifeq +90 -> 674
    //   587: aload 12
    //   589: astore 14
    //   591: aload_1
    //   592: astore 13
    //   594: aload 18
    //   596: invokevirtual 292	java/io/File:getPath	()Ljava/lang/String;
    //   599: invokestatic 298	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   602: astore 11
    //   604: aload 12
    //   606: astore 14
    //   608: aload_1
    //   609: astore 13
    //   611: aload 16
    //   613: new 66	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   620: aload 11
    //   622: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc 233
    //   627: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 12
    //   639: astore 14
    //   641: aload_1
    //   642: astore 13
    //   644: aload_0
    //   645: aload_0
    //   646: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   649: iconst_1
    //   650: iadd
    //   651: putfield 193	bdkc:jdField_b_of_type_Int	I
    //   654: iload 5
    //   656: iconst_1
    //   657: iadd
    //   658: istore 5
    //   660: goto -100 -> 560
    //   663: iconst_0
    //   664: istore_3
    //   665: goto -205 -> 460
    //   668: iconst_0
    //   669: istore 4
    //   671: goto -171 -> 500
    //   674: aload 12
    //   676: astore 14
    //   678: aload_1
    //   679: astore 13
    //   681: aload 18
    //   683: invokevirtual 301	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   686: astore 11
    //   688: goto -84 -> 604
    //   691: astore 11
    //   693: aload 12
    //   695: astore 14
    //   697: aload_1
    //   698: astore 13
    //   700: aload 17
    //   702: ldc_w 303
    //   705: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload 18
    //   710: invokevirtual 292	java/io/File:getPath	()Ljava/lang/String;
    //   713: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: iload 6
    //   719: iconst_1
    //   720: iadd
    //   721: istore 6
    //   723: goto -86 -> 637
    //   726: iload 6
    //   728: ifle +21 -> 749
    //   731: aload 12
    //   733: astore 14
    //   735: aload_1
    //   736: astore 13
    //   738: ldc 241
    //   740: iconst_2
    //   741: aload 16
    //   743: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: aload 12
    //   751: astore 14
    //   753: aload_1
    //   754: astore 13
    //   756: aload 16
    //   758: new 66	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 305
    //   768: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   775: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload 12
    //   787: astore 14
    //   789: aload_1
    //   790: astore 13
    //   792: aload 16
    //   794: new 66	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   801: ldc_w 307
    //   804: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload_0
    //   808: getfield 309	bdkc:jdField_a_of_type_Int	I
    //   811: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   814: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 12
    //   823: astore 14
    //   825: aload_1
    //   826: astore 13
    //   828: aload 16
    //   830: new 66	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 311
    //   840: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: ldc_w 313
    //   846: lload 7
    //   848: invokestatic 319	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   851: invokeinterface 322 1 0
    //   856: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload 12
    //   868: astore 14
    //   870: aload_1
    //   871: astore 13
    //   873: aload 16
    //   875: ldc_w 324
    //   878: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 12
    //   884: astore 14
    //   886: aload_1
    //   887: astore 13
    //   889: aload 16
    //   891: new 66	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   898: ldc_w 326
    //   901: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokestatic 331	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   907: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 12
    //   919: astore 14
    //   921: aload_1
    //   922: astore 13
    //   924: aload 16
    //   926: new 66	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   933: ldc_w 333
    //   936: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: iconst_2
    //   940: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   943: ldc_w 335
    //   946: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload_0
    //   950: getfield 64	bdkc:jdField_c_of_type_Int	I
    //   953: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: ldc 233
    //   958: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 12
    //   970: ifnull +8 -> 978
    //   973: aload 12
    //   975: invokevirtual 252	java/io/BufferedReader:close	()V
    //   978: aload_1
    //   979: ifnull -669 -> 310
    //   982: aload_1
    //   983: invokevirtual 255	java/io/InputStream:close	()V
    //   986: goto -676 -> 310
    //   989: astore_1
    //   990: goto -680 -> 310
    //   993: astore 15
    //   995: aconst_null
    //   996: astore_1
    //   997: aconst_null
    //   998: astore 11
    //   1000: aload 11
    //   1002: astore 14
    //   1004: aload_1
    //   1005: astore 13
    //   1007: ldc 241
    //   1009: iconst_2
    //   1010: new 66	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1017: ldc_w 337
    //   1020: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: aload 15
    //   1025: invokevirtual 338	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   1028: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload 11
    //   1039: astore 14
    //   1041: aload_1
    //   1042: astore 13
    //   1044: aload_0
    //   1045: iconst_0
    //   1046: putfield 193	bdkc:jdField_b_of_type_Int	I
    //   1049: aload 11
    //   1051: ifnull +8 -> 1059
    //   1054: aload 11
    //   1056: invokevirtual 252	java/io/BufferedReader:close	()V
    //   1059: aload_1
    //   1060: ifnull -750 -> 310
    //   1063: aload_1
    //   1064: invokevirtual 255	java/io/InputStream:close	()V
    //   1067: goto -757 -> 310
    //   1070: astore_1
    //   1071: goto -761 -> 310
    //   1074: astore 11
    //   1076: aconst_null
    //   1077: astore_1
    //   1078: aconst_null
    //   1079: astore 12
    //   1081: aload 12
    //   1083: ifnull +8 -> 1091
    //   1086: aload 12
    //   1088: invokevirtual 252	java/io/BufferedReader:close	()V
    //   1091: aload_1
    //   1092: ifnull +7 -> 1099
    //   1095: aload_1
    //   1096: invokevirtual 255	java/io/InputStream:close	()V
    //   1099: aload 11
    //   1101: athrow
    //   1102: aload_0
    //   1103: aload_0
    //   1104: getfield 104	bdkc:jdField_a_of_type_Bdmp	Lbdmp;
    //   1107: aload_1
    //   1108: invokevirtual 341	bdmp:a	(Lbdmr;)Ljava/lang/String;
    //   1111: putfield 343	bdkc:d	Ljava/lang/String;
    //   1114: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +32 -> 1149
    //   1120: ldc 241
    //   1122: iconst_2
    //   1123: new 66	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1130: ldc_w 345
    //   1133: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload_0
    //   1137: getfield 343	bdkc:d	Ljava/lang/String;
    //   1140: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: getstatic 350	bdkc:e	Ljava/lang/String;
    //   1152: ifnonnull +31 -> 1183
    //   1155: new 66	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1162: invokestatic 356	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1165: invokevirtual 360	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   1168: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1171: ldc_w 365
    //   1174: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: putstatic 350	bdkc:e	Ljava/lang/String;
    //   1183: invokestatic 356	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1186: ldc_w 367
    //   1189: iconst_0
    //   1190: invokevirtual 371	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1193: astore_1
    //   1194: aload_0
    //   1195: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   1198: ifne +223 -> 1421
    //   1201: aload_1
    //   1202: ldc_w 373
    //   1205: lconst_0
    //   1206: invokeinterface 379 4 0
    //   1211: lstore 9
    //   1213: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1216: lload 9
    //   1218: lsub
    //   1219: ldc2_w 380
    //   1222: lcmp
    //   1223: ifle +47 -> 1270
    //   1226: invokestatic 356	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1229: invokevirtual 385	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1232: invokestatic 389	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1235: aconst_null
    //   1236: ldc_w 391
    //   1239: iconst_1
    //   1240: lconst_0
    //   1241: lconst_0
    //   1242: aconst_null
    //   1243: aconst_null
    //   1244: invokevirtual 395	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1247: aload_1
    //   1248: invokeinterface 399 1 0
    //   1253: ldc_w 373
    //   1256: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1259: invokeinterface 405 4 0
    //   1264: invokeinterface 408 1 0
    //   1269: pop
    //   1270: aconst_null
    //   1271: astore_1
    //   1272: iload_2
    //   1273: ifeq +114 -> 1387
    //   1276: invokestatic 413	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   1279: astore_1
    //   1280: aload_1
    //   1281: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifne +16 -> 1300
    //   1287: aload 16
    //   1289: ldc_w 421
    //   1292: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload_1
    //   1296: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: new 423	java/util/HashMap
    //   1303: dup
    //   1304: iconst_1
    //   1305: invokespecial 424	java/util/HashMap:<init>	(I)V
    //   1308: astore 11
    //   1310: aload_1
    //   1311: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1314: ifeq +155 -> 1469
    //   1317: ldc_w 426
    //   1320: astore_1
    //   1321: aload 11
    //   1323: ldc_w 428
    //   1326: aload_1
    //   1327: invokevirtual 432	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1330: pop
    //   1331: invokestatic 356	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1334: invokevirtual 385	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1337: invokestatic 389	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1340: aconst_null
    //   1341: ldc_w 434
    //   1344: iconst_1
    //   1345: lconst_0
    //   1346: lconst_0
    //   1347: aload 11
    //   1349: aconst_null
    //   1350: invokevirtual 395	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1353: new 66	java/lang/StringBuilder
    //   1356: dup
    //   1357: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1360: getstatic 350	bdkc:e	Ljava/lang/String;
    //   1363: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: lload 7
    //   1368: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1371: ldc 137
    //   1373: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: astore_1
    //   1380: aload_0
    //   1381: aload_1
    //   1382: aload 16
    //   1384: invokespecial 440	bdkc:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   1387: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1390: ifeq +29 -> 1419
    //   1393: ldc 241
    //   1395: iconst_2
    //   1396: new 66	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 442
    //   1406: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: iload_2
    //   1410: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1413: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1419: aload_1
    //   1420: areturn
    //   1421: new 423	java/util/HashMap
    //   1424: dup
    //   1425: iconst_1
    //   1426: invokespecial 424	java/util/HashMap:<init>	(I)V
    //   1429: astore_1
    //   1430: aload_1
    //   1431: ldc_w 444
    //   1434: aload_0
    //   1435: getfield 193	bdkc:jdField_b_of_type_Int	I
    //   1438: invokestatic 446	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1441: invokevirtual 432	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1444: pop
    //   1445: invokestatic 356	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1448: invokevirtual 385	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1451: invokestatic 389	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1454: aconst_null
    //   1455: ldc_w 448
    //   1458: iconst_1
    //   1459: lconst_0
    //   1460: lconst_0
    //   1461: aload_1
    //   1462: aconst_null
    //   1463: invokevirtual 395	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1466: goto -196 -> 1270
    //   1469: aload_1
    //   1470: invokevirtual 146	java/lang/String:length	()I
    //   1473: invokestatic 446	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1476: astore_1
    //   1477: goto -156 -> 1321
    //   1480: astore 11
    //   1482: goto -504 -> 978
    //   1485: astore_1
    //   1486: goto -1186 -> 300
    //   1489: astore_1
    //   1490: goto -1180 -> 310
    //   1493: astore 11
    //   1495: goto -436 -> 1059
    //   1498: astore 12
    //   1500: goto -409 -> 1091
    //   1503: astore_1
    //   1504: goto -405 -> 1099
    //   1507: astore 11
    //   1509: aconst_null
    //   1510: astore 12
    //   1512: goto -431 -> 1081
    //   1515: astore 11
    //   1517: aload 14
    //   1519: astore 12
    //   1521: aload 13
    //   1523: astore_1
    //   1524: goto -443 -> 1081
    //   1527: astore 12
    //   1529: aload 11
    //   1531: astore 13
    //   1533: aload 12
    //   1535: astore 11
    //   1537: aload_1
    //   1538: astore 12
    //   1540: aload 13
    //   1542: astore_1
    //   1543: goto -462 -> 1081
    //   1546: astore 15
    //   1548: aconst_null
    //   1549: astore 11
    //   1551: goto -551 -> 1000
    //   1554: astore 15
    //   1556: aload 12
    //   1558: astore 11
    //   1560: goto -560 -> 1000
    //   1563: astore 12
    //   1565: aconst_null
    //   1566: astore 11
    //   1568: aconst_null
    //   1569: astore_1
    //   1570: goto -1312 -> 258
    //   1573: astore 12
    //   1575: aconst_null
    //   1576: astore 13
    //   1578: aload_1
    //   1579: astore 11
    //   1581: aload 13
    //   1583: astore_1
    //   1584: goto -1326 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1587	0	this	bdkc
    //   0	1587	1	paramString	String
    //   0	1587	2	paramBoolean1	boolean
    //   0	1587	3	paramBoolean2	boolean
    //   95	575	4	i	int
    //   334	325	5	j	int
    //   558	169	6	k	int
    //   24	1343	7	l1	long
    //   1211	6	9	l2	long
    //   3	684	11	localObject1	Object
    //   691	1	11	localThrowable	Throwable
    //   998	57	11	localObject2	Object
    //   1074	26	11	localObject3	Object
    //   1308	40	11	localHashMap	HashMap
    //   1480	1	11	localIOException1	java.io.IOException
    //   1493	1	11	localIOException2	java.io.IOException
    //   1507	1	11	localObject4	Object
    //   1515	15	11	localObject5	Object
    //   1535	45	11	localObject6	Object
    //   60	1027	12	localObject7	Object
    //   1498	1	12	localIOException3	java.io.IOException
    //   1510	10	12	localObject8	Object
    //   1527	7	12	localObject9	Object
    //   1538	19	12	str1	String
    //   1563	1	12	localIOException4	java.io.IOException
    //   1573	1	12	localIOException5	java.io.IOException
    //   67	149	13	str2	String
    //   246	9	13	localIOException6	java.io.IOException
    //   369	1213	13	localObject10	Object
    //   64	1454	14	localObject11	Object
    //   74	502	15	localObject12	Object
    //   993	31	15	localNullPointerException1	NullPointerException
    //   1546	1	15	localNullPointerException2	NullPointerException
    //   1554	1	15	localNullPointerException3	NullPointerException
    //   14	1369	16	localStringBuilder	StringBuilder
    //   33	668	17	localObject13	Object
    //   580	129	18	localObject14	Object
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
    //   526	538	246	java/io/IOException
    //   545	554	246	java/io/IOException
    //   567	575	246	java/io/IOException
    //   594	604	246	java/io/IOException
    //   611	637	246	java/io/IOException
    //   644	654	246	java/io/IOException
    //   681	688	246	java/io/IOException
    //   700	717	246	java/io/IOException
    //   738	749	246	java/io/IOException
    //   756	785	246	java/io/IOException
    //   792	821	246	java/io/IOException
    //   828	866	246	java/io/IOException
    //   873	882	246	java/io/IOException
    //   889	917	246	java/io/IOException
    //   924	968	246	java/io/IOException
    //   594	604	691	java/lang/Throwable
    //   611	637	691	java/lang/Throwable
    //   681	688	691	java/lang/Throwable
    //   982	986	989	java/io/IOException
    //   35	45	993	java/lang/NullPointerException
    //   1063	1067	1070	java/io/IOException
    //   35	45	1074	finally
    //   973	978	1480	java/io/IOException
    //   296	300	1485	java/io/IOException
    //   305	310	1489	java/io/IOException
    //   1054	1059	1493	java/io/IOException
    //   1086	1091	1498	java/io/IOException
    //   1095	1099	1503	java/io/IOException
    //   45	62	1507	finally
    //   69	76	1515	finally
    //   88	97	1515	finally
    //   113	129	1515	finally
    //   136	143	1515	finally
    //   150	176	1515	finally
    //   183	193	1515	finally
    //   204	210	1515	finally
    //   217	243	1515	finally
    //   371	378	1515	finally
    //   385	398	1515	finally
    //   410	418	1515	finally
    //   425	431	1515	finally
    //   438	453	1515	finally
    //   467	482	1515	finally
    //   489	497	1515	finally
    //   507	514	1515	finally
    //   526	538	1515	finally
    //   545	554	1515	finally
    //   567	575	1515	finally
    //   594	604	1515	finally
    //   611	637	1515	finally
    //   644	654	1515	finally
    //   681	688	1515	finally
    //   700	717	1515	finally
    //   738	749	1515	finally
    //   756	785	1515	finally
    //   792	821	1515	finally
    //   828	866	1515	finally
    //   873	882	1515	finally
    //   889	917	1515	finally
    //   924	968	1515	finally
    //   1007	1037	1515	finally
    //   1044	1049	1515	finally
    //   258	292	1527	finally
    //   45	62	1546	java/lang/NullPointerException
    //   69	76	1554	java/lang/NullPointerException
    //   88	97	1554	java/lang/NullPointerException
    //   113	129	1554	java/lang/NullPointerException
    //   136	143	1554	java/lang/NullPointerException
    //   150	176	1554	java/lang/NullPointerException
    //   183	193	1554	java/lang/NullPointerException
    //   204	210	1554	java/lang/NullPointerException
    //   217	243	1554	java/lang/NullPointerException
    //   371	378	1554	java/lang/NullPointerException
    //   385	398	1554	java/lang/NullPointerException
    //   410	418	1554	java/lang/NullPointerException
    //   425	431	1554	java/lang/NullPointerException
    //   438	453	1554	java/lang/NullPointerException
    //   467	482	1554	java/lang/NullPointerException
    //   489	497	1554	java/lang/NullPointerException
    //   507	514	1554	java/lang/NullPointerException
    //   526	538	1554	java/lang/NullPointerException
    //   545	554	1554	java/lang/NullPointerException
    //   567	575	1554	java/lang/NullPointerException
    //   594	604	1554	java/lang/NullPointerException
    //   611	637	1554	java/lang/NullPointerException
    //   644	654	1554	java/lang/NullPointerException
    //   681	688	1554	java/lang/NullPointerException
    //   700	717	1554	java/lang/NullPointerException
    //   738	749	1554	java/lang/NullPointerException
    //   756	785	1554	java/lang/NullPointerException
    //   792	821	1554	java/lang/NullPointerException
    //   828	866	1554	java/lang/NullPointerException
    //   873	882	1554	java/lang/NullPointerException
    //   889	917	1554	java/lang/NullPointerException
    //   924	968	1554	java/lang/NullPointerException
    //   35	45	1563	java/io/IOException
    //   45	62	1573	java/io/IOException
  }
  
  private void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (new File(paramString).exists())
      {
        FileUtils.deleteFilesInDirectory(paramString);
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
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 122	java/io/File
    //   3: dup
    //   4: getstatic 350	bdkc:e	Ljava/lang/String;
    //   7: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 122	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 451	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 461	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 451	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 464	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 466	java/io/BufferedWriter
    //   68: dup
    //   69: new 468	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 471	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 474	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 477	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 480	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 481	java/io/BufferedWriter:close	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 241
    //   123: iconst_2
    //   124: ldc 188
    //   126: aload_3
    //   127: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ifnull -25 -> 106
    //   134: aload_2
    //   135: invokevirtual 481	java/io/BufferedWriter:close	()V
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
    //   151: invokevirtual 481	java/io/BufferedWriter:close	()V
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
    //   0	176	0	this	bdkc
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
  
  private void i()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(this.jdField_b_of_type_JavaLangString);
    Object localObject2;
    boolean bool;
    if (((localObject1 == null) || (((File)localObject1).list() == null)) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder().append("checkFDCount file:");
      if (localObject1 != null) {
        break label209;
      }
      bool = true;
      QLog.d("FDStats", 2, bool);
    }
    int i;
    int j;
    label308:
    for (;;)
    {
      try
      {
        i = ((File)localObject1).list().length;
      }
      catch (NullPointerException localNullPointerException1)
      {
        label209:
        i = 0;
      }
      try
      {
        StatisticCollector.FDCountLastChecked = i;
        StatisticCollector.FDMillisLastChecked = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 0;
        j = i;
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
        if (j != 0) {
          break label241;
        }
        l2 = ((SharedPreferences)localObject1).getLong("key_last_count_failed_time", 0L);
        if ((System.currentTimeMillis() - l2 > 86400000L) && (l2 != 0L))
        {
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountFailed", true, 0L, 0L, null, null);
          ((SharedPreferences)localObject1).edit().putLong("key_last_count_failed_time", System.currentTimeMillis()).commit();
        }
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
          break label310;
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
      continue;
      label241:
      if (Math.random() <= 0.001D) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label308;
        }
        localObject2 = new HashMap(1);
        ((HashMap)localObject2).put("count", String.valueOf(j));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountSuccess", true, 0L, 0L, (HashMap)localObject2, null);
        break;
      }
    }
    label310:
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
          if (FileUtils.zipFiles((List)localObject1, (String)localObject2)) {
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
        a(e);
        a(jdField_a_of_type_JavaLangString);
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
        break label413;
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
        ((JSONObject)localObject2).put("p_id", MagnifierSDK.b());
        ((JSONObject)localObject2).put("plugin", String.valueOf(137));
        ((JSONObject)localObject2).put("newplugin", String.valueOf(137));
        ((JSONObject)localObject1).put("newplugin", String.valueOf(137));
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
          break label453;
        }
        l1 = Long.parseLong(((QQAppInterface)localObject2).getCurrentUin());
      }
      catch (Exception localException)
      {
        QLog.e("FDStats", 2, "reportFileToAPM get uin " + 0L);
        l1 = 0L;
        continue;
      }
      ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
      localObject1 = a(new Date(StatisticCollector.FDMillisLastChecked));
      bdjw.a(new Exception(String.format("FDStats countLastChecked: %d at %s", new Object[] { Integer.valueOf(StatisticCollector.FDCountLastChecked), localObject1 })), this.d);
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
      label413:
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "no file to report");
      }
      localThrowable.edit().putLong("key_last_report", l1).commit();
      continue;
      label453:
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
    //   3: getfield 309	bdkc:jdField_a_of_type_Int	I
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 186	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_3
    //   16: anewarray 41	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 770
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 772
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 774
    //   36: aastore
    //   37: invokevirtual 777	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +125 -> 167
    //   45: aload_1
    //   46: invokevirtual 211	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: astore_1
    //   50: new 213	java/io/BufferedReader
    //   53: dup
    //   54: new 215	java/io/InputStreamReader
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 218	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: sipush 7777
    //   65: invokespecial 780	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 5
    //   75: aload_3
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload 5
    //   82: ifnull +90 -> 172
    //   85: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +30 -> 118
    //   91: ldc 241
    //   93: iconst_2
    //   94: new 66	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 782
    //   104: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: aload 5
    //   121: invokestatic 785	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: putfield 309	bdkc:jdField_a_of_type_Int	I
    //   127: goto -58 -> 69
    //   130: astore 4
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 241
    //   141: iconst_1
    //   142: ldc 246
    //   144: aload_3
    //   145: invokestatic 766	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 252	java/io/BufferedReader:close	()V
    //   156: aload_2
    //   157: ifnull -148 -> 9
    //   160: aload_2
    //   161: invokevirtual 255	java/io/InputStream:close	()V
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
    //   179: invokevirtual 252	java/io/BufferedReader:close	()V
    //   182: aload_2
    //   183: ifnull -174 -> 9
    //   186: aload_2
    //   187: invokevirtual 255	java/io/InputStream:close	()V
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
    //   203: invokevirtual 252	java/io/BufferedReader:close	()V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 255	java/io/InputStream:close	()V
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
    //   0	274	0	this	bdkc
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
    a(Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/fdmon/");
  }
  
  void f()
  {
    
    arfc localarfc;
    boolean bool;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (FDNative.b()))
    {
      localarfc = (arfc)aqxe.a().a(546);
      if ((localarfc == null) || (localarfc.d != 1)) {
        break label224;
      }
      bool = true;
      if (localarfc == null) {
        break label229;
      }
    }
    label224:
    label229:
    for (int i = localarfc.d;; i = 0)
    {
      QLog.d("FDStats", 1, new Object[] { "startHook shouldHook:", Boolean.valueOf(bool), " fdSwitch:", Integer.valueOf(i) });
      if (bool)
      {
        i = new Random().nextInt(3);
        FDNative.a();
        FDNative.nativeInit(false, true, 1);
        FDNative.a();
        FDNative.nativeRegister(".*\\.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libjavacore.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libEGL.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite_qq.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libBugly-rqd.so$");
        FDNative.a();
        FDNative.nativeStart();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        QLog.d("FDStats", 1, new Object[] { "fd hook start mode:", Integer.valueOf(i) });
      }
      return;
      bool = false;
      break;
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
  
  public void onCallback(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkc
 * JD-Core Version:    0.7.0.1
 */