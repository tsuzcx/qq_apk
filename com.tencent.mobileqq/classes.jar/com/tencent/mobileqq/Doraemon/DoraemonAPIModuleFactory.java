package com.tencent.mobileqq.Doraemon;

import com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.qphone.base.util.QLog;

public class DoraemonAPIModuleFactory
{
  public static DoraemonAPIModule a(Class paramClass, DoraemonAPIManager paramDoraemonAPIManager)
  {
    if (paramClass == SensorModule.class) {
      paramClass = new SensorModule();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramDoraemonAPIManager);
      }
      return paramClass;
      if (paramClass == UserInfoModule.class) {
        paramClass = new UserInfoModule();
      } else {
        try
        {
          DoraemonAPIModule localDoraemonAPIModule = (DoraemonAPIModule)paramClass.newInstance();
          paramClass = localDoraemonAPIModule;
        }
        catch (Exception localException)
        {
          QLog.e("DoraemonOpenAPI.moduleFactory", 1, "newInstance error module=" + paramClass, localException);
          paramClass = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIModuleFactory
 * JD-Core Version:    0.7.0.1
 */