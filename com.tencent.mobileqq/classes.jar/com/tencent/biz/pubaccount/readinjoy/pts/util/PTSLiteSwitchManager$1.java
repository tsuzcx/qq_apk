package com.tencent.biz.pubaccount.readinjoy.pts.util;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSSoLoader;
import com.tencent.qphone.base.util.QLog;

class PTSLiteSwitchManager$1
  implements Runnable
{
  PTSLiteSwitchManager$1(PTSLiteSwitchManager paramPTSLiteSwitchManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(289);
    boolean bool1;
    if (localAladdinConfig != null) {
      if (localAladdinConfig.getIntegerFromString("pts_lite_switch", 0) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      QLog.i("PTSLiteSwitchManager", 1, "[init], ptsLiteSwitchTmp = " + bool1);
      localAladdinConfig = Aladdin.getConfig(332);
      if (localAladdinConfig != null) {
        if (localAladdinConfig.getIntegerFromString("enabled", 1) != 1) {}
      }
      for (bool2 = true;; bool2 = true)
      {
        QLog.i("PTSLiteSwitchManager", 1, "[init], ptsLiteMasterSwitchTmp = " + bool2);
        if ((bool1) || (bool2))
        {
          PTSHelper.b();
          PTSSoLoader.a().a("ptslite");
          PTSStyleManager.a().a();
        }
        PTSLiteSwitchManager.a(this.this$0, bool1);
        PTSLiteSwitchManager.b(this.this$0, bool2);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */