package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.qphone.base.util.QLog;

public class ForgroundOther
  extends GuardState
{
  private String a = null;
  
  protected void a(String paramString)
  {
    this.a = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundOther", 2, new Object[] { "ForgroundOther: onEnter proc: ", paramString });
    }
    this.a = paramString;
    CoreService.startCoreService(GuardConfig.a().a);
    this.e.cancelTimer();
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundOther", 2, new Object[] { "ForgroundOther: onBackground proc: ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.ForgroundOther
 * JD-Core Version:    0.7.0.1
 */