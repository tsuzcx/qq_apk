package com.tencent.ilive.base.component;

import com.tencent.livesdk.servicefactory.ServiceAccessor;

public abstract interface ComponentServiceConfig
{
  public abstract ServiceAccessor getLiveAccessor();
  
  public abstract ServiceAccessor getRoomAccessor();
  
  public abstract ServiceAccessor getUserAccessor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentServiceConfig
 * JD-Core Version:    0.7.0.1
 */