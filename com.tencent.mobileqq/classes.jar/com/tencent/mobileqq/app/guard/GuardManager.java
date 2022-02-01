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
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
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
  private static final String ACTION_PLUGIN_BG = "com.tencent.process.stopping";
  private static final String ACTION_PLUGIN_FG = "com.tencent.process.starting";
  public static final String ACTION_PLUGIN_STATE_CHANGE = "com.tencent.plugin.state.change";
  public static final int EVENT_MAIN = 6;
  public static final int EVENT_MSG = 0;
  public static final int EVENT_RESUME = 1;
  public static final String GM_VERSION = "20140619";
  public static final int GUARD_BGFETCH = 1;
  public static final int GUARD_EMPTY = 0;
  public static final int GUARD_LITE = 6;
  public static final String KEY_PLUGIN_STATE = "key_plugin_state";
  public static final long MIN_BETWEEN_TWO_REPORT = 600000L;
  private static final int MSG_GUARD_EVENT = 4;
  private static final int MSG_NEXT_STATE = 6;
  private static final int MSG_QQPLUGIN_BG = 1;
  private static final int MSG_QQPLUGIN_FG = 2;
  private static final int MSG_REPORT_CHANGE = 3;
  private static final int MSG_TICK = 5;
  private static final int MSG_UNGUARD = 7;
  public static final int PERIOD_TIMER = 12000;
  protected static final String PROCESS_MSG = "fake_p_msg";
  public static final String PROCESS_NAME = "process";
  protected static final String PROCESS_TRICK = "trick_p_msg";
  public static final int REPORT_ALIVE = 0;
  public static final int REPORT_LOGIN_BACKGROUND = 2;
  public static final int REPORT_LOGIN_FOREGROUND = 1;
  public static final int STATE_TO_BACKGROUND = 0;
  public static final int STATE_TO_FOREGROUND = 1;
  public static int SUICIDE_FACTOR = 0;
  public static final String TAG = "GuardManager";
  protected static final int TICK_FOREGROUND_KILL_QZONE = 15;
  public static final int TICK_KILL_ALL = 50;
  protected static final int TICK_KILL_OTHER = 3;
  protected static final int TICK_MSG_GUARD = 2;
  public static final int TICK_REPORT_MEM = 1;
  public static final int TYPE_MM = 101;
  public static GuardManager sInstance;
  public static int sTickQZoneBgKill = 15;
  public static int sTickToolBgFgKill;
  private static ConcurrentHashMap<String, Long> timeMillisInTodayZeroMap = new ConcurrentHashMap();
  private boolean isLastCallbackFG = false;
  public volatile String lastProcess = null;
  long mBgTime = 0L;
  private Application mContext;
  protected long[][] mCountEvents = (long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 });
  public volatile String mFgProcess = null;
  long mFgTime = 0L;
  private final Map<String, String> mForegroundProcessMap;
  private Handler mHandler;
  protected int mLastIndex = 0;
  protected int mLastMinute = 0;
  long mNoLoginedUinStartTime = 0L;
  private volatile BroadcastReceiver mScreenLockReceiver;
  long mStartTime = 0L;
  private GuardState mState = null;
  GuardState[] mStateCache = new GuardState[9];
  private int mStateId = 0;
  Random random;
  
  static
  {
    SUICIDE_FACTOR = 5;
    sTickToolBgFgKill = 10;
  }
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    if ("com.tencent.mobileqq".equals(MobileQQ.processName))
    {
      this.mContext = paramApplication;
      this.mHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      this.mForegroundProcessMap = new ConcurrentHashMap();
      nextState(paramInt, null);
      paramApplication = new IntentFilter("com.tencent.process.stopping");
      paramApplication.addAction("com.tencent.process.starting");
    }
    try
    {
      this.mContext.registerReceiver(this, paramApplication);
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
  
  private static Map<String, String> filteredRealForegroundProcMap(Map<String, String> paramMap)
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
  
  private static String getTopActivityName()
  {
    Activity localActivity = Foreground.getTopActivity();
    if (localActivity != null) {
      return localActivity.getClass().getName();
    }
    return "Null";
  }
  
  private void handleMessageForGuardEvent(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (paramMessage.arg1 < 3) {
      updateActiveStatistic(i);
    }
    this.mState.a(i, paramMessage.obj);
  }
  
  private boolean handleMessageForQQPluginBG(Message paramMessage)
  {
    paramMessage = ((Bundle)paramMessage.obj).getString("process");
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] fgProcess: ", this.mFgProcess, ", bgProcess: ", paramMessage, ", activityCount: ", Integer.valueOf(Foreground.getActivityCount()), ", foreground: ", Boolean.valueOf(isApplicationForeground()) });
    GuardStateScheduler.a().b(paramMessage, String.valueOf(0));
    if (this.mFgProcess == null) {
      return true;
    }
    if (TextUtils.equals(this.mFgProcess, paramMessage))
    {
      this.mFgProcess = null;
      if (Foreground.getActivityCount() > 0)
      {
        this.mFgProcess = "com.tencent.mobileqq";
        return true;
      }
      if (isApplicationForeground())
      {
        if (this.mFgProcess == null)
        {
          long l1 = 0L;
          paramMessage = this.mForegroundProcessMap.entrySet().iterator();
          while (paramMessage.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramMessage.next();
            String str = (String)localEntry.getValue();
            if (TextUtils.isDigitsOnly(str))
            {
              long l2 = Long.parseLong(str);
              if (l2 > l1)
              {
                this.mFgProcess = ((String)localEntry.getKey());
                l1 = l2;
              }
            }
          }
        }
        QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginBG] multi process. fgProcess: ", this.mFgProcess });
        return true;
      }
      if (this.mScreenLockReceiver == null) {}
    }
    try
    {
      this.mContext.unregisterReceiver(this.mScreenLockReceiver);
      label278:
      this.mScreenLockReceiver = null;
      reportForegroundRunningTime(false, paramMessage);
      onEvent(4, paramMessage);
      paramMessage = new Intent("com.tencent.plugin.state.change");
      paramMessage.putExtra("key_plugin_state", 0);
      MobileQQ.getContext().sendBroadcast(paramMessage);
      return false;
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label278;
    }
  }
  
  private void handleMessageForQQPluginFG(Message paramMessage)
  {
    paramMessage = (Bundle)paramMessage.obj;
    String str = this.mFgProcess;
    this.lastProcess = this.mFgProcess;
    this.mFgProcess = paramMessage.getString("process");
    QLog.d("GuardManager", 1, new Object[] { "[handleMessageForQQPluginFG] old: ", str, ", new: ", this.mFgProcess });
    GuardStateScheduler.a().a(this.mFgProcess, String.valueOf(paramMessage.getLong("event_time")));
    if (str == null)
    {
      updateStartTime(MobileQQ.getMobileQQ().waitAppRuntime(null));
      if (this.mScreenLockReceiver == null)
      {
        this.mScreenLockReceiver = new GuardManager.ScreenLockReceiver(this);
        paramMessage = new IntentFilter();
        paramMessage.addAction("android.intent.action.SCREEN_OFF");
        paramMessage.addAction("android.intent.action.SCREEN_ON");
      }
    }
    try
    {
      this.mContext.registerReceiver(this.mScreenLockReceiver, paramMessage);
      label153:
      paramMessage = new Intent("com.tencent.plugin.state.change");
      paramMessage.putExtra("key_plugin_state", 1);
      MobileQQ.getMobileQQ().sendBroadcast(paramMessage);
      reportForegroundEvent(this.mFgProcess);
      onEvent(3, this.mFgProcess);
      return;
    }
    catch (Throwable paramMessage)
    {
      break label153;
    }
  }
  
  private boolean handleMessageForReportChange(Message paramMessage)
  {
    try
    {
      if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5) || (paramMessage.arg1 == 6) || (paramMessage.arg1 == 7) || (paramMessage.arg1 == 0))) {
        MobileQQ.getMobileQQ().waitAppRuntime(null).onGuardEvent(7, 0L, 0L);
      }
      if (this.random == null) {
        this.random = new Random();
      }
      if (this.random.nextInt(20000) != 0) {
        return true;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("before", GuardState.c[paramMessage.arg1]);
      localHashMap.put("after", GuardState.c[paramMessage.arg2]);
      report("GM_guardChangeS", localHashMap);
    }
    catch (Throwable paramMessage)
    {
      label152:
      break label152;
    }
    return false;
  }
  
  private boolean isLogin()
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
  
  public static void reportDailyInfo(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      if (!PrivacyPolicyHelper.d())
      {
        QLog.d("GuardManager", 1, "privacy is not allowed");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GuardManager", 1, "reportDailyInfo err: ", localThrowable);
      long l1 = System.currentTimeMillis();
      if (!timeMillisInTodayZeroMap.containsKey(paramString)) {
        if (paramInt != 0)
        {
          if ((paramInt == 1) || (paramInt == 2)) {
            timeMillisInTodayZeroMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext, paramString)));
          }
        }
        else {
          timeMillisInTodayZeroMap.put(paramString, Long.valueOf(GuardSharedPreUtils.a(paramContext)));
        }
      }
      if (l1 - ((Long)timeMillisInTodayZeroMap.get(paramString)).longValue() < 86400000L) {
        return;
      }
      long l2 = QTimeFormatterUtils.a(l1);
      timeMillisInTodayZeroMap.put(paramString, Long.valueOf(l2));
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
  }
  
  public static void reportLoginActive(Context paramContext, boolean paramBoolean)
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
          reportDailyInfo(paramContext, ((StringBuilder)localObject).toString(), 1);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localAppRuntime.getAccount());
        ((StringBuilder)localObject).append("_Background");
        reportDailyInfo(paramContext, ((StringBuilder)localObject).toString(), 2);
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
  
  public static void reportStart(boolean paramBoolean)
  {
    GuardConfig localGuardConfig = GuardConfig.a();
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    int i = localGuardConfig.e;
    localAppRuntime.onGuardEvent(5, localGuardConfig.f | i << 8, paramBoolean | GuardConfig.a().h << 8);
  }
  
  void cancelTimer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    this.mHandler.removeMessages(5);
  }
  
  void dispatcherEvent(int paramInt, Object paramObject)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return;
      }
      if (realForegroundProcessMap().size() == 0)
      {
        GuardManagerCallbackDispatcher.b();
        this.isLastCallbackFG = false;
      }
    }
    else if (!this.isLastCallbackFG)
    {
      GuardManagerCallbackDispatcher.a();
      this.isLastCallbackFG = true;
    }
  }
  
  public void exit()
  {
    nextState(8, null);
    try
    {
      this.mContext.unregisterReceiver(this);
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
    }
    if (this.mScreenLockReceiver != null) {}
    try
    {
      this.mContext.unregisterReceiver(this.mScreenLockReceiver);
      label53:
      this.mScreenLockReceiver = null;
      this.mHandler.removeMessages(5);
      CoreService.stopCoreService();
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label53;
    }
  }
  
  public int getActivateLevel()
  {
    return GuardConfig.a().a(this.mCountEvents, this.mLastIndex, this.mLastMinute);
  }
  
  public int[] getActiveCount()
  {
    int[] arrayOfInt = new int[2];
    int i = 0;
    while (i < 15)
    {
      long l = arrayOfInt[0];
      long[][] arrayOfLong = this.mCountEvents;
      arrayOfInt[0] = ((int)(l + arrayOfLong[1][i]));
      arrayOfInt[1] = ((int)(arrayOfInt[1] + arrayOfLong[0][i]));
      i += 1;
    }
    return arrayOfInt;
  }
  
  public Application getContext()
  {
    return this.mContext;
  }
  
  public String getForegroundProcess()
  {
    return this.mFgProcess;
  }
  
  GuardState getState(int paramInt)
  {
    GuardState localGuardState = this.mStateCache[paramInt];
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
      ((GuardState)localObject).e = this;
      ((GuardState)localObject).d = paramInt;
      this.mStateCache[paramInt] = localObject;
    }
    return localObject;
  }
  
  int getStateId()
  {
    return this.mStateId;
  }
  
  public long getTimeout()
  {
    return GuardConfig.a().a(this.mCountEvents, this.mLastIndex, this.mLastMinute, MemoryUtils.a(Process.myPid())) / 12000L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 7: 
      if (isGuardState())
      {
        nextState(this.mStateId + 1, "trick_p_msg");
        return true;
      }
      break;
    case 6: 
      nextState(paramMessage.arg1, paramMessage.obj);
      return true;
    case 5: 
      this.mHandler.sendEmptyMessageDelayed(5, 12000L);
      this.mState.a();
      return true;
    case 4: 
      handleMessageForGuardEvent(paramMessage);
      return true;
    case 3: 
      if (handleMessageForReportChange(paramMessage)) {
        return true;
      }
      break;
    case 2: 
      handleMessageForQQPluginFG(paramMessage);
      return true;
    case 1: 
      if (!handleMessageForQQPluginBG(paramMessage)) {
        break;
      }
    }
    return true;
  }
  
  public boolean isApplicationForeground()
  {
    boolean bool;
    if (realForegroundProcessMap().size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, new Object[] { "Application isForeground: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isGuardState()
  {
    int i = this.mStateId;
    return (i == 4) || (i == 6);
  }
  
  public boolean isLiteOrUnguard()
  {
    int i = this.mStateId;
    return (i == 6) || (i == 7) || (i == 5);
  }
  
  public boolean isProcessForeground(String paramString)
  {
    boolean bool = realForegroundProcessMap().containsKey(paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("GuardManager", 2, new Object[] { "process: ", paramString, " isForeground: ", Boolean.valueOf(bool) });
      QLog.d("GuardManager", 2, "call stack: ", new Throwable());
    }
    QGuardUtils.a(new String[] { "processName:", paramString, " isForeground: ", String.valueOf(bool) });
    return bool;
  }
  
  void nextState(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == ThreadManager.getFileThreadLooper())
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nextState: ");
        ((StringBuilder)localObject).append(GuardState.c[this.mStateId]);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(GuardState.c[paramInt]);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
      }
      int i = this.mStateId;
      if (i == 8) {
        return;
      }
      if (i != paramInt)
      {
        QGuardUtils.a(new String[] { "GuardStateChange to: ", GuardState.c[paramInt] });
        localObject = this.mHandler.obtainMessage(3, this.mStateId, paramInt);
        this.mHandler.sendMessageDelayed((Message)localObject, 1000L);
        this.mState = getState(paramInt);
        this.mStateId = paramInt;
      }
      else if (paramInt == 0)
      {
        this.mState = getState(paramInt);
      }
      this.mState.a(5, paramObject);
      return;
    }
    this.mHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void noticeSubThreadBackground(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("process", paramString);
    paramString = this.mHandler.obtainMessage(1, localBundle);
    this.mHandler.sendMessage(paramString);
  }
  
  public void onEvent(int paramInt, Object paramObject)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool3) {
      QLog.d("GuardManager", 2, new Object[] { "GuradManager.onEvent: ", Integer.valueOf(paramInt), " param: ", paramObject });
    }
    this.mHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
    Application localApplication;
    if (paramInt != 3)
    {
      if (paramInt == 4)
      {
        reportDailyInfo(this.mContext, "daily_boot_report", 0);
        localApplication = this.mContext;
        if (realForegroundProcessMap().size() <= 0) {
          bool1 = false;
        }
        reportLoginActive(localApplication, bool1);
        dispatcherEvent(4, paramObject);
      }
    }
    else
    {
      reportDailyInfo(this.mContext, "daily_boot_report", 0);
      localApplication = this.mContext;
      if (realForegroundProcessMap().size() > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      reportLoginActive(localApplication, bool1);
      dispatcherEvent(3, paramObject);
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("state change:");
      paramObject.append(paramInt);
      QLog.d("GuardManager", 2, paramObject.toString());
    }
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
          paramIntent.append(this.mBgTime);
          paramIntent.append(", ");
          paramIntent.append(this.mFgTime);
          QLog.d("GuardManager", 2, paramIntent.toString());
        }
        if ((paramContext == null) || ((!paramContext.equals("com.tencent.mobileqq")) && (!paramContext.startsWith("com.tencent.mobileqq:")))) {
          break label550;
        }
        bool = "com.tencent.process.stopping".equals(localObject);
        if (bool)
        {
          if ((l1 >= this.mBgTime) || (l1 < this.mBgTime - 1000000L) || (l1 < 0L)) {
            break label557;
          }
          if (!this.mForegroundProcessMap.containsKey(paramContext)) {
            break label551;
          }
          break label557;
          if (bool)
          {
            this.mBgTime = l1;
            paramIntent = new Bundle();
            paramIntent.putString("process", paramContext);
            paramIntent.putLong("event_time", l2);
            paramIntent = this.mHandler.obtainMessage(1, paramIntent);
            this.mHandler.sendMessageDelayed(paramIntent, 50L);
            this.mForegroundProcessMap.remove(paramContext);
            QLog.d("GuardManager", 1, new Object[] { "[process][remove] onReceive: invoked. ", " process: ", paramContext });
          }
          QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_BG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
          return;
        }
        if (!"com.tencent.process.starting".equals(localObject)) {
          break label550;
        }
        if ((l1 >= this.mFgTime) || (l1 < this.mBgTime - 1000000L) || (l1 < 0L)) {
          break label569;
        }
        if (this.mForegroundProcessMap.containsKey(paramContext)) {
          break label563;
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
        this.mFgTime = l1;
        paramIntent = new Bundle();
        paramIntent.putString("process", paramContext);
        paramIntent.putLong("event_time", l2);
        paramIntent = this.mHandler.obtainMessage(2, paramIntent);
        this.mHandler.sendMessage(paramIntent);
        paramIntent = this.mForegroundProcessMap;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(l2);
        paramIntent.put(paramContext, ((StringBuilder)localObject).toString());
        QLog.d("GuardManager", 1, new Object[] { "[process][put] onReceive: invoked. ", " process: ", paramContext });
      }
      QLog.d("GuardManager", 1, new Object[] { "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(bool) });
      return;
      label550:
      return;
      label551:
      boolean bool = false;
      continue;
      label557:
      bool = true;
      continue;
      label563:
      bool = false;
      continue;
      label569:
      bool = true;
    }
  }
  
  public Map<String, String> realForegroundProcessMap()
  {
    try
    {
      Map localMap = filteredRealForegroundProcMap(this.mForegroundProcessMap);
      return localMap;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GuardManager", 1, "realForegroundProcessMap: failed. ", localThrowable);
    }
    return this.mForegroundProcessMap;
  }
  
  public void registerCallBack(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.a(paramIGuardInterface);
  }
  
  protected void report(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", GuardConfig.a().i);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void reportForegroundEvent(String paramString)
  {
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        int j = AppSetting.d();
        String str = getTopActivityName();
        boolean bool = isLogin();
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
  
  public void reportForegroundRunningTime(boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void startTimer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.mHandler.removeMessages(5);
    this.mHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  public void unregisterCallback(IGuardInterface paramIGuardInterface)
  {
    GuardManagerCallbackDispatcher.b(paramIGuardInterface);
  }
  
  void updateActiveStatistic(int paramInt)
  {
    int k = (int)(System.currentTimeMillis() / 60000L);
    int i = this.mLastMinute;
    if (k == i)
    {
      long[] arrayOfLong = this.mCountEvents[paramInt];
      paramInt = this.mLastIndex;
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
          this.mCountEvents[i][j] = 0L;
          j += 1;
        }
        i += 1;
      }
      this.mLastMinute = (k - 15);
      this.mLastIndex = 0;
    }
    int m = (k - this.mLastMinute) % 15;
    i = 1;
    while (i <= m)
    {
      j = 0;
      while (j < 3)
      {
        this.mCountEvents[j][((this.mLastIndex + i) % 15)] = 0L;
        j += 1;
      }
      i += 1;
    }
    this.mLastMinute = k;
    this.mLastIndex = ((this.mLastIndex + m) % 15);
    this.mCountEvents[paramInt][this.mLastIndex] = 1L;
  }
  
  public void updateStartTime(AppRuntime paramAppRuntime)
  {
    if ((this.mStartTime == 0L) && (this.mFgProcess != null))
    {
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
      {
        long l = this.mNoLoginedUinStartTime;
        if (l > 0L)
        {
          this.mStartTime = l;
          this.mNoLoginedUinStartTime = 0L;
        }
        else
        {
          this.mStartTime = SystemClock.uptimeMillis();
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("848QQDT [updateStartTime] resetTime: ");
        paramAppRuntime.append(this.mStartTime);
        QLog.d("GuardManager", 1, paramAppRuntime.toString());
        return;
      }
      this.mNoLoginedUinStartTime = SystemClock.uptimeMillis();
    }
  }
  
  public void updateStateOnPreStartEvent(int paramInt)
  {
    int i = this.mStateId;
    if (i != 0) {
      QLog.d("GuardManager", 1, new Object[] { "GuardManager preStartEvent, but GuardStateIs null empty: ", Integer.valueOf(i) });
    }
    i = 6;
    if (paramInt == 2) {
      i = 1;
    }
    nextState(i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardManager
 * JD-Core Version:    0.7.0.1
 */