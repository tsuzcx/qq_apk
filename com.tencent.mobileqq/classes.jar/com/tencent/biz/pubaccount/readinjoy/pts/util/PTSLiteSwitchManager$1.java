package com.tencent.biz.pubaccount.readinjoy.pts.util;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import pwe;
import pwt;
import pwu;
import pxa;

public class PTSLiteSwitchManager$1
  implements Runnable
{
  public PTSLiteSwitchManager$1(pwu parampwu) {}
  
  public void run()
  {
    boolean bool2 = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(289);
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      bool1 = bool2;
      if (localAladdinConfig.getIntegerFromString("pts_lite_switch", 0) == 1) {
        bool1 = true;
      }
    }
    QLog.i("PTSLiteSwitchManager", 1, "[init], ptsLiteSwitchTmp = " + bool1);
    if (bool1)
    {
      pwt.b();
      pwe.a().a("ptslite");
      pxa.a().a();
    }
    pwu.a(this.this$0, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */