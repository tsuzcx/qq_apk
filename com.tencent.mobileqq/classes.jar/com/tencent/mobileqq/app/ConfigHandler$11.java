package com.tencent.mobileqq.app;

import anvl;
import bhdu;
import bhdz;
import bhrv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(anvl paramanvl) {}
  
  public void run()
  {
    Object localObject = bhdu.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bhrv.b();
    int i = bhrv.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      bhdu.a().a((QQAppInterface)localObject, true);
      bhrv.b(j);
      bhrv.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */