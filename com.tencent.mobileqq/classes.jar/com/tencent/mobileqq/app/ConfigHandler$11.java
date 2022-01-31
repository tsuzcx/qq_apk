package com.tencent.mobileqq.app;

import alqf;
import amqe;
import amqj;
import bdmr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(alqf paramalqf) {}
  
  public void run()
  {
    Object localObject = amqe.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bdmr.b();
    int i = bdmr.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      amqe.a().a((QQAppInterface)localObject, true);
      bdmr.b(j);
      bdmr.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */