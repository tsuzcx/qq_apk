package com.tencent.ilive.base.bizmodule;

import android.os.Bundle;
import java.util.Map;

public class BizModulesFactory
{
  protected BizModulesConfig bizModulesConfig = new BizModulesConfig();
  
  public BootBizModules createBootBizModules(int paramInt, Bundle paramBundle)
  {
    BizModulesBuilder localBizModulesBuilder = (BizModulesBuilder)getConfig().get().get(Integer.valueOf(paramInt));
    if (localBizModulesBuilder != null) {
      return localBizModulesBuilder.build(paramBundle);
    }
    return null;
  }
  
  public BizModulesConfig getConfig()
  {
    return this.bizModulesConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BizModulesFactory
 * JD-Core Version:    0.7.0.1
 */