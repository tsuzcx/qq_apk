package com.tencent.mobileqq.app;

import ajud;
import akuz;
import akve;
import bbjm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(ajud paramajud) {}
  
  public void run()
  {
    Object localObject = akuz.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bbjm.b();
    int i = bbjm.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      akuz.a().a((QQAppInterface)localObject, true);
      bbjm.b(j);
      bbjm.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */