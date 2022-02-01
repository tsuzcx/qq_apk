package com.tencent.livesdk.servicefactory;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import java.util.HashMap;
import java.util.Map;

public class ServiceConfig
{
  private Map<Class<? extends ServiceBaseInterface>, BaseServiceBuilder> interfaceToImpl = new HashMap();
  private Map<Class<? extends ServiceBaseInterface>, ServiceEnginScope> newEnginScopeMap = new HashMap();
  
  public <T extends ServiceBaseInterface> void add(Class<? extends T> paramClass, BaseServiceBuilder paramBaseServiceBuilder)
  {
    this.interfaceToImpl.put(paramClass, paramBaseServiceBuilder);
  }
  
  public <T extends ServiceBaseInterface> void add(Class<? extends T> paramClass, BaseServiceBuilder paramBaseServiceBuilder, ServiceEnginScope paramServiceEnginScope)
  {
    this.interfaceToImpl.put(paramClass, paramBaseServiceBuilder);
    this.newEnginScopeMap.put(paramClass, paramServiceEnginScope);
  }
  
  public Map<Class<? extends ServiceBaseInterface>, BaseServiceBuilder> get()
  {
    return this.interfaceToImpl;
  }
  
  public Map<Class<? extends ServiceBaseInterface>, ServiceEnginScope> getEnginScope()
  {
    return this.newEnginScopeMap;
  }
  
  public void merge(ServiceConfig paramServiceConfig)
  {
    this.interfaceToImpl.putAll(paramServiceConfig.get());
    this.newEnginScopeMap.putAll(paramServiceConfig.newEnginScopeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceConfig
 * JD-Core Version:    0.7.0.1
 */