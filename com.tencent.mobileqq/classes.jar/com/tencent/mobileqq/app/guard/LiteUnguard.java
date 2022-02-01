package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LiteUnguard
  extends GuardState
{
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteUnguard", 2, new Object[] { "onForground process: ", paramString });
    }
  }
  
  protected void b()
  {
    GuardStateScheduler.a().a(7, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteUnguard", 2, new Object[] { "onForground onEnter: ", paramString });
    }
    super.b(paramString);
    this.a.c();
    this.a.b(0);
    MobileQQ.getMobileQQ().peekAppRuntime().onGuardEvent(4, GuardConfig.a().a, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.LiteUnguard
 * JD-Core Version:    0.7.0.1
 */