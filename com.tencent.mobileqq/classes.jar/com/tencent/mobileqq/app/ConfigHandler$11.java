package com.tencent.mobileqq.app;

import ajgd;
import akgo;
import akgt;
import bahs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(ajgd paramajgd) {}
  
  public void run()
  {
    Object localObject = akgo.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bahs.b();
    int i = bahs.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      akgo.a().a((QQAppInterface)localObject, true);
      bahs.b(j);
      bahs.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */