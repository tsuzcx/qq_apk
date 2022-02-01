package com.tencent.mobileqq.Doraemon;

import com.tencent.qphone.base.util.QLog;

public class DoraemonAPIModuleFactory
{
  public static DoraemonAPIModule a(Class<? extends DoraemonAPIModule> paramClass, DoraemonAPIManager paramDoraemonAPIManager)
  {
    try
    {
      DoraemonAPIModule localDoraemonAPIModule = (DoraemonAPIModule)paramClass.newInstance();
      paramClass = localDoraemonAPIModule;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("newInstance error module=");
      localStringBuilder.append(paramClass);
      QLog.e("DoraemonOpenAPI.moduleFactory", 1, localStringBuilder.toString(), localException);
      paramClass = null;
    }
    if (paramClass != null) {
      paramClass.a(paramDoraemonAPIManager);
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIModuleFactory
 * JD-Core Version:    0.7.0.1
 */