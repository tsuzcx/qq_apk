package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.utils.SPSettings;

class ConfigHandler$11
  implements Runnable
{
  ConfigHandler$11(ConfigHandler paramConfigHandler) {}
  
  public void run()
  {
    Object localObject = UpgradeController.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = SPSettings.b();
    int i = SPSettings.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      UpgradeController.a().a((QQAppInterface)localObject, true);
      SPSettings.b(j);
      SPSettings.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */