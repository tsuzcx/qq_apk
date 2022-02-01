package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher;
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
    GuardManagerCallbackDispatcher.c(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnguard onTick: mClearTick: ", Long.valueOf(this.d), " mGuardTick: ", Long.valueOf(this.c) });
    }
    if (this.d == GuardManager.c * 50 - 1) {}
    while (((this.d != GuardManager.c * 50) && (this.d != GuardManager.c * 50 + 1)) || (this.a.a != null)) {
      return;
    }
    System.exit(-1);
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnguard onForground: proc: ", paramString });
    }
    this.a.a(3, paramString);
  }
  
  protected void b()
  {
    this.a.a(4, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundUnguard", 2, new Object[] { "BackgroundUnGuard onEnter: proc: ", paramString });
    }
    this.a.a(0);
    if (!"trick_p_msg".equals(paramString)) {
      QGuardUtils.a(false, new String[] { paramString });
    }
    long l = MemoryUtils.a(Process.myPid());
    if (GuardConfig.a().a(l) != 2) {
      this.a.c();
    }
    MobileQQ.getMobileQQ().peekAppRuntime().onGuardEvent(2, GuardConfig.a().a, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BackgroundUnguard
 * JD-Core Version:    0.7.0.1
 */