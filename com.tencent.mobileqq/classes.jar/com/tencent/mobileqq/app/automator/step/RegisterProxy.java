package com.tencent.mobileqq.app.automator.step;

import aczy;
import afod;
import afof;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import anyz;
import aoem;
import aoix;
import aoiy;
import aoiz;
import bcrg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;
import pkh;
import pvj;
import pvp;

public class RegisterProxy
  extends AsyncStep
{
  public static int d;
  public long a;
  Handler jdField_a_of_type_AndroidOsHandler;
  anyz jdField_a_of_type_Anyz;
  private aoix jdField_a_of_type_Aoix;
  private boolean jdField_a_of_type_Boolean;
  private long c;
  private long d;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k;
  
  public RegisterProxy()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    Object localObject;
    if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
    {
      MsgAutoMonitorUtil.getInstance().printMsgInfo();
      l2 = l1 + BaseApplicationImpl.sLaunchTime;
      l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 9) {
          break label476;
        }
        localObject = ">9";
        label151:
        localHashMap.put("param_FailCount", localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 0) {
          break label491;
        }
      }
      label476:
      label491:
      for (localObject = "CLIENT_TIMEOUT";; localObject = "")
      {
        localHashMap.put("param_FailCode", localObject);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_a_of_type_Long));
        localHashMap.put("param_threadOpId", String.valueOf(aoem.a().a()));
        localHashMap.put("param_hc_state", String.valueOf(aczy.a().a()));
        localHashMap.put("param_model", Build.MODEL);
        localHashMap.put("param_PluginDelayTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)));
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str1))
          {
            try
            {
              localHashMap.put("param_" + str1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1)));
            }
            catch (Throwable localThrowable) {}
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "add param exception ", localThrowable);
            }
          }
        }
        Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        break;
        localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        break label151;
      }
      localHashMap.put("param_" + this.jdField_a_of_type_JavaLangString, String.valueOf(l1 - this.jdField_c_of_type_Long));
      if (QLog.isColorLevel())
      {
        localObject = localHashMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          QLog.d("QQInitHandler", 2, new Object[] { str2, "=", localHashMap.get(str2) });
        }
      }
      if (jdField_d_of_type_Int == 0)
      {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginB", true, l2, 0L, localHashMap, null);
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.sLaunchTime = 0L;
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l1 -= BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label940;
        }
        localObject = "1";
        label706:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + (String)localObject);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", localObject);
        if (jdField_d_of_type_Int != 0) {
          break label988;
        }
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.appStartTime = 0L;
      jdField_d_of_type_Int = 0;
      return;
      localHashMap.put("param_exceptionReason", String.valueOf(jdField_d_of_type_Int));
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b + ",actBExcetpionReason=" + jdField_d_of_type_Int);
      break;
      label940:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin))
      {
        localObject = "2";
        break label706;
      }
      if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin))
      {
        localObject = "3";
        break label706;
      }
      localObject = "4";
      break label706;
      label988:
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + (String)localObject + ",actBExcetpionReason=" + jdField_d_of_type_Int);
    }
  }
  
  private void a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (!(paramObject instanceof Bundle)) {
          continue;
        }
        n = 1;
        localObject1 = ((Bundle)paramObject).get("ToServiceMsg");
        localObject2 = ((Bundle)paramObject).get("FromServiceMsg");
        paramObject = new HashMap(4);
        bool = localObject1 instanceof ToServiceMsg;
        m = n;
        if (!bool) {}
      }
      catch (Throwable paramObject)
      {
        int n;
        Object localObject1;
        Object localObject2;
        boolean bool;
        int m = 0;
        continue;
        continue;
        m = 0;
        continue;
      }
      try
      {
        a(((ToServiceMsg)localObject1).getAttribute("to_SendTime"), paramObject, "app2msf");
        m = n;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2net"), paramObject, "msf2net");
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_net2msf"), paramObject, "net2msf");
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2app"), paramObject, "msf2app");
          a(((FromServiceMsg)localObject2).getAttribute("msf_receive"), paramObject, "msfReceive");
          if ((m == 0) || (paramObject.isEmpty())) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("netCost", Long.valueOf(1L));
          if (m != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("netCost", Long.valueOf(0L));
          return;
          localNumberFormatException1 = localNumberFormatException1;
          m = 0;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          m = 0;
          continue;
          m = 0;
        }
      }
    }
    if (m != 0)
    {
      bool = localObject2 instanceof FromServiceMsg;
      if (!bool) {}
    }
  }
  
  private void a(Object paramObject, HashMap<String, Long> paramHashMap, String paramString)
  {
    if (paramObject != null)
    {
      long l = Long.parseLong(paramObject.toString());
      paramHashMap.put(paramString, Long.valueOf(l - this.jdField_d_of_type_Long));
      this.jdField_d_of_type_Long = l;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new aoiz(this, ThreadManager.getSubThreadLooper());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
    }
    super.a(4);
  }
  
  private boolean b()
  {
    return (this.f == 2) && (this.g == 2) && (this.h == 2) && (this.i == 2);
  }
  
  public int a()
  {
    boolean bool2 = true;
    this.k = aczy.a().a(0, 1, 1, MainService.sNativeTidOfReceiver, 5000, 201, 131072L, Process.myTid(), "pullMsg");
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    Object localObject;
    int m;
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler();
      if (this.b == 18)
      {
        m = 2;
        ((MessageHandler)localObject).a(m);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      l = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.b != 18) {
        break label286;
      }
      MessageHandler.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().a(2, true, l, false);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("SERP", Long.valueOf(SystemClock.uptimeMillis() - this.jdField_c_of_type_Long));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.b).append(" , isGetPassword = ");
        if (this.b != 17) {
          break label372;
        }
      }
    }
    label286:
    label372:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("RegisterProxy", 2, bool1 + " ,isUseNewRegisterProxy = " + MessageHandler.b);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long));
      return 2;
      m = 1;
      break;
      if (MessageHandler.b)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler();
        if (this.b == 17) {}
        for (bool1 = true;; bool1 = false)
        {
          ((MessageHandler)localObject).a(l, bool1);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler();
      if (this.b == 17) {}
      for (bool1 = true;; bool1 = false)
      {
        ((MessageHandler)localObject).a(1, true, l, bool1);
        break;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())
    {
      if (paramInt != 4) {
        break label26;
      }
      a(true);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      label26:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
    }
  }
  
  public boolean a()
  {
    return ((this.e == 2) || (this.e == 1)) && ((this.f == 2) || (this.f == 1)) && ((this.i == 2) || (this.i == 1)) && ((this.g == 2) || (this.g == 1)) && ((this.h == 2) || (this.h == 1));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anyz == null)
    {
      this.jdField_a_of_type_Anyz = new aoiy(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addDefaultObservers(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_Aoix = new aoix(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Aoix);
    }
    if ((this.b == 17) || (this.b == 19)) {
      MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumBegin(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    MessageHandler.b = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgCache().a(true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anyz != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_Anyz = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aoix);
      this.jdField_a_of_type_Aoix = null;
    }
    if ((this.jdField_a_of_type_Int != 7) || (!b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "RegisterProxy result:" + this.jdField_a_of_type_Int + " ,syncSucc:" + b());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgCache().c(true);
    }
    MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumEnd(Thread.currentThread().getThreadGroup().activeCount());
    a();
    if (this.b == 17)
    {
      afod.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
      afof.a().a(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().a(b());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l);
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label464;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, (String)localObject, b(), l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().b()) {}
    for (int m = 2;; m = 1)
    {
      ((Automator)localObject).jdField_a_of_type_Int = m;
      if (pkh.b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app))
      {
        localObject = (pvp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (localObject != null) {
          ((pvp)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getLongAccountUin());
        }
      }
      MsfServiceSdk.get().registerProxyDone();
      if (this.k != 0)
      {
        aczy.a().a(this.k);
        this.k = 0;
      }
      return;
      label464:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */