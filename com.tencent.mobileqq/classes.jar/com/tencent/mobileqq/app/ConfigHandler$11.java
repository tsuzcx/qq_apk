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
    Object localObject = UpgradeController.a().d();
    if (localObject != null)
    {
      if (((UpgradeDetailWrapper)localObject).e == null) {
        return;
      }
      boolean bool = SPSettings.c();
      int i = SPSettings.d();
      int j = ((UpgradeDetailWrapper)localObject).e.d;
      if ((bool) && (j == i)) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i == 0)
      {
        UpgradeController.a().a((QQAppInterface)localObject, true);
        SPSettings.b(j);
        SPSettings.b(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */