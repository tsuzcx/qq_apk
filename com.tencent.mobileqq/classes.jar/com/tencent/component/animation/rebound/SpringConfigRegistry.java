package com.tencent.component.animation.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpringConfigRegistry
{
  private static final SpringConfigRegistry INSTANCE = new SpringConfigRegistry(true);
  private final Map<SpringConfig, String> mSpringConfigMap = new HashMap();
  
  SpringConfigRegistry(boolean paramBoolean)
  {
    if (paramBoolean) {
      addSpringConfig(SpringConfig.defaultConfig, "default config");
    }
  }
  
  public static SpringConfigRegistry getInstance()
  {
    return INSTANCE;
  }
  
  public boolean addSpringConfig(SpringConfig paramSpringConfig, String paramString)
  {
    if (paramSpringConfig != null)
    {
      if (paramString != null)
      {
        if (this.mSpringConfigMap.containsKey(paramSpringConfig)) {
          return false;
        }
        this.mSpringConfigMap.put(paramSpringConfig, paramString);
        return true;
      }
      throw new IllegalArgumentException("configName is required");
    }
    throw new IllegalArgumentException("springConfig is required");
  }
  
  public Map<SpringConfig, String> getAllSpringConfig()
  {
    return Collections.unmodifiableMap(this.mSpringConfigMap);
  }
  
  public void removeAllSpringConfig()
  {
    this.mSpringConfigMap.clear();
  }
  
  public boolean removeSpringConfig(SpringConfig paramSpringConfig)
  {
    if (paramSpringConfig != null) {
      return this.mSpringConfigMap.remove(paramSpringConfig) != null;
    }
    throw new IllegalArgumentException("springConfig is required");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringConfigRegistry
 * JD-Core Version:    0.7.0.1
 */