package com.tencent.ilive.base.component;

import com.tencent.livesdk.servicefactory.ServiceAccessorConfig;

public abstract interface ComponentBuilder
{
  public abstract Object build();
  
  public abstract void setAccessorConfig(ServiceAccessorConfig paramServiceAccessorConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentBuilder
 * JD-Core Version:    0.7.0.1
 */