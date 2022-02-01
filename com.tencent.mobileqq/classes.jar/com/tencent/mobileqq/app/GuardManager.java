package com.tencent.mobileqq.app;

import android.app.Activity;
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
import com.tencent.beacon.event.UserAction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.GuardSharedPreUtils;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.mobileqq.utils.QTimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static GuardManager a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static int c;
  public static int d;
  public static int e = 15;
  protected int a;
  long jdField_a_of_type_Long = 0L;
  private Application jdField_a_of_type_AndroidAppApplication;
  private volatile BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GuardState jdField_a_of_type_ComTencentMobileqqAppGuardState = null;
  public volatile String a;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean = false;
  GuardState[] jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardState = new GuardState[9];
  protected long[][] a;
  protected int b;
  long b;
  public volatile String b;
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
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    a(paramInt, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label156:
      Foreground.setReady();
      return;
    }
    catch (Throwable paramApplication)
    {
      break label156;
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
            localHashMap.put(str, paramMap.get(str));
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
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext)));
      break;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext, paramString)));
      break;
      long l2 = QTimeFormatterUtils.a(l1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l2));
      switch (paramInt)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("GuardManager", 2, "Daily Report info key=" + paramString + " timeMillisInTodayZero=" + l2 + " nowTime=" + l1);
        return;
        GuardSharedPreUtils.a(paramContext, l2);
        ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "start_up", "front", "device_cnt", "", 1, "");
        continue;
        GuardSharedPreUtils.a(paramContext, paramString, l2);
        ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "login", "front", "login", "", 1, "");
        continue;
        GuardSharedPreUtils.a(paramContext, paramString, l2);
        ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "login", "msf", "login", "", 1, "");
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = MobileQQ.getMobileQQ();
    if (localMobileQQ != null)
    {
      AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
      if ((localAppRuntime == null) || (!localMobileQQ.isRuntimeReady()) || (!localAppRuntime.isLogin())) {
        break label140;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "now login uin=" + localAppRuntime.getAccount() + " isForeground=" + paramBoolean);
      }
      if (paramBoolean) {
        a(paramContext, localAppRuntime.getAccount() + "_Foreground", 1);
      }
      a(paramContext, localAppRuntime.getAccount() + "_Background", 2);
    }
    label140:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GuardManager", 2, "isRuntimeReady=" + localMobileQQ.isRuntimeReady() + " now login uin=null");
  }
  
  private void a(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (paramMessage.arg1 < 3) {
      a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGuardState.a(i, paramMessage.obj);
  }
  
  public static void a(boolean paramBoolean)
  {
    GuardConfig localGuardConfig = GuardConfig.a();
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    int i = localGuardConfig.jdField_a_of_type_Int;
    long l = localGuardConfig.jdField_b_of_type_Int | i << 8;
    int j = GuardConfig.a().jdField_c_of_type_Int;
    if (paramBoolean) {}
    for (i = 1;; i = 0)
    {
      localAppRuntime.onGuardEvent(5, l, i | j << 8);
      return;
    }
  }
  
  private boolean a(Message paramMessage)
  {
    try
    {
      if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5) || (paramMessage.arg1 == 6) || (paramMessage.arg1 == 7) || (paramMessage.arg1 == 0))) {
        MobileQQ.getMobileQQ().waitAppRuntime(null).onGuardEvent(7, 0L, 0L);
      }
      if (this.jdField_a_of_type_JavaUtilRandom == null) {
        this.jdField_a_of_type_JavaUtilRandom = new Random();
      }
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt(20000) != 0) {
        return true;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("before", GuardState.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg1]);
      localHashMap.put("after", GuardState.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg2]);
      a("GM_guardChangeS", localHashMap);
    }
    catch (Throwable paramMessage)
    {
      label152:
      break label152;
    }
    return false;
  }
  
  private static String b()
  {
    Activity localActivity = Foreground.getTopActivity();
    if (localActivity != null) {
      return localActivity.getClass().getName();
    }
    return "Null";
  }
  
  private void b(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = ((String)paramMessage.obj);
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginFG] old: ", localObject, ", new: ", this.jdField_a_of_type_JavaLangString });
    if (localObject == null)
    {
      a(MobileQQ.getMobileQQ().waitAppRuntime(null));
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GuardManager.ScreenLockReceiver(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      label126:
      localObject = new Intent("com.tencent.plugin.state.change");
      ((Intent)localObject).putExtra("key_plugin_state", 1);
      MobileQQ.getMobileQQ().sendBroadcast((Intent)localObject);
      b(this.jdField_a_of_type_JavaLangString);
      b(3, paramMessage.obj);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label126;
    }
  }
  
  private boolean b(Message paramMessage)
  {
    Object localObject = (String)paramMessage.obj;
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] fgProcess: ", this.jdField_a_of_type_JavaLangString, ", bgProcess: ", localObject, ", activityCount: ", Integer.valueOf(Foreground.getActivityCount()), ", foreground: ", Boolean.valueOf(a()) });
    if (this.jdField_a_of_type_JavaLangString == null) {
      return true;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
    {
      this.jdField_a_of_type_JavaLangString = null;
      if (Foreground.getActivityCount() > 0)
      {
        this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq";
        return true;
      }
    }
    else
    {
      return true;
    }
    if (a()) {
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        long l1 = 0L;
        if (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          String str = (String)((Map.Entry)localObject).getValue();
          if (!TextUtils.isDigitsOnly(str)) {
            break label323;
          }
          long l2 = Long.parseLong(str);
          if (l2 <= l1) {
            break label323;
          }
          this.jdField_a_of_type_JavaLangString = ((String)((Map.Entry)localObject).getKey());
          l1 = l2;
        }
      }
    }
    label268:
    label323:
    for (;;)
    {
      break;
      QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] multi process. fgProcess: ", this.jdField_a_of_type_JavaLangString });
      return true;
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        a(false, (String)localObject);
        b(4, paramMessage.obj);
        paramMessage = new Intent("com.tencent.plugin.state.change");
        paramMessage.putExtra("key_plugin_state", 0);
        MobileQQ.getContext().sendBroadcast(paramMessage);
        return false;
      }
      catch (Throwable localThrowable)
      {
        break label268;
      }
    }
  }
  
  private boolean d()
  {
    boolean bool = true;
    Object localObject = MobileQQ.getMobileQQ();
    if (localObject == null)
    {
      QLog.d("GuardManager", 1, "[isLogin] app is null");
      return false;
    }
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if ((localObject != null) && (((AppRuntime)localObject).isLogin())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int a()
  {
    return GuardConfig.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public long a()
  {
    return GuardConfig.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, MemoryUtils.a(Process.myPid())) / 12000L;
  }
  
  public Application a()
  {
    return this.jdField_a_of_type_AndroidAppApplication;
  }
  
  GuardState a(int paramInt)
  {
    GuardState localGuardState = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardState[paramInt];
    Object localObject = localGuardState;
    if (localGuardState == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new ForgroundMain();
      }
    }
    for (;;)
    {
      ((GuardState)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((GuardState)localObject).jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardState[paramInt] = localObject;
      return localObject;
      localObject = new ForgroundOther();
      continue;
      localObject = new BackgroundGuard();
      continue;
      localObject = new BackgroundUnguard();
      continue;
      localObject = new LiteUnguard();
      continue;
      localObject = new GuardState();
      continue;
      localObject = new LiteGuard();
      continue;
      localObject = new PrestartGuard();
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
        QLog.d("GuardManager", 2, "nextState: " + GuardState.jdField_a_of_type_ArrayOfJavaLangString[this.f] + ", " + GuardState.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject);
      }
      if (this.f == 8) {
        return;
      }
      if (this.f != paramInt)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.f, paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
        this.jdField_a_of_type_ComTencentMobileqqAppGuardState = a(paramInt);
        this.f = paramInt;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardState.a(5, paramObject);
        return;
        if (paramInt == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppGuardState = a(paramInt);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void a(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.a(paramIGuardInterface);
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  protected void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", GuardConfig.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_JavaLangString != null))
    {
      if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramAppRuntime.getAccount()))) {
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
    String str1 = b();
    String str2 = String.valueOf(AppSetting.a());
    boolean bool = d();
    QLog.d("GuardManager", 1, "848QQDT _reportForeground(" + paramBoolean + "):[" + this.jdField_a_of_type_Long + " - " + l1 + " = " + i + "]，process:" + paramString + ", isLogin: " + bool + ", appid=" + str2 + ", activity =" + str1);
    String str3;
    AppRuntime localAppRuntime;
    if (i > 0)
    {
      str3 = NetConnInfoCenter.getServerTimeMillis() + "";
      localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
      if (!bool) {
        break label321;
      }
    }
    label321:
    for (j = 1;; j = 0)
    {
      ReportController.b(localAppRuntime, "CliOper", "", "", "Online_time", "Fe_time", 0, i, j, str3, str2, str1 + "-" + paramString, UserAction.getQIMEI());
      if (!paramBoolean) {
        break label327;
      }
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_Long = l1;
      QLog.d("GuardManager", 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.jdField_a_of_type_Long);
      return;
    }
    label327:
    this.jdField_a_of_type_Long = 0L;
    QLog.d("GuardManager", 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.jdField_a_of_type_Long);
  }
  
  public boolean a()
  {
    if (a().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, new Object[] { "Application isForeground: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = a().containsKey(paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("GuardManager", 2, new Object[] { "process: ", paramString, " isForeground: ", Boolean.valueOf(bool) });
      QLog.d("GuardManager", 2, "call stack: ", new Throwable());
    }
    QGuardUtils.a(new String[] { "processName:", paramString, " isForeground: ", String.valueOf(bool) });
    return bool;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int i = 0;
    while (i < 15)
    {
      arrayOfInt[0] = ((int)(arrayOfInt[0] + this.jdField_a_of_type_Array2dOfLong[1][i]));
      arrayOfInt[1] = ((int)(arrayOfInt[1] + this.jdField_a_of_type_Array2dOfLong[0][i]));
      i += 1;
    }
    return arrayOfInt;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, new Object[] { "GuradManager.onEvent: ", Integer.valueOf(paramInt), " param: ", paramObject });
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "state change:" + paramInt);
      }
      return;
    case 3: 
      a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
      localApplication = this.jdField_a_of_type_AndroidAppApplication;
      if (a().size() > 0) {}
      for (;;)
      {
        a(localApplication, bool1);
        c(3, paramObject);
        break;
        bool1 = false;
      }
    }
    a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
    Application localApplication = this.jdField_a_of_type_AndroidAppApplication;
    if (a().size() > 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      a(localApplication, bool1);
      c(4, paramObject);
      break;
    }
  }
  
  public void b(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.b(paramIGuardInterface);
  }
  
  public void b(String paramString)
  {
    int i = 0;
    try
    {
      AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
      int j = AppSetting.a();
      String str = b();
      boolean bool = d();
      QLog.d("GuardManager", 1, "848QQDT [reportForegroundEvent] isLogin: " + bool);
      if (bool) {
        i = 1;
      }
      ReportController.b(localAppRuntime, "dc00898", "", "", "qq_login", "front_open", 0, 1, i, "", String.valueOf(j), str, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("GuardManager", 1, "848QQDT [reportForegroundEvent]", paramString);
    }
  }
  
  public boolean b()
  {
    int i = this.f;
    return (i == 6) || (i == 7) || (i == 5);
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  void c(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Boolean);
      GuardManagerCallbackDispatcher.a();
      this.jdField_a_of_type_Boolean = true;
      return;
    } while (a().size() != 0);
    GuardManagerCallbackDispatcher.b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    int i = this.f;
    return (i == 4) || (i == 6);
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
        this.jdField_a_of_type_ComTencentMobileqqAppGuardState.a();
        return true;
      } while (!c());
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
          break label471;
        }
        if ("com.tencent.process.stopping".equals(str))
        {
          if ((l >= this.jdField_d_of_type_Long) || (l < this.jdField_d_of_type_Long - 1000000L) || (l < 0L)) {
            break label465;
          }
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramContext)) {
            break label472;
          }
          break label465;
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
          break label471;
        }
        if ((l >= this.jdField_c_of_type_Long) || (l < this.jdField_d_of_type_Long - 1000000L) || (l < 0L)) {
          break label478;
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramContext)) {
          break label459;
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
        this.jdField_a_of_type_JavaUtilMap.put(paramContext, "" + System.currentTimeMillis());
        QLog.d("GuardManager", 1, new Object[] { "[process][put] onReceive: invoked. ", " process: ", paramContext });
      }
      QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
      return;
      label459:
      boolean bool = false;
      continue;
      label465:
      bool = true;
      continue;
      label471:
      return;
      label472:
      bool = false;
      continue;
      label478:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */