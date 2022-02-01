package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import anqt;
import anqu;
import anue;
import anuk;
import anul;
import anvu;
import anvv;
import anvw;
import anxt;
import anxu;
import anzx;
import aoam;
import aoys;
import arqj;
import avlf;
import bdla;
import bdlr;
import bdmg;
import behh;
import bhhr;
import bhid;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static GuardManager a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static volatile boolean a;
  public static int c;
  public static int d;
  public static int e = 15;
  public int a;
  public long a;
  private Application jdField_a_of_type_AndroidAppApplication;
  private volatile BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private anvw jdField_a_of_type_Anvw;
  public volatile String a;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  Random jdField_a_of_type_JavaUtilRandom;
  anvw[] jdField_a_of_type_ArrayOfAnvw = new anvw[9];
  public long[][] a;
  public int b;
  long b;
  long c;
  long d;
  private int f = 0;
  
  static
  {
    jdField_c_of_type_Int = 5;
    jdField_d_of_type_Int = 10;
  }
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 }));
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    a(paramInt, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label131:
      Foreground.setReady();
      return;
    }
    catch (Throwable paramApplication)
    {
      break label131;
    }
  }
  
  private static Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject = BaseApplication.context;
    HashMap localHashMap = new HashMap();
    localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)((Map.Entry)localIterator.next()).getKey();
          if ((str != null) && (str.equals(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.importance == 100)) {
            localHashMap.put(str, "");
          }
        }
      }
    }
    QLog.d("GuardManager", 1, new Object[] { "[process] filterRealForegroundProcMap: invoked. ", " realProcMap: ", localHashMap });
    return localHashMap;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {}
    switch (paramInt)
    {
    default: 
      if (l1 - ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue() >= 86400000L) {
        break;
      }
    }
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(bhhr.a(paramContext)));
      break;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(bhhr.m(paramContext, paramString)));
      break;
      long l2 = bhid.a(l1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l2));
      switch (paramInt)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("GuardManager", 2, "Daily Report info key=" + paramString + " timeMillisInTodayZero=" + l2 + " nowTime=" + l1);
        return;
        bhhr.a(paramContext, l2);
        bdla.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "start_up", "front", "device_cnt", "", 1, "");
        continue;
        bhhr.k(paramContext, paramString, l2);
        bdla.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "login", "front", "login", "", 1, "");
        continue;
        bhhr.k(paramContext, paramString, l2);
        bdla.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "login", "msf", "login", "", 1, "");
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null)
    {
      AppRuntime localAppRuntime = localBaseApplicationImpl.getRuntime();
      if ((localAppRuntime == null) || (!localBaseApplicationImpl.isRuntimeReady()) || (!localAppRuntime.isLogin())) {
        break label137;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "now login uin=" + localAppRuntime.getAccount() + " isForeground=" + paramBoolean);
      }
      if (paramBoolean) {
        a(paramContext, localAppRuntime.getAccount() + "_Foreground", 1);
      }
      a(paramContext, localAppRuntime.getAccount() + "_Background", 2);
    }
    label137:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GuardManager", 2, "isRuntimeReady=" + localBaseApplicationImpl.isRuntimeReady() + " now login uin=null");
  }
  
  private void a(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (paramMessage.arg1 < 3) {
      a(i);
    }
    this.jdField_a_of_type_Anvw.a(i, paramMessage.obj);
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      long l2;
      try
      {
        if (BaseApplicationImpl.sProcessId != 1) {
          return;
        }
        long l1 = SystemClock.uptimeMillis();
        if ((!paramBoolean) && (l1 - JobReporter.sThreadJobReportLastReportTs.get() < 600000L)) {
          break;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        l2 = JobReporter.sThreadJobReportTotalCount.getAndSet(0L);
        if ((l2 == 0L) || (localQQAppInterface == null) || (!d())) {
          break;
        }
        String str1 = Long.toString(JobReporter.sThreadJobReportCountLevelOne.getAndSet(0L));
        String str2 = Long.toString(JobReporter.sThreadJobReportCountLevelTwo.getAndSet(0L));
        String str3 = Long.toString(JobReporter.sThreadJobReportCountLevelThree.getAndSet(0L));
        if (l2 > 2147483647L)
        {
          i = 2147483647;
          JobReporter.sThreadJobReportLastReportTs.set(l1);
          HashMap localHashMap = new HashMap();
          localHashMap.put("countLevel_1", str1);
          localHashMap.put("countLevel_2", str2);
          localHashMap.put("countLevel_3", str3);
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(localQQAppInterface.getCurrentUin(), "maxThreadManagerJobWait", true, i, 1L, localHashMap, "", false);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GuardManager", 1, "reportThreadJobWaitTime", localThrowable);
        return;
      }
      int i = (int)l2;
    }
  }
  
  private boolean a(Message paramMessage)
  {
    try
    {
      if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5))) {
        BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(7, 0L, 0L);
      }
      if (((paramMessage.arg1 == 2) || (paramMessage.arg1 == 3) || (paramMessage.arg1 == 0)) && ((paramMessage.arg2 == 4) || (paramMessage.arg2 == 6)))
      {
        QQAppInterface.getBatteryStats().b();
        anue.a().a();
      }
      if (this.jdField_a_of_type_JavaUtilRandom == null) {
        this.jdField_a_of_type_JavaUtilRandom = new Random();
      }
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt(20000) != 0) {
        return true;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("before", anvw.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg1]);
      localHashMap.put("after", anvw.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg2]);
      a("GM_guardChangeS", localHashMap);
    }
    catch (Throwable paramMessage)
    {
      label178:
      break label178;
    }
    return false;
  }
  
  private void b(Message paramMessage)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = ((String)paramMessage.obj);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      a((QQAppInterface)localObject1);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new anvv(this);
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
        ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      label89:
      localObject2 = new Intent("com.tencent.plugin.state.change");
      ((Intent)localObject2).putExtra("key_plugin_state", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2);
      a(this.jdField_a_of_type_JavaLangString);
      if (StartService.jdField_a_of_type_Boolean) {
        MemoryManager.getInstance().clearTopAppMemory(BaseApplicationImpl.sApplication, (QQAppInterface)localObject1);
      }
      b(3, paramMessage.obj);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label89;
    }
  }
  
  private boolean b(Message paramMessage)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return true;
    }
    String str = (String)paramMessage.obj;
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = null;
      if (Foreground.sCountActivity > 0)
      {
        this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq";
        return true;
      }
    }
    else
    {
      return true;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label68:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      a(false, str);
      b(4, paramMessage.obj);
      paramMessage = new Intent("com.tencent.plugin.state.change");
      paramMessage.putExtra("key_plugin_state", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramMessage);
      paramMessage = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramMessage.isRunning()) {
        paramMessage.showIdleNotification(BaseApplicationImpl.sApplication, null);
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      break label68;
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null)
    {
      QLog.d("GuardManager", 1, "[isLogin] app is null");
      return false;
    }
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject != null) && (((AppRuntime)localObject).isLogin())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static boolean d()
  {
    if (!ThreadSetting.isPublicVersion) {}
    while (ThreadSetting.isGrayVersion) {
      return true;
    }
    return JobReporter.ramdomReport(10000);
  }
  
  anvw a(int paramInt)
  {
    anvw localanvw = this.jdField_a_of_type_ArrayOfAnvw[paramInt];
    Object localObject = localanvw;
    if (localanvw == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new anuk();
      }
    }
    for (;;)
    {
      ((anvw)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((anvw)localObject).jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfAnvw[paramInt] = localObject;
      return localObject;
      localObject = new anul();
      continue;
      localObject = new anqt();
      continue;
      localObject = new anqu();
      continue;
      localObject = new anxu();
      continue;
      localObject = new anvw();
      continue;
      localObject = new anxt();
      continue;
      localObject = new anzx();
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, String> a()
  {
    try
    {
      Map localMap = a(this.jdField_a_of_type_JavaUtilMap);
      return localMap;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GuardManager", 1, "realForegroundProcessMap: failed. ", localThrowable);
    }
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    a(8, null);
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        label33:
        do
        {
          this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
          CoreService.stopCoreService();
          return;
          localThrowable1 = localThrowable1;
        } while (!QLog.isColorLevel());
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        break label33;
      }
    }
  }
  
  void a(int paramInt)
  {
    int k = (int)(System.currentTimeMillis() / 60000L);
    if (k == this.jdField_b_of_type_Int)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.jdField_a_of_type_Int;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int j;
    if ((k < this.jdField_b_of_type_Int) || (k - this.jdField_b_of_type_Int > 15))
    {
      i = 0;
      while (i < 3)
      {
        j = 0;
        while (j < 15)
        {
          this.jdField_a_of_type_Array2dOfLong[i][j] = 0L;
          j += 1;
        }
        i += 1;
      }
      this.jdField_b_of_type_Int = (k - 15);
      this.jdField_a_of_type_Int = 0;
    }
    int m = (k - this.jdField_b_of_type_Int) % 15;
    int i = 1;
    while (i <= m)
    {
      j = 0;
      while (j < 3)
      {
        this.jdField_a_of_type_Array2dOfLong[j][((this.jdField_a_of_type_Int + i) % 15)] = 0L;
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_Int = k;
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + m) % 15);
    this.jdField_a_of_type_Array2dOfLong[paramInt][this.jdField_a_of_type_Int] = 1L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == ThreadManager.getFileThreadLooper())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "nextState: " + anvw.jdField_a_of_type_ArrayOfJavaLangString[this.f] + ", " + anvw.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject);
      }
      if (this.f == 8) {
        return;
      }
      if (this.f != paramInt)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.f, paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
        this.jdField_a_of_type_Anvw = a(paramInt);
        this.f = paramInt;
      }
      for (;;)
      {
        this.jdField_a_of_type_Anvw.a(5, paramObject);
        return;
        if (paramInt == 0) {
          this.jdField_a_of_type_Anvw = a(paramInt);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_JavaLangString != null))
    {
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getAccount()))) {
        break label92;
      }
      if (this.jdField_b_of_type_Long <= 0L) {
        break label82;
      }
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = 0L;
    }
    for (;;)
    {
      QLog.d("GuardManager", 1, "848QQDT [updateStartTime] resetTime: " + this.jdField_a_of_type_Long);
      return;
      label82:
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    label92:
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void a(String paramString)
  {
    int i = 0;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      int j = AppSetting.a();
      String str = aoam.a();
      boolean bool = c();
      QLog.d("GuardManager", 1, "848QQDT [reportForegroundEvent] isLogin: " + bool);
      if (bool) {
        i = 1;
      }
      bdla.b(localQQAppInterface, "dc00898", "", "", "qq_login", "front_open", 0, 1, i, "", String.valueOf(j), str, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("GuardManager", 1, "848QQDT [reportForegroundEvent]", paramString);
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", anvu.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    int j = (int)(l2 / 1000L);
    int i = j;
    if (l2 % 1000L >= 500L) {
      i = j + 1;
    }
    String str1 = aoam.a();
    String str2 = String.valueOf(AppSetting.a());
    boolean bool = c();
    QLog.d("GuardManager", 1, "848QQDT _reportForeground(" + paramBoolean + "):[" + this.jdField_a_of_type_Long + " - " + l1 + " = " + i + "]，process:" + paramString + ", isLogin: " + bool + ", appid=" + str2 + ", activity =" + str1);
    Object localObject;
    QQAppInterface localQQAppInterface;
    if (i > 0)
    {
      localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
      localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (!bool) {
        break label304;
      }
    }
    label304:
    for (j = 1;; j = 0)
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "Online_time", "Fe_time", 0, i, j, (String)localObject, str2, str1, paramString);
      if (!paramBoolean) {
        break label310;
      }
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_Long = l1;
      QLog.d("GuardManager", 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.jdField_a_of_type_Long);
      return;
    }
    label310:
    this.jdField_a_of_type_Long = 0L;
    QLog.d("GuardManager", 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.jdField_a_of_type_Long);
  }
  
  public void a(boolean paramBoolean, String... paramVarArgs)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = (ActivityManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("activity");
    try
    {
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label318;
          }
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          str1 = localRunningAppProcessInfo.processName;
          i = localRunningAppProcessInfo.pid;
          if ((str1.startsWith("com.tencent.mobileqq")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF"))) {
            if (paramVarArgs != null)
            {
              int k = paramVarArgs.length;
              j = 0;
              i = 0;
              if (j < k)
              {
                String str2 = paramVarArgs[j];
                if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                  break;
                }
                i = 1;
                if (i == 0) {
                  break label298;
                }
                localArrayList3.add(str1);
              }
              if (i != 0) {}
            }
            else
            {
              if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                break label307;
              }
              localArrayList1.add(str1);
              avlf.b(str1);
              if (str1.endsWith(":qzone")) {
                bdlr.a().d(bdlr.a());
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        int j;
        if (QLog.isColorLevel()) {
          QLog.e("GuardManager", 2, "exitProcess: Failed.  exception: ", localThrowable);
        }
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        label298:
        j += 1;
        continue;
        label307:
        localArrayList2.add(str1);
      }
      label318:
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + arqj.a(BaseApplicationImpl.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
      }
      if (localArrayList1.size() > 0)
      {
        paramVarArgs = new Intent("com.tencent.process.exit");
        paramVarArgs.putExtra("exit_type", 101);
        paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
        paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
        paramVarArgs.putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList1, false));
        this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramVarArgs);
      }
    }
  }
  
  public boolean a()
  {
    int i = this.f;
    return (i == 6) || (i == 7) || (i == 5);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "state change:" + paramInt);
      }
      return;
      jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
      a(this.jdField_a_of_type_AndroidAppApplication, jdField_a_of_type_Boolean);
      behh.a(null);
      aoys.a(1);
      continue;
      jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
      a(this.jdField_a_of_type_AndroidAppApplication, jdField_a_of_type_Boolean);
      aoys.a(2);
    }
  }
  
  public void b(String paramString)
  {
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    long l = MemoryManager.getMemory(Process.myPid());
    a(0);
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < 15)
    {
      k = (int)(k + this.jdField_a_of_type_Array2dOfLong[1][i]);
      j = (int)(j + this.jdField_a_of_type_Array2dOfLong[0][i]);
      i += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
    localHashMap.put("resumeCount", String.valueOf(k * 1.0D / 15.0D));
    localHashMap.put("msgCount", String.valueOf(j * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(anvu.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)));
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      a(str, localHashMap);
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    avlf.b(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    Intent localIntent = new Intent("com.tencent.process.exit");
    localIntent.putExtra("exit_type", 101);
    localIntent.putExtra("qq_mode_foreground", paramBoolean);
    localIntent.putStringArrayListExtra("procNameList", localArrayList);
    localIntent.putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList, false));
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + arqj.a(BaseApplicationImpl.getContext()) + ", toExitTargetProcess=" + paramString + " isForeground=" + paramBoolean);
    }
  }
  
  public boolean b()
  {
    int i = this.f;
    return (i == 4) || (i == 6);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  public void c(boolean paramBoolean)
  {
    anvu localanvu = anvu.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    int i = localanvu.jdField_a_of_type_Int;
    long l = localanvu.jdField_b_of_type_Int | i << 8;
    int j = anvu.a().jdField_c_of_type_Int;
    if (paramBoolean) {}
    for (i = 1;; i = 0)
    {
      localAppRuntime.onGuardEvent(5, l, i | j << 8);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
      do
      {
        do
        {
          do
          {
            return true;
          } while (!b(paramMessage));
          return true;
          b(paramMessage);
          return true;
        } while (!a(paramMessage));
        return true;
        a(paramMessage);
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
        this.jdField_a_of_type_Anvw.a();
        return true;
      } while (!b());
      a(this.f + 1, "trick_p_msg");
      return true;
    }
    a(paramMessage.arg1, paramMessage.obj);
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        String str = paramIntent.getAction();
        paramContext = paramIntent.getStringExtra("runningProcessName");
        l = paramIntent.getLongExtra("runningtime", 0L);
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, str + " received with " + paramContext + " at " + l + ", when " + this.jdField_d_of_type_Long + ", " + this.jdField_c_of_type_Long);
        }
        if ((paramContext == null) || ((!paramContext.equals("com.tencent.mobileqq")) && (!paramContext.startsWith("com.tencent.mobileqq:")))) {
          break label424;
        }
        if ("com.tencent.process.stopping".equals(str))
        {
          if ((l >= this.jdField_d_of_type_Long) || (l < this.jdField_d_of_type_Long - 1000000L)) {
            break label418;
          }
          if (l >= 0L) {
            break label425;
          }
          break label418;
          if (bool)
          {
            this.jdField_d_of_type_Long = l;
            paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramContext);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramIntent, 50L);
            this.jdField_a_of_type_JavaUtilMap.remove(paramContext);
            QLog.d("GuardManager", 1, new Object[] { "[process][remove] onReceive: invoked. ", " process: ", paramContext });
          }
          QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_BG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
          return;
        }
        if (!"com.tencent.process.starting".equals(str)) {
          break label424;
        }
        if ((l >= this.jdField_c_of_type_Long) || (l < this.jdField_d_of_type_Long - 1000000L)) {
          break label431;
        }
        if (l >= 0L) {
          break label412;
        }
      }
      catch (Throwable paramContext)
      {
        long l;
        QLog.d("GuardManager", 1, "", paramContext);
        return;
      }
      if (bool)
      {
        this.jdField_c_of_type_Long = l;
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramContext);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        this.jdField_a_of_type_JavaUtilMap.put(paramContext, "");
        QLog.d("GuardManager", 1, new Object[] { "[process][put] onReceive: invoked. ", " process: ", paramContext });
      }
      QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
      return;
      label412:
      boolean bool = false;
      continue;
      label418:
      bool = true;
      continue;
      label424:
      return;
      label425:
      bool = false;
      continue;
      label431:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */