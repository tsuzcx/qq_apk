package com.tencent.common.app;

import com.tencent.mobileqq.qroute.utils.IProcessCheck;
import com.tencent.mobileqq.qroute.utils.ProcessChecker;

class BaseApplicationImpl$2
  implements IProcessCheck
{
  BaseApplicationImpl$2(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public boolean check(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    return ProcessChecker.check(paramClass, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.2
 * JD-Core Version:    0.7.0.1
 */