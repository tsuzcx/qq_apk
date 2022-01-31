package com.tencent.mobileqq.app;

import ajuf;
import akva;
import akvf;
import bbiy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(ajuf paramajuf) {}
  
  public void run()
  {
    Object localObject = akva.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bbiy.b();
    int i = bbiy.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      akva.a().a((QQAppInterface)localObject, true);
      bbiy.b(j);
      bbiy.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */