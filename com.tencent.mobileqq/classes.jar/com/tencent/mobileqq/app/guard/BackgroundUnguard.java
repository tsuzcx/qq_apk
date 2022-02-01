package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BackgroundUnguard
  extends GuardState
{
  protected void a()
  {
    super.a();
    GuardManagerCallbackDispatcher.c(this.g);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnguard onTick: mClearTick: ", Long.valueOf(this.g), " mGuardTick: ", Long.valueOf(this.f) });
    }
    if (this.g == GuardManager.SUICIDE_FACTOR * 50 - 1) {
      return;
    }
    if (((this.g == GuardManager.SUICIDE_FACTOR * 50) || (this.g == GuardManager.SUICIDE_FACTOR * 50 + 1)) && (this.e.mFgProcess == null)) {
      System.exit(-1);
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnguard onForground: proc: ", paramString });
    }
  }
  
  protected void b()
  {
    GuardStateScheduler.a().a(5, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnGuard onEnter: proc: ", paramString });
    }
    this.e.updateActiveStatistic(0);
    if (!"trick_p_msg".equals(paramString)) {
      QGuardUtils.a(false, new String[] { paramString });
    }
    long l = MemoryUtils.a(Process.myPid());
    if (GuardConfig.a().a(l) != 2) {
      this.e.cancelTimer();
    }
    MobileQQ.getMobileQQ().peekAppRuntime().onGuardEvent(2, GuardConfig.a().g, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.BackgroundUnguard
 * JD-Core Version:    0.7.0.1
 */