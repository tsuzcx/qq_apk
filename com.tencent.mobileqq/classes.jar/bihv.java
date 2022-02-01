import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.4;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.5;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bihv
  extends bign
{
  public static long A;
  public static long B;
  public static long C;
  public static long D;
  public static long U;
  public static long V;
  public static long W;
  public static long X;
  public static long Y;
  public static long Z;
  public static HashMap<String, bihw> a;
  public static long aa;
  public static boolean b;
  public static int d;
  public static volatile boolean r;
  public static volatile boolean s;
  public static volatile boolean t;
  public static boolean x;
  public static boolean y;
  public static boolean z;
  public boolean A;
  public boolean B;
  public boolean C;
  private boolean D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q;
  public long R;
  public long S;
  public long T;
  public int a;
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
  public bihx a;
  public Runnable a;
  public String a;
  public List<String> a;
  public JSONObject a;
  public boolean a;
  public long ab;
  public long ac;
  public long ad;
  public long ae;
  public int b;
  public long b;
  public String b;
  private HashMap<String, Long> b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  private int f;
  public long f;
  public String f;
  public boolean f;
  private int g;
  public long g;
  public String g;
  public boolean g;
  private int jdField_h_of_type_Int;
  public long h;
  private String jdField_h_of_type_JavaLangString = "state_activity_init";
  public boolean h;
  public long i;
  private String i;
  public boolean i;
  public long j;
  private String j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  public boolean l;
  public long m;
  public boolean m;
  public long n;
  public boolean n;
  public long o;
  public boolean o;
  public long p;
  boolean p;
  public long q;
  public boolean q;
  public long r;
  public long s;
  public long t = -1L;
  public long u;
  public boolean u;
  public long v;
  public boolean v;
  public long w;
  public boolean w;
  public long x;
  public long y;
  public long z;
  
  static
  {
    jdField_d_of_type_Int = 10;
    jdField_x_of_type_Boolean = bihy.b(1, false);
    jdField_y_of_type_Boolean = bihy.b(2, false);
    jdField_z_of_type_Boolean = bihy.b(4, false);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public bihv()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_q_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(7);
    this.jdField_a_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bihx = new bihx();
  }
  
  /* Error */
  public static Bundle a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 146	android/os/Bundle
    //   6: dup
    //   7: invokespecial 147	android/os/Bundle:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload 4
    //   26: areturn
    //   27: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: aload_0
    //   31: invokevirtual 157	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   34: ifeq +153 -> 187
    //   37: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   40: aload_0
    //   41: invokevirtual 161	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 163	bihw
    //   47: astore_0
    //   48: aload_0
    //   49: getfield 165	bihw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   52: ifnull +63 -> 115
    //   55: aload_0
    //   56: getfield 165	bihw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: ldc 167
    //   61: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore 5
    //   66: new 131	java/util/ArrayList
    //   69: dup
    //   70: aload 5
    //   72: arraylength
    //   73: invokespecial 174	java/util/ArrayList:<init>	(I)V
    //   76: astore 6
    //   78: aload 5
    //   80: arraylength
    //   81: istore_2
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_1
    //   85: iload_2
    //   86: if_icmpge +20 -> 106
    //   89: aload 6
    //   91: aload 5
    //   93: iload_1
    //   94: aaload
    //   95: invokevirtual 177	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   98: pop
    //   99: iload_1
    //   100: iconst_1
    //   101: iadd
    //   102: istore_1
    //   103: goto -19 -> 84
    //   106: aload 4
    //   108: ldc 179
    //   110: aload 6
    //   112: invokevirtual 183	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   115: aload_0
    //   116: getfield 185	bihw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   119: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +14 -> 136
    //   125: aload 4
    //   127: ldc 187
    //   129: aload_0
    //   130: getfield 185	bihw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   133: invokevirtual 191	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: getfield 193	bihw:jdField_b_of_type_Boolean	Z
    //   140: ifeq +50 -> 190
    //   143: iconst_1
    //   144: istore_1
    //   145: aload 4
    //   147: ldc 195
    //   149: iload_1
    //   150: invokevirtual 199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   153: aload_0
    //   154: getfield 201	bihw:jdField_a_of_type_Boolean	Z
    //   157: ifeq +38 -> 195
    //   160: iconst_1
    //   161: istore_1
    //   162: aload 4
    //   164: ldc 203
    //   166: iload_1
    //   167: invokevirtual 199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   170: aload_0
    //   171: getfield 205	bihw:jdField_c_of_type_Boolean	Z
    //   174: ifeq +26 -> 200
    //   177: iconst_1
    //   178: istore_1
    //   179: aload 4
    //   181: ldc 207
    //   183: iload_1
    //   184: invokevirtual 199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   187: goto -166 -> 21
    //   190: iconst_0
    //   191: istore_1
    //   192: goto -47 -> 145
    //   195: iconst_0
    //   196: istore_1
    //   197: goto -35 -> 162
    //   200: iconst_0
    //   201: istore_1
    //   202: goto -23 -> 179
    //   205: astore_0
    //   206: ldc 209
    //   208: iconst_1
    //   209: aload_0
    //   210: iconst_0
    //   211: anewarray 211	java/lang/Object
    //   214: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   217: goto -30 -> 187
    //   220: astore_0
    //   221: ldc 2
    //   223: monitorexit
    //   224: aload_0
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramString	String
    //   83	119	1	i1	int
    //   81	6	2	i2	int
    //   16	2	3	bool	boolean
    //   10	170	4	localBundle	Bundle
    //   64	28	5	arrayOfString	String[]
    //   76	35	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   12	17	205	java/lang/Throwable
    //   27	82	205	java/lang/Throwable
    //   89	99	205	java/lang/Throwable
    //   106	115	205	java/lang/Throwable
    //   115	136	205	java/lang/Throwable
    //   136	143	205	java/lang/Throwable
    //   145	160	205	java/lang/Throwable
    //   162	177	205	java/lang/Throwable
    //   179	187	205	java/lang/Throwable
    //   3	12	220	finally
    //   12	17	220	finally
    //   27	82	220	finally
    //   89	99	220	finally
    //   106	115	220	finally
    //   115	136	220	finally
    //   136	143	220	finally
    //   145	160	220	finally
    //   162	177	220	finally
    //   179	187	220	finally
    //   206	217	220	finally
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    int i1 = paramString.indexOf('?');
    int i2 = paramString.indexOf('#');
    if (i1 == -1)
    {
      i1 = i2;
      if (i2 == -1) {
        i1 = paramString.length();
      }
    }
    while (i1 == 0)
    {
      return "null";
      if (i2 != -1) {
        i1 = Math.min(i1, i2);
      }
    }
    return paramString.substring(0, i1);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = biit.b(paramString1);
    if (("http".equals(str)) || ("https".equals(str))) {
      break label26;
    }
    label26:
    while (!jdField_z_of_type_Boolean) {
      return;
    }
    if (paramString2 == null)
    {
      localObject = null;
      label39:
      if (localObject != null) {
        break label129;
      }
      paramString2 = "";
      label46:
      if (localObject != null) {
        break label137;
      }
    }
    label129:
    label137:
    for (Object localObject = "";; localObject = ((Uri)localObject).getPath())
    {
      bdla.b(null, "dc00899", "WV_Analysis", "", "scheme_call", "total", paramInt, 0, paramString2, (String)localObject, str, biit.d(paramString1));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SwiftBrowserStatistics", 2, new Object[] { "reportScheme ", str, " method:", biit.d(paramString1) });
      return;
      localObject = Uri.parse(paramString2);
      break label39;
      paramString2 = ((Uri)localObject).getHost();
      break label46;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      aady localaady = aady.a();
      localaady.a();
      Bundle localBundle = a(paramString2);
      localBundle.putString("uin", paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        localBundle.putString("title", paramString3);
      }
      localaady.a(2, paramString2, paramString1, localBundle);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 1, paramString1, new Object[0]);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +22 -> 29
    //   10: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +16 -> 29
    //   16: ldc 209
    //   18: iconst_2
    //   19: ldc_w 311
    //   22: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: aload_1
    //   33: invokevirtual 157	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   36: ifne +18 -> 54
    //   39: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: aload_1
    //   43: new 163	bihw
    //   46: dup
    //   47: invokespecial 315	bihw:<init>	()V
    //   50: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   57: aload_1
    //   58: invokevirtual 161	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 163	bihw
    //   64: astore 7
    //   66: aload 7
    //   68: aload_1
    //   69: putfield 320	bihw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: aload_0
    //   73: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +9 -> 85
    //   79: aload 7
    //   81: aload_0
    //   82: putfield 322	bihw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_2
    //   86: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +9 -> 98
    //   92: aload 7
    //   94: aload_2
    //   95: putfield 165	bihw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   98: aload_3
    //   99: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +9 -> 111
    //   105: aload 7
    //   107: aload_3
    //   108: putfield 185	bihw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   111: iload 4
    //   113: ifeq +10 -> 123
    //   116: aload 7
    //   118: iload 4
    //   120: putfield 201	bihw:jdField_a_of_type_Boolean	Z
    //   123: iload 5
    //   125: ifeq +10 -> 135
    //   128: aload 7
    //   130: iload 5
    //   132: putfield 193	bihw:jdField_b_of_type_Boolean	Z
    //   135: aload 7
    //   137: iload 6
    //   139: putfield 205	bihw:jdField_c_of_type_Boolean	Z
    //   142: getstatic 95	bihv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   145: aload_1
    //   146: aload 7
    //   148: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: goto -127 -> 25
    //   155: astore_0
    //   156: ldc 2
    //   158: monitorexit
    //   159: aload_0
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString1	String
    //   0	161	1	paramString2	String
    //   0	161	2	paramString3	String
    //   0	161	3	paramString4	String
    //   0	161	4	paramBoolean1	boolean
    //   0	161	5	paramBoolean2	boolean
    //   0	161	6	paramBoolean3	boolean
    //   64	83	7	localbihw	bihw
    // Exception table:
    //   from	to	target	type
    //   3	25	155	finally
    //   29	54	155	finally
    //   54	85	155	finally
    //   85	98	155	finally
    //   98	111	155	finally
    //   116	123	155	finally
    //   128	135	155	finally
    //   135	152	155	finally
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = true;
    String str = biit.b(paramString);
    boolean bool1;
    if ((!"null".equals(paramString)) && (paramString.length() <= 1024))
    {
      bool1 = bool2;
      if (!"http".equals(str))
      {
        bool1 = bool2;
        if ("https".equals(str)) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "not report url:", paramString });
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        Object localObject = jdField_a_of_type_JavaUtilHashMap;
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
        localObject = ((HashMap)localObject).values();
        if (localObject != null)
        {
          Iterator localIterator = ((Collection)localObject).iterator();
          if (localIterator.hasNext())
          {
            bihw localbihw = (bihw)localIterator.next();
            HashMap localHashMap = new HashMap();
            localHashMap.put("originUrl", localbihw.jdField_a_of_type_JavaLangString);
            localHashMap.put("curUrl", localbihw.jdField_b_of_type_JavaLangString);
            if (!TextUtils.isEmpty(localbihw.jdField_c_of_type_JavaLangString)) {
              localHashMap.put("recognisedText", localbihw.jdField_c_of_type_JavaLangString);
            }
            if (localbihw.jdField_a_of_type_Boolean)
            {
              localObject = "1";
              localHashMap.put("passwdTyped", localObject);
              if (!localbihw.jdField_b_of_type_Boolean) {
                break label202;
              }
              localObject = "1";
              localHashMap.put("showPasswd", localObject);
              StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "wvAntiPasswd", true, 0L, 0L, localHashMap, "");
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SwiftBrowserStatistics", 2, localThrowable, new Object[0]);
      }
      do
      {
        str = "0";
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SwiftBrowserStatistics", 2, "nothing to report");
      return;
      label202:
      String str = "0";
    }
  }
  
  private void c()
  {
    if (!bdku.jdField_a_of_type_Boolean)
    {
      bdkv localbdkv = new bdkv();
      localbdkv.jdField_e_of_type_JavaLangString = "0X8009242";
      localbdkv.jdField_d_of_type_JavaLangString = "离开点击Push";
      bdku.a(this.jdField_d_of_type_JavaLangString, localbdkv);
      bdku.a(null, localbdkv);
      bdku.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    if (!bdku.jdField_a_of_type_Boolean) {
      awtm.a(null, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, "0X8009242", "离开点击Push");
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApplication() == null)) {}
    for (;;)
    {
      return null;
      Object localObject = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      paramAppInterface = new File((File)localObject, "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface);
      if (!paramAppInterface.exists()) {}
      try
      {
        paramAppInterface.createNewFile();
        paramAppInterface = FileUtils.fileToBytes(paramAppInterface);
        if (paramAppInterface != null) {
          localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom(paramAppInterface);
            return localObject;
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {}
    for (paramAppRuntime = (AppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramAppRuntime == null) {
        return "";
      }
      String str = paramAppRuntime.getApp().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
      if (!"".equals(str))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null) {
          break label212;
        }
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime == null) {
          break label212;
        }
        Iterator localIterator = paramAppRuntime.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!paramAppRuntime.path.get().equals(str));
      }
      for (;;)
      {
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.missions.get();
          if (paramAppRuntime != null)
          {
            int i1 = 0;
            while (i1 < paramAppRuntime.size())
            {
              localStringBuilder.append((String)paramAppRuntime.get(i1));
              if (i1 != paramAppRuntime.size() - 1) {
                localStringBuilder.append("_");
              }
              i1 += 1;
            }
          }
        }
        return localStringBuilder.toString();
        label212:
        paramAppRuntime = null;
      }
    }
  }
  
  public void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + localAppRuntime.getLongAccountUin(), 4);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_d_of_type_Long;
      bdla.b(null, "dc00899", "grp_lbs", "", this.jdField_a_of_type_JavaLangString, "visit_time", 0, 1, 0, "" + localSharedPreferences.getInt("charm_level", 0), "" + localSharedPreferences.getInt("gender", 0), "" + (l1 - l2), "");
    }
    if (((this.jdField_g_of_type_Boolean) || (this.jdField_D_of_type_Boolean)) && (!this.jdField_k_of_type_Boolean) && (!bdku.jdField_a_of_type_Boolean)) {
      ThreadManager.getFileThreadHandler().postDelayed(new SwiftBrowserStatistics.2(this, localAppRuntime), 1000L);
    }
  }
  
  public void a(Context paramContext, bihx parambihx)
  {
    paramContext = new File(paramContext.getFilesDir(), bhln.e.jdField_a_of_type_JavaLangString);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.readFileContent(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i1 = paramContext.getInt("sample_rate");
        bihx.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i1));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int i2 = localJSONArray.length();
        i1 = 0;
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          bihx.jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i1 += 1;
        }
        parambihx.jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowser", 2, "" + paramContext);
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_Bihx.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_Bihx.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    String str3 = "UNKNOWN";
    try
    {
      int i1 = NetworkUtil.getSystemNetwork(paramContext);
      str1 = str3;
      if (i1 != -1)
      {
        str1 = str3;
        if (i1 < AppConstants.NET_TYPE_NAME.length) {
          str1 = AppConstants.NET_TYPE_NAME[i1];
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2 = "UNKNOWN";
      }
    }
    ThreadManager.post(new SwiftBrowserStatistics.4(this, paramString, paramIntent, paramContext, System.currentTimeMillis(), str1), 5, null, false);
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_i_of_type_Long = System.nanoTime();
    this.jdField_c_of_type_Long = paramIntent.getLongExtra("qqBrowserActivityCreateTime", -1L);
    if (this.jdField_c_of_type_Long <= 0L) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    this.F = SystemClock.elapsedRealtime();
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mOnCreateMilliTimeStamp = " + this.jdField_c_of_type_Long);
    this.jdField_a_of_type_Bihx.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bihx.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("startOpenPageTime", -1L);
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mClickTime = " + this.jdField_b_of_type_Long);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("op_type");
    this.p = paramIntent.getBooleanExtra("reportMsfLog", false);
    this.n = paramIntent.getBooleanExtra("fromAio", false);
    paramIntent.getBooleanExtra("fromPublicAccount", false);
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
    }
    GameCenterActivity.a(paramString, 1, false, false);
    this.jdField_k_of_type_Long = paramIntent.getLongExtra("plugin_start_time", 0L);
    this.jdField_l_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    this.jdField_q_of_type_Boolean = paramIntent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
    if (this.jdField_k_of_type_Long > 0L) {
      paramIntent.putExtra("plugin_start_time", 0L);
    }
    if (this.jdField_l_of_type_Long > 0L) {
      paramIntent.putExtra("click_start_time", 0L);
    }
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("is_from_leba", false);
    this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    this.jdField_a_of_type_Bihx.jdField_a_of_type_Boolean = this.jdField_f_of_type_Boolean;
    boolean bool;
    label352:
    int i1;
    label520:
    int i2;
    label530:
    int i3;
    label540:
    long l1;
    if (paramIntent.getIntExtra("uintype", -1) == 1030)
    {
      bool = true;
      this.jdField_g_of_type_Boolean = bool;
      if (paramIntent.getIntExtra("uintype", -1) != 1035) {
        break label932;
      }
      bool = true;
      this.jdField_D_of_type_Boolean = bool;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_service_id");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_content_id");
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("KEY_SUB_BUSINESS_ID", 0);
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("KEY_PUSH_ID", 0);
      ayoh.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_D_of_type_Boolean)) {
        bdku.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_i_of_type_Long);
      }
      if (WebAccelerateHelper.isWebViewCache)
      {
        this.jdField_w_of_type_Boolean = true;
        QLog.d("SwiftBrowserStatistics", 1, "onCreate, isWebViewCache = true");
      }
      this.M = System.currentTimeMillis();
      if (!s) {
        break label938;
      }
      i1 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label943;
      }
      i2 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label949;
      }
      i3 = 1;
      this.jdField_c_of_type_Int = (i3 + ((i1 << 2) + (i2 << 1)));
      this.jdField_e_of_type_JavaLangString = a(paramString);
      this.jdField_f_of_type_JavaLangString = HttpUtil.getNetWorkTypeByStr();
      if (jdField_x_of_type_Boolean)
      {
        if (this.jdField_l_of_type_Long <= 0L) {
          break label955;
        }
        l1 = this.jdField_c_of_type_Long - this.jdField_l_of_type_Long;
        label596:
        a("process_init", l1, "0");
      }
      this.E = paramIntent.getLongExtra("StartClickTime", 0L);
      paramIntent.removeExtra("StartClickTime");
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)) {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("StartClickTime");
      }
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("SourceActivityName");
      if (this.E <= 0L)
      {
        this.E = this.F;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserStatistics", 4, "reportTime mClickUrlMilliTime=" + this.E);
        }
        a(paramString, "ClickTime", this.E + "");
      }
      if (this.F - this.E > 10000L) {
        a(paramString, "CreateActivity", this.F - this.E + "");
      }
      if (jdField_A_of_type_Long <= this.E) {
        break label961;
      }
      bool = true;
      label815:
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break label967;
      }
    }
    label932:
    label938:
    label943:
    label949:
    label955:
    label961:
    label967:
    for (this.H = (jdField_A_of_type_Long - this.E);; this.H = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "mClickUrlMilliTime: ", Long.valueOf(this.E), " mSourceActivityClassName:", this.jdField_c_of_type_JavaLangString, " mProcessLaunchMilliTime:", Long.valueOf(jdField_A_of_type_Long), " mIsColdLaunch:", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      return;
      bool = false;
      break;
      bool = false;
      break label352;
      i1 = 0;
      break label520;
      i2 = 0;
      break label530;
      i3 = 0;
      break label540;
      l1 = 0L;
      break label596;
      bool = false;
      break label815;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramTouchWebView.getPluginEngine();
    if (localObject != null)
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject == null) || (!(localObject instanceof aarc))) {}
    }
    for (localObject = (aarc)localObject;; localObject = null)
    {
      if ((localObject != null) && (((aarc)localObject).a() != null)) {}
      for (localObject = ((aarc)localObject).a();; localObject = "")
      {
        int i1;
        int i2;
        label74:
        String str2;
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          i1 = 3;
          i2 = 0;
          if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label249;
          }
          str2 = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
          if (i2 != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break label234;
          }
          paramTouchWebView = String.valueOf(paramInt);
          label125:
          if (str2 == null) {
            break label241;
          }
        }
        label234:
        label241:
        for (String str1 = str2;; str1 = "unknown")
        {
          VasWebviewUtil.reportQBWebInfo((String)localObject, "qbweb_load_redirect", "", str1.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", paramTouchWebView);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "url=" + str2 + ", rlt=" + paramTouchWebView);
          }
          i2 += 1;
          break label74;
          i1 = 1;
          break;
          paramTouchWebView = "10001";
          break label125;
        }
        label249:
        this.jdField_a_of_type_JavaUtilList.clear();
        if (beeg.a(paramString2)) {
          beeg.a(null, beeg.c(paramString2), "0X8009E9F", "fail", beeg.d(paramString2), "err=" + paramInt);
        }
        beeg.b(paramString2, "SwiftBrowserStatistics", "web_loaded_url_err", "errorCode = " + paramInt + " description = " + paramString1);
        beeg.b(paramString2, "SwiftBrowserStatistics", "failingUrl", paramString2);
        beeg.b(paramString2, "SwiftBrowserStatistics", "cookie");
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    if (paramTouchWebView == null) {
      return;
    }
    Object localObject1 = paramTouchWebView.getPluginEngine();
    if (localObject1 != null)
    {
      localObject1 = ((WebViewPluginEngine)localObject1).a("offline");
      if ((localObject1 == null) || (!(localObject1 instanceof aarc))) {}
    }
    for (localObject1 = (aarc)localObject1;; localObject1 = null)
    {
      if ((localObject1 != null) && (((aarc)localObject1).a() != null)) {}
      for (localObject1 = ((aarc)localObject1).a();; localObject1 = "")
      {
        long l1;
        try
        {
          if ((this.jdField_d_of_type_JavaLangString.startsWith("http://")) || (paramString.startsWith("http://")))
          {
            localObject2 = new HashMap(2);
            ((HashMap)localObject2).put("url", paramString);
            ((HashMap)localObject2).put("first_url", this.jdField_d_of_type_JavaLangString);
            if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null))
            {
              localObject3 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
              i1 = ((Intent)localObject3).getIntExtra("articalChannelId", 100);
              boolean bool = ((Intent)localObject3).getBooleanExtra("fromAio", false);
              localObject3 = ((Intent)localObject3).getStringExtra("SourceActivityName");
              ((HashMap)localObject2).put("fromChannel", String.valueOf(i1));
              ((HashMap)localObject2).put("fromAIO", String.valueOf(bool));
              ((HashMap)localObject2).put("fromAct", localObject3);
            }
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "actWVHttpReport", true, 0L, 0L, (HashMap)localObject2, "");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            QLog.e("SwiftBrowserStatistics", 1, localThrowable, new Object[0]);
            continue;
            int i1 = 0;
            continue;
            int i2 = 0;
            continue;
            i1 = 1;
            continue;
            paramTouchWebView = "unknown";
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          if ((!this.jdField_j_of_type_Boolean) || (!this.n) || (this.o)) {
            break label779;
          }
          this.o = true;
          if (paramString == null) {
            break label866;
          }
          paramTouchWebView = paramString;
          bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, nwo.b(URLEncoder.encode(paramTouchWebView), new String[0]), "", "", "" + this.jdField_c_of_type_Int);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          localObject2 = HttpUtil.getNetWorkType() + "";
          l1 = (System.nanoTime() - this.jdField_j_of_type_Long) / 1000000L;
          if (!WebProcessManager.b()) {
            break label657;
          }
          i1 = 1;
          localObject3 = new StringBuilder();
          if (!this.jdField_w_of_type_Boolean) {
            break label662;
          }
          i2 = 1;
          bdla.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, (String)localObject2, String.valueOf(l1), String.valueOf(i1), String.valueOf(i2) + ", " + (String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - this.jdField_j_of_type_Long) / 1000000L + ", url = " + nwo.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean + ", " + (String)localObject1);
          }
        }
        if ((this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          b(paramString);
          if (paramTouchWebView.getX5WebViewExtension() != null)
          {
            i1 = 3;
            localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label680;
              }
              localObject2 = (String)((Iterator)localObject3).next();
              if (localObject2 == null) {
                break;
              }
              paramTouchWebView = (TouchWebView)localObject2;
              VasWebviewUtil.reportQBWebInfo((String)localObject1, "qbweb_load_redirect", "", paramTouchWebView.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", "10000");
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "url=" + (String)localObject2 + ", rlt=" + "10000");
              }
            }
          }
        }
        label657:
        label662:
        label680:
        while (beeg.a(paramString))
        {
          l1 = beeg.a(String.valueOf(this.jdField_j_of_type_Long));
          paramTouchWebView = beeg.d(paramString);
          paramString = beeg.c(paramString);
          if (l1 != 0L)
          {
            beeg.a(null, paramString, "0X8009E9F", "success", paramTouchWebView, "");
            beeg.a(null, paramString, "0X8009E9E", String.valueOf(l1), paramTouchWebView, "");
          }
          if (!TextUtils.isEmpty(paramString)) {
            break label873;
          }
          beeg.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(l1));
          return;
          label866:
          paramTouchWebView = "unknown";
        }
        label779:
        break;
        label873:
        beeg.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(l1), paramString);
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.post(new SwiftBrowserStatistics.5(this, paramTouchWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if ("about:blank".equalsIgnoreCase(paramString)) {
      break label10;
    }
    label10:
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_j_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bihx.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Bihx.jdField_a_of_type_Long = System.currentTimeMillis();
    this.ab = (this.jdField_a_of_type_Bihx.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.jdField_a_of_type_Bihx.jdField_a_of_type_Int + ", asyncMode: " + this.jdField_b_of_type_Int + ", stepTime: " + this.ab + ", totalTime: " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "\n" + paramString);
    }
    int i3;
    String str1;
    String str2;
    int i1;
    if ((this.jdField_i_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
    {
      i3 = (int)((this.jdField_j_of_type_Long - this.jdField_i_of_type_Long) / 1000000L);
      str1 = HttpUtil.getNetWorkType() + "";
      str2 = "" + i3;
      if (!WebProcessManager.b()) {
        break label448;
      }
      i1 = 1;
      label234:
      if (!this.jdField_w_of_type_Boolean) {
        break label453;
      }
    }
    label448:
    label453:
    for (int i2 = 1;; i2 = 0)
    {
      bdla.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, str1, str2, String.valueOf(i1), String.valueOf(i2));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + i3 + ", url = " + nwo.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean);
      }
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      if ((this.p) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new SwiftBrowserStatistics.1(this);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (!beeg.a(paramString)) {
        break;
      }
      beeg.a("SwiftBrowserStatistics", "onPageStarted_url", paramString);
      beeg.a(String.valueOf(this.jdField_j_of_type_Long));
      return;
      i1 = 0;
      break label234;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while ((!this.jdField_i_of_type_Boolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new SwiftBrowserStatistics.3(this, paramString, paramInt, paramString, paramInt), 5, null, false);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if ((beeg.a(this.jdField_d_of_type_JavaLangString)) && (TextUtils.equals(paramString1, "webview_init"))) {
      beeg.a(null, beeg.c(this.jdField_d_of_type_JavaLangString), "0X8009E9D", String.valueOf(paramLong), beeg.d(this.jdField_d_of_type_JavaLangString), "err=" + paramString2);
    }
    beeg.b(this.jdField_d_of_type_JavaLangString, "SwiftBrowserStatistics", paramString1, String.valueOf(paramLong));
    String str = this.jdField_e_of_type_JavaLangString;
    int i1;
    int i2;
    if (this.jdField_A_of_type_Boolean)
    {
      i1 = 1;
      if (!this.jdField_B_of_type_Boolean) {
        break label164;
      }
      i2 = 2;
      label106:
      if (!this.jdField_C_of_type_Boolean) {
        break label170;
      }
    }
    label164:
    label170:
    for (int i3 = 4;; i3 = 0)
    {
      bdla.b(null, "dc00899", "WV_Analysis", "", paramString1, str, i2 | i1 | i3, (int)paramLong, String.valueOf(this.jdField_e_of_type_Int), this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, paramString2);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label106;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      paramString1 = a(paramString1);
      if (!a(paramString1)) {
        return;
      }
      localHashMap.put("url", paramString1);
      localHashMap.put(paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportErrorScene: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "actWvReportError", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 2, paramString1, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("DETAIL");
        boolean bool = localJSONObject.optBoolean("is_first_init_tbs");
        long l1 = localJSONObject.optLong("init_x5_core_begin");
        long l2 = localJSONObject.optLong("init_x5_core_end");
        long l3 = localJSONObject.optLong("webview_init_begin");
        long l4 = localJSONObject.optLong("webview_init_end");
        long l5 = localJSONObject.optLong("tbslog_init_begin");
        long l6 = localJSONObject.optLong("tbslog_init_end");
        long l7 = localJSONObject.optLong("init_all_begin");
        long l8 = localJSONObject.optLong("init_all_end");
        long l9 = localJSONObject.optLong("tbs_load_so_begin");
        long l10 = localJSONObject.optLong("tbs_load_so_end");
        this.v = (l2 - l1);
        this.jdField_w_of_type_Long = (l4 - l3);
        this.jdField_x_of_type_Long = (l10 - l9);
        this.jdField_y_of_type_Long = (l6 - l5);
        this.jdField_z_of_type_Long = (l8 - l7);
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "performance: ", paramJSONObject.toString() });
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "firstInitTbs: ", Boolean.valueOf(bool), " x5core: ", Long.valueOf(this.v), " webview: ", Long.valueOf(this.jdField_w_of_type_Long), " loadSo:", Long.valueOf(this.jdField_x_of_type_Long), " tbsLog:", Long.valueOf(this.jdField_y_of_type_Long), " initAll:", Long.valueOf(this.jdField_z_of_type_Long) });
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("SwiftBrowserStatistics", 1, new Object[] { "exception ", paramJSONObject.toString() });
      }
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (!jdField_x_of_type_Boolean) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = a(paramString);
    } while (!a(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", paramIntent.getStringExtra("SourceActivityName"));
    if (jdField_A_of_type_Long > this.E) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (String)paramIntent.next();
        localHashMap.put(paramString, ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue() - this.E + "");
      }
    }
    localHashMap.put("bounce_rate_state", this.jdField_h_of_type_JavaLangString);
    localHashMap.put("is_cold_launch", "" + bool);
    localHashMap.put("network_type", HttpUtil.getNetWorkTypeByStr());
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.g());
    localHashMap.put("use_offline_package", jdField_b_of_type_Boolean + "");
    localHashMap.put("use_sonic", this.jdField_d_of_type_Boolean + "");
    localHashMap.put("use_pre_load", "" + s);
    paramIntent = new StringBuilder();
    if (jdField_D_of_type_Long > this.E) {}
    for (bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("core_type", this.jdField_e_of_type_Int + "");
      localHashMap.put("activity_create_final", String.valueOf(this.G - this.F));
      localHashMap.put("origin_url", this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.jdField_a_of_type_JavaUtilList.size());
        localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportBounceRate: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "webviewBounceRateCollection", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (!jdField_x_of_type_Boolean) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = a(paramString);
    } while (!a(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("process_start_spending_time", String.valueOf(this.H));
    localHashMap.put("init_tbs_time", String.valueOf(this.jdField_y_of_type_Long));
    localHashMap.put("init_x5_core_time", String.valueOf(this.v));
    localHashMap.put("init_x5_webview_time", String.valueOf(this.jdField_w_of_type_Long));
    localHashMap.put("init_tbs_so_time", String.valueOf(this.jdField_x_of_type_Long));
    localHashMap.put("init_all_time", String.valueOf(this.jdField_z_of_type_Long));
    localHashMap.put("activity_on_create_time", String.valueOf(this.F - this.E));
    localHashMap.put("is_cold_launch", "" + this.jdField_c_of_type_Boolean);
    localHashMap.put("network_type", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.g());
    localHashMap.put("use_offline_package", jdField_b_of_type_Boolean + "");
    localHashMap.put("use_sonic", this.jdField_d_of_type_Boolean + "");
    localHashMap.put("use_pre_load", "" + s);
    paramString = new StringBuilder();
    if (jdField_D_of_type_Long > this.E) {}
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("webview_create_time", String.valueOf(this.I));
      localHashMap.put("core_type", String.valueOf(this.jdField_e_of_type_Int));
      localHashMap.put("fragment_create_final", String.valueOf(this.G - this.F));
      localHashMap.put("browser_act_create_cost", String.valueOf(this.G - jdField_B_of_type_Long));
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.jdField_a_of_type_JavaUtilList.size());
        localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
      }
      localHashMap.put("int_tbs_env", String.valueOf(biis.jdField_a_of_type_Long));
      localHashMap.put("init_plugin", String.valueOf(jdField_C_of_type_Long));
      localHashMap.put("fragment_create_time", String.valueOf(this.F - jdField_B_of_type_Long));
      localHashMap.put("step_initUIFrame", String.valueOf(this.J));
      localHashMap.put("step_initUIContent", String.valueOf(this.L));
      localHashMap.put("step_initTitleBar", String.valueOf(this.K));
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "webviewSpendingTimeCollection: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "webviewSpendingTimeCollection", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (paramString.equals("state_back")) {
      if (!this.jdField_h_of_type_JavaLangString.equals("state_final")) {
        this.jdField_b_of_type_JavaUtilHashMap.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
      }
    }
    int i1;
    int i2;
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(0, "state_activity_init");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(1, "state_activity_create");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(2, "state_webview_create");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(3, "state_load_url");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(4, "state_activity_first_line");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(5, "state_first_screen");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(6, "state_page_finished");
        this.jdField_a_of_type_AndroidUtilSparseArray.put(7, "state_final");
      }
      i1 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramString);
      i2 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(this.jdField_h_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "setBounceRateState state=" + paramString + " mCurr=" + this.jdField_h_of_type_JavaLangString);
      }
    } while (i1 <= i2);
    this.jdField_h_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_h_of_type_JavaLangString, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.m) {
        bdla.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", paramString.getQueryParameter("appid"), (int)((System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L) + "", paramString.getQueryParameter("group_openid"));
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L + ", url = " + nwo.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {
      c();
    }
  }
  
  public void didBindContext()
  {
    super.didBindContext();
    this.jdField_a_of_type_AndroidAppActivity = this.mComponentContext.a();
  }
  
  public void e(String paramString)
  {
    QLog.i("SwiftBrowserStatistics", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
    this.t = System.currentTimeMillis();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void onLifeCycleStateChanged(int paramInt, Bundle paramBundle)
  {
    super.onLifeCycleStateChanged(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      label73:
      long l1;
      long l2;
      int i1;
      if (this.jdField_k_of_type_Long > 0L)
      {
        paramInt = (int)((this.jdField_i_of_type_Long - this.jdField_k_of_type_Long) / 1000000L);
        if (this.jdField_i_of_type_Boolean)
        {
          paramBundle = HttpUtil.getNetWorkType() + "";
          l1 = System.currentTimeMillis();
          l2 = this.jdField_l_of_type_Long;
          if (!WebProcessManager.b()) {
            break label280;
          }
          i1 = 1;
          label121:
          if (!this.jdField_w_of_type_Boolean) {
            break label285;
          }
        }
      }
      label280:
      label285:
      for (int i2 = 1;; i2 = 0)
      {
        bdla.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i1), String.valueOf(i2));
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("web_report", 4, "web_before_create, cost = " + paramInt + ", url = " + nwo.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean + ", isProgressCreate = " + s + ", flag=" + this.jdField_c_of_type_Int);
        return;
        paramInt = 0;
        break label73;
        i1 = 0;
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
      a();
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("url")))
      {
        d(paramBundle.getString("url"));
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("url")))
        {
          a(paramBundle.getString("url"));
          return;
          if ((paramBundle != null) && (paramBundle.containsKey("url"))) {}
          for (paramBundle = paramBundle.getString("url"); !TextUtils.isEmpty(paramBundle); paramBundle = "")
          {
            a((TouchWebView)this.mComponentContext.a(), paramBundle);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihv
 * JD-Core Version:    0.7.0.1
 */