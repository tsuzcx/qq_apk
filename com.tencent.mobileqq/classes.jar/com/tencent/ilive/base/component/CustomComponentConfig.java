package com.tencent.ilive.base.component;

import com.tencent.ilive.uicomponent.UIOuter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CustomComponentConfig
{
  private Map<Class<? extends UIOuter>, Class<? extends ComponentBuilder>> uiConfigMap = new HashMap();
  
  public <T extends UIOuter> void add(Class<? extends T> paramClass, Class<? extends ComponentBuilder> paramClass1)
  {
    this.uiConfigMap.put(paramClass, paramClass1);
  }
  
  public void clear()
  {
    this.uiConfigMap.clear();
  }
  
  public Map<Class<? extends UIOuter>, Class<? extends ComponentBuilder>> get()
  {
    return this.uiConfigMap;
  }
  
  public ComponentConfig getComponentConfig()
  {
    localComponentConfig = new ComponentConfig();
    try
    {
      if (this.uiConfigMap.size() > 0)
      {
        Iterator localIterator = this.uiConfigMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Class localClass1 = (Class)localIterator.next();
          Class localClass2 = (Class)this.uiConfigMap.get(localClass1);
          if (localClass2 != null) {
            localComponentConfig.add(localClass1, (ComponentBuilder)localClass2.newInstance());
          }
        }
      }
      return localComponentConfig;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.component.CustomComponentConfig
 * JD-Core Version:    0.7.0.1
 */