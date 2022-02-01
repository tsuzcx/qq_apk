package com.tencent.livesdk.servicefactory;

import java.util.Set;

public abstract interface EnginServiceConfig
{
  public abstract BaseEnginLogic getEnginLogic();
  
  public abstract String getOwnerEngine();
  
  public abstract Set<Class> getScopeServices();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.EnginServiceConfig
 * JD-Core Version:    0.7.0.1
 */