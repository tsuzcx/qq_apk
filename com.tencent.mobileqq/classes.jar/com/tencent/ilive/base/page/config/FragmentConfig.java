package com.tencent.ilive.base.page.config;

import com.tencent.ilive.base.page.fragment.LiveFragment;
import java.util.HashMap;
import java.util.Map;

public class FragmentConfig
{
  private Map<Integer, Class<? extends LiveFragment>> activityConfigMap = new HashMap();
  
  public void add(int paramInt, Class<? extends LiveFragment> paramClass)
  {
    this.activityConfigMap.put(Integer.valueOf(paramInt), paramClass);
  }
  
  public void clear()
  {
    if (this.activityConfigMap.size() > 0) {
      this.activityConfigMap.clear();
    }
  }
  
  public boolean contains(Integer paramInteger)
  {
    return this.activityConfigMap.containsKey(paramInteger);
  }
  
  public Map<Integer, Class<? extends LiveFragment>> get()
  {
    return this.activityConfigMap;
  }
  
  public void merge(FragmentConfig paramFragmentConfig)
  {
    this.activityConfigMap.putAll(paramFragmentConfig.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.config.FragmentConfig
 * JD-Core Version:    0.7.0.1
 */