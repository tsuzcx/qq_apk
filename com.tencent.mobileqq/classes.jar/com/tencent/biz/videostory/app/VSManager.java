package com.tencent.biz.videostory.app;

import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class VSManager
  implements Manager
{
  protected static BaseApplicationImpl a;
  public static boolean b = true;
  private AppInterface c;
  
  public VSManager(AppInterface paramAppInterface)
  {
    this.c = paramAppInterface;
    a();
  }
  
  public void a()
  {
    try
    {
      a = BaseApplicationImpl.getApplication();
      if (b) {
        b = false;
      }
      VSConfigManager.a();
      QLog.i("Q.videostory.VSManager", 1, "init");
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.app.VSManager
 * JD-Core Version:    0.7.0.1
 */