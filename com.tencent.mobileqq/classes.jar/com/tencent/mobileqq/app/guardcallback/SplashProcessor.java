package com.tencent.mobileqq.app.guardcallback;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SplashProcessor
  implements IGuardInterface
{
  private void a(long paramLong)
  {
    if ((paramLong == 1L) && (SetSplash.a()))
    {
      GuardManager localGuardManager = GuardManager.sInstance;
      if (localGuardManager == null) {
        return;
      }
      if (localGuardManager.mFgProcess == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
        }
        ReportController.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
        System.exit(-1);
      }
    }
  }
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground() {}
  
  public void onBackgroundTimeTick(long paramLong)
  {
    a(paramLong);
  }
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.SplashProcessor
 * JD-Core Version:    0.7.0.1
 */