package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qqperf.monitor.crash.ReportLog;
import mqq.manager.ServerConfigManager.ConfigType;

public class SetLogOn
  extends AsyncStep
{
  protected int doStep()
  {
    String str = this.mAutomator.k.getServerConfigValue(ServerConfigManager.ConfigType.common, "QQIniUrl");
    if ((str != null) && (str.length() > 0)) {
      ReportLog.d = str.trim();
    }
    ReportLog.a(this.mAutomator.k.getApp(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SetLogOn
 * JD-Core Version:    0.7.0.1
 */