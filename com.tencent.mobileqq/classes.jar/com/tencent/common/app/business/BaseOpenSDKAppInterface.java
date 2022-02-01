package com.tencent.common.app.business;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public abstract class BaseOpenSDKAppInterface
  extends AppInterface
{
  public BaseOpenSDKAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  @NonNull
  public <T extends IRuntimeService> T getRuntimeService(Class<T> paramClass)
  {
    return getRuntimeService(paramClass, "openSdk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.business.BaseOpenSDKAppInterface
 * JD-Core Version:    0.7.0.1
 */