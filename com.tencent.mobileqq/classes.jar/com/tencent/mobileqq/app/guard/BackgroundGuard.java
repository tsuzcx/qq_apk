package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;

public class BackgroundGuard
  extends GuardState
{
  private String a = null;
  
  private void c()
  {
    if ((this.g == GuardManager.sTickQZoneBgKill) || (this.g == GuardManager.sTickQZoneBgKill + 1))
    {
      if (!"com.tencent.mobileqq:qzone".equals(this.a)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:qzone");
      }
      QGuardUtils.a(false);
    }
  }
  
  private void d()
  {
    if ((this.g == GuardManager.sTickToolBgFgKill) || (this.g == GuardManager.sTickToolBgFgKill + 1))
    {
      if (!"com.tencent.mobileqq:tool".equals(this.a)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:tool");
      }
      if (!"com.tencent.mobileqq:plugins".equals(this.a)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:plugins");
      }
    }
  }
  
  protected void a()
  {
    super.a();
    GuardManagerCallbackDispatcher.a(this.g);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard onTick: mClearTick: ", Long.valueOf(this.g), " mGuardTick: ", Long.valueOf(this.f) });
    }
    int i = GuardConfig.a().a(MemoryUtils.a(Process.myPid()));
    int j = GuardConfig.a().a(this.e.mCountEvents, this.e.mLastIndex, this.e.mLastMinute);
    long l = GuardConfig.a().c[(i + j)] / 12000;
    if (this.f >= l) {
      GuardStateScheduler.a().a(4, this.a, 0);
    } else if ((this.g == 3L) || (this.g == 4L)) {
      QGuardUtils.a(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", "com.tencent.mobileqq:plugins", this.a });
    }
    if ((this.g != 50L) && (this.g != 51L))
    {
      c();
      d();
      return;
    }
    QGuardUtils.a(true);
    QGuardUtils.a(false, new String[0]);
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard onForground: process", paramString });
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
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard enter: process: ", paramString });
    }
    this.a = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.f = (GuardConfig.a().a(this.e.mCountEvents, this.e.mLastIndex, this.e.mLastMinute, MemoryUtils.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(GuardConfig.a().a);
    this.e.startTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.BackgroundGuard
 * JD-Core Version:    0.7.0.1
 */