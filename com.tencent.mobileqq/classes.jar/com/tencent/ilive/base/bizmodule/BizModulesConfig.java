package com.tencent.ilive.base.bizmodule;

import java.util.HashMap;
import java.util.Map;

public class BizModulesConfig
{
  private Map<Integer, BizModulesBuilder> bizModulesConfigMap = new HashMap();
  
  public void add(int paramInt, BizModulesBuilder paramBizModulesBuilder)
  {
    this.bizModulesConfigMap.put(Integer.valueOf(paramInt), paramBizModulesBuilder);
  }
  
  public Map<Integer, BizModulesBuilder> get()
  {
    return this.bizModulesConfigMap;
  }
  
  public void merge(BizModulesConfig paramBizModulesConfig)
  {
    this.bizModulesConfigMap.putAll(paramBizModulesConfig.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BizModulesConfig
 * JD-Core Version:    0.7.0.1
 */