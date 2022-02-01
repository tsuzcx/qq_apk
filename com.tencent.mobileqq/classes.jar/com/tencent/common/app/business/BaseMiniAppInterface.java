package com.tencent.common.app.business;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public abstract class BaseMiniAppInterface
  extends AppInterface
{
  public BaseMiniAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  @NonNull
  public <T extends IRuntimeService> T getRuntimeService(Class<T> paramClass)
  {
    return getRuntimeService(paramClass, "multi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.business.BaseMiniAppInterface
 * JD-Core Version:    0.7.0.1
 */