package com.tencent.mobileqq.app;

import allq;
import amlp;
import amlu;
import bdii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(allq paramallq) {}
  
  public void run()
  {
    Object localObject = amlp.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bdii.b();
    int i = bdii.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      amlp.a().a((QQAppInterface)localObject, true);
      bdii.b(j);
      bdii.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */