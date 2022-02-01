package com.tencent.ilive.base.component;

import androidx.annotation.Nullable;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorConfig;

public abstract class BaseComponentBuilder
  implements ComponentBuilder
{
  public ServiceAccessorConfig mAccessorConfig;
  
  public ServiceAccessor getLiveAccessor()
  {
    return this.mAccessorConfig.getLiveAccessor();
  }
  
  @Nullable
  public ServiceAccessor getRoomAccessor()
  {
    return this.mAccessorConfig.getRoomAccessor();
  }
  
  public ServiceAccessor getUserAccessor()
  {
    return this.mAccessorConfig.getUserAccessor();
  }
  
  public void setAccessorConfig(ServiceAccessorConfig paramServiceAccessorConfig)
  {
    this.mAccessorConfig = paramServiceAccessorConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.component.BaseComponentBuilder
 * JD-Core Version:    0.7.0.1
 */