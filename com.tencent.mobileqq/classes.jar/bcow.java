import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.DebugActivity;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector.1;
import com.tencent.mobileqq.startup.director.StartupDirector.2;
import com.tencent.mobileqq.startup.director.StartupDirector.3;
import com.tencent.mobileqq.startup.director.StartupDirector.5;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bcow
  implements Handler.Callback
{
  public static int a;
  public static Set<Integer> a;
  public static boolean a;
  public static final int[] a;
  public static int b;
  public static boolean b;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 1, 6, 9, 15 };
  public static int c;
  public static boolean c;
  private static final int[] c;
  public static int d;
  public static long d;
  public static boolean d;
  private static final int[] d;
  public static long e;
  public static boolean e;
  private static final int[] jdField_e_of_type_ArrayOfInt;
  public static long f;
  public static boolean f;
  private static final int[] jdField_f_of_type_ArrayOfInt;
  public static long g;
  public static boolean g;
  private static final int[] jdField_g_of_type_ArrayOfInt;
  public static long h;
  public static boolean h;
  private static final int[] jdField_h_of_type_ArrayOfInt;
  public static boolean i;
  private static final int[] jdField_i_of_type_ArrayOfInt;
  public static boolean j;
  private static final int[] jdField_j_of_type_ArrayOfInt;
  private static long jdField_k_of_type_Long;
  public static boolean k;
  private static final int[] jdField_k_of_type_ArrayOfInt;
  public static boolean l;
  private static final int[] l;
  private static final int[] jdField_m_of_type_ArrayOfInt;
  private static final int[] n;
  private static final int[] o;
  private static final int[] p;
  private static final int[] q;
  private static final int[] r;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bcox jdField_a_of_type_Bcox;
  private CheckPermission jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission;
  private ArrayList<WeakReference<AppActivity>> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
  public AppActivity a;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public long c;
  private int jdField_e_of_type_Int = -1;
  private int jdField_f_of_type_Int;
  private int jdField_g_of_type_Int;
  private int jdField_h_of_type_Int = -1;
  private long jdField_i_of_type_Long;
  private long jdField_j_of_type_Long;
  private boolean jdField_m_of_type_Boolean;
  
  static
  {
    jdField_c_of_type_ArrayOfInt = new int[] { 5, 7 };
    jdField_d_of_type_ArrayOfInt = new int[] { 11, 12, 17, 18 };
    jdField_e_of_type_ArrayOfInt = new int[] { 13, 11, 12, 17 };
    jdField_f_of_type_ArrayOfInt = new int[] { 7, 19 };
    jdField_g_of_type_ArrayOfInt = new int[] { 13, 11, 17 };
    jdField_h_of_type_ArrayOfInt = jdField_f_of_type_ArrayOfInt;
    jdField_i_of_type_ArrayOfInt = new int[] { 32, 5, 10 };
    jdField_j_of_type_ArrayOfInt = new int[] { 14, 5, 11, 10 };
    jdField_a_of_type_ArrayOfInt = new int[] { 14, 5, 11, 10 };
    jdField_k_of_type_ArrayOfInt = new int[] { 14 };
    jdField_l_of_type_ArrayOfInt = new int[] { 5, 10, 8, 20 };
    jdField_m_of_type_ArrayOfInt = new int[] { 13, 5 };
    n = new int[] { 13, 5, 14, 12, 10 };
    o = new int[] { 13, 5, 14, 12, 21 };
    p = new int[] { 13, 5, 14, 12 };
    q = new int[] { 30, 33 };
    r = new int[] { 5, 14, 8, 12, 10 };
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_j_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_h_of_type_Long = -1L;
  }
  
  /* Error */
  private final int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: new 113	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 119	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc 121
    //   24: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 9
    //   29: iload 4
    //   31: istore_3
    //   32: aload 9
    //   34: invokevirtual 128	java/io/File:exists	()Z
    //   37: ifeq +49 -> 86
    //   40: new 130	java/io/BufferedInputStream
    //   43: dup
    //   44: new 132	java/io/FileInputStream
    //   47: dup
    //   48: aload 9
    //   50: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 138	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: aload 5
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 142	java/io/BufferedInputStream:read	()I
    //   66: istore_3
    //   67: iload_3
    //   68: iconst_m1
    //   69: if_icmpne +228 -> 297
    //   72: iload_2
    //   73: istore_3
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   84: iload_2
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: aload 8
    //   92: astore_1
    //   93: new 147	java/io/FileOutputStream
    //   96: dup
    //   97: aload 9
    //   99: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore 5
    //   104: aload 5
    //   106: iload_2
    //   107: invokevirtual 151	java/io/FileOutputStream:write	(I)V
    //   110: aload 5
    //   112: ifnull +8 -> 120
    //   115: aload 5
    //   117: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   127: iload_2
    //   128: istore_3
    //   129: goto -43 -> 86
    //   132: astore 6
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: astore_1
    //   140: aload 6
    //   142: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   145: iload 4
    //   147: istore_3
    //   148: aload 5
    //   150: ifnull -64 -> 86
    //   153: aload 5
    //   155: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   158: iload 4
    //   160: istore_3
    //   161: goto -75 -> 86
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -86 -> 86
    //   175: astore_1
    //   176: aload 6
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore 5
    //   194: aload 5
    //   196: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   199: goto -9 -> 190
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   207: iload_2
    //   208: ireturn
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 5
    //   217: astore_1
    //   218: aload 6
    //   220: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull -105 -> 120
    //   228: aload 5
    //   230: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   233: iload_2
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   240: iload_2
    //   241: ireturn
    //   242: astore 6
    //   244: aload_1
    //   245: astore 5
    //   247: aload 6
    //   249: astore_1
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore 5
    //   264: aload 5
    //   266: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   269: goto -9 -> 260
    //   272: astore_1
    //   273: goto -23 -> 250
    //   276: astore 6
    //   278: goto -63 -> 215
    //   281: astore 6
    //   283: aload_1
    //   284: astore 5
    //   286: aload 6
    //   288: astore_1
    //   289: goto -109 -> 180
    //   292: astore 6
    //   294: goto -157 -> 137
    //   297: iload_3
    //   298: istore_2
    //   299: goto -227 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	bcow
    //   0	302	1	paramContext	android.content.Context
    //   13	286	2	i1	int
    //   31	267	3	i2	int
    //   10	160	4	i3	int
    //   56	130	5	localObject1	Object
    //   192	3	5	localIOException1	java.io.IOException
    //   213	43	5	localObject2	Object
    //   262	3	5	localIOException2	java.io.IOException
    //   284	1	5	localContext	android.content.Context
    //   7	1	6	localObject3	Object
    //   132	45	6	localException1	Exception
    //   209	10	6	localIOException3	java.io.IOException
    //   242	6	6	localObject4	Object
    //   276	1	6	localIOException4	java.io.IOException
    //   281	6	6	localObject5	Object
    //   292	1	6	localException2	Exception
    //   1	211	7	localObject6	Object
    //   4	87	8	localObject7	Object
    //   27	71	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	84	122	java/io/IOException
    //   40	58	132	java/lang/Exception
    //   153	158	164	java/io/IOException
    //   40	58	175	finally
    //   185	190	192	java/io/IOException
    //   115	120	202	java/io/IOException
    //   93	104	209	java/io/IOException
    //   228	233	235	java/io/IOException
    //   93	104	242	finally
    //   218	223	242	finally
    //   255	260	262	java/io/IOException
    //   104	110	272	finally
    //   104	110	276	java/io/IOException
    //   61	67	281	finally
    //   140	145	281	finally
    //   61	67	292	java/lang/Exception
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("perf_config", 4);
  }
  
  public static bcow a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    bcow localbcow = new bcow();
    localbcow.a(0);
    bcrg.b(0, localbcow, jdField_b_of_type_ArrayOfInt).step();
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      DebugActivity.startNetworkPolicy();
      label50:
      if (BaseApplicationImpl.sProcessId == 1)
      {
        localbcow.a(1);
        return localbcow;
      }
      if (BaseApplicationImpl.sProcessId == 6)
      {
        jdField_a_of_type_Boolean = false;
        return localbcow;
      }
      jdField_a_of_type_Boolean = false;
      bcrg.b(13, localbcow, null).step();
      if (BaseApplicationImpl.sProcessId == 2)
      {
        bcrg.b(11, localbcow, null).step();
        bcrg.b(40, localbcow, null).step();
        ThreadManager.post(bcrg.b(0, localbcow, jdField_l_of_type_ArrayOfInt), 10, null, false);
        bcrg.b(0, localbcow, jdField_k_of_type_ArrayOfInt).step();
      }
      for (;;)
      {
        return null;
        if (BaseApplicationImpl.sProcessId == 10)
        {
          bcrg.b(0, localbcow, r).step();
        }
        else if ((BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7))
        {
          bcrg.b(11, localbcow, null).step();
          bcrg.b(8, localbcow, null).step();
          bcrg.b(0, localbcow, jdField_i_of_type_ArrayOfInt).step();
          bcrg.b(12, localbcow, null).step();
          bcrg.b(47, localbcow, null).step();
          if (BaseApplicationImpl.sProcessId == 7) {
            bcrg.b(49, localbcow, null).step();
          }
        }
        else if (BaseApplicationImpl.processName.endsWith(":secmsg"))
        {
          bcrg.b(12, localbcow, null).step();
        }
        else if (!BaseApplicationImpl.processName.endsWith(":qqfav"))
        {
          if (BaseApplicationImpl.processName.endsWith(":peak"))
          {
            ThreadManager.excute(bcrg.b(0, localbcow, jdField_a_of_type_ArrayOfInt), 16, null, false);
          }
          else
          {
            if (!BaseApplicationImpl.processName.endsWith(":picture")) {
              break;
            }
            bcrg.b(11, localbcow, null).step();
          }
        }
      }
      if (BaseApplicationImpl.processName.endsWith(":troopbar"))
      {
        bcrg.b(12, localbcow, null).step();
        bcrg.b(11, localbcow, null).step();
        bcrg.b(14, localbcow, null).step();
      }
      for (;;)
      {
        if (BaseApplicationImpl.processName.endsWith(":troophomework")) {
          bcrg.b(38, localbcow, null).step();
        }
        if (!BaseApplicationImpl.processName.endsWith(":live")) {
          break;
        }
        bcrg.b(48, localbcow, null).step();
        break;
        bcrg.b(0, localbcow, jdField_j_of_type_ArrayOfInt).step();
      }
    }
    catch (Throwable localThrowable)
    {
      break label50;
    }
  }
  
  public static void a()
  {
    int i2 = 0;
    if ((!jdField_k_of_type_Boolean) && (BaseApplicationImpl.sProcessId == 1)) {}
    for (;;)
    {
      try
      {
        localObject = a();
        bool = bgln.g();
        jdField_h_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("enable_thread_suspend", false);
        jdField_i_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("fake_enable_thread_suspend", false);
        jdField_j_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("suspendWhiteListOnly", true);
        SuspendThreadManager.a().a();
        if (!bool) {
          return;
        }
        if (bool) {
          jdField_l_of_type_Boolean = true;
        }
        jdField_d_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablepreloadproc_new", false);
        jdField_c_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablegettrooplist_new", false);
        jdField_e_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablepredownload_new", false);
        jdField_f_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("enableautoperf_new", false);
        if ((jdField_d_of_type_Boolean) || (jdField_c_of_type_Boolean) || (jdField_e_of_type_Boolean)) {
          break label535;
        }
        if (!jdField_f_of_type_Boolean) {
          break label540;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        boolean bool;
        String str1;
        String[] arrayOfString;
        int i3;
        String str2;
        QLog.e("Perf", 1, "enablePerfConfig has Exception:", localThrowable);
      }
      if ((i1 != 0) && (bool))
      {
        str1 = ((SharedPreferences)localObject).getString("extralsteps_new", "");
        if (!str1.isEmpty())
        {
          arrayOfString = str1.split("\\|");
          if (arrayOfString.length > 0)
          {
            i3 = arrayOfString.length;
            i1 = 0;
            if (i1 < i3)
            {
              str2 = arrayOfString[i1];
              anze.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(Integer.parseInt(str2)));
              i1 += 1;
              continue;
            }
          }
        }
        jdField_a_of_type_JavaUtilSet.clear();
        localObject = ((SharedPreferences)localObject).getString("predownloadwhitelist_new", "");
        if (!((String)localObject).isEmpty())
        {
          arrayOfString = ((String)localObject).split("\\|");
          if (arrayOfString.length > 0)
          {
            i3 = arrayOfString.length;
            i1 = i2;
            if (i1 < i3)
            {
              str2 = arrayOfString[i1];
              jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(Integer.parseInt(str2)));
              i1 += 1;
              continue;
            }
          }
        }
        jdField_c_of_type_Int = 0;
        if (jdField_d_of_type_Boolean) {
          jdField_c_of_type_Int |= 0x1;
        }
        if (jdField_c_of_type_Boolean) {
          jdField_c_of_type_Int |= 0x2;
        }
        if (jdField_e_of_type_Boolean) {
          jdField_c_of_type_Int |= 0x4;
        }
        if (jdField_f_of_type_Boolean) {
          jdField_c_of_type_Int |= 0x8;
        }
        jdField_k_of_type_Boolean = true;
        QLog.d("Perf", 1, "sDisablePreloadProcess:" + jdField_d_of_type_Boolean + ",sDisableGetTroopList:" + jdField_c_of_type_Boolean + ",sDisablePreDownload:" + jdField_e_of_type_Boolean + ",sEnableAutoMatorPerf:" + jdField_f_of_type_Boolean + ",sEnableCpuTimePrint:" + jdField_g_of_type_Boolean + ",extra_imp_steps:" + str1 + ",sPerfConfigReportValue:" + jdField_c_of_type_Int + ",predownload_white_list:" + (String)localObject);
        return;
      }
      return;
      label535:
      int i1 = 1;
      continue;
      label540:
      i1 = 0;
    }
  }
  
  private void a(int paramInt)
  {
    QLog.i("AutoMonitor", 1, "nextState " + this.jdField_e_of_type_Int + ", " + paramInt);
    if ((jdField_a_of_type_Boolean) || (BaseApplicationImpl.sProcessId == 1))
    {
      long l1 = 0L;
      if (this.jdField_e_of_type_Int != -1)
      {
        long l2 = SystemClock.uptimeMillis();
        if (jdField_a_of_type_Boolean) {
          Log.i("AutoMonitor", "STATE_" + this.jdField_e_of_type_Int + ", cost=" + (l2 - jdField_k_of_type_Long) + " then " + paramInt);
        }
        l1 = l2;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_e_of_type_Int), Long.valueOf(l2 - jdField_k_of_type_Long));
          l1 = l2;
        }
      }
      if (paramInt != 1000)
      {
        if (this.jdField_e_of_type_Int == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          jdField_k_of_type_Long = l1;
        }
      }
    }
    this.jdField_e_of_type_Int = paramInt;
    if ((this.jdField_e_of_type_Int == 2) || (this.jdField_e_of_type_Int == 1000))
    {
      if (this.jdField_e_of_type_Int != 2) {
        break label251;
      }
      this.jdField_h_of_type_Int = ThreadManager.getSubThread().getPriority();
      ThreadManager.getSubThread().setPriority(10);
      ThreadManager.getRecentThread().setPriority(10);
    }
    label251:
    while ((this.jdField_e_of_type_Int != 1000) || (this.jdField_h_of_type_Int == -1)) {
      return;
    }
    ThreadManager.getSubThread().setPriority(this.jdField_h_of_type_Int);
    ThreadManager.getRecentThread().setPriority(this.jdField_h_of_type_Int);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + this.jdField_e_of_type_Int);
    }
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(bcrg.b(10, this, null));
      if (jdField_a_of_type_Int == 1) {
        ThreadManager.getSubThreadHandler().post(bcrg.b(22, this, null));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(1000);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (paramBoolean)
    {
      l1 = SystemClock.uptimeMillis();
      l2 = this.jdField_b_of_type_Long;
      l3 = this.jdField_b_of_type_Long;
      l4 = BaseApplicationImpl.sShowTime;
      l5 = l1 - BaseApplicationImpl.sShowTime;
      jdField_h_of_type_Long = l5;
      if ((BaseApplicationImpl.sShowTime <= 0L) || (!bgnt.g(BaseApplicationImpl.sApplication))) {
        break label319;
      }
    }
    label319:
    for (BaseApplicationImpl.sShowTime = -l1;; BaseApplicationImpl.sShowTime = 0L)
    {
      long l6 = this.jdField_a_of_type_Long;
      long l7 = this.jdField_c_of_type_Long;
      if ((l4 > 0L) && (l5 < 30000L)) {
        QLog.d("AutoMonitor", 1, "ActionLoginS, cost=" + l5);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.1(this, l7, l6, l2, l1 - l3, l4, l5), 10000L);
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.2(this), 3000L);
      if (this.jdField_a_of_type_Bcox != null)
      {
        SplashADView localSplashADView = SplashADView.a(null, null);
        if (localSplashADView != null) {
          ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.3(this, localSplashADView), 4000L);
        }
      }
      BaseApplicationImpl.sDirector = null;
      return;
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.jdField_f_of_type_Int = 1;
    paramArrayOfInt1 = bcrg.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.jdField_f_of_type_Int = 2;
      this.jdField_g_of_type_Int = paramInt;
      paramArrayOfInt1.setResultListener(this.jdField_b_of_type_AndroidOsHandler, 10);
      paramArrayOfInt2 = bcrg.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.setResultListener(this.jdField_b_of_type_AndroidOsHandler, 10);
      new Handler(ThreadManager.getRecentThreadLooper()).post(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.step();
      return;
      paramArrayOfInt1.setResultListener(this.jdField_b_of_type_AndroidOsHandler, paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void b(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean) {
      localTextView.setText(2131693054);
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      QLog.flushLog();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new StartupDirector.5(this, paramAppActivity), 8000L);
      return;
      localTextView.setText(anni.a(2131713043));
    }
  }
  
  private void c()
  {
    QLog.i("AutoMonitor", 1, "realCreateActivity " + this.jdField_e_of_type_Int + ", " + this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_e_of_type_Int == 3) {
      a(4);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i1 -= 1;
          break;
        }
      }
    }
    long l1;
    if (BaseApplicationImpl.sLaunchTime > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_c_of_type_Long = (l1 - BaseApplicationImpl.sLaunchTime);
      Log.d("AutoMonitor", "ActionLoginA, cost=" + this.jdField_c_of_type_Long);
      if (!bgnt.d(BaseApplicationImpl.sApplication)) {
        break label223;
      }
    }
    label223:
    for (BaseApplicationImpl.sLaunchTime = -l1;; BaseApplicationImpl.sLaunchTime = 0L)
    {
      a(5);
      a(2, 0, 3000L);
      if (BaseApplicationImpl.sProcessId == 1) {
        b(12, 0, 10000L);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(bcox parambcox)
  {
    this.jdField_a_of_type_Bcox = parambcox;
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    QLog.i("AutoMonitor", 1, "onActivityFocusChanged when " + this.jdField_e_of_type_Int + ", " + paramAppActivity + ", " + paramBoolean);
    if (!paramBoolean) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission == null) {
        this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission = ((CheckPermission)bcrg.b(3, this, null));
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission.checkPermission(paramAppActivity))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        return;
      }
    }
    bkfy.a();
    if (this.jdField_e_of_type_Int == 2)
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        ThreadManager.getFileThreadHandler().postDelayed(bcrg.b(14, this, null), 1000L);
      }
      a(11, 1, 5L);
      a(3);
    }
    for (;;)
    {
      paramAppActivity = SplashADView.a(null, null);
      if ((paramAppActivity == null) || (!paramAppActivity.jdField_a_of_type_Boolean) || (!paramAppActivity.b)) {
        break;
      }
      QLog.i("SplashAD", 1, "adView resume Video");
      paramAppActivity.c();
      return;
      if (this.jdField_e_of_type_Int == 101)
      {
        a(11, 7, 5L);
        a(3);
      }
      else if (this.jdField_e_of_type_Int == 201)
      {
        a(11, 8, 5L);
        a(3);
      }
      else if ((this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 6))
      {
        a(true);
      }
      else if (this.jdField_e_of_type_Int == 3) {}
    }
  }
  
  public boolean a()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  public boolean a(Object paramObject, Intent paramIntent)
  {
    QLog.i("AutoMonitor", 1, "onActivityCreate" + paramObject);
    if ((paramObject instanceof AppActivity)) {}
    for (paramObject = (AppActivity)paramObject;; paramObject = null)
    {
      long l1 = SystemClock.uptimeMillis();
      if ((this.jdField_e_of_type_Int == 1) && (Math.abs(l1 - BaseApplicationImpl.appStartTime) > 4000L))
      {
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
      }
      label206:
      boolean bool2;
      if (paramObject == null)
      {
        int i1;
        if (this.jdField_e_of_type_Int == 1)
        {
          BaseApplicationImpl.sIsBgStartup = true;
          BaseApplicationImpl.sShowTime = 0L;
          BaseApplicationImpl.sLaunchTime = 0L;
          if (paramIntent != null) {
            jdField_a_of_type_Int = paramIntent.getIntExtra("k_start_mode", 0);
          }
          QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_e_of_type_Int + ", " + jdField_a_of_type_Int);
          paramObject = n;
          if (jdField_a_of_type_Int == 1)
          {
            paramObject = o;
            bcrg.b(0, this, paramObject).step();
            abev.f();
            if (GuardManager.a != null)
            {
              paramObject = GuardManager.a;
              if (jdField_a_of_type_Int != 2) {
                break label256;
              }
              i1 = 1;
              paramObject.a(i1, null);
            }
            a(201);
          }
        }
        for (;;)
        {
          bool2 = false;
          return bool2;
          if (jdField_a_of_type_Int == 2)
          {
            paramObject = p;
            BaseApplicationImpl.appStartTime = 0L;
            break;
          }
          if (jdField_a_of_type_Int != 0) {
            break;
          }
          paramObject = n;
          break;
          label256:
          i1 = 6;
          break label206;
          if (this.jdField_e_of_type_Int == 2)
          {
            bcrg.b(0, this, jdField_m_of_type_ArrayOfInt).step();
            a(101);
          }
          else if ((this.jdField_e_of_type_Int == 201) && (jdField_a_of_type_Int == 2) && (paramIntent != null))
          {
            i1 = paramIntent.getIntExtra("k_start_mode", 0);
            QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_e_of_type_Int + ", " + i1);
            if ((i1 == 3) || (i1 == 0) || (i1 == 1)) {
              bcrg.b(10, this, null).step();
            }
          }
        }
      }
      if ((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 2) || (this.jdField_e_of_type_Int == 101) || (this.jdField_e_of_type_Int == 201))
      {
        if ((Build.VERSION.SDK_INT < 21) && (!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
        {
          paramIntent = new Intent(paramObject, InstallActivity.class);
          paramIntent.addFlags(603979776);
          Intent localIntent = paramObject.getIntent();
          localIntent.addFlags(67108864);
          paramIntent.putExtra("NT_AY", localIntent);
          try
          {
            paramObject.superStartActivityForResult(paramIntent, -1, null);
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                paramObject.superFinish();
                jdField_b_of_type_Int = a(BaseApplicationImpl.sApplication);
                if (jdField_b_of_type_Int <= 3) {
                  System.exit(-1);
                }
                return true;
                paramIntent = paramIntent;
                QLog.e("AutoMonitor", 1, "", paramIntent);
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                QLog.e("AutoMonitor", 1, "", paramObject);
              }
            }
          }
        }
        this.jdField_a_of_type_MqqAppAppActivity = paramObject;
        if (!(paramObject instanceof InstallActivity)) {}
      }
      for (;;)
      {
        boolean bool1;
        try
        {
          new File(this.jdField_a_of_type_MqqAppAppActivity.getFilesDir(), "suicide_count").delete();
          if (!(paramObject instanceof SplashActivity))
          {
            BaseApplicationImpl.sLaunchTime = 0L;
            BaseApplicationImpl.sShowTime = 0L;
          }
          paramIntent = (SetSplash)bcrg.b(2, this, null);
          paramIntent.step();
          if (paramIntent.jdField_a_of_type_Boolean)
          {
            bool2 = true;
            a(2, 0, 1000L);
            if ((this.jdField_e_of_type_Int == 201) || ((this.jdField_e_of_type_Int == 1) && (jdField_a_of_type_Int == 2))) {
              this.jdField_b_of_type_Long = l1;
            }
            bool1 = bool2;
            if (this.jdField_e_of_type_Int == 1)
            {
              a(2);
              bool1 = bool2;
            }
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
            return bool1;
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
          continue;
          bcrg.b(7, this, null).step();
          bool2 = false;
          a(2, 0, 0L);
          continue;
        }
        if ((this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 6))
        {
          BaseApplicationImpl.sLaunchTime = 0L;
          BaseApplicationImpl.sShowTime = 0L;
          this.jdField_a_of_type_MqqAppAppActivity = paramObject;
          a(6);
          a(2, 0, 1000L);
          bool1 = false;
        }
        else if (this.jdField_e_of_type_Int == 3)
        {
          bool1 = true;
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public void b()
  {
    a(2, 0, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = 0;
    QLog.i("AutoMonitor", 1, this.jdField_e_of_type_Int + "handleMessage" + paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      for (;;)
      {
        return true;
        a(4, 0, 300L);
        bool1 = bcrg.b(13, this, null).step();
        if ((bool1) && (jdField_b_of_type_Int <= 3))
        {
          a(5, 0, 0L);
          a(jdField_c_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt, 6);
          b(9, 0, 300L);
          return true;
        }
        if (bool1) {
          i1 = 1;
        }
        a(3, i1, 0L);
        return true;
        b(9, 0, 300L);
        a(jdField_e_of_type_ArrayOfInt, jdField_f_of_type_ArrayOfInt, 6);
        return true;
        a(jdField_g_of_type_ArrayOfInt, jdField_h_of_type_ArrayOfInt, 6);
        return true;
        a(jdField_g_of_type_ArrayOfInt, jdField_h_of_type_ArrayOfInt, 116);
        return true;
        a(this.jdField_a_of_type_MqqAppAppActivity, true);
        return true;
        if (this.jdField_a_of_type_MqqAppAppActivity != null)
        {
          AppActivity localAppActivity = this.jdField_a_of_type_MqqAppAppActivity;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          b(localAppActivity, bool1);
          return true;
          if (this.jdField_a_of_type_MqqAppAppActivity != null)
          {
            bgsi.a(this.jdField_a_of_type_MqqAppAppActivity, "com.tencent.mobileqq.activity.MainActivity");
            bgsi.a(this.jdField_a_of_type_MqqAppAppActivity, SplashActivity.class.getName());
            return true;
            if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(4)) {}
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            return true;
            QLog.d("AutoMonitor", 1, "qqBackStartReady");
            this.jdField_m_of_type_Boolean = true;
            return true;
            if (paramMessage.arg1 == 0)
            {
              if (this.jdField_a_of_type_Long > 0L) {
                this.jdField_i_of_type_Long = (this.jdField_j_of_type_Long + this.jdField_a_of_type_Long - SystemClock.uptimeMillis());
              }
              if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
              {
                System.gc();
                this.jdField_i_of_type_Long = 2000L;
              }
              if ((this.jdField_i_of_type_Long > 0L) && (this.jdField_i_of_type_Long < 6000L))
              {
                if (this.jdField_a_of_type_Bcox != null)
                {
                  a(6, 2, this.jdField_i_of_type_Long);
                  return true;
                }
                a(6, 1, this.jdField_i_of_type_Long);
                return true;
              }
              c();
              return true;
            }
            if (paramMessage.arg1 == 1)
            {
              c();
              return true;
            }
            this.jdField_a_of_type_Bcox.a(this);
            if (this.jdField_a_of_type_Long > 0L) {
              this.jdField_i_of_type_Long = this.jdField_a_of_type_Long;
            }
            QLog.i("SplashAD", 1, "mDelay" + this.jdField_i_of_type_Long);
            if ((this.jdField_i_of_type_Long > 0L) && (this.jdField_i_of_type_Long < 11000L))
            {
              a(15, 1, this.jdField_i_of_type_Long);
              return true;
            }
            c();
            return true;
            bcrg.b(14, this, null).step();
            if (BaseApplicationImpl.sProcessId == 7)
            {
              a(13, 0, 0L);
              return true;
              QLog.d("AutoMonitor", 1, "MSG_REAL_CREATE MSG_JOB_FINISHED");
              i1 = this.jdField_f_of_type_Int - 1;
              this.jdField_f_of_type_Int = i1;
              if (i1 == 0)
              {
                a(this.jdField_g_of_type_Int, 0, 0L);
                return true;
                if (this.jdField_a_of_type_Long > 0L) {
                  this.jdField_j_of_type_Long = SystemClock.uptimeMillis();
                }
                b(paramMessage.arg1, 0, 0L);
                return true;
                try
                {
                  if (GuardManager.a != null)
                  {
                    paramMessage = GuardManager.a;
                    bool1 = bool2;
                    if (jdField_a_of_type_Int == 2) {
                      bool1 = true;
                    }
                    paramMessage.d(bool1);
                    return true;
                  }
                }
                catch (Throwable paramMessage)
                {
                  return true;
                }
              }
            }
          }
        }
      }
      bcrg.b(29, this, null).step();
      return true;
    } while (this.jdField_a_of_type_Bcox.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bcox.a();
    QLog.d("AutoMonitor", 1, "MSG_REAL_CREATE1 MSG_SPLASHAD_END");
    a(6, 1, 0L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcow
 * JD-Core Version:    0.7.0.1
 */