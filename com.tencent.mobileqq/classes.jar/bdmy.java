import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MainService;

public class bdmy
  implements Handler.Callback
{
  private static bdmy jdField_a_of_type_Bdmy;
  private static final String jdField_a_of_type_JavaLangString = bigv.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", File.separator) + File.separator);
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "temp.trace";
  private static final String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "baseInfo.txt";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bdmz jdField_a_of_type_Bdmz = new bdmz();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 15;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g;
  
  public static bdmy a()
  {
    if (jdField_a_of_type_Bdmy == null) {}
    try
    {
      if (jdField_a_of_type_Bdmy == null) {
        jdField_a_of_type_Bdmy = new bdmy();
      }
      return jdField_a_of_type_Bdmy;
    }
    finally {}
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("bg_cpu_").append(System.currentTimeMillis()).append(".trace.zip");
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    String str1 = QLog.getLogPath();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = bhsw.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Long> paramMap)
  {
    Object[] arrayOfObject = aodu.a("-2");
    long l2 = -1L;
    long l1 = -1L;
    long l3 = -1L;
    if (arrayOfObject != null)
    {
      l2 = ((Long)arrayOfObject[1]).longValue() + ((Long)arrayOfObject[2]).longValue();
      l1 = ((Long)arrayOfObject[1]).longValue();
    }
    long l4 = aodu.a("-1");
    if (BaseApplicationImpl.sProcessId != 4) {
      l3 = aodu.a(String.valueOf(MainService.sNativeTidOfReceiver));
    }
    long l5 = MainService.sReceiverCpuTime;
    long l6 = apbc.jdField_a_of_type_Long;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "cpuInfo: ", Long.valueOf(l2), ", ", Long.valueOf(l1), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", Long.valueOf(l5), ", ", Long.valueOf(l6) });
    if ((l2 <= 0L) || (l1 <= 0L) || (l4 <= 0L) || ((BaseApplicationImpl.sProcessId != 4) && (l3 <= 0L)))
    {
      QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
      return false;
    }
    int i;
    int k;
    if (paramBoolean2)
    {
      i = -1;
      long l7 = l2 - this.jdField_a_of_type_Long;
      if ((l7 <= 0L) || (l1 <= this.jdField_b_of_type_Long) || (l4 <= this.jdField_c_of_type_Long))
      {
        paramMap = new StringBuilder(256);
        paramMap.append("bad cpu value2.").append(l2).append(",").append(this.jdField_a_of_type_Long).append(",").append(l1).append(",").append(this.jdField_b_of_type_Long).append(",").append(l4).append(",").append(this.jdField_c_of_type_Long);
        QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
        return false;
      }
      long l8 = l4 - this.jdField_c_of_type_Long;
      k = (int)(100L * l8 / l7);
      if (paramMap != null)
      {
        paramMap.put("elapse", Long.valueOf(l7));
        paramMap.put("qqConsume", Long.valueOf(l8));
        paramMap.put("qqRatio", Long.valueOf(k));
      }
      if (BaseApplicationImpl.sProcessId == 4) {
        break label710;
      }
      if (l3 < this.jdField_d_of_type_Long)
      {
        QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.jdField_d_of_type_Long) });
        return false;
      }
      l8 = l3 - this.jdField_d_of_type_Long;
      int j = (int)(100L * l8 / l7);
      i = j;
      if (paramMap != null)
      {
        paramMap.put("msfConsume", Long.valueOf(l8));
        paramMap.put("msfRatio", Long.valueOf(j));
        i = j;
      }
    }
    for (;;)
    {
      paramMap.put("msfTime", Long.valueOf(l5 - this.e));
      paramMap.put("ftsTime", Long.valueOf(l6 - this.f));
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(k), ", msf-receiver cpuRatio = ", Integer.valueOf(i), ", remainRptCount = ", Integer.valueOf(this.jdField_a_of_type_Int) });
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Long = l2;
        this.jdField_b_of_type_Long = l1;
        this.jdField_c_of_type_Long = l4;
        this.jdField_d_of_type_Long = l3;
        this.e = l5;
        this.f = l6;
      }
      return true;
      label710:
      paramMap.put("msfConsume", Long.valueOf(0L));
      paramMap.put("msfRatio", Long.valueOf(0L));
    }
  }
  
  private static void c()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        int i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("bg_cpu_"))) {}
          for (int j = 1;; j = 0)
          {
            if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
              localObject2.delete();
            }
            i += 1;
            break;
          }
        }
      }
    }
  }
  
  void a()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground,sCountActivity = ", Integer.valueOf(Foreground.sCountActivity) });
    if ((this.jdField_d_of_type_Boolean) || (UEC.a().a())) {
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground, isMainProcessForeground = ", Boolean.valueOf(UEC.a().a()) });
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      this.jdField_d_of_type_Boolean = true;
    } while ((!this.jdField_a_of_type_Boolean) || (Looper.myLooper() != ThreadManager.getFileThreadLooper()) || (!a(true, false, null)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
  }
  
  void a(String paramString)
  {
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4)) {
      break label14;
    }
    label14:
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    QLog.d("BatteryStats.BgCpu", 2, "config = " + paramString);
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
          this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
        }
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("rand_time", 0L);
        bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("rand_rs", false);
        paramString = paramString.split(";");
        if (Math.abs(System.currentTimeMillis() - l) > 86400000L)
        {
          float f2 = Float.valueOf(paramString[1]).floatValue();
          float f1 = f2;
          if (QLog.isColorLevel())
          {
            f1 = f2;
            if (paramString.length >= 9) {
              f1 = f2 * Integer.valueOf(paramString[8]).intValue();
            }
          }
          if (Math.random() >= f1) {
            break label445;
          }
          bool1 = true;
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label451;
          }
          i = 1;
          break label469;
          this.jdField_b_of_type_Int = Integer.valueOf(paramString[j]).intValue();
          if (i == 0) {
            break label463;
          }
          i = 3;
          label267:
          this.jdField_c_of_type_Int = Integer.valueOf(paramString[i]).intValue();
          this.jdField_a_of_type_Int = (Integer.valueOf(paramString[6]).intValue() - this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("times", 0));
          if (this.jdField_a_of_type_Int <= 0) {
            bool1 = false;
          }
          this.jdField_b_of_type_Boolean = "1".equals(paramString[7]);
          bool2 = bool1;
        }
        this.jdField_a_of_type_Boolean = bool2;
        QQLiveImage.setUSRLogEnable(this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (BaseApplicationImpl.sProcessId == 4) && (this.jdField_a_of_type_AndroidOsHandler == null)) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        }
        if (paramString.length < 10) {
          break label14;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("enable_nor_sensor", "1".equals(paramString[9])).commit();
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BatteryStats.BgCpu", 2, "", paramString);
      return;
      label445:
      boolean bool1 = false;
      continue;
      label451:
      int i = 0;
      label463:
      label469:
      while (i == 0)
      {
        j = 4;
        break;
        i = 5;
        break label267;
      }
      int j = 2;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("enable_nor_sensor", true);
  }
  
  void b()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppForeground,sCountActivity = ", Integer.valueOf(Foreground.sCountActivity) });
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.g > 0L) {
        QLog.d("BatteryStats.BgCpu", 1, "stop trace bg cpu");
      }
      try
      {
        Debug.stopMethodTracing();
        this.g = 0L;
        if (this.jdField_c_of_type_Boolean) {
          continue;
        }
        c();
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BatteryStats.BgCpu", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(21)
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 511	android/os/Message:what	I
    //   4: bipush 10
    //   6: if_icmpne +25 -> 31
    //   9: aload_0
    //   10: getfield 90	bdmy:jdField_a_of_type_Bdmz	Lbdmz;
    //   13: invokevirtual 513	bdmz:a	()V
    //   16: aload_0
    //   17: getfield 336	bdmy:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   20: bipush 10
    //   22: ldc2_w 361
    //   25: invokevirtual 366	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   28: pop
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_1
    //   32: getfield 511	android/os/Message:what	I
    //   35: bipush 11
    //   37: if_icmpne +13 -> 50
    //   40: aload_0
    //   41: getfield 90	bdmy:jdField_a_of_type_Bdmz	Lbdmz;
    //   44: invokevirtual 515	bdmz:b	()V
    //   47: goto -18 -> 29
    //   50: aload_1
    //   51: getfield 511	android/os/Message:what	I
    //   54: iconst_2
    //   55: if_icmpne +10 -> 65
    //   58: aload_0
    //   59: invokevirtual 516	bdmy:a	()V
    //   62: goto -33 -> 29
    //   65: aload_1
    //   66: getfield 511	android/os/Message:what	I
    //   69: ifne +632 -> 701
    //   72: new 518	java/util/HashMap
    //   75: dup
    //   76: iconst_5
    //   77: invokespecial 519	java/util/HashMap:<init>	(I)V
    //   80: astore 17
    //   82: invokestatic 325	com/tencent/mobileqq/statistics/UEC:a	()Lcom/tencent/mobileqq/statistics/UEC;
    //   85: invokevirtual 521	com/tencent/mobileqq/statistics/UEC:b	()Z
    //   88: ifeq -59 -> 29
    //   91: aload_0
    //   92: iconst_1
    //   93: iconst_1
    //   94: aload 17
    //   96: invokespecial 360	bdmy:a	(ZZLjava/util/Map;)Z
    //   99: ifeq -70 -> 29
    //   102: aload 17
    //   104: ldc 242
    //   106: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   109: ifeq -80 -> 29
    //   112: aload 17
    //   114: ldc 252
    //   116: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   119: ifeq -90 -> 29
    //   122: aload 17
    //   124: ldc 242
    //   126: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 161	java/lang/Long
    //   132: invokevirtual 164	java/lang/Long:longValue	()J
    //   135: lstore 4
    //   137: aload 17
    //   139: ldc 252
    //   141: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   144: ifeq +552 -> 696
    //   147: aload 17
    //   149: ldc 252
    //   151: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast 161	java/lang/Long
    //   157: invokevirtual 164	java/lang/Long:longValue	()J
    //   160: lstore_2
    //   161: ldc 190
    //   163: iconst_1
    //   164: bipush 6
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: ldc_w 530
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: lload 4
    //   179: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: ldc 226
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: lload_2
    //   191: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: dup
    //   196: iconst_4
    //   197: ldc 197
    //   199: aastore
    //   200: dup
    //   201: iconst_5
    //   202: iconst_0
    //   203: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   206: aastore
    //   207: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   210: lload 4
    //   212: lload_2
    //   213: lsub
    //   214: aload_0
    //   215: getfield 83	bdmy:jdField_b_of_type_Int	I
    //   218: i2l
    //   219: lcmp
    //   220: ifgt +13 -> 233
    //   223: lload_2
    //   224: aload_0
    //   225: getfield 85	bdmy:jdField_c_of_type_Int	I
    //   228: i2l
    //   229: lcmp
    //   230: ifle -201 -> 29
    //   233: new 518	java/util/HashMap
    //   236: dup
    //   237: iconst_2
    //   238: invokespecial 519	java/util/HashMap:<init>	(I)V
    //   241: astore_1
    //   242: aload_1
    //   243: new 25	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   250: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   253: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: ldc_w 535
    //   259: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: new 25	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   272: aload 17
    //   274: ldc 242
    //   276: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   279: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: ldc_w 475
    //   285: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: aload_1
    //   296: new 25	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   303: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   306: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: ldc_w 541
    //   312: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: new 25	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   325: aload 17
    //   327: ldc 252
    //   329: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   332: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: ldc_w 475
    //   338: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: aload_1
    //   349: new 25	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   356: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   359: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc_w 543
    //   365: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: new 25	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   378: aload 17
    //   380: ldc 232
    //   382: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   385: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: ldc_w 475
    //   391: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: aload_1
    //   402: new 25	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   409: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   412: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc_w 545
    //   418: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: new 25	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   431: aload 17
    //   433: ldc 240
    //   435: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   438: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: ldc_w 475
    //   444: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: aload_1
    //   455: new 25	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   462: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   465: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc_w 547
    //   471: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: new 25	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   484: aload 17
    //   486: ldc 250
    //   488: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   491: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   494: ldc_w 475
    //   497: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_1
    //   508: ldc_w 549
    //   511: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   514: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   517: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: aload_1
    //   522: ldc_w 551
    //   525: getstatic 373	android/os/Build$VERSION:SDK_INT	I
    //   528: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   531: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: pop
    //   535: invokestatic 381	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   538: invokestatic 556	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   541: aconst_null
    //   542: ldc_w 558
    //   545: iconst_1
    //   546: lconst_0
    //   547: lconst_0
    //   548: aload_1
    //   549: aconst_null
    //   550: invokevirtual 561	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   553: new 36	java/io/File
    //   556: dup
    //   557: getstatic 75	bdmy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   560: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   563: astore 17
    //   565: aload 17
    //   567: invokevirtual 564	java/io/File:getParentFile	()Ljava/io/File;
    //   570: ifnull +23 -> 593
    //   573: aload 17
    //   575: invokevirtual 564	java/io/File:getParentFile	()Ljava/io/File;
    //   578: invokevirtual 277	java/io/File:exists	()Z
    //   581: ifeq +12 -> 593
    //   584: aload 17
    //   586: invokevirtual 564	java/io/File:getParentFile	()Ljava/io/File;
    //   589: invokevirtual 567	java/io/File:mkdirs	()Z
    //   592: pop
    //   593: aload 17
    //   595: invokevirtual 277	java/io/File:exists	()Z
    //   598: ifeq +9 -> 607
    //   601: aload 17
    //   603: invokevirtual 311	java/io/File:delete	()Z
    //   606: pop
    //   607: aload_0
    //   608: getfield 465	bdmy:jdField_b_of_type_Boolean	Z
    //   611: ifeq +7 -> 618
    //   614: iconst_2
    //   615: invokestatic 570	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   618: getstatic 75	bdmy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   621: ldc_w 571
    //   624: sipush 1000
    //   627: invokestatic 575	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   630: aload_0
    //   631: invokestatic 580	android/os/SystemClock:uptimeMillis	()J
    //   634: putfield 487	bdmy:g	J
    //   637: aload_0
    //   638: getfield 336	bdmy:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   641: aload_0
    //   642: getfield 336	bdmy:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   645: iconst_1
    //   646: aload_1
    //   647: invokestatic 584	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   650: ldc2_w 361
    //   653: invokevirtual 588	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   656: pop
    //   657: goto -628 -> 29
    //   660: astore_1
    //   661: aload_0
    //   662: iconst_0
    //   663: putfield 353	bdmy:jdField_a_of_type_Boolean	Z
    //   666: ldc 190
    //   668: iconst_1
    //   669: ldc_w 590
    //   672: aload_1
    //   673: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   676: invokestatic 494	android/os/Debug:stopMethodTracing	()V
    //   679: goto -650 -> 29
    //   682: astore_1
    //   683: ldc 190
    //   685: iconst_1
    //   686: ldc_w 475
    //   689: aload_1
    //   690: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   693: goto -664 -> 29
    //   696: lconst_0
    //   697: lstore_2
    //   698: goto -537 -> 161
    //   701: aload_1
    //   702: getfield 511	android/os/Message:what	I
    //   705: iconst_3
    //   706: if_icmpne +13 -> 719
    //   709: aload_1
    //   710: getfield 595	android/os/Message:arg1	I
    //   713: invokestatic 570	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   716: goto -687 -> 29
    //   719: aload_1
    //   720: getfield 511	android/os/Message:what	I
    //   723: iconst_1
    //   724: if_icmpne -695 -> 29
    //   727: invokestatic 494	android/os/Debug:stopMethodTracing	()V
    //   730: aload_0
    //   731: lconst_0
    //   732: putfield 487	bdmy:g	J
    //   735: new 518	java/util/HashMap
    //   738: dup
    //   739: iconst_5
    //   740: invokespecial 519	java/util/HashMap:<init>	(I)V
    //   743: astore 17
    //   745: invokestatic 325	com/tencent/mobileqq/statistics/UEC:a	()Lcom/tencent/mobileqq/statistics/UEC;
    //   748: invokevirtual 521	com/tencent/mobileqq/statistics/UEC:b	()Z
    //   751: ifeq -722 -> 29
    //   754: aload_0
    //   755: iconst_1
    //   756: iconst_1
    //   757: aload 17
    //   759: invokespecial 360	bdmy:a	(ZZLjava/util/Map;)Z
    //   762: ifeq -733 -> 29
    //   765: aload 17
    //   767: ldc 242
    //   769: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   772: ifeq -743 -> 29
    //   775: aload 17
    //   777: ldc 252
    //   779: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   782: ifeq -753 -> 29
    //   785: aload 17
    //   787: ldc 242
    //   789: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   792: checkcast 161	java/lang/Long
    //   795: invokevirtual 164	java/lang/Long:longValue	()J
    //   798: lstore 8
    //   800: aload 17
    //   802: ldc 252
    //   804: invokevirtual 524	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   807: ifeq +1460 -> 2267
    //   810: aload 17
    //   812: ldc 252
    //   814: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   817: checkcast 161	java/lang/Long
    //   820: invokevirtual 164	java/lang/Long:longValue	()J
    //   823: lstore_2
    //   824: ldc 190
    //   826: iconst_1
    //   827: bipush 6
    //   829: anewarray 4	java/lang/Object
    //   832: dup
    //   833: iconst_0
    //   834: ldc_w 597
    //   837: aastore
    //   838: dup
    //   839: iconst_1
    //   840: lload 8
    //   842: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   845: aastore
    //   846: dup
    //   847: iconst_2
    //   848: ldc 226
    //   850: aastore
    //   851: dup
    //   852: iconst_3
    //   853: lload_2
    //   854: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   857: aastore
    //   858: dup
    //   859: iconst_4
    //   860: ldc 226
    //   862: aastore
    //   863: dup
    //   864: iconst_5
    //   865: iconst_0
    //   866: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   869: aastore
    //   870: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   873: lload 8
    //   875: lload_2
    //   876: lsub
    //   877: aload_0
    //   878: getfield 83	bdmy:jdField_b_of_type_Int	I
    //   881: i2l
    //   882: lcmp
    //   883: ifgt +13 -> 896
    //   886: lload_2
    //   887: aload_0
    //   888: getfield 85	bdmy:jdField_c_of_type_Int	I
    //   891: i2l
    //   892: lcmp
    //   893: ifle +1471 -> 2364
    //   896: aload 17
    //   898: ldc 232
    //   900: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   903: checkcast 161	java/lang/Long
    //   906: invokevirtual 164	java/lang/Long:longValue	()J
    //   909: lstore 10
    //   911: aload 17
    //   913: ldc 240
    //   915: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   918: checkcast 161	java/lang/Long
    //   921: invokevirtual 164	java/lang/Long:longValue	()J
    //   924: lstore 12
    //   926: aload 17
    //   928: ldc 250
    //   930: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   933: checkcast 161	java/lang/Long
    //   936: invokevirtual 164	java/lang/Long:longValue	()J
    //   939: lstore 14
    //   941: new 36	java/io/File
    //   944: dup
    //   945: getstatic 75	bdmy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   948: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   951: astore_1
    //   952: new 599	java/util/ArrayList
    //   955: dup
    //   956: iconst_4
    //   957: invokespecial 600	java/util/ArrayList:<init>	(I)V
    //   960: astore 22
    //   962: aload 22
    //   964: aload_1
    //   965: invokevirtual 603	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   968: invokeinterface 608 2 0
    //   973: pop
    //   974: new 36	java/io/File
    //   977: dup
    //   978: getstatic 79	bdmy:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   981: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   984: astore 18
    //   986: aload 18
    //   988: invokevirtual 277	java/io/File:exists	()Z
    //   991: ifeq +9 -> 1000
    //   994: aload 18
    //   996: invokevirtual 311	java/io/File:delete	()Z
    //   999: pop
    //   1000: aload 22
    //   1002: aload 18
    //   1004: invokevirtual 603	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1007: invokeinterface 608 2 0
    //   1012: pop
    //   1013: aconst_null
    //   1014: astore_1
    //   1015: new 610	java/io/BufferedOutputStream
    //   1018: dup
    //   1019: new 612	java/io/FileOutputStream
    //   1022: dup
    //   1023: aload 18
    //   1025: invokespecial 615	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1028: invokespecial 618	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1031: astore 19
    //   1033: aload 19
    //   1035: ldc_w 620
    //   1038: invokevirtual 624	java/lang/String:getBytes	()[B
    //   1041: invokevirtual 628	java/io/BufferedOutputStream:write	([B)V
    //   1044: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1047: iconst_1
    //   1048: if_icmpne +1224 -> 2272
    //   1051: ldc_w 630
    //   1054: astore_1
    //   1055: aload 19
    //   1057: aload_1
    //   1058: invokevirtual 624	java/lang/String:getBytes	()[B
    //   1061: invokevirtual 628	java/io/BufferedOutputStream:write	([B)V
    //   1064: new 25	java/lang/StringBuilder
    //   1067: dup
    //   1068: sipush 200
    //   1071: invokespecial 222	java/lang/StringBuilder:<init>	(I)V
    //   1074: astore 23
    //   1076: aload 23
    //   1078: ldc_w 632
    //   1081: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1087: ldc2_w 633
    //   1090: lsub
    //   1091: ldc_w 636
    //   1094: invokestatic 131	bhsw:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1097: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: ldc_w 638
    //   1103: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1109: ldc_w 636
    //   1112: invokestatic 131	bhsw:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1115: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: ldc_w 640
    //   1121: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: ldc_w 642
    //   1127: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: lload 8
    //   1132: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1135: ldc_w 644
    //   1138: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: lload_2
    //   1142: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1145: ldc_w 646
    //   1148: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: lload 10
    //   1153: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1156: ldc_w 648
    //   1159: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: lload 12
    //   1164: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1167: ldc_w 650
    //   1170: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: lload 14
    //   1175: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1178: ldc_w 652
    //   1181: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: aload 17
    //   1186: ldc 254
    //   1188: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1191: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1194: ldc_w 654
    //   1197: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload 17
    //   1202: ldc_w 258
    //   1205: invokevirtual 528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1208: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1211: ldc_w 640
    //   1214: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: invokestatic 381	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1221: aconst_null
    //   1222: invokevirtual 658	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1225: checkcast 660	com/tencent/mobileqq/app/QQAppInterface
    //   1228: astore 24
    //   1230: aload 24
    //   1232: ifnull +144 -> 1376
    //   1235: aload 23
    //   1237: ldc_w 662
    //   1240: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: aload 24
    //   1245: invokevirtual 665	com/tencent/mobileqq/app/QQAppInterface:a	()Lapau;
    //   1248: invokevirtual 669	apau:a	()J
    //   1251: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1254: ldc_w 640
    //   1257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: pop
    //   1261: aload 24
    //   1263: invokevirtual 665	com/tencent/mobileqq/app/QQAppInterface:a	()Lapau;
    //   1266: iconst_2
    //   1267: invokevirtual 672	apau:a	(I)Lapay;
    //   1270: checkcast 674	apbd
    //   1273: astore_1
    //   1274: aload 23
    //   1276: ldc_w 676
    //   1279: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: aload_1
    //   1283: invokevirtual 678	apbd:b	()I
    //   1286: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1289: ldc_w 640
    //   1292: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload 23
    //   1298: ldc_w 680
    //   1301: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: aload_1
    //   1305: invokevirtual 682	apbd:a	()I
    //   1308: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1311: ldc_w 640
    //   1314: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload 24
    //   1320: invokevirtual 665	com/tencent/mobileqq/app/QQAppInterface:a	()Lapau;
    //   1323: iconst_1
    //   1324: invokevirtual 672	apau:a	(I)Lapay;
    //   1327: checkcast 684	apaz
    //   1330: astore_1
    //   1331: aload 23
    //   1333: ldc_w 686
    //   1336: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: aload_1
    //   1340: iconst_0
    //   1341: invokevirtual 689	apaz:a	(Z)I
    //   1344: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1347: ldc_w 640
    //   1350: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: pop
    //   1354: aload 23
    //   1356: ldc_w 691
    //   1359: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: aload_1
    //   1363: invokevirtual 692	apaz:a	()I
    //   1366: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1369: ldc_w 640
    //   1372: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: pop
    //   1376: aload 19
    //   1378: aload 23
    //   1380: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1383: invokevirtual 624	java/lang/String:getBytes	()[B
    //   1386: invokevirtual 628	java/io/BufferedOutputStream:write	([B)V
    //   1389: aconst_null
    //   1390: astore 21
    //   1392: aconst_null
    //   1393: astore_1
    //   1394: aconst_null
    //   1395: astore 20
    //   1397: lconst_0
    //   1398: lstore 4
    //   1400: aload 20
    //   1402: astore 18
    //   1404: aload 21
    //   1406: astore 17
    //   1408: invokestatic 381	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1411: invokevirtual 696	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1414: astore 25
    //   1416: iconst_0
    //   1417: ifne +60 -> 1477
    //   1420: aload 20
    //   1422: astore 18
    //   1424: aload 21
    //   1426: astore 17
    //   1428: aload 25
    //   1430: ldc 48
    //   1432: sipush 128
    //   1435: invokevirtual 702	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1438: astore_1
    //   1439: aload 20
    //   1441: astore 18
    //   1443: aload 21
    //   1445: astore 17
    //   1447: new 25	java/lang/StringBuilder
    //   1450: dup
    //   1451: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1454: aload_1
    //   1455: getfield 707	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1458: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc 50
    //   1463: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload_1
    //   1467: getfield 710	android/content/pm/PackageInfo:versionCode	I
    //   1470: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: astore_1
    //   1477: aload 20
    //   1479: astore 18
    //   1481: aload_1
    //   1482: astore 17
    //   1484: aload 25
    //   1486: ldc 48
    //   1488: sipush 128
    //   1491: invokevirtual 714	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1494: getfield 720	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1497: ldc_w 722
    //   1500: invokevirtual 727	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1503: invokevirtual 728	java/lang/Object:toString	()Ljava/lang/String;
    //   1506: astore 20
    //   1508: aload 20
    //   1510: astore 18
    //   1512: aload_1
    //   1513: astore 17
    //   1515: aload 24
    //   1517: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1520: invokestatic 734	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1523: lstore 6
    //   1525: ldc_w 736
    //   1528: astore 21
    //   1530: aload_1
    //   1531: astore 17
    //   1533: lload 6
    //   1535: lstore 4
    //   1537: aload 20
    //   1539: astore 18
    //   1541: aload 21
    //   1543: astore_1
    //   1544: aload 23
    //   1546: iconst_0
    //   1547: aload 23
    //   1549: invokevirtual 739	java/lang/StringBuilder:length	()I
    //   1552: invokevirtual 742	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 23
    //   1558: ldc_w 744
    //   1561: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: lload 4
    //   1566: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1569: ldc_w 746
    //   1572: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload 17
    //   1577: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: ldc_w 748
    //   1583: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: aload 18
    //   1588: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: ldc_w 750
    //   1594: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: aload_1
    //   1598: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: ldc_w 752
    //   1604: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1610: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1613: ldc_w 754
    //   1616: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: invokestatic 419	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1622: invokevirtual 757	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 19
    //   1628: aload 23
    //   1630: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1633: invokevirtual 624	java/lang/String:getBytes	()[B
    //   1636: invokevirtual 628	java/io/BufferedOutputStream:write	([B)V
    //   1639: aload 19
    //   1641: invokevirtual 760	java/io/BufferedOutputStream:flush	()V
    //   1644: aload 19
    //   1646: ifnull +8 -> 1654
    //   1649: aload 19
    //   1651: invokevirtual 763	java/io/BufferedOutputStream:close	()V
    //   1654: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1657: invokestatic 765	bdmy:a	(J)Ljava/lang/String;
    //   1660: astore_1
    //   1661: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1664: ldc2_w 766
    //   1667: lsub
    //   1668: invokestatic 765	bdmy:a	(J)Ljava/lang/String;
    //   1671: astore 17
    //   1673: aload 22
    //   1675: aload_1
    //   1676: invokeinterface 608 2 0
    //   1681: pop
    //   1682: aload_1
    //   1683: aload 17
    //   1685: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1688: ifne +13 -> 1701
    //   1691: aload 22
    //   1693: aload 17
    //   1695: invokeinterface 608 2 0
    //   1700: pop
    //   1701: invokestatic 769	bdmy:a	()Ljava/lang/String;
    //   1704: astore 18
    //   1706: iconst_0
    //   1707: istore 16
    //   1709: aload 22
    //   1711: aload 18
    //   1713: invokestatic 774	bhmi:a	(Ljava/util/List;Ljava/lang/String;)Z
    //   1716: ifeq +165 -> 1881
    //   1719: aload_0
    //   1720: aload_0
    //   1721: getfield 268	bdmy:jdField_a_of_type_Int	I
    //   1724: iconst_1
    //   1725: isub
    //   1726: putfield 268	bdmy:jdField_a_of_type_Int	I
    //   1729: aload_0
    //   1730: getfield 377	bdmy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1733: invokeinterface 434 1 0
    //   1738: ldc_w 446
    //   1741: aload_0
    //   1742: getfield 377	bdmy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1745: ldc_w 446
    //   1748: iconst_0
    //   1749: invokeinterface 457 3 0
    //   1754: iconst_1
    //   1755: iadd
    //   1756: invokeinterface 450 3 0
    //   1761: invokeinterface 453 1 0
    //   1766: pop
    //   1767: new 776	org/json/JSONObject
    //   1770: dup
    //   1771: invokespecial 777	org/json/JSONObject:<init>	()V
    //   1774: astore_1
    //   1775: new 776	org/json/JSONObject
    //   1778: dup
    //   1779: invokespecial 777	org/json/JSONObject:<init>	()V
    //   1782: astore 17
    //   1784: aload 17
    //   1786: ldc_w 779
    //   1789: aload 18
    //   1791: invokevirtual 782	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1794: pop
    //   1795: new 776	org/json/JSONObject
    //   1798: dup
    //   1799: invokespecial 777	org/json/JSONObject:<init>	()V
    //   1802: astore 18
    //   1804: aload 18
    //   1806: ldc_w 784
    //   1809: ldc_w 459
    //   1812: invokevirtual 782	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1815: pop
    //   1816: aload_1
    //   1817: ldc_w 786
    //   1820: aload 17
    //   1822: invokevirtual 782	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1825: pop
    //   1826: aload_1
    //   1827: ldc_w 788
    //   1830: aload 18
    //   1832: invokevirtual 782	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1835: pop
    //   1836: aload_1
    //   1837: ldc_w 790
    //   1840: bipush 126
    //   1842: invokevirtual 793	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1845: pop
    //   1846: new 795	com/tencent/mfsdk/collector/ResultObject
    //   1849: dup
    //   1850: iconst_0
    //   1851: ldc_w 797
    //   1854: iconst_1
    //   1855: lconst_1
    //   1856: lconst_1
    //   1857: aload_1
    //   1858: iconst_1
    //   1859: iconst_1
    //   1860: getstatic 800	com/tencent/mfsdk/MagnifierSDK:jdField_a_of_type_Long	J
    //   1863: invokespecial 803	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   1866: invokestatic 808	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   1869: ldc 190
    //   1871: iconst_2
    //   1872: ldc_w 810
    //   1875: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1878: iconst_1
    //   1879: istore 16
    //   1881: new 518	java/util/HashMap
    //   1884: dup
    //   1885: iconst_2
    //   1886: invokespecial 519	java/util/HashMap:<init>	(I)V
    //   1889: astore_1
    //   1890: aload_1
    //   1891: new 25	java/lang/StringBuilder
    //   1894: dup
    //   1895: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1898: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1901: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1904: ldc_w 535
    //   1907: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1913: new 25	java/lang/StringBuilder
    //   1916: dup
    //   1917: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1920: lload 8
    //   1922: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1925: ldc_w 475
    //   1928: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1934: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1937: pop
    //   1938: aload_1
    //   1939: new 25	java/lang/StringBuilder
    //   1942: dup
    //   1943: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1946: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1949: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1952: ldc_w 541
    //   1955: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1961: new 25	java/lang/StringBuilder
    //   1964: dup
    //   1965: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1968: lload_2
    //   1969: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1972: ldc_w 475
    //   1975: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1981: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1984: pop
    //   1985: aload_1
    //   1986: new 25	java/lang/StringBuilder
    //   1989: dup
    //   1990: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1993: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1996: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1999: ldc_w 543
    //   2002: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2008: new 25	java/lang/StringBuilder
    //   2011: dup
    //   2012: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   2015: lload 10
    //   2017: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2020: ldc_w 475
    //   2023: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2032: pop
    //   2033: aload_1
    //   2034: new 25	java/lang/StringBuilder
    //   2037: dup
    //   2038: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   2041: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2044: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2047: ldc_w 545
    //   2050: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2056: new 25	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   2063: lload 12
    //   2065: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2068: ldc_w 475
    //   2071: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2074: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2077: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2080: pop
    //   2081: aload_1
    //   2082: new 25	java/lang/StringBuilder
    //   2085: dup
    //   2086: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   2089: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2092: invokevirtual 533	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2095: ldc_w 547
    //   2098: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2104: new 25	java/lang/StringBuilder
    //   2107: dup
    //   2108: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   2111: lload 14
    //   2113: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2116: ldc_w 475
    //   2119: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2125: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2128: pop
    //   2129: aload_1
    //   2130: ldc_w 549
    //   2133: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2136: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2139: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2142: pop
    //   2143: aload_1
    //   2144: ldc_w 551
    //   2147: getstatic 373	android/os/Build$VERSION:SDK_INT	I
    //   2150: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2153: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2156: pop
    //   2157: invokestatic 381	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2160: invokestatic 556	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   2163: aconst_null
    //   2164: ldc_w 812
    //   2167: iload 16
    //   2169: lconst_0
    //   2170: lconst_0
    //   2171: aload_1
    //   2172: aconst_null
    //   2173: invokevirtual 561	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2176: aload 22
    //   2178: invokeinterface 816 1 0
    //   2183: astore_1
    //   2184: aload_1
    //   2185: invokeinterface 821 1 0
    //   2190: ifeq -2161 -> 29
    //   2193: aload_1
    //   2194: invokeinterface 825 1 0
    //   2199: checkcast 55	java/lang/String
    //   2202: astore 17
    //   2204: aload 17
    //   2206: ldc 149
    //   2208: invokevirtual 828	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2211: ifne -27 -> 2184
    //   2214: aload 17
    //   2216: ldc_w 830
    //   2219: invokevirtual 828	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2222: ifne -38 -> 2184
    //   2225: new 36	java/io/File
    //   2228: dup
    //   2229: aload 17
    //   2231: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   2234: astore 17
    //   2236: aload 17
    //   2238: invokevirtual 277	java/io/File:exists	()Z
    //   2241: ifeq -57 -> 2184
    //   2244: aload 17
    //   2246: invokevirtual 311	java/io/File:delete	()Z
    //   2249: pop
    //   2250: goto -66 -> 2184
    //   2253: astore_1
    //   2254: ldc 190
    //   2256: iconst_1
    //   2257: ldc_w 475
    //   2260: aload_1
    //   2261: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2264: goto -1534 -> 730
    //   2267: lconst_0
    //   2268: lstore_2
    //   2269: goto -1445 -> 824
    //   2272: ldc_w 832
    //   2275: astore_1
    //   2276: goto -1221 -> 1055
    //   2279: astore_1
    //   2280: ldc 190
    //   2282: iconst_1
    //   2283: ldc_w 475
    //   2286: aload_1
    //   2287: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2290: ldc_w 834
    //   2293: astore_1
    //   2294: goto -750 -> 1544
    //   2297: astore 17
    //   2299: invokestatic 419	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2302: ifeq +14 -> 2316
    //   2305: ldc 190
    //   2307: iconst_2
    //   2308: ldc_w 475
    //   2311: aload 17
    //   2313: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2316: aload_1
    //   2317: ifnull -663 -> 1654
    //   2320: aload_1
    //   2321: invokevirtual 763	java/io/BufferedOutputStream:close	()V
    //   2324: goto -670 -> 1654
    //   2327: astore_1
    //   2328: goto -674 -> 1654
    //   2331: astore_1
    //   2332: aconst_null
    //   2333: astore 17
    //   2335: aload 17
    //   2337: ifnull +8 -> 2345
    //   2340: aload 17
    //   2342: invokevirtual 763	java/io/BufferedOutputStream:close	()V
    //   2345: aload_1
    //   2346: athrow
    //   2347: astore_1
    //   2348: ldc 190
    //   2350: iconst_1
    //   2351: ldc_w 836
    //   2354: aload_1
    //   2355: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2358: iconst_1
    //   2359: istore 16
    //   2361: goto -480 -> 1881
    //   2364: ldc 190
    //   2366: iconst_1
    //   2367: iconst_4
    //   2368: anewarray 4	java/lang/Object
    //   2371: dup
    //   2372: iconst_0
    //   2373: ldc_w 838
    //   2376: aastore
    //   2377: dup
    //   2378: iconst_1
    //   2379: lload 8
    //   2381: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2384: aastore
    //   2385: dup
    //   2386: iconst_2
    //   2387: ldc_w 475
    //   2390: aastore
    //   2391: dup
    //   2392: iconst_3
    //   2393: lload_2
    //   2394: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2397: aastore
    //   2398: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2401: goto -2372 -> 29
    //   2404: astore_1
    //   2405: goto -751 -> 1654
    //   2408: astore 17
    //   2410: goto -65 -> 2345
    //   2413: astore_1
    //   2414: aload 19
    //   2416: astore 17
    //   2418: goto -83 -> 2335
    //   2421: astore 18
    //   2423: aload_1
    //   2424: astore 17
    //   2426: aload 18
    //   2428: astore_1
    //   2429: goto -94 -> 2335
    //   2432: astore 17
    //   2434: aload 19
    //   2436: astore_1
    //   2437: goto -138 -> 2299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2440	0	this	bdmy
    //   0	2440	1	paramMessage	android.os.Message
    //   160	2234	2	l1	long
    //   135	1430	4	l2	long
    //   1523	11	6	l3	long
    //   798	1582	8	l4	long
    //   909	1107	10	l5	long
    //   924	1140	12	l6	long
    //   939	1173	14	l7	long
    //   1707	653	16	bool	boolean
    //   80	2165	17	localObject1	Object
    //   2297	15	17	localException1	Exception
    //   2333	8	17	localObject2	Object
    //   2408	1	17	localException2	Exception
    //   2416	9	17	localObject3	Object
    //   2432	1	17	localException3	Exception
    //   984	847	18	localObject4	Object
    //   2421	6	18	localObject5	Object
    //   1031	1404	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1395	143	20	str1	String
    //   1390	152	21	str2	String
    //   960	1217	22	localArrayList	java.util.ArrayList
    //   1074	555	23	localStringBuilder	StringBuilder
    //   1228	288	24	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1414	71	25	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   618	657	660	java/lang/Throwable
    //   676	679	682	java/lang/Throwable
    //   727	730	2253	java/lang/Throwable
    //   1408	1416	2279	java/lang/Exception
    //   1428	1439	2279	java/lang/Exception
    //   1447	1477	2279	java/lang/Exception
    //   1484	1508	2279	java/lang/Exception
    //   1515	1525	2279	java/lang/Exception
    //   1015	1033	2297	java/lang/Exception
    //   2320	2324	2327	java/lang/Exception
    //   1015	1033	2331	finally
    //   1767	1878	2347	java/lang/Exception
    //   1649	1654	2404	java/lang/Exception
    //   2340	2345	2408	java/lang/Exception
    //   1033	1051	2413	finally
    //   1055	1230	2413	finally
    //   1235	1376	2413	finally
    //   1376	1389	2413	finally
    //   1408	1416	2413	finally
    //   1428	1439	2413	finally
    //   1447	1477	2413	finally
    //   1484	1508	2413	finally
    //   1515	1525	2413	finally
    //   1544	1644	2413	finally
    //   2280	2290	2413	finally
    //   2299	2316	2421	finally
    //   1033	1051	2432	java/lang/Exception
    //   1055	1230	2432	java/lang/Exception
    //   1235	1376	2432	java/lang/Exception
    //   1376	1389	2432	java/lang/Exception
    //   1544	1644	2432	java/lang/Exception
    //   2280	2290	2432	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmy
 * JD-Core Version:    0.7.0.1
 */