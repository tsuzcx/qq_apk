package com.tencent.ilive.config;

import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.base.component.ComponentConfig;

public abstract interface PageConfigInterface
{
  public abstract BizModulesConfig createBizModulesConfig();
  
  public abstract ComponentConfig createComponentConfig(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.config.PageConfigInterface
 * JD-Core Version:    0.7.0.1
 */