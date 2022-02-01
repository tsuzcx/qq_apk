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
  public static boolean a = true;
  private AppInterface a;
  
  public VSManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_Boolean = false;
      }
      VSConfigManager.a();
      QLog.i("Q.videostory.VSManager", 1, "init");
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.app.VSManager
 * JD-Core Version:    0.7.0.1
 */