package com.tencent.mobileqq.automator.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import mqq.app.MobileQQ;

public class AutomatorApiImpl
  implements IAutomatorApi
{
  public int getInActionLoginB()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.a();
    }
    return 0;
  }
  
  public String getPREFERENCE_NAME()
  {
    return "acc_info";
  }
  
  public boolean isFirstLaunchNew()
  {
    return AutomatorHelper.a;
  }
  
  public boolean isInRealActionLoginB()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.b();
    }
    return false;
  }
  
  public boolean isLogining()
  {
    int i = MobileQQ.sProcessId;
    boolean bool = true;
    if (i == 1)
    {
      if (((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.a != 0L) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isSyncNormalMsgFinish()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.d();
    }
    return false;
  }
  
  public boolean isSyncingMsg()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.c() ^ true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.automator.api.impl.AutomatorApiImpl
 * JD-Core Version:    0.7.0.1
 */