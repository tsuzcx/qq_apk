package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.qphone.base.util.QLog;

public class PrestartGuard
  extends GuardState
{
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.PrestartGuard", 2, new Object[] { "PrestartGuard ontick: clearTime: ", Long.valueOf(this.d), " guardTime: ", Long.valueOf(this.c) });
    }
    if (this.d >= GuardConfig.a().a / 12000L)
    {
      CoreService.stopTempService();
      this.a.c();
      this.d = 0L;
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.PrestartGuard", 2, new Object[] { "PrestartGuard: onForground proc: ", paramString });
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.PrestartGuard", 2, new Object[] { "PrestartGuard: onEnter proc", paramString });
    }
    this.a.b();
    CoreService.startTempService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.PrestartGuard
 * JD-Core Version:    0.7.0.1
 */