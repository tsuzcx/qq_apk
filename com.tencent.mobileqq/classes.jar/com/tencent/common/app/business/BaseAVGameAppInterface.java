package com.tencent.common.app.business;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public abstract class BaseAVGameAppInterface
  extends AppInterface
{
  public BaseAVGameAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  @NonNull
  public <T extends IRuntimeService> T getRuntimeService(Class<T> paramClass)
  {
    return getRuntimeService(paramClass, "avgame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.business.BaseAVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */