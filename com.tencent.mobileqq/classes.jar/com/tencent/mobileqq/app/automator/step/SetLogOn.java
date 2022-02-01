package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.log.ReportLog;
import mqq.manager.ServerConfigManager.ConfigType;

public class SetLogOn
  extends AsyncStep
{
  public int a()
  {
    String str = this.a.a.getServerConfigValue(ServerConfigManager.ConfigType.common, "QQIniUrl");
    if ((str != null) && (str.length() > 0)) {
      ReportLog.b = str.trim();
    }
    ReportLog.a(this.a.a.getApp(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SetLogOn
 * JD-Core Version:    0.7.0.1
 */