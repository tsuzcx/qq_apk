package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LiteGuard
  extends GuardState
{
  protected void a()
  {
    super.a();
    GuardManagerCallbackDispatcher.b(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onTick mClearTime: ", Long.valueOf(this.d), " mGuardTick: ", Long.valueOf(this.c) });
    }
    if (this.c >= GuardConfig.a().a(this.a.jdField_a_of_type_Array2dOfLong, this.a.jdField_a_of_type_Int, this.a.b, MemoryUtils.a(Process.myPid())) / 12000L) {
      this.a.a(7, null);
    }
  }
  
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.a;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onForground proc: ", paramString });
      }
      return;
    }
  }
  
  protected void b()
  {
    if (this.c > 2L) {
      this.c -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onEnter proc: ", paramString });
    }
    CoreService.startCoreService(GuardConfig.a().a);
    this.a.b();
    MobileQQ.getMobileQQ().waitAppRuntime(null).onGuardEvent(3, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LiteGuard
 * JD-Core Version:    0.7.0.1
 */