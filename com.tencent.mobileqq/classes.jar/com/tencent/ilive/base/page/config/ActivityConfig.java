package com.tencent.ilive.base.page.config;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class ActivityConfig
{
  private Map<Integer, Class<? extends Activity>> activityConfigMap = new HashMap();
  
  public void add(int paramInt, Class<? extends Activity> paramClass)
  {
    this.activityConfigMap.put(Integer.valueOf(paramInt), paramClass);
  }
  
  public void clear()
  {
    if (this.activityConfigMap.size() > 0) {
      this.activityConfigMap.clear();
    }
  }
  
  public boolean contains(int paramInt)
  {
    return this.activityConfigMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public Map<Integer, Class<? extends Activity>> get()
  {
    return this.activityConfigMap;
  }
  
  public void merge(ActivityConfig paramActivityConfig)
  {
    this.activityConfigMap.putAll(paramActivityConfig.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.config.ActivityConfig
 * JD-Core Version:    0.7.0.1
 */