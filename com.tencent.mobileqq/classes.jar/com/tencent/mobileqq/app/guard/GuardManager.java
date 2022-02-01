package com.tencent.mobileqq.app.guard;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
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
  private GuardState jdField_a_of_type_ComTencentMobileqqAppGuardGuardState = null;
  public volatile String a;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean = false;
  GuardState[] jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardGuardState = new GuardState[9];
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
    if ("com.tencent.mobileqq".equals(MobileQQ.processName))
    {
      this.jdField_a_of_type_AndroidAppApplication = paramApplication;
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      a(paramInt, null);
      paramApplication = new IntentFilter("com.tencent.process.stopping");
      paramApplication.addAction("com.tencent.process.starting");
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label167:
      Foreground.setReady();
      return;
      throw new RuntimeException("GuardManager cannot instantiate at sub process!!!");
    }
    catch (Throwable paramApplication)
    {
      break label167;
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
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      if (paramInt != 0)
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext, paramString)));
        }
      }
      else {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext)));
      }
    }
    if (l1 - ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue() < 86400000L) {
      return;
    }
    long l2 = QTimeFormatterUtils.a(l1);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l2));
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          GuardSharedPreUtils.a(paramContext, paramString, l2);
          ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "login", "msf", "login", "", 1, "");
        }
      }
      else
      {
        GuardSharedPreUtils.a(paramContext, paramString, l2);
        ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "login", "front", "login", "", 1, "");
      }
    }
    else
    {
      GuardSharedPreUtils.a(paramContext, l2);
      ReportController.b(MobileQQ.getMobileQQ().waitAppRuntime(null), "start_up", "front", "device_cnt", "", 1, "");
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("Daily Report info key=");
      paramContext.append(paramString);
      paramContext.append(" timeMillisInTodayZero=");
      paramContext.append(l2);
      paramContext.append(" nowTime=");
      paramContext.append(l1);
      QLog.d("GuardManager", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = MobileQQ.getMobileQQ();
    if (localObject != null)
    {
      AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
      if ((localAppRuntime != null) && (((MobileQQ)localObject).isRuntimeReady()) && (localAppRuntime.isLogin()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("now login uin=");
          ((StringBuilder)localObject).append(localAppRuntime.getAccount());
          ((StringBuilder)localObject).append(" isForeground=");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
        }
        if (paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAppRuntime.getAccount());
          ((StringBuilder)localObject).append("_Foreground");
          a(paramContext, ((StringBuilder)localObject).toString(), 1);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localAppRuntime.getAccount());
        ((StringBuilder)localObject).append("_Background");
        a(paramContext, ((StringBuilder)localObject).toString(), 2);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isRuntimeReady=");
        paramContext.append(((MobileQQ)localObject).isRuntimeReady());
        paramContext.append(" now login uin=null");
        QLog.d("GuardManager", 2, paramContext.toString());
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (paramMessage.arg1 < 3) {
      b(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardState.a(i, paramMessage.obj);
  }
  
  public static void a(boolean paramBoolean)
  {
    GuardConfig localGuardConfig = GuardConfig.a();
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    int i = localGuardConfig.jdField_a_of_type_Int;
    localAppRuntime.onGuardEvent(5, localGuardConfig.jdField_b_of_type_Int | i << 8, paramBoolean | GuardConfig.a().jdField_c_of_type_Int << 8);
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
    paramMessage = (Bundle)paramMessage.obj;
    String str = this.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = paramMessage.getString("process");
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginFG] old: ", str, ", new: ", this.jdField_a_of_type_JavaLangString });
    GuardStateScheduler.a().a(this.jdField_a_of_type_JavaLangString, String.valueOf(paramMessage.getLong("event_time")));
    if (str == null)
    {
      a(MobileQQ.getMobileQQ().waitAppRuntime(null));
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GuardManager.ScreenLockReceiver(this);
        paramMessage = new IntentFilter();
        paramMessage.addAction("android.intent.action.SCREEN_OFF");
        paramMessage.addAction("android.intent.action.SCREEN_ON");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramMessage);
      label154:
      paramMessage = new Intent("com.tencent.plugin.state.change");
      paramMessage.putExtra("key_plugin_state", 1);
      MobileQQ.getMobileQQ().sendBroadcast(paramMessage);
      b(this.jdField_a_of_type_JavaLangString);
      b(3, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable paramMessage)
    {
      break label154;
    }
  }
  
  private boolean b(Message paramMessage)
  {
    paramMessage = ((Bundle)paramMessage.obj).getString("process");
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] fgProcess: ", this.jdField_a_of_type_JavaLangString, ", bgProcess: ", paramMessage, ", activityCount: ", Integer.valueOf(Foreground.getActivityCount()), ", foreground: ", Boolean.valueOf(a()) });
    GuardStateScheduler.a().b(paramMessage, String.valueOf(0));
    if (this.jdField_a_of_type_JavaLangString == null) {
      return true;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramMessage))
    {
      this.jdField_a_of_type_JavaLangString = null;
      if (Foreground.getActivityCount() > 0)
      {
        this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq";
        return true;
      }
      if (a())
      {
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          long l1 = 0L;
          paramMessage = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (paramMessage.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramMessage.next();
            String str = (String)localEntry.getValue();
            if (TextUtils.isDigitsOnly(str))
            {
              long l2 = Long.parseLong(str);
              if (l2 > l1)
              {
                this.jdField_a_of_type_JavaLangString = ((String)localEntry.getKey());
                l1 = l2;
              }
            }
          }
        }
        QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] multi process. fgProcess: ", this.jdField_a_of_type_JavaLangString });
        return true;
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label279:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      a(false, paramMessage);
      b(4, paramMessage);
      paramMessage = new Intent("com.tencent.plugin.state.change");
      paramMessage.putExtra("key_plugin_state", 0);
      MobileQQ.getContext().sendBroadcast(paramMessage);
      return false;
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label279;
    }
  }
  
  private boolean d()
  {
    Object localObject = MobileQQ.getMobileQQ();
    boolean bool2 = false;
    if (localObject == null)
    {
      QLog.d("GuardManager", 1, "[isLogin] app is null");
      return false;
    }
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((AppRuntime)localObject).isLogin()) {
        bool1 = true;
      }
    }
    return bool1;
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
    GuardState localGuardState = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardGuardState[paramInt];
    Object localObject = localGuardState;
    if (localGuardState == null)
    {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 7: 
        localObject = new LiteUnguard();
        break;
      case 6: 
        localObject = new LiteGuard();
        break;
      case 5: 
        localObject = new BackgroundUnguard();
        break;
      case 4: 
        localObject = new BackgroundGuard();
        break;
      case 3: 
        localObject = new ForgroundOther();
        break;
      case 2: 
        localObject = new ForgroundMain();
        break;
      case 1: 
        localObject = new PrestartGuard();
        break;
      case 0: 
      case 8: 
        localObject = new GuardState();
      }
      ((GuardState)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager = this;
      ((GuardState)localObject).jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppGuardGuardState[paramInt] = localObject;
    }
    return localObject;
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
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label53:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      CoreService.stopCoreService();
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label53;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.f;
    if (i != 0) {
      QLog.d("GuardManager", 1, new Object[] { "GuardManager preStartEvent, but GuardStateIs null empty: ", Integer.valueOf(i) });
    }
    i = 6;
    if (paramInt == 2) {
      i = 1;
    }
    a(i, null);
  }
  
  void a(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == ThreadManager.getFileThreadLooper())
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nextState: ");
        ((StringBuilder)localObject).append(GuardState.jdField_a_of_type_ArrayOfJavaLangString[this.f]);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(GuardState.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
      }
      int i = this.f;
      if (i == 8) {
        return;
      }
      if (i != paramInt)
      {
        QGuardUtils.a(new String[] { "GuardStateChange to: ", GuardState.jdField_a_of_type_ArrayOfJavaLangString[paramInt] });
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.f, paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
        this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardState = a(paramInt);
        this.f = paramInt;
      }
      else if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardState = a(paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardState.a(5, paramObject);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void a(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.a(paramIGuardInterface);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("process", paramString);
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localBundle);
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
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
      {
        long l = this.jdField_b_of_type_Long;
        if (l > 0L)
        {
          this.jdField_a_of_type_Long = l;
          this.jdField_b_of_type_Long = 0L;
        }
        else
        {
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("848QQDT [updateStartTime] resetTime: ");
        paramAppRuntime.append(this.jdField_a_of_type_Long);
        QLog.d("GuardManager", 1, paramAppRuntime.toString());
        return;
      }
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    boolean bool;
    if (a().size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, new Object[] { "Application isForeground: ", Boolean.valueOf(bool) });
    }
    return bool;
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
      long l = arrayOfInt[0];
      long[][] arrayOfLong = this.jdField_a_of_type_Array2dOfLong;
      arrayOfInt[0] = ((int)(l + arrayOfLong[1][i]));
      arrayOfInt[1] = ((int)(arrayOfInt[1] + arrayOfLong[0][i]));
      i += 1;
    }
    return arrayOfInt;
  }
  
  int b()
  {
    return this.f;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  void b(int paramInt)
  {
    int k = (int)(System.currentTimeMillis() / 60000L);
    int i = this.jdField_b_of_type_Int;
    if (k == i)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.jdField_a_of_type_Int;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int j;
    if ((k < i) || (k - i > 15))
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
    i = 1;
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
  
  public void b(int paramInt, Object paramObject)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool3) {
      QLog.d("GuardManager", 2, new Object[] { "GuradManager.onEvent: ", Integer.valueOf(paramInt), " param: ", paramObject });
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
    Application localApplication;
    if (paramInt != 3)
    {
      if (paramInt == 4)
      {
        a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
        localApplication = this.jdField_a_of_type_AndroidAppApplication;
        if (a().size() <= 0) {
          bool1 = false;
        }
        a(localApplication, bool1);
        c(4, paramObject);
      }
    }
    else
    {
      a(this.jdField_a_of_type_AndroidAppApplication, "daily_boot_report", 0);
      localApplication = this.jdField_a_of_type_AndroidAppApplication;
      if (a().size() > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      a(localApplication, bool1);
      c(3, paramObject);
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("state change:");
      paramObject.append(paramInt);
      QLog.d("GuardManager", 2, paramObject.toString());
    }
  }
  
  public void b(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.b(paramIGuardInterface);
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        int j = AppSetting.a();
        String str = b();
        boolean bool = d();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("848QQDT [reportForegroundEvent] isLogin: ");
        localStringBuilder.append(bool);
        QLog.d("GuardManager", 1, localStringBuilder.toString());
        if (bool)
        {
          i = 1;
          ReportController.b(localAppRuntime, "dc00898", "", "", "qq_login", "front_open", 0, 1, i, "", String.valueOf(j), str, paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("GuardManager", 1, "848QQDT [reportForegroundEvent]", paramString);
        return;
      }
      int i = 0;
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
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return;
      }
      if (a().size() == 0)
      {
        GuardManagerCallbackDispatcher.b();
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      GuardManagerCallbackDispatcher.a();
      this.jdField_a_of_type_Boolean = true;
    }
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
      return true;
    case 7: 
      if (c())
      {
        a(this.f + 1, "trick_p_msg");
        return true;
      }
      break;
    case 6: 
      a(paramMessage.arg1, paramMessage.obj);
      return true;
    case 5: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
      this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardState.a();
      return true;
    case 4: 
      a(paramMessage);
      return true;
    case 3: 
      if (a(paramMessage)) {
        return true;
      }
      break;
    case 2: 
      b(paramMessage);
      return true;
    case 1: 
      if (!b(paramMessage)) {
        break;
      }
    }
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        localObject = paramIntent.getAction();
        paramContext = paramIntent.getStringExtra("runningProcessName");
        l1 = paramIntent.getLongExtra("runningtime", 0L);
        l2 = paramIntent.getLongExtra("event_time", 0L);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append((String)localObject);
          paramIntent.append(" received with ");
          paramIntent.append(paramContext);
          paramIntent.append(" at ");
          paramIntent.append(l1);
          paramIntent.append(", when ");
          paramIntent.append(this.jdField_d_of_type_Long);
          paramIntent.append(", ");
          paramIntent.append(this.jdField_c_of_type_Long);
          QLog.d("GuardManager", 2, paramIntent.toString());
        }
        if ((paramContext == null) || ((!paramContext.equals("com.tencent.mobileqq")) && (!paramContext.startsWith("com.tencent.mobileqq:")))) {
          break label552;
        }
        bool = "com.tencent.process.stopping".equals(localObject);
        if (bool)
        {
          if ((l1 >= this.jdField_d_of_type_Long) || (l1 < this.jdField_d_of_type_Long - 1000000L) || (l1 < 0L)) {
            break label559;
          }
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramContext)) {
            break label553;
          }
          break label559;
          if (bool)
          {
            this.jdField_d_of_type_Long = l1;
            paramIntent = new Bundle();
            paramIntent.putString("process", paramContext);
            paramIntent.putLong("event_time", l2);
            paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramIntent);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramIntent, 50L);
            this.jdField_a_of_type_JavaUtilMap.remove(paramContext);
            QLog.d("GuardManager", 1, new Object[] { "[process][remove] onReceive: invoked. ", " process: ", paramContext });
          }
          QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_BG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
          return;
        }
        if (!"com.tencent.process.starting".equals(localObject)) {
          break label552;
        }
        if ((l1 >= this.jdField_c_of_type_Long) || (l1 < this.jdField_d_of_type_Long - 1000000L) || (l1 < 0L)) {
          break label571;
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramContext)) {
          break label565;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        long l1;
        long l2;
        QLog.d("GuardManager", 1, "", paramContext);
      }
      if (bool)
      {
        this.jdField_c_of_type_Long = l1;
        paramIntent = new Bundle();
        paramIntent.putString("process", paramContext);
        paramIntent.putLong("event_time", l2);
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramIntent);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        paramIntent = this.jdField_a_of_type_JavaUtilMap;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(l2);
        paramIntent.put(paramContext, ((StringBuilder)localObject).toString());
        QLog.d("GuardManager", 1, new Object[] { "[process][put] onReceive: invoked. ", " process: ", paramContext });
      }
      QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
      return;
      label552:
      return;
      label553:
      boolean bool = false;
      continue;
      label559:
      bool = true;
      continue;
      label565:
      bool = false;
      continue;
      label571:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardManager
 * JD-Core Version:    0.7.0.1
 */