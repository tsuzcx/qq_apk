package com.tencent.mobileqq.automator.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import mqq.app.MobileQQ;

public class AutomatorApiImpl
  implements IAutomatorApi
{
  public boolean isInRealActionLoginB()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.b();
    }
    return false;
  }
  
  public boolean isLogining()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.a != 0L;
    }
    return true;
  }
  
  public boolean isSyncingMsg()
  {
    if (MobileQQ.sProcessId == 1) {
      return !((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.automator.api.impl.AutomatorApiImpl
 * JD-Core Version:    0.7.0.1
 */