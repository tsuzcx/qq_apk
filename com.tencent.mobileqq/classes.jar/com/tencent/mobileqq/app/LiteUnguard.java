package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LiteUnguard
  extends GuardState
{
  protected void a(String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteUnguard", 2, new Object[] { "onForground process: ", paramString });
    }
    GuardManager localGuardManager = this.a;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (;;)
    {
      localGuardManager.a(i, paramString);
      return;
      i = 3;
    }
  }
  
  protected void b()
  {
    this.a.a(6, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.LiteUnguard", 2, new Object[] { "onForground onEnter: ", paramString });
    }
    super.b(paramString);
    this.a.c();
    this.a.a(0);
    MobileQQ.getMobileQQ().peekAppRuntime().onGuardEvent(4, GuardConfig.a().a, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LiteUnguard
 * JD-Core Version:    0.7.0.1
 */