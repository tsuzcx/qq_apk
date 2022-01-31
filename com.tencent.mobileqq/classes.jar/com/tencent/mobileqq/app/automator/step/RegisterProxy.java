package com.tencent.mobileqq.app.automator.step;

import aabg;
import acsy;
import acta;
import akat;
import akhm;
import akmi;
import akmj;
import akmk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import awzy;
import axrn;
import bbfj;
import bfnl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;
import onh;
import osg;
import osl;

public class RegisterProxy
  extends AsyncStep
{
  public static int d;
  public long a;
  akat jdField_a_of_type_Akat;
  private akmi jdField_a_of_type_Akmi;
  Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private long c;
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
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new akmk(this, ThreadManager.getSubThreadLooper());
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
  
  private void b()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    Object localObject;
    if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
    {
      bfnl.a().k();
      l2 = l1 + BaseApplicationImpl.sLaunchTime;
      l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 9) {
          break label490;
        }
        localObject = ">9";
        label151:
        localHashMap.put("param_FailCount", localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 0) {
          break label505;
        }
      }
      label490:
      label505:
      for (localObject = "CLIENT_TIMEOUT";; localObject = "")
      {
        localHashMap.put("param_FailCode", localObject);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_a_of_type_Long));
        localHashMap.put("param_threadOpId", String.valueOf(akhm.a().a()));
        localHashMap.put("param_cacheConfig", String.valueOf(MsgLruCache.cacheConfig));
        localHashMap.put("param_hc_state", String.valueOf(aabg.a().a()));
        localHashMap.put("param_model", Build.MODEL);
        localHashMap.put("param_PluginDelayTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", 0L)));
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
      if (d == 0)
      {
        axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
        axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginR", true, l3, 0L, localHashMap, null);
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
          break label957;
        }
        localObject = "1";
        label723:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + (String)localObject);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", localObject);
        if (d != 0) {
          break label1005;
        }
        axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.appStartTime = 0L;
      d = 0;
      return;
      localHashMap.put("param_exceptionReason", String.valueOf(d));
      axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b + ",actBExcetpionReason=" + d);
      break;
      label957:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin))
      {
        localObject = "2";
        break label723;
      }
      if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin))
      {
        localObject = "3";
        break label723;
      }
      localObject = "4";
      break label723;
      label1005:
      axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + (String)localObject + ",actBExcetpionReason=" + d);
    }
  }
  
  private boolean b()
  {
    return (this.f == 2) && (this.g == 2) && (this.h == 2) && (this.i == 2);
  }
  
  public int a()
  {
    boolean bool2 = true;
    this.k = aabg.a().a(0, 1, 1, MainService.sNativeTidOfReceiver, 5000, 201, 131072L, Process.myTid(), "pullMsg");
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    Object localObject;
    int m;
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
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
      if (this.b != 18) {
        break label254;
      }
      MessageHandler.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(2, true, l, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.b).append(" , isGetPassword = ");
        if (this.b != 17) {
          break label340;
        }
      }
    }
    label340:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("RegisterProxy", 2, bool1 + " ,isUseNewRegisterProxy = " + MessageHandler.b);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long));
      return 2;
      m = 1;
      break;
      label254:
      if (MessageHandler.b)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
        if (this.b == 17) {}
        for (bool1 = true;; bool1 = false)
        {
          ((MessageHandler)localObject).a(l, bool1);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
      if (this.b == 17) {}
      for (bool1 = true;; bool1 = false)
      {
        ((MessageHandler)localObject).a(1, true, l, bool1);
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akat == null)
    {
      this.jdField_a_of_type_Akat = new akmj(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_Akmi = new akmi(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Akmi);
    }
    if ((this.b == 17) || (this.b == 19)) {
      bfnl.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    MessageHandler.b = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(true);
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
  
  public void d()
  {
    if (this.jdField_a_of_type_Akat != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_Akat = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Akmi);
      this.jdField_a_of_type_Akmi = null;
    }
    if ((this.jdField_a_of_type_Int != 7) || (!b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "RegisterProxy result:" + this.jdField_a_of_type_Int + " ,syncSucc:" + b());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().c(true);
    }
    bfnl.a().b(Thread.currentThread().getThreadGroup().activeCount());
    b();
    if (this.b == 17)
    {
      acsy.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
      acta.a().a(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(b());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l);
      if (bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label464;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
        axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, (String)localObject, b(), l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().b()) {}
    for (int m = 2;; m = 1)
    {
      ((Automator)localObject).jdField_a_of_type_Int = m;
      if (onh.d(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app))
      {
        localObject = (osl)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(163);
        if (localObject != null) {
          ((osl)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getLongAccountUin());
        }
      }
      MsfServiceSdk.get().registerProxyDone();
      if (this.k != 0)
      {
        aabg.a().a(this.k);
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