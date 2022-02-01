package com.tencent.common.app.business;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public abstract class BaseQQAppInterface
  extends AppInterface
{
  public BaseQQAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  @NonNull
  public <T extends IRuntimeService> T getRuntimeService(Class<T> paramClass)
  {
    return getRuntimeService(paramClass, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.business.BaseQQAppInterface
 * JD-Core Version:    0.7.0.1
 */