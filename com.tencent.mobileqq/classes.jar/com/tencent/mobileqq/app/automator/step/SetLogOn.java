package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.log.ReportLog;
import mqq.manager.ServerConfigManager.ConfigType;

public class SetLogOn
  extends AsyncStep
{
  protected int a()
  {
    String str = this.a.b.a(ServerConfigManager.ConfigType.common, "QQIniUrl");
    if ((str != null) && (str.length() > 0)) {
      ReportLog.b = str.trim();
    }
    ReportLog.a(this.a.b.getApp(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SetLogOn
 * JD-Core Version:    0.7.0.1
 */