package com.tencent.ilive.base.component;

import com.tencent.ilive.uicomponent.UIOuter;
import java.util.HashMap;
import java.util.Map;

public class ComponentConfig
{
  private Map<Class<? extends UIOuter>, ComponentBuilder> uiConfigMap = new HashMap();
  
  public <T extends UIOuter> void add(Class<? extends T> paramClass, ComponentBuilder paramComponentBuilder)
  {
    this.uiConfigMap.put(paramClass, paramComponentBuilder);
  }
  
  public void clear()
  {
    this.uiConfigMap.clear();
  }
  
  public Map<Class<? extends UIOuter>, ComponentBuilder> get()
  {
    return this.uiConfigMap;
  }
  
  public void merge(ComponentConfig paramComponentConfig)
  {
    this.uiConfigMap.putAll(paramComponentConfig.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentConfig
 * JD-Core Version:    0.7.0.1
 */