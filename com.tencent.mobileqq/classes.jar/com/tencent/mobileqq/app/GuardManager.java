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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.memory.ProcReporter;
import com.tencent.mobileqq.app.memory.ProcReporter.Proc;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.statistics.battery.BatteryStats;
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
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import zaa;
import zab;
import zdd;
import zde;
import zeo;
import zep;
import zeq;
import zga;
import zgb;
import zjm;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static GuardManager a;
  public static AtomicLong a;
  public static AtomicLong b;
  public static int c;
  public static AtomicLong c;
  public static int d;
  public static AtomicLong d;
  public static int e;
  public static AtomicLong e;
  public int a;
  public long a;
  private Application jdField_a_of_type_AndroidAppApplication;
  private volatile BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public volatile String a;
  Random jdField_a_of_type_JavaUtilRandom;
  private zeq jdField_a_of_type_Zeq;
  zeq[] jdField_a_of_type_ArrayOfZeq = new zeq[9];
  public long[][] a;
  public int b;
  long b;
  long c;
  private int f = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_d_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_e_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_c_of_type_Int = 5;
    jdField_d_of_type_Int = 10;
    jdField_e_of_type_Int = 15;
  }
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 }));
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    a(paramInt, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      label115:
      Foreground.setReady();
      return;
    }
    catch (Throwable paramApplication)
    {
      break label115;
    }
  }
  
  public static void b(boolean paramBoolean)
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
        if ((!paramBoolean) && (l1 - jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() < 600000L)) {
          break;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        l2 = jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndSet(0L);
        if ((l2 == 0L) || (localQQAppInterface == null) || (!JobReporter.ramdomReport(100))) {
          break;
        }
        String str1 = Long.toString(jdField_c_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndSet(0L));
        String str2 = Long.toString(jdField_d_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndSet(0L));
        String str3 = Long.toString(jdField_e_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndSet(0L));
        if (l2 > 2147483647L)
        {
          i = 2147483647;
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
          HashMap localHashMap = new HashMap();
          localHashMap.put("countLevel_1", str1);
          localHashMap.put("countLevel_2", str2);
          localHashMap.put("countLevel_3", str3);
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(localQQAppInterface.c(), "maxThreadManagerJobWait", true, i, 1L, localHashMap, "", false);
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
  
  zeq a(int paramInt)
  {
    zeq localzeq = this.jdField_a_of_type_ArrayOfZeq[paramInt];
    Object localObject = localzeq;
    if (localzeq == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new zdd();
      }
    }
    for (;;)
    {
      ((zeq)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((zeq)localObject).jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfZeq[paramInt] = localObject;
      return localObject;
      localObject = new zde();
      continue;
      localObject = new zaa();
      continue;
      localObject = new zab();
      continue;
      localObject = new zgb();
      continue;
      localObject = new zeq();
      continue;
      localObject = new zga();
      continue;
      localObject = new zjm();
    }
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
        QLog.d("GuardManager", 2, "nextState: " + zeq.jdField_a_of_type_ArrayOfJavaLangString[this.f] + ", " + zeq.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject);
      }
      if (this.f == 8) {
        return;
      }
      if (this.f != paramInt)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.f, paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
        this.jdField_a_of_type_Zeq = a(paramInt);
        this.f = paramInt;
      }
      for (;;)
      {
        this.jdField_a_of_type_Zeq.a(5, paramObject);
        return;
        if (paramInt == 0) {
          this.jdField_a_of_type_Zeq = a(paramInt);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getAccount())) && (this.jdField_a_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    paramHashMap.put("config", zeo.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.a("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    long l1;
    int i;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      long l2 = l1 - this.jdField_a_of_type_Long;
      int j = (int)(l2 / 1000L);
      i = j;
      if (l2 % 1000L >= 500L) {
        i = j + 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportForeground(" + paramBoolean + "):[" + this.jdField_a_of_type_Long + " - " + l1 + " = " + i + "]");
      }
      if (i > 0)
      {
        Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
        ReportController.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "CliOper", "", "", "Online_time", "Fe_time", 0, i, 0, (String)localObject, "", "", "");
      }
      if (!paramBoolean) {
        break;
      }
    } while (i <= 0);
    this.jdField_a_of_type_Long = l1;
    return;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    PreloadProcHitMgr.b(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    Intent localIntent = new Intent("com.tencent.process.exit");
    localIntent.putExtra("exit_type", 101);
    localIntent.putExtra("qq_mode_foreground", paramBoolean);
    localIntent.putStringArrayListExtra("procNameList", localArrayList);
    localIntent.putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList, false));
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(BaseApplicationImpl.getContext()) + ", toExitTargetProcess=" + paramString + " isForeground=" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, String... paramVarArgs)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
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
            break label360;
          }
          Object localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          str1 = ((ActivityManager.RunningAppProcessInfo)localObject3).processName;
          int k = ((ActivityManager.RunningAppProcessInfo)localObject3).pid;
          if ((str1.startsWith("com.tencent.mobileqq")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF"))) {
            if (paramVarArgs != null)
            {
              int m = paramVarArgs.length;
              i = 0;
              j = 0;
              if (j < m)
              {
                String str2 = paramVarArgs[j];
                if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                  break;
                }
                i = 1;
                if (i == 0) {
                  break label340;
                }
                localArrayList3.add(str1);
              }
              if (i != 0) {}
            }
            else
            {
              if ((((ActivityManager.RunningAppProcessInfo)localObject3).importance == 100) || ((((ActivityManager.RunningAppProcessInfo)localObject3).importance == 200) && ((((ActivityManager.RunningAppProcessInfo)localObject3).importance != 200) || (((ActivityManager.RunningAppProcessInfo)localObject3).importanceReasonCode == 0)))) {
                break label349;
              }
              localArrayList1.add(str1);
              localObject3 = new ProcReporter.Proc();
              ((ProcReporter.Proc)localObject3).jdField_a_of_type_Int = k;
              ((ProcReporter.Proc)localObject3).jdField_a_of_type_JavaLangString = str1;
              localArrayList4.add(localObject3);
              PreloadProcHitMgr.b(str1);
              if (str1.endsWith(":qzone")) {
                StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
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
        label340:
        j += 1;
        continue;
        label349:
        localArrayList2.add(str1);
      }
      label360:
      ProcReporter.a().a(localArrayList2);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(BaseApplicationImpl.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
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
    long l = MemoryManager.a(Process.myPid());
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
    localHashMap.put("activeLevel", String.valueOf(zeo.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)));
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      a(str, localHashMap);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    zeo localzeo = zeo.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    int i = localzeo.jdField_a_of_type_Int;
    long l = localzeo.jdField_b_of_type_Int | i << 8;
    int j = zeo.a().jdField_c_of_type_Int;
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
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_JavaLangString == null) {
        continue;
      }
      Object localObject1 = (String)paramMessage.obj;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject1)) {
        continue;
      }
      this.jdField_a_of_type_JavaLangString = null;
      if (Foreground.sCountActivity > 0)
      {
        this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq";
        return true;
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        label114:
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        a(false);
        b(4, paramMessage.obj);
        paramMessage = new Intent("com.tencent.plugin.state.change");
        paramMessage.putExtra("key_plugin_state", 0);
        BaseApplicationImpl.getApplication().sendBroadcast(paramMessage);
        paramMessage = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramMessage.isRunning()) {
          paramMessage.a(BaseApplicationImpl.sApplication);
        }
        try
        {
          ProcReporter.a().a();
          return true;
        }
        catch (Throwable paramMessage)
        {
          return true;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = ((String)paramMessage.obj);
        Object localObject2;
        if (localObject1 == null)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a((QQAppInterface)localObject1);
          if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
          {
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = new zep(this);
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
            ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
          }
        }
        try
        {
          this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
          label288:
          localObject2 = new Intent("com.tencent.plugin.state.change");
          ((Intent)localObject2).putExtra("key_plugin_state", 1);
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2);
          if (StartService.a) {
            MemoryManager.a().a(BaseApplicationImpl.sApplication, (QQAppInterface)localObject1);
          }
          b(3, paramMessage.obj);
          return true;
          try
          {
            if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5))) {
              BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(7, 0L, 0L);
            }
            if (((paramMessage.arg1 == 2) || (paramMessage.arg1 == 3)) && (paramMessage.arg2 == 4)) {
              QQAppInterface.a().c();
            }
            if (this.jdField_a_of_type_JavaUtilRandom == null) {
              this.jdField_a_of_type_JavaUtilRandom = new Random();
            }
            if (this.jdField_a_of_type_JavaUtilRandom.nextInt(20000) != 0) {
              continue;
            }
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("before", zeq.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg1]);
            ((HashMap)localObject1).put("after", zeq.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg2]);
            a("GM_guardChangeS", (HashMap)localObject1);
            return true;
          }
          catch (Throwable paramMessage)
          {
            return true;
          }
          int i = paramMessage.arg1;
          if (paramMessage.arg1 < 3) {
            a(i);
          }
          this.jdField_a_of_type_Zeq.a(i, paramMessage.obj);
          return true;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
          this.jdField_a_of_type_Zeq.a();
          return true;
          if (!b()) {
            continue;
          }
          a(this.f + 1, "trick_p_msg");
          return true;
          a(paramMessage.arg1, paramMessage.obj);
          return true;
        }
        catch (Throwable localThrowable2)
        {
          break label288;
        }
      }
      catch (Throwable localThrowable1)
      {
        break label114;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      String str = paramIntent.getStringExtra("runningProcessName");
      long l = paramIntent.getLongExtra("runningtime", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, paramContext + " received with " + str + " at " + l + ", when " + this.jdField_c_of_type_Long + ", " + this.jdField_b_of_type_Long);
      }
      if ("com.tencent.process.stopping".equals(paramContext))
      {
        if ((l >= this.jdField_c_of_type_Long) || (l < this.jdField_c_of_type_Long - 1000000L) || (l < 0L))
        {
          this.jdField_c_of_type_Long = l;
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramContext, 50L);
        }
      }
      else if (("com.tencent.process.starting".equals(paramContext)) && ((l >= this.jdField_b_of_type_Long) || (l < this.jdField_c_of_type_Long - 1000000L) || (l < 0L)))
      {
        this.jdField_b_of_type_Long = l;
        paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.d("GuardManager", 1, "", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */