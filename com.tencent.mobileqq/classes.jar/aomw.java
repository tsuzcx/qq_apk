import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class aomw
  extends aocj
{
  private aomw(RegisterProxy paramRegisterProxy) {}
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler1", 2, "stateC2C=" + RegisterProxy.a(this.a) + " stateGroupFirstMsg=" + RegisterProxy.c(this.a));
    }
    long l1;
    long l2;
    Object localObject1;
    if ((RegisterProxy.a(this.a) == 2) && (RegisterProxy.c(this.a) == 2))
    {
      l1 = SystemClock.uptimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().c = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(true);
      if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
      {
        l2 = BaseApplicationImpl.sLaunchTime + l1;
        if (!QLog.isColorLevel()) {
          break label470;
        }
        QLog.i("AutoMonitor", 2, "registerB, cost=" + l2);
        bdmc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "prxyRegisterB", true, l2, 0L, null, null);
      }
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l2 = BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label498;
        }
        localObject1 = "1";
      }
    }
    for (;;)
    {
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("actLoginType", localObject1);
      bdmc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "prxyRegisterT", true, l1 - l2, 0L, (HashMap)localObject2, null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
      {
        l1 = System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
        if (bhnv.g(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()))
        {
          boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true);
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_isFirstInit", String.valueOf(bool));
          bdmc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "prxyRegisterM", RegisterProxy.a(this.a), l1, 0L, (HashMap)localObject1, null);
          if (QLog.isColorLevel()) {
            QLog.i("AutoMonitor", 2, "machineStartToStopCircle, cost=" + l1 + ", isfirstQQInit=" + bool);
          }
        }
      }
      if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null)
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp();
        localObject2 = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
        GuardManager.a((Context)localObject1, GuardManager.jdField_a_of_type_Boolean);
      }
      return;
      label470:
      Log.i("AutoMonitor", "registerB, cost=" + l2);
      break;
      label498:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin)) {
        localObject1 = "2";
      } else if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin)) {
        localObject1 = "3";
      } else {
        localObject1 = "4";
      }
    }
  }
  
  private void o()
  {
    if (this.a.a()) {
      this.a.a(7);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetPAMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.e((RegisterProxy)localObject, i);
      if (!MessageHandler.jdField_a_of_type_Boolean) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c = true;
      o();
      return;
    }
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (RegisterProxy.b(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).c = paramBoolean;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPA", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy;
    if (paramLong2 == 0L)
    {
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label248;
      }
      i = 2;
      RegisterProxy.d(localRegisterProxy, i);
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
        break label254;
      }
      i = 2;
      label174:
      RegisterProxy.c(localRegisterProxy, i);
      this.a.jdField_a_of_type_Long = paramLong1;
      if (MessageHandler.jdField_a_of_type_Boolean)
      {
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label260;
        }
        i = 2;
        label209:
        RegisterProxy.b(localRegisterProxy, i);
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label266;
        }
      }
    }
    label260:
    label266:
    for (int i = j;; i = 1)
    {
      RegisterProxy.e(localRegisterProxy, i);
      MessageHandler.jdField_a_of_type_Boolean = false;
      o();
      return;
      label248:
      i = 1;
      break;
      label254:
      i = 1;
      break label174;
      i = 1;
      break label209;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetTroopMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPT", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
    paramArrayOfString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.d(paramArrayOfString, i);
      o();
      return;
      i = 1;
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.a(localRegisterProxy, i);
      if (!paramBoolean) {
        break;
      }
      o();
      RegisterProxy.a(this.a, paramObject);
      return;
      i = 1;
    }
    this.a.a(6);
  }
  
  protected void f(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetC2CMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPC", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markC2CFinishCost();
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.b((RegisterProxy)localObject, i);
      if (!MessageHandler.jdField_a_of_type_Boolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetDiscussionMsg Fin: Receive empty package set isC2CMsgSuccess true");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b = true;
      if (MessageHandler.b) {
        n();
      }
      o();
      return;
    }
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (RegisterProxy.a(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).b = paramBoolean;
      break;
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetDiscussionMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPD", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markDisFinishCost();
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.c(localRegisterProxy, i);
      o();
      return;
      i = 1;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetFirstGroup Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPF", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.f(localRegisterProxy, i);
      n();
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomw
 * JD-Core Version:    0.7.0.1
 */