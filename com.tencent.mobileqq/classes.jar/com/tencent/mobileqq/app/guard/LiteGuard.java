package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
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
    GuardManagerCallbackDispatcher.b(this.g);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onTick mClearTime: ", Long.valueOf(this.g), " mGuardTick: ", Long.valueOf(this.f) });
    }
    if (this.f >= GuardConfig.a().a(this.e.mCountEvents, this.e.mLastIndex, this.e.mLastMinute, MemoryUtils.a(Process.myPid())) / 12000L) {
      GuardStateScheduler.a().a(6, null, 0);
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onForground proc: ", paramString });
    }
  }
  
  protected void b()
  {
    if (this.f > 2L) {
      this.f -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteGuard", 2, new Object[] { "LiteGuard: onEnter proc: ", paramString });
    }
    CoreService.startCoreService(GuardConfig.a().a);
    this.e.startTimer();
    MobileQQ.getMobileQQ().waitAppRuntime(null).onGuardEvent(3, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.LiteGuard
 * JD-Core Version:    0.7.0.1
 */