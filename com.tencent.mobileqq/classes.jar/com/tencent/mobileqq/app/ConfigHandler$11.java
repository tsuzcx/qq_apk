package com.tencent.mobileqq.app;

import ansg;
import bgvx;
import bgwc;
import bhhj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(ansg paramansg) {}
  
  public void run()
  {
    Object localObject = bgvx.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = bhhj.b();
    int i = bhhj.b();
    int j = ((UpgradeDetailWrapper)localObject).a.a;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      bgvx.a().a((QQAppInterface)localObject, true);
      bhhj.b(j);
      bhhj.b(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */