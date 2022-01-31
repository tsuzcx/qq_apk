package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class UpgradeTipsDialog$JsCover
  extends JsBridge.JsHandler
{
  protected UpgradeTipsDialog$JsCover(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public int tipsLoadComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "loadTipsComplete");
    }
    UpgradeTipsDialog.a(this.a, true);
    ReportController.b(UpgradeTipsDialog.a(this.a), "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(1), UpgradeController.a(), "");
    if (UpgradeTipsDialog.a(this.a) != null)
    {
      UpgradeTipsDialog.a(this.a).a(this.a);
      return 0;
    }
    try
    {
      this.a.show();
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeTipsDialog.JsCover
 * JD-Core Version:    0.7.0.1
 */