package com.tencent.ilive.config;

import android.app.Activity;
import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.base.component.CustomComponentConfig;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.config.ActivityConfig;
import java.util.HashMap;
import java.util.Map;

public class UIConfig
{
  public static Map<Integer, BizModulesConfig> bizModulesConfigMap = new HashMap();
  public static Map<Integer, CustomComponentConfig> componentConfigMap = new HashMap();
  
  public void addActivityConfig(int paramInt, Class<? extends Activity> paramClass)
  {
    PageFactory.getActivityConfig().add(paramInt, paramClass);
  }
  
  public void addComponentConfig(int paramInt, CustomComponentConfig paramCustomComponentConfig)
  {
    componentConfigMap.put(Integer.valueOf(paramInt), paramCustomComponentConfig);
  }
  
  public void addModulesTempConfig(int paramInt, BizModulesConfig paramBizModulesConfig)
  {
    bizModulesConfigMap.put(Integer.valueOf(paramInt), paramBizModulesConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.config.UIConfig
 * JD-Core Version:    0.7.0.1
 */